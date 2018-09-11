package com.antoniosj.strings.data;

import com.antoniosj.strings.arraysandstrings.CheckTypos;
import com.antoniosj.strings.arraysandstrings.CheckWords;

import java.util.ArrayList;
import java.util.List;

public class WordPresenter {

    public ArrayList<String> fillWords() {

        ArrayList<String> words = new ArrayList<>();
        words.add("asdasd1");
        words.add("jambo");
        words.add("asdasd1sadasdsad");
        words.add("asdggggasd1");
        words.add("asd");
        words.add("asdasd1");
        words.add("asdasd1");
        words.add("asxxxxxdasd1");
        words.add("asdasd1sadasdsad");
        words.add("asdggggasd1");
        words.add("asd");
        words.add("asdasd1");
        words.add("asdasasdd1");
        words.add("asdaxcsd1");
        words.add("asdasd1");
        words.add("asxxxxxdasd1");
        words.add("asdasd1sadasdsad");
        words.add("asdggggasd1");
        words.add("asd");
        words.add("asdasd1");
        words.add("asdasasdd1");
        words.add("asdaxcsd1");
        words.add("asdasasdd1");
        words.add("asdaxcsd1");

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
