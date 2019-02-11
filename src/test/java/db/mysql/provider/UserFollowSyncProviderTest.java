package db.mysql.provider;

import db.mysql.entity.UserFollowEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserFollowSyncProviderTest extends DBProviderTestBase {

    private UserFollowSyncProvider userFollowSyncProvider;
    private int userId = 1;

    @Test
    void queryState() {
        UserFollowEntity userFollowEntity = new UserFollowEntity();
        userFollowEntity.setStartUserId("1");
        userFollowEntity.setGoalUserId("2");
        userFollowEntity = userFollowSyncProvider.queryState(userFollowEntity);
        logger.debug(userFollowEntity.toString());
    }

    @Test
    void queryStateList() {
        List<UserFollowEntity> userFollowEntityList = userFollowSyncProvider.queryStateList(userId);
        for (UserFollowEntity userFollowEntity :
                userFollowEntityList) {
            logger.debug(userFollowEntity.toString());
        }
    }

    @Override
    void init() {
        userFollowSyncProvider = new UserFollowSyncProvider();
    }
}