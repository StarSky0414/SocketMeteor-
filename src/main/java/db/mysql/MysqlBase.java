package db.mysql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 *  MyBatis 初始化
 *  配置文件读取
 */
public class MysqlBase extends ClassLoader {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     *  初始化数据库 读取 MyBatis 配置文件
     */
    public static void init() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     *  工厂模式，禁止用户创建对象
     */
    private MysqlBase() {
    }

    public static MysqlBase getMysqlBase() {
        return new MysqlBase();
    }

    public SqlSession getSession() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

}
