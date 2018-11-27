package com.jiagouedu;

import com.jiagouedu.mapper.CustomerMapper;
import com.jiagouedu.mapper.ProductMapper;
import com.jiagouedu.mapper.ProductMapper1;
import com.jiagouedu.mapper.UserMapper;
import com.jiagouedu.pojo.*;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.List;

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
  @Autowired
  private CustomerMapper customerMapper;

  @Test
  public void testBatchCustomerToMap() throws Exception{

    //调用userMapper的方法
    List<BatchItem> bcList=customerMapper.findBatchCustomerToMap(1);
    if(bcList!=null){
      BatchItem batchItem = null;
      Customer customer = null;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      for (int i = 0; i < bcList.size(); i++) {
        batchItem = bcList.get(i);//取出批次对象
        customer = batchItem.getCustomer();//取出该批次的用户信息
        System.out.println("卡号为"+customer.getAcno()+"的名为"
                +customer.getUsername()+"的客户:\n于"
                +sdf.format(batchItem.getCreatetime())+"采购了批次号为"
                +batchItem.getNumber()+"的一批理财产品");
      }
    }
  }
  @Test
  public void testBatchCustomer() throws Exception{
    //调用userMapper的方法
    List<BatchCustomer> bcList = customerMapper.findBatchCustomer(1);
    if(bcList!=null){
      BatchCustomer batchCustomer;
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      for (int i = 0; i < bcList.size(); i++) {
        batchCustomer = bcList.get(i);
        System.out.println("卡号为"+batchCustomer.getAcno()+"的名为"
                +batchCustomer.getUsername()+"的客户:\n于"
                +sdf.format(batchCustomer.getCreatetime())+"采购了批次号为"
                +batchCustomer.getNumber()+"的一批理财产品");
      }
    }
  }

  @Test
  public void testUserMapper() {
    User selectUser = userMapper.selectUser(1);
    log.error("user:{}",selectUser);

    System.err.println(selectUser);
  }

  @Test
  public void testList1() {//实体类含有list的
    Product product = productMapper.queryProductInfo(1);
    log.info("--------------------------Product{}",product.getPname());
    List<Reply> replies = product.getReplys();
    for(Reply reply : replies){
      log.info("--------------------------{}",reply.getInfo() + "------------" + reply.getUsername());
    }
    System.err.println(product);
  }

  @Test
  public void testList(){//实体类含有list的
    Product product = productMapper1.queryProductInfo(1);
    log.info("--------------------------Product{}",product);
    List<Reply> replies = product.getReplys();
    for(Reply reply : replies){
      log.info("--------------------------{}",reply.getInfo() + "------------" + reply.getUsername());
    }
    System.err.println(product);
  }
}
