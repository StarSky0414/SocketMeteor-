package adapter.udp;

import bean.AdapterResponseBean;
import bean.SyncMessageRequestBean;
import bean.udp.SyncMessageUdp;
import com.alibaba.fastjson.JSONObject;
import controller.SyncMessage;
import db.redis.*;
import db.redis.annotate.MyJedisAnalyze;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.HashMap;

public class UdpListener implements Runnable {

    private static int port = 8091;

    public static int num = 1;
    private static DatagramSocket socket;

    {
        try {
            socket = new DatagramSocket(port, InetAddress.getLocalHost());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    ;

    /**
     * 监听UDP
     */
    synchronized private void monitorUDP() throws SocketException {

        //准备空的数据包用于存放数据。
        byte[] buf = new byte[10240];
        while (true) {
            System.out.println("num================" + num++);
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length); // 1024

            //调用udp的服务接收数据
            try {
                socket.receive(datagramPacket); //receive是一个阻塞型的方法，没有接收到数据包之前会一直等待。 数据实际上就是存储到了byte的自己数组中了。
//                byte[] address = datagramPacket.getAddress().getAddress();
                InetAddress address1 = datagramPacket.getAddress();
                System.out.println(address1);
                int port = datagramPacket.getPort();
                System.out.println(port);
                String s = new String(buf, 0, datagramPacket.getLength());
                System.out.println("=================" + s);
                SyncMessageRequestBean syncMessageRequestBean = JSONObject.parseObject(s, SyncMessageRequestBean.class);
//                SyncMessageUdp syncMessageUdp = new SyncMessageUdp("644761e05ed1465dbfce9a3d2a8b7fc3", "");
//                RedisBase redisBase = new RedisBase();
//                String userId = redisBase.queryRedisString(FunctionEnum.USERSESSION, syncMessageUdp.getTocken());
//                if (userId == null || userId.equals("")) {
//                    return;
//                }
                String userId = syncMessageRequestBean.getUserId();
                uodateHostAndPort(address1, port, userId);
//                SyncMessageResponse syncMessageResponse = new SyncMessageResponse();
//                boolean b = hasNewMessageCheck(Integer.valueOf(syncMessageUdp.getLocationMessageNum()), userId);
//                syncMessageResponse.setHasNewMessage(b);
                DatagramPacket datagramPacket1 = responseUDP(address1, port,syncMessageRequestBean);
                // 通过套接字发送数据
                socket.send(datagramPacket1);
//            socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {

        try {
            monitorUDP();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private void uodateHostAndPort(InetAddress inetAddress, int prot, String userId) {
        MyJedisAnalyze myJedisAnalyze = new MyJedisAnalyze();
        HashMap<UserInfoEnum, String> userInfoEnumStringHashMap = new HashMap<>();
        userInfoEnumStringHashMap.put(UserInfoEnum.USER_ADDRESS, inetAddress.toString().replace("/", ""));
        userInfoEnumStringHashMap.put(UserInfoEnum.USER_ADDRESS_PORT, String.valueOf(prot));
        myJedisAnalyze.jedisList(FunctionEnum.USERINFO, userId, RedisDataBasicOperation.UPDATE, userInfoEnumStringHashMap);
    }

    /**
     * 将数据返回给客户端
     *
     * @param inetAddress         客户端IP地址
     * @param port                客户端端口
     * @param syncMessageResponse 要返回的Bean
     * @return UDP发送的数据包
     */
    private DatagramPacket responseUDP(InetAddress inetAddress, int port, SyncMessageRequestBean syncMessageResponse) {
        // 确定要反馈发送方的消息内容，并转换为字节数组
        String s = JSONObject.toJSONString(syncMessageResponse);

        SyncMessage syncMessage = new SyncMessage();
        syncMessage.setJson(s);
        syncMessage.getMessage();
        AdapterResponseBean adapterResponse = syncMessage.getAdapterResponse();

        String jsonString = JSONObject.toJSONString(adapterResponse);
        System.out.println(s);
        byte[] backBuf = jsonString.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(backBuf, backBuf.length, inetAddress, port);
        return sendPacket;
    }

    /**
     * 判断是否有新消息
     *
     * @param localNum 客户端本地版本号
     * @param userId   用户id
     * @return 【正确】 有新消息  【错误】 没有新消息
     */
    private boolean hasNewMessageCheck(int localNum, String userId) {
        RedisBase redisBase = new RedisBase();
        String s = redisBase.queryRedisList(FunctionEnum.USERINFO, userId, UserInfoEnum.MESSAGEED_ID);
        if (s != null && !s.equals("")) {
            Integer integer = Integer.valueOf(s);
            if (localNum < integer) {
                return true;
            }
        }
        return false;
    }
}
