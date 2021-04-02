package com.wmm.concurrent.theadlocal;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangmingming160328
 * @date @2021/1/27 16:14
 */
public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {

        int threads = 3;
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        InnerClass innerClass = new InnerClass();
      ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        for(int i = 1; i <= threads; i++) {
            new Thread(() -> {
                for(int j = 0; j < 4; j++) {
                    innerClass.add(String.valueOf(j));
                    innerClass.print();
                }
                innerClass.set("hello world");
                threadLocal.set(123);
                System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                        Thread.currentThread().getName(),
                        threadLocal.hashCode(),
                        threadLocal.get().hashCode(),
                        threadLocal.get().toString());
                countDownLatch.countDown();
            }, "thread - " + i).start();
        }
        countDownLatch.await();
        System.out.println("end");
    }

    private static class InnerClass {

        public void add(String newStr) {
            StringBuilder str = Counter.counter.get();
            Counter.counter.set(str.append(newStr));
        }

        public void print() {
            System.out.printf("Thread name:%s , ThreadLocal hashcode:%s, Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }

        public void set(String words) {
            Counter.counter.set(new StringBuilder(words));
            System.out.printf("Set, Thread name:%s , ThreadLocal hashcode:%s,  Instance hashcode:%s, Value:%s\n",
                    Thread.currentThread().getName(),
                    Counter.counter.hashCode(),
                    Counter.counter.get().hashCode(),
                    Counter.counter.get().toString());
        }
    }

    private static class Counter {
        private static final ThreadLocal<StringBuilder> counter = ThreadLocal.withInitial(StringBuilder::new);
    }

}
