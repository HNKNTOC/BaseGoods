package com.HalenDouglas.Client.GUI;

import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.BaseData.OnlineData.BaseSQL;
import com.HalenDouglas.Client.GUI.client.FrameGoodsEditor;
import com.HalenDouglas.Client.GUI.client.manager.FrameManager;
import com.HalenDouglas.Client.GUI.client.seller.FrameSeller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HNKNTOC on 23.07.2015.
 */
public class FrameLog extends JFrame {
    private JTextField txtFieldLog;
    private JPasswordField txtFieldPassword;
    private JLabel labAnnotation;
    public static String ip = "localhost";

    public FrameLog(){
        super("Вход");
    }

    public void go() {

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
        txtFieldLog = new JTextField("root");

        panelLog.setLayout(new BoxLayout(panelLog,BoxLayout.X_AXIS));


        panelLog.add(labLog);
        panelLog.add(txtFieldLog);

        panelMain.add(panelLog);

        /**
         * Пароль
         */
        JPanel panelPassworld = new JPanel();
        txtFieldPassword = new JPasswordField("test");
        JLabel labPassword = new JLabel("Пароль");

        panelPassworld.add(labPassword);
        panelPassworld.add(txtFieldPassword);

        panelPassworld.setLayout(new BoxLayout(panelPassworld,BoxLayout.X_AXIS));

        panelMain.add(panelPassworld);


        /**
         * Вход
         */
        JButton butLog = new JButton("Вход");
        butLog.addActionListener(new ClickLog());

        /**
         * Ip
         */
        JButton butIp = new JButton("Ip");
        butIp.addActionListener(new ClickIp());

        /**
         * PanelBut
         */
        JPanel panelBut = new JPanel();
        panelBut.setLayout(new GridLayout(1,2));
        add(BorderLayout.SOUTH, panelBut);

        panelBut.add(butLog);
        panelBut.add(butIp);




        setSize(250, 130);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Создает Base проверяет подключение и возвращает Base.
     * Если подключение не успешно то возврашает null.
     *
     * @param userName
     * @param password
     * @param ip
     * @return
     */
    private Base createBase(String userName, String password,String ip){

        System.out.println("Создание базы " + userName + " " + password + " " + ip);

        Base base = new BaseSQL(userName,password,"jdbc:mysql://"+ip+":3306");

        try {
            base.connectBase();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }

        return base;
    }


    /**
     * Получает базу из метода createBase
     */
    private class ClickLog implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Base base = createBase(txtFieldLog.getText(),new String(txtFieldPassword.getPassword()),ip);

            if(base==null) {
                return;
            }else {
                setVisible(false);
                dispose();
            }

            FrameGoodsEditor frameGoods;

            if(txtFieldLog.getText().equals("root")){
                frameGoods = new FrameManager(base);
            }else {
                frameGoods = new FrameSeller(base);
            }
            frameGoods.start();
        }
    }

    private class ClickIp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameIp frameIp = new FrameIp();
            frameIp.go();
        }
    }
}
