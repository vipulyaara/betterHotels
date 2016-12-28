package com.vipul.bit_hotels.reactions;

import android.content.Context;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by chRyNaN on 2/26/2016.
 */
public class ReactionPopup extends PopupWindow {
    private boolean showing;
    private Reaction reaction;
    private Context context;

    private ReactionView view;

    public ReactionPopup(Context context){
        super(context);
        init(context);
        this.context = context;
    }

    private void init(Context context){
        showing = false;
        reaction = null;
        view = new ReactionView(context);
        view.addReactionSelectedListener(new ReactionSelectedListener() {
            @Override
            public void onLike() {
                reaction = Reaction.LIKE;
            }
            @Override
            public void onLove() {
                reaction = Reaction.LOVE;
            }
            @Override
            public void onLaugh() {
                reaction = Reaction.LAUGH;
            }
            @Override
            public void onWow() {
                reaction = Reaction.WOW;
            }
            @Override
            public void onSad() {
                reaction = Reaction.SAD;
            }
            @Override
            public void onAngry() {
                reaction = Reaction.ANGRY;
            }
        });
    }

    public boolean isShowing() {
        return showing;
    }

    public void show(MotionEvent event){
        if(!showing){
            showAtLocation(view, Gravity.NO_GRAVITY, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        showing = true;
        view.show(event);
    }

    @Override
    public void dismiss(){
        view.dismiss();
        if(showing){
            super.dismiss();
        }
        showing = false;
    }

    public void selectReaction(Reaction reaction){
        view.selectReaction(reaction);
    }

    public Reaction getSelectedReaction(){
        return reaction;
    }

    public Context getContext(){
        return context;
    }

    public ReactionView getReactionView(){
        return view;
    }

    public void addReactionSelectedListener(ReactionSelectedListener l){
        view.addReactionSelectedListener(l);
    }

    public boolean removeReactionSelectedListener(ReactionSelectedListener l){
        return view.removeReactionSelectedListener(l);
    }

    public void addVisibilityChangedListener(VisibilityChangedListener l){
        view.addVisibilityChangedListener(l);
    }

    public boolean removeVisibilityChangedListener(VisibilityChangedListener l){
        return view.removeVisibilityChangedListener(l);
    }

}
