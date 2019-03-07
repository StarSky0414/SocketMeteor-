package db.mysql.entity;


/**
 *  redis 查询实体
 */
public class RedisMessageEntity {

    // 用户id
    private String userId;

    // 当前用户本地消息版本号
    private String messageId;

    public RedisMessageEntity(String userId, String messageId) {
        this.userId = userId;
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
