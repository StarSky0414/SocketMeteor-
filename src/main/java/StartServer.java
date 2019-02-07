import adapter.ConnectListener;
import adapter.ConnectPool;
import db.mysql.MysqlBase;

import java.io.*;
import java.net.Socket;


public class StartServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        MysqlBase.init();
        //初始化线程池

//        new Thread(new Runnable() {
//            public void run() {
        try {
                    ConnectPool.init();
                    ConnectListener connectListener = new ConnectListener();
                    connectListener.listen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
//            }
//        }).start();
//
//        for (int i=0 ;i<15;i++) {
//            Socket socket = new Socket("127.0.0.1", 8088);
//            InputStream inputStream = socket.getInputStream();
//            String result = new BufferedReader(new InputStreamReader(inputStream)).readLine();
//            System.out.println(result);
//            socket.shutdownInput();S
//            socket.close();
//            System.out.println(socket.isClosed());
////            Thread.sleep(1000);
//        }

    }
}
