package db.mysql.entity;


/**
 * 动态实体类
 */
public class TrendsEntity {

    // 发送用户id
    private String sendUserId;
    // 用户头像
    private String headPhotoUrl;
    //用户昵称
    private String userNickName;
    // 动态图片
    private String trendPhotoUrl;
    // 动态id
    private String trendId;
    // 动态内容
    private String trendContent;
    // 动态创建时间
    private String trendCreateTime;
    // 喜欢数量
    private String likeNumber;

    /**
     * 客户端提交使用
     *
     * @param sendUserId    发送者id
     * @param trendPhotoUrl 动态图片
     * @param trendContent  动态内容
     */
    public TrendsEntity(String sendUserId, String trendPhotoUrl, String trendContent) {
        this.sendUserId = sendUserId;
        this.trendPhotoUrl = trendPhotoUrl;
        this.trendContent = trendContent;
    }

    /**
     * 服务端更新使用
     *
     * @param sendUserId    发送用户id
     * @param trendPhotoUrl 动态图片网址
     * @param trendId       动态id
     * @param trendContent  动态内容
     */
    public TrendsEntity(String sendUserId, String trendPhotoUrl, String trendId, String trendContent) {
        this.sendUserId = sendUserId;
        this.trendPhotoUrl = trendPhotoUrl;
        this.trendId = trendId;
        this.trendContent = trendContent;
    }

    /**
     * 服务端返回使用
     *
     * @param sendUserId      发送者id
     * @param headPhotoUrl    发送者头像图片
     * @param userNickName    发送者昵称
     * @param trendPhotoUrl   动态图片网址
     * @param trendId         动态图片id
     * @param trendContent    动态图片内容
     * @param trendCreateTime 动态图片创建时间
     * @param likeNumber      喜欢数量
     */
    public TrendsEntity(String sendUserId, String headPhotoUrl, String userNickName, String trendPhotoUrl, String trendId, String trendContent, String trendCreateTime, String likeNumber) {
        this.sendUserId = sendUserId;
        this.headPhotoUrl = headPhotoUrl;
        this.userNickName = userNickName;
        this.trendPhotoUrl = trendPhotoUrl;
        this.trendId = trendId;
        this.trendContent = trendContent;
        this.trendCreateTime = trendCreateTime;
        this.likeNumber = likeNumber;
    }

    /**
     * 空构造器
     */
    public TrendsEntity() {
    }

    //==============================
    // get,set 方法
    //==============================


    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getTrendPhotoUrl() {
        return trendPhotoUrl;
    }

    public void setTrendPhotoUrl(String trendPhotoUrl) {
        this.trendPhotoUrl = trendPhotoUrl;
    }

    public String getTrendId() {
        return trendId;
    }

    public void setTrendId(String trendId) {
        this.trendId = trendId;
    }

    public String getTrendContent() {
        return trendContent;
    }

    public void setTrendContent(String trendContent) {
        this.trendContent = trendContent;
    }

    public String getTrendCreateTime() {
        return trendCreateTime;
    }

    public void setTrendCreateTime(String trendCreateTime) {
        this.trendCreateTime = trendCreateTime;
    }

    public String getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(String likeNumber) {
        this.likeNumber = likeNumber;
    }
}

