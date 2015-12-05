import com.HalenDouglas.Client.GUI.extraPanel.PanelGoods;
import com.HalenDouglas.Client.Logic.RandomGoods;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by HNKNTOC on 14.10.2015.
 */
public class TestPanelGoods extends JFrame {

    public void go(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,1));
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        TestPanelGoods frame = new TestPanelGoods();
        ArrayList<JButton> listButton = new ArrayList<>();
        listButton.add(new JButton("Кнопка 1"));

        for (int i=0;i<5;i++) {
            PanelGoods panelGoods = new PanelGoods(RandomGoods.getGoods());

        }

        frame.go();
    }
}
