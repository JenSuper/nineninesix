package com.jensuper.nineninesix.thread;


import org.apache.tomcat.util.collections.SynchronizedQueue;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author jichao
 * @version V1.0
 * @description: 线程池
 * @date 2020/01/16
 */
public class ThreadPoolTest {

    /**
     * 线程池 三种队列 ：1. 有界队列 2. 无界队列 3. 同步位移队列
     */


    /**
     * 基于数组：有界队列 队列容量为10
     */
    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        for (int i = 1; i < 20; i++) {
            queue.put(i);
            System.out.println("queue 添加元素"+i);
        }
    }

    /**
     * 基于链表：有界队列 容量为10
     * @throws InterruptedException
     */
    @Test
    public void linkedBlockingQueue() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        for (int i = 1; i < 20; i++) {
            queue.put(i);
            System.out.println("queue 添加元素"+i);
        }
    }

    /**
     * 基于链表：无界队列
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        for (int i = 1; i < 20; i++) {
            queue.put(i);
            System.out.println("queue 添加元素"+i);
        }
    }


    /**
     * 同步位移锁：一个生产线程，一个消费线程
     */
    @Test
    public void synchronousQueue(){
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(()->{
                try {
                    queue.put(1);
                    System.out.println("queue 添加元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();

        new Thread(()->{
            try {
                queue.take();
                System.out.println("queue 删除元素");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
