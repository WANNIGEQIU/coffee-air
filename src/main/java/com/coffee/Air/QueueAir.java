package com.coffee.Air;

public class QueueAir<E> {
    private final static Object[] EMPTY_ELEMENTS = {};

    private Object[] elements;


    public QueueAir () {
        elements = EMPTY_ELEMENTS;
    }
    public int size() {
        return elements.length;
    }

    /**
     * 入队
     * @param element
     */
    public void add(E element) {
        Object[] arr = new Object[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
        }
        arr[elements.length] = element;
        elements = arr;
    }

    /**
     * 出队
     * @return
     */
    public E poll() {
        Object element = elements[0];
        Object[] arr = new Object[elements.length - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = elements[i+1];
        }
        elements = arr;
        return (E) element;
    }




}
