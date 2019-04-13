package db.mysql.provider;

import db.mysql.entity.UserFollowEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFollowSendProviderTest extends DBProviderTestBase {

    private UserFollowSendProvider userFollowSendProvider;
    private UserFollowEntity userFollowEntity;

    @Test
    void createUserFollow() {
        userFollowEntity.setStartUserId("2");
        userFollowEntity.setGoalUserId("10");
        int userFollow = userFollowSendProvider.createUserFollow(userFollowEntity);
        logger.debug("userFollow : "+ userFollow);
    }

    @Test
    void updateState() {
        userFollowEntity.setStartUserId("2");
        userFollowEntity.setGoalUserId("10");
        userFollowEntity.setState(1);
        int userFollow = userFollowSendProvider.updateState(userFollowEntity);
        logger.debug("userFollow : "+ userFollow);
    }

    @Test
    void deleteUserFollow() {
        userFollowEntity.setStartUserId("2");
        userFollowEntity.setGoalUserId("10");
        int userFollow = userFollowSendProvider.deleteUserFollow(userFollowEntity);
        logger.debug("userFollow : "+ userFollow);
    }

    @Override
    protected void init() {
        userFollowSendProvider = new UserFollowSendProvider();
        userFollowEntity = new UserFollowEntity();
    }
}