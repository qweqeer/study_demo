package com.leetcode;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2019/1/4
 * @Description:
 * @Modify :
 */
public class DemoClass {


    public static void main(String[] args) {
        long a = 1234123L;
        long b1 = a >>> 3;
        long b2 = a/8;
        System.out.println(b1+";"+b2);

        int i = -1;
        i >>>= 10;
        System.out.println(i);
        long l = -1;
        l >>>= 10;
        System.out.println(l);
        short s = -1;
        s >>>= 10;
        System.out.println(s);
        byte b = -1;
        b >>>= 10;
        System.out.println(b);
    }
}
