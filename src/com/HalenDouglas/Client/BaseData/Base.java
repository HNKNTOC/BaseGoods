package com.HalenDouglas.Client.BaseData;

import com.HalenDouglas.Client.Logic.Goods;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

/**
 * Created by HNKNTOC on 20.08.2015.
 */
public interface Base {

    boolean connectBase() throws Exception;
    int getSizeBase();

    Goods getGoods(String id);
    HashMap<String,Goods> getAllGoods();
    void setGoods(String id);
    boolean addGoods(Goods goods);
    boolean sellGoods(String id);
}
