package com.vipul.bit_hotels.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

public class FancyBehavior<V extends View>
        extends CoordinatorLayout.Behavior<V> {
    private Rect mTmpRect;

    /**
     * Default constructor for instantiating a FancyBehavior in code.
     */
    public FancyBehavior() {
    }

    /**
     * Default constructor for inflating a FancyBehavior from layout.
     *
     * @param context The {@link Context}.
     * @param attrs   The {@link AttributeSet}.
     */
    public FancyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        // Extract any custom attributes out
        // preferably prefixed with behavior_ to denote they
        // belong to a behavior
    }

//    @Override
//    public boolean layoutDependsOn(CoordinatorLayout parent, V child, View dependency) {
//        return dependency instanceof Toolbar;
//    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, V child, View dependency) {
        modifyAvatarDependingDependencyState(parent, dependency, child);
        return false;
    }

    private void modifyAvatarDependingDependencyState(
            CoordinatorLayout parent, View appBarLayout, View child) {
        if (mTmpRect == null) {
            mTmpRect = new Rect();
        }
        child.setAlpha(0.4f);
    }
//
//    private void onchanged(CoordinatorLayout parent, View child, View dependency) {
//        maybeInitProperties(child, dependency);
//        final int maxScrollDistance = (int) (mStartToolbarPosition);
//        float expandedPercentageFactor = dependency.getY() / maxScrollDistance;
//
//        if (expandedPercentageFactor < mChangeBehaviorPoint) {
//            float heightFactor = (mChangeBehaviorPoint - expandedPercentageFactor) / mChangeBehaviorPoint;
//
//            float distanceXToSubtract = ((mStartXPosition - mFinalXPosition)
//                    * heightFactor) + (child.getHeight()/2);
//            float distanceYToSubtract = ((mStartYPosition - mFinalYPosition)
//                    * (1f - expandedPercentageFactor)) + (child.getHeight()/2);
//
//            child.setX(mStartXPosition - distanceXToSubtract);
//            child.setY(mStartYPosition - distanceYToSubtract);
//
//            float heightToSubtract = ((mStartHeight - mCustomFinalHeight) * heightFactor);
//
//            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
//            lp.width = (int) (mStartHeight - heightToSubtract);
//            lp.height = (int) (mStartHeight - heightToSubtract);
//            child.setLayoutParams(lp);
//        } else {
//            float distanceYToSubtract = ((mStartYPosition - mFinalYPosition)
//                    * (1f - expandedPercentageFactor)) + (mStartHeight/2);
//
//            child.setX(mStartXPosition - child.getWidth()/2);
//            child.setY(mStartYPosition - distanceYToSubtract);
//
//            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
//            lp.width = (int) (mStartHeight);
//            lp.height = (int) (mStartHeight);
//            child.setLayoutParams(lp);
//        }
//    }
}