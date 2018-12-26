//package controller;
//
//import com.alibaba.fastjson.JSONObject;
//import com.starsky.meteor.bean.SynUserFriendRequestBean;
//import com.starsky.meteor.db.bean.FollowUserInfoBean;
//import com.starsky.meteor.db.mapper.UserFriendListProviderMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class SynUserFriendController extends AdapterI{
//
//    @Autowired
//    UserFriendListProviderMapper userFriendListProviderMapper;
//
//    private int getUserId(){
//        SynUserFriendRequestBean synUserFriendRequestBean = JSONObject.parseObject(adapterResponseBean, SynUserFriendRequestBean.class);
//        Integer userId = synUserFriendRequestBean.getUserId();
//        return userId;
//    }
//
//    private List<FollowUserInfoBean> getUserFriendList(){
//        int userId = getUserId();
//        List<FollowUserInfoBean> followUserInfoBeans = userFriendListProviderMapper.queryUserFriendList(userId);
//        return followUserInfoBeans;
//    }
//
//
//    @Override
//    public String getSeverJsonString() {
//        List<FollowUserInfoBean> userFriendList = getUserFriendList();
//        String s = JSONObject.toJSONString(userFriendList);
//        return s;
//    }
//}
