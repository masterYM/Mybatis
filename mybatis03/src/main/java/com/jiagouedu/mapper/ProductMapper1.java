package com.jiagouedu.mapper;


import com.jiagouedu.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper1 {

   Product queryProductInfo(Integer id);

}
