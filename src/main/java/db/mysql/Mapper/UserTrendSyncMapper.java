package db.mysql.Mapper;


import db.mysql.entity.TrendsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserTrendSyncMapper {

    @Select("select * from trends where id < #{id}  and send_user_id=#{userId} order by id desc limit 0,3")
    List<TrendsEntity> queryTrends(@Param("id") String id,@Param("userId") int userid);

}
