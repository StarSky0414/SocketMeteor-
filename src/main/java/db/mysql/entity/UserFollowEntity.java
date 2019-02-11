package db.mysql.entity;

/**
 *  用户关系实体类
 */
public class UserFollowEntity {

    // 请求id
    private int id;

    // 发起用户id
    private String startUserId;

    // 目标用户id
    private String goalUserId;

    // 发起时间
    private String createTime;

    // 目前状态  【 请求中 0 ；通过 1 ；未通过  2 】
    private int state;

    // 删除标记 【 未删除 0 ； 删除 1 】
    private int deleSign;

    public UserFollowEntity() {
    }

    /** 创建，删除 */
    public UserFollowEntity(String startUserId, String goalUserId) {
        this.startUserId = startUserId;
        this.goalUserId = goalUserId;
    }

    /** 更新状态 */
    public UserFollowEntity(String startUserId, String goalUserId, int state) {
        this.startUserId = startUserId;
        this.goalUserId = goalUserId;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartUserId() {
        return startUserId;
    }

    public void setStartUserId(String startUserId) {
        this.startUserId = startUserId;
    }

    public String getGoalUserId() {
        return goalUserId;
    }

    public void setGoalUserId(String goalUserId) {
        this.goalUserId = goalUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDeleSign() {
        return deleSign;
    }

    public void setDeleSign(int deleSign) {
        this.deleSign = deleSign;
    }

    @Override
    public String toString() {
        return "UserFollowEntity{" +
                "id=" + id +
                ", startUserId='" + startUserId + '\'' +
                ", goalUserId='" + goalUserId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state=" + state +
                ", deleSign=" + deleSign +
                '}';
    }
}