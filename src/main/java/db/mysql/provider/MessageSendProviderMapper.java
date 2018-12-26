package db.mysql.provider;

import db.mysql.MessageSendMapper;
import db.mysql.MysqlBase;
import org.apache.ibatis.session.SqlSession;

public class MessageSendProviderMapper {

    private final SqlSession mysqlBaseSession;

    public MessageSendProviderMapper(){
        MysqlBase mysqlBase = MysqlBase.getMysqlBase();
        mysqlBaseSession = mysqlBase.getSession();
    }

    public void insertTextMessage(String sendUserId,String receiveUserid,String messageContent){
        MessageSendMapper messageSendMapper = mysqlBaseSession.getMapper(MessageSendMapper.class);
        messageSendMapper.insertMessage(sendUserId,receiveUserid,messageContent,"Text",null);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
    }
}
