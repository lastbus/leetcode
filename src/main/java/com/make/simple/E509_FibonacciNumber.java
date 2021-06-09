package com.make.simple;

/**
 * @author make
 * @create 2021-06-09
 */
public class E509_FibonacciNumber {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
