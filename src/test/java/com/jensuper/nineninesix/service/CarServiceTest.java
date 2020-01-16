package com.jensuper.nineninesix.service;


import com.alibaba.fastjson.JSON;
import com.jensuper.nineninesix.condition.BooksCondition;
import com.jensuper.nineninesix.entity.Sku;
import com.jensuper.nineninesix.enums.SkuCategoryEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author JenSuper
 * @version V1.0
 * @description:
 * @date 2019/12/26
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@Slf4j
public class CarServiceTest {

    @Test
    public void getSkuList() {
        List<Sku> skuList = CarService.getSkuList();
        String retJson = JSON.toJSONString(skuList, true);
        System.out.println(retJson);
    }

    @Test
    public void filterSkuList() {
        List<Sku> skuList = CarService.filterSkuList(SkuCategoryEnum.BOOKS);
        String retJson = JSON.toJSONString(skuList, true);
        System.out.println(retJson);
    }

    @Test
    public void filterPriceSkuList() {
        List<Sku> skuList = CarService.filterPriceSkuList(SkuCategoryEnum.CLOTHING, 500.00);
        String retJson = JSON.toJSONString(skuList, true);
        System.out.println(retJson);
    }

    @Test
    public void filterConditionSkuList() {
        BooksCondition booksCondition = new BooksCondition();
        List<Sku> skuList = CarService.filterConditionSkuList(booksCondition);
        String retJson = JSON.toJSONString(skuList, true);
        System.out.println(retJson);
    }

    /** *
     * 自定义函数式编程方式
     * @author JenSuper
     * @param
     * @return void
     * @date 2019/12/27 11:26
     */
    @Test
    public void filterConditionSku() {
        List<Sku> skuList = CarService.filterConditionSkuList((Sku sku)->sku.getTotalPrice()>1000);
        String retJson = JSON.toJSONString(skuList, true);
        System.out.println(retJson);
    }

}