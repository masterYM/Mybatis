package com.jiagouedu.statement;

import com.jiagouedu.binding.MapperMethod;

import com.jiagouedu.result.DefaultResultSetHandler;
import com.jiagouedu.result.ResultSetHandler;
import com.jiagouedu.session.Configuration;
import com.jiagouedu.util.DbUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StatementHandler {
  private Configuration configuration;

  private ResultSetHandler resultSetHandler;

  public StatementHandler() {
  }

  public StatementHandler(Configuration configuration) {
    this.configuration = configuration;
    resultSetHandler=new DefaultResultSetHandler();
  }
  public <T> T query(MapperMethod method, Object parameter) throws Exception {

    Connection connection= DbUtil.open();
    PreparedStatement preparedStatement = connection.prepareStatement(String.format(method.getSql(), Integer.parseInt(String
           .valueOf(parameter))));
    preparedStatement.execute();
    return  resultSetHandler.handle(preparedStatement,method);
  }
}
