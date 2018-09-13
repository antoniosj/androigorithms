package com.antoniosj.linked.model;

public class NodeHelper {
    public Node tail;
    public int size;

    public NodeHelper(Node tail, int size) {
        this.tail = tail;
        this.size = size;
    }

    public static NodeHelper getAttributes(Node tail){

        if (tail == null) {
            return null;
        }

        int size = 1;
        Node curr = tail;

        while (curr.next != null) {
            size++;
            curr = curr.next;
        }
        return new NodeHelper(curr, size);
    }


}
