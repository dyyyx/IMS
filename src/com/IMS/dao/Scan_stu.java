package com.IMS.dao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scan_stu extends JPanel implements ActionListener {
    DefaultTableModel update_table;
    JTable table;
    Query query;
    JButton button;
    Object a[][];
    String b[];
    Scan_stu(){
        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);
        query = new Query();
        query.setTableName("stu");
        a = query.getRecord();
        b = query.getField();
        update_table = new DefaultTableModel(a,b);
        table = new JTable(update_table);
        button = new JButton("更新");
        button.addActionListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,0,800,500);
        //表格出现滑动条
        table.setPreferredSize(new Dimension(scrollPane.getWidth()-50,scrollPane.getHeight()*3));
        add(scrollPane);
        add(button);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        a = null;
        b = null;
        query = new Query();
        query.setTableName("stu");
        a = query.getRecord();
        b = query.getField();
        update_table.setDataVector(a,b);
    }
}
