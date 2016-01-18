package com.BaseGoods.Client.Logic;

import com.BaseGoods.Client.BaseData.BaseFacade;
import com.BaseGoods.Client.BaseData.BaseFacadeFactory;
import com.BaseGoods.Client.Logic.storage.StorageGoods;
import com.BaseGoods.Client.Logic.storage.StorageGoodsDefault;

/**
 * Фасад для паботы с логикой
 */
public class LogicFacade {
    private StorageGoods storageGoods;
    private BaseFacade baseFacade;

    public boolean connectBase(){
            baseFacade = BaseFacadeFactory.getBaseFacade();
        return baseFacade != null;
    }

    public LogicFacade(BaseFacade baseFacade) {
        this.baseFacade = baseFacade;
    }

    public StorageGoods getStorageGoods(){
        if(baseFacade==null){
            return null;
        }
        if(storageGoods==null){
            return storageGoods= new StorageGoodsDefault(baseFacade.getAllGoods());
        }
        return storageGoods;
    }

    public void update(){
        if(baseFacade==null){
            return;
        }
        if(storageGoods!=null){
            storageGoods.update(baseFacade.getAllGoods());
        }
    }

}
