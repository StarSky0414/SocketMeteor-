package controller;

import bean.AdapterResponseBean;
import bean.SendTrendsBean;
import bean.SyncTrendsBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.MysqlBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendTrendsControllerTest {


    static SendTrendsController sendTrendsController ;
    static {
        init();
    }

    static void init(){
        MysqlBase.init();

        sendTrendsController = new SendTrendsController();
        SendTrendsBean sendTrendsBean = new SendTrendsBean("1","测试数据","URL://123.123.123.123");
        sendTrendsController.json=JSONObject.toJSONString(sendTrendsBean);
        System.out.println("==================== init is over ===================");
    }

    @Test
    void testGetAdapterResponse() {
        System.out.println("sendTrendsController.json ："+sendTrendsController.json);
        AdapterResponseBean adapterResponse = sendTrendsController.getAdapterResponse();
        System.out.println(adapterResponse);
    }
}