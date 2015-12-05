import com.BaseGoods.Client.BaseData.Base;
import com.BaseGoods.Client.Logic.Goods;
import com.BaseGoods.Client.Logic.RandomGoods;

import java.util.HashMap;

/**
 * Created by HNKNTOC on 14.10.2015.
 */
public class BaseFraud implements Base {
    @Override
    public boolean connectBase() {
        return false;
    }

    @Override
    public int getSizeBase() {
        return 0;
    }

    @Override
    public Goods getGoods(String id) {
        return RandomGoods.getGoods();
    }

    @Override
    public HashMap<String, Goods> getAllGoods() {
        HashMap<String,Goods> list = new HashMap<>();
        list.put("testKey",RandomGoods.getGoods());
        list.put("testKey",RandomGoods.getGoods());
        list.put("testKey",RandomGoods.getGoods());
        list.put("testKey",RandomGoods.getGoods());
        list.put("testKey",RandomGoods.getGoods());
        list.put("testKey",RandomGoods.getGoods());
        return list;
    }

    @Override
    public void setGoods(String id) {

    }

    @Override
    public boolean addGoods(Goods goods) {
        return false;
    }

    @Override
    public boolean sellGoods(String id) {
        return false;
    }

}
