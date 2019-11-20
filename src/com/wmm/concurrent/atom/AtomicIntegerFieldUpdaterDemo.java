package com.wmm.concurrent.atom;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 19:29
 */
public class AtomicIntegerFieldUpdaterDemo {
    private class Device {
        volatile String id;
        volatile  String name;

        public Device(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Device{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        AtomicIntegerFieldUpdaterDemo demo = new AtomicIntegerFieldUpdaterDemo();
        AtomicIntegerFieldUpdaterDemo.Device device = demo.new Device("32d421", "worker");
        System.out.println(device);
        AtomicReferenceFieldUpdater<Device, String> deviceAtomicIntegerFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Device.class, String.class, "name");

        System.out.println(deviceAtomicIntegerFieldUpdater.get(device));
        System.out.println(deviceAtomicIntegerFieldUpdater.compareAndSet(device, "worker", "wmm"));
        System.out.println(deviceAtomicIntegerFieldUpdater.get(device));
        deviceAtomicIntegerFieldUpdater.getAndSet(device, "1");
        System.out.println(deviceAtomicIntegerFieldUpdater.get(device));
    }
}
