package com.antoniosj.linked;

import com.antoniosj.linked.linkedlists.EmailIntersection;
import com.antoniosj.linked.model.Node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmailIntersectionUnitTest {
    Node node1;
    Node node2;
    EmailIntersection emailIntersection;
    @Before
    public void setup() {

        node1 = new Node("oi tudo bom");
        node1.appendToTail("blzas com vc");
        node1.appendToTail("blzxx com vc");
        node1.appendToTail("oi tudo otimo");
        node1.appendToTail("blz com vc");

        node2 = new Node("email teste");
        node2.appendToTail("oi tudo otimo");
        node2.appendToTail("blz com vc");

        node2.next.next = node1.next.next.next;

        emailIntersection = new EmailIntersection();
    }

    @Test
    public void getIntersection_isCorrect() {

        Node result = emailIntersection.getIntersection(node1, node2);

        Assert.assertEquals("oi tudo otimo", result.email);
    }



}
