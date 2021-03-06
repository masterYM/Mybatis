package com.jiagouedu.result;

import com.jiagouedu.binding.MapperMethod;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ResultSetHandler {

  <T> T handle(PreparedStatement pstmt, MapperMethod mapperMethod) throws Exception;
}
