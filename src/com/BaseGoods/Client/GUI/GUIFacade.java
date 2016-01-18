package com.BaseGoods.Client.GUI;

import com.BaseGoods.Client.GUI.client.FrameMain;
import com.BaseGoods.Client.Logic.LogicFacade;
import com.BaseGoods.Client.Logic.attributes.ProgramAttributes;
import com.BaseGoods.Client.Logic.storage.StorageGoods;
import com.BaseGoods.Client.ProgramSetting;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Фасат для работы с UI
 */
public class GUIFacade {
    private FrameLogin frameLogin;
    private FrameSetting frameSetting;
    private FrameMain frameMain;
    private FactoryFrame factoryFrame;

    private LogicFacade logicFacade;

    public GUIFacade(LogicFacade logicFacade) {
        this.logicFacade = logicFacade;
        factoryFrame = new FactoryFrame();
    }

    /**
     * Запускает FrameLogin.
     */
    public void startFrameLogin(){
        frameLogin = factoryFrame.createFrameLogin();
        frameLogin.addListenerLog(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProgramSetting.User.NAME=frameLogin.getUserName();
                ProgramSetting.User.PASSWORD=frameLogin.getUserPassword();

                if(logicFacade.connectBase()){
                    frameLogin.stop();
                    startFrameMain(logicFacade.getStorageGoods());
                }else {
                    frameLogin.newNotice("Не удалось подключится к базе");
                }
            }
        });
        frameLogin.addListenerSettings(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrameSetsing();
            }
        });
        frameLogin.start();
    }

    /**
     * Возвращает пароль пользователя введённый в FrameLogin.
     * @return null если FrameLogin не создан или нечего не в ведено.
     */
    public String getUserPassword(){
            if(frameLogin!=null){
                return frameLogin.getUserPassword();
            }
        return null;
    }

    /**
     * Возвращает логин пользователя введённый в FrameLogin.
     * @return null если FrameLogin не создан или нечего не в ведено.
     */
    public String getUserName(){
        if(frameLogin!=null){
            return frameLogin.getUserName();
        }
        return null;
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
