package com.jensuper.nineninesix.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author JenSuper
 * @version V1.0
 * @description: 下单商品
 * @date 2019/12/26
 */
@Data
public class Sku {

    /**
     * 新增
     */
    public interface saveSku {

    }

    /**
     * 修改
     */
    public interface updSku {

    }

    /**
     * 商品id
     * 只有在修改的时候才会执行验证
     */
    @NotEmpty(message = "商品ID不能为空",groups = updSku.class)
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
