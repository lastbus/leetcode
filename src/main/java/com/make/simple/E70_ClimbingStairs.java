package com.make.simple;

/**
 * @author make
 * @create 2021-05-10
 */
public class E70_ClimbingStairs {

    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        while (n > 0) {
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return c;
    }

}
