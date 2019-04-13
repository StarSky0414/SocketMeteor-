package adapter;

import bean.AdapterRequestBean;
import bean.AdapterResponseBean;
import safeproving.Safe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectManager implements Runnable {


    private int taskNum;
    private Socket client;
    private Distribute distribute;
    private final Safe safe;

    public ConnectManager(int i, Socket client) {
        this.taskNum = i;
        this.client = client;
        distribute = new Distribute();
        safe = new Safe();
    }

    public void run() {
        System.out.println("正在执行task " + taskNum);
        try {
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            String userId = safe.checkSession(inputStream);
            System.out.println("===========userId: " + userId);
            AdapterResponseBean adapterResponseBean = null;
            if (userId == null || userId.equals("")) {
                adapterResponseBean = new AdapterResponseBean("safe", "[]");
            } else {
                AdapterRequestBean adapterRequestBean = distribute.resolvePackage(inputStream);
                adapterResponseBean = distribute.toDistribute(adapterRequestBean, userId);
            }

            safe.insertSession(outputStream, userId);
            //==============================
            // 测试使用！！！！！！！！！
            //==============================
//            safe.insertSession(outputStream,"1");
            distribute.toEncapsulation(outputStream, adapterResponseBean);
            safe.deleSession();

            closeClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + "执行完毕");
    }

//    public void setClient(Socket client) {
//        this.client=client;
//    }

    private void closeClient() {
        try {
            client.close();
        } catch (IOException e) {
            System.out.println("关闭异常");
        }
    }
}
