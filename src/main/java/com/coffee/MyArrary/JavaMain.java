package com.coffee.MyArrary;

public class JavaMain {
    public static void main(String[] args) {
        ArrayAir arrayAir = new ArrayAir();
        for (int i = 0; i < 10; i++) {
            arrayAir.add(i);
        }
        System.out.println(arrayAir.toString());
        arrayAir.clear();
        System.out.println(arrayAir.size());
    }

}
