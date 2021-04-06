package com.make.simple;

/**
 * @author make
 * @create 2019-12-28
 */
public class E13_RomanToIntegerSolution {

    public int romanToInt(String s) {
        String val = s.trim();
        if (val.length() == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            char next = ' ';
            if ((i + 1) < val.length()) {
                next = val.charAt(i + 1);
            }
            switch (c) {
                case 'I':
                    if (next == 'V') {
                        sum += 4;
                        i++;
                    } else if (next == 'X') {
                        sum += 9;
                        i++;
                    } else {
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (next == 'L') {
                        sum += 40;
                        i++;
                    } else if (next == 'C') {
                        sum += 90;
                        i++;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (next == 'D') {
                        sum += 400;
                        i++;
                    } else if (next == 'M') {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
                default:
                    System.out.println("Not known symbol: " + c);
            }
        }
        return sum;
    }

}
