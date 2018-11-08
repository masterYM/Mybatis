package com.jiagouedu.mapper;


import com.jiagouedu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
   @Results({
     @Result(property = "desc",column = "desc")
   })
  @Select("select id,username,age,phone,`desc` from user where id=#{id}")
   User selectUser(Integer id);

}
