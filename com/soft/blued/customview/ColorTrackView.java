package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

public class ColorTrackView extends View {
  private int a;
  
  private int b;
  
  private int c = 0;
  
  private String d = "张鸿洋";
  
  private Paint e;
  
  private int f = a(15.0F);
  
  private int g = -16777216;
  
  private int h = -65536;
  
  private Rect i = new Rect();
  
  private int j;
  
  private int k;
  
  private float l;
  
  private boolean m = false;
  
  public ColorTrackView(Context paramContext) {
    super(paramContext, null);
    a();
  }
  
  public ColorTrackView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(float paramFloat) {
    return (int)TypedValue.applyDimension(2, paramFloat, getResources().getDisplayMetrics());
  }
  
  private int a(int paramInt) {
    int k = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (k != Integer.MIN_VALUE && k != 0) {
      if (k != 1073741824) {
        paramInt = 0;
      } else {
        paramInt = j;
      } 
    } else {
      paramInt = this.i.height() + getPaddingTop() + getPaddingBottom();
    } 
    int i = paramInt;
    if (k == Integer.MIN_VALUE)
      i = Math.min(paramInt, j); 
    return i;
  }
  
  private void a() {
    this.e = new Paint(1);
    this.e.setTextSize(this.f);
    this.g = getResources().getColor(2131100543);
    this.h = getResources().getColor(2131100527);
  }
  
  private void a(Canvas paramCanvas, int paramInt) {
    paramInt = this.h;
    int i = this.a;
    a(paramCanvas, paramInt, i, (int)(i + this.l * this.j));
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3) {
    this.e.setColor(paramInt1);
    if (this.m) {
      this.e.setStyle(Paint.Style.STROKE);
      paramCanvas.drawRect(paramInt2, 0.0F, paramInt3, getMeasuredHeight(), this.e);
    } 
    paramCanvas.save();
    paramCanvas.clipRect(paramInt2, 0, paramInt3, getMeasuredHeight());
    paramCanvas.drawText(this.d, this.a, (getMeasuredHeight() / 2) - (this.e.descent() + this.e.ascent()) / 2.0F, this.e);
    paramCanvas.restore();
  }
  
  private int b(int paramInt) {
    int k = View.MeasureSpec.getMode(paramInt);
    int j = View.MeasureSpec.getSize(paramInt);
    if (k != Integer.MIN_VALUE && k != 0) {
      if (k != 1073741824) {
        paramInt = 0;
      } else {
        paramInt = j;
      } 
    } else {
      paramInt = this.j + getPaddingLeft() + getPaddingRight();
    } 
    int i = paramInt;
    if (k == Integer.MIN_VALUE)
      i = Math.min(paramInt, j); 
    return i;
  }
  
  private void b() {
    this.j = (int)this.e.measureText(this.d);
    Paint.FontMetrics fontMetrics = this.e.getFontMetrics();
    this.k = (int)Math.ceil((fontMetrics.descent - fontMetrics.top));
    Paint paint = this.e;
    String str = this.d;
    paint.getTextBounds(str, 0, str.length(), this.i);
    this.k = this.i.height();
  }
  
  private void b(Canvas paramCanvas, int paramInt) {
    paramInt = this.g;
    int i = this.a;
    float f1 = i;
    float f2 = this.l;
    int j = this.j;
    a(paramCanvas, paramInt, (int)(f1 + f2 * j), i + j);
  }
  
  private void b(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3) {
    this.e.setColor(paramInt1);
    if (this.m) {
      this.e.setStyle(Paint.Style.STROKE);
      paramCanvas.drawRect(0.0F, paramInt2, getMeasuredWidth(), paramInt3, this.e);
    } 
    paramCanvas.save();
    paramCanvas.clipRect(0, paramInt2, getMeasuredWidth(), paramInt3);
    paramCanvas.drawText(this.d, this.a, (getMeasuredHeight() / 2) - (this.e.descent() + this.e.ascent()) / 2.0F, this.e);
    paramCanvas.restore();
  }
  
