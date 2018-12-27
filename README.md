
# Socket版本Meteor
该项目负责 【聊天app】 服务端
优化：  
 1. http 应用层协议改用 自定义应用层协议，更加灵活。
 2. 身份验证失败不进行数据解析，优化并发处理能力，摒弃无用请求。
 3. 采用线程池管理数据，提高并发处理能力，常驻线程加快请求处理效率。
 4. mysql 采用 **MyBatis** 框架，简化编码。
 5. Redis 采用 自定义结构（枚举+list/自定义注解）完成自动化处理
>枚举+list  
>**Redis** List 结构，采用枚举确定其顺序，采用 list 去存储数据  
>使用时候只需要提供Hasp<枚举，String数据>  

    HashMap<UserInfoEnum, String> userInfoEnumStringHashMap = new HashMap<UserInfoEnum, String>(); 
    myJedisAnalyze.jedisList(FunctionEnum.USERINFO, "123456", RedisDataBasicOperation.UPDATE, userInfoEnumStringHashMap);  

>**Redis** String 结构，采用自定义注解解析  

使用代码：  
Bean    

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

填装：  

    SessionString sessionString = new SessionString("123456", "2", RedisDataBasicOperation.CREATE, FunctionEnum.USERSESSION);  
    MyJedisAnalyze myJedisAnalyze = new MyJedisAnalyze();  
    try {  
        myJedisAnalyze.jedisString(sessionString);  
    } catch (IllegalAccessException e) {  
        e.printStackTrace();  
    }



处理代码：  

 
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

 
