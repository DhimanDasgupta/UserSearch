package com.dhimandasgupta.countrysearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dhimandasgupta on 15/01/17.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<String> mCountries;

    public CountryAdapter() {

    }

    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, int position) {
        holder.bind(mCountries.get(position));
    }

    @Override
    public int getItemCount() {
        return mCountries == null ? 0 : mCountries.size();
    }

    public void setUsers(final List<String> users) {
        mCountries = users;
        notifyDataSetChanged();
    }

    public static final class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public CountryViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        public void bind(final String user) {
            mTextView.setText(user);
        }
    }
}
