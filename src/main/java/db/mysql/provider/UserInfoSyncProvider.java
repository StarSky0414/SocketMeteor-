package db.mysql.provider;

import db.mysql.entity.OtherUserInfoQuery;
import db.mysql.entity.UserInfoEntity;
import java.util.HashMap;
import java.util.List;

/**
 * 用户个人信息
 */
public class UserInfoSyncProvider extends MysqlProviderBase {

    public UserInfoEntity getUserInfo(String id) {
        UserInfoEntity userInfoEntity = mysqlBaseSession.selectOne("user_info.user_info_select", id);
        return userInfoEntity;
    }

    /**
     * 获取消息用户信息
     *
     * @param userId   客户端 用户id
     * @param clientId 客户端 本地消息版本号
     * @return
     */
    public List<UserInfoEntity> getMessageUserInfo(int userId, int clientId) {
        HashMap<String, Object> messagePram = new HashMap<>();
        messagePram.put("userId", userId);
        messagePram.put("clientLastId", clientId);
        List<UserInfoEntity> userInfoEntities = mysqlBaseSession.selectList("user_info.message_user_info", messagePram);
        return userInfoEntities;
    }

    public OtherUserInfoQuery queryUserInfo(String queryUserId){
        List<String> userTrendsPhoto = queryUserTrendsPhoto(queryUserId);
        List<OtherUserInfoQuery> queryUserTrendsPhoto = mysqlBaseSession.selectList("user_info.queryUserOtherInfo", queryUserId);
        OtherUserInfoQuery otherUserInfoQuery = null;
        if (queryUserTrendsPhoto !=null || queryUserTrendsPhoto.size() ==1){
            otherUserInfoQuery = queryUserTrendsPhoto.get(0);
            otherUserInfoQuery.setUserTrendsPhoto(userTrendsPhoto);
        }
        return otherUserInfoQuery;
    }

    private List<String> queryUserTrendsPhoto(String queryUserId){
        List<String> queryUserTrendsPhoto = mysqlBaseSession.selectList("trends.queryUserTrendsPhoto", queryUserId);
        return queryUserTrendsPhoto;
    }

}
