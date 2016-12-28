package com.vipul.bit_hotels.reactions;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.View;

import com.vipul.bit_hotels.R;

/**
 * Created by chRyNaN on 2/26/2016.
 */
public class IconView extends View {
    private static final String TAG = IconView.class.getSimpleName();
    private Reaction reactionType;
    private Drawable icon;

    private int currentSize;
    private Mode mode;
    private boolean showText;
    private boolean showTextWhenLarge;

    private int textSize;
    private Paint textPaint;
    private Paint textBackgroundPaint;
    private int textColor;
    private int textBackgroundColor;
    //Used by the parent to know where to draw this View's text if the parent is in charge of that
    private RectF parentTextRect;
    private RectF parentTextBackgroundRect;

    private float availableWidth;
    private float availableHeight;

    public static enum Mode{
        SMALL, MEDIUM, LARGE
    }

    public IconView(Context context) {
        super(context);
        init(context, null);
    }

    public IconView(Context context, Reaction type){
        super(context);
        init(context, null);
        this.reactionType = type;
        handleImage(context);
    }

    public IconView(Context context, Reaction type, Drawable icon){
        super(context);
        init(context, null);
        this.reactionType = type;
        this.icon = icon;
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public IconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IconView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        mode = Mode.MEDIUM;
        reactionType = Reaction.LIKE;
        showText = false;
        showTextWhenLarge = false;
        textSize = 0;
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setStyle(Paint.Style.FILL);
        textColor = Color.parseColor("#FFFFFF");
        textPaint.setColor(textColor);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textBackgroundPaint.setStyle(Paint.Style.FILL);
        textBackgroundColor = Color.parseColor("#000000");
        textBackgroundPaint.setColor(textBackgroundColor);
        textBackgroundPaint.setAlpha(230);
        if(attrs != null){
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.IconView, 0, 0);
            int r = a.getInteger(R.styleable.IconView_reaction, 0);
            switch(r){
                default:
                case 0:
                    reactionType = Reaction.LIKE;
                    break;
                case 1:
                    reactionType = Reaction.LOVE;
                    break;
                case 2:
                    reactionType = Reaction.LAUGH;
                    break;
                case 3:
                    reactionType = Reaction.WOW;
                    break;
                case 4:
                    reactionType = Reaction.SAD;
                    break;
                case 5:
                    reactionType = Reaction.ANGRY;
                    break;
            }
        }
        handleImage(context);
    }

    private void handleImage(Context context){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            handleImageLollipop(context);
        }else {
            handleImagePreLollipop(context);
        }
    }

    @SuppressWarnings("deprecation")
    private void handleImagePreLollipop(Context context){
        switch(reactionType){
            default:
            case LIKE:
                icon = context.getResources().getDrawable(R.drawable.like);
                break;
            case LOVE:
                icon = context.getResources().getDrawable(R.drawable.love);
                break;
            case LAUGH:
                icon = context.getResources().getDrawable(R.drawable.laugh);
                break;
            case WOW:
                icon = context.getResources().getDrawable(R.drawable.wow);
                break;
            case SAD:
                icon = context.getResources().getDrawable(R.drawable.sad);
                break;
            case ANGRY:
                icon = context.getResources().getDrawable(R.drawable.angry);
                break;
        }
        invalidate();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void handleImageLollipop(Context context){
        switch(reactionType){
            default:
            case LIKE:
                icon = context.getDrawable(R.drawable.like);
                break;
            case LOVE:
                icon = context.getDrawable(R.drawable.love);
                break;
            case LAUGH:
                icon = context.getDrawable(R.drawable.laugh);
                break;
            case WOW:
                icon = context.getDrawable(R.drawable.wow);
                break;
            case SAD:
                icon = context.getDrawable(R.drawable.sad);
                break;
            case ANGRY:
                icon = context.getDrawable(R.drawable.angry);
                break;
        }
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH){
        super.onSizeChanged(w, h, oldW, oldH);
        currentSize = Math.min(w, h);
        availableWidth = w;
        availableHeight = h;
        textSize = (mode == Mode.LARGE) ? currentSize / 4 : currentSize / 2;
        textPaint.setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Bitmap bitmap = ViewUtils.drawableToBitmap(icon);
        bitmap = Bitmap.createScaledBitmap(bitmap, currentSize, currentSize, false);
        canvas.drawBitmap(bitmap, 0, 0, new Paint());
        if(showText || (showTextWhenLarge && mode == Mode.LARGE)){
            String text = getText();
            RectF rect = new RectF();
            int textHeight = ViewUtils.getTextHeight(text, textPaint);
            int textWidth = ViewUtils.getTextWidth(text, textPaint);
            rect.left = availableWidth - ((textWidth / 2) + textSize / 2);
            rect.right = rect.left + textWidth + (textSize / 2);
            if(3 * textHeight < availableHeight){
                rect.top = 3 * textHeight;
            }else if(2 * textHeight < availableHeight){
                rect.top = 2 * textHeight;
            }else{
                rect.top = 0;
            }
            rect.bottom = rect.top +  textHeight + textSize;
            //Draw the text background
            canvas.drawRect(rect, textBackgroundPaint);
            //Draw the text
            canvas.drawText(text, rect.left + textSize / 2, rect.top + textSize / 2, textPaint);
        }
    }

    public Reaction getReactionType(){
        return reactionType;
    }

    public void setReactionType(Reaction reactionType){
        this.reactionType = reactionType;
        handleImage(getContext());
    }

    public Drawable getIcon(){
        return icon;
    }

    public void setIcon(Drawable icon){
        this.icon = icon;
        invalidate();
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public Mode getMode(){
        return mode;
    }

    public void setMode(Mode mode){
        this.mode = mode;
        if(mode.equals(Mode.LARGE) && showTextWhenLarge){
            showText = true;
            invalidate();
        }
    }

    public boolean isShowText(){
        return showText;
    }

    public void setShowText(boolean showText){
        this.showText = showText;
        invalidate();
    }

    public boolean isShowTextWhenLarge(){
        return showTextWhenLarge;
    }

    public void setShowTextWhenLarge(boolean showTextWhenLarge){
        this.showTextWhenLarge = showTextWhenLarge;
        invalidate();
    }

    public int getTextSize(){
        return textSize;
    }

    public void setTextSize(int textSize){
        this.textSize = (int) ViewUtils.toDp(textSize, getContext());
        invalidate();
    }

    public int getTextColor(){
        return textColor;
    }

    public void setTextColor(@ColorInt int color){
        this.textColor = color;
        textPaint.setColor(color);
        invalidate();
    }

    public int getTextBackgroundColor(){
        return textBackgroundColor;
    }

    public void setTextBackgroundColor(@ColorInt int color){
        this.textBackgroundColor = color;
        textBackgroundPaint.setColor(color);
        invalidate();
    }

    public int getTextBackgroundColorAlpha(){
        return textBackgroundPaint.getAlpha();
    }

    public void setTextBackgroundColorAlpha(int alpha){
        alpha = (alpha < 0) ? 0 : alpha;
        alpha = (alpha > 250) ? 250 : alpha;
        textBackgroundPaint.setAlpha(alpha);
        invalidate();
    }

    public Paint getTextPaint(){
        return textPaint;
    }

    public Paint getTextBackgroundPaint(){
        return textBackgroundPaint;
    }

    public String getText(){
        switch(reactionType){
            default:
            case LIKE:
                return "Like";
            case LOVE:
                return "Love";
            case LAUGH:
                return "Laugh";
            case WOW:
                return "Wow";
            case SAD:
                return "Sad";
            case ANGRY:
                return "Angry";
        }
    }

    public RectF getTextRectF(float parentStartX, float parentEndX, float parentStartY, float parentEndY){
        parentTextRect = new RectF();
        String text = getText();
        int textWidth = ViewUtils.getTextWidth(text, textPaint);
        int textHeight = ViewUtils.getTextHeight(text, textPaint);
        float x = getX();
        float y = getY();
        parentTextRect.left = (x + currentSize / 2) - (textWidth / 2) + (textSize / 2);
        parentTextRect.right = parentTextRect.left + textWidth;
        if(y - 2 * textHeight > parentStartY){
            //Text Above
            parentTextRect.top = y - (2 * textHeight + (textSize / 2));
            parentTextRect.bottom = parentTextRect.top + textHeight;
        }else if(y + currentSize + textHeight < parentEndY){
            //Text Below
            parentTextRect.top = y + currentSize + (textHeight + (textSize / 2));
            parentTextRect.bottom = parentTextRect.top + textHeight;
        }else{
            parentTextRect.top = y;
            parentTextRect.bottom = parentTextRect.top + textHeight;
        }
        return parentTextRect;
    }

    public RectF getTextBackgroundRectF(float parentStartX, float parentEndX, float parentStartY, float parentEndY){
        RectF textRect = getTextRectF(parentStartX, parentEndX, parentStartY, parentEndY);
        parentTextBackgroundRect = new RectF();
        String text = getText();
        int textWidth = ViewUtils.getTextWidth(text, textPaint);
        int textHeight = ViewUtils.getTextHeight(text, textPaint);
        float x = getX();
        float y = getY();
        if(y - 2 * textHeight > parentStartY){
            parentTextBackgroundRect.top = y - 2 * textHeight;
        }else if(y + currentSize + textHeight < parentEndY){
            parentTextBackgroundRect.top = y + currentSize + textHeight;
        }else{
            parentTextBackgroundRect.top = y;
        }
        parentTextBackgroundRect.bottom = parentTextBackgroundRect.top + textHeight + textSize;
        parentTextBackgroundRect.left = (x + (currentSize / 2)) - (textWidth / 2);
        parentTextBackgroundRect.right = parentTextBackgroundRect.left + textWidth + textSize;
        return parentTextBackgroundRect;
    }

    public int getTextHeight(){
        return ViewUtils.getTextHeight(getText(), textPaint);
    }

    public int getTextWidth(){
        return ViewUtils.getTextWidth(getText(), textPaint);
    }

}
