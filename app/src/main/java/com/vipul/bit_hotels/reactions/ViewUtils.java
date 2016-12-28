package com.vipul.bit_hotels.reactions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by chRyNaN on 2/26/2016.
 */
public class ViewUtils {

    public static float toPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    public static int toPixelInt(float dp, Context context){
        return (int) toPixel(dp, context);
    }

    public static float toDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    public static float toDpInt(float px, Context context){
        return (int) toDp(px, context);
    }

    public static Point getScreenSize(Context context){
        Display display = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }

    public static float getScreenWidth(Context context){
        Point p = getScreenSize(context);
        return p.x;
    }

    public static float getScreenHeight(Context context){
        Point p = getScreenSize(context);
        return p.y;
    }

    public static Point getCenterScreenPosition(Context context){
        Point p = getScreenSize(context);
        p.x = p.x / 2;
        p.y = p.y / 2;
        return p;
    }

    public static float getCenterXScreenPosition(Context context){
        Point p = getCenterScreenPosition(context);
        return p.x;
    }

    public static float getCenterYScreenPosition(Context context){
        Point p = getCenterScreenPosition(context);
        return p.y;
    }

    public static float getCenterPosition(float start, float end){
        return (end - start) / 2;
    }

    //http://stackoverflow.com/a/10600736/1478764
    public static Bitmap drawableToBitmap(Drawable drawable){
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static Bitmap getViewAsBitmap(View view){
        Bitmap bitmap = null;
        if(view.isDrawingCacheEnabled()){
            view.buildDrawingCache();
            bitmap = view.getDrawingCache();
        }else {
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            bitmap = view.getDrawingCache();
            view.destroyDrawingCache();
            view.setDrawingCacheEnabled(false);
        }
        return bitmap;
    }

    public static Rect getTextBounds(String text, Paint paint){
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }

    public static Rect getDefaultTextBounds(String text, Context context){
        Paint paint = new Paint();
        paint.setTextSize(ViewUtils.toPixel(16, context));
        return getTextBounds(text, paint);
    }

    public static int getTextHeight(String text, Paint paint){
        Rect rect = getTextBounds(text, paint);
        return rect.height();
    }

    public static int getDefaultTextHeight(String text, Context context){
        Rect rect = getDefaultTextBounds(text, context);
        return rect.height();
    }

    public static int getTextWidth(String text, Paint paint){
        Rect rect = getTextBounds(text, paint);
        return rect.width();
    }

    public static int getDefaultTextWidth(String text, Context context){
        Rect rect = getDefaultTextBounds(text, context);
        return (rect.left + rect.right) / 2;
    }

}
