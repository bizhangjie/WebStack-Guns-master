package com.jsnjfz.manage.modular.api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;


public class jisuanqi extends Frame {

    public static void main(String[] args) {
        JFrame c=new JFrame("Computer");
        c.setLayout(new java.awt.FlowLayout());//设置布局
        c.setBounds(400, 400, 500, 150);//确定窗口位置和大小
        c.setResizable(false);
        //菜单项
        JMenuBar menubar= new JMenuBar();
        c.setJMenuBar(menubar);
        JMenu Operation=new JMenu("Operation");
        JMenuItem Exit=new JMenuItem("Exit");
        JMenuItem add=new JMenuItem("Add");
        add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
        JMenuItem sub=new JMenuItem("Subtract");
        sub.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        JMenuItem mul=new JMenuItem("Multiple");
        mul.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
        JMenuItem div=new JMenuItem("Divide");
        div.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
        menubar.add(Operation);
        menubar.add(Exit);
        Operation.add(add);
        Operation.add(sub);
        Operation.add(mul);
        Operation.add(div);
        //主页面

        //文本框和加减乘除按钮
        JTextField num1=new JTextField(6);
        JTextField num2=new JTextField(6);
        JTextArea res=new JTextArea(1,10);
        JButton Badd=new JButton("Add");
        JButton Bsub=new JButton("Subtract");
        JButton Bmul=new JButton("Multiple");
        JButton Bdiv=new JButton("Divide");
        c.add(new JLabel("Number1"));
        c.add(num1);
        c.add(new JLabel("Number2"));
        c.add(num2);
        c.add(new JLabel("Result"));
        c.add(res);
        c.add(Badd);
        c.add(Bsub);
        c.add(Bmul);
        c.add(Bdiv);
        res.setEditable(false);

        //添加监听器
        Badd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    double result=0;
                    result=number1+number2;
                    String str=new String();
                    res.append(str=""+result);
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }

            }
        });

        Bsub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    double result=0;
                    result=number1-number2;
                    String str;
                    res.append(str=""+result);
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }
            }
        });

        Bmul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    double result=0;
                    result=number1*number2;
                    String str=new String();
                    res.append(str=""+result);
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }

            }
        });

        Bdiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    if(number2==0)
                    {
                        res.append("ERROR");
                    }
                    else {
                        double result=0;
                        result=number1/number2;
                        String str=new String();
                        res.append(str=""+result);
                    }
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }

            }
        });

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    double result=0;
                    result=number1+number2;
                    String str=new String();
                    res.append(str=""+result);
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }

            }
        });

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    double result=0;
                    result=number1-number2;
                    String str;
                    res.append(str=""+result);
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }
            }
        });

        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    double result=0;
                    result=number1*number2;
                    String str=new String();
                    res.append(str=""+result);
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }
            }
        });

        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    res.setText("");
                    double number1=Double.parseDouble(num1.getText());
                    double number2=Double.parseDouble(num2.getText());
                    if(number2==0)
                    {
                        res.append("ERROR");
                    }
                    else {
                        double result=0;
                        result=number1/number2;
                        String str=new String();
                        res.append(str=""+result);
                    }
                }
                catch(Exception exp){
                    res.append("请输入数字字符");
                }
            }
        });

        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        c.setVisible(true);
    }
}