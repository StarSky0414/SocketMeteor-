package db.redis;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

public class RedisTest {




    RedisBase redisBase ;
    private static final String id = "123123";

    @Before
    public void init(){
        redisBase = new RedisBase();
    }

    @Test
    public void testCreat(){

    }

    @Test
    public void testUserInfoEnum(){
        String[] strings = new String[5];
//
//        strings."aaaaa");
//        strings.add("bbbbb");
//        strings.add("ccccc");

        redisBase.createRedisList(FunctionEnum.USERINFO,id,strings);

    }
//
//    @Test
//    public void testUpdateRedisList(){
//
//        redisBase.updateRedisList(FunctionEnum.USERINFO,id,"fffffff",UserInfoEnum.SESSION);
//    }

    @Test
    public void insertRedisList(){
//        ArrayList<String> strings = new ArrayList<String>();
//        strings.add(1,"lalala");
        String[] strings = new String[5];

        strings[1]="aaaaa";
        redisBase.createRedisList(FunctionEnum.USERINFO,"123",strings);
    }
}
