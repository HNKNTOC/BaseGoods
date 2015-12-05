package com.HalenDouglas.Client.Logic.attributes;

/**
 * Created by HNKNTOC on 05.08.2015.
 */
public class CollectionAttributes {
    public static final String SUMMER="Лето";
    public static final String FALL="Осень";
    public static final String WINTER="Зима";
    public static final String SPRING="Весна";

    public static String[] getMass(){
        String[] strings={
                SUMMER,
                FALL,
                WINTER,
                SPRING,
        };
        return strings;
    }
}
