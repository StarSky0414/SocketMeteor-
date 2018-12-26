package adapter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  连接监听
 */
public class ConnectListener {

    // tcp 有服务器区分
    private static ServerSocket serverSocket;
    // 监听端口 8080
    private static final int PORT = 8090;

    public ConnectListener() throws IOException {
        serverSocket = new ServerSocket(PORT);
    }

    public void listen() {
        ConnectPool connectPool = new ConnectPool();
        int i = 0;
        while (true)
            try {
                Socket client = serverSocket.accept();
                ConnectManager connectManager = new ConnectManager(i++, client);
                connectPool.execute(connectManager);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

}
