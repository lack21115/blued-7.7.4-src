package com.soft.blued.customview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.util.Pools;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class PageTabLayout extends HorizontalScrollView implements BluedSkinSupportable {
  private static final Pools.Pool<Tab> E = (Pools.Pool<Tab>)new Pools.SynchronizedPool(16);
  
  private int A;
  
  private Tab B;
  
  private ValueAnimator C;
  
  private final ArrayList<Tab> D;
  
  private final Pools.Pool<TabView> F;
  
  private final ArrayList<OnTabSelectedListener> G;
  
  private int H;
  
  final int a;
  
  int b;
  
  int c;
  
  int d;
  
  int e;
  
  int f;
  
  int g;
  
  int h;
  
  ColorStateList i;
  
  float j;
  
  private final int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private ViewPager q;
  
  private TabLayoutOnPageChangeListener r;
  
  private AdapterChangeListener s;
  
  private OnTabSelectedListener t;
  
  private boolean u;
  
  private final SlidingTabStrip v;
  
  private PagerAdapter w;
  
  private DataSetObserver x;
  
  private float y;
  
  private float z;
  
  public PageTabLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public PageTabLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PageTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial <init> : (Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: ldc 2147483647
    //   10: putfield f : I
    //   13: aload_0
    //   14: new java/util/ArrayList
    //   17: dup
    //   18: invokespecial <init> : ()V
    //   21: putfield D : Ljava/util/ArrayList;
    //   24: aload_0
    //   25: new androidx/core/util/Pools$SimplePool
    //   28: dup
    //   29: bipush #12
    //   31: invokespecial <init> : (I)V
    //   34: putfield F : Landroidx/core/util/Pools$Pool;
    //   37: aload_0
    //   38: new java/util/ArrayList
    //   41: dup
    //   42: invokespecial <init> : ()V
    //   45: putfield G : Ljava/util/ArrayList;
    //   48: aload_0
    //   49: fconst_0
    //   50: putfield j : F
    //   53: aload_0
    //   54: iconst_0
    //   55: invokevirtual setHorizontalScrollBarEnabled : (Z)V
    //   58: aload_0
    //   59: new com/soft/blued/customview/PageTabLayout$SlidingTabStrip
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: invokespecial <init> : (Lcom/soft/blued/customview/PageTabLayout;Landroid/content/Context;)V
    //   68: putfield v : Lcom/soft/blued/customview/PageTabLayout$SlidingTabStrip;
    //   71: aload_0
    //   72: aload_0
    //   73: getfield v : Lcom/soft/blued/customview/PageTabLayout$SlidingTabStrip;
    //   76: iconst_0
    //   77: new android/widget/FrameLayout$LayoutParams
    //   80: dup
    //   81: bipush #-2
    //   83: iconst_m1
    //   84: invokespecial <init> : (II)V
    //   87: invokespecial addView : (Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    //   90: aload_1
    //   91: aload_2
    //   92: getstatic com/soft/blued/R$styleable.PageTabLayout : [I
    //   95: iload_3
    //   96: ldc 2131821200
    //   98: invokevirtual obtainStyledAttributes : (Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   101: astore_2
    //   102: aload_0
    //   103: getfield v : Lcom/soft/blued/customview/PageTabLayout$SlidingTabStrip;
    //   106: aload_2
    //   107: iconst_4
    //   108: iconst_0
    //   109: invokevirtual getDimensionPixelSize : (II)I
    //   112: invokevirtual setSelectedIndicatorHeight : (I)V
    //   115: aload_0
    //   116: getfield v : Lcom/soft/blued/customview/PageTabLayout$SlidingTabStrip;
    //   119: aload_2
    //   120: iconst_5
    //   121: iconst_0
    //   122: invokevirtual getDimensionPixelSize : (II)I
    //   125: invokevirtual setSelectedIndicatorRadius : (I)V
    //   128: aload_0
    //   129: aload_2
    //   130: iconst_3
    //   131: iconst_0
    //   132: invokevirtual getResourceId : (II)I
    //   135: putfield H : I
    //   138: aload_0
    //   139: getfield v : Lcom/soft/blued/customview/PageTabLayout$SlidingTabStrip;
    //   142: aload_1
    //   143: aload_0
    //   144: getfield H : I
    //   147: invokestatic a : (Landroid/content/Context;I)I
    //   150: invokevirtual setSelectedIndicatorColor : (I)V
    //   153: aload_2
    //   154: bipush #10
    //   156: iconst_0
    //   157: invokevirtual getDimensionPixelSize : (II)I
    //   160: istore_3
    //   161: aload_0
    //   162: iload_3
    //   163: putfield e : I
    //   166: aload_0
    //   167: iload_3
    //   168: putfield d : I
    //   171: aload_0
    //   172: iload_3
    //   173: putfield c : I
    //   176: aload_0
    //   177: iload_3
    //   178: putfield b : I
    //   181: aload_0
    //   182: aload_2
    //   183: bipush #13
    //   185: aload_0
    //   186: getfield b : I
    //   189: invokevirtual getDimensionPixelSize : (II)I
    //   192: putfield b : I
    //   195: aload_0
    //   196: aload_2
    //   197: bipush #14
    //   199: aload_0
    //   200: getfield c : I
    //   203: invokevirtual getDimensionPixelSize : (II)I
    //   206: putfield c : I
    //   209: aload_0
    //   210: aload_2
    //   211: bipush #12
    //   213: aload_0
    //   214: getfield d : I
    //   217: invokevirtual getDimensionPixelSize : (II)I
    //   220: putfield d : I
    //   223: aload_0
    //   224: aload_2
    //   225: bipush #11
    //   227: aload_0
    //   228: getfield e : I
    //   231: invokevirtual getDimensionPixelSize : (II)I
    //   234: putfield e : I
    //   237: aload_0
    //   238: aload_2
    //   239: bipush #6
    //   241: aload_0
    //   242: getfield p : I
    //   245: invokevirtual getDimensionPixelSize : (II)I
    //   248: putfield p : I
    //   251: aload_0
    //   252: aload_2
    //   253: bipush #16
    //   255: ldc 2131820950
    //   257: invokevirtual getResourceId : (II)I
    //   260: putfield l : I
    //   263: aload_0
    //   264: aload_2
    //   265: iconst_0
    //   266: iconst_0
    //   267: invokevirtual getResourceId : (II)I
    //   270: putfield a : I
    //   273: aload_0
    //   274: aload_2
    //   275: bipush #18
    //   277: iconst_1
    //   278: invokevirtual getInteger : (II)I
    //   281: putfield A : I
    //   284: aload_1
    //   285: aload_0
    //   286: getfield l : I
    //   289: getstatic com/soft/blued/R$styleable.TextAppearance : [I
    //   292: invokevirtual obtainStyledAttributes : (I[I)Landroid/content/res/TypedArray;
    //   295: astore #5
    //   297: aload_0
    //   298: aload #5
    //   300: iconst_0
    //   301: iconst_0
    //   302: invokevirtual getDimensionPixelSize : (II)I
    //   305: i2f
    //   306: putfield y : F
    //   309: aload_0
    //   310: aload #5
    //   312: iconst_3
    //   313: invokevirtual getColorStateList : (I)Landroid/content/res/ColorStateList;
    //   316: putfield i : Landroid/content/res/ColorStateList;
    //   319: aload #5
    //   321: invokevirtual recycle : ()V
    //   324: aload_2
    //   325: bipush #17
    //   327: invokevirtual hasValue : (I)Z
    //   330: ifeq -> 368
    //   333: invokestatic c : ()Z
    //   336: ifeq -> 352
    //   339: aload_0
    //   340: aload_2
    //   341: bipush #17
    //   343: invokevirtual getColorStateList : (I)Landroid/content/res/ColorStateList;
    //   346: putfield i : Landroid/content/res/ColorStateList;
    //   349: goto -> 368
    //   352: aload_1
    //   353: aload_2
    //   354: bipush #17
    //   356: iconst_0
    //   357: invokevirtual getResourceId : (II)I
    //   360: invokestatic a : (Landroid/content/Context;I)I
    //   363: istore #4
    //   365: goto -> 371
    //   368: iconst_m1
    //   369: istore #4
    //   371: aload_2
    //   372: bipush #15
    //   374: invokevirtual hasValue : (I)Z
    //   377: ifeq -> 514
    //   380: invokestatic c : ()Z
    //   383: ifeq -> 428
    //   386: aload_2
    //   387: bipush #15
    //   389: iconst_0
    //   390: invokevirtual getColor : (II)I
    //   393: istore_3
    //   394: new java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial <init> : ()V
    //   401: astore_1
    //   402: aload_1
    //   403: ldc 'selected color id = '
    //   405: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_1
    //   410: iload_3
    //   411: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: ldc 'skin'
    //   417: aload_1
    //   418: invokevirtual toString : ()Ljava/lang/String;
    //   421: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   424: pop
    //   425: goto -> 480
    //   428: aload_1
    //   429: aload_2
    //   430: bipush #15
    //   432: iconst_0
    //   433: invokevirtual getResourceId : (II)I
    //   436: invokestatic a : (Landroid/content/Context;I)I
    //   439: istore_3
    //   440: new java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial <init> : ()V
    //   447: astore_1
    //   448: aload_1
    //   449: ldc_w 'SkinCompatResources selected color id = '
    //   452: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_1
    //   457: iload_3
    //   458: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: ldc 'skin'
    //   464: aload_1
    //   465: invokevirtual toString : ()Ljava/lang/String;
    //   468: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   471: pop
    //   472: goto -> 480
    //   475: goto -> 480
    //   478: iconst_0
    //   479: istore_3
    //   480: invokestatic c : ()Z
    //   483: ifeq -> 504
    //   486: aload_0
    //   487: aload_0
    //   488: getfield i : Landroid/content/res/ColorStateList;
    //   491: invokevirtual getDefaultColor : ()I
    //   494: iload_3
    //   495: invokestatic a : (II)Landroid/content/res/ColorStateList;
    //   498: putfield i : Landroid/content/res/ColorStateList;
    //   501: goto -> 514
    //   504: aload_0
    //   505: iload #4
    //   507: iload_3
    //   508: invokestatic a : (II)Landroid/content/res/ColorStateList;
    //   511: putfield i : Landroid/content/res/ColorStateList;
    //   514: aload_0
    //   515: aload_2
    //   516: bipush #8
    //   518: iconst_m1
    //   519: invokevirtual getDimensionPixelSize : (II)I
    //   522: putfield m : I
    //   525: aload_0
    //   526: aload_2
    //   527: bipush #7
    //   529: iconst_m1
    //   530: invokevirtual getDimensionPixelSize : (II)I
    //   533: putfield o : I
    //   536: aload_0
    //   537: aload_2
    //   538: iconst_1
    //   539: iconst_0
    //   540: invokevirtual getDimensionPixelSize : (II)I
    //   543: putfield k : I
    //   546: aload_0
    //   547: aload_2
    //   548: bipush #9
    //   550: iconst_1
    //   551: invokevirtual getInt : (II)I
    //   554: putfield h : I
    //   557: aload_0
    //   558: aload_2
    //   559: iconst_2
    //   560: iconst_0
    //   561: invokevirtual getInt : (II)I
    //   564: putfield g : I
    //   567: aload_2
    //   568: invokevirtual recycle : ()V
    //   571: aload_0
    //   572: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   575: astore_1
    //   576: aload_0
    //   577: aload_1
    //   578: ldc_w 2131165342
    //   581: invokevirtual getDimensionPixelSize : (I)I
    //   584: i2f
    //   585: putfield z : F
    //   588: aload_0
    //   589: aload_1
    //   590: ldc_w 2131165486
    //   593: invokevirtual getDimensionPixelSize : (I)I
    //   596: putfield n : I
    //   599: aload_0
    //   600: invokespecial c : ()V
    //   603: return
    //   604: astore_1
    //   605: aload #5
    //   607: invokevirtual recycle : ()V
    //   610: aload_1
    //   611: athrow
    //   612: astore_1
    //   613: goto -> 478
    //   616: astore_1
    //   617: goto -> 475
    // Exception table:
    //   from	to	target	type
    //   297	319	604	finally
    //   428	440	612	java/lang/Exception
    //   440	472	616	java/lang/Exception
  }
  
  private int a(int paramInt, float paramFloat) {
    int j = this.h;
    int i = 0;
    if (j == 0) {
      View view1;
      View view2 = this.v.getChildAt(paramInt);
      if (++paramInt < this.v.getChildCount()) {
        view1 = this.v.getChildAt(paramInt);
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
  
  private static ColorStateList a(int paramInt1, int paramInt2) {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams) {
    if (this.h == 1 && this.g == 0) {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    } 
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2) {
    ViewPager viewPager = this.q;
    if (viewPager != null) {
      TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.r;
      if (tabLayoutOnPageChangeListener != null)
        viewPager.removeOnPageChangeListener(tabLayoutOnPageChangeListener); 
      AdapterChangeListener adapterChangeListener = this.s;
      if (adapterChangeListener != null)
        this.q.removeOnAdapterChangeListener(adapterChangeListener); 
    } 
    OnTabSelectedListener onTabSelectedListener = this.t;
    if (onTabSelectedListener != null) {
      b(onTabSelectedListener);
      this.t = null;
    } 
    if (paramViewPager != null) {
      this.q = paramViewPager;
      if (this.r == null)
        this.r = new TabLayoutOnPageChangeListener(this); 
      this.r.a();
      paramViewPager.addOnPageChangeListener(this.r);
      this.t = new ViewPagerOnTabSelectedListener(paramViewPager);
      a(this.t);
      PagerAdapter pagerAdapter = paramViewPager.getAdapter();
      if (pagerAdapter != null)
        a(pagerAdapter, paramBoolean1); 
      if (this.s == null)
        this.s = new AdapterChangeListener(this); 
      this.s.a(paramBoolean1);
      paramViewPager.addOnAdapterChangeListener(this.s);
      a(paramViewPager.getCurrentItem(), 0.0F, true);
    } else {
      this.q = null;
      a((PagerAdapter)null, false);
    } 
    this.u = paramBoolean2;
  }
  
  private void a(OnTabSelectedListener paramOnTabSelectedListener) {
    if (!this.G.contains(paramOnTabSelectedListener))
      this.G.add(paramOnTabSelectedListener); 
  }
  
  private void a(Tab paramTab, int paramInt) {
    paramTab.a(paramInt);
    this.D.add(paramInt, paramTab);
    int i = this.D.size();
    while (true) {
      if (++paramInt < i) {
        ((Tab)this.D.get(paramInt)).a(paramInt);
        continue;
      } 
      break;
    } 
  }
  
  private void b(OnTabSelectedListener paramOnTabSelectedListener) {
    this.G.remove(paramOnTabSelectedListener);
  }
  
  private void b(Tab paramTab) {
    for (int i = this.G.size() - 1; i >= 0; i--)
      ((OnTabSelectedListener)this.G.get(i)).a(paramTab); 
  }
  
  private void c() {
    if (this.h == 0) {
      i = Math.max(0, this.k - this.b);
    } else {
      i = 0;
    } 
    ViewCompat.setPaddingRelative((View)this.v, i, 0, 0, 0);
    int i = this.h;
    if (i != 0) {
      if (i == 1)
        this.v.setGravity(1); 
    } else {
      this.v.setGravity(8388611);
    } 
    a(true);
  }
  
  private void c(int paramInt) {
    if (paramInt == -1)
      return; 
    if (getWindowToken() == null || !ViewCompat.isLaidOut((View)this) || this.v.a()) {
      a(paramInt, 0.0F, true);
      return;
    } 
    int i = getScrollX();
    int j = a(paramInt, 0.0F);
    if (i != j) {
      d();
      this.C.setIntValues(new int[] { i, j });
      this.C.start();
    } 
    this.v.b(paramInt, 300);
  }
  
  private void c(Tab paramTab) {
    for (int i = this.G.size() - 1; i >= 0; i--)
      ((OnTabSelectedListener)this.G.get(i)).b(paramTab); 
  }
  
  private void d() {
    if (this.C == null) {
      this.C = new ValueAnimator();
      this.C.setInterpolator((TimeInterpolator)AnimationUtils.b);
      this.C.setDuration(300L);
      this.C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.scrollTo(((Integer)param1ValueAnimator.getAnimatedValue()).intValue(), 0);
            }
          });
    } 
  }
  
  private void d(int paramInt) {
    TabView tabView = (TabView)this.v.getChildAt(paramInt);
    this.v.removeViewAt(paramInt);
    if (tabView != null) {
      tabView.a();
      this.F.release(tabView);
    } 
    requestLayout();
  }
  
  private void d(Tab paramTab) {
    for (int i = this.G.size() - 1; i >= 0; i--)
      ((OnTabSelectedListener)this.G.get(i)).c(paramTab); 
  }
  
  private TabView e(Tab paramTab) {
    TabView tabView;
    Pools.Pool<TabView> pool1 = this.F;
    if (pool1 != null) {
      TabView tabView1 = (TabView)pool1.acquire();
    } else {
      pool1 = null;
    } 
    Pools.Pool<TabView> pool2 = pool1;
    if (pool1 == null)
      tabView = new TabView(this, getContext()); 
    tabView.a(paramTab);
    tabView.setFocusable(true);
    tabView.setMinimumWidth(getTabMinWidth());
    return tabView;
  }
  
  private void e() {
    b();
    PagerAdapter pagerAdapter = this.w;
    if (pagerAdapter != null) {
      int j = pagerAdapter.getCount();
      int i;
      for (i = 0; i < j; i++)
        b(a().a(this.w.getPageTitle(i)), false); 
      ViewPager viewPager = this.q;
      if (viewPager != null && j > 0) {
        i = viewPager.getCurrentItem();
        if (i != getSelectedTabPosition() && i < getTabCount())
          a(a(i)); 
      } 
    } 
  }
  
  private LinearLayout.LayoutParams f() {
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(layoutParams);
    return layoutParams;
  }
  
  private void f(Tab paramTab) {
    TabView tabView = paramTab.b;
    this.v.addView((View)tabView, paramTab.c(), (ViewGroup.LayoutParams)f());
  }
  
  private int getDefaultHeight() {
    boolean bool1;
    int j = this.D.size();
    boolean bool2 = false;
    int i = 0;
    while (true) {
      bool1 = bool2;
      if (i < j) {
        Tab tab = this.D.get(i);
        if (tab != null && tab.b() != null && !TextUtils.isEmpty(tab.d())) {
          bool1 = true;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    return bool1 ? 72 : 48;
  }
  
  private int getSelectedTabPosition() {
    Tab tab = this.B;
    return (tab != null) ? tab.c() : -1;
  }
  
  private int getTabCount() {
    return this.D.size();
  }
  
  private int getTabMaxWidth() {
    return this.f;
  }
  
  private int getTabMinWidth() {
    int i = this.m;
    return (i != -1) ? i : ((this.h == 0) ? this.n : 0);
  }
  
  private void setSelectedTabView(int paramInt) {
    int i = this.v.getChildCount();
    if (paramInt < i)
      for (int j = 0; j < i; j++) {
        boolean bool;
        View view = this.v.getChildAt(j);
        if (j == paramInt) {
          bool = true;
        } else {
          bool = false;
        } 
        view.setSelected(bool);
      }  
  }
  
  public Tab a() {
    Tab tab2 = (Tab)E.acquire();
    Tab tab1 = tab2;
    if (tab2 == null)
      tab1 = new Tab(this); 
    tab1.a = this;
    tab1.b = e(tab1);
    return tab1;
  }
  
  public Tab a(int paramInt) {
    return (paramInt < 0 || paramInt >= getTabCount()) ? null : this.D.get(paramInt);
  }
  
  public void a(int paramInt, float paramFloat, boolean paramBoolean) {
    a(paramInt, paramFloat, paramBoolean, true);
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2) {
    int i;
    if (paramFloat > this.j) {
      i = Math.round(paramInt + paramFloat - 0.4F);
    } else {
      i = Math.round(paramInt + paramFloat + 0.4F);
    } 
    this.j = paramFloat;
    if (i >= 0) {
      if (i >= this.v.getChildCount())
        return; 
      if (paramBoolean2)
        this.v.a(paramInt, paramFloat); 
      ValueAnimator valueAnimator = this.C;
      if (valueAnimator != null && valueAnimator.isRunning())
        this.C.cancel(); 
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean1)
        setSelectedTabView(i); 
    } 
  }
  
  void a(PagerAdapter paramPagerAdapter, boolean paramBoolean) {
    PagerAdapter pagerAdapter = this.w;
    if (pagerAdapter != null) {
      DataSetObserver dataSetObserver = this.x;
      if (dataSetObserver != null)
        pagerAdapter.unregisterDataSetObserver(dataSetObserver); 
    } 
    this.w = paramPagerAdapter;
    if (paramBoolean && paramPagerAdapter != null) {
      if (this.x == null)
        this.x = new PagerAdapterObserver(this); 
      paramPagerAdapter.registerDataSetObserver(this.x);
    } 
    e();
  }
  
  void a(Tab paramTab) {
    a(paramTab, true);
  }
  
  public void a(Tab paramTab, int paramInt, boolean paramBoolean) {
    if (paramTab.a == this) {
      a(paramTab, paramInt);
      f(paramTab);
      if (paramBoolean)
        paramTab.e(); 
      return;
    } 
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  void a(Tab paramTab, boolean paramBoolean) {
    Tab tab = this.B;
    if (tab == paramTab) {
      if (tab != null) {
        d(paramTab);
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
      if (tab != null)
        c(tab); 
      this.B = paramTab;
      if (paramTab != null)
        b(paramTab); 
    } 
  }
  
  void a(boolean paramBoolean) {
    for (int i = 0; i < this.v.getChildCount(); i++) {
      View view = this.v.getChildAt(i);
      view.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)view.getLayoutParams());
      if (paramBoolean)
        view.requestLayout(); 
    } 
  }
  
  int b(int paramInt) {
    return Math.round((getResources().getDisplayMetrics()).density * paramInt);
  }
  
  public void b() {
    for (int i = this.v.getChildCount() - 1; i >= 0; i--)
      d(i); 
    Iterator<Tab> iterator = this.D.iterator();
    while (iterator.hasNext()) {
      Tab tab = iterator.next();
      iterator.remove();
      tab.i();
      E.release(tab);
    } 
    this.B = null;
  }
  
  public void b(Tab paramTab, boolean paramBoolean) {
    a(paramTab, this.D.size(), paramBoolean);
  }
  
  public void g() {
    this.v.setSelectedIndicatorColor(BluedSkinUtils.a(getContext(), this.H));
  }
  
  public int getTabsCount() {
    ArrayList<Tab> arrayList = this.D;
    return (arrayList != null) ? arrayList.size() : 0;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.q == null) {
      ViewParent viewParent = getParent();
      if (viewParent instanceof ViewPager)
        a((ViewPager)viewParent, true, true); 
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.u) {
      setupWithViewPager((ViewPager)null);
      this.u = false;
    } 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int i = b(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    int j = View.MeasureSpec.getMode(paramInt2);
    if (j != Integer.MIN_VALUE) {
      if (j == 0)
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824); 
    } else {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
    } 
    j = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      i = this.o;
      if (i <= 0)
        i = j - b(29); 
      this.f = i;
    } 
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 1) {
      paramInt1 = 0;
      View view = getChildAt(0);
      i = this.h;
      if ((i != 0) ? (i == 1 && view.getMeasuredWidth() != getMeasuredWidth()) : (view.getMeasuredWidth() < getMeasuredWidth()))
        paramInt1 = 1; 
      if (paramInt1 != 0) {
        paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), (view.getLayoutParams()).height);
        view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      } 
    } 
  }
  
  public void setupWithViewPager(ViewPager paramViewPager) {
    a(paramViewPager, true, false);
  }
  
  class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {
    private boolean b;
    
    AdapterChangeListener(PageTabLayout this$0) {}
    
    void a(boolean param1Boolean) {
      this.b = param1Boolean;
    }
    
    public void onAdapterChanged(ViewPager param1ViewPager, PagerAdapter param1PagerAdapter1, PagerAdapter param1PagerAdapter2) {
      if (PageTabLayout.c(this.a) == param1ViewPager)
        this.a.a(param1PagerAdapter2, this.b); 
    }
  }
  
  static class AnimationUtils {
    public static final Interpolator a = (Interpolator)new LinearInterpolator();
    
    public static final Interpolator b = (Interpolator)new FastOutSlowInInterpolator();
    
    public static final Interpolator c = (Interpolator)new FastOutLinearInInterpolator();
    
    public static final Interpolator d = (Interpolator)new LinearOutSlowInInterpolator();
    
    public static final Interpolator e = (Interpolator)new DecelerateInterpolator();
    
    public static int a(int param1Int1, int param1Int2, float param1Float) {
      return param1Int1 + Math.round(param1Float * (param1Int2 - param1Int1));
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Mode {}
  
  public static interface OnTabSelectedListener {
    void a(PageTabLayout.Tab param1Tab);
    
    void b(PageTabLayout.Tab param1Tab);
    
    void c(PageTabLayout.Tab param1Tab);
  }
  
  class PagerAdapterObserver extends DataSetObserver {
    PagerAdapterObserver(PageTabLayout this$0) {}
    
    public void onChanged() {
      PageTabLayout.e(this.a);
    }
    
    public void onInvalidated() {
      PageTabLayout.e(this.a);
    }
  }
  
  public class SlidingTabStrip extends LinearLayout {
    int a = -1;
    
    float b;
    
    private int d;
    
    private final Paint e;
    
    private int f;
    
    private int g = -1;
    
    private int h = -1;
    
    private int i = -1;
    
    private ValueAnimator j;
    
    SlidingTabStrip(PageTabLayout this$0, Context param1Context) {
      super(param1Context);
      setWillNotDraw(false);
      this.e = new Paint();
    }
    
    private void b() {
      byte b1;
      byte b2;
      View view = getChildAt(this.a);
      if (view != null && view.getWidth() > 0) {
        int j = view.getLeft();
        int i = view.getRight();
        b1 = i;
        b2 = j;
        if (this.b > 0.0F) {
          b1 = i;
          b2 = j;
          if (this.a < getChildCount() - 1) {
            view = getChildAt(this.a + 1);
            float f1 = this.b;
            float f2 = view.getLeft();
            float f3 = this.b;
            b2 = (int)(f1 * f2 + (1.0F - f3) * j);
            b1 = (int)(f3 * view.getRight() + (1.0F - this.b) * i);
          } 
        } 
      } else {
        b2 = -1;
        b1 = -1;
      } 
      a(b2, b1);
    }
    
    void a(int param1Int, float param1Float) {
      ValueAnimator valueAnimator = this.j;
      if (valueAnimator != null && valueAnimator.isRunning())
        this.j.cancel(); 
      this.a = param1Int;
      this.b = param1Float;
      b();
    }
    
    void a(int param1Int1, int param1Int2) {
      if (param1Int1 != this.h || param1Int2 != this.i) {
        this.h = param1Int1;
        this.i = param1Int2;
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
    
    void b(int param1Int1, int param1Int2) {
      int i;
      int j;
      ValueAnimator valueAnimator = this.j;
      if (valueAnimator != null && valueAnimator.isRunning())
        this.j.cancel(); 
      ViewCompat.getLayoutDirection((View)this);
      View view = getChildAt(param1Int1);
      if (view == null) {
        b();
        return;
      } 
      int k = view.getLeft();
      int m = view.getRight();
      if (Math.abs(param1Int1 - this.a) <= 1) {
        i = this.h;
        j = this.i;
      } else {
        i = this.h;
        j = this.i;
      } 
      if (i != k || j != m) {
        ValueAnimator valueAnimator1 = new ValueAnimator();
        this.j = valueAnimator1;
        valueAnimator1.setInterpolator((TimeInterpolator)PageTabLayout.AnimationUtils.b);
        valueAnimator1.setDuration(param1Int2);
        valueAnimator1.setFloatValues(new float[] { 0.0F, 1.0F });
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i, k, j, m) {
              public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                float f = param2ValueAnimator.getAnimatedFraction();
                this.e.a(PageTabLayout.AnimationUtils.a(this.a, this.b, f), PageTabLayout.AnimationUtils.a(this.c, this.d, f));
              }
            });
        valueAnimator1.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, param1Int1) {
              public void onAnimationEnd(Animator param2Animator) {
                PageTabLayout.SlidingTabStrip slidingTabStrip = this.b;
                slidingTabStrip.a = this.a;
                slidingTabStrip.b = 0.0F;
              }
            });
        valueAnimator1.start();
      } 
    }
    
    protected void dispatchDraw(Canvas param1Canvas) {
      int i = PageTabLayout.d(this.c) / 2;
      RectF rectF = new RectF();
      rectF.left = (this.h + i);
      rectF.top = ((getHeight() - this.d) / 2);
      rectF.right = (this.i - i);
      rectF.bottom = rectF.top + this.d;
      this.e.setAntiAlias(true);
      i = this.h;
      if (i >= 0 && this.i > i) {
        i = this.f;
        if (i == 0) {
          i = this.d;
          param1Canvas.drawRoundRect(rectF, (i / 2), (i / 2), this.e);
        } else {
          param1Canvas.drawRoundRect(rectF, i, i, this.e);
        } 
      } 
      super.dispatchDraw(param1Canvas);
    }
    
    public void draw(Canvas param1Canvas) {
      super.draw(param1Canvas);
    }
    
    float getIndicatorPosition() {
      return this.a + this.b;
    }
    
    protected void onLayout(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      super.onLayout(param1Boolean, param1Int1, param1Int2, param1Int3, param1Int4);
      ValueAnimator valueAnimator = this.j;
      if (valueAnimator != null && valueAnimator.isRunning()) {
        this.j.cancel();
        long l = this.j.getDuration();
        b(this.a, Math.round((1.0F - this.j.getAnimatedFraction()) * (float)l));
        return;
      } 
      b();
    }
    
    protected void onMeasure(int param1Int1, int param1Int2) {
      super.onMeasure(param1Int1, param1Int2);
      if (View.MeasureSpec.getMode(param1Int1) != 1073741824)
        return; 
      int i = this.c.h;
      boolean bool = true;
      if (i == 1 && this.c.g == 1) {
        int k = getChildCount();
        byte b = 0;
        i = 0;
        int j;
        for (j = 0; i < k; j = m) {
          View view = getChildAt(i);
          int m = j;
          if (view.getVisibility() == 0)
            m = Math.max(j, view.getMeasuredWidth()); 
          i++;
        } 
        if (j <= 0)
          return; 
        i = this.c.b(16);
        if (j * k <= getMeasuredWidth() - i * 2) {
          i = 0;
          int m;
          for (m = b; m < k; m++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)getChildAt(m).getLayoutParams();
            if (layoutParams.width != j || layoutParams.weight != 0.0F) {
              layoutParams.width = j;
              layoutParams.weight = 0.0F;
              i = 1;
            } 
          } 
        } else {
          PageTabLayout pageTabLayout = this.c;
          pageTabLayout.g = 0;
          pageTabLayout.a(false);
          i = bool;
        } 
        if (i != 0)
          super.onMeasure(param1Int1, param1Int2); 
      } 
    }
    
    public void onRtlPropertiesChanged(int param1Int) {
      super.onRtlPropertiesChanged(param1Int);
      if (Build.VERSION.SDK_INT < 23 && this.g != param1Int) {
        requestLayout();
        this.g = param1Int;
      } 
    }
    
    void setSelectedIndicatorColor(int param1Int) {
      if (this.e.getColor() != param1Int) {
        this.e.setColor(param1Int);
        ViewCompat.postInvalidateOnAnimation((View)this);
      } 
    }
    
    void setSelectedIndicatorHeight(int param1Int) {
      if (this.d != param1Int) {
        this.d = param1Int;
        ViewCompat.postInvalidateOnAnimation((View)this);
      } 
    }
    
    void setSelectedIndicatorRadius(int param1Int) {
      if (this.f != param1Int) {
        this.f = param1Int;
        ViewCompat.postInvalidateOnAnimation((View)this);
      } 
    }
  }
  
  class null implements ValueAnimator.AnimatorUpdateListener {
    null(PageTabLayout this$0, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {}
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      float f = param1ValueAnimator.getAnimatedFraction();
      this.e.a(PageTabLayout.AnimationUtils.a(this.a, this.b, f), PageTabLayout.AnimationUtils.a(this.c, this.d, f));
    }
  }
  
  class null extends AnimatorListenerAdapter {
    null(PageTabLayout this$0, int param1Int) {}
    
    public void onAnimationEnd(Animator param1Animator) {
      PageTabLayout.SlidingTabStrip slidingTabStrip = this.b;
      slidingTabStrip.a = this.a;
      slidingTabStrip.b = 0.0F;
    }
  }
  
  public class Tab {
    PageTabLayout a;
    
    PageTabLayout.TabView b;
    
    private Object d;
    
    private Drawable e;
    
    private CharSequence f;
    
    private CharSequence g;
    
    private int h = -1;
    
    private View i;
    
    Tab(PageTabLayout this$0) {}
    
    public View a() {
      return this.i;
    }
    
    public Tab a(View param1View) {
      this.i = param1View;
      h();
      return this;
    }
    
    public Tab a(CharSequence param1CharSequence) {
      this.f = param1CharSequence;
      h();
      return this;
    }
    
    void a(int param1Int) {
      this.h = param1Int;
    }
    
    public Drawable b() {
      return this.e;
    }
    
    public int c() {
      return this.h;
    }
    
    public CharSequence d() {
      return this.f;
    }
    
    public void e() {
      PageTabLayout pageTabLayout = this.a;
      if (pageTabLayout != null) {
        pageTabLayout.a(this);
        return;
      } 
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public boolean f() {
      PageTabLayout pageTabLayout = this.a;
      if (pageTabLayout != null)
        return (PageTabLayout.a(pageTabLayout) == this.h); 
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    public CharSequence g() {
      return this.g;
    }
    
    void h() {
      PageTabLayout.TabView tabView = this.b;
      if (tabView != null)
        tabView.b(); 
    }
    
    void i() {
      this.a = null;
      this.b = null;
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
      this.h = -1;
      this.i = null;
    }
  }
  
  public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
    private final WeakReference<PageTabLayout> a;
    
    private int b;
    
    private int c;
    
    public TabLayoutOnPageChangeListener(PageTabLayout param1PageTabLayout) {
      this.a = new WeakReference<PageTabLayout>(param1PageTabLayout);
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
      PageTabLayout pageTabLayout = this.a.get();
      if (pageTabLayout != null) {
        param1Int2 = this.c;
        boolean bool2 = true;
        if (param1Int2 == 2)
          param1Int2 = this.b; 
        boolean bool1 = bool2;
        if (this.c == 2)
          if (this.b != 0) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }  
        pageTabLayout.a(param1Int1, param1Float, false, bool1);
      } 
    }
    
    public void onPageSelected(int param1Int) {
      PageTabLayout pageTabLayout = this.a.get();
      if (pageTabLayout != null) {
        PageTabLayout.a(pageTabLayout, param1Int);
        if (PageTabLayout.a(pageTabLayout) != param1Int && param1Int < PageTabLayout.b(pageTabLayout)) {
          boolean bool;
          int i = this.c;
          if (i == 0 || (i == 2 && this.b == 0)) {
            bool = true;
          } else {
            bool = false;
          } 
          pageTabLayout.a(pageTabLayout.a(param1Int), bool);
        } 
      } 
    }
  }
  
  class TabView extends LinearLayout {
    private PageTabLayout.Tab b;
    
    private TextView c;
    
    private ImageView d;
    
    private View e;
    
    private View f;
    
    private TextView g;
    
    private ImageView h;
    
    private int i = 1;
    
    public TabView(PageTabLayout this$0, Context param1Context) {
      super(param1Context);
      if (this$0.a != 0)
        ViewCompat.setBackground((View)this, AppCompatResources.getDrawable(param1Context, this$0.a)); 
      ViewCompat.setPaddingRelative((View)this, this$0.b, this$0.c, this$0.d, this$0.e);
      setGravity(17);
      setOrientation(0);
      setClickable(true);
      ViewCompat.setPointerIcon((View)this, PointerIconCompat.getSystemIcon(getContext(), 1002));
    }
    
    private float a(Layout param1Layout, int param1Int, float param1Float) {
      return param1Layout.getLineWidth(param1Int) * param1Float / param1Layout.getPaint().getTextSize();
    }
    
    private void a(TextView param1TextView, ImageView param1ImageView) {
      Drawable drawable;
      CharSequence charSequence;
      PageTabLayout.Tab tab1 = this.b;
      PageTabLayout.Tab tab2 = null;
      if (tab1 != null) {
        drawable = tab1.b();
      } else {
        drawable = null;
      } 
      tab1 = this.b;
      if (tab1 != null) {
        charSequence = tab1.d();
      } else {
        charSequence = null;
      } 
      tab1 = this.b;
      if (tab1 != null) {
        CharSequence charSequence1 = tab1.g();
      } else {
        tab1 = null;
      } 
      byte b = 0;
      if (param1ImageView != null) {
        if (drawable != null) {
          param1ImageView.setImageDrawable(drawable);
          param1ImageView.setVisibility(0);
          setVisibility(0);
        } else {
          param1ImageView.setVisibility(8);
          param1ImageView.setImageDrawable(null);
        } 
        param1ImageView.setContentDescription((CharSequence)tab1);
      } 
      int i = TextUtils.isEmpty(charSequence) ^ true;
      if (param1TextView != null) {
        if (i != 0) {
          param1TextView.setText(charSequence);
          param1TextView.setVisibility(0);
          setVisibility(0);
        } else {
          param1TextView.setVisibility(8);
          param1TextView.setText(null);
        } 
        param1TextView.setContentDescription((CharSequence)tab1);
      } 
      if (param1ImageView != null) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)param1ImageView.getLayoutParams();
        int j = b;
        if (i != 0) {
          j = b;
          if (param1ImageView.getVisibility() == 0)
            j = this.a.b(8); 
        } 
        if (j != marginLayoutParams.bottomMargin) {
          marginLayoutParams.bottomMargin = j;
          param1ImageView.requestLayout();
        } 
      } 
      if (i != 0)
        tab1 = tab2; 
      TooltipCompat.setTooltipText((View)this, (CharSequence)tab1);
    }
    
    void a() {
      a((PageTabLayout.Tab)null);
      setSelected(false);
    }
    
    void a(PageTabLayout.Tab param1Tab) {
      if (param1Tab != this.b) {
        this.b = param1Tab;
        b();
      } 
    }
    
    final void b() {
      PageTabLayout.Tab tab = this.b;
      if (tab != null) {
        view = tab.a();
      } else {
        view = null;
      } 
      if (view != null) {
        ViewParent viewParent = view.getParent();
        if (viewParent != this) {
          if (viewParent != null)
            ((ViewGroup)viewParent).removeView(view); 
          addView(view);
        } 
        this.f = view;
        TextView textView2 = this.c;
        if (textView2 != null)
          textView2.setVisibility(8); 
        ImageView imageView = this.d;
        if (imageView != null) {
          imageView.setVisibility(8);
          this.d.setImageDrawable(null);
        } 
        this.g = (TextView)view.findViewById(16908308);
        TextView textView1 = this.g;
        if (textView1 != null)
          this.i = TextViewCompat.getMaxLines(textView1); 
        this.h = (ImageView)view.findViewById(16908294);
      } else {
        view = this.f;
        if (view != null) {
          removeView(view);
          this.f = null;
        } 
        this.g = null;
        this.h = null;
      } 
      View view = this.f;
      boolean bool2 = false;
      if (view == null) {
        if (this.d == null) {
          ImageView imageView = (ImageView)LayoutInflater.from(getContext()).inflate(2131492963, (ViewGroup)this, false);
          addView((View)imageView, 0);
          this.d = imageView;
        } 
        if (this.c == null) {
          TextView textView = (TextView)LayoutInflater.from(getContext()).inflate(2131492964, (ViewGroup)this, false);
          addView((View)textView);
          this.c = textView;
          this.c.setMaxLines(PageTabLayout.i(this.a));
          this.c.setLines(PageTabLayout.i(this.a));
          this.i = TextViewCompat.getMaxLines(this.c);
        } 
        TextViewCompat.setTextAppearance(this.c, PageTabLayout.j(this.a));
        view = this.e;
        if (view != null)
          addView(view); 
        if (this.a.i != null)
          this.c.setTextColor(this.a.i); 
        a(this.c, this.d);
      } else if (this.g != null || this.h != null) {
        a(this.g, this.h);
      } 
      boolean bool1 = bool2;
      if (tab != null) {
        bool1 = bool2;
        if (tab.f())
          bool1 = true; 
      } 
      setSelected(bool1);
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo param1AccessibilityNodeInfo) {
      super.onInitializeAccessibilityNodeInfo(param1AccessibilityNodeInfo);
      param1AccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }
    
    public void onMeasure(int param1Int1, int param1Int2) {
      // Byte code:
      //   0: iload_1
      //   1: invokestatic getSize : (I)I
      //   4: pop
      //   5: iload_1
      //   6: invokestatic getMode : (I)I
      //   9: pop
      //   10: aload_0
      //   11: getfield a : Lcom/soft/blued/customview/PageTabLayout;
      //   14: invokestatic f : (Lcom/soft/blued/customview/PageTabLayout;)I
      //   17: pop
      //   18: aload_0
      //   19: iload_1
      //   20: iload_2
      //   21: invokespecial onMeasure : (II)V
      //   24: aload_0
      //   25: getfield c : Landroid/widget/TextView;
      //   28: ifnull -> 289
      //   31: aload_0
      //   32: invokevirtual getResources : ()Landroid/content/res/Resources;
      //   35: pop
      //   36: aload_0
      //   37: getfield a : Lcom/soft/blued/customview/PageTabLayout;
      //   40: invokestatic g : (Lcom/soft/blued/customview/PageTabLayout;)F
      //   43: fstore #4
      //   45: aload_0
      //   46: getfield i : I
      //   49: istore #6
      //   51: aload_0
      //   52: getfield d : Landroid/widget/ImageView;
      //   55: astore #10
      //   57: iconst_1
      //   58: istore #7
      //   60: aload #10
      //   62: ifnull -> 82
      //   65: aload #10
      //   67: invokevirtual getVisibility : ()I
      //   70: ifne -> 82
      //   73: iconst_1
      //   74: istore #5
      //   76: fload #4
      //   78: fstore_3
      //   79: goto -> 128
      //   82: aload_0
      //   83: getfield c : Landroid/widget/TextView;
      //   86: astore #10
      //   88: fload #4
      //   90: fstore_3
      //   91: iload #6
      //   93: istore #5
      //   95: aload #10
      //   97: ifnull -> 128
      //   100: fload #4
      //   102: fstore_3
      //   103: iload #6
      //   105: istore #5
      //   107: aload #10
      //   109: invokevirtual getLineCount : ()I
      //   112: iconst_1
      //   113: if_icmple -> 128
      //   116: aload_0
      //   117: getfield a : Lcom/soft/blued/customview/PageTabLayout;
      //   120: invokestatic h : (Lcom/soft/blued/customview/PageTabLayout;)F
      //   123: fstore_3
      //   124: iload #6
      //   126: istore #5
      //   128: aload_0
      //   129: getfield c : Landroid/widget/TextView;
      //   132: invokevirtual getTextSize : ()F
      //   135: fstore #4
      //   137: aload_0
      //   138: getfield c : Landroid/widget/TextView;
      //   141: invokevirtual getLineCount : ()I
      //   144: istore #8
      //   146: aload_0
      //   147: getfield c : Landroid/widget/TextView;
      //   150: invokestatic getMaxLines : (Landroid/widget/TextView;)I
      //   153: istore #6
      //   155: fload_3
      //   156: fload #4
      //   158: fcmpl
      //   159: istore #9
      //   161: iload #9
      //   163: ifne -> 178
      //   166: iload #6
      //   168: iflt -> 289
      //   171: iload #5
      //   173: iload #6
      //   175: if_icmpeq -> 289
      //   178: iload #7
      //   180: istore #6
      //   182: aload_0
      //   183: getfield a : Lcom/soft/blued/customview/PageTabLayout;
      //   186: getfield h : I
      //   189: iconst_1
      //   190: if_icmpne -> 260
      //   193: iload #7
      //   195: istore #6
      //   197: iload #9
      //   199: ifle -> 260
      //   202: iload #7
      //   204: istore #6
      //   206: iload #8
      //   208: iconst_1
      //   209: if_icmpne -> 260
      //   212: aload_0
      //   213: getfield c : Landroid/widget/TextView;
      //   216: invokevirtual getLayout : ()Landroid/text/Layout;
      //   219: astore #10
      //   221: aload #10
      //   223: ifnull -> 257
      //   226: iload #7
      //   228: istore #6
      //   230: aload_0
      //   231: aload #10
      //   233: iconst_0
      //   234: fload_3
      //   235: invokespecial a : (Landroid/text/Layout;IF)F
      //   238: aload_0
      //   239: invokevirtual getMeasuredWidth : ()I
      //   242: aload_0
      //   243: invokevirtual getPaddingLeft : ()I
      //   246: isub
      //   247: aload_0
      //   248: invokevirtual getPaddingRight : ()I
      //   251: isub
      //   252: i2f
      //   253: fcmpl
      //   254: ifle -> 260
      //   257: iconst_0
      //   258: istore #6
      //   260: iload #6
      //   262: ifeq -> 289
      //   265: aload_0
      //   266: getfield c : Landroid/widget/TextView;
      //   269: iconst_0
      //   270: fload_3
      //   271: invokevirtual setTextSize : (IF)V
      //   274: aload_0
      //   275: getfield c : Landroid/widget/TextView;
      //   278: iload #5
      //   280: invokevirtual setMaxLines : (I)V
      //   283: aload_0
      //   284: iload_1
      //   285: iload_2
      //   286: invokespecial onMeasure : (II)V
      //   289: return
    }
    
    public boolean performClick() {
      boolean bool2 = super.performClick();
      boolean bool1 = bool2;
      if (this.b != null) {
        if (!bool2)
          playSoundEffect(0); 
        this.b.e();
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
      View view = this.f;
      if (view != null)
        view.setSelected(param1Boolean); 
    }
  }
  
  public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {
    private final ViewPager a;
    
    ViewPagerOnTabSelectedListener(ViewPager param1ViewPager) {
      this.a = param1ViewPager;
    }
    
    public void a(PageTabLayout.Tab param1Tab) {
      this.a.setCurrentItem(param1Tab.c());
    }
    
    public void b(PageTabLayout.Tab param1Tab) {}
    
    public void c(PageTabLayout.Tab param1Tab) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PageTabLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */