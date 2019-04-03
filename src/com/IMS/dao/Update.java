package com.IMS.dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    String tableName;
    JTextField field[] = null;
    String a[] = null;
    public void setTableName(String s){
        tableName = s.trim();
    }
    public void setField(JTextField s[]){
        field = s;
    }
    public void setA(String e[]){
        a = e;
    }
    public Update(){

    }
    public void Execute_Update(int mark){
        String SQL[] = new String [a.length];
        Connection conn = null;
        Statement ps = null;
        for (int i=0;i<a.length;i++){
            if(i!=mark){
                SQL[i] = "update "+tableName+" set "+a[i]+" = "+field[i].getText().toString()+" where "+a[mark]+" ='"+field[mark].getText().toString()+"'";
            }
        }
        JDBCUtil.getMysqlConn();
        try {
            ps = conn.createStatement();
            for(int i=0;i<field.length;i++){
                if(i!=mark&&field[i].getText().toString().equals("")==false){
                    ps.executeUpdate(SQL[i]);
                }
            }
            JDBCUtil.close(ps,conn);
            for (int i=0;i<field.length;i++){
                field[i].setText(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
