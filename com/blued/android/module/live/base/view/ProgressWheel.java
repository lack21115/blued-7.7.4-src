package com.blued.android.module.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.blued.android.module.live.base.R;

public class ProgressWheel extends View {
  private static final String a = ProgressWheel.class.getSimpleName();
  
  private final int b = 16;
  
  private final int c = 270;
  
  private final long d = 200L;
  
  private int e = 28;
  
  private int f = 4;
  
  private int g = 4;
  
  private boolean h = false;
  
  private double i = 0.0D;
  
  private double j = 460.0D;
  
  private float k = 0.0F;
  
  private boolean l = true;
  
  private long m = 0L;
  
  private int n = -1442840576;
  
  private int o = 16777215;
  
  private Paint p = new Paint();
  
  private Paint q = new Paint();
  
  private RectF r = new RectF();
  
  private float s = 230.0F;
  
  private long t = 0L;
  
  private boolean u;
  
  private float v = 0.0F;
  
  private float w = 0.0F;
  
  private boolean x = false;
  
  private ProgressCallback y;
  
  private boolean z;
  
  public ProgressWheel(Context paramContext) {
    super(paramContext);
    b();
  }
  
  public ProgressWheel(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ProgressWheel));
    b();
  }
  
  private void a(float paramFloat) {
    ProgressCallback progressCallback = this.y;
    if (progressCallback != null)
      progressCallback.a(paramFloat); 
  }
  
  private void a(int paramInt1, int paramInt2) {
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    if (!this.h) {
      m = paramInt1 - k - m;
      paramInt1 = Math.min(Math.min(m, paramInt2 - j - i), this.e * 2 - this.f * 2);
      k = (m - paramInt1) / 2 + k;
      paramInt2 = (paramInt2 - i - j - paramInt1) / 2 + i;
      i = this.f;
      this.r = new RectF((k + i), (paramInt2 + i), (k + paramInt1 - i), (paramInt2 + paramInt1 - i));
      return;
    } 
    int n = this.f;
    this.r = new RectF((k + n), (i + n), (paramInt1 - m - n), (paramInt2 - j - n));
  }
  
  private void a(long paramLong) {
    long l = this.m;
    if (l >= 200L) {
      this.i += paramLong;
      double d1 = this.i;
      double d2 = this.j;
      if (d1 > d2) {
        this.i = d1 - d2;
        this.m = 0L;
        this.l ^= 0x1;
      } 
      float f = (float)Math.cos((this.i / this.j + 1.0D) * Math.PI) / 2.0F + 0.5F;
      if (this.l) {
        this.k = f * 254.0F;
        return;
      } 
      f = (1.0F - f) * 254.0F;
      this.v += this.k - f;
      this.k = f;
      return;
    } 
    this.m = l + paramLong;
  }
  
  private void a(TypedArray paramTypedArray) {
    DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
    this.f = (int)TypedValue.applyDimension(1, this.f, displayMetrics);
    this.g = (int)TypedValue.applyDimension(1, this.g, displayMetrics);
    this.e = (int)TypedValue.applyDimension(1, this.e, displayMetrics);
    this.e = (int)paramTypedArray.getDimension(R.styleable.ProgressWheel_matProg_circleRadius, this.e);
    this.h = paramTypedArray.getBoolean(R.styleable.ProgressWheel_matProg_fillRadius, false);
    this.f = (int)paramTypedArray.getDimension(R.styleable.ProgressWheel_matProg_barWidth, this.f);
    this.g = (int)paramTypedArray.getDimension(R.styleable.ProgressWheel_matProg_rimWidth, this.g);
    this.s = paramTypedArray.getFloat(R.styleable.ProgressWheel_matProg_spinSpeed, this.s / 360.0F) * 360.0F;
    this.j = paramTypedArray.getInt(R.styleable.ProgressWheel_matProg_barSpinCycleTime, (int)this.j);
    this.n = paramTypedArray.getColor(R.styleable.ProgressWheel_matProg_barColor, this.n);
    this.o = paramTypedArray.getColor(R.styleable.ProgressWheel_matProg_rimColor, this.o);
    this.u = paramTypedArray.getBoolean(R.styleable.ProgressWheel_matProg_linearProgress, false);
    if (paramTypedArray.getBoolean(R.styleable.ProgressWheel_matProg_progressIndeterminate, false))
      a(); 
    paramTypedArray.recycle();
  }
  
  private void b() {
    float f;
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17) {
      f = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
    } else {
      f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0F);
    } 
    if (f != 0.0F) {
      bool = true;
    } else {
      bool = false;
    } 
    this.z = bool;
  }
  
  private void c() {
    this.p.setColor(this.n);
    this.p.setAntiAlias(true);
    this.p.setStyle(Paint.Style.STROKE);
    this.p.setStrokeWidth(this.f);
    this.q.setColor(this.o);
    this.q.setAntiAlias(true);
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setStrokeWidth(this.g);
  }
  
  private void d() {
    if (this.y != null) {
      float f = Math.round(this.v * 100.0F / 360.0F) / 100.0F;
      this.y.a(f);
    } 
  }
  
  public void a() {
    this.t = SystemClock.uptimeMillis();
    this.x = true;
    invalidate();
  }
  
  public int getBarColor() {
    return this.n;
  }
  
  public int getBarWidth() {
    return this.f;
  }
  
  public int getCircleRadius() {
    return this.e;
  }
  
  public float getProgress() {
    return this.x ? -1.0F : (this.v / 360.0F);
  }
  
  public int getRimColor() {
    return this.o;
  }
  
  public int getRimWidth() {
    return this.g;
  }
  
  public float getSpinSpeed() {
    return this.s / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.r, 360.0F, 360.0F, false, this.q);
    if (!this.z)
      return; 
    boolean bool = this.x;
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool) {
      long l = SystemClock.uptimeMillis() - this.t;
      float f1 = (float)l * this.s / 1000.0F;
      a(l);
      this.v += f1;
      f1 = this.v;
      if (f1 > 360.0F) {
        this.v = f1 - 360.0F;
        a(-1.0F);
      } 
      this.t = SystemClock.uptimeMillis();
      f1 = this.v;
      float f2 = this.k + 16.0F;
      if (isInEditMode()) {
        f2 = 135.0F;
        f1 = 0.0F;
      } 
      paramCanvas.drawArc(this.r, -f1, -f2, false, this.p);
      bool1 = bool2;
    } else {
      float f2;
      float f1 = this.v;
      if (f1 != this.w) {
        f2 = (float)(SystemClock.uptimeMillis() - this.t) / 1000.0F;
        float f = this.s;
        this.v = Math.min(this.v + f2 * f, this.w);
        this.t = SystemClock.uptimeMillis();
      } else {
        bool1 = false;
      } 
      if (f1 != this.v)
        d(); 
      f1 = this.v;
      if (!this.u) {
        f2 = (float)(1.0D - Math.pow((1.0F - f1 / 360.0F), 4.0F)) * 360.0F;
        f1 = (float)(1.0D - Math.pow((1.0F - this.v / 360.0F), 2.0F)) * 360.0F;
      } else {
        f2 = 0.0F;
      } 
      if (isInEditMode())
        f1 = 360.0F; 
      paramCanvas.drawArc(this.r, f2 - 90.0F, f1, false, this.p);
    } 
    if (bool1)
      invalidate(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int k = this.e + getPaddingLeft() + getPaddingRight();
    int i = this.e + getPaddingTop() + getPaddingBottom();
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (n == 1073741824) {
      paramInt1 = m;
    } else {
      paramInt1 = k;
      if (n == Integer.MIN_VALUE)
        paramInt1 = Math.min(k, m); 
    } 
    if (i1 == 1073741824 || n == 1073741824) {
      paramInt2 = j;
    } else {
      paramInt2 = i;
      if (i1 == Integer.MIN_VALUE)
        paramInt2 = Math.min(i, j); 
    } 
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof WheelSavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    WheelSavedState wheelSavedState = (WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(wheelSavedState.getSuperState());
    this.v = wheelSavedState.a;
    this.w = wheelSavedState.b;
    this.x = wheelSavedState.c;
    this.s = wheelSavedState.d;
    this.f = wheelSavedState.e;
    this.n = wheelSavedState.f;
    this.g = wheelSavedState.g;
    this.o = wheelSavedState.h;
    this.e = wheelSavedState.i;
    this.u = wheelSavedState.j;
    this.h = wheelSavedState.k;
    this.t = SystemClock.uptimeMillis();
  }
  
  public Parcelable onSaveInstanceState() {
    WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    wheelSavedState.a = this.v;
    wheelSavedState.b = this.w;
    wheelSavedState.c = this.x;
    wheelSavedState.d = this.s;
    wheelSavedState.e = this.f;
    wheelSavedState.f = this.n;
    wheelSavedState.g = this.g;
    wheelSavedState.h = this.o;
    wheelSavedState.i = this.e;
    wheelSavedState.j = this.u;
    wheelSavedState.k = this.h;
    return (Parcelable)wheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
    c();
    invalidate();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
      this.t = SystemClock.uptimeMillis(); 
  }
  
  public void setBarColor(int paramInt) {
    this.n = paramInt;
    c();
    if (!this.x)
      invalidate(); 
  }
  
  public void setBarWidth(int paramInt) {
    this.f = paramInt;
    if (!this.x)
      invalidate(); 
  }
  
  public void setCallback(ProgressCallback paramProgressCallback) {
    this.y = paramProgressCallback;
    if (!this.x)
      d(); 
  }
  
  public void setCircleRadius(int paramInt) {
    this.e = paramInt;
    if (!this.x)
      invalidate(); 
  }
  
  public void setInstantProgress(float paramFloat) {
    float f;
    if (this.x) {
      this.v = 0.0F;
      this.x = false;
    } 
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    } else {
      f = paramFloat;
      if (paramFloat < 0.0F)
        f = 0.0F; 
    } 
    if (f == this.w)
      return; 
    this.w = Math.min(f * 360.0F, 360.0F);
    this.v = this.w;
    this.t = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void setLinearProgress(boolean paramBoolean) {
    this.u = paramBoolean;
    if (!this.x)
      invalidate(); 
  }
  
  public void setProgress(float paramFloat) {
    float f;
    if (this.x) {
      this.v = 0.0F;
      this.x = false;
      d();
    } 
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    } else {
      f = paramFloat;
      if (paramFloat < 0.0F)
        f = 0.0F; 
    } 
    paramFloat = this.w;
    if (f == paramFloat)
      return; 
    if (this.v == paramFloat)
      this.t = SystemClock.uptimeMillis(); 
    this.w = Math.min(f * 360.0F, 360.0F);
    invalidate();
  }
  
  public void setRimColor(int paramInt) {
    this.o = paramInt;
    c();
    if (!this.x)
      invalidate(); 
  }
  
  public void setRimWidth(int paramInt) {
    this.g = paramInt;
    if (!this.x)
      invalidate(); 
  }
  
  public void setSpinSpeed(float paramFloat) {
    this.s = paramFloat * 360.0F;
  }
  
  public static interface ProgressCallback {
    void a(float param1Float);
  }
  
  static class WheelSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() {
        public ProgressWheel.WheelSavedState a(Parcel param2Parcel) {
          return new ProgressWheel.WheelSavedState(param2Parcel);
        }
        
        public ProgressWheel.WheelSavedState[] a(int param2Int) {
          return new ProgressWheel.WheelSavedState[param2Int];
        }
      };
    
    float a;
    
    float b;
    
    boolean c;
    
    float d;
    
    int e;
    
    int f;
    
    int g;
    
    int h;
    
    int i;
    
    boolean j;
    
    boolean k;
    
    private WheelSavedState(Parcel param1Parcel) {
      super(param1Parcel);
      boolean bool1;
      this.a = param1Parcel.readFloat();
      this.b = param1Parcel.readFloat();
      byte b = param1Parcel.readByte();
      boolean bool2 = true;
      if (b != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.c = bool1;
      this.d = param1Parcel.readFloat();
      this.e = param1Parcel.readInt();
      this.f = param1Parcel.readInt();
      this.g = param1Parcel.readInt();
      this.h = param1Parcel.readInt();
      this.i = param1Parcel.readInt();
      if (param1Parcel.readByte() != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.j = bool1;
      if (param1Parcel.readByte() != 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.k = bool1;
    }
    
    WheelSavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeFloat(this.a);
      param1Parcel.writeFloat(this.b);
      param1Parcel.writeByte((byte)this.c);
      param1Parcel.writeFloat(this.d);
      param1Parcel.writeInt(this.e);
      param1Parcel.writeInt(this.f);
      param1Parcel.writeInt(this.g);
      param1Parcel.writeInt(this.h);
      param1Parcel.writeInt(this.i);
      param1Parcel.writeByte((byte)this.j);
      param1Parcel.writeByte((byte)this.k);
    }
  }
  
  static final class null implements Parcelable.Creator<WheelSavedState> {
    public ProgressWheel.WheelSavedState a(Parcel param1Parcel) {
      return new ProgressWheel.WheelSavedState(param1Parcel);
    }
    
    public ProgressWheel.WheelSavedState[] a(int param1Int) {
      return new ProgressWheel.WheelSavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\ProgressWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */