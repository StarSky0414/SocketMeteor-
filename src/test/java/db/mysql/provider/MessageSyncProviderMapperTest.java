package db.mysql.provider;

import db.mysql.MysqlBase;
import db.mysql.entity.UserChatMessageEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageSyncProviderMapperTest {

    @Test
    void queryTextMessage() {
        MysqlBase.init();
        MessageSyncProviderMapper messageSyncProviderMapper = new MessageSyncProviderMapper();
        List<UserChatMessageEntity> userChatMessageEntities = messageSyncProviderMapper.queryTextMessage("1", "1", "0");
        for (UserChatMessageEntity userChatMessageEntity : userChatMessageEntities){
            System.out.println(userChatMessageEntity.toString());
        }
    }
}