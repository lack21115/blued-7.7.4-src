package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
  public static final int SCROLL_STATE_DRAGGING = 1;
  
  public static final int SCROLL_STATE_IDLE = 0;
  
  public static final int SCROLL_STATE_SETTLING = 2;
  
  static final int[] a = new int[] { 16842931 };
  
  private static final ViewPositionComparator aj;
  
  private static final Comparator<ItemInfo> e = new Comparator<ItemInfo>() {
      public int compare(ViewPager.ItemInfo param1ItemInfo1, ViewPager.ItemInfo param1ItemInfo2) {
        return param1ItemInfo1.b - param1ItemInfo2.b;
      }
    };
  
  public static final Interpolator f = new Interpolator() {
      public float getInterpolation(float param1Float) {
        param1Float--;
        return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
      }
    };
  
  private int A = 1;
  
  private boolean B;
  
  private boolean C;
  
  private int D;
  
  private int E;
  
  private int F;
  
  private float G;
  
  private float H;
  
  private float I;
  
  private float J;
  
  private int K = -1;
  
  private VelocityTracker L;
  
  private int M;
  
  private int N;
  
  private int O;
  
  private int P;
  
  private boolean Q;
  
  private long R;
  
  private EdgeEffect S;
  
  private EdgeEffect T;
  
  private boolean U = true;
  
  private boolean V = false;
  
  private boolean W;
  
  private int aa;
  
  private List<OnPageChangeListener> ab;
  
  private OnPageChangeListener ac;
  
  private OnPageChangeListener ad;
  
  private List<OnAdapterChangeListener> ae;
  
  private PageTransformer af;
  
  private int ag;
  
  private int ah;
  
  private ArrayList<View> ai;
  
  private final Runnable ak = new Runnable(this) {
      public void run() {
        this.a.setScrollState(0);
        this.a.c();
      }
    };
  
  private int al = 0;
  
  PagerAdapter b;
  
  int c;
  
  private int d;
  
  private final ArrayList<ItemInfo> g = new ArrayList<ItemInfo>();
  
  private final ItemInfo h = new ItemInfo();
  
  private final Rect i = new Rect();
  
  private int j = -1;
  
  private Parcelable k = null;
  
  private ClassLoader l = null;
  
  public Scroller m;
  
  private boolean n;
  
  private PagerObserver o;
  
  private int p;
  
  private Drawable q;
  
  private int r;
  
  private int s;
  
  private float t = -3.4028235E38F;
  
  private float u = Float.MAX_VALUE;
  
  private int v;
  
  private int w;
  
  private boolean x;
  
  private boolean y;
  
  private boolean z;
  
  static {
    aj = new ViewPositionComparator();
  }
  
  public ViewPager(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3) {
    if (Math.abs(paramInt3) > this.O && Math.abs(paramInt2) > this.M) {
      if (paramInt2 <= 0)
        paramInt1++; 
    } else {
      float f;
      if (paramInt1 >= this.c) {
        f = 0.4F;
      } else {
        f = 0.6F;
      } 
      paramInt1 += (int)(paramFloat + f);
    } 
    paramInt2 = paramInt1;
    if (this.g.size() > 0) {
      ItemInfo itemInfo1 = this.g.get(0);
      ArrayList<ItemInfo> arrayList = this.g;
      ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
      paramInt2 = Math.max(itemInfo1.b, Math.min(paramInt1, itemInfo2.b));
    } 
    return paramInt2;
  }
  
  private Rect a(Rect paramRect, View paramView) {
    Rect rect = paramRect;
    if (paramRect == null)
      rect = new Rect(); 
    if (paramView == null) {
      rect.set(0, 0, 0, 0);
      return rect;
    } 
    rect.left = paramView.getLeft();
    rect.right = paramView.getRight();
    rect.top = paramView.getTop();
    rect.bottom = paramView.getBottom();
    ViewParent viewParent = paramView.getParent();
    while (viewParent instanceof ViewGroup && viewParent != this) {
      ViewGroup viewGroup = (ViewGroup)viewParent;
      rect.left += viewGroup.getLeft();
      rect.right += viewGroup.getRight();
      rect.top += viewGroup.getTop();
      rect.bottom += viewGroup.getBottom();
      ViewParent viewParent1 = viewGroup.getParent();
    } 
    return rect;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    float f;
    if (paramInt2 > 0 && !this.g.isEmpty()) {
      if (!this.m.isFinished()) {
        this.m.setFinalX(getCurrentItem() * getClientWidth());
        return;
      } 
      int i = getPaddingLeft();
      int j = getPaddingRight();
      int k = getPaddingLeft();
      int m = getPaddingRight();
      scrollTo((int)(getScrollX() / (paramInt2 - k - m + paramInt4) * (paramInt1 - i - j + paramInt3)), getScrollY());
      return;
    } 
    ItemInfo itemInfo = b(this.c);
    if (itemInfo != null) {
      f = Math.min(itemInfo.e, this.u);
    } else {
      f = 0.0F;
    } 
    paramInt1 = (int)(f * (paramInt1 - getPaddingLeft() - getPaddingRight()));
    if (paramInt1 != getScrollX()) {
      a(false);
      scrollTo(paramInt1, getScrollY());
    } 
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2) {
    boolean bool;
    ItemInfo itemInfo = b(paramInt1);
    if (itemInfo != null) {
      bool = (int)(getClientWidth() * Math.max(this.t, Math.min(itemInfo.e, this.u)));
    } else {
      bool = false;
    } 
    if (paramBoolean1) {
      a(bool, 0, paramInt2);
      if (paramBoolean2) {
        d(paramInt1);
        return;
      } 
    } else {
      if (paramBoolean2)
        d(paramInt1); 
      a(false);
      scrollTo(bool, 0);
      c(bool);
    } 
  }
  
  private void a(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.K) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.G = paramMotionEvent.getX(i);
      this.K = paramMotionEvent.getPointerId(i);
      VelocityTracker velocityTracker = this.L;
      if (velocityTracker != null)
        velocityTracker.clear(); 
    } 
  }
  
  private void a(ItemInfo paramItemInfo1, int paramInt, ItemInfo paramItemInfo2) {
    float f2;
    int m = this.b.getCount();
    int i = getClientWidth();
    if (i > 0) {
      f2 = this.p / i;
    } else {
      f2 = 0.0F;
    } 
    if (paramItemInfo2 != null) {
      i = paramItemInfo2.b;
      if (i < paramItemInfo1.b) {
        f1 = paramItemInfo2.e + paramItemInfo2.d + f2;
        i++;
        int n = 0;
        while (i <= paramItemInfo1.b && n < this.g.size()) {
          float f;
          int i1;
          paramItemInfo2 = this.g.get(n);
          while (true) {
            i1 = i;
            f = f1;
            if (i > paramItemInfo2.b) {
              i1 = i;
              f = f1;
              if (n < this.g.size() - 1) {
                paramItemInfo2 = this.g.get(++n);
                continue;
              } 
            } 
            break;
          } 
          while (i1 < paramItemInfo2.b) {
            f += this.b.getPageWidth(i1) + f2;
            i1++;
          } 
          paramItemInfo2.e = f;
          f1 = f + paramItemInfo2.d + f2;
          i = i1 + 1;
        } 
      } else if (i > paramItemInfo1.b) {
        int n = this.g.size() - 1;
        f1 = paramItemInfo2.e;
        while (--i >= paramItemInfo1.b && n >= 0) {
          float f;
          int i1;
          paramItemInfo2 = this.g.get(n);
          while (true) {
            i1 = i;
            f = f1;
            if (i < paramItemInfo2.b) {
              i1 = i;
              f = f1;
              if (n > 0) {
                paramItemInfo2 = this.g.get(--n);
                continue;
              } 
            } 
            break;
          } 
          while (i1 > paramItemInfo2.b) {
            f -= this.b.getPageWidth(i1) + f2;
            i1--;
          } 
          f1 = f - paramItemInfo2.d + f2;
          paramItemInfo2.e = f1;
          i = i1 - 1;
        } 
      } 
    } 
    int k = this.g.size();
    float f3 = paramItemInfo1.e;
    i = paramItemInfo1.b - 1;
    if (paramItemInfo1.b == 0) {
      f1 = paramItemInfo1.e;
    } else {
      f1 = -3.4028235E38F;
    } 
    this.t = f1;
    int j = paramItemInfo1.b;
    if (j == --m) {
      f1 = paramItemInfo1.e + paramItemInfo1.d - 1.0F;
    } else {
      f1 = Float.MAX_VALUE;
    } 
    this.u = f1;
    j = paramInt - 1;
    float f1 = f3;
    while (j >= 0) {
      paramItemInfo2 = this.g.get(j);
      while (i > paramItemInfo2.b) {
        f1 -= this.b.getPageWidth(i) + f2;
        i--;
      } 
      f1 -= paramItemInfo2.d + f2;
      paramItemInfo2.e = f1;
      if (paramItemInfo2.b == 0)
        this.t = f1; 
      j--;
      i--;
    } 
    f1 = paramItemInfo1.e + paramItemInfo1.d + f2;
    j = paramItemInfo1.b + 1;
    i = paramInt + 1;
    for (paramInt = j; i < k; paramInt++) {
      paramItemInfo1 = this.g.get(i);
      while (paramInt < paramItemInfo1.b) {
        f1 += this.b.getPageWidth(paramInt) + f2;
        paramInt++;
      } 
      if (paramItemInfo1.b == m)
        this.u = paramItemInfo1.d + f1 - 1.0F; 
      paramItemInfo1.e = f1;
      f1 += paramItemInfo1.d + f2;
      i++;
    } 
    this.V = false;
  }
  
  private void a(boolean paramBoolean) {
    if (this.al == 2) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      setScrollingCacheEnabled(false);
      if ((this.m.isFinished() ^ true) != 0) {
        this.m.abortAnimation();
        int k = getScrollX();
        int m = getScrollY();
        int n = this.m.getCurrX();
        int i1 = this.m.getCurrY();
        if (k != n || m != i1) {
          scrollTo(n, i1);
          if (n != k)
            c(n); 
        } 
      } 
    } 
    this.z = false;
    byte b = 0;
    int j = i;
    for (int i = b; i < this.g.size(); i++) {
      ItemInfo itemInfo = this.g.get(i);
      if (itemInfo.c) {
        itemInfo.c = false;
        j = 1;
      } 
    } 
    if (j != 0) {
      if (paramBoolean) {
        ViewCompat.postOnAnimation((View)this, this.ak);
        return;
      } 
      this.ak.run();
    } 
  }
  
  private boolean a(float paramFloat1, float paramFloat2) {
    return ((paramFloat1 < this.E && paramFloat2 > 0.0F) || (paramFloat1 > (getWidth() - this.E) && paramFloat2 < 0.0F));
  }
  
  private void b(int paramInt1, float paramFloat, int paramInt2) {
    OnPageChangeListener onPageChangeListener2 = this.ac;
    if (onPageChangeListener2 != null)
      onPageChangeListener2.onPageScrolled(paramInt1, paramFloat, paramInt2); 
    List<OnPageChangeListener> list = this.ab;
    if (list != null) {
      int i = 0;
      int j = list.size();
      while (i < j) {
        OnPageChangeListener onPageChangeListener = this.ab.get(i);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2); 
        i++;
      } 
    } 
    OnPageChangeListener onPageChangeListener1 = this.ad;
    if (onPageChangeListener1 != null)
      onPageChangeListener1.onPageScrolled(paramInt1, paramFloat, paramInt2); 
  }
  
  private void b(boolean paramBoolean) {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      boolean bool;
      if (paramBoolean) {
        bool = this.ag;
      } else {
        bool = false;
      } 
      getChildAt(i).setLayerType(bool, null);
    } 
  }
  
  private boolean b(float paramFloat) {
    boolean bool1;
    float f1 = this.G;
    this.G = paramFloat;
    float f2 = getScrollX() + f1 - paramFloat;
    float f3 = getClientWidth();
    paramFloat = this.t * f3;
    f1 = this.u * f3;
    ArrayList<ItemInfo> arrayList1 = this.g;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    ItemInfo itemInfo1 = arrayList1.get(0);
    ArrayList<ItemInfo> arrayList2 = this.g;
    ItemInfo itemInfo2 = arrayList2.get(arrayList2.size() - 1);
    if (itemInfo1.b != 0) {
      paramFloat = itemInfo1.e * f3;
      i = 0;
    } else {
      i = 1;
    } 
    if (itemInfo2.b != this.b.getCount() - 1) {
      f1 = itemInfo2.e * f3;
      bool1 = false;
    } else {
      bool1 = true;
    } 
    if (f2 < paramFloat) {
      if (i) {
        this.S.onPull(Math.abs(paramFloat - f2) / f3);
        bool2 = true;
      } 
    } else {
      bool2 = bool4;
      paramFloat = f2;
      if (f2 > f1) {
        bool2 = bool3;
        if (bool1) {
          this.T.onPull(Math.abs(f2 - f1) / f3);
          bool2 = true;
        } 
        paramFloat = f1;
      } 
    } 
    f1 = this.G;
    int i = (int)paramFloat;
    this.G = f1 + paramFloat - i;
    scrollTo(i, getScrollY());
    c(i);
    return bool2;
  }
  
  private void c(boolean paramBoolean) {
    ViewParent viewParent = getParent();
    if (viewParent != null)
      viewParent.requestDisallowInterceptTouchEvent(paramBoolean); 
  }
  
  private boolean c(int paramInt) {
    if (this.g.size() == 0) {
      if (this.U)
        return false; 
      this.W = false;
      a(0, 0.0F, 0);
      if (this.W)
        return false; 
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    } 
    ItemInfo itemInfo = i();
    int j = getClientWidth();
    int k = this.p;
    float f2 = k;
    float f1 = j;
    f2 /= f1;
    int i = itemInfo.b;
    f1 = (paramInt / f1 - itemInfo.e) / (itemInfo.d + f2);
    paramInt = (int)((j + k) * f1);
    this.W = false;
    a(i, f1, paramInt);
    if (this.W)
      return true; 
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private static boolean c(View paramView) {
    return (paramView.getClass().getAnnotation(DecorView.class) != null);
  }
  
  private void d(int paramInt) {
    OnPageChangeListener onPageChangeListener2 = this.ac;
    if (onPageChangeListener2 != null)
      onPageChangeListener2.onPageSelected(paramInt); 
    List<OnPageChangeListener> list = this.ab;
    if (list != null) {
      int i = 0;
      int j = list.size();
      while (i < j) {
        OnPageChangeListener onPageChangeListener = this.ab.get(i);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageSelected(paramInt); 
        i++;
      } 
    } 
    OnPageChangeListener onPageChangeListener1 = this.ad;
    if (onPageChangeListener1 != null)
      onPageChangeListener1.onPageSelected(paramInt); 
  }
  
  private void e(int paramInt) {
    OnPageChangeListener onPageChangeListener2 = this.ac;
    if (onPageChangeListener2 != null)
      onPageChangeListener2.onPageScrollStateChanged(paramInt); 
    List<OnPageChangeListener> list = this.ab;
    if (list != null) {
      int i = 0;
      int j = list.size();
      while (i < j) {
        OnPageChangeListener onPageChangeListener = this.ab.get(i);
        if (onPageChangeListener != null)
          onPageChangeListener.onPageScrollStateChanged(paramInt); 
        i++;
      } 
    } 
    OnPageChangeListener onPageChangeListener1 = this.ad;
    if (onPageChangeListener1 != null)
      onPageChangeListener1.onPageScrollStateChanged(paramInt); 
  }
  
  private void f() {
    for (int i = 0; i < getChildCount(); i = j + 1) {
      int j = i;
      if (!((LayoutParams)getChildAt(i).getLayoutParams()).isDecor) {
        removeViewAt(i);
        j = i - 1;
      } 
    } 
  }
  
  private void g() {
    if (this.ah != 0) {
      ArrayList<View> arrayList = this.ai;
      if (arrayList == null) {
        this.ai = new ArrayList<View>();
      } else {
        arrayList.clear();
      } 
      int j = getChildCount();
      for (int i = 0; i < j; i++) {
        View view = getChildAt(i);
        this.ai.add(view);
      } 
      Collections.sort(this.ai, aj);
    } 
  }
  
  private int getClientWidth() {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private boolean h() {
    this.K = -1;
    j();
    this.S.onRelease();
    this.T.onRelease();
    return (this.S.isFinished() || this.T.isFinished());
  }
  
  private ItemInfo i() {
    float f1;
    float f2;
    int i = getClientWidth();
    if (i > 0) {
      f1 = getScrollX() / i;
    } else {
      f1 = 0.0F;
    } 
    if (i > 0) {
      f2 = this.p / i;
    } else {
      f2 = 0.0F;
    } 
    ItemInfo itemInfo = null;
    i = 0;
    boolean bool = true;
    int j = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i < this.g.size()) {
      ItemInfo itemInfo2 = this.g.get(i);
      int k = i;
      ItemInfo itemInfo1 = itemInfo2;
      if (!bool) {
        int m = itemInfo2.b;
        j++;
        k = i;
        itemInfo1 = itemInfo2;
        if (m != j) {
          itemInfo1 = this.h;
          itemInfo1.e = f3 + f4 + f2;
          itemInfo1.b = j;
          itemInfo1.d = this.b.getPageWidth(itemInfo1.b);
          k = i - 1;
        } 
      } 
      f3 = itemInfo1.e;
      f4 = itemInfo1.d;
      if (bool || f1 >= f3) {
        if (f1 >= f4 + f3 + f2) {
          if (k == this.g.size() - 1)
            return itemInfo1; 
          j = itemInfo1.b;
          f4 = itemInfo1.d;
          i = k + 1;
          bool = false;
          itemInfo = itemInfo1;
          continue;
        } 
        return itemInfo1;
      } 
      return itemInfo;
    } 
    return itemInfo;
  }
  
  private void j() {
    this.B = false;
    this.C = false;
    VelocityTracker velocityTracker = this.L;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.L = null;
    } 
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean) {
    if (this.y != paramBoolean)
      this.y = paramBoolean; 
  }
  
  float a(float paramFloat) {
    return (float)Math.sin(((paramFloat - 0.5F) * 0.47123894F));
  }
  
  ItemInfo a(int paramInt1, int paramInt2) {
    ItemInfo itemInfo = new ItemInfo();
    itemInfo.b = paramInt1;
    itemInfo.a = this.b.instantiateItem(this, paramInt1);
    itemInfo.d = this.b.getPageWidth(paramInt1);
    if (paramInt2 < 0 || paramInt2 >= this.g.size()) {
      this.g.add(itemInfo);
      return itemInfo;
    } 
    this.g.add(paramInt2, itemInfo);
    return itemInfo;
  }
  
  ItemInfo a(View paramView) {
    for (int i = 0; i < this.g.size(); i++) {
      ItemInfo itemInfo = this.g.get(i);
      if (this.b.isViewFromObject(paramView, itemInfo.a))
        return itemInfo; 
    } 
    return null;
  }
  
  OnPageChangeListener a(OnPageChangeListener paramOnPageChangeListener) {
    OnPageChangeListener onPageChangeListener = this.ad;
    this.ad = paramOnPageChangeListener;
    return onPageChangeListener;
  }
  
  void a() {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context context = getContext();
    this.m = new Scroller(context, f);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
    float f = (context.getResources().getDisplayMetrics()).density;
    this.F = viewConfiguration.getScaledPagingTouchSlop();
    this.M = (int)(400.0F * f);
    this.N = viewConfiguration.getScaledMaximumFlingVelocity();
    this.S = new EdgeEffect(context);
    this.T = new EdgeEffect(context);
    this.O = (int)(25.0F * f);
    this.P = (int)(2.0F * f);
    this.D = (int)(f * 16.0F);
    ViewCompat.setAccessibilityDelegate((View)this, new MyAccessibilityDelegate(this));
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener(this) {
          private final Rect b = new Rect();
          
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            WindowInsetsCompat windowInsetsCompat = ViewCompat.onApplyWindowInsets(param1View, param1WindowInsetsCompat);
            if (windowInsetsCompat.isConsumed())
              return windowInsetsCompat; 
            Rect rect = this.b;
            rect.left = windowInsetsCompat.getSystemWindowInsetLeft();
            rect.top = windowInsetsCompat.getSystemWindowInsetTop();
            rect.right = windowInsetsCompat.getSystemWindowInsetRight();
            rect.bottom = windowInsetsCompat.getSystemWindowInsetBottom();
            int i = 0;
            int j = this.a.getChildCount();
            while (i < j) {
              WindowInsetsCompat windowInsetsCompat1 = ViewCompat.dispatchApplyWindowInsets(this.a.getChildAt(i), windowInsetsCompat);
              rect.left = Math.min(windowInsetsCompat1.getSystemWindowInsetLeft(), rect.left);
              rect.top = Math.min(windowInsetsCompat1.getSystemWindowInsetTop(), rect.top);
              rect.right = Math.min(windowInsetsCompat1.getSystemWindowInsetRight(), rect.right);
              rect.bottom = Math.min(windowInsetsCompat1.getSystemWindowInsetBottom(), rect.bottom);
              i++;
            } 
            return windowInsetsCompat.replaceSystemWindowInsets(rect.left, rect.top, rect.right, rect.bottom);
          }
        });
  }
  
  void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : I
    //   4: istore #5
    //   6: iload #5
    //   8: iload_1
    //   9: if_icmpeq -> 28
    //   12: aload_0
    //   13: iload #5
    //   15: invokevirtual b : (I)Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   18: astore #14
    //   20: aload_0
    //   21: iload_1
    //   22: putfield c : I
    //   25: goto -> 31
    //   28: aconst_null
    //   29: astore #14
    //   31: aload_0
    //   32: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   35: ifnonnull -> 43
    //   38: aload_0
    //   39: invokespecial g : ()V
    //   42: return
    //   43: aload_0
    //   44: getfield z : Z
    //   47: ifeq -> 55
    //   50: aload_0
    //   51: invokespecial g : ()V
    //   54: return
    //   55: aload_0
    //   56: invokevirtual getWindowToken : ()Landroid/os/IBinder;
    //   59: ifnonnull -> 63
    //   62: return
    //   63: aload_0
    //   64: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   67: aload_0
    //   68: invokevirtual startUpdate : (Landroid/view/ViewGroup;)V
    //   71: aload_0
    //   72: getfield A : I
    //   75: istore_1
    //   76: iconst_0
    //   77: aload_0
    //   78: getfield c : I
    //   81: iload_1
    //   82: isub
    //   83: invokestatic max : (II)I
    //   86: istore #11
    //   88: aload_0
    //   89: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   92: invokevirtual getCount : ()I
    //   95: istore #9
    //   97: iload #9
    //   99: iconst_1
    //   100: isub
    //   101: aload_0
    //   102: getfield c : I
    //   105: iload_1
    //   106: iadd
    //   107: invokestatic min : (II)I
    //   110: istore #10
    //   112: iload #9
    //   114: aload_0
    //   115: getfield d : I
    //   118: if_icmpne -> 1210
    //   121: iconst_0
    //   122: istore_1
    //   123: iload_1
    //   124: aload_0
    //   125: getfield g : Ljava/util/ArrayList;
    //   128: invokevirtual size : ()I
    //   131: if_icmpge -> 181
    //   134: aload_0
    //   135: getfield g : Ljava/util/ArrayList;
    //   138: iload_1
    //   139: invokevirtual get : (I)Ljava/lang/Object;
    //   142: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   145: astore #13
    //   147: aload #13
    //   149: getfield b : I
    //   152: aload_0
    //   153: getfield c : I
    //   156: if_icmplt -> 174
    //   159: aload #13
    //   161: getfield b : I
    //   164: aload_0
    //   165: getfield c : I
    //   168: if_icmpne -> 181
    //   171: goto -> 184
    //   174: iload_1
    //   175: iconst_1
    //   176: iadd
    //   177: istore_1
    //   178: goto -> 123
    //   181: aconst_null
    //   182: astore #13
    //   184: aload #13
    //   186: astore #15
    //   188: aload #13
    //   190: ifnonnull -> 213
    //   193: aload #13
    //   195: astore #15
    //   197: iload #9
    //   199: ifle -> 213
    //   202: aload_0
    //   203: aload_0
    //   204: getfield c : I
    //   207: iload_1
    //   208: invokevirtual a : (II)Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   211: astore #15
    //   213: aload #15
    //   215: ifnull -> 994
    //   218: iload_1
    //   219: iconst_1
    //   220: isub
    //   221: istore #5
    //   223: iload #5
    //   225: iflt -> 245
    //   228: aload_0
    //   229: getfield g : Ljava/util/ArrayList;
    //   232: iload #5
    //   234: invokevirtual get : (I)Ljava/lang/Object;
    //   237: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   240: astore #13
    //   242: goto -> 248
    //   245: aconst_null
    //   246: astore #13
    //   248: aload_0
    //   249: invokespecial getClientWidth : ()I
    //   252: istore #12
    //   254: iload #12
    //   256: ifgt -> 265
    //   259: fconst_0
    //   260: fstore #4
    //   262: goto -> 284
    //   265: fconst_2
    //   266: aload #15
    //   268: getfield d : F
    //   271: fsub
    //   272: aload_0
    //   273: invokevirtual getPaddingLeft : ()I
    //   276: i2f
    //   277: iload #12
    //   279: i2f
    //   280: fdiv
    //   281: fadd
    //   282: fstore #4
    //   284: aload_0
    //   285: getfield c : I
    //   288: iconst_1
    //   289: isub
    //   290: istore #8
    //   292: fconst_0
    //   293: fstore_3
    //   294: iload #8
    //   296: iflt -> 591
    //   299: fload_3
    //   300: fload #4
    //   302: fcmpl
    //   303: iflt -> 433
    //   306: iload #8
    //   308: iload #11
    //   310: if_icmpge -> 433
    //   313: aload #13
    //   315: ifnonnull -> 321
    //   318: goto -> 591
    //   321: fload_3
    //   322: fstore_2
    //   323: iload_1
    //   324: istore #7
    //   326: aload #13
    //   328: astore #16
    //   330: iload #5
    //   332: istore #6
    //   334: iload #8
    //   336: aload #13
    //   338: getfield b : I
    //   341: if_icmpne -> 569
    //   344: fload_3
    //   345: fstore_2
    //   346: iload_1
    //   347: istore #7
    //   349: aload #13
    //   351: astore #16
    //   353: iload #5
    //   355: istore #6
    //   357: aload #13
    //   359: getfield c : Z
    //   362: ifne -> 569
    //   365: aload_0
    //   366: getfield g : Ljava/util/ArrayList;
    //   369: iload #5
    //   371: invokevirtual remove : (I)Ljava/lang/Object;
    //   374: pop
    //   375: aload_0
    //   376: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   379: aload_0
    //   380: iload #8
    //   382: aload #13
    //   384: getfield a : Ljava/lang/Object;
    //   387: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   390: iload #5
    //   392: iconst_1
    //   393: isub
    //   394: istore #5
    //   396: iload_1
    //   397: iconst_1
    //   398: isub
    //   399: istore_1
    //   400: fload_3
    //   401: fstore_2
    //   402: iload_1
    //   403: istore #6
    //   405: iload #5
    //   407: istore #7
    //   409: iload #5
    //   411: iflt -> 548
    //   414: aload_0
    //   415: getfield g : Ljava/util/ArrayList;
    //   418: iload #5
    //   420: invokevirtual get : (I)Ljava/lang/Object;
    //   423: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   426: astore #13
    //   428: fload_3
    //   429: fstore_2
    //   430: goto -> 558
    //   433: aload #13
    //   435: ifnull -> 495
    //   438: iload #8
    //   440: aload #13
    //   442: getfield b : I
    //   445: if_icmpne -> 495
    //   448: fload_3
    //   449: aload #13
    //   451: getfield d : F
    //   454: fadd
    //   455: fstore_3
    //   456: iload #5
    //   458: iconst_1
    //   459: isub
    //   460: istore #5
    //   462: fload_3
    //   463: fstore_2
    //   464: iload_1
    //   465: istore #6
    //   467: iload #5
    //   469: istore #7
    //   471: iload #5
    //   473: iflt -> 548
    //   476: aload_0
    //   477: getfield g : Ljava/util/ArrayList;
    //   480: iload #5
    //   482: invokevirtual get : (I)Ljava/lang/Object;
    //   485: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   488: astore #13
    //   490: fload_3
    //   491: fstore_2
    //   492: goto -> 558
    //   495: fload_3
    //   496: aload_0
    //   497: iload #8
    //   499: iload #5
    //   501: iconst_1
    //   502: iadd
    //   503: invokevirtual a : (II)Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   506: getfield d : F
    //   509: fadd
    //   510: fstore_3
    //   511: iload_1
    //   512: iconst_1
    //   513: iadd
    //   514: istore_1
    //   515: fload_3
    //   516: fstore_2
    //   517: iload_1
    //   518: istore #6
    //   520: iload #5
    //   522: istore #7
    //   524: iload #5
    //   526: iflt -> 548
    //   529: aload_0
    //   530: getfield g : Ljava/util/ArrayList;
    //   533: iload #5
    //   535: invokevirtual get : (I)Ljava/lang/Object;
    //   538: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   541: astore #13
    //   543: fload_3
    //   544: fstore_2
    //   545: goto -> 558
    //   548: aconst_null
    //   549: astore #13
    //   551: iload #7
    //   553: istore #5
    //   555: iload #6
    //   557: istore_1
    //   558: iload #5
    //   560: istore #6
    //   562: aload #13
    //   564: astore #16
    //   566: iload_1
    //   567: istore #7
    //   569: iload #8
    //   571: iconst_1
    //   572: isub
    //   573: istore #8
    //   575: fload_2
    //   576: fstore_3
    //   577: iload #7
    //   579: istore_1
    //   580: aload #16
    //   582: astore #13
    //   584: iload #6
    //   586: istore #5
    //   588: goto -> 294
    //   591: aload #15
    //   593: getfield d : F
    //   596: fstore_3
    //   597: iload_1
    //   598: iconst_1
    //   599: iadd
    //   600: istore #6
    //   602: fload_3
    //   603: fconst_2
    //   604: fcmpg
    //   605: ifge -> 968
    //   608: iload #6
    //   610: aload_0
    //   611: getfield g : Ljava/util/ArrayList;
    //   614: invokevirtual size : ()I
    //   617: if_icmpge -> 637
    //   620: aload_0
    //   621: getfield g : Ljava/util/ArrayList;
    //   624: iload #6
    //   626: invokevirtual get : (I)Ljava/lang/Object;
    //   629: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   632: astore #13
    //   634: goto -> 640
    //   637: aconst_null
    //   638: astore #13
    //   640: iload #12
    //   642: ifgt -> 651
    //   645: fconst_0
    //   646: fstore #4
    //   648: goto -> 664
    //   651: aload_0
    //   652: invokevirtual getPaddingRight : ()I
    //   655: i2f
    //   656: iload #12
    //   658: i2f
    //   659: fdiv
    //   660: fconst_2
    //   661: fadd
    //   662: fstore #4
    //   664: aload_0
    //   665: getfield c : I
    //   668: istore #5
    //   670: aload #13
    //   672: astore #16
    //   674: iload #5
    //   676: iconst_1
    //   677: iadd
    //   678: istore #7
    //   680: iload #7
    //   682: iload #9
    //   684: if_icmpge -> 968
    //   687: fload_3
    //   688: fload #4
    //   690: fcmpl
    //   691: iflt -> 819
    //   694: iload #7
    //   696: iload #10
    //   698: if_icmple -> 819
    //   701: aload #16
    //   703: ifnonnull -> 709
    //   706: goto -> 968
    //   709: fload_3
    //   710: fstore_2
    //   711: iload #6
    //   713: istore #5
    //   715: aload #16
    //   717: astore #13
    //   719: iload #7
    //   721: aload #16
    //   723: getfield b : I
    //   726: if_icmpne -> 951
    //   729: fload_3
    //   730: fstore_2
    //   731: iload #6
    //   733: istore #5
    //   735: aload #16
    //   737: astore #13
    //   739: aload #16
    //   741: getfield c : Z
    //   744: ifne -> 951
    //   747: aload_0
    //   748: getfield g : Ljava/util/ArrayList;
    //   751: iload #6
    //   753: invokevirtual remove : (I)Ljava/lang/Object;
    //   756: pop
    //   757: aload_0
    //   758: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   761: aload_0
    //   762: iload #7
    //   764: aload #16
    //   766: getfield a : Ljava/lang/Object;
    //   769: invokevirtual destroyItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   772: fload_3
    //   773: fstore_2
    //   774: iload #6
    //   776: istore #5
    //   778: iload #6
    //   780: aload_0
    //   781: getfield g : Ljava/util/ArrayList;
    //   784: invokevirtual size : ()I
    //   787: if_icmpge -> 813
    //   790: aload_0
    //   791: getfield g : Ljava/util/ArrayList;
    //   794: iload #6
    //   796: invokevirtual get : (I)Ljava/lang/Object;
    //   799: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   802: astore #13
    //   804: fload_3
    //   805: fstore_2
    //   806: iload #6
    //   808: istore #5
    //   810: goto -> 951
    //   813: aconst_null
    //   814: astore #13
    //   816: goto -> 951
    //   819: aload #16
    //   821: ifnull -> 889
    //   824: iload #7
    //   826: aload #16
    //   828: getfield b : I
    //   831: if_icmpne -> 889
    //   834: fload_3
    //   835: aload #16
    //   837: getfield d : F
    //   840: fadd
    //   841: fstore_3
    //   842: iload #6
    //   844: iconst_1
    //   845: iadd
    //   846: istore #6
    //   848: fload_3
    //   849: fstore_2
    //   850: iload #6
    //   852: istore #5
    //   854: iload #6
    //   856: aload_0
    //   857: getfield g : Ljava/util/ArrayList;
    //   860: invokevirtual size : ()I
    //   863: if_icmpge -> 813
    //   866: aload_0
    //   867: getfield g : Ljava/util/ArrayList;
    //   870: iload #6
    //   872: invokevirtual get : (I)Ljava/lang/Object;
    //   875: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   878: astore #13
    //   880: fload_3
    //   881: fstore_2
    //   882: iload #6
    //   884: istore #5
    //   886: goto -> 951
    //   889: aload_0
    //   890: iload #7
    //   892: iload #6
    //   894: invokevirtual a : (II)Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   897: astore #13
    //   899: iload #6
    //   901: iconst_1
    //   902: iadd
    //   903: istore #6
    //   905: fload_3
    //   906: aload #13
    //   908: getfield d : F
    //   911: fadd
    //   912: fstore_3
    //   913: fload_3
    //   914: fstore_2
    //   915: iload #6
    //   917: istore #5
    //   919: iload #6
    //   921: aload_0
    //   922: getfield g : Ljava/util/ArrayList;
    //   925: invokevirtual size : ()I
    //   928: if_icmpge -> 813
    //   931: aload_0
    //   932: getfield g : Ljava/util/ArrayList;
    //   935: iload #6
    //   937: invokevirtual get : (I)Ljava/lang/Object;
    //   940: checkcast androidx/viewpager/widget/ViewPager$ItemInfo
    //   943: astore #13
    //   945: iload #6
    //   947: istore #5
    //   949: fload_3
    //   950: fstore_2
    //   951: fload_2
    //   952: fstore_3
    //   953: iload #5
    //   955: istore #6
    //   957: aload #13
    //   959: astore #16
    //   961: iload #7
    //   963: istore #5
    //   965: goto -> 674
    //   968: aload_0
    //   969: aload #15
    //   971: iload_1
    //   972: aload #14
    //   974: invokespecial a : (Landroidx/viewpager/widget/ViewPager$ItemInfo;ILandroidx/viewpager/widget/ViewPager$ItemInfo;)V
    //   977: aload_0
    //   978: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   981: aload_0
    //   982: aload_0
    //   983: getfield c : I
    //   986: aload #15
    //   988: getfield a : Ljava/lang/Object;
    //   991: invokevirtual setPrimaryItem : (Landroid/view/ViewGroup;ILjava/lang/Object;)V
    //   994: aload_0
    //   995: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   998: aload_0
    //   999: invokevirtual finishUpdate : (Landroid/view/ViewGroup;)V
    //   1002: aload_0
    //   1003: invokevirtual getChildCount : ()I
    //   1006: istore #5
    //   1008: iconst_0
    //   1009: istore_1
    //   1010: iload_1
    //   1011: iload #5
    //   1013: if_icmpge -> 1097
    //   1016: aload_0
    //   1017: iload_1
    //   1018: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1021: astore #14
    //   1023: aload #14
    //   1025: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1028: checkcast androidx/viewpager/widget/ViewPager$LayoutParams
    //   1031: astore #13
    //   1033: aload #13
    //   1035: iload_1
    //   1036: putfield d : I
    //   1039: aload #13
    //   1041: getfield isDecor : Z
    //   1044: ifne -> 1090
    //   1047: aload #13
    //   1049: getfield a : F
    //   1052: fconst_0
    //   1053: fcmpl
    //   1054: ifne -> 1090
    //   1057: aload_0
    //   1058: aload #14
    //   1060: invokevirtual a : (Landroid/view/View;)Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   1063: astore #14
    //   1065: aload #14
    //   1067: ifnull -> 1090
    //   1070: aload #13
    //   1072: aload #14
    //   1074: getfield d : F
    //   1077: putfield a : F
    //   1080: aload #13
    //   1082: aload #14
    //   1084: getfield b : I
    //   1087: putfield c : I
    //   1090: iload_1
    //   1091: iconst_1
    //   1092: iadd
    //   1093: istore_1
    //   1094: goto -> 1010
    //   1097: aload_0
    //   1098: invokespecial g : ()V
    //   1101: aload_0
    //   1102: invokevirtual hasFocus : ()Z
    //   1105: ifeq -> 1209
    //   1108: aload_0
    //   1109: invokevirtual findFocus : ()Landroid/view/View;
    //   1112: astore #13
    //   1114: aload #13
    //   1116: ifnull -> 1130
    //   1119: aload_0
    //   1120: aload #13
    //   1122: invokevirtual b : (Landroid/view/View;)Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   1125: astore #13
    //   1127: goto -> 1133
    //   1130: aconst_null
    //   1131: astore #13
    //   1133: aload #13
    //   1135: ifnull -> 1150
    //   1138: aload #13
    //   1140: getfield b : I
    //   1143: aload_0
    //   1144: getfield c : I
    //   1147: if_icmpeq -> 1209
    //   1150: iconst_0
    //   1151: istore_1
    //   1152: iload_1
    //   1153: aload_0
    //   1154: invokevirtual getChildCount : ()I
    //   1157: if_icmpge -> 1209
    //   1160: aload_0
    //   1161: iload_1
    //   1162: invokevirtual getChildAt : (I)Landroid/view/View;
    //   1165: astore #13
    //   1167: aload_0
    //   1168: aload #13
    //   1170: invokevirtual a : (Landroid/view/View;)Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   1173: astore #14
    //   1175: aload #14
    //   1177: ifnull -> 1202
    //   1180: aload #14
    //   1182: getfield b : I
    //   1185: aload_0
    //   1186: getfield c : I
    //   1189: if_icmpne -> 1202
    //   1192: aload #13
    //   1194: iconst_2
    //   1195: invokevirtual requestFocus : (I)Z
    //   1198: ifeq -> 1202
    //   1201: return
    //   1202: iload_1
    //   1203: iconst_1
    //   1204: iadd
    //   1205: istore_1
    //   1206: goto -> 1152
    //   1209: return
    //   1210: aload_0
    //   1211: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   1214: aload_0
    //   1215: invokevirtual getId : ()I
    //   1218: invokevirtual getResourceName : (I)Ljava/lang/String;
    //   1221: astore #13
    //   1223: goto -> 1235
    //   1226: aload_0
    //   1227: invokevirtual getId : ()I
    //   1230: invokestatic toHexString : (I)Ljava/lang/String;
    //   1233: astore #13
    //   1235: new java/lang/StringBuilder
    //   1238: dup
    //   1239: invokespecial <init> : ()V
    //   1242: astore #14
    //   1244: aload #14
    //   1246: ldc_w 'The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: '
    //   1249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: pop
    //   1253: aload #14
    //   1255: aload_0
    //   1256: getfield d : I
    //   1259: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1262: pop
    //   1263: aload #14
    //   1265: ldc_w ', found: '
    //   1268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: aload #14
    //   1274: iload #9
    //   1276: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1279: pop
    //   1280: aload #14
    //   1282: ldc_w ' Pager id: '
    //   1285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: pop
    //   1289: aload #14
    //   1291: aload #13
    //   1293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1296: pop
    //   1297: aload #14
    //   1299: ldc_w ' Pager class: '
    //   1302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: aload #14
    //   1308: aload_0
    //   1309: invokevirtual getClass : ()Ljava/lang/Class;
    //   1312: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1315: pop
    //   1316: aload #14
    //   1318: ldc_w ' Problematic adapter: '
    //   1321: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1324: pop
    //   1325: aload #14
    //   1327: aload_0
    //   1328: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   1331: invokevirtual getClass : ()Ljava/lang/Class;
    //   1334: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1337: pop
    //   1338: new java/lang/IllegalStateException
    //   1341: dup
    //   1342: aload #14
    //   1344: invokevirtual toString : ()Ljava/lang/String;
    //   1347: invokespecial <init> : (Ljava/lang/String;)V
    //   1350: athrow
    //   1351: astore #13
    //   1353: goto -> 1226
    // Exception table:
    //   from	to	target	type
    //   1210	1223	1351	android/content/res/Resources$NotFoundException
  }
  
  protected void a(int paramInt1, float paramFloat, int paramInt2) {
    int i = this.aa;
    boolean bool = false;
    if (i > 0) {
      int m = getScrollX();
      i = getPaddingLeft();
      int j = getPaddingRight();
      int n = getWidth();
      int i1 = getChildCount();
      int k;
      for (k = 0; k < i1; k++) {
        View view = getChildAt(k);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (layoutParams.isDecor) {
          int i2 = layoutParams.gravity & 0x7;
          if (i2 != 1) {
            if (i2 != 3) {
              if (i2 != 5) {
                int i3 = i;
                i2 = i;
                i = i3;
              } else {
                i2 = n - j - view.getMeasuredWidth();
                j += view.getMeasuredWidth();
              } 
            } else {
              int i3 = view.getWidth() + i;
              i2 = i;
              i = i3;
            } 
          } else {
            i2 = Math.max((n - view.getMeasuredWidth()) / 2, i);
          } 
          i2 = i2 + m - view.getLeft();
          if (i2 != 0)
            view.offsetLeftAndRight(i2); 
        } 
      } 
    } 
    b(paramInt1, paramFloat, paramInt2);
    if (this.af != null) {
      paramInt2 = getScrollX();
      i = getChildCount();
      for (paramInt1 = bool; paramInt1 < i; paramInt1++) {
        View view = getChildAt(paramInt1);
        if (!((LayoutParams)view.getLayoutParams()).isDecor) {
          paramFloat = (view.getLeft() - paramInt2) / getClientWidth();
          this.af.transformPage(view, paramFloat);
        } 
      } 
    } 
    this.W = true;
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3) {
    int i;
    if (getChildCount() == 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    Scroller scroller = this.m;
    if (scroller != null && !scroller.isFinished()) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      if (this.n) {
        i = this.m.getCurrX();
      } else {
        i = this.m.getStartX();
      } 
      this.m.abortAnimation();
      setScrollingCacheEnabled(false);
    } else {
      i = getScrollX();
    } 
    int j = getScrollY();
    int k = paramInt1 - i;
    paramInt2 -= j;
    if (k == 0 && paramInt2 == 0) {
      a(false);
      c();
      setScrollState(0);
      return;
    } 
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int m = paramInt1 / 2;
    float f2 = Math.abs(k);
    float f1 = paramInt1;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = m;
    f3 = a(f3);
    paramInt1 = Math.abs(paramInt3);
    if (paramInt1 > 0) {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
    } else {
      f2 = this.b.getPageWidth(this.c);
      paramInt1 = (int)((Math.abs(k) / (f1 * f2 + this.p) + 1.0F) * 100.0F);
    } 
    paramInt1 = Math.min(paramInt1, 600);
    this.n = false;
    this.m.startScroll(i, j, k, paramInt2, paramInt1);
    ViewCompat.postInvalidateOnAnimation((View)this);
  }
  
  void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2) {
    int i;
    PagerAdapter pagerAdapter = this.b;
    if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    if (!paramBoolean2 && this.c == paramInt1 && this.g.size() != 0) {
      setScrollingCacheEnabled(false);
      return;
    } 
    paramBoolean2 = true;
    if (paramInt1 < 0) {
      i = 0;
    } else {
      i = paramInt1;
      if (paramInt1 >= this.b.getCount())
        i = this.b.getCount() - 1; 
    } 
    paramInt1 = this.A;
    int j = this.c;
    if (i > j + paramInt1 || i < j - paramInt1)
      for (paramInt1 = 0; paramInt1 < this.g.size(); paramInt1++)
        ((ItemInfo)this.g.get(paramInt1)).c = true;  
    if (this.c == i)
      paramBoolean2 = false; 
    if (this.U) {
      this.c = i;
      if (paramBoolean2)
        d(i); 
      requestLayout();
      return;
    } 
    a(i);
    a(i, paramBoolean1, paramInt2, paramBoolean2);
  }
  
  protected boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int j = paramView.getScrollX();
      int k = paramView.getScrollY();
      int i;
      for (i = viewGroup.getChildCount() - 1; i >= 0; i--) {
        View view = viewGroup.getChildAt(i);
        int m = paramInt2 + j;
        if (m >= view.getLeft() && m < view.getRight()) {
          int n = paramInt3 + k;
          if (n >= view.getTop() && n < view.getBottom() && a(view, true, paramInt1, m - view.getLeft(), n - view.getTop()))
            return true; 
        } 
      } 
    } 
    return (paramBoolean && paramView.canScrollHorizontally(-paramInt1));
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    int i = paramArrayList.size();
    int j = getDescendantFocusability();
    if (j != 393216) {
      int k;
      for (k = 0; k < getChildCount(); k++) {
        View view = getChildAt(k);
        if (view.getVisibility() == 0) {
          ItemInfo itemInfo = a(view);
          if (itemInfo != null && itemInfo.b == this.c)
            view.addFocusables(paramArrayList, paramInt1, paramInt2); 
        } 
      } 
    } 
    if (j != 262144 || i == paramArrayList.size()) {
      if (!isFocusable())
        return; 
      if ((paramInt2 & 0x1) == 1 && isInTouchMode() && !isFocusableInTouchMode())
        return; 
      if (paramArrayList != null)
        paramArrayList.add(this); 
    } 
  }
  
  public void addOnAdapterChangeListener(OnAdapterChangeListener paramOnAdapterChangeListener) {
    if (this.ae == null)
      this.ae = new ArrayList<OnAdapterChangeListener>(); 
    this.ae.add(paramOnAdapterChangeListener);
  }
  
  public void addOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    if (this.ab == null)
      this.ab = new ArrayList<OnPageChangeListener>(); 
    this.ab.add(paramOnPageChangeListener);
  }
  
  public void addTouchables(ArrayList<View> paramArrayList) {
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = a(view);
        if (itemInfo != null && itemInfo.b == this.c)
          view.addTouchables(paramArrayList); 
      } 
    } 
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    ViewGroup.LayoutParams layoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams))
      layoutParams = generateLayoutParams(paramLayoutParams); 
    paramLayoutParams = layoutParams;
    ((LayoutParams)paramLayoutParams).isDecor |= c(paramView);
    if (this.x) {
      if (paramLayoutParams == null || !((LayoutParams)paramLayoutParams).isDecor) {
        ((LayoutParams)paramLayoutParams).b = true;
        addViewInLayout(paramView, paramInt, layoutParams);
        return;
      } 
      throw new IllegalStateException("Cannot add pager decor view during layout");
    } 
    super.addView(paramView, paramInt, layoutParams);
  }
  
  public boolean arrowScroll(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual findFocus : ()Landroid/view/View;
    //   4: astore #7
    //   6: iconst_0
    //   7: istore #4
    //   9: aconst_null
    //   10: astore #6
    //   12: aload #7
    //   14: aload_0
    //   15: if_acmpne -> 25
    //   18: aload #6
    //   20: astore #5
    //   22: goto -> 199
    //   25: aload #7
    //   27: ifnull -> 195
    //   30: aload #7
    //   32: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   35: astore #5
    //   37: aload #5
    //   39: instanceof android/view/ViewGroup
    //   42: ifeq -> 68
    //   45: aload #5
    //   47: aload_0
    //   48: if_acmpne -> 56
    //   51: iconst_1
    //   52: istore_2
    //   53: goto -> 70
    //   56: aload #5
    //   58: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   63: astore #5
    //   65: goto -> 37
    //   68: iconst_0
    //   69: istore_2
    //   70: iload_2
    //   71: ifne -> 195
    //   74: new java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: astore #8
    //   83: aload #8
    //   85: aload #7
    //   87: invokevirtual getClass : ()Ljava/lang/Class;
    //   90: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload #7
    //   99: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   102: astore #5
    //   104: aload #5
    //   106: instanceof android/view/ViewGroup
    //   109: ifeq -> 147
    //   112: aload #8
    //   114: ldc_w ' => '
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload #8
    //   123: aload #5
    //   125: invokevirtual getClass : ()Ljava/lang/Class;
    //   128: invokevirtual getSimpleName : ()Ljava/lang/String;
    //   131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload #5
    //   137: invokeinterface getParent : ()Landroid/view/ViewParent;
    //   142: astore #5
    //   144: goto -> 104
    //   147: new java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial <init> : ()V
    //   154: astore #5
    //   156: aload #5
    //   158: ldc_w 'arrowScroll tried to find focus based on non-child current focused view '
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload #5
    //   167: aload #8
    //   169: invokevirtual toString : ()Ljava/lang/String;
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: ldc_w 'ViewPager'
    //   179: aload #5
    //   181: invokevirtual toString : ()Ljava/lang/String;
    //   184: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: aload #6
    //   190: astore #5
    //   192: goto -> 199
    //   195: aload #7
    //   197: astore #5
    //   199: invokestatic getInstance : ()Landroid/view/FocusFinder;
    //   202: aload_0
    //   203: aload #5
    //   205: iload_1
    //   206: invokevirtual findNextFocus : (Landroid/view/ViewGroup;Landroid/view/View;I)Landroid/view/View;
    //   209: astore #6
    //   211: aload #6
    //   213: ifnull -> 349
    //   216: aload #6
    //   218: aload #5
    //   220: if_acmpeq -> 349
    //   223: iload_1
    //   224: bipush #17
    //   226: if_icmpne -> 286
    //   229: aload_0
    //   230: aload_0
    //   231: getfield i : Landroid/graphics/Rect;
    //   234: aload #6
    //   236: invokespecial a : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   239: getfield left : I
    //   242: istore_2
    //   243: aload_0
    //   244: aload_0
    //   245: getfield i : Landroid/graphics/Rect;
    //   248: aload #5
    //   250: invokespecial a : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   253: getfield left : I
    //   256: istore_3
    //   257: aload #5
    //   259: ifnull -> 276
    //   262: iload_2
    //   263: iload_3
    //   264: if_icmplt -> 276
    //   267: aload_0
    //   268: invokevirtual d : ()Z
    //   271: istore #4
    //   273: goto -> 283
    //   276: aload #6
    //   278: invokevirtual requestFocus : ()Z
    //   281: istore #4
    //   283: goto -> 389
    //   286: iload_1
    //   287: bipush #66
    //   289: if_icmpne -> 389
    //   292: aload_0
    //   293: aload_0
    //   294: getfield i : Landroid/graphics/Rect;
    //   297: aload #6
    //   299: invokespecial a : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   302: getfield left : I
    //   305: istore_2
    //   306: aload_0
    //   307: aload_0
    //   308: getfield i : Landroid/graphics/Rect;
    //   311: aload #5
    //   313: invokespecial a : (Landroid/graphics/Rect;Landroid/view/View;)Landroid/graphics/Rect;
    //   316: getfield left : I
    //   319: istore_3
    //   320: aload #5
    //   322: ifnull -> 339
    //   325: iload_2
    //   326: iload_3
    //   327: if_icmpgt -> 339
    //   330: aload_0
    //   331: invokevirtual e : ()Z
    //   334: istore #4
    //   336: goto -> 283
    //   339: aload #6
    //   341: invokevirtual requestFocus : ()Z
    //   344: istore #4
    //   346: goto -> 283
    //   349: iload_1
    //   350: bipush #17
    //   352: if_icmpeq -> 383
    //   355: iload_1
    //   356: iconst_1
    //   357: if_icmpne -> 363
    //   360: goto -> 383
    //   363: iload_1
    //   364: bipush #66
    //   366: if_icmpeq -> 374
    //   369: iload_1
    //   370: iconst_2
    //   371: if_icmpne -> 389
    //   374: aload_0
    //   375: invokevirtual e : ()Z
    //   378: istore #4
    //   380: goto -> 389
    //   383: aload_0
    //   384: invokevirtual d : ()Z
    //   387: istore #4
    //   389: iload #4
    //   391: ifeq -> 402
    //   394: aload_0
    //   395: iload_1
    //   396: invokestatic getContantForFocusDirection : (I)I
    //   399: invokevirtual playSoundEffect : (I)V
    //   402: iload #4
    //   404: ireturn
  }
  
  ItemInfo b(int paramInt) {
    for (int i = 0; i < this.g.size(); i++) {
      ItemInfo itemInfo = this.g.get(i);
      if (itemInfo.b == paramInt)
        return itemInfo; 
    } 
    return null;
  }
  
  ItemInfo b(View paramView) {
    while (true) {
      ViewParent viewParent = paramView.getParent();
      if (viewParent != this) {
        if (viewParent != null) {
          if (!(viewParent instanceof View))
            return null; 
          paramView = (View)viewParent;
          continue;
        } 
        continue;
      } 
      return a(paramView);
    } 
  }
  
  protected void b() {
    Object object1;
    int i;
    Object object2;
    int k;
    int i2 = this.b.getCount();
    this.d = i2;
    if (this.g.size() < this.A * 2 + 1 && this.g.size() < i2) {
      j = 1;
    } else {
      j = 0;
    } 
    int m = this.c;
    int i1 = j;
    int j = m;
    int n = 0;
    m = 0;
    while (n < this.g.size()) {
      ItemInfo itemInfo = this.g.get(n);
      int i6 = this.b.getItemPosition(itemInfo.a);
      if (i6 == -1) {
        int i7 = n;
        Object object3 = object2;
        Object object4 = object1;
        continue;
      } 
      if (i6 == -2) {
        byte b;
        this.g.remove(n);
        int i7 = n - 1;
        Object object = object2;
        if (object2 == null) {
          this.b.startUpdate(this);
          b = 1;
        } 
        this.b.destroyItem(this, itemInfo.b, itemInfo.a);
        n = i7;
        k = b;
        if (this.c == itemInfo.b) {
          i = Math.max(0, Math.min(this.c, i2 - 1));
          k = b;
          n = i7;
        } 
      } else {
        int i7 = n;
        int i8 = k;
        int i9 = i;
        if (itemInfo.b != i6) {
          if (itemInfo.b == this.c)
            i = i6; 
          itemInfo.b = i6;
        } else {
          continue;
        } 
      } 
      i1 = 1;
      int i3 = n;
      int i4 = k;
      int i5 = i;
      continue;
      n = SYNTHETIC_LOCAL_VARIABLE_4 + 1;
      object2 = SYNTHETIC_LOCAL_VARIABLE_5;
      object1 = SYNTHETIC_LOCAL_VARIABLE_7;
    } 
    if (k)
      this.b.finishUpdate(this); 
    Collections.sort(this.g, e);
    if (i1 != 0) {
      n = getChildCount();
      for (k = 0; k < n; k++) {
        LayoutParams layoutParams = (LayoutParams)getChildAt(k).getLayoutParams();
        if (!layoutParams.isDecor)
          layoutParams.a = 0.0F; 
      } 
      a(i, false, true);
      requestLayout();
    } 
  }
  
  public boolean beginFakeDrag() {
    if (this.B)
      return false; 
    this.Q = true;
    setScrollState(1);
    this.G = 0.0F;
    this.I = 0.0F;
    VelocityTracker velocityTracker = this.L;
    if (velocityTracker == null) {
      this.L = VelocityTracker.obtain();
    } else {
      velocityTracker.clear();
    } 
    long l = SystemClock.uptimeMillis();
    MotionEvent motionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
    this.L.addMovement(motionEvent);
    motionEvent.recycle();
    this.R = l;
    return true;
  }
  
  void c() {
    a(this.c);
  }
  
  public boolean canScrollHorizontally(int paramInt) {
    PagerAdapter pagerAdapter = this.b;
    boolean bool2 = false;
    boolean bool1 = false;
    if (pagerAdapter == null)
      return false; 
    int i = getClientWidth();
    int j = getScrollX();
    if (paramInt < 0) {
      if (j > (int)(i * this.t))
        bool1 = true; 
      return bool1;
    } 
    bool1 = bool2;
    if (paramInt > 0) {
      bool1 = bool2;
      if (j < (int)(i * this.u))
        bool1 = true; 
    } 
    return bool1;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  public void clearOnPageChangeListeners() {
    List<OnPageChangeListener> list = this.ab;
    if (list != null)
      list.clear(); 
  }
  
  public void computeScroll() {
    this.n = true;
    if (!this.m.isFinished() && this.m.computeScrollOffset()) {
      int i = getScrollX();
      int j = getScrollY();
      int k = this.m.getCurrX();
      int m = this.m.getCurrY();
      if (i != k || j != m) {
        scrollTo(k, m);
        if (!c(k)) {
          this.m.abortAnimation();
          scrollTo(0, m);
        } 
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
      return;
    } 
    a(true);
  }
  
  boolean d() {
    int i = this.c;
    if (i > 0) {
      setCurrentItem(i - 1, true);
      return true;
    } 
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    return (super.dispatchKeyEvent(paramKeyEvent) || executeKeyEvent(paramKeyEvent));
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    if (paramAccessibilityEvent.getEventType() == 4096)
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent); 
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = a(view);
        if (itemInfo != null && itemInfo.b == this.c && view.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))
          return true; 
      } 
    } 
    return false;
  }
  
  public void draw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial draw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: invokevirtual getOverScrollMode : ()I
    //   9: istore #4
    //   11: iconst_0
    //   12: istore_3
    //   13: iconst_0
    //   14: istore_2
    //   15: iload #4
    //   17: ifeq -> 66
    //   20: iload #4
    //   22: iconst_1
    //   23: if_icmpne -> 49
    //   26: aload_0
    //   27: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   30: astore #8
    //   32: aload #8
    //   34: ifnull -> 49
    //   37: aload #8
    //   39: invokevirtual getCount : ()I
    //   42: iconst_1
    //   43: if_icmple -> 49
    //   46: goto -> 66
    //   49: aload_0
    //   50: getfield S : Landroid/widget/EdgeEffect;
    //   53: invokevirtual finish : ()V
    //   56: aload_0
    //   57: getfield T : Landroid/widget/EdgeEffect;
    //   60: invokevirtual finish : ()V
    //   63: goto -> 256
    //   66: aload_0
    //   67: getfield S : Landroid/widget/EdgeEffect;
    //   70: invokevirtual isFinished : ()Z
    //   73: ifne -> 155
    //   76: aload_1
    //   77: invokevirtual save : ()I
    //   80: istore_3
    //   81: aload_0
    //   82: invokevirtual getHeight : ()I
    //   85: aload_0
    //   86: invokevirtual getPaddingTop : ()I
    //   89: isub
    //   90: aload_0
    //   91: invokevirtual getPaddingBottom : ()I
    //   94: isub
    //   95: istore_2
    //   96: aload_0
    //   97: invokevirtual getWidth : ()I
    //   100: istore #4
    //   102: aload_1
    //   103: ldc_w 270.0
    //   106: invokevirtual rotate : (F)V
    //   109: aload_1
    //   110: iload_2
    //   111: ineg
    //   112: aload_0
    //   113: invokevirtual getPaddingTop : ()I
    //   116: iadd
    //   117: i2f
    //   118: aload_0
    //   119: getfield t : F
    //   122: iload #4
    //   124: i2f
    //   125: fmul
    //   126: invokevirtual translate : (FF)V
    //   129: aload_0
    //   130: getfield S : Landroid/widget/EdgeEffect;
    //   133: iload_2
    //   134: iload #4
    //   136: invokevirtual setSize : (II)V
    //   139: iconst_0
    //   140: aload_0
    //   141: getfield S : Landroid/widget/EdgeEffect;
    //   144: aload_1
    //   145: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   148: ior
    //   149: istore_2
    //   150: aload_1
    //   151: iload_3
    //   152: invokevirtual restoreToCount : (I)V
    //   155: iload_2
    //   156: istore_3
    //   157: aload_0
    //   158: getfield T : Landroid/widget/EdgeEffect;
    //   161: invokevirtual isFinished : ()Z
    //   164: ifne -> 256
    //   167: aload_1
    //   168: invokevirtual save : ()I
    //   171: istore #4
    //   173: aload_0
    //   174: invokevirtual getWidth : ()I
    //   177: istore_3
    //   178: aload_0
    //   179: invokevirtual getHeight : ()I
    //   182: istore #5
    //   184: aload_0
    //   185: invokevirtual getPaddingTop : ()I
    //   188: istore #6
    //   190: aload_0
    //   191: invokevirtual getPaddingBottom : ()I
    //   194: istore #7
    //   196: aload_1
    //   197: ldc_w 90.0
    //   200: invokevirtual rotate : (F)V
    //   203: aload_1
    //   204: aload_0
    //   205: invokevirtual getPaddingTop : ()I
    //   208: ineg
    //   209: i2f
    //   210: aload_0
    //   211: getfield u : F
    //   214: fconst_1
    //   215: fadd
    //   216: fneg
    //   217: iload_3
    //   218: i2f
    //   219: fmul
    //   220: invokevirtual translate : (FF)V
    //   223: aload_0
    //   224: getfield T : Landroid/widget/EdgeEffect;
    //   227: iload #5
    //   229: iload #6
    //   231: isub
    //   232: iload #7
    //   234: isub
    //   235: iload_3
    //   236: invokevirtual setSize : (II)V
    //   239: iload_2
    //   240: aload_0
    //   241: getfield T : Landroid/widget/EdgeEffect;
    //   244: aload_1
    //   245: invokevirtual draw : (Landroid/graphics/Canvas;)Z
    //   248: ior
    //   249: istore_3
    //   250: aload_1
    //   251: iload #4
    //   253: invokevirtual restoreToCount : (I)V
    //   256: iload_3
    //   257: ifeq -> 264
    //   260: aload_0
    //   261: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   264: return
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    Drawable drawable = this.q;
    if (drawable != null && drawable.isStateful())
      drawable.setState(getDrawableState()); 
  }
  
  boolean e() {
    PagerAdapter pagerAdapter = this.b;
    if (pagerAdapter != null && this.c < pagerAdapter.getCount() - 1) {
      setCurrentItem(this.c + 1, true);
      return true;
    } 
    return false;
  }
  
  public void endFakeDrag() {
    if (this.Q) {
      if (this.b != null) {
        VelocityTracker velocityTracker = this.L;
        velocityTracker.computeCurrentVelocity(1000, this.N);
        int i = (int)velocityTracker.getXVelocity(this.K);
        this.z = true;
        int j = getClientWidth();
        int k = getScrollX();
        ItemInfo itemInfo = i();
        a(a(itemInfo.b, (k / j - itemInfo.e) / itemInfo.d, i, (int)(this.G - this.I)), true, true, i);
      } 
      j();
      this.Q = false;
      return;
    } 
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  public boolean executeKeyEvent(KeyEvent paramKeyEvent) {
    if (paramKeyEvent.getAction() == 0) {
      int i = paramKeyEvent.getKeyCode();
      if (i != 21) {
        if (i != 22) {
          if (i == 61) {
            if (paramKeyEvent.hasNoModifiers())
              return arrowScroll(2); 
            if (paramKeyEvent.hasModifiers(1))
              return arrowScroll(1); 
          } 
        } else {
          return paramKeyEvent.hasModifiers(2) ? e() : arrowScroll(66);
        } 
      } else {
        return paramKeyEvent.hasModifiers(2) ? d() : arrowScroll(17);
      } 
    } 
    return false;
  }
  
  public void fakeDragBy(float paramFloat) {
    if (this.Q) {
      if (this.b == null)
        return; 
      this.G += paramFloat;
      float f2 = getScrollX() - paramFloat;
      float f3 = getClientWidth();
      paramFloat = this.t * f3;
      float f1 = this.u * f3;
      ItemInfo itemInfo1 = this.g.get(0);
      ArrayList<ItemInfo> arrayList = this.g;
      ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
      if (itemInfo1.b != 0)
        paramFloat = itemInfo1.e * f3; 
      if (itemInfo2.b != this.b.getCount() - 1)
        f1 = itemInfo2.e * f3; 
      if (f2 >= paramFloat) {
        paramFloat = f2;
        if (f2 > f1)
          paramFloat = f1; 
      } 
      f1 = this.G;
      int i = (int)paramFloat;
      this.G = f1 + paramFloat - i;
      scrollTo(i, getScrollY());
      c(i);
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(this.R, l, 2, this.G, 0.0F, 0);
      this.L.addMovement(motionEvent);
      motionEvent.recycle();
      return;
    } 
    throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return generateDefaultLayoutParams();
  }
  
  public PagerAdapter getAdapter() {
    return this.b;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    int i = paramInt2;
    if (this.ah == 2)
      i = paramInt1 - 1 - paramInt2; 
    return ((LayoutParams)((View)this.ai.get(i)).getLayoutParams()).d;
  }
  
  public int getCurrentItem() {
    return this.c;
  }
  
  public int getOffscreenPageLimit() {
    return this.A;
  }
  
  public int getPageMargin() {
    return this.p;
  }
  
  public boolean isFakeDragging() {
    return this.Q;
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.U = true;
  }
  
  public void onDetachedFromWindow() {
    removeCallbacks(this.ak);
    Scroller scroller = this.m;
    if (scroller != null && !scroller.isFinished())
      this.m.abortAnimation(); 
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (this.p > 0 && this.q != null && this.g.size() > 0 && this.b != null) {
      int k = getScrollX();
      int m = getWidth();
      float f1 = this.p;
      float f3 = m;
      float f2 = f1 / f3;
      ArrayList<ItemInfo> arrayList = this.g;
      int j = 0;
      ItemInfo itemInfo = arrayList.get(0);
      f1 = itemInfo.e;
      int n = this.g.size();
      int i = itemInfo.b;
      int i1 = ((ItemInfo)this.g.get(n - 1)).b;
      while (i < i1) {
        float f;
        ItemInfo itemInfo1;
        while (i > itemInfo.b && j < n) {
          ArrayList<ItemInfo> arrayList1 = this.g;
          itemInfo1 = arrayList1.get(++j);
        } 
        if (i == itemInfo1.b) {
          f = (itemInfo1.e + itemInfo1.d) * f3;
          f1 = itemInfo1.e + itemInfo1.d + f2;
        } else {
          float f4 = this.b.getPageWidth(i);
          f = f1 + f4 + f2;
          f4 = (f1 + f4) * f3;
          f1 = f;
          f = f4;
        } 
        if (this.p + f > k) {
          this.q.setBounds(Math.round(f), this.r, Math.round(this.p + f), this.s);
          this.q.draw(paramCanvas);
        } 
        if (f > (k + m))
          return; 
        i++;
      } 
    } 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 3 || i == 1) {
      h();
      return false;
    } 
    if (i != 0) {
      if (this.B)
        return true; 
      if (this.C)
        return false; 
    } 
    if (i != 0) {
      if (i != 2) {
        if (i == 6)
          a(paramMotionEvent); 
      } else {
        i = this.K;
        if (i != -1) {
          i = paramMotionEvent.findPointerIndex(i);
          float f2 = paramMotionEvent.getX(i);
          float f1 = f2 - this.G;
          float f4 = Math.abs(f1);
          float f3 = paramMotionEvent.getY(i);
          float f5 = Math.abs(f3 - this.J);
          i = f1 cmp 0.0F;
          if (i != 0 && !a(this.G, f1) && a((View)this, false, (int)f1, (int)f2, (int)f3)) {
            this.G = f2;
            this.H = f3;
            this.C = true;
            return false;
          } 
          if (f4 > this.F && f4 * 0.5F > f5) {
            this.B = true;
            c(true);
            setScrollState(1);
            f1 = this.I;
            f4 = this.F;
            if (i > 0) {
              f1 += f4;
            } else {
              f1 -= f4;
            } 
            this.G = f1;
            this.H = f3;
            setScrollingCacheEnabled(true);
          } else if (f5 > this.F) {
            this.C = true;
          } 
          if (this.B && b(f2))
            ViewCompat.postInvalidateOnAnimation((View)this); 
        } 
      } 
    } else {
      float f = paramMotionEvent.getX();
      this.I = f;
      this.G = f;
      f = paramMotionEvent.getY();
      this.J = f;
      this.H = f;
      this.K = paramMotionEvent.getPointerId(0);
      this.C = false;
      this.n = true;
      this.m.computeScrollOffset();
      if (this.al == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
        this.m.abortAnimation();
        this.z = false;
        c();
        this.B = true;
        c(true);
        setScrollState(1);
      } else {
        a(false);
        this.B = false;
      } 
    } 
    if (this.L == null)
      this.L = VelocityTracker.obtain(); 
    this.L.addMovement(paramMotionEvent);
    return this.B;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int m = getChildCount();
    int n = paramInt3 - paramInt1;
    int i1 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i2 = getScrollX();
    int j = 0;
    int k = 0;
    while (k < m) {
      View view = getChildAt(k);
      int i3 = paramInt2;
      int i6 = i;
      int i5 = paramInt1;
      int i4 = paramInt4;
      paramInt3 = j;
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        i3 = paramInt2;
        i6 = i;
        i5 = paramInt1;
        i4 = paramInt4;
        paramInt3 = j;
        if (layoutParams.isDecor) {
          paramInt3 = layoutParams.gravity & 0x7;
          i4 = layoutParams.gravity & 0x70;
          if (paramInt3 != 1) {
            if (paramInt3 != 3) {
              if (paramInt3 != 5) {
                paramInt3 = paramInt2;
                i3 = paramInt2;
              } else {
                paramInt3 = n - i - view.getMeasuredWidth();
                i += view.getMeasuredWidth();
                i3 = paramInt2;
              } 
            } else {
              i3 = view.getMeasuredWidth();
              paramInt3 = paramInt2;
              i3 += paramInt2;
            } 
          } else {
            paramInt3 = Math.max((n - view.getMeasuredWidth()) / 2, paramInt2);
            i3 = paramInt2;
          } 
          if (i4 != 16) {
            if (i4 != 48) {
              if (i4 != 80) {
                paramInt2 = paramInt1;
              } else {
                paramInt2 = i1 - paramInt4 - view.getMeasuredHeight();
                paramInt4 += view.getMeasuredHeight();
              } 
            } else {
              i4 = view.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i4 + paramInt1;
            } 
          } else {
            paramInt2 = Math.max((i1 - view.getMeasuredHeight()) / 2, paramInt1);
          } 
          paramInt3 += i2;
          view.layout(paramInt3, paramInt2, view.getMeasuredWidth() + paramInt3, paramInt2 + view.getMeasuredHeight());
          paramInt3 = j + 1;
          i4 = paramInt4;
          i5 = paramInt1;
          i6 = i;
        } 
      } 
      k++;
      paramInt2 = i3;
      i = i6;
      paramInt1 = i5;
      paramInt4 = i4;
      j = paramInt3;
    } 
    for (paramInt3 = 0; paramInt3 < m; paramInt3++) {
      View view = getChildAt(paramInt3);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (!layoutParams.isDecor) {
          ItemInfo itemInfo = a(view);
          if (itemInfo != null) {
            float f = (n - paramInt2 - i);
            int i3 = (int)(itemInfo.e * f) + paramInt2;
            if (layoutParams.b) {
              layoutParams.b = false;
              view.measure(View.MeasureSpec.makeMeasureSpec((int)(f * layoutParams.a), 1073741824), View.MeasureSpec.makeMeasureSpec(i1 - paramInt1 - paramInt4, 1073741824));
            } 
            view.layout(i3, paramInt1, view.getMeasuredWidth() + i3, view.getMeasuredHeight() + paramInt1);
          } 
        } 
      } 
    } 
    this.r = paramInt1;
    this.s = i1 - paramInt4;
    this.aa = j;
    if (this.U)
      a(this.c, false, 0, false); 
    this.U = false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: iload_1
    //   3: invokestatic getDefaultSize : (II)I
    //   6: iconst_0
    //   7: iload_2
    //   8: invokestatic getDefaultSize : (II)I
    //   11: invokevirtual setMeasuredDimension : (II)V
    //   14: aload_0
    //   15: invokevirtual getMeasuredWidth : ()I
    //   18: istore_1
    //   19: aload_0
    //   20: iload_1
    //   21: bipush #10
    //   23: idiv
    //   24: aload_0
    //   25: getfield D : I
    //   28: invokestatic min : (II)I
    //   31: putfield E : I
    //   34: aload_0
    //   35: invokevirtual getPaddingLeft : ()I
    //   38: istore_3
    //   39: aload_0
    //   40: invokevirtual getPaddingRight : ()I
    //   43: istore #4
    //   45: aload_0
    //   46: invokevirtual getMeasuredHeight : ()I
    //   49: istore_2
    //   50: aload_0
    //   51: invokevirtual getPaddingTop : ()I
    //   54: istore #5
    //   56: aload_0
    //   57: invokevirtual getPaddingBottom : ()I
    //   60: istore #6
    //   62: aload_0
    //   63: invokevirtual getChildCount : ()I
    //   66: istore #11
    //   68: iload_2
    //   69: iload #5
    //   71: isub
    //   72: iload #6
    //   74: isub
    //   75: istore_2
    //   76: iload_1
    //   77: iload_3
    //   78: isub
    //   79: iload #4
    //   81: isub
    //   82: istore_1
    //   83: iconst_0
    //   84: istore #5
    //   86: iconst_1
    //   87: istore #8
    //   89: ldc_w 1073741824
    //   92: istore #10
    //   94: iload #5
    //   96: iload #11
    //   98: if_icmpge -> 434
    //   101: aload_0
    //   102: iload #5
    //   104: invokevirtual getChildAt : (I)Landroid/view/View;
    //   107: astore #12
    //   109: iload_1
    //   110: istore_3
    //   111: iload_2
    //   112: istore #4
    //   114: aload #12
    //   116: invokevirtual getVisibility : ()I
    //   119: bipush #8
    //   121: if_icmpeq -> 420
    //   124: aload #12
    //   126: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   129: checkcast androidx/viewpager/widget/ViewPager$LayoutParams
    //   132: astore #13
    //   134: iload_1
    //   135: istore_3
    //   136: iload_2
    //   137: istore #4
    //   139: aload #13
    //   141: ifnull -> 420
    //   144: iload_1
    //   145: istore_3
    //   146: iload_2
    //   147: istore #4
    //   149: aload #13
    //   151: getfield isDecor : Z
    //   154: ifeq -> 420
    //   157: aload #13
    //   159: getfield gravity : I
    //   162: bipush #7
    //   164: iand
    //   165: istore_3
    //   166: aload #13
    //   168: getfield gravity : I
    //   171: bipush #112
    //   173: iand
    //   174: istore #4
    //   176: iload #4
    //   178: bipush #48
    //   180: if_icmpeq -> 199
    //   183: iload #4
    //   185: bipush #80
    //   187: if_icmpne -> 193
    //   190: goto -> 199
    //   193: iconst_0
    //   194: istore #7
    //   196: goto -> 202
    //   199: iconst_1
    //   200: istore #7
    //   202: iload #8
    //   204: istore #6
    //   206: iload_3
    //   207: iconst_3
    //   208: if_icmpeq -> 226
    //   211: iload_3
    //   212: iconst_5
    //   213: if_icmpne -> 223
    //   216: iload #8
    //   218: istore #6
    //   220: goto -> 226
    //   223: iconst_0
    //   224: istore #6
    //   226: ldc_w -2147483648
    //   229: istore_3
    //   230: iload #7
    //   232: ifeq -> 243
    //   235: ldc_w 1073741824
    //   238: istore #4
    //   240: goto -> 265
    //   243: iload_3
    //   244: istore #4
    //   246: iload #6
    //   248: ifeq -> 265
    //   251: ldc_w 1073741824
    //   254: istore #8
    //   256: iload_3
    //   257: istore #4
    //   259: iload #8
    //   261: istore_3
    //   262: goto -> 269
    //   265: ldc_w -2147483648
    //   268: istore_3
    //   269: aload #13
    //   271: getfield width : I
    //   274: bipush #-2
    //   276: if_icmpeq -> 313
    //   279: aload #13
    //   281: getfield width : I
    //   284: iconst_m1
    //   285: if_icmpeq -> 298
    //   288: aload #13
    //   290: getfield width : I
    //   293: istore #4
    //   295: goto -> 301
    //   298: iload_1
    //   299: istore #4
    //   301: ldc_w 1073741824
    //   304: istore #8
    //   306: iload #4
    //   308: istore #9
    //   310: goto -> 320
    //   313: iload_1
    //   314: istore #9
    //   316: iload #4
    //   318: istore #8
    //   320: aload #13
    //   322: getfield height : I
    //   325: bipush #-2
    //   327: if_icmpeq -> 353
    //   330: aload #13
    //   332: getfield height : I
    //   335: iconst_m1
    //   336: if_icmpeq -> 348
    //   339: aload #13
    //   341: getfield height : I
    //   344: istore_3
    //   345: goto -> 362
    //   348: iload_2
    //   349: istore_3
    //   350: goto -> 362
    //   353: iload_2
    //   354: istore #4
    //   356: iload_3
    //   357: istore #10
    //   359: iload #4
    //   361: istore_3
    //   362: aload #12
    //   364: iload #9
    //   366: iload #8
    //   368: invokestatic makeMeasureSpec : (II)I
    //   371: iload_3
    //   372: iload #10
    //   374: invokestatic makeMeasureSpec : (II)I
    //   377: invokevirtual measure : (II)V
    //   380: iload #7
    //   382: ifeq -> 399
    //   385: iload_2
    //   386: aload #12
    //   388: invokevirtual getMeasuredHeight : ()I
    //   391: isub
    //   392: istore #4
    //   394: iload_1
    //   395: istore_3
    //   396: goto -> 420
    //   399: iload_1
    //   400: istore_3
    //   401: iload_2
    //   402: istore #4
    //   404: iload #6
    //   406: ifeq -> 420
    //   409: iload_1
    //   410: aload #12
    //   412: invokevirtual getMeasuredWidth : ()I
    //   415: isub
    //   416: istore_3
    //   417: iload_2
    //   418: istore #4
    //   420: iload #5
    //   422: iconst_1
    //   423: iadd
    //   424: istore #5
    //   426: iload_3
    //   427: istore_1
    //   428: iload #4
    //   430: istore_2
    //   431: goto -> 86
    //   434: aload_0
    //   435: iload_1
    //   436: ldc_w 1073741824
    //   439: invokestatic makeMeasureSpec : (II)I
    //   442: putfield v : I
    //   445: aload_0
    //   446: iload_2
    //   447: ldc_w 1073741824
    //   450: invokestatic makeMeasureSpec : (II)I
    //   453: putfield w : I
    //   456: aload_0
    //   457: iconst_1
    //   458: putfield x : Z
    //   461: aload_0
    //   462: invokevirtual c : ()V
    //   465: iconst_0
    //   466: istore_2
    //   467: aload_0
    //   468: iconst_0
    //   469: putfield x : Z
    //   472: aload_0
    //   473: invokevirtual getChildCount : ()I
    //   476: istore_3
    //   477: iload_2
    //   478: iload_3
    //   479: if_icmpge -> 553
    //   482: aload_0
    //   483: iload_2
    //   484: invokevirtual getChildAt : (I)Landroid/view/View;
    //   487: astore #12
    //   489: aload #12
    //   491: invokevirtual getVisibility : ()I
    //   494: bipush #8
    //   496: if_icmpeq -> 546
    //   499: aload #12
    //   501: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   504: checkcast androidx/viewpager/widget/ViewPager$LayoutParams
    //   507: astore #13
    //   509: aload #13
    //   511: ifnull -> 522
    //   514: aload #13
    //   516: getfield isDecor : Z
    //   519: ifne -> 546
    //   522: aload #12
    //   524: iload_1
    //   525: i2f
    //   526: aload #13
    //   528: getfield a : F
    //   531: fmul
    //   532: f2i
    //   533: ldc_w 1073741824
    //   536: invokestatic makeMeasureSpec : (II)I
    //   539: aload_0
    //   540: getfield w : I
    //   543: invokevirtual measure : (II)V
    //   546: iload_2
    //   547: iconst_1
    //   548: iadd
    //   549: istore_2
    //   550: goto -> 477
    //   553: return
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    byte b;
    int i = getChildCount();
    int j = -1;
    if ((paramInt & 0x2) != 0) {
      j = i;
      i = 0;
      b = 1;
    } else {
      i--;
      b = -1;
    } 
    while (i != j) {
      View view = getChildAt(i);
      if (view.getVisibility() == 0) {
        ItemInfo itemInfo = a(view);
        if (itemInfo != null && itemInfo.b == this.c && view.requestFocus(paramInt, paramRect))
          return true; 
      } 
      i += b;
    } 
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    PagerAdapter pagerAdapter = this.b;
    if (pagerAdapter != null) {
      pagerAdapter.restoreState(savedState.b, savedState.c);
      a(savedState.a, false, true);
      return;
    } 
    this.j = savedState.a;
    this.k = savedState.b;
    this.l = savedState.c;
  }
  
  public Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    savedState.a = this.c;
    PagerAdapter pagerAdapter = this.b;
    if (pagerAdapter != null)
      savedState.b = pagerAdapter.saveState(); 
    return (Parcelable)savedState;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      paramInt2 = this.p;
      a(paramInt1, paramInt3, paramInt2, paramInt2);
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield Q : Z
    //   4: ifeq -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_1
    //   10: invokevirtual getAction : ()I
    //   13: istore #6
    //   15: iconst_0
    //   16: istore #9
    //   18: iload #6
    //   20: ifne -> 32
    //   23: aload_1
    //   24: invokevirtual getEdgeFlags : ()I
    //   27: ifeq -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: getfield b : Landroidx/viewpager/widget/PagerAdapter;
    //   36: astore #10
    //   38: aload #10
    //   40: ifnull -> 612
    //   43: aload #10
    //   45: invokevirtual getCount : ()I
    //   48: ifne -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: aload_0
    //   54: getfield L : Landroid/view/VelocityTracker;
    //   57: ifnonnull -> 67
    //   60: aload_0
    //   61: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   64: putfield L : Landroid/view/VelocityTracker;
    //   67: aload_0
    //   68: getfield L : Landroid/view/VelocityTracker;
    //   71: aload_1
    //   72: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   75: aload_1
    //   76: invokevirtual getAction : ()I
    //   79: sipush #255
    //   82: iand
    //   83: istore #6
    //   85: iload #6
    //   87: ifeq -> 546
    //   90: iload #6
    //   92: iconst_1
    //   93: if_icmpeq -> 406
    //   96: iload #6
    //   98: iconst_2
    //   99: if_icmpeq -> 204
    //   102: iload #6
    //   104: iconst_3
    //   105: if_icmpeq -> 177
    //   108: iload #6
    //   110: iconst_5
    //   111: if_icmpeq -> 148
    //   114: iload #6
    //   116: bipush #6
    //   118: if_icmpeq -> 124
    //   121: goto -> 601
    //   124: aload_0
    //   125: aload_1
    //   126: invokespecial a : (Landroid/view/MotionEvent;)V
    //   129: aload_0
    //   130: aload_1
    //   131: aload_1
    //   132: aload_0
    //   133: getfield K : I
    //   136: invokevirtual findPointerIndex : (I)I
    //   139: invokevirtual getX : (I)F
    //   142: putfield G : F
    //   145: goto -> 601
    //   148: aload_1
    //   149: invokevirtual getActionIndex : ()I
    //   152: istore #6
    //   154: aload_0
    //   155: aload_1
    //   156: iload #6
    //   158: invokevirtual getX : (I)F
    //   161: putfield G : F
    //   164: aload_0
    //   165: aload_1
    //   166: iload #6
    //   168: invokevirtual getPointerId : (I)I
    //   171: putfield K : I
    //   174: goto -> 601
    //   177: aload_0
    //   178: getfield B : Z
    //   181: ifeq -> 601
    //   184: aload_0
    //   185: aload_0
    //   186: getfield c : I
    //   189: iconst_1
    //   190: iconst_0
    //   191: iconst_0
    //   192: invokespecial a : (IZIZ)V
    //   195: aload_0
    //   196: invokespecial h : ()Z
    //   199: istore #9
    //   201: goto -> 601
    //   204: aload_0
    //   205: getfield B : Z
    //   208: ifne -> 376
    //   211: aload_1
    //   212: aload_0
    //   213: getfield K : I
    //   216: invokevirtual findPointerIndex : (I)I
    //   219: istore #6
    //   221: iload #6
    //   223: iconst_m1
    //   224: if_icmpne -> 236
    //   227: aload_0
    //   228: invokespecial h : ()Z
    //   231: istore #9
    //   233: goto -> 601
    //   236: aload_1
    //   237: iload #6
    //   239: invokevirtual getX : (I)F
    //   242: fstore_2
    //   243: fload_2
    //   244: aload_0
    //   245: getfield G : F
    //   248: fsub
    //   249: invokestatic abs : (F)F
    //   252: fstore #4
    //   254: aload_1
    //   255: iload #6
    //   257: invokevirtual getY : (I)F
    //   260: fstore_3
    //   261: fload_3
    //   262: aload_0
    //   263: getfield H : F
    //   266: fsub
    //   267: invokestatic abs : (F)F
    //   270: fstore #5
    //   272: fload #4
    //   274: aload_0
    //   275: getfield F : I
    //   278: i2f
    //   279: fcmpl
    //   280: ifle -> 376
    //   283: fload #4
    //   285: fload #5
    //   287: fcmpl
    //   288: ifle -> 376
    //   291: aload_0
    //   292: iconst_1
    //   293: putfield B : Z
    //   296: aload_0
    //   297: iconst_1
    //   298: invokespecial c : (Z)V
    //   301: aload_0
    //   302: getfield I : F
    //   305: fstore #4
    //   307: fload_2
    //   308: fload #4
    //   310: fsub
    //   311: fconst_0
    //   312: fcmpl
    //   313: ifle -> 328
    //   316: fload #4
    //   318: aload_0
    //   319: getfield F : I
    //   322: i2f
    //   323: fadd
    //   324: fstore_2
    //   325: goto -> 337
    //   328: fload #4
    //   330: aload_0
    //   331: getfield F : I
    //   334: i2f
    //   335: fsub
    //   336: fstore_2
    //   337: aload_0
    //   338: fload_2
    //   339: putfield G : F
    //   342: aload_0
    //   343: fload_3
    //   344: putfield H : F
    //   347: aload_0
    //   348: iconst_1
    //   349: invokevirtual setScrollState : (I)V
    //   352: aload_0
    //   353: iconst_1
    //   354: invokespecial setScrollingCacheEnabled : (Z)V
    //   357: aload_0
    //   358: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   361: astore #10
    //   363: aload #10
    //   365: ifnull -> 376
    //   368: aload #10
    //   370: iconst_1
    //   371: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   376: aload_0
    //   377: getfield B : Z
    //   380: ifeq -> 601
    //   383: iconst_0
    //   384: aload_0
    //   385: aload_1
    //   386: aload_1
    //   387: aload_0
    //   388: getfield K : I
    //   391: invokevirtual findPointerIndex : (I)I
    //   394: invokevirtual getX : (I)F
    //   397: invokespecial b : (F)Z
    //   400: ior
    //   401: istore #9
    //   403: goto -> 601
    //   406: aload_0
    //   407: getfield B : Z
    //   410: ifeq -> 601
    //   413: aload_0
    //   414: getfield L : Landroid/view/VelocityTracker;
    //   417: astore #10
    //   419: aload #10
    //   421: sipush #1000
    //   424: aload_0
    //   425: getfield N : I
    //   428: i2f
    //   429: invokevirtual computeCurrentVelocity : (IF)V
    //   432: aload #10
    //   434: aload_0
    //   435: getfield K : I
    //   438: invokevirtual getXVelocity : (I)F
    //   441: f2i
    //   442: istore #6
    //   444: aload_0
    //   445: iconst_1
    //   446: putfield z : Z
    //   449: aload_0
    //   450: invokespecial getClientWidth : ()I
    //   453: istore #7
    //   455: aload_0
    //   456: invokevirtual getScrollX : ()I
    //   459: istore #8
    //   461: aload_0
    //   462: invokespecial i : ()Landroidx/viewpager/widget/ViewPager$ItemInfo;
    //   465: astore #10
    //   467: aload_0
    //   468: getfield p : I
    //   471: i2f
    //   472: fstore_3
    //   473: iload #7
    //   475: i2f
    //   476: fstore_2
    //   477: fload_3
    //   478: fload_2
    //   479: fdiv
    //   480: fstore_3
    //   481: aload_0
    //   482: aload_0
    //   483: aload #10
    //   485: getfield b : I
    //   488: iload #8
    //   490: i2f
    //   491: fload_2
    //   492: fdiv
    //   493: aload #10
    //   495: getfield e : F
    //   498: fsub
    //   499: aload #10
    //   501: getfield d : F
    //   504: fload_3
    //   505: fadd
    //   506: fdiv
    //   507: iload #6
    //   509: aload_1
    //   510: aload_1
    //   511: aload_0
    //   512: getfield K : I
    //   515: invokevirtual findPointerIndex : (I)I
    //   518: invokevirtual getX : (I)F
    //   521: aload_0
    //   522: getfield I : F
    //   525: fsub
    //   526: f2i
    //   527: invokespecial a : (IFII)I
    //   530: iconst_1
    //   531: iconst_1
    //   532: iload #6
    //   534: invokevirtual a : (IZZI)V
    //   537: aload_0
    //   538: invokespecial h : ()Z
    //   541: istore #9
    //   543: goto -> 601
    //   546: aload_0
    //   547: getfield m : Landroid/widget/Scroller;
    //   550: invokevirtual abortAnimation : ()V
    //   553: aload_0
    //   554: iconst_0
    //   555: putfield z : Z
    //   558: aload_0
    //   559: invokevirtual c : ()V
    //   562: aload_1
    //   563: invokevirtual getX : ()F
    //   566: fstore_2
    //   567: aload_0
    //   568: fload_2
    //   569: putfield I : F
    //   572: aload_0
    //   573: fload_2
    //   574: putfield G : F
    //   577: aload_1
    //   578: invokevirtual getY : ()F
    //   581: fstore_2
    //   582: aload_0
    //   583: fload_2
    //   584: putfield J : F
    //   587: aload_0
    //   588: fload_2
    //   589: putfield H : F
    //   592: aload_0
    //   593: aload_1
    //   594: iconst_0
    //   595: invokevirtual getPointerId : (I)I
    //   598: putfield K : I
    //   601: iload #9
    //   603: ifeq -> 610
    //   606: aload_0
    //   607: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   610: iconst_1
    //   611: ireturn
    //   612: iconst_0
    //   613: ireturn
  }
  
  public void removeOnAdapterChangeListener(OnAdapterChangeListener paramOnAdapterChangeListener) {
    List<OnAdapterChangeListener> list = this.ae;
    if (list != null)
      list.remove(paramOnAdapterChangeListener); 
  }
  
  public void removeOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    List<OnPageChangeListener> list = this.ab;
    if (list != null)
      list.remove(paramOnPageChangeListener); 
  }
  
  public void removeView(View paramView) {
    if (this.x) {
      removeViewInLayout(paramView);
      return;
    } 
    super.removeView(paramView);
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter) {
    PagerAdapter pagerAdapter = this.b;
    byte b = 0;
    if (pagerAdapter != null) {
      pagerAdapter.a(null);
      this.b.startUpdate(this);
      for (int i = 0; i < this.g.size(); i++) {
        ItemInfo itemInfo = this.g.get(i);
        this.b.destroyItem(this, itemInfo.b, itemInfo.a);
      } 
      this.b.finishUpdate(this);
      this.g.clear();
      f();
      this.c = 0;
      scrollTo(0, 0);
    } 
    pagerAdapter = this.b;
    this.b = paramPagerAdapter;
    this.d = 0;
    if (this.b != null) {
      if (this.o == null)
        this.o = new PagerObserver(this); 
      this.b.a(this.o);
      this.z = false;
      boolean bool = this.U;
      this.U = true;
      this.d = this.b.getCount();
      if (this.j >= 0) {
        this.b.restoreState(this.k, this.l);
        a(this.j, false, true);
        this.j = -1;
        this.k = null;
        this.l = null;
      } else if (!bool) {
        c();
      } else {
        requestLayout();
      } 
    } 
    List<OnAdapterChangeListener> list = this.ae;
    if (list != null && !list.isEmpty()) {
      int j = this.ae.size();
      for (int i = b; i < j; i++)
        ((OnAdapterChangeListener)this.ae.get(i)).onAdapterChanged(this, pagerAdapter, paramPagerAdapter); 
    } 
  }
  
  public void setCurrentItem(int paramInt) {
    this.z = false;
    a(paramInt, this.U ^ true, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean) {
    this.z = false;
    a(paramInt, paramBoolean, false);
  }
  
  public void setOffscreenPageLimit(int paramInt) {
    int i = paramInt;
    if (paramInt < 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Requested offscreen page limit ");
      stringBuilder.append(paramInt);
      stringBuilder.append(" too small; defaulting to ");
      stringBuilder.append(1);
      Log.w("ViewPager", stringBuilder.toString());
      i = 1;
    } 
    if (i != this.A) {
      this.A = i;
      c();
    } 
  }
  
  @Deprecated
  public void setOnPageChangeListener(OnPageChangeListener paramOnPageChangeListener) {
    this.ac = paramOnPageChangeListener;
  }
  
  public void setPageMargin(int paramInt) {
    int i = this.p;
    this.p = paramInt;
    int j = getWidth();
    a(j, j, paramInt, i);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt) {
    setPageMarginDrawable(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable) {
    boolean bool;
    this.q = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState(); 
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    } 
    setWillNotDraw(bool);
    invalidate();
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer) {
    setPageTransformer(paramBoolean, paramPageTransformer, 2);
  }
  
  public void setPageTransformer(boolean paramBoolean, PageTransformer paramPageTransformer, int paramInt) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    byte b = 1;
    if (paramPageTransformer != null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (this.af != null) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    if (bool2 != bool3) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.af = paramPageTransformer;
    setChildrenDrawingOrderEnabled(bool2);
    if (bool2) {
      if (paramBoolean)
        b = 2; 
      this.ah = b;
      this.ag = paramInt;
    } else {
      this.ah = 0;
    } 
    if (bool1)
      c(); 
  }
  
  void setScrollState(int paramInt) {
    if (this.al == paramInt)
      return; 
    this.al = paramInt;
    if (this.af != null) {
      boolean bool;
      if (paramInt != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      b(bool);
    } 
    e(paramInt);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.q);
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.TYPE})
  public static @interface DecorView {}
  
  static class ItemInfo {
    Object a;
    
    int b;
    
    boolean c;
    
    float d;
    
    float e;
  }
  
  public static class LayoutParams extends ViewGroup.LayoutParams {
    float a = 0.0F;
    
    boolean b;
    
    int c;
    
    int d;
    
    public int gravity;
    
    public boolean isDecor;
    
    public LayoutParams() {
      super(-1, -1);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, ViewPager.a);
      this.gravity = typedArray.getInteger(0, 48);
      typedArray.recycle();
    }
  }
  
  class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
    MyAccessibilityDelegate(ViewPager this$0) {}
    
    private boolean b() {
      return (this.a.b != null && this.a.b.getCount() > 1);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(ViewPager.class.getName());
      param1AccessibilityEvent.setScrollable(b());
      if (param1AccessibilityEvent.getEventType() == 4096 && this.a.b != null) {
        param1AccessibilityEvent.setItemCount(this.a.b.getCount());
        param1AccessibilityEvent.setFromIndex(this.a.c);
        param1AccessibilityEvent.setToIndex(this.a.c);
      } 
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      param1AccessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
      param1AccessibilityNodeInfoCompat.setScrollable(b());
      if (this.a.canScrollHorizontally(1))
        param1AccessibilityNodeInfoCompat.addAction(4096); 
      if (this.a.canScrollHorizontally(-1))
        param1AccessibilityNodeInfoCompat.addAction(8192); 
    }
    
    public boolean performAccessibilityAction(View param1View, int param1Int, Bundle param1Bundle) {
      if (super.performAccessibilityAction(param1View, param1Int, param1Bundle))
        return true; 
      if (param1Int != 4096) {
        if (param1Int != 8192)
          return false; 
        if (this.a.canScrollHorizontally(-1)) {
          ViewPager viewPager = this.a;
          viewPager.setCurrentItem(viewPager.c - 1);
          return true;
        } 
        return false;
      } 
      if (this.a.canScrollHorizontally(1)) {
        ViewPager viewPager = this.a;
        viewPager.setCurrentItem(viewPager.c + 1);
        return true;
      } 
      return false;
    }
  }
  
  public static interface OnAdapterChangeListener {
    void onAdapterChanged(ViewPager param1ViewPager, PagerAdapter param1PagerAdapter1, PagerAdapter param1PagerAdapter2);
  }
  
  public static interface OnPageChangeListener {
    void onPageScrollStateChanged(int param1Int);
    
    void onPageScrolled(int param1Int1, float param1Float, int param1Int2);
    
    void onPageSelected(int param1Int);
  }
  
  public static interface PageTransformer {
    void transformPage(View param1View, float param1Float);
  }
  
  class PagerObserver extends DataSetObserver {
    PagerObserver(ViewPager this$0) {}
    
    public void onChanged() {
      this.a.b();
    }
    
    public void onInvalidated() {
      this.a.b();
    }
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public ViewPager.SavedState createFromParcel(Parcel param2Parcel) {
          return new ViewPager.SavedState(param2Parcel, null);
        }
        
        public ViewPager.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new ViewPager.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public ViewPager.SavedState[] newArray(int param2Int) {
          return new ViewPager.SavedState[param2Int];
        }
      };
    
    int a;
    
    Parcelable b;
    
    ClassLoader c;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      ClassLoader classLoader = param1ClassLoader;
      if (param1ClassLoader == null)
        classLoader = getClass().getClassLoader(); 
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readParcelable(classLoader);
      this.c = classLoader;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("FragmentPager.SavedState{");
      stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      stringBuilder.append(" position=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeParcelable(this.b, param1Int);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public ViewPager.SavedState createFromParcel(Parcel param1Parcel) {
      return new ViewPager.SavedState(param1Parcel, null);
    }
    
    public ViewPager.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new ViewPager.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public ViewPager.SavedState[] newArray(int param1Int) {
      return new ViewPager.SavedState[param1Int];
    }
  }
  
  public static class SimpleOnPageChangeListener implements OnPageChangeListener {
    public void onPageScrollStateChanged(int param1Int) {}
    
    public void onPageScrolled(int param1Int1, float param1Float, int param1Int2) {}
    
    public void onPageSelected(int param1Int) {}
  }
  
  static class ViewPositionComparator implements Comparator<View> {
    public int compare(View param1View1, View param1View2) {
      ViewPager.LayoutParams layoutParams1 = (ViewPager.LayoutParams)param1View1.getLayoutParams();
      ViewPager.LayoutParams layoutParams2 = (ViewPager.LayoutParams)param1View2.getLayoutParams();
      return (layoutParams1.isDecor != layoutParams2.isDecor) ? (layoutParams1.isDecor ? 1 : -1) : (layoutParams1.c - layoutParams2.c);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager\widget\ViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */