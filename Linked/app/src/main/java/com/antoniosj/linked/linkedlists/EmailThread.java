package com.antoniosj.linked.linkedlists;

import com.antoniosj.linked.model.Node;

import java.util.HashSet;

//Q5
public class EmailThread {


    public void removeDupEmails(Node head) {

        HashSet<String>  hashSet = new HashSet<>();

        Node curr = head;

        while (head != null) {

            if (!hashSet.contains(head.email)) {
                hashSet.add(head.email);
            } else {
                head.deleteNode(curr, head.email);
            }
            head = head.next;
        }
    }

    public boolean hasDups(Node head) {

        HashSet<String>  hashSet = new HashSet<>();
        while (head != null) {

            if (!hashSet.contains(head.email)) {
                hashSet.add(head.email);
            } else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
