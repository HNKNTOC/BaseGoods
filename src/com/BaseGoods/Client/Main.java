package com.BaseGoods.Client;

import com.BaseGoods.Client.BaseData.BaseFacade;
import com.BaseGoods.Client.BaseData.OnlineData.BaseSQL;
import com.BaseGoods.Client.GUI.GUIFacade;
import com.BaseGoods.Client.Logic.LogicFacade;

/**
 * Created by HNKNTOC on 17.01.2016.
 */
public class Main {
    public static void main(String[] args) {
        BaseFacade baseFacade = new BaseFacade(new BaseSQL());
        LogicFacade logicFacade = new LogicFacade(baseFacade);
        GUIFacade guiFacade = new GUIFacade(logicFacade);

        guiFacade.startFrameLogin();

    }
}
