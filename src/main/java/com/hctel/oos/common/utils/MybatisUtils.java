package com.hctel.oos.common.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class MybatisUtils {
    private static final Logger LOG = LoggerFactory.getLogger(MybatisUtils.class);
    private static SqlSessionFactory factory;

    public MybatisUtils() {
    }

    private static SqlSessionFactory getMybatisFactory() {
        InputStream is = null;
        is = MybatisUtils.class.getClassLoader().getResourceAsStream("mysql-mybatis-config.xml");
        factory = new SqlSessionFactoryBuilder().build(is);
        System.out.println("factory build success");
        return factory;
    }

    public static SqlSession createSqlSession() {
        return getMybatisFactory().openSession();
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

}
