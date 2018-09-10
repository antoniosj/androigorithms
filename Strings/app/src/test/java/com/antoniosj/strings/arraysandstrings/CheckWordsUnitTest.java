package com.antoniosj.strings.arraysandstrings;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckWordsUnitTest {


    @Test
    public void isPartialPermutation_isCorrect() {

        String a = "as";
        String b = "aa";

        assertTrue(CheckWords.isPartialPermutation(a, b));
    }

}
