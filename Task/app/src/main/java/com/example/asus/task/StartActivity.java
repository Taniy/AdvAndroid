package com.example.asus.task;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.concurrent.TimeUnit;


public class StartActivity extends Activity {
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }

     @Override
    protected void onStart() {

         super.onStart();

         final Activity activity = this;
        thread = (Thread)getLastNonConfigurationInstance();
         if(thread == null) {
             thread = new Thread(new Runnable() {
                 public void run() {
                     try {
                         Thread.sleep(2000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }

                     runOnUiThread(
                             new Runnable() {
                                 @Override
                                 public void run() {
                                     Intent intent = new Intent(activity, MainActivity.class);
                                     startActivity(intent);
                                     activity.finish();
                                     ;
                                 }
                             });
                 }
             });
             thread.start();
         }
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        return thread;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
