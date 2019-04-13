package db.mysql.provider;

import bean.json.request.SendMessageBean;

public class MessageSendProviderMapper extends MysqlProviderBase {

    public int insertMessage(SendMessageBean sendMessageBean){
//        MessageSendMapper messageSendMapper = mysqlBaseSession.getMapper(MessageSendMapper.class);
//        messageSendMapper.insertMessage(sendUserId,receiveUserid,messageContent,"Text",null);
//        mysqlBaseSession.commit();
//        mysqlBaseSession.close();
        int insert = mysqlBaseSession.insert("message.message_insert",sendMessageBean);
        mysqlBaseSession.commit();
        return insert;

    }
}
