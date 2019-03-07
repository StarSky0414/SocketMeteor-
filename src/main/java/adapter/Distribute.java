package adapter;

import bean.AdapterRequestBean;
import bean.AdapterResponseBean;
import bean.SendTrendsBean;
import controller.AdapterI;
import controller.SendTrendsController;
import safeproving.Safe;
import utiles.Conversion;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Distribute {
    private static MappingLoading mappingLoading = new MappingLoading();

    /**
     * 分发，根据分发路径，创建实体对象
     * @param adapterRequestBean 分发路径，并非class路径
     * @return 回应的json数据
     */
    public AdapterResponseBean toDistribute(AdapterRequestBean adapterRequestBean) {
        String[] path = adapterRequestBean.getPathString().split(":");
        String aClassName = path[0];
        String modeName = path[1];
        String jsonString = adapterRequestBean.getJsonString();
        AdapterResponseBean adapterResponseBean = null;
        try {
            Class<?> cls = Class.forName(mappingLoading.getMyClass(aClassName));
            Constructor<?> cons = cls.getConstructor();
            AdapterI adapterI = (AdapterI) cons.newInstance();
            adapterI.setAdapterResponseBean(jsonString);
            callMethodAnnotate(adapterI,modeName);
            adapterResponseBean = adapterI.getAdapterResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("echoJsonString: " + adapterResponseBean.getJsonString());
        return adapterResponseBean;
    }

    /**
     *  根据 注解获取要映射的method
     * @param adapterI 被映射的实体类
     * @param methodName 注解methodName="XXXXXX"
     */
    public void callMethodAnnotate(AdapterI adapterI , String methodName){
        Method[] declaredMethods = adapterI.getClass().getDeclaredMethods();
        for (Method method : declaredMethods){
            MethodName methodAnnotation = method.getAnnotation(MethodName.class);
//            System.out.println("callMethodAnnotate:"+methodAnnotation);
            if (methodAnnotation != null && methodAnnotation.methodName().equals(methodName)){
                System.out.println(methodAnnotation.toString());
                try {
                    method.invoke(adapterI);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }


    /**
     * 解析数据包
     * 封装格式 预留位置【20】 分发位置长度【4】  分发位置【20】 数据包长度【4】 json【数据包实际数值】
     *
     * @param inputStream 客户端输入流
     * @throws IOException
     */
    public AdapterRequestBean resolvePackage(InputStream inputStream) throws IOException {
//        byte[] obligateBytes = new byte[20];
        byte[] packLengthByte = new byte[4];
        byte[] pathLengthByte = new byte[4];
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        //跳过预留数据包
//        dataInputStream.skipBytes(obligateBytes.length);

        //读取path长度
        dataInputStream.read(pathLengthByte, 0, pathLengthByte.length);
        System.out.println(new String(pathLengthByte));
        int pathLength = Conversion.byteArrayToInt(pathLengthByte);
        System.out.println(pathLength);
        byte[] pathBytes = new byte[pathLength];
        //读取分发位置
        dataInputStream.read(pathBytes, 0, pathLength);
        System.out.println(new String(pathBytes));
        //读取json长度
        dataInputStream.read(packLengthByte, 0, packLengthByte.length);
        int i = Conversion.byteArrayToInt(packLengthByte);
        byte[] messageBodyByte = new byte[i];
        //读取数据json
        int read = dataInputStream.read(messageBodyByte, 0, i);

        String jsonString = new String(messageBodyByte, "utf-8");
        String pathString = new String(pathBytes);
        String messageBodyString = new String(messageBodyByte);
        AdapterRequestBean adapterRequestBean = new AdapterRequestBean(pathString, messageBodyString);
        System.out.println(i);
        System.out.println(read);
        System.out.println(jsonString);
        return adapterRequestBean;
    }

    /**
     * 将json 进行数据封装
     * 封装格式 预留位置【20】 分发位置长度【4】  分发位置【20】 数据包长度【4】 json【数据包实际数值】
     *
     * @param adapterResponseBean 服务器返回json
     * @param outputStream        client输出流
     * @throws IOException
     */
    public void toEncapsulation(OutputStream outputStream, AdapterResponseBean adapterResponseBean) throws IOException {

        System.out.println("adapterResponseBean : "+adapterResponseBean.toString());
        String jsonString = adapterResponseBean.getJsonString();
//        String pathString = adapterResponseBean.getPath();
//        byte[] obligateBytes = new byte[20];
        int packLength = jsonString.getBytes("utf-8").length;
//        int pathLength = pathString.length();

        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


//        Integer integer = new Integer(13);
//        byte[] packLengthByte = Conversion.intToByteArray(packLength);
        byte[] packLengthByte = String.format("%08d", packLength).getBytes();
//        byte[] bytes ={0,0,0,0};

//
//        for (int i=packLengthByte.length-1;i>=0;i--){
//            System.out.println("+++++++++++++++++++++++"+i);
//                bytes[i] = packLengthByte[i];
//        }
//        byte[] pathLengthByte = Conversion.intToByteArray(pathLength);
        System.out.println("packLength: " + packLength);
        System.out.println("packLengthByte: " + new String(packLengthByte));
        System.out.println("packLengthInt: " + Integer.valueOf(new String(packLengthByte)));
        dataOutputStream.write(packLengthByte);
        dataOutputStream.write(jsonString.getBytes());
//        dataOutputStream.write(packLengthByte);
//        dataOutputStream.write(jsonString.getBytes());
        dataOutputStream.flush();
    }


}
