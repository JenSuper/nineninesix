package com.jensuper.nineninesix.guava;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author JenSuper
 * @version V1.0
 * @description: 文件复制 ： guava
 * @date 2020/01/13
 */
public class CopyFileTest {

    @Test
    public void Files(){
        /**
         * 创建对应的 Source 和 Sink 
         */
        CharSource charSource = Files.asCharSource(new File("F:\\java\\projects\\myself\\nineninesix\\src\\main\\java\\com\\jensuper\\nineninesix\\guava\\CopyFileTest.java"), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File("F:\\java\\projects\\myself\\nineninesix\\target\\CopyFileTest.txt"), Charsets.UTF_8);
        try {
            charSource.copyTo(charSink);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
