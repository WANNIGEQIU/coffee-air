package com.coffee.Air;

/**
 * 单链表
 * @param <E>
 */
public class NodeAir<E> {

    private E data;

    private NodeAir<E> next;

    public NodeAir (E data) {
        this.data = data;
    }

    public void addNode(NodeAir<E> node) {

        if (this.next == null) {
            this.next = node;
        }else {
            this.next.addNode(node);
        }
    }

    public NodeAir<E> nextNode() {
        return this.next;
    }

    public E getData(){
        return this.data;
    }

    public boolean isLast() {
        return null == this.next;
    }

    public void removeNext() {
        this.next = this.next.next;
    }

    public void after(NodeAir<E> newNode) {
            newNode.next = this.next;
             this.next = newNode;



    }

    public void show() {
          NodeAir<E> cur = this;
        while (true) {
            System.out.println(cur.getData());
            cur = cur.next;
            if (cur == null) {
                break;
            }
        }
    }



}
