package db.mysql.provider;

import db.mysql.entity.UserInfoEntity;

/**
 *  用户个人信息
 */
public class UserInfoSyncProvider extends MysqlProviderBase{

    public UserInfoEntity getUserInfo(String id){
        UserInfoEntity userInfoEntity= mysqlBaseSession.selectOne("userInfo.userInfoQuery", id);
        return userInfoEntity;
    }

}
