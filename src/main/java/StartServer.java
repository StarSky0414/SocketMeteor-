import adapter.ConnectListener;
import adapter.ConnectPool;
import adapter.MessageInit;
import adapter.udp.UdpListener;
import db.mysql.MysqlBase;
import db.mysql.entity.MessageEntity;
import db.mysql.entity.RedisMessageEntity;
import org.apache.ibatis.session.SqlSession;

import java.io.*;
import java.net.Socket;


public class StartServer {


    public static void main(String[] args) throws IOException, InterruptedException {
        MysqlBase.init();
        MessageInit.messageInit();
        System.out.println("消息数初始化结束    ======"+MessageInit.getMessageNum());

        new Thread(new UdpListener()).start();
        //初始化线程池

        try {
            ConnectPool.init();
            ConnectListener connectListener = new ConnectListener();
            connectListener.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}

