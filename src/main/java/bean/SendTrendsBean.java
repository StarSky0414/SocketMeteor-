package bean;

public class SendTrendsBean {

    // 发送用户id
    private String sendUserId;
    // 动态内容
    private String content;
    // 动态图片网址
    private String photoUrl;

    public SendTrendsBean(String sendUserId, String content, String photoUrl) {
        this.sendUserId = sendUserId;
        this.content = content;
        this.photoUrl = photoUrl;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "SendTrendsBean{" +
                "sendUserId='" + sendUserId + '\'' +
                ", content='" + content + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }
}
