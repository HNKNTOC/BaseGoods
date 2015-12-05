package com.HalenDouglas.Client.GUI.client.seller;

import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.GUI.client.FrameMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HNKNTOC on 29.08.2015.
 */
public class FrameSeller extends FrameMain{
    static public FrameBasket frameBasket;

    public FrameSeller(Base base) {
        super("Панель продавца", base);
        frameBasket = new FrameBasket(base);
        settingsGUI();
        start();
    }

    private void settingsGUI(){
        addButtonPanelGoods("Добавить в корзину", new ClickAddBasket());
        addButton("Обновит", new ClickUpdates());
        addButton("Открыть корзину", new ClickOpenBasket());
    }

    class ClickUpdates implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    }

    class ClickOpenBasket implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class ClickAddBasket implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Добавлен!!");
        }
    }
}
