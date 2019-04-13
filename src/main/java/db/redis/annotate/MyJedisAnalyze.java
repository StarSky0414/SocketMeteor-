package db.redis.annotate;

import db.redis.*;
import java.lang.reflect.Field;
import java.util.*;

/**
 *  redis 解析处理
 *  String 类型使用 自定义注解方式加载  key，value，operation
 *  List 类型使用 枚举确定其结构
 */
public class MyJedisAnalyze  {

    private static RedisBase redisBase = null;

    static {
        redisBase = new RedisBase();
    }


    /**
     *  String 类型处理
     * @param pJedisTypeByString       实现了  RedisStringStructure  的Bean
     * @throws IllegalAccessException  非法访问出错异常
     */
    public void jedisString(RedisStringStructure pJedisTypeByString) throws IllegalAccessException {
        Class<? extends RedisStringStructure> jedisTypeByStringClass = pJedisTypeByString.getClass();
        Field[] fields = jedisTypeByStringClass.getDeclaredFields();
        String keyName = null;
        String stringValue = null;
        RedisDataBasicOperation redisOperationType = null;
        FunctionEnum redisFunction = null;

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(StringByKey.class)) {
                keyName = (String) field.get(pJedisTypeByString);
            } else if (field.isAnnotationPresent(StringByValue.class)) {
                stringValue = (String) field.get(pJedisTypeByString);
            } else if (field.isAnnotationPresent(StringByType.class)) {
                redisOperationType = (RedisDataBasicOperation) field.get(pJedisTypeByString);
            } else if (field.isAnnotationPresent(StringByFunction.class)) {
                redisFunction = (FunctionEnum) field.get(pJedisTypeByString);
            }
        }

        try {
            jedisStringCheckNull(keyName, redisOperationType, redisFunction);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        switch (redisOperationType) {
            case CREATE:
                redisBase.createRedisString(redisFunction, keyName, stringValue);
                break;
            case QUERY:
                String queryRedisString = redisBase.queryRedisString(redisFunction, keyName);
                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(StringByValue.class)) {
                        field.set(pJedisTypeByString, queryRedisString);
                    }
                }
                break;
            case UPDATE:
                redisBase.updateRedisString(redisFunction, keyName, stringValue);
                break;
            case DELE:
                redisBase.deleRedisString(redisFunction, keyName);
                break;
        }
    }

    /**
     *  检查jedis 标记是否完整
     * @param pKeyName             key区分
     * @param pRedisOperationType 要操作的类型
     * @param pRedisFunction       前缀
     * @throws Exception
     */
    private void jedisStringCheckNull(String pKeyName, RedisDataBasicOperation pRedisOperationType, FunctionEnum pRedisFunction) throws Exception {
        StringBuffer errorString = new StringBuffer();
        if (pKeyName == null) {
            errorString.append(" @StringByKey ");
        }
        if (pRedisOperationType == null) {
            errorString.append(" @StringByType ");
        }
        if (pRedisFunction == null) {
            errorString.append(" @StringByFunction ");
        }
        if (errorString.length() != 0) {
            errorString.append("缺失，请检查标记是否存在,或是变量是否初始化。");
            System.out.println(errorString);
            throw new Exception();
        }
    }

    /**
     *  List 处理
     * @param pKeyClass                  前缀
     * @param pObject                    种类详细值  例如前缀是id 该参数即为id详细值
     * @param operationType              操作类型，【增，删，改，查】
     * @param userInfoEnumStringHashMap  用户要操作的数据
     * @return                           用户修改完的结果
     */
    public String[] jedisList(FunctionEnum pKeyClass, String pObject,
                              RedisDataBasicOperation operationType, HashMap<? extends RedisListStructure,String> userInfoEnumStringHashMap){
        Set<? extends Map.Entry<? extends RedisListStructure, String>> entries = userInfoEnumStringHashMap.entrySet();
        Set<? extends RedisListStructure> redisListStructures = userInfoEnumStringHashMap.keySet();
        Iterator<? extends RedisListStructure> iterator = redisListStructures.iterator();
        int enumNumber = 0;
        RedisListStructure next = null;
        if (iterator.hasNext()) {
            next = iterator.next();
            enumNumber = next.getEnumNumber();
            System.out.println(enumNumber);
        }

        String[] nullAllRedisArray = new String[enumNumber];
        Arrays.fill(nullAllRedisArray,"");

        String[] queryAllRedisArray=null;

        switch (operationType){
            case CREATE:
                String[] fillData = updateListByMap(userInfoEnumStringHashMap, nullAllRedisArray);
                redisBase.createRedisList(pKeyClass, pObject,fillData);
                break;
            case DELE:
                System.err.println("jedisList DELE 未使用！！！");
                break;
            case QUERY:
                queryAllRedisArray = redisBase.queryAllRedisList(pKeyClass, pObject);
                break;
            case UPDATE:
                queryAllRedisArray = redisBase.queryAllRedisList(pKeyClass, pObject);
                if (queryAllRedisArray.length==0){
                    queryAllRedisArray=nullAllRedisArray;
                }
                String[] strings = updateListByMap(userInfoEnumStringHashMap, queryAllRedisArray);
                redisBase.updateRedisList(pKeyClass, pObject,strings,next);
                break;
        }
        return queryAllRedisArray;
    }

    /**
     *  将map转化为List 与Enum对应
     * @param userInfoEnumStringHashMap        用户要处理的数据，<枚举，数据>
     * @param userInfoArray                    通过枚举创建的Array
     * @return                                 要插入数据库的数组
     */
    private String[]  updateListByMap(HashMap<? extends RedisListStructure,String> userInfoEnumStringHashMap, String[] userInfoArray){
        for (Map.Entry<? extends RedisListStructure,String> entry : userInfoEnumStringHashMap.entrySet()){
            RedisListStructure key = entry.getKey();
            String value = entry.getValue();
            int getindex = key.getindex();
            userInfoArray[getindex] = value;
        }
        return userInfoArray;
    }

}
