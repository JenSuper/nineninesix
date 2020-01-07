package com.jensuper.nineninesix.stream;

import com.alibaba.fastjson.JSON;
import com.jensuper.nineninesix.common.Data;
import com.jensuper.nineninesix.entity.Sku;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jichao
 * @version V1.0
 * @description: lambda编程，对集合的操作
 * @date 2019/12/29
 */
public class StreamCollector {

    /**
     * 收集器
     *
     * Collectors.groupingBy 以某一条件进行分组
     */
    @Test
    public void groupTest(){
        Map<Integer, List<Sku>> group = Data.getCartSkuList()
                .stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.groupingBy(Sku::getSkuId));
        System.out.println(JSON.toJSONString(group, true));
    }
    /**
     * 收集器
     *
     * Collectors.partitioningBy 按区域划分，返回结果为 true 和false 分为2类
     */
    @Test
    public void parttingTest(){
        Map<Boolean, List<Sku>> part = Data.getCartSkuList()
                .stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 500));
        System.out.println(JSON.toJSONString(part, true));
    }

}
