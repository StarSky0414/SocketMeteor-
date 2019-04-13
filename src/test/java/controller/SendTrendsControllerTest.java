package controller;

import bean.AdapterRequestBean;
import bean.AdapterResponseBean;
import bean.SendTrendsBean;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

class SendTrendsControllerTest extends ControllerBaseTest{

    @Test
    void testGetAdapterResponse() {
        SendTrendsBean sendTrendsBean = new SendTrendsBean("1", "测试数据", "URL://123.123.123.123");
        String s = JSONObject.toJSONString(sendTrendsBean);
        AdapterRequestBean adapterRequestBean = new AdapterRequestBean("trends:createTrend",s);
        AdapterResponseBean adapterResponseBean = distribute.toDistribute(adapterRequestBean, "1");
        System.out.println("sendTrendsController.json ："+sendTrendsController.json);
//        AdapterResponseBean adapterResponse = sendTrendsController.getAdapterResponse();
//        System.out.println(adapterResponse);
        System.out.println(adapterResponseBean.toString());
    }
}