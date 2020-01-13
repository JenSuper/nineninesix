package com.jensuper.nineninesix.service;

import com.jensuper.nineninesix.common.Data;
import com.jensuper.nineninesix.condition.SkuCondition;
import com.jensuper.nineninesix.entity.Sku;
import com.jensuper.nineninesix.enums.SkuCategoryEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JenSuper
 * @version V1.0
 * @description: 购物车业务
 * @date 2019/12/26
 */
public class CarService {

    /**
     * 所有购物数据
     */
    private static List<Sku> skuList = Data.getCartSkuList();

    /**
     * V 1.0
     * 获取所有电子产品
     *
     * @return
     */
    public static List<Sku> getSkuList() {
        // 所有商品返回结果
        List<Sku> skuListRet = new ArrayList<>();

        for (Sku sku : skuList) {
            if (SkuCategoryEnum.ELECTRONICS.equals(sku.getSkuCategory())) {
                skuListRet.add(sku);
            }
        }
        return skuListRet;
    }

    /**
     * V 2.0
     * 获取指定商品类型
     */
    public static List<Sku> filterSkuList(SkuCategoryEnum categoryEnum) {
        // 所有商品返回结果
        List<Sku> skuListRet = new ArrayList<>();

        for (Sku sku : skuList) {
            if (categoryEnum.equals(sku.getSkuCategory())) {
                skuListRet.add(sku);
            }
        }
        return skuListRet;
    }

    /**
     * V 3.0
     * 过滤商品
     * 条件：类型 | 价格
     */
    public static List<Sku> filterPriceSkuList(SkuCategoryEnum categoryEnum, Double totalPrice) {
        // 所有商品返回结果
        List<Sku> skuListRet = new ArrayList<>();

        for (Sku sku : skuList) {
            if (categoryEnum.equals(sku.getSkuCategory()) && sku.getTotalPrice() <= totalPrice) {
                skuListRet.add(sku);
            }
        }
        return skuListRet;
    }


    /**
     * V 4.0
     * 过滤商品
     * 条件：根据参数判断
     */
    public static List<Sku> filterConditionSkuList(SkuCondition skuCondition) {
        // 所有商品返回结果
        List<Sku> skuListRet = new ArrayList<>();

        for (Sku sku : skuList) {
            if (skuCondition.test(sku)) {
                skuListRet.add(sku);
            }
        }

        return skuListRet;
    }


}
