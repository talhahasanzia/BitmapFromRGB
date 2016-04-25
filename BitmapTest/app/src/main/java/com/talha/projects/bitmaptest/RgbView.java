package com.talha.projects.bitmaptest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class RgbView extends View {

    Paint p=new Paint();
    public RgbView(Context context) {
        super(context);
        init(null, 0);
    }

    public RgbView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public RgbView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        p.setColor(Color.RED);
    }

    public void setColor(int Red, int Green, int Blue)
    {

        p.setARGB(255, Red, Green, Blue);
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(0,0, getHeight(),getWidth(),p);
    }



}
