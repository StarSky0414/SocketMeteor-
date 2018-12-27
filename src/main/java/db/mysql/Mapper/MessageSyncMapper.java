package db.mysql.Mapper;

import db.mysql.entity.UserChatMessageEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageSyncMapper {

    @Select("select * from user_chat_message where (receive_user_id=#{receiveUserId} or send_user_id=#{sendUserId} ) and id >#{id} order by time")
    List<UserChatMessageEntity> queryMessage(@Param("receiveUserId")String receiveUserId, @Param("sendUserId")String sendUserId, @Param("id")String id);
}
