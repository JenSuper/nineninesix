package com.jensuper.nineninesix.closeresource;

import lombok.Cleanup;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author JenSuper
 * @version V1.0
 * @description: 优雅的关闭流资源
 * @date 2020/01/04
 */
public class CopyFile {

    /**
     * try - with - resource
     * 不需要手动关闭流资源
     */
    @Test
    public void test() {
        /**
         * 将需要关闭的流创建在 try 小括号内
         */
        try (
                FileOutputStream fileOutputStream =
                        new FileOutputStream(new File("F:\\java\\projects\\myself\\nineninesix\\target\\CopyFile.txt"));
                FileInputStream fileInputStream =
                        new FileInputStream(new File("F:\\java\\projects\\myself\\nineninesix\\src\\main\\java\\com\\jensuper\\nineninesix\\closeresource\\CopyFile.java"));

        ) {
            int content;
            while ((content = fileInputStream.read())!=-1) {
                fileOutputStream.write(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
