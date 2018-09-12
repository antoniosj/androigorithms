package com.antoniosj.strings.data;

import com.antoniosj.strings.arraysandstrings.CheckTypos;
import com.antoniosj.strings.arraysandstrings.CheckWords;

import java.util.ArrayList;
import java.util.List;

public class WordPresenter {

    public ArrayList<String> fillWords() {

        ArrayList<String> words = new ArrayList<>();
        words.add("you");
        words.add("jambo");
        words.add("probably");
        words.add("despite");
        words.add("moon");
        words.add("misspellings");
        words.add("pale");
        words.add("cerveja");
        words.add("banana");
        words.add("cesar");
        words.add("recife");
        words.add("android");
        words.add("bacon");
        words.add("timhortons");
        words.add("starbucks");

        return words;
    }


    public ArrayList<String> filter(ArrayList<String > wordList, String query) {

        query = query.toLowerCase();
        final ArrayList<String> filteredList = new ArrayList<>();

        if (wordList == null){
            return null;
        }

        for (String word : wordList) {
            if (CheckWords.isPartialPermutation(query, word)) {
                filteredList.add(word);
            } else if (CheckTypos.hasOneOrZeroEdit(query, word)){
                filteredList.add(word);
            }
        }

        return filteredList;
    }



}
