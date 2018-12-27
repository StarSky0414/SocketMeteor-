package controller;

import bean.AdapterResponseBean;
import bean.SyncMessageRequestBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.MysqlBase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SyncMessageRequestBeanTest {

    static SyncMessage syncMessage ;
    static {
        init();
    }

    static void init(){
        MysqlBase.init();
        syncMessage = new SyncMessage();
        SyncMessageRequestBean syncMessageRequestBean = new SyncMessageRequestBean("1","0");

        syncMessage.json=JSONObject.toJSONString(syncMessageRequestBean);
        System.out.println("==================== init is over ===================");
    }

    @Test
    void getAdapterResponse() {

        System.out.println("syncMessage.json ："+syncMessage.json);
        AdapterResponseBean adapterResponse = syncMessage.getAdapterResponse();
        System.out.println(adapterResponse.toString());
    }
}