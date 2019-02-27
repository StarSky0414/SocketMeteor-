package db.mysql.provider;

import db.mysql.entity.TrendsEntity;

public class TrendsSendProviderMapper extends MysqlProviderBase{

//    public void sendTrendsContent(TrendsEntity trendsEntity){
//        TrendsSendMapper trendsSendMapper = mysqlBaseSession.getMapper(TrendsSendMapper.class);
//        String sendUserId = trendsEntity.getSendUserId();
//        String content = trendsEntity.getContent();
//        String url = trendsEntity.getUrl();
//        trendsSendMapper.insertTrends(sendUserId,content,url);
//        mysqlBaseSession.commit();
//        mysqlBaseSession.close();
//    }

    public int sendTrendsContent(TrendsEntity trendsEntity) {
        int insert = mysqlBaseSession.insert("trends.insertTrends",trendsEntity);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
        return insert;
    }

    public int updateTrendsContent(TrendsEntity trendsEntity){
        int update = mysqlBaseSession.update("trends.updateTrends",trendsEntity);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
        return update;
    }

    public int deleteTrendsContent(String id){
        System.out.println("id : "+id);
        int update = mysqlBaseSession.update("trends.deleteTrends",id);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
        return update;
    }

}
