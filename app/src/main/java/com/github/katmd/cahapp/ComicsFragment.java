package com.github.katmd.cahapp;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.URL;


/**
 * A {@link Fragment} subclass to display comic strip.
 */
public class ComicsFragment extends Fragment {

    private static String TAG = "Image Loader Output";
    
    public ComicsFragment() {
        // Required empty public constructor
    }

    private String websiteImage = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View comicView = inflater.inflate(R.layout.fragment_comics, container, false);

        // Find the View that shows the Comic Strip ImageView and load an image from a known website URL
        ImageView comicStrip = (ImageView) comicView.findViewById(R.id.comic_strip);
        try {
            Glide.with(getContext()).load(websiteImage).into(comicStrip);
            Log.d(TAG, "websiteImage returned: " + websiteImage);
        }
        catch (Exception e) {
            Log.d(TAG, "websiteImage returned: " + e);
            Toast.makeText(getActivity(), getString(R.string.error_load_image_toast), Toast.LENGTH_LONG).show();
            return null;
        }
        return comicView;
    }



}
