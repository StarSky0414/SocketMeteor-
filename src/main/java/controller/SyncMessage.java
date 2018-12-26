package controller;

import bean.AdapterResponseBean;
import bean.MessageSendResolveJsonBean;
import bean.SyncMessageRequestBean;
import com.alibaba.fastjson.JSONObject;

public class SyncMessage extends AdapterI  {


    private SyncMessageRequestBean resolveJson(){
        SyncMessageRequestBean syncMessageRequestBean = JSONObject.parseObject(json, SyncMessageRequestBean.class);
//        JSONObject.parseObject(json, MessageSendResolveJsonBean.class)
        return syncMessageRequestBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        SyncMessageRequestBean syncMessageRequestBean = resolveJson();

        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("1","1");
        return adapterResponseBean;
    }
}
