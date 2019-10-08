package com.wmm.recursive;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    private static int sum(int i) {
        if (i == 2) {
            return 3;
        }
        return sum(i - 1) + i;
    }
}
