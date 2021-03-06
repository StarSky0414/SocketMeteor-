package controller;

import adapter.MethodName;
import bean.AdapterResponseBean;
import bean.SendTrendsBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.entity.TrendsEntity;
import db.mysql.provider.TrendsSendProviderMapper;

public class SendTrendsController extends AdapterI{

    private TrendsEntity resolveJson(){
        TrendsEntity syncTrendsBean = JSONObject.parseObject(json, TrendsEntity.class);
        System.out.println("syncTrendsBean: "+syncTrendsBean.toString());
        return syncTrendsBean;
    }

    private String path;
    private String state;

    @Override
    public AdapterResponseBean getAdapterResponse() {
        System.out.println("SendTrendsController: json"+json);

        AdapterResponseBean adapterResponseBean = new AdapterResponseBean(null, state);
        return adapterResponseBean;
    }


    @MethodName(methodName="createTrend")
    public void createTrend(){
        TrendsEntity sendTrendsBean = resolveJson();
        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
        TrendsEntity trendsEntity = new TrendsEntity(sendTrendsBean.getSendUserId(),sendTrendsBean.getTrendPhotoUrl(),sendTrendsBean.getTrendContent());
        int i = trendsSendProviderMapper.sendTrendsContent(trendsEntity);
        state = i == 1?SUCCESS_SIGN:FAIL_SIGN;
    }

    @MethodName(methodName = "updateTrend")
    public void updateTrend(){
        TrendsEntity sendTrendsBean = resolveJson();
        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
        System.out.println("sendTrendsBean : "+sendTrendsBean.toString());
        TrendsEntity trendsEntity = new TrendsEntity(sendTrendsBean.getSendUserId(),sendTrendsBean.getTrendPhotoUrl(), sendTrendsBean.getTrendId(), sendTrendsBean.getTrendContent());
        System.out.println("trendsEntity : "+trendsEntity.toString());
        int i = trendsSendProviderMapper.updateTrendsContent(trendsEntity);
        state = i == 1?SUCCESS_SIGN:FAIL_SIGN;
    }

    @MethodName(methodName = "deleteTrend")
    public void deleteTrend(){
        TrendsEntity sendTrendsBean = resolveJson();
        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
        int i = trendsSendProviderMapper.deleteTrendsContent(String.valueOf(sendTrendsBean.getTrendId()));
        state = i == 1?SUCCESS_SIGN:FAIL_SIGN;
    }

}
