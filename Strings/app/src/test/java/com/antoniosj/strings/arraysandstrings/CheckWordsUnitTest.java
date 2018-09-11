package com.antoniosj.strings.arraysandstrings;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckWordsUnitTest {


    @Test
    public void isPartialPermutation_isCorrect() {

        String s1 = "you";
        String s2 = "yuo";

        String s3 = "probably";
        String s4 = "porbalby";

        String s5 = "despite";
        String s6 = "desptie";


        assertTrue(CheckWords.isPartialPermutation(s1, s2));
        assertTrue(CheckWords.isPartialPermutation(s3, s4));
        assertTrue(CheckWords.isPartialPermutation(s5, s6));

    }

    @Test
    public void isPartialPermutation_isIncorrect() {

        String s1 = "moon";
        String s2 = "nmoo";
        String s3 = "misspellings";
        String s4 = "mpeissngslli";

        assertFalse(CheckWords.isPartialPermutation(s1, s2));
        assertFalse(CheckWords.isPartialPermutation(s3, s4));

    }

    @Test
    public void isSideCase_isCorrect() {

        String s1 = null;
        String s2 = "nmoo";

        String s3 = "";
        String s4 = "mpeissngslli";

        String s5 = "aaa";
        String s6 = "aa";

        String s7 = "go";
        String s8 = "og";

        assertTrue(CheckWords.isSideCase(s1, s2));
        assertTrue(CheckWords.isSideCase(s3, s4));
        assertTrue(CheckWords.isSideCase(s5, s6));
        assertTrue(CheckWords.isSideCase(s7, s8));

    }
}
