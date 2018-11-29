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
  public void testfindCustomerAndProducts() throws Exception{

    //调用userMapper的方法，获取所有用户信息(以及从属批次信息)
    List<Customer> customerList=customerMapper.findUserAndProducts(1);
    if(customerList!=null){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Customer customer = null;
      for (int i = 0; i < customerList.size(); i++) {
        customer = customerList.get(i);
        //1.获取用户基本信息
        System.out.println("卡号为"+customer.getAcno()+"的名为"
                +customer.getUsername()+"的客户:");
        //2.获取用户下的所有批次订单信息
        List<Batch> batchList=customer.getBatchList();
        Batch batch = null;
        for (int j = 0; j < batchList.size(); j++) {
          batch = batchList.get(j);
          System.out.println("于"
                  +sdf.format(batch.getCreatetime())+"采购了批次号为"
                  +batch.getNumber()+"的一批理财产品，详情如下：");
          //3.获取一个批次的明细
          List<BatchDetail> batchDetails = batch.getBatchDetials();
          BatchDetail batchDetail = null;
          FinacialProduct finacialProduct = null;
          for (int k = 0; k < batchDetails.size(); k++) {
            batchDetail = batchDetails.get(k);
            System.out.println("id为"+batchDetail.getProduct_id()
                    +"的理财产品"+batchDetail.getProduct_num()+"份。");
            //4.获取每个批次明细中的理财产品详细信息
            finacialProduct = batchDetail.getFinacialProduct();
            System.out.println("该理财产品的详细信息为：\n"
                    +"产品名称:"+finacialProduct.getName()
                    +"|产品价格:"+finacialProduct.getPrice()
                    +"|产品简介:"+finacialProduct.getDetail());
          }
        }
        System.out.println("**************************************");
      }

    }
  }

  @Test
  public void testfindBatchAndBatchDetail() throws Exception{

    //调用userMapper的方法
    BatchItem batchItem=customerMapper.findBatchAndBatchDetail(1);
    if(batchItem!=null){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Customer customer = batchItem.getCustomer();//取出该批次的用户信息
      //取出该批次订购的理财产品信息
      List<BatchDetail> batchDetails = batchItem.getBatchDetails();
      System.out.println("卡号为"+customer.getAcno()+"的名为"
              +customer.getUsername()+"的客户:\n于"
              +sdf.format(batchItem.getCreatetime())+"采购了批次号为"
              +batchItem.getNumber()+"的一批理财产品，详情如下：");
      BatchDetail batchDetail = null;
      if(batchDetails!=null){
        for (int i = 0; i < batchDetails.size(); i++) {
          batchDetail = batchDetails.get(i);
          System.out.println("id为"+batchDetail.getProduct_id()
                  +"的理财产品"+batchDetail.getProduct_num()+"份");
        }

      }

    }
  }

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
