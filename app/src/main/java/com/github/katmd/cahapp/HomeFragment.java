package com.github.katmd.cahapp;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "Website Redirect Intent";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Find the View that shows the Official Website ImageButton
        ImageButton officialWebsiteButton = (ImageButton) rootView.findViewById(R.id.go_to_website);

        // Set click listener on the Official Website ImageButton
        officialWebsiteButton.setOnClickListener(new View.OnClickListener() {
            PackageManager packageManager = getActivity().getPackageManager();

            @Override
            public void onClick(View view) {
                Intent officialWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calvinandhobbes.com/") );
                if (officialWebsiteIntent.resolveActivity(packageManager) != null) {
                    Toast.makeText(getActivity(), getString(R.string.go_to_website_toast), Toast.LENGTH_LONG).show();
                    startActivity(officialWebsiteIntent);
                } else {
                    Toast.makeText(getActivity(), getString(R.string.error_go_to_website_toast), Toast.LENGTH_LONG).show();
                    Log.e(TAG, "Could not resolve website redirection intent");
                }
            }
        });
        return rootView;
    }
}
