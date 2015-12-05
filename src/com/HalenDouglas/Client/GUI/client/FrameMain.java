package com.HalenDouglas.Client.GUI.client;


import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.GUI.extraPanel.PanelGoods;
import com.HalenDouglas.Client.GUI.extraPanel.PanelGoodsElement;
import com.HalenDouglas.Client.Logic.Goods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Главныё фрейм для работы с базой
 */
public class FrameMain extends JFrame implements FrameGoodsEditor {

    private Base base;
    private JPanel panelButton; //Нижняя напель с кнопками
    private ArrayList<JButton> listButtonPaneGoods; // Лист с кнопками для GoodsPanel
    private PanelGoodsElement panelGoodsElement; //Панель в которую поменяются Goods для отображения

    public FrameMain(String name, Base base) {
        super(name);

        this.base = base;

        if(base==null){
            System.out.println("FrameMain null==base");
            NullPointerException exception = new NullPointerException();
            exception.printStackTrace();
        }

        panelGoodsElement = new PanelGoodsElement();
        listButtonPaneGoods = new ArrayList<>();
        panelButton = new JPanel();
        defaultSettingGUI();
        update();
    }

    public JPanel getPaneButton() {
        return panelButton;
    }

    /**
     * Настраивает гуи по стандарту
     */
    private void defaultSettingGUI() {

        /**
         * Панель goods списка
         */
        panelGoodsElement.setLayout(new GridLayout(0, 1));

        /**
         * Панель Button
         */
        panelButton.setLayout(new GridLayout(1, 0));


        add(BorderLayout.SOUTH, getPaneButton());
        add(BorderLayout.CENTER, panelGoodsElement.getScrollPaneGoodsElement());

        /**
         * Настройки Frame
         */


        setSize(700, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Добавление кнопки на панель panelButton
     *
     * @param name     имя кнопки
     * @param listener листнер кнопки
     * @return true если кнопка добавлена, false если нет
     */
    public boolean addButton(String name, ActionListener listener) {

        if (panelButton == null) return false;

        JButton button = new JButton(name);
        button.addActionListener(listener);
        panelButton.add(button);
        revalidate();
        return true;
    }

    /**
     * Обновление списка panelGoods
     *
     * @return false если base == null
     */
    @Override
    public boolean update() {
        if (base == null) return false;

        panelGoodsElement.removeAllGoods();
        for (Goods goods : base.getAllGoods().values()) {
            panelGoodsElement.addGoods(goods);
        }


        panelGoodsElement.update();
        revalidate();
        updateButtonPanelGoods();
        return true;
    }


    public void addButtonPanelGoods(String name, ActionListener listener) {
        JButton button = new JButton(name);
        button.addActionListener(listener);
        listButtonPaneGoods.add(button);
        updateButtonPanelGoods();
    }

    /**
     * Обновление JButton в PanelGoods из листа listPanelGoods.
     *
     * Создаём копию JButton из списка listButtonPaneGoods
     * Помешаем копию в каждую panelGoods из списка listPanelGoods
     */
    private void updateButtonPanelGoods() {
        for(JButton buttonA:listButtonPaneGoods){
            for(PanelGoods panelGoods:panelGoodsElement.getAllPanelGoods()){
                JButton buttonB = new JButton(buttonA.getText());
                for(ActionListener listener:buttonA.getActionListeners()){
                    buttonB.addActionListener(listener);
                }
                panelGoods.addButton(buttonB);
            }
        }
    }

    @Override
    public void start() {
        revalidate();
        setVisible(true);
    }

    @Override
    public void stop() {
        dispose();
        setVisible(false);
    }

    @Override
    public void validate() {
        super.validate();
        panelGoodsElement.updateForm(getWidth());
    }
}




