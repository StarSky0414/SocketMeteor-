package db.redis;

import db.redis.annotate.StringByFunction;
import db.redis.annotate.StringByKey;
import db.redis.annotate.StringByType;
import db.redis.annotate.StringByValue;

import static db.redis.RedisDataBasicOperation.CREATE;

public class SessionString implements RedisStringStructure {

    // 用户session
    @StringByKey
    private String SESSION;

    // 用户id
    @StringByValue
    private String userId;

    // 操作
    @StringByType
    private RedisDataBasicOperation basicOperation = CREATE;

    // key前缀
    @StringByFunction
    private FunctionEnum functionEnum;

    public SessionString(String SESSION, String userId, FunctionEnum functionEnum) {
        this.SESSION = SESSION;
        this.userId = userId;
        this.functionEnum=functionEnum;
    }

    public SessionString(String SESSION, String userId, RedisDataBasicOperation basicOperation, FunctionEnum functionEnum) {
        this.SESSION = SESSION;
        this.userId = userId;
        this.basicOperation = basicOperation;
        this.functionEnum = functionEnum;
    }

    public String getSESSION() {
        return SESSION;
    }

    public String getUserId() {
        return userId;
    }

    public RedisDataBasicOperation getBasicOperation() {
        return basicOperation;
    }


}
