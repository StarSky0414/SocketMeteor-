package safeproving;


import db.redis.FunctionEnum;
import db.redis.RedisBase;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class Safe {
    private static int sessionLen = makeSession().length();
    private RedisBase redisBase = new RedisBase();
    private String clientSession;

    /**
     *  校验 session 读取输入流
     *  格式 session【34】 + 包
     * @param inputStream  client输入流
     * @return  userId 用户id
     * @throws IOException 流解析错误，直接返回client
     */
    public String checkSession(InputStream inputStream) throws IOException {
        byte[] sessionByteArray = new byte[32];
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        dataInputStream.read(sessionByteArray);
        clientSession = new String(sessionByteArray);
        System.out.println("clientSession : "+clientSession);
        String id = redisBase.queryRedisString(FunctionEnum.USERSESSION, clientSession);
        return id;
    }

    /**
     * 创建 session 生成唯一值
     * 也可采用 多池 捞取拼接策略，减小服务器创建session 的压力
     * @return session 唯一值
     */
    public static String makeSession() {
        String id = UUID.randomUUID().toString();//生成的id942cd30b-16c8-449e-8dc5-028f38495bb5中间含有横杠，<span style="color: rgb(75, 75, 75); font-family: Verdana, Arial, Helvetica, sans-serif; line-height: 20.7999992370605px;">用来生成数据库的主键id是很实用的。</span>
        id = id.replace("-", "");//替换掉中间的那个斜杠
        return id;
    }

    /**
     * 插入session
     * 格式 session【34】 + 包
     * 用户 session =》 userid
     * @param outputStream 输出流 返回给client
     * @param userId       用户id
     */
    public void insertSession(OutputStream outputStream, String userId) {
        String session = makeSession();
        System.out.println("session: "+session);
        try {
            outputStream.write(session.getBytes());
            if (userId != null) {
                redisBase.updateRedisString(FunctionEnum.USERSESSION, session, userId);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void deleSession(){
        redisBase.deleRedisString(FunctionEnum.USERSESSION, clientSession);
    }

}
