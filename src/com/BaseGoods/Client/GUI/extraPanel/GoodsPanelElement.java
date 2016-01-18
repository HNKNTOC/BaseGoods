package com.BaseGoods.Client.GUI.extraPanel;


import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by HNKNTOC on 18.10.2015.
 */
public class GoodsPanelElement extends JPanel {
    private HashMap<String,GoodsPanel> listPanelGoods = new HashMap<>();
    private JScrollPane scrollPaneGoodsElement;

    public GoodsPanelElement() {
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

    public void addPanelGoods(GoodsPanel panelGoods){
        listPanelGoods.put(panelGoods.getGoods().getId(), panelGoods);
    }

    public void addGoodsPanel(GoodsPanel goodsPanel){
        listPanelGoods.put(goodsPanel.getGoods().getId(),goodsPanel);
    }

    public void removeGoods(String id){
        listPanelGoods.remove(id);
    }

    public void removeAllGoods(){
        listPanelGoods.clear();
    }

    public Collection<GoodsPanel> getAllPanelGoods(){
        return listPanelGoods.values();
    }



    public void update(){
        for(GoodsPanel panelGoods:listPanelGoods.values()){
            add(panelGoods);
        }
    }


    /**
     * В зависимости от размера Frame изменяет колонки в GoodsPanelElement
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
