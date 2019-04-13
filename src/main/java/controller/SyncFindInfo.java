package controller;

import adapter.MethodName;
import bean.AdapterResponseBean;
import bean.SyncFindInfoRequestBean;
import bean.SyncMessageRequestBean;
import bean.json.request.UserInfoRequestBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.MysqlBase;
import db.mysql.entity.UserInfoEntity;
import db.redis.FunctionEnum;
import db.redis.RedisBase;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SyncFindInfo extends AdapterI {

    private String userInfoJsonString="[]";

    @Override
    public AdapterResponseBean getAdapterResponse() {
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("", userInfoJsonString);
        return adapterResponseBean;
    }

    @MethodName(methodName = "findInfo")
    public void findInfo() {
        MysqlBase mysqlBase = MysqlBase.getMysqlBase();
        SqlSession session = mysqlBase.getSession();
        List<UserInfoEntity> userInfoEntities = session.selectList("user_info.user_info_select_all",userId);
        if (userInfoEntities != null && userInfoEntities.size()!=0){
            userInfoJsonString = JSONObject.toJSONString(userInfoEntities);
        }else {
            userInfoJsonString = "[]";
        }
    }
}
