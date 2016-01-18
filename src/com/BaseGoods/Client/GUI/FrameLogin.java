package com.BaseGoods.Client.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by HNKNTOC on 23.07.2015.
 */
public class FrameLogin extends JFrame {
    private JTextField txtFieldLog;
    private JPasswordField txtFieldPassword;

    private JButton butLog;
    private JButton butSetting;

    private JLabel labAnnotation;
    public static String ip = "localhost";

    public FrameLogin(){
        super("Вход");

        txtFieldLog = new JTextField("root");
        txtFieldPassword = new JPasswordField("test");

        butSetting = new JButton("Setting");
        butLog = new JButton("Вход");
    }

    public void start() {

        JPanel panelMain = new JPanel();

        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        add(BorderLayout.CENTER, panelMain);

        labAnnotation = new JLabel("Пожалуйста введите логин и пароль.");
        add(BorderLayout.NORTH, labAnnotation);

        /**
         * Логин
         */
        JPanel panelLog = new JPanel();
        JLabel labLog = new JLabel("Логин");

        panelLog.setLayout(new BoxLayout(panelLog,BoxLayout.X_AXIS));


        panelLog.add(labLog);
        panelLog.add(txtFieldLog);

        panelMain.add(panelLog);

        /**
         * Пароль
         */
        JPanel panelPassworld = new JPanel();
        JLabel labPassword = new JLabel("Пароль");

        panelPassworld.add(labPassword);
        panelPassworld.add(txtFieldPassword);

        panelPassworld.setLayout(new BoxLayout(panelPassworld, BoxLayout.X_AXIS));

        panelMain.add(panelPassworld);


        /**
         * PanelBut
         */
        JPanel panelBut = new JPanel();
        panelBut.setLayout(new GridLayout(1,2));
        add(BorderLayout.SOUTH, panelBut);

        panelBut.add(butLog);
        panelBut.add(butSetting);




        setSize(250, 130);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addListenerLog(ActionListener listener){
        butLog.addActionListener(listener);
    }

    public void addListenerSeting(ActionListener listener){
        butSetting.addActionListener(listener);
    }

    public String getUserName(){
        return txtFieldLog.getText();
    }

    public String getUserPassword(){
        return new String(txtFieldPassword.getPassword());
    }

}
