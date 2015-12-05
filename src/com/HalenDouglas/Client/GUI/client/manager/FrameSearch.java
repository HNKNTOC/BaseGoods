package com.HalenDouglas.Client.GUI.client.manager;

import com.HalenDouglas.Client.GUI.extraPanel.PanelGoods;
import com.HalenDouglas.Client.Logic.Goods;
import com.HalenDouglas.Client.Logic.GoodsSearch;
import com.HalenDouglas.Client.Logic.attributes.CollectionAttributes;
import com.HalenDouglas.Client.Logic.attributes.TypeAttributes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by HNKNTOC on 31.07.2015.
 */
public class FrameSearch extends JFrame {

    private HashMap<String,Goods> goodsFoundList = new HashMap<>();
    private HashMap<String,Goods> goodsList;

    private JTextField textFieldName;
    private JPanel panelResult;
    private JTextField textFieldCostFrom;
    private JTextField textFieldCostBefore;
    private JTextField textFieldId;

    private JComboBox comboBoxType;
    private JComboBox comboBoxCollection;

    public FrameSearch(HashMap<String,Goods> goods){
        super("Поиск");
        this.goodsList =goods;
    }


    public void goGui(){
        /**
         * Панель ввода данных
         */
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new GridLayout(0,1));
        /**
         * Панель вывода найденных Goods
         */
        panelResult = new JPanel();
        panelResult.setLayout(new BoxLayout(panelResult,BoxLayout.Y_AXIS));

        /**
         * Скрол для panelInput
         */
        JScrollPane scrollPaneInput = new JScrollPane(panelInput);

        /**
         * Скрол для panelResult
         */
        JScrollPane scrollResult = new JScrollPane(panelResult);
        panelResult.add(new PanelGoods(new Goods()));

        /**
         * Поиск but
         */
        JButton butSearch = new JButton("     -----     Поиск по критериям     -----     ");
        butSearch.addActionListener(new ClickSearch());


        /**
         * Добавление на panelInput компонентов
         */
        addComponent(panelInput);
        panelInput.add(butSearch);


        add(BorderLayout.WEST, scrollPaneInput);
        add(BorderLayout.CENTER, scrollResult);


        /**
         * Настройки фрейма
         */
        setSize(570, 400);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void addComponent(JPanel panelMain){
        /**
         * Название
         */
        JPanel panelName = new JPanel();
        JLabel labelName = new JLabel("Название:");
        textFieldName = new JTextField(12);

        panelName.add(labelName);
        panelName.add(textFieldName);
        panelMain.add(panelName);

        /**
         * Id
         */
        JPanel panelId = new JPanel();
        JLabel labelId = new JLabel("Id:");
        textFieldId = new JTextField(13);

        panelId.add(labelId);
        panelId.add(textFieldId);
        panelMain.add(panelId);

        /**
         * Цена
         */
        JPanel panelCost = new JPanel();
        JLabel labelCost = new JLabel("Цена:");
        JLabel labelCostFrom = new JLabel("От");
        JLabel labelCostBefore = new JLabel("До");
        textFieldCostFrom = new JTextField(5);
        textFieldCostBefore = new JTextField(5);

        panelCost.add(labelCost);
        panelCost.add(labelCostFrom);
        panelCost.add(textFieldCostFrom);
        panelCost.add(labelCostBefore);
        panelCost.add(textFieldCostBefore);
        panelMain.add(panelCost);

        /**
         * Коллекция
         */
        JPanel panelCollection = new JPanel();
        JLabel labelCollection = new JLabel("Коллекция");

        String[] MassCollection = {
                "Не выбрано",
                CollectionAttributes.SUMMER,
                CollectionAttributes.FALL,
                CollectionAttributes.WINTER,
                CollectionAttributes.SPRING,
        };
        comboBoxCollection = new JComboBox(MassCollection);


        panelCollection.add(labelCollection);
        panelCollection.add(comboBoxCollection);
        panelMain.add(panelCollection);

        /**
         * Тип
         */
        JPanel panelType = new JPanel();
        JLabel labelType = new JLabel("Тип");
        String[] MassType = {
                "Не выбрано",
                TypeAttributes.CLOTHES,
                TypeAttributes.SHOES,
                TypeAttributes.ACCESSORIES,
        };
        comboBoxType = new JComboBox(MassType);

        panelType.add(labelType);
        panelType.add(comboBoxType);
        panelMain.add(panelType);


    }

    /**
     * Под классы
     */

    private FrameSearch getClasSearch(){
        return this;
    }

    private class ClickSearch implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(textFieldName.getText().equals("")){
                textFieldName.setText(null);
            }

            if(textFieldCostFrom.getText().equals("")){
                textFieldCostFrom.setText(null);
            }


            /**
             * Присваиваем значение 0 если поля пустые
             */
            int From=0;
            int Before=0;
            try {
                From = Integer.parseInt(textFieldCostFrom.getText());
            } catch (NumberFormatException e1) {
                From = 0;
            }

            try {
                Before = Integer.parseInt(textFieldCostBefore.getText());
            } catch (NumberFormatException e1) {
                Before = 0;
            }
            /**
             * Берём значение из
             */
            String tupe=comboBoxType.getSelectedItem().toString();
            String collection=comboBoxCollection.getSelectedItem().toString();

            if(tupe.equals("Не выбрано")) tupe="";
            if(collection.equals("Не выбрано")) collection="";

            GoodsSearch searchGoods = new GoodsSearch(getClasSearch());
            goodsFoundList=searchGoods.searchGoods(goodsList, textFieldName.getText(),From,Before,textFieldId.getText(),
                    tupe,collection);

            panelResult.removeAll();

            for (Goods goods:goodsFoundList.values()) {
                panelResult.add(new PanelGoods(goods));
            }
            revalidate();

        }
    }
}
