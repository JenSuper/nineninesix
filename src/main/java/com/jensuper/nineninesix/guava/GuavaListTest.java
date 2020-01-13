package com.jensuper.nineninesix.guava;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author JenSuper
 * @version V1.0
 * @description: guava中集合的使用
 * @date 2020/01/08
 */
public class GuavaListTest {

    /**
     * Set
     */
    private static Set set1 = Sets.newHashSet(1, 2, 3, 4, 5);
    private static Set set2 = Sets.newHashSet(4, 5, 6);

    /**
     * 并集 两个集合出现的所有元素
     */
    @Test
    public void union() {
        Set<Integer> set = Sets.union(set1, set2);
        System.out.println(set);
    }

    /**
     * 交集 两个集合都有的元素
     */
    @Test
    public void intersection() {
        Set<Integer> set = Sets.intersection(set1, set2);
        System.out.println(set);
    }

    /**
     * 差集：元素属于1 而且不属于2
     */
    @Test
    public void difference() {
        Set<Integer> set = Sets.difference(set1, set2);
        System.out.println(set);
    }

    /**
     * 差集：元素既不属于1 也不属于 2
     */
    @Test
    public void symmetricDifference() {
        Set<Integer> set = Sets.symmetricDifference(set1, set2);
        System.out.println(set);
    }

    /**
     * 求子集 将集合中的元素互相组合所有能出现的情况
     */
    @Test
    public void powerSet() {
        Set<Set<Integer>> set = Sets.powerSet(set1);
        System.out.println(JSON.toJSONString(set, true));
    }

    /**
     * 计算两个集合的笛卡尔积
     */
    @Test
    public void cartesianProduct() {
        Set<List<Integer>> set = Sets.cartesianProduct(set1, set2);
        System.out.println(set);
    }

    /**
     * List ------------------------------------
     */

    /**
     *  将集合按照个数合并
     */
    @Test
    public void partition() {
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3, 4, 6, 7, 8, 9, 10);
        List<List<Integer>> partition = Lists.partition(list, 4);
        System.out.println(JSON.toJSONString(partition, true));
    }
}
