package controller;

import bean.AdapterResponseBean;
import bean.MessageSendResolveJsonBean;
import bean.SyncMessageRequestBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.entity.UserChatMessageEntity;
import db.mysql.provider.MessageSyncProviderMapper;

import java.util.List;

public class SyncMessage extends AdapterI  {


    private SyncMessageRequestBean resolveJson(){
        SyncMessageRequestBean syncMessageRequestBean = JSONObject.parseObject(json, SyncMessageRequestBean.class);
//        JSONObject.parseObject(json, MessageSendResolveJsonBean.class)
        return syncMessageRequestBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        SyncMessageRequestBean syncMessageRequestBean = resolveJson();
        String locatMessageId = syncMessageRequestBean.getLocatMessageId();
        String userId = syncMessageRequestBean.getUserId();
        MessageSyncProviderMapper messageSyncProviderMapper = new MessageSyncProviderMapper();
        List<UserChatMessageEntity> userChatMessageEntities = messageSyncProviderMapper.queryTextMessage(userId, userId, locatMessageId);
        String s = JSONObject.toJSONString(userChatMessageEntities);
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("1",s);
        return adapterResponseBean;
    }
}
