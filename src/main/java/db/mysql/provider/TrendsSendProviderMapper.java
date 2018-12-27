package db.mysql.provider;

import db.mysql.Mapper.TrendsSendMapper;
import db.mysql.entity.TrendsEntity;

public class TrendsSendProviderMapper extends MysqlProviderBase{

    void sendTrendsContent(TrendsEntity trendsEntity){
        TrendsSendMapper trendsSendMapper = mysqlBaseSession.getMapper(TrendsSendMapper.class);
        String sendUserId = trendsEntity.getSendUserId();
        String content = trendsEntity.getContent();
        String url = trendsEntity.getUrl();
        trendsSendMapper.insertTrends(sendUserId,content,url);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
    }

}
