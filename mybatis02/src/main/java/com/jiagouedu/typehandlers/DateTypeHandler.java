package com.jiagouedu.typehandlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

/**
 * 将JDBC的timestamp类型与Date类型互相转换的类型处理器
 *
 * 一般要实现org.apache.ibatis.type.TypeHandler,也可以继承mybatis 的 BaseTypeHandler。
 */
public class DateTypeHandler implements TypeHandler<Date> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {
        //指定传入的Java参数对应JDBC中的数据库类型
        System.out.println("其他逻辑");
        ps.setDate(i,date);
        System.out.println("其他逻辑");
    }

    @Override
    public Date getResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("其他逻辑");

        return resultSet.getDate(s);
    }

    @Override
    public Date getResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("其他逻辑");
        return resultSet.getDate(i);
    }

    @Override
    public Date getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }
}
