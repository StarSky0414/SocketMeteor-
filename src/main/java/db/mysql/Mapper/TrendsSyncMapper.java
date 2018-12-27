package db.mysql.Mapper;

import db.mysql.entity.TrendsEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TrendsSyncMapper {

    @Select("select * from trends where id < #{id} order by id desc limit 0,3")
    List<TrendsEntity> queryTrends(@Param("id") String id);

}
