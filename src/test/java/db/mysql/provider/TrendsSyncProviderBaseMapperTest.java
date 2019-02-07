package db.mysql.provider;

import db.mysql.MysqlBase;
import db.mysql.entity.TrendsEntity;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

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

    @Test
    public void testFlushTrends(){
        Log logger = LogFactory.getLog(this.getClass().toString());
        MysqlBase.init();
        TrendsSyncProviderBaseMapper trendsSyncProviderBaseMapper = new TrendsSyncProviderBaseMapper();
        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.flushTrends();
        for (TrendsEntity trendsEntity: trendsEntities){
//            System.out.println(trendsEntity.toString());
            logger.debug(trendsEntity.toString());
        }
    }

    @Test
    public void testShowMoreTrends(){
        Log logger = LogFactory.getLog(this.getClass().toString());
        MysqlBase.init();
        TrendsSyncProviderBaseMapper trendsSyncProviderBaseMapper = new TrendsSyncProviderBaseMapper();
        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.showMoreTrends("");
        for (TrendsEntity trendsEntity: trendsEntities){
            logger.debug(trendsEntity.toString());
        }
    }
}