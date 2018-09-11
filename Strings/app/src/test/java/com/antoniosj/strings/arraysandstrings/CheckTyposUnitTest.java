package com.antoniosj.strings.arraysandstrings;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckTyposUnitTest {

    @Test
    public void hasOneOrZeroEdit_isCorrect() {

        String s1 = "pale";
        String s2 = "ple";

        String s3 = "pales";
        String s4 = "pale";

        String s5 = "pale";
        String s6 = "bale";


        assertTrue(CheckTypos.hasOneOrZeroEdit(s1, s2));
        assertTrue(CheckTypos.hasOneOrZeroEdit(s3, s4));
        assertTrue(CheckTypos.hasOneOrZeroEdit(s5, s6));
    }

    @Test
    public void hasOneOrZeroEdit_isIncorrect() {

        String s1 = "pale";
        String s2 = "bake";

        assertFalse(CheckTypos.hasOneOrZeroEdit(s1, s2));
    }

    @Test
    public void isSideCase_isCorrect() {
        String s1 = "pale";
        String s2 = "paless";

        String s3 = "bale";
        String s4 = null;

        String s5 = "pale";
        String s6 = "ple";

        assertTrue(CheckTypos.isSideCase(s1, s2));
        assertTrue(CheckTypos.isSideCase(s3, s4));
        assertFalse(CheckTypos.isSideCase(s5, s6));
    }

    @Test
    public void checkDifference_isCorrect() {
        String shorter = "ale";
        String longer = "pale";

        assertTrue(CheckTypos.checkDifference(shorter, longer));
    }

}
