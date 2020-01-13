package com.jensuper.nineninesix.condition;

import com.jensuper.nineninesix.entity.Sku;

/**
 * @author JenSuper
 * @version V1.0
 * @description: 函数式接口
 * @date 2019/12/26
 */
@FunctionalInterface
public interface SkuCondition {

    boolean test(Sku sku);


}
