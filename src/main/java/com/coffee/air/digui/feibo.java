package com.coffee.air.digui;

/**
 * 递归
 * 斐波那契数列
 */
public class feibo {

    // 1 1 2 3 5 8 13 21 33
    public static void main(String[] args) {
        System.out.println(getFeibo(4));
    }
    /**
     * 获取第n项斐波那契数列
     */
    public static int getFeibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return getFeibo(n -1) + getFeibo(n - 2);
        }

    }
}
