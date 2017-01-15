package com.dhimandasgupta.countrysearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by dhimandasgupta on 15/01/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder mUnbinder;

    @BindView(R.id.edit_text)
    AppCompatEditText mSearchEditText;

    @BindView(R.id.button)
    AppCompatButton mSearchButton;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    protected CountryAdapter mCountryAdapter;

    protected CountrySearchEngine mCountrySearchEngine;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_search);

        mUnbinder = ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mCountryAdapter = new CountryAdapter());

        List<String> cheeses = Arrays.asList(getResources().getStringArray(R.array.countries));
        mCountrySearchEngine = new CountrySearchEngine(cheeses);
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        super.onDestroy();
    }

    protected void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    protected void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    protected void showResult(List<String> result) {
        if (result.isEmpty()) {
            Toast.makeText(this, R.string.no_country_found, Toast.LENGTH_SHORT).show();
            mCountryAdapter.setUsers(Collections.<String>emptyList());
            showProgressBar();
        } else {
            mCountryAdapter.setUsers(result);
            hideProgressBar();
        }
    }
}
