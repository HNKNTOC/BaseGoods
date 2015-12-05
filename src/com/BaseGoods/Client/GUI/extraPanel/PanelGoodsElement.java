package com.BaseGoods.Client.GUI.extraPanel;

import com.BaseGoods.Client.Logic.Goods;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by HNKNTOC on 18.10.2015.
 */
public class PanelGoodsElement extends JPanel {
    private HashMap<String,PanelGoods> listPanelGoods = new HashMap<>();
    private JScrollPane scrollPaneGoodsElement;

    public PanelGoodsElement() {
        settingsPanel();
    }

    public void settingsPanel(){
        setLayout(new GridLayout(0, 1));
        scrollPaneGoodsElement = new JScrollPane(this);
        //scrollPaneGoodsElement.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    }

    public JScrollPane getScrollPaneGoodsElement() {
        return scrollPaneGoodsElement;
    }

    public void addPanelGoods(PanelGoods panelGoods){
        listPanelGoods.put(panelGoods.getGoods().getId(), panelGoods);
    }

    public void addGoods(Goods goods){
        listPanelGoods.put(goods.getId(), new PanelGoods(goods));
    }

    public void removeGoods(String id){
        listPanelGoods.remove(id);
    }

    public void removeAllGoods(){
        listPanelGoods.clear();
    }

    public Collection<PanelGoods> getAllPanelGoods(){
        return listPanelGoods.values();
    }



    public void update(){
        for(PanelGoods panelGoods:listPanelGoods.values()){
            add(panelGoods);
        }
    }


    /**
     * В зависимости от размера Frame изменяет колонки в PanelGoodsElement
     */
    public void updateForm(int width) {
        if (width > 800) {
            if (width > 1300) {
                setLayout(new GridLayout(0, 3));
                return;
            }
            setLayout(new GridLayout(0, 2));
        } else {
            setLayout(new GridLayout(0, 1));
        }

    }
}
