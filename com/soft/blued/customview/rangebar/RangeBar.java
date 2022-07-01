package com.soft.blued.customview.rangebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.soft.blued.R;
import skin.support.widget.SkinCompatBackgroundHelper;

public class RangeBar extends View implements BluedSkinSupportable {
  private int a = 3;
  
  private float b = 24.0F;
  
  private float c = 2.0F;
  
  private int d = -3355444;
  
  private float e = 4.0F;
  
  private int f = -13388315;
  
  private int g = 2131232764;
  
  private int h = 2131232764;
  
  private float i = -1.0F;
  
  private int j = -1;
  
  private int k = -1;
  
  private boolean l = true;
  
  private int m = 500;
  
  private int n = 100;
  
  private Thumb o;
  
  private Thumb p;
  
  private Bar q;
  
  private ConnectingLine r;
  
  private OnRangeBarChangeListener s;
  
  private int t = 0;
  
  private int u = this.a - 1;
  
  private SkinCompatBackgroundHelper v;
  
  public RangeBar(Context paramContext) {
    super(paramContext);
  }
  
  public RangeBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public RangeBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a() {
    this.q = new Bar(getContext(), getMarginLeft(), getYPos(), getBarLength(), this.a, this.b, this.c, this.d);
    invalidate();
  }
  
  private void a(float paramFloat) {
    if (this.o.c()) {
      a(this.o, paramFloat);
    } else if (this.p.c()) {
      a(this.p, paramFloat);
    } 
    if (this.o.b() > this.p.b()) {
      Thumb thumb = this.o;
      this.o = this.p;
      this.p = thumb;
    } 
    int i = this.q.b(this.o);
    int j = this.q.b(this.p);
    if (i != this.t || j != this.u) {
      this.t = i;
      this.u = j;
      OnRangeBarChangeListener onRangeBarChangeListener = this.s;
      if (onRangeBarChangeListener != null)
        onRangeBarChangeListener.a(this, this.t, this.u); 
    } 
  }
  
