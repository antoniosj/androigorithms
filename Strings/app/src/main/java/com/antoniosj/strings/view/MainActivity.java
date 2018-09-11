package com.antoniosj.strings.view;

import android.databinding.DataBindingUtil;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;

import com.antoniosj.strings.R;
import com.antoniosj.strings.data.WordPresenter;
import com.antoniosj.strings.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


//TODO save instance from list (rotate) - FIX

public class MainActivity extends AppCompatActivity  implements SearchView.OnQueryTextListener {

    private ArrayList<String> mWords;
    private WordAdapter mAdapter;
    private WordPresenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerViewWords.setLayoutManager(new LinearLayoutManager(this));

        presenter = new WordPresenter();
        if (savedInstanceState != null) {
            mWords = savedInstanceState.getStringArrayList("words");
        } else {
            mWords = presenter.fillWords();
        }

        binding.recyclerViewWords.setAdapter(new WordAdapter(mWords, this));

        setupSearchView();
        setupRefresh();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putStringArrayList("words", mWords);
    }

    private void setupRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mWords = presenter.fillWords();
                binding.recyclerViewWords.setAdapter(new WordAdapter(mWords, MainActivity.this));
                binding.swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    private void setupSearchView() {
        binding.searchView.setIconifiedByDefault(false);
        binding.searchView.setOnQueryTextListener(this);
        binding.searchView.setSubmitButtonEnabled(true);
        binding.searchView.setQueryHint(("Digite aqui"));
    }


    @Override
    public boolean onQueryTextSubmit(String newText) {
        if (presenter != null) {
            presenter =  new WordPresenter();
        }
        final ArrayList<String> filteredList = presenter.filter(mWords, newText);
        mAdapter = (WordAdapter) binding.recyclerViewWords.getAdapter();
        if (mAdapter != null) {
            mAdapter.setFilter(filteredList);
            return true;
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
