//package bean.json.response;
//
//
///**
// *  动态和用户主页 bean
// *  返回json使用
// */
//public class TrendsAndHmoeResponseBean {
//
//    //==============================
//    // 动态及用户主页
//    //==============================
//
//    // 动态id
//    private int id ;
//    // 发送用户id
//    private String sendUserId;
//    // 用户头像
//    private String headPhotoUrl;
//    //用户昵称
//    private String userNickName;
//    // 动态图片
//    private String trendPhotoUrl;
//    // 动态id
//    private String trendId;
//
//    //==============================
//    // 动态 独有字段
//    //==============================
//
//    // 动态内容
//    private String trendContent;
//    // 动态创建时间
//    private String trendCreateTime;
//    // 喜欢数量
//    private String likeNumber;
//
//    //==============================
//    //  构造方法
//    //==============================
//
//    public TrendsAndHmoeResponseBean(){
//
//    }
//
//    public TrendsAndHmoeResponseBean(int id, String sendUserId, String headPhotoUrl, String userNickName, String trendPhotoUrl, String trendId) {
//        this.id = id;
//        this.sendUserId = sendUserId;
//        this.headPhotoUrl = headPhotoUrl;
//        this.userNickName = userNickName;
//        this.trendPhotoUrl = trendPhotoUrl;
//        this.trendId = trendId;
//    }
//
//    public TrendsAndHmoeResponseBean(int id, String sendUserId, String headPhotoUrl, String userNickName, String trendPhotoUrl, String trendId, String trendContent, String trendCreateTime, String likeNumber) {
//        this.id = id;
//        this.sendUserId = sendUserId;
//        this.headPhotoUrl = headPhotoUrl;
//        this.userNickName = userNickName;
//        this.trendPhotoUrl = trendPhotoUrl;
//        this.trendId = trendId;
//        this.trendContent = trendContent;
//        this.trendCreateTime = trendCreateTime;
//        this.likeNumber = likeNumber;
//    }
//
//    //==============================
//    // get , set 方法
//    //==============================
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getSendUserId() {
//        return sendUserId;
//    }
//
//    public void setSendUserId(String sendUserId) {
//        this.sendUserId = sendUserId;
//    }
//
//    public String getHeadPhotoUrl() {
//        return headPhotoUrl;
//    }
//
//    public void setHeadPhotoUrl(String headPhotoUrl) {
//        this.headPhotoUrl = headPhotoUrl;
//    }
//
//    public String getUserNickName() {
//        return userNickName;
//    }
//
//    public void setUserNickName(String userNickName) {
//        this.userNickName = userNickName;
//    }
//
//    public String getTrendPhotoUrl() {
//        return trendPhotoUrl;
//    }
//
//    public void setTrendPhotoUrl(String trendPhotoUrl) {
//        this.trendPhotoUrl = trendPhotoUrl;
//    }
//
//    public String getTrendId() {
//        return trendId;
//    }
//
//    public void setTrendId(String trendId) {
//        this.trendId = trendId;
//    }
//
//    public String getTrendContent() {
//        return trendContent;
//    }
//
//    public void setTrendContent(String trendContent) {
//        this.trendContent = trendContent;
//    }
//
//    public String getTrendCreateTime() {
//        return trendCreateTime;
//    }
//
//    public void setTrendCreateTime(String trendCreateTime) {
//        this.trendCreateTime = trendCreateTime;
//    }
//
//    public String getLikeNumber() {
//        return likeNumber;
//    }
//
//    public void setLikeNumber(String likeNumber) {
//        this.likeNumber = likeNumber;
//    }
//}
