package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.framework.R;

public abstract class PullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T> {
  private static String C = "";
  
  private OnPullEventListener<T> A;
  
  private SmoothScrollRunnable B;
  
  private int D = 0;
  
  private int E;
  
  private boolean F = false;
  
  private boolean G = true;
  
  T a;
  
  private Context b;
  
  private boolean c;
  
  private int d;
  
  private float e;
  
  private float f;
  
  private float g;
  
  private float h;
  
  private float i;
  
  private float j;
  
  private boolean k = false;
  
  private State l = State.a;
  
  private Mode m = Mode.a();
  
  private Mode n;
  
  private FrameLayout o;
  
  private boolean p = true;
  
  private boolean q = true;
  
  private boolean r = true;
  
  private boolean s = true;
  
  private boolean t = true;
  
  private Interpolator u;
  
  private AnimationStyle v = AnimationStyle.a();
  
  private LoadingLayout w;
  
  private LoadingLayout x;
  
  private OnRefreshListener<T> y;
  
  private OnRefreshListener2<T> z;
  
  public PullToRefreshBase(Context paramContext) {
    super(paramContext);
    b(paramContext, (AttributeSet)null);
  }
  
  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshBase(Context paramContext, Mode paramMode) {
    super(paramContext);
    this.m = paramMode;
    b(paramContext, (AttributeSet)null);
  }
  
  public PullToRefreshBase(Context paramContext, Mode paramMode, AnimationStyle paramAnimationStyle) {
    super(paramContext);
    this.m = paramMode;
    this.v = paramAnimationStyle;
    b(paramContext, (AttributeSet)null);
  }
  
  private final void a(int paramInt, long paramLong) {
    a(paramInt, paramLong, 0L, (OnSmoothScrollFinishedListener)null);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2, OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener) {
    int i;
    SmoothScrollRunnable smoothScrollRunnable = this.B;
    if (smoothScrollRunnable != null)
      smoothScrollRunnable.a(); 
    if (null.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      i = getScrollY();
    } else {
      i = getScrollX();
    } 
    if (i != paramInt) {
      if (this.u == null)
        this.u = (Interpolator)new DecelerateInterpolator(); 
      this.B = new SmoothScrollRunnable(this, i, paramInt, paramLong1, paramOnSmoothScrollFinishedListener);
      if (paramLong2 > 0L) {
        postDelayed(this.B, paramLong2);
        return;
      } 
      post(this.B);
      return;
    } 
    if (paramOnSmoothScrollFinishedListener != null)
      paramOnSmoothScrollFinishedListener.a(); 
  }
  
