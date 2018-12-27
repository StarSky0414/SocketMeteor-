package db.mysql.provider;

import db.mysql.Mapper.TrendsSyncMapper;
import db.mysql.entity.TrendsEntity;

import java.util.List;

public class TrendsSyncProviderBaseMapper extends MysqlProviderBase {

    public List<TrendsEntity> syncTrendsContent(String id){
        TrendsSyncMapper trendsSyncMapper = mysqlBaseSession.getMapper(TrendsSyncMapper.class);
        List<TrendsEntity> trendsEntities = trendsSyncMapper.queryTrends(id);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
        return trendsEntities;
    }

}
