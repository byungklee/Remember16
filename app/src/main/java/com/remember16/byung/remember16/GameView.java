package com.remember16.byung.remember16;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
public class GameView extends View {
    private Rect myRect;
    private Paint myPaint;
    private static final int SQUARE_SIDE_LENGTH = 200;

    public GameView(Context context) {
        super(context);
        myRect = new Rect(30, 30, SQUARE_SIDE_LENGTH, SQUARE_SIDE_LENGTH);
        myPaint = new Paint();
        myPaint.setColor(Color.MAGENTA);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(39, 111, 184);
        canvas.drawRect(myRect, myPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        myRect.left = (int) event.getX() - (SQUARE_SIDE_LENGTH / 2);
        myRect.top = (int) event.getY() - (SQUARE_SIDE_LENGTH / 2);
        myRect.right = myRect.left + SQUARE_SIDE_LENGTH;
        myRect.bottom = myRect.top + SQUARE_SIDE_LENGTH;
        //myRect.

        invalidate();
        return true; // Indicates that a touch event was handled.
    }
}
//
///**
// * TODO: document your custom view class.
// */
//public class InitialView extends View {
//    private String mExampleString; // TODO: use a default from R.string...
//    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
//    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
//    private Drawable mExampleDrawable;
//
//    private TextPaint mTextPaint;
//    private float mTextWidth =100;
//    private float mTextHeight= 100;
//
//    public InitialView(Context context) {
//        super(context);
//        init(null, 0);
//    }
//
//    public InitialView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init(attrs, 0);
//    }
//
//    public InitialView(Context context, AttributeSet attrs, int defStyle) {
//        super(context, attrs, defStyle);
//        init(attrs, defStyle);
//    }
//
//    private void init(AttributeSet attrs, int defStyle) {
//        // Load attributes
//        final TypedArray a = getContext().obtainStyledAttributes(
//                attrs, R.styleable.InitialView, defStyle, 0);
//
//        mExampleString = getResources().getString(R.string.temp);
//        mExampleColor = a.getColor(
//                R.styleable.InitialView_exampleColor,
//                mExampleColor);
//        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
//        // values that should fall on pixel boundaries.
//        mExampleDimension = a.getDimension(
//                R.styleable.InitialView_exampleDimension,
//                mExampleDimension);
//
//        if (a.hasValue(R.styleable.InitialView_exampleDrawable)) {
//            mExampleDrawable = a.getDrawable(
//                    R.styleable.InitialView_exampleDrawable);
//            mExampleDrawable.setCallback(this);
//        }
//
//        a.recycle();
//
//        // Set up a default TextPaint object
//        mTextPaint = new TextPaint();
//        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
//        mTextPaint.setTextAlign(Paint.Align.LEFT);
//        Log.i("InitialView", "etst");
//        // Update TextPaint and text measurements from attributes
//        invalidateTextPaintAndMeasurements();
//    }
//
//    private void invalidateTextPaintAndMeasurements() {
//        mTextPaint.setTextSize(mExampleDimension);
//        mTextPaint.setColor(mExampleColor);
//        mTextWidth = mTextPaint.measureText(mExampleString);
//
//        Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
//        mTextHeight = fontMetrics.bottom;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        // TODO: consider storing these as member variables to reduce
//        // allocations per draw cycle.
//        int paddingLeft = getPaddingLeft();
//        int paddingTop = getPaddingTop();
//        int paddingRight = getPaddingRight();
//        int paddingBottom = getPaddingBottom();
//
//        int contentWidth = getWidth() - paddingLeft - paddingRight;
//        int contentHeight = getHeight() - paddingTop - paddingBottom;
//
//        canvas.drawColor(Color.DKGRAY);
//        Bitmap bm = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.title));
//        canvas.drawBitmap(bm, 60, 60, mTextPaint);
//
//        //canvas.drawLine(mTextX, mPointerY, mPointerX, mPointerY, mTextPaint);
//        //canvas.drawLine(15,15,100,100,mTextPaint);
//
//        // Draw the example drawable on top of the text.
//        if (mExampleDrawable != null) {
//            mExampleDrawable.setBounds(paddingLeft, paddingTop,
//                    paddingLeft + contentWidth, paddingTop + contentHeight);
//            mExampleDrawable.draw(canvas);
//            Log.i("InitView" , "this?");
//        }
//    }
//
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec,
//                             int heightMeasureSpec) {
//        setMeasuredDimension(100, 100);	//must call this. in this case, 100 pixel height and width
//    }
//
//    /**
//     * Gets the example string attribute value.
//     *
//     * @return The example string attribute value.
//     */
//    public String getExampleString() {
//        return mExampleString;
//    }
//
//    /**
//     * Sets the view's example string attribute value. In the example view, this string
//     * is the text to draw.
//     *
//     * @param exampleString The example string attribute value to use.
//     */
//    public void setExampleString(String exampleString) {
//        mExampleString = exampleString;
//        invalidateTextPaintAndMeasurements();
//    }
//
//    /**
//     * Gets the example color attribute value.
//     *
//     * @return The example color attribute value.
//     */
//    public int getExampleColor() {
//        return mExampleColor;
//    }
//
//    /**
//     * Sets the view's example color attribute value. In the example view, this color
//     * is the font color.
//     *
//     * @param exampleColor The example color attribute value to use.
//     */
//    public void setExampleColor(int exampleColor) {
//        mExampleColor = exampleColor;
//        invalidateTextPaintAndMeasurements();
//    }
//
//    /**
//     * Gets the example dimension attribute value.
//     *
//     * @return The example dimension attribute value.
//     */
//    public float getExampleDimension() {
//        return mExampleDimension;
//    }
//
//    /**
//     * Sets the view's example dimension attribute value. In the example view, this dimension
//     * is the font size.
//     *
//     * @param exampleDimension The example dimension attribute value to use.
//     */
//    public void setExampleDimension(float exampleDimension) {
//        mExampleDimension = exampleDimension;
//        invalidateTextPaintAndMeasurements();
//    }
//
//    /**
//     * Gets the example drawable attribute value.
//     *
//     * @return The example drawable attribute value.
//     */
//    public Drawable getExampleDrawable() {
//        return mExampleDrawable;
//    }
//
//    /**
//     * Sets the view's example drawable attribute value. In the example view, this drawable is
//     * drawn above the text.
//     *
//     * @param exampleDrawable The example drawable attribute value to use.
//     */
//    public void setExampleDrawable(Drawable exampleDrawable) {
//        mExampleDrawable = exampleDrawable;
//    }
//}
