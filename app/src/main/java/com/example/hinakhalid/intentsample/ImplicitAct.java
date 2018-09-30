package com.example.hinakhalid.intentsample;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ImplicitAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);

        Toast toast = Toast.makeText(this, "starting with implicit", Toast.LENGTH_LONG);
        toast.show();
        phoneNumber = "";
    }

    String yourMessage;
    String phoneNumber;

    public void implicitIntent(View view) {
        final EditText edtText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Message");
        builder.setMessage("Type Your Message");
        builder.setCancelable(false);
        builder.setView(edtText);
        builder.setNeutralButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(), "Hello " + edtText.getText() + " ! how are you?", Toast.LENGTH_LONG).show();
                yourMessage = edtText.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, yourMessage);
                sendIntent.setType("text/plain");

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }
            }
        });
        builder.show();


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


    public void openCall(View view) {
        //phoneNumber = "tel:03053996778";
        if (phoneNumber.isEmpty()){
            final EditText edtText = new EditText(this);
            edtText.setInputType(3);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Phone");
            builder.setMessage("Enter Phone Number");
            builder.setCancelable(true);
            builder.setView(edtText);
            builder.setNeutralButton("Call", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    phoneNumber = edtText.getText().toString();
                }
            });
            builder.show();
        }

        if (phoneNumber.isEmpty()){
            Toast toast = Toast.makeText(this,"No Phone Number Entered to Make a Call", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            phoneNumber = "tel:" + phoneNumber;
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse(phoneNumber));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(callIntent);
        }
    }

    @Override
    public  void onStart(){
        super.onStart();
        phoneNumber = getIntent().getExtras().getString("PHONE_NUMBER");
    }
}

