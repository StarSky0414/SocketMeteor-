package db.mysql.provider;

import db.mysql.Mapper.MessageSyncMapper;
import db.mysql.entity.MessageEntity;
import db.mysql.entity.RedisMessageEntity;
import db.mysql.entity.UserChatMessageEntity;

import java.util.List;

public class MessageSyncProviderMapper extends MysqlProviderBase{

//    public List<UserChatMessageEntity> queryTextMessage(String sendUserId, String receiveUserid, String id){
//        MessageSyncMapper messageSyncMapper = mysqlBaseSession.getMapper(MessageSyncMapper.class);
//        List<UserChatMessageEntity> userChatMessageEntity = messageSyncMapper.queryMessage(receiveUserid, sendUserId, id);
//        mysqlBaseSession.commit();
//        mysqlBaseSession.close();
//        return userChatMessageEntity;
//    }

    public List<MessageEntity> queryMessage(RedisMessageEntity redisMessageEntity){
        List<MessageEntity> messageEntityList = mysqlBaseSession.selectList("message.message_select", redisMessageEntity);
        return messageEntityList;
    }
}
