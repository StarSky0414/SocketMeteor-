package bean.user;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.util.Date;

public class UserInfo {

    // 用户id
    private int userId;
    // 用户昵称
    private String userNickName;
    // 用户位置
    private String city;
    // 用户年龄
    private int userAge;
    // 用户爱好
    private String hobby;
    // 用户一句话
    private String oneShort;

    private long date =  System.currentTimeMillis();

    public UserInfo() {
    }

    public UserInfo(int userId, String userNickName, String city, int userAge, String hobby, String oneShort) {
        this.userId = userId;
        this.userNickName = userNickName;
        this.city = city;
        this.userAge = userAge;
        this.hobby = hobby;
        this.oneShort = oneShort;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getOneShort() {
        return oneShort;
    }

    public void setOneShort(String oneShort) {
        this.oneShort = oneShort;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userNickName='" + userNickName + '\'' +
                ", city='" + city + '\'' +
                ", userAge=" + userAge +
                ", hobby='" + hobby + '\'' +
                ", oneShort='" + oneShort + '\'' +
                ", date=" + date +
                '}';
    }
}
