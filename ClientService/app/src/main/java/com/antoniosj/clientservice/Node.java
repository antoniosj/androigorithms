package com.antoniosj.clientservice;

public class Node {

    public Node next = null;
    public String email;

    public Node(String email) {
        this.email = email;
    }

    public void appendToTail(String email) {
        Node end = new Node(email);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node deleteNode(Node head, String del){
        Node n = head;
        if (n.email == del){
            return head.next;
        }

        while (n.next != null) {
            if (n.next.email == del) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
