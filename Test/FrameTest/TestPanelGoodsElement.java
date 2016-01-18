package FrameTest;

import com.BaseGoods.Client.GUI.extraPanel.GoodsPanel;
import com.BaseGoods.Client.GUI.extraPanel.GoodsPanelElement;
import com.BaseGoods.Client.Logic.RandomGoods;

import javax.swing.*;

/**
 * Created by HNKNTOC on 22.10.2015.
 */
public class TestPanelGoodsElement extends JFrame {

    public void go(){
        GoodsPanelElement panelGoodsElement = new GoodsPanelElement();
        panelGoodsElement.addGoodsPanel(new GoodsPanel(RandomGoods.getGoods()));
        panelGoodsElement.addGoodsPanel(new GoodsPanel(RandomGoods.getGoods()));
        panelGoodsElement.addGoodsPanel(new GoodsPanel(RandomGoods.getGoods()));

        add(panelGoodsElement.getScrollPaneGoodsElement());
        panelGoodsElement.update();

        setSize(300, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        TestPanelGoodsElement test = new TestPanelGoodsElement();
        test.go();
    }
}
