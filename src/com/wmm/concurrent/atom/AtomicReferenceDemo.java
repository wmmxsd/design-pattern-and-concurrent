package com.wmm.concurrent.atom;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 17:29
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<Person> personAtomicReference = new AtomicReference<>();

        AtomicReferenceDemo atomicReferenceDemo = new AtomicReferenceDemo();
        AtomicReferenceDemo.Person person = atomicReferenceDemo.new Person("王明明", 11);

        personAtomicReference.set(person);
        System.out.println(personAtomicReference.get());

        AtomicReferenceDemo.Person person1 = atomicReferenceDemo.new Person("vrv", 22);
        personAtomicReference.getAndSet(person1);
        System.out.println(personAtomicReference.get());

        personAtomicReference.compareAndSet(person1, atomicReferenceDemo.new Person("大锅", 23));
        System.out.println(personAtomicReference.get());
    }

    private class Person {
        private String name;
        private int age;

        public Person(String name) {
            this.name = name;
        }

         Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }
}
