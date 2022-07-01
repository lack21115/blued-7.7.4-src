package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  
  public static final int LOCK_MODE_UNDEFINED = 3;
  
  public static final int LOCK_MODE_UNLOCKED = 0;
  
  public static final int STATE_DRAGGING = 1;
  
  public static final int STATE_IDLE = 0;
  
  public static final int STATE_SETTLING = 2;
  
  static final int[] a;
  
  static final boolean b;
  
  private static final int[] c = new int[] { 16843828 };
  
  private static final boolean d;
  
  private float A;
  
  private Drawable B;
  
  private Drawable C;
  
  private Drawable D;
  
  private CharSequence E;
  
  private CharSequence F;
  
  private Object G;
  
  private boolean H;
  
  private Drawable I = null;
  
  private Drawable J = null;
  
  private Drawable K = null;
  
  private Drawable L = null;
  
  private final ArrayList<View> M;
  
  private Rect N;
  
  private Matrix O;
  
  private final ChildAccessibilityDelegate e = new ChildAccessibilityDelegate();
  
  private float f;
  
  private int g;
  
  private int h = -1728053248;
  
  private float i;
  
  private Paint j = new Paint();
  
  private final ViewDragHelper k;
  
  private final ViewDragHelper l;
  
  private final ViewDragCallback m;
  
  private final ViewDragCallback n;
  
  private int o;
  
  private boolean p;
  
  private boolean q = true;
  
  private int r = 3;
  
  private int s = 3;
  
  private int t = 3;
  
  private int u = 3;
  
  private boolean v;
  
  private boolean w;
  
  private DrawerListener x;
  
  private List<DrawerListener> y;
  
  private float z;
  
  static {
    a = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    b = bool1;
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    d = bool1;
  }
  
  public DrawerLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = (getResources().getDisplayMetrics()).density;
    this.g = (int)(64.0F * f1 + 0.5F);
    float f2 = 400.0F * f1;
    this.m = new ViewDragCallback(this, 3);
    this.n = new ViewDragCallback(this, 5);
    this.k = ViewDragHelper.create(this, 1.0F, this.m);
    this.k.setEdgeTrackingEnabled(1);
    this.k.setMinVelocity(f2);
    this.m.setDragger(this.k);
    this.l = ViewDragHelper.create(this, 1.0F, this.n);
    this.l.setEdgeTrackingEnabled(2);
    this.l.setMinVelocity(f2);
    this.n.setDragger(this.l);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility((View)this, 1);
    ViewCompat.setAccessibilityDelegate((View)this, new AccessibilityDelegate(this));
    setMotionEventSplittingEnabled(false);
    if (ViewCompat.getFitsSystemWindows((View)this))
      if (Build.VERSION.SDK_INT >= 21) {
        setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) {
              public WindowInsets onApplyWindowInsets(View param1View, WindowInsets param1WindowInsets) {
                boolean bool;
                DrawerLayout drawerLayout = (DrawerLayout)param1View;
                if (param1WindowInsets.getSystemWindowInsetTop() > 0) {
                  bool = true;
                } else {
                  bool = false;
                } 
                drawerLayout.setChildInsets(param1WindowInsets, bool);
                return param1WindowInsets.consumeSystemWindowInsets();
              }
            });
        setSystemUiVisibility(1280);
        TypedArray typedArray = paramContext.obtainStyledAttributes(c);
        try {
          this.B = typedArray.getDrawable(0);
        } finally {
          typedArray.recycle();
        } 
      } else {
        this.B = null;
      }  
    this.f = f1 * 10.0F;
    this.M = new ArrayList<View>();
  }
  
  private void a(View paramView, boolean paramBoolean) {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if ((!paramBoolean && !f(view)) || (paramBoolean && view == paramView)) {
        ViewCompat.setImportantForAccessibility(view, 1);
      } else {
        ViewCompat.setImportantForAccessibility(view, 4);
      } 
    } 
  }
  
  private boolean a(float paramFloat1, float paramFloat2, View paramView) {
    if (this.N == null)
      this.N = new Rect(); 
    paramView.getHitRect(this.N);
    return this.N.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  private boolean a(Drawable paramDrawable, int paramInt) {
    if (paramDrawable == null || !DrawableCompat.isAutoMirrored(paramDrawable))
      return false; 
    DrawableCompat.setLayoutDirection(paramDrawable, paramInt);
    return true;
  }
  
  private boolean a(MotionEvent paramMotionEvent, View paramView) {
    if (!paramView.getMatrix().isIdentity()) {
      paramMotionEvent = b(paramMotionEvent, paramView);
      boolean bool1 = paramView.dispatchGenericMotionEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      return bool1;
    } 
    float f1 = (getScrollX() - paramView.getLeft());
    float f2 = (getScrollY() - paramView.getTop());
    paramMotionEvent.offsetLocation(f1, f2);
    boolean bool = paramView.dispatchGenericMotionEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-f1, -f2);
    return bool;
  }
  
  private MotionEvent b(MotionEvent paramMotionEvent, View paramView) {
    float f1 = (getScrollX() - paramView.getLeft());
    float f2 = (getScrollY() - paramView.getTop());
    paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
    paramMotionEvent.offsetLocation(f1, f2);
    Matrix matrix = paramView.getMatrix();
    if (!matrix.isIdentity()) {
      if (this.O == null)
        this.O = new Matrix(); 
      matrix.invert(this.O);
      paramMotionEvent.transform(this.O);
    } 
    return paramMotionEvent;
  }
  
  static String b(int paramInt) {
    return ((paramInt & 0x3) == 3) ? "LEFT" : (((paramInt & 0x5) == 5) ? "RIGHT" : Integer.toHexString(paramInt));
  }
  
  private void d() {
    if (d)
      return; 
    this.C = e();
    this.D = f();
  }
  
  private Drawable e() {
    int i = ViewCompat.getLayoutDirection((View)this);
    if (i == 0) {
      Drawable drawable = this.I;
      if (drawable != null) {
        a(drawable, i);
        return this.I;
      } 
    } else {
      Drawable drawable = this.J;
      if (drawable != null) {
        a(drawable, i);
        return this.J;
      } 
    } 
    return this.K;
  }
  
  private Drawable f() {
    int i = ViewCompat.getLayoutDirection((View)this);
    if (i == 0) {
      Drawable drawable = this.J;
      if (drawable != null) {
        a(drawable, i);
        return this.J;
      } 
    } else {
      Drawable drawable = this.I;
      if (drawable != null) {
        a(drawable, i);
        return this.I;
      } 
    } 
    return this.L;
  }
  
  private boolean g() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      if (((LayoutParams)getChildAt(i).getLayoutParams()).b)
        return true; 
    } 
    return false;
  }
  
  static boolean g(View paramView) {
    return (ViewCompat.getImportantForAccessibility(paramView) != 4 && ViewCompat.getImportantForAccessibility(paramView) != 2);
  }
  
  private boolean h() {
    return (b() != null);
  }
  
  private static boolean h(View paramView) {
    Drawable drawable = paramView.getBackground();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (drawable != null) {
      bool1 = bool2;
      if (drawable.getOpacity() == -1)
        bool1 = true; 
    } 
    return bool1;
  }
  
  View a() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if ((((LayoutParams)view.getLayoutParams()).c & 0x1) == 1)
        return view; 
    } 
    return null;
  }
  
  View a(int paramInt) {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    int j = getChildCount();
    for (paramInt = 0; paramInt < j; paramInt++) {
      View view = getChildAt(paramInt);
      if ((d(view) & 0x7) == (i & 0x7))
        return view; 
    } 
    return null;
  }
  
  void a(int paramInt1, int paramInt2, View paramView) {
    int i = this.k.getViewDragState();
    int j = this.l.getViewDragState();
    byte b = 2;
    if (i == 1 || j == 1) {
      paramInt1 = 1;
    } else {
      paramInt1 = b;
      if (i != 2)
        if (j == 2) {
          paramInt1 = b;
        } else {
          paramInt1 = 0;
        }  
    } 
    if (paramView != null && paramInt2 == 0) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      if (layoutParams.a == 0.0F) {
        a(paramView);
      } else if (layoutParams.a == 1.0F) {
        b(paramView);
      } 
    } 
    if (paramInt1 != this.o) {
      this.o = paramInt1;
      List<DrawerListener> list = this.y;
      if (list != null)
        for (paramInt2 = list.size() - 1; paramInt2 >= 0; paramInt2--)
          ((DrawerListener)this.y.get(paramInt2)).onDrawerStateChanged(paramInt1);  
    } 
  }
  
  void a(View paramView) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((layoutParams.c & 0x1) == 1) {
      layoutParams.c = 0;
      List<DrawerListener> list = this.y;
      if (list != null)
        for (int i = list.size() - 1; i >= 0; i--)
          ((DrawerListener)this.y.get(i)).onDrawerClosed(paramView);  
      a(paramView, false);
      if (hasWindowFocus()) {
        paramView = getRootView();
        if (paramView != null)
          paramView.sendAccessibilityEvent(32); 
      } 
    } 
  }
  
  void a(View paramView, float paramFloat) {
    List<DrawerListener> list = this.y;
    if (list != null)
      for (int i = list.size() - 1; i >= 0; i--)
        ((DrawerListener)this.y.get(i)).onDrawerSlide(paramView, paramFloat);  
  }
  
  void a(boolean paramBoolean) {
    int j;
    int m = getChildCount();
    int i = 0;
    int k = 0;
    while (i < m) {
      int n;
      View view = getChildAt(i);
      LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
      int i1 = k;
      if (f(view))
        if (paramBoolean && !layoutParams.b) {
          i1 = k;
        } else {
          int i2;
          i1 = view.getWidth();
          if (a(view, 3)) {
            i2 = this.k.smoothSlideViewTo(view, -i1, view.getTop());
          } else {
            i2 = this.l.smoothSlideViewTo(view, getWidth(), view.getTop());
          } 
          n = k | i2;
          layoutParams.b = false;
        }  
      i++;
      j = n;
    } 
    this.m.removeCallbacks();
    this.n.removeCallbacks();
    if (j != 0)
      invalidate(); 
  }
  
  boolean a(View paramView, int paramInt) {
    return ((d(paramView) & paramInt) == paramInt);
  }
  
  public void addDrawerListener(DrawerListener paramDrawerListener) {
    if (paramDrawerListener == null)
      return; 
    if (this.y == null)
      this.y = new ArrayList<DrawerListener>(); 
    this.y.add(paramDrawerListener);
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    if (getDescendantFocusability() == 393216)
      return; 
    int k = getChildCount();
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < k) {
      View view = getChildAt(i);
      if (f(view)) {
        if (isDrawerOpen(view)) {
          view.addFocusables(paramArrayList, paramInt1, paramInt2);
          j = 1;
        } 
      } else {
        this.M.add(view);
      } 
      i++;
    } 
    if (!j) {
      j = this.M.size();
      for (i = bool; i < j; i++) {
        View view = this.M.get(i);
        if (view.getVisibility() == 0)
          view.addFocusables(paramArrayList, paramInt1, paramInt2); 
      } 
    } 
    this.M.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (a() != null || f(paramView)) {
      ViewCompat.setImportantForAccessibility(paramView, 4);
    } else {
      ViewCompat.setImportantForAccessibility(paramView, 1);
    } 
    if (!b)
      ViewCompat.setAccessibilityDelegate(paramView, this.e); 
  }
  
  View b() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (f(view) && isDrawerVisible(view))
        return view; 
    } 
    return null;
  }
  
  void b(View paramView) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((layoutParams.c & 0x1) == 0) {
      layoutParams.c = 1;
      List<DrawerListener> list = this.y;
      if (list != null)
        for (int i = list.size() - 1; i >= 0; i--)
          ((DrawerListener)this.y.get(i)).onDrawerOpened(paramView);  
      a(paramView, true);
      if (hasWindowFocus())
        sendAccessibilityEvent(32); 
    } 
  }
  
  void b(View paramView, float paramFloat) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == layoutParams.a)
      return; 
    layoutParams.a = paramFloat;
    a(paramView, paramFloat);
  }
  
  float c(View paramView) {
    return ((LayoutParams)paramView.getLayoutParams()).a;
  }
  
  void c() {
    if (!this.w) {
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      for (int i = 0; i < j; i++)
        getChildAt(i).dispatchTouchEvent(motionEvent); 
      motionEvent.recycle();
      this.w = true;
    } 
  }
  
  void c(View paramView, float paramFloat) {
    float f1 = c(paramView);
    float f2 = paramView.getWidth();
    int i = (int)(f1 * f2);
    i = (int)(f2 * paramFloat) - i;
    if (!a(paramView, 3))
      i = -i; 
    paramView.offsetLeftAndRight(i);
    b(paramView, paramFloat);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && super.checkLayoutParams(paramLayoutParams));
  }
  
  public void closeDrawer(int paramInt) {
    closeDrawer(paramInt, true);
  }
  
  public void closeDrawer(int paramInt, boolean paramBoolean) {
    View view = a(paramInt);
    if (view != null) {
      closeDrawer(view, paramBoolean);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No drawer view found with gravity ");
    stringBuilder.append(b(paramInt));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void closeDrawer(View paramView) {
    closeDrawer(paramView, true);
  }
  
  public void closeDrawer(View paramView, boolean paramBoolean) {
    if (f(paramView)) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      if (this.q) {
        layoutParams.a = 0.0F;
        layoutParams.c = 0;
      } else if (paramBoolean) {
        layoutParams.c |= 0x4;
        if (a(paramView, 3)) {
          this.k.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        } else {
          this.l.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
        } 
      } else {
        c(paramView, 0.0F);
        a(layoutParams.gravity, 0, paramView);
        paramView.setVisibility(4);
      } 
      invalidate();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a sliding drawer");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void closeDrawers() {
    a(false);
  }
  
  public void computeScroll() {
    int j = getChildCount();
    float f = 0.0F;
    for (int i = 0; i < j; i++)
      f = Math.max(f, ((LayoutParams)getChildAt(i).getLayoutParams()).a); 
    this.i = f;
    boolean bool1 = this.k.continueSettling(true);
    boolean bool2 = this.l.continueSettling(true);
    if (bool1 || bool2)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  int d(View paramView) {
    return GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection((View)this));
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent) {
    if ((paramMotionEvent.getSource() & 0x2) == 0 || paramMotionEvent.getAction() == 10 || this.i <= 0.0F)
      return super.dispatchGenericMotionEvent(paramMotionEvent); 
    int i = getChildCount();
    if (i != 0) {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      while (--i >= 0) {
        View view = getChildAt(i);
        if (a(f1, f2, view) && !e(view) && a(paramMotionEvent, view))
          return true; 
        i--;
      } 
    } 
    return false;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    int m = getHeight();
    boolean bool1 = e(paramView);
    int i = getWidth();
    int k = paramCanvas.save();
    int j = 0;
    if (bool1) {
      int i1 = getChildCount();
      int n = 0;
      j = 0;
      while (n < i1) {
        View view = getChildAt(n);
        int i2 = j;
        int i3 = i;
        if (view != paramView) {
          i2 = j;
          i3 = i;
          if (view.getVisibility() == 0) {
            i2 = j;
            i3 = i;
            if (h(view)) {
              i2 = j;
              i3 = i;
              if (f(view))
                if (view.getHeight() < m) {
                  i2 = j;
                  i3 = i;
                } else if (a(view, 3)) {
                  int i4 = view.getRight();
                  i2 = j;
                  i3 = i;
                  if (i4 > j) {
                    i2 = i4;
                    i3 = i;
                  } 
                } else {
                  int i4 = view.getLeft();
                  i2 = j;
                  i3 = i;
                  if (i4 < i) {
                    i3 = i4;
                    i2 = j;
                  } 
                }  
            } 
          } 
        } 
        n++;
        j = i2;
        i = i3;
      } 
      paramCanvas.clipRect(j, 0, i, getHeight());
    } 
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(k);
    float f = this.i;
    if (f > 0.0F && bool1) {
      int n = this.h;
      int i1 = (int)(((0xFF000000 & n) >>> 24) * f);
      this.j.setColor(n & 0xFFFFFF | i1 << 24);
      paramCanvas.drawRect(j, 0.0F, i, getHeight(), this.j);
      return bool2;
    } 
    if (this.C != null && a(paramView, 3)) {
      i = this.C.getIntrinsicWidth();
      j = paramView.getRight();
      int n = this.k.getEdgeSize();
      f = Math.max(0.0F, Math.min(j / n, 1.0F));
      this.C.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
      this.C.setAlpha((int)(f * 255.0F));
      this.C.draw(paramCanvas);
      return bool2;
    } 
    if (this.D != null && a(paramView, 5)) {
      i = this.D.getIntrinsicWidth();
      j = paramView.getLeft();
      int n = getWidth();
      int i1 = this.l.getEdgeSize();
      f = Math.max(0.0F, Math.min((n - j) / i1, 1.0F));
      this.D.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.D.setAlpha((int)(f * 255.0F));
      this.D.draw(paramCanvas);
    } 
    return bool2;
  }
  
  boolean e(View paramView) {
    return (((LayoutParams)paramView.getLayoutParams()).gravity == 0);
  }
  
  boolean f(View paramView) {
    int i = GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView));
    return ((i & 0x3) != 0) ? true : (((i & 0x5) != 0));
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    return (ViewGroup.LayoutParams)new LayoutParams(-1, -1);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return (ViewGroup.LayoutParams)new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)((paramLayoutParams instanceof LayoutParams) ? new LayoutParams((LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams)));
  }
  
  public float getDrawerElevation() {
    return d ? this.f : 0.0F;
  }
  
  public int getDrawerLockMode(int paramInt) {
    int i = ViewCompat.getLayoutDirection((View)this);
    if (paramInt != 3) {
      if (paramInt != 5) {
        if (paramInt != 8388611) {
          if (paramInt == 8388613) {
            paramInt = this.u;
            if (paramInt != 3)
              return paramInt; 
            if (i == 0) {
              paramInt = this.s;
            } else {
              paramInt = this.r;
            } 
            if (paramInt != 3)
              return paramInt; 
          } 
        } else {
          paramInt = this.t;
          if (paramInt != 3)
            return paramInt; 
          if (i == 0) {
            paramInt = this.r;
          } else {
            paramInt = this.s;
          } 
          if (paramInt != 3)
            return paramInt; 
        } 
      } else {
        paramInt = this.s;
        if (paramInt != 3)
          return paramInt; 
        if (i == 0) {
          paramInt = this.u;
        } else {
          paramInt = this.t;
        } 
        if (paramInt != 3)
          return paramInt; 
      } 
    } else {
      paramInt = this.r;
      if (paramInt != 3)
        return paramInt; 
      if (i == 0) {
        paramInt = this.t;
      } else {
        paramInt = this.u;
      } 
      if (paramInt != 3)
        return paramInt; 
    } 
    return 0;
  }
  
  public int getDrawerLockMode(View paramView) {
    if (f(paramView))
      return getDrawerLockMode(((LayoutParams)paramView.getLayoutParams()).gravity); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public CharSequence getDrawerTitle(int paramInt) {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    return (paramInt == 3) ? this.E : ((paramInt == 5) ? this.F : null);
  }
  
  public Drawable getStatusBarBackgroundDrawable() {
    return this.B;
  }
  
  public boolean isDrawerOpen(int paramInt) {
    View view = a(paramInt);
    return (view != null) ? isDrawerOpen(view) : false;
  }
  
  public boolean isDrawerOpen(View paramView) {
    if (f(paramView))
      return ((((LayoutParams)paramView.getLayoutParams()).c & 0x1) == 1); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean isDrawerVisible(int paramInt) {
    View view = a(paramInt);
    return (view != null) ? isDrawerVisible(view) : false;
  }
  
  public boolean isDrawerVisible(View paramView) {
    if (f(paramView))
      return (((LayoutParams)paramView.getLayoutParams()).a > 0.0F); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.q = true;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.q = true;
  }
  
  public void onDraw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onDraw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: getfield H : Z
    //   9: ifeq -> 75
    //   12: aload_0
    //   13: getfield B : Landroid/graphics/drawable/Drawable;
    //   16: ifnull -> 75
    //   19: getstatic android/os/Build$VERSION.SDK_INT : I
    //   22: bipush #21
    //   24: if_icmplt -> 47
    //   27: aload_0
    //   28: getfield G : Ljava/lang/Object;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull -> 47
    //   36: aload_3
    //   37: checkcast android/view/WindowInsets
    //   40: invokevirtual getSystemWindowInsetTop : ()I
    //   43: istore_2
    //   44: goto -> 49
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_2
    //   50: ifle -> 75
    //   53: aload_0
    //   54: getfield B : Landroid/graphics/drawable/Drawable;
    //   57: iconst_0
    //   58: iconst_0
    //   59: aload_0
    //   60: invokevirtual getWidth : ()I
    //   63: iload_2
    //   64: invokevirtual setBounds : (IIII)V
    //   67: aload_0
    //   68: getfield B : Landroid/graphics/drawable/Drawable;
    //   71: aload_1
    //   72: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   75: return
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #4
    //   6: aload_0
    //   7: getfield k : Landroidx/customview/widget/ViewDragHelper;
    //   10: aload_1
    //   11: invokevirtual shouldInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   14: istore #7
    //   16: aload_0
    //   17: getfield l : Landroidx/customview/widget/ViewDragHelper;
    //   20: aload_1
    //   21: invokevirtual shouldInterceptTouchEvent : (Landroid/view/MotionEvent;)Z
    //   24: istore #8
    //   26: iconst_1
    //   27: istore #6
    //   29: iload #4
    //   31: ifeq -> 104
    //   34: iload #4
    //   36: iconst_1
    //   37: if_icmpeq -> 83
    //   40: iload #4
    //   42: iconst_2
    //   43: if_icmpeq -> 55
    //   46: iload #4
    //   48: iconst_3
    //   49: if_icmpeq -> 83
    //   52: goto -> 98
    //   55: aload_0
    //   56: getfield k : Landroidx/customview/widget/ViewDragHelper;
    //   59: iconst_3
    //   60: invokevirtual checkTouchSlop : (I)Z
    //   63: ifeq -> 98
    //   66: aload_0
    //   67: getfield m : Landroidx/drawerlayout/widget/DrawerLayout$ViewDragCallback;
    //   70: invokevirtual removeCallbacks : ()V
    //   73: aload_0
    //   74: getfield n : Landroidx/drawerlayout/widget/DrawerLayout$ViewDragCallback;
    //   77: invokevirtual removeCallbacks : ()V
    //   80: goto -> 98
    //   83: aload_0
    //   84: iconst_1
    //   85: invokevirtual a : (Z)V
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield v : Z
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield w : Z
    //   98: iconst_0
    //   99: istore #4
    //   101: goto -> 176
    //   104: aload_1
    //   105: invokevirtual getX : ()F
    //   108: fstore_2
    //   109: aload_1
    //   110: invokevirtual getY : ()F
    //   113: fstore_3
    //   114: aload_0
    //   115: fload_2
    //   116: putfield z : F
    //   119: aload_0
    //   120: fload_3
    //   121: putfield A : F
    //   124: aload_0
    //   125: getfield i : F
    //   128: fconst_0
    //   129: fcmpl
    //   130: ifle -> 163
    //   133: aload_0
    //   134: getfield k : Landroidx/customview/widget/ViewDragHelper;
    //   137: fload_2
    //   138: f2i
    //   139: fload_3
    //   140: f2i
    //   141: invokevirtual findTopChildUnder : (II)Landroid/view/View;
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -> 163
    //   149: aload_0
    //   150: aload_1
    //   151: invokevirtual e : (Landroid/view/View;)Z
    //   154: ifeq -> 163
    //   157: iconst_1
    //   158: istore #4
    //   160: goto -> 166
    //   163: iconst_0
    //   164: istore #4
    //   166: aload_0
    //   167: iconst_0
    //   168: putfield v : Z
    //   171: aload_0
    //   172: iconst_0
    //   173: putfield w : Z
    //   176: iload #6
    //   178: istore #5
    //   180: iload #7
    //   182: iload #8
    //   184: ior
    //   185: ifne -> 220
    //   188: iload #6
    //   190: istore #5
    //   192: iload #4
    //   194: ifne -> 220
    //   197: iload #6
    //   199: istore #5
    //   201: aload_0
    //   202: invokespecial g : ()Z
    //   205: ifne -> 220
    //   208: aload_0
    //   209: getfield w : Z
    //   212: ifeq -> 217
    //   215: iconst_1
    //   216: ireturn
    //   217: iconst_0
    //   218: istore #5
    //   220: iload #5
    //   222: ireturn
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4 && h()) {
      paramKeyEvent.startTracking();
      return true;
    } 
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    View view;
    if (paramInt == 4) {
      view = b();
      if (view != null && getDrawerLockMode(view) == 0)
        closeDrawers(); 
      return (view != null);
    } 
    return super.onKeyUp(paramInt, (KeyEvent)view);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.p = true;
    int i = paramInt3 - paramInt1;
    int j = getChildCount();
    for (paramInt3 = 0; paramInt3 < j; paramInt3++) {
      View view = getChildAt(paramInt3);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        if (e(view)) {
          view.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + view.getMeasuredWidth(), layoutParams.topMargin + view.getMeasuredHeight());
        } else {
          float f;
          int k;
          boolean bool;
          int m = view.getMeasuredWidth();
          int n = view.getMeasuredHeight();
          if (a(view, 3)) {
            paramInt1 = -m;
            f = m;
            k = paramInt1 + (int)(layoutParams.a * f);
            f = (m + k) / f;
          } else {
            f = m;
            k = i - (int)(layoutParams.a * f);
            f = (i - k) / f;
          } 
          if (f != layoutParams.a) {
            bool = true;
          } else {
            bool = false;
          } 
          paramInt1 = layoutParams.gravity & 0x70;
          if (paramInt1 != 16) {
            if (paramInt1 != 80) {
              view.layout(k, layoutParams.topMargin, m + k, layoutParams.topMargin + n);
            } else {
              paramInt1 = paramInt4 - paramInt2;
              view.layout(k, paramInt1 - layoutParams.bottomMargin - view.getMeasuredHeight(), m + k, paramInt1 - layoutParams.bottomMargin);
            } 
          } else {
            int i2 = paramInt4 - paramInt2;
            int i1 = (i2 - n) / 2;
            if (i1 < layoutParams.topMargin) {
              paramInt1 = layoutParams.topMargin;
            } else {
              paramInt1 = i1;
              if (i1 + n > i2 - layoutParams.bottomMargin)
                paramInt1 = i2 - layoutParams.bottomMargin - n; 
            } 
            view.layout(k, paramInt1, m + k, n + paramInt1);
          } 
          if (bool)
            b(view, f); 
          if (layoutParams.a > 0.0F) {
            paramInt1 = 0;
          } else {
            paramInt1 = 4;
          } 
          if (view.getVisibility() != paramInt1)
            view.setVisibility(paramInt1); 
        } 
      } 
    } 
    this.p = false;
    this.q = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iload_1
    //   1: invokestatic getMode : (I)I
    //   4: istore #10
    //   6: iload_2
    //   7: invokestatic getMode : (I)I
    //   10: istore #9
    //   12: iload_1
    //   13: invokestatic getSize : (I)I
    //   16: istore #5
    //   18: iload_2
    //   19: invokestatic getSize : (I)I
    //   22: istore #6
    //   24: iload #10
    //   26: ldc_w 1073741824
    //   29: if_icmpne -> 48
    //   32: iload #5
    //   34: istore #7
    //   36: iload #6
    //   38: istore #8
    //   40: iload #9
    //   42: ldc_w 1073741824
    //   45: if_icmpeq -> 117
    //   48: aload_0
    //   49: invokevirtual isInEditMode : ()Z
    //   52: ifeq -> 820
    //   55: iload #10
    //   57: ldc_w -2147483648
    //   60: if_icmpne -> 66
    //   63: goto -> 76
    //   66: iload #10
    //   68: ifne -> 76
    //   71: sipush #300
    //   74: istore #5
    //   76: iload #9
    //   78: ldc_w -2147483648
    //   81: if_icmpne -> 95
    //   84: iload #5
    //   86: istore #7
    //   88: iload #6
    //   90: istore #8
    //   92: goto -> 117
    //   95: iload #5
    //   97: istore #7
    //   99: iload #6
    //   101: istore #8
    //   103: iload #9
    //   105: ifne -> 117
    //   108: sipush #300
    //   111: istore #8
    //   113: iload #5
    //   115: istore #7
    //   117: aload_0
    //   118: iload #7
    //   120: iload #8
    //   122: invokevirtual setMeasuredDimension : (II)V
    //   125: aload_0
    //   126: getfield G : Ljava/lang/Object;
    //   129: ifnull -> 145
    //   132: aload_0
    //   133: invokestatic getFitsSystemWindows : (Landroid/view/View;)Z
    //   136: ifeq -> 145
    //   139: iconst_1
    //   140: istore #9
    //   142: goto -> 148
    //   145: iconst_0
    //   146: istore #9
    //   148: aload_0
    //   149: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   152: istore #12
    //   154: aload_0
    //   155: invokevirtual getChildCount : ()I
    //   158: istore #13
    //   160: iconst_0
    //   161: istore #10
    //   163: iconst_0
    //   164: istore #6
    //   166: iconst_0
    //   167: istore #5
    //   169: iload #10
    //   171: iload #13
    //   173: if_icmpge -> 819
    //   176: aload_0
    //   177: iload #10
    //   179: invokevirtual getChildAt : (I)Landroid/view/View;
    //   182: astore #17
    //   184: aload #17
    //   186: invokevirtual getVisibility : ()I
    //   189: bipush #8
    //   191: if_icmpne -> 197
    //   194: goto -> 501
    //   197: aload #17
    //   199: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   202: checkcast androidx/drawerlayout/widget/DrawerLayout$LayoutParams
    //   205: astore #18
    //   207: iload #9
    //   209: ifeq -> 447
    //   212: aload #18
    //   214: getfield gravity : I
    //   217: iload #12
    //   219: invokestatic getAbsoluteGravity : (II)I
    //   222: istore #11
    //   224: aload #17
    //   226: invokestatic getFitsSystemWindows : (Landroid/view/View;)Z
    //   229: ifeq -> 325
    //   232: getstatic android/os/Build$VERSION.SDK_INT : I
    //   235: bipush #21
    //   237: if_icmplt -> 447
    //   240: aload_0
    //   241: getfield G : Ljava/lang/Object;
    //   244: checkcast android/view/WindowInsets
    //   247: astore #16
    //   249: iload #11
    //   251: iconst_3
    //   252: if_icmpne -> 281
    //   255: aload #16
    //   257: aload #16
    //   259: invokevirtual getSystemWindowInsetLeft : ()I
    //   262: aload #16
    //   264: invokevirtual getSystemWindowInsetTop : ()I
    //   267: iconst_0
    //   268: aload #16
    //   270: invokevirtual getSystemWindowInsetBottom : ()I
    //   273: invokevirtual replaceSystemWindowInsets : (IIII)Landroid/view/WindowInsets;
    //   276: astore #15
    //   278: goto -> 314
    //   281: aload #16
    //   283: astore #15
    //   285: iload #11
    //   287: iconst_5
    //   288: if_icmpne -> 314
    //   291: aload #16
    //   293: iconst_0
    //   294: aload #16
    //   296: invokevirtual getSystemWindowInsetTop : ()I
    //   299: aload #16
    //   301: invokevirtual getSystemWindowInsetRight : ()I
    //   304: aload #16
    //   306: invokevirtual getSystemWindowInsetBottom : ()I
    //   309: invokevirtual replaceSystemWindowInsets : (IIII)Landroid/view/WindowInsets;
    //   312: astore #15
    //   314: aload #17
    //   316: aload #15
    //   318: invokevirtual dispatchApplyWindowInsets : (Landroid/view/WindowInsets;)Landroid/view/WindowInsets;
    //   321: pop
    //   322: goto -> 447
    //   325: getstatic android/os/Build$VERSION.SDK_INT : I
    //   328: bipush #21
    //   330: if_icmplt -> 447
    //   333: aload_0
    //   334: getfield G : Ljava/lang/Object;
    //   337: checkcast android/view/WindowInsets
    //   340: astore #16
    //   342: iload #11
    //   344: iconst_3
    //   345: if_icmpne -> 374
    //   348: aload #16
    //   350: aload #16
    //   352: invokevirtual getSystemWindowInsetLeft : ()I
    //   355: aload #16
    //   357: invokevirtual getSystemWindowInsetTop : ()I
    //   360: iconst_0
    //   361: aload #16
    //   363: invokevirtual getSystemWindowInsetBottom : ()I
    //   366: invokevirtual replaceSystemWindowInsets : (IIII)Landroid/view/WindowInsets;
    //   369: astore #15
    //   371: goto -> 407
    //   374: aload #16
    //   376: astore #15
    //   378: iload #11
    //   380: iconst_5
    //   381: if_icmpne -> 407
    //   384: aload #16
    //   386: iconst_0
    //   387: aload #16
    //   389: invokevirtual getSystemWindowInsetTop : ()I
    //   392: aload #16
    //   394: invokevirtual getSystemWindowInsetRight : ()I
    //   397: aload #16
    //   399: invokevirtual getSystemWindowInsetBottom : ()I
    //   402: invokevirtual replaceSystemWindowInsets : (IIII)Landroid/view/WindowInsets;
    //   405: astore #15
    //   407: aload #18
    //   409: aload #15
    //   411: invokevirtual getSystemWindowInsetLeft : ()I
    //   414: putfield leftMargin : I
    //   417: aload #18
    //   419: aload #15
    //   421: invokevirtual getSystemWindowInsetTop : ()I
    //   424: putfield topMargin : I
    //   427: aload #18
    //   429: aload #15
    //   431: invokevirtual getSystemWindowInsetRight : ()I
    //   434: putfield rightMargin : I
    //   437: aload #18
    //   439: aload #15
    //   441: invokevirtual getSystemWindowInsetBottom : ()I
    //   444: putfield bottomMargin : I
    //   447: aload_0
    //   448: aload #17
    //   450: invokevirtual e : (Landroid/view/View;)Z
    //   453: ifeq -> 504
    //   456: aload #17
    //   458: iload #7
    //   460: aload #18
    //   462: getfield leftMargin : I
    //   465: isub
    //   466: aload #18
    //   468: getfield rightMargin : I
    //   471: isub
    //   472: ldc_w 1073741824
    //   475: invokestatic makeMeasureSpec : (II)I
    //   478: iload #8
    //   480: aload #18
    //   482: getfield topMargin : I
    //   485: isub
    //   486: aload #18
    //   488: getfield bottomMargin : I
    //   491: isub
    //   492: ldc_w 1073741824
    //   495: invokestatic makeMeasureSpec : (II)I
    //   498: invokevirtual measure : (II)V
    //   501: goto -> 736
    //   504: aload_0
    //   505: aload #17
    //   507: invokevirtual f : (Landroid/view/View;)Z
    //   510: ifeq -> 745
    //   513: getstatic androidx/drawerlayout/widget/DrawerLayout.d : Z
    //   516: ifeq -> 545
    //   519: aload #17
    //   521: invokestatic getElevation : (Landroid/view/View;)F
    //   524: fstore_3
    //   525: aload_0
    //   526: getfield f : F
    //   529: fstore #4
    //   531: fload_3
    //   532: fload #4
    //   534: fcmpl
    //   535: ifeq -> 545
    //   538: aload #17
    //   540: fload #4
    //   542: invokestatic setElevation : (Landroid/view/View;F)V
    //   545: aload_0
    //   546: aload #17
    //   548: invokevirtual d : (Landroid/view/View;)I
    //   551: bipush #7
    //   553: iand
    //   554: istore #14
    //   556: iload #14
    //   558: iconst_3
    //   559: if_icmpne -> 568
    //   562: iconst_1
    //   563: istore #11
    //   565: goto -> 571
    //   568: iconst_0
    //   569: istore #11
    //   571: iload #11
    //   573: ifeq -> 581
    //   576: iload #6
    //   578: ifne -> 594
    //   581: iload #11
    //   583: ifne -> 672
    //   586: iload #5
    //   588: ifne -> 594
    //   591: goto -> 672
    //   594: new java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial <init> : ()V
    //   601: astore #15
    //   603: aload #15
    //   605: ldc_w 'Child drawer has absolute gravity '
    //   608: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload #15
    //   614: iload #14
    //   616: invokestatic b : (I)Ljava/lang/String;
    //   619: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload #15
    //   625: ldc_w ' but this '
    //   628: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload #15
    //   634: ldc_w 'DrawerLayout'
    //   637: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload #15
    //   643: ldc_w ' already has a '
    //   646: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload #15
    //   652: ldc_w 'drawer view along that edge'
    //   655: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: new java/lang/IllegalStateException
    //   662: dup
    //   663: aload #15
    //   665: invokevirtual toString : ()Ljava/lang/String;
    //   668: invokespecial <init> : (Ljava/lang/String;)V
    //   671: athrow
    //   672: iload #11
    //   674: ifeq -> 683
    //   677: iconst_1
    //   678: istore #6
    //   680: goto -> 686
    //   683: iconst_1
    //   684: istore #5
    //   686: aload #17
    //   688: iload_1
    //   689: aload_0
    //   690: getfield g : I
    //   693: aload #18
    //   695: getfield leftMargin : I
    //   698: iadd
    //   699: aload #18
    //   701: getfield rightMargin : I
    //   704: iadd
    //   705: aload #18
    //   707: getfield width : I
    //   710: invokestatic getChildMeasureSpec : (III)I
    //   713: iload_2
    //   714: aload #18
    //   716: getfield topMargin : I
    //   719: aload #18
    //   721: getfield bottomMargin : I
    //   724: iadd
    //   725: aload #18
    //   727: getfield height : I
    //   730: invokestatic getChildMeasureSpec : (III)I
    //   733: invokevirtual measure : (II)V
    //   736: iload #10
    //   738: iconst_1
    //   739: iadd
    //   740: istore #10
    //   742: goto -> 169
    //   745: new java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial <init> : ()V
    //   752: astore #15
    //   754: aload #15
    //   756: ldc_w 'Child '
    //   759: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload #15
    //   765: aload #17
    //   767: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload #15
    //   773: ldc_w ' at index '
    //   776: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload #15
    //   782: iload #10
    //   784: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   787: pop
    //   788: aload #15
    //   790: ldc_w ' does not have a valid layout_gravity - must be Gravity.LEFT, '
    //   793: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload #15
    //   799: ldc_w 'Gravity.RIGHT or Gravity.NO_GRAVITY'
    //   802: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: new java/lang/IllegalStateException
    //   809: dup
    //   810: aload #15
    //   812: invokevirtual toString : ()Ljava/lang/String;
    //   815: invokespecial <init> : (Ljava/lang/String;)V
    //   818: athrow
    //   819: return
    //   820: new java/lang/IllegalArgumentException
    //   823: dup
    //   824: ldc_w 'DrawerLayout must be measured with MeasureSpec.EXACTLY.'
    //   827: invokespecial <init> : (Ljava/lang/String;)V
    //   830: athrow
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    if (savedState.a != 0) {
      View view = a(savedState.a);
      if (view != null)
        openDrawer(view); 
    } 
    if (savedState.b != 3)
      setDrawerLockMode(savedState.b, 3); 
    if (savedState.c != 3)
      setDrawerLockMode(savedState.c, 5); 
    if (savedState.d != 3)
      setDrawerLockMode(savedState.d, 8388611); 
    if (savedState.e != 3)
      setDrawerLockMode(savedState.e, 8388613); 
  }
  
  public void onRtlPropertiesChanged(int paramInt) {
    d();
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState = new SavedState(super.onSaveInstanceState());
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      LayoutParams layoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      int k = layoutParams.c;
      boolean bool = true;
      if (k == 1) {
        k = 1;
      } else {
        k = 0;
      } 
      if (layoutParams.c != 2)
        bool = false; 
      if (k != 0 || bool) {
        savedState.a = layoutParams.gravity;
        break;
      } 
    } 
    savedState.b = this.r;
    savedState.c = this.s;
    savedState.d = this.t;
    savedState.e = this.u;
    return (Parcelable)savedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    View view;
    this.k.processTouchEvent(paramMotionEvent);
    this.l.processTouchEvent(paramMotionEvent);
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0) {
      if (i != 1) {
        if (i != 3)
          return true; 
        a(true);
        this.v = false;
        this.w = false;
        return true;
      } 
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      view = this.k.findTopChildUnder((int)f2, (int)f1);
      if (view != null && e(view)) {
        f2 -= this.z;
        f1 -= this.A;
        i = this.k.getTouchSlop();
        if (f2 * f2 + f1 * f1 < (i * i)) {
          view = a();
          if (view == null || getDrawerLockMode(view) == 2) {
            boolean bool2 = true;
            a(bool2);
            this.v = false;
            return true;
          } 
          boolean bool1 = false;
          a(bool1);
          this.v = false;
          return true;
        } 
      } 
    } else {
      float f1 = view.getX();
      float f2 = view.getY();
      this.z = f1;
      this.A = f2;
      this.v = false;
      this.w = false;
      return true;
    } 
    boolean bool = true;
    a(bool);
    this.v = false;
    return true;
  }
  
  public void openDrawer(int paramInt) {
    openDrawer(paramInt, true);
  }
  
  public void openDrawer(int paramInt, boolean paramBoolean) {
    View view = a(paramInt);
    if (view != null) {
      openDrawer(view, paramBoolean);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No drawer view found with gravity ");
    stringBuilder.append(b(paramInt));
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void openDrawer(View paramView) {
    openDrawer(paramView, true);
  }
  
  public void openDrawer(View paramView, boolean paramBoolean) {
    if (f(paramView)) {
      LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
      if (this.q) {
        layoutParams.a = 1.0F;
        layoutParams.c = 1;
        a(paramView, true);
      } else if (paramBoolean) {
        layoutParams.c |= 0x2;
        if (a(paramView, 3)) {
          this.k.smoothSlideViewTo(paramView, 0, paramView.getTop());
        } else {
          this.l.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        } 
      } else {
        c(paramView, 1.0F);
        a(layoutParams.gravity, 0, paramView);
        paramView.setVisibility(0);
      } 
      invalidate();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a sliding drawer");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void removeDrawerListener(DrawerListener paramDrawerListener) {
    if (paramDrawerListener == null)
      return; 
    List<DrawerListener> list = this.y;
    if (list == null)
      return; 
    list.remove(paramDrawerListener);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.v = paramBoolean;
    if (paramBoolean)
      a(true); 
  }
  
  public void requestLayout() {
    if (!this.p)
      super.requestLayout(); 
  }
  
  public void setChildInsets(Object paramObject, boolean paramBoolean) {
    this.G = paramObject;
    this.H = paramBoolean;
    if (!paramBoolean && getBackground() == null) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    setWillNotDraw(paramBoolean);
    requestLayout();
  }
  
  public void setDrawerElevation(float paramFloat) {
    this.f = paramFloat;
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (f(view))
        ViewCompat.setElevation(view, this.f); 
    } 
  }
  
  @Deprecated
  public void setDrawerListener(DrawerListener paramDrawerListener) {
    DrawerListener drawerListener = this.x;
    if (drawerListener != null)
      removeDrawerListener(drawerListener); 
    if (paramDrawerListener != null)
      addDrawerListener(paramDrawerListener); 
    this.x = paramDrawerListener;
  }
  
  public void setDrawerLockMode(int paramInt) {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }
  
  public void setDrawerLockMode(int paramInt1, int paramInt2) {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection((View)this));
    if (paramInt2 != 3) {
      if (paramInt2 != 5) {
        if (paramInt2 != 8388611) {
          if (paramInt2 == 8388613)
            this.u = paramInt1; 
        } else {
          this.t = paramInt1;
        } 
      } else {
        this.s = paramInt1;
      } 
    } else {
      this.r = paramInt1;
    } 
    if (paramInt1 != 0) {
      ViewDragHelper viewDragHelper;
      if (i == 3) {
        viewDragHelper = this.k;
      } else {
        viewDragHelper = this.l;
      } 
      viewDragHelper.cancel();
    } 
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
        return; 
      View view = a(i);
      if (view != null) {
        openDrawer(view);
        return;
      } 
    } else {
      View view = a(i);
      if (view != null)
        closeDrawer(view); 
    } 
  }
  
  public void setDrawerLockMode(int paramInt, View paramView) {
    if (f(paramView)) {
      setDrawerLockMode(paramInt, ((LayoutParams)paramView.getLayoutParams()).gravity);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a ");
    stringBuilder.append("drawer with appropriate layout_gravity");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void setDrawerShadow(int paramInt1, int paramInt2) {
    setDrawerShadow(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }
  
  public void setDrawerShadow(Drawable paramDrawable, int paramInt) {
    if (d)
      return; 
    if ((paramInt & 0x800003) == 8388611) {
      this.I = paramDrawable;
    } else if ((paramInt & 0x800005) == 8388613) {
      this.J = paramDrawable;
    } else if ((paramInt & 0x3) == 3) {
      this.K = paramDrawable;
    } else if ((paramInt & 0x5) == 5) {
      this.L = paramDrawable;
    } else {
      return;
    } 
    d();
    invalidate();
  }
  
  public void setDrawerTitle(int paramInt, CharSequence paramCharSequence) {
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    if (paramInt == 3) {
      this.E = paramCharSequence;
      return;
    } 
    if (paramInt == 5)
      this.F = paramCharSequence; 
  }
  
  public void setScrimColor(int paramInt) {
    this.h = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt) {
    Drawable drawable;
    if (paramInt != 0) {
      drawable = ContextCompat.getDrawable(getContext(), paramInt);
    } else {
      drawable = null;
    } 
    this.B = drawable;
    invalidate();
  }
  
  public void setStatusBarBackground(Drawable paramDrawable) {
    this.B = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt) {
    this.B = (Drawable)new ColorDrawable(paramInt);
    invalidate();
  }
  
  static {
    boolean bool1;
    boolean bool2 = true;
  }
  
  class AccessibilityDelegate extends AccessibilityDelegateCompat {
    private final Rect b = new Rect();
    
    AccessibilityDelegate(DrawerLayout this$0) {}
    
    private void a(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat, ViewGroup param1ViewGroup) {
      int j = param1ViewGroup.getChildCount();
      for (int i = 0; i < j; i++) {
        View view = param1ViewGroup.getChildAt(i);
        if (DrawerLayout.g(view))
          param1AccessibilityNodeInfoCompat.addChild(view); 
      } 
    }
    
    private void a(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat2) {
      Rect rect = this.b;
      param1AccessibilityNodeInfoCompat2.getBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInParent(rect);
      param1AccessibilityNodeInfoCompat2.getBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setBoundsInScreen(rect);
      param1AccessibilityNodeInfoCompat1.setVisibleToUser(param1AccessibilityNodeInfoCompat2.isVisibleToUser());
      param1AccessibilityNodeInfoCompat1.setPackageName(param1AccessibilityNodeInfoCompat2.getPackageName());
      param1AccessibilityNodeInfoCompat1.setClassName(param1AccessibilityNodeInfoCompat2.getClassName());
      param1AccessibilityNodeInfoCompat1.setContentDescription(param1AccessibilityNodeInfoCompat2.getContentDescription());
      param1AccessibilityNodeInfoCompat1.setEnabled(param1AccessibilityNodeInfoCompat2.isEnabled());
      param1AccessibilityNodeInfoCompat1.setClickable(param1AccessibilityNodeInfoCompat2.isClickable());
      param1AccessibilityNodeInfoCompat1.setFocusable(param1AccessibilityNodeInfoCompat2.isFocusable());
      param1AccessibilityNodeInfoCompat1.setFocused(param1AccessibilityNodeInfoCompat2.isFocused());
      param1AccessibilityNodeInfoCompat1.setAccessibilityFocused(param1AccessibilityNodeInfoCompat2.isAccessibilityFocused());
      param1AccessibilityNodeInfoCompat1.setSelected(param1AccessibilityNodeInfoCompat2.isSelected());
      param1AccessibilityNodeInfoCompat1.setLongClickable(param1AccessibilityNodeInfoCompat2.isLongClickable());
      param1AccessibilityNodeInfoCompat1.addAction(param1AccessibilityNodeInfoCompat2.getActions());
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      List<CharSequence> list;
      CharSequence charSequence;
      if (param1AccessibilityEvent.getEventType() == 32) {
        list = param1AccessibilityEvent.getText();
        View view = this.a.b();
        if (view != null) {
          int i = this.a.d(view);
          charSequence = this.a.getDrawerTitle(i);
          if (charSequence != null)
            list.add(charSequence); 
        } 
        return true;
      } 
      return super.dispatchPopulateAccessibilityEvent((View)list, (AccessibilityEvent)charSequence);
    }
    
    public void onInitializeAccessibilityEvent(View param1View, AccessibilityEvent param1AccessibilityEvent) {
      super.onInitializeAccessibilityEvent(param1View, param1AccessibilityEvent);
      param1AccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      if (DrawerLayout.b) {
        super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      } else {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(param1AccessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(param1View, accessibilityNodeInfoCompat);
        param1AccessibilityNodeInfoCompat.setSource(param1View);
        ViewParent viewParent = ViewCompat.getParentForAccessibility(param1View);
        if (viewParent instanceof View)
          param1AccessibilityNodeInfoCompat.setParent((View)viewParent); 
        a(param1AccessibilityNodeInfoCompat, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.recycle();
        a(param1AccessibilityNodeInfoCompat, (ViewGroup)param1View);
      } 
      param1AccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
      param1AccessibilityNodeInfoCompat.setFocusable(false);
      param1AccessibilityNodeInfoCompat.setFocused(false);
      param1AccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_FOCUS);
      param1AccessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_FOCUS);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup param1ViewGroup, View param1View, AccessibilityEvent param1AccessibilityEvent) {
      return (DrawerLayout.b || DrawerLayout.g(param1View)) ? super.onRequestSendAccessibilityEvent(param1ViewGroup, param1View, param1AccessibilityEvent) : false;
    }
  }
  
  static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
    public void onInitializeAccessibilityNodeInfo(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      super.onInitializeAccessibilityNodeInfo(param1View, param1AccessibilityNodeInfoCompat);
      if (!DrawerLayout.g(param1View))
        param1AccessibilityNodeInfoCompat.setParent(null); 
    }
  }
  
  public static interface DrawerListener {
    void onDrawerClosed(View param1View);
    
    void onDrawerOpened(View param1View);
    
    void onDrawerSlide(View param1View, float param1Float);
    
    void onDrawerStateChanged(int param1Int);
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    float a;
    
    boolean b;
    
    int c;
    
    public int gravity = 0;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(int param1Int1, int param1Int2, int param1Int3) {
      this(param1Int1, param1Int2);
      this.gravity = param1Int3;
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, DrawerLayout.a);
      this.gravity = typedArray.getInt(0, 0);
      typedArray.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
      this.gravity = param1LayoutParams.gravity;
    }
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public DrawerLayout.SavedState createFromParcel(Parcel param2Parcel) {
          return new DrawerLayout.SavedState(param2Parcel, null);
        }
        
        public DrawerLayout.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new DrawerLayout.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public DrawerLayout.SavedState[] newArray(int param2Int) {
          return new DrawerLayout.SavedState[param2Int];
        }
      };
    
    int a = 0;
    
    int b;
    
    int c;
    
    int d;
    
    int e;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      this.c = param1Parcel.readInt();
      this.d = param1Parcel.readInt();
      this.e = param1Parcel.readInt();
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeInt(this.c);
      param1Parcel.writeInt(this.d);
      param1Parcel.writeInt(this.e);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public DrawerLayout.SavedState createFromParcel(Parcel param1Parcel) {
      return new DrawerLayout.SavedState(param1Parcel, null);
    }
    
    public DrawerLayout.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new DrawerLayout.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public DrawerLayout.SavedState[] newArray(int param1Int) {
      return new DrawerLayout.SavedState[param1Int];
    }
  }
  
  public static abstract class SimpleDrawerListener implements DrawerListener {
    public void onDrawerClosed(View param1View) {}
    
    public void onDrawerOpened(View param1View) {}
    
    public void onDrawerSlide(View param1View, float param1Float) {}
    
    public void onDrawerStateChanged(int param1Int) {}
  }
  
  class ViewDragCallback extends ViewDragHelper.Callback {
    private final int b;
    
    private ViewDragHelper c;
    
    private final Runnable d = new Runnable(this) {
        public void run() {
          this.a.a();
        }
      };
    
    ViewDragCallback(DrawerLayout this$0, int param1Int) {
      this.b = param1Int;
    }
    
    private void b() {
      int i = this.b;
      byte b = 3;
      if (i == 3)
        b = 5; 
      View view = this.a.a(b);
      if (view != null)
        this.a.closeDrawer(view); 
    }
    
    void a() {
      View view;
      int k = this.c.getEdgeSize();
      int i = this.b;
      int j = 0;
      if (i == 3) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0) {
        view = this.a.a(3);
        if (view != null)
          j = -view.getWidth(); 
        j += k;
      } else {
        view = this.a.a(5);
        j = this.a.getWidth() - k;
      } 
      if (view != null && ((i != 0 && view.getLeft() < j) || (i == 0 && view.getLeft() > j)) && this.a.getDrawerLockMode(view) == 0) {
        DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams)view.getLayoutParams();
        this.c.smoothSlideViewTo(view, j, view.getTop());
        layoutParams.b = true;
        this.a.invalidate();
        b();
        this.a.c();
      } 
    }
    
    public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
      if (this.a.a(param1View, 3))
        return Math.max(-param1View.getWidth(), Math.min(param1Int1, 0)); 
      param1Int2 = this.a.getWidth();
      return Math.max(param1Int2 - param1View.getWidth(), Math.min(param1Int1, param1Int2));
    }
    
    public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
      return param1View.getTop();
    }
    
    public int getViewHorizontalDragRange(View param1View) {
      return this.a.f(param1View) ? param1View.getWidth() : 0;
    }
    
    public void onEdgeDragStarted(int param1Int1, int param1Int2) {
      View view;
      if ((param1Int1 & 0x1) == 1) {
        view = this.a.a(3);
      } else {
        view = this.a.a(5);
      } 
      if (view != null && this.a.getDrawerLockMode(view) == 0)
        this.c.captureChildView(view, param1Int2); 
    }
    
    public boolean onEdgeLock(int param1Int) {
      return false;
    }
    
    public void onEdgeTouched(int param1Int1, int param1Int2) {
      this.a.postDelayed(this.d, 160L);
    }
    
    public void onViewCaptured(View param1View, int param1Int) {
      ((DrawerLayout.LayoutParams)param1View.getLayoutParams()).b = false;
      b();
    }
    
    public void onViewDragStateChanged(int param1Int) {
      this.a.a(this.b, param1Int, this.c.getCapturedView());
    }
    
    public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      float f;
      param1Int2 = param1View.getWidth();
      if (this.a.a(param1View, 3)) {
        f = (param1Int1 + param1Int2);
      } else {
        f = (this.a.getWidth() - param1Int1);
      } 
      f /= param1Int2;
      this.a.b(param1View, f);
      if (f == 0.0F) {
        param1Int1 = 4;
      } else {
        param1Int1 = 0;
      } 
      param1View.setVisibility(param1Int1);
      this.a.invalidate();
    }
    
    public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Landroidx/drawerlayout/widget/DrawerLayout;
      //   4: aload_1
      //   5: invokevirtual c : (Landroid/view/View;)F
      //   8: fstore_3
      //   9: aload_1
      //   10: invokevirtual getWidth : ()I
      //   13: istore #6
      //   15: aload_0
      //   16: getfield a : Landroidx/drawerlayout/widget/DrawerLayout;
      //   19: aload_1
      //   20: iconst_3
      //   21: invokevirtual a : (Landroid/view/View;I)Z
      //   24: ifeq -> 66
      //   27: fload_2
      //   28: fconst_0
      //   29: fcmpl
      //   30: istore #4
      //   32: iload #4
      //   34: ifgt -> 60
      //   37: iload #4
      //   39: ifne -> 52
      //   42: fload_3
      //   43: ldc 0.5
      //   45: fcmpl
      //   46: ifle -> 52
      //   49: goto -> 60
      //   52: iload #6
      //   54: ineg
      //   55: istore #4
      //   57: goto -> 109
      //   60: iconst_0
      //   61: istore #4
      //   63: goto -> 109
      //   66: aload_0
      //   67: getfield a : Landroidx/drawerlayout/widget/DrawerLayout;
      //   70: invokevirtual getWidth : ()I
      //   73: istore #5
      //   75: fload_2
      //   76: fconst_0
      //   77: fcmpg
      //   78: iflt -> 102
      //   81: iload #5
      //   83: istore #4
      //   85: fload_2
      //   86: fconst_0
      //   87: fcmpl
      //   88: ifne -> 109
      //   91: iload #5
      //   93: istore #4
      //   95: fload_3
      //   96: ldc 0.5
      //   98: fcmpl
      //   99: ifle -> 109
      //   102: iload #5
      //   104: iload #6
      //   106: isub
      //   107: istore #4
      //   109: aload_0
      //   110: getfield c : Landroidx/customview/widget/ViewDragHelper;
      //   113: iload #4
      //   115: aload_1
      //   116: invokevirtual getTop : ()I
      //   119: invokevirtual settleCapturedViewAt : (II)Z
      //   122: pop
      //   123: aload_0
      //   124: getfield a : Landroidx/drawerlayout/widget/DrawerLayout;
      //   127: invokevirtual invalidate : ()V
      //   130: return
    }
    
    public void removeCallbacks() {
      this.a.removeCallbacks(this.d);
    }
    
    public void setDragger(ViewDragHelper param1ViewDragHelper) {
      this.c = param1ViewDragHelper;
    }
    
    public boolean tryCaptureView(View param1View, int param1Int) {
      return (this.a.f(param1View) && this.a.a(param1View, this.b) && this.a.getDrawerLockMode(param1View) == 0);
    }
  }
  
  class null implements Runnable {
    null(DrawerLayout this$0) {}
    
    public void run() {
      this.a.a();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\drawerlayout\widget\DrawerLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */