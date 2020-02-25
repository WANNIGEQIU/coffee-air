package com.coffee.Air;

public class ArrayAir<E> {

    private Object[] elements;

    public ArrayAir(){
        elements = EMPTY_ELEMENTS;
    }

    public int size() {
        return elements.length;
    }

    public void add(E element){
        int x = this.size() + 1;
        Object[] arr = new Object[x];
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
            sb.append(elements[i]);
            if (i == max)
                return sb.append("}").toString();
            sb.append(",");
        }
        return sb.toString();
    }

    public E remove(int index) {
        check(index);
        Object element = elements[index];
        Object[] arr = new Object[size() - 1];
        for (int i = 0; i < arr.length; i++) {
            if (i < index) {
                arr[i]=elements[i];
            }else {
                arr[i] = elements[i+1];
            }
        }
        elements = arr;
        return (E)element;

    }

    public E get(int index) {
        return (E) elements[index];
    }

    public void insert(int index,E element) {
       check(index);
        Object[] arr = new Object[size() + 1];
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

    public void set(int index,E element) {
       check(index);
       elements[index]=element;

    }

    public void clear() {
        elements = EMPTY_ELEMENTS;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    private void check(int index) {
        if (index > size()-1 || index < 0)
            throw new RuntimeException("数组下标越界");
    }

    private final static Object[] EMPTY_ELEMENTS = {};


}
