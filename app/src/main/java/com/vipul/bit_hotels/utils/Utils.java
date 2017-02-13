package com.vipul.bit_hotels.utils;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.koushikdutta.ion.Ion;
import com.vipul.bit_hotels.R;

/**
 * Created by vipulkumar on 04/10/16.
 */

public class Utils {

    public static void loadGifImageWithIon(ImageView imageView, String imageUrl) {
        Ion.with(imageView)
                .animateLoad(R.anim.abc_fade_in)
                .animateIn(R.anim.abc_fade_in)
                .load("file:///android_asset/" + imageUrl + ".gif");
    }

    public static void animationIn(final View view, final int animation, int delayTime, final Context context) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Animation inAnimation = AnimationUtils.loadAnimation(
                        context.getApplicationContext(), animation);
                view.setAnimation(inAnimation);
                view.setVisibility(View.VISIBLE);
            }
        }, delayTime);
    }

    public static void animationOut(final View view, final int animation, int delayTime, final boolean isViewGone, final Context context) {
        view.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Animation outAnimation = AnimationUtils.loadAnimation(
                        context.getApplicationContext(), animation);
                view.setAnimation(outAnimation);
                if (isViewGone)
                    view.setVisibility(View.GONE);
                else
                    view.setVisibility(View.INVISIBLE);
            }
        }, delayTime);
    }

    public static void startActivityWithClipReveal(Context context, Class landingActivity, View view) {
        Intent intent = new Intent(context, landingActivity);
        ActivityOptions options = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            options = ActivityOptions.makeClipRevealAnimation(view, 0, 0,
                    view.getWidth(), view.getHeight());
            context.startActivity(intent, options.toBundle());
        } else {
            context.startActivity(intent);
        }
    }
}
