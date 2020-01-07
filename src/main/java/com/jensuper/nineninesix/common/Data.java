package com.jensuper.nineninesix.common;

import com.jensuper.nineninesix.entity.Sku;
import com.jensuper.nineninesix.enums.SkuCategoryEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jichao
 * @version V1.0
 * @description: 初始化数据
 * @date 2019/12/26
 */
public class Data {

    /**
     * 初始化数据
     */
    public static List<Sku> cartSkuList = new ArrayList<Sku>(){
        {
            add(new Sku(654032,"无人机",4999.00,1,4999.00,SkuCategoryEnum.ELECTRONICS));
            add(new Sku(642934,"VR-一体机",2299.00,1,2299.00,SkuCategoryEnum.ELECTRONICS));
            add(new Sku(645321,"纯色衬衫",409.00,3,409.00,SkuCategoryEnum.CLOTHING));
            add(new Sku(654327,"牛仔裤",528.00,1,528.00,SkuCategoryEnum.CLOTHING));
            add(new Sku(645489,"跑步机",2699.00,1,2699.00,SkuCategoryEnum.SPORTS));
            add(new Sku(644564,"Java编程思想",79.80,1,79.80,SkuCategoryEnum.BOOKS));
            add(new Sku(697894,"算法之美",78.20,1,78.20,SkuCategoryEnum.BOOKS));
            add(new Sku(696968,"TensorFlow进阶指南",85.10,1,85.10,SkuCategoryEnum.BOOKS));
        }
    };

    /**
     * 获取商品列表
     * @return
     */
    public static List<Sku> getCartSkuList() {
        return cartSkuList;
    }
}
