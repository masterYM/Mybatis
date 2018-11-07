package com.jiagouedu.com;

import com.jiagouedu.mybatis.mapper.UserMapper;
import com.jiagouedu.mybatis.pojo.User;
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

  @Test
  public void test() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    User user = sqlSession.selectOne("com.jiagouedu.mybatis.UserMapper.selectUser", 1);
   log.info("user:{}",user);

  }

  @Test
  public void test2() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
   // User user = sqlSession.selectOne("com.jiagouedu.mybatis.UserMapper.selectUser", 1);
    User user = mapper.selectUser(1);
    log.info("user:{}",user);

  }

  @Test
  public void test3() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//    UserExample userExample = new UserExample();
//    UserExample.Criteria criteria = userExample.createCriteria();
//    criteria.andIdEqualTo(1L);
//    List<User> userList = mapper.selectByExample(userExample);
//    log.info("user:{}",userList.get(0));

  }
}


