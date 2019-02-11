package db.mysql.provider;

import db.mysql.entity.UserFollowEntity;

/**
 *  用户关系操作
 */
public class UserFollowSendProvider extends MysqlProviderBase {

    private final static String namespa = "userFollow.";

    public int createUserFollow(UserFollowEntity userFollowEntity){
        int insert = mysqlBaseSession.insert(namespa+"createUserFollow", userFollowEntity);
        commit();
        return insert;
    }

    public int updateState(UserFollowEntity userFollowEntity){
        int update = mysqlBaseSession.update(namespa+"updateUserFollowState",userFollowEntity);
        commit();
        return update;
    }

    public int deleteUserFollow(UserFollowEntity userFollowEntity){
        int update = mysqlBaseSession.update(namespa+"deleteUserFollow",userFollowEntity);
        commit();
        return update;
    }

}
