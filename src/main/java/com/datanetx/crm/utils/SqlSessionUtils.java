package com.datanetx.crm.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    //防止工具类被new
    private SqlSessionUtils(){}

    /**
     * 根据mybatis-config.xml取得一个SqlSessionFactory对象
     */
    private static SqlSessionFactory sqlSessionFactory;
    //代码放静态代码块中是为了让代码只在第一次调用SqlSessionUtils工具类时执行一次，没必须每次调用都创建sqlSessionFactory
    static {
        String resource="mybatis-config.xml";
        InputStream inputStream= null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }


    /**
     * 取得一个SqlSession对象
     * @return SqlSession对象
     */
    private static ThreadLocal<SqlSession> t=new ThreadLocal<>();
    public static SqlSession getSession(){
        SqlSession session=t.get();
        if(session==null){
            session=sqlSessionFactory.openSession();
            t.set(session);
        }
        return session;
    }

    /**
     * 关闭SqlSession对象
     */
    public static void closeSession(SqlSession session){
        if(session!=null){
            session.close();
            t.remove();
        }
    }
}
