package db.redis;

import redis.clients.jedis.*;


/**
 * redis  连接使用
 */
public class RedisConnect {

    private static JedisPool jedisPool;

    /**
     * 初始化切片池
     */
    private static void initJedisPool() {
        JedisPoolConfig config = makeRedisConfig();
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
    }

    /**
     *  获取Jedis
     * @return Jedis实例
     */
    public static Jedis getJedis() {
        if (jedisPool == null){
            RedisConnect.initJedisPool();
        }
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    /**
     *  Jedis 连接池配置
     * @return config
     */
    private static JedisPoolConfig makeRedisConfig(){

        // 池基本配置
        JedisPoolConfig config = new JedisPoolConfig();
        //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        config.setBlockWhenExhausted(true);
        //是否启用后进先出, 默认true
        config.setLifo(true);
        //最大空闲连接数, 默认8个
        config.setMaxIdle(8);
        //最大连接数, 默认8个
        config.setMaxTotal(50);
        //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        config.setMaxWaitMillis(-1);
        //逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
        config.setMinEvictableIdleTimeMillis(1800000);
        //最小空闲连接数, 默认0
        config.setMinIdle(3);
        //对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
        config.setSoftMinEvictableIdleTimeMillis(1800000);
        //在获取连接的时候检查有效性, 默认false
        config.setTestOnBorrow(false);
        //在空闲时检查有效性, 默认false
        config.setTestWhileIdle(false);
        //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
        config.setTimeBetweenEvictionRunsMillis(-1);
        return config;
    }

}
