package com.blued.android.module.common.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.res_china.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TabPageIndicatorWithDot extends HorizontalScrollView implements BluedSkinSupportable {
  private static final int[] z = new int[] { 16842901, 16842904 };
  
  private LinearLayout.LayoutParams A;
  
  private final PageListener B = new PageListener(this);
  
  private ViewPager.OnPageChangeListener C;
  
  private ViewPager D;
  
  private boolean E = false;
  
  private Paint F;
  
  private boolean G = false;
  
  private boolean H = false;
  
  private int I = 52;
  
  private int J = 0;
  
  private int K = 4;
  
  private int L = 0;
  
  private int M = 0;
  
  private float N = 15.0F;
  
  private Typeface O = null;
  
  private int P = 0;
  
  private int Q = 0;
  
  private int R = 0;
  
  private int S;
  
  private int T;
  
  private int U;
  
  private List<TextView> V;
  
  private List<View> W;
  
  public Context a;
  
  private List<QBadgeContainer> aa;
  
  private int ab = -1;
  
  private int ac = 0;
  
  private OnTitleClickListener ad;
  
  public RelativeLayout.LayoutParams b;
  
  public LinearLayout.LayoutParams c;
  
  public LinearLayout d;
  
  public int e;
  
  public int f = 0;
  
  public float g = 0.0F;
  
  public int h = 0;
  
  public Paint i;
  
  public int j = R.color.syc_h;
  
  public int k = -14803165;
  
  public int l = R.color.common_v4_blue_frame_font;
  
  public int m = -16738064;
  
  public int n = R.color.common_v4_blue_frame_font;
  
  public int o = -16738064;
  
  public int p = 2;
  
  public float q = -1.0F;
  
  public float r = 0.0F;
  
  public int s = 15;
  
  public int t = 17;
  
  public int u = 16;
  
  public int v = -14803165;
  
  public int w = R.color.syc_h;
  
  public int x = -3750202;
  
  public int y = R.color.syc_i;
  
  public TabPageIndicatorWithDot(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TabPageIndicatorWithDot(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabPageIndicatorWithDot(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    if (isInEditMode())
      return; 
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    this.S = displayMetrics.widthPixels;
    this.T = displayMetrics.heightPixels;
    setFillViewport(true);
    setWillNotDraw(false);
    this.d = new LinearLayout(paramContext);
    this.d.setOrientation(0);
    this.d.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
    addView((View)this.d);
    displayMetrics = getResources().getDisplayMetrics();
    this.I = (int)TypedValue.applyDimension(1, this.I, displayMetrics);
    this.p = (int)TypedValue.applyDimension(1, this.p, displayMetrics);
    this.q = (int)TypedValue.applyDimension(1, this.q, displayMetrics);
    this.J = (int)TypedValue.applyDimension(1, this.J, displayMetrics);
    this.K = (int)TypedValue.applyDimension(1, this.K, displayMetrics);
    this.s = (int)TypedValue.applyDimension(1, this.s, displayMetrics);
    this.L = (int)TypedValue.applyDimension(1, this.L, displayMetrics);
    this.t = (int)TypedValue.applyDimension(2, this.t, displayMetrics);
    this.u = (int)TypedValue.applyDimension(2, this.u, displayMetrics);
    TypedArray typedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, z);
    this.t = typedArray2.getDimensionPixelSize(0, this.t);
    this.U = DensityUtils.a(getContext(), 8.0F);
    typedArray2.recycle();
    TypedArray typedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagerSlidingTabStrip);
    a();
    if (typedArray1.hasValue(R.styleable.PagerSlidingTabStrip_tabBackground))
      this.R = typedArray1.getResourceId(R.styleable.PagerSlidingTabStrip_tabBackground, this.R); 
    this.K = typedArray1.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_tabdividerPadding, this.K);
    this.s = typedArray1.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_tabPaddingLeftRight, this.s);
    this.H = typedArray1.getBoolean(R.styleable.PagerSlidingTabStrip_shouldExpand, this.H);
    this.I = typedArray1.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_scrollOffset, this.I);
    typedArray1.recycle();
    this.i = new Paint();
    this.i.setAntiAlias(true);
    this.i.setStyle(Paint.Style.FILL);
    this.F = new Paint();
    this.F.setAntiAlias(true);
    this.F.setStrokeWidth(this.L);
    this.c = new LinearLayout.LayoutParams(-2, -1);
    this.b = new RelativeLayout.LayoutParams(-2, DensityUtils.a(paramContext, 44.0F));
    this.A = new LinearLayout.LayoutParams(0, -1, 1.0F);
    this.M = DensityUtils.a(paramContext, 30.0F);
  }
  
  private void a(int paramInt) {
    if (this.V != null)
      for (int i = 0; i < this.V.size(); i++) {
        TextView textView = this.V.get(i);
        if (textView != null)
          if (i == paramInt) {
            textView.setTextColor(this.v);
            textView.setTextSize(0, this.t);
          } else {
            textView.setTextColor(this.x);
            if (this.x != -1) {
              textView.setTextSize(0, this.u);
            } else {
              textView.setTextSize(0, this.t);
            } 
          }  
      }  
  }
  
  private void a(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : Landroid/widget/LinearLayout;
    //   4: iload_1
    //   5: invokevirtual getChildAt : (I)Landroid/view/View;
    //   8: invokevirtual getLeft : ()I
    //   11: iload_2
    //   12: iadd
    //   13: istore_3
    //   14: iload_1
    //   15: ifgt -> 24
    //   18: iload_3
    //   19: istore_1
    //   20: iload_2
    //   21: ifle -> 31
    //   24: iload_3
    //   25: aload_0
    //   26: getfield I : I
    //   29: isub
    //   30: istore_1
    //   31: iload_1
    //   32: aload_0
    //   33: getfield Q : I
    //   36: if_icmpeq -> 50
    //   39: aload_0
    //   40: iload_1
    //   41: putfield Q : I
    //   44: aload_0
    //   45: iload_1
    //   46: iconst_0
    //   47: invokevirtual scrollTo : (II)V
    //   50: return
  }
  
  private void a(int paramInt, String paramString) {
    TextView textView = new TextView(getContext());
    textView.setText(paramString);
    textView.setFocusable(true);
    textView.setGravity(17);
    textView.setSingleLine();
    textView.setPadding(0, 0, 0, DensityUtils.a(this.a, this.N));
    List<TextView> list = this.V;
    if (list != null)
      list.add(textView); 
    LinearLayout linearLayout = new LinearLayout(getContext());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramInt);
    linearLayout.setTag(stringBuilder.toString());
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)this.c);
    linearLayout.setGravity(17);
    ImageView imageView = new ImageView(getContext());
    imageView.setVisibility(8);
    imageView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -1));
    ((ViewGroup.MarginLayoutParams)imageView.getLayoutParams()).rightMargin = 6;
    ShapeTextView shapeTextView = new ShapeTextView(getContext());
    ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, R.color.nafio_g);
    ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, this.U);
    shapeTextView.setVisibility(4);
    int i = this.U;
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
    layoutParams.gravity = 48;
    layoutParams.topMargin = this.U / 2;
    shapeTextView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    List<View> list2 = this.W;
    if (list2 != null)
      list2.add(shapeTextView); 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt == 2)
          imageView.setImageResource(R.drawable.navclass_hot); 
      } else {
        imageView.setImageResource(R.drawable.navclass_time);
      } 
    } else {
      imageView.setImageResource(R.drawable.navclass_location);
    } 
    linearLayout.addView((View)imageView);
    linearLayout.addView((View)textView);
    linearLayout.addView((View)shapeTextView);
    QBadgeContainer qBadgeContainer = new QBadgeContainer(this.a);
    qBadgeContainer.setGravity(17);
    qBadgeContainer.setLayoutParams((ViewGroup.LayoutParams)this.b);
    qBadgeContainer.addView((View)linearLayout);
    qBadgeContainer.a((View)linearLayout);
    qBadgeContainer.d(8388661);
    qBadgeContainer.a(11.0F, true);
    qBadgeContainer.a(10.0F, 0.0F, true);
    qBadgeContainer.a("");
    qBadgeContainer.b(BluedSkinUtils.a(this.a, R.color.syc_g));
    List<QBadgeContainer> list1 = this.aa;
    if (list1 != null)
      list1.add(qBadgeContainer); 
    linearLayout.setOnClickListener(new -$$Lambda$TabPageIndicatorWithDot$0XNcGhIQyw6jz_y1reD3L-0fzds(this, paramInt));
    this.d.addView((View)qBadgeContainer);
  }
  
  private void c() {
    for (int i = 0; i < this.e; i++) {
      QBadgeContainer qBadgeContainer = (QBadgeContainer)this.d.getChildAt(i);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.D.getAdapter().getPageTitle(i).toString());
      stringBuilder.append(i);
      LinearLayout linearLayout = (LinearLayout)qBadgeContainer.findViewWithTag(stringBuilder.toString());
      linearLayout.setBackgroundResource(this.R);
      if (this.H) {
        linearLayout.setPadding(0, 0, 0, 0);
      } else {
        int j = this.s;
        linearLayout.setPadding(j, 0, j, 0);
      } 
      TextView textView = (TextView)linearLayout.getChildAt(1);
      textView.setTextSize(0, this.t);
      textView.setTypeface(this.O, this.P);
      textView.setTextColor(this.v);
    } 
  }
  
  private void d() {
    if (this.ac > 0) {
      if (this.ab == -1)
        return; 
      List<QBadgeContainer> list = this.aa;
      if (list != null) {
        if (list.isEmpty())
          return; 
        Iterator<QBadgeContainer> iterator = this.aa.iterator();
        while (iterator.hasNext())
          ((QBadgeContainer)iterator.next()).a(BluedSkinUtils.a(this.a, this.ab), this.ac, true); 
      } 
    } 
  }
  
  public TabData a(View paramView) {
    TabData tabData = new TabData(this);
    tabData.a = (paramView.getRight() - this.U - paramView.getLeft());
    tabData.b = paramView.getLeft();
    tabData.c = (paramView.getRight() - this.U);
    if (tabData.a > 0.0F && this.q > 0.0F) {
      tabData.b = paramView.getLeft() + tabData.a / 2.0F - this.q / 2.0F;
      tabData.c = paramView.getLeft() + tabData.a / 2.0F + this.q / 2.0F;
    } 
    return tabData;
  }
  
  public void a() {
    this.q = DensityUtils.a(this.a, 12.0F);
    this.p = DensityUtils.a(this.a, 2.5F);
    this.v = BluedSkinUtils.a(this.a, R.color.syc_h);
    this.w = R.color.syc_h;
    this.k = BluedSkinUtils.a(this.a, R.color.syc_h);
    this.j = R.color.syc_h;
    this.x = BluedSkinUtils.a(this.a, R.color.syc_i);
    this.y = R.color.syc_i;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2) {
    int i = getHeight() - getPaddingBottom();
    if (this.r > 0.0F) {
      RectF rectF = new RectF();
      rectF.left = paramInt1;
      rectF.top = (i - this.p);
      rectF.right = paramInt2;
      rectF.bottom = i;
      float f = this.r;
      paramCanvas.drawRoundRect(rectF, f, f, this.i);
      return;
    } 
    paramCanvas.drawRect(paramInt1, (i - this.p), paramInt2, i, this.i);
  }
  
  public void b() {
    this.d.removeAllViews();
    this.e = this.D.getAdapter().getCount();
    List<TextView> list2 = this.V;
    if (list2 != null) {
      list2.clear();
    } else {
      this.V = new ArrayList<TextView>();
    } 
    List<View> list1 = this.W;
    if (list1 != null) {
      list1.clear();
    } else {
      this.W = new ArrayList<View>();
    } 
    List<QBadgeContainer> list = this.aa;
    if (list != null) {
      list.clear();
    } else {
      this.aa = new ArrayList<QBadgeContainer>();
    } 
    for (int i = 0; i < this.e; i++)
      a(i, this.D.getAdapter().getPageTitle(i).toString()); 
    c();
    this.G = false;
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            TabPageIndicatorWithDot tabPageIndicatorWithDot = this.a;
            tabPageIndicatorWithDot.f = TabPageIndicatorWithDot.a(tabPageIndicatorWithDot).getCurrentItem();
            tabPageIndicatorWithDot = this.a;
            TabPageIndicatorWithDot.a(tabPageIndicatorWithDot, tabPageIndicatorWithDot.f, 0);
            tabPageIndicatorWithDot = this.a;
            TabPageIndicatorWithDot.a(tabPageIndicatorWithDot, tabPageIndicatorWithDot.f);
          }
        });
  }
  
  public void g() {
    this.k = BluedSkinUtils.a(this.a, this.j);
    this.v = BluedSkinUtils.a(this.a, this.w);
    this.x = BluedSkinUtils.a(this.a, this.y);
    d();
    a(this.f);
  }
  
  public int getDividerColor() {
    return this.o;
  }
  
  public int getDividerPadding() {
    return this.K;
  }
  
  public int getIndicatorColor() {
    return this.k;
  }
  
  public int getIndicatorHeight() {
    return this.p;
  }
  
  public int getScrollOffset() {
    return this.I;
  }
  
  public boolean getShuldExpand() {
    return this.H;
  }
  
  public int getTabBackground() {
    return this.R;
  }
  
  public int getTabPaddingLeftRight() {
    return this.s;
  }
  
  public int getTextColor() {
    return this.v;
  }
  
  public int getTextSize() {
    return this.t;
  }
  
  public int getUnderlineColor() {
    return this.m;
  }
  
  public int getUnderlineHeight() {
    return this.J;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (!isInEditMode()) {
      if (this.e == 0)
        return; 
      int i = getHeight() - getPaddingBottom();
      this.i.setColor(this.k);
      TabData tabData = a(this.d.getChildAt(this.f));
      int j = this.f;
      j = this.h;
      if (this.g > 0.0F) {
        j = this.f;
        if (j < this.e - 1) {
          TabData tabData1 = a(this.d.getChildAt(j + 1));
          if (this.g < 0.5D) {
            tabData.b += this.g * this.M;
            tabData.c = tabData.c + this.g * 2.0F * (tabData1.c - tabData.c) - this.g * this.M;
          } else {
            float f1 = tabData.b;
            float f2 = this.g;
            float f3 = tabData1.b;
            float f4 = tabData.b;
            j = this.M;
            tabData.b = f1 + (f2 - 0.5F) * 2.0F * (f3 - f4 - (j / 2)) + (j / 2);
            tabData1.c -= (1.0F - this.g) * this.M;
          } 
        } 
      } 
      if (this.e > 1 || this.E)
        a(paramCanvas, (int)tabData.b, (int)tabData.c); 
      this.i.setColor(this.m);
      paramCanvas.drawRect(0.0F, (i - this.J), this.d.getWidth(), i, this.i);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.H) {
      if (View.MeasureSpec.getMode(paramInt1) == 0)
        return; 
      int i = getMeasuredWidth();
      boolean bool = false;
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt1 < this.e) {
        paramInt2 += this.d.getChildAt(paramInt1).getMeasuredWidth();
        paramInt1++;
      } 
      if (!this.G && paramInt2 > 0 && i > 0) {
        if (paramInt2 <= i)
          for (paramInt1 = bool; paramInt1 < this.e; paramInt1++)
            this.d.getChildAt(paramInt1).setLayoutParams((ViewGroup.LayoutParams)this.A);  
        this.G = true;
      } 
    } 
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    this.f = savedState.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.f;
    return (Parcelable)savedState;
  }
  
  public void setDividerColor(int paramInt) {
    this.n = paramInt;
    this.o = BluedSkinUtils.a(this.a, paramInt);
    invalidate();
  }
  
  public void setDividerPadding(int paramInt) {
    this.K = paramInt;
    invalidate();
  }
  
  public void setForeverShowTabIndicator(boolean paramBoolean) {
    this.E = paramBoolean;
    invalidate();
  }
  
  public void setIndicatorColor(int paramInt) {
    this.j = paramInt;
    this.k = BluedSkinUtils.a(this.a, paramInt);
    invalidate();
  }
  
  public void setIndicatorHeight(int paramInt) {
    this.p = paramInt;
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener) {
    this.C = paramOnPageChangeListener;
  }
  
  public void setOnTitleClickListener(OnTitleClickListener paramOnTitleClickListener) {
    this.ad = paramOnTitleClickListener;
  }
  
  public void setScrollOffset(int paramInt) {
    this.I = paramInt;
    invalidate();
  }
  
  public void setShouldExpand(boolean paramBoolean) {
    this.H = paramBoolean;
    requestLayout();
  }
  
  public void setTabBackground(int paramInt) {
    this.R = paramInt;
  }
  
  public void setTabPaddingLeftRight(int paramInt) {
    this.s = paramInt;
    c();
  }
  
  public void setTabTextColorUnfocused(int paramInt) {
    this.y = paramInt;
    this.x = BluedSkinUtils.a(this.a, paramInt);
    c();
  }
  
  public void setTextColor(int paramInt) {
    this.w = paramInt;
    this.v = BluedSkinUtils.a(this.a, paramInt);
    c();
  }
  
  public void setTextSize(int paramInt) {
    this.t = paramInt;
    c();
  }
  
  public void setUnderlineColor(int paramInt) {
    this.l = paramInt;
    this.m = BluedSkinUtils.a(this.a, paramInt);
    invalidate();
  }
  
  public void setUnderlineHeight(int paramInt) {
    this.J = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager) {
    this.D = paramViewPager;
    if (paramViewPager.getAdapter() != null) {
      paramViewPager.addOnPageChangeListener(this.B);
      b();
      return;
    } 
    throw new IllegalStateException("ViewPager does not have adapter instance.");
  }
  
  public static interface OnTitleClickListener {
    void a(int param1Int);
  }
  
  public class PageListener implements ViewPager.OnPageChangeListener {
    public PageListener(TabPageIndicatorWithDot this$0) {}
    
    public void onPageScrollStateChanged(int param1Int) {
      if (param1Int == 0) {
        TabPageIndicatorWithDot tabPageIndicatorWithDot = this.a;
        TabPageIndicatorWithDot.a(tabPageIndicatorWithDot, TabPageIndicatorWithDot.a(tabPageIndicatorWithDot).getCurrentItem(), 0);
      } 
      if (TabPageIndicatorWithDot.b(this.a) != null)
        TabPageIndicatorWithDot.b(this.a).onPageScrollStateChanged(param1Int); 
    }
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
      TabPageIndicatorWithDot tabPageIndicatorWithDot = this.a;
      tabPageIndicatorWithDot.f = param1Int1;
      tabPageIndicatorWithDot.g = param1Float;
      if (tabPageIndicatorWithDot.d != null && this.a.d.getChildAt(param1Int1) != null) {
        tabPageIndicatorWithDot = this.a;
        TabPageIndicatorWithDot.a(tabPageIndicatorWithDot, param1Int1, (int)(tabPageIndicatorWithDot.d.getChildAt(param1Int1).getWidth() * param1Float));
      } 
      this.a.invalidate();
      if (TabPageIndicatorWithDot.b(this.a) != null)
        TabPageIndicatorWithDot.b(this.a).onPageScrolled(param1Int1, param1Float, param1Int2); 
    }
    
    public void onPageSelected(int param1Int) {
      TabPageIndicatorWithDot tabPageIndicatorWithDot = this.a;
      tabPageIndicatorWithDot.h = param1Int;
      if (TabPageIndicatorWithDot.b(tabPageIndicatorWithDot) != null)
        TabPageIndicatorWithDot.b(this.a).onPageSelected(param1Int); 
      TabPageIndicatorWithDot.a(this.a, param1Int);
    }
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public TabPageIndicatorWithDot.SavedState a(Parcel param2Parcel) {
          return new TabPageIndicatorWithDot.SavedState(param2Parcel);
        }
        
        public TabPageIndicatorWithDot.SavedState[] a(int param2Int) {
          return new TabPageIndicatorWithDot.SavedState[param2Int];
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
    public TabPageIndicatorWithDot.SavedState a(Parcel param1Parcel) {
      return new TabPageIndicatorWithDot.SavedState(param1Parcel);
    }
    
    public TabPageIndicatorWithDot.SavedState[] a(int param1Int) {
      return new TabPageIndicatorWithDot.SavedState[param1Int];
    }
  }
  
  public class TabData {
    public float a;
    
    public float b;
    
    public float c;
    
    public TabData(TabPageIndicatorWithDot this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\TabPageIndicatorWithDot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */