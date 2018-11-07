package com.jiagouedu.executor;

import com.jiagouedu.binding.MapperMethod;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface Executor {

  <T> T query(MapperMethod method, Object parameter) throws Exception;
}
