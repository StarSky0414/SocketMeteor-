package controller;

import adapter.MethodName;
import bean.AdapterResponseBean;
import bean.json.request.UserInfoRequestBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.entity.OtherUserInfoQuery;
import db.mysql.provider.UserInfoSyncProvider;

public class SyncUserInfo extends AdapterI {
    private static UserInfoSyncProvider userInfoSyncProvider=new UserInfoSyncProvider();
    private OtherUserInfoQuery otherUserInfoQuery;

    private UserInfoRequestBean resolveJson() {
        UserInfoRequestBean userInfoRequestBean = JSONObject.parseObject(json, UserInfoRequestBean.class);
        return userInfoRequestBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        String s = JSONObject.toJSONString(otherUserInfoQuery);
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("", s);
        return adapterResponseBean;
    }

    @MethodName(methodName = "otherUserInfo")
    public void otherUserInfo(){
        UserInfoRequestBean userInfoRequestBean = resolveJson();
        otherUserInfoQuery = userInfoSyncProvider.queryUserInfo(userInfoRequestBean.getQueryUserId());

    }
}
