package com.vipul.bit_hotels.reactions;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by chRyNaN on 2/29/2016.
 */
public class RoundedView extends View {
    private static final String TAG = RoundedView.class.getSimpleName();

    private RectF rect;
    private Path path;
    private Paint paint;

    private float vWidth;
    private float vHeight;
    private float cornerSize;

    private float xStart;
    private float yStart;

    public RoundedView(Context context) {
        super(context);
        init(context, null);
    }

    public RoundedView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public RoundedView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RoundedView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#FFFFFF"));
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(230);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH){
        Log.d(TAG, "onSizeChanged: w = " + w + "; h = " + h + "; oldW = " + oldW + "; oldH = " + oldH);
        vWidth = w;
        vHeight = h;
        float xPad = (getPaddingLeft() + getPaddingRight() <= 0) ? ViewUtils.toPixel(8, getContext()) :
                (getPaddingLeft() + getPaddingRight()) / 2;
        float bPad = xPad / 2;
        float regIconSize = (vWidth - (2 * xPad + 5 * bPad)) / 6;
        cornerSize = xPad + regIconSize / 2;
        xStart = cornerSize;
        yStart = 0f;
        Log.d(TAG, "onSizeChanged: padding left = " + getPaddingLeft() + "; padding right = " + getPaddingRight() +
                "; padding top = " + getPaddingTop() + "; padding bottom = " + getPaddingBottom());
        Log.d(TAG, "onSizeChanged: xStart = " + (getX() + xStart) + "; cornerSize = " + cornerSize + "; x = " + getX());
    }

    @Override
    protected void onDraw(Canvas canvas){
        //Draw the background rounded rectangle
        path = new Path();
        path.moveTo(xStart, yStart);
        //Top line between curves
        path.lineTo(xStart + (vWidth - (2 * cornerSize)), yStart);
        //First curve, right side
        rect = new RectF();
        rect.left = (xStart + (vWidth) - (2 * cornerSize));
        rect.right = rect.left + cornerSize;
        rect.top = yStart;
        rect.bottom = yStart + vHeight;
        path.arcTo(rect, 270, 180);
        //Bottom line between curves
        path.lineTo(xStart, yStart + vHeight);
        //Second curve, left side
        rect.left = xStart - cornerSize;
        rect.right = xStart;
        rect.top = yStart;
        rect.bottom = yStart + vHeight;
        path.arcTo(rect, 90, 180);
        path.close();
        canvas.drawPath(path, paint);
    }

}
