//package controller;
//
//import bean.AdapterResponseBean;
//import bean.MessageSendResolveJsonBean;
//import com.alibaba.fastjson.JSONObject;
//import db.mysql.provider.MessageSendProviderMapper;
//
//public class MessageController extends AdapterI{
//
//    private MessageSendResolveJsonBean resolveJson(){
//        MessageSendResolveJsonBean messageSendResolveJsonBean = JSONObject.parseObject(json, MessageSendResolveJsonBean.class);
////        JSONObject.parseObject(json, MessageSendResolveJsonBean.class)
//        return messageSendResolveJsonBean;
//    }
//
//    public AdapterResponseBean getAdapterResponse() {
//        MessageSendResolveJsonBean messageSendResolveJsonBean = resolveJson();
//        MessageSendProviderMapper messageSendProviderMapper = new MessageSendProviderMapper();
//        messageSendProviderMapper.insertTextMessage(messageSendResolveJsonBean.getSendUserId(),messageSendResolveJsonBean.getReceiveUserId(),messageSendResolveJsonBean.getMessageContext());
//        AdapterResponseBean adapterResponseBean = new AdapterResponseBean("","","{\"stat\":1}");
//        return adapterResponseBean;
//    }
//}
