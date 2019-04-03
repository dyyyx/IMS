package com.IMS.dao;

import java.sql.*;

public class BaseDao {
    //创建驱动
    private final String driver = "com.mysql.jdbc.Driver";
    //连接url
    private final String url = "jdbc:mysql://localhost:3305/sorm";
    //登录mysql的用户名
    private final String name = "root";
    //登录mysql的密码
    private final String pwd = "123456";

    //创建连接
    public Connection getConn(){
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,name,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //创建关闭方法
    public void close(ResultSet rs, PreparedStatement ps, Connection conn){
        try {
            if (rs!=null){
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
