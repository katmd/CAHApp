package com.github.katmd.cahapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the Official Website ImageButton
        ImageButton officialWebsite = (ImageButton) findViewById(R.id.go_to_website);

        // Set click listener on the Official Website ImageButton
        officialWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent officialWebsiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calvinandhobbes.com/") );
                if (officialWebsiteIntent.resolveActivity(getPackageManager()) != null) {
                    Toast.makeText(getApplicationContext(), getString(R.string.go_to_website_toast), Toast.LENGTH_LONG).show();
                    startActivity(officialWebsiteIntent);
                }
            }
        });
    }
}
