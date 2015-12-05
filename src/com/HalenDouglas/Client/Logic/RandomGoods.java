package com.HalenDouglas.Client.Logic;

import com.HalenDouglas.Client.BaseData.Base;
import com.HalenDouglas.Client.BaseData.OnlineData.BaseSQL;
import com.HalenDouglas.Client.Logic.attributes.CollectionAttributes;
import com.HalenDouglas.Client.Logic.attributes.StateAttributes;
import com.HalenDouglas.Client.Logic.attributes.TypeAttributes;
import com.HalenDouglas.Client.Logic.generator.Id;

/**
 * Created by HNKNTOC on 03.08.2015.
 */
public class RandomGoods {
    private static int i;
    public static Goods getGoods(){
        String collection=getRandomCollection();
        String type=getRandomType();
        i++;
        String id=Id.getId((i),type,collection);
        return new Goods(getRandomName(),id,collection,type, StateAttributes.IN_STOCK,getRandomCost(), "no_image.png");
    }
    public static String getRandomName(){

        String[] catsName = {
                "Босоножки",
                "Куртка",
                "Туфли",
                "Куртка",
                "Шарф",
                "Шуба",
                "Сапоги",
                "Шлёпки",
                "Кепка",
                "Кеды",
                "Боксеры",
                "Джинсы",
        };

        return catsName[(int)(Math.random()*12)];
    }

    public static String getRandomCollection(){
        String[] strings = CollectionAttributes.getMass();
        return strings[(int)(Math.random()*strings.length)];
    }
    public static String getRandomType(){
        String[] strings =TypeAttributes.getMass();
        return strings[(int)(Math.random()*strings.length)];
    }
    public static int getRandomCost(){
        String s=(int)(Math.random()*50)+"000";
        return Integer.parseInt(s);
    }
    public static void main(String args[]){
        Base base = new BaseSQL();
        base.connectBase();
        for (int i=0;i<10;i++) {
            base.addGoods(RandomGoods.getGoods());
        }
    }
}
