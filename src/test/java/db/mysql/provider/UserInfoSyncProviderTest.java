package db.mysql.provider;

import db.mysql.entity.UserInfoEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoSyncProviderTest extends DBProviderTestBase {

    private UserInfoSyncProvider userInfoSyncProvider;

    @Test
    void testGetUserInfo() {
        UserInfoEntity userInfo = userInfoSyncProvider.getUserInfo("1");
        logger.debug(userInfo.toString());
    }

    @Override
    void init() {
        userInfoSyncProvider = new UserInfoSyncProvider();
    }
}