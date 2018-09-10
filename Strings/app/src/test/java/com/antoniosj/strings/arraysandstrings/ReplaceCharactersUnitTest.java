package com.antoniosj.strings.arraysandstrings;

import com.antoniosj.strings.arraysandstrings.ReplaceCharacters;

import org.junit.Test;

import static org.junit.Assert.*;


public class ReplaceCharactersUnitTest {

    @Test
    public void fillSpaces_isCorrect() {

        int length = 19;
        String s1 = "User is not allowed      ";
        String s2 = "User&32is&32not&32allowed";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        char[] ans = ReplaceCharacters.fillSpaces(c1, length);

        String input = new String(ans);
        String expected = new String(c2);

        assertEquals(expected, input);
    }

    @Test
    public void fillSpaces_isIncorrect() {

        int length = 10;
        String s1 = "User is not allowed      ";
        String s2 = "User&32is&32not&32allowed";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        char[] ans = ReplaceCharacters.fillSpaces(c1, length);

        String input = new String(ans);
        String expected = new String(c2);

        assertNotEquals(expected, input);
    }

    @Test
    public void fillSpaces_isEmpty() {

        int length = 19;
        String s1 = "";
        String s2 = "User&32is&32not&32allowed";

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        char[] ans = ReplaceCharacters.fillSpaces(c1, length);

        String input;
        String expected;

        if (ans != null && c2 != null) {
            input = new String(c2);
            expected = new String(ans);
        } else {
            input = "";
            expected = "";
        }
        assertNotEquals(expected, input);
    }
}