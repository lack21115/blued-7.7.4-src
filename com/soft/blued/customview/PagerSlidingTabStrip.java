package com.soft.blued.customview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.soft.blued.R;

public class PagerSlidingTabStrip extends HorizontalScrollView {
  private static final int[] a = new int[] { 16842901, 16842904 };
  
  private int A = -6052957;
  
  private Typeface B = null;
  
  private int C = 0;
  
  private int D = 0;
  
  private int E = 0;
  
  private int F;
  
  private int G;
  
  private boolean H = true;
  
  private LinearLayout.LayoutParams b;
  
  private LinearLayout.LayoutParams c;
  
  private final PageListener d = new PageListener(this);
  
  private ViewPager.OnPageChangeListener e;
  
  private LinearLayout f;
  
  private ViewPager g;
  
  private int h;
  
  private int i = 0;
  
  private float j = 0.0F;
  
  private Paint k;
  
  private Paint l;
  
  private boolean m = false;
  
  private int n = -16738064;
  
  private int o = -3355444;
  
  private int p = 436207616;
  
  private boolean q = false;
  
  private int r = 52;
  
  private int s = 2;
  
  private int t = 0;
  
  private int u = 4;
  
  private int v = 10;
  
  private int w = 8;
  
  private int x = 0;
  
  private int y = 20;
  
