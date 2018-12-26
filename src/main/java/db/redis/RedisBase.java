package db.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisDataException;

import java.util.ArrayList;
import java.util.List;

public class RedisBase {

    private final Jedis jedis;

    /**
     * Jedis 获取
     */
    public RedisBase() {
        jedis = RedisConnect.getJedis();
    }

    /**
     * 创建 RedisList
     *
     * @param keyClass 前缀
     * @param object   种类详细值  例如前缀是id 该参数即为id详细值
     * @param values   参数按list 顺序创建
     */
    public void createRedisList(FunctionEnum keyClass, String object, String[] values) {
        String key = keyClass.getKeyName() + object + ":list";
        for (String value : values) {
            jedis.rpush(key, value);
        }
    }

    /**
     * 更新redis list
     *
     * @param keyClass           前缀
     * @param object             种类详细值  例如前缀是id 该参数即为id详细值
     * @param values             要修改的值
     * @param redisListStructure 实现该接口的枚举，用于list结构
     */
    public void updateRedisList(FunctionEnum keyClass, String object, String[] values, RedisListStructure redisListStructure) {
        String key = keyClass.getKeyName() + object + ":list";
        RedisListStructure[] redisListStructureEnum = redisListStructure.getEnum();
        for (int i = 0; i < values.length; i++) {
            int getindex = redisListStructureEnum[i].getindex();
            try {
                jedis.lset(key, getindex, values[i]);
            } catch (JedisDataException e) {
                jedis.rpush(key, values[i]);
            }
        }
    }

    /**
     * 查询redis list
     *
     * @param keyClass           前缀
     * @param object             种类详细值  例如前缀是id 该参数即为id详细值
     * @param redisListStructure 实现该接口的枚举，用于list结构
     * @return 查询结果
     */
    public String queryRedisList(FunctionEnum keyClass, String object, RedisListStructure redisListStructure) {
        String key = keyClass.getKeyName() + object + ":list";
        int index = redisListStructure.getindex();
        String indexResult = jedis.lindex(key, index);
        return indexResult;
    }

    /**
     * 查询 全部 redis list
     *
     * @param keyClass 前缀
     * @param object   种类详细值  例如前缀是id 该参数即为id详细值
     * @return 查询结果 list
     */
    public String[] queryAllRedisList(FunctionEnum keyClass, String object) {
        String key = keyClass.getKeyName() + object + ":list";
        long llen = jedis.llen(key);
        String[] allresultString = new String[(int) llen];
        for (int i = 0; i < llen; i++) {
            String lindex = jedis.lindex(key, i);
            allresultString[i] = lindex;
        }
        return allresultString;
    }

    /**
     * 创建 key-value String
     *
     * @param keyClass 前缀
     * @param object   种类详细值  例如前缀是id 该参数即为id详细值
     * @param values   要存储的值
     */
    public void createRedisString(FunctionEnum keyClass, String object, String values) {
        String key = keyClass.getKeyName() + object + ":String";
        jedis.set(key, values);
    }

    /**
     * 查询 key-value String
     *
     * @param keyClass 前缀
     * @param object   种类详细值
     * @return value 值
     */
    public String queryRedisString(FunctionEnum keyClass, String object) {
        String key = keyClass.getKeyName() + object + ":String";
        String resultString = jedis.get(key);
        return resultString;
    }

    /**
     * 更新 key-value String
     *
     * @param keyClass 前缀
     * @param object   种类详细值
     * @param values   要更新的值
     */
    public void updateRedisString(FunctionEnum keyClass, String object, String values) {
        createRedisString(keyClass, object, values);
    }

    /**
     * 删除 key-value String
     *
     * @param keyClass 前缀
     * @param object   种类详细值
     */
    public void deleRedisString(FunctionEnum keyClass, String object) {
        String key = keyClass.getKeyName() + object + ":String";
        jedis.del(key);
    }
}
