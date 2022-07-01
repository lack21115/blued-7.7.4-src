package com.soft.blued.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.soft.blued.R;

public class CirclePageIndicator extends View implements PageIndicator {
  private float a;
  
  private final Paint b = new Paint(1);
  
  private final Paint c = new Paint(1);
  
  private final Paint d = new Paint(1);
  
  private ViewPager e;
  
  private ViewPager.OnPageChangeListener f;
  
  private int g;
  
  private int h;
  
  private float i;
  
  private int j;
  
  private int k;
  
  private boolean l;
  
  private boolean m;
  
  private int n;
  
  private float o = -1.0F;
  
  private int p = -1;
  
  private boolean q;
  
  private int r = 0;
  
  public CirclePageIndicator(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 2130969813);
  }
  
  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return; 
    Resources resources = getResources();
    int i = resources.getColor(2131100253);
    int j = resources.getColor(2131100252);
    int k = resources.getInteger(2131361798);
    int m = resources.getColor(2131100254);
    float f1 = resources.getDimension(2131165287);
    float f2 = resources.getDimension(2131165286);
    boolean bool1 = resources.getBoolean(2131034115);
    boolean bool2 = resources.getBoolean(2131034116);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CirclePageIndicator, paramInt, 0);
    this.l = typedArray.getBoolean(2, bool1);
    this.k = typedArray.getInt(0, k);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(typedArray.getColor(4, i));
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(typedArray.getColor(7, m));
    this.c.setStrokeWidth(typedArray.getDimension(8, f1));
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(typedArray.getColor(3, j));
    this.a = typedArray.getDimension(5, f2);
    this.m = typedArray.getBoolean(6, bool2);
    Drawable drawable = typedArray.getDrawable(1);
    if (drawable != null)
      setBackground(drawable); 
    typedArray.recycle();
    this.n = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }
  
  private int a(int paramInt) {
    int j = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    paramInt = i;
    if (j != 1073741824) {
      ViewPager viewPager = this.e;
      if (viewPager == null)
        return i; 
      paramInt = viewPager.getAdapter().getCount();
      float f1 = (getPaddingLeft() + getPaddingRight());
      float f2 = (paramInt * 2);
      float f3 = this.a;
      paramInt = (int)(f1 + f2 * f3 + (paramInt - 1) * (f3 + this.r) + 1.0F);
      if (j == Integer.MIN_VALUE)
        return Math.min(paramInt, i); 
    } 
    return paramInt;
  }
  
  private int b(int paramInt) {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824)
      return paramInt; 
    int j = (int)(this.a * 2.0F + getPaddingTop() + getPaddingBottom() + 1.0F);
    return (i == Integer.MIN_VALUE) ? Math.min(j, paramInt) : j;
  }
  
  public int getFillColor() {
    return this.d.getColor();
  }
  
  public int getOrientation() {
    return this.k;
  }
  
  public int getPageColor() {
    return this.b.getColor();
  }
  
  public float getRadius() {
    return this.a;
  }
  
  public int getStrokeColor() {
    return this.c.getColor();
  }
  
  public float getStrokeWidth() {
    return this.c.getStrokeWidth();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    int j;
    int k;
    int m;
    super.onDraw(paramCanvas);
    ViewPager viewPager = this.e;
    if (viewPager == null)
      return; 
    int n = viewPager.getAdapter().getCount();
    if (n == 0)
      return; 
    if (this.g >= n) {
      setCurrentItem(n - 1);
      return;
    } 
    if (this.k == 0) {
      i = getWidth();
      j = getPaddingLeft();
      k = getPaddingRight();
      m = getPaddingTop();
    } else {
      i = getHeight();
      j = getPaddingTop();
      k = getPaddingBottom();
      m = getPaddingLeft();
    } 
    float f2 = this.a;
    float f5 = 3.0F * f2;
    float f1 = m + f2;
    if (this.l) {
      f2 = (i - j - k) / 2.0F - (n - 1) * (this.r + f5) / 2.0F;
    } else {
      f2 = j + f2;
    } 
    float f4 = this.a;
    float f3 = f4;
    if (this.c.getStrokeWidth() > 0.0F)
      f3 = f4 - this.c.getStrokeWidth() / 2.0F; 
    int i;
    for (i = 0; i < n; i++) {
      float f6;
      f4 = i * (this.r + f5) + f2;
      if (this.k == 0) {
        f6 = f1;
      } else {
        f6 = f4;
        f4 = f1;
      } 
      if (this.b.getAlpha() > 0)
        paramCanvas.drawCircle(f4, f6, f3, this.b); 
      float f7 = this.a;
      if (f3 != f7)
        paramCanvas.drawCircle(f4, f6, f7, this.c); 
    } 
    if (this.m) {
      i = this.h;
    } else {
      i = this.g;
    } 
    f3 = i;
    i = this.r;
    f4 = f3 * (i + f5);
    f3 = f4;
    if (!this.m)
      f3 = f4 + this.i * (f5 + i); 
    if (this.k == 0) {
      f2 = f3 + f2;
      f3 = f1;
    } else {
      f3 += f2;
      f2 = f1;
    } 
    paramCanvas.drawCircle(f2, f3, this.a, this.d);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (this.k == 0) {
      setMeasuredDimension(a(paramInt1), b(paramInt2));
      return;
    } 
    setMeasuredDimension(b(paramInt1), a(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt) {
    this.j = paramInt;
    ViewPager.OnPageChangeListener onPageChangeListener = this.f;
    if (onPageChangeListener != null)
      onPageChangeListener.onPageScrollStateChanged(paramInt); 
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    this.g = paramInt1;
    this.i = paramFloat;
    invalidate();
    ViewPager.OnPageChangeListener onPageChangeListener = this.f;
    if (onPageChangeListener != null)
      onPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  public void onPageSelected(int paramInt) {
    if (this.m || this.j == 0) {
      this.g = paramInt;
      this.h = paramInt;
      invalidate();
    } 
    ViewPager.OnPageChangeListener onPageChangeListener = this.f;
    if (onPageChangeListener != null)
      onPageChangeListener.onPageSelected(paramInt); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.g = savedState.a;
    this.h = savedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.g;
    return (Parcelable)savedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (super.onTouchEvent(paramMotionEvent))
      return true; 
    ViewPager viewPager = this.e;
    int i = 0;
    if (viewPager != null) {
      if (viewPager.getAdapter().getCount() == 0)
        return false; 
      int j = paramMotionEvent.getAction() & 0xFF;
      if (j != 0) {
        if (j != 1)
          if (j != 2) {
            if (j != 3) {
              if (j != 5) {
                if (j != 6)
                  return true; 
                j = MotionEventCompat.getActionIndex(paramMotionEvent);
                if (MotionEventCompat.getPointerId(paramMotionEvent, j) == this.p) {
                  if (j == 0)
                    i = 1; 
                  this.p = MotionEventCompat.getPointerId(paramMotionEvent, i);
                } 
                this.o = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.p));
                return true;
              } 
              i = MotionEventCompat.getActionIndex(paramMotionEvent);
              this.o = MotionEventCompat.getX(paramMotionEvent, i);
              this.p = MotionEventCompat.getPointerId(paramMotionEvent, i);
              return true;
            } 
          } else {
            try {
              float f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.p));
              float f2 = f1 - this.o;
              if (!this.q && Math.abs(f2) > this.n)
                this.q = true; 
              if (this.q) {
                this.o = f1;
                if (this.e.isFakeDragging() || this.e.beginFakeDrag()) {
                  this.e.fakeDragBy(f2);
                  return true;
                } 
              } 
              return true;
            } catch (Exception exception) {
              return true;
            } 
          }  
        if (!this.q) {
          i = this.e.getAdapter().getCount();
          float f2 = getWidth();
          float f1 = f2 / 2.0F;
          f2 /= 6.0F;
          if (this.g > 0 && exception.getX() < f1 - f2) {
            if (j != 3)
              this.e.setCurrentItem(this.g - 1); 
            return true;
          } 
          if (this.g < i - 1 && exception.getX() > f1 + f2) {
            if (j != 3)
              this.e.setCurrentItem(this.g + 1); 
            return true;
          } 
        } 
        this.q = false;
        this.p = -1;
        if (this.e.isFakeDragging()) {
          this.e.endFakeDrag();
          return true;
        } 
      } else {
        this.p = MotionEventCompat.getPointerId((MotionEvent)exception, 0);
        this.o = exception.getX();
      } 
      return true;
    } 
    return false;
  }
  
  public void setCentered(boolean paramBoolean) {
    this.l = paramBoolean;
    invalidate();
  }
  
  public void setCurrentItem(int paramInt) {
    ViewPager viewPager = this.e;
    if (viewPager != null) {
      viewPager.setCurrentItem(paramInt);
      this.g = paramInt;
      invalidate();
      return;
    } 
    throw new IllegalStateException("ViewPager has not been bound.");
  }
  
  public void setFillColor(int paramInt) {
    this.d.setColor(paramInt);
    invalidate();
  }
  
  public void setInterval(int paramInt) {
    this.r = paramInt;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {
    this.f = paramOnPageChangeListener;
  }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 0 || paramInt == 1) {
      this.k = paramInt;
      requestLayout();
      return;
    } 
    throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
  }
  
  public void setPageColor(int paramInt) {
    this.b.setColor(paramInt);
    invalidate();
  }
  
  public void setRadius(float paramFloat) {
    this.a = paramFloat;
    invalidate();
  }
  
  public void setSnap(boolean paramBoolean) {
    this.m = paramBoolean;
    invalidate();
  }
  
  public void setStrokeColor(int paramInt) {
    this.c.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat) {
    this.c.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager) {
    ViewPager viewPager = this.e;
    if (viewPager == paramViewPager)
      return; 
    if (viewPager != null)
      viewPager.setOnPageChangeListener(null); 
    if (paramViewPager.getAdapter() != null) {
      this.e = paramViewPager;
      this.e.setOnPageChangeListener(this);
      invalidate();
      return;
    } 
    throw new IllegalStateException("ViewPager does not have adapter instance.");
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public CirclePageIndicator.SavedState a(Parcel param2Parcel) {
          return new CirclePageIndicator.SavedState(param2Parcel);
        }
        
        public CirclePageIndicator.SavedState[] a(int param2Int) {
          return new CirclePageIndicator.SavedState[param2Int];
        }
      };
    
    int a;
    
    private SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      this.a = param1Parcel.readInt();
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public CirclePageIndicator.SavedState a(Parcel param1Parcel) {
      return new CirclePageIndicator.SavedState(param1Parcel);
    }
    
    public CirclePageIndicator.SavedState[] a(int param1Int) {
      return new CirclePageIndicator.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CirclePageIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */