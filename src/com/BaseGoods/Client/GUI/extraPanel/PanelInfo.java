package com.BaseGoods.Client.GUI.extraPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HNKNTOC on 10.08.2015.
 */
public class PanelInfo extends JPanel {

    private String namePanel;

    private JPanel panelTxt = new JPanel();
    private JPanel panelButton = new JPanel();

    private ArrayList<JLabel> listLabel = new ArrayList<>();
    private ArrayList<JButton> listButton = new ArrayList<>();

    public PanelInfo(String namePanel,int quantityLabel,int quantityButton) {

        /**
         * Заполнение
         */
        for(;quantityLabel>0;quantityLabel--)listLabel.add(new JLabel("Тест"));
        for(;quantityButton>0;quantityButton--)listButton.add(new JButton("Тест"));

        this.namePanel=namePanel;
        goGui();
    }

    public void goGui(){

        for (JLabel label:listLabel) {
            System.out.println("Add label");
            panelTxt.add(label);
        }

        for (JButton button:listButton) {
            System.out.println("Add but");
            panelButton.add(button);
        }

        /**
         * Настройки Frame
         */

        setBorder(BorderFactory.createEtchedBorder());//границы панели

        panelTxt.setLayout(new GridLayout(0,2,10,10));
        panelButton.setLayout(new GridLayout(0, 1));

        add(BorderLayout.CENTER, panelTxt);
        add(BorderLayout.EAST, panelButton);
    }

    public JLabel getLabel(int number){
        return listLabel.get(number);
    }

    public JButton getButton(int number){
        return listButton.get(number);
    }

}
