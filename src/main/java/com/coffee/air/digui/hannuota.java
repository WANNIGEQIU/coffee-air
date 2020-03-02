package com.coffee.air.digui;

/**
 * 汉诺塔
 *
 */
public class hannuota {
    public static void main(String[] args) {
        hannuo(2,'a','b','c');
    }
    /**
     *
     * @param n  个数
     * @param from      开始位置
     * @param in        中间位置
     * @param to        目标位置
     */
    public static void hannuo(int n,char from,char in, char to) {
            if (n == 1) {
                System.out.println("第1个盘子从"+from+"移动到"+to);
            }else {
                hannuo(n-1,from,to,in);
                System.out.println("第"+n+"盘子从"+from+"移动到"+to);
                hannuo(n-1,from,to,in);
            }
    }
}
