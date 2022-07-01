package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView extends ViewGroup implements NestedScrollingChild2, NestedScrollingChild3, ScrollingView {
  static {
    if (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = true;
    } else {
      bool = false;
    } 
    b = bool;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    } 
    c = bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    d = bool;
    if (Build.VERSION.SDK_INT <= 15) {
      bool = true;
    } else {
      bool = false;
    } 
    M = bool;
    if (Build.VERSION.SDK_INT <= 15) {
      bool = true;
    } else {
      bool = false;
    } 
    N = bool;
    O = new Class[] { Context.class, AttributeSet.class, int.class, int.class };
    K = new Interpolator() {
        public float getInterpolation(float param1Float) {
          param1Float--;
          return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
        }
      };
  }
  
  public RecyclerView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.recyclerViewStyle);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl;
    this.P = new RecyclerViewDataObserver(this);
    this.e = new Recycler(this);
    this.h = new ViewInfoStore();
    this.j = new Runnable(this) {
        public void run() {
          if (this.a.t) {
            if (this.a.isLayoutRequested())
              return; 
            if (!this.a.q) {
              this.a.requestLayout();
              return;
            } 
            if (this.a.v) {
              this.a.u = true;
              return;
            } 
            this.a.d();
          } 
        }
      };
    this.k = new Rect();
    this.R = new Rect();
    this.l = new RectF();
    this.p = new ArrayList<ItemDecoration>();
    this.S = new ArrayList<OnItemTouchListener>();
    this.U = 0;
    this.x = false;
    this.y = false;
    this.ac = 0;
    this.ad = 0;
    this.ae = new EdgeEffectFactory();
    this.z = new DefaultItemAnimator();
    this.aj = 0;
    this.ak = -1;
    this.au = Float.MIN_VALUE;
    this.av = Float.MIN_VALUE;
    boolean bool2 = true;
    this.aw = true;
    this.A = new ViewFlinger(this);
    if (d) {
      layoutPrefetchRegistryImpl = new GapWorker.LayoutPrefetchRegistryImpl();
    } else {
      layoutPrefetchRegistryImpl = null;
    } 
    this.C = layoutPrefetchRegistryImpl;
    this.D = new State();
    this.E = false;
    this.F = false;
    this.az = new ItemAnimatorRestoreListener(this);
    this.G = false;
    this.aB = new int[2];
    this.aD = new int[2];
    this.aE = new int[2];
    this.I = new int[2];
    this.J = new ArrayList<ViewHolder>();
    this.aF = new Runnable(this) {
        public void run() {
          if (this.a.z != null)
            this.a.z.runPendingAnimations(); 
          this.a.G = false;
        }
      };
    this.aG = new ViewInfoStore.ProcessCallback(this) {
        public void processAppeared(RecyclerView.ViewHolder param1ViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2) {
          this.a.a(param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2);
        }
        
        public void processDisappeared(RecyclerView.ViewHolder param1ViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2) {
          this.a.e.c(param1ViewHolder);
          this.a.b(param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2);
        }
        
        public void processPersistent(RecyclerView.ViewHolder param1ViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo param1ItemHolderInfo2) {
          param1ViewHolder.setIsRecyclable(false);
          if (this.a.x) {
            if (this.a.z.animateChange(param1ViewHolder, param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2)) {
              this.a.n();
              return;
            } 
          } else if (this.a.z.animatePersistence(param1ViewHolder, param1ItemHolderInfo1, param1ItemHolderInfo2)) {
            this.a.n();
          } 
        }
        
        public void unused(RecyclerView.ViewHolder param1ViewHolder) {
          this.a.n.removeAndRecycleView(param1ViewHolder.itemView, this.a.e);
        }
      };
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.aq = viewConfiguration.getScaledTouchSlop();
    this.au = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, paramContext);
    this.av = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, paramContext);
    this.as = viewConfiguration.getScaledMinimumFlingVelocity();
    this.at = viewConfiguration.getScaledMaximumFlingVelocity();
    if (getOverScrollMode() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    setWillNotDraw(bool1);
    this.z.a(this.az);
    b();
    w();
    v();
    if (ViewCompat.getImportantForAccessibility((View)this) == 0)
      ViewCompat.setImportantForAccessibility((View)this, 1); 
    this.aa = (AccessibilityManager)getContext().getSystemService("accessibility");
    setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt, 0);
    if (Build.VERSION.SDK_INT >= 29)
      saveAttributeDataForStyleable(paramContext, R.styleable.RecyclerView, paramAttributeSet, typedArray, paramInt, 0); 
    String str = typedArray.getString(R.styleable.RecyclerView_layoutManager);
    if (typedArray.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1)
      setDescendantFocusability(262144); 
    this.i = typedArray.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
    this.s = typedArray.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
    if (this.s)
      a((StateListDrawable)typedArray.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArray.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)typedArray.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArray.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable)); 
    typedArray.recycle();
    a(paramContext, str, paramAttributeSet, paramInt, 0);
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 21) {
      typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, L, paramInt, 0);
      if (Build.VERSION.SDK_INT >= 29)
        saveAttributeDataForStyleable(paramContext, L, paramAttributeSet, typedArray, paramInt, 0); 
      bool1 = typedArray.getBoolean(0, true);
      typedArray.recycle();
    } 
    setNestedScrollingEnabled(bool1);
  }
  
  private void A() {
    VelocityTracker velocityTracker = this.al;
    if (velocityTracker != null)
      velocityTracker.clear(); 
    stopNestedScroll(0);
    z();
  }
  
  private void B() {
    A();
    setScrollState(0);
  }
  
  private void C() {
    int i = this.W;
    this.W = 0;
    if (i != 0 && m()) {
      AccessibilityEvent accessibilityEvent = AccessibilityEvent.obtain();
      accessibilityEvent.setEventType(2048);
      AccessibilityEventCompat.setContentChangeTypes(accessibilityEvent, i);
      sendAccessibilityEventUnchecked(accessibilityEvent);
    } 
  }
  
  private boolean D() {
    return (this.z != null && this.n.supportsPredictiveItemAnimations());
  }
  
  private void E() {
    boolean bool1;
    if (this.x) {
      this.f.a();
      if (this.y)
        this.n.onItemsChanged(this); 
    } 
    if (D()) {
      this.f.b();
    } else {
      this.f.e();
    } 
    boolean bool = this.E;
    boolean bool2 = false;
    if (bool || this.F) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    State state = this.D;
    if (this.t && this.z != null && (this.x || bool1 || this.n.u) && (!this.x || this.m.hasStableIds())) {
      bool = true;
    } else {
      bool = false;
    } 
    state.j = bool;
    state = this.D;
    bool = bool2;
    if (state.j) {
      bool = bool2;
      if (bool1) {
        bool = bool2;
        if (!this.x) {
          bool = bool2;
          if (D())
            bool = true; 
        } 
      } 
    } 
    state.k = bool;
  }
  
  private void F() {
    int i;
    long l;
    ViewHolder viewHolder1;
    boolean bool = this.aw;
    ViewHolder viewHolder2 = null;
    if (bool && hasFocus() && this.m != null) {
      viewHolder1 = (ViewHolder)getFocusedChild();
    } else {
      viewHolder1 = null;
    } 
    if (viewHolder1 == null) {
      viewHolder1 = viewHolder2;
    } else {
      viewHolder1 = findContainingViewHolder((View)viewHolder1);
    } 
    if (viewHolder1 == null) {
      G();
      return;
    } 
    State state = this.D;
    if (this.m.hasStableIds()) {
      l = viewHolder1.getItemId();
    } else {
      l = -1L;
    } 
    state.m = l;
    state = this.D;
    if (this.x) {
      i = -1;
    } else if (viewHolder1.m()) {
      i = viewHolder1.c;
    } else {
      i = viewHolder1.getAdapterPosition();
    } 
    state.l = i;
    this.D.n = g(viewHolder1.itemView);
  }
  
  private void G() {
    State state = this.D;
    state.m = -1L;
    state.l = -1;
    state.n = -1;
  }
  
  private View H() {
    if (this.D.l != -1) {
      i = this.D.l;
    } else {
      i = 0;
    } 
    int k = this.D.getItemCount();
    for (int j = i; j < k; j++) {
      ViewHolder viewHolder = findViewHolderForAdapterPosition(j);
      if (viewHolder == null)
        break; 
      if (viewHolder.itemView.hasFocusable())
        return viewHolder.itemView; 
    } 
    for (int i = Math.min(k, i) - 1; i >= 0; i--) {
      ViewHolder viewHolder = findViewHolderForAdapterPosition(i);
      if (viewHolder == null)
        return null; 
      if (viewHolder.itemView.hasFocusable())
        return viewHolder.itemView; 
    } 
    return null;
  }
  
  private void I() {
    if (this.aw && this.m != null && hasFocus() && getDescendantFocusability() != 393216) {
      View view1;
      if (getDescendantFocusability() == 131072 && isFocused())
        return; 
      if (!isFocused()) {
        view1 = getFocusedChild();
        if (N && (view1.getParent() == null || !view1.hasFocus())) {
          if (this.g.b() == 0) {
            requestFocus();
            return;
          } 
        } else if (!this.g.c(view1)) {
          return;
        } 
      } 
      long l = this.D.m;
      View view2 = null;
      if (l != -1L && this.m.hasStableIds()) {
        view1 = (View)findViewHolderForItemId(this.D.m);
      } else {
        view1 = null;
      } 
      if (view1 == null || this.g.c(((ViewHolder)view1).itemView) || !((ViewHolder)view1).itemView.hasFocusable()) {
        view1 = view2;
        if (this.g.b() > 0)
          view1 = H(); 
      } else {
        view1 = ((ViewHolder)view1).itemView;
      } 
      if (view1 != null) {
        if (this.D.n != -1L) {
          view2 = view1.findViewById(this.D.n);
          if (view2 != null && view2.isFocusable())
            view1 = view2; 
        } 
        view1.requestFocus();
      } 
    } 
  }
  
  private void J() {
    State state = this.D;
    boolean bool = true;
    state.a(1);
    a(this.D);
    this.D.i = false;
    e();
    this.h.a();
    k();
    E();
    F();
    state = this.D;
    if (!state.j || !this.F)
      bool = false; 
    state.h = bool;
    this.F = false;
    this.E = false;
    state = this.D;
    state.g = state.k;
    this.D.e = this.m.getItemCount();
    a(this.aB);
    if (this.D.j) {
      int j = this.g.b();
      for (int i = 0; i < j; i++) {
        ViewHolder viewHolder = b(this.g.b(i));
        if (!viewHolder.bf_() && (!viewHolder.j() || this.m.hasStableIds())) {
          ItemAnimator.ItemHolderInfo itemHolderInfo = this.z.recordPreLayoutInformation(this.D, viewHolder, ItemAnimator.b(viewHolder), viewHolder.r());
          this.h.a(viewHolder, itemHolderInfo);
          if (this.D.h && viewHolder.v() && !viewHolder.m() && !viewHolder.bf_() && !viewHolder.j()) {
            long l = a(viewHolder);
            this.h.a(l, viewHolder);
          } 
        } 
      } 
    } 
    if (this.D.k) {
      q();
      bool = this.D.f;
      state = this.D;
      state.f = false;
      this.n.onLayoutChildren(this.e, state);
      this.D.f = bool;
      for (int i = 0; i < this.g.b(); i++) {
        ViewHolder viewHolder = b(this.g.b(i));
        if (!viewHolder.bf_() && !this.h.d(viewHolder)) {
          int k = ItemAnimator.b(viewHolder);
          bool = viewHolder.a(8192);
          int j = k;
          if (!bool)
            j = k | 0x1000; 
          ItemAnimator.ItemHolderInfo itemHolderInfo = this.z.recordPreLayoutInformation(this.D, viewHolder, j, viewHolder.r());
          if (bool) {
            a(viewHolder, itemHolderInfo);
          } else {
            this.h.b(viewHolder, itemHolderInfo);
          } 
        } 
      } 
      r();
    } else {
      r();
    } 
    l();
    a(false);
    this.D.d = 2;
  }
  
  private void K() {
    boolean bool;
    e();
    k();
    this.D.a(6);
    this.f.e();
    this.D.e = this.m.getItemCount();
    State state = this.D;
    state.c = 0;
    state.g = false;
    this.n.onLayoutChildren(this.e, state);
    state = this.D;
    state.f = false;
    this.Q = null;
    if (state.j && this.z != null) {
      bool = true;
    } else {
      bool = false;
    } 
    state.j = bool;
    this.D.d = 4;
    l();
    a(false);
  }
  
  private void L() {
    this.D.a(4);
    e();
    k();
    State state = this.D;
    state.d = 1;
    if (state.j) {
      for (int i = this.g.b() - 1; i >= 0; i--) {
        ViewHolder viewHolder = b(this.g.b(i));
        if (!viewHolder.bf_()) {
          long l = a(viewHolder);
          ItemAnimator.ItemHolderInfo itemHolderInfo = this.z.recordPostLayoutInformation(this.D, viewHolder);
          ViewHolder viewHolder1 = this.h.a(l);
          if (viewHolder1 != null && !viewHolder1.bf_()) {
            boolean bool1 = this.h.a(viewHolder1);
            boolean bool2 = this.h.a(viewHolder);
            if (bool1 && viewHolder1 == viewHolder) {
              this.h.c(viewHolder, itemHolderInfo);
            } else {
              ItemAnimator.ItemHolderInfo itemHolderInfo1 = this.h.b(viewHolder1);
              this.h.c(viewHolder, itemHolderInfo);
              itemHolderInfo = this.h.c(viewHolder);
              if (itemHolderInfo1 == null) {
                a(l, viewHolder, viewHolder1);
              } else {
                a(viewHolder1, viewHolder, itemHolderInfo1, itemHolderInfo, bool1, bool2);
              } 
            } 
          } else {
            this.h.c(viewHolder, itemHolderInfo);
          } 
        } 
      } 
      this.h.a(this.aG);
    } 
    this.n.a(this.e);
    state = this.D;
    state.b = state.e;
    this.x = false;
    this.y = false;
    state = this.D;
    state.j = false;
    state.k = false;
    this.n.u = false;
    if (this.e.b != null)
      this.e.b.clear(); 
    if (this.n.y) {
      LayoutManager layoutManager = this.n;
      layoutManager.x = 0;
      layoutManager.y = false;
      this.e.a();
    } 
    this.n.onLayoutCompleted(this.D);
    l();
    a(false);
    this.h.a();
    int[] arrayOfInt = this.aB;
    if (g(arrayOfInt[0], arrayOfInt[1]))
      f(0, 0); 
    I();
    G();
  }
  
  private String a(Context paramContext, String paramString) {
    if (paramString.charAt(0) == '.') {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramContext.getPackageName());
      stringBuilder1.append(paramString);
      return stringBuilder1.toString();
    } 
    if (paramString.contains("."))
      return paramString; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(RecyclerView.class.getPackage().getName());
    stringBuilder.append('.');
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    // Byte code:
    //   0: iconst_1
    //   1: istore #6
    //   3: fload_2
    //   4: fconst_0
    //   5: fcmpg
    //   6: ifge -> 43
    //   9: aload_0
    //   10: invokevirtual f : ()V
    //   13: aload_0
    //   14: getfield af : Landroid/widget/EdgeEffect;
    //   17: fload_2
    //   18: fneg
    //   19: aload_0
    //   20: invokevirtual getWidth : ()I
    //   23: i2f
    //   24: fdiv
    //   25: fconst_1
    //   26: fload_3
    //   27: aload_0
    //   28: invokevirtual getHeight : ()I
    //   31: i2f
    //   32: fdiv
    //   33: fsub
    //   34: invokestatic onPull : (Landroid/widget/EdgeEffect;FF)V
    //   37: iconst_1
    //   38: istore #5
    //   40: goto -> 80
    //   43: fload_2
    //   44: fconst_0
    //   45: fcmpl
    //   46: ifle -> 77
    //   49: aload_0
    //   50: invokevirtual aC_ : ()V
    //   53: aload_0
    //   54: getfield ah : Landroid/widget/EdgeEffect;
    //   57: fload_2
    //   58: aload_0
    //   59: invokevirtual getWidth : ()I
    //   62: i2f
    //   63: fdiv
    //   64: fload_3
    //   65: aload_0
    //   66: invokevirtual getHeight : ()I
    //   69: i2f
    //   70: fdiv
    //   71: invokestatic onPull : (Landroid/widget/EdgeEffect;FF)V
    //   74: goto -> 37
    //   77: iconst_0
    //   78: istore #5
    //   80: fload #4
    //   82: fconst_0
    //   83: fcmpg
    //   84: ifge -> 121
    //   87: aload_0
    //   88: invokevirtual h : ()V
    //   91: aload_0
    //   92: getfield ag : Landroid/widget/EdgeEffect;
    //   95: fload #4
    //   97: fneg
    //   98: aload_0
    //   99: invokevirtual getHeight : ()I
    //   102: i2f
    //   103: fdiv
    //   104: fload_1
    //   105: aload_0
    //   106: invokevirtual getWidth : ()I
    //   109: i2f
    //   110: fdiv
    //   111: invokestatic onPull : (Landroid/widget/EdgeEffect;FF)V
    //   114: iload #6
    //   116: istore #5
    //   118: goto -> 163
    //   121: fload #4
    //   123: fconst_0
    //   124: fcmpl
    //   125: ifle -> 163
    //   128: aload_0
    //   129: invokevirtual i : ()V
    //   132: aload_0
    //   133: getfield ai : Landroid/widget/EdgeEffect;
    //   136: fload #4
    //   138: aload_0
    //   139: invokevirtual getHeight : ()I
    //   142: i2f
    //   143: fdiv
    //   144: fconst_1
    //   145: fload_1
    //   146: aload_0
    //   147: invokevirtual getWidth : ()I
    //   150: i2f
    //   151: fdiv
    //   152: fsub
    //   153: invokestatic onPull : (Landroid/widget/EdgeEffect;FF)V
    //   156: iload #6
    //   158: istore #5
    //   160: goto -> 163
    //   163: iload #5
    //   165: ifne -> 181
    //   168: fload_2
    //   169: fconst_0
    //   170: fcmpl
    //   171: ifne -> 181
    //   174: fload #4
    //   176: fconst_0
    //   177: fcmpl
    //   178: ifeq -> 185
    //   181: aload_0
    //   182: invokestatic postInvalidateOnAnimation : (Landroid/view/View;)V
    //   185: return
  }
  
  private void a(long paramLong, ViewHolder paramViewHolder1, ViewHolder paramViewHolder2) {
    StringBuilder stringBuilder1;
    int j = this.g.b();
    int i;
    for (i = 0; i < j; i++) {
      ViewHolder viewHolder = b(this.g.b(i));
      if (viewHolder != paramViewHolder1 && a(viewHolder) == paramLong) {
        Adapter adapter = this.m;
        if (adapter != null && adapter.hasStableIds()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          stringBuilder.append(viewHolder);
          stringBuilder.append(" \n View Holder 2:");
          stringBuilder.append(paramViewHolder1);
          stringBuilder.append(a());
          throw new IllegalStateException(stringBuilder.toString());
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        stringBuilder1.append(viewHolder);
        stringBuilder1.append(" \n View Holder 2:");
        stringBuilder1.append(paramViewHolder1);
        stringBuilder1.append(a());
        throw new IllegalStateException(stringBuilder1.toString());
      } 
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    stringBuilder2.append(stringBuilder1);
    stringBuilder2.append(" cannot be found but it is necessary for ");
    stringBuilder2.append(paramViewHolder1);
    stringBuilder2.append(a());
    Log.e("RecyclerView", stringBuilder2.toString());
  }
  
  private void a(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    if (paramString != null) {
      paramString = paramString.trim();
      if (!paramString.isEmpty()) {
        String str = a(paramContext, paramString);
        try {
          StringBuilder stringBuilder;
          ClassLoader classLoader;
          if (isInEditMode()) {
            classLoader = getClass().getClassLoader();
          } else {
            classLoader = paramContext.getClassLoader();
          } 
          Class<? extends LayoutManager> clazz = Class.forName(str, false, classLoader).asSubclass(LayoutManager.class);
          NoSuchMethodException noSuchMethodException2 = null;
          try {
            Constructor<? extends LayoutManager> constructor = clazz.getConstructor(O);
            Object[] arrayOfObject = { paramContext, paramAttributeSet, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) };
          } catch (NoSuchMethodException noSuchMethodException) {
            try {
              Constructor<? extends LayoutManager> constructor = clazz.getConstructor(new Class[0]);
              noSuchMethodException = noSuchMethodException2;
              constructor.setAccessible(true);
              setLayoutManager(constructor.newInstance((Object[])noSuchMethodException));
              return;
            } catch (NoSuchMethodException noSuchMethodException1) {
              noSuchMethodException1.initCause(noSuchMethodException);
              stringBuilder = new StringBuilder();
              stringBuilder.append(paramAttributeSet.getPositionDescription());
              stringBuilder.append(": Error creating LayoutManager ");
              stringBuilder.append(str);
              throw new IllegalStateException(stringBuilder.toString(), noSuchMethodException1);
            } 
          } 
          noSuchMethodException1.setAccessible(true);
          setLayoutManager(noSuchMethodException1.newInstance((Object[])stringBuilder));
          return;
        } catch (ClassNotFoundException classNotFoundException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Unable to find LayoutManager ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), classNotFoundException);
        } catch (InvocationTargetException invocationTargetException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Could not instantiate the LayoutManager: ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), invocationTargetException);
        } catch (InstantiationException instantiationException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Could not instantiate the LayoutManager: ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), instantiationException);
        } catch (IllegalAccessException illegalAccessException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Cannot access non-public constructor ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), illegalAccessException);
        } catch (ClassCastException classCastException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramAttributeSet.getPositionDescription());
          stringBuilder.append(": Class is not a LayoutManager ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString(), classCastException);
        } 
      } 
    } 
  }
  
  static void a(View paramView, Rect paramRect) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect rect = layoutParams.d;
    paramRect.set(paramView.getLeft() - rect.left - layoutParams.leftMargin, paramView.getTop() - rect.top - layoutParams.topMargin, paramView.getRight() + rect.right + layoutParams.rightMargin, paramView.getBottom() + rect.bottom + layoutParams.bottomMargin);
  }
  
  private void a(View paramView1, View paramView2) {
    boolean bool;
    View view;
    if (paramView2 != null) {
      view = paramView2;
    } else {
      view = paramView1;
    } 
    this.k.set(0, 0, view.getWidth(), view.getHeight());
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    if (layoutParams instanceof LayoutParams) {
      LayoutParams layoutParams1 = (LayoutParams)layoutParams;
      if (!layoutParams1.e) {
        Rect rect1 = layoutParams1.d;
        Rect rect2 = this.k;
        rect2.left -= rect1.left;
        rect2 = this.k;
        rect2.right += rect1.right;
        rect2 = this.k;
        rect2.top -= rect1.top;
        rect2 = this.k;
        rect2.bottom += rect1.bottom;
      } 
    } 
    if (paramView2 != null) {
      offsetDescendantRectToMyCoords(paramView2, this.k);
      offsetRectIntoDescendantCoords(paramView1, this.k);
    } 
    LayoutManager layoutManager = this.n;
    Rect rect = this.k;
    boolean bool1 = this.t;
    if (paramView2 == null) {
      bool = true;
    } else {
      bool = false;
    } 
    layoutManager.requestChildRectangleOnScreen(this, paramView1, rect, bool1 ^ true, bool);
  }
  
  private void a(Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2) {
    Adapter adapter = this.m;
    if (adapter != null) {
      adapter.unregisterAdapterDataObserver(this.P);
      this.m.onDetachedFromRecyclerView(this);
    } 
    if (!paramBoolean1 || paramBoolean2)
      c(); 
    this.f.a();
    adapter = this.m;
    this.m = paramAdapter;
    if (paramAdapter != null) {
      paramAdapter.registerAdapterDataObserver(this.P);
      paramAdapter.onAttachedToRecyclerView(this);
    } 
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      layoutManager.onAdapterChanged(adapter, this.m); 
    this.e.a(adapter, this.m, paramBoolean1);
    this.D.f = true;
  }
  
  private void a(ViewHolder paramViewHolder1, ViewHolder paramViewHolder2, ItemAnimator.ItemHolderInfo paramItemHolderInfo1, ItemAnimator.ItemHolderInfo paramItemHolderInfo2, boolean paramBoolean1, boolean paramBoolean2) {
    paramViewHolder1.setIsRecyclable(false);
    if (paramBoolean1)
      e(paramViewHolder1); 
    if (paramViewHolder1 != paramViewHolder2) {
      if (paramBoolean2)
        e(paramViewHolder2); 
      paramViewHolder1.g = paramViewHolder2;
      e(paramViewHolder1);
      this.e.c(paramViewHolder1);
      paramViewHolder2.setIsRecyclable(false);
      paramViewHolder2.h = paramViewHolder1;
    } 
    if (this.z.animateChange(paramViewHolder1, paramViewHolder2, paramItemHolderInfo1, paramItemHolderInfo2))
      n(); 
  }
  
  private void a(int[] paramArrayOfint) {
    int m = this.g.b();
    if (m == 0) {
      paramArrayOfint[0] = -1;
      paramArrayOfint[1] = -1;
      return;
    } 
    int k = 0;
    int i = Integer.MAX_VALUE;
    int j;
    for (j = Integer.MIN_VALUE; k < m; j = n) {
      int n;
      ViewHolder viewHolder = b(this.g.b(k));
      if (viewHolder.bf_()) {
        n = j;
      } else {
        int i2 = viewHolder.getLayoutPosition();
        int i1 = i;
        if (i2 < i)
          i1 = i2; 
        i = i1;
        n = j;
        if (i2 > j) {
          n = i2;
          i = i1;
        } 
      } 
      k++;
    } 
    paramArrayOfint[0] = i;
    paramArrayOfint[1] = j;
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    OnItemTouchListener onItemTouchListener = this.T;
    if (onItemTouchListener == null)
      return (paramMotionEvent.getAction() == 0) ? false : b(paramMotionEvent); 
    onItemTouchListener.onTouchEvent(this, paramMotionEvent);
    int i = paramMotionEvent.getAction();
    if (i == 3 || i == 1)
      this.T = null; 
    return true;
  }
  
  private boolean a(View paramView1, View paramView2, int paramInt) {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool1 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    null = bool6;
    if (paramView2 != null) {
      byte b1;
      if (paramView2 == this)
        return false; 
      if (findContainingItemView(paramView2) == null)
        return false; 
      if (paramView1 == null)
        return true; 
      if (findContainingItemView(paramView1) == null)
        return true; 
      this.k.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
      this.R.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView1, this.k);
      offsetDescendantRectToMyCoords(paramView2, this.R);
      int i = this.n.getLayoutDirection();
      byte b = -1;
      if (i == 1) {
        b1 = -1;
      } else {
        b1 = 1;
      } 
      if ((this.k.left < this.R.left || this.k.right <= this.R.left) && this.k.right < this.R.right) {
        i = 1;
      } else if ((this.k.right > this.R.right || this.k.left >= this.R.right) && this.k.left > this.R.left) {
        i = -1;
      } else {
        i = 0;
      } 
      if ((this.k.top < this.R.top || this.k.bottom <= this.R.top) && this.k.bottom < this.R.bottom) {
        b = 1;
      } else if ((this.k.bottom <= this.R.bottom && this.k.top < this.R.bottom) || this.k.top <= this.R.top) {
        b = 0;
      } 
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 17) {
            if (paramInt != 33) {
              if (paramInt != 66) {
                if (paramInt == 130) {
                  null = bool2;
                  if (b > 0)
                    null = true; 
                  return null;
                } 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid direction: ");
                stringBuilder.append(paramInt);
                stringBuilder.append(a());
                throw new IllegalArgumentException(stringBuilder.toString());
              } 
              null = bool3;
              if (i > 0)
                null = true; 
              return null;
            } 
            null = bool4;
            if (b < 0)
              null = true; 
            return null;
          } 
          null = bool5;
          if (i < 0)
            null = true; 
          return null;
        } 
        if (b <= 0) {
          null = bool1;
          if (b == 0) {
            null = bool1;
            if (i * b1 >= 0)
              return true; 
          } 
          return null;
        } 
      } else {
        if (b >= 0) {
          null = bool6;
          if (b == 0) {
            null = bool6;
            if (i * b1 <= 0)
              null = true; 
          } 
          return null;
        } 
        null = true;
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  static ViewHolder b(View paramView) {
    return (paramView == null) ? null : ((LayoutParams)paramView.getLayoutParams()).c;
  }
  
  private boolean b(MotionEvent paramMotionEvent) {
    int j = paramMotionEvent.getAction();
    int k = this.S.size();
    for (int i = 0; i < k; i++) {
      OnItemTouchListener onItemTouchListener = this.S.get(i);
      if (onItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent) && j != 3) {
        this.T = onItemTouchListener;
        return true;
      } 
    } 
    return false;
  }
  
  private void c(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.ak) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.ak = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.ao = j;
      this.am = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.ap = i;
      this.an = i;
    } 
  }
  
  static void c(ViewHolder paramViewHolder) {
    if (paramViewHolder.a != null) {
      View view = (View)paramViewHolder.a.get();
      while (view != null) {
        if (view == paramViewHolder.itemView)
          return; 
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
          View view1 = (View)viewParent;
          continue;
        } 
        viewParent = null;
      } 
      paramViewHolder.a = null;
    } 
  }
  
  static RecyclerView d(View paramView) {
    if (!(paramView instanceof ViewGroup))
      return null; 
    if (paramView instanceof RecyclerView)
      return (RecyclerView)paramView; 
    ViewGroup viewGroup = (ViewGroup)paramView;
    int j = viewGroup.getChildCount();
    for (int i = 0; i < j; i++) {
      RecyclerView recyclerView = d(viewGroup.getChildAt(i));
      if (recyclerView != null)
        return recyclerView; 
    } 
    return null;
  }
  
  private void e(ViewHolder paramViewHolder) {
    boolean bool;
    View view = paramViewHolder.itemView;
    if (view.getParent() == this) {
      bool = true;
    } else {
      bool = false;
    } 
    this.e.c(getChildViewHolder(view));
    if (paramViewHolder.n()) {
      this.g.a(view, -1, view.getLayoutParams(), true);
      return;
    } 
    if (!bool) {
      this.g.a(view, true);
      return;
    } 
    this.g.d(view);
  }
  
  private int g(View paramView) {
    int i = paramView.getId();
    while (!paramView.isFocused() && paramView instanceof ViewGroup && paramView.hasFocus()) {
      View view = ((ViewGroup)paramView).getFocusedChild();
      paramView = view;
      if (view.getId() != -1) {
        i = view.getId();
        paramView = view;
      } 
    } 
    return i;
  }
  
  private boolean g(int paramInt1, int paramInt2) {
    a(this.aB);
    int[] arrayOfInt = this.aB;
    boolean bool = false;
    if (arrayOfInt[0] != paramInt1 || arrayOfInt[1] != paramInt2)
      bool = true; 
    return bool;
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper() {
    if (this.aC == null)
      this.aC = new NestedScrollingChildHelper((View)this); 
    return this.aC;
  }
  
  private void v() {
    if (ViewCompat.getImportantForAutofill((View)this) == 0)
      ViewCompat.setImportantForAutofill((View)this, 8); 
  }
  
  private void w() {
    this.g = new ChildHelper(new ChildHelper.Callback(this) {
          public void addView(View param1View, int param1Int) {
            this.a.addView(param1View, param1Int);
            this.a.f(param1View);
          }
          
          public void attachViewToParent(View param1View, int param1Int, ViewGroup.LayoutParams param1LayoutParams) {
            StringBuilder stringBuilder;
            RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
            if (viewHolder != null)
              if (viewHolder.n() || viewHolder.bf_()) {
                viewHolder.h();
              } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Called attach on a child which is not detached: ");
                stringBuilder.append(viewHolder);
                stringBuilder.append(this.a.a());
                throw new IllegalArgumentException(stringBuilder.toString());
              }  
            RecyclerView.a(this.a, (View)stringBuilder, param1Int, param1LayoutParams);
          }
          
          public void detachViewFromParent(int param1Int) {
            View view = getChildAt(param1Int);
            if (view != null) {
              RecyclerView.ViewHolder viewHolder = RecyclerView.b(view);
              if (viewHolder != null)
                if (!viewHolder.n() || viewHolder.bf_()) {
                  viewHolder.b(256);
                } else {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("called detach on an already detached child ");
                  stringBuilder.append(viewHolder);
                  stringBuilder.append(this.a.a());
                  throw new IllegalArgumentException(stringBuilder.toString());
                }  
            } 
            RecyclerView.a(this.a, param1Int);
          }
          
          public View getChildAt(int param1Int) {
            return this.a.getChildAt(param1Int);
          }
          
          public int getChildCount() {
            return this.a.getChildCount();
          }
          
          public RecyclerView.ViewHolder getChildViewHolder(View param1View) {
            return RecyclerView.b(param1View);
          }
          
          public int indexOfChild(View param1View) {
            return this.a.indexOfChild(param1View);
          }
          
          public void onEnteredHiddenState(View param1View) {
            RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
            if (viewHolder != null)
              viewHolder.a(this.a); 
          }
          
          public void onLeftHiddenState(View param1View) {
            RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
            if (viewHolder != null)
              viewHolder.b(this.a); 
          }
          
          public void removeAllViews() {
            int j = getChildCount();
            for (int i = 0; i < j; i++) {
              View view = getChildAt(i);
              this.a.e(view);
              view.clearAnimation();
            } 
            this.a.removeAllViews();
          }
          
          public void removeViewAt(int param1Int) {
            View view = this.a.getChildAt(param1Int);
            if (view != null) {
              this.a.e(view);
              view.clearAnimation();
            } 
            this.a.removeViewAt(param1Int);
          }
        });
  }
  
  private boolean x() {
    int j = this.g.b();
    for (int i = 0; i < j; i++) {
      ViewHolder viewHolder = b(this.g.b(i));
      if (viewHolder != null && !viewHolder.bf_() && viewHolder.v())
        return true; 
    } 
    return false;
  }
  
  private void y() {
    this.A.stop();
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      layoutManager.f(); 
  }
  
  private void z() {
    EdgeEffect edgeEffect = this.af;
    if (edgeEffect != null) {
      edgeEffect.onRelease();
      bool2 = this.af.isFinished();
    } else {
      bool2 = false;
    } 
    edgeEffect = this.ag;
    boolean bool1 = bool2;
    if (edgeEffect != null) {
      edgeEffect.onRelease();
      bool1 = bool2 | this.ag.isFinished();
    } 
    edgeEffect = this.ah;
    boolean bool2 = bool1;
    if (edgeEffect != null) {
      edgeEffect.onRelease();
      bool2 = bool1 | this.ah.isFinished();
    } 
    edgeEffect = this.ai;
    bool1 = bool2;
    if (edgeEffect != null) {
      edgeEffect.onRelease();
      bool1 = bool2 | this.ai.isFinished();
    } 
    if (bool1)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  long a(ViewHolder paramViewHolder) {
    return this.m.hasStableIds() ? paramViewHolder.getItemId() : paramViewHolder.b;
  }
  
  ViewHolder a(int paramInt, boolean paramBoolean) {
    int j = this.g.c();
    Object object = null;
    int i = 0;
    while (i < j) {
      ViewHolder viewHolder = b(this.g.d(i));
      Object object1 = object;
      if (viewHolder != null) {
        object1 = object;
        if (!viewHolder.m()) {
          if (paramBoolean) {
            if (viewHolder.b != paramInt) {
              object1 = object;
              continue;
            } 
          } else if (viewHolder.getLayoutPosition() != paramInt) {
            object1 = object;
            continue;
          } 
          if (this.g.c(viewHolder.itemView)) {
            object1 = viewHolder;
          } else {
            return viewHolder;
          } 
        } 
      } 
      continue;
      i++;
      object = SYNTHETIC_LOCAL_VARIABLE_6;
    } 
    return (ViewHolder)object;
  }
  
  String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" ");
    stringBuilder.append(toString());
    stringBuilder.append(", adapter:");
    stringBuilder.append(this.m);
    stringBuilder.append(", layout:");
    stringBuilder.append(this.n);
    stringBuilder.append(", context:");
    stringBuilder.append(getContext());
    return stringBuilder.toString();
  }
  
  void a(int paramInt) {
    if (this.n == null)
      return; 
    setScrollState(2);
    this.n.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  void a(int paramInt1, int paramInt2) {
    EdgeEffect edgeEffect = this.af;
    if (edgeEffect != null && !edgeEffect.isFinished() && paramInt1 > 0) {
      this.af.onRelease();
      bool2 = this.af.isFinished();
    } else {
      bool2 = false;
    } 
    edgeEffect = this.ah;
    boolean bool1 = bool2;
    if (edgeEffect != null) {
      bool1 = bool2;
      if (!edgeEffect.isFinished()) {
        bool1 = bool2;
        if (paramInt1 < 0) {
          this.ah.onRelease();
          bool1 = bool2 | this.ah.isFinished();
        } 
      } 
    } 
    edgeEffect = this.ag;
    boolean bool2 = bool1;
    if (edgeEffect != null) {
      bool2 = bool1;
      if (!edgeEffect.isFinished()) {
        bool2 = bool1;
        if (paramInt2 > 0) {
          this.ag.onRelease();
          bool2 = bool1 | this.ag.isFinished();
        } 
      } 
    } 
    edgeEffect = this.ai;
    bool1 = bool2;
    if (edgeEffect != null) {
      bool1 = bool2;
      if (!edgeEffect.isFinished()) {
        bool1 = bool2;
        if (paramInt2 < 0) {
          this.ai.onRelease();
          bool1 = bool2 | this.ai.isFinished();
        } 
      } 
    } 
    if (bool1)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  void a(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3, boolean paramBoolean) {
    LayoutManager layoutManager = this.n;
    if (layoutManager == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    if (this.v)
      return; 
    boolean bool = layoutManager.canScrollHorizontally();
    int j = 0;
    int i = paramInt1;
    if (!bool)
      i = 0; 
    if (!this.n.canScrollVertically())
      paramInt2 = 0; 
    if (i != 0 || paramInt2 != 0) {
      if (paramInt3 == Integer.MIN_VALUE || paramInt3 > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      } 
      if (paramInt1 != 0) {
        if (paramBoolean) {
          paramInt1 = j;
          if (i != 0)
            paramInt1 = 1; 
          j = paramInt1;
          if (paramInt2 != 0)
            j = paramInt1 | 0x2; 
          startNestedScroll(j, 1);
        } 
        this.A.smoothScrollBy(i, paramInt2, paramInt3, paramInterpolator);
        return;
      } 
      scrollBy(i, paramInt2);
    } 
  }
  
  void a(int paramInt1, int paramInt2, Object paramObject) {
    int j = this.g.c();
    int i;
    for (i = 0; i < j; i++) {
      View view = this.g.d(i);
      ViewHolder viewHolder = b(view);
      if (viewHolder != null && !viewHolder.bf_() && viewHolder.b >= paramInt1 && viewHolder.b < paramInt1 + paramInt2) {
        viewHolder.b(2);
        viewHolder.a(paramObject);
        ((LayoutParams)view.getLayoutParams()).e = true;
      } 
    } 
    this.e.c(paramInt1, paramInt2);
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    int j = this.g.c();
    int i;
    for (i = 0; i < j; i++) {
      ViewHolder viewHolder = b(this.g.d(i));
      if (viewHolder != null && !viewHolder.bf_())
        if (viewHolder.b >= paramInt1 + paramInt2) {
          viewHolder.a(-paramInt2, paramBoolean);
          this.D.f = true;
        } else if (viewHolder.b >= paramInt1) {
          viewHolder.a(paramInt1 - 1, -paramInt2, paramBoolean);
          this.D.f = true;
        }  
    } 
    this.e.a(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  void a(int paramInt1, int paramInt2, int[] paramArrayOfint) {
    e();
    k();
    TraceCompat.beginSection("RV Scroll");
    a(this.D);
    if (paramInt1 != 0) {
      paramInt1 = this.n.scrollHorizontallyBy(paramInt1, this.e, this.D);
    } else {
      paramInt1 = 0;
    } 
    if (paramInt2 != 0) {
      paramInt2 = this.n.scrollVerticallyBy(paramInt2, this.e, this.D);
    } else {
      paramInt2 = 0;
    } 
    TraceCompat.endSection();
    t();
    l();
    a(false);
    if (paramArrayOfint != null) {
      paramArrayOfint[0] = paramInt1;
      paramArrayOfint[1] = paramInt2;
    } 
  }
  
  void a(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2) {
    if (paramStateListDrawable1 != null && paramDrawable1 != null && paramStateListDrawable2 != null && paramDrawable2 != null) {
      Resources resources = getContext().getResources();
      new FastScroller(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Trying to set fast scroller without both required drawables.");
    stringBuilder.append(a());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  final void a(State paramState) {
    if (getScrollState() == 2) {
      OverScroller overScroller = this.A.a;
      paramState.o = overScroller.getFinalX() - overScroller.getCurrX();
      paramState.p = overScroller.getFinalY() - overScroller.getCurrY();
      return;
    } 
    paramState.o = 0;
    paramState.p = 0;
  }
  
  void a(ViewHolder paramViewHolder, ItemAnimator.ItemHolderInfo paramItemHolderInfo) {
    paramViewHolder.a(0, 8192);
    if (this.D.h && paramViewHolder.v() && !paramViewHolder.m() && !paramViewHolder.bf_()) {
      long l = a(paramViewHolder);
      this.h.a(l, paramViewHolder);
    } 
    this.h.a(paramViewHolder, paramItemHolderInfo);
  }
  
  void a(ViewHolder paramViewHolder, ItemAnimator.ItemHolderInfo paramItemHolderInfo1, ItemAnimator.ItemHolderInfo paramItemHolderInfo2) {
    paramViewHolder.setIsRecyclable(false);
    if (this.z.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2))
      n(); 
  }
  
  void a(String paramString) {
    if (!isComputingLayout()) {
      StringBuilder stringBuilder1;
      if (paramString == null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
        stringBuilder1.append(a());
        throw new IllegalStateException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append((String)stringBuilder1);
      stringBuilder2.append(a());
      throw new IllegalStateException(stringBuilder2.toString());
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (this.U < 1)
      this.U = 1; 
    if (!paramBoolean && !this.v)
      this.u = false; 
    if (this.U == 1) {
      if (paramBoolean && this.u && !this.v && this.n != null && this.m != null)
        o(); 
      if (!this.v)
        this.u = false; 
    } 
    this.U--;
  }
  
  boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent) {
    boolean bool1;
    boolean bool2;
    byte b1;
    byte b2;
    boolean bool3;
    d();
    Adapter adapter = this.m;
    boolean bool5 = true;
    if (adapter != null) {
      int[] arrayOfInt = this.I;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      a(paramInt1, paramInt2, arrayOfInt);
      arrayOfInt = this.I;
      b1 = arrayOfInt[0];
      b2 = arrayOfInt[1];
      bool2 = b2;
      bool1 = b1;
      b1 = paramInt1 - b1;
      b2 = paramInt2 - b2;
    } else {
      bool1 = false;
      bool2 = false;
      b1 = 0;
      b2 = 0;
    } 
    if (!this.p.isEmpty())
      invalidate(); 
    int[] arrayOfInt1 = this.I;
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    dispatchNestedScroll(bool1, bool2, b1, b2, this.aD, 0, arrayOfInt1);
    arrayOfInt1 = this.I;
    int i = arrayOfInt1[0];
    int j = arrayOfInt1[1];
    if (arrayOfInt1[0] != 0 || arrayOfInt1[1] != 0) {
      bool3 = true;
    } else {
      bool3 = false;
    } 
    int k = this.ao;
    arrayOfInt1 = this.aD;
    this.ao = k - arrayOfInt1[0];
    this.ap -= arrayOfInt1[1];
    int[] arrayOfInt2 = this.aE;
    arrayOfInt2[0] = arrayOfInt2[0] + arrayOfInt1[0];
    arrayOfInt2[1] = arrayOfInt2[1] + arrayOfInt1[1];
    if (getOverScrollMode() != 2) {
      if (paramMotionEvent != null && !MotionEventCompat.isFromSource(paramMotionEvent, 8194))
        a(paramMotionEvent.getX(), (b1 - i), paramMotionEvent.getY(), (b2 - j)); 
      a(paramInt1, paramInt2);
    } 
    if (bool1 || bool2)
      f(bool1, bool2); 
    if (!awakenScrollBars())
      invalidate(); 
    boolean bool4 = bool5;
    if (!bool3) {
      bool4 = bool5;
      if (!bool1) {
        if (bool2)
          return true; 
        bool4 = false;
      } 
    } 
    return bool4;
  }
  
  boolean a(View paramView) {
    e();
    boolean bool = this.g.f(paramView);
    if (bool) {
      ViewHolder viewHolder = b(paramView);
      this.e.c(viewHolder);
      this.e.b(viewHolder);
    } 
    a(bool ^ true);
    return bool;
  }
  
  boolean a(AccessibilityEvent paramAccessibilityEvent) {
    if (isComputingLayout()) {
      boolean bool1;
      if (paramAccessibilityEvent != null) {
        bool1 = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);
      } else {
        bool1 = false;
      } 
      boolean bool2 = bool1;
      if (!bool1)
        bool2 = false; 
      this.W = bool2 | this.W;
      return true;
    } 
    return false;
  }
  
  boolean a(ViewHolder paramViewHolder, int paramInt) {
    if (isComputingLayout()) {
      paramViewHolder.n = paramInt;
      this.J.add(paramViewHolder);
      return false;
    } 
    ViewCompat.setImportantForAccessibility(paramViewHolder.itemView, paramInt);
    return true;
  }
  
  void aC_() {
    if (this.ah != null)
      return; 
    this.ah = this.ae.a(this, 2);
    if (this.i) {
      this.ah.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    } 
    this.ah.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2) {
    LayoutManager layoutManager = this.n;
    if (layoutManager == null || !layoutManager.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))
      super.addFocusables(paramArrayList, paramInt1, paramInt2); 
  }
  
  public void addItemDecoration(ItemDecoration paramItemDecoration) {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(ItemDecoration paramItemDecoration, int paramInt) {
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout"); 
    if (this.p.isEmpty())
      setWillNotDraw(false); 
    if (paramInt < 0) {
      this.p.add(paramItemDecoration);
    } else {
      this.p.add(paramInt, paramItemDecoration);
    } 
    p();
    requestLayout();
  }
  
  public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener) {
    if (this.ab == null)
      this.ab = new ArrayList<OnChildAttachStateChangeListener>(); 
    this.ab.add(paramOnChildAttachStateChangeListener);
  }
  
  public void addOnItemTouchListener(OnItemTouchListener paramOnItemTouchListener) {
    this.S.add(paramOnItemTouchListener);
  }
  
  public void addOnScrollListener(OnScrollListener paramOnScrollListener) {
    if (this.ay == null)
      this.ay = new ArrayList<OnScrollListener>(); 
    this.ay.add(paramOnScrollListener);
  }
  
  void b() {
    this.f = new AdapterHelper(new AdapterHelper.Callback(this) {
          void a(AdapterHelper.UpdateOp param1UpdateOp) {
            int i = param1UpdateOp.a;
            if (i != 1) {
              if (i != 2) {
                if (i != 4) {
                  if (i != 8)
                    return; 
                  this.a.n.onItemsMoved(this.a, param1UpdateOp.b, param1UpdateOp.d, 1);
                  return;
                } 
                this.a.n.onItemsUpdated(this.a, param1UpdateOp.b, param1UpdateOp.d, param1UpdateOp.c);
                return;
              } 
              this.a.n.onItemsRemoved(this.a, param1UpdateOp.b, param1UpdateOp.d);
              return;
            } 
            this.a.n.onItemsAdded(this.a, param1UpdateOp.b, param1UpdateOp.d);
          }
          
          public RecyclerView.ViewHolder findViewHolder(int param1Int) {
            RecyclerView.ViewHolder viewHolder = this.a.a(param1Int, true);
            return (viewHolder == null) ? null : (this.a.g.c(viewHolder.itemView) ? null : viewHolder);
          }
          
          public void markViewHoldersUpdated(int param1Int1, int param1Int2, Object param1Object) {
            this.a.a(param1Int1, param1Int2, param1Object);
            this.a.F = true;
          }
          
          public void offsetPositionsForAdd(int param1Int1, int param1Int2) {
            this.a.e(param1Int1, param1Int2);
            this.a.E = true;
          }
          
          public void offsetPositionsForMove(int param1Int1, int param1Int2) {
            this.a.d(param1Int1, param1Int2);
            this.a.E = true;
          }
          
          public void offsetPositionsForRemovingInvisible(int param1Int1, int param1Int2) {
            this.a.a(param1Int1, param1Int2, true);
            RecyclerView recyclerView = this.a;
            recyclerView.E = true;
            RecyclerView.State state = recyclerView.D;
            state.c += param1Int2;
          }
          
          public void offsetPositionsForRemovingLaidOutOrNewView(int param1Int1, int param1Int2) {
            this.a.a(param1Int1, param1Int2, false);
            this.a.E = true;
          }
          
          public void onDispatchFirstPass(AdapterHelper.UpdateOp param1UpdateOp) {
            a(param1UpdateOp);
          }
          
          public void onDispatchSecondPass(AdapterHelper.UpdateOp param1UpdateOp) {
            a(param1UpdateOp);
          }
        });
  }
  
  void b(int paramInt) {
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      layoutManager.onScrollStateChanged(paramInt); 
    onScrollStateChanged(paramInt);
    OnScrollListener onScrollListener = this.ax;
    if (onScrollListener != null)
      onScrollListener.onScrollStateChanged(this, paramInt); 
    List<OnScrollListener> list = this.ay;
    if (list != null)
      for (int i = list.size() - 1; i >= 0; i--)
        ((OnScrollListener)this.ay.get(i)).onScrollStateChanged(this, paramInt);  
  }
  
  void b(int paramInt1, int paramInt2) {
    if (paramInt1 < 0) {
      f();
      if (this.af.isFinished())
        this.af.onAbsorb(-paramInt1); 
    } else if (paramInt1 > 0) {
      aC_();
      if (this.ah.isFinished())
        this.ah.onAbsorb(paramInt1); 
    } 
    if (paramInt2 < 0) {
      h();
      if (this.ag.isFinished())
        this.ag.onAbsorb(-paramInt2); 
    } else if (paramInt2 > 0) {
      i();
      if (this.ai.isFinished())
        this.ai.onAbsorb(paramInt2); 
    } 
    if (paramInt1 != 0 || paramInt2 != 0)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  void b(ViewHolder paramViewHolder, ItemAnimator.ItemHolderInfo paramItemHolderInfo1, ItemAnimator.ItemHolderInfo paramItemHolderInfo2) {
    e(paramViewHolder);
    paramViewHolder.setIsRecyclable(false);
    if (this.z.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2))
      n(); 
  }
  
  void b(String paramString) {
    if (isComputingLayout()) {
      StringBuilder stringBuilder;
      if (paramString == null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
        stringBuilder.append(a());
        throw new IllegalStateException(stringBuilder.toString());
      } 
      throw new IllegalStateException(stringBuilder);
    } 
    if (this.ad > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(a());
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(stringBuilder.toString()));
    } 
  }
  
  void b(boolean paramBoolean) {
    this.ac--;
    if (this.ac < 1) {
      this.ac = 0;
      if (paramBoolean) {
        C();
        u();
      } 
    } 
  }
  
  boolean b(ViewHolder paramViewHolder) {
    ItemAnimator itemAnimator = this.z;
    return (itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.r()));
  }
  
  Rect c(View paramView) {
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!layoutParams.e)
      return layoutParams.d; 
    if (this.D.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid()))
      return layoutParams.d; 
    Rect rect = layoutParams.d;
    rect.set(0, 0, 0, 0);
    int j = this.p.size();
    for (int i = 0; i < j; i++) {
      this.k.set(0, 0, 0, 0);
      ((ItemDecoration)this.p.get(i)).getItemOffsets(this.k, paramView, this, this.D);
      rect.left += this.k.left;
      rect.top += this.k.top;
      rect.right += this.k.right;
      rect.bottom += this.k.bottom;
    } 
    layoutParams.e = false;
    return rect;
  }
  
  void c() {
    ItemAnimator itemAnimator = this.z;
    if (itemAnimator != null)
      itemAnimator.endAnimations(); 
    LayoutManager layoutManager = this.n;
    if (layoutManager != null) {
      layoutManager.removeAndRecycleAllViews(this.e);
      this.n.a(this.e);
    } 
    this.e.clear();
  }
  
  void c(int paramInt1, int paramInt2) {
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth((View)this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight((View)this)));
  }
  
  void c(boolean paramBoolean) {
    this.y = paramBoolean | this.y;
    this.x = true;
    s();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof LayoutParams && this.n.checkLayoutParams((LayoutParams)paramLayoutParams));
  }
  
  public void clearOnChildAttachStateChangeListeners() {
    List<OnChildAttachStateChangeListener> list = this.ab;
    if (list != null)
      list.clear(); 
  }
  
  public void clearOnScrollListeners() {
    List<OnScrollListener> list = this.ay;
    if (list != null)
      list.clear(); 
  }
  
  public int computeHorizontalScrollExtent() {
    LayoutManager layoutManager = this.n;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (layoutManager.canScrollHorizontally())
      i = this.n.computeHorizontalScrollExtent(this.D); 
    return i;
  }
  
  public int computeHorizontalScrollOffset() {
    LayoutManager layoutManager = this.n;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (layoutManager.canScrollHorizontally())
      i = this.n.computeHorizontalScrollOffset(this.D); 
    return i;
  }
  
  public int computeHorizontalScrollRange() {
    LayoutManager layoutManager = this.n;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (layoutManager.canScrollHorizontally())
      i = this.n.computeHorizontalScrollRange(this.D); 
    return i;
  }
  
  public int computeVerticalScrollExtent() {
    LayoutManager layoutManager = this.n;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (layoutManager.canScrollVertically())
      i = this.n.computeVerticalScrollExtent(this.D); 
    return i;
  }
  
  public int computeVerticalScrollOffset() {
    LayoutManager layoutManager = this.n;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (layoutManager.canScrollVertically())
      i = this.n.computeVerticalScrollOffset(this.D); 
    return i;
  }
  
  public int computeVerticalScrollRange() {
    LayoutManager layoutManager = this.n;
    int i = 0;
    if (layoutManager == null)
      return 0; 
    if (layoutManager.canScrollVertically())
      i = this.n.computeVerticalScrollRange(this.D); 
    return i;
  }
  
  int d(ViewHolder paramViewHolder) {
    return (paramViewHolder.a(524) || !paramViewHolder.l()) ? -1 : this.f.applyPendingUpdatesToPosition(paramViewHolder.b);
  }
  
  void d() {
    if (!this.t || this.x) {
      TraceCompat.beginSection("RV FullInvalidate");
      o();
      TraceCompat.endSection();
      return;
    } 
    if (!this.f.d())
      return; 
    if (this.f.a(4) && !this.f.a(11)) {
      TraceCompat.beginSection("RV PartialInvalidate");
      e();
      k();
      this.f.b();
      if (!this.u)
        if (x()) {
          o();
        } else {
          this.f.c();
        }  
      a(true);
      l();
      TraceCompat.endSection();
      return;
    } 
    if (this.f.d()) {
      TraceCompat.beginSection("RV FullInvalidate");
      o();
      TraceCompat.endSection();
    } 
  }
  
  void d(int paramInt1, int paramInt2) {
    int i;
    int j;
    boolean bool;
    int m = this.g.c();
    if (paramInt1 < paramInt2) {
      i = paramInt1;
      j = paramInt2;
      bool = true;
    } else {
      j = paramInt1;
      i = paramInt2;
      bool = true;
    } 
    int k;
    for (k = 0; k < m; k++) {
      ViewHolder viewHolder = b(this.g.d(k));
      if (viewHolder != null && viewHolder.b >= i && viewHolder.b <= j) {
        if (viewHolder.b == paramInt1) {
          viewHolder.a(paramInt2 - paramInt1, false);
        } else {
          viewHolder.a(bool, false);
        } 
        this.D.f = true;
      } 
    } 
    this.e.a(paramInt1, paramInt2);
    requestLayout();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt3) {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, paramInt3);
  }
  
  public final void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int paramInt5, int[] paramArrayOfint2) {
    getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint1, paramInt5, paramArrayOfint2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, int paramInt5) {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramInt5);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent) {
    onPopulateAccessibilityEvent(paramAccessibilityEvent);
    return true;
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray) {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray) {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    int j = this.p.size();
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++)
      ((ItemDecoration)this.p.get(i)).onDrawOver(paramCanvas, this, this.D); 
    EdgeEffect edgeEffect = this.af;
    if (edgeEffect != null && !edgeEffect.isFinished()) {
      int k = paramCanvas.save();
      if (this.i) {
        i = getPaddingBottom();
      } else {
        i = 0;
      } 
      paramCanvas.rotate(270.0F);
      paramCanvas.translate((-getHeight() + i), 0.0F);
      edgeEffect = this.af;
      if (edgeEffect != null && edgeEffect.draw(paramCanvas)) {
        j = 1;
      } else {
        j = 0;
      } 
      paramCanvas.restoreToCount(k);
    } else {
      j = 0;
    } 
    edgeEffect = this.ag;
    i = j;
    if (edgeEffect != null) {
      i = j;
      if (!edgeEffect.isFinished()) {
        int k = paramCanvas.save();
        if (this.i)
          paramCanvas.translate(getPaddingLeft(), getPaddingTop()); 
        edgeEffect = this.ag;
        if (edgeEffect != null && edgeEffect.draw(paramCanvas)) {
          i = 1;
        } else {
          i = 0;
        } 
        i = j | i;
        paramCanvas.restoreToCount(k);
      } 
    } 
    edgeEffect = this.ah;
    j = i;
    if (edgeEffect != null) {
      j = i;
      if (!edgeEffect.isFinished()) {
        int k = paramCanvas.save();
        int m = getWidth();
        if (this.i) {
          j = getPaddingTop();
        } else {
          j = 0;
        } 
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-j, -m);
        edgeEffect = this.ah;
        if (edgeEffect != null && edgeEffect.draw(paramCanvas)) {
          j = 1;
        } else {
          j = 0;
        } 
        j = i | j;
        paramCanvas.restoreToCount(k);
      } 
    } 
    edgeEffect = this.ai;
    if (edgeEffect != null && !edgeEffect.isFinished()) {
      int k = paramCanvas.save();
      paramCanvas.rotate(180.0F);
      if (this.i) {
        paramCanvas.translate((-getWidth() + getPaddingRight()), (-getHeight() + getPaddingBottom()));
      } else {
        paramCanvas.translate(-getWidth(), -getHeight());
      } 
      edgeEffect = this.ai;
      i = bool;
      if (edgeEffect != null) {
        i = bool;
        if (edgeEffect.draw(paramCanvas))
          i = 1; 
      } 
      i |= j;
      paramCanvas.restoreToCount(k);
    } else {
      i = j;
    } 
    j = i;
    if (i == 0) {
      j = i;
      if (this.z != null) {
        j = i;
        if (this.p.size() > 0) {
          j = i;
          if (this.z.isRunning())
            j = 1; 
        } 
      } 
    } 
    if (j != 0)
      ViewCompat.postInvalidateOnAnimation((View)this); 
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void e() {
    this.U++;
    if (this.U == 1 && !this.v)
      this.u = false; 
  }
  
  void e(int paramInt1, int paramInt2) {
    int j = this.g.c();
    for (int i = 0; i < j; i++) {
      ViewHolder viewHolder = b(this.g.d(i));
      if (viewHolder != null && !viewHolder.bf_() && viewHolder.b >= paramInt1) {
        viewHolder.a(paramInt2, false);
        this.D.f = true;
      } 
    } 
    this.e.b(paramInt1, paramInt2);
    requestLayout();
  }
  
  void e(View paramView) {
    ViewHolder viewHolder = b(paramView);
    onChildDetachedFromWindow(paramView);
    Adapter<ViewHolder> adapter = this.m;
    if (adapter != null && viewHolder != null)
      adapter.onViewDetachedFromWindow(viewHolder); 
    List<OnChildAttachStateChangeListener> list = this.ab;
    if (list != null)
      for (int i = list.size() - 1; i >= 0; i--)
        ((OnChildAttachStateChangeListener)this.ab.get(i)).onChildViewDetachedFromWindow(paramView);  
  }
  
  void f() {
    if (this.af != null)
      return; 
    this.af = this.ae.a(this, 0);
    if (this.i) {
      this.af.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    } 
    this.af.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void f(int paramInt1, int paramInt2) {
    this.ad++;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i - paramInt1, j - paramInt2);
    onScrolled(paramInt1, paramInt2);
    OnScrollListener onScrollListener = this.ax;
    if (onScrollListener != null)
      onScrollListener.onScrolled(this, paramInt1, paramInt2); 
    List<OnScrollListener> list = this.ay;
    if (list != null)
      for (i = list.size() - 1; i >= 0; i--)
        ((OnScrollListener)this.ay.get(i)).onScrolled(this, paramInt1, paramInt2);  
    this.ad--;
  }
  
  void f(View paramView) {
    ViewHolder viewHolder = b(paramView);
    onChildAttachedToWindow(paramView);
    Adapter<ViewHolder> adapter = this.m;
    if (adapter != null && viewHolder != null)
      adapter.onViewAttachedToWindow(viewHolder); 
    List<OnChildAttachStateChangeListener> list = this.ab;
    if (list != null)
      for (int i = list.size() - 1; i >= 0; i--)
        ((OnChildAttachStateChangeListener)this.ab.get(i)).onChildViewAttachedToWindow(paramView);  
  }
  
  public View findChildViewUnder(float paramFloat1, float paramFloat2) {
    int i;
    for (i = this.g.b() - 1; i >= 0; i--) {
      View view = this.g.b(i);
      float f1 = view.getTranslationX();
      float f2 = view.getTranslationY();
      if (paramFloat1 >= view.getLeft() + f1 && paramFloat1 <= view.getRight() + f1 && paramFloat2 >= view.getTop() + f2 && paramFloat2 <= view.getBottom() + f2)
        return view; 
    } 
    return null;
  }
  
  public View findContainingItemView(View paramView) {
    ViewParent viewParent2 = paramView.getParent();
    View view = paramView;
    ViewParent viewParent1;
    for (viewParent1 = viewParent2; viewParent1 != null && viewParent1 != this && viewParent1 instanceof View; viewParent1 = view.getParent())
      view = (View)viewParent1; 
    return (viewParent1 == this) ? view : null;
  }
  
  public ViewHolder findContainingViewHolder(View paramView) {
    paramView = findContainingItemView(paramView);
    return (paramView == null) ? null : getChildViewHolder(paramView);
  }
  
  public ViewHolder findViewHolderForAdapterPosition(int paramInt) {
    boolean bool = this.x;
    ViewHolder viewHolder = null;
    if (bool)
      return null; 
    int j = this.g.c();
    int i = 0;
    while (i < j) {
      ViewHolder viewHolder2 = b(this.g.d(i));
      ViewHolder viewHolder1 = viewHolder;
      if (viewHolder2 != null) {
        viewHolder1 = viewHolder;
        if (!viewHolder2.m()) {
          viewHolder1 = viewHolder;
          if (d(viewHolder2) == paramInt)
            if (this.g.c(viewHolder2.itemView)) {
              viewHolder1 = viewHolder2;
            } else {
              return viewHolder2;
            }  
        } 
      } 
      i++;
      viewHolder = viewHolder1;
    } 
    return viewHolder;
  }
  
  public ViewHolder findViewHolderForItemId(long paramLong) {
    Adapter adapter = this.m;
    ViewHolder viewHolder2 = null;
    ViewHolder viewHolder1 = null;
    if (adapter != null) {
      if (!adapter.hasStableIds())
        return null; 
      int j = this.g.c();
      int i = 0;
      while (true) {
        viewHolder2 = viewHolder1;
        if (i < j) {
          ViewHolder viewHolder = b(this.g.d(i));
          viewHolder2 = viewHolder1;
          if (viewHolder != null) {
            viewHolder2 = viewHolder1;
            if (!viewHolder.m()) {
              viewHolder2 = viewHolder1;
              if (viewHolder.getItemId() == paramLong)
                if (this.g.c(viewHolder.itemView)) {
                  viewHolder2 = viewHolder;
                } else {
                  return viewHolder;
                }  
            } 
          } 
          i++;
          viewHolder1 = viewHolder2;
          continue;
        } 
        break;
      } 
    } 
    return viewHolder2;
  }
  
  public ViewHolder findViewHolderForLayoutPosition(int paramInt) {
    return a(paramInt, false);
  }
  
  @Deprecated
  public ViewHolder findViewHolderForPosition(int paramInt) {
    return a(paramInt, false);
  }
  
  public boolean fling(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   4: astore #11
    //   6: iconst_0
    //   7: istore #7
    //   9: aload #11
    //   11: ifnonnull -> 26
    //   14: ldc_w 'RecyclerView'
    //   17: ldc_w 'Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.'
    //   20: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: getfield v : Z
    //   30: ifeq -> 35
    //   33: iconst_0
    //   34: ireturn
    //   35: aload #11
    //   37: invokevirtual canScrollHorizontally : ()Z
    //   40: istore #9
    //   42: aload_0
    //   43: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   46: invokevirtual canScrollVertically : ()Z
    //   49: istore #10
    //   51: iload #9
    //   53: ifeq -> 70
    //   56: iload_1
    //   57: istore #5
    //   59: iload_1
    //   60: invokestatic abs : (I)I
    //   63: aload_0
    //   64: getfield as : I
    //   67: if_icmpge -> 73
    //   70: iconst_0
    //   71: istore #5
    //   73: iload #10
    //   75: ifeq -> 92
    //   78: iload_2
    //   79: istore #6
    //   81: iload_2
    //   82: invokestatic abs : (I)I
    //   85: aload_0
    //   86: getfield as : I
    //   89: if_icmpge -> 95
    //   92: iconst_0
    //   93: istore #6
    //   95: iload #5
    //   97: ifne -> 107
    //   100: iload #6
    //   102: ifne -> 107
    //   105: iconst_0
    //   106: ireturn
    //   107: iload #5
    //   109: i2f
    //   110: fstore_3
    //   111: iload #6
    //   113: i2f
    //   114: fstore #4
    //   116: aload_0
    //   117: fload_3
    //   118: fload #4
    //   120: invokevirtual dispatchNestedPreFling : (FF)Z
    //   123: ifne -> 261
    //   126: iload #9
    //   128: ifne -> 145
    //   131: iload #10
    //   133: ifeq -> 139
    //   136: goto -> 145
    //   139: iconst_0
    //   140: istore #8
    //   142: goto -> 148
    //   145: iconst_1
    //   146: istore #8
    //   148: aload_0
    //   149: fload_3
    //   150: fload #4
    //   152: iload #8
    //   154: invokevirtual dispatchNestedFling : (FFZ)Z
    //   157: pop
    //   158: aload_0
    //   159: getfield ar : Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;
    //   162: astore #11
    //   164: aload #11
    //   166: ifnull -> 183
    //   169: aload #11
    //   171: iload #5
    //   173: iload #6
    //   175: invokevirtual onFling : (II)Z
    //   178: ifeq -> 183
    //   181: iconst_1
    //   182: ireturn
    //   183: iload #8
    //   185: ifeq -> 261
    //   188: iload #7
    //   190: istore_1
    //   191: iload #9
    //   193: ifeq -> 198
    //   196: iconst_1
    //   197: istore_1
    //   198: iload_1
    //   199: istore_2
    //   200: iload #10
    //   202: ifeq -> 209
    //   205: iload_1
    //   206: iconst_2
    //   207: ior
    //   208: istore_2
    //   209: aload_0
    //   210: iload_2
    //   211: iconst_1
    //   212: invokevirtual startNestedScroll : (II)Z
    //   215: pop
    //   216: aload_0
    //   217: getfield at : I
    //   220: istore_1
    //   221: iload_1
    //   222: ineg
    //   223: iload #5
    //   225: iload_1
    //   226: invokestatic min : (II)I
    //   229: invokestatic max : (II)I
    //   232: istore_1
    //   233: aload_0
    //   234: getfield at : I
    //   237: istore_2
    //   238: iload_2
    //   239: ineg
    //   240: iload #6
    //   242: iload_2
    //   243: invokestatic min : (II)I
    //   246: invokestatic max : (II)I
    //   249: istore_2
    //   250: aload_0
    //   251: getfield A : Landroidx/recyclerview/widget/RecyclerView$ViewFlinger;
    //   254: iload_1
    //   255: iload_2
    //   256: invokevirtual fling : (II)V
    //   259: iconst_1
    //   260: ireturn
    //   261: iconst_0
    //   262: ireturn
  }
  
  public View focusSearch(View paramView, int paramInt) {
    byte b;
    View view1;
    View view2 = this.n.onInterceptFocusSearch(paramView, paramInt);
    if (view2 != null)
      return view2; 
    if (this.m != null && this.n != null && !isComputingLayout() && !this.v) {
      b = 1;
    } else {
      b = 0;
    } 
    FocusFinder focusFinder = FocusFinder.getInstance();
    if (b && (paramInt == 2 || paramInt == 1)) {
      if (this.n.canScrollVertically()) {
        byte b2;
        byte b3;
        if (paramInt == 2) {
          b2 = 130;
        } else {
          b2 = 33;
        } 
        if (focusFinder.findNextFocus(this, paramView, b2) == null) {
          b3 = 1;
        } else {
          b3 = 0;
        } 
        b = b3;
        if (M) {
          paramInt = b2;
          b = b3;
        } 
      } else {
        b = 0;
      } 
      byte b1 = b;
      int i = paramInt;
      if (!b) {
        b1 = b;
        i = paramInt;
        if (this.n.canScrollHorizontally()) {
          byte b2;
          if (this.n.getLayoutDirection() == 1) {
            b = 1;
          } else {
            b = 0;
          } 
          if (paramInt == 2) {
            b2 = 1;
          } else {
            b2 = 0;
          } 
          if ((b ^ b2) != 0) {
            b = 66;
          } else {
            b = 17;
          } 
          if (focusFinder.findNextFocus(this, paramView, b) == null) {
            b2 = 1;
          } else {
            b2 = 0;
          } 
          b1 = b2;
          i = paramInt;
          if (M) {
            i = b;
            b1 = b2;
          } 
        } 
      } 
      if (b1 != 0) {
        d();
        if (findContainingItemView(paramView) == null)
          return null; 
        e();
        this.n.onFocusSearchFailed(paramView, i, this.e, this.D);
        a(false);
      } 
      view1 = focusFinder.findNextFocus(this, paramView, i);
      paramInt = i;
    } else {
      view1 = view1.findNextFocus(this, paramView, paramInt);
      if (view1 == null && b != 0) {
        d();
        if (findContainingItemView(paramView) == null)
          return null; 
        e();
        view1 = this.n.onFocusSearchFailed(paramView, paramInt, this.e, this.D);
        a(false);
      } 
    } 
    if (view1 != null && !view1.hasFocusable()) {
      if (getFocusedChild() == null)
        return super.focusSearch(paramView, paramInt); 
      a(view1, (View)null);
      return paramView;
    } 
    return a(paramView, view1, paramInt) ? view1 : super.focusSearch(paramView, paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      return (ViewGroup.LayoutParams)layoutManager.generateDefaultLayoutParams(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RecyclerView has no LayoutManager");
    stringBuilder.append(a());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      return (ViewGroup.LayoutParams)layoutManager.generateLayoutParams(getContext(), paramAttributeSet); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RecyclerView has no LayoutManager");
    stringBuilder.append(a());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      return (ViewGroup.LayoutParams)layoutManager.generateLayoutParams(paramLayoutParams); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("RecyclerView has no LayoutManager");
    stringBuilder.append(a());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public CharSequence getAccessibilityClassName() {
    return "androidx.recyclerview.widget.RecyclerView";
  }
  
  public Adapter getAdapter() {
    return this.m;
  }
  
  public int getBaseline() {
    LayoutManager layoutManager = this.n;
    return (layoutManager != null) ? layoutManager.getBaseline() : super.getBaseline();
  }
  
  public int getChildAdapterPosition(View paramView) {
    ViewHolder viewHolder = b(paramView);
    return (viewHolder != null) ? viewHolder.getAdapterPosition() : -1;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    ChildDrawingOrderCallback childDrawingOrderCallback = this.aA;
    return (childDrawingOrderCallback == null) ? super.getChildDrawingOrder(paramInt1, paramInt2) : childDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public long getChildItemId(View paramView) {
    Adapter adapter = this.m;
    long l2 = -1L;
    long l1 = l2;
    if (adapter != null) {
      if (!adapter.hasStableIds())
        return -1L; 
      ViewHolder viewHolder = b(paramView);
      l1 = l2;
      if (viewHolder != null)
        l1 = viewHolder.getItemId(); 
    } 
    return l1;
  }
  
  public int getChildLayoutPosition(View paramView) {
    ViewHolder viewHolder = b(paramView);
    return (viewHolder != null) ? viewHolder.getLayoutPosition() : -1;
  }
  
  @Deprecated
  public int getChildPosition(View paramView) {
    return getChildAdapterPosition(paramView);
  }
  
  public ViewHolder getChildViewHolder(View paramView) {
    ViewParent viewParent = paramView.getParent();
    if (viewParent == null || viewParent == this)
      return b(paramView); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("View ");
    stringBuilder.append(paramView);
    stringBuilder.append(" is not a direct child of ");
    stringBuilder.append(this);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public boolean getClipToPadding() {
    return this.i;
  }
  
  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
    return this.H;
  }
  
  public void getDecoratedBoundsWithMargins(View paramView, Rect paramRect) {
    a(paramView, paramRect);
  }
  
  public EdgeEffectFactory getEdgeEffectFactory() {
    return this.ae;
  }
  
  public ItemAnimator getItemAnimator() {
    return this.z;
  }
  
  public ItemDecoration getItemDecorationAt(int paramInt) {
    int i = getItemDecorationCount();
    if (paramInt >= 0 && paramInt < i)
      return this.p.get(paramInt); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(" is an invalid index for size ");
    stringBuilder.append(i);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  public int getItemDecorationCount() {
    return this.p.size();
  }
  
  public LayoutManager getLayoutManager() {
    return this.n;
  }
  
  public int getMaxFlingVelocity() {
    return this.at;
  }
  
  public int getMinFlingVelocity() {
    return this.as;
  }
  
  long getNanoTime() {
    return d ? System.nanoTime() : 0L;
  }
  
  public OnFlingListener getOnFlingListener() {
    return this.ar;
  }
  
  public boolean getPreserveFocusAfterLayout() {
    return this.aw;
  }
  
  public RecycledViewPool getRecycledViewPool() {
    return this.e.e();
  }
  
  public int getScrollState() {
    return this.aj;
  }
  
  void h() {
    if (this.ag != null)
      return; 
    this.ag = this.ae.a(this, 1);
    if (this.i) {
      this.ag.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    } 
    this.ag.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public boolean hasFixedSize() {
    return this.r;
  }
  
  public boolean hasNestedScrollingParent() {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasNestedScrollingParent(int paramInt) {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }
  
  public boolean hasPendingAdapterUpdates() {
    return (!this.t || this.x || this.f.d());
  }
  
  void i() {
    if (this.ai != null)
      return; 
    this.ai = this.ae.a(this, 3);
    if (this.i) {
      this.ai.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    } 
    this.ai.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public void invalidateItemDecorations() {
    if (this.p.size() == 0)
      return; 
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout"); 
    p();
    requestLayout();
  }
  
  public boolean isAnimating() {
    ItemAnimator itemAnimator = this.z;
    return (itemAnimator != null && itemAnimator.isRunning());
  }
  
  public boolean isAttachedToWindow() {
    return this.q;
  }
  
  public boolean isComputingLayout() {
    return (this.ac > 0);
  }
  
  @Deprecated
  public boolean isLayoutFrozen() {
    return isLayoutSuppressed();
  }
  
  public final boolean isLayoutSuppressed() {
    return this.v;
  }
  
  public boolean isNestedScrollingEnabled() {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  void j() {
    this.ai = null;
    this.ag = null;
    this.ah = null;
    this.af = null;
  }
  
  void k() {
    this.ac++;
  }
  
  void l() {
    b(true);
  }
  
  boolean m() {
    AccessibilityManager accessibilityManager = this.aa;
    return (accessibilityManager != null && accessibilityManager.isEnabled());
  }
  
  void n() {
    if (!this.G && this.q) {
      ViewCompat.postOnAnimation((View)this, this.aF);
      this.G = true;
    } 
  }
  
  void o() {
    if (this.m == null) {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    } 
    if (this.n == null) {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    } 
    State state = this.D;
    state.i = false;
    if (state.d == 1) {
      J();
      this.n.c(this);
      K();
    } else if (this.f.f() || this.n.getWidth() != getWidth() || this.n.getHeight() != getHeight()) {
      this.n.c(this);
      K();
    } else {
      this.n.c(this);
    } 
    L();
  }
  
  public void offsetChildrenHorizontal(int paramInt) {
    int j = this.g.b();
    for (int i = 0; i < j; i++)
      this.g.b(i).offsetLeftAndRight(paramInt); 
  }
  
  public void offsetChildrenVertical(int paramInt) {
    int j = this.g.b();
    for (int i = 0; i < j; i++)
      this.g.b(i).offsetTopAndBottom(paramInt); 
  }
  
  protected void onAttachedToWindow() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial onAttachedToWindow : ()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield ac : I
    //   9: iconst_1
    //   10: istore_2
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield q : Z
    //   16: aload_0
    //   17: getfield t : Z
    //   20: ifeq -> 33
    //   23: aload_0
    //   24: invokevirtual isLayoutRequested : ()Z
    //   27: ifne -> 33
    //   30: goto -> 35
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: iload_2
    //   37: putfield t : Z
    //   40: aload_0
    //   41: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   44: astore_3
    //   45: aload_3
    //   46: ifnull -> 54
    //   49: aload_3
    //   50: aload_0
    //   51: invokevirtual b : (Landroidx/recyclerview/widget/RecyclerView;)V
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield G : Z
    //   59: getstatic androidx/recyclerview/widget/RecyclerView.d : Z
    //   62: ifeq -> 163
    //   65: aload_0
    //   66: getstatic androidx/recyclerview/widget/GapWorker.a : Ljava/lang/ThreadLocal;
    //   69: invokevirtual get : ()Ljava/lang/Object;
    //   72: checkcast androidx/recyclerview/widget/GapWorker
    //   75: putfield B : Landroidx/recyclerview/widget/GapWorker;
    //   78: aload_0
    //   79: getfield B : Landroidx/recyclerview/widget/GapWorker;
    //   82: ifnonnull -> 155
    //   85: aload_0
    //   86: new androidx/recyclerview/widget/GapWorker
    //   89: dup
    //   90: invokespecial <init> : ()V
    //   93: putfield B : Landroidx/recyclerview/widget/GapWorker;
    //   96: aload_0
    //   97: invokestatic getDisplay : (Landroid/view/View;)Landroid/view/Display;
    //   100: astore_3
    //   101: aload_0
    //   102: invokevirtual isInEditMode : ()Z
    //   105: ifne -> 128
    //   108: aload_3
    //   109: ifnull -> 128
    //   112: aload_3
    //   113: invokevirtual getRefreshRate : ()F
    //   116: fstore_1
    //   117: fload_1
    //   118: ldc_w 30.0
    //   121: fcmpl
    //   122: iflt -> 128
    //   125: goto -> 132
    //   128: ldc_w 60.0
    //   131: fstore_1
    //   132: aload_0
    //   133: getfield B : Landroidx/recyclerview/widget/GapWorker;
    //   136: ldc_w 1.0E9
    //   139: fload_1
    //   140: fdiv
    //   141: f2l
    //   142: putfield d : J
    //   145: getstatic androidx/recyclerview/widget/GapWorker.a : Ljava/lang/ThreadLocal;
    //   148: aload_0
    //   149: getfield B : Landroidx/recyclerview/widget/GapWorker;
    //   152: invokevirtual set : (Ljava/lang/Object;)V
    //   155: aload_0
    //   156: getfield B : Landroidx/recyclerview/widget/GapWorker;
    //   159: aload_0
    //   160: invokevirtual add : (Landroidx/recyclerview/widget/RecyclerView;)V
    //   163: return
  }
  
  public void onChildAttachedToWindow(View paramView) {}
  
  public void onChildDetachedFromWindow(View paramView) {}
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ItemAnimator itemAnimator = this.z;
    if (itemAnimator != null)
      itemAnimator.endAnimations(); 
    stopScroll();
    this.q = false;
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      layoutManager.a(this, this.e); 
    this.J.clear();
    removeCallbacks(this.aF);
    this.h.b();
    if (d) {
      GapWorker gapWorker = this.B;
      if (gapWorker != null) {
        gapWorker.remove(this);
        this.B = null;
      } 
    } 
  }
  
  public void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    int j = this.p.size();
    for (int i = 0; i < j; i++)
      ((ItemDecoration)this.p.get(i)).onDraw(paramCanvas, this, this.D); 
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   4: ifnonnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: getfield v : Z
    //   13: ifeq -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_1
    //   19: invokevirtual getAction : ()I
    //   22: bipush #8
    //   24: if_icmpne -> 172
    //   27: aload_1
    //   28: invokevirtual getSource : ()I
    //   31: iconst_2
    //   32: iand
    //   33: ifeq -> 87
    //   36: aload_0
    //   37: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   40: invokevirtual canScrollVertically : ()Z
    //   43: ifeq -> 57
    //   46: aload_1
    //   47: bipush #9
    //   49: invokevirtual getAxisValue : (I)F
    //   52: fneg
    //   53: fstore_3
    //   54: goto -> 59
    //   57: fconst_0
    //   58: fstore_3
    //   59: fload_3
    //   60: fstore_2
    //   61: aload_0
    //   62: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   65: invokevirtual canScrollHorizontally : ()Z
    //   68: ifeq -> 138
    //   71: aload_1
    //   72: bipush #10
    //   74: invokevirtual getAxisValue : (I)F
    //   77: fstore #4
    //   79: fload_3
    //   80: fstore_2
    //   81: fload #4
    //   83: fstore_3
    //   84: goto -> 140
    //   87: aload_1
    //   88: invokevirtual getSource : ()I
    //   91: ldc_w 4194304
    //   94: iand
    //   95: ifeq -> 136
    //   98: aload_1
    //   99: bipush #26
    //   101: invokevirtual getAxisValue : (I)F
    //   104: fstore_3
    //   105: aload_0
    //   106: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   109: invokevirtual canScrollVertically : ()Z
    //   112: ifeq -> 121
    //   115: fload_3
    //   116: fneg
    //   117: fstore_2
    //   118: goto -> 138
    //   121: aload_0
    //   122: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   125: invokevirtual canScrollHorizontally : ()Z
    //   128: ifeq -> 136
    //   131: fconst_0
    //   132: fstore_2
    //   133: goto -> 140
    //   136: fconst_0
    //   137: fstore_2
    //   138: fconst_0
    //   139: fstore_3
    //   140: fload_2
    //   141: fconst_0
    //   142: fcmpl
    //   143: ifne -> 152
    //   146: fload_3
    //   147: fconst_0
    //   148: fcmpl
    //   149: ifeq -> 172
    //   152: aload_0
    //   153: fload_3
    //   154: aload_0
    //   155: getfield au : F
    //   158: fmul
    //   159: f2i
    //   160: fload_2
    //   161: aload_0
    //   162: getfield av : F
    //   165: fmul
    //   166: f2i
    //   167: aload_1
    //   168: invokevirtual a : (IILandroid/view/MotionEvent;)Z
    //   171: pop
    //   172: iconst_0
    //   173: ireturn
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    StringBuilder stringBuilder;
    boolean bool1 = this.v;
    boolean bool = false;
    if (bool1)
      return false; 
    this.T = null;
    if (b(paramMotionEvent)) {
      B();
      return true;
    } 
    LayoutManager layoutManager = this.n;
    if (layoutManager == null)
      return false; 
    bool1 = layoutManager.canScrollHorizontally();
    boolean bool2 = this.n.canScrollVertically();
    if (this.al == null)
      this.al = VelocityTracker.obtain(); 
    this.al.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (j != 0) {
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            if (j != 5) {
              if (j == 6)
                c(paramMotionEvent); 
            } else {
              this.ak = paramMotionEvent.getPointerId(i);
              j = (int)(paramMotionEvent.getX(i) + 0.5F);
              this.ao = j;
              this.am = j;
              i = (int)(paramMotionEvent.getY(i) + 0.5F);
              this.ap = i;
              this.an = i;
            } 
          } else {
            B();
          } 
        } else {
          j = paramMotionEvent.findPointerIndex(this.ak);
          if (j < 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error processing scroll; pointer index for id ");
            stringBuilder.append(this.ak);
            stringBuilder.append(" not found. Did any MotionEvents get skipped?");
            Log.e("RecyclerView", stringBuilder.toString());
            return false;
          } 
          i = (int)(stringBuilder.getX(j) + 0.5F);
          int k = (int)(stringBuilder.getY(j) + 0.5F);
          if (this.aj != 1) {
            j = this.am;
            int m = this.an;
            if (bool1 && Math.abs(i - j) > this.aq) {
              this.ao = i;
              i = 1;
            } else {
              i = 0;
            } 
            j = i;
            if (bool2) {
              j = i;
              if (Math.abs(k - m) > this.aq) {
                this.ap = k;
                j = 1;
              } 
            } 
            if (j != 0)
              setScrollState(1); 
          } 
        } 
      } else {
        this.al.clear();
        stopNestedScroll(0);
      } 
    } else {
      if (this.V)
        this.V = false; 
      this.ak = stringBuilder.getPointerId(0);
      i = (int)(stringBuilder.getX() + 0.5F);
      this.ao = i;
      this.am = i;
      i = (int)(stringBuilder.getY() + 0.5F);
      this.ap = i;
      this.an = i;
      if (this.aj == 2) {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
      } 
      int[] arrayOfInt = this.aE;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      if (bool1) {
        i = 1;
      } else {
        i = 0;
      } 
      j = i;
      if (bool2)
        j = i | 0x2; 
      startNestedScroll(j, 0);
    } 
    if (this.aj == 1)
      bool = true; 
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    TraceCompat.beginSection("RV OnLayout");
    o();
    TraceCompat.endSection();
    this.t = true;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    LayoutManager layoutManager = this.n;
    if (layoutManager == null) {
      c(paramInt1, paramInt2);
      return;
    } 
    boolean bool1 = layoutManager.isAutoMeasureEnabled();
    boolean bool = false;
    if (bool1) {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getMode(paramInt2);
      this.n.onMeasure(this.e, this.D, paramInt1, paramInt2);
      boolean bool2 = bool;
      if (i == 1073741824) {
        bool2 = bool;
        if (j == 1073741824)
          bool2 = true; 
      } 
      if (!bool2) {
        if (this.m == null)
          return; 
        if (this.D.d == 1)
          J(); 
        this.n.c(paramInt1, paramInt2);
        this.D.i = true;
        K();
        this.n.d(paramInt1, paramInt2);
        if (this.n.e()) {
          this.n.c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
          this.D.i = true;
          K();
          this.n.d(paramInt1, paramInt2);
          return;
        } 
      } else {
        return;
      } 
    } else {
      if (this.r) {
        this.n.onMeasure(this.e, this.D, paramInt1, paramInt2);
        return;
      } 
      if (this.w) {
        e();
        k();
        E();
        l();
        if (this.D.k) {
          this.D.g = true;
        } else {
          this.f.e();
          this.D.g = false;
        } 
        this.w = false;
        a(false);
      } else if (this.D.k) {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        return;
      } 
      Adapter adapter = this.m;
      if (adapter != null) {
        this.D.e = adapter.getItemCount();
      } else {
        this.D.e = 0;
      } 
      e();
      this.n.onMeasure(this.e, this.D, paramInt1, paramInt2);
      a(false);
      this.D.g = false;
    } 
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect) {
    return isComputingLayout() ? false : super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    this.Q = (SavedState)paramParcelable;
    super.onRestoreInstanceState(this.Q.getSuperState());
    if (this.n != null && this.Q.a != null)
      this.n.onRestoreInstanceState(this.Q.a); 
  }
  
  protected Parcelable onSaveInstanceState() {
    SavedState savedState1 = new SavedState(super.onSaveInstanceState());
    SavedState savedState2 = this.Q;
    if (savedState2 != null) {
      savedState1.a(savedState2);
      return (Parcelable)savedState1;
    } 
    LayoutManager layoutManager = this.n;
    if (layoutManager != null) {
      savedState1.a = layoutManager.onSaveInstanceState();
      return (Parcelable)savedState1;
    } 
    savedState1.a = null;
    return (Parcelable)savedState1;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void onScrolled(int paramInt1, int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3 || paramInt2 != paramInt4)
      j(); 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield v : Z
    //   4: istore #13
    //   6: iconst_0
    //   7: istore #10
    //   9: iload #13
    //   11: ifne -> 1067
    //   14: aload_0
    //   15: getfield V : Z
    //   18: ifeq -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: aload_1
    //   25: invokespecial a : (Landroid/view/MotionEvent;)Z
    //   28: ifeq -> 37
    //   31: aload_0
    //   32: invokespecial B : ()V
    //   35: iconst_1
    //   36: ireturn
    //   37: aload_0
    //   38: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   41: astore #15
    //   43: aload #15
    //   45: ifnonnull -> 50
    //   48: iconst_0
    //   49: ireturn
    //   50: aload #15
    //   52: invokevirtual canScrollHorizontally : ()Z
    //   55: istore #13
    //   57: aload_0
    //   58: getfield n : Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   61: invokevirtual canScrollVertically : ()Z
    //   64: istore #14
    //   66: aload_0
    //   67: getfield al : Landroid/view/VelocityTracker;
    //   70: ifnonnull -> 80
    //   73: aload_0
    //   74: invokestatic obtain : ()Landroid/view/VelocityTracker;
    //   77: putfield al : Landroid/view/VelocityTracker;
    //   80: aload_1
    //   81: invokevirtual getActionMasked : ()I
    //   84: istore #5
    //   86: aload_1
    //   87: invokevirtual getActionIndex : ()I
    //   90: istore #4
    //   92: iload #5
    //   94: ifne -> 113
    //   97: aload_0
    //   98: getfield aE : [I
    //   101: astore #15
    //   103: aload #15
    //   105: iconst_1
    //   106: iconst_0
    //   107: iastore
    //   108: aload #15
    //   110: iconst_0
    //   111: iconst_0
    //   112: iastore
    //   113: aload_1
    //   114: invokestatic obtain : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
    //   117: astore #15
    //   119: aload_0
    //   120: getfield aE : [I
    //   123: astore #16
    //   125: aload #15
    //   127: aload #16
    //   129: iconst_0
    //   130: iaload
    //   131: i2f
    //   132: aload #16
    //   134: iconst_1
    //   135: iaload
    //   136: i2f
    //   137: invokevirtual offsetLocation : (FF)V
    //   140: iload #5
    //   142: ifeq -> 950
    //   145: iload #5
    //   147: iconst_1
    //   148: if_icmpeq -> 842
    //   151: iload #5
    //   153: iconst_2
    //   154: if_icmpeq -> 273
    //   157: iload #5
    //   159: iconst_3
    //   160: if_icmpeq -> 262
    //   163: iload #5
    //   165: iconst_5
    //   166: if_icmpeq -> 195
    //   169: iload #5
    //   171: bipush #6
    //   173: if_icmpeq -> 183
    //   176: iload #10
    //   178: istore #8
    //   180: goto -> 1046
    //   183: aload_0
    //   184: aload_1
    //   185: invokespecial c : (Landroid/view/MotionEvent;)V
    //   188: iload #10
    //   190: istore #8
    //   192: goto -> 1046
    //   195: aload_0
    //   196: aload_1
    //   197: iload #4
    //   199: invokevirtual getPointerId : (I)I
    //   202: putfield ak : I
    //   205: aload_1
    //   206: iload #4
    //   208: invokevirtual getX : (I)F
    //   211: ldc_w 0.5
    //   214: fadd
    //   215: f2i
    //   216: istore #5
    //   218: aload_0
    //   219: iload #5
    //   221: putfield ao : I
    //   224: aload_0
    //   225: iload #5
    //   227: putfield am : I
    //   230: aload_1
    //   231: iload #4
    //   233: invokevirtual getY : (I)F
    //   236: ldc_w 0.5
    //   239: fadd
    //   240: f2i
    //   241: istore #4
    //   243: aload_0
    //   244: iload #4
    //   246: putfield ap : I
    //   249: aload_0
    //   250: iload #4
    //   252: putfield an : I
    //   255: iload #10
    //   257: istore #8
    //   259: goto -> 1046
    //   262: aload_0
    //   263: invokespecial B : ()V
    //   266: iload #10
    //   268: istore #8
    //   270: goto -> 1046
    //   273: aload_1
    //   274: aload_0
    //   275: getfield ak : I
    //   278: invokevirtual findPointerIndex : (I)I
    //   281: istore #4
    //   283: iload #4
    //   285: ifge -> 334
    //   288: new java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial <init> : ()V
    //   295: astore_1
    //   296: aload_1
    //   297: ldc_w 'Error processing scroll; pointer index for id '
    //   300: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: aload_0
    //   306: getfield ak : I
    //   309: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload_1
    //   314: ldc_w ' not found. Did any MotionEvents get skipped?'
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: ldc_w 'RecyclerView'
    //   324: aload_1
    //   325: invokevirtual toString : ()Ljava/lang/String;
    //   328: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   331: pop
    //   332: iconst_0
    //   333: ireturn
    //   334: aload_1
    //   335: iload #4
    //   337: invokevirtual getX : (I)F
    //   340: ldc_w 0.5
    //   343: fadd
    //   344: f2i
    //   345: istore #11
    //   347: aload_1
    //   348: iload #4
    //   350: invokevirtual getY : (I)F
    //   353: ldc_w 0.5
    //   356: fadd
    //   357: f2i
    //   358: istore #12
    //   360: aload_0
    //   361: getfield ao : I
    //   364: iload #11
    //   366: isub
    //   367: istore #4
    //   369: aload_0
    //   370: getfield ap : I
    //   373: iload #12
    //   375: isub
    //   376: istore #8
    //   378: iload #4
    //   380: istore #5
    //   382: iload #8
    //   384: istore #7
    //   386: aload_0
    //   387: getfield aj : I
    //   390: iconst_1
    //   391: if_icmpeq -> 552
    //   394: iload #4
    //   396: istore #6
    //   398: iload #13
    //   400: ifeq -> 452
    //   403: iload #4
    //   405: ifle -> 424
    //   408: iconst_0
    //   409: iload #4
    //   411: aload_0
    //   412: getfield aq : I
    //   415: isub
    //   416: invokestatic max : (II)I
    //   419: istore #4
    //   421: goto -> 437
    //   424: iconst_0
    //   425: iload #4
    //   427: aload_0
    //   428: getfield aq : I
    //   431: iadd
    //   432: invokestatic min : (II)I
    //   435: istore #4
    //   437: iload #4
    //   439: istore #6
    //   441: iload #4
    //   443: ifeq -> 452
    //   446: iconst_1
    //   447: istore #5
    //   449: goto -> 459
    //   452: iconst_0
    //   453: istore #5
    //   455: iload #6
    //   457: istore #4
    //   459: iload #8
    //   461: istore #6
    //   463: iload #5
    //   465: istore #9
    //   467: iload #14
    //   469: ifeq -> 526
    //   472: iload #8
    //   474: ifle -> 493
    //   477: iconst_0
    //   478: iload #8
    //   480: aload_0
    //   481: getfield aq : I
    //   484: isub
    //   485: invokestatic max : (II)I
    //   488: istore #7
    //   490: goto -> 506
    //   493: iconst_0
    //   494: iload #8
    //   496: aload_0
    //   497: getfield aq : I
    //   500: iadd
    //   501: invokestatic min : (II)I
    //   504: istore #7
    //   506: iload #7
    //   508: istore #6
    //   510: iload #5
    //   512: istore #9
    //   514: iload #7
    //   516: ifeq -> 526
    //   519: iconst_1
    //   520: istore #9
    //   522: iload #7
    //   524: istore #6
    //   526: iload #4
    //   528: istore #5
    //   530: iload #6
    //   532: istore #7
    //   534: iload #9
    //   536: ifeq -> 552
    //   539: aload_0
    //   540: iconst_1
    //   541: invokevirtual setScrollState : (I)V
    //   544: iload #6
    //   546: istore #7
    //   548: iload #4
    //   550: istore #5
    //   552: iload #5
    //   554: istore #6
    //   556: iload #10
    //   558: istore #8
    //   560: aload_0
    //   561: getfield aj : I
    //   564: iconst_1
    //   565: if_icmpne -> 1046
    //   568: aload_0
    //   569: getfield I : [I
    //   572: astore #16
    //   574: aload #16
    //   576: iconst_0
    //   577: iconst_0
    //   578: iastore
    //   579: aload #16
    //   581: iconst_1
    //   582: iconst_0
    //   583: iastore
    //   584: iload #13
    //   586: ifeq -> 596
    //   589: iload #6
    //   591: istore #8
    //   593: goto -> 599
    //   596: iconst_0
    //   597: istore #8
    //   599: iload #14
    //   601: ifeq -> 611
    //   604: iload #7
    //   606: istore #9
    //   608: goto -> 614
    //   611: iconst_0
    //   612: istore #9
    //   614: iload #6
    //   616: istore #5
    //   618: iload #7
    //   620: istore #4
    //   622: aload_0
    //   623: iload #8
    //   625: iload #9
    //   627: aload_0
    //   628: getfield I : [I
    //   631: aload_0
    //   632: getfield aD : [I
    //   635: iconst_0
    //   636: invokevirtual dispatchNestedPreScroll : (II[I[II)Z
    //   639: ifeq -> 718
    //   642: aload_0
    //   643: getfield I : [I
    //   646: astore #16
    //   648: iload #6
    //   650: aload #16
    //   652: iconst_0
    //   653: iaload
    //   654: isub
    //   655: istore #5
    //   657: iload #7
    //   659: aload #16
    //   661: iconst_1
    //   662: iaload
    //   663: isub
    //   664: istore #4
    //   666: aload_0
    //   667: getfield aE : [I
    //   670: astore #16
    //   672: aload #16
    //   674: iconst_0
    //   675: iaload
    //   676: istore #6
    //   678: aload_0
    //   679: getfield aD : [I
    //   682: astore #17
    //   684: aload #16
    //   686: iconst_0
    //   687: iload #6
    //   689: aload #17
    //   691: iconst_0
    //   692: iaload
    //   693: iadd
    //   694: iastore
    //   695: aload #16
    //   697: iconst_1
    //   698: aload #16
    //   700: iconst_1
    //   701: iaload
    //   702: aload #17
    //   704: iconst_1
    //   705: iaload
    //   706: iadd
    //   707: iastore
    //   708: aload_0
    //   709: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   712: iconst_1
    //   713: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   718: aload_0
    //   719: getfield aD : [I
    //   722: astore #16
    //   724: aload_0
    //   725: iload #11
    //   727: aload #16
    //   729: iconst_0
    //   730: iaload
    //   731: isub
    //   732: putfield ao : I
    //   735: aload_0
    //   736: iload #12
    //   738: aload #16
    //   740: iconst_1
    //   741: iaload
    //   742: isub
    //   743: putfield ap : I
    //   746: iload #13
    //   748: ifeq -> 758
    //   751: iload #5
    //   753: istore #6
    //   755: goto -> 761
    //   758: iconst_0
    //   759: istore #6
    //   761: iload #14
    //   763: ifeq -> 773
    //   766: iload #4
    //   768: istore #7
    //   770: goto -> 776
    //   773: iconst_0
    //   774: istore #7
    //   776: aload_0
    //   777: iload #6
    //   779: iload #7
    //   781: aload_1
    //   782: invokevirtual a : (IILandroid/view/MotionEvent;)Z
    //   785: ifeq -> 798
    //   788: aload_0
    //   789: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   792: iconst_1
    //   793: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   798: iload #10
    //   800: istore #8
    //   802: aload_0
    //   803: getfield B : Landroidx/recyclerview/widget/GapWorker;
    //   806: ifnull -> 1046
    //   809: iload #5
    //   811: ifne -> 823
    //   814: iload #10
    //   816: istore #8
    //   818: iload #4
    //   820: ifeq -> 1046
    //   823: aload_0
    //   824: getfield B : Landroidx/recyclerview/widget/GapWorker;
    //   827: aload_0
    //   828: iload #5
    //   830: iload #4
    //   832: invokevirtual a : (Landroidx/recyclerview/widget/RecyclerView;II)V
    //   835: iload #10
    //   837: istore #8
    //   839: goto -> 1046
    //   842: aload_0
    //   843: getfield al : Landroid/view/VelocityTracker;
    //   846: aload #15
    //   848: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   851: aload_0
    //   852: getfield al : Landroid/view/VelocityTracker;
    //   855: sipush #1000
    //   858: aload_0
    //   859: getfield at : I
    //   862: i2f
    //   863: invokevirtual computeCurrentVelocity : (IF)V
    //   866: iload #13
    //   868: ifeq -> 887
    //   871: aload_0
    //   872: getfield al : Landroid/view/VelocityTracker;
    //   875: aload_0
    //   876: getfield ak : I
    //   879: invokevirtual getXVelocity : (I)F
    //   882: fneg
    //   883: fstore_2
    //   884: goto -> 889
    //   887: fconst_0
    //   888: fstore_2
    //   889: iload #14
    //   891: ifeq -> 910
    //   894: aload_0
    //   895: getfield al : Landroid/view/VelocityTracker;
    //   898: aload_0
    //   899: getfield ak : I
    //   902: invokevirtual getYVelocity : (I)F
    //   905: fneg
    //   906: fstore_3
    //   907: goto -> 912
    //   910: fconst_0
    //   911: fstore_3
    //   912: fload_2
    //   913: fconst_0
    //   914: fcmpl
    //   915: ifne -> 924
    //   918: fload_3
    //   919: fconst_0
    //   920: fcmpl
    //   921: ifeq -> 935
    //   924: aload_0
    //   925: fload_2
    //   926: f2i
    //   927: fload_3
    //   928: f2i
    //   929: invokevirtual fling : (II)Z
    //   932: ifne -> 940
    //   935: aload_0
    //   936: iconst_0
    //   937: invokevirtual setScrollState : (I)V
    //   940: aload_0
    //   941: invokespecial A : ()V
    //   944: iconst_1
    //   945: istore #8
    //   947: goto -> 1046
    //   950: aload_0
    //   951: aload_1
    //   952: iconst_0
    //   953: invokevirtual getPointerId : (I)I
    //   956: putfield ak : I
    //   959: aload_1
    //   960: invokevirtual getX : ()F
    //   963: ldc_w 0.5
    //   966: fadd
    //   967: f2i
    //   968: istore #4
    //   970: aload_0
    //   971: iload #4
    //   973: putfield ao : I
    //   976: aload_0
    //   977: iload #4
    //   979: putfield am : I
    //   982: aload_1
    //   983: invokevirtual getY : ()F
    //   986: ldc_w 0.5
    //   989: fadd
    //   990: f2i
    //   991: istore #4
    //   993: aload_0
    //   994: iload #4
    //   996: putfield ap : I
    //   999: aload_0
    //   1000: iload #4
    //   1002: putfield an : I
    //   1005: iload #13
    //   1007: ifeq -> 1016
    //   1010: iconst_1
    //   1011: istore #4
    //   1013: goto -> 1019
    //   1016: iconst_0
    //   1017: istore #4
    //   1019: iload #4
    //   1021: istore #5
    //   1023: iload #14
    //   1025: ifeq -> 1034
    //   1028: iload #4
    //   1030: iconst_2
    //   1031: ior
    //   1032: istore #5
    //   1034: aload_0
    //   1035: iload #5
    //   1037: iconst_0
    //   1038: invokevirtual startNestedScroll : (II)Z
    //   1041: pop
    //   1042: iload #10
    //   1044: istore #8
    //   1046: iload #8
    //   1048: ifne -> 1060
    //   1051: aload_0
    //   1052: getfield al : Landroid/view/VelocityTracker;
    //   1055: aload #15
    //   1057: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   1060: aload #15
    //   1062: invokevirtual recycle : ()V
    //   1065: iconst_1
    //   1066: ireturn
    //   1067: iconst_0
    //   1068: ireturn
  }
  
  void p() {
    int j = this.g.c();
    for (int i = 0; i < j; i++)
      ((LayoutParams)this.g.d(i).getLayoutParams()).e = true; 
    this.e.h();
  }
  
  void q() {
    int j = this.g.c();
    for (int i = 0; i < j; i++) {
      ViewHolder viewHolder = b(this.g.d(i));
      if (!viewHolder.bf_())
        viewHolder.be_(); 
    } 
  }
  
  void r() {
    int j = this.g.c();
    for (int i = 0; i < j; i++) {
      ViewHolder viewHolder = b(this.g.d(i));
      if (!viewHolder.bf_())
        viewHolder.a(); 
    } 
    this.e.g();
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean) {
    StringBuilder stringBuilder;
    ViewHolder viewHolder = b(paramView);
    if (viewHolder != null)
      if (viewHolder.n()) {
        viewHolder.h();
      } else if (!viewHolder.bf_()) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        stringBuilder.append(viewHolder);
        stringBuilder.append(a());
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    stringBuilder.clearAnimation();
    e((View)stringBuilder);
    super.removeDetachedView((View)stringBuilder, paramBoolean);
  }
  
  public void removeItemDecoration(ItemDecoration paramItemDecoration) {
    LayoutManager layoutManager = this.n;
    if (layoutManager != null)
      layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout"); 
    this.p.remove(paramItemDecoration);
    if (this.p.isEmpty()) {
      boolean bool;
      if (getOverScrollMode() == 2) {
        bool = true;
      } else {
        bool = false;
      } 
      setWillNotDraw(bool);
    } 
    p();
    requestLayout();
  }
  
  public void removeItemDecorationAt(int paramInt) {
    int i = getItemDecorationCount();
    if (paramInt >= 0 && paramInt < i) {
      removeItemDecoration(getItemDecorationAt(paramInt));
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(" is an invalid index for size ");
    stringBuilder.append(i);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener) {
    List<OnChildAttachStateChangeListener> list = this.ab;
    if (list == null)
      return; 
    list.remove(paramOnChildAttachStateChangeListener);
  }
  
  public void removeOnItemTouchListener(OnItemTouchListener paramOnItemTouchListener) {
    this.S.remove(paramOnItemTouchListener);
    if (this.T == paramOnItemTouchListener)
      this.T = null; 
  }
  
  public void removeOnScrollListener(OnScrollListener paramOnScrollListener) {
    List<OnScrollListener> list = this.ay;
    if (list != null)
      list.remove(paramOnScrollListener); 
  }
  
  public void requestChildFocus(View paramView1, View paramView2) {
    if (!this.n.onRequestChildFocus(this, this.D, paramView1, paramView2) && paramView2 != null)
      a(paramView1, paramView2); 
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean) {
    return this.n.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    int j = this.S.size();
    for (int i = 0; i < j; i++)
      ((OnItemTouchListener)this.S.get(i)).onRequestDisallowInterceptTouchEvent(paramBoolean); 
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout() {
    if (this.U == 0 && !this.v) {
      super.requestLayout();
      return;
    } 
    this.u = true;
  }
  
  void s() {
    int j = this.g.c();
    for (int i = 0; i < j; i++) {
      ViewHolder viewHolder = b(this.g.d(i));
      if (viewHolder != null && !viewHolder.bf_())
        viewHolder.b(6); 
    } 
    p();
    this.e.f();
  }
  
  public void scrollBy(int paramInt1, int paramInt2) {
    LayoutManager layoutManager = this.n;
    if (layoutManager == null) {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    if (this.v)
      return; 
    boolean bool1 = layoutManager.canScrollHorizontally();
    boolean bool2 = this.n.canScrollVertically();
    if (bool1 || bool2) {
      if (!bool1)
        paramInt1 = 0; 
      if (!bool2)
        paramInt2 = 0; 
      a(paramInt1, paramInt2, (MotionEvent)null);
    } 
  }
  
  public void scrollTo(int paramInt1, int paramInt2) {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt) {
    if (this.v)
      return; 
    stopScroll();
    LayoutManager layoutManager = this.n;
    if (layoutManager == null) {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    layoutManager.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent) {
    if (a(paramAccessibilityEvent))
      return; 
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate) {
    this.H = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate((View)this, this.H);
  }
  
  public void setAdapter(Adapter paramAdapter) {
    setLayoutFrozen(false);
    a(paramAdapter, false, true);
    c(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(ChildDrawingOrderCallback paramChildDrawingOrderCallback) {
    boolean bool;
    if (paramChildDrawingOrderCallback == this.aA)
      return; 
    this.aA = paramChildDrawingOrderCallback;
    if (this.aA != null) {
      bool = true;
    } else {
      bool = false;
    } 
    setChildrenDrawingOrderEnabled(bool);
  }
  
  public void setClipToPadding(boolean paramBoolean) {
    if (paramBoolean != this.i)
      j(); 
    this.i = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.t)
      requestLayout(); 
  }
  
  public void setEdgeEffectFactory(EdgeEffectFactory paramEdgeEffectFactory) {
    Preconditions.checkNotNull(paramEdgeEffectFactory);
    this.ae = paramEdgeEffectFactory;
    j();
  }
  
  public void setHasFixedSize(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  public void setItemAnimator(ItemAnimator paramItemAnimator) {
    ItemAnimator itemAnimator = this.z;
    if (itemAnimator != null) {
      itemAnimator.endAnimations();
      this.z.a(null);
    } 
    this.z = paramItemAnimator;
    paramItemAnimator = this.z;
    if (paramItemAnimator != null)
      paramItemAnimator.a(this.az); 
  }
  
  public void setItemViewCacheSize(int paramInt) {
    this.e.setViewCacheSize(paramInt);
  }
  
  @Deprecated
  public void setLayoutFrozen(boolean paramBoolean) {
    suppressLayout(paramBoolean);
  }
  
  public void setLayoutManager(LayoutManager paramLayoutManager) {
    if (paramLayoutManager == this.n)
      return; 
    stopScroll();
    if (this.n != null) {
      ItemAnimator itemAnimator = this.z;
      if (itemAnimator != null)
        itemAnimator.endAnimations(); 
      this.n.removeAndRecycleAllViews(this.e);
      this.n.a(this.e);
      this.e.clear();
      if (this.q)
        this.n.a(this, this.e); 
      this.n.a((RecyclerView)null);
      this.n = null;
    } else {
      this.e.clear();
    } 
    this.g.a();
    this.n = paramLayoutManager;
    if (paramLayoutManager != null)
      if (paramLayoutManager.q == null) {
        this.n.a(this);
        if (this.q)
          this.n.b(this); 
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LayoutManager ");
        stringBuilder.append(paramLayoutManager);
        stringBuilder.append(" is already attached to a RecyclerView:");
        stringBuilder.append(paramLayoutManager.q.a());
        throw new IllegalArgumentException(stringBuilder.toString());
      }  
    this.e.a();
    requestLayout();
  }
  
  @Deprecated
  public void setLayoutTransition(LayoutTransition paramLayoutTransition) {
    if (Build.VERSION.SDK_INT < 18) {
      if (paramLayoutTransition == null) {
        suppressLayout(false);
        return;
      } 
      if (paramLayoutTransition.getAnimator(0) == null && paramLayoutTransition.getAnimator(1) == null && paramLayoutTransition.getAnimator(2) == null && paramLayoutTransition.getAnimator(3) == null && paramLayoutTransition.getAnimator(4) == null) {
        suppressLayout(true);
        return;
      } 
    } 
    if (paramLayoutTransition == null) {
      super.setLayoutTransition(null);
      return;
    } 
    throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(OnFlingListener paramOnFlingListener) {
    this.ar = paramOnFlingListener;
  }
  
  @Deprecated
  public void setOnScrollListener(OnScrollListener paramOnScrollListener) {
    this.ax = paramOnScrollListener;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean) {
    this.aw = paramBoolean;
  }
  
  public void setRecycledViewPool(RecycledViewPool paramRecycledViewPool) {
    this.e.a(paramRecycledViewPool);
  }
  
  public void setRecyclerListener(RecyclerListener paramRecyclerListener) {
    this.o = paramRecyclerListener;
  }
  
  void setScrollState(int paramInt) {
    if (paramInt == this.aj)
      return; 
    this.aj = paramInt;
    if (paramInt != 2)
      y(); 
    b(paramInt);
  }
  
  public void setScrollingTouchSlop(int paramInt) {
    ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
    if (paramInt != 0)
      if (paramInt != 1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
        stringBuilder.append(paramInt);
        stringBuilder.append("; using default value");
        Log.w("RecyclerView", stringBuilder.toString());
      } else {
        this.aq = viewConfiguration.getScaledPagingTouchSlop();
        return;
      }  
    this.aq = viewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(ViewCacheExtension paramViewCacheExtension) {
    this.e.a(paramViewCacheExtension);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2) {
    smoothScrollBy(paramInt1, paramInt2, (Interpolator)null);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator) {
    smoothScrollBy(paramInt1, paramInt2, paramInterpolator, -2147483648);
  }
  
  public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3) {
    a(paramInt1, paramInt2, paramInterpolator, paramInt3, false);
  }
  
  public void smoothScrollToPosition(int paramInt) {
    if (this.v)
      return; 
    LayoutManager layoutManager = this.n;
    if (layoutManager == null) {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    } 
    layoutManager.smoothScrollToPosition(this, this.D, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt) {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2) {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  public void stopNestedScroll() {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopNestedScroll(int paramInt) {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
  
  public void stopScroll() {
    setScrollState(0);
    y();
  }
  
  public final void suppressLayout(boolean paramBoolean) {
    if (paramBoolean != this.v) {
      b("Do not suppressLayout in layout or scroll");
      if (!paramBoolean) {
        this.v = false;
        if (this.u && this.n != null && this.m != null)
          requestLayout(); 
        this.u = false;
        return;
      } 
      long l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
      this.v = true;
      this.V = true;
      stopScroll();
    } 
  }
  
  public void swapAdapter(Adapter paramAdapter, boolean paramBoolean) {
    setLayoutFrozen(false);
    a(paramAdapter, true, paramBoolean);
    c(true);
    requestLayout();
  }
  
  void t() {
    int j = this.g.b();
    for (int i = 0; i < j; i++) {
      View view = this.g.b(i);
      ViewHolder viewHolder = getChildViewHolder(view);
      if (viewHolder != null && viewHolder.h != null) {
        View view1 = viewHolder.h.itemView;
        int k = view.getLeft();
        int m = view.getTop();
        if (k != view1.getLeft() || m != view1.getTop())
          view1.layout(k, m, view1.getWidth() + k, view1.getHeight() + m); 
      } 
    } 
  }
  
  void u() {
    for (int i = this.J.size() - 1; i >= 0; i--) {
      ViewHolder viewHolder = this.J.get(i);
      if (viewHolder.itemView.getParent() == this && !viewHolder.bf_()) {
        int j = viewHolder.n;
        if (j != -1) {
          ViewCompat.setImportantForAccessibility(viewHolder.itemView, j);
          viewHolder.n = -1;
        } 
      } 
    } 
    this.J.clear();
  }
  
  static {
    boolean bool;
  }
  
  public static final int HORIZONTAL = 0;
  
  public static final int INVALID_TYPE = -1;
  
  static final Interpolator K;
  
  private static final int[] L = new int[] { 16843830 };
  
  private static final boolean M;
  
  private static final boolean N;
  
  public static final long NO_ID = -1L;
  
  public static final int NO_POSITION = -1;
  
  private static final Class<?>[] O;
  
  public static final int SCROLL_STATE_DRAGGING = 1;
  
  public static final int SCROLL_STATE_IDLE = 0;
  
  public static final int SCROLL_STATE_SETTLING = 2;
  
  public static final int TOUCH_SLOP_DEFAULT = 0;
  
  public static final int TOUCH_SLOP_PAGING = 1;
  
  public static final int UNDEFINED_DURATION = -2147483648;
  
  public static final int VERTICAL = 1;
  
  static final boolean a;
  
  static final boolean b;
  
  static final boolean c;
  
  static final boolean d;
  
  final ViewFlinger A;
  
  GapWorker B;
  
  GapWorker.LayoutPrefetchRegistryImpl C;
  
  final State D;
  
  boolean E;
  
  boolean F;
  
  boolean G;
  
  RecyclerViewAccessibilityDelegate H;
  
  final int[] I;
  
  final List<ViewHolder> J;
  
  private final RecyclerViewDataObserver P;
  
  private SavedState Q;
  
  private final Rect R;
  
  private final ArrayList<OnItemTouchListener> S;
  
  private OnItemTouchListener T;
  
  private int U;
  
  private boolean V;
  
  private int W;
  
  private ChildDrawingOrderCallback aA;
  
  private final int[] aB;
  
  private NestedScrollingChildHelper aC;
  
  private final int[] aD;
  
  private final int[] aE;
  
  private Runnable aF;
  
  private final ViewInfoStore.ProcessCallback aG;
  
  private final AccessibilityManager aa;
  
  private List<OnChildAttachStateChangeListener> ab;
  
  private int ac;
  
  private int ad;
  
  private EdgeEffectFactory ae;
  
  private EdgeEffect af;
  
  private EdgeEffect ag;
  
  private EdgeEffect ah;
  
  private EdgeEffect ai;
  
  private int aj;
  
  private int ak;
  
  private VelocityTracker al;
  
  private int am;
  
  private int an;
  
  private int ao;
  
  private int ap;
  
  private int aq;
  
  private OnFlingListener ar;
  
  private final int as;
  
  private final int at;
  
  private float au;
  
  private float av;
  
  private boolean aw;
  
  private OnScrollListener ax;
  
  private List<OnScrollListener> ay;
  
  private ItemAnimator.ItemAnimatorListener az;
  
  final Recycler e;
  
  AdapterHelper f;
  
  ChildHelper g;
  
  final ViewInfoStore h;
  
  boolean i;
  
  final Runnable j;
  
  final Rect k;
  
  final RectF l;
  
  Adapter m;
  
  LayoutManager n;
  
  RecyclerListener o;
  
  final ArrayList<ItemDecoration> p;
  
  boolean q;
  
  boolean r;
  
  boolean s;
  
  boolean t;
  
  boolean u;
  
  boolean v;
  
  boolean w;
  
  boolean x;
  
  boolean y;
  
  ItemAnimator z;
  
  public static abstract class Adapter<VH extends ViewHolder> {
    private final RecyclerView.AdapterDataObservable a = new RecyclerView.AdapterDataObservable();
    
    private boolean b = false;
    
    public final void bindViewHolder(VH param1VH, int param1Int) {
      ((RecyclerView.ViewHolder)param1VH).b = param1Int;
      if (hasStableIds())
        ((RecyclerView.ViewHolder)param1VH).d = getItemId(param1Int); 
      param1VH.a(1, 519);
      TraceCompat.beginSection("RV OnBindView");
      onBindViewHolder(param1VH, param1Int, param1VH.r());
      param1VH.q();
      ViewGroup.LayoutParams layoutParams = ((RecyclerView.ViewHolder)param1VH).itemView.getLayoutParams();
      if (layoutParams instanceof RecyclerView.LayoutParams)
        ((RecyclerView.LayoutParams)layoutParams).e = true; 
      TraceCompat.endSection();
    }
    
    public final VH createViewHolder(ViewGroup param1ViewGroup, int param1Int) {
      try {
        TraceCompat.beginSection("RV CreateView");
        param1ViewGroup = (ViewGroup)onCreateViewHolder(param1ViewGroup, param1Int);
        if (((RecyclerView.ViewHolder)param1ViewGroup).itemView.getParent() == null) {
          ((RecyclerView.ViewHolder)param1ViewGroup).e = param1Int;
          return (VH)param1ViewGroup;
        } 
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      } finally {
        TraceCompat.endSection();
      } 
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int param1Int) {
      return -1L;
    }
    
    public int getItemViewType(int param1Int) {
      return 0;
    }
    
    public final boolean hasObservers() {
      return this.a.hasObservers();
    }
    
    public final boolean hasStableIds() {
      return this.b;
    }
    
    public final void notifyDataSetChanged() {
      this.a.notifyChanged();
    }
    
    public final void notifyItemChanged(int param1Int) {
      this.a.notifyItemRangeChanged(param1Int, 1);
    }
    
    public final void notifyItemChanged(int param1Int, Object param1Object) {
      this.a.notifyItemRangeChanged(param1Int, 1, param1Object);
    }
    
    public final void notifyItemInserted(int param1Int) {
      this.a.notifyItemRangeInserted(param1Int, 1);
    }
    
    public final void notifyItemMoved(int param1Int1, int param1Int2) {
      this.a.notifyItemMoved(param1Int1, param1Int2);
    }
    
    public final void notifyItemRangeChanged(int param1Int1, int param1Int2) {
      this.a.notifyItemRangeChanged(param1Int1, param1Int2);
    }
    
    public final void notifyItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      this.a.notifyItemRangeChanged(param1Int1, param1Int2, param1Object);
    }
    
    public final void notifyItemRangeInserted(int param1Int1, int param1Int2) {
      this.a.notifyItemRangeInserted(param1Int1, param1Int2);
    }
    
    public final void notifyItemRangeRemoved(int param1Int1, int param1Int2) {
      this.a.notifyItemRangeRemoved(param1Int1, param1Int2);
    }
    
    public final void notifyItemRemoved(int param1Int) {
      this.a.notifyItemRangeRemoved(param1Int, 1);
    }
    
    public void onAttachedToRecyclerView(RecyclerView param1RecyclerView) {}
    
    public abstract void onBindViewHolder(VH param1VH, int param1Int);
    
    public void onBindViewHolder(VH param1VH, int param1Int, List<Object> param1List) {
      onBindViewHolder(param1VH, param1Int);
    }
    
    public abstract VH onCreateViewHolder(ViewGroup param1ViewGroup, int param1Int);
    
    public void onDetachedFromRecyclerView(RecyclerView param1RecyclerView) {}
    
    public boolean onFailedToRecycleView(VH param1VH) {
      return false;
    }
    
    public void onViewAttachedToWindow(VH param1VH) {}
    
    public void onViewDetachedFromWindow(VH param1VH) {}
    
    public void onViewRecycled(VH param1VH) {}
    
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver param1AdapterDataObserver) {
      this.a.registerObserver(param1AdapterDataObserver);
    }
    
    public void setHasStableIds(boolean param1Boolean) {
      if (!hasObservers()) {
        this.b = param1Boolean;
        return;
      } 
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver param1AdapterDataObserver) {
      this.a.unregisterObserver(param1AdapterDataObserver);
    }
  }
  
  static class AdapterDataObservable extends Observable<AdapterDataObserver> {
    public boolean hasObservers() {
      return this.mObservers.isEmpty() ^ true;
    }
    
    public void notifyChanged() {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onChanged(); 
    }
    
    public void notifyItemMoved(int param1Int1, int param1Int2) {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeMoved(param1Int1, param1Int2, 1); 
    }
    
    public void notifyItemRangeChanged(int param1Int1, int param1Int2) {
      notifyItemRangeChanged(param1Int1, param1Int2, (Object)null);
    }
    
    public void notifyItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      int i;
      for (i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(param1Int1, param1Int2, param1Object); 
    }
    
    public void notifyItemRangeInserted(int param1Int1, int param1Int2) {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(param1Int1, param1Int2); 
    }
    
    public void notifyItemRangeRemoved(int param1Int1, int param1Int2) {
      for (int i = this.mObservers.size() - 1; i >= 0; i--)
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(param1Int1, param1Int2); 
    }
  }
  
  public static abstract class AdapterDataObserver {
    public void onChanged() {}
    
    public void onItemRangeChanged(int param1Int1, int param1Int2) {}
    
    public void onItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      onItemRangeChanged(param1Int1, param1Int2);
    }
    
    public void onItemRangeInserted(int param1Int1, int param1Int2) {}
    
    public void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onItemRangeRemoved(int param1Int1, int param1Int2) {}
  }
  
  public static interface ChildDrawingOrderCallback {
    int onGetChildDrawingOrder(int param1Int1, int param1Int2);
  }
  
  public static class EdgeEffectFactory {
    public static final int DIRECTION_BOTTOM = 3;
    
    public static final int DIRECTION_LEFT = 0;
    
    public static final int DIRECTION_RIGHT = 2;
    
    public static final int DIRECTION_TOP = 1;
    
    protected EdgeEffect a(RecyclerView param1RecyclerView, int param1Int) {
      return new EdgeEffect(param1RecyclerView.getContext());
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface EdgeDirection {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface EdgeDirection {}
  
  public static abstract class ItemAnimator {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    
    public static final int FLAG_CHANGED = 2;
    
    public static final int FLAG_INVALIDATED = 4;
    
    public static final int FLAG_MOVED = 2048;
    
    public static final int FLAG_REMOVED = 8;
    
    private ItemAnimatorListener a = null;
    
    private ArrayList<ItemAnimatorFinishedListener> b = new ArrayList<ItemAnimatorFinishedListener>();
    
    private long c = 120L;
    
    private long d = 120L;
    
    private long e = 250L;
    
    private long f = 250L;
    
    static int b(RecyclerView.ViewHolder param1ViewHolder) {
      int j = param1ViewHolder.i & 0xE;
      if (param1ViewHolder.j())
        return 4; 
      int i = j;
      if ((j & 0x4) == 0) {
        int k = param1ViewHolder.getOldPosition();
        int m = param1ViewHolder.getAdapterPosition();
        i = j;
        if (k != -1) {
          i = j;
          if (m != -1) {
            i = j;
            if (k != m)
              i = j | 0x800; 
          } 
        } 
      } 
      return i;
    }
    
    void a(ItemAnimatorListener param1ItemAnimatorListener) {
      this.a = param1ItemAnimatorListener;
    }
    
    public abstract boolean animateAppearance(RecyclerView.ViewHolder param1ViewHolder, ItemHolderInfo param1ItemHolderInfo1, ItemHolderInfo param1ItemHolderInfo2);
    
    public abstract boolean animateChange(RecyclerView.ViewHolder param1ViewHolder1, RecyclerView.ViewHolder param1ViewHolder2, ItemHolderInfo param1ItemHolderInfo1, ItemHolderInfo param1ItemHolderInfo2);
    
    public abstract boolean animateDisappearance(RecyclerView.ViewHolder param1ViewHolder, ItemHolderInfo param1ItemHolderInfo1, ItemHolderInfo param1ItemHolderInfo2);
    
    public abstract boolean animatePersistence(RecyclerView.ViewHolder param1ViewHolder, ItemHolderInfo param1ItemHolderInfo1, ItemHolderInfo param1ItemHolderInfo2);
    
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder param1ViewHolder) {
      return true;
    }
    
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder param1ViewHolder, List<Object> param1List) {
      return canReuseUpdatedViewHolder(param1ViewHolder);
    }
    
    public final void dispatchAnimationFinished(RecyclerView.ViewHolder param1ViewHolder) {
      onAnimationFinished(param1ViewHolder);
      ItemAnimatorListener itemAnimatorListener = this.a;
      if (itemAnimatorListener != null)
        itemAnimatorListener.onAnimationFinished(param1ViewHolder); 
    }
    
    public final void dispatchAnimationStarted(RecyclerView.ViewHolder param1ViewHolder) {
      onAnimationStarted(param1ViewHolder);
    }
    
    public final void dispatchAnimationsFinished() {
      int j = this.b.size();
      for (int i = 0; i < j; i++)
        ((ItemAnimatorFinishedListener)this.b.get(i)).onAnimationsFinished(); 
      this.b.clear();
    }
    
    public abstract void endAnimation(RecyclerView.ViewHolder param1ViewHolder);
    
    public abstract void endAnimations();
    
    public long getAddDuration() {
      return this.c;
    }
    
    public long getChangeDuration() {
      return this.f;
    }
    
    public long getMoveDuration() {
      return this.e;
    }
    
    public long getRemoveDuration() {
      return this.d;
    }
    
    public abstract boolean isRunning();
    
    public final boolean isRunning(ItemAnimatorFinishedListener param1ItemAnimatorFinishedListener) {
      boolean bool = isRunning();
      if (param1ItemAnimatorFinishedListener != null) {
        if (!bool) {
          param1ItemAnimatorFinishedListener.onAnimationsFinished();
          return bool;
        } 
        this.b.add(param1ItemAnimatorFinishedListener);
      } 
      return bool;
    }
    
    public ItemHolderInfo obtainHolderInfo() {
      return new ItemHolderInfo();
    }
    
    public void onAnimationFinished(RecyclerView.ViewHolder param1ViewHolder) {}
    
    public void onAnimationStarted(RecyclerView.ViewHolder param1ViewHolder) {}
    
    public ItemHolderInfo recordPostLayoutInformation(RecyclerView.State param1State, RecyclerView.ViewHolder param1ViewHolder) {
      return obtainHolderInfo().setFrom(param1ViewHolder);
    }
    
    public ItemHolderInfo recordPreLayoutInformation(RecyclerView.State param1State, RecyclerView.ViewHolder param1ViewHolder, int param1Int, List<Object> param1List) {
      return obtainHolderInfo().setFrom(param1ViewHolder);
    }
    
    public abstract void runPendingAnimations();
    
    public void setAddDuration(long param1Long) {
      this.c = param1Long;
    }
    
    public void setChangeDuration(long param1Long) {
      this.f = param1Long;
    }
    
    public void setMoveDuration(long param1Long) {
      this.e = param1Long;
    }
    
    public void setRemoveDuration(long param1Long) {
      this.d = param1Long;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface AdapterChanges {}
    
    public static interface ItemAnimatorFinishedListener {
      void onAnimationsFinished();
    }
    
    static interface ItemAnimatorListener {
      void onAnimationFinished(RecyclerView.ViewHolder param2ViewHolder);
    }
    
    public static class ItemHolderInfo {
      public int bottom;
      
      public int changeFlags;
      
      public int left;
      
      public int right;
      
      public int top;
      
      public ItemHolderInfo setFrom(RecyclerView.ViewHolder param2ViewHolder) {
        return setFrom(param2ViewHolder, 0);
      }
      
      public ItemHolderInfo setFrom(RecyclerView.ViewHolder param2ViewHolder, int param2Int) {
        View view = param2ViewHolder.itemView;
        this.left = view.getLeft();
        this.top = view.getTop();
        this.right = view.getRight();
        this.bottom = view.getBottom();
        return this;
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AdapterChanges {}
  
  public static interface ItemAnimatorFinishedListener {
    void onAnimationsFinished();
  }
  
  static interface ItemAnimatorListener {
    void onAnimationFinished(RecyclerView.ViewHolder param1ViewHolder);
  }
  
  public static class ItemHolderInfo {
    public int bottom;
    
    public int changeFlags;
    
    public int left;
    
    public int right;
    
    public int top;
    
    public ItemHolderInfo setFrom(RecyclerView.ViewHolder param1ViewHolder) {
      return setFrom(param1ViewHolder, 0);
    }
    
    public ItemHolderInfo setFrom(RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
      View view = param1ViewHolder.itemView;
      this.left = view.getLeft();
      this.top = view.getTop();
      this.right = view.getRight();
      this.bottom = view.getBottom();
      return this;
    }
  }
  
  class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
    ItemAnimatorRestoreListener(RecyclerView this$0) {}
    
    public void onAnimationFinished(RecyclerView.ViewHolder param1ViewHolder) {
      param1ViewHolder.setIsRecyclable(true);
      if (param1ViewHolder.g != null && param1ViewHolder.h == null)
        param1ViewHolder.g = null; 
      param1ViewHolder.h = null;
      if (!param1ViewHolder.t() && !this.a.a(param1ViewHolder.itemView) && param1ViewHolder.n())
        this.a.removeDetachedView(param1ViewHolder.itemView, false); 
    }
  }
  
  public static abstract class ItemDecoration {
    @Deprecated
    public void getItemOffsets(Rect param1Rect, int param1Int, RecyclerView param1RecyclerView) {
      param1Rect.set(0, 0, 0, 0);
    }
    
    public void getItemOffsets(Rect param1Rect, View param1View, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      getItemOffsets(param1Rect, ((RecyclerView.LayoutParams)param1View.getLayoutParams()).getViewLayoutPosition(), param1RecyclerView);
    }
    
    @Deprecated
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView) {}
    
    public void onDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      onDraw(param1Canvas, param1RecyclerView);
    }
    
    @Deprecated
    public void onDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView) {}
    
    public void onDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.State param1State) {
      onDrawOver(param1Canvas, param1RecyclerView);
    }
  }
  
  public static abstract class LayoutManager {
    private final ViewBoundsCheck.Callback a = new ViewBoundsCheck.Callback(this) {
        public View getChildAt(int param2Int) {
          return this.a.getChildAt(param2Int);
        }
        
        public int getChildEnd(View param2View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param2View.getLayoutParams();
          return this.a.getDecoratedRight(param2View) + layoutParams.rightMargin;
        }
        
        public int getChildStart(View param2View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param2View.getLayoutParams();
          return this.a.getDecoratedLeft(param2View) - layoutParams.leftMargin;
        }
        
        public int getParentEnd() {
          return this.a.getWidth() - this.a.getPaddingRight();
        }
        
        public int getParentStart() {
          return this.a.getPaddingLeft();
        }
      };
    
    private final ViewBoundsCheck.Callback b = new ViewBoundsCheck.Callback(this) {
        public View getChildAt(int param2Int) {
          return this.a.getChildAt(param2Int);
        }
        
        public int getChildEnd(View param2View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param2View.getLayoutParams();
          return this.a.getDecoratedBottom(param2View) + layoutParams.bottomMargin;
        }
        
        public int getChildStart(View param2View) {
          RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param2View.getLayoutParams();
          return this.a.getDecoratedTop(param2View) - layoutParams.topMargin;
        }
        
        public int getParentEnd() {
          return this.a.getHeight() - this.a.getPaddingBottom();
        }
        
        public int getParentStart() {
          return this.a.getPaddingTop();
        }
      };
    
    private boolean c = true;
    
    private boolean d = true;
    
    private int e;
    
    private int f;
    
    private int g;
    
    private int h;
    
    ChildHelper p;
    
    RecyclerView q;
    
    ViewBoundsCheck r = new ViewBoundsCheck(this.a);
    
    ViewBoundsCheck s = new ViewBoundsCheck(this.b);
    
    RecyclerView.SmoothScroller t;
    
    boolean u = false;
    
    boolean v = false;
    
    boolean w = false;
    
    int x;
    
    boolean y;
    
    private void a(int param1Int, View param1View) {
      this.p.e(param1Int);
    }
    
    private void a(View param1View, int param1Int, boolean param1Boolean) {
      StringBuilder stringBuilder;
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      if (param1Boolean || viewHolder.m()) {
        this.q.h.e(viewHolder);
      } else {
        this.q.h.f(viewHolder);
      } 
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      if (viewHolder.f() || viewHolder.d()) {
        if (viewHolder.d()) {
          viewHolder.e();
        } else {
          viewHolder.g();
        } 
        this.p.a(param1View, param1Int, param1View.getLayoutParams(), false);
      } else if (param1View.getParent() == this.q) {
        int j = this.p.b(param1View);
        int i = param1Int;
        if (param1Int == -1)
          i = this.p.b(); 
        if (j != -1) {
          if (j != i)
            this.q.n.moveView(j, i); 
        } else {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
          stringBuilder.append(this.q.indexOfChild(param1View));
          stringBuilder.append(this.q.a());
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } else {
        this.p.a(param1View, param1Int, false);
        layoutParams.e = true;
        RecyclerView.SmoothScroller smoothScroller = this.t;
        if (smoothScroller != null && smoothScroller.isRunning())
          this.t.a(param1View); 
      } 
      if (layoutParams.f) {
        ((RecyclerView.ViewHolder)stringBuilder).itemView.invalidate();
        layoutParams.f = false;
      } 
    }
    
    private void a(RecyclerView.Recycler param1Recycler, int param1Int, View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      if (viewHolder.bf_())
        return; 
      if (viewHolder.j() && !viewHolder.m() && !this.q.m.hasStableIds()) {
        removeViewAt(param1Int);
        param1Recycler.b(viewHolder);
        return;
      } 
      detachViewAt(param1Int);
      param1Recycler.b(param1View);
      this.q.h.onViewDetached(viewHolder);
    }
    
    private static boolean a(int param1Int1, int param1Int2, int param1Int3) {
      int i = View.MeasureSpec.getMode(param1Int2);
      param1Int2 = View.MeasureSpec.getSize(param1Int2);
      boolean bool2 = false;
      boolean bool1 = false;
      if (param1Int3 > 0 && param1Int1 != param1Int3)
        return false; 
      if (i != Integer.MIN_VALUE) {
        if (i != 0) {
          if (i != 1073741824)
            return false; 
          if (param1Int2 == param1Int1)
            bool1 = true; 
          return bool1;
        } 
        return true;
      } 
      bool1 = bool2;
      if (param1Int2 >= param1Int1)
        bool1 = true; 
      return bool1;
    }
    
    private boolean a(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
      View view = param1RecyclerView.getFocusedChild();
      if (view == null)
        return false; 
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth();
      int m = getPaddingRight();
      int n = getHeight();
      int i1 = getPaddingBottom();
      Rect rect = this.q.k;
      getDecoratedBoundsWithMargins(view, rect);
      return (rect.left - param1Int1 < k - m && rect.right - param1Int1 > i && rect.top - param1Int2 < n - i1) ? (!(rect.bottom - param1Int2 <= j)) : false;
    }
    
    private int[] a(View param1View, Rect param1Rect) {
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth();
      int i5 = getPaddingRight();
      int n = getHeight();
      int i1 = getPaddingBottom();
      int i6 = param1View.getLeft() + param1Rect.left - param1View.getScrollX();
      int i2 = param1View.getTop() + param1Rect.top - param1View.getScrollY();
      int i7 = param1Rect.width();
      int i3 = param1Rect.height();
      int i4 = i6 - i;
      i = Math.min(0, i4);
      int m = i2 - j;
      j = Math.min(0, m);
      i5 = i7 + i6 - k - i5;
      k = Math.max(0, i5);
      n = Math.max(0, i3 + i2 - n - i1);
      if (getLayoutDirection() == 1) {
        if (k != 0) {
          i = k;
        } else {
          i = Math.max(i, i5);
        } 
      } else if (i == 0) {
        i = Math.min(i4, k);
      } 
      if (j == 0)
        j = Math.min(m, n); 
      return new int[] { i, j };
    }
    
    public static int chooseSize(int param1Int1, int param1Int2, int param1Int3) {
      int i = View.MeasureSpec.getMode(param1Int1);
      param1Int1 = View.MeasureSpec.getSize(param1Int1);
      if (i != Integer.MIN_VALUE) {
        if (i != 1073741824)
          param1Int1 = Math.max(param1Int2, param1Int3); 
        return param1Int1;
      } 
      return Math.min(param1Int1, Math.max(param1Int2, param1Int3));
    }
    
    public static int getChildMeasureSpec(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      // Byte code:
      //   0: iconst_0
      //   1: istore #6
      //   3: iconst_0
      //   4: iload_0
      //   5: iload_2
      //   6: isub
      //   7: invokestatic max : (II)I
      //   10: istore #5
      //   12: iload #4
      //   14: ifeq -> 62
      //   17: iload_3
      //   18: iflt -> 24
      //   21: goto -> 66
      //   24: iload_3
      //   25: iconst_m1
      //   26: if_icmpne -> 120
      //   29: iload_1
      //   30: ldc -2147483648
      //   32: if_icmpeq -> 52
      //   35: iload_1
      //   36: ifeq -> 45
      //   39: iload_1
      //   40: ldc 1073741824
      //   42: if_icmpeq -> 52
      //   45: iconst_0
      //   46: istore_1
      //   47: iconst_0
      //   48: istore_0
      //   49: goto -> 55
      //   52: iload #5
      //   54: istore_0
      //   55: iload_0
      //   56: istore_2
      //   57: iload_1
      //   58: istore_0
      //   59: goto -> 125
      //   62: iload_3
      //   63: iflt -> 74
      //   66: iload_3
      //   67: istore_2
      //   68: ldc 1073741824
      //   70: istore_0
      //   71: goto -> 125
      //   74: iload_3
      //   75: iconst_m1
      //   76: if_icmpne -> 87
      //   79: iload_1
      //   80: istore_0
      //   81: iload #5
      //   83: istore_2
      //   84: goto -> 125
      //   87: iload_3
      //   88: bipush #-2
      //   90: if_icmpne -> 120
      //   93: iload_1
      //   94: ldc -2147483648
      //   96: if_icmpeq -> 111
      //   99: iload #5
      //   101: istore_2
      //   102: iload #6
      //   104: istore_0
      //   105: iload_1
      //   106: ldc 1073741824
      //   108: if_icmpne -> 125
      //   111: ldc -2147483648
      //   113: istore_0
      //   114: iload #5
      //   116: istore_2
      //   117: goto -> 125
      //   120: iconst_0
      //   121: istore_2
      //   122: iload #6
      //   124: istore_0
      //   125: iload_2
      //   126: iload_0
      //   127: invokestatic makeMeasureSpec : (II)I
      //   130: ireturn
    }
    
    @Deprecated
    public static int getChildMeasureSpec(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      // Byte code:
      //   0: iconst_0
      //   1: istore #4
      //   3: iconst_0
      //   4: iload_0
      //   5: iload_1
      //   6: isub
      //   7: invokestatic max : (II)I
      //   10: istore_0
      //   11: iload_3
      //   12: ifeq -> 30
      //   15: iload_2
      //   16: iflt -> 22
      //   19: goto -> 34
      //   22: iconst_0
      //   23: istore_0
      //   24: iload #4
      //   26: istore_1
      //   27: goto -> 59
      //   30: iload_2
      //   31: iflt -> 42
      //   34: iload_2
      //   35: istore_0
      //   36: ldc 1073741824
      //   38: istore_1
      //   39: goto -> 59
      //   42: iload_2
      //   43: iconst_m1
      //   44: if_icmpne -> 50
      //   47: goto -> 36
      //   50: iload_2
      //   51: bipush #-2
      //   53: if_icmpne -> 22
      //   56: ldc -2147483648
      //   58: istore_1
      //   59: iload_0
      //   60: iload_1
      //   61: invokestatic makeMeasureSpec : (II)I
      //   64: ireturn
    }
    
    public static Properties getProperties(Context param1Context, AttributeSet param1AttributeSet, int param1Int1, int param1Int2) {
      Properties properties = new Properties();
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.RecyclerView, param1Int1, param1Int2);
      properties.orientation = typedArray.getInt(R.styleable.RecyclerView_android_orientation, 1);
      properties.spanCount = typedArray.getInt(R.styleable.RecyclerView_spanCount, 1);
      properties.reverseLayout = typedArray.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      properties.stackFromEnd = typedArray.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      typedArray.recycle();
      return properties;
    }
    
    void a(View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      if (viewHolder != null && !viewHolder.m() && !this.p.c(viewHolder.itemView))
        onInitializeAccessibilityNodeInfoForItem(this.q.e, this.q.D, param1View, param1AccessibilityNodeInfoCompat); 
    }
    
    void a(AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      onInitializeAccessibilityNodeInfo(this.q.e, this.q.D, param1AccessibilityNodeInfoCompat);
    }
    
    void a(RecyclerView.Recycler param1Recycler) {
      int j = param1Recycler.c();
      for (int i = j - 1; i >= 0; i--) {
        View view = param1Recycler.b(i);
        RecyclerView.ViewHolder viewHolder = RecyclerView.b(view);
        if (!viewHolder.bf_()) {
          viewHolder.setIsRecyclable(false);
          if (viewHolder.n())
            this.q.removeDetachedView(view, false); 
          if (this.q.z != null)
            this.q.z.endAnimation(viewHolder); 
          viewHolder.setIsRecyclable(true);
          param1Recycler.a(view);
        } 
      } 
      param1Recycler.d();
      if (j > 0)
        this.q.invalidate(); 
    }
    
    void a(RecyclerView.SmoothScroller param1SmoothScroller) {
      if (this.t == param1SmoothScroller)
        this.t = null; 
    }
    
    void a(RecyclerView param1RecyclerView) {
      if (param1RecyclerView == null) {
        this.q = null;
        this.p = null;
        this.g = 0;
        this.h = 0;
      } else {
        this.q = param1RecyclerView;
        this.p = param1RecyclerView.g;
        this.g = param1RecyclerView.getWidth();
        this.h = param1RecyclerView.getHeight();
      } 
      this.e = 1073741824;
      this.f = 1073741824;
    }
    
    void a(RecyclerView param1RecyclerView, RecyclerView.Recycler param1Recycler) {
      this.v = false;
      onDetachedFromWindow(param1RecyclerView, param1Recycler);
    }
    
    boolean a(int param1Int, Bundle param1Bundle) {
      return performAccessibilityAction(this.q.e, this.q.D, param1Int, param1Bundle);
    }
    
    boolean a(View param1View, int param1Int1, int param1Int2, RecyclerView.LayoutParams param1LayoutParams) {
      return (!this.c || !a(param1View.getMeasuredWidth(), param1Int1, param1LayoutParams.width) || !a(param1View.getMeasuredHeight(), param1Int2, param1LayoutParams.height));
    }
    
    boolean a(View param1View, int param1Int, Bundle param1Bundle) {
      return performAccessibilityActionForItem(this.q.e, this.q.D, param1View, param1Int, param1Bundle);
    }
    
    public void addDisappearingView(View param1View) {
      addDisappearingView(param1View, -1);
    }
    
    public void addDisappearingView(View param1View, int param1Int) {
      a(param1View, param1Int, true);
    }
    
    public void addView(View param1View) {
      addView(param1View, -1);
    }
    
    public void addView(View param1View, int param1Int) {
      a(param1View, param1Int, false);
    }
    
    public void assertInLayoutOrScroll(String param1String) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.a(param1String); 
    }
    
    public void assertNotInLayoutOrScroll(String param1String) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.b(param1String); 
    }
    
    public void attachView(View param1View) {
      attachView(param1View, -1);
    }
    
    public void attachView(View param1View, int param1Int) {
      attachView(param1View, param1Int, (RecyclerView.LayoutParams)param1View.getLayoutParams());
    }
    
    public void attachView(View param1View, int param1Int, RecyclerView.LayoutParams param1LayoutParams) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      if (viewHolder.m()) {
        this.q.h.e(viewHolder);
      } else {
        this.q.h.f(viewHolder);
      } 
      this.p.a(param1View, param1Int, (ViewGroup.LayoutParams)param1LayoutParams, viewHolder.m());
    }
    
    void b(RecyclerView param1RecyclerView) {
      this.v = true;
      onAttachedToWindow(param1RecyclerView);
    }
    
    boolean b(View param1View, int param1Int1, int param1Int2, RecyclerView.LayoutParams param1LayoutParams) {
      return (param1View.isLayoutRequested() || !this.c || !a(param1View.getWidth(), param1Int1, param1LayoutParams.width) || !a(param1View.getHeight(), param1Int2, param1LayoutParams.height));
    }
    
    void c(int param1Int1, int param1Int2) {
      this.g = View.MeasureSpec.getSize(param1Int1);
      this.e = View.MeasureSpec.getMode(param1Int1);
      if (this.e == 0 && !RecyclerView.b)
        this.g = 0; 
      this.h = View.MeasureSpec.getSize(param1Int2);
      this.f = View.MeasureSpec.getMode(param1Int2);
      if (this.f == 0 && !RecyclerView.b)
        this.h = 0; 
    }
    
    void c(RecyclerView param1RecyclerView) {
      c(View.MeasureSpec.makeMeasureSpec(param1RecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(param1RecyclerView.getHeight(), 1073741824));
    }
    
    public void calculateItemDecorationsForChild(View param1View, Rect param1Rect) {
      RecyclerView recyclerView = this.q;
      if (recyclerView == null) {
        param1Rect.set(0, 0, 0, 0);
        return;
      } 
      param1Rect.set(recyclerView.c(param1View));
    }
    
    public boolean canScrollHorizontally() {
      return false;
    }
    
    public boolean canScrollVertically() {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams param1LayoutParams) {
      return (param1LayoutParams != null);
    }
    
    public void collectAdjacentPrefetchPositions(int param1Int1, int param1Int2, RecyclerView.State param1State, LayoutPrefetchRegistry param1LayoutPrefetchRegistry) {}
    
    public void collectInitialPrefetchPositions(int param1Int, LayoutPrefetchRegistry param1LayoutPrefetchRegistry) {}
    
    public int computeHorizontalScrollExtent(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeHorizontalScrollRange(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeVerticalScrollExtent(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeVerticalScrollOffset(RecyclerView.State param1State) {
      return 0;
    }
    
    public int computeVerticalScrollRange(RecyclerView.State param1State) {
      return 0;
    }
    
    void d(int param1Int1, int param1Int2) {
      int i1 = getChildCount();
      if (i1 == 0) {
        this.q.c(param1Int1, param1Int2);
        return;
      } 
      int j = 0;
      int n = Integer.MAX_VALUE;
      int k = Integer.MAX_VALUE;
      int m = Integer.MIN_VALUE;
      int i;
      for (i = Integer.MIN_VALUE; j < i1; i = i4) {
        View view = getChildAt(j);
        Rect rect = this.q.k;
        getDecoratedBoundsWithMargins(view, rect);
        int i2 = n;
        if (rect.left < n)
          i2 = rect.left; 
        int i3 = m;
        if (rect.right > m)
          i3 = rect.right; 
        m = k;
        if (rect.top < k)
          m = rect.top; 
        int i4 = i;
        if (rect.bottom > i)
          i4 = rect.bottom; 
        j++;
        k = m;
        n = i2;
        m = i3;
      } 
      this.q.k.set(n, k, m, i);
      setMeasuredDimension(this.q.k, param1Int1, param1Int2);
    }
    
    public void detachAndScrapAttachedViews(RecyclerView.Recycler param1Recycler) {
      for (int i = getChildCount() - 1; i >= 0; i--)
        a(param1Recycler, i, getChildAt(i)); 
    }
    
    public void detachAndScrapView(View param1View, RecyclerView.Recycler param1Recycler) {
      a(param1Recycler, this.p.b(param1View), param1View);
    }
    
    public void detachAndScrapViewAt(int param1Int, RecyclerView.Recycler param1Recycler) {
      a(param1Recycler, param1Int, getChildAt(param1Int));
    }
    
    public void detachView(View param1View) {
      int i = this.p.b(param1View);
      if (i >= 0)
        a(i, param1View); 
    }
    
    public void detachViewAt(int param1Int) {
      a(param1Int, getChildAt(param1Int));
    }
    
    boolean e() {
      return false;
    }
    
    public void endAnimation(View param1View) {
      if (this.q.z != null)
        this.q.z.endAnimation(RecyclerView.b(param1View)); 
    }
    
    void f() {
      RecyclerView.SmoothScroller smoothScroller = this.t;
      if (smoothScroller != null)
        smoothScroller.e(); 
    }
    
    public View findContainingItemView(View param1View) {
      RecyclerView recyclerView = this.q;
      if (recyclerView == null)
        return null; 
      param1View = recyclerView.findContainingItemView(param1View);
      return (param1View == null) ? null : (this.p.c(param1View) ? null : param1View);
    }
    
    public View findViewByPosition(int param1Int) {
      int j = getChildCount();
      for (int i = 0; i < j; i++) {
        View view = getChildAt(i);
        RecyclerView.ViewHolder viewHolder = RecyclerView.b(view);
        if (viewHolder != null && viewHolder.getLayoutPosition() == param1Int && !viewHolder.bf_() && (this.q.D.isPreLayout() || !viewHolder.m()))
          return view; 
      } 
      return null;
    }
    
    boolean g() {
      int j = getChildCount();
      for (int i = 0; i < j; i++) {
        ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
        if (layoutParams.width < 0 && layoutParams.height < 0)
          return true; 
      } 
      return false;
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      return new RecyclerView.LayoutParams(param1Context, param1AttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      return (param1LayoutParams instanceof RecyclerView.LayoutParams) ? new RecyclerView.LayoutParams((RecyclerView.LayoutParams)param1LayoutParams) : ((param1LayoutParams instanceof ViewGroup.MarginLayoutParams) ? new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)param1LayoutParams) : new RecyclerView.LayoutParams(param1LayoutParams));
    }
    
    public int getBaseline() {
      return -1;
    }
    
    public int getBottomDecorationHeight(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d.bottom;
    }
    
    public View getChildAt(int param1Int) {
      ChildHelper childHelper = this.p;
      return (childHelper != null) ? childHelper.b(param1Int) : null;
    }
    
    public int getChildCount() {
      ChildHelper childHelper = this.p;
      return (childHelper != null) ? childHelper.b() : 0;
    }
    
    public boolean getClipToPadding() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null && recyclerView.i);
    }
    
    public int getColumnCountForAccessibility(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      RecyclerView recyclerView = this.q;
      byte b = 1;
      int i = b;
      if (recyclerView != null) {
        if (recyclerView.m == null)
          return 1; 
        i = b;
        if (canScrollHorizontally())
          i = this.q.m.getItemCount(); 
      } 
      return i;
    }
    
    public int getDecoratedBottom(View param1View) {
      return param1View.getBottom() + getBottomDecorationHeight(param1View);
    }
    
    public void getDecoratedBoundsWithMargins(View param1View, Rect param1Rect) {
      RecyclerView.a(param1View, param1Rect);
    }
    
    public int getDecoratedLeft(View param1View) {
      return param1View.getLeft() - getLeftDecorationWidth(param1View);
    }
    
    public int getDecoratedMeasuredHeight(View param1View) {
      Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d;
      return param1View.getMeasuredHeight() + rect.top + rect.bottom;
    }
    
    public int getDecoratedMeasuredWidth(View param1View) {
      Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d;
      return param1View.getMeasuredWidth() + rect.left + rect.right;
    }
    
    public int getDecoratedRight(View param1View) {
      return param1View.getRight() + getRightDecorationWidth(param1View);
    }
    
    public int getDecoratedTop(View param1View) {
      return param1View.getTop() - getTopDecorationHeight(param1View);
    }
    
    public View getFocusedChild() {
      RecyclerView recyclerView = this.q;
      if (recyclerView == null)
        return null; 
      View view = recyclerView.getFocusedChild();
      return (view != null) ? (this.p.c(view) ? null : view) : null;
    }
    
    public int getHeight() {
      return this.h;
    }
    
    public int getHeightMode() {
      return this.f;
    }
    
    public int getItemCount() {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
      } else {
        recyclerView = null;
      } 
      return (recyclerView != null) ? recyclerView.getItemCount() : 0;
    }
    
    public int getItemViewType(View param1View) {
      return RecyclerView.b(param1View).getItemViewType();
    }
    
    public int getLayoutDirection() {
      return ViewCompat.getLayoutDirection((View)this.q);
    }
    
    public int getLeftDecorationWidth(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d.left;
    }
    
    public int getMinimumHeight() {
      return ViewCompat.getMinimumHeight((View)this.q);
    }
    
    public int getMinimumWidth() {
      return ViewCompat.getMinimumWidth((View)this.q);
    }
    
    public int getPaddingBottom() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingBottom() : 0;
    }
    
    public int getPaddingEnd() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? ViewCompat.getPaddingEnd((View)recyclerView) : 0;
    }
    
    public int getPaddingLeft() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingLeft() : 0;
    }
    
    public int getPaddingRight() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingRight() : 0;
    }
    
    public int getPaddingStart() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? ViewCompat.getPaddingStart((View)recyclerView) : 0;
    }
    
    public int getPaddingTop() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.getPaddingTop() : 0;
    }
    
    public int getPosition(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).getViewLayoutPosition();
    }
    
    public int getRightDecorationWidth(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d.right;
    }
    
    public int getRowCountForAccessibility(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      RecyclerView recyclerView = this.q;
      byte b = 1;
      int i = b;
      if (recyclerView != null) {
        if (recyclerView.m == null)
          return 1; 
        i = b;
        if (canScrollVertically())
          i = this.q.m.getItemCount(); 
      } 
      return i;
    }
    
    public int getSelectionModeForAccessibility(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return 0;
    }
    
    public int getTopDecorationHeight(View param1View) {
      return ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d.top;
    }
    
    public void getTransformedBoundingBox(View param1View, boolean param1Boolean, Rect param1Rect) {
      if (param1Boolean) {
        Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d;
        param1Rect.set(-rect.left, -rect.top, param1View.getWidth() + rect.right, param1View.getHeight() + rect.bottom);
      } else {
        param1Rect.set(0, 0, param1View.getWidth(), param1View.getHeight());
      } 
      if (this.q != null) {
        Matrix matrix = param1View.getMatrix();
        if (matrix != null && !matrix.isIdentity()) {
          RectF rectF = this.q.l;
          rectF.set(param1Rect);
          matrix.mapRect(rectF);
          param1Rect.set((int)Math.floor(rectF.left), (int)Math.floor(rectF.top), (int)Math.ceil(rectF.right), (int)Math.ceil(rectF.bottom));
        } 
      } 
      param1Rect.offset(param1View.getLeft(), param1View.getTop());
    }
    
    public int getWidth() {
      return this.g;
    }
    
    public int getWidthMode() {
      return this.e;
    }
    
    public boolean hasFocus() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null && recyclerView.hasFocus());
    }
    
    public void ignoreView(View param1View) {
      ViewParent viewParent = param1View.getParent();
      RecyclerView recyclerView = this.q;
      if (viewParent == recyclerView && recyclerView.indexOfChild(param1View) != -1) {
        RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
        viewHolder.b(128);
        this.q.h.g(viewHolder);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("View should be fully attached to be ignored");
      stringBuilder.append(this.q.a());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public boolean isAttachedToWindow() {
      return this.v;
    }
    
    public boolean isAutoMeasureEnabled() {
      return this.w;
    }
    
    public boolean isFocused() {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null && recyclerView.isFocused());
    }
    
    public final boolean isItemPrefetchEnabled() {
      return this.d;
    }
    
    public boolean isLayoutHierarchical(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return false;
    }
    
    public boolean isMeasurementCacheEnabled() {
      return this.c;
    }
    
    public boolean isSmoothScrolling() {
      RecyclerView.SmoothScroller smoothScroller = this.t;
      return (smoothScroller != null && smoothScroller.isRunning());
    }
    
    public boolean isViewPartiallyVisible(View param1View, boolean param1Boolean1, boolean param1Boolean2) {
      if (this.r.a(param1View, 24579) && this.s.a(param1View, 24579)) {
        param1Boolean2 = true;
      } else {
        param1Boolean2 = false;
      } 
      return param1Boolean1 ? param1Boolean2 : (param1Boolean2 ^ true);
    }
    
    public void layoutDecorated(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      Rect rect = ((RecyclerView.LayoutParams)param1View.getLayoutParams()).d;
      param1View.layout(param1Int1 + rect.left, param1Int2 + rect.top, param1Int3 - rect.right, param1Int4 - rect.bottom);
    }
    
    public void layoutDecoratedWithMargins(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      Rect rect = layoutParams.d;
      param1View.layout(param1Int1 + rect.left + layoutParams.leftMargin, param1Int2 + rect.top + layoutParams.topMargin, param1Int3 - rect.right - layoutParams.rightMargin, param1Int4 - rect.bottom - layoutParams.bottomMargin);
    }
    
    public void measureChild(View param1View, int param1Int1, int param1Int2) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      Rect rect = this.q.c(param1View);
      int k = rect.left;
      int m = rect.right;
      int i = rect.top;
      int j = rect.bottom;
      param1Int1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + param1Int1 + k + m, layoutParams.width, canScrollHorizontally());
      param1Int2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + param1Int2 + i + j, layoutParams.height, canScrollVertically());
      if (b(param1View, param1Int1, param1Int2, layoutParams))
        param1View.measure(param1Int1, param1Int2); 
    }
    
    public void measureChildWithMargins(View param1View, int param1Int1, int param1Int2) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      Rect rect = this.q.c(param1View);
      int k = rect.left;
      int m = rect.right;
      int i = rect.top;
      int j = rect.bottom;
      param1Int1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + param1Int1 + k + m, layoutParams.width, canScrollHorizontally());
      param1Int2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + param1Int2 + i + j, layoutParams.height, canScrollVertically());
      if (b(param1View, param1Int1, param1Int2, layoutParams))
        param1View.measure(param1Int1, param1Int2); 
    }
    
    public void moveView(int param1Int1, int param1Int2) {
      View view = getChildAt(param1Int1);
      if (view != null) {
        detachViewAt(param1Int1);
        attachView(view, param1Int2);
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Cannot move a child from non-existing index:");
      stringBuilder.append(param1Int1);
      stringBuilder.append(this.q.toString());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public void offsetChildrenHorizontal(int param1Int) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.offsetChildrenHorizontal(param1Int); 
    }
    
    public void offsetChildrenVertical(int param1Int) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.offsetChildrenVertical(param1Int); 
    }
    
    public void onAdapterChanged(RecyclerView.Adapter param1Adapter1, RecyclerView.Adapter param1Adapter2) {}
    
    public boolean onAddFocusables(RecyclerView param1RecyclerView, ArrayList<View> param1ArrayList, int param1Int1, int param1Int2) {
      return false;
    }
    
    public void onAttachedToWindow(RecyclerView param1RecyclerView) {}
    
    @Deprecated
    public void onDetachedFromWindow(RecyclerView param1RecyclerView) {}
    
    public void onDetachedFromWindow(RecyclerView param1RecyclerView, RecyclerView.Recycler param1Recycler) {
      onDetachedFromWindow(param1RecyclerView);
    }
    
    public View onFocusSearchFailed(View param1View, int param1Int, RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent param1AccessibilityEvent) {
      onInitializeAccessibilityEvent(this.q.e, this.q.D, param1AccessibilityEvent);
    }
    
    public void onInitializeAccessibilityEvent(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, AccessibilityEvent param1AccessibilityEvent) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null) {
        if (param1AccessibilityEvent == null)
          return; 
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!recyclerView.canScrollVertically(1)) {
          bool1 = bool2;
          if (!this.q.canScrollVertically(-1)) {
            bool1 = bool2;
            if (!this.q.canScrollHorizontally(-1))
              if (this.q.canScrollHorizontally(1)) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }  
          } 
        } 
        param1AccessibilityEvent.setScrollable(bool1);
        if (this.q.m != null)
          param1AccessibilityEvent.setItemCount(this.q.m.getItemCount()); 
      } 
    }
    
    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
        param1AccessibilityNodeInfoCompat.addAction(8192);
        param1AccessibilityNodeInfoCompat.setScrollable(true);
      } 
      if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
        param1AccessibilityNodeInfoCompat.addAction(4096);
        param1AccessibilityNodeInfoCompat.setScrollable(true);
      } 
      param1AccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(param1Recycler, param1State), getColumnCountForAccessibility(param1Recycler, param1State), isLayoutHierarchical(param1Recycler, param1State), getSelectionModeForAccessibility(param1Recycler, param1State)));
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, View param1View, AccessibilityNodeInfoCompat param1AccessibilityNodeInfoCompat) {
      boolean bool1;
      boolean bool2;
      if (canScrollVertically()) {
        bool1 = getPosition(param1View);
      } else {
        bool1 = false;
      } 
      if (canScrollHorizontally()) {
        bool2 = getPosition(param1View);
      } else {
        bool2 = false;
      } 
      param1AccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(bool1, 1, bool2, 1, false, false));
    }
    
    public View onInterceptFocusSearch(View param1View, int param1Int) {
      return null;
    }
    
    public void onItemsAdded(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void onItemsChanged(RecyclerView param1RecyclerView) {}
    
    public void onItemsMoved(RecyclerView param1RecyclerView, int param1Int1, int param1Int2, int param1Int3) {}
    
    public void onItemsRemoved(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void onItemsUpdated(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
    
    public void onItemsUpdated(RecyclerView param1RecyclerView, int param1Int1, int param1Int2, Object param1Object) {
      onItemsUpdated(param1RecyclerView, param1Int1, param1Int2);
    }
    
    public void onLayoutChildren(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onLayoutCompleted(RecyclerView.State param1State) {}
    
    public void onMeasure(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, int param1Int1, int param1Int2) {
      this.q.c(param1Int1, param1Int2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(RecyclerView param1RecyclerView, View param1View1, View param1View2) {
      return (isSmoothScrolling() || param1RecyclerView.isComputingLayout());
    }
    
    public boolean onRequestChildFocus(RecyclerView param1RecyclerView, RecyclerView.State param1State, View param1View1, View param1View2) {
      return onRequestChildFocus(param1RecyclerView, param1View1, param1View2);
    }
    
    public void onRestoreInstanceState(Parcelable param1Parcelable) {}
    
    public Parcelable onSaveInstanceState() {
      return null;
    }
    
    public void onScrollStateChanged(int param1Int) {}
    
    public boolean performAccessibilityAction(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, int param1Int, Bundle param1Bundle) {
      // Byte code:
      //   0: aload_0
      //   1: getfield q : Landroidx/recyclerview/widget/RecyclerView;
      //   4: astore_1
      //   5: aload_1
      //   6: ifnonnull -> 11
      //   9: iconst_0
      //   10: ireturn
      //   11: iload_3
      //   12: sipush #4096
      //   15: if_icmpeq -> 96
      //   18: iload_3
      //   19: sipush #8192
      //   22: if_icmpeq -> 33
      //   25: iconst_0
      //   26: istore_3
      //   27: iconst_0
      //   28: istore #5
      //   30: goto -> 169
      //   33: aload_1
      //   34: iconst_m1
      //   35: invokevirtual canScrollVertically : (I)Z
      //   38: ifeq -> 60
      //   41: aload_0
      //   42: invokevirtual getHeight : ()I
      //   45: aload_0
      //   46: invokevirtual getPaddingTop : ()I
      //   49: isub
      //   50: aload_0
      //   51: invokevirtual getPaddingBottom : ()I
      //   54: isub
      //   55: ineg
      //   56: istore_3
      //   57: goto -> 62
      //   60: iconst_0
      //   61: istore_3
      //   62: iload_3
      //   63: istore #5
      //   65: aload_0
      //   66: getfield q : Landroidx/recyclerview/widget/RecyclerView;
      //   69: iconst_m1
      //   70: invokevirtual canScrollHorizontally : (I)Z
      //   73: ifeq -> 167
      //   76: aload_0
      //   77: invokevirtual getWidth : ()I
      //   80: aload_0
      //   81: invokevirtual getPaddingLeft : ()I
      //   84: isub
      //   85: aload_0
      //   86: invokevirtual getPaddingRight : ()I
      //   89: isub
      //   90: ineg
      //   91: istore #5
      //   93: goto -> 154
      //   96: aload_1
      //   97: iconst_1
      //   98: invokevirtual canScrollVertically : (I)Z
      //   101: ifeq -> 122
      //   104: aload_0
      //   105: invokevirtual getHeight : ()I
      //   108: aload_0
      //   109: invokevirtual getPaddingTop : ()I
      //   112: isub
      //   113: aload_0
      //   114: invokevirtual getPaddingBottom : ()I
      //   117: isub
      //   118: istore_3
      //   119: goto -> 124
      //   122: iconst_0
      //   123: istore_3
      //   124: iload_3
      //   125: istore #5
      //   127: aload_0
      //   128: getfield q : Landroidx/recyclerview/widget/RecyclerView;
      //   131: iconst_1
      //   132: invokevirtual canScrollHorizontally : (I)Z
      //   135: ifeq -> 167
      //   138: aload_0
      //   139: invokevirtual getWidth : ()I
      //   142: aload_0
      //   143: invokevirtual getPaddingLeft : ()I
      //   146: isub
      //   147: aload_0
      //   148: invokevirtual getPaddingRight : ()I
      //   151: isub
      //   152: istore #5
      //   154: iload_3
      //   155: istore #6
      //   157: iload #5
      //   159: istore_3
      //   160: iload #6
      //   162: istore #5
      //   164: goto -> 169
      //   167: iconst_0
      //   168: istore_3
      //   169: iload #5
      //   171: ifne -> 180
      //   174: iload_3
      //   175: ifne -> 180
      //   178: iconst_0
      //   179: ireturn
      //   180: aload_0
      //   181: getfield q : Landroidx/recyclerview/widget/RecyclerView;
      //   184: iload_3
      //   185: iload #5
      //   187: aconst_null
      //   188: ldc -2147483648
      //   190: iconst_1
      //   191: invokevirtual a : (IILandroid/view/animation/Interpolator;IZ)V
      //   194: iconst_1
      //   195: ireturn
    }
    
    public boolean performAccessibilityActionForItem(RecyclerView.Recycler param1Recycler, RecyclerView.State param1State, View param1View, int param1Int, Bundle param1Bundle) {
      return false;
    }
    
    public void postOnAnimation(Runnable param1Runnable) {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        ViewCompat.postOnAnimation((View)recyclerView, param1Runnable); 
    }
    
    public void removeAllViews() {
      for (int i = getChildCount() - 1; i >= 0; i--)
        this.p.a(i); 
    }
    
    public void removeAndRecycleAllViews(RecyclerView.Recycler param1Recycler) {
      for (int i = getChildCount() - 1; i >= 0; i--) {
        if (!RecyclerView.b(getChildAt(i)).bf_())
          removeAndRecycleViewAt(i, param1Recycler); 
      } 
    }
    
    public void removeAndRecycleView(View param1View, RecyclerView.Recycler param1Recycler) {
      removeView(param1View);
      param1Recycler.recycleView(param1View);
    }
    
    public void removeAndRecycleViewAt(int param1Int, RecyclerView.Recycler param1Recycler) {
      View view = getChildAt(param1Int);
      removeViewAt(param1Int);
      param1Recycler.recycleView(view);
    }
    
    public boolean removeCallbacks(Runnable param1Runnable) {
      RecyclerView recyclerView = this.q;
      return (recyclerView != null) ? recyclerView.removeCallbacks(param1Runnable) : false;
    }
    
    public void removeDetachedView(View param1View) {
      this.q.removeDetachedView(param1View, false);
    }
    
    public void removeView(View param1View) {
      this.p.a(param1View);
    }
    
    public void removeViewAt(int param1Int) {
      if (getChildAt(param1Int) != null)
        this.p.a(param1Int); 
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView param1RecyclerView, View param1View, Rect param1Rect, boolean param1Boolean) {
      return requestChildRectangleOnScreen(param1RecyclerView, param1View, param1Rect, param1Boolean, false);
    }
    
    public boolean requestChildRectangleOnScreen(RecyclerView param1RecyclerView, View param1View, Rect param1Rect, boolean param1Boolean1, boolean param1Boolean2) {
      int[] arrayOfInt = a(param1View, param1Rect);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if ((!param1Boolean2 || a(param1RecyclerView, i, j)) && (i != 0 || j != 0)) {
        if (param1Boolean1) {
          param1RecyclerView.scrollBy(i, j);
          return true;
        } 
        param1RecyclerView.smoothScrollBy(i, j);
        return true;
      } 
      return false;
    }
    
    public void requestLayout() {
      RecyclerView recyclerView = this.q;
      if (recyclerView != null)
        recyclerView.requestLayout(); 
    }
    
    public void requestSimpleAnimationsInNextLayout() {
      this.u = true;
    }
    
    public int scrollHorizontallyBy(int param1Int, RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return 0;
    }
    
    public void scrollToPosition(int param1Int) {}
    
    public int scrollVerticallyBy(int param1Int, RecyclerView.Recycler param1Recycler, RecyclerView.State param1State) {
      return 0;
    }
    
    @Deprecated
    public void setAutoMeasureEnabled(boolean param1Boolean) {
      this.w = param1Boolean;
    }
    
    public final void setItemPrefetchEnabled(boolean param1Boolean) {
      if (param1Boolean != this.d) {
        this.d = param1Boolean;
        this.x = 0;
        RecyclerView recyclerView = this.q;
        if (recyclerView != null)
          recyclerView.e.a(); 
      } 
    }
    
    public void setMeasuredDimension(int param1Int1, int param1Int2) {
      RecyclerView.a(this.q, param1Int1, param1Int2);
    }
    
    public void setMeasuredDimension(Rect param1Rect, int param1Int1, int param1Int2) {
      int i = param1Rect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = param1Rect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(chooseSize(param1Int1, i + j + k, getMinimumWidth()), chooseSize(param1Int2, m + n + i1, getMinimumHeight()));
    }
    
    public void setMeasurementCacheEnabled(boolean param1Boolean) {
      this.c = param1Boolean;
    }
    
    public void smoothScrollToPosition(RecyclerView param1RecyclerView, RecyclerView.State param1State, int param1Int) {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public void startSmoothScroll(RecyclerView.SmoothScroller param1SmoothScroller) {
      RecyclerView.SmoothScroller smoothScroller = this.t;
      if (smoothScroller != null && param1SmoothScroller != smoothScroller && smoothScroller.isRunning())
        this.t.e(); 
      this.t = param1SmoothScroller;
      this.t.a(this.q, this);
    }
    
    public void stopIgnoringView(View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      viewHolder.i();
      viewHolder.s();
      viewHolder.b(4);
    }
    
    public boolean supportsPredictiveItemAnimations() {
      return false;
    }
    
    public static interface LayoutPrefetchRegistry {
      void addPosition(int param2Int1, int param2Int2);
    }
    
    public static class Properties {
      public int orientation;
      
      public boolean reverseLayout;
      
      public int spanCount;
      
      public boolean stackFromEnd;
    }
  }
  
  class null implements ViewBoundsCheck.Callback {
    null(RecyclerView this$0) {}
    
    public View getChildAt(int param1Int) {
      return this.a.getChildAt(param1Int);
    }
    
    public int getChildEnd(View param1View) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      return this.a.getDecoratedRight(param1View) + layoutParams.rightMargin;
    }
    
    public int getChildStart(View param1View) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      return this.a.getDecoratedLeft(param1View) - layoutParams.leftMargin;
    }
    
    public int getParentEnd() {
      return this.a.getWidth() - this.a.getPaddingRight();
    }
    
    public int getParentStart() {
      return this.a.getPaddingLeft();
    }
  }
  
  class null implements ViewBoundsCheck.Callback {
    null(RecyclerView this$0) {}
    
    public View getChildAt(int param1Int) {
      return this.a.getChildAt(param1Int);
    }
    
    public int getChildEnd(View param1View) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      return this.a.getDecoratedBottom(param1View) + layoutParams.bottomMargin;
    }
    
    public int getChildStart(View param1View) {
      RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)param1View.getLayoutParams();
      return this.a.getDecoratedTop(param1View) - layoutParams.topMargin;
    }
    
    public int getParentEnd() {
      return this.a.getHeight() - this.a.getPaddingBottom();
    }
    
    public int getParentStart() {
      return this.a.getPaddingTop();
    }
  }
  
  public static interface LayoutPrefetchRegistry {
    void addPosition(int param1Int1, int param1Int2);
  }
  
  public static class Properties {
    public int orientation;
    
    public boolean reverseLayout;
    
    public int spanCount;
    
    public boolean stackFromEnd;
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    RecyclerView.ViewHolder c;
    
    final Rect d = new Rect();
    
    boolean e = true;
    
    boolean f = false;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
    
    public LayoutParams(LayoutParams param1LayoutParams) {
      super((ViewGroup.LayoutParams)param1LayoutParams);
    }
    
    public int getViewAdapterPosition() {
      return this.c.getAdapterPosition();
    }
    
    public int getViewLayoutPosition() {
      return this.c.getLayoutPosition();
    }
    
    @Deprecated
    public int getViewPosition() {
      return this.c.getPosition();
    }
    
    public boolean isItemChanged() {
      return this.c.v();
    }
    
    public boolean isItemRemoved() {
      return this.c.m();
    }
    
    public boolean isViewInvalid() {
      return this.c.j();
    }
    
    public boolean viewNeedsUpdate() {
      return this.c.k();
    }
  }
  
  public static interface OnChildAttachStateChangeListener {
    void onChildViewAttachedToWindow(View param1View);
    
    void onChildViewDetachedFromWindow(View param1View);
  }
  
  public static abstract class OnFlingListener {
    public abstract boolean onFling(int param1Int1, int param1Int2);
  }
  
  public static interface OnItemTouchListener {
    boolean onInterceptTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent);
    
    void onRequestDisallowInterceptTouchEvent(boolean param1Boolean);
    
    void onTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent);
  }
  
  public static abstract class OnScrollListener {
    public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {}
    
    public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Orientation {}
  
  public static class RecycledViewPool {
    SparseArray<ScrapData> a = new SparseArray();
    
    private int b = 0;
    
    private ScrapData a(int param1Int) {
      ScrapData scrapData2 = (ScrapData)this.a.get(param1Int);
      ScrapData scrapData1 = scrapData2;
      if (scrapData2 == null) {
        scrapData1 = new ScrapData();
        this.a.put(param1Int, scrapData1);
      } 
      return scrapData1;
    }
    
    long a(long param1Long1, long param1Long2) {
      return (param1Long1 == 0L) ? param1Long2 : (param1Long1 / 4L * 3L + param1Long2 / 4L);
    }
    
    void a() {
      this.b++;
    }
    
    void a(int param1Int, long param1Long) {
      ScrapData scrapData = a(param1Int);
      scrapData.c = a(scrapData.c, param1Long);
    }
    
    void a(RecyclerView.Adapter param1Adapter1, RecyclerView.Adapter param1Adapter2, boolean param1Boolean) {
      if (param1Adapter1 != null)
        b(); 
      if (!param1Boolean && this.b == 0)
        clear(); 
      if (param1Adapter2 != null)
        a(); 
    }
    
    boolean a(int param1Int, long param1Long1, long param1Long2) {
      long l = (a(param1Int)).c;
      return (l == 0L || param1Long1 + l < param1Long2);
    }
    
    void b() {
      this.b--;
    }
    
    void b(int param1Int, long param1Long) {
      ScrapData scrapData = a(param1Int);
      scrapData.d = a(scrapData.d, param1Long);
    }
    
    boolean b(int param1Int, long param1Long1, long param1Long2) {
      long l = (a(param1Int)).d;
      return (l == 0L || param1Long1 + l < param1Long2);
    }
    
    public void clear() {
      for (int i = 0; i < this.a.size(); i++)
        ((ScrapData)this.a.valueAt(i)).a.clear(); 
    }
    
    public RecyclerView.ViewHolder getRecycledView(int param1Int) {
      ScrapData scrapData = (ScrapData)this.a.get(param1Int);
      if (scrapData != null && !scrapData.a.isEmpty()) {
        ArrayList<RecyclerView.ViewHolder> arrayList = scrapData.a;
        for (param1Int = arrayList.size() - 1; param1Int >= 0; param1Int--) {
          if (!((RecyclerView.ViewHolder)arrayList.get(param1Int)).o())
            return arrayList.remove(param1Int); 
        } 
      } 
      return null;
    }
    
    public int getRecycledViewCount(int param1Int) {
      return (a(param1Int)).a.size();
    }
    
    public void putRecycledView(RecyclerView.ViewHolder param1ViewHolder) {
      int i = param1ViewHolder.getItemViewType();
      ArrayList<RecyclerView.ViewHolder> arrayList = (a(i)).a;
      if (((ScrapData)this.a.get(i)).b <= arrayList.size())
        return; 
      param1ViewHolder.s();
      arrayList.add(param1ViewHolder);
    }
    
    public void setMaxRecycledViews(int param1Int1, int param1Int2) {
      ScrapData scrapData = a(param1Int1);
      scrapData.b = param1Int2;
      ArrayList<RecyclerView.ViewHolder> arrayList = scrapData.a;
      while (arrayList.size() > param1Int2)
        arrayList.remove(arrayList.size() - 1); 
    }
    
    static class ScrapData {
      final ArrayList<RecyclerView.ViewHolder> a = new ArrayList<RecyclerView.ViewHolder>();
      
      int b = 5;
      
      long c = 0L;
      
      long d = 0L;
    }
  }
  
  static class ScrapData {
    final ArrayList<RecyclerView.ViewHolder> a = new ArrayList<RecyclerView.ViewHolder>();
    
    int b = 5;
    
    long c = 0L;
    
    long d = 0L;
  }
  
  public final class Recycler {
    final ArrayList<RecyclerView.ViewHolder> a = new ArrayList<RecyclerView.ViewHolder>();
    
    ArrayList<RecyclerView.ViewHolder> b = null;
    
    final ArrayList<RecyclerView.ViewHolder> c = new ArrayList<RecyclerView.ViewHolder>();
    
    int d = 2;
    
    RecyclerView.RecycledViewPool e;
    
    private final List<RecyclerView.ViewHolder> g = Collections.unmodifiableList(this.a);
    
    private int h = 2;
    
    private RecyclerView.ViewCacheExtension i;
    
    public Recycler(RecyclerView this$0) {}
    
    private void a(ViewGroup param1ViewGroup, boolean param1Boolean) {
      int i;
      for (i = param1ViewGroup.getChildCount() - 1; i >= 0; i--) {
        View view = param1ViewGroup.getChildAt(i);
        if (view instanceof ViewGroup)
          a((ViewGroup)view, true); 
      } 
      if (!param1Boolean)
        return; 
      if (param1ViewGroup.getVisibility() == 4) {
        param1ViewGroup.setVisibility(0);
        param1ViewGroup.setVisibility(4);
        return;
      } 
      i = param1ViewGroup.getVisibility();
      param1ViewGroup.setVisibility(4);
      param1ViewGroup.setVisibility(i);
    }
    
    private boolean a(RecyclerView.ViewHolder param1ViewHolder, int param1Int1, int param1Int2, long param1Long) {
      param1ViewHolder.o = this.f;
      int i = param1ViewHolder.getItemViewType();
      long l = this.f.getNanoTime();
      if (param1Long != Long.MAX_VALUE && !this.e.b(i, l, param1Long))
        return false; 
      this.f.m.bindViewHolder(param1ViewHolder, param1Int1);
      param1Long = this.f.getNanoTime();
      this.e.b(param1ViewHolder.getItemViewType(), param1Long - l);
      e(param1ViewHolder);
      if (this.f.D.isPreLayout())
        param1ViewHolder.f = param1Int2; 
      return true;
    }
    
    private void e(RecyclerView.ViewHolder param1ViewHolder) {
      if (this.f.m()) {
        View view = param1ViewHolder.itemView;
        if (ViewCompat.getImportantForAccessibility(view) == 0)
          ViewCompat.setImportantForAccessibility(view, 1); 
        if (this.f.H == null)
          return; 
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.f.H.getItemDelegate();
        if (accessibilityDelegateCompat instanceof RecyclerViewAccessibilityDelegate.ItemDelegate)
          ((RecyclerViewAccessibilityDelegate.ItemDelegate)accessibilityDelegateCompat).b(view); 
        ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
      } 
    }
    
    private void f(RecyclerView.ViewHolder param1ViewHolder) {
      if (param1ViewHolder.itemView instanceof ViewGroup)
        a((ViewGroup)param1ViewHolder.itemView, false); 
    }
    
    View a(int param1Int, boolean param1Boolean) {
      return (a(param1Int, param1Boolean, Long.MAX_VALUE)).itemView;
    }
    
    RecyclerView.ViewHolder a(int param1Int, boolean param1Boolean, long param1Long) {
      // Byte code:
      //   0: iload_1
      //   1: iflt -> 1049
      //   4: iload_1
      //   5: aload_0
      //   6: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   9: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   12: invokevirtual getItemCount : ()I
      //   15: if_icmpge -> 1049
      //   18: aload_0
      //   19: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   22: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   25: invokevirtual isPreLayout : ()Z
      //   28: istore #10
      //   30: iconst_1
      //   31: istore #9
      //   33: iload #10
      //   35: ifeq -> 60
      //   38: aload_0
      //   39: iload_1
      //   40: invokevirtual c : (I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   43: astore #16
      //   45: aload #16
      //   47: astore #15
      //   49: aload #16
      //   51: ifnull -> 63
      //   54: iconst_1
      //   55: istore #6
      //   57: goto -> 70
      //   60: aconst_null
      //   61: astore #15
      //   63: iconst_0
      //   64: istore #6
      //   66: aload #15
      //   68: astore #16
      //   70: aload #16
      //   72: astore #15
      //   74: iload #6
      //   76: istore #5
      //   78: aload #16
      //   80: ifnonnull -> 188
      //   83: aload_0
      //   84: iload_1
      //   85: iload_2
      //   86: invokevirtual b : (IZ)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   89: astore #16
      //   91: aload #16
      //   93: astore #15
      //   95: iload #6
      //   97: istore #5
      //   99: aload #16
      //   101: ifnull -> 188
      //   104: aload_0
      //   105: aload #16
      //   107: invokevirtual a : (Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z
      //   110: ifne -> 181
      //   113: iload_2
      //   114: ifne -> 171
      //   117: aload #16
      //   119: iconst_4
      //   120: invokevirtual b : (I)V
      //   123: aload #16
      //   125: invokevirtual d : ()Z
      //   128: ifeq -> 152
      //   131: aload_0
      //   132: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   135: aload #16
      //   137: getfield itemView : Landroid/view/View;
      //   140: iconst_0
      //   141: invokevirtual removeDetachedView : (Landroid/view/View;Z)V
      //   144: aload #16
      //   146: invokevirtual e : ()V
      //   149: goto -> 165
      //   152: aload #16
      //   154: invokevirtual f : ()Z
      //   157: ifeq -> 165
      //   160: aload #16
      //   162: invokevirtual g : ()V
      //   165: aload_0
      //   166: aload #16
      //   168: invokevirtual b : (Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V
      //   171: aconst_null
      //   172: astore #15
      //   174: iload #6
      //   176: istore #5
      //   178: goto -> 188
      //   181: iconst_1
      //   182: istore #5
      //   184: aload #16
      //   186: astore #15
      //   188: aload #15
      //   190: astore #16
      //   192: iload #5
      //   194: istore #7
      //   196: aload #15
      //   198: ifnonnull -> 743
      //   201: aload_0
      //   202: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   205: getfield f : Landroidx/recyclerview/widget/AdapterHelper;
      //   208: iload_1
      //   209: invokevirtual b : (I)I
      //   212: istore #7
      //   214: iload #7
      //   216: iflt -> 650
      //   219: iload #7
      //   221: aload_0
      //   222: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   225: getfield m : Landroidx/recyclerview/widget/RecyclerView$Adapter;
      //   228: invokevirtual getItemCount : ()I
      //   231: if_icmpge -> 650
      //   234: aload_0
      //   235: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   238: getfield m : Landroidx/recyclerview/widget/RecyclerView$Adapter;
      //   241: iload #7
      //   243: invokevirtual getItemViewType : (I)I
      //   246: istore #8
      //   248: iload #5
      //   250: istore #6
      //   252: aload_0
      //   253: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   256: getfield m : Landroidx/recyclerview/widget/RecyclerView$Adapter;
      //   259: invokevirtual hasStableIds : ()Z
      //   262: ifeq -> 313
      //   265: aload_0
      //   266: aload_0
      //   267: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   270: getfield m : Landroidx/recyclerview/widget/RecyclerView$Adapter;
      //   273: iload #7
      //   275: invokevirtual getItemId : (I)J
      //   278: iload #8
      //   280: iload_2
      //   281: invokevirtual a : (JIZ)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   284: astore #16
      //   286: aload #16
      //   288: astore #15
      //   290: iload #5
      //   292: istore #6
      //   294: aload #16
      //   296: ifnull -> 313
      //   299: aload #16
      //   301: iload #7
      //   303: putfield b : I
      //   306: iconst_1
      //   307: istore #6
      //   309: aload #16
      //   311: astore #15
      //   313: aload #15
      //   315: astore #16
      //   317: aload #15
      //   319: ifnonnull -> 470
      //   322: aload_0
      //   323: getfield i : Landroidx/recyclerview/widget/RecyclerView$ViewCacheExtension;
      //   326: astore #17
      //   328: aload #15
      //   330: astore #16
      //   332: aload #17
      //   334: ifnull -> 470
      //   337: aload #17
      //   339: aload_0
      //   340: iload_1
      //   341: iload #8
      //   343: invokevirtual getViewForPositionAndType : (Landroidx/recyclerview/widget/RecyclerView$Recycler;II)Landroid/view/View;
      //   346: astore #17
      //   348: aload #15
      //   350: astore #16
      //   352: aload #17
      //   354: ifnull -> 470
      //   357: aload_0
      //   358: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   361: aload #17
      //   363: invokevirtual getChildViewHolder : (Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   366: astore #16
      //   368: aload #16
      //   370: ifnull -> 427
      //   373: aload #16
      //   375: invokevirtual bf_ : ()Z
      //   378: ifne -> 384
      //   381: goto -> 470
      //   384: new java/lang/StringBuilder
      //   387: dup
      //   388: invokespecial <init> : ()V
      //   391: astore #15
      //   393: aload #15
      //   395: ldc 'getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.'
      //   397: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   400: pop
      //   401: aload #15
      //   403: aload_0
      //   404: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   407: invokevirtual a : ()Ljava/lang/String;
      //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   413: pop
      //   414: new java/lang/IllegalArgumentException
      //   417: dup
      //   418: aload #15
      //   420: invokevirtual toString : ()Ljava/lang/String;
      //   423: invokespecial <init> : (Ljava/lang/String;)V
      //   426: athrow
      //   427: new java/lang/StringBuilder
      //   430: dup
      //   431: invokespecial <init> : ()V
      //   434: astore #15
      //   436: aload #15
      //   438: ldc 'getViewForPositionAndType returned a view which does not have a ViewHolder'
      //   440: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   443: pop
      //   444: aload #15
      //   446: aload_0
      //   447: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   450: invokevirtual a : ()Ljava/lang/String;
      //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   456: pop
      //   457: new java/lang/IllegalArgumentException
      //   460: dup
      //   461: aload #15
      //   463: invokevirtual toString : ()Ljava/lang/String;
      //   466: invokespecial <init> : (Ljava/lang/String;)V
      //   469: athrow
      //   470: aload #16
      //   472: astore #15
      //   474: aload #16
      //   476: ifnonnull -> 524
      //   479: aload_0
      //   480: invokevirtual e : ()Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
      //   483: iload #8
      //   485: invokevirtual getRecycledView : (I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   488: astore #16
      //   490: aload #16
      //   492: astore #15
      //   494: aload #16
      //   496: ifnull -> 524
      //   499: aload #16
      //   501: invokevirtual s : ()V
      //   504: aload #16
      //   506: astore #15
      //   508: getstatic androidx/recyclerview/widget/RecyclerView.a : Z
      //   511: ifeq -> 524
      //   514: aload_0
      //   515: aload #16
      //   517: invokespecial f : (Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V
      //   520: aload #16
      //   522: astore #15
      //   524: aload #15
      //   526: astore #16
      //   528: iload #6
      //   530: istore #7
      //   532: aload #15
      //   534: ifnonnull -> 743
      //   537: aload_0
      //   538: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   541: invokevirtual getNanoTime : ()J
      //   544: lstore #11
      //   546: lload_3
      //   547: ldc2_w 9223372036854775807
      //   550: lcmp
      //   551: ifeq -> 571
      //   554: aload_0
      //   555: getfield e : Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
      //   558: iload #8
      //   560: lload #11
      //   562: lload_3
      //   563: invokevirtual a : (IJJ)Z
      //   566: ifne -> 571
      //   569: aconst_null
      //   570: areturn
      //   571: aload_0
      //   572: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   575: getfield m : Landroidx/recyclerview/widget/RecyclerView$Adapter;
      //   578: aload_0
      //   579: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   582: iload #8
      //   584: invokevirtual createViewHolder : (Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   587: astore #16
      //   589: getstatic androidx/recyclerview/widget/RecyclerView.d : Z
      //   592: ifeq -> 624
      //   595: aload #16
      //   597: getfield itemView : Landroid/view/View;
      //   600: invokestatic d : (Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView;
      //   603: astore #15
      //   605: aload #15
      //   607: ifnull -> 624
      //   610: aload #16
      //   612: new java/lang/ref/WeakReference
      //   615: dup
      //   616: aload #15
      //   618: invokespecial <init> : (Ljava/lang/Object;)V
      //   621: putfield a : Ljava/lang/ref/WeakReference;
      //   624: aload_0
      //   625: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   628: invokevirtual getNanoTime : ()J
      //   631: lstore #13
      //   633: aload_0
      //   634: getfield e : Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;
      //   637: iload #8
      //   639: lload #13
      //   641: lload #11
      //   643: lsub
      //   644: invokevirtual a : (IJ)V
      //   647: goto -> 747
      //   650: new java/lang/StringBuilder
      //   653: dup
      //   654: invokespecial <init> : ()V
      //   657: astore #15
      //   659: aload #15
      //   661: ldc_w 'Inconsistency detected. Invalid item position '
      //   664: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   667: pop
      //   668: aload #15
      //   670: iload_1
      //   671: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   674: pop
      //   675: aload #15
      //   677: ldc_w '(offset:'
      //   680: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   683: pop
      //   684: aload #15
      //   686: iload #7
      //   688: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   691: pop
      //   692: aload #15
      //   694: ldc_w ').state:'
      //   697: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   700: pop
      //   701: aload #15
      //   703: aload_0
      //   704: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   707: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   710: invokevirtual getItemCount : ()I
      //   713: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   716: pop
      //   717: aload #15
      //   719: aload_0
      //   720: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   723: invokevirtual a : ()Ljava/lang/String;
      //   726: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   729: pop
      //   730: new java/lang/IndexOutOfBoundsException
      //   733: dup
      //   734: aload #15
      //   736: invokevirtual toString : ()Ljava/lang/String;
      //   739: invokespecial <init> : (Ljava/lang/String;)V
      //   742: athrow
      //   743: iload #7
      //   745: istore #6
      //   747: iload #6
      //   749: ifeq -> 848
      //   752: aload_0
      //   753: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   756: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   759: invokevirtual isPreLayout : ()Z
      //   762: ifne -> 848
      //   765: aload #16
      //   767: sipush #8192
      //   770: invokevirtual a : (I)Z
      //   773: ifeq -> 848
      //   776: aload #16
      //   778: iconst_0
      //   779: sipush #8192
      //   782: invokevirtual a : (II)V
      //   785: aload_0
      //   786: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   789: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   792: getfield j : Z
      //   795: ifeq -> 848
      //   798: aload #16
      //   800: invokestatic b : (Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)I
      //   803: istore #5
      //   805: aload_0
      //   806: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   809: getfield z : Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;
      //   812: aload_0
      //   813: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   816: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   819: aload #16
      //   821: iload #5
      //   823: sipush #4096
      //   826: ior
      //   827: aload #16
      //   829: invokevirtual r : ()Ljava/util/List;
      //   832: invokevirtual recordPreLayoutInformation : (Landroidx/recyclerview/widget/RecyclerView$State;Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;
      //   835: astore #15
      //   837: aload_0
      //   838: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   841: aload #16
      //   843: aload #15
      //   845: invokevirtual a : (Landroidx/recyclerview/widget/RecyclerView$ViewHolder;Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;)V
      //   848: aload_0
      //   849: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   852: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   855: invokevirtual isPreLayout : ()Z
      //   858: ifeq -> 878
      //   861: aload #16
      //   863: invokevirtual l : ()Z
      //   866: ifeq -> 878
      //   869: aload #16
      //   871: iload_1
      //   872: putfield f : I
      //   875: goto -> 905
      //   878: aload #16
      //   880: invokevirtual l : ()Z
      //   883: ifeq -> 910
      //   886: aload #16
      //   888: invokevirtual k : ()Z
      //   891: ifne -> 910
      //   894: aload #16
      //   896: invokevirtual j : ()Z
      //   899: ifeq -> 905
      //   902: goto -> 910
      //   905: iconst_0
      //   906: istore_2
      //   907: goto -> 930
      //   910: aload_0
      //   911: aload #16
      //   913: aload_0
      //   914: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   917: getfield f : Landroidx/recyclerview/widget/AdapterHelper;
      //   920: iload_1
      //   921: invokevirtual b : (I)I
      //   924: iload_1
      //   925: lload_3
      //   926: invokespecial a : (Landroidx/recyclerview/widget/RecyclerView$ViewHolder;IIJ)Z
      //   929: istore_2
      //   930: aload #16
      //   932: getfield itemView : Landroid/view/View;
      //   935: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   938: astore #15
      //   940: aload #15
      //   942: ifnonnull -> 970
      //   945: aload_0
      //   946: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   949: invokevirtual generateDefaultLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   952: checkcast androidx/recyclerview/widget/RecyclerView$LayoutParams
      //   955: astore #15
      //   957: aload #16
      //   959: getfield itemView : Landroid/view/View;
      //   962: aload #15
      //   964: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
      //   967: goto -> 1016
      //   970: aload_0
      //   971: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   974: aload #15
      //   976: invokevirtual checkLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)Z
      //   979: ifne -> 1009
      //   982: aload_0
      //   983: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   986: aload #15
      //   988: invokevirtual generateLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
      //   991: checkcast androidx/recyclerview/widget/RecyclerView$LayoutParams
      //   994: astore #15
      //   996: aload #16
      //   998: getfield itemView : Landroid/view/View;
      //   1001: aload #15
      //   1003: invokevirtual setLayoutParams : (Landroid/view/ViewGroup$LayoutParams;)V
      //   1006: goto -> 1016
      //   1009: aload #15
      //   1011: checkcast androidx/recyclerview/widget/RecyclerView$LayoutParams
      //   1014: astore #15
      //   1016: aload #15
      //   1018: aload #16
      //   1020: putfield c : Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
      //   1023: iload #6
      //   1025: ifeq -> 1038
      //   1028: iload_2
      //   1029: ifeq -> 1038
      //   1032: iload #9
      //   1034: istore_2
      //   1035: goto -> 1040
      //   1038: iconst_0
      //   1039: istore_2
      //   1040: aload #15
      //   1042: iload_2
      //   1043: putfield f : Z
      //   1046: aload #16
      //   1048: areturn
      //   1049: new java/lang/StringBuilder
      //   1052: dup
      //   1053: invokespecial <init> : ()V
      //   1056: astore #15
      //   1058: aload #15
      //   1060: ldc_w 'Invalid item position '
      //   1063: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1066: pop
      //   1067: aload #15
      //   1069: iload_1
      //   1070: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1073: pop
      //   1074: aload #15
      //   1076: ldc_w '('
      //   1079: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1082: pop
      //   1083: aload #15
      //   1085: iload_1
      //   1086: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1089: pop
      //   1090: aload #15
      //   1092: ldc_w '). Item count:'
      //   1095: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1098: pop
      //   1099: aload #15
      //   1101: aload_0
      //   1102: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   1105: getfield D : Landroidx/recyclerview/widget/RecyclerView$State;
      //   1108: invokevirtual getItemCount : ()I
      //   1111: invokevirtual append : (I)Ljava/lang/StringBuilder;
      //   1114: pop
      //   1115: aload #15
      //   1117: aload_0
      //   1118: getfield f : Landroidx/recyclerview/widget/RecyclerView;
      //   1121: invokevirtual a : ()Ljava/lang/String;
      //   1124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1127: pop
      //   1128: new java/lang/IndexOutOfBoundsException
      //   1131: dup
      //   1132: aload #15
      //   1134: invokevirtual toString : ()Ljava/lang/String;
      //   1137: invokespecial <init> : (Ljava/lang/String;)V
      //   1140: athrow
    }
    
    RecyclerView.ViewHolder a(long param1Long, int param1Int, boolean param1Boolean) {
      int i;
      for (i = this.a.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.a.get(i);
        if (viewHolder.getItemId() == param1Long && !viewHolder.f()) {
          if (param1Int == viewHolder.getItemViewType()) {
            viewHolder.b(32);
            if (viewHolder.m() && !this.f.D.isPreLayout())
              viewHolder.a(2, 14); 
            return viewHolder;
          } 
          if (!param1Boolean) {
            this.a.remove(i);
            this.f.removeDetachedView(viewHolder.itemView, false);
            a(viewHolder.itemView);
          } 
        } 
      } 
      for (i = this.c.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.c.get(i);
        if (viewHolder.getItemId() == param1Long && !viewHolder.o()) {
          if (param1Int == viewHolder.getItemViewType()) {
            if (!param1Boolean)
              this.c.remove(i); 
            return viewHolder;
          } 
          if (!param1Boolean) {
            a(i);
            return null;
          } 
        } 
      } 
      return null;
    }
    
    void a() {
      if (this.f.n != null) {
        i = this.f.n.x;
      } else {
        i = 0;
      } 
      this.d = this.h + i;
      for (int i = this.c.size() - 1; i >= 0 && this.c.size() > this.d; i--)
        a(i); 
    }
    
    void a(int param1Int) {
      a(this.c.get(param1Int), true);
      this.c.remove(param1Int);
    }
    
    void a(int param1Int1, int param1Int2) {
      int i;
      int j;
      boolean bool;
      if (param1Int1 < param1Int2) {
        i = param1Int1;
        j = param1Int2;
        bool = true;
      } else {
        j = param1Int1;
        i = param1Int2;
        bool = true;
      } 
      int m = this.c.size();
      int k;
      for (k = 0; k < m; k++) {
        RecyclerView.ViewHolder viewHolder = this.c.get(k);
        if (viewHolder != null && viewHolder.b >= i && viewHolder.b <= j)
          if (viewHolder.b == param1Int1) {
            viewHolder.a(param1Int2 - param1Int1, false);
          } else {
            viewHolder.a(bool, false);
          }  
      } 
    }
    
    void a(int param1Int1, int param1Int2, boolean param1Boolean) {
      int i;
      for (i = this.c.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.c.get(i);
        if (viewHolder != null)
          if (viewHolder.b >= param1Int1 + param1Int2) {
            viewHolder.a(-param1Int2, param1Boolean);
          } else if (viewHolder.b >= param1Int1) {
            viewHolder.b(8);
            a(i);
          }  
      } 
    }
    
    void a(View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      viewHolder.l = null;
      viewHolder.m = false;
      viewHolder.g();
      b(viewHolder);
    }
    
    void a(RecyclerView.Adapter param1Adapter1, RecyclerView.Adapter param1Adapter2, boolean param1Boolean) {
      clear();
      e().a(param1Adapter1, param1Adapter2, param1Boolean);
    }
    
    void a(RecyclerView.RecycledViewPool param1RecycledViewPool) {
      RecyclerView.RecycledViewPool recycledViewPool = this.e;
      if (recycledViewPool != null)
        recycledViewPool.b(); 
      this.e = param1RecycledViewPool;
      if (this.e != null && this.f.getAdapter() != null)
        this.e.a(); 
    }
    
    void a(RecyclerView.ViewCacheExtension param1ViewCacheExtension) {
      this.i = param1ViewCacheExtension;
    }
    
    void a(RecyclerView.ViewHolder param1ViewHolder, boolean param1Boolean) {
      RecyclerView.c(param1ViewHolder);
      View view = param1ViewHolder.itemView;
      if (this.f.H != null) {
        AccessibilityDelegateCompat accessibilityDelegateCompat = this.f.H.getItemDelegate();
        if (accessibilityDelegateCompat instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
          accessibilityDelegateCompat = ((RecyclerViewAccessibilityDelegate.ItemDelegate)accessibilityDelegateCompat).c(view);
        } else {
          accessibilityDelegateCompat = null;
        } 
        ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
      } 
      if (param1Boolean)
        d(param1ViewHolder); 
      param1ViewHolder.o = null;
      e().putRecycledView(param1ViewHolder);
    }
    
    boolean a(RecyclerView.ViewHolder param1ViewHolder) {
      if (param1ViewHolder.m())
        return this.f.D.isPreLayout(); 
      if (param1ViewHolder.b >= 0 && param1ViewHolder.b < this.f.m.getItemCount()) {
        boolean bool1 = this.f.D.isPreLayout();
        boolean bool = false;
        if (!bool1 && this.f.m.getItemViewType(param1ViewHolder.b) != param1ViewHolder.getItemViewType())
          return false; 
        if (this.f.m.hasStableIds()) {
          if (param1ViewHolder.getItemId() == this.f.m.getItemId(param1ViewHolder.b))
            bool = true; 
          return bool;
        } 
        return true;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
      stringBuilder.append(param1ViewHolder);
      stringBuilder.append(this.f.a());
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    View b(int param1Int) {
      return ((RecyclerView.ViewHolder)this.a.get(param1Int)).itemView;
    }
    
    RecyclerView.ViewHolder b(int param1Int, boolean param1Boolean) {
      int j = this.a.size();
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++) {
        RecyclerView.ViewHolder viewHolder = this.a.get(i);
        if (!viewHolder.f() && viewHolder.getLayoutPosition() == param1Int && !viewHolder.j() && (this.f.D.g || !viewHolder.m())) {
          viewHolder.b(32);
          return viewHolder;
        } 
      } 
      if (!param1Boolean) {
        View view = this.f.g.c(param1Int);
        if (view != null) {
          RecyclerView.ViewHolder viewHolder = RecyclerView.b(view);
          this.f.g.e(view);
          param1Int = this.f.g.b(view);
          if (param1Int != -1) {
            this.f.g.e(param1Int);
            b(view);
            viewHolder.b(8224);
            return viewHolder;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("layout index should not be -1 after unhiding a view:");
          stringBuilder.append(viewHolder);
          stringBuilder.append(this.f.a());
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } 
      j = this.c.size();
      for (i = bool; i < j; i++) {
        RecyclerView.ViewHolder viewHolder = this.c.get(i);
        if (!viewHolder.j() && viewHolder.getLayoutPosition() == param1Int && !viewHolder.o()) {
          if (!param1Boolean)
            this.c.remove(i); 
          return viewHolder;
        } 
      } 
      return null;
    }
    
    void b() {
      for (int i = this.c.size() - 1; i >= 0; i--)
        a(i); 
      this.c.clear();
      if (RecyclerView.d)
        this.f.C.a(); 
    }
    
    void b(int param1Int1, int param1Int2) {
      int j = this.c.size();
      for (int i = 0; i < j; i++) {
        RecyclerView.ViewHolder viewHolder = this.c.get(i);
        if (viewHolder != null && viewHolder.b >= param1Int1)
          viewHolder.a(param1Int2, true); 
      } 
    }
    
    void b(View param1View) {
      StringBuilder stringBuilder;
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      if (viewHolder.a(12) || !viewHolder.v() || this.f.b(viewHolder)) {
        if (!viewHolder.j() || viewHolder.m() || this.f.m.hasStableIds()) {
          viewHolder.a(this, false);
          this.a.add(viewHolder);
          return;
        } 
        stringBuilder = new StringBuilder();
        stringBuilder.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        stringBuilder.append(this.f.a());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      if (this.b == null)
        this.b = new ArrayList<RecyclerView.ViewHolder>(); 
      stringBuilder.a(this, true);
      this.b.add(stringBuilder);
    }
    
    void b(RecyclerView.ViewHolder param1ViewHolder) {
      StringBuilder stringBuilder1;
      boolean bool2 = param1ViewHolder.d();
      boolean bool1 = false;
      int i = 0;
      if (bool2 || param1ViewHolder.itemView.getParent() != null) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scrapped or attached views may not be recycled. isScrap:");
        stringBuilder.append(param1ViewHolder.d());
        stringBuilder.append(" isAttached:");
        if (param1ViewHolder.itemView.getParent() != null)
          bool1 = true; 
        stringBuilder.append(bool1);
        stringBuilder.append(this.f.a());
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      if (!param1ViewHolder.n()) {
        if (!param1ViewHolder.bf_()) {
          int j;
          int k;
          bool1 = param1ViewHolder.u();
          if (this.f.m != null && bool1 && this.f.m.onFailedToRecycleView(param1ViewHolder)) {
            j = 1;
          } else {
            j = 0;
          } 
          if (j || param1ViewHolder.isRecyclable()) {
            if (this.d > 0 && !param1ViewHolder.a(526)) {
              int m = this.c.size();
              j = m;
              if (m >= this.d) {
                j = m;
                if (m > 0) {
                  a(0);
                  j = m - 1;
                } 
              } 
              m = j;
              if (RecyclerView.d) {
                m = j;
                if (j > 0) {
                  m = j;
                  if (!this.f.C.a(param1ViewHolder.b)) {
                    while (--j >= 0) {
                      m = ((RecyclerView.ViewHolder)this.c.get(j)).b;
                      if (!this.f.C.a(m))
                        break; 
                      j--;
                    } 
                    m = j + 1;
                  } 
                } 
              } 
              this.c.add(m, param1ViewHolder);
              j = 1;
            } else {
              j = 0;
            } 
            k = i;
            i = j;
            if (j == 0) {
              a(param1ViewHolder, true);
              k = 1;
              i = j;
            } 
          } else {
            j = 0;
            k = i;
            i = j;
          } 
          this.f.h.g(param1ViewHolder);
          if (i == 0 && k == 0 && bool1)
            param1ViewHolder.o = null; 
          return;
        } 
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
        stringBuilder1.append(this.f.a());
        throw new IllegalArgumentException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
      stringBuilder2.append(stringBuilder1);
      stringBuilder2.append(this.f.a());
      throw new IllegalArgumentException(stringBuilder2.toString());
    }
    
    public void bindViewToPosition(View param1View, int param1Int) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      if (viewHolder != null) {
        int i = this.f.f.b(param1Int);
        if (i >= 0 && i < this.f.m.getItemCount()) {
          RecyclerView.LayoutParams layoutParams;
          a(viewHolder, i, param1Int, Long.MAX_VALUE);
          ViewGroup.LayoutParams layoutParams1 = viewHolder.itemView.getLayoutParams();
          if (layoutParams1 == null) {
            layoutParams = (RecyclerView.LayoutParams)this.f.generateDefaultLayoutParams();
            viewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          } else if (!this.f.checkLayoutParams((ViewGroup.LayoutParams)layoutParams)) {
            layoutParams = (RecyclerView.LayoutParams)this.f.generateLayoutParams((ViewGroup.LayoutParams)layoutParams);
            viewHolder.itemView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
          } else {
            layoutParams = layoutParams;
          } 
          boolean bool = true;
          layoutParams.e = true;
          layoutParams.c = viewHolder;
          if (viewHolder.itemView.getParent() != null)
            bool = false; 
          layoutParams.f = bool;
          return;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Inconsistency detected. Invalid item position ");
        stringBuilder1.append(param1Int);
        stringBuilder1.append("(offset:");
        stringBuilder1.append(i);
        stringBuilder1.append(").state:");
        stringBuilder1.append(this.f.D.getItemCount());
        stringBuilder1.append(this.f.a());
        throw new IndexOutOfBoundsException(stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
      stringBuilder.append(this.f.a());
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    int c() {
      return this.a.size();
    }
    
    RecyclerView.ViewHolder c(int param1Int) {
      ArrayList<RecyclerView.ViewHolder> arrayList = this.b;
      if (arrayList != null) {
        int j = arrayList.size();
        if (j == 0)
          return null; 
        boolean bool = false;
        for (int i = 0; i < j; i++) {
          RecyclerView.ViewHolder viewHolder = this.b.get(i);
          if (!viewHolder.f() && viewHolder.getLayoutPosition() == param1Int) {
            viewHolder.b(32);
            return viewHolder;
          } 
        } 
        if (this.f.m.hasStableIds()) {
          param1Int = this.f.f.b(param1Int);
          if (param1Int > 0 && param1Int < this.f.m.getItemCount()) {
            long l = this.f.m.getItemId(param1Int);
            for (param1Int = bool; param1Int < j; param1Int++) {
              RecyclerView.ViewHolder viewHolder = this.b.get(param1Int);
              if (!viewHolder.f() && viewHolder.getItemId() == l) {
                viewHolder.b(32);
                return viewHolder;
              } 
            } 
          } 
        } 
      } 
      return null;
    }
    
    void c(int param1Int1, int param1Int2) {
      for (int i = this.c.size() - 1; i >= 0; i--) {
        RecyclerView.ViewHolder viewHolder = this.c.get(i);
        if (viewHolder != null) {
          int j = viewHolder.b;
          if (j >= param1Int1 && j < param1Int2 + param1Int1) {
            viewHolder.b(2);
            a(i);
          } 
        } 
      } 
    }
    
    void c(RecyclerView.ViewHolder param1ViewHolder) {
      if (param1ViewHolder.m) {
        this.b.remove(param1ViewHolder);
      } else {
        this.a.remove(param1ViewHolder);
      } 
      param1ViewHolder.l = null;
      param1ViewHolder.m = false;
      param1ViewHolder.g();
    }
    
    public void clear() {
      this.a.clear();
      b();
    }
    
    public int convertPreLayoutPositionToPostLayout(int param1Int) {
      if (param1Int >= 0 && param1Int < this.f.D.getItemCount())
        return !this.f.D.isPreLayout() ? param1Int : this.f.f.b(param1Int); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("invalid position ");
      stringBuilder.append(param1Int);
      stringBuilder.append(". State item count is ");
      stringBuilder.append(this.f.D.getItemCount());
      stringBuilder.append(this.f.a());
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    void d() {
      this.a.clear();
      ArrayList<RecyclerView.ViewHolder> arrayList = this.b;
      if (arrayList != null)
        arrayList.clear(); 
    }
    
    void d(RecyclerView.ViewHolder param1ViewHolder) {
      if (this.f.o != null)
        this.f.o.onViewRecycled(param1ViewHolder); 
      if (this.f.m != null)
        this.f.m.onViewRecycled(param1ViewHolder); 
      if (this.f.D != null)
        this.f.h.g(param1ViewHolder); 
    }
    
    RecyclerView.RecycledViewPool e() {
      if (this.e == null)
        this.e = new RecyclerView.RecycledViewPool(); 
      return this.e;
    }
    
    void f() {
      int j = this.c.size();
      for (int i = 0; i < j; i++) {
        RecyclerView.ViewHolder viewHolder = this.c.get(i);
        if (viewHolder != null) {
          viewHolder.b(6);
          viewHolder.a((Object)null);
        } 
      } 
      if (this.f.m == null || !this.f.m.hasStableIds())
        b(); 
    }
    
    void g() {
      int j = this.c.size();
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++)
        ((RecyclerView.ViewHolder)this.c.get(i)).a(); 
      j = this.a.size();
      for (i = 0; i < j; i++)
        ((RecyclerView.ViewHolder)this.a.get(i)).a(); 
      ArrayList<RecyclerView.ViewHolder> arrayList = this.b;
      if (arrayList != null) {
        j = arrayList.size();
        for (i = bool; i < j; i++)
          ((RecyclerView.ViewHolder)this.b.get(i)).a(); 
      } 
    }
    
    public List<RecyclerView.ViewHolder> getScrapList() {
      return this.g;
    }
    
    public View getViewForPosition(int param1Int) {
      return a(param1Int, false);
    }
    
    void h() {
      int j = this.c.size();
      for (int i = 0; i < j; i++) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.c.get(i)).itemView.getLayoutParams();
        if (layoutParams != null)
          layoutParams.e = true; 
      } 
    }
    
    public void recycleView(View param1View) {
      RecyclerView.ViewHolder viewHolder = RecyclerView.b(param1View);
      if (viewHolder.n())
        this.f.removeDetachedView(param1View, false); 
      if (viewHolder.d()) {
        viewHolder.e();
      } else if (viewHolder.f()) {
        viewHolder.g();
      } 
      b(viewHolder);
      if (this.f.z != null && !viewHolder.isRecyclable())
        this.f.z.endAnimation(viewHolder); 
    }
    
    public void setViewCacheSize(int param1Int) {
      this.h = param1Int;
      a();
    }
  }
  
  public static interface RecyclerListener {
    void onViewRecycled(RecyclerView.ViewHolder param1ViewHolder);
  }
  
  class RecyclerViewDataObserver extends AdapterDataObserver {
    RecyclerViewDataObserver(RecyclerView this$0) {}
    
    void a() {
      if (RecyclerView.c && this.a.r && this.a.q) {
        RecyclerView recyclerView1 = this.a;
        ViewCompat.postOnAnimation((View)recyclerView1, recyclerView1.j);
        return;
      } 
      RecyclerView recyclerView = this.a;
      recyclerView.w = true;
      recyclerView.requestLayout();
    }
    
    public void onChanged() {
      this.a.b((String)null);
      this.a.D.f = true;
      this.a.c(true);
      if (!this.a.f.d())
        this.a.requestLayout(); 
    }
    
    public void onItemRangeChanged(int param1Int1, int param1Int2, Object param1Object) {
      this.a.b((String)null);
      if (this.a.f.a(param1Int1, param1Int2, param1Object))
        a(); 
    }
    
    public void onItemRangeInserted(int param1Int1, int param1Int2) {
      this.a.b((String)null);
      if (this.a.f.b(param1Int1, param1Int2))
        a(); 
    }
    
    public void onItemRangeMoved(int param1Int1, int param1Int2, int param1Int3) {
      this.a.b((String)null);
      if (this.a.f.a(param1Int1, param1Int2, param1Int3))
        a(); 
    }
    
    public void onItemRangeRemoved(int param1Int1, int param1Int2) {
      this.a.b((String)null);
      if (this.a.f.c(param1Int1, param1Int2))
        a(); 
    }
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public RecyclerView.SavedState createFromParcel(Parcel param2Parcel) {
          return new RecyclerView.SavedState(param2Parcel, null);
        }
        
        public RecyclerView.SavedState createFromParcel(Parcel param2Parcel, ClassLoader param2ClassLoader) {
          return new RecyclerView.SavedState(param2Parcel, param2ClassLoader);
        }
        
        public RecyclerView.SavedState[] newArray(int param2Int) {
          return new RecyclerView.SavedState[param2Int];
        }
      };
    
    Parcelable a;
    
    SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      if (param1ClassLoader == null)
        param1ClassLoader = RecyclerView.LayoutManager.class.getClassLoader(); 
      this.a = param1Parcel.readParcelable(param1ClassLoader);
    }
    
    SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    void a(SavedState param1SavedState) {
      this.a = param1SavedState.a;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeParcelable(this.a, 0);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
    public RecyclerView.SavedState createFromParcel(Parcel param1Parcel) {
      return new RecyclerView.SavedState(param1Parcel, null);
    }
    
    public RecyclerView.SavedState createFromParcel(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new RecyclerView.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public RecyclerView.SavedState[] newArray(int param1Int) {
      return new RecyclerView.SavedState[param1Int];
    }
  }
  
  public static class SimpleOnItemTouchListener implements OnItemTouchListener {
    public boolean onInterceptTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {
      return false;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean param1Boolean) {}
    
    public void onTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {}
  }
  
  public static abstract class SmoothScroller {
    private int a = -1;
    
    private RecyclerView b;
    
    private RecyclerView.LayoutManager c;
    
    private boolean d;
    
    private boolean e;
    
    private View f;
    
    private final Action g = new Action(0, 0);
    
    private boolean h;
    
    protected abstract void a();
    
    void a(int param1Int1, int param1Int2) {
      RecyclerView recyclerView = this.b;
      if (this.a == -1 || recyclerView == null)
        e(); 
      if (this.d && this.f == null && this.c != null) {
        PointF pointF = computeScrollVectorForPosition(this.a);
        if (pointF != null && (pointF.x != 0.0F || pointF.y != 0.0F))
          recyclerView.a((int)Math.signum(pointF.x), (int)Math.signum(pointF.y), (int[])null); 
      } 
      this.d = false;
      View view = this.f;
      if (view != null)
        if (getChildPosition(view) == this.a) {
          a(this.f, recyclerView.D, this.g);
          this.g.a(recyclerView);
          e();
        } else {
          Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
          this.f = null;
        }  
      if (this.e) {
        a(param1Int1, param1Int2, recyclerView.D, this.g);
        boolean bool = this.g.a();
        this.g.a(recyclerView);
        if (bool && this.e) {
          this.d = true;
          recyclerView.A.a();
        } 
      } 
    }
    
    protected abstract void a(int param1Int1, int param1Int2, RecyclerView.State param1State, Action param1Action);
    
    protected void a(PointF param1PointF) {
      float f = (float)Math.sqrt((param1PointF.x * param1PointF.x + param1PointF.y * param1PointF.y));
      param1PointF.x /= f;
      param1PointF.y /= f;
    }
    
    protected void a(View param1View) {
      if (getChildPosition(param1View) == getTargetPosition())
        this.f = param1View; 
    }
    
    protected abstract void a(View param1View, RecyclerView.State param1State, Action param1Action);
    
    void a(RecyclerView param1RecyclerView, RecyclerView.LayoutManager param1LayoutManager) {
      param1RecyclerView.A.stop();
      if (this.h) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An instance of ");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" was started more than once. Each instance of");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" is intended to only be used once. You should create a new instance for each use.");
        Log.w("RecyclerView", stringBuilder.toString());
      } 
      this.b = param1RecyclerView;
      this.c = param1LayoutManager;
      if (this.a != -1) {
        this.b.D.a = this.a;
        this.e = true;
        this.d = true;
        this.f = findViewByPosition(getTargetPosition());
        a();
        this.b.A.a();
        this.h = true;
        return;
      } 
      throw new IllegalArgumentException("Invalid target position");
    }
    
    protected abstract void b();
    
    public PointF computeScrollVectorForPosition(int param1Int) {
      RecyclerView.LayoutManager layoutManager = getLayoutManager();
      if (layoutManager instanceof ScrollVectorProvider)
        return ((ScrollVectorProvider)layoutManager).computeScrollVectorForPosition(param1Int); 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
      stringBuilder.append(ScrollVectorProvider.class.getCanonicalName());
      Log.w("RecyclerView", stringBuilder.toString());
      return null;
    }
    
    protected final void e() {
      if (!this.e)
        return; 
      this.e = false;
      b();
      this.b.D.a = -1;
      this.f = null;
      this.a = -1;
      this.d = false;
      this.c.a(this);
      this.c = null;
      this.b = null;
    }
    
    public View findViewByPosition(int param1Int) {
      return this.b.n.findViewByPosition(param1Int);
    }
    
    public int getChildCount() {
      return this.b.n.getChildCount();
    }
    
    public int getChildPosition(View param1View) {
      return this.b.getChildLayoutPosition(param1View);
    }
    
    public RecyclerView.LayoutManager getLayoutManager() {
      return this.c;
    }
    
    public int getTargetPosition() {
      return this.a;
    }
    
    @Deprecated
    public void instantScrollToPosition(int param1Int) {
      this.b.scrollToPosition(param1Int);
    }
    
    public boolean isPendingInitialRun() {
      return this.d;
    }
    
    public boolean isRunning() {
      return this.e;
    }
    
    public void setTargetPosition(int param1Int) {
      this.a = param1Int;
    }
    
    public static class Action {
      public static final int UNDEFINED_DURATION = -2147483648;
      
      private int a;
      
      private int b;
      
      private int c;
      
      private int d = -1;
      
      private Interpolator e;
      
      private boolean f = false;
      
      private int g = 0;
      
      public Action(int param2Int1, int param2Int2) {
        this(param2Int1, param2Int2, -2147483648, null);
      }
      
      public Action(int param2Int1, int param2Int2, int param2Int3) {
        this(param2Int1, param2Int2, param2Int3, null);
      }
      
      public Action(int param2Int1, int param2Int2, int param2Int3, Interpolator param2Interpolator) {
        this.a = param2Int1;
        this.b = param2Int2;
        this.c = param2Int3;
        this.e = param2Interpolator;
      }
      
      private void b() {
        if (this.e == null || this.c >= 1) {
          if (this.c >= 1)
            return; 
          throw new IllegalStateException("Scroll duration must be a positive number");
        } 
        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
      }
      
      void a(RecyclerView param2RecyclerView) {
        int i = this.d;
        if (i >= 0) {
          this.d = -1;
          param2RecyclerView.a(i);
          this.f = false;
          return;
        } 
        if (this.f) {
          b();
          param2RecyclerView.A.smoothScrollBy(this.a, this.b, this.c, this.e);
          this.g++;
          if (this.g > 10)
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary"); 
          this.f = false;
          return;
        } 
        this.g = 0;
      }
      
      boolean a() {
        return (this.d >= 0);
      }
      
      public int getDuration() {
        return this.c;
      }
      
      public int getDx() {
        return this.a;
      }
      
      public int getDy() {
        return this.b;
      }
      
      public Interpolator getInterpolator() {
        return this.e;
      }
      
      public void jumpTo(int param2Int) {
        this.d = param2Int;
      }
      
      public void setDuration(int param2Int) {
        this.f = true;
        this.c = param2Int;
      }
      
      public void setDx(int param2Int) {
        this.f = true;
        this.a = param2Int;
      }
      
      public void setDy(int param2Int) {
        this.f = true;
        this.b = param2Int;
      }
      
      public void setInterpolator(Interpolator param2Interpolator) {
        this.f = true;
        this.e = param2Interpolator;
      }
      
      public void update(int param2Int1, int param2Int2, int param2Int3, Interpolator param2Interpolator) {
        this.a = param2Int1;
        this.b = param2Int2;
        this.c = param2Int3;
        this.e = param2Interpolator;
        this.f = true;
      }
    }
    
    public static interface ScrollVectorProvider {
      PointF computeScrollVectorForPosition(int param2Int);
    }
  }
  
  public static class Action {
    public static final int UNDEFINED_DURATION = -2147483648;
    
    private int a;
    
    private int b;
    
    private int c;
    
    private int d = -1;
    
    private Interpolator e;
    
    private boolean f = false;
    
    private int g = 0;
    
    public Action(int param1Int1, int param1Int2) {
      this(param1Int1, param1Int2, -2147483648, null);
    }
    
    public Action(int param1Int1, int param1Int2, int param1Int3) {
      this(param1Int1, param1Int2, param1Int3, null);
    }
    
    public Action(int param1Int1, int param1Int2, int param1Int3, Interpolator param1Interpolator) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
      this.e = param1Interpolator;
    }
    
    private void b() {
      if (this.e == null || this.c >= 1) {
        if (this.c >= 1)
          return; 
        throw new IllegalStateException("Scroll duration must be a positive number");
      } 
      throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
    }
    
    void a(RecyclerView param1RecyclerView) {
      int i = this.d;
      if (i >= 0) {
        this.d = -1;
        param1RecyclerView.a(i);
        this.f = false;
        return;
      } 
      if (this.f) {
        b();
        param1RecyclerView.A.smoothScrollBy(this.a, this.b, this.c, this.e);
        this.g++;
        if (this.g > 10)
          Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary"); 
        this.f = false;
        return;
      } 
      this.g = 0;
    }
    
    boolean a() {
      return (this.d >= 0);
    }
    
    public int getDuration() {
      return this.c;
    }
    
    public int getDx() {
      return this.a;
    }
    
    public int getDy() {
      return this.b;
    }
    
    public Interpolator getInterpolator() {
      return this.e;
    }
    
    public void jumpTo(int param1Int) {
      this.d = param1Int;
    }
    
    public void setDuration(int param1Int) {
      this.f = true;
      this.c = param1Int;
    }
    
    public void setDx(int param1Int) {
      this.f = true;
      this.a = param1Int;
    }
    
    public void setDy(int param1Int) {
      this.f = true;
      this.b = param1Int;
    }
    
    public void setInterpolator(Interpolator param1Interpolator) {
      this.f = true;
      this.e = param1Interpolator;
    }
    
    public void update(int param1Int1, int param1Int2, int param1Int3, Interpolator param1Interpolator) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
      this.e = param1Interpolator;
      this.f = true;
    }
  }
  
  public static interface ScrollVectorProvider {
    PointF computeScrollVectorForPosition(int param1Int);
  }
  
  public static class State {
    int a = -1;
    
    int b = 0;
    
    int c = 0;
    
    int d = 1;
    
    int e = 0;
    
    boolean f = false;
    
    boolean g = false;
    
    boolean h = false;
    
    boolean i = false;
    
    boolean j = false;
    
    boolean k = false;
    
    int l;
    
    long m;
    
    int n;
    
    int o;
    
    int p;
    
    private SparseArray<Object> q;
    
    void a(int param1Int) {
      if ((this.d & param1Int) != 0)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Layout state should be one of ");
      stringBuilder.append(Integer.toBinaryString(param1Int));
      stringBuilder.append(" but it is ");
      stringBuilder.append(Integer.toBinaryString(this.d));
      throw new IllegalStateException(stringBuilder.toString());
    }
    
    void a(RecyclerView.Adapter param1Adapter) {
      this.d = 1;
      this.e = param1Adapter.getItemCount();
      this.g = false;
      this.h = false;
      this.i = false;
    }
    
    public boolean didStructureChange() {
      return this.f;
    }
    
    public <T> T get(int param1Int) {
      SparseArray<Object> sparseArray = this.q;
      return (T)((sparseArray == null) ? null : sparseArray.get(param1Int));
    }
    
    public int getItemCount() {
      return this.g ? (this.b - this.c) : this.e;
    }
    
    public int getRemainingScrollHorizontal() {
      return this.o;
    }
    
    public int getRemainingScrollVertical() {
      return this.p;
    }
    
    public int getTargetScrollPosition() {
      return this.a;
    }
    
    public boolean hasTargetScrollPosition() {
      return (this.a != -1);
    }
    
    public boolean isMeasuring() {
      return this.i;
    }
    
    public boolean isPreLayout() {
      return this.g;
    }
    
    public void put(int param1Int, Object param1Object) {
      if (this.q == null)
        this.q = new SparseArray(); 
      this.q.put(param1Int, param1Object);
    }
    
    public void remove(int param1Int) {
      SparseArray<Object> sparseArray = this.q;
      if (sparseArray == null)
        return; 
      sparseArray.remove(param1Int);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("State{mTargetPosition=");
      stringBuilder.append(this.a);
      stringBuilder.append(", mData=");
      stringBuilder.append(this.q);
      stringBuilder.append(", mItemCount=");
      stringBuilder.append(this.e);
      stringBuilder.append(", mIsMeasuring=");
      stringBuilder.append(this.i);
      stringBuilder.append(", mPreviousLayoutItemCount=");
      stringBuilder.append(this.b);
      stringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      stringBuilder.append(this.c);
      stringBuilder.append(", mStructureChanged=");
      stringBuilder.append(this.f);
      stringBuilder.append(", mInPreLayout=");
      stringBuilder.append(this.g);
      stringBuilder.append(", mRunSimpleAnimations=");
      stringBuilder.append(this.j);
      stringBuilder.append(", mRunPredictiveAnimations=");
      stringBuilder.append(this.k);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
    
    public boolean willRunPredictiveAnimations() {
      return this.k;
    }
    
    public boolean willRunSimpleAnimations() {
      return this.j;
    }
  }
  
  public static abstract class ViewCacheExtension {
    public abstract View getViewForPositionAndType(RecyclerView.Recycler param1Recycler, int param1Int1, int param1Int2);
  }
  
  class ViewFlinger implements Runnable {
    OverScroller a;
    
    Interpolator b = RecyclerView.K;
    
    private int d;
    
    private int e;
    
    private boolean f = false;
    
    private boolean g = false;
    
    ViewFlinger(RecyclerView this$0) {
      this.a = new OverScroller(this$0.getContext(), RecyclerView.K);
    }
    
    private float a(float param1Float) {
      return (float)Math.sin(((param1Float - 0.5F) * 0.47123894F));
    }
    
    private int a(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      boolean bool;
      int i = Math.abs(param1Int1);
      int j = Math.abs(param1Int2);
      if (i > j) {
        bool = true;
      } else {
        bool = false;
      } 
      param1Int3 = (int)Math.sqrt((param1Int3 * param1Int3 + param1Int4 * param1Int4));
      param1Int2 = (int)Math.sqrt((param1Int1 * param1Int1 + param1Int2 * param1Int2));
      RecyclerView recyclerView = this.c;
      if (bool) {
        param1Int1 = recyclerView.getWidth();
      } else {
        param1Int1 = recyclerView.getHeight();
      } 
      param1Int4 = param1Int1 / 2;
      float f2 = param1Int2;
      float f1 = param1Int1;
      float f3 = Math.min(1.0F, f2 * 1.0F / f1);
      f2 = param1Int4;
      f3 = a(f3);
      if (param1Int3 > 0) {
        param1Int1 = Math.round(Math.abs((f2 + f3 * f2) / param1Int3) * 1000.0F) * 4;
      } else {
        if (bool) {
          param1Int1 = i;
        } else {
          param1Int1 = j;
        } 
        param1Int1 = (int)((param1Int1 / f1 + 1.0F) * 300.0F);
      } 
      return Math.min(param1Int1, 2000);
    }
    
    private void b() {
      this.c.removeCallbacks(this);
      ViewCompat.postOnAnimation((View)this.c, this);
    }
    
    void a() {
      if (this.f) {
        this.g = true;
        return;
      } 
      b();
    }
    
    public void fling(int param1Int1, int param1Int2) {
      this.c.setScrollState(2);
      this.e = 0;
      this.d = 0;
      if (this.b != RecyclerView.K) {
        this.b = RecyclerView.K;
        this.a = new OverScroller(this.c.getContext(), RecyclerView.K);
      } 
      this.a.fling(0, 0, param1Int1, param1Int2, -2147483648, 2147483647, -2147483648, 2147483647);
      a();
    }
    
    public void run() {
      if (this.c.n == null) {
        stop();
        return;
      } 
      this.g = false;
      this.f = true;
      this.c.d();
      OverScroller overScroller = this.a;
      if (overScroller.computeScrollOffset()) {
        int i = overScroller.getCurrX();
        int j = overScroller.getCurrY();
        int m = i - this.d;
        int k = j - this.e;
        this.d = i;
        this.e = j;
        this.c.I[0] = 0;
        this.c.I[1] = 0;
        RecyclerView recyclerView = this.c;
        i = m;
        j = k;
        if (recyclerView.dispatchNestedPreScroll(m, k, recyclerView.I, (int[])null, 1)) {
          i = m - this.c.I[0];
          j = k - this.c.I[1];
        } 
        if (this.c.getOverScrollMode() != 2)
          this.c.a(i, j); 
        if (this.c.m != null) {
          this.c.I[0] = 0;
          this.c.I[1] = 0;
          recyclerView = this.c;
          recyclerView.a(i, j, recyclerView.I);
          int i2 = this.c.I[0];
          int i3 = this.c.I[1];
          int i4 = i - i2;
          int i5 = j - i3;
          RecyclerView.SmoothScroller smoothScroller2 = this.c.n.t;
          i = i2;
          m = i4;
          j = i3;
          k = i5;
          if (smoothScroller2 != null) {
            i = i2;
            m = i4;
            j = i3;
            k = i5;
            if (!smoothScroller2.isPendingInitialRun()) {
              i = i2;
              m = i4;
              j = i3;
              k = i5;
              if (smoothScroller2.isRunning()) {
                i = this.c.D.getItemCount();
                if (i == 0) {
                  smoothScroller2.e();
                  i = i2;
                  m = i4;
                  j = i3;
                  k = i5;
                } else if (smoothScroller2.getTargetPosition() >= i) {
                  smoothScroller2.setTargetPosition(i - 1);
                  smoothScroller2.a(i2, i3);
                  i = i2;
                  m = i4;
                  j = i3;
                  k = i5;
                } else {
                  smoothScroller2.a(i2, i3);
                  i = i2;
                  m = i4;
                  j = i3;
                  k = i5;
                } 
              } 
            } 
          } 
        } else {
          boolean bool = false;
          m = 0;
          k = j;
          j = m;
          m = i;
          i = bool;
        } 
        if (!this.c.p.isEmpty())
          this.c.invalidate(); 
        this.c.I[0] = 0;
        this.c.I[1] = 0;
        recyclerView = this.c;
        recyclerView.dispatchNestedScroll(i, j, m, k, (int[])null, 1, recyclerView.I);
        int i1 = m - this.c.I[0];
        int n = k - this.c.I[1];
        if (i != 0 || j != 0)
          this.c.f(i, j); 
        if (!RecyclerView.a(this.c))
          this.c.invalidate(); 
        if (overScroller.getCurrX() == overScroller.getFinalX()) {
          k = 1;
        } else {
          k = 0;
        } 
        if (overScroller.getCurrY() == overScroller.getFinalY()) {
          m = 1;
        } else {
          m = 0;
        } 
        if (overScroller.isFinished() || ((k != 0 || i1 != 0) && (m != 0 || n != 0))) {
          k = 1;
        } else {
          k = 0;
        } 
        RecyclerView.SmoothScroller smoothScroller1 = this.c.n.t;
        if (smoothScroller1 != null && smoothScroller1.isPendingInitialRun()) {
          m = 1;
        } else {
          m = 0;
        } 
        if (m == 0 && k != 0) {
          if (this.c.getOverScrollMode() != 2) {
            j = (int)overScroller.getCurrVelocity();
            if (i1 < 0) {
              i = -j;
            } else if (i1 > 0) {
              i = j;
            } else {
              i = 0;
            } 
            if (n < 0) {
              j = -j;
            } else if (n <= 0) {
              j = 0;
            } 
            this.c.b(i, j);
          } 
          if (RecyclerView.d)
            this.c.C.a(); 
        } else {
          a();
          if (this.c.B != null)
            this.c.B.a(this.c, i, j); 
        } 
      } 
      RecyclerView.SmoothScroller smoothScroller = this.c.n.t;
      if (smoothScroller != null && smoothScroller.isPendingInitialRun())
        smoothScroller.a(0, 0); 
      this.f = false;
      if (this.g) {
        b();
        return;
      } 
      this.c.setScrollState(0);
      this.c.stopNestedScroll(1);
    }
    
    public void smoothScrollBy(int param1Int1, int param1Int2, int param1Int3, Interpolator param1Interpolator) {
      int i = param1Int3;
      if (param1Int3 == Integer.MIN_VALUE)
        i = a(param1Int1, param1Int2, 0, 0); 
      Interpolator interpolator = param1Interpolator;
      if (param1Interpolator == null)
        interpolator = RecyclerView.K; 
      if (this.b != interpolator) {
        this.b = interpolator;
        this.a = new OverScroller(this.c.getContext(), interpolator);
      } 
      this.e = 0;
      this.d = 0;
      this.c.setScrollState(2);
      this.a.startScroll(0, 0, param1Int1, param1Int2, i);
      if (Build.VERSION.SDK_INT < 23)
        this.a.computeScrollOffset(); 
      a();
    }
    
    public void stop() {
      this.c.removeCallbacks(this);
      this.a.abortAnimation();
    }
  }
  
  public static abstract class ViewHolder {
    private static final List<Object> p = Collections.emptyList();
    
    WeakReference<RecyclerView> a;
    
    int b = -1;
    
    int c = -1;
    
    long d = -1L;
    
    int e = -1;
    
    int f = -1;
    
    ViewHolder g = null;
    
    ViewHolder h = null;
    
    int i;
    
    public final View itemView;
    
    List<Object> j = null;
    
    List<Object> k = null;
    
    RecyclerView.Recycler l = null;
    
    boolean m = false;
    
    int n = -1;
    
    RecyclerView o;
    
    private int q = 0;
    
    private int r = 0;
    
    public ViewHolder(View param1View) {
      if (param1View != null) {
        this.itemView = param1View;
        return;
      } 
      throw new IllegalArgumentException("itemView may not be null");
    }
    
    private void w() {
      if (this.j == null) {
        this.j = new ArrayList();
        this.k = Collections.unmodifiableList(this.j);
      } 
    }
    
    void a() {
      this.c = -1;
      this.f = -1;
    }
    
    void a(int param1Int1, int param1Int2) {
      this.i = param1Int1 & param1Int2 | this.i & param1Int2;
    }
    
    void a(int param1Int1, int param1Int2, boolean param1Boolean) {
      b(8);
      a(param1Int2, param1Boolean);
      this.b = param1Int1;
    }
    
    void a(int param1Int, boolean param1Boolean) {
      if (this.c == -1)
        this.c = this.b; 
      if (this.f == -1)
        this.f = this.b; 
      if (param1Boolean)
        this.f += param1Int; 
      this.b += param1Int;
      if (this.itemView.getLayoutParams() != null)
        ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).e = true; 
    }
    
    void a(RecyclerView.Recycler param1Recycler, boolean param1Boolean) {
      this.l = param1Recycler;
      this.m = param1Boolean;
    }
    
    void a(RecyclerView param1RecyclerView) {
      int i = this.n;
      if (i != -1) {
        this.r = i;
      } else {
        this.r = ViewCompat.getImportantForAccessibility(this.itemView);
      } 
      param1RecyclerView.a(this, 4);
    }
    
    void a(Object param1Object) {
      if (param1Object == null) {
        b(1024);
        return;
      } 
      if ((0x400 & this.i) == 0) {
        w();
        this.j.add(param1Object);
      } 
    }
    
    boolean a(int param1Int) {
      return ((param1Int & this.i) != 0);
    }
    
    void b(int param1Int) {
      this.i = param1Int | this.i;
    }
    
    void b(RecyclerView param1RecyclerView) {
      param1RecyclerView.a(this, this.r);
      this.r = 0;
    }
    
    void be_() {
      if (this.c == -1)
        this.c = this.b; 
    }
    
    boolean bf_() {
      return ((this.i & 0x80) != 0);
    }
    
    boolean d() {
      return (this.l != null);
    }
    
    void e() {
      this.l.c(this);
    }
    
    boolean f() {
      return ((this.i & 0x20) != 0);
    }
    
    void g() {
      this.i &= 0xFFFFFFDF;
    }
    
    public final int getAdapterPosition() {
      RecyclerView recyclerView = this.o;
      return (recyclerView == null) ? -1 : recyclerView.d(this);
    }
    
    public final long getItemId() {
      return this.d;
    }
    
    public final int getItemViewType() {
      return this.e;
    }
    
    public final int getLayoutPosition() {
      int j = this.f;
      int i = j;
      if (j == -1)
        i = this.b; 
      return i;
    }
    
    public final int getOldPosition() {
      return this.c;
    }
    
    @Deprecated
    public final int getPosition() {
      int j = this.f;
      int i = j;
      if (j == -1)
        i = this.b; 
      return i;
    }
    
    void h() {
      this.i &= 0xFFFFFEFF;
    }
    
    void i() {
      this.i &= 0xFFFFFF7F;
    }
    
    public final boolean isRecyclable() {
      return ((this.i & 0x10) == 0 && !ViewCompat.hasTransientState(this.itemView));
    }
    
    boolean j() {
      return ((this.i & 0x4) != 0);
    }
    
    boolean k() {
      return ((this.i & 0x2) != 0);
    }
    
    boolean l() {
      return ((this.i & 0x1) != 0);
    }
    
    boolean m() {
      return ((this.i & 0x8) != 0);
    }
    
    boolean n() {
      return ((this.i & 0x100) != 0);
    }
    
    boolean o() {
      return (this.itemView.getParent() != null && this.itemView.getParent() != this.o);
    }
    
    boolean p() {
      return ((this.i & 0x200) != 0 || j());
    }
    
    void q() {
      List<Object> list = this.j;
      if (list != null)
        list.clear(); 
      this.i &= 0xFFFFFBFF;
    }
    
    List<Object> r() {
      if ((this.i & 0x400) == 0) {
        List<Object> list = this.j;
        return (list == null || list.size() == 0) ? p : this.k;
      } 
      return p;
    }
    
    void s() {
      this.i = 0;
      this.b = -1;
      this.c = -1;
      this.d = -1L;
      this.f = -1;
      this.q = 0;
      this.g = null;
      this.h = null;
      q();
      this.r = 0;
      this.n = -1;
      RecyclerView.c(this);
    }
    
    public final void setIsRecyclable(boolean param1Boolean) {
      int i = this.q;
      if (param1Boolean) {
        i--;
      } else {
        i++;
      } 
      this.q = i;
      i = this.q;
      if (i < 0) {
        this.q = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        stringBuilder.append(this);
        Log.e("View", stringBuilder.toString());
        return;
      } 
      if (!param1Boolean && i == 1) {
        this.i |= 0x10;
        return;
      } 
      if (param1Boolean && this.q == 0)
        this.i &= 0xFFFFFFEF; 
    }
    
    boolean t() {
      return ((this.i & 0x10) != 0);
    }
    
    public String toString() {
      String str;
      if (getClass().isAnonymousClass()) {
        str = "ViewHolder";
      } else {
        str = getClass().getSimpleName();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("{");
      stringBuilder.append(Integer.toHexString(hashCode()));
      stringBuilder.append(" position=");
      stringBuilder.append(this.b);
      stringBuilder.append(" id=");
      stringBuilder.append(this.d);
      stringBuilder.append(", oldPos=");
      stringBuilder.append(this.c);
      stringBuilder.append(", pLpos:");
      stringBuilder.append(this.f);
      stringBuilder = new StringBuilder(stringBuilder.toString());
      if (d()) {
        stringBuilder.append(" scrap ");
        if (this.m) {
          str = "[changeScrap]";
        } else {
          str = "[attachedScrap]";
        } 
        stringBuilder.append(str);
      } 
      if (j())
        stringBuilder.append(" invalid"); 
      if (!l())
        stringBuilder.append(" unbound"); 
      if (k())
        stringBuilder.append(" update"); 
      if (m())
        stringBuilder.append(" removed"); 
      if (bf_())
        stringBuilder.append(" ignored"); 
      if (n())
        stringBuilder.append(" tmpDetached"); 
      if (!isRecyclable()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" not recyclable(");
        stringBuilder1.append(this.q);
        stringBuilder1.append(")");
        stringBuilder.append(stringBuilder1.toString());
      } 
      if (p())
        stringBuilder.append(" undefined adapter position"); 
      if (this.itemView.getParent() == null)
        stringBuilder.append(" no parent"); 
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
    
    boolean u() {
      return ((this.i & 0x10) == 0 && ViewCompat.hasTransientState(this.itemView));
    }
    
    boolean v() {
      return ((this.i & 0x2) != 0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */