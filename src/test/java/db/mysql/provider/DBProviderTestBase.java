package db.mysql.provider;

import db.mysql.MysqlBase;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class DBProviderTestBase {

    protected Log logger;


    @BeforeEach
    public void superInit(){
        logger = LogFactory.getLog(this.getClass().toString());
        MysqlBase.init();
        init();
    }

    abstract void init();
}
