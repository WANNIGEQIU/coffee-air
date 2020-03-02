package com.coffee.air;

public class Air {
    /**
     * 整形数组比较
     * @param a
     * @param b
     * @return
     */
    public static boolean equals(int[]a,int[]b) {
        if (a == b)
            return true;
        if (a == null || b == null)
            return false;
        int length = a.length;
        if (b.length != length)
            return false;
        for (int i = 0; i < length; i++) {
            if (a[i] != b[i])
                return false;

        }
        return true;
    }

    /**
     *  外层 a.length - 1,内层 a.length - 1 - i 冒泡
     * @param a
     */
    public static void sort(int[] a) {

        if (a == null)
            throw new NullPointerException();
        if (a.length < 0)
            throw new RuntimeException("数组不合法");
        int length = a.length;
        int temp;
        for (int i = 0; i < length - 1; i ++) {
            for (int x = 0; x < length-i-1; x++){
                if (a[x] > a[x+1]) {
                    temp = a[x];
                    a[x] = a[x+1];
                    a[x+1] = temp;

                }
            }
        }

    }

    /**
     * 二分
     * @param a
     * @param x
     * @return
     */

    public static int binarySearch(int[] a,int x) {

        int low = 0;
        int high = a.length -1;

        while (low <= high) {
            int mid = (low + high) /2;
            int midVal = a[mid];

            if (x > midVal) {
                low = mid + 1;
            }else if (x < midVal) {
                high = mid - 1;
            }else {
                return mid; //found
            }
        }
        return -(low +1); // not found

    }
}
