package com.jensuper.nineninesix.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.util.List;


/**
 * @author JenSuper
 * @version V1.0
 * @description: 统计词频
 * @date 2020/01/08
 */
public class WordCountTest {

    private static String text = "百度近期引入了一位副总裁级别的高管褚昱，" +
            "负责市场公关和政府关系，百度公关市场负责人袁佛玉和政府关系负责人张东晨都向褚昱汇报。" +
            "资料显示，褚昱2016年出任阿里巴巴集团副总裁。更早之前，褚昱从2008年起进入互联网企业工作，" +
            "先后出任过京东集团、联想集团中国区副总裁，负责集团政府事务工作。对于此次人事引进，目前百度暂无回应。";

    @Test
    public void count() {
        // 1. 创建集合
        HashMultiset<Character> multiset = HashMultiset.create();
        // 2. 将文本转换为字节
        char[] chars = text.toCharArray();
        // 3. 将字节添加到集合中
        Chars.asList(chars)
                .stream()
                .forEach(charData -> {
                    multiset.add(charData);
                });
        // 4. 获取词频
        System.out.println("所有词总数：" + multiset.size());
        // count 中的参数必须为单引号，否则会认为是字符串
        System.out.println("当前出现词频：" + multiset.count('0'));
    }
}
