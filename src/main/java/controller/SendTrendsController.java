package controller;

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
        TrendsEntity trendsEntity = sendTrendsBeanToTrendsEntity(sendTrendsBean);
        trendsSendProviderMapper.sendTrendsContent(trendsEntity);
        String s = "{\"stat\":1}";
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("1", s);
        return adapterResponseBean;
    }

    private TrendsEntity sendTrendsBeanToTrendsEntity(SendTrendsBean sendTrendsBean){
        TrendsEntity trendsEntity = new TrendsEntity();
        trendsEntity.setSendUserId(sendTrendsBean.getSendUserId());
        trendsEntity.setContent(sendTrendsBean.getContent());
        trendsEntity.setUrl(sendTrendsBean.getPhotoUrl());
        return trendsEntity;
    }
}
