package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

@DecorView
public class PagerTitleStrip extends ViewGroup {
  private static final int[] n = new int[] { 16842804, 16842901, 16842904, 16842927 };
  
  private static final int[] o = new int[] { 16843660 };
  
  ViewPager a;
  
  TextView b;
  
  TextView c;
  
  TextView d;
  
  float e = -1.0F;
  
  int f;
  
  private int g = -1;
  
  private int h;
  
  private int i;
  
  private boolean j;
  
  private boolean k;
  
  private final PageListener l = new PageListener(this);
  
  private WeakReference<PagerAdapter> m;
  
  private int p;
  
  public PagerTitleStrip(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TextView textView = new TextView(paramContext);
    this.b = textView;
    addView((View)textView);
    textView = new TextView(paramContext);
    this.c = textView;
    addView((View)textView);
    textView = new TextView(paramContext);
    this.d = textView;
    addView((View)textView);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, n);
    boolean bool = false;
    int i = typedArray.getResourceId(0, 0);
    if (i != 0) {
      TextViewCompat.setTextAppearance(this.b, i);
      TextViewCompat.setTextAppearance(this.c, i);
      TextViewCompat.setTextAppearance(this.d, i);
    } 
    int j = typedArray.getDimensionPixelSize(1, 0);
    if (j != 0)
      setTextSize(0, j); 
    if (typedArray.hasValue(2)) {
      j = typedArray.getColor(2, 0);
      this.b.setTextColor(j);
      this.c.setTextColor(j);
      this.d.setTextColor(j);
    } 
    this.i = typedArray.getInteger(3, 80);
    typedArray.recycle();
    this.f = this.c.getTextColors().getDefaultColor();
    setNonPrimaryAlpha(0.6F);
    this.b.setEllipsize(TextUtils.TruncateAt.END);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.d.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0) {
      typedArray = paramContext.obtainStyledAttributes(i, o);
      bool = typedArray.getBoolean(0, false);
      typedArray.recycle();
    } 
    if (bool) {
      setSingleLineAllCaps(this.b);
      setSingleLineAllCaps(this.c);
      setSingleLineAllCaps(this.d);
    } else {
      this.b.setSingleLine();
      this.c.setSingleLine();
      this.d.setSingleLine();
    } 
    this.h = (int)((paramContext.getResources().getDisplayMetrics()).density * 16.0F);
  }
  
  private static void setSingleLineAllCaps(TextView paramTextView) {
    paramTextView.setTransformationMethod((TransformationMethod)new SingleLineAllCapsTransform(paramTextView.getContext()));
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean) {
    if (paramInt != this.g) {
      a(paramInt, this.a.getAdapter());
    } else if (!paramBoolean && paramFloat == this.e) {
      return;
    } 
    this.k = true;
    int m = this.b.getMeasuredWidth();
    int i4 = this.c.getMeasuredWidth();
    int k = this.d.getMeasuredWidth();
    int i3 = i4 / 2;
    int n = getWidth();
    int i = getHeight();
    int i2 = getPaddingLeft();
    int i1 = getPaddingRight();
    paramInt = getPaddingTop();
    int j = getPaddingBottom();
    int i5 = i1 + i3;
    float f2 = 0.5F + paramFloat;
    float f1 = f2;
    if (f2 > 1.0F)
      f1 = f2 - 1.0F; 
    i3 = n - i5 - (int)((n - i2 + i3 - i5) * f1) - i3;
    i4 += i3;
    int i7 = this.b.getBaseline();
    i5 = this.c.getBaseline();
    int i6 = this.d.getBaseline();
    int i8 = Math.max(Math.max(i7, i5), i6);
    i7 = i8 - i7;
    i5 = i8 - i5;
    i6 = i8 - i6;
    i8 = this.b.getMeasuredHeight();
    int i9 = this.c.getMeasuredHeight();
    int i10 = this.d.getMeasuredHeight();
    i8 = Math.max(Math.max(i8 + i7, i9 + i5), i10 + i6);
    i9 = this.i & 0x70;
    if (i9 != 16) {
      if (i9 != 80) {
        i = i7 + paramInt;
        j = i5 + paramInt;
        paramInt += i6;
      } else {
        paramInt = i - j - i8;
        i = i7 + paramInt;
        j = i5 + paramInt;
        paramInt += i6;
      } 
    } else {
      paramInt = (i - paramInt - j - i8) / 2;
      i = i7 + paramInt;
      j = i5 + paramInt;
      paramInt += i6;
    } 
    TextView textView = this.c;
    textView.layout(i3, j, i4, textView.getMeasuredHeight() + j);
    j = Math.min(i2, i3 - this.h - m);
    textView = this.b;
    textView.layout(j, i, m + j, textView.getMeasuredHeight() + i);
    i = Math.max(n - i1 - k, i4 + this.h);
    textView = this.d;
    textView.layout(i, paramInt, i + k, textView.getMeasuredHeight() + paramInt);
    this.e = paramFloat;
    this.k = false;
  }
  
  void a(int paramInt, PagerAdapter paramPagerAdapter) {
    if (paramPagerAdapter != null) {
      i = paramPagerAdapter.getCount();
    } else {
      i = 0;
    } 
    this.j = true;
    CharSequence charSequence2 = null;
    if (paramInt >= 1 && paramPagerAdapter != null) {
      charSequence1 = paramPagerAdapter.getPageTitle(paramInt - 1);
    } else {
      charSequence1 = null;
    } 
    this.b.setText(charSequence1);
    TextView textView = this.c;
    if (paramPagerAdapter != null && paramInt < i) {
      charSequence1 = paramPagerAdapter.getPageTitle(paramInt);
    } else {
      charSequence1 = null;
    } 
    textView.setText(charSequence1);
    int j = paramInt + 1;
    CharSequence charSequence1 = charSequence2;
    if (j < i) {
      charSequence1 = charSequence2;
      if (paramPagerAdapter != null)
        charSequence1 = paramPagerAdapter.getPageTitle(j); 
    } 
    this.d.setText(charSequence1);
    int i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), -2147483648);
    j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), -2147483648);
    this.b.measure(i, j);
    this.c.measure(i, j);
    this.d.measure(i, j);
    this.g = paramInt;
    if (!this.k)
      a(paramInt, this.e, false); 
    this.j = false;
  }
  
  void a(PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2) {
    if (paramPagerAdapter1 != null) {
      paramPagerAdapter1.unregisterDataSetObserver(this.l);
      this.m = null;
    } 
    if (paramPagerAdapter2 != null) {
      paramPagerAdapter2.registerDataSetObserver(this.l);
      this.m = new WeakReference<PagerAdapter>(paramPagerAdapter2);
    } 
    ViewPager viewPager = this.a;
    if (viewPager != null) {
      this.g = -1;
      this.e = -1.0F;
      a(viewPager.getCurrentItem(), paramPagerAdapter2);
      requestLayout();
    } 
  }
  
  int getMinHeight() {
    Drawable drawable = getBackground();
    return (drawable != null) ? drawable.getIntrinsicHeight() : 0;
  }
  
  public int getTextSpacing() {
    return this.h;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ViewParent viewParent = getParent();
    if (viewParent instanceof ViewPager) {
      ViewPager viewPager = (ViewPager)viewParent;
      PagerAdapter pagerAdapter = viewPager.getAdapter();
      viewPager.a(this.l);
      viewPager.addOnAdapterChangeListener(this.l);
      this.a = viewPager;
      WeakReference<PagerAdapter> weakReference = this.m;
      if (weakReference != null) {
        PagerAdapter pagerAdapter1 = weakReference.get();
      } else {
        weakReference = null;
      } 
      a((PagerAdapter)weakReference, pagerAdapter);
      return;
    } 
    throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ViewPager viewPager = this.a;
    if (viewPager != null) {
      a(viewPager.getAdapter(), (PagerAdapter)null);
      this.a.a((ViewPager.OnPageChangeListener)null);
      this.a.removeOnAdapterChangeListener(this.l);
      this.a = null;
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.a != null) {
      float f = this.e;
      if (f < 0.0F)
        f = 0.0F; 
      a(this.g, f, true);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      int j = getPaddingTop() + getPaddingBottom();
      int k = getChildMeasureSpec(paramInt2, j, -2);
      int i = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
      this.b.measure(paramInt1, k);
      this.c.measure(paramInt1, k);
      this.d.measure(paramInt1, k);
      if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
      } else {
        paramInt1 = this.c.getMeasuredHeight();
        paramInt1 = Math.max(getMinHeight(), paramInt1 + j);
      } 
      setMeasuredDimension(i, View.resolveSizeAndState(paramInt1, paramInt2, this.c.getMeasuredState() << 16));
      return;
    } 
    throw new IllegalStateException("Must measure with an exact width");
  }
  
  public void requestLayout() {
    if (!this.j)
      super.requestLayout(); 
  }
  
  public void setGravity(int paramInt) {
    this.i = paramInt;
    requestLayout();
  }
  
  public void setNonPrimaryAlpha(float paramFloat) {
    this.p = (int)(paramFloat * 255.0F) & 0xFF;
    int i = this.p << 24 | this.f & 0xFFFFFF;
    this.b.setTextColor(i);
    this.d.setTextColor(i);
  }
  
  public void setTextColor(int paramInt) {
    this.f = paramInt;
    this.c.setTextColor(paramInt);
    paramInt = this.p << 24 | this.f & 0xFFFFFF;
    this.b.setTextColor(paramInt);
    this.d.setTextColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat) {
    this.b.setTextSize(paramInt, paramFloat);
    this.c.setTextSize(paramInt, paramFloat);
    this.d.setTextSize(paramInt, paramFloat);
  }
  
  public void setTextSpacing(int paramInt) {
    this.h = paramInt;
    requestLayout();
  }
  
  class PageListener extends DataSetObserver implements ViewPager.OnAdapterChangeListener, ViewPager.OnPageChangeListener {
    private int b;
    
    PageListener(PagerTitleStrip this$0) {}
    
    public void onAdapterChanged(ViewPager param1ViewPager, PagerAdapter param1PagerAdapter1, PagerAdapter param1PagerAdapter2) {
      this.a.a(param1PagerAdapter1, param1PagerAdapter2);
    }
    
    public void onChanged() {
      PagerTitleStrip pagerTitleStrip = this.a;
      pagerTitleStrip.a(pagerTitleStrip.a.getCurrentItem(), this.a.a.getAdapter());
      float f2 = this.a.e;
      float f1 = 0.0F;
      if (f2 >= 0.0F)
        f1 = this.a.e; 
      pagerTitleStrip = this.a;
      pagerTitleStrip.a(pagerTitleStrip.a.getCurrentItem(), f1, true);
    }
    
    public void onPageScrollStateChanged(int param1Int) {
      this.b = param1Int;
    }
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
      param1Int2 = param1Int1;
      if (param1Float > 0.5F)
        param1Int2 = param1Int1 + 1; 
      this.a.a(param1Int2, param1Float, false);
    }
    
    public void onPageSelected(int param1Int) {
      if (this.b == 0) {
        PagerTitleStrip pagerTitleStrip = this.a;
        pagerTitleStrip.a(pagerTitleStrip.a.getCurrentItem(), this.a.a.getAdapter());
        float f2 = this.a.e;
        float f1 = 0.0F;
        if (f2 >= 0.0F)
          f1 = this.a.e; 
        pagerTitleStrip = this.a;
        pagerTitleStrip.a(pagerTitleStrip.a.getCurrentItem(), f1, true);
      } 
    }
  }
  
  static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {
    private Locale a;
    
    SingleLineAllCapsTransform(Context param1Context) {
      this.a = (param1Context.getResources().getConfiguration()).locale;
    }
    
    public CharSequence getTransformation(CharSequence param1CharSequence, View param1View) {
      param1CharSequence = super.getTransformation(param1CharSequence, param1View);
      return (param1CharSequence != null) ? param1CharSequence.toString().toUpperCase(this.a) : null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager\widget\PagerTitleStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */