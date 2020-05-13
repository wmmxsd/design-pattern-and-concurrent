package com.wmm.concurrent.keywordaboutlock;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * synchronized代码块由monitorenter/monitorexit指令实现
 * jvm检测到不同的竞争资源的状况时会自动切换不同限制等级的锁，这就是锁升级，降级。
 * 锁有三种，偏向锁，轻量锁，重量锁
 * 当没有竞争出现时，默认会使用偏向锁。JVM 会利用 CAS 操作（compare and swap），在对象头上的 Mark Word 部分设置线程 ID。
 * 如果有另外的线程试图锁定某个已经被偏向过的对象，
 * JVM 就需要撤销（revoke）偏向锁。
 * 并切换到轻量级锁实现。
 * 轻量级锁依赖 CAS 操作 Mark Word 来试图获取锁，如果重试成功，就使用轻量级锁；
 * 否则，进一步升级为重量级锁
 *
 * @author wangmingming160328
 * @Description
 * @date @2020/5/13 16:36
 */
public class synchronizedTest {
    //共享资源
      int i = 0;

    public synchronized void incr() {
        i++;
    }

    public void incrWithSyncThis() {
        synchronized (this) {
            i++;
        }
    }

    public void incrWithSyncClass() {
        synchronized (synchronizedTest.class) {
            i++;
        }
    }
}
