package com.jensuper.nineninesix.guava;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author JenSuper
 * @version V1.0
 * @description: 集合
 * @date 2020/01/07
 */
public class ListDemoTest {

    /**
     * 不可变集合 - java 方式
     */
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Collection<String> newList = Collections.unmodifiableCollection(list);

        newList.remove(0);

        System.out.println(list);
    }

    /**
     * 不可变集合 - guava 方式
     */
    @Test
    public void testGuava(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        /**
         * 第一种 - 复制原集合
         */
        ImmutableSet<String> immutableSet = ImmutableSet.copyOf(list);
        // immutableSet.remove("1");

        /**
         * 第二种 - 创建不可变集合
         */
        ImmutableMultiset<String> immutableMultiset = ImmutableMultiset.of("1", "2", "3");
        // immutableMultiset.remove("1");

        /**
         * 第三种 - 以builder方式创建
         */
        ImmutableMultiset.builder()
                .add("1")
                .addAll(Sets.newHashSet("2", "3"))
                .add("5", "6")
                .build();

    }

}
