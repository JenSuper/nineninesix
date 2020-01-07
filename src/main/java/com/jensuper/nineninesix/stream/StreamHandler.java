package com.jensuper.nineninesix.stream;

import com.alibaba.fastjson.JSON;
import com.jensuper.nineninesix.common.Data;
import com.jensuper.nineninesix.entity.Sku;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;

/**
 * @author jichao
 * @version V1.0
 * @description: 流式编程 1. 对集合的操作
 * @date 2019/12/29
 */
public class StreamHandler {

    /**
     * flatMap: 将对象转换为流
     */
    @Test
    public void flatMapTest(){
        Data.getCartSkuList()
                .stream()
                .flatMap(sku-> Arrays.stream(sku.getSkuName().split("")))
                .forEach(sku-> System.out.println(sku));
    }

    /**
     * peek: 中间操作，类型foreach ，不会影响后面的执行
     *
     * peek 为无状态操作，所以输出结果为交替执行
     */
    @Test
    public void peekTest(){
        Data.getCartSkuList()
                .stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * peek 为无状态操作
     * sorted 为有状态操作
     * 所以打印结果为，先输出peek，然后输出 结果
     */
    @Test
    public void sortTest(){
        Data.getCartSkuList()
                .stream()
                .peek(sku -> System.out.println(sku.getSkuName()))
                .sorted(Comparator.comparing(Sku::getTotalPrice).reversed())
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * 跳过指定N条数,有状态操作
     */
    @Test
    public void skipTest(){
        Data.getCartSkuList()
                .stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                // skip
                .skip(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     * 获取前几条数据，有状态操作
     */
    @Test
    public void limitTest(){
        Data.getCartSkuList()
                .stream()
                .sorted(Comparator.comparing(Sku::getTotalPrice))
                // limit(3)
                .limit(3)
                .forEach(sku -> System.out.println(JSON.toJSONString(sku, true)));
    }

    /**
     *  ============================= 终端操作 ======================================
     */


    /**
     * 短路操作
     *
     * allMatch : 所有都匹配，返回true，只要有一个不符合，则返回false
     * anyMatch : 任意一个匹配，返回true
     * noneMatch: 所有都不匹配，返回true
     *
     * findFirst :
     * findAny : 在并行时，效率要高于findFirst
     */
    @Test
    public void matchTest(){
        boolean match = Data.getCartSkuList().stream()
                .peek(sku -> System.out.println(sku))
                .allMatch(sku -> sku.getTotalPrice() > 10000);
        System.out.println(match);
    }

    /**
     * 非短路操作
     *
     * max | min | count
     */
    @Test
    public void maxTest(){
        OptionalDouble max = Data.getCartSkuList()
                .stream()
                .mapToDouble(Sku::getTotalPrice)
                // max
                .max();
        System.out.println(JSON.toJSONString(max.getAsDouble(), true));
    }

}
