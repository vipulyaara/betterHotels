package com.vipul.bit_hotels.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.vipul.bit_hotels.R;

/**
 * Created by vipulkumar on 01/12/16.
 */

public class SnackbarBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {
    private float value;
    private Context context;

    public SnackbarBehavior(Context context, AttributeSet attrs) {
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        return dependency instanceof LinearLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        Toast.makeText(context, "changed", Toast.LENGTH_SHORT).show();
        if ((dependency.getLeft() < child.getLeft() && child.getLeft() < dependency.getRight()) ||
                (dependency.getLeft() < child.getRight() && child.getRight() < dependency.getRight())) {
            float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
            child.setTranslationY(-400);
//            value = value - 100;
//            TranslateAnimation translateAnimation = new TranslateAnimation(0, 0,0, value);
//            translateAnimation.setFillAfter(true);
//            child.startAnimation(translateAnimation);
        }
        return true;
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, RelativeLayout child, View dependency) {
        super.onDependentViewRemoved(parent, child, dependency);
        child.setTranslationY(0);
    }

}
