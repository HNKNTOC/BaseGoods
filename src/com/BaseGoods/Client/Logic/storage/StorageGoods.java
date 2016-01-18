package com.BaseGoods.Client.Logic.storage;

import com.BaseGoods.Client.Logic.Goods;

import java.util.HashMap;

/**
 * Хранилище Goods из которого можно брать Goods
 */
public interface StorageGoods {
    HashMap<String,Goods> getAllGoods();
    Goods getGoods(String id);
    void update(HashMap<String,Goods> listGoods);

}
