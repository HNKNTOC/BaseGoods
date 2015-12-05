package com.HalenDouglas.Client.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HNKNTOC on 01.09.2015.
 */
public class FrameIp extends JFrame {
    JTextField jTextField;
    public void go(){

        jTextField = new JTextField();
        JButton button = new JButton("Ok");
        button.addActionListener(new ClickOk());

        setLayout(new GridLayout(2,1));
        add(jTextField);
        add(button);

        setSize(300, 90);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class ClickOk implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameLog.ip=jTextField.getText();

            setVisible(false);
            dispose();
        }
    }

}
