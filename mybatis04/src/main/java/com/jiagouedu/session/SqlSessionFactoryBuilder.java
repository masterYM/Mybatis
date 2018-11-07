package com.jiagouedu.session;


import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryBuilder {

  public SqlSessionFactory build(Configuration configuration) throws IOException {
    configuration.loadConfigurations();
    return  new SqlSessionFactory();
  }

}
