package com.coffee.MyArrary;

public class ArrayAir {

    private int[] elements;

    public ArrayAir(){
        elements = new int[0];
    }

    public int size() {
        return elements.length;
    }

    public void add(int element){
        int x = this.size() + 1;
        int[] arr = new int[x];
        for (int i = 0; i < elements.length; i++) {
            arr[i]=elements[i];
        }
        arr[size()] = element;
        elements = arr;
    }

    public String toString() {
        // System.out.println(Arrays.toString(elements));
        if (size() == 0)
            return "{}";
        int max = size() -1;
        if (max < 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < elements.length; i++) {
            sb.append(i);
            if (i == max)
                return sb.append("}").toString();
            sb.append(",");
        }
        return sb.toString();
    }

    public int remove(int index) {
        check(index);
        int remValue = elements[index];
        int[] arr = new int[size() - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index) {
                arr[i]=elements[i];
            }else {
                arr[i] = elements[i+1];
            }
        }
        elements = arr;
        return remValue;

    }

    public int get(int index) {
        return elements[index];
    }

    public void insert(int index,int element) {
       check(index);
        int[] arr = new int[size() + 1];
        for (int i = 0; i < elements.length; i++) {
            if (i < index) {
                arr[i] = elements[i];
            }else {
                arr[i+1] = elements[i];
            }
        }
        arr[index]= element;
        elements = arr;

    }

    public void set(int index,int element) {
       check(index);
       elements[index]=element;

    }

    public void clear() {
        elements =new int[0];
    }


    private void check(int index) {
        if (index > size()-1 || index < 0)
            throw new RuntimeException("数组下标越界");
    }
}
