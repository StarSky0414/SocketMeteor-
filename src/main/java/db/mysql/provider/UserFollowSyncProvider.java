package db.mysql.provider;

import db.mysql.entity.UserFollowEntity;

import java.util.List;

public class UserFollowSyncProvider extends MysqlProviderBase {

    /**
     *  查询单个用户之间关系
     * @param userFollowEntity 用户id
     * @return 关系状况实体
     */
    public UserFollowEntity queryState(UserFollowEntity userFollowEntity){
        userFollowEntity = mysqlBaseSession.selectOne("userFollow.queryUserFollow",userFollowEntity);
        return userFollowEntity;
    }

    /**
     *  查询用户状态列表信息
     * @param userId 用户id
     * @return 关系状态列表
     */
    public List<UserFollowEntity> queryStateList(int userId){
        List<UserFollowEntity> userFollowEntityList = mysqlBaseSession.selectList("userFollow.queryUserFollowList",userId);
        return userFollowEntityList;
    }
}
