package com.IMS.dao;

import java.sql.*;

public class Query {
    Object a[][];
    String b[];
    String tableName;
    int count;
    Query(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    //获取表的内容
    public Object[][] getRecord(){
        a = null;
        b = null;
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getMysqlConn();
            int colcount = getCount();
            int n = getAmount();
            a = new Object[n][colcount];
            ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery("select * from "+tableName);
            int m = 0;
            while (rs.next()){
                for (int k=1;k<=colcount;k++){
                    a[m][k-1] = rs.getString(k);
                }
                System.out.println();
                m++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           JDBCUtil.close(rs,ps,conn);
        }

        return a;
    }

    //获取表内容有多少行
    public int getAmount(){
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getMysqlConn();
            ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery("SELECT * from "+tableName);
            rs.last();
            int rows = rs.getRow();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //获取字段名称
    public String[] getField(){
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getMysqlConn();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getColumns(null,null,tableName,null);
            int colcount = getCount();
            b = new String[colcount];
            int k = 0;
            while (rs.next()){
                b[k] = rs.getString(4);
                k++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        return b;

    }

    //初试表名
    public void setTableName(String s){

        tableName = s.trim();
    }

    //获取字段个数
    public int getCount(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getMysqlConn();
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getColumns(null,null,tableName,null);
            count = 0;
            while(rs.next()){
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        return count;
    }
}
