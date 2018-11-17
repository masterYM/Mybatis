package com.jiagouedu;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
@Slf4j
public class MybatisTest {

  //一级缓存
  @Test
  public void test() throws IOException {

    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    log.info("user1：{}", (Object) sqlSession.selectOne("com.jiagouedu.mybatis.UserMapper.selectUser", 3));
    log.info("user2：{}", (Throwable) sqlSession.selectOne("com.jiagouedu.mybatis.UserMapper.selectUser", 3));
    sqlSession.commit();
    log.info("user3：{}", java.util.Optional.ofNullable(sqlSession.selectOne("com.jiagouedu.mybatis.UserMapper.selectUser", 3)));
    log.info("user4：{}", java.util.Optional.ofNullable(sqlSession.selectOne("com.jiagouedu.mybatis.UserMapper.selectUser", 3)));
  }
}
