package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.DecorView;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@DecorView
public class TabLayout extends HorizontalScrollView {
  private static final int x = R.style.Widget_Design_TabLayout;
  
  private static final Pools.Pool<Tab> y = (Pools.Pool<Tab>)new Pools.SynchronizedPool(16);
  
  private Tab A;
  
  private final RectF B = new RectF();
  
  private final int C;
  
  private final int D;
  
  private final int E;
  
  private int F;
  
  private BaseOnTabSelectedListener G;
  
  private final ArrayList<BaseOnTabSelectedListener> H = new ArrayList<BaseOnTabSelectedListener>();
  
  private BaseOnTabSelectedListener I;
  
  private ValueAnimator J;
  
  private PagerAdapter K;
  
  private DataSetObserver L;
  
  private TabLayoutOnPageChangeListener M;
  
  private AdapterChangeListener N;
  
  private boolean O;
  
  private final Pools.Pool<TabView> P = (Pools.Pool<TabView>)new Pools.SimplePool(12);
  
  final SlidingTabIndicator a;
  
  int b;
  
  int c;
  
  int d;
  
  int e;
  
  int f;
  
  ColorStateList g;
  
  ColorStateList h;
  
  ColorStateList i;
  
  Drawable j;
  
  PorterDuff.Mode k;
  
  float l;
  
  float m;
  
  final int n;
  
  int o = Integer.MAX_VALUE;
  
  int p;
  
  int q;
  
  int r;
  
  int s;
  
  boolean t;
  
  boolean u;
  
  boolean v;
  
  ViewPager w;
  
  private final ArrayList<Tab> z = new ArrayList<Tab>();
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.tabStyle);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, x), paramAttributeSet, paramInt);
    paramContext = getContext();
    setHorizontalScrollBarEnabled(false);
    this.a = new SlidingTabIndicator(this, paramContext);
    super.addView((View)this.a, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -1));
    TypedArray typedArray1 = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.TabLayout, paramInt, x, new int[] { R.styleable.TabLayout_tabTextAppearance });
    if (getBackground() instanceof ColorDrawable) {
      ColorDrawable colorDrawable = (ColorDrawable)getBackground();
      MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
      materialShapeDrawable.g(ColorStateList.valueOf(colorDrawable.getColor()));
      materialShapeDrawable.a(paramContext);
      materialShapeDrawable.r(ViewCompat.getElevation((View)this));
      ViewCompat.setBackground((View)this, (Drawable)materialShapeDrawable);
    } 
    this.a.b(typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
    this.a.a(typedArray1.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
    setSelectedTabIndicator(MaterialResources.b(paramContext, typedArray1, R.styleable.TabLayout_tabIndicator));
    setSelectedTabIndicatorGravity(typedArray1.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
    setTabIndicatorFullWidth(typedArray1.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
    paramInt = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
    this.e = paramInt;
    this.d = paramInt;
    this.c = paramInt;
    this.b = paramInt;
    this.b = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, this.b);
    this.c = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.c);
    this.d = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.d);
    this.e = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.e);
    this.f = typedArray1.getResourceId(R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
    TypedArray typedArray2 = paramContext.obtainStyledAttributes(this.f, R.styleable.TextAppearance);
    try {
      this.l = typedArray2.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
      this.g = MaterialResources.a(paramContext, typedArray2, R.styleable.TextAppearance_android_textColor);
      typedArray2.recycle();
      if (typedArray1.hasValue(R.styleable.TabLayout_tabTextColor))
        this.g = MaterialResources.a(paramContext, typedArray1, R.styleable.TabLayout_tabTextColor); 
      if (typedArray1.hasValue(R.styleable.TabLayout_tabSelectedTextColor)) {
        paramInt = typedArray1.getColor(R.styleable.TabLayout_tabSelectedTextColor, 0);
        this.g = b(this.g.getDefaultColor(), paramInt);
      } 
      this.h = MaterialResources.a(paramContext, typedArray1, R.styleable.TabLayout_tabIconTint);
      this.k = ViewUtils.a(typedArray1.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
      this.i = MaterialResources.a(paramContext, typedArray1, R.styleable.TabLayout_tabRippleColor);
      this.q = typedArray1.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
      this.C = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
      this.D = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
      this.n = typedArray1.getResourceId(R.styleable.TabLayout_tabBackground, 0);
      this.F = typedArray1.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
      this.s = typedArray1.getInt(R.styleable.TabLayout_tabMode, 1);
      this.p = typedArray1.getInt(R.styleable.TabLayout_tabGravity, 0);
      this.t = typedArray1.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
      this.v = typedArray1.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
      typedArray1.recycle();
      Resources resources = getResources();
      this.m = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      this.E = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      return;
    } finally {
      typedArray2.recycle();
    } 
  }
  
  private int a(int paramInt, float paramFloat) {
    int j = this.s;
    int i = 0;
    if (j == 0 || j == 2) {
      View view1;
      View view2 = this.a.getChildAt(paramInt);
      if (++paramInt < this.a.getChildCount()) {
        view1 = this.a.getChildAt(paramInt);
      } else {
        view1 = null;
      } 
      if (view2 != null) {
        paramInt = view2.getWidth();
      } else {
        paramInt = 0;
      } 
      if (view1 != null)
        i = view1.getWidth(); 
      j = view2.getLeft() + paramInt / 2 - getWidth() / 2;
      paramInt = (int)((paramInt + i) * 0.5F * paramFloat);
      return (ViewCompat.getLayoutDirection((View)this) == 0) ? (j + paramInt) : (j - paramInt);
    } 
    return 0;
  }
  
  private void a(View paramView) {
    if (paramView instanceof TabItem) {
      a((TabItem)paramView);
      return;
    } 
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams) {
    if (this.s == 1 && this.p == 0) {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    } 
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2) {
    ViewPager viewPager = this.w;
    if (viewPager != null) {
      TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.M;
      if (tabLayoutOnPageChangeListener != null)
        viewPager.removeOnPageChangeListener(tabLayoutOnPageChangeListener); 
      AdapterChangeListener adapterChangeListener = this.N;
      if (adapterChangeListener != null)
        this.w.removeOnAdapterChangeListener(adapterChangeListener); 
    } 
    BaseOnTabSelectedListener baseOnTabSelectedListener = this.I;
    if (baseOnTabSelectedListener != null) {
      b(baseOnTabSelectedListener);
      this.I = null;
    } 
    if (paramViewPager != null) {
      this.w = paramViewPager;
      if (this.M == null)
        this.M = new TabLayoutOnPageChangeListener(this); 
      this.M.a();
      paramViewPager.addOnPageChangeListener(this.M);
      this.I = new ViewPagerOnTabSelectedListener(paramViewPager);
      a(this.I);
      PagerAdapter pagerAdapter = paramViewPager.getAdapter();
      if (pagerAdapter != null)
        a(pagerAdapter, paramBoolean1); 
      if (this.N == null)
        this.N = new AdapterChangeListener(this); 
      this.N.a(paramBoolean1);
      paramViewPager.addOnAdapterChangeListener(this.N);
      a(paramViewPager.getCurrentItem(), 0.0F, true);
    } else {
      this.w = null;
      a((PagerAdapter)null, false);
    } 
    this.O = paramBoolean2;
  }
  
  private void a(TabItem paramTabItem) {
    Tab tab = a();
    if (paramTabItem.a != null)
      tab.a(paramTabItem.a); 
    if (paramTabItem.b != null)
      tab.a(paramTabItem.b); 
    if (paramTabItem.c != 0)
      tab.a(paramTabItem.c); 
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription()))
      tab.b(paramTabItem.getContentDescription()); 
    a(tab);
  }
  
  private void a(Tab paramTab, int paramInt) {
    paramTab.b(paramInt);
    this.z.add(paramInt, paramTab);
    int i = this.z.size();
    while (true) {
      if (++paramInt < i) {
        ((Tab)this.z.get(paramInt)).b(paramInt);
        continue;
      } 
      break;
    } 
  }
  
  private static ColorStateList b(int paramInt1, int paramInt2) {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private void b(int paramInt) {
    TabView tabView = (TabView)this.a.getChildAt(paramInt);
    this.a.removeViewAt(paramInt);
    if (tabView != null) {
      tabView.a();
      this.P.release(tabView);
    } 
    requestLayout();
  }
  
  private void c(int paramInt) {
    if (paramInt == -1)
      return; 
    if (getWindowToken() == null || !ViewCompat.isLaidOut((View)this) || this.a.a()) {
      a(paramInt, 0.0F, true);
      return;
    } 
    int i = getScrollX();
    int j = a(paramInt, 0.0F);
    if (i != j) {
      g();
      this.J.setIntValues(new int[] { i, j });
      this.J.start();
    } 
    this.a.b(paramInt, this.q);
  }
  
  private TabView d(Tab paramTab) {
    TabView tabView;
    Pools.Pool<TabView> pool1 = this.P;
    if (pool1 != null) {
      TabView tabView1 = (TabView)pool1.acquire();
    } else {
      pool1 = null;
    } 
    Pools.Pool<TabView> pool2 = pool1;
    if (pool1 == null)
      tabView = new TabView(this, getContext()); 
    tabView.setTab(paramTab);
    tabView.setFocusable(true);
    tabView.setMinimumWidth(getTabMinWidth());
    if (TextUtils.isEmpty(Tab.a(paramTab))) {
      tabView.setContentDescription(Tab.b(paramTab));
      return tabView;
    } 
    tabView.setContentDescription(Tab.a(paramTab));
    return tabView;
  }
  
  private void d(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
      } else {
        this.a.setGravity(1);
        return;
      } 
    } else {
      Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    } 
    this.a.setGravity(8388611);
  }
  
  private void e() {
    int j = this.z.size();
    for (int i = 0; i < j; i++)
      ((Tab)this.z.get(i)).h(); 
  }
  
  private void e(Tab paramTab) {
    TabView tabView = paramTab.b;
    tabView.setSelected(false);
    tabView.setActivated(false);
    this.a.addView((View)tabView, paramTab.c(), (ViewGroup.LayoutParams)f());
  }
  
  private LinearLayout.LayoutParams f() {
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(layoutParams);
    return layoutParams;
  }
  
  private void f(Tab paramTab) {
    for (int i = this.H.size() - 1; i >= 0; i--)
      ((BaseOnTabSelectedListener<Tab>)this.H.get(i)).a(paramTab); 
  }
  
  private void g() {
    if (this.J == null) {
      this.J = new ValueAnimator();
      this.J.setInterpolator(AnimationUtils.b);
      this.J.setDuration(this.q);
      this.J.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.scrollTo(((Integer)param1ValueAnimator.getAnimatedValue()).intValue(), 0);
            }
          });
    } 
  }
  
  private void g(Tab paramTab) {
    for (int i = this.H.size() - 1; i >= 0; i--)
      ((BaseOnTabSelectedListener<Tab>)this.H.get(i)).b(paramTab); 
  }
  
  private int getDefaultHeight() {
    boolean bool1;
    int j = this.z.size();
    boolean bool2 = false;
    int i = 0;
    while (true) {
      bool1 = bool2;
      if (i < j) {
        Tab tab = this.z.get(i);
        if (tab != null && tab.b() != null && !TextUtils.isEmpty(tab.d())) {
          bool1 = true;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    return (bool1 && !this.t) ? 72 : 48;
  }
  
  private int getTabMinWidth() {
    int i = this.C;
    if (i != -1)
      return i; 
    i = this.s;
    return (i == 0 || i == 2) ? this.E : 0;
  }
  
  private int getTabScrollRange() {
    return Math.max(0, this.a.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void h() {
    int i = this.s;
    if (i == 0 || i == 2) {
      i = Math.max(0, this.F - this.b);
    } else {
      i = 0;
    } 
    ViewCompat.setPaddingRelative((View)this.a, i, 0, 0, 0);
    i = this.s;
    if (i != 0) {
      if (i == 1 || i == 2) {
        if (this.p == 2)
          Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead"); 
        this.a.setGravity(1);
      } 
    } else {
      d(this.p);
    } 
    a(true);
  }
  
  private void h(Tab paramTab) {
    for (int i = this.H.size() - 1; i >= 0; i--)
      ((BaseOnTabSelectedListener<Tab>)this.H.get(i)).c(paramTab); 
  }
  
  private void setSelectedTabView(int paramInt) {
    int i = this.a.getChildCount();
    if (paramInt < i)
      for (int j = 0; j < i; j++) {
        boolean bool1;
        View view = this.a.getChildAt(j);
        boolean bool2 = true;
        if (j == paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        view.setSelected(bool1);
        if (j == paramInt) {
          bool1 = bool2;
        } else {
          bool1 = false;
        } 
        view.setActivated(bool1);
      }  
  }
  
  public Tab a() {
    Tab tab = b();
    tab.a = this;
    tab.b = d(tab);
    return tab;
  }
  
  public Tab a(int paramInt) {
    return (paramInt < 0 || paramInt >= getTabCount()) ? null : this.z.get(paramInt);
  }
  
  public void a(int paramInt, float paramFloat, boolean paramBoolean) {
    a(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2) {
    int i = Math.round(paramInt + paramFloat);
    if (i >= 0) {
      if (i >= this.a.getChildCount())
        return; 
      if (paramBoolean2)
        this.a.a(paramInt, paramFloat); 
      ValueAnimator valueAnimator = this.J;
      if (valueAnimator != null && valueAnimator.isRunning())
        this.J.cancel(); 
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean1)
        setSelectedTabView(i); 
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    setTabTextColors(b(paramInt1, paramInt2));
  }
  
  void a(PagerAdapter paramPagerAdapter, boolean paramBoolean) {
    PagerAdapter pagerAdapter = this.K;
    if (pagerAdapter != null) {
      DataSetObserver dataSetObserver = this.L;
      if (dataSetObserver != null)
        pagerAdapter.unregisterDataSetObserver(dataSetObserver); 
    } 
    this.K = paramPagerAdapter;
    if (paramBoolean && paramPagerAdapter != null) {
      if (this.L == null)
        this.L = new PagerAdapterObserver(this); 
      paramPagerAdapter.registerDataSetObserver(this.L);
    } 
    d();
  }
  
  public void a(ViewPager paramViewPager, boolean paramBoolean) {
    a(paramViewPager, paramBoolean, false);
  }
  
  @Deprecated
  public void a(BaseOnTabSelectedListener paramBaseOnTabSelectedListener) {
    if (!this.H.contains(paramBaseOnTabSelectedListener))
      this.H.add(paramBaseOnTabSelectedListener); 
  }
  
  public void a(Tab paramTab) {
    a(paramTab, this.z.isEmpty());
  }
  
  public void a(Tab paramTab, int paramInt, boolean paramBoolean) {
    if (paramTab.a == this) {
      a(paramTab, paramInt);
      e(paramTab);
      if (paramBoolean)
        paramTab.f(); 
      return;
    } 
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  public void a(Tab paramTab, boolean paramBoolean) {
    a(paramTab, this.z.size(), paramBoolean);
  }
  
  void a(boolean paramBoolean) {
    for (int i = 0; i < this.a.getChildCount(); i++) {
      View view = this.a.getChildAt(i);
      view.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)view.getLayoutParams());
      if (paramBoolean)
        view.requestLayout(); 
    } 
  }
  
  public void addView(View paramView) {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt) {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    a(paramView);
  }
  
  protected Tab b() {
    Tab tab2 = (Tab)y.acquire();
    Tab tab1 = tab2;
    if (tab2 == null)
      tab1 = new Tab(); 
    return tab1;
  }
  
  @Deprecated
  public void b(BaseOnTabSelectedListener paramBaseOnTabSelectedListener) {
    this.H.remove(paramBaseOnTabSelectedListener);
  }
  
  public void b(Tab paramTab, boolean paramBoolean) {
    Tab tab = this.A;
    if (tab == paramTab) {
      if (tab != null) {
        h(paramTab);
        c(paramTab.c());
        return;
      } 
    } else {
      byte b;
      if (paramTab != null) {
        b = paramTab.c();
      } else {
        b = -1;
      } 
      if (paramBoolean) {
        if ((tab == null || tab.c() == -1) && b != -1) {
          a(b, 0.0F, true);
        } else {
          c(b);
        } 
        if (b != -1)
          setSelectedTabView(b); 
      } 
      this.A = paramTab;
      if (tab != null)
        g(tab); 
      if (paramTab != null)
        f(paramTab); 
    } 
  }
  
  protected boolean b(Tab paramTab) {
    return y.release(paramTab);
  }
  
  public void c() {
    for (int i = this.a.getChildCount() - 1; i >= 0; i--)
      b(i); 
    Iterator<Tab> iterator = this.z.iterator();
    while (iterator.hasNext()) {
      Tab tab = iterator.next();
      iterator.remove();
      tab.i();
      b(tab);
    } 
    this.A = null;
  }
  
  public void c(Tab paramTab) {
    b(paramTab, true);
  }
  
  void d() {
    c();
    PagerAdapter pagerAdapter = this.K;
    if (pagerAdapter != null) {
      int j = pagerAdapter.getCount();
      int i;
      for (i = 0; i < j; i++)
        a(a().a(this.K.getPageTitle(i)), false); 
      ViewPager viewPager = this.w;
      if (viewPager != null && j > 0) {
        i = viewPager.getCurrentItem();
        if (i != getSelectedTabPosition() && i < getTabCount())
          c(a(i)); 
      } 
    } 
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition() {
    Tab tab = this.A;
    return (tab != null) ? tab.c() : -1;
  }
  
  public int getTabCount() {
    return this.z.size();
  }
  
  public int getTabGravity() {
    return this.p;
  }
  
  public ColorStateList getTabIconTint() {
    return this.h;
  }
  
  public int getTabIndicatorGravity() {
    return this.r;
  }
  
  int getTabMaxWidth() {
    return this.o;
  }
  
  public int getTabMode() {
    return this.s;
  }
  
  public ColorStateList getTabRippleColor() {
    return this.i;
  }
  
  public Drawable getTabSelectedIndicator() {
    return this.j;
  }
  
  public ColorStateList getTabTextColors() {
    return this.g;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this);
    if (this.w == null) {
      ViewParent viewParent = getParent();
      if (viewParent instanceof ViewPager)
        a((ViewPager)viewParent, true, true); 
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.O) {
      setupWithViewPager((ViewPager)null);
      this.O = false;
    } 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    for (int i = 0; i < this.a.getChildCount(); i++) {
      View view = this.a.getChildAt(i);
      if (view instanceof TabView)
        TabView.a((TabView)view, paramCanvas); 
    } 
    super.onDraw(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContext : ()Landroid/content/Context;
    //   4: aload_0
    //   5: invokespecial getDefaultHeight : ()I
    //   8: invokestatic a : (Landroid/content/Context;I)F
    //   11: invokestatic round : (F)I
    //   14: istore #5
    //   16: iload_2
    //   17: invokestatic getMode : (I)I
    //   20: istore_3
    //   21: iconst_0
    //   22: istore #4
    //   24: iload_3
    //   25: ldc_w -2147483648
    //   28: if_icmpeq -> 62
    //   31: iload_3
    //   32: ifeq -> 40
    //   35: iload_2
    //   36: istore_3
    //   37: goto -> 95
    //   40: iload #5
    //   42: aload_0
    //   43: invokevirtual getPaddingTop : ()I
    //   46: iadd
    //   47: aload_0
    //   48: invokevirtual getPaddingBottom : ()I
    //   51: iadd
    //   52: ldc_w 1073741824
    //   55: invokestatic makeMeasureSpec : (II)I
    //   58: istore_3
    //   59: goto -> 95
    //   62: iload_2
    //   63: istore_3
    //   64: aload_0
    //   65: invokevirtual getChildCount : ()I
    //   68: iconst_1
    //   69: if_icmpne -> 95
    //   72: iload_2
    //   73: istore_3
    //   74: iload_2
    //   75: invokestatic getSize : (I)I
    //   78: iload #5
    //   80: if_icmplt -> 95
    //   83: aload_0
    //   84: iconst_0
    //   85: invokevirtual getChildAt : (I)Landroid/view/View;
    //   88: iload #5
    //   90: invokevirtual setMinimumHeight : (I)V
    //   93: iload_2
    //   94: istore_3
    //   95: iload_1
    //   96: invokestatic getSize : (I)I
    //   99: istore #5
    //   101: iload_1
    //   102: invokestatic getMode : (I)I
    //   105: ifeq -> 140
    //   108: aload_0
    //   109: getfield D : I
    //   112: istore_2
    //   113: iload_2
    //   114: ifle -> 120
    //   117: goto -> 135
    //   120: iload #5
    //   122: i2f
    //   123: aload_0
    //   124: invokevirtual getContext : ()Landroid/content/Context;
    //   127: bipush #56
    //   129: invokestatic a : (Landroid/content/Context;I)F
    //   132: fsub
    //   133: f2i
    //   134: istore_2
    //   135: aload_0
    //   136: iload_2
    //   137: putfield o : I
    //   140: aload_0
    //   141: iload_1
    //   142: iload_3
    //   143: invokespecial onMeasure : (II)V
    //   146: aload_0
    //   147: invokevirtual getChildCount : ()I
    //   150: iconst_1
    //   151: if_icmpne -> 266
    //   154: aload_0
    //   155: iconst_0
    //   156: invokevirtual getChildAt : (I)Landroid/view/View;
    //   159: astore #6
    //   161: aload_0
    //   162: getfield s : I
    //   165: istore_1
    //   166: iload_1
    //   167: ifeq -> 206
    //   170: iload_1
    //   171: iconst_1
    //   172: if_icmpeq -> 186
    //   175: iload_1
    //   176: iconst_2
    //   177: if_icmpeq -> 206
    //   180: iload #4
    //   182: istore_1
    //   183: goto -> 224
    //   186: iload #4
    //   188: istore_1
    //   189: aload #6
    //   191: invokevirtual getMeasuredWidth : ()I
    //   194: aload_0
    //   195: invokevirtual getMeasuredWidth : ()I
    //   198: if_icmpeq -> 224
    //   201: iconst_1
    //   202: istore_1
    //   203: goto -> 224
    //   206: iload #4
    //   208: istore_1
    //   209: aload #6
    //   211: invokevirtual getMeasuredWidth : ()I
    //   214: aload_0
    //   215: invokevirtual getMeasuredWidth : ()I
    //   218: if_icmpge -> 224
    //   221: goto -> 201
    //   224: iload_1
    //   225: ifeq -> 266
    //   228: iload_3
    //   229: aload_0
    //   230: invokevirtual getPaddingTop : ()I
    //   233: aload_0
    //   234: invokevirtual getPaddingBottom : ()I
    //   237: iadd
    //   238: aload #6
    //   240: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   243: getfield height : I
    //   246: invokestatic getChildMeasureSpec : (III)I
    //   249: istore_1
    //   250: aload #6
    //   252: aload_0
    //   253: invokevirtual getMeasuredWidth : ()I
    //   256: ldc_w 1073741824
    //   259: invokestatic makeMeasureSpec : (II)I
    //   262: iload_1
    //   263: invokevirtual measure : (II)V
    //   266: return
  }
  
  public void setElevation(float paramFloat) {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a((View)this, paramFloat);
  }
  
  public void setInlineLabel(boolean paramBoolean) {
    if (this.t != paramBoolean) {
      this.t = paramBoolean;
      for (int i = 0; i < this.a.getChildCount(); i++) {
        View view = this.a.getChildAt(i);
        if (view instanceof TabView)
          ((TabView)view).c(); 
      } 
      h();
    } 
  }
  
  public void setInlineLabelResource(int paramInt) {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(BaseOnTabSelectedListener paramBaseOnTabSelectedListener) {
    BaseOnTabSelectedListener baseOnTabSelectedListener = this.G;
    if (baseOnTabSelectedListener != null)
      b(baseOnTabSelectedListener); 
    this.G = paramBaseOnTabSelectedListener;
    if (paramBaseOnTabSelectedListener != null)
      a(paramBaseOnTabSelectedListener); 
  }
  
  @Deprecated
  public void setOnTabSelectedListener(OnTabSelectedListener paramOnTabSelectedListener) {
    setOnTabSelectedListener(paramOnTabSelectedListener);
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener) {
    g();
    this.J.addListener(paramAnimatorListener);
  }
  
  public void setSelectedTabIndicator(int paramInt) {
    if (paramInt != 0) {
      setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), paramInt));
      return;
    } 
    setSelectedTabIndicator((Drawable)null);
  }
  
  public void setSelectedTabIndicator(Drawable paramDrawable) {
    if (this.j != paramDrawable) {
      this.j = paramDrawable;
      ViewCompat.postInvalidateOnAnimation((View)this.a);
    } 
  }
  
  public void setSelectedTabIndicatorColor(int paramInt) {
    this.a.a(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt) {
    if (this.r != paramInt) {
      this.r = paramInt;
      ViewCompat.postInvalidateOnAnimation((View)this.a);
    } 
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt) {
    this.a.b(paramInt);
  }
  
  public void setTabGravity(int paramInt) {
    if (this.p != paramInt) {
      this.p = paramInt;
      h();
    } 
  }
  
  public void setTabIconTint(ColorStateList paramColorStateList) {
    if (this.h != paramColorStateList) {
      this.h = paramColorStateList;
      e();
    } 
  }
  
  public void setTabIconTintResource(int paramInt) {
    setTabIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean) {
    this.u = paramBoolean;
    ViewCompat.postInvalidateOnAnimation((View)this.a);
  }
  
  public void setTabMode(int paramInt) {
    if (paramInt != this.s) {
      this.s = paramInt;
      h();
    } 
  }
  
  public void setTabRippleColor(ColorStateList paramColorStateList) {
    if (this.i != paramColorStateList) {
      this.i = paramColorStateList;
      for (int i = 0; i < this.a.getChildCount(); i++) {
        View view = this.a.getChildAt(i);
        if (view instanceof TabView)
          TabView.a((TabView)view, getContext()); 
      } 
    } 
  }
  
  public void setTabRippleColorResource(int paramInt) {
    setTabRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabTextColors(ColorStateList paramColorStateList) {
    if (this.g != paramColorStateList) {
      this.g = paramColorStateList;
      e();
    } 
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(PagerAdapter paramPagerAdapter) {
    a(paramPagerAdapter, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean) {
    if (this.v != paramBoolean) {
      this.v = paramBoolean;
      for (int i = 0; i < this.a.getChildCount(); i++) {
        View view = this.a.getChildAt(i);
        if (view instanceof TabView)
          TabView.a((TabView)view, getContext()); 
      } 
    } 
  }
  
  public void setUnboundedRippleResource(int paramInt) {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(ViewPager paramViewPager) {
    a(paramViewPager, true);
  }
  
  public boolean shouldDelayChildPressedState() {
    return (getTabScrollRange() > 0);
  }
  
  class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
    private boolean b;
    
    AdapterChangeListener(TabLayout this$0) {}
    
    void a(boolean param1Boolean) {
      this.b = param1Boolean;
    }
    
    public void onAdapterChanged(ViewPager param1ViewPager, PagerAdapter param1PagerAdapter1, PagerAdapter param1PagerAdapter2) {
      if (this.a.w == param1ViewPager)
        this.a.a(param1PagerAdapter2, this.b); 
    }
  }
  
  @Deprecated
  public static interface BaseOnTabSelectedListener<T extends Tab> {
    void a(T param1T);
    
    void b(T param1T);
    
    void c(T param1T);
  }
  
  public static @interface LabelVisibility {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Mode {}
  
  public static interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {}
  
  class PagerAdapterObserver extends DataSetObserver {
    PagerAdapterObserver(TabLayout this$0) {}
    
    public void onChanged() {
      this.a.d();
    }
    
    public void onInvalidated() {
      this.a.d();
    }
  }
  
  class SlidingTabIndicator extends LinearLayout {
    int a = -1;
    
    float b;
    
    int c = -1;
    
    int d = -1;
    
    ValueAnimator e;
    
    private int g;
    
    private final Paint h;
    
    private final GradientDrawable i;
    
    private int j = -1;
    
    private int k = -1;
    
    private int l = -1;
    
    SlidingTabIndicator(TabLayout this$0, Context param1Context) {
      super(param1Context);
      setWillNotDraw(false);
      this.h = new Paint();
      this.i = new GradientDrawable();
    }
    
    private void a(TabLayout.TabView param1TabView, RectF param1RectF) {
      int j = TabLayout.TabView.c(param1TabView);
      int k = (int)ViewUtils.a(getContext(), 24);
      int i = j;
      if (j < k)
        i = k; 
      j = (param1TabView.getLeft() + param1TabView.getRight()) / 2;
      i /= 2;
      param1RectF.set((j - i), 0.0F, (j + i), 0.0F);
    }
    
    private void a(boolean param1Boolean, int param1Int1, int param1Int2) {
      View view = getChildAt(param1Int1);
      if (view == null) {
        b();
        return;
      } 
      int k = view.getLeft();
      int m = view.getRight();
      int j = k;
      int i = m;
      if (!this.f.u) {
        j = k;
        i = m;
        if (view instanceof TabLayout.TabView) {
          a((TabLayout.TabView)view, TabLayout.a(this.f));
          j = (int)(TabLayout.a(this.f)).left;
          i = (int)(TabLayout.a(this.f)).right;
        } 
      } 
      k = this.c;
      m = this.d;
      if (k == j && m == i)
        return; 
      if (param1Boolean) {
        this.k = k;
        this.l = m;
      } 
      ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(this, j, i) {
          public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
            float f = param2ValueAnimator.getAnimatedFraction();
            TabLayout.SlidingTabIndicator slidingTabIndicator = this.c;
            slidingTabIndicator.a(AnimationUtils.a(TabLayout.SlidingTabIndicator.a(slidingTabIndicator), this.a, f), AnimationUtils.a(TabLayout.SlidingTabIndicator.b(this.c), this.b, f));
          }
        };
      if (param1Boolean) {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.e = valueAnimator;
        valueAnimator.setInterpolator(AnimationUtils.b);
        valueAnimator.setDuration(param1Int2);
        valueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
        valueAnimator.addUpdateListener(animatorUpdateListener);
        valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, param1Int1) {
              public void onAnimationEnd(Animator param2Animator) {
                TabLayout.SlidingTabIndicator slidingTabIndicator = this.b;
                slidingTabIndicator.a = this.a;
                slidingTabIndicator.b = 0.0F;
              }
              
              public void onAnimationStart(Animator param2Animator) {
                this.b.a = this.a;
              }
            });
        valueAnimator.start();
        return;
      } 
      this.e.removeAllUpdateListeners();
      this.e.addUpdateListener(animatorUpdateListener);
    }
    
    private void b() {
      byte b1;
      byte b2;
      View view = getChildAt(this.a);
      if (view != null && view.getWidth() > 0) {
        b1 = view.getLeft();
        b2 = view.getRight();
        int j = b1;
        int i = b2;
        if (!this.f.u) {
          j = b1;
          i = b2;
          if (view instanceof TabLayout.TabView) {
            a((TabLayout.TabView)view, TabLayout.a(this.f));
            j = (int)(TabLayout.a(this.f)).left;
            i = (int)(TabLayout.a(this.f)).right;
          } 
        } 
        b1 = j;
        b2 = i;
        if (this.b > 0.0F) {
          b1 = j;
          b2 = i;
          if (this.a < getChildCount() - 1) {
            view = getChildAt(this.a + 1);
            int k = view.getLeft();
            int m = view.getRight();
            b2 = k;
            b1 = m;
            if (!this.f.u) {
              b2 = k;
              b1 = m;
              if (view instanceof TabLayout.TabView) {
                a((TabLayout.TabView)view, TabLayout.a(this.f));
                b2 = (int)(TabLayout.a(this.f)).left;
                b1 = (int)(TabLayout.a(this.f)).right;
              } 
            } 
            float f = this.b;
            j = (int)(b2 * f + (1.0F - f) * j);
            b2 = (int)(b1 * f + (1.0F - f) * i);
            b1 = j;
          } 
        } 
      } else {
        b1 = -1;
        b2 = -1;
      } 
      a(b1, b2);
    }
    
    void a(int param1Int) {
      if (this.h.getColor() != param1Int) {
        this.h.setColor(param1Int);
        ViewCompat.postInvalidateOnAnimation((View)this);
      } 
    }
    
    void a(int param1Int, float param1Float) {
      ValueAnimator valueAnimator = this.e;
      if (valueAnimator != null && valueAnimator.isRunning())
        this.e.cancel(); 
      this.a = param1Int;
      this.b = param1Float;
      b();
    }
    
    void a(int param1Int1, int param1Int2) {
      if (param1Int1 != this.c || param1Int2 != this.d) {
        this.c = param1Int1;
        this.d = param1Int2;
        ViewCompat.postInvalidateOnAnimation((View)this);
      } 
    }
    
    boolean a() {
      int j = getChildCount();
      for (int i = 0; i < j; i++) {
        if (getChildAt(i).getWidth() <= 0)
          return true; 
      } 
      return false;
    }
    
    void b(int param1Int) {
      if (this.g != param1Int) {
        this.g = param1Int;
        ViewCompat.postInvalidateOnAnimation((View)this);
      } 
    }
    
    void b(int param1Int1, int param1Int2) {
      ValueAnimator valueAnimator = this.e;
      if (valueAnimator != null && valueAnimator.isRunning())
        this.e.cancel(); 
      a(true, param1Int1, param1Int2);
    }
    
    public void draw(Canvas param1Canvas) {
      int i;
      Drawable drawable = this.f.j;
      int k = 0;
      if (drawable != null) {
        i = this.f.j.getIntrinsicHeight();
      } else {
        i = 0;
      } 
      int j = this.g;
      if (j >= 0)
        i = j; 
      int m = this.f.r;
      if (m != 0) {
        if (m != 1) {
          j = k;
          if (m != 2)
            if (m != 3) {
              i = 0;
              j = k;
            } else {
              i = getHeight();
              j = k;
            }  
        } else {
          j = (getHeight() - i) / 2;
          i = (getHeight() + i) / 2;
        } 
      } else {
        j = getHeight() - i;
        i = getHeight();
      } 
      k = this.c;
      if (k >= 0 && this.d > k) {
        GradientDrawable gradientDrawable;
        if (this.f.j != null) {
          drawable = this.f.j;
        } else {
          gradientDrawable = this.i;
        } 
        Drawable drawable1 = DrawableCompat.wrap((Drawable)gradientDrawable).mutate();
        drawable1.setBounds(this.c, j, this.d, i);
        if (this.h != null)
          if (Build.VERSION.SDK_INT == 21) {
            drawable1.setColorFilter(this.h.getColor(), PorterDuff.Mode.SRC_IN);
          } else {
            DrawableCompat.setTint(drawable1, this.h.getColor());
          }  
        drawable1.draw(param1Canvas);
      } 
      super.draw(param1Canvas);
    }
    
    protected void onLayout(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      super.onLayout(param1Boolean, param1Int1, param1Int2, param1Int3, param1Int4);
      ValueAnimator valueAnimator = this.e;
      if (valueAnimator != null && valueAnimator.isRunning()) {
        a(false, this.a, -1);
        return;
      } 
      b();
    }
    
    protected void onMeasure(int param1Int1, int param1Int2) {
      super.onMeasure(param1Int1, param1Int2);
      if (View.MeasureSpec.getMode(param1Int1) != 1073741824)
        return; 
      if (this.f.p == 1 || this.f.s == 2) {
        int m = getChildCount();
        int k = 0;
        int i = 0;
        int j;
        for (j = 0; i < m; j = n) {
          View view = getChildAt(i);
          int n = j;
          if (view.getVisibility() == 0)
            n = Math.max(j, view.getMeasuredWidth()); 
          i++;
        } 
        if (j <= 0)
          return; 
        i = (int)ViewUtils.a(getContext(), 16);
        if (j * m <= getMeasuredWidth() - i * 2) {
          i = 0;
          int n = k;
          while (true) {
            k = i;
            if (n < m) {
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getChildAt(n).getLayoutParams();
              if (layoutParams.width != j || layoutParams.weight != 0.0F) {
                layoutParams.width = j;
                layoutParams.weight = 0.0F;
                i = 1;
              } 
              n++;
              continue;
            } 
            break;
          } 
        } else {
          TabLayout tabLayout = this.f;
          tabLayout.p = 0;
          tabLayout.a(false);
          k = 1;
        } 
        if (k != 0)
          super.onMeasure(param1Int1, param1Int2); 
      } 
    }
    
    public void onRtlPropertiesChanged(int param1Int) {
      super.onRtlPropertiesChanged(param1Int);
      if (Build.VERSION.SDK_INT < 23 && this.j != param1Int) {
        requestLayout();
        this.j = param1Int;
      } 
    }
  }
  
  class null implements ValueAnimator.AnimatorUpdateListener {
    null(TabLayout this$0, int param1Int1, int param1Int2) {}
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      float f = param1ValueAnimator.getAnimatedFraction();
      TabLayout.SlidingTabIndicator slidingTabIndicator = this.c;
      slidingTabIndicator.a(AnimationUtils.a(TabLayout.SlidingTabIndicator.a(slidingTabIndicator), this.a, f), AnimationUtils.a(TabLayout.SlidingTabIndicator.b(this.c), this.b, f));
    }
  }
  
  class null extends AnimatorListenerAdapter {
    null(TabLayout this$0, int param1Int) {}
    
    public void onAnimationEnd(Animator param1Animator) {
      TabLayout.SlidingTabIndicator slidingTabIndicator = this.b;
      slidingTabIndicator.a = this.a;
      slidingTabIndicator.b = 0.0F;
    }
    
    public void onAnimationStart(Animator param1Animator) {
      this.b.a = this.a;
    }
  }
  
  public static class Tab {
    public TabLayout a;
    
    public TabLayout.TabView b;
    
    private Object c;
    
    private Drawable d;
    
    private CharSequence e;
    
    private CharSequence f;
    
    private int g = -1;
    
    private View h;
    
    private int i = 1;
    
    public View a() {
      return this.h;
    }
    
    public Tab a(int param1Int) {
      return a(LayoutInflater.from(this.b.getContext()).inflate(param1Int, (ViewGroup)this.b, false));
    }
    
    public Tab a(Drawable param1Drawable) {
      this.d = param1Drawable;
      if (this.a.p == 1 || this.a.s == 2)
        this.a.a(true); 
      h();
      if (BadgeUtils.a && TabLayout.TabView.a(this.b) && TabLayout.TabView.b(this.b).isVisible())
        this.b.invalidate(); 
      return this;
    }
    
    public Tab a(View param1View) {
      this.h = param1View;
      h();
      return this;
    }
    
    public Tab a(CharSequence param1CharSequence) {
      if (TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(param1CharSequence))
        this.b.setContentDescription(param1CharSequence); 
      this.e = param1CharSequence;
      h();
      return this;
    }
    
    public Drawable b() {
      return this.d;
    }
    
    public Tab b(CharSequence param1CharSequence) {
      this.f = param1CharSequence;
      h();
      return this;
    }
    
    void b(int param1Int) {
      this.g = param1Int;
    }
    
    public int c() {
      return this.g;
    }
    
    public CharSequence d() {
      return this.e;
    }
    
    public int e() {
      return this.i;
    }
    
    public void f() {
      TabLayout tabLayout = this.a;
      if (tabLayout != null) {
        tabLayout.c(this);
        return;
      } 
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public boolean g() {
      TabLayout tabLayout = this.a;
      if (tabLayout != null)
        return (tabLayout.getSelectedTabPosition() == this.g); 
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    void h() {
      TabLayout.TabView tabView = this.b;
      if (tabView != null)
        tabView.b(); 
    }
    
    void i() {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = -1;
      this.h = null;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TabGravity {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface TabIndicatorGravity {}
  
  public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
    private final WeakReference<TabLayout> a;
    
    private int b;
    
    private int c;
    
    public TabLayoutOnPageChangeListener(TabLayout param1TabLayout) {
      this.a = new WeakReference<TabLayout>(param1TabLayout);
    }
    
    void a() {
      this.c = 0;
      this.b = 0;
    }
    
    public void onPageScrollStateChanged(int param1Int) {
      this.b = this.c;
      this.c = param1Int;
    }
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {
      TabLayout tabLayout = this.a.get();
      if (tabLayout != null) {
        boolean bool1;
        param1Int2 = this.c;
        boolean bool2 = false;
        if (param1Int2 != 2 || this.b == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        if (this.c != 2 || this.b != 0)
          bool2 = true; 
        tabLayout.a(param1Int1, param1Float, bool1, bool2);
      } 
    }
    
    public void onPageSelected(int param1Int) {
      TabLayout tabLayout = this.a.get();
      if (tabLayout != null && tabLayout.getSelectedTabPosition() != param1Int && param1Int < tabLayout.getTabCount()) {
        boolean bool;
        int i = this.c;
        if (i == 0 || (i == 2 && this.b == 0)) {
          bool = true;
        } else {
          bool = false;
        } 
        tabLayout.b(tabLayout.a(param1Int), bool);
      } 
    }
  }
  
  public final class TabView extends LinearLayout {
    private TabLayout.Tab b;
    
    private TextView c;
    
    private ImageView d;
    
    private View e;
    
    private BadgeDrawable f;
    
    private View g;
    
    private TextView h;
    
    private ImageView i;
    
    private Drawable j;
    
    private int k = 2;
    
    public TabView(TabLayout this$0, Context param1Context) {
      super(param1Context);
      a(param1Context);
      ViewCompat.setPaddingRelative((View)this, this$0.b, this$0.c, this$0.d, this$0.e);
      setGravity(17);
      setOrientation(this$0.t ^ true);
      setClickable(true);
      ViewCompat.setPointerIcon((View)this, PointerIconCompat.getSystemIcon(getContext(), 1002));
    }
    
    private float a(Layout param1Layout, int param1Int, float param1Float) {
      return param1Layout.getLineWidth(param1Int) * param1Float / param1Layout.getPaint().getTextSize();
    }
    
    private void a(Context param1Context) {
      LayerDrawable layerDrawable;
      if (this.a.n != 0) {
        this.j = AppCompatResources.getDrawable(param1Context, this.a.n);
        Drawable drawable = this.j;
        if (drawable != null && drawable.isStateful())
          this.j.setState(getDrawableState()); 
      } else {
        this.j = null;
      } 
      GradientDrawable gradientDrawable2 = new GradientDrawable();
      gradientDrawable2.setColor(0);
      GradientDrawable gradientDrawable1 = gradientDrawable2;
      if (this.a.i != null) {
        RippleDrawable rippleDrawable;
        gradientDrawable1 = new GradientDrawable();
        gradientDrawable1.setCornerRadius(1.0E-5F);
        gradientDrawable1.setColor(-1);
        ColorStateList colorStateList = RippleUtils.a(this.a.i);
        if (Build.VERSION.SDK_INT >= 21) {
          if (this.a.v)
            gradientDrawable2 = null; 
          if (this.a.v)
            gradientDrawable1 = null; 
          rippleDrawable = new RippleDrawable(colorStateList, (Drawable)gradientDrawable2, (Drawable)gradientDrawable1);
        } else {
          Drawable drawable = DrawableCompat.wrap((Drawable)rippleDrawable);
          DrawableCompat.setTintList(drawable, colorStateList);
          layerDrawable = new LayerDrawable(new Drawable[] { (Drawable)gradientDrawable2, drawable });
        } 
      } 
      ViewCompat.setBackground((View)this, (Drawable)layerDrawable);
      this.a.invalidate();
    }
    
    private void a(Canvas param1Canvas) {
      Drawable drawable = this.j;
      if (drawable != null) {
        drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
        this.j.draw(param1Canvas);
      } 
    }
    
    private void a(View param1View) {
      if (param1View == null)
        return; 
      param1View.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this, param1View) {
            public void onLayoutChange(View param2View, int param2Int1, int param2Int2, int param2Int3, int param2Int4, int param2Int5, int param2Int6, int param2Int7, int param2Int8) {
              if (this.a.getVisibility() == 0)
                TabLayout.TabView.a(this.b, this.a); 
            }
          });
    }
    
    private void a(TextView param1TextView, ImageView param1ImageView) {
      TabLayout.Tab tab2 = this.b;
      if (tab2 != null && tab2.b() != null) {
        Drawable drawable = DrawableCompat.wrap(this.b.b()).mutate();
      } else {
        tab2 = null;
      } 
      TabLayout.Tab tab3 = this.b;
      if (tab3 != null) {
        CharSequence charSequence = tab3.d();
      } else {
        tab3 = null;
      } 
      if (param1ImageView != null)
        if (tab2 != null) {
          param1ImageView.setImageDrawable((Drawable)tab2);
          param1ImageView.setVisibility(0);
          setVisibility(0);
        } else {
          param1ImageView.setVisibility(8);
          param1ImageView.setImageDrawable(null);
        }  
      int i = TextUtils.isEmpty((CharSequence)tab3) ^ true;
      if (param1TextView != null)
        if (i != 0) {
          param1TextView.setText((CharSequence)tab3);
          if (TabLayout.Tab.c(this.b) == 1) {
            param1TextView.setVisibility(0);
          } else {
            param1TextView.setVisibility(8);
          } 
          setVisibility(0);
        } else {
          param1TextView.setVisibility(8);
          param1TextView.setText(null);
        }  
      if (param1ImageView != null) {
        boolean bool;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)param1ImageView.getLayoutParams();
        if (i != 0 && param1ImageView.getVisibility() == 0) {
          bool = (int)ViewUtils.a(getContext(), 8);
        } else {
          bool = false;
        } 
        if (this.a.t) {
          if (bool != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
            MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, bool);
            marginLayoutParams.bottomMargin = 0;
            param1ImageView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
            param1ImageView.requestLayout();
          } 
        } else if (bool != marginLayoutParams.bottomMargin) {
          marginLayoutParams.bottomMargin = bool;
          MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
          param1ImageView.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
          param1ImageView.requestLayout();
        } 
      } 
      TabLayout.Tab tab1 = this.b;
      if (tab1 != null) {
        CharSequence charSequence = TabLayout.Tab.a(tab1);
      } else {
        tab1 = null;
      } 
      if (i != 0)
        tab1 = null; 
      TooltipCompat.setTooltipText((View)this, (CharSequence)tab1);
    }
    
    private void a(boolean param1Boolean) {
      setClipChildren(param1Boolean);
      setClipToPadding(param1Boolean);
      ViewGroup viewGroup = (ViewGroup)getParent();
      if (viewGroup != null) {
        viewGroup.setClipChildren(param1Boolean);
        viewGroup.setClipToPadding(param1Boolean);
      } 
    }
    
    private void b(View param1View) {
      if (!i())
        return; 
      if (param1View != null) {
        a(false);
        BadgeUtils.a(this.f, param1View, d(param1View));
        this.e = param1View;
      } 
    }
    
    private void c(View param1View) {
      if (i() && param1View == this.e)
        BadgeUtils.c(this.f, param1View, d(param1View)); 
    }
    
    private FrameLayout d(View param1View) {
      ImageView imageView = this.d;
      FrameLayout frameLayout = null;
      if (param1View != imageView && param1View != this.c)
        return null; 
      if (BadgeUtils.a)
        frameLayout = (FrameLayout)param1View.getParent(); 
      return frameLayout;
    }
    
    private void d() {
      TabView tabView;
      if (BadgeUtils.a) {
        FrameLayout frameLayout = f();
        addView((View)frameLayout, 0);
      } else {
        tabView = this;
      } 
      this.d = (ImageView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup)tabView, false);
      tabView.addView((View)this.d, 0);
    }
    
    private void e() {
      TabView tabView;
      if (BadgeUtils.a) {
        FrameLayout frameLayout = f();
        addView((View)frameLayout);
      } else {
        tabView = this;
      } 
      this.c = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup)tabView, false);
      tabView.addView((View)this.c);
    }
    
    private FrameLayout f() {
      FrameLayout frameLayout = new FrameLayout(getContext());
      frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
      return frameLayout;
    }
    
    private void g() {
      if (!i())
        return; 
      if (this.g != null) {
        h();
        return;
      } 
      if (this.d != null) {
        TabLayout.Tab tab = this.b;
        if (tab != null && tab.b() != null) {
          View view = this.e;
          ImageView imageView = this.d;
          if (view != imageView) {
            h();
            b((View)this.d);
            return;
          } 
          c((View)imageView);
          return;
        } 
      } 
      if (this.c != null) {
        TabLayout.Tab tab = this.b;
        if (tab != null && tab.e() == 1) {
          View view = this.e;
          TextView textView = this.c;
          if (view != textView) {
            h();
            b((View)this.c);
            return;
          } 
          c((View)textView);
          return;
        } 
      } 
      h();
    }
    
    private BadgeDrawable getBadge() {
      return this.f;
    }
    
    private int getContentWidth() {
      View[] arrayOfView = new View[3];
      TextView textView = this.c;
      int k = 0;
      arrayOfView[0] = (View)textView;
      arrayOfView[1] = (View)this.d;
      arrayOfView[2] = this.g;
      int n = arrayOfView.length;
      int m = 0;
      int i = 0;
      for (int j = 0; k < n; j = i1) {
        View view = arrayOfView[k];
        int i3 = m;
        int i2 = i;
        int i1 = j;
        if (view != null) {
          i3 = m;
          i2 = i;
          i1 = j;
          if (view.getVisibility() == 0) {
            if (j) {
              i = Math.min(i, view.getLeft());
            } else {
              i = view.getLeft();
            } 
            if (j) {
              j = Math.max(m, view.getRight());
            } else {
              j = view.getRight();
            } 
            i1 = 1;
            i2 = i;
            i3 = j;
          } 
        } 
        k++;
        m = i3;
        i = i2;
      } 
      return m - i;
    }
    
    private BadgeDrawable getOrCreateBadge() {
      if (this.f == null)
        this.f = BadgeDrawable.a(getContext()); 
      g();
      BadgeDrawable badgeDrawable = this.f;
      if (badgeDrawable != null)
        return badgeDrawable; 
      throw new IllegalStateException("Unable to create badge");
    }
    
    private void h() {
      if (!i())
        return; 
      a(true);
      View view = this.e;
      if (view != null) {
        BadgeUtils.b(this.f, view, d(view));
        this.e = null;
      } 
    }
    
    private boolean i() {
      return (this.f != null);
    }
    
    void a() {
      setTab((TabLayout.Tab)null);
      setSelected(false);
    }
    
    final void b() {
      boolean bool;
      View view1;
      TabLayout.Tab tab = this.b;
      View view2 = null;
      if (tab != null) {
        view1 = tab.a();
      } else {
        view1 = null;
      } 
      if (view1 != null) {
        ViewParent viewParent = view1.getParent();
        if (viewParent != this) {
          if (viewParent != null)
            ((ViewGroup)viewParent).removeView(view1); 
          addView(view1);
        } 
        this.g = view1;
        TextView textView2 = this.c;
        if (textView2 != null)
          textView2.setVisibility(8); 
        ImageView imageView = this.d;
        if (imageView != null) {
          imageView.setVisibility(8);
          this.d.setImageDrawable(null);
        } 
        this.h = (TextView)view1.findViewById(16908308);
        TextView textView1 = this.h;
        if (textView1 != null)
          this.k = TextViewCompat.getMaxLines(textView1); 
        this.i = (ImageView)view1.findViewById(16908294);
      } else {
        view1 = this.g;
        if (view1 != null) {
          removeView(view1);
          this.g = null;
        } 
        this.h = null;
        this.i = null;
      } 
      if (this.g == null) {
        Drawable drawable;
        if (this.d == null)
          d(); 
        view1 = view2;
        if (tab != null) {
          view1 = view2;
          if (tab.b() != null)
            drawable = DrawableCompat.wrap(tab.b()).mutate(); 
        } 
        if (drawable != null) {
          DrawableCompat.setTintList(drawable, this.a.h);
          if (this.a.k != null)
            DrawableCompat.setTintMode(drawable, this.a.k); 
        } 
        if (this.c == null) {
          e();
          this.k = TextViewCompat.getMaxLines(this.c);
        } 
        TextViewCompat.setTextAppearance(this.c, this.a.f);
        if (this.a.g != null)
          this.c.setTextColor(this.a.g); 
        a(this.c, this.d);
        g();
        a((View)this.d);
        a((View)this.c);
      } else if (this.h != null || this.i != null) {
        a(this.h, this.i);
      } 
      if (tab != null && !TextUtils.isEmpty(TabLayout.Tab.a(tab)))
        setContentDescription(TabLayout.Tab.a(tab)); 
      if (tab != null && tab.g()) {
        bool = true;
      } else {
        bool = false;
      } 
      setSelected(bool);
    }
    
    final void c() {
      setOrientation(this.a.t ^ true);
      if (this.h != null || this.i != null) {
        a(this.h, this.i);
        return;
      } 
      a(this.c, this.d);
    }
    
    protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] arrayOfInt = getDrawableState();
      Drawable drawable = this.j;
      byte b = 0;
      int i = b;
      if (drawable != null) {
        i = b;
        if (drawable.isStateful())
          i = false | this.j.setState(arrayOfInt); 
      } 
      if (i != 0) {
        invalidate();
        this.a.invalidate();
      } 
    }
    
    public TabLayout.Tab getTab() {
      return this.b;
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      super.onInitializeAccessibilityNodeInfo(param1AccessibilityNodeInfo);
      BadgeDrawable badgeDrawable = this.f;
      if (badgeDrawable != null && badgeDrawable.isVisible()) {
        CharSequence charSequence = getContentDescription();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence);
        stringBuilder.append(", ");
        stringBuilder.append(this.f.f());
        param1AccessibilityNodeInfo.setContentDescription(stringBuilder.toString());
      } 
      AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap(param1AccessibilityNodeInfo);
      accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.b.c(), 1, false, isSelected()));
      if (isSelected()) {
        accessibilityNodeInfoCompat.setClickable(false);
        accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
      } 
      accessibilityNodeInfoCompat.setRoleDescription("Tab");
    }
    
    public void onMeasure(int param1Int1, int param1Int2) {
      // Byte code:
      //   0: iload_1
      //   1: invokestatic getSize : (I)I
      //   4: istore #6
      //   6: iload_1
      //   7: invokestatic getMode : (I)I
      //   10: istore #7
      //   12: aload_0
      //   13: getfield a : Lcom/google/android/material/tabs/TabLayout;
      //   16: invokevirtual getTabMaxWidth : ()I
      //   19: istore #8
      //   21: iload_1
      //   22: istore #5
      //   24: iload #8
      //   26: ifle -> 59
      //   29: iload #7
      //   31: ifeq -> 44
      //   34: iload_1
      //   35: istore #5
      //   37: iload #6
      //   39: iload #8
      //   41: if_icmple -> 59
      //   44: aload_0
      //   45: getfield a : Lcom/google/android/material/tabs/TabLayout;
      //   48: getfield o : I
      //   51: ldc_w -2147483648
      //   54: invokestatic makeMeasureSpec : (II)I
      //   57: istore #5
      //   59: aload_0
      //   60: iload #5
      //   62: iload_2
      //   63: invokespecial onMeasure : (II)V
      //   66: aload_0
      //   67: getfield c : Landroid/widget/TextView;
      //   70: ifnull -> 321
      //   73: aload_0
      //   74: getfield a : Lcom/google/android/material/tabs/TabLayout;
      //   77: getfield l : F
      //   80: fstore #4
      //   82: aload_0
      //   83: getfield k : I
      //   86: istore #6
      //   88: aload_0
      //   89: getfield d : Landroid/widget/ImageView;
      //   92: astore #10
      //   94: iconst_1
      //   95: istore #7
      //   97: aload #10
      //   99: ifnull -> 118
      //   102: aload #10
      //   104: invokevirtual getVisibility : ()I
      //   107: ifne -> 118
      //   110: iconst_1
      //   111: istore_1
      //   112: fload #4
      //   114: fstore_3
      //   115: goto -> 161
      //   118: aload_0
      //   119: getfield c : Landroid/widget/TextView;
      //   122: astore #10
      //   124: fload #4
      //   126: fstore_3
      //   127: iload #6
      //   129: istore_1
      //   130: aload #10
      //   132: ifnull -> 161
      //   135: fload #4
      //   137: fstore_3
      //   138: iload #6
      //   140: istore_1
      //   141: aload #10
      //   143: invokevirtual getLineCount : ()I
      //   146: iconst_1
      //   147: if_icmple -> 161
      //   150: aload_0
      //   151: getfield a : Lcom/google/android/material/tabs/TabLayout;
      //   154: getfield m : F
      //   157: fstore_3
      //   158: iload #6
      //   160: istore_1
      //   161: aload_0
      //   162: getfield c : Landroid/widget/TextView;
      //   165: invokevirtual getTextSize : ()F
      //   168: fstore #4
      //   170: aload_0
      //   171: getfield c : Landroid/widget/TextView;
      //   174: invokevirtual getLineCount : ()I
      //   177: istore #8
      //   179: aload_0
      //   180: getfield c : Landroid/widget/TextView;
      //   183: invokestatic getMaxLines : (Landroid/widget/TextView;)I
      //   186: istore #6
      //   188: fload_3
      //   189: fload #4
      //   191: fcmpl
      //   192: istore #9
      //   194: iload #9
      //   196: ifne -> 210
      //   199: iload #6
      //   201: iflt -> 321
      //   204: iload_1
      //   205: iload #6
      //   207: if_icmpeq -> 321
      //   210: iload #7
      //   212: istore #6
      //   214: aload_0
      //   215: getfield a : Lcom/google/android/material/tabs/TabLayout;
      //   218: getfield s : I
      //   221: iconst_1
      //   222: if_icmpne -> 292
      //   225: iload #7
      //   227: istore #6
      //   229: iload #9
      //   231: ifle -> 292
      //   234: iload #7
      //   236: istore #6
      //   238: iload #8
      //   240: iconst_1
      //   241: if_icmpne -> 292
      //   244: aload_0
      //   245: getfield c : Landroid/widget/TextView;
      //   248: invokevirtual getLayout : ()Landroid/text/Layout;
      //   251: astore #10
      //   253: aload #10
      //   255: ifnull -> 289
      //   258: iload #7
      //   260: istore #6
      //   262: aload_0
      //   263: aload #10
      //   265: iconst_0
      //   266: fload_3
      //   267: invokespecial a : (Landroid/text/Layout;IF)F
      //   270: aload_0
      //   271: invokevirtual getMeasuredWidth : ()I
      //   274: aload_0
      //   275: invokevirtual getPaddingLeft : ()I
      //   278: isub
      //   279: aload_0
      //   280: invokevirtual getPaddingRight : ()I
      //   283: isub
      //   284: i2f
      //   285: fcmpl
      //   286: ifle -> 292
      //   289: iconst_0
      //   290: istore #6
      //   292: iload #6
      //   294: ifeq -> 321
      //   297: aload_0
      //   298: getfield c : Landroid/widget/TextView;
      //   301: iconst_0
      //   302: fload_3
      //   303: invokevirtual setTextSize : (IF)V
      //   306: aload_0
      //   307: getfield c : Landroid/widget/TextView;
      //   310: iload_1
      //   311: invokevirtual setMaxLines : (I)V
      //   314: aload_0
      //   315: iload #5
      //   317: iload_2
      //   318: invokespecial onMeasure : (II)V
      //   321: return
    }
    
    public boolean performClick() {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (this.b != null) {
        if (!bool2)
          playSoundEffect(0); 
        this.b.f();
        bool1 = true;
      } 
      return bool1;
    }
    
    public void setSelected(boolean param1Boolean) {
      boolean bool;
      if (isSelected() != param1Boolean) {
        bool = true;
      } else {
        bool = false;
      } 
      super.setSelected(param1Boolean);
      if (bool && param1Boolean && Build.VERSION.SDK_INT < 16)
        sendAccessibilityEvent(4); 
      TextView textView = this.c;
      if (textView != null)
        textView.setSelected(param1Boolean); 
      ImageView imageView = this.d;
      if (imageView != null)
        imageView.setSelected(param1Boolean); 
      View view = this.g;
      if (view != null)
        view.setSelected(param1Boolean); 
    }
    
    void setTab(TabLayout.Tab param1Tab) {
      if (param1Tab != this.b) {
        this.b = param1Tab;
        b();
      } 
    }
  }
  
  class null implements View.OnLayoutChangeListener {
    null(TabLayout this$0, View param1View) {}
    
    public void onLayoutChange(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int param1Int6, int param1Int7, int param1Int8) {
      if (this.a.getVisibility() == 0)
        TabLayout.TabView.a(this.b, this.a); 
    }
  }
  
  public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
    private final ViewPager a;
    
    public ViewPagerOnTabSelectedListener(ViewPager param1ViewPager) {
      this.a = param1ViewPager;
    }
    
    public void a(TabLayout.Tab param1Tab) {
      this.a.setCurrentItem(param1Tab.c());
    }
    
    public void b(TabLayout.Tab param1Tab) {}
    
    public void c(TabLayout.Tab param1Tab) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\tabs\TabLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */