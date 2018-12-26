package connect;

import adapter.Distribute;
import bean.AdapterRequestBean;
import org.junit.Before;
import org.junit.Test;
import utiles.Conversion;

import java.io.*;
import java.net.Socket;

 public class MessageTest {


    private Distribute distribute;
    @Before
    public void init(){
        this.distribute=new Distribute();
    }

    @Test
    public void messageSend() throws IOException {
          int aaa;
        Socket socket = new Socket("127.0.0.1", 8090);
        OutputStream outputStream = socket.getOutputStream();
        String jsonString = "你好啊";
        String pathString = "testpath";

//        byte[] obligateBytes = new byte[20];
        byte[] pathStringBytes = pathString.getBytes();
        byte[] jsonStringBytes = jsonString.getBytes("utf-8");

        int packLength =pathStringBytes.length;
        int pathLength =jsonStringBytes.length;

        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        byte[] packLengthByte = Conversion.intToByteArray(packLength);
        byte[] pathLengthByte = Conversion.intToByteArray(pathLength);
        dataOutputStream.write("f2634392b55544208704edd0cd1cd6a5".getBytes());
//        dataOutputStream.write(obligateBytes);
        dataOutputStream.write(pathLengthByte);
        dataOutputStream.write(pathStringBytes);
        dataOutputStream.write(packLengthByte);
        dataOutputStream.write(jsonStringBytes);
        dataOutputStream.flush();

        InputStream inputStream = socket.getInputStream();
        inputStream.skip(32);
        AdapterRequestBean adapterRequestBean = distribute.resolvePackage(inputStream);
//        System.out.println(adapterRequestBean.getJsonString());
//        System.out.println(adapterRequestBean.getPathString());
//        DataInputStream dataInputStream = new DataInputStream(inputStream);
//        String s = dataInputStream.readUTF();
//        System.out.println(dataInputStream.readLine());
//        System.out.println(s);

        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }

}
