package com.antoniosj.linked;

import com.antoniosj.linked.linkedlists.EmailThread;
import com.antoniosj.linked.model.Node;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class EmailThreadUnitTest {
    Node node;

    @Before
    public void setup() {
        node = new Node("oi tudo bom");
        node.appendToTail("blz com vc");
        node.appendToTail("blz com vc");
        node.appendToTail("oi tudo otimo");
        node.appendToTail("blz com vc");
    }

    @Test
    public void removeDupEmails_isCorrect() {

        EmailThread email = new EmailThread();
        email.removeDupEmails(node);
        assertFalse(email.hasDups(node));

    }
}