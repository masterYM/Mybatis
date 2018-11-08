package com.jiagouedu.com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/***
 * 非对象
 */
public class Jdbc01 {

  public static void main(String[] args) {

    insert("好强",18,"18875021111","很帅");
  }

  static void insert(String name,int age,String phone,String desc)
  {
    String sql="insert into user(username,age,phone) value(?,?,?)";
    Connection conn=DbUtil.open();
    try {
      PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql);
      pstmt.setString(1,name);
      pstmt.setInt(2,age);
      pstmt.setString(3,phone);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    finally {
      DbUtil.close(conn);
    }

  }


}
