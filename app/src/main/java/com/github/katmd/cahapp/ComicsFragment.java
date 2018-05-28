package com.github.katmd.cahapp;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;


/**
 * A {@link Fragment} subclass to display comic strip.
 */
public class ComicsFragment extends Fragment {

    public ComicsFragment() {
        // Required empty public constructor
    }

    private String websiteImage = "https://assets.amuniversal.com/feab55401c17013627b6005056a9545d";

    // Load an image from a known website URL
    public static Drawable LoadImageFromWeb(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "Comic Strip Image");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View comicView = inflater.inflate(R.layout.fragment_comics, container, false);

        // Find the View that shows the Comic Strip ImageView
        ImageView comicStrip = (ImageView) comicView.findViewById(R.id.comic_strip);
        comicStrip.setImageDrawable(LoadImageFromWeb(websiteImage));

        return comicView;
    }



}
