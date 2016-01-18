package com.BaseGoods.Client.BaseData;

import com.BaseGoods.Client.Logic.Goods;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by HNKNTOC on 17.01.2016.
 */
public class BaseFacade {
    private Base base;

    public BaseFacade(Base base) {
        this.base = base;
    }

    public boolean connect(){
        try {
            base.connectBase();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public HashMap<String,Goods> getAllGoods(){
        return base.getAllGoods();
    }

    public void createGoods(Goods goods){

    }

    public void deleteGoods(String id){

    }

    public void updateGoods(String id,Goods goods){

    }

}
