package db.redis;

/**
 * 用于list结构规范
 */
public interface RedisListStructure  {

    // 获取枚举个数
    int getEnumNumber();

    // 获取枚举下标
    int getindex();

    // 获取枚举值
    RedisListStructure[] getEnum();
}
