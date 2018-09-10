package com.antoniosj.strings.arraysandstrings;



// Q1. Replace characters in place

public class ReplaceCharacters {

    public static char[] fillSpaces(char[] input, int length) {

        int spaceCount = 0;

        // side cases
        if (input == null || input.length < 1 || length > input.length) {
            return input;
        }

        for (int i = 0; i < length; i++) {
            if (input[i] == ' ') {
                spaceCount++;
            }
        }

        for (int j = length - 1, k = j + 2 * spaceCount; j >= 0; j--) {
            if (input[j] == ' ') {
                input[k--] = '2';
                input[k--] = '3';
                input[k--] = '&';
            } else {
                input[k] = input[j];
                k--;
            }
        }

        return input;
    }

}
