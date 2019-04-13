package adapter.udp;


/**
 *  UDP消息是否有消息询问 回复
 */
public class SyncMessageResponse {

    private boolean hasNewMessage = false;

    public boolean getHasNewMessage() {
        return hasNewMessage;
    }

    public void setHasNewMessage(boolean hasNewMessage) {
        this.hasNewMessage = hasNewMessage;
    }
}
