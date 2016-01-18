package com.BaseGoods.Client.Logic;

import com.BaseGoods.Client.BaseData.BaseFacade;
import com.BaseGoods.Client.Logic.storage.StorageGoods;
import com.BaseGoods.Client.Logic.storage.StorageGoodsDefault;

/**
 * Created by HNKNTOC on 17.01.2016.
 */
public class LogicFacade {
    private BaseFacade baseFacade;
    private StorageGoods storageGoods;

    public LogicFacade(BaseFacade baseFacade) {
        this.baseFacade = baseFacade;
        baseFacade.connect();
    }

    public StorageGoods getStorageGoods(){
        if(storageGoods==null){
            return storageGoods= new StorageGoodsDefault(baseFacade.getAllGoods());
        }
        return storageGoods;
    }

    public void update(){
        if(storageGoods!=null){
            storageGoods.update(baseFacade.getAllGoods());
        }
    }

}
