package db.redis;

import bean.user.UserInfo;
import db.mysql.provider.DBProviderTestBase;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OnLineListTest extends DBProviderTestBase {

    @Test
    void getUserInfoList() {
        List<UserInfo> userInfoList = OnLineList.getUserInfoList();
        for (UserInfo userInfo: userInfoList){
            System.out.println(userInfo.toString());
        }
    }

    @Override
    protected void init() {
        for (int i =1 ;i<=5;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String value = String.valueOf(i);
            UserInfo userInfo = new UserInfo(i, value, value, i, value, value);
            OnLineList.setUserInfoSet(userInfo);
        }
    }

    @Test
    public void testDate(){
        Date date = new Date();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date1 = new Date();
        System.out.println(date);
        System.out.println(date1);
        System.out.println(date.compareTo(date));
    }
}