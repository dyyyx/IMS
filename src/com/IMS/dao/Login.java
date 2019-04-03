package com.IMS.dao;

import javax.swing.*;
import java.awt.*;

public class Login {
    public static void main(String[] args) {
        Login login = new Login();
        login.initUI();
    }

    /**
     * 在该类中定义初始化登录界面的方法
     */
    public void initUI(){

        JFrame frame = new JFrame();
        //设置窗体对象的属性值：标题、大小、显示位置、关闭操作、布局、禁止调整大小
        frame.setTitle("登陆界面");//设置窗体标题
        frame.setSize(400,500);//设置窗体大小
        frame.setDefaultCloseOperation(3);//设置窗体关闭操作：3表示关闭窗体退出程序
        frame.setLocationRelativeTo(null);//设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);//禁止调整窗体大小

        //实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐，组件之间的间隔为5个像素
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,10,10);
        //实例化流式布局类的对象
        frame.setLayout(fl);

        //实例化元素组件对象添加到窗体上（组件添加要在窗体可见之前完成）
        //实例化ImageIcon图标类的对象，该对象加载磁盘上的图片文件到内存
        ImageIcon icon = new ImageIcon("C:/Users/97973/Desktop/11/BJ0.jpg");
        //用标签来接收图片，实例化JLable标签对象，该对象显示icon图标
        JLabel labIcon = new JLabel(icon);
        //设置标签大小
        Dimension dim = new Dimension(400,300);
        labIcon.setPreferredSize(dim);
        //将LabIcon标签添加到窗体上
        frame.add(labIcon);

        //实例化JLabel标签对象，该对象显示“账号：”
        JLabel labName = new JLabel("账号：");
        //将LabName添加到窗体上
        frame.add(labName);

        //实例化JTextField标签对象
        JTextField tn = new JTextField();
        Dimension dim1 = new Dimension(300,30);
        tn.setPreferredSize(dim1);
        //将textName添加到窗体上
        frame.add(tn);

        //实例化JLable标签对象，该对象显示“密码：”
        JLabel labpwd = new JLabel("密码：");
        frame.add(labpwd);
        //实例化JPasswordField
        JPasswordField tw = new JPasswordField();
        //设置大小
        tw.setPreferredSize(dim1);
        frame.add(tw);

        //实例化JButton组件
        JButton button = new JButton();
        //设置按钮的显示内容
        Dimension dim2 = new Dimension(100,30);
        button.setText("登录");
        //设置按钮大小
        button.setSize(dim2);
        frame.add(button);

        //实例化JRadioButton单选框组件
        JRadioButton jrb1 = new JRadioButton("学生登录");
        JRadioButton jrb2 = new JRadioButton("教师登录");
        JRadioButton jrb3 = new JRadioButton("管理员登录");
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        frame.add(jrb1);
        frame.add(jrb2);
        frame.add(jrb3);

        //设置窗体可见
        frame.setVisible(true);
    }
}
