package bean;

public class MessageSendResolveJsonBean {
    String receiveUserId;
    String messageContext;
    String sendUserId;

    public MessageSendResolveJsonBean() {
    }

    public MessageSendResolveJsonBean(String receiveUserId, String messageContext, String sendUserId) {
        this.receiveUserId = receiveUserId;
        this.messageContext = messageContext;
        this.sendUserId = sendUserId;
    }

    public String getReceiveUserId() {
        return receiveUserId;
    }

    public void setReceiveUserId(String receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }
}
