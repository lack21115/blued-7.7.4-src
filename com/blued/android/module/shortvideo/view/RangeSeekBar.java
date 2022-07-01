package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import javax.annotation.Nullable;

public class RangeSeekBar extends View {
  private static final String a;
  
  private Thumb A;
  
  private boolean B;
  
  private boolean C = false;
  
  private OnRangeSeekBarChangeListener D;
  
  private double b;
  
  private double c;
  
  private double d = 0.0D;
  
  private double e = 1.0D;
  
  private long f = 3000L;
  
  private double g = 1.0D;
  
  private double h = 0.0D;
  
  private double i = 1.0D;
  
  private int j;
  
  private Bitmap k;
  
  private Bitmap l;
  
  private Bitmap m;
  
  private Bitmap n;
  
  private Bitmap o;
  
  private Paint p;
  
  private Paint q;
  
  private int r;
  
  private float s;
  
  private final float t = 0.0F;
  
  private float u = 0.0F;
  
  private float v = 0.0F;
  
  private boolean w;
  
  private int x = 255;
  
  private float y;
  
  private boolean z;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RangeSeekBar.class.getSimpleName());
    stringBuilder.append(" ");
    a = stringBuilder.toString();
  }
  
  public RangeSeekBar(Context paramContext, long paramLong1, long paramLong2) {
    super(paramContext);
    this.b = paramLong1;
    this.c = paramLong2;
    setFocusable(true);
    setFocusableInTouchMode(true);
    c();
  }
  
  public RangeSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public RangeSeekBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private double a(float paramFloat, int paramInt) {
    double d1;
    int i = getWidth();
    float f1 = i;
    if (f1 <= 0.0F)
      return 0.0D; 
    this.B = false;
    double d2 = paramFloat;
    float f2 = a(this.d);
    float f3 = a(this.e);
    this.g = this.f / (this.c - this.b) * (i - this.r * 2);
    if (paramInt == 0) {
      if (b(paramFloat, this.d, 0.5D))
        return this.d; 
      if (getWidth() - f3 >= 0.0F) {
        paramFloat = getWidth() - f3;
      } else {
        paramFloat = 0.0F;
      } 
      double d5 = getValueLength() - paramFloat + this.g;
      double d6 = f2;
      if (d2 > d6) {
        d1 = d2 - d6 + d6;
      } else {
        d1 = d2;
        if (d2 <= d6)
          d1 = d6 - d6 - d2; 
      } 
      if (d1 > d5) {
        this.B = true;
        d1 = d5;
      } 
      if (d1 < (this.r * 2 / 3))
        d1 = 0.0D; 
      d1 -= 0.0D;
      this.h = Math.min(1.0D, Math.max(0.0D, d1 / (i - this.r * 2)));
      return Math.min(1.0D, Math.max(0.0D, d1 / (f1 - 0.0F)));
    } 
    if (a(paramFloat, this.e, 0.5D))
      return this.e; 
    double d3 = getValueLength() - f2 + this.g;
    double d4 = f3;
    if (d2 > d4) {
      d1 = d2 - d4 + d4;
    } else {
      d1 = d2;
      if (d2 <= d4)
        d1 = d4 - d4 - d2; 
    } 
    d2 = getWidth() - d1;
    if (d2 > d3) {
      this.B = true;
      d2 = getWidth() - d3;
      d1 = d3;
    } else {
      d3 = d2;
      d2 = d1;
      d1 = d3;
    } 
    d3 = d1;
    if (d1 < (this.r * 2 / 3)) {
      d2 = getWidth();
      d3 = 0.0D;
    } 
    this.i = Math.min(1.0D, Math.max(0.0D, 1.0D - (d3 - 0.0D) / (i - this.r * 2)));
    return Math.min(1.0D, Math.max(0.0D, (d2 - 0.0D) / (f1 - 0.0F)));
  }
  
  private double a(long paramLong) {
    double d1 = this.c;
    double d2 = this.b;
    return (0.0D == d1 - d2) ? 0.0D : ((paramLong - d2) / (d1 - d2));
  }
  
  private float a(double paramDouble) {
    return (float)(getPaddingLeft() + paramDouble * (getWidth() - getPaddingLeft() - getPaddingRight()));
  }
  
  private Thumb a(float paramFloat) {
    boolean bool1 = a(paramFloat, this.d, 2.0D);
    boolean bool2 = a(paramFloat, this.e, 2.0D);
    return (bool1 && bool2) ? ((paramFloat / getWidth() > 0.5F) ? Thumb.a : Thumb.b) : (bool1 ? Thumb.a : (bool2 ? Thumb.b : null));
  }
  
  private void a(float paramFloat, boolean paramBoolean1, Canvas paramCanvas, boolean paramBoolean2) {
    float f1;
    int i;
    Bitmap bitmap;
    if (paramBoolean1) {
      bitmap = this.m;
    } else if (paramBoolean2) {
      bitmap = this.k;
    } else {
      bitmap = this.l;
    } 
    if (paramBoolean2) {
      i = 0;
    } else {
      i = this.r;
    } 
    float f2 = i;
    if (paramBoolean1) {
      f1 = this.v;
    } else {
      f1 = this.u;
    } 
    paramCanvas.drawBitmap(bitmap, paramFloat - f2, f1, this.p);
  }
  
  private void a(MotionEvent paramMotionEvent) {
    int i = (paramMotionEvent.getAction() & 0xFF00) >> 8;
    if (paramMotionEvent.getPointerId(i) == this.x) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.y = paramMotionEvent.getX(i);
      this.x = paramMotionEvent.getPointerId(i);
    } 
  }
  
  private boolean a(float paramFloat, double paramDouble1, double paramDouble2) {
    return (Math.abs(paramFloat - a(paramDouble1)) <= this.s * paramDouble2);
  }
  
  private long b(double paramDouble) {
    double d = this.b;
    return (long)(d + paramDouble * (this.c - d));
  }
  
  private void b(MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getPointerCount() > 1)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("trackTouchEvent: ");
    stringBuilder.append(paramMotionEvent.getAction());
    stringBuilder.append(" x: ");
    stringBuilder.append(paramMotionEvent.getX());
    StvLogUtils.b(stringBuilder.toString(), new Object[0]);
    int i = paramMotionEvent.findPointerIndex(this.x);
    try {
      float f = paramMotionEvent.getX(i);
      if (Thumb.a.equals(this.A)) {
        setNormalizedMinValue(a(f, 0));
        return;
      } 
      if (Thumb.b.equals(this.A))
        setNormalizedMaxValue(a(f, 1)); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private boolean b(float paramFloat, double paramDouble1, double paramDouble2) {
    return (Math.abs(paramFloat - a(paramDouble1) - this.r) <= this.s * paramDouble2);
  }
  
  private void c() {
    this.j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.trim_selected_video_handle);
    int i = bitmap.getWidth();
    int j = bitmap.getHeight();
    int k = a(11);
    int m = a(55);
    float f1 = k * 1.0F / i;
    float f2 = m * 1.0F / j;
    Matrix matrix = new Matrix();
    matrix.postScale(f1, f2);
    this.k = Bitmap.createBitmap(bitmap, 0, 0, i, j, matrix, true);
    bitmap.recycle();
    bitmap = this.k;
    this.l = bitmap;
    this.m = bitmap;
    this.r = k;
    this.s = (this.r / 2);
    this.n = BitmapFactory.decodeResource(getResources(), R.drawable.upload_overlay_black);
    this.o = BitmapFactory.decodeResource(getResources(), R.drawable.upload_overlay_trans);
    this.p = new Paint(1);
    this.q = new Paint(1);
    this.q.setStyle(Paint.Style.FILL);
    this.q.setColor(Color.parseColor("#F7C443"));
  }
  
  private void d() {
    if (getParent() != null)
      getParent().requestDisallowInterceptTouchEvent(true); 
  }
  
  private int getValueLength() {
    return getWidth() - this.r * 2;
  }
  
  public int a(int paramInt) {
    float f = (getContext().getResources().getDisplayMetrics()).density;
    return (int)(paramInt * f + 0.5F);
  }
  
  void a() {
    this.z = true;
  }
  
  void b() {
    this.z = false;
  }
  
  public long getSelectedMaxValue() {
    return b(this.i);
  }
  
  public long getSelectedMinValue() {
    return b(this.h);
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    float f1 = ((getWidth() - getPaddingRight()) - 0.0F) / this.o.getWidth();
    float f2 = a(this.d);
    float f3 = a(this.e);
    float f4 = (f3 - f2) / this.o.getWidth();
    if (f4 > 0.0F)
      try {
        Matrix matrix = new Matrix();
        matrix.postScale(f4, 1.0F);
        paramCanvas.drawBitmap(Bitmap.createBitmap(this.o, 0, 0, this.o.getWidth(), this.o.getHeight(), matrix, true), f2, this.u, this.p);
        matrix = new Matrix();
        matrix.postScale(f1, 1.0F);
        Bitmap bitmap = Bitmap.createBitmap(this.n, 0, 0, this.n.getWidth(), this.n.getHeight(), matrix, true);
        paramCanvas.drawBitmap(Bitmap.createBitmap(bitmap, 0, 0, (int)(f2 - 0.0F) + this.r / 2, this.n.getHeight()), 0.0F, this.u, this.p);
        paramCanvas.drawBitmap(Bitmap.createBitmap(bitmap, (int)(f3 - (this.r / 2)), 0, (int)(getWidth() - f3) + this.r / 2, this.n.getHeight()), (int)(f3 - (this.r / 2)), this.u, this.p);
        paramCanvas.drawRect(f2, this.u, f3, this.u + a(2), this.q);
        paramCanvas.drawRect(f2, (getHeight() - a(2)), f3, getHeight(), this.q);
        a(a(this.d), false, paramCanvas, true);
        a(a(this.e), false, paramCanvas, false);
        return;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("IllegalArgumentException--width=");
        stringBuilder.append(this.o.getWidth());
        stringBuilder.append("Height=");
        stringBuilder.append(this.o.getHeight());
        stringBuilder.append("scale_pro=");
        stringBuilder.append(f4);
        StvLogUtils.b(stringBuilder.toString(), new Object[0]);
        exception.printStackTrace();
      }  
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
    } else {
      paramInt1 = 300;
    } 
    int i = 120;
    if (View.MeasureSpec.getMode(paramInt2) != 0)
      i = View.MeasureSpec.getSize(paramInt2); 
    setMeasuredDimension(paramInt1, i);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    Bundle bundle = (Bundle)paramParcelable;
    super.onRestoreInstanceState(bundle.getParcelable("SUPER"));
    this.d = bundle.getDouble("MIN");
    this.e = bundle.getDouble("MAX");
    this.h = bundle.getDouble("MIN_TIME");
    this.i = bundle.getDouble("MAX_TIME");
  }
  
  protected Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putParcelable("SUPER", super.onSaveInstanceState());
    bundle.putDouble("MIN", this.d);
    bundle.putDouble("MAX", this.e);
    bundle.putDouble("MIN_TIME", this.h);
    bundle.putDouble("MAX_TIME", this.i);
    return (Parcelable)bundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    OnRangeSeekBarChangeListener onRangeSeekBarChangeListener;
    if (this.w)
      return super.onTouchEvent(paramMotionEvent); 
    if (paramMotionEvent.getPointerCount() > 1)
      return super.onTouchEvent(paramMotionEvent); 
    if (!isEnabled())
      return false; 
    if (this.c <= this.f)
      return super.onTouchEvent(paramMotionEvent); 
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0) {
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 5) {
              if (i != 6)
                return true; 
              a(paramMotionEvent);
              invalidate();
              return true;
            } 
            i = paramMotionEvent.getPointerCount() - 1;
            this.y = paramMotionEvent.getX(i);
            this.x = paramMotionEvent.getPointerId(i);
            invalidate();
            return true;
          } 
          if (this.z) {
            b();
            setPressed(false);
          } 
          invalidate();
          return true;
        } 
        if (this.A != null) {
          if (this.z) {
            b(paramMotionEvent);
          } else if (Math.abs(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.x)) - this.y) > this.j) {
            setPressed(true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("没有拖住最大最小值");
            StvLogUtils.b(stringBuilder.toString(), new Object[0]);
            invalidate();
            a();
            b(paramMotionEvent);
            d();
          } 
          if (this.C) {
            onRangeSeekBarChangeListener = this.D;
            if (onRangeSeekBarChangeListener != null) {
              onRangeSeekBarChangeListener.a(this, getSelectedMinValue(), getSelectedMaxValue(), 2, this.B, this.A);
              return true;
            } 
          } 
        } 
      } else {
        if (this.z) {
          b((MotionEvent)onRangeSeekBarChangeListener);
          b();
          setPressed(false);
        } else {
          a();
          b((MotionEvent)onRangeSeekBarChangeListener);
          b();
        } 
        invalidate();
        onRangeSeekBarChangeListener = this.D;
        if (onRangeSeekBarChangeListener != null)
          onRangeSeekBarChangeListener.a(this, getSelectedMinValue(), getSelectedMaxValue(), 1, this.B, this.A); 
        this.A = null;
        return true;
      } 
    } else {
      this.x = onRangeSeekBarChangeListener.getPointerId(onRangeSeekBarChangeListener.getPointerCount() - 1);
      this.y = onRangeSeekBarChangeListener.getX(onRangeSeekBarChangeListener.findPointerIndex(this.x));
      this.A = a(this.y);
      if (this.A == null)
        return super.onTouchEvent((MotionEvent)onRangeSeekBarChangeListener); 
      setPressed(true);
      a();
      b((MotionEvent)onRangeSeekBarChangeListener);
      d();
      onRangeSeekBarChangeListener = this.D;
      if (onRangeSeekBarChangeListener != null)
        onRangeSeekBarChangeListener.a(this, getSelectedMinValue(), getSelectedMaxValue(), 0, this.B, this.A); 
    } 
    return true;
  }
  
  public void setMin_cut_time(long paramLong) {
    this.f = paramLong;
  }
  
  public void setNormalizedMaxValue(double paramDouble) {
    this.e = Math.max(0.0D, Math.min(1.0D, Math.max(paramDouble, this.d)));
    invalidate();
  }
  
  public void setNormalizedMinValue(double paramDouble) {
    this.d = Math.max(0.0D, Math.min(1.0D, Math.min(paramDouble, this.e)));
    invalidate();
  }
  
  public void setNotifyWhileDragging(boolean paramBoolean) {
    this.C = paramBoolean;
  }
  
  public void setOnRangeSeekBarChangeListener(OnRangeSeekBarChangeListener paramOnRangeSeekBarChangeListener) {
    this.D = paramOnRangeSeekBarChangeListener;
  }
  
  public void setSelectedMaxValue(long paramLong) {
    if (0.0D == this.c - this.b) {
      setNormalizedMaxValue(1.0D);
      return;
    } 
    setNormalizedMaxValue(a(paramLong));
  }
  
  public void setSelectedMinValue(long paramLong) {
    if (0.0D == this.c - this.b) {
      setNormalizedMinValue(0.0D);
      return;
    } 
    setNormalizedMinValue(a(paramLong));
  }
  
  public void setTouchDown(boolean paramBoolean) {
    this.w = paramBoolean;
  }
  
  public static interface OnRangeSeekBarChangeListener {
    void a(RangeSeekBar param1RangeSeekBar, long param1Long1, long param1Long2, int param1Int, boolean param1Boolean, RangeSeekBar.Thumb param1Thumb);
  }
  
  public enum Thumb {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\RangeSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */