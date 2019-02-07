package db.mysql;

import db.mysql.entity.TrendsEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MysqlBaseTest {

    @Test
    public void testQuery(){
//        MysqlBase.init();
//        MysqlBase mysqlBase = MysqlBase.getMysqlBase();
//        SqlSession session = mysqlBase.getSession();
//        BlogMapper mapper = session.getMapper(BlogMapper.class);
//        Integer integer = mapper.selectBlog(1);
//        System.out.println(integer);
    }

    @Test
    public void testMyBatisXmlUsed(){
        Logger logger = Logger.getLogger("logTest1");
//        logger.config("");
        MysqlBase.init();
        MysqlBase mysqlBase = MysqlBase.getMysqlBase();
        SqlSession session = mysqlBase.getSession();

        TrendsEntity trendsEntity1 = new TrendsEntity();
        trendsEntity1.setId(10);
//        trendsEntity1.setUrl("url://xxxxx.xxxx.xxxx");

        List<TrendsEntity> trendsEntityMap = session.selectList("trends.trendsAll",trendsEntity1);
//        for(HashMap.Entry trendsEntity : trendsEntityMap.entrySet()){
//            System.out.println("key: "+trendsEntity.getKey() +"      value"+trendsEntity.getValue());
//        }
        for (TrendsEntity trendsEntity: trendsEntityMap){
            System.out.println(trendsEntity.toString());
        }
    }

}