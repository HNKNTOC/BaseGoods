package com.BaseGoods.Client.Logic;

import com.BaseGoods.Client.BaseData.Base;
import com.BaseGoods.Client.Logic.attributes.CollectionAttributes;
import com.BaseGoods.Client.Logic.attributes.TypeAttributes;
import com.BaseGoods.Client.BaseData.OnlineData.BaseSQL;
import com.BaseGoods.Client.Logic.attributes.StateAttributes;
import com.BaseGoods.Client.Logic.generator.Id;
import com.BaseGoods.Client.ProgramSetting;

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
        String[] strings = TypeAttributes.getMass();
        return strings[(int)(Math.random()*strings.length)];
    }
    public static int getRandomCost(){
        String s=(int)(Math.random()*50)+"000";
        return Integer.parseInt(s);
    }
    public static void main(String args[]){
        Base base = new BaseSQL();
        try {
            base.connectBase("root","test");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i=0;i<10;i++) {
            base.addGoods(RandomGoods.getGoods());
        }
    }
}
