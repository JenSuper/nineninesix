package com.jensuper.nineninesix.entity;

import lombok.Data;

/**
 * @author jichao
 * @version V1.0
 * @description: 下单商品
 * @date 2019/12/26
 */
@Data
public class Sku {

    /**
     * 商品id
     */
    private Integer skuId;
    /**
     * 商品名称
     */
    private String skuName;
    /**
     * 商品单价
     */
    private Double skuPrice;
    /**
     * 商品数量
     */
    private Integer totalNum;
    /**
     * 商品总价
     */
    private Double totalPrice;
    /**
     * 商品类型
     */
    private Enum skuCategory;

    public Sku() {
    }

    public Sku(Integer skuId, String skuName, Double skuPrice, Integer totalNum, Double totalPrice, Enum skuCategory) {
        this.skuId = skuId;
        this.skuName = skuName;
        this.skuPrice = skuPrice;
        this.totalNum = totalNum;
        this.totalPrice = totalPrice;
        this.skuCategory = skuCategory;
    }
}
