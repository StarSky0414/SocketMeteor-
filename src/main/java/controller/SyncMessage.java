package controller;

import adapter.MethodName;
import bean.AdapterResponseBean;
import bean.MessageSendResolveJsonBean;
import bean.SyncMessageRequestBean;
import bean.json.response.MessageResponseBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.entity.MessageEntity;
import db.mysql.entity.RedisMessageEntity;
import db.mysql.entity.UserChatMessageEntity;
import db.mysql.entity.UserInfoEntity;
import db.mysql.provider.MessageSyncProviderMapper;
import db.mysql.provider.UserInfoSyncProvider;

import java.util.List;

public class SyncMessage extends AdapterI {


    private MessageResponseBean messageResponseBean;

    private SyncMessageRequestBean resolveJson() {
        SyncMessageRequestBean syncMessageRequestBean = JSONObject.parseObject(json, SyncMessageRequestBean.class);
//        JSONObject.parseObject(json, MessageSendResolveJsonBean.class)
        return syncMessageRequestBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        String s = JSONObject.toJSONString(messageResponseBean);
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean
                (null, s);
        return adapterResponseBean;

    }

    /**
     * 获取消息
     */
    @MethodName(methodName = "getMessage")
    public void getMessage() {
        SyncMessageRequestBean syncMessageRequestBean = resolveJson();
        String locatMessageId = syncMessageRequestBean.getLocatMessageId();
        String userId = syncMessageRequestBean.getUserId();

        MessageSyncProviderMapper messageSyncProviderMapper = new MessageSyncProviderMapper();
        RedisMessageEntity redisMessageEntity = new RedisMessageEntity(userId, locatMessageId);
        List<MessageEntity> messageEntities = messageSyncProviderMapper.queryMessage(redisMessageEntity);

        UserInfoSyncProvider userInfoSyncProvider = new UserInfoSyncProvider();
        List<UserInfoEntity> messageUserInfo = userInfoSyncProvider.getMessageUserInfo(Integer.valueOf(userId), Integer.valueOf(locatMessageId));

        messageResponseBean = new MessageResponseBean(messageEntities, messageUserInfo);
    }
}
