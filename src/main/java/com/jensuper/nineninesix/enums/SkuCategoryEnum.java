package com.jensuper.nineninesix.enums;

import lombok.Getter;

/**
 * @author jichao
 * @version V1.0
 * @description: 商品类型枚举
 * @date 2019/12/26
 */
@Getter
public enum SkuCategoryEnum {
    CLOTHING(10,"服装类"),
    ELECTRONICS(10,"数码类"),
    SPORTS(10,"运动类"),
    BOOKS(10,"图书类"),
    ;

    private Integer code;
    private String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
