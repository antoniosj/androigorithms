package com.antoniosj.strings.arraysandstrings;


//Q3
public class CheckTypos {

    public static boolean hasOneOrZeroEdit(String s1, String s2) {

        if (isSideCase(s1, s2)) {
            return false;
        }

        boolean hasOneEdit = true;
        int count = 0;

        //1st case: same length with 1 edit.
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                }
                if (count > 1) {
                    return false;
                }
            }
            //s2 has one edit bigger
        } else if (s1.length() + 1 == s2.length()) {

            hasOneEdit = checkDifference(s1, s2);
        } else if (s1.length() == s2.length() + 1) {

            hasOneEdit = checkDifference(s2, s1);
        }

        return hasOneEdit;
    }

    public static boolean checkDifference(String shorter, String longer) {

        int shorterIndex = 0;
        int longerIndex = 0;
        int isOneEdit = 0;

        while (shorterIndex < shorter.length() && longerIndex < longer.length()){
            if (shorter.charAt(shorterIndex) != longer.charAt(longerIndex)){
                longerIndex++;
                isOneEdit++;
            } else {
                shorterIndex++;
                longerIndex++;
            }
        }

        if (isOneEdit > 1){
            return false;
        }

        return true;
    }


    static boolean isSideCase(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return true;
        }

        int abs = Math.abs(s1.length() - s2.length());

        if (abs > 1) {
            return true;
        }

        return false;
    }
}
