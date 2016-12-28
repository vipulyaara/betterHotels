package com.vipul.bit_hotels.reactions;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by chRyNaN on 3/3/2016.
 */
public class ReactionButton extends Button implements ReactionEvents, View.OnLongClickListener {
    private ReactionPopup popup;
    private float x, y;

    public ReactionButton(Context context) {
        super(context);
        init(context, null);
    }

    public ReactionButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ReactionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ReactionButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        popup = new ReactionPopup(context);
        setOnLongClickListener(this);
        x = 0f;
        y = 0f;
    }

    public ReactionPopup getPopup(){
        return popup;
    }

    @Override
    public void onLike() {

    }

    @Override
    public void onLove() {

    }

    @Override
    public void onLaugh() {

    }

    @Override
    public void onWow() {

    }

    @Override
    public void onSad() {

    }

    @Override
    public void onAngry() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public boolean onLongClick(View v) {
        MotionEvent event = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                MotionEvent.ACTION_DOWN, x, y, 0);
        popup.show(event);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
        }
        return super.onTouchEvent(event);
    }

    public void addReactionSelectedListener(ReactionSelectedListener l){
        popup.addReactionSelectedListener(l);
    }

    public boolean removeReactionSelectedListener(ReactionSelectedListener l){
        return popup.removeReactionSelectedListener(l);
    }

    public void addVisibilityChangedListener(VisibilityChangedListener l){
        popup.addVisibilityChangedListener(l);
    }

    public boolean removeVisiblityChangedListener(VisibilityChangedListener l){
        return popup.removeVisibilityChangedListener(l);
    }

}
