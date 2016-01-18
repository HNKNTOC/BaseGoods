package com.BaseGoods.Client.GUI;

import com.BaseGoods.Client.GUI.client.FrameMain;
import com.BaseGoods.Client.Logic.LogicFacade;
import com.BaseGoods.Client.Logic.storage.StorageGoods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by HNKNTOC on 16.01.2016.
 */
public class GUIFacade {
    private FrameLogin frameLogin;
    private FrameSetting frameSetting;
    private FrameMain frameMain;
    private FactoryFrame factoryFrame;

    private LogicFacade logicFacade;

    public GUIFacade(LogicFacade logicFacade) {
        this.logicFacade=logicFacade;
        factoryFrame = new FactoryFrame();
    }

    public void startFrameLogin(){
        frameLogin = factoryFrame.createFrameLogin();
        frameLogin.addListenerLog(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Log\nName:"+frameLogin.getUserName()+
                        "\nPassword:"+frameLogin.getUserPassword());

                startFrameMain(logicFacade.getStorageGoods());

            }
        });
        frameLogin.addListenerSeting(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrameSetsing();
            }
        });
        frameLogin.start();
    }

    private void startFrameSetsing() {
        frameSetting = factoryFrame.createFrameSeting();
        frameSetting.start();
    }

    private void startFrameMain(StorageGoods storageGoods) {
        frameMain = factoryFrame.createFrameMain(storageGoods);
        frameMain.start();
    }

}
