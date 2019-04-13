package bean.udp;

/**
 *  udp 同步消息使用
 */
public class SyncMessageUdp {

    private String tocken;

    private String locationMessageNum;

    public SyncMessageUdp(String tocken, String locationMessageNum) {
        this.tocken = tocken;
        this.locationMessageNum = locationMessageNum;
    }

    public SyncMessageUdp() {
    }

    public String getTocken() {
        return tocken;
    }

    public void setTocken(String tocken) {
        this.tocken = tocken;
    }

    public String getLocationMessageNum() {
        return locationMessageNum;
    }

    public void setLocationMessageNum(String locationMessageNum) {
        this.locationMessageNum = locationMessageNum;
    }
}