  private void a(Context paramContext, T paramT) {
    this.o = new FrameLayout(paramContext);
    this.o.addView((View)paramT, -1, -1);
    a((View)this.o, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
  }
  
  private void a(MotionEvent paramMotionEvent) {
    this.i = this.e - this.g;
    this.j = this.f - this.h;
    float f = paramMotionEvent.getX();
    this.g = f;
    this.e = f;
    this.e += this.i;
    f = paramMotionEvent.getY();
    this.h = f;
    this.f = f;
    this.f += this.j;
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet) {
    this.b = paramContext;
    if (null.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      setOrientation(1);
    } else {
      setOrientation(0);
    } 
    setGravity(17);
    this.d = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToRefresh);
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrMode))
      this.m = Mode.a(typedArray.getInteger(R.styleable.PullToRefresh_ptrMode, 0)); 
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrAnimationStyle))
      this.v = AnimationStyle.a(typedArray.getInteger(R.styleable.PullToRefresh_ptrAnimationStyle, 0)); 
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderLoadingClass))
      C = typedArray.getString(R.styleable.PullToRefresh_ptrHeaderLoadingClass); 
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrMaximumPullHeight))
      this.E = (int)typedArray.getDimension(R.styleable.PullToRefresh_ptrMaximumPullHeight, 0.0F); 
    this.a = a(paramContext, paramAttributeSet);
    a(paramContext, this.a);
    this.w = a(paramContext, Mode.b, typedArray);
    this.x = a(paramContext, Mode.c, typedArray);
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrRefreshableViewBackground)) {
      Drawable drawable = typedArray.getDrawable(R.styleable.PullToRefresh_ptrRefreshableViewBackground);
      if (drawable != null)
        this.a.setBackgroundDrawable(drawable); 
    } else if (typedArray.hasValue(R.styleable.PullToRefresh_ptrAdapterViewBackground)) {
      Log.w("ptrAViewBackground", "ptrRefreshableViewBackground");
      Drawable drawable = typedArray.getDrawable(R.styleable.PullToRefresh_ptrAdapterViewBackground);
      if (drawable != null)
        this.a.setBackgroundDrawable(drawable); 
    } 
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrOverScroll))
      this.s = typedArray.getBoolean(R.styleable.PullToRefresh_ptrOverScroll, true); 
    if (typedArray.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled))
      this.q = typedArray.getBoolean(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled, false); 
    a(typedArray);
    typedArray.recycle();
    f();
  }
  
  private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
    return (null.a[getPullToRefreshScrollDirection().ordinal()] != 1) ? new LinearLayout.LayoutParams(-1, -2) : new LinearLayout.LayoutParams(-2, -1);
  }
  
  private int getMaximumPullScroll() {
    if (null.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      int i = this.E;
      return (i != 0) ? i : Math.round(getHeight() / 2.0F);
    } 
    return Math.round(getWidth() / 2.0F);
  }
  
  private void o() {
    OnRefreshListener<T> onRefreshListener = this.y;
    if (onRefreshListener != null) {
      onRefreshListener.a(this);
      return;
    } 
    if (this.z != null) {
      if (this.n == Mode.b) {
        this.z.a(this);
        return;
      } 
      if (this.n == Mode.c)
        this.z.b(this); 
    } 
  }
  
  private boolean p() {
    int i = null.b[this.m.ordinal()];
    if (i != 2) {
      if (i != 3) {
        boolean bool = false;
        if (i != 4)
          return false; 
        if (e() || d())
          bool = true; 
        return bool;
      } 
      return d();
    } 
    return e();
  }
  
  private void q() {
    float f1;
    float f2;
    int i;
    int j;
    if (null.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
      f1 = this.h;
      f2 = this.f;
    } else {
      f1 = this.g;
      f2 = this.e;
    } 
    if (null.b[this.n.ordinal()] != 2) {
      i = Math.round(Math.min(f1 - f2, 0.0F) / 2.0F);
      j = getHeaderSize();
    } else {
      i = Math.round(Math.max(f1 - f2, 0.0F) / 2.0F);
      j = getFooterSize();
    } 
    if (this.D != 0 || !this.F)
      setHeaderScroll(i); 
    this.D = i;
    if (i != 0 && !i()) {
      f1 = Math.abs(i) / j;
      if (null.b[this.n.ordinal()] != 2) {
        this.w.onPull(f1);
      } else {
        this.x.onPull(f1);
      } 
      if (this.l != State.b && j >= Math.abs(i)) {
        a(State.b, new boolean[0]);
        return;
      } 
      if (this.l == State.b && j < Math.abs(i))
        a(State.c, new boolean[0]); 
    } 
  }
  
  protected abstract T a(Context paramContext, AttributeSet paramAttributeSet);
  
  public final ILoadingLayout a(boolean paramBoolean1, boolean paramBoolean2) {
    return b(paramBoolean1, paramBoolean2);
  }
  
  protected LoadingLayout a(Context paramContext, Mode paramMode, TypedArray paramTypedArray) {
    LoadingLayout loadingLayout = this.v.a(paramContext, paramMode, getPullToRefreshScrollDirection(), paramTypedArray);
    loadingLayout.setVisibility(4);
    C = "";
    return loadingLayout;
  }
  
  protected void a() {
    int i = null.b[this.n.ordinal()];
    if (i != 2) {
      if (i != 3)
        return; 
      this.w.pullToRefresh();
      return;
    } 
    this.x.pullToRefresh();
  }
  
  protected final void a(int paramInt) {
    a(paramInt, getPullToRefreshScrollDuration());
  }
  
  protected final void a(int paramInt, OnSmoothScrollFinishedListener paramOnSmoothScrollFinishedListener) {
    a(paramInt, getPullToRefreshScrollDuration(), 0L, paramOnSmoothScrollFinishedListener);
  }
  
  protected void a(TypedArray paramTypedArray) {}
  
  protected void a(Bundle paramBundle) {}
  
  protected final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  protected final void a(View paramView, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, -1, paramLayoutParams);
  }
  
  final void a(State paramState, boolean... paramVarArgs) {
    this.l = paramState;
    int i = null.c[this.l.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4 || i == 5)
            a(paramVarArgs[0]); 
        } else {
          b();
        } 
      } else {
        a();
      } 
    } else {
      c();
    } 
    OnPullEventListener<T> onPullEventListener = this.A;
    if (onPullEventListener != null)
      onPullEventListener.a(this, this.l, this.n); 
  }
  
  public void a(CharSequence paramCharSequence, Mode paramMode) {
    a(paramMode.c(), paramMode.d()).setReleaseLabel(paramCharSequence);
  }
  
  protected void a(boolean paramBoolean) {
    if (this.m.c())
      this.w.refreshing(); 
    if (this.m.d())
      this.x.refreshing(); 
    if (paramBoolean) {
      if (this.p) {
        OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = new OnSmoothScrollFinishedListener(this) {
            public void a() {
              PullToRefreshBase.a(this.a);
            }
          };
        int i = null.b[this.n.ordinal()];
        if (i != 1 && i != 2) {
          a(-getHeaderSize(), onSmoothScrollFinishedListener);
          return;
        } 
        a(getFooterSize(), onSmoothScrollFinishedListener);
        return;
      } 
      a(0);
      return;
    } 
    o();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    T t = getRefreshableView();
    if (t instanceof ViewGroup) {
      ((ViewGroup)t).addView(paramView, paramInt, paramLayoutParams);
      return;
    } 
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }
  
  protected LoadingLayoutProxy b(boolean paramBoolean1, boolean paramBoolean2) {
    LoadingLayoutProxy loadingLayoutProxy = new LoadingLayoutProxy();
    if (paramBoolean1 && this.m.c())
      loadingLayoutProxy.a(this.w); 
    if (paramBoolean2 && this.m.d())
      loadingLayoutProxy.a(this.x); 
    return loadingLayoutProxy;
  }
  
  protected void b() {
    int i = null.b[this.n.ordinal()];
    if (i != 2) {
      if (i != 3)
        return; 
      this.w.releaseToRefresh();
      return;
    } 
    this.x.releaseToRefresh();
  }
  
  protected void b(Bundle paramBundle) {}
  
  protected void c() {
    this.k = false;
    this.t = true;
    this.w.reset();
    this.x.reset();
    a(0);
  }
  
  protected abstract boolean d();
  
  protected abstract boolean e();
  
  protected void f() {
    Mode mode;
    LinearLayout.LayoutParams layoutParams = getLoadingLayoutLayoutParams();
    if (this == this.w.getParent())
      removeView((View)this.w); 
    if (this.m.c())
      a((View)this.w, 0, (ViewGroup.LayoutParams)layoutParams); 
    if (this == this.x.getParent())
      removeView((View)this.x); 
    if (this.m.d())
      a((View)this.x, (ViewGroup.LayoutParams)layoutParams); 
    m();
    if (this.m != Mode.d) {
      mode = this.m;
    } else {
      mode = Mode.b;
    } 
    this.n = mode;
  }
  
  public final boolean g() {
    return this.m.b();
  }
  
  public final Mode getCurrentMode() {
    return this.n;
  }
  
  public final boolean getFilterTouchEvents() {
    return this.r;
  }
  
  protected final LoadingLayout getFooterLayout() {
    return this.x;
  }
  
  protected final int getFooterSize() {
    return this.x.getContentSize();
  }
  
  protected final LoadingLayout getHeaderLayout() {
    return this.w;
  }
  
  protected final int getHeaderSize() {
    return this.w.getContentSize();
  }
  
  public final ILoadingLayout getLoadingLayoutProxy() {
    return a(true, true);
  }
  
  public final Mode getMode() {
    return this.m;
  }
  
  public abstract Orientation getPullToRefreshScrollDirection();
  
  protected int getPullToRefreshScrollDuration() {
    return 200;
  }
  
  protected int getPullToRefreshScrollDurationLonger() {
    return 325;
  }
  
  public final T getRefreshableView() {
    return this.a;
  }
  
  protected FrameLayout getRefreshableViewWrapper() {
    return this.o;
  }
  
  public final boolean getShowViewWhileRefreshing() {
    return this.p;
  }
  
  public final State getState() {
    return this.l;
  }
  
  public final boolean h() {
    return (Build.VERSION.SDK_INT >= 9 && this.s && OverscrollHelper.a((View)this.a));
  }
  
  public final boolean i() {
    return (this.l == State.d || this.l == State.e);
  }
  
  public final void j() {
    if (i())
      a(State.a, new boolean[0]); 
  }
  
  public final void k() {
    setRefreshing(true);
  }
  
  protected final void l() {
    this.t = false;
  }
  
  protected final void m() {
    int i1 = (int)(getMaximumPullScroll() * 1.2F);
    int m = getPaddingLeft();
    int n = getPaddingTop();
    int j = getPaddingRight();
    int k = getPaddingBottom();
    int i = null.a[getPullToRefreshScrollDirection().ordinal()];
    if (i != 1) {
      if (i == 2) {
        if (this.m.c()) {
          this.w.setHeight(i1);
          i = -i1;
        } else {
          i = 0;
        } 
        if (this.m.d()) {
          this.x.setHeight(i1);
          k = -i1;
          n = i;
        } else {
          k = 0;
          n = i;
        } 
      } 
    } else {
      if (this.m.c()) {
        this.w.setWidth(i1);
        i = -i1;
      } else {
        i = 0;
      } 
      if (this.m.d()) {
        this.x.setWidth(i1);
        j = -i1;
        m = i;
      } else {
        j = 0;
        m = i;
      } 
    } 
    setPadding(m, n, j, k);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (!g())
      return false; 
    int i = paramMotionEvent.getAction();
    if (i == 3 || i == 1) {
      this.k = false;
      return false;
    } 
    if (i != 0 && this.k)
      return true; 
    SmoothScrollRunnable smoothScrollRunnable = this.B;
    if (smoothScrollRunnable != null && smoothScrollRunnable.b())
      return false; 
    if (i != 0) {
      if (i == 2) {
        if (!this.q && i())
          return true; 
        if (p()) {
          float f1;
          float f2;
          float f3 = paramMotionEvent.getY();
          float f4 = paramMotionEvent.getX();
          if (null.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            f1 = f3 - this.f;
            f2 = f4 - this.e;
          } else {
            f1 = f4 - this.e;
            f2 = f3 - this.f;
          } 
          float f5 = Math.abs(f1);
          if (f5 > this.d && (!this.r || f5 > Math.abs(f2)))
            if (this.m.c() && f1 >= 1.0F && d()) {
              this.f = f3;
              this.e = f4;
              this.k = true;
              if (this.m == Mode.d)
                this.n = Mode.b; 
            } else if (this.m.d() && f1 <= -1.0F && e()) {
              this.f = f3;
              this.e = f4;
              this.k = true;
              if (this.m == Mode.d)
                this.n = Mode.c; 
            }  
        } 
      } 
    } else if (p()) {
      float f = paramMotionEvent.getY();
      this.h = f;
      this.f = f;
      f = paramMotionEvent.getX();
      this.g = f;
      this.e = f;
      this.k = false;
      this.c = false;
      this.i = 0.0F;
      this.j = 0.0F;
    } 
    return this.k;
  }
  
  protected final void onRestoreInstanceState(Parcelable paramParcelable) {
    Bundle bundle;
    if (paramParcelable instanceof Bundle) {
      bundle = (Bundle)paramParcelable;
      setMode(Mode.a(bundle.getInt("ptr_mode", 0)));
      this.n = Mode.a(bundle.getInt("ptr_current_mode", 0));
      this.q = bundle.getBoolean("ptr_disable_scrolling", false);
      this.p = bundle.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
      State state = State.a(bundle.getInt("ptr_state", 0));
      if (state == State.d || state == State.e)
        a(state, new boolean[] { true }); 
      a(bundle);
      return;
    } 
    super.onRestoreInstanceState((Parcelable)bundle);
  }
  
  protected final Parcelable onSaveInstanceState() {
    Bundle bundle = new Bundle();
    b(bundle);
    bundle.putInt("ptr_state", this.l.a());
    bundle.putInt("ptr_mode", this.m.e());
    bundle.putInt("ptr_current_mode", this.n.e());
    bundle.putBoolean("ptr_disable_scrolling", this.q);
    bundle.putBoolean("ptr_show_refreshing_view", this.p);
    bundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return (Parcelable)bundle;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.G) {
      this.G = false;
      m();
      post(new Runnable(this) {
            public void run() {
              this.a.requestLayout();
            }
          });
    } 
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (!g())
      return false; 
    if (!this.q && i())
      return true; 
    if (paramMotionEvent.getAction() == 0 && paramMotionEvent.getEdgeFlags() != 0)
      return false; 
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3) {
            if (i != 5 && i != 6)
              return false; 
            if (this.k) {
              this.c = true;
              return false;
            } 
            return false;
          } 
        } else {
          if (this.k) {
            if (this.c) {
              a(paramMotionEvent);
              this.c = false;
            } 
            this.f = paramMotionEvent.getY() + this.j;
            this.e = paramMotionEvent.getX() + this.i;
            q();
            return true;
          } 
          return false;
        }  
      this.D = 0;
      if (this.k) {
        this.k = false;
        if (this.l == State.c && (this.y != null || this.z != null)) {
          a(State.d, new boolean[] { true });
          return true;
        } 
        if (i()) {
          i = null.b[this.n.ordinal()];
          if (i != 1 && i != 2) {
            a(-getHeaderSize());
            return true;
          } 
          a(getFooterSize());
          return true;
        } 
        a(State.a, new boolean[0]);
        return true;
      } 
    } else if (p()) {
      float f = paramMotionEvent.getY();
      this.h = f;
      this.f = f;
      f = paramMotionEvent.getX();
      this.g = f;
      this.e = f;
      this.c = false;
      this.i = 0.0F;
      this.j = 0.0F;
      return true;
    } 
    return false;
  }
  
  public void setDisableScrollingWhileRefreshing(boolean paramBoolean) {
    setScrollingWhileRefreshingEnabled(paramBoolean ^ true);
  }
  
  public final void setFilterTouchEvents(boolean paramBoolean) {
    this.r = paramBoolean;
  }
  
  protected final void setHeaderScroll(int paramInt) {
    int i = getMaximumPullScroll();
    paramInt = Math.min(i, Math.max(-i, paramInt));
    if (this.t)
      if (paramInt < 0) {
        this.w.setVisibility(0);
      } else if (paramInt > 0) {
        this.x.setVisibility(0);
      }  
    i = null.a[getPullToRefreshScrollDirection().ordinal()];
    if (i != 1) {
      if (i != 2)
        return; 
      scrollTo(0, paramInt);
      return;
    } 
    scrollTo(paramInt, 0);
  }
  
  public void setIfIgnoreFirstScroll(boolean paramBoolean) {
    this.F = paramBoolean;
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence) {
    getLoadingLayoutProxy().setLastUpdatedLabel(paramCharSequence);
  }
  
  public void setLoadingDrawable(Drawable paramDrawable) {
    getLoadingLayoutProxy().setLoadingDrawable(paramDrawable);
  }
  
  public void setLongClickable(boolean paramBoolean) {
    getRefreshableView().setLongClickable(paramBoolean);
  }
  
  public final void setMode(Mode paramMode) {
    if (paramMode != this.m) {
      this.m = paramMode;
      f();
    } 
  }
  
  public void setOnPullEventListener(OnPullEventListener<T> paramOnPullEventListener) {
    this.A = paramOnPullEventListener;
  }
  
  public final void setOnRefreshListener(OnRefreshListener2<T> paramOnRefreshListener2) {
    this.z = paramOnRefreshListener2;
    this.y = null;
  }
  
  public final void setOnRefreshListener(OnRefreshListener<T> paramOnRefreshListener) {
    this.y = paramOnRefreshListener;
    this.z = null;
  }
  
  public void setPullLabel(CharSequence paramCharSequence) {
    getLoadingLayoutProxy().setPullLabel(paramCharSequence);
  }
  
  public final void setPullToRefreshEnabled(boolean paramBoolean) {
    Mode mode;
    if (paramBoolean) {
      mode = Mode.a();
    } else {
      mode = Mode.a;
    } 
    setMode(mode);
  }
  
  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean) {
    this.s = paramBoolean;
  }
  
  public final void setRefreshing(boolean paramBoolean) {
    if (!i())
      a(State.e, new boolean[] { paramBoolean }); 
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence) {
    getLoadingLayoutProxy().setRefreshingLabel(paramCharSequence);
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence) {
    a(paramCharSequence, Mode.d);
  }
  
  public void setScrollAnimationInterpolator(Interpolator paramInterpolator) {
    this.u = paramInterpolator;
  }
  
  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean) {
    this.q = paramBoolean;
  }
  
  public final void setShowViewWhileRefreshing(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public enum AnimationStyle {
    a, b;
    
    static AnimationStyle a() {
      return a;
    }
    
    static AnimationStyle a(int param1Int) {
      return (param1Int != 1) ? a : b;
    }
    
    LoadingLayout a(Context param1Context, PullToRefreshBase.Mode param1Mode, PullToRefreshBase.Orientation param1Orientation, TypedArray param1TypedArray) {
      if (!TextUtils.isEmpty(PullToRefreshBase.n()))
        try {
          return Class.forName(PullToRefreshBase.n()).getConstructor(new Class[] { Context.class, PullToRefreshBase.Mode.class, PullToRefreshBase.Orientation.class, TypedArray.class }).newInstance(new Object[] { param1Context, param1Mode, param1Orientation, param1TypedArray });
        } catch (Exception exception) {
          exception.printStackTrace();
          return (LoadingLayout)((PullToRefreshBase.null.d[ordinal()] != 2) ? new RotateLoadingLayout(param1Context, param1Mode, param1Orientation, param1TypedArray) : new FlipLoadingLayout(param1Context, param1Mode, param1Orientation, param1TypedArray));
        }  
      String str = PullToRefreshHelper.e();
      if (TextUtils.isEmpty(str))
        return (LoadingLayout)((PullToRefreshBase.null.d[ordinal()] != 2) ? new RotateLoadingLayout(param1Context, param1Mode, param1Orientation, param1TypedArray) : new FlipLoadingLayout(param1Context, param1Mode, param1Orientation, param1TypedArray)); 
      try {
        return Class.forName(str).getConstructor(new Class[] { Context.class, PullToRefreshBase.Mode.class, PullToRefreshBase.Orientation.class, TypedArray.class }).newInstance(new Object[] { param1Context, param1Mode, param1Orientation, param1TypedArray });
      } catch (Exception exception) {
        exception.printStackTrace();
        return (LoadingLayout)((PullToRefreshBase.null.d[ordinal()] != 2) ? new RotateLoadingLayout(param1Context, param1Mode, param1Orientation, param1TypedArray) : new FlipLoadingLayout(param1Context, param1Mode, param1Orientation, param1TypedArray));
      } 
    }
  }
  
  public enum Mode {
    a(0),
    b(1),
    c(2),
    d(3),
    e(4);
    
    public static Mode f;
    
    public static Mode g;
    
    private int h;
    
    static {
      Mode mode1 = a;
      Mode mode2 = b;
      Mode mode3 = c;
      i = new Mode[] { mode1, mode2, mode3, d, e };
      f = mode2;
      g = mode3;
    }
    
    Mode(int param1Int1) {
      this.h = param1Int1;
    }
    
    static Mode a() {
      return b;
    }
    
    static Mode a(int param1Int) {
      for (Mode mode : values()) {
        if (param1Int == mode.e())
          return mode; 
      } 
      return a();
    }
    
    boolean b() {
      return (this != a && this != e);
    }
    
    public boolean c() {
      return (this == b || this == d);
    }
    
    public boolean d() {
      return (this == c || this == d || this == e);
    }
    
    int e() {
      return this.h;
    }
  }
  
  public static interface OnLastItemVisibleListener {
    void a();
  }
  
  public static interface OnPullEventListener<V extends View> {
    void a(PullToRefreshBase<V> param1PullToRefreshBase, PullToRefreshBase.State param1State, PullToRefreshBase.Mode param1Mode);
  }
  
  public static interface OnRefreshListener<V extends View> {
    void a(PullToRefreshBase<V> param1PullToRefreshBase);
  }
  
  public static interface OnRefreshListener2<V extends View> {
    void a(PullToRefreshBase<V> param1PullToRefreshBase);
    
    void b(PullToRefreshBase<V> param1PullToRefreshBase);
  }
  
  static interface OnSmoothScrollFinishedListener {
    void a();
  }
  
  public enum Orientation {
    a, b;
  }
  
  final class SmoothScrollRunnable implements Runnable {
    private final Interpolator b;
    
    private final int c;
    
    private final int d;
    
    private final long e;
    
    private PullToRefreshBase.OnSmoothScrollFinishedListener f;
    
    private boolean g = true;
    
    private long h = -1L;
    
    private int i = -1;
    
    public SmoothScrollRunnable(PullToRefreshBase this$0, int param1Int1, int param1Int2, long param1Long, PullToRefreshBase.OnSmoothScrollFinishedListener param1OnSmoothScrollFinishedListener) {
      this.d = param1Int1;
      this.c = param1Int2;
      this.b = PullToRefreshBase.b(this$0);
      this.e = param1Long;
      this.f = param1OnSmoothScrollFinishedListener;
    }
    
    public void a() {
      this.g = false;
      this.a.removeCallbacks(this);
    }
    
    public boolean b() {
      return this.g;
    }
    
    public void run() {
      if (this.h == -1L) {
        this.h = System.currentTimeMillis();
      } else {
        long l = Math.max(Math.min((System.currentTimeMillis() - this.h) * 1000L / this.e, 1000L), 0L);
        int i = Math.round((this.d - this.c) * this.b.getInterpolation((float)l / 1000.0F));
        this.i = this.d - i;
        this.a.setHeaderScroll(this.i);
      } 
      if (this.g && this.c != this.i) {
        ViewCompat.a((View)this.a, this);
        return;
      } 
      this.g = false;
      PullToRefreshBase.OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = this.f;
      if (onSmoothScrollFinishedListener != null)
        onSmoothScrollFinishedListener.a(); 
    }
  }
  
  public enum State {
    a(0),
    b(1),
    c(2),
    d(8),
    e(9),
    f(16);
    
    private int g;
    
    State(int param1Int1) {
      this.g = param1Int1;
    }
    
    static State a(int param1Int) {
      for (State state : values()) {
        if (param1Int == state.a())
          return state; 
      } 
      return a;
    }
    
    int a() {
      return this.g;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\pulltorefresh\PullToRefreshBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */