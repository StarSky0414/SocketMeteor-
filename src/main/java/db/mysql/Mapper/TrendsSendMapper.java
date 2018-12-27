package db.mysql.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TrendsSendMapper {

    @Insert("insert into trends (send_user_id, content,photo_url) values  (#{sendUserId},#{content},#{photoUrl})")
    void insertTrends(@Param("sendUserId") String sendUserid, @Param("content") String content, @Param("photoUrl") String photoUrl);
}
