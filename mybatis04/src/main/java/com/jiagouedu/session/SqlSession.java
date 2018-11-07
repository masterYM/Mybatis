package com.jiagouedu.session;

import com.jiagouedu.binding.MapperMethod;

import java.sql.SQLException;

public interface SqlSession {
  <T> T selectOne(MapperMethod mapperMethod, Object statement) throws Exception;

}
