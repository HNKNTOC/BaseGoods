package com.HalenDouglas.Client.Logic.generator;

import com.HalenDouglas.Client.Logic.attributes.CollectionAttributes;
import com.HalenDouglas.Client.Logic.attributes.TypeAttributes;

/**
 * Генерирует id состоящий 3 атрибутов разделённых тире.
 *Пример: CL-0004-SU
 *CL тип товара.
 *0004 номер.
 *SU коллекция.
 */
public class Id {
    public static String getId(int number,String type,String collection){
        StringBuilder builder = new StringBuilder(""+number);
        String s=null;
        String collectionId=null;
        String typeId=null;

        switch (builder.length()){
            case 1: s="000"; break;
            case 2: s="00";  break;
            case 3: s="0";   break;
            case 4: s="";    break;
        }
        switch (collection){
            case CollectionAttributes.SUMMER: collectionId="SU"; break;
            case CollectionAttributes.FALL: collectionId="FA";  break;
            case CollectionAttributes.WINTER: collectionId="WI"; break;
            case CollectionAttributes.SPRING: collectionId="SP"; break;
        }

        switch (type){
            case TypeAttributes.CLOTHES: typeId="CL"; break;
            case TypeAttributes.SHOES: typeId="SH"; break;
            case TypeAttributes.ACCESSORIES: typeId="AC"; break;
        }
        return typeId+"-"+s+builder.toString()+"-"+collectionId;
    }
    public static void main(String args[]){
        System.out.println(Id.getId(4, TypeAttributes.CLOTHES, CollectionAttributes.SUMMER));
        System.out.println(Id.getId(23, TypeAttributes.SHOES, CollectionAttributes.WINTER));
        System.out.println(Id.getId(193, TypeAttributes.ACCESSORIES, CollectionAttributes.SPRING));
        System.out.println(Id.getId(92, TypeAttributes.CLOTHES, CollectionAttributes.FALL));
    }
}
