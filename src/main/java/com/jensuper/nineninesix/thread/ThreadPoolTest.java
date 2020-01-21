package com.jensuper.nineninesix.thread;


import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author jichao
 * @version V1.0
 * @description: 线程池
 * @date 2020/01/16
 */
public class ThreadPoolTest {

    /**
     * 线程池 三种队列 ：1. 有界队列 2. 无界队列 3. 同步移交队列
     */

    /**
     * 基于数组：有界队列 队列容量为10
     */
    @Test
    public void arrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        for (int i = 1; i < 20; i++) {
            queue.put(i);
            System.out.println("queue 添加元素" + i);
        }
    }

    /**
     * 基于链表：有界队列 容量为10
     *
     * @throws InterruptedException
     */
    @Test
    public void linkedBlockingQueue() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(10);

        for (int i = 1; i < 20; i++) {
            queue.put(i);
            System.out.println("queue 添加元素" + i);
        }
    }

    /**
     * 基于链表：无界队列
     *
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        for (int i = 1; i < 20; i++) {
            queue.put(i);
            System.out.println("queue 添加元素" + i);
        }
    }


    /**
     * 同步移交队列：一个生产线程，一个消费线程
     */
    @Test
    public void synchronousQueue() {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                queue.put(1);
                System.out.println("queue 添加元素");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                queue.take();
                System.out.println("queue 删除元素");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * 使用submit接收线程返回值
     */
    @Test
    public void submitTest() throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Integer> future = service.submit(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2 + 2;
        });
        /**
         * 只有接收到返回值才会执行
         */
        System.out.println(future.get());
    }

    /**
     * excute 执行任务
     */
    @Test
    public void executeTest() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int a = 2 + 2;
            System.out.println("执行结果" + a);
        });
        Thread.sleep(2000);
    }


}
