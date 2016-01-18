package com.BaseGoods.Client.GUI.client.manager;


import com.BaseGoods.Client.GUI.client.FrameMain;
import com.BaseGoods.Client.Logic.storage.StorageGoods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HNKNTOC on 05.09.2015.
 */
public class FrameManager extends FrameMain{
    StorageGoods storageGoods;
    public FrameManager(StorageGoods storageGoods) {
        super("Панель администратора",storageGoods);
        this.storageGoods =storageGoods;
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
            FrameAdd panelAddGoods = new FrameAdd(storageGoods);
            panelAddGoods.goGUI();
        }
    }

    private class ClickSearch implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // ИСПРАВИТЬ!!!
            //FrameSearch panelSearch = new FrameSearch();
            //panelSearch.goGui();
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
