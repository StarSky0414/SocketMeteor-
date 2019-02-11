package db.mysql.provider;

import db.mysql.MysqlBase;
import org.apache.ibatis.session.SqlSession;

public abstract class MysqlProviderBase {
    protected final SqlSession mysqlBaseSession;

    public MysqlProviderBase(){
        MysqlBase mysqlBase = MysqlBase.getMysqlBase();
        mysqlBaseSession = mysqlBase.getSession();
    }

    protected void commit(){
        mysqlBaseSession.commit();
        mysqlBaseSession.close();
    }
}
