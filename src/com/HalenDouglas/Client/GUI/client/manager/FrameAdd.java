package com.HalenDouglas.Client.GUI.client.manager;

import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.GUI.client.FrameMain;
import com.HalenDouglas.Client.Logic.Goods;
import com.HalenDouglas.Client.Logic.attributes.CollectionAttributes;
import com.HalenDouglas.Client.Logic.attributes.StateAttributes;
import com.HalenDouglas.Client.Logic.attributes.TypeAttributes;
import com.HalenDouglas.Client.Logic.generator.Id;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by HNKNTOC on 27.07.2015.
 */
public class FrameAdd extends JFrame {

    private JTextField textFieldName;
    private JTextField textFieldCost;
    private JComboBox comboBoxCollection;
    private JComboBox comboBoxType;
    private JLabel labelImage;
    private JPanel panelAddImage;
    private int sizeBase;



    private Base base;

    public FrameAdd(Base base){
        super("Добавить товар");
        this.base=base;
        this.sizeBase=base.getSizeBase()+1;

    }

    public void goGUI(){
        /**
         * Панель Ввода
         */
        JPanel panelInput = new JPanel();

        panelInput.setLayout(new GridLayout(0,1));
        add(BorderLayout.CENTER, panelInput);

        /**
         * Панель Картинки
         */
        panelAddImage = new JPanel();
        labelImage = new JLabel();
        JButton butAddImage = new JButton("Добавить картинку");

        butAddImage.addActionListener(new ClickAddImage());

        panelAddImage.add(labelImage);
        panelAddImage.setLayout(new BoxLayout(panelAddImage, BoxLayout.Y_AXIS));

        add(BorderLayout.EAST, panelAddImage);


        /**
         * Название
         */
        JPanel panelName = new JPanel();
        JLabel labelName = new JLabel("Название:");
        textFieldName = new JTextField(10);

        panelName.add(labelName);
        panelName.add(textFieldName);
        panelInput.add(panelName);

        /**
         * Цена
         */
        JPanel panelCost = new JPanel();
        JLabel labelCost = new JLabel("Цена:");
        textFieldCost = new JTextField(12);

        panelCost.add(labelCost);
        panelCost.add(textFieldCost);
        panelInput.add(panelCost);

        /**
         * Коллекция
         */
        JPanel panelCollection = new JPanel();
        JLabel labelCollection = new JLabel("Коллекция");


        comboBoxCollection = new JComboBox(CollectionAttributes.getMass());

        panelCollection.add(labelCollection);
        panelCollection.add(comboBoxCollection);

        panelInput.add(panelCollection);

        /**
         * Тип
         */
        JPanel panelType= new JPanel();
        JLabel labelType= new JLabel("Тип");

        comboBoxType= new JComboBox(TypeAttributes.getMass());

        panelType.add(labelType);
        panelType.add(comboBoxType);
        panelInput.add(panelType);

        /**
         * Добывить товар
         */
        JButton butSave= new JButton("Добывить товар");
        butSave.addActionListener(new ClickSave());
        add(BorderLayout.SOUTH, butSave);
        panelAddImage.add(butAddImage);


        setSize(360, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private FrameAdd getFrameAdd(){
        return this;
    }

    class ClickSave implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int cost=Integer.parseInt(textFieldCost.getText());
            String id = Id.getId(sizeBase,comboBoxType.getSelectedItem().toString(),
                    comboBoxCollection.getSelectedItem().toString());

            Goods goods = new Goods(textFieldName.getText(),id,comboBoxCollection.getSelectedItem().toString(),
                    comboBoxType.getSelectedItem().toString(), StateAttributes.IN_STOCK,cost,"no_image.png");
            base.addGoods(goods);

            setVisible(false);
            dispose();
        }
    }

    public void rep(){
        System.out.println("Пересоздание");

    }

    class ClickAddImage implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(getFrameAdd());
            File f=fileChooser.getSelectedFile();
            //res.image=new ImageIcon(f.getPath()).getImage();

            rep();
        }
    }
}
