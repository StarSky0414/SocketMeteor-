package db.mysql.provider;

import db.mysql.MysqlBase;
import db.mysql.entity.MessageEntity;
import db.mysql.entity.RedisMessageEntity;
import db.mysql.entity.UserChatMessageEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageSyncProviderMapperTest  extends DBProviderTestBase{

    private MessageSyncProviderMapper messageSyncProviderMapper;

//    @Test
//    void queryTextMessage() {
//        MysqlBase.init();
//        MessageSyncProviderMapper messageSyncProviderMapper = new MessageSyncProviderMapper();
//        List<UserChatMessageEntity> userChatMessageEntities = messageSyncProviderMapper.queryTextMessage("1", "1", "0");
//        for (UserChatMessageEntity userChatMessageEntity : userChatMessageEntities){
//            System.out.println(userChatMessageEntity.toString());
//        }
//    }

    @Test
    void queryMessage(){
        RedisMessageEntity redisMessageEntity = new RedisMessageEntity("1", "0");
        List<MessageEntity> messageEntities = messageSyncProviderMapper.queryMessage(redisMessageEntity);
        for (MessageEntity messageEntity: messageEntities) {
            System.out.println(messageEntity.toString());
        }
    }

    @Override
    protected void init() {
        messageSyncProviderMapper = new MessageSyncProviderMapper();
    }
}