  private void c(Canvas paramCanvas, int paramInt) {
    paramInt = this.h;
    int i = this.a;
    float f1 = i;
    float f2 = this.l;
    int j = this.j;
    a(paramCanvas, paramInt, (int)(f1 + (1.0F - f2) * j), i + j);
  }
  
  private void d(Canvas paramCanvas, int paramInt) {
    paramInt = this.g;
    int i = this.a;
    a(paramCanvas, paramInt, i, (int)(i + (1.0F - this.l) * this.j));
  }
  
  private void e(Canvas paramCanvas, int paramInt) {
    paramInt = this.h;
    int i = this.b;
    b(paramCanvas, paramInt, i, (int)(i + this.l * this.k));
  }
  
  private void f(Canvas paramCanvas, int paramInt) {
    paramInt = this.g;
    int i = this.b;
    float f1 = i;
    float f2 = this.l;
    int j = this.k;
    b(paramCanvas, paramInt, (int)(f1 + f2 * j), i + j);
  }
  
  private void g(Canvas paramCanvas, int paramInt) {
    paramInt = this.h;
    int i = this.b;
    float f1 = i;
    float f2 = this.l;
    int j = this.k;
    b(paramCanvas, paramInt, (int)(f1 + (1.0F - f2) * j), i + j);
  }
  
  private void h(Canvas paramCanvas, int paramInt) {
    paramInt = this.g;
    int i = this.b;
    b(paramCanvas, paramInt, i, (int)(i + (1.0F - this.l) * this.k));
  }
  
  public float getProgress() {
    return this.l;
  }
  
  public int getTextChangeColor() {
    return this.h;
  }
  
  public int getTextOriginColor() {
    return this.g;
  }
  
  public int getTextSize() {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    float f = this.l;
    int i = (int)(this.j * f + this.a);
    int j = (int)(f * this.k + this.b);
    int k = this.c;
    if (k == 0) {
      a(paramCanvas, i);
      b(paramCanvas, i);
      return;
    } 
    if (k == 1) {
      d(paramCanvas, i);
      c(paramCanvas, i);
      return;
    } 
    if (k == 2) {
      f(paramCanvas, j);
      e(paramCanvas, j);
      return;
    } 
    h(paramCanvas, j);
    g(paramCanvas, j);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    b();
    setMeasuredDimension(b(paramInt1), a(paramInt2));
    this.a = getMeasuredWidth() / 2 - this.j / 2;
    this.b = getMeasuredHeight() / 2 - this.k / 2;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    Bundle bundle;
    if (paramParcelable instanceof Bundle) {
      bundle = (Bundle)paramParcelable;
      this.l = bundle.getFloat("key_progress");
      super.onRestoreInstanceState(bundle.getParcelable("key_default_state"));
      return;
    } 
    super.onRestoreInstanceState((Parcelable)bundle);
  }
  
  protected Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putFloat("key_progress", this.l);
    bundle.putParcelable("key_default_state", super.onSaveInstanceState());
    return (Parcelable)bundle;
  }
  
  public void setDirection(int paramInt) {
    this.c = paramInt;
  }
  
  public void setProgress(float paramFloat) {
    this.l = paramFloat;
    invalidate();
  }
  
  public void setText(String paramString) {
    this.d = paramString;
    requestLayout();
    invalidate();
  }
  
  public void setTextChangeColor(int paramInt) {
    this.h = paramInt;
    invalidate();
  }
  
  public void setTextOriginColor(int paramInt) {
    this.g = paramInt;
    invalidate();
  }
  
  public void setTextSize(int paramInt) {
    this.f = paramInt;
    this.e.setTextSize(paramInt);
    requestLayout();
    invalidate();
  }
  
  public enum Direction {
    a, b, c, d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\ColorTrackView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */