package com.BaseGoods.Client.BaseData;

import com.BaseGoods.Client.Logic.Goods;
import com.BaseGoods.Client.ProgramSetting;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Фасад для работы с базой
 */
public class BaseFacade {
    private Base base;

    public BaseFacade(Base base) {
        this.base = base;
    }

    public boolean connect(String name,String password){
        try {
            base.connectBase(name,password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        return true;
    }

    public HashMap<String,Goods> getAllGoods(){
        return base.getAllGoods();
    }

    public void createGoods(Goods goods){

    }

    public void deleteGoods(String id){

    }

    public void updateGoods(String id,Goods goods){

    }

}
