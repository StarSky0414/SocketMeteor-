package db.redis;

public enum FunctionEnum {


    USERINFO("user_info:id:"),
    USERSESSION("user_session:session:");

    private String keyName;

    FunctionEnum(String s) {
        keyName= "skstmetetor:"+s;
    }

    public String getKeyName() {
        System.out.println(keyName);
        return keyName;
    }
}
