package com.IMS.dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete extends JFrame {
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
    public Delete(){

    }
    public void Execute_Delete(int n){
        String SQL = "";
        Connection conn = null;
        Statement ps = null;
        SQL = "delete from "+tableName+" where "+a[n]+" = '"+field[n].getText().toString()+"'";
        JDBCUtil.getMysqlConn();
        try {
            ps = conn.createStatement();
            ps.executeUpdate(SQL);
            JDBCUtil.close(ps,conn);
            JOptionPane.showMessageDialog(this,"删除成功","消息对话框",JOptionPane.WARNING_MESSAGE);
            for(int i=0;i<field.length;i++){
                field[i].setText(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