  private int z = -16738064;
  
  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return; 
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.F = displayMetrics.widthPixels;
    this.G = displayMetrics.heightPixels;
    setFillViewport(true);
    setWillNotDraw(false);
    this.f = new LinearLayout(paramContext);
    this.f.setOrientation(0);
    this.f.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
    addView((View)this.f);
    displayMetrics = getResources().getDisplayMetrics();
    this.r = (int)TypedValue.applyDimension(1, this.r, displayMetrics);
    this.s = (int)TypedValue.applyDimension(1, this.s, displayMetrics);
    this.t = (int)TypedValue.applyDimension(1, this.t, displayMetrics);
    this.u = (int)TypedValue.applyDimension(1, this.u, displayMetrics);
    this.v = (int)TypedValue.applyDimension(1, this.v, displayMetrics);
    this.x = (int)TypedValue.applyDimension(1, this.x, displayMetrics);
    this.y = (int)TypedValue.applyDimension(2, this.y, displayMetrics);
    this.w = (int)TypedValue.applyDimension(2, this.w, displayMetrics);
    TypedArray typedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    this.y = typedArray2.getDimensionPixelSize(0, this.y);
    this.z = typedArray2.getColor(13, this.z);
    typedArray2.recycle();
    TypedArray typedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagerSlidingTabStrip);
    this.n = typedArray1.getColor(1, this.n);
    this.o = typedArray1.getColor(18, this.o);
    this.p = typedArray1.getColor(0, this.p);
    this.s = typedArray1.getDimensionPixelSize(2, this.s);
    this.t = typedArray1.getDimensionPixelSize(19, this.t);
    this.u = typedArray1.getDimensionPixelSize(16, this.u);
    this.v = typedArray1.getDimensionPixelSize(10, this.v);
    this.E = typedArray1.getResourceId(7, this.E);
    this.q = typedArray1.getBoolean(6, this.q);
    this.r = typedArray1.getDimensionPixelSize(5, this.r);
    typedArray1.recycle();
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setStyle(Paint.Style.FILL);
    this.l = new Paint();
    this.l.setAntiAlias(true);
    this.l.setStrokeWidth(this.x);
    this.b = new LinearLayout.LayoutParams(-2, -1);
    this.c = new LinearLayout.LayoutParams(0, -1, 1.0F);
  }
  
  private void a(int paramInt) {
    TextView textView1;
    ImageView imageView2 = (ImageView)((LinearLayout)this.f.getChildAt(0)).getChildAt(0);
    ImageView imageView3 = (ImageView)((LinearLayout)this.f.getChildAt(1)).getChildAt(0);
    TextView textView2 = (TextView)((LinearLayout)this.f.getChildAt(0)).getChildAt(1);
    TextView textView3 = (TextView)((LinearLayout)this.f.getChildAt(1)).getChildAt(1);
    boolean bool = this.H;
    ImageView imageView1 = null;
    if (!bool) {
      imageView1 = (ImageView)((LinearLayout)this.f.getChildAt(2)).getChildAt(0);
      textView1 = (TextView)((LinearLayout)this.f.getChildAt(2)).getChildAt(1);
    } else {
      textView1 = null;
    } 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        textView2.setTextColor(this.A);
        textView3.setTextColor(this.A);
        imageView2.setImageResource(2131233472);
        imageView3.setImageResource(2131233474);
        if (!this.H) {
          textView1.setTextColor(this.z);
          imageView1.setImageResource(2131233471);
          return;
        } 
      } else {
        textView2.setTextColor(this.A);
        textView3.setTextColor(this.z);
        imageView2.setImageResource(2131233472);
        imageView3.setImageResource(2131233475);
        if (!this.H) {
          textView1.setTextColor(this.A);
          imageView1.setImageResource(2131233470);
          return;
        } 
      } 
    } else {
      textView2.setTextColor(this.z);
      textView3.setTextColor(this.A);
      imageView2.setImageResource(2131233473);
      imageView3.setImageResource(2131233474);
      if (!this.H) {
        textView1.setTextColor(this.A);
        imageView1.setImageResource(2131233470);
      } 
    } 
  }
  
  private void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield f : Landroid/widget/LinearLayout;
    //   4: iload_1
    //   5: invokevirtual getChildAt : (I)Landroid/view/View;
    //   8: invokevirtual getLeft : ()I
    //   11: iload_2
    //   12: iadd
    //   13: istore #4
    //   15: iload_1
    //   16: ifgt -> 26
    //   19: iload #4
    //   21: istore_3
    //   22: iload_2
    //   23: ifle -> 34
    //   26: iload #4
    //   28: aload_0
    //   29: getfield r : I
    //   32: isub
    //   33: istore_3
    //   34: iload_3
    //   35: aload_0
    //   36: getfield D : I
    //   39: if_icmpeq -> 53
    //   42: aload_0
    //   43: iload_3
    //   44: putfield D : I
    //   47: aload_0
    //   48: iload_3
    //   49: iconst_0
    //   50: invokevirtual scrollTo : (II)V
    //   53: aload_0
    //   54: iload_1
    //   55: invokespecial a : (I)V
    //   58: return
  }
  
  private void a(int paramInt, String paramString) {
    TextView textView = new TextView(getContext());
    textView.setText(paramString);
    textView.setFocusable(true);
    textView.setGravity(17);
    textView.setSingleLine();
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout linearLayout = new LinearLayout(getContext());
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    linearLayout.setGravity(17);
    ImageView imageView = new ImageView(getContext());
    imageView.setVisibility(8);
    imageView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    ((ViewGroup.MarginLayoutParams)imageView.getLayoutParams()).rightMargin = 6;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          imageView.setImageResource(2131233470); 
      } else {
        imageView.setImageResource(2131233474);
      } 
    } else {
      imageView.setImageResource(2131233472);
    } 
    linearLayout.addView((View)imageView);
    linearLayout.addView((View)textView);
    linearLayout.setOnClickListener(new View.OnClickListener(this, paramInt) {
          public void onClick(View param1View) {
            PagerSlidingTabStrip.a(this.b).setCurrentItem(this.a);
          }
        });
    this.f.addView((View)linearLayout);
  }
  
  private void b() {
    for (int i = 0; i < this.h; i++) {
      LinearLayout linearLayout = (LinearLayout)this.f.getChildAt(i);
      linearLayout.setBackgroundResource(this.E);
      if (this.q) {
        linearLayout.setPadding(0, 0, 0, 0);
      } else {
        int j = this.v;
        linearLayout.setPadding(j, 0, j, this.w);
      } 
      ((TextView)linearLayout.getChildAt(1)).setTextSize(0, this.y);
      ((TextView)linearLayout.getChildAt(1)).setTypeface(this.B, this.C);
      ((TextView)linearLayout.getChildAt(1)).setTextColor(this.z);
    } 
  }
  
  public void a() {
    this.f.removeAllViews();
    this.h = this.g.getAdapter().getCount();
    for (int i = 0; i < this.h; i++)
      a(i, this.g.getAdapter().getPageTitle(i).toString()); 
    b();
    this.m = false;
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
            PagerSlidingTabStrip.a(pagerSlidingTabStrip, PagerSlidingTabStrip.a(pagerSlidingTabStrip).getCurrentItem());
            pagerSlidingTabStrip = this.a;
            PagerSlidingTabStrip.a(pagerSlidingTabStrip, PagerSlidingTabStrip.b(pagerSlidingTabStrip), 0);
          }
        });
  }
  
  public int getDividerColor() {
    return this.p;
  }
  
  public int getDividerPadding() {
    return this.u;
  }
  
  public int getIndicatorColor() {
    return this.n;
  }
  
  public int getIndicatorHeight() {
    return this.s;
  }
  
  public int getScrollOffset() {
    return this.r;
  }
  
  public boolean getShuldExpand() {
    return this.q;
  }
  
  public int getTabBackground() {
    return this.E;
  }
  
  public int getTabPaddingLeftRight() {
    return this.v;
  }
  
  public int getTextColor() {
    return this.z;
  }
  
  public int getTextSize() {
    return this.y;
  }
  
  public int getUnderlineColor() {
    return this.o;
  }
  
  public int getUnderlineHeight() {
    return this.t;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (!isInEditMode()) {
      if (this.h == 0)
        return; 
      int i = getHeight();
      this.k.setColor(this.n);
      View view = this.f.getChildAt(this.i);
      float f4 = view.getLeft();
      float f3 = view.getRight();
      float f2 = f3;
      float f1 = f4;
      if (this.j > 0.0F) {
        int j = this.i;
        f2 = f3;
        f1 = f4;
        if (j < this.h - 1) {
          view = this.f.getChildAt(j + 1);
          f1 = view.getLeft();
          f2 = view.getRight();
          float f = this.j;
          f1 = f1 * f + (1.0F - f) * f4;
          f2 = f2 * f + (1.0F - f) * f3;
        } 
      } 
      f3 = (i - this.s);
      f4 = i;
      paramCanvas.drawRect(f1, f3, f2, f4, this.k);
      this.k.setColor(this.o);
      paramCanvas.drawRect(0.0F, (i - this.t), this.f.getWidth(), f4, this.k);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.q) {
      if (View.MeasureSpec.getMode(paramInt1) == 0)
        return; 
      int i = getMeasuredWidth();
      boolean bool = false;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt1 < this.h) {
        paramInt2 += this.f.getChildAt(paramInt1).getMeasuredWidth();
        paramInt1++;
      } 
      if (!this.m && paramInt2 > 0 && i > 0) {
        if (paramInt2 <= i)
          for (paramInt1 = bool; paramInt1 < this.h; paramInt1++)
            this.f.getChildAt(paramInt1).setLayoutParams((ViewGroup.LayoutParams)this.c);  
        this.m = true;
      } 
    } 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.i = savedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.i;
    return (Parcelable)savedState;
  }
  
  public void setDividerColor(int paramInt) {
    this.p = paramInt;
    invalidate();
  }
  
  public void setDividerColorResource(int paramInt) {
    this.p = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setDividerPadding(int paramInt) {
    this.u = paramInt;
    invalidate();
  }
  
  public void setIndicatorColor(int paramInt) {
    this.n = paramInt;
    invalidate();
  }
  
  public void setIndicatorColorResource(int paramInt) {
    this.n = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setIndicatorHeight(int paramInt) {
    this.s = paramInt;
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {
    this.e = paramOnPageChangeListener;
  }
  
  public void setScrollOffset(int paramInt) {
    this.r = paramInt;
    invalidate();
  }
  
  public void setShouldExpand(boolean paramBoolean) {
    this.q = paramBoolean;
    requestLayout();
  }
  
  public void setTabBackground(int paramInt) {
    this.E = paramInt;
  }
  
  public void setTabPaddingLeftRight(int paramInt) {
    this.v = paramInt;
    b();
  }
  
  public void setTextColor(int paramInt) {
    this.z = paramInt;
    b();
  }
  
  public void setTextColorResource(int paramInt) {
    this.z = getResources().getColor(paramInt);
    b();
  }
  
  public void setTextSize(int paramInt) {
    this.y = paramInt;
    b();
  }
  
  public void setTwoTab(boolean paramBoolean) {
    this.H = paramBoolean;
  }
  
  public void setUnderlineColor(int paramInt) {
    this.o = paramInt;
    invalidate();
  }
  
  public void setUnderlineColorResource(int paramInt) {
    this.o = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setUnderlineHeight(int paramInt) {
    this.t = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager) {
    this.g = paramViewPager;
    if (paramViewPager.getAdapter() != null) {
      paramViewPager.setOnPageChangeListener(this.d);
      a();
      return;
    } 
    throw new IllegalStateException("ViewPager does not have adapter instance.");
  }
  
  public class PageListener implements ViewPager.OnPageChangeListener {
    public PageListener(PagerSlidingTabStrip this$0) {}
    
    public void onPageScrollStateChanged(int param1Int) {
      if (param1Int == 0) {
        PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
        PagerSlidingTabStrip.a(pagerSlidingTabStrip, PagerSlidingTabStrip.a(pagerSlidingTabStrip).getCurrentItem(), 0);
      } 
      if (PagerSlidingTabStrip.d(this.a) != null)
        PagerSlidingTabStrip.d(this.a).onPageScrollStateChanged(param1Int); 
    }
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
      PagerSlidingTabStrip.a(this.a, param1Int1);
      PagerSlidingTabStrip.a(this.a, param1Float);
      PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
      PagerSlidingTabStrip.a(pagerSlidingTabStrip, PagerSlidingTabStrip.a(pagerSlidingTabStrip).getCurrentItem(), (int)(PagerSlidingTabStrip.c(this.a).getChildAt(param1Int1).getWidth() * param1Float));
      this.a.invalidate();
      if (PagerSlidingTabStrip.d(this.a) != null)
        PagerSlidingTabStrip.d(this.a).onPageScrolled(param1Int1, param1Float, param1Int2); 
    }
    
    public void onPageSelected(int param1Int) {
      if (PagerSlidingTabStrip.d(this.a) != null)
        PagerSlidingTabStrip.d(this.a).onPageSelected(param1Int); 
    }
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public PagerSlidingTabStrip.SavedState a(Parcel param2Parcel) {
          return new PagerSlidingTabStrip.SavedState(param2Parcel);
        }
        
        public PagerSlidingTabStrip.SavedState[] a(int param2Int) {
          return new PagerSlidingTabStrip.SavedState[param2Int];
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
    public PagerSlidingTabStrip.SavedState a(Parcel param1Parcel) {
      return new PagerSlidingTabStrip.SavedState(param1Parcel);
    }
    
    public PagerSlidingTabStrip.SavedState[] a(int param1Int) {
      return new PagerSlidingTabStrip.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PagerSlidingTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */