package controller;

import adapter.MethodName;
import bean.AdapterResponseBean;
import bean.SendTrendsBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.entity.TrendsEntity;
import db.mysql.provider.TrendsSendProviderMapper;

public class SendTrendsController extends AdapterI{
    private SendTrendsBean resolveJson(){
        SendTrendsBean syncTrendsBean = JSONObject.parseObject(json, SendTrendsBean.class);
        return syncTrendsBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        SendTrendsBean sendTrendsBean = resolveJson();
        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
//        TrendsEntity trendsEntity = sendTrendsBeanToTrendsEntity(sendTrendsBean);
//        trendsSendProviderMapper.sendTrendsContent(trendsEntity);
//        String s = "{\"stat\":1}";
//        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("1", s);

        TrendsEntity trendsEntity = new TrendsEntity(sendTrendsBean.getSendUserId(),sendTrendsBean.getContent(),sendTrendsBean.getPhotoUrl());
        int i = trendsSendProviderMapper.sendTrendsContent(trendsEntity);
        String state = i == 1?SUCCESS_SIGN:FAIL_SIGN;
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean(null, state);
        return adapterResponseBean;
    }


    @MethodName(methodName="testMethod")
    public void createTrends(){
        System.out.println("This is createTrends");
        try {
            Thread.sleep(Long.parseLong("5000"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sleep is Over");
    }
}
