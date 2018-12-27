package db.mysql.provider;

import db.mysql.Mapper.MessageSendMapper;

public class MessageSendProviderMapper extends MysqlProviderBase {

    public void insertTextMessage(String sendUserId,String receiveUserid,String messageContent){
        MessageSendMapper messageSendMapper = mysqlBaseSession.getMapper(MessageSendMapper.class);
        messageSendMapper.insertMessage(sendUserId,receiveUserid,messageContent,"Text",null);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
    }
}
