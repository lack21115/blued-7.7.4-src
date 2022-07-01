package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.blued.android.framework.R;

public class ProgressWheel extends View {
  public static boolean a;
  
  private static final String b = ProgressWheel.class.getSimpleName();
  
  private int c = 23;
  
  private int d = 3;
  
  private int e = 3;
  
  private final int f = 36;
  
  private final int g = 324;
  
  private boolean h = false;
  
  private double i = 0.0D;
  
  private double j = 460.0D;
  
  private float k = 0.0F;
  
  private boolean l = true;
  
  private long m = 0L;
  
  private final long n = 200L;
  
  private int o = -1442840576;
  
  private int p = 16777215;
  
  private Paint q = new Paint();
  
  private Paint r = new Paint();
  
  private RectF s = new RectF();
  
  private float t = 230.0F;
  
  private long u = 0L;
  
  private boolean v;
  
  private float w = 0.0F;
  
  private float x = 0.0F;
  
  private boolean y = false;
  
  private ProgressCallback z;
  
  static {
    a = false;
  }
  
  public ProgressWheel(Context paramContext) {
    super(paramContext);
  }
  
  public ProgressWheel(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ProgressWheel));
  }
  
  private void a(float paramFloat) {
    ProgressCallback progressCallback = this.z;
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
      paramInt1 = Math.min(Math.min(m, paramInt2 - j - i), this.c * 2 - this.d * 2);
      k = (m - paramInt1) / 2 + k;
      paramInt2 = (paramInt2 - i - j - paramInt1) / 2 + i;
      i = this.d;
      this.s = new RectF((k + i), (paramInt2 + i), (k + paramInt1 - i), (paramInt2 + paramInt1 - i));
      return;
    } 
    int n = this.d;
    this.s = new RectF((k + n), (i + n), (paramInt1 - m - n), (paramInt2 - j - n));
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
        this.k = f * 288.0F;
        return;
      } 
      f = (1.0F - f) * 288.0F;
      this.w += this.k - f;
      this.k = f;
      return;
    } 
    this.m = l + paramLong;
  }
  
  private void a(TypedArray paramTypedArray) {
    DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
    this.d = (int)TypedValue.applyDimension(1, this.d, displayMetrics);
    this.e = (int)TypedValue.applyDimension(1, this.e, displayMetrics);
    this.c = (int)TypedValue.applyDimension(1, this.c, displayMetrics);
    this.c = (int)paramTypedArray.getDimension(R.styleable.ProgressWheel_matProg_circleRadius, this.c);
    this.h = paramTypedArray.getBoolean(R.styleable.ProgressWheel_matProg_fillRadius, false);
    this.d = (int)paramTypedArray.getDimension(R.styleable.ProgressWheel_matProg_barWidth, this.d);
    this.e = (int)paramTypedArray.getDimension(R.styleable.ProgressWheel_matProg_rimWidth, this.e);
    this.t = paramTypedArray.getFloat(R.styleable.ProgressWheel_matProg_spinSpeed, this.t / 360.0F) * 360.0F;
    this.j = paramTypedArray.getInt(R.styleable.ProgressWheel_matProg_barSpinCycleTime, (int)this.j);
    this.o = paramTypedArray.getColor(R.styleable.ProgressWheel_matProg_barColor, this.o);
    this.p = paramTypedArray.getColor(R.styleable.ProgressWheel_matProg_rimColor, this.p);
    this.v = paramTypedArray.getBoolean(R.styleable.ProgressWheel_matProg_linearProgress, false);
    if (paramTypedArray.getBoolean(R.styleable.ProgressWheel_matProg_progressIndeterminate, false))
      a(); 
    paramTypedArray.recycle();
  }
  
  private void b() {
    this.q.setColor(this.o);
    this.q.setAntiAlias(true);
    this.q.setStyle(Paint.Style.STROKE);
    this.q.setStrokeWidth(this.d);
    this.r.setColor(this.p);
    this.r.setAntiAlias(true);
    this.r.setStyle(Paint.Style.STROKE);
    this.r.setStrokeWidth(this.e);
  }
  
  private void c() {
    if (this.z != null) {
      float f = Math.round(this.w * 100.0F / 360.0F) / 100.0F;
      this.z.a(f);
    } 
  }
  
  public void a() {
    this.u = SystemClock.uptimeMillis();
    this.y = true;
    invalidate();
  }
  
  public int getBarColor() {
    return this.o;
  }
  
  public int getBarWidth() {
    return this.d;
  }
  
  public int getCircleRadius() {
    return this.c;
  }
  
  public float getProgress() {
    return this.y ? -1.0F : (this.w / 360.0F);
  }
  
  public int getRimColor() {
    return this.p;
  }
  
  public int getRimWidth() {
    return this.e;
  }
  
  public float getSpinSpeed() {
    return this.t / 360.0F;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.s, 360.0F, 360.0F, false, this.r);
    boolean bool = this.y;
    boolean bool2 = true;
    boolean bool1 = true;
    if (bool) {
      bool1 = bool2;
      if (a) {
        long l = SystemClock.uptimeMillis() - this.u;
        float f1 = (float)l * this.t / 1000.0F;
        a(l);
        this.w += f1;
        f1 = this.w;
        if (f1 > 360.0F) {
          this.w = f1 - 360.0F;
          a(-1.0F);
        } 
        this.u = SystemClock.uptimeMillis();
        f1 = this.w;
        float f2 = this.k;
        if (isInEditMode()) {
          f1 = 0.0F;
          f2 = 135.0F;
        } else {
          f1 -= 90.0F;
          f2 += 36.0F;
        } 
        paramCanvas.drawArc(this.s, f1, f2, false, this.q);
        bool1 = bool2;
      } 
    } else {
      float f2;
      float f1 = this.w;
      if (f1 != this.x) {
        f2 = (float)(SystemClock.uptimeMillis() - this.u) / 1000.0F;
        float f = this.t;
        this.w = Math.min(this.w + f2 * f, this.x);
        this.u = SystemClock.uptimeMillis();
      } else {
        bool1 = false;
      } 
      if (f1 != this.w)
        c(); 
      f1 = this.w;
      if (!this.v) {
        f2 = (float)(1.0D - Math.pow((1.0F - f1 / 360.0F), 4.0F)) * 360.0F;
        f1 = (float)(1.0D - Math.pow((1.0F - this.w / 360.0F), 2.0F)) * 360.0F;
      } else {
        f2 = 0.0F;
      } 
      if (isInEditMode())
        f1 = 360.0F; 
      paramCanvas.drawArc(this.s, f2 - 90.0F, f1, false, this.q);
    } 
    if (bool1)
      invalidate(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int k = this.c + getPaddingLeft() + getPaddingRight();
    int i = this.c + getPaddingTop() + getPaddingBottom();
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
    this.w = wheelSavedState.a;
    this.x = wheelSavedState.b;
    this.y = wheelSavedState.c;
    this.t = wheelSavedState.d;
    this.d = wheelSavedState.e;
    this.o = wheelSavedState.f;
    this.e = wheelSavedState.g;
    this.p = wheelSavedState.h;
    this.c = wheelSavedState.i;
    this.v = wheelSavedState.j;
    this.h = wheelSavedState.k;
    this.u = SystemClock.uptimeMillis();
  }
  
  public Parcelable onSaveInstanceState() {
    WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    wheelSavedState.a = this.w;
    wheelSavedState.b = this.x;
    wheelSavedState.c = this.y;
    wheelSavedState.d = this.t;
    wheelSavedState.e = this.d;
    wheelSavedState.f = this.o;
    wheelSavedState.g = this.e;
    wheelSavedState.h = this.p;
    wheelSavedState.i = this.c;
    wheelSavedState.j = this.v;
    wheelSavedState.k = this.h;
    return (Parcelable)wheelSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    a(paramInt1, paramInt2);
    b();
    invalidate();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt) {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
      this.u = SystemClock.uptimeMillis(); 
  }
  
  public void setBarColor(int paramInt) {
    this.o = paramInt;
    b();
    if (!this.y)
      invalidate(); 
  }
  
  public void setBarWidth(int paramInt) {
    this.d = paramInt;
    if (!this.y)
      invalidate(); 
  }
  
  public void setCallback(ProgressCallback paramProgressCallback) {
    this.z = paramProgressCallback;
    if (!this.y)
      c(); 
  }
  
  public void setCircleRadius(int paramInt) {
    this.c = paramInt;
    if (!this.y)
      invalidate(); 
  }
  
  public void setInstantProgress(float paramFloat) {
    float f;
    if (this.y) {
      this.w = 0.0F;
      this.y = false;
    } 
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    } else {
      f = paramFloat;
      if (paramFloat < 0.0F)
        f = 0.0F; 
    } 
    if (f == this.x)
      return; 
    this.x = Math.min(f * 360.0F, 360.0F);
    this.w = this.x;
    this.u = SystemClock.uptimeMillis();
    invalidate();
  }
  
  public void setLinearProgress(boolean paramBoolean) {
    this.v = paramBoolean;
    if (!this.y)
      invalidate(); 
  }
  
  public void setProgress(float paramFloat) {
    float f;
    if (this.y) {
      this.w = 0.0F;
      this.y = false;
      c();
    } 
    if (paramFloat > 1.0F) {
      f = paramFloat - 1.0F;
    } else {
      f = paramFloat;
      if (paramFloat < 0.0F)
        f = 0.0F; 
    } 
    paramFloat = this.x;
    if (f == paramFloat)
      return; 
    if (this.w == paramFloat)
      this.u = SystemClock.uptimeMillis(); 
    this.x = Math.min(f * 360.0F, 360.0F);
    invalidate();
  }
  
  public void setRimColor(int paramInt) {
    this.p = paramInt;
    b();
    if (!this.y)
      invalidate(); 
  }
  
  public void setRimWidth(int paramInt) {
    this.e = paramInt;
    if (!this.y)
      invalidate(); 
  }
  
  public void setSpinSpeed(float paramFloat) {
    this.t = paramFloat * 360.0F;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\ProgressWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */