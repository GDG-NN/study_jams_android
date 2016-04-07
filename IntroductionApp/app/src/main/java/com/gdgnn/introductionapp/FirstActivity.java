package com.gdgnn.introductionapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    private static final String LOG_TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.wtf(LOG_TAG, "onCreate");
    }

    //It is not required to override the callbacks below
    //If you don't have any business logic to put into those callbacks
    //Just an example to study callbacks on a practice
    @Override
    protected void onStart() {
        super.onStart();
        //Don't repeat at home and production code :)
        Log.wtf(LOG_TAG, "onStart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.wtf(LOG_TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.wtf(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.wtf(LOG_TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.wtf(LOG_TAG, "onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.wtf(LOG_TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.wtf(LOG_TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.wtf(LOG_TAG, "onDestroy");
    }

    //Example of explicit intent
    //This is also example of click handling
    //The methods below are bound to buttons in activity_first.xml
    //See android:onClick
    public void openSecond(View v) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    //Example of explicit intent
    public void openChrome(View v) {
        PackageManager manager = getPackageManager();
        Intent chromeIntent = manager.getLaunchIntentForPackage("com.android.chrome");
        if (chromeIntent != null) {
            startActivity(chromeIntent);
        }
    }

    //Example of implicit intent
    public void openBrowser(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse("http://www.google.com"));
        browserIntent.addCategory(Intent.CATEGORY_BROWSABLE);
        if (browserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(browserIntent);
        }
    }
}
