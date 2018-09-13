package com.antoniosj.linked.linkedlists;

import com.antoniosj.linked.model.Node;
import com.antoniosj.linked.model.NodeHelper;

public class EmailIntersection {

    public Node getIntersection(Node n1, Node n2) {

        if (n1 == null || n2 == null) {
            return null;
        }

        NodeHelper helper1 = NodeHelper.getAttributes(n1);
        NodeHelper helper2 = NodeHelper.getAttributes(n2);

       if (helper1.tail != helper2.tail) {
           return null;
       }

       Node shorter = helper1.size < helper2.size ? n1 : n2;
       Node longer  = helper1.size < helper2.size ? n2 : n1;

       longer = getNthNode(longer, Math.abs(helper1.size - helper2.size));

       //anda os 2 ponteiros até se encontrarem
       while (shorter != longer) {
           shorter = shorter.next;
           longer = longer.next;
       }

        return longer;
    }

    Node getNthNode(Node head, int n) {

        Node curr = head;

        while (n > 0 && curr != null) {
            curr = curr.next;
            n--;
        }
        return curr;
    }
}


