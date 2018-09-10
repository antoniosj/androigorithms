package com.antoniosj.strings.arraysandstrings;

public class CheckWords {

    public static boolean isPartialPermutation(String a, String b){

        // checking side cases
        if(isSideCase(a, b)) {
            return false;
        }

        int letterPercentage = (a.length() / 3) * 2;
        int changeCount = 0;
        int limitASCII = 128;


        int[] letterCount = new int[limitASCII];

        //checking if changecount is up to 2/3
        for (int i = 0; i < a.length(); i++) {
            letterCount[a.charAt(i) - 'a'] += 1;
            letterCount[b.charAt(i) - 'a'] += 1;

            if (a.length() > 3 && a.charAt(i) != b.charAt(i)) {
                changeCount++;
                if (changeCount > letterPercentage) {
                    return false;
                }
            }
        }

        //checking if it's the same word
        for (int j = 0; j < limitASCII; j++) {
            if ((letterCount[j] % 2) != 0) {
                return false;
            }
        }

        return true;
    }

    static boolean isSideCase(String a, String b) {

        if (a == null || b == null) {
            return true;
        }

        if (a.isEmpty() || b.isEmpty()) {
            return true;
        }

        if (a.length() != b.length()){
            return true;
        }

        if (a.charAt(0) != b.charAt(0)) {
            return true;
        }

        return false;
    }
}