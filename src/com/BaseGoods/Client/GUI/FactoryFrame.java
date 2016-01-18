package com.BaseGoods.Client.GUI;

import com.BaseGoods.Client.GUI.client.FrameMain;
import com.BaseGoods.Client.Logic.storage.StorageGoods;

/**
 * Created by HNKNTOC on 16.01.2016.
 */
public class FactoryFrame {
    public FrameLogin createFrameLogin(){
        return new FrameLogin();
    }

    public FrameSetting createFrameSeting(){
        return new FrameSetting();
    }

    public FrameMain createFrameMain(StorageGoods storageGoods){
        return new FrameMain("Frame name",storageGoods);
    }

}
