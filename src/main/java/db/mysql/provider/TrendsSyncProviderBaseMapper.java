package db.mysql.provider;

import db.mysql.Mapper.TrendsSyncMapper;
import db.mysql.entity.TrendsEntity;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.util.List;

public class TrendsSyncProviderBaseMapper extends MysqlProviderBase {

    private static Log logger = LogFactory.getLog(TrendsSyncProviderBaseMapper.class);

//    public List<TrendsEntity> syncTrendsContent(String id){
//        TrendsSyncMapper trendsSyncMapper = mysqlBaseSession.getMapper(TrendsSyncMapper.class);
//        List<TrendsEntity> trendsEntities = trendsSyncMapper.queryTrends(id);
//        mysqlBaseSession.commit();
//        mysqlBaseSession.close();
//        return trendsEntities;
//    }

    /**
     *  更新所有动态消息
     *  对应手机动态下拉刷新
     * @return 动态列表 长度5
     */
    public List<TrendsEntity> flushTrends(){
        List<TrendsEntity> trendsEnterList = mysqlBaseSession.selectList("trends.showTrends");
        return  trendsEnterList;
    }


    /**
     *  更新后边动态消息
     *  对应手机动态上拉刷新
     * @return 动态列表  【长度5】
     */
    public  List<TrendsEntity> showMoreTrends(String appTrendsMessage){
        List<TrendsEntity> trendsEnterList = mysqlBaseSession.selectList("trends.showTrends", appTrendsMessage);
        return trendsEnterList;
    }

    /**
     *  获取用户所有动态
     * @param userId  用户id
     * @return  动态列表  【无长度限制】
     */
    public List<TrendsEntity> showUserAllTrends(String userId){
        List<TrendsEntity> trendsEntityList = mysqlBaseSession.selectList("trends.showTheUserTrends", userId);
        return trendsEntityList;
    }

}