  private void a(float paramFloat1, float paramFloat2) {
    if (!this.o.c() && this.o.a(paramFloat1, paramFloat2)) {
      a(this.o);
      return;
    } 
    if (!this.o.c() && this.p.a(paramFloat1, paramFloat2))
      a(this.p); 
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    this.v = new SkinCompatBackgroundHelper(this);
    this.v.a(paramAttributeSet, 0);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RangeBar, 0, 0);
    try {
      Integer integer = Integer.valueOf(typedArray.getInteger(9, 3));
      if (a(integer.intValue())) {
        this.a = integer.intValue();
        this.t = 0;
        this.u = this.a - 1;
        if (this.s != null)
          this.s.a(this, this.t, this.u); 
      } else {
        Log.e("RangeBar", "tickCount less than 2; invalid tickCount. XML input ignored.");
      } 
      this.b = typedArray.getDimension(10, 24.0F);
      this.c = typedArray.getDimension(1, 2.0F);
      this.d = typedArray.getColor(0, -3355444);
      this.e = typedArray.getDimension(3, 4.0F);
      this.f = typedArray.getColor(2, -13388315);
      this.i = typedArray.getDimension(8, -1.0F);
      this.g = typedArray.getResourceId(6, 2131232764);
      this.h = typedArray.getResourceId(7, 2131232764);
      this.j = typedArray.getColor(4, -1);
      this.k = typedArray.getColor(5, -1);
      return;
    } finally {
      typedArray.recycle();
    } 
  }
  
  private void a(Thumb paramThumb) {
    if (this.l == true)
      this.l = false; 
    paramThumb.d();
    invalidate();
  }
  
  private void a(Thumb paramThumb, float paramFloat) {
    if (paramFloat < this.q.a()) {
      paramThumb.a(this.q.a());
    } else if (paramFloat > this.q.b()) {
      paramThumb.a(this.q.b());
    } else {
      paramThumb.a(paramFloat);
    } 
    invalidate();
  }
  
  private boolean a(int paramInt) {
    return (paramInt > 1);
  }
  
  private void b() {
    this.r = new ConnectingLine(getContext(), getYPos(), this.e, this.f);
    invalidate();
  }
  
  private void b(float paramFloat1, float paramFloat2) {
    if (this.o.c()) {
      b(this.o);
      return;
    } 
    if (this.p.c()) {
      b(this.p);
      return;
    } 
    if (Math.abs(this.o.b() - paramFloat1) < Math.abs(this.p.b() - paramFloat1)) {
      this.o.a(paramFloat1);
      b(this.o);
    } else {
      this.p.a(paramFloat1);
      b(this.p);
    } 
    int i = this.q.b(this.o);
    int j = this.q.b(this.p);
    if (i != this.t || j != this.u) {
      this.t = i;
      this.u = j;
      OnRangeBarChangeListener onRangeBarChangeListener = this.s;
      if (onRangeBarChangeListener != null)
        onRangeBarChangeListener.a(this, this.t, this.u); 
    } 
  }
  
  private void b(Thumb paramThumb) {
    paramThumb.a(this.q.a(paramThumb));
    paramThumb.e();
    invalidate();
  }
  
  private boolean b(int paramInt1, int paramInt2) {
    if (paramInt1 >= 0) {
      int i = this.a;
      if (paramInt1 < i && paramInt2 >= 0 && paramInt2 < i)
        return false; 
    } 
    return true;
  }
  
  private void c() {
    Context context = getContext();
    float f1 = getYPos();
    this.o = new Thumb(context, f1, this.j, this.k, this.i, this.g, this.h);
    this.p = new Thumb(context, f1, this.j, this.k, this.i, this.g, this.h);
    f1 = getMarginLeft();
    float f2 = getBarLength();
    this.o.a(this.t / (this.a - 1) * f2 + f1);
    this.p.a(f1 + this.u / (this.a - 1) * f2);
    invalidate();
  }
  
  private float getBarLength() {
    return getWidth() - getMarginLeft() * 2.0F;
  }
  
  private float getMarginLeft() {
    Thumb thumb = this.o;
    return (thumb != null) ? thumb.a() : 0.0F;
  }
  
  private float getYPos() {
    return getHeight() / 2.0F;
  }
  
  public void a(int paramInt1, int paramInt2) {
    if (!b(paramInt1, paramInt2)) {
      if (this.l == true)
        this.l = false; 
      this.t = paramInt1;
      this.u = paramInt2;
      c();
      OnRangeBarChangeListener onRangeBarChangeListener = this.s;
      if (onRangeBarChangeListener != null)
        onRangeBarChangeListener.a(this, this.t, this.u); 
      invalidate();
      requestLayout();
      return;
    } 
    Log.e("RangeBar", "A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
    throw new IllegalArgumentException("A thumb index is out of bounds. Check that it is between 0 and mTickCount - 1");
  }
  
  public void g() {
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.v;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(); 
  }
  
  public int getLeftIndex() {
    return this.t;
  }
  
  public int getRightIndex() {
    return this.u;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    this.q.a(paramCanvas);
    this.r.a(paramCanvas, this.o, this.p);
    this.o.a(paramCanvas);
    this.p.a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int k = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (k == Integer.MIN_VALUE) {
      paramInt2 = i;
    } else if (k == 1073741824) {
      paramInt2 = i;
    } else {
      paramInt2 = this.m;
    } 
    if (j == Integer.MIN_VALUE) {
      paramInt1 = Math.min(this.n, paramInt1);
    } else if (j != 1073741824) {
      paramInt1 = this.n;
    } 
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    Bundle bundle;
    if (paramParcelable instanceof Bundle) {
      bundle = (Bundle)paramParcelable;
      this.a = bundle.getInt("TICK_COUNT");
      this.b = bundle.getFloat("TICK_HEIGHT_DP");
      this.c = bundle.getFloat("BAR_WEIGHT");
      this.d = bundle.getInt("BAR_COLOR");
      this.e = bundle.getFloat("CONNECTING_LINE_WEIGHT");
      this.f = bundle.getInt("CONNECTING_LINE_COLOR");
      this.g = bundle.getInt("THUMB_IMAGE_NORMAL");
      this.h = bundle.getInt("THUMB_IMAGE_PRESSED");
      this.i = bundle.getFloat("THUMB_RADIUS_DP");
      this.j = bundle.getInt("THUMB_COLOR_NORMAL");
      this.k = bundle.getInt("THUMB_COLOR_PRESSED");
      this.t = bundle.getInt("LEFT_INDEX");
      this.u = bundle.getInt("RIGHT_INDEX");
      this.l = bundle.getBoolean("FIRST_SET_TICK_COUNT");
      a(this.t, this.u);
      super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
      return;
    } 
    super.onRestoreInstanceState((Parcelable)bundle);
  }
  
  public Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    bundle.putParcelable("instanceState", super.onSaveInstanceState());
    bundle.putInt("TICK_COUNT", this.a);
    bundle.putFloat("TICK_HEIGHT_DP", this.b);
    bundle.putFloat("BAR_WEIGHT", this.c);
    bundle.putInt("BAR_COLOR", this.d);
    bundle.putFloat("CONNECTING_LINE_WEIGHT", this.e);
    bundle.putInt("CONNECTING_LINE_COLOR", this.f);
    bundle.putInt("THUMB_IMAGE_NORMAL", this.g);
    bundle.putInt("THUMB_IMAGE_PRESSED", this.h);
    bundle.putFloat("THUMB_RADIUS_DP", this.i);
    bundle.putInt("THUMB_COLOR_NORMAL", this.j);
    bundle.putInt("THUMB_COLOR_PRESSED", this.k);
    bundle.putInt("LEFT_INDEX", this.t);
    bundle.putInt("RIGHT_INDEX", this.u);
    bundle.putBoolean("FIRST_SET_TICK_COUNT", this.l);
    return (Parcelable)bundle;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Context context = getContext();
    float f1 = paramInt2 / 2.0F;
    this.o = new Thumb(context, f1, this.j, this.k, this.i, this.g, this.h);
    this.p = new Thumb(context, f1, this.j, this.k, this.i, this.g, this.h);
    float f2 = this.o.a();
    float f3 = paramInt1 - 2.0F * f2;
    this.q = new Bar(context, f2, f1, f3, this.a, this.b, this.c, this.d);
    this.o.a(this.t / (this.a - 1) * f3 + f2);
    this.p.a(f2 + this.u / (this.a - 1) * f3);
    paramInt1 = this.q.b(this.o);
    paramInt2 = this.q.b(this.p);
    if (paramInt1 != this.t || paramInt2 != this.u) {
      this.t = paramInt1;
      this.u = paramInt2;
      OnRangeBarChangeListener onRangeBarChangeListener = this.s;
      if (onRangeBarChangeListener != null)
        onRangeBarChangeListener.a(this, this.t, this.u); 
    } 
    this.r = new ConnectingLine(context, f1, this.e, this.f);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!isEnabled())
      return false; 
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            return false; 
        } else {
          a(paramMotionEvent.getX());
          getParent().requestDisallowInterceptTouchEvent(true);
          return true;
        }  
      getParent().requestDisallowInterceptTouchEvent(false);
      b(paramMotionEvent.getX(), paramMotionEvent.getY());
      return true;
    } 
    a(paramMotionEvent.getX(), paramMotionEvent.getY());
    return true;
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.v;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setBarColor(int paramInt) {
    this.d = paramInt;
    a();
  }
  
  public void setBarWeight(float paramFloat) {
    this.c = paramFloat;
    a();
  }
  
  public void setConnectingLineColor(int paramInt) {
    this.f = paramInt;
    b();
  }
  
  public void setConnectingLineWeight(float paramFloat) {
    this.e = paramFloat;
    b();
  }
  
  public void setOnRangeBarChangeListener(OnRangeBarChangeListener paramOnRangeBarChangeListener) {
    this.s = paramOnRangeBarChangeListener;
  }
  
  public void setThumbColorNormal(int paramInt) {
    this.j = paramInt;
    c();
  }
  
  public void setThumbColorPressed(int paramInt) {
    this.k = paramInt;
    c();
  }
  
  public void setThumbImageNormal(int paramInt) {
    this.g = paramInt;
    c();
  }
  
  public void setThumbImagePressed(int paramInt) {
    this.h = paramInt;
    c();
  }
  
  public void setThumbRadius(float paramFloat) {
    this.i = paramFloat;
    c();
  }
  
  public void setTickCount(int paramInt) {
    if (a(paramInt)) {
      this.a = paramInt;
      if (this.l) {
        this.t = 0;
        this.u = this.a - 1;
        OnRangeBarChangeListener onRangeBarChangeListener = this.s;
        if (onRangeBarChangeListener != null)
          onRangeBarChangeListener.a(this, this.t, this.u); 
      } 
      if (b(this.t, this.u)) {
        this.t = 0;
        this.u = this.a - 1;
        OnRangeBarChangeListener onRangeBarChangeListener = this.s;
        if (onRangeBarChangeListener != null)
          onRangeBarChangeListener.a(this, this.t, this.u); 
      } 
      a();
      c();
      return;
    } 
    Log.e("RangeBar", "tickCount less than 2; invalid tickCount.");
    throw new IllegalArgumentException("tickCount less than 2; invalid tickCount.");
  }
  
  public void setTickHeight(float paramFloat) {
    this.b = paramFloat;
    a();
  }
  
  public static interface OnRangeBarChangeListener {
    void a(RangeBar param1RangeBar, int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\rangebar\RangeBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */