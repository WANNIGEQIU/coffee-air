package com.coffee.air;

public class StackAir<E> {

    private Object[] elements;

    public StackAir() {
        this.elements = EMPTY_ELEMENTS;
    }
    public int size() {
        return elements.length;
    }

    /**
     * 入栈
     * @param element
     */
    public void push(E element) {
        int n = size();
        Object[] arr = new Object[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = elements[i];
        }
        arr[n] = element;
        elements = arr;
    }

    /**
     * 弹栈
     * @return
     */
    public E pop() {
        if (size() == 0)
            throw new RuntimeException("没有元素");

        Object element = elements[size() - 1];
        Object[] arr = new Object[size() - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i];
        }
        elements = arr;
        return (E) element;
    }

    /**
     * 查看栈顶
     * @return
     */
    public Object peek() {
        return elements[size() - 1];
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 搜索
     * @param x
     * @return
     */
    public int search(E x) {
        int index;
        if (size() == 0)
            return -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == x) {
                index = i;
                return elements.length - index;
            }
        }

        return -1;
    }

    private final static Object[] EMPTY_ELEMENTS = {};

}
