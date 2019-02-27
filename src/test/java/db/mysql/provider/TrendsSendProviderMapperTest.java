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

    @Test
    void testupdateTrendsContent(){
        MysqlBase.init();
        TrendsEntity trendsEntity = new TrendsEntity("4", "测试内容4", "url://xxxxx.xxxx.xxxx");
        trendsEntity.setId(3);
        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
        trendsSendProviderMapper.updateTrendsContent(trendsEntity);
    }

    @Test
    void testDeleteTrendsContent(){
        MysqlBase.init();
        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
        trendsSendProviderMapper.deleteTrendsContent("4");
    }

}