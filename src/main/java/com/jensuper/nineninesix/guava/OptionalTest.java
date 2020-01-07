package com.jensuper.nineninesix.guava;

import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author jichao
 * @version V1.0
 * @description:  Optional 使用
 * @date 2020/01/07
 */
public class OptionalTest {

    @Test
    public void test(){
        /**
         * optional 三种创建方式
         */
        // 创建空对象
        Optional.empty();

        System.out.println("============== 我是分割线 1 =================");

        // 使用非null值创建optional
        Optional.of("");

        System.out.println("============== 我是分割线 2 =================");

        // 使用任意值创建optional对象
        Optional<String> optional = Optional.ofNullable("optional");

        System.out.println("============== 我是分割线 3 =================");

        /**
         *  当optional引用存在时执行
         *  类似的方法：map filter flatMap
         */
        optional.ifPresent(System.out::println);

        /**
         * 当optional 引用缺失时执行
         */
        optional.orElse("引用缺失");
        optional.orElseGet(() -> {
            // 自定义引用缺失的返回值
            return "自定义引用缺失";
        });
//        optional.orElseThrow(() -> {
//            throw new RuntimeException("引用缺失异常");
//        });
    }

    /**
     * 案例：处理空集合
     */
    @Test
    public void testDemo(){
        List<String> list = Arrays.asList("1","2");
        this.processTestDemo(null);
    }

    /**
     * 参数中的集合为空
     * @param listData
     */
    public void processTestDemo(List<String> listData){
        // 直接遍历会报NPE
        // listData.stream().forEach(System.out::println);

        Optional.ofNullable(listData)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);
    }

}
