package db.redis;

/**
 * 用户信息Redis list
 */

public enum UserInfoEnum implements RedisListStructure {
    // 用户地址
    USER_ADDRESS,
    // 用户地址
    USER_ADDRESS_PORT,
    // 用户old消息id
    OLD_MESSAGE_ID,
    // 已发送用户消息id
    MESSAGEED_ID;

    public int getindex() {
        return this.ordinal();
    }

    @Override
    public UserInfoEnum[] getEnum() {
        return UserInfoEnum.values();
    }

    public UserInfoEnum getThis() {
        return this;
    }

    @Override
    public int getEnumNumber() {
        return values().length;
    }
}

