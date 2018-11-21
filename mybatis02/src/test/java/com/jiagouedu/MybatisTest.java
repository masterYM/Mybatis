package com.jiagouedu;
import com.jiagouedu.objectfactory.CartObjectFactory;
import com.jiagouedu.pojo.ShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

  @Test
  public void ObjectFactoryTest() throws IOException {
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    CartObjectFactory e = new CartObjectFactory();
    //设置参数类型list和参数值List
    List constructorArgTypes = new ArrayList();
    constructorArgTypes.add(int.class);
    constructorArgTypes.add(String.class);
    constructorArgTypes.add(int.class);
    constructorArgTypes.add(double.class);
    constructorArgTypes.add(double.class);

    List constructorArgs = new ArrayList();
    constructorArgs.add(1);//productId
    constructorArgs.add("牙刷");//productName
    constructorArgs.add(5);//number
    constructorArgs.add(4.0);//price
    constructorArgs.add(0.0);//totalAmount

    ShoppingCart sCart = e.create(ShoppingCart.class,constructorArgTypes,constructorArgs);
    System.out.println(sCart.getTotalAmount());
    sqlSession.close();

  }
}




















