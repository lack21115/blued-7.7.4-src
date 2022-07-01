package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.soft.blued.utils.Logger;
import java.text.DecimalFormat;

public class HelloProgressView extends View {
  DecimalFormat a = new DecimalFormat("0.0");
  
  private ValueAnimator b;
  
  private float c = a(15.0F);
  
  private int d = (int)Math.max(5.0F, this.c);
  
  private float e = 0.0F;
  
  private float f = 0.0F;
  
  private float g = 360.0F;
  
  private float h = 10.0F;
  
  private float i = 10.0F;
  
  private int j = 3000;
  
  private int[] k = new int[] { Color.parseColor("#ffffff"), Color.parseColor("#016dff"), Color.parseColor("#62d4d4"), Color.parseColor("#62d4d4") };
  
  private float[] l = new float[this.k.length];
  
  private double[] m = new double[] { 20.0D, 75.0D, 255.0D, 360.0D };
  
  public HelloProgressView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(float paramFloat) {
    byte b;
    float f = (getContext().getResources().getDisplayMetrics()).density;
    if (paramFloat >= 0.0F) {
      b = 1;
    } else {
      b = -1;
    } 
    return (int)(f * paramFloat + b * 0.5F);
  }
  
  private int a(int paramInt, boolean paramBoolean) {
    int j = a(200.0F);
    int k = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    paramInt = i;
    if (k != Integer.MIN_VALUE) {
      paramInt = i;
      if (k != 1073741824) {
        i = Math.min(j, i);
        paramInt = i;
        if (i == 0)
          paramInt = 200; 
      } 
    } 
    return paramInt;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt) {
    this.b = ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 });
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFloat1);
    stringBuilder.append("");
    Logger.e("last=====", new Object[] { stringBuilder.toString() });
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramFloat2);
    stringBuilder.append("");
    Logger.e("current=====", new Object[] { stringBuilder.toString() });
    this.b.setDuration(paramInt);
    this.b.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            HelloProgressView.a(this.a, ((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
            this.a.invalidate();
          }
        });
    this.b.start();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    float f1 = a(5.0F);
    int i = getHeight();
    int j = this.d;
    float f2 = ((i - j * 2) / 2);
    float f3 = j;
    float f4 = j;
    float f5 = 2.0F * f2;
    RectF rectF = new RectF(f3, f4, j + f5, f5 + j);
    Paint paint = new Paint();
    paint.setStyle(Paint.Style.STROKE);
    paint.setAntiAlias(true);
    paint.setStrokeWidth(f1);
    paint.setStrokeCap(Paint.Cap.ROUND);
    new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), this.k, this.l, Shader.TileMode.MIRROR);
    this.l[0] = Float.parseFloat(this.a.format(this.m[0] / this.g));
    this.l[1] = Float.parseFloat(this.a.format(this.m[1] / this.g));
    this.l[2] = Float.parseFloat(this.a.format(this.m[2] / this.g));
    this.l[3] = Float.parseFloat(this.a.format(this.m[3] / this.g));
    SweepGradient sweepGradient = new SweepGradient(f2, f2, this.k, this.l);
    Matrix matrix = new Matrix();
    matrix.setRotate(0.0F, f2, f2);
    sweepGradient.setLocalMatrix(matrix);
    paint.setShader((Shader)sweepGradient);
    paramCanvas.scale(-1.0F, 1.0F, (getWidth() / 2), (getHeight() / 2));
    paramCanvas.rotate(-89.0F, (getWidth() / 2), (getHeight() / 2));
    paramCanvas.drawArc(rectF, this.h, this.e, false, paint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
  }
  
  public void setCurrentCount(float paramFloat) {
    float f2 = this.g;
    float f1 = paramFloat;
    if (paramFloat > f2)
      f1 = f2; 
    this.f = f1;
    a(this.i, this.f, this.j);
    this.i = this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\HelloProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */