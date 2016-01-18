package com.BaseGoods.Client.GUI.extraPanel;

import com.BaseGoods.Client.Logic.Goods;
import com.BaseGoods.Client.Logic.RandomGoods;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HNKNTOC on 13.10.2015.
 */
public class PanelGoodsTest {

    @Test
    public void testGetGoods() throws Exception {
        Goods goods = RandomGoods.getGoods();
        GoodsPanel panelGoods = new GoodsPanel(goods);
        System.out.println(goods.toString());
        System.out.println(panelGoods.getGoods().toString());
        assertTrue(goods.toString().equals(panelGoods.getGoods().toString()));

    }

    @Test
    public void testGoPanelBut() throws Exception {

    }

    @Test
    public void testAddAttribute() throws Exception {

    }

    @Test
    public void testAddButton() throws Exception {

    }
}