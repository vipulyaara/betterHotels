package com.vipul.bit_hotels.reactions;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chRyNaN on 3/3/2016.
 */
public class ReactionLayoutTransition extends LayoutTransition {

    public ReactionLayoutTransition(){
        super();
    }

    @Override
    public void addChild(ViewGroup parent, View child){
        if(child instanceof RoundedView){
            child.animate().alpha(1.0f).translationY(child.getHeight());
        }else{
            //TODO
        }
    }

    @Override
    public void showChild(ViewGroup parent, View child, int oldVisibility){
        if(child instanceof RoundedView){
            child.animate().alpha(1.0f).translationY(child.getHeight());
        }else{
            //TODO
        }
    }

    @Override
    public void removeChild(ViewGroup parent, View child){
        if(child instanceof RoundedView){
            child.animate().alpha(0.0f).translationY(0);
        }else{
            //TODO
        }
    }

    @Override
    public void hideChild(ViewGroup parent, View child, int newVisibility){
        if(child instanceof RoundedView){
            child.animate().alpha(0.0f).translationY(0);
        }else{
            //TODO
        }
    }

}
