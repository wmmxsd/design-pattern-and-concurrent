package com.wmm.concurrent.countdownlatch.serviceutil;

import com.wmm.concurrent.countdownlatch.childservice.BaseHealthChecker;
import com.wmm.concurrent.countdownlatch.childservice.impl.CacheHealthChecker;
import com.wmm.concurrent.countdownlatch.childservice.impl.DatabaseHealthChecker;
import com.wmm.concurrent.countdownlatch.childservice.impl.NetworkHealthChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/11/19 17:02
 */
public class ApplicationStartupUtil {
    private static List<BaseHealthChecker> childServiceList = new ArrayList<>();
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    private ApplicationStartupUtil() {
    }

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkChildServices() throws InterruptedException, ExecutionException {
        childServiceList.add(new NetworkHealthChecker(countDownLatch));
        childServiceList.add(new DatabaseHealthChecker(countDownLatch));
        childServiceList.add(new CacheHealthChecker(countDownLatch));

        AtomicInteger integer = new AtomicInteger(0);
        ExecutorService executorService = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, "check_service_" + integer.getAndIncrement()));

        List<Future<Boolean>> futures = new ArrayList<>();
        for (BaseHealthChecker healthChecker : childServiceList) {
            futures.add(executorService.submit(healthChecker));
        }
        //Now wait till all services are checked
        countDownLatch.await();

        executorService.shutdown();

        while (true){
            if (executorService.isTerminated()) {
                System.out.println("子服务启动完成");
                break;
            }
        }

        for (Future<Boolean> future : futures) {
           if (!future.get()) {
               return false;
           }
        }

        return true;
    }
}
