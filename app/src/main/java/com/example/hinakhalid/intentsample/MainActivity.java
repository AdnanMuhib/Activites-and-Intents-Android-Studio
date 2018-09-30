package com.example.hinakhalid.intentsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Activity&Intent Example", "MainActivity 1 onCreate");
        setContentView(R.layout.activity_main);
    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity&Intent Example", "MainActivity 1 onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity&Intent Example", "MainActivity 1 onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity&Intent Example", "MainActivity 1 onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity&Intent Example", "MainActivity 1 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity&Intent Example", "MainActivity 1 onStop");
    }

    public void startActivity2(View view) {
        Intent replyIntent = new Intent(this,ResponseAct.class);
        startActivity(replyIntent);

    }


    public void implicitIntent(View view) {
        Intent implIntent = new Intent(this,ImplicitAct.class);
        startActivity(implIntent);
    }

}
