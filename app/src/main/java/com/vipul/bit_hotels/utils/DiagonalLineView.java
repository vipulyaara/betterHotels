package com.vipul.bit_hotels.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.vipul.bit_hotels.R;

public class DiagonalLineView extends View {

private int dividerColor;
private Paint paint;

public DiagonalLineView(Context context)
{
    super(context);
    init(context);
}

public DiagonalLineView(Context context, AttributeSet attrs)
{
    super(context, attrs);
    init(context);
}

public DiagonalLineView(Context context, AttributeSet attrs, int defStyle)
{
    super(context, attrs, defStyle);
    init(context);
}

private void init(Context context)
{
    Resources resources = context.getResources();
    dividerColor = resources.getColor(R.color.white);

    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(dividerColor);
         paint.setStrokeWidth(resources.getDimension(R.dimen.vertical_divider_width));
}

@Override
protected void onDraw(Canvas canvas)
{
    super.onDraw(canvas);
    canvas.drawLine(0, getHeight(), getWidth(), 0, paint);
}

}