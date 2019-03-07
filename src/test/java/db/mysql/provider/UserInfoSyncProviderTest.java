package db.mysql.provider;

import db.mysql.entity.UserInfoEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoSyncProviderTest extends DBProviderTestBase {

    private UserInfoSyncProvider userInfoSyncProvider;

    @Test
    void testGetUserInfo() {
        UserInfoEntity userInfo = userInfoSyncProvider.getUserInfo("1");
        logger.debug(userInfo.toString());
    }

    @Test
    void testGetMessageUserInfo(){
        List<UserInfoEntity> messageUserInfo = userInfoSyncProvider.getMessageUserInfo(1,5);
        for ( UserInfoEntity userInfoEntity : messageUserInfo){
            System.out.println("messageUserInfo:"+userInfoEntity.toString());
        }

    }

    @Override
    void init() {
        userInfoSyncProvider = new UserInfoSyncProvider();
    }
}