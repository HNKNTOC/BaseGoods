package com.HalenDouglas.Client.GUI.client.seller;

import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.GUI.extraPanel.PanelGoods;
import com.HalenDouglas.Client.GUI.extraPanel.PanelGoodsElement;
import com.HalenDouglas.Client.Logic.Goods;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Чек содержит товар для продажи.
 */
public class FrameBasket extends JFrame{

    private static ArrayList<String> listIdGoods = new ArrayList<>();
    private Base base;
    private PanelGoodsElement panelGoodsElement = new PanelGoodsElement();

    public FrameBasket(Base base) {
        super("Корзина");
        this.base=base;
        settingsGUI();
    }

    public void settingsGUI() {
        JButton button = new JButton("Продать");
        button.addActionListener(new ClickSell());
        add(button);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 400);
    }

    public  boolean addIdGoods(String id){
        listIdGoods.add(id);
        Goods goods = base.getGoods(id);

        if(goods==null) System.out.println("goods==null");
        panelGoodsElement.addGoods(goods);

        return true;
    }



    class ClickSell implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            panelGoodsElement.removeAllGoods();
            repaint();
            for (String id:listIdGoods) {
                base.sellGoods(id);
            }
        }
    }
}
