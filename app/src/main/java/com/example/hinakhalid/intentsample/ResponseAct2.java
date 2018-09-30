package com.example.hinakhalid.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResponseAct2 extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    //EditText for reply back
    EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_act2);
        // Initialize view variables.
        mReply = (EditText) findViewById(R.id.editText_second);

        // Get the intent that launched this activity, and the message in
        // the intent extra.
        Intent intent = getIntent();
        String message = intent.getStringExtra("EXTRA_MESSAGE");

        // Put that message into the text_message TextView
        TextView textView = (TextView) findViewById(R.id.text_message);
        if (textView != null) {
            textView.setText(message);
        }
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();

        // Create a new intent for the reply, add the reply message to it as an extra,
        // set the intent result, and close the activity.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
    /**
     *  Working with Different States of the Activity
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MYTAG", "Response Activity 2 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MYTAG", "Response Activity 2 onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MYTAG", "Response Activity 2 onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MYTAG", "Response Activity 2 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MYTAG", "Response Activity 2 onStop");
    }
}
