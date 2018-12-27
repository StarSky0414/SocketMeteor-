package db.mysql.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MessageSendMapper {


    @Insert("insert user_chat_message (send_user_id, receive_user_id, message_content, type, voiceTime)  values  (#{sendUserId},#{receiveUserid},#{messageContent},#{type},#{voiceTime})")
    void insertMessage(@Param("sendUserId")String sendUserId,@Param("receiveUserid")String receiveUserid,@Param("messageContent")String messageContent,@Param("type")String type,@Param("voiceTime")String voiceTime);
}
