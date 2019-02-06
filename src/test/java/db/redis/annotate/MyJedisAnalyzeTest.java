package db.redis.annotate;

import db.redis.*;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MyJedisAnalyzeTest {

    @Test
    void jedisString() {
        SessionString sessionString = new SessionString("123456", "2", RedisDataBasicOperation.CREATE, FunctionEnum.USERSESSION);
        MyJedisAnalyze myJedisAnalyze = new MyJedisAnalyze();
        try {
            myJedisAnalyze.jedisString(sessionString);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testJedisList() {
        HashMap<UserInfoEnum, String> userInfoEnumStringHashMap = new HashMap<UserInfoEnum, String>();
        userInfoEnumStringHashMap.put(UserInfoEnum.MESSAGEED_ID, "");
        MyJedisAnalyze myJedisAnalyze = new MyJedisAnalyze();

        myJedisAnalyze.jedisList(FunctionEnum.USERINFO, "123456", RedisDataBasicOperation.UPDATE, userInfoEnumStringHashMap);
        String[] strings = myJedisAnalyze.jedisList(FunctionEnum.USERINFO, "123456", RedisDataBasicOperation.QUERY, userInfoEnumStringHashMap);

        for (String string : strings) {
            System.out.println("redisListItem: " + string);
        }

    }
}