package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import com.soft.blued.R;

public class CountDownView extends TextView {
  private int a;
  
  private float b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private Paint f;
  
  private RectF g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private float k;
  
  private OnCountDownFinishListener l;
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CountDownView);
    this.a = typedArray.getColor(3, paramContext.getResources().getColor(2131100528));
    this.b = typedArray.getFloat(4, 2.0F);
    this.c = typedArray.getDimensionPixelSize(2, a(18.0F));
    this.i = typedArray.getColor(1, paramContext.getResources().getColor(2131100528));
    this.j = typedArray.getInteger(0, 5);
    typedArray.recycle();
    this.f = new Paint(1);
    this.f.setAntiAlias(true);
    this.h = a(3.0F);
    setWillNotDraw(false);
  }
  
  private int a(float paramFloat) {
    return (int)TypedValue.applyDimension(2, paramFloat, getResources().getDisplayMetrics());
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    this.f.setColor(this.a);
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setStrokeWidth(this.b);
    paramCanvas.drawArc(this.g, -90.0F, this.k, false, this.f);
    Paint paint = new Paint();
    paint.setAntiAlias(true);
    paint.setTextAlign(Paint.Align.CENTER);
    StringBuilder stringBuilder = new StringBuilder();
    int i = this.j;
    stringBuilder.append(i - (int)(this.k / 360.0F * i));
    stringBuilder.append("");
    String str = stringBuilder.toString();
    paint.setTextSize(this.c);
    paint.setColor(this.i);
    Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
    i = (int)((this.g.bottom + this.g.top - fontMetricsInt.bottom - fontMetricsInt.top) / 2.0F);
    paramCanvas.drawText(str, this.g.centerX(), i, paint);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = getMeasuredWidth();
    this.e = getMeasuredHeight();
    float f1 = this.b;
    float f2 = f1 / 2.0F;
    paramInt1 = this.h;
    this.g = new RectF(f2 + 0.0F + paramInt1, f1 / 2.0F + 0.0F + paramInt1, this.d - f1 / 2.0F - paramInt1, this.e - f1 / 2.0F - paramInt1);
  }
  
  public void setAddCountDownListener(OnCountDownFinishListener paramOnCountDownFinishListener) {
    this.l = paramOnCountDownFinishListener;
  }
  
  public void setCountdownTime(int paramInt) {
    this.j = paramInt;
  }
  
  public static interface OnCountDownFinishListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CountDownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */