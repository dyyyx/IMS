package com.IMS.dao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new LoginFrame();
    }
    Box box1,box2,basebox;
    JLabel username,userpwd,tubiao,username1,userpwd1;
    JTextField nameField,nameField1;
    JPasswordField pwdField,pwdField1;
    JButton button;
    JTabbedPane choose;
    JPanel panel1,panel2;

    LoginFrame(){
        setBackground(Color.gray);
        tubiao = new JLabel(new ImageIcon("C:/Users/97973/Desktop/11/BJ0.jpg"));
        add(tubiao,BorderLayout.NORTH);
        username = new JLabel("账号：",JLabel.CENTER);
        userpwd = new JLabel("密码：",JLabel.CENTER);
        username1 = new JLabel("账号：",JLabel.CENTER);
        userpwd1 = new JLabel("密码：",JLabel.CENTER);
        //账号密码的长度为10位
        nameField = new JTextField(10);
        pwdField = new JPasswordField(12);
        nameField1 = new JTextField(10);
        pwdField1 = new JPasswordField(12);
        panel1 = new JPanel();
        panel2 = new JPanel();
        choose = new JTabbedPane();
        panel1.setLayout(new GridLayout(2,2));
        panel1.add(username);
        panel1.add(nameField);
        panel1.add(userpwd);
        panel1.add(pwdField);
        panel2.setLayout(new GridLayout(2,2));
        panel2.add(username1);
        panel2.add(nameField1);
        panel2.add(userpwd1);
        panel2.add(pwdField1);
        choose.addTab("学生登录：",panel1);
        choose.addTab("教师登录：",panel2);
        add(choose,BorderLayout.CENTER);
        button = new JButton("登录");
        add(button,BorderLayout.SOUTH);
        button.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(400,150,600,300);
        setTitle("登录界面");
        validate();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String stuname, stupwd;
        stuname = nameField.getText();
        stupwd = pwdField.getText();
        Connection conn = null;
        Statement ps = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtil.getMysqlConn();
            ps = conn.createStatement();
            rs = ps.executeQuery("select * from login where stuname ='"+stuname+"' and stupwd='"+stupwd+"'");
            int q = 0;
            while (rs.next()){
                q++;
            }
            if(q>0){
                JOptionPane.showMessageDialog(this,"登录成功！","消息对话框",JOptionPane.WARNING_MESSAGE);
                this.dispose();
                new CommFrame();
            }else{
                JOptionPane.showMessageDialog(this,"账号或者密码错误！","消息对话框",JOptionPane.WARNING_MESSAGE);

            }
        } catch (SQLException e1) {
            System.out.println(e1);
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }

    }
}
