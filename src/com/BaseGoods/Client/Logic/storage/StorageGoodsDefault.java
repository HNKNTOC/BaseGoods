package com.BaseGoods.Client.Logic.storage;

import com.BaseGoods.Client.Logic.Goods;

import java.util.HashMap;

/**
 * Created by HNKNTOC on 17.01.2016.
 */
public class StorageGoodsDefault implements StorageGoods {

    private HashMap<String,Goods> listGoods;

    public StorageGoodsDefault(HashMap<String,Goods> listGoods) {
        this.listGoods = listGoods;
    }

    @Override
    public HashMap<String, Goods> getAllGoods() {
        return listGoods;
    }

    @Override
    public Goods getGoods(String id) {
        return listGoods.get(id);
    }

    @Override
    public void update(HashMap<String, Goods> listGoods) {
        this.listGoods = listGoods;
    }
}
