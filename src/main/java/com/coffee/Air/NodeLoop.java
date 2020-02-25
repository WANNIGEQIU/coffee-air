package com.coffee.Air;

/**
 * 循环链表
 *
 * @param <E>
 */
public class NodeLoop<E> {

    private E data;

    private NodeLoop<E> next = this;

    public NodeLoop(E data) {
        this.data = data;
    }


    public NodeLoop<E> nextNode() {
        return this.next;
    }

    public E getData(){
        return this.data;
    }


    public void removeNext() {
        this.next = this.next.next;
    }

    public void after(NodeLoop<E> newNode) {

        newNode.next = this.next;
        this.next = newNode;


    }





}
