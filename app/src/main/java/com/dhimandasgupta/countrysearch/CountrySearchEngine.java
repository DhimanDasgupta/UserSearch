package com.dhimandasgupta.countrysearch;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dhimandasgupta on 15/01/17.
 */

public class CountrySearchEngine {
    private List<String> mCountries;

    public CountrySearchEngine(final List<String> users) {
        mCountries = users;
    }

    public List<String> search(String query) {
        query = query.toLowerCase();

        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final List<String> result = new LinkedList<>();

        if (mCountries != null && mCountries.size() > 0) {
            for (int i = 0; i < mCountries.size(); i++) {
                if (mCountries.get(i).toLowerCase().contains(query)) {
                    result.add(mCountries.get(i));
                }
            }
        }

        return result;
    }
}
