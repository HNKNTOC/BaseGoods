
import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.BaseData.OnlineData.BaseSQL;
import com.HalenDouglas.Client.GUI.client.FrameGoodsEditor;
import com.HalenDouglas.Client.GUI.client.manager.FrameManager;
import com.HalenDouglas.Client.GUI.client.seller.FrameSeller;

import javax.swing.*;

/**
 * Created by HNKNTOC on 10.08.2015.
 */
public class TestFrame extends JFrame {

    public static void main(String args[]){
        Base base = new BaseSQL();
        try {
            base.connectBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FrameGoodsEditor frameGoods = new FrameSeller(base);
        frameGoods.start();
    }
}
