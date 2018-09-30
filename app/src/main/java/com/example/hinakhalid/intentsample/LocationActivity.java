package com.example.hinakhalid.intentsample;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LocationActivity extends AppCompatActivity {

    TextView longitude; // = (TextView) findViewById(R.id.longitude);
    TextView latitude; //= (TextView) findViewById(R.id.latitude);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        longitude = (TextView) findViewById(R.id.longitude);
        latitude = (TextView) findViewById(R.id.latitude);
    }

    public void  OpenMap(View view) {

        // Show a Confirmation Dialogue First
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmation!");
        builder.setMessage("Are you sure you want to open the location on Map?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String longi = longitude.getText().toString();
                String lat = latitude.getText().toString();
                if (longi.isEmpty() || lat.isEmpty()) {
                    Toast toast = Toast.makeText(LocationActivity.this, "Enter the Longitude and latitude of the Location", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Uri geoLocation = null;
                    try {
                        //geoLocation = Uri.parse("geo:38.0316114,-78.5107279?z=11");
                        geoLocation = Uri.parse("geo:" + longi + "," + lat + "?z=11");
                    } catch (Exception e) {
                        Log.e("Activity&Intent Example", "URI Exception");
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(geoLocation);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've changed your mind :-/", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}
