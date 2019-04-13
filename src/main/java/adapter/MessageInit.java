package adapter;

import db.mysql.MysqlBase;
import org.apache.ibatis.session.SqlSession;

public class MessageInit {
    private static int messageNum = 0;


    public  static void messageInit() {
        messageNum = setMessageNum();
    }

    public static int getMessageNum() {
        return messageNum;
    }

    private static int setMessageNum() {
        MysqlBase mysqlBase = MysqlBase.getMysqlBase();
        SqlSession session = mysqlBase.getSession();
        int integer = session.selectOne("message.message_select_all");
        return integer;
    }

    synchronized static public void addMessageNum(){
        messageNum++;
    }
}
