package com.IMS.dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert extends JFrame {
    String tableName;
    JTextField field[] = null;
    String a[] = null;
    Update update;
    public void setTableName(String s){
        tableName = s.trim();
    }
    public void setField(JTextField s[]){
        field = s;
    }
    public void setA(String e[]){
        a = e;
    }
    public Insert(){

    }
    public void Execute_Insert(int mark){
        String SQL;
        Connection conn = null;
        Statement ps = null;

        SQL = "insert "+tableName+"("+a[mark]+") values ("+field[mark].getText().toString()+")";
        JDBCUtil.getMysqlConn();
        try {
            ps = conn.createStatement();
            ps.execute(SQL);
            JDBCUtil.close(ps,conn);
            update = new Update();
            update.setTableName(tableName);
            update.setField(field);
            update.setA(a);
            update.Execute_Update(mark);
            JOptionPane.showMessageDialog(this,"添加成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
            for(int i=0;i<field.length;i++){
                field[i].setText(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
