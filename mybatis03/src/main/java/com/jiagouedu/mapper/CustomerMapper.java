package com.jiagouedu.mapper;


import com.jiagouedu.pojo.BatchCustomer;
import com.jiagouedu.pojo.BatchItem;
import com.jiagouedu.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CustomerMapper {
     Customer findCustomerById(int id) throws Exception;


    List<BatchCustomer> findBatchCustomer(int id) throws Exception;
    List<BatchItem> findBatchCustomerToMap(int id) throws Exception;
    BatchItem findBatchAndBatchDetail(int id) throws Exception;
    List<Customer> findUserAndProducts(int id) throws Exception;


     void insertCustomer(Customer customer) throws Exception;
      

     void deleteCustomer(int id) throws Exception;
      

     void updateCustomerAcNo(Customer customer) throws Exception;
}
