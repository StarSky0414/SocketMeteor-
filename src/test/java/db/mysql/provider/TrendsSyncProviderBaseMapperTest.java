package db.mysql.provider;

import db.mysql.MysqlBase;
import db.mysql.entity.TrendsEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrendsSyncProviderBaseMapperTest {

    @Test
    void testSyncTrendsContent() {
        MysqlBase.init();
        TrendsSyncProviderBaseMapper trendsSyncProviderBaseMapper = new TrendsSyncProviderBaseMapper();
        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.syncTrendsContent("4");
        for (TrendsEntity trendsEntity : trendsEntities){
            System.out.println(trendsEntity.toString());
        }
    }
}