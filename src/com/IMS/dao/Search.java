package com.IMS.dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search extends JFrame {
    String tableName;
    JTextField field[] = null;
    String a[] = null;
    Object object[][];
    String b[];
    public void setTableName(String s){
        tableName = s.trim();
    }
    public void setField(JTextField s[]){
        field = s;
    }
    public void setA(String e[]){
        a = e;
    }
    public Search(){

    }
    public void Exeute_Search(){
        String sql = "select * from "+tableName+" where";
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;
        int sum = 0;
        for (int i=0;i<a.length;i++){
            if (field[i].getText().toString()!=null){
                if(sum==0){
                    sql = sql+a[i]+" = '"+field[i].getText().toString()+"'";

                }else{
                    sql = sql+" and "+a[i]+" = "+field[i].getText().toString()+"'";
                }
                sum++;
            }
        }
        try {
            JDBCUtil.getMysqlConn();
            ps = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.TYPE_FORWARD_ONLY);
            rs = ps.executeQuery(sql);
            rs.last();
            object = new Object[rs.getRow()][a.length];
            rs.beforeFirst();
            int ncase = 0;
            while(rs.next()){
                for(int i=1;i<=a.length;i++){
                    object[ncase][i-1] = rs.getString(i);
                }
                ncase++;
            }
            for (int i=0;i<field.length;i++){
                field[i].setText(null);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }
    }
    public Object[][] getRecord(){
        return object;
    }

}
