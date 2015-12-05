package com.BaseGoods.Client.Logic.attributes;

/**
 * Created by HNKNTOC on 05.08.2015.
 */
public class TypeAttributes {
    public static final String CLOTHES="Одежда";
    public static final String SHOES="Обувь";
    public static final String ACCESSORIES="Аксессуары";

    public static String[] getMass(){
        String[] strings={
                CLOTHES,
                SHOES,
                ACCESSORIES,
        };
        return strings;
    }
}
