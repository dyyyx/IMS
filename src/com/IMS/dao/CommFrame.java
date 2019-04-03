package com.IMS.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommFrame extends JFrame implements ActionListener {
    JMenuBar bar;
    JMenu menu;
    JMenuItem scanItem,searchItem,deleteItem,updateItem,insertItem;
    Scan_stu scan;//查看所有学生信息
    Delete_stu delete;//删除学生信息
    Update_stu update;//更新学生信息
    Insert_stu insert;//插入学生信息
    Search_stu search;//查找学生信息

    CardLayout card = null;
    JPanel p;

    CommFrame(){
        setLayout(new FlowLayout());
        scanItem = new JMenuItem("浏览");
        deleteItem = new JMenuItem("删除");
        updateItem = new JMenuItem("更新");
        insertItem = new JMenuItem("添加");
        searchItem = new JMenuItem("查找");
        bar = new JMenuBar();
        menu = new JMenu("菜单");
        menu.add(scanItem);
        menu.add(searchItem);
        menu.add(deleteItem);
        menu.add(updateItem);
        menu.add(insertItem);
        bar.add(menu);
        setJMenuBar(bar);
        scanItem.addActionListener(this);
        searchItem.addActionListener(this);
        deleteItem.addActionListener(this);
        updateItem.addActionListener(this);
        insertItem.addActionListener(this);
        scan = new Scan_stu();
        search = new Search_stu();
        delete = new Delete_stu();
        update = new Update_stu();
        insert = new Insert_stu();
        card = new CardLayout();
        p = new JPanel(card);
        p.setLayout(card);
        p.add("scanItem",scan);
        p.add("deleteItem",delete);
        p.add("updateItem",update);
        p.add("insertItem",insert);
        p.add("searchItem",search);
        add(p,BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(400,150,1000,800);
        setTitle("学生信息管理系统");
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==scanItem){
            card.show(p,"scanItem");
        }else if(e.getSource()==searchItem){
            card.show(p,"searchItem");
        }else if(e.getSource()==deleteItem){
            card.show(p,"deleteItem");
        }else if(e.getSource()==updateItem){
            card.show(p,"updateItem");
        }else if(e.getSource()==insertItem){
            card.show(p,"insertItem");
        }
    }
}
