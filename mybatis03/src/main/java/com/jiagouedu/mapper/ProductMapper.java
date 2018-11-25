package com.jiagouedu.mapper;


import com.jiagouedu.pojo.Product;
import com.jiagouedu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {

   Product queryProductInfo(Integer id);

}
