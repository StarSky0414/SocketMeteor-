package safeproving;

import db.redis.FunctionEnum;
import db.redis.RedisBase;

import static org.junit.jupiter.api.Assertions.*;

class SafeTest {

    @org.junit.jupiter.api.Test
    void makeSession() {
        Safe safe = new Safe();
        String s = safe.makeSession();
        RedisBase redisBase = new RedisBase();
//        redisBase.createRedisList(FunctionEnum.USERINFO,"123123",s);
        System.out.println(s);
    }
}