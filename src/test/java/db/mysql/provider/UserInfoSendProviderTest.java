package db.mysql.provider;

import db.mysql.entity.UserInfoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoSendProviderTest extends DBProviderTestBase {

    private UserInfoSendProvider userInfoSendProvider;
    private UserInfoEntity userInfoEntity;
    private static String userId;

    @Override
    protected void init() {
        userInfoSendProvider = new UserInfoSendProvider();
        userInfoEntity = new UserInfoEntity();
    }

    @Test
    void testUserInfoInit() {
        userInfoEntity.setUserPhone("bbbbbbb");
        userInfoEntity.setPassWord("ccccccc");
        int i = userInfoSendProvider.userInfoInit(userInfoEntity);
        String id = userInfoEntity.getId();
        System.out.println("id: "+id);
        userId=id;
        logger.debug(String.valueOf(i));
    }

    @Test
    void testUserInfoOther(){
        userInfoEntity.setId(userId);
        userInfoEntity.setPhotoUser("url://xxxx.xxxx");
        int i = userInfoSendProvider.userInfoOther(userInfoEntity);
        logger.debug(String.valueOf(i));
    }



}