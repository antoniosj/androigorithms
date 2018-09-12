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
        ArrayList<String> filteredList = new ArrayList<String>();
        if (savedInstanceState != null) {
            filteredList = savedInstanceState.getStringArrayList(getResources().getString(R.string.words));
        }

        mWords = presenter.fillWords();
        binding.recyclerViewWords.setAdapter(new WordAdapter(mWords, this));

        if (!filteredList.isEmpty() && filteredList != null) {
            mAdapter = (WordAdapter) binding.recyclerViewWords.getAdapter();
            if (mAdapter != null) {
                mAdapter.setFilter(filteredList);
            }
        }

        setupSearchView();
        setupRefresh();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter = (WordAdapter) binding.recyclerViewWords.getAdapter();
        if (mAdapter != null) {
            final ArrayList<String> filteredList = mAdapter.getFilter();
            outState.putStringArrayList(getResources().getString(R.string.words), filteredList);
        }
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
        binding.searchView.setQueryHint(getResources().getString(R.string.type_here));
    }


    @Override
    public boolean onQueryTextSubmit(String newText) {
        if (presenter == null) {
            presenter = new WordPresenter();
        }
        ArrayList<String> filteredList = presenter.filter(mWords, newText);
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
