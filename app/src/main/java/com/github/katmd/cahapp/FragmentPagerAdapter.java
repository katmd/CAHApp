package com.github.katmd.cahapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kathleen on 5/27/2018.
 */

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 *
 */
public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    /** Number of tabs/"pages" in app **/
    final int PAGE_COUNT = 2;

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link FragmentPagerAdapter} object.
     *
     * @param context is the context of the app that allows the use of project values
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across tabs.
     */
    public FragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    // Get fragment associated with each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else {
            return new ComicsFragment();
        }
    }

    // Get page titles of tabs
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.home);
        } else {
            return mContext.getString(R.string.comic_viewer);
        }
    }

}
