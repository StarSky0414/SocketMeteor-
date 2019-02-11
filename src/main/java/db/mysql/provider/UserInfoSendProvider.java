package db.mysql.provider;


import db.mysql.entity.UserInfoEntity;

/**
 *  用户信息更新
 */
public class UserInfoSendProvider extends MysqlProviderBase{

    public int userInfoInit(UserInfoEntity userInfoEntity){
        int insert = mysqlBaseSession.insert("userInfo.userInfoInit", userInfoEntity);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
        return insert;
    }

    public int userInfoOther(UserInfoEntity userInfoEntity){
        int update = mysqlBaseSession.update("userInfo.userInfoOther", userInfoEntity);
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
        return update;
    }
}
