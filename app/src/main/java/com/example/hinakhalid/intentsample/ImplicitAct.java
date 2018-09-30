package com.example.hinakhalid.intentsample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ImplicitAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        Toast toast = Toast.makeText(this, "starting with implicit", Toast.LENGTH_LONG);
        toast.show();
    }
    public void implicitIntent(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "My awesome text message!");
        sendIntent.setType("text/plain");

        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    public void openMap(View view) {
//        Uri geoLocation = null;
//        try {
//            geoLocation = Uri.parse("geo:38.0316114,-78.5107279?z=11");
//        } catch(Exception e) {
//            Log.e("Activity&Intent Example", "URI Exception");
//        }
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(geoLocation);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
        startActivity(new Intent(ImplicitAct.this, LocationActivity.class));
    }

}

