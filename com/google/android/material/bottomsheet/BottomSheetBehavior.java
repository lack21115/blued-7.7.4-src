package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
  private static final int F = R.style.Widget_Design_BottomSheet_Modal;
  
  private boolean A;
  
  private ShapeAppearanceModel B;
  
  private boolean C;
  
  private SettleRunnable D = null;
  
  private ValueAnimator E;
  
  private boolean G;
  
  private boolean H = true;
  
  private boolean I;
  
  private int J;
  
  private boolean K;
  
  private int L;
  
  private final ArrayList<BottomSheetCallback> M = new ArrayList<BottomSheetCallback>();
  
  private VelocityTracker N;
  
  private int O;
  
  private Map<View, Integer> P;
  
  private final ViewDragHelper.Callback Q = new ViewDragHelper.Callback(this) {
      private boolean a(View param1View) {
        return (param1View.getTop() > (this.a.k + this.a.a()) / 2);
      }
      
      public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
        return param1View.getLeft();
      }
      
      public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
        int i = this.a.a();
        if (this.a.g) {
          param1Int2 = this.a.k;
        } else {
          param1Int2 = this.a.e;
        } 
        return MathUtils.clamp(param1Int1, i, param1Int2);
      }
      
      public int getViewVerticalDragRange(View param1View) {
        return this.a.g ? this.a.k : this.a.e;
      }
      
      public void onViewDragStateChanged(int param1Int) {
        if (param1Int == 1 && BottomSheetBehavior.b(this.a))
          this.a.e(1); 
      }
      
      public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
        this.a.f(param1Int2);
      }
      
      public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
        byte b = 4;
        if (param1Float2 < 0.0F) {
          if (BottomSheetBehavior.c(this.a)) {
            int i = this.a.b;
          } else {
            if (param1View.getTop() > this.a.c) {
              int i = this.a.c;
            } else {
              int i = this.a.a;
              b = 3;
            } 
            b = 6;
          } 
        } else {
          int i;
          if (this.a.g && this.a.a(param1View, param1Float2)) {
            if ((Math.abs(param1Float1) < Math.abs(param1Float2) && param1Float2 > 500.0F) || a(param1View)) {
              i = this.a.k;
              b = 5;
            } else {
              if (BottomSheetBehavior.c(this.a)) {
                i = this.a.b;
              } else if (Math.abs(param1View.getTop() - this.a.a) < Math.abs(param1View.getTop() - this.a.c)) {
                i = this.a.a;
              } else {
                i = this.a.c;
                b = 6;
              } 
              b = 3;
            } 
          } else {
            if (param1Float2 == 0.0F || Math.abs(param1Float1) > Math.abs(param1Float2)) {
              i = param1View.getTop();
              if (BottomSheetBehavior.c(this.a)) {
                if (Math.abs(i - this.a.b) < Math.abs(i - this.a.e)) {
                  i = this.a.b;
                } else {
                  i = this.a.e;
                  this.a.a(param1View, b, i, true);
                } 
              } else if (i < this.a.c) {
                if (i < Math.abs(i - this.a.e)) {
                  i = this.a.a;
                } else {
                  i = this.a.c;
                  b = 6;
                } 
              } else {
                if (Math.abs(i - this.a.c) < Math.abs(i - this.a.e)) {
                  i = this.a.c;
                } else {
                  i = this.a.e;
                  this.a.a(param1View, b, i, true);
                } 
                b = 6;
              } 
            } else {
              if (BottomSheetBehavior.c(this.a)) {
                i = this.a.e;
              } else {
                i = param1View.getTop();
                if (Math.abs(i - this.a.c) < Math.abs(i - this.a.e)) {
                  i = this.a.c;
                } else {
                  i = this.a.e;
                  this.a.a(param1View, b, i, true);
                } 
                b = 6;
              } 
              this.a.a(param1View, b, i, true);
            } 
            b = 3;
          } 
          this.a.a(param1View, b, i, true);
        } 
        b = 3;
      }
      
      public boolean tryCaptureView(View param1View, int param1Int) {
        if (this.a.h == 1)
          return false; 
        if (this.a.o)
          return false; 
        if (this.a.h == 3 && this.a.n == param1Int) {
          View view;
          if (this.a.m != null) {
            view = this.a.m.get();
          } else {
            view = null;
          } 
          if (view != null && view.canScrollVertically(-1))
            return false; 
        } 
        return (this.a.l != null && this.a.l.get() == param1View);
      }
    };
  
  int a;
  
  int b;
  
  int c;
  
  float d = 0.5F;
  
  int e;
  
  float f = -1.0F;
  
  boolean g;
  
  int h = 4;
  
  ViewDragHelper i;
  
  int j;
  
  int k;
  
  WeakReference<V> l;
  
  WeakReference<View> m;
  
  int n;
  
  boolean o;
  
  private int p = 0;
  
  private boolean q = true;
  
  private boolean r = false;
  
  private float s;
  
  private int t;
  
  private boolean u;
  
  private int v;
  
  private int w;
  
  private boolean x;
  
  private MaterialShapeDrawable y;
  
  private int z;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.w = paramContext.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BottomSheetBehavior_Layout);
    this.x = typedArray.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
    boolean bool = typedArray.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
    if (bool) {
      a(paramContext, paramAttributeSet, bool, MaterialResources.a(paramContext, typedArray, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
    } else {
      a(paramContext, paramAttributeSet, bool);
    } 
    i();
    if (Build.VERSION.SDK_INT >= 21)
      this.f = typedArray.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0F); 
    TypedValue typedValue = typedArray.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
    if (typedValue != null && typedValue.data == -1) {
      a(typedValue.data);
    } else {
      a(typedArray.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    } 
    b(typedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
    e(typedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
    a(typedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
    c(typedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
    d(typedArray.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
    c(typedArray.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
    a(typedArray.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5F));
    typedValue = typedArray.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
    if (typedValue != null && typedValue.type == 16) {
      b(typedValue.data);
    } else {
      b(typedArray.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
    } 
    typedArray.recycle();
    this.s = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean) {
    a(paramContext, paramAttributeSet, paramBoolean, (ColorStateList)null);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean, ColorStateList paramColorStateList) {
    if (this.x) {
      this.B = ShapeAppearanceModel.a(paramContext, paramAttributeSet, R.attr.bottomSheetStyle, F).a();
      this.y = new MaterialShapeDrawable(this.B);
      this.y.a(paramContext);
      if (paramBoolean && paramColorStateList != null) {
        this.y.g(paramColorStateList);
        return;
      } 
      TypedValue typedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(16842801, typedValue, true);
      this.y.setTint(typedValue.data);
    } 
  }
  
  private void a(V paramV, AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat, int paramInt) {
    ViewCompat.replaceAccessibilityAction((View)paramV, paramAccessibilityActionCompat, null, new AccessibilityViewCommand(this, paramInt) {
          public boolean perform(View param1View, AccessibilityViewCommand.CommandArguments param1CommandArguments) {
            this.b.d(this.a);
            return true;
          }
        });
  }
  
  private void a(SavedState paramSavedState) {
    int i = this.p;
    if (i == 0)
      return; 
    if (i == -1 || (i & 0x1) == 1)
      this.t = paramSavedState.b; 
    i = this.p;
    if (i == -1 || (i & 0x2) == 2)
      this.q = paramSavedState.c; 
    i = this.p;
    if (i == -1 || (i & 0x4) == 4)
      this.g = paramSavedState.d; 
    i = this.p;
    if (i == -1 || (i & 0x8) == 8)
      this.G = paramSavedState.e; 
  }
  
  public static <V extends View> BottomSheetBehavior<V> b(V paramV) {
    ViewGroup.LayoutParams layoutParams = paramV.getLayoutParams();
    if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
      CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)layoutParams).getBehavior();
      if (behavior instanceof BottomSheetBehavior)
        return (BottomSheetBehavior<V>)behavior; 
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    } 
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  private void c(View paramView) {
    if (Build.VERSION.SDK_INT >= 29 && !c() && !this.u)
      ViewUtils.a(paramView, new ViewUtils.OnApplyWindowInsetsListener(this) {
            public WindowInsetsCompat a(View param1View, WindowInsetsCompat param1WindowInsetsCompat, ViewUtils.RelativePadding param1RelativePadding) {
              BottomSheetBehavior.a(this.a, (param1WindowInsetsCompat.getMandatorySystemGestureInsets()).bottom);
              BottomSheetBehavior.a(this.a, false);
              return param1WindowInsetsCompat;
            }
          }); 
  }
  
  private int e() {
    if (this.u)
      return Math.min(Math.max(this.v, this.k - this.j * 9 / 16), this.L); 
    if (!this.A) {
      int i = this.z;
      if (i > 0)
        return Math.max(this.t, i + this.w); 
    } 
    return this.t;
  }
  
  private void f() {
    int i = e();
    if (this.q) {
      this.e = Math.max(this.k - i, this.b);
      return;
    } 
    this.e = this.k - i;
  }
  
  private void f(boolean paramBoolean) {
    if (this.l != null) {
      f();
      if (this.h == 4) {
        View view = (View)this.l.get();
        if (view != null) {
          if (paramBoolean) {
            g(this.h);
            return;
          } 
          view.requestLayout();
        } 
      } 
    } 
  }
  
  private void g() {
    this.c = (int)(this.k * (1.0F - this.d));
  }
  
  private void g(int paramInt) {
    View view = (View)this.l.get();
    if (view == null)
      return; 
    ViewParent viewParent = view.getParent();
    if (viewParent != null && viewParent.isLayoutRequested() && ViewCompat.isAttachedToWindow(view)) {
      view.post(new Runnable(this, view, paramInt) {
            public void run() {
              this.c.a(this.a, this.b);
            }
          });
      return;
    } 
    a(view, paramInt);
  }
  
  private void g(boolean paramBoolean) {
    WeakReference<V> weakReference = this.l;
    if (weakReference == null)
      return; 
    ViewParent viewParent = ((View)weakReference.get()).getParent();
    if (!(viewParent instanceof CoordinatorLayout))
      return; 
    CoordinatorLayout coordinatorLayout = (CoordinatorLayout)viewParent;
    int j = coordinatorLayout.getChildCount();
    if (Build.VERSION.SDK_INT >= 16 && paramBoolean)
      if (this.P == null) {
        this.P = new HashMap<View, Integer>(j);
      } else {
        return;
      }  
    for (int i = 0; i < j; i++) {
      View view = coordinatorLayout.getChildAt(i);
      if (view != this.l.get())
        if (paramBoolean) {
          if (Build.VERSION.SDK_INT >= 16)
            this.P.put(view, Integer.valueOf(view.getImportantForAccessibility())); 
          if (this.r)
            ViewCompat.setImportantForAccessibility(view, 4); 
        } else if (this.r) {
          Map<View, Integer> map = this.P;
          if (map != null && map.containsKey(view))
            ViewCompat.setImportantForAccessibility(view, ((Integer)this.P.get(view)).intValue()); 
        }  
    } 
    if (!paramBoolean)
      this.P = null; 
  }
  
  private void h() {
    this.n = -1;
    VelocityTracker velocityTracker = this.N;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.N = null;
    } 
  }
  
  private void h(int paramInt) {
    boolean bool;
    if (paramInt == 2)
      return; 
    if (paramInt == 3) {
      bool = true;
    } else {
      bool = false;
    } 
    if (this.C != bool) {
      this.C = bool;
      if (this.y != null) {
        ValueAnimator valueAnimator = this.E;
        if (valueAnimator != null) {
          float f;
          if (valueAnimator.isRunning()) {
            this.E.reverse();
            return;
          } 
          if (bool) {
            f = 0.0F;
          } else {
            f = 1.0F;
          } 
          this.E.setFloatValues(new float[] { 1.0F - f, f });
          this.E.start();
        } 
      } 
    } 
  }
  
  private void i() {
    this.E = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.E.setDuration(500L);
    this.E.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.a(this.a) != null)
              BottomSheetBehavior.a(this.a).p(f); 
          }
        });
  }
  
  private float j() {
    VelocityTracker velocityTracker = this.N;
    if (velocityTracker == null)
      return 0.0F; 
    velocityTracker.computeCurrentVelocity(1000, this.s);
    return this.N.getYVelocity(this.n);
  }
  
  private void k() {
    WeakReference<V> weakReference = this.l;
    if (weakReference == null)
      return; 
    View view = (View)weakReference.get();
    if (view == null)
      return; 
    ViewCompat.removeAccessibilityAction(view, 524288);
    ViewCompat.removeAccessibilityAction(view, 262144);
    ViewCompat.removeAccessibilityAction(view, 1048576);
    if (this.g && this.h != 5)
      a((V)view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5); 
    int i = this.h;
    byte b = 6;
    if (i != 3) {
      if (i != 4) {
        if (i != 6)
          return; 
        a((V)view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
        a((V)view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        return;
      } 
      if (this.q)
        b = 3; 
      a((V)view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, b);
      return;
    } 
    if (this.q)
      b = 4; 
    a((V)view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, b);
  }
  
  public int a() {
    return this.q ? this.b : this.a;
  }
  
  View a(View paramView) {
    if (ViewCompat.isNestedScrollingEnabled(paramView))
      return paramView; 
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int i = 0;
      int j = viewGroup.getChildCount();
      while (i < j) {
        View view = a(viewGroup.getChildAt(i));
        if (view != null)
          return view; 
        i++;
      } 
    } 
    return null;
  }
  
  public void a(float paramFloat) {
    if (paramFloat > 0.0F && paramFloat < 1.0F) {
      this.d = paramFloat;
      if (this.l != null)
        g(); 
      return;
    } 
    throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
  }
  
  public void a(int paramInt) {
    a(paramInt, false);
  }
  
  public final void a(int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iload_1
    //   3: iconst_m1
    //   4: if_icmpne -> 24
    //   7: aload_0
    //   8: getfield u : Z
    //   11: ifne -> 42
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield u : Z
    //   19: iload_3
    //   20: istore_1
    //   21: goto -> 63
    //   24: aload_0
    //   25: getfield u : Z
    //   28: ifne -> 47
    //   31: aload_0
    //   32: getfield t : I
    //   35: iload_1
    //   36: if_icmpeq -> 42
    //   39: goto -> 47
    //   42: iconst_0
    //   43: istore_1
    //   44: goto -> 63
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield u : Z
    //   52: aload_0
    //   53: iconst_0
    //   54: iload_1
    //   55: invokestatic max : (II)I
    //   58: putfield t : I
    //   61: iload_3
    //   62: istore_1
    //   63: iload_1
    //   64: ifeq -> 72
    //   67: aload_0
    //   68: iload_2
    //   69: invokespecial f : (Z)V
    //   72: return
  }
  
  void a(View paramView, int paramInt) {
    StringBuilder stringBuilder;
    int i;
    if (paramInt == 4) {
      i = this.e;
    } else if (paramInt == 6) {
      i = this.c;
      if (this.q) {
        int j = this.b;
        if (i <= j) {
          i = j;
          paramInt = 3;
        } 
      } 
    } else if (paramInt == 3) {
      i = a();
    } else if (this.g && paramInt == 5) {
      i = this.k;
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("Illegal state argument: ");
      stringBuilder.append(paramInt);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    a((View)stringBuilder, paramInt, i, false);
  }
  
  void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean) {
    ViewDragHelper viewDragHelper = this.i;
    if (viewDragHelper != null && (paramBoolean ? viewDragHelper.settleCapturedViewAt(paramView.getLeft(), paramInt2) : viewDragHelper.smoothSlideViewTo(paramView, paramView.getLeft(), paramInt2))) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    } 
    if (paramInt2 != 0) {
      e(2);
      h(paramInt1);
      if (this.D == null)
        this.D = new SettleRunnable(this, paramView, paramInt1); 
      if (!SettleRunnable.a(this.D)) {
        SettleRunnable settleRunnable = this.D;
        settleRunnable.a = paramInt1;
        ViewCompat.postOnAnimation(paramView, settleRunnable);
        SettleRunnable.a(this.D, true);
        return;
      } 
      this.D.a = paramInt1;
      return;
    } 
    e(paramInt1);
  }
  
  public void a(BottomSheetCallback paramBottomSheetCallback) {
    if (!this.M.contains(paramBottomSheetCallback))
      this.M.add(paramBottomSheetCallback); 
  }
  
  public void a(boolean paramBoolean) {
    int i;
    if (this.q == paramBoolean)
      return; 
    this.q = paramBoolean;
    if (this.l != null)
      f(); 
    if (this.q && this.h == 6) {
      i = 3;
    } else {
      i = this.h;
    } 
    e(i);
    k();
  }
  
  boolean a(View paramView, float paramFloat) {
    if (this.G)
      return true; 
    if (paramView.getTop() < this.e)
      return false; 
    int i = e();
    return (Math.abs(paramView.getTop() + paramFloat * 0.1F - this.e) / i > 0.5F);
  }
  
  public void b(int paramInt) {
    if (paramInt >= 0) {
      this.a = paramInt;
      return;
    } 
    throw new IllegalArgumentException("offset must be greater than or equal to 0");
  }
  
  public void b(BottomSheetCallback paramBottomSheetCallback) {
    this.M.remove(paramBottomSheetCallback);
  }
  
  public void b(boolean paramBoolean) {
    if (this.g != paramBoolean) {
      this.g = paramBoolean;
      if (!paramBoolean && this.h == 5)
        d(4); 
      k();
    } 
  }
  
  public boolean b() {
    return this.g;
  }
  
  public void c(int paramInt) {
    this.p = paramInt;
  }
  
  public void c(boolean paramBoolean) {
    this.G = paramBoolean;
  }
  
  public boolean c() {
    return this.A;
  }
  
  public int d() {
    return this.h;
  }
  
  public void d(int paramInt) {
    if (paramInt == this.h)
      return; 
    if (this.l == null) {
      if (paramInt == 4 || paramInt == 3 || paramInt == 6 || (this.g && paramInt == 5))
        this.h = paramInt; 
      return;
    } 
    g(paramInt);
  }
  
  public void d(boolean paramBoolean) {
    this.H = paramBoolean;
  }
  
  void e(int paramInt) {
    if (this.h == paramInt)
      return; 
    this.h = paramInt;
    WeakReference<V> weakReference = this.l;
    if (weakReference == null)
      return; 
    View view = (View)weakReference.get();
    if (view == null)
      return; 
    int i = 0;
    if (paramInt == 3) {
      g(true);
    } else if (paramInt == 6 || paramInt == 5 || paramInt == 4) {
      g(false);
    } 
    h(paramInt);
    while (i < this.M.size()) {
      ((BottomSheetCallback)this.M.get(i)).a(view, paramInt);
      i++;
    } 
    k();
  }
  
  public void e(boolean paramBoolean) {
    this.A = paramBoolean;
  }
  
  void f(int paramInt) {
    View view = (View)this.l.get();
    if (view != null && !this.M.isEmpty()) {
      float f2;
      int i = this.e;
      if (paramInt > i || i == a()) {
        i = this.e;
        f2 = (i - paramInt);
        f1 = (this.k - i);
      } else {
        i = this.e;
        f2 = (i - paramInt);
        f1 = (i - a());
      } 
      float f1 = f2 / f1;
      for (paramInt = 0; paramInt < this.M.size(); paramInt++)
        ((BottomSheetCallback)this.M.get(paramInt)).a(view, f1); 
    } 
  }
  
  public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams paramLayoutParams) {
    super.onAttachedToLayoutParams(paramLayoutParams);
    this.l = null;
    this.i = null;
  }
  
  public void onDetachedFromLayoutParams() {
    super.onDetachedFromLayoutParams();
    this.l = null;
    this.i = null;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    View view;
    boolean bool = paramV.isShown();
    boolean bool1 = false;
    if (!bool || !this.H) {
      this.I = true;
      return false;
    } 
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      h(); 
    if (this.N == null)
      this.N = VelocityTracker.obtain(); 
    this.N.addMovement(paramMotionEvent);
    V v = null;
    if (i != 0) {
      if (i == 1 || i == 3) {
        this.o = false;
        this.n = -1;
        if (this.I) {
          this.I = false;
          return false;
        } 
      } 
    } else {
      int j = (int)paramMotionEvent.getX();
      this.O = (int)paramMotionEvent.getY();
      if (this.h != 2) {
        WeakReference<View> weakReference1 = this.m;
        if (weakReference1 != null) {
          View view1 = weakReference1.get();
        } else {
          weakReference1 = null;
        } 
        if (weakReference1 != null && paramCoordinatorLayout.isPointInChildBounds((View)weakReference1, j, this.O)) {
          this.n = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          this.o = true;
        } 
      } 
      if (this.n == -1 && !paramCoordinatorLayout.isPointInChildBounds((View)paramV, j, this.O)) {
        bool = true;
      } else {
        bool = false;
      } 
      this.I = bool;
    } 
    if (!this.I) {
      ViewDragHelper viewDragHelper = this.i;
      if (viewDragHelper != null && viewDragHelper.shouldInterceptTouchEvent(paramMotionEvent))
        return true; 
    } 
    WeakReference<View> weakReference = this.m;
    paramV = v;
    if (weakReference != null)
      view = weakReference.get(); 
    bool = bool1;
    if (i == 2) {
      bool = bool1;
      if (view != null) {
        bool = bool1;
        if (!this.I) {
          bool = bool1;
          if (this.h != 1) {
            bool = bool1;
            if (!paramCoordinatorLayout.isPointInChildBounds(view, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
              bool = bool1;
              if (this.i != null) {
                bool = bool1;
                if (Math.abs(this.O - paramMotionEvent.getY()) > this.i.getTouchSlop())
                  bool = true; 
              } 
            } 
          } 
        } 
      } 
    } 
    return bool;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    if (ViewCompat.getFitsSystemWindows((View)paramCoordinatorLayout) && !ViewCompat.getFitsSystemWindows((View)paramV))
      paramV.setFitsSystemWindows(true); 
    if (this.l == null) {
      this.v = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
      c((View)paramV);
      this.l = new WeakReference<V>(paramV);
      if (this.x) {
        MaterialShapeDrawable materialShapeDrawable1 = this.y;
        if (materialShapeDrawable1 != null)
          ViewCompat.setBackground((View)paramV, (Drawable)materialShapeDrawable1); 
      } 
      MaterialShapeDrawable materialShapeDrawable = this.y;
      if (materialShapeDrawable != null) {
        boolean bool;
        float f2 = this.f;
        float f1 = f2;
        if (f2 == -1.0F)
          f1 = ViewCompat.getElevation((View)paramV); 
        materialShapeDrawable.r(f1);
        if (this.h == 3) {
          bool = true;
        } else {
          bool = false;
        } 
        this.C = bool;
        materialShapeDrawable = this.y;
        if (this.C) {
          f1 = 0.0F;
        } else {
          f1 = 1.0F;
        } 
        materialShapeDrawable.p(f1);
      } 
      k();
      if (ViewCompat.getImportantForAccessibility((View)paramV) == 0)
        ViewCompat.setImportantForAccessibility((View)paramV, 1); 
    } 
    if (this.i == null)
      this.i = ViewDragHelper.create((ViewGroup)paramCoordinatorLayout, this.Q); 
    int i = paramV.getTop();
    paramCoordinatorLayout.onLayoutChild((View)paramV, paramInt);
    this.j = paramCoordinatorLayout.getWidth();
    this.k = paramCoordinatorLayout.getHeight();
    this.L = paramV.getHeight();
    this.b = Math.max(0, this.k - this.L);
    g();
    f();
    paramInt = this.h;
    if (paramInt == 3) {
      ViewCompat.offsetTopAndBottom((View)paramV, a());
    } else if (paramInt == 6) {
      ViewCompat.offsetTopAndBottom((View)paramV, this.c);
    } else if (this.g && paramInt == 5) {
      ViewCompat.offsetTopAndBottom((View)paramV, this.k);
    } else {
      paramInt = this.h;
      if (paramInt == 4) {
        ViewCompat.offsetTopAndBottom((View)paramV, this.e);
      } else if (paramInt == 1 || paramInt == 2) {
        ViewCompat.offsetTopAndBottom((View)paramV, i - paramV.getTop());
      } 
    } 
    this.m = new WeakReference<View>(a((View)paramV));
    return true;
  }
  
  public boolean onNestedPreFling(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, float paramFloat1, float paramFloat2) {
    WeakReference<View> weakReference = this.m;
    boolean bool = false;
    null = bool;
    if (weakReference != null) {
      null = bool;
      if (paramView == weakReference.get()) {
        if (this.h == 3) {
          null = bool;
          return super.onNestedPreFling(paramCoordinatorLayout, (View)paramV, paramView, paramFloat1, paramFloat2) ? true : null;
        } 
      } else {
        return null;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
    if (paramInt3 == 1)
      return; 
    WeakReference<View> weakReference = this.m;
    if (weakReference != null) {
      View view = weakReference.get();
    } else {
      weakReference = null;
    } 
    if (paramView != weakReference)
      return; 
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0) {
      if (paramInt3 < a()) {
        paramArrayOfint[1] = paramInt1 - a();
        ViewCompat.offsetTopAndBottom((View)paramV, -paramArrayOfint[1]);
        e(3);
      } else {
        if (!this.H)
          return; 
        paramArrayOfint[1] = paramInt2;
        ViewCompat.offsetTopAndBottom((View)paramV, -paramInt2);
        e(1);
      } 
    } else if (paramInt2 < 0 && !paramView.canScrollVertically(-1)) {
      int i = this.e;
      if (paramInt3 <= i || this.g) {
        if (!this.H)
          return; 
        paramArrayOfint[1] = paramInt2;
        ViewCompat.offsetTopAndBottom((View)paramV, -paramInt2);
        e(1);
      } else {
        paramArrayOfint[1] = paramInt1 - i;
        ViewCompat.offsetTopAndBottom((View)paramV, -paramArrayOfint[1]);
        e(4);
      } 
    } 
    f(paramV.getTop());
    this.J = paramInt2;
    this.K = true;
  }
  
  public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint) {}
  
  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramCoordinatorLayout, (View)paramV, savedState.getSuperState());
    a(savedState);
    if (savedState.a == 1 || savedState.a == 2) {
      this.h = 4;
      return;
    } 
    this.h = savedState.a;
  }
  
  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV) {
    return (Parcelable)new SavedState(super.onSaveInstanceState(paramCoordinatorLayout, (View)paramV), this);
  }
  
  public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView1, View paramView2, int paramInt1, int paramInt2) {
    boolean bool = false;
    this.J = 0;
    this.K = false;
    if ((paramInt1 & 0x2) != 0)
      bool = true; 
    return bool;
  }
  
  public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, V paramV, View paramView, int paramInt) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual getTop : ()I
    //   4: istore #4
    //   6: aload_0
    //   7: invokevirtual a : ()I
    //   10: istore #6
    //   12: iconst_3
    //   13: istore #5
    //   15: iload #4
    //   17: iload #6
    //   19: if_icmpne -> 28
    //   22: aload_0
    //   23: iconst_3
    //   24: invokevirtual e : (I)V
    //   27: return
    //   28: aload_0
    //   29: getfield m : Ljava/lang/ref/WeakReference;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull -> 369
    //   37: aload_3
    //   38: aload_1
    //   39: invokevirtual get : ()Ljava/lang/Object;
    //   42: if_acmpne -> 369
    //   45: aload_0
    //   46: getfield K : Z
    //   49: ifne -> 53
    //   52: return
    //   53: aload_0
    //   54: getfield J : I
    //   57: ifle -> 107
    //   60: aload_0
    //   61: getfield q : Z
    //   64: ifeq -> 76
    //   67: aload_0
    //   68: getfield b : I
    //   71: istore #4
    //   73: goto -> 354
    //   76: aload_2
    //   77: invokevirtual getTop : ()I
    //   80: istore #6
    //   82: aload_0
    //   83: getfield c : I
    //   86: istore #4
    //   88: iload #6
    //   90: iload #4
    //   92: if_icmple -> 98
    //   95: goto -> 338
    //   98: aload_0
    //   99: getfield a : I
    //   102: istore #4
    //   104: goto -> 354
    //   107: aload_0
    //   108: getfield g : Z
    //   111: ifeq -> 138
    //   114: aload_0
    //   115: aload_2
    //   116: aload_0
    //   117: invokespecial j : ()F
    //   120: invokevirtual a : (Landroid/view/View;F)Z
    //   123: ifeq -> 138
    //   126: aload_0
    //   127: getfield k : I
    //   130: istore #4
    //   132: iconst_5
    //   133: istore #5
    //   135: goto -> 354
    //   138: aload_0
    //   139: getfield J : I
    //   142: ifne -> 284
    //   145: aload_2
    //   146: invokevirtual getTop : ()I
    //   149: istore #4
    //   151: aload_0
    //   152: getfield q : Z
    //   155: ifeq -> 199
    //   158: iload #4
    //   160: aload_0
    //   161: getfield b : I
    //   164: isub
    //   165: invokestatic abs : (I)I
    //   168: iload #4
    //   170: aload_0
    //   171: getfield e : I
    //   174: isub
    //   175: invokestatic abs : (I)I
    //   178: if_icmpge -> 190
    //   181: aload_0
    //   182: getfield b : I
    //   185: istore #4
    //   187: goto -> 354
    //   190: aload_0
    //   191: getfield e : I
    //   194: istore #4
    //   196: goto -> 297
    //   199: aload_0
    //   200: getfield c : I
    //   203: istore #6
    //   205: iload #4
    //   207: iload #6
    //   209: if_icmpge -> 245
    //   212: iload #4
    //   214: iload #4
    //   216: aload_0
    //   217: getfield e : I
    //   220: isub
    //   221: invokestatic abs : (I)I
    //   224: if_icmpge -> 236
    //   227: aload_0
    //   228: getfield a : I
    //   231: istore #4
    //   233: goto -> 354
    //   236: aload_0
    //   237: getfield c : I
    //   240: istore #4
    //   242: goto -> 338
    //   245: iload #4
    //   247: iload #6
    //   249: isub
    //   250: invokestatic abs : (I)I
    //   253: iload #4
    //   255: aload_0
    //   256: getfield e : I
    //   259: isub
    //   260: invokestatic abs : (I)I
    //   263: if_icmpge -> 275
    //   266: aload_0
    //   267: getfield c : I
    //   270: istore #4
    //   272: goto -> 338
    //   275: aload_0
    //   276: getfield e : I
    //   279: istore #4
    //   281: goto -> 297
    //   284: aload_0
    //   285: getfield q : Z
    //   288: ifeq -> 303
    //   291: aload_0
    //   292: getfield e : I
    //   295: istore #4
    //   297: iconst_4
    //   298: istore #5
    //   300: goto -> 354
    //   303: aload_2
    //   304: invokevirtual getTop : ()I
    //   307: istore #4
    //   309: iload #4
    //   311: aload_0
    //   312: getfield c : I
    //   315: isub
    //   316: invokestatic abs : (I)I
    //   319: iload #4
    //   321: aload_0
    //   322: getfield e : I
    //   325: isub
    //   326: invokestatic abs : (I)I
    //   329: if_icmpge -> 345
    //   332: aload_0
    //   333: getfield c : I
    //   336: istore #4
    //   338: bipush #6
    //   340: istore #5
    //   342: goto -> 354
    //   345: aload_0
    //   346: getfield e : I
    //   349: istore #4
    //   351: goto -> 297
    //   354: aload_0
    //   355: aload_2
    //   356: iload #5
    //   358: iload #4
    //   360: iconst_0
    //   361: invokevirtual a : (Landroid/view/View;IIZ)V
    //   364: aload_0
    //   365: iconst_0
    //   366: putfield K : Z
    //   369: return
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent) {
    if (!paramV.isShown())
      return false; 
    int i = paramMotionEvent.getActionMasked();
    if (this.h == 1 && i == 0)
      return true; 
    ViewDragHelper viewDragHelper = this.i;
    if (viewDragHelper != null)
      viewDragHelper.processTouchEvent(paramMotionEvent); 
    if (i == 0)
      h(); 
    if (this.N == null)
      this.N = VelocityTracker.obtain(); 
    this.N.addMovement(paramMotionEvent);
    if (this.i != null && i == 2 && !this.I && Math.abs(this.O - paramMotionEvent.getY()) > this.i.getTouchSlop())
      this.i.captureChildView((View)paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex())); 
    return this.I ^ true;
  }
  
  public static abstract class BottomSheetCallback {
    public abstract void a(View param1View, float param1Float);
    
    public abstract void a(View param1View, int param1Int);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface SaveFlags {}
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public BottomSheetBehavior.SavedState a(Parcel param2Parcel) {
          return new BottomSheetBehavior.SavedState(param2Parcel, null);
        }
        
        public BottomSheetBehavior.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new BottomSheetBehavior.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public BottomSheetBehavior.SavedState[] a(int param2Int) {
          return new BottomSheetBehavior.SavedState[param2Int];
        }
      };
    
    final int a;
    
    int b;
    
    boolean c;
    
    boolean d;
    
    boolean e;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readInt();
      int i = param1Parcel.readInt();
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.c = bool1;
      if (param1Parcel.readInt() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.d = bool1;
      boolean bool1 = bool2;
      if (param1Parcel.readInt() == 1)
        bool1 = true; 
      this.e = bool1;
    }
    
    public SavedState(Parcelable param1Parcelable, BottomSheetBehavior<?> param1BottomSheetBehavior) {
      super(param1Parcelable);
      this.a = param1BottomSheetBehavior.h;
      this.b = BottomSheetBehavior.d(param1BottomSheetBehavior);
      this.c = BottomSheetBehavior.c(param1BottomSheetBehavior);
      this.d = param1BottomSheetBehavior.g;
      this.e = BottomSheetBehavior.e(param1BottomSheetBehavior);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public BottomSheetBehavior.SavedState a(Parcel param1Parcel) {
      return new BottomSheetBehavior.SavedState(param1Parcel, null);
    }
    
    public BottomSheetBehavior.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new BottomSheetBehavior.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public BottomSheetBehavior.SavedState[] a(int param1Int) {
      return new BottomSheetBehavior.SavedState[param1Int];
    }
  }
  
  class SettleRunnable implements Runnable {
    int a;
    
    private final View c;
    
    private boolean d;
    
    SettleRunnable(BottomSheetBehavior this$0, View param1View, int param1Int) {
      this.c = param1View;
      this.a = param1Int;
    }
    
    public void run() {
      if (this.b.i != null && this.b.i.continueSettling(true)) {
        ViewCompat.postOnAnimation(this.c, this);
      } else {
        this.b.e(this.a);
      } 
      this.d = false;
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface State {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\bottomsheet\BottomSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */