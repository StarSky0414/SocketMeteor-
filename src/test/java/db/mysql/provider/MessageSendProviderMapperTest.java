package db.mysql.provider;

import db.mysql.MessageSendMapper;
import db.mysql.MysqlBase;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageSendProviderMapperTest {


    @Test
    void testInsertTextMessage() {
        MysqlBase.init();
        MessageSendProviderMapper messageSendProviderMapper = new MessageSendProviderMapper();
        messageSendProviderMapper.insertTextMessage("","","DBINsert");
    }
}