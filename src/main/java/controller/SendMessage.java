package controller;

import adapter.MessageInit;
import adapter.MethodName;
import bean.AdapterResponseBean;
import bean.json.request.SendMessageBean;
import bean.user.UserInfo;
import com.alibaba.fastjson.JSONObject;
import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;
import db.mysql.entity.TrendsEntity;
import db.mysql.provider.MessageSendProviderMapper;
import db.mysql.provider.TrendsSendProviderMapper;
import db.redis.FunctionEnum;
import db.redis.RedisBase;
import db.redis.RedisDataBasicOperation;
import db.redis.UserInfoEnum;
import db.redis.annotate.MyJedisAnalyze;

import java.util.HashMap;

public class SendMessage extends AdapterI {

    private String state ;
    private SendMessageBean resolveJson(){
        SendMessageBean sendMessageBean = JSONObject.parseObject(json, SendMessageBean.class);
        System.out.println("syncTrendsBean: "+sendMessageBean.toString());
        return sendMessageBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("", "", state);
        return adapterResponseBean;
    }

    @MethodName(methodName = "setMessage")
    public void setMessage(){
        SendMessageBean sendMessageBean = resolveJson();
//        TrendsSendProviderMapper trendsSendProviderMapper = new TrendsSendProviderMapper();
        System.out.println("sendMessageBean: "+sendMessageBean.toString());
        MessageSendProviderMapper messageSendProviderMapper = new MessageSendProviderMapper();
        int i = messageSendProviderMapper.insertMessage(sendMessageBean);
//        String  receiveUserId= sendMessageBean.getReceiveUserId();
        MessageInit.addMessageNum();
//        RedisBase redisBase = new RedisBase();
//        Integer integer = redisBase.inrcRedisList(FunctionEnum.USERINFO, receiveUserId, UserInfoEnum.MESSAGEED_ID);
        state = i == 1?SUCCESS_SIGN:FAIL_SIGN;
    }
}
