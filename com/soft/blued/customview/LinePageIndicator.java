package com.soft.blued.customview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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

public class LinePageIndicator extends View implements PageIndicator {
  RectF a = new RectF();
  
  private final Paint b = new Paint(1);
  
  private final Paint c = new Paint(1);
  
  private final Paint d = new Paint(1);
  
  private ViewPager e;
  
  private ViewPager.OnPageChangeListener f;
  
  private int g;
  
  private boolean h;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private float l;
  
  private float m;
  
  private int n;
  
  private float o = -1.0F;
  
  private int p = -1;
  
  private boolean q;
  
  public LinePageIndicator(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LinePageIndicator(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 2130969815);
  }
  
  public LinePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return; 
    Resources resources = getResources();
    int i = resources.getColor(2131100255);
    int j = resources.getColor(2131100256);
    float f1 = resources.getDimension(2131165292);
    float f2 = resources.getDimension(2131165290);
    float f3 = resources.getDimension(2131165293);
    boolean bool = resources.getBoolean(2131034117);
    float f4 = resources.getDimension(2131165291);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinePageIndicator, paramInt, 0);
    this.h = typedArray.getBoolean(1, bool);
    this.i = typedArray.getDimension(4, f1);
    this.m = typedArray.getDimension(3, f4);
    this.j = typedArray.getDimension(2, f2);
    setStrokeWidth(typedArray.getDimension(8, f3));
    this.b.setColor(typedArray.getColor(9, j));
    this.c.setColor(typedArray.getColor(6, i));
    this.d.setStyle(Paint.Style.FILL);
    this.d.setColor(typedArray.getColor(9, j));
    this.k = typedArray.getDimension(7, this.i);
    this.l = typedArray.getDimension(5, 0.0F);
    Drawable drawable = typedArray.getDrawable(0);
    if (drawable != null)
      setBackgroundDrawable(drawable); 
    typedArray.recycle();
    this.n = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }
  
  private int a(int paramInt) {
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i != 1073741824) {
      ViewPager viewPager = this.e;
      if (viewPager == null) {
        float f3 = paramInt;
        return (int)Math.ceil(f3);
      } 
      int j = viewPager.getAdapter().getCount();
      float f2 = (getPaddingLeft() + getPaddingRight()) + j * this.i + (j - 1) * this.j;
      float f1 = f2;
      if (i == Integer.MIN_VALUE)
        f1 = Math.min(f2, paramInt); 
      return (int)Math.ceil(f1);
    } 
    float f = paramInt;
    return (int)Math.ceil(f);
  }
  
  private int b(int paramInt) {
    float f;
    int i = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    if (i == 1073741824) {
      f = paramInt;
    } else {
      f = this.c.getStrokeWidth() + getPaddingTop() + getPaddingBottom();
      if (i == Integer.MIN_VALUE)
        f = Math.min(f, paramInt); 
    } 
    return (int)Math.ceil(f);
  }
  
  public void a(ViewPager paramViewPager, int paramInt) {
    setViewPager(paramViewPager);
    setCurrentItem(paramInt);
  }
  
  public float getGapWidth() {
    return this.j;
  }
  
  public float getLineWidth() {
    return this.i;
  }
  
  public int getSelectedColor() {
    return this.c.getColor();
  }
  
  public float getStrokeWidth() {
    return this.c.getStrokeWidth();
  }
  
  public int getUnselectedColor() {
    return this.b.getColor();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    ViewPager viewPager = this.e;
    if (viewPager == null)
      return; 
    int j = viewPager.getAdapter().getCount();
    if (j == 0)
      return; 
    if (this.g >= j) {
      setCurrentItem(j - 1);
      return;
    } 
    float f3 = this.i;
    float f6 = this.j;
    float f4 = f3 + f6;
    float f7 = j;
    float f8 = this.k;
    float f1 = getPaddingTop();
    float f2 = getPaddingLeft();
    float f9 = getPaddingRight();
    float f5 = f1 + (getHeight() - f1 - getPaddingBottom()) / 2.0F;
    f1 = f2;
    if (this.h)
      f1 = f2 + (getWidth() - f2 - f9) / 2.0F - (f7 * f4 - f6 + f8 - f3) / 2.0F; 
    int i;
    for (i = 0; i < j; i++) {
      f6 = i;
      int k = this.g;
      f3 = 0.0F;
      if (i > k) {
        f2 = this.k - this.i;
      } else {
        f2 = 0.0F;
      } 
      f6 = f6 * f4 + f1 + f2;
      f7 = this.i;
      f2 = f3;
      if (i == this.g)
        f2 = this.k - f7; 
      RectF rectF = this.a;
      f3 = this.m;
      rectF.set(f6, f5 - f3 / 2.0F, f6 + f7 + f2, f3 / 2.0F + f5);
      if (i == this.g) {
        rectF = this.a;
        f2 = this.l;
        paramCanvas.drawRoundRect(rectF, f2, f2, this.c);
      } else if (Math.abs(this.m - this.l * 2.0F) < 0.4F) {
        f2 = this.l;
        paramCanvas.drawCircle(f6 + f2, f5, f2, this.d);
      } else {
        rectF = this.a;
        f2 = this.l;
        paramCanvas.drawRoundRect(rectF, f2, f2, this.b);
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  public void onPageScrollStateChanged(int paramInt) {
    ViewPager.OnPageChangeListener onPageChangeListener = this.f;
    if (onPageChangeListener != null)
      onPageChangeListener.onPageScrollStateChanged(paramInt); 
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
    ViewPager.OnPageChangeListener onPageChangeListener = this.f;
    if (onPageChangeListener != null)
      onPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  public void onPageSelected(int paramInt) {
    this.g = paramInt;
    invalidate();
    ViewPager.OnPageChangeListener onPageChangeListener = this.f;
    if (onPageChangeListener != null)
      onPageChangeListener.onPageSelected(paramInt); 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.g = savedState.a;
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
      try {
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
            }  
          if (!this.q) {
            i = this.e.getAdapter().getCount();
            float f2 = getWidth();
            float f1 = f2 / 2.0F;
            f2 /= 6.0F;
            if (this.g > 0 && paramMotionEvent.getX() < f1 - f2) {
              if (j != 3) {
                this.e.setCurrentItem(this.g - 1);
                return true;
              } 
            } else {
              if (this.g < i - 1 && paramMotionEvent.getX() > f1 + f2) {
                if (j != 3) {
                  this.e.setCurrentItem(this.g + 1);
                  return true;
                } 
                return true;
              } 
              this.q = false;
              this.p = -1;
            } 
            return true;
          } 
        } else {
          this.p = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          this.o = paramMotionEvent.getX();
          return true;
        } 
        this.q = false;
        this.p = -1;
      } catch (Exception exception) {
        return true;
      } 
    } 
    return false;
  }
  
  public void setCentered(boolean paramBoolean) {
    this.h = paramBoolean;
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
  
  public void setGapWidth(float paramFloat) {
    this.j = paramFloat;
    invalidate();
  }
  
  public void setLineWidth(float paramFloat) {
    this.i = paramFloat;
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {
    this.f = paramOnPageChangeListener;
  }
  
  public void setSelectedColor(int paramInt) {
    this.c.setColor(paramInt);
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat) {
    this.c.setStrokeWidth(paramFloat);
    this.b.setStrokeWidth(paramFloat);
    invalidate();
  }
  
  public void setUnselectedColor(int paramInt) {
    this.b.setColor(paramInt);
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
        public LinePageIndicator.SavedState a(Parcel param2Parcel) {
          return new LinePageIndicator.SavedState(param2Parcel);
        }
        
        public LinePageIndicator.SavedState[] a(int param2Int) {
          return new LinePageIndicator.SavedState[param2Int];
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
    public LinePageIndicator.SavedState a(Parcel param1Parcel) {
      return new LinePageIndicator.SavedState(param1Parcel);
    }
    
    public LinePageIndicator.SavedState[] a(int param1Int) {
      return new LinePageIndicator.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\LinePageIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */