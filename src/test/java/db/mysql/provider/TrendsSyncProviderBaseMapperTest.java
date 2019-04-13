package db.mysql.provider;

import db.mysql.MysqlBase;
import db.mysql.entity.TrendsEntity;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TrendsSyncProviderBaseMapperTest extends DBProviderTestBase {


    private TrendsSyncProviderBaseMapper trendsSyncProviderBaseMapper;
//
//    @Test
//    void testSyncTrendsContent() {
//
//        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.syncTrendsContent("4");
//        for (TrendsEntity trendsEntity : trendsEntities){
//            System.out.println(trendsEntity.toString());
//        }
//    }

    @Test
    public void testFlushTrends(){

        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.flushTrends();
        for (TrendsEntity trendsEntity: trendsEntities){
//            System.out.println(trendsEntity.toString());
            logger.debug(trendsEntity.toString());
        }
    }

    @Test
    public void testShowMoreTrends(){
        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.showMoreTrends("");
        for (TrendsEntity trendsEntity: trendsEntities){
            logger.debug(trendsEntity.toString());
        }
    }

    @Test
    public void testShowUserAllTrends(){
        List<TrendsEntity> trendsEntities = trendsSyncProviderBaseMapper.showUserAllTrends("2");
        if (trendsEntities == null || trendsEntities.size() == 0){
            logger.error("List<TrendsEntity> is empty");
        }else {
            for (TrendsEntity trendsEntity : trendsEntities){
                logger.debug(trendsEntity.toString());
            }
        }
    }

    @Override
    protected void init() {
        trendsSyncProviderBaseMapper = new TrendsSyncProviderBaseMapper();
    }
}