package com.HalenDouglas.Client.GUI.client.manager;

import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.GUI.client.FrameMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HNKNTOC on 05.09.2015.
 */
public class FrameManager extends FrameMain{
    Base base;
    public FrameManager(Base base) {
        super("Панель администратора",base);
        this.base=base;
        settingsGUI();
        update();
        start();
    }

    private void settingsGUI(){
        addButton("Добавить товар",new ClickAdd());
        addButton("Найти товар",new ClickSearch());
        addButton("История событий",null);
        addButton("Настройки",null);
        addButton("Информация",new ClickInfa());
        addButton("Обновить", new ClickUpdate());
    }

    private class ClickAdd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameAdd panelAddGoods = new FrameAdd(base);
            panelAddGoods.goGUI();
        }
    }

    private class ClickSearch implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            FrameSearch panelSearch = new FrameSearch(base.getAllGoods());
            panelSearch.goGui();
        }
    }

    private class ClickInfa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    private class ClickUpdate implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            update();
        }
    }
}
