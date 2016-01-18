package com.BaseGoods.Client.GUI.client.seller;

import com.BaseGoods.Client.GUI.extraPanel.GoodsPanelElement;
import com.BaseGoods.Client.Logic.storage.StorageGoods;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Чек содержит товар для продажи.
 */
public class FrameBasket extends JFrame{

    private static ArrayList<String> listIdGoods = new ArrayList<>();
    private StorageGoods storageGoods;
    private GoodsPanelElement panelGoodsElement = new GoodsPanelElement();

    public FrameBasket(StorageGoods storageGoods) {
        super("Корзина");
        this.storageGoods =storageGoods;
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
        //Goods goods = storageGoods.getAllPanelGoodsElement();

        //if(goods==null) System.out.println("goods==null");
        //panelGoodsElement.addGoodsPanel(goods);

        return true;
    }



    class ClickSell implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            panelGoodsElement.removeAllGoods();
            repaint();
            for (String id:listIdGoods) {
                //storageGoods.sellGoods(id);
            }
        }
    }
}
