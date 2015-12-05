package com.HalenDouglas.Client.Logic;

import com.HalenDouglas.Client.GUI.client.manager.FrameSearch;

import java.util.HashMap;

/**
 * Created by HNKNTOC on 02.08.2015.
 */
public class GoodsSearch {
    private HashMap<String,Goods> stringFoundList = new HashMap<>();
    private HashMap<String,Goods> stringRequiredList;
    private String required;
    private FrameSearch panelSearch;

    public GoodsSearch(FrameSearch panelSearch) {
        this.panelSearch=panelSearch;
    }

    /**
     * Этот метод отсеивает Goods по параметрам, null если по данному параметру искать не нужно.
     *
     * @param goodsRequiredList лист с Goods для обработки
     * @param requiredName параметр поиска
     * @param requireFrom цена от
     * @param requireBefore цена до
     * @param id
     * @return лист с Goods удовлетворяющими параметр поиска

     */
    public HashMap<String,Goods> searchGoods(HashMap<String,Goods> goodsRequiredList,String requiredName,int requireFrom,int requireBefore,
                                        String id,String type,String collection){
        /**
         * Если все порамметры пусты возвращает null
         */
        if(requiredName==null){
            return null;
        }
            for(Goods goods:goodsRequiredList.values()){
                if(searchString(goods.getName(),requiredName) & searchCost(goods.getCost(),requireFrom,requireBefore) &
                        searchString(goods.getId(),id) & searchString(goods.getType(),type) &
                        searchString(goods.getCollection(),collection)){
                    stringFoundList.put(goods.getId(),goods);
                }
            }

        return stringFoundList;
    }

    private boolean searchString(String word,String required){
        if(required.equals("")){
            return true;
        }
        System.out.println("Пришло= "+required+" и "+word);
        if(word.length()==0 | required.length()==0){
            return false;
        }
        word=word.toLowerCase();
        required=required.toLowerCase();

        StringBuilder builder = new StringBuilder(word);

        int lengthRequired=required.length();

        if (lengthRequired>word.length()){
            lengthRequired=Math.abs(word.length() - lengthRequired);
        }

        try {
            word=builder.substring(0,lengthRequired);
        } catch (Exception e) {
            System.out.println("Ошибка: Строка ="+word+" а берут с неё "+required.length());
        }

        return word.equals(required);

    }

    private boolean searchCost(int goods,int from,int before){
        if(from==0 & before==0){
            return true;
        }

        if(before==0 & from<=goods){
            return true;
        }

        if(from<=goods & goods<=before){
            return true;
        }

        return false;
    }
}
