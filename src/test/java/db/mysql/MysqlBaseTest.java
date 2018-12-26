package db.mysql;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MysqlBaseTest {

    @Test
    public void testQuery(){
        MysqlBase.init();
        MysqlBase mysqlBase = MysqlBase.getMysqlBase();
        SqlSession session = mysqlBase.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Integer integer = mapper.selectBlog(1);
        System.out.println(integer);
    }

}