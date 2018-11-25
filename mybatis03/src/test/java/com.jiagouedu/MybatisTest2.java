package com.jiagouedu;

import com.jiagouedu.mapper.ProductMapper;
import com.jiagouedu.mapper.ProductMapper1;
import com.jiagouedu.mapper.UserMapper;
import com.jiagouedu.pojo.Product;
import com.jiagouedu.pojo.User;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-mybatis.xml"})
@Slf4j
public class MybatisTest2 {
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private ProductMapper productMapper;
  @Autowired
  private ProductMapper1 productMapper1;
  @Test
  public void testUserMapper() {
    User selectUser = userMapper.selectUser(1);
    log.error("user:{}",selectUser);
    System.err.println(selectUser);
  }

  @Test
  public void testList1() {//实体类含有list的
    Product product = productMapper.queryProductInfo(1);
    log.info("--------------------------Product{}",product);
    System.err.println(product);
  }

  @Test
  public void testList(){//实体类含有list的
    Product product = productMapper1.queryProductInfo(1);
    log.info("--------------------------Product{}",product);
    System.err.println(product);
  }
}
