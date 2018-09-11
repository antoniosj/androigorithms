package com.antoniosj.strings.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.antoniosj.strings.databinding.WordItemBinding;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private ArrayList<String> mWords;
    Context mContext;

    public void setFilter(ArrayList<String> words) {
        mWords = new ArrayList<>();
        mWords.addAll(words);
        notifyDataSetChanged();
    }

    public WordAdapter(ArrayList<String> words, Context ctx) {
        mWords = words;
        mContext = ctx;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        WordItemBinding binding = WordItemBinding.inflate(layoutInflater, viewGroup, false);
        return new WordViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int position) {
        final String word = mWords.get(position);
        wordViewHolder.binding.setTitleWord(word);
    }

    @Override
    public int getItemCount() {
        return mWords.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        WordItemBinding binding;

        public WordViewHolder(WordItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
