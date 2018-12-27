package controller;

import bean.AdapterResponseBean;
import bean.SyncMessageRequestBean;
import bean.SyncTrendsBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.MysqlBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SyncTrendsControllerTest {

    static SyncTrendsController syncTrendsController ;
    static {
        init();
    }

    static void init(){
        MysqlBase.init();

        syncTrendsController = new SyncTrendsController();
        SyncTrendsBean syncTrendsBean = new SyncTrendsBean("1","5");

        syncTrendsController.json=JSONObject.toJSONString(syncTrendsBean);
        System.out.println("==================== init is over ===================");
    }
    @Test
    void testGetAdapterResponse() {
        System.out.println("syncMessage.json ："+syncTrendsController.json);
        AdapterResponseBean adapterResponse = syncTrendsController.getAdapterResponse();
        System.out.println(adapterResponse);
    }
}