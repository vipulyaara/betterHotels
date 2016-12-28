package com.vipul.bit_hotels.activity;

import android.content.Context;
import android.support.design.widget.AppBarFlingFixBehavior;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by vipulkumar on 17/08/16.
 */
public class BaseActivity extends AppCompatActivity {


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
