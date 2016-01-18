package com.BaseGoods.Client.BaseData;

import com.BaseGoods.Client.BaseData.OnlineData.BaseSQL;
import com.BaseGoods.Client.ProgramSetting;

/**
 * Created by HNKNTOC on 18.01.2016.
 */
public class BaseFacadeFactory {

    public static BaseFacade getBaseFacade(){
        BaseFacade baseFacade = new BaseFacade(new BaseSQL());
        if(baseFacade.connect(ProgramSetting.User.NAME,ProgramSetting.User.PASSWORD)){
            return baseFacade;
        }
        return null;
    }
}
