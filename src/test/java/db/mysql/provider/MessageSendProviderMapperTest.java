package db.mysql.provider;

import db.mysql.MysqlBase;
import org.junit.jupiter.api.Test;

class MessageSendProviderMapperTest {


    @Test
    void testInsertTextMessage() {
        MysqlBase.init();
        MessageSendProviderMapper messageSendProviderMapper = new MessageSendProviderMapper();
        messageSendProviderMapper.insertTextMessage("123","321","DBINsert");
    }
}