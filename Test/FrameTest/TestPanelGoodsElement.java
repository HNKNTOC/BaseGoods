package FrameTest;

import com.BaseGoods.Client.GUI.extraPanel.PanelGoodsElement;
import com.BaseGoods.Client.Logic.RandomGoods;

import javax.swing.*;

/**
 * Created by HNKNTOC on 22.10.2015.
 */
public class TestPanelGoodsElement extends JFrame {

    public void go(){
        PanelGoodsElement panelGoodsElement = new PanelGoodsElement();
        panelGoodsElement.addGoods(RandomGoods.getGoods());
        panelGoodsElement.addGoods(RandomGoods.getGoods());
        panelGoodsElement.addGoods(RandomGoods.getGoods());

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
