package bean;
import java.util.ArrayList;

public class MessageBean {
    private int code;
    private int state;
    private String userId;
    private String nextCheck;
    private ArrayList messageList;

    public void setCode(int code) {
        this.code = code;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNextCheck(String nextCheck) {
        this.nextCheck = nextCheck;
    }

    public void setMessageList(ArrayList messageList) {
        this.messageList = messageList;
    }
}
