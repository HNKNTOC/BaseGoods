package com.HalenDouglas.Client.GUI.extraPanel;


import com.HalenDouglas.Client.Logic.Goods;
import com.HalenDouglas.Client.Logic.attributes.StateAttributes;
import res.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by HNKNTOC on 25.07.2015.
 */
public class PanelGoods extends JPanel{
    private String name;
    private String collection;
    private String typ;
    private String id;
    private String state;
    private String imageDirectory;
    private String location;

    private Image image = res.ResourceLoader.getImage("no_image.png");
    private int cost;

    private boolean setVisibleName;
    private boolean setVisibleCollection;
    private boolean setVisibleType;
    private boolean setVisibleId;
    private boolean setVisibleState;
    private boolean setVisibleLocation;

    private ArrayList<JLabel> ListLabel = new ArrayList<>();

    private JPanel panelAttribute = new JPanel();
    private JPanel panelImage = new JPanel();
    private JPanel panelBut = new JPanel();

    public PanelGoods(Goods goods) {


        name = goods.getName();
        collection = goods.getCollection();
        typ = goods.getType();
        id = goods.getId();
        state = goods.getState();
        cost = goods.getCost();
        imageDirectory = goods.getImageDirectory();
        settingsPanel();
    }

    public Goods getGoods() {
        return new Goods(name, id, collection, typ, state, cost, imageDirectory);
    }

    private void settingsPanel() {

        /**
         * Добавление атрибутов
         */
        addAttribute("Название", name);
        addAttribute("Id", id);
        addAttribute("Цена", "" + cost);
        addAttribute("Коллекция", "" + collection);
        addAttribute("Тип", "" + typ);
        addAttribute("Состояние", "" + state);


        /**
         * Картинка
         */

        JLabel labelImage = new JLabel(new ImageIcon(image));

        panelImage.add(labelImage);

        /**
         * Настройки
         */
        setBorder(BorderFactory.createEtchedBorder());//границы панели


        panelAttribute.setLayout(new GridLayout(0, 1));
        setLayout(new GridLayout(1, 3));

        add(panelImage);
        add(panelAttribute);
        add(panelBut);

        if (state == null) {
            return;
        }

        if (state.equals(StateAttributes.SOLD)) {
            Image sales = ResourceLoader.getImage("sales.png");

            add(BorderLayout.WEST, new JLabel(new ImageIcon(sales)));
        }
    }

    private void setPanelButVisible(boolean b) {
        panelBut.setVisible(b);
    }


    public boolean addAttribute(String name, String value) {
        if (panelAttribute == null) return false;
        JLabel label = new JLabel(name + ": " + value);
        ListLabel.add(label);
        panelAttribute.add(label);
        return true;
    }

    /**
     * Добавляет кнопку на PanelGoods
     *
     * @param name
     * @param listener
     * @return
     */
    public boolean addButton(String name, ActionListener listener) {
        if (state.equals(StateAttributes.SOLD)) {
            panelBut.setVisible(false);
            System.out.println("false SOLD");
            return false;
        }

        JButton button = new JButton(name);
        button.addActionListener(listener);
        panelBut.add(button);
        return true;
    }

    public boolean addButton(JButton button) {
        if (state.equals(StateAttributes.SOLD)) {
            panelBut.setVisible(false);
            System.out.println("false SOLD");
            return false;
        }
        panelBut.add(button);
        return true;
    }


    class ClickRemoveBasket implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
