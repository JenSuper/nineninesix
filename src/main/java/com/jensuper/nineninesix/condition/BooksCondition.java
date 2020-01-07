package com.jensuper.nineninesix.condition;

import com.jensuper.nineninesix.entity.Sku;
import com.jensuper.nineninesix.enums.SkuCategoryEnum;

/**
 * @author jichao
 * @version V1.0
 * @description:
 * @date 2019/12/26
 */
public class BooksCondition implements SkuCondition {

    @Override
    public boolean test(Sku sku) {
        return SkuCategoryEnum.BOOKS.equals(sku.getSkuCategory());
    }
}
