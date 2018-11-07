package com.jiagouedu.session;


import com.jiagouedu.executor.SimpleExecutor;

public class SqlSessionFactory {



  public SqlSession openSession(Configuration configuration) {
    return  new DefaultSqlSession(configuration,new SimpleExecutor(configuration));
  }

}
