package db.mysql.provider;

import db.mysql.MysqlBase;
import db.mysql.entity.TrendsEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrendsSendProviderMapperTest {

    @Test
    void testSendTrendsContent() {
        MysqlBase.init();
        TrendsEntity trendsEntity = new TrendsEntity("1", "测试内容", "url://xxxxx.xxxx.xxxx");
        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
        trendsSendProviderMapper.sendTrendsContent(trendsEntity);
    }
}