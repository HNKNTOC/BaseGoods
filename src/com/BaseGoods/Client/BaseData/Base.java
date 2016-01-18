package com.BaseGoods.Client.BaseData;

import com.BaseGoods.Client.Logic.Goods;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by HNKNTOC on 20.08.2015.
 */
public interface Base {

    /**
     * Подключение к базе данных.
     * @throws SQLException , ClassNotFoundException
     */
    void connectBase() throws SQLException,ClassNotFoundException;

    /**
     * Закрытие подключения
     */
    void close();

    /**
     * Возвращает размер базы.
     * @return количество Goods.
     */
    int getSizeBase();

    /**
     * Возвращает Goods по id
     * @param id id Gods которое нужно вернуть.
     * @return null если Goods был не найден
     */
    Goods getGoods(String id);
    HashMap<String,Goods> getAllGoods();
    void setGoods(String id);
    boolean addGoods(Goods goods);
    boolean sellGoods(String id);
}
