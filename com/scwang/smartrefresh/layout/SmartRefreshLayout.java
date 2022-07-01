package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.constant.DimensionStatus;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshContentWrapper;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.scwang.smartrefresh.layout.util.DelayedRunnable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.SmartUtil;
import com.scwang.smartrefresh.layout.util.ViscousFluidInterpolator;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SmartRefreshLayout extends ViewGroup implements NestedScrollingParent, RefreshLayout {
  protected static DefaultRefreshFooterCreator aH;
  
  protected static DefaultRefreshHeaderCreator aI;
  
  protected static DefaultRefreshInitializer aJ;
  
  protected boolean A;
  
  protected boolean B;
  
  protected boolean C;
  
  protected boolean D;
  
  protected boolean E;
  
  protected boolean F;
  
  protected boolean G;
  
  protected boolean H;
  
  protected boolean I;
  
  protected boolean J;
  
  protected boolean K;
  
  protected boolean L;
  
  protected boolean M;
  
  protected boolean N;
  
  protected boolean O;
  
  protected boolean P;
  
  protected boolean Q;
  
  protected boolean R;
  
  protected boolean S;
  
  protected boolean T;
  
  protected boolean U;
  
  protected boolean V;
  
  protected OnRefreshListener W;
  
  protected int a;
  
  protected RefreshState aA;
  
  protected long aB;
  
  protected int aC;
  
  protected int aD;
  
  protected boolean aE;
  
  protected boolean aF;
  
  protected boolean aG;
  
  protected boolean aK;
  
  protected MotionEvent aL;
  
  protected Runnable aM;
  
  protected ValueAnimator aN;
  
  protected OnLoadMoreListener aa;
  
  protected OnMultiPurposeListener ab;
  
  protected ScrollBoundaryDecider ac;
  
  protected int ad;
  
  protected boolean ae;
  
  protected int[] af;
  
  protected NestedScrollingChildHelper ag;
  
  protected NestedScrollingParentHelper ah;
  
  protected int ai;
  
  protected DimensionStatus aj;
  
  protected int ak;
  
  protected DimensionStatus al;
  
  protected int am;
  
  protected int an;
  
  protected float ao;
  
  protected float ap;
  
  protected float aq;
  
  protected float ar;
  
  protected RefreshInternal as;
  
  protected RefreshInternal at;
  
  protected RefreshContent au;
  
  protected Paint av;
  
  protected Handler aw;
  
  protected RefreshKernel ax;
  
  protected List<DelayedRunnable> ay;
  
  protected RefreshState az;
  
  protected int b;
  
  protected int c;
  
  protected int d;
  
  protected int e;
  
  protected int f;
  
  protected int g;
  
  protected float h;
  
  protected float i;
  
  protected float j;
  
  protected float k;
  
  protected float l;
  
  protected char m;
  
  protected boolean n;
  
  protected boolean o;
  
  protected int p;
  
  protected int q;
  
  protected int r;
  
  protected int s;
  
  protected int t;
  
  protected int u;
  
  protected int v;
  
  protected Scroller w;
  
  protected VelocityTracker x;
  
  protected Interpolator y;
  
  protected int[] z;
  
  public SmartRefreshLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SmartRefreshLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SmartRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    DimensionStatus dimensionStatus;
    boolean bool;
    this.e = 250;
    this.f = 250;
    this.l = 0.5F;
    this.m = 'n';
    this.p = -1;
    this.q = -1;
    this.r = -1;
    this.s = -1;
    this.A = true;
    this.B = false;
    this.C = true;
    this.D = true;
    this.E = true;
    this.F = true;
    this.G = false;
    this.H = true;
    this.I = true;
    this.J = false;
    this.K = true;
    this.L = false;
    this.M = true;
    this.N = true;
    this.O = true;
    this.P = false;
    this.Q = false;
    this.R = false;
    this.S = false;
    this.T = false;
    this.U = false;
    this.V = false;
    this.af = new int[2];
    this.ag = new NestedScrollingChildHelper((View)this);
    this.ah = new NestedScrollingParentHelper(this);
    this.aj = DimensionStatus.a;
    this.al = DimensionStatus.a;
    this.ao = 2.5F;
    this.ap = 2.5F;
    this.aq = 1.0F;
    this.ar = 1.0F;
    this.ax = new RefreshKernelImpl(this);
    this.az = RefreshState.a;
    this.aA = RefreshState.a;
    this.aB = 0L;
    this.aC = 0;
    this.aD = 0;
    this.aG = false;
    this.aK = false;
    this.aL = null;
    setClipToPadding(false);
    DensityUtil densityUtil = new DensityUtil();
    ViewConfiguration viewConfiguration = ViewConfiguration.get(paramContext);
    this.w = new Scroller(paramContext);
    this.x = VelocityTracker.obtain();
    this.g = (paramContext.getResources().getDisplayMetrics()).heightPixels;
    this.y = (Interpolator)new ViscousFluidInterpolator();
    this.a = viewConfiguration.getScaledTouchSlop();
    this.t = viewConfiguration.getScaledMinimumFlingVelocity();
    this.u = viewConfiguration.getScaledMaximumFlingVelocity();
    this.ak = densityUtil.b(60.0F);
    this.ai = densityUtil.b(100.0F);
    DefaultRefreshInitializer defaultRefreshInitializer = aJ;
    if (defaultRefreshInitializer != null)
      defaultRefreshInitializer.a(paramContext, this); 
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SmartRefreshLayout);
    this.ag.setNestedScrollingEnabled(typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.ag.isNestedScrollingEnabled()));
    this.l = typedArray.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.l);
    this.ao = typedArray.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.ao);
    this.ap = typedArray.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.ap);
    this.aq = typedArray.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.aq);
    this.ar = typedArray.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.ar);
    this.A = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.A);
    this.f = typedArray.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f);
    this.B = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.B);
    this.ai = typedArray.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.ai);
    this.ak = typedArray.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.ak);
    this.am = typedArray.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.am);
    this.an = typedArray.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.an);
    this.P = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.P);
    this.Q = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.Q);
    this.E = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.E);
    this.F = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.F);
    this.H = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.H);
    this.K = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.K);
    this.I = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.I);
    this.L = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.L);
    this.M = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.M);
    this.N = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.N);
    this.O = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.O);
    this.G = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.G);
    this.C = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.C);
    this.D = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.D);
    this.J = typedArray.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.J);
    this.p = typedArray.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.p);
    this.q = typedArray.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.q);
    this.r = typedArray.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.r);
    this.s = typedArray.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.s);
    if (this.L && !typedArray.hasValue(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag))
      this.J = true; 
    if (this.S || typedArray.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore)) {
      bool = true;
    } else {
      bool = false;
    } 
    this.S = bool;
    if (this.U || typedArray.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent)) {
      bool = true;
    } else {
      bool = false;
    } 
    this.U = bool;
    if (this.V || typedArray.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent)) {
      bool = true;
    } else {
      bool = false;
    } 
    this.V = bool;
    if (this.T || typedArray.hasValue(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling)) {
      bool = true;
    } else {
      bool = false;
    } 
    this.T = bool;
    if (typedArray.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight)) {
      dimensionStatus = DimensionStatus.g;
    } else {
      dimensionStatus = this.aj;
    } 
    this.aj = dimensionStatus;
    if (typedArray.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight)) {
      dimensionStatus = DimensionStatus.g;
    } else {
      dimensionStatus = this.al;
    } 
    this.al = dimensionStatus;
    paramInt = typedArray.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
    int i = typedArray.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
    if (i != 0) {
      if (paramInt != 0) {
        this.z = new int[] { i, paramInt };
      } else {
        this.z = new int[] { i };
      } 
    } else if (paramInt != 0) {
      this.z = new int[] { 0, paramInt };
    } 
    typedArray.recycle();
  }
  
  public static void setDefaultRefreshFooterCreator(DefaultRefreshFooterCreator paramDefaultRefreshFooterCreator) {
    aH = paramDefaultRefreshFooterCreator;
  }
  
  public static void setDefaultRefreshHeaderCreator(DefaultRefreshHeaderCreator paramDefaultRefreshHeaderCreator) {
    aI = paramDefaultRefreshHeaderCreator;
  }
  
  public static void setDefaultRefreshInitializer(DefaultRefreshInitializer paramDefaultRefreshInitializer) {
    aJ = paramDefaultRefreshInitializer;
  }
  
  protected ValueAnimator a(int paramInt1, int paramInt2, Interpolator paramInterpolator, int paramInt3) {
    if (this.b != paramInt1) {
      ValueAnimator valueAnimator = this.aN;
      if (valueAnimator != null)
        valueAnimator.cancel(); 
      this.aM = null;
      this.aN = ValueAnimator.ofInt(new int[] { this.b, paramInt1 });
      this.aN.setDuration(paramInt3);
      this.aN.setInterpolator((TimeInterpolator)paramInterpolator);
      this.aN.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
            public void onAnimationCancel(Animator param1Animator) {
              super.onAnimationEnd(param1Animator);
            }
            
            public void onAnimationEnd(Animator param1Animator) {
              SmartRefreshLayout smartRefreshLayout = this.a;
              smartRefreshLayout.aN = null;
              if (smartRefreshLayout.b == 0) {
                if (this.a.az != RefreshState.a && !this.a.az.v) {
                  this.a.a(RefreshState.a);
                  return;
                } 
              } else if (this.a.az != this.a.aA) {
                smartRefreshLayout = this.a;
                smartRefreshLayout.setViceState(smartRefreshLayout.az);
              } 
            }
          });
      this.aN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.ax.a(((Integer)param1ValueAnimator.getAnimatedValue()).intValue(), false);
            }
          });
      this.aN.setStartDelay(paramInt2);
      this.aN.start();
      return this.aN;
    } 
    return null;
  }
  
  public LayoutParams a(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    return new LayoutParams(paramLayoutParams);
  }
  
  public SmartRefreshLayout a(int paramInt, boolean paramBoolean) {
    long l;
    if (this.az == RefreshState.l && paramBoolean)
      f(false); 
    Runnable runnable = new Runnable(this, paramBoolean) {
        public void run() {
          if (this.b.az == RefreshState.l && this.b.as != null && this.b.au != null) {
            this.b.a(RefreshState.o);
            int i = this.b.as.a(this.b, this.a);
            if (this.b.ab != null && this.b.as instanceof RefreshHeader)
              this.b.ab.a((RefreshHeader)this.b.as, this.a); 
            if (i < Integer.MAX_VALUE) {
              if (this.b.n || this.b.ae) {
                if (this.b.n) {
                  SmartRefreshLayout smartRefreshLayout1 = this.b;
                  smartRefreshLayout1.i = smartRefreshLayout1.k;
                  smartRefreshLayout1 = this.b;
                  smartRefreshLayout1.d = 0;
                  smartRefreshLayout1.n = false;
                } 
                long l = System.currentTimeMillis();
                SmartRefreshLayout smartRefreshLayout = this.b;
                SmartRefreshLayout.a(smartRefreshLayout, MotionEvent.obtain(l, l, 0, smartRefreshLayout.j, this.b.k + this.b.b - (this.b.a * 2), 0));
                smartRefreshLayout = this.b;
                SmartRefreshLayout.b(smartRefreshLayout, MotionEvent.obtain(l, l, 2, smartRefreshLayout.j, this.b.k + this.b.b, 0));
                if (this.b.ae)
                  this.b.ad = 0; 
              } 
              if (this.b.b > 0) {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                SmartRefreshLayout smartRefreshLayout = this.b;
                ValueAnimator valueAnimator = smartRefreshLayout.a(0, i, smartRefreshLayout.y, this.b.f);
                if (this.b.N)
                  animatorUpdateListener = this.b.au.a(this.b.b); 
                if (valueAnimator != null && animatorUpdateListener != null) {
                  valueAnimator.addUpdateListener(animatorUpdateListener);
                  return;
                } 
              } else {
                if (this.b.b < 0) {
                  SmartRefreshLayout smartRefreshLayout = this.b;
                  smartRefreshLayout.a(0, i, smartRefreshLayout.y, this.b.f);
                  return;
                } 
                this.b.ax.a(0, false);
                this.b.d();
              } 
            } 
          } 
        }
      };
    if (paramInt <= 0) {
      l = 1L;
    } else {
      l = paramInt;
    } 
    postDelayed(runnable, l);
    return this;
  }
  
  public SmartRefreshLayout a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    long l;
    Runnable runnable = new Runnable(this, paramBoolean1, paramBoolean2) {
        public void run() {
          RefreshState refreshState1 = this.c.az;
          RefreshState refreshState2 = RefreshState.m;
          int i = 1;
          if (refreshState1 == refreshState2 && this.c.at != null && this.c.au != null) {
            this.c.a(RefreshState.p);
            int j = this.c.at.a(this.c, this.a);
            if (this.c.ab != null && this.c.at instanceof RefreshFooter)
              this.c.ab.a((RefreshFooter)this.c.at, this.a); 
            if (j < Integer.MAX_VALUE) {
              long l;
              if (!this.b || !this.c.G || this.c.b >= 0 || !this.c.au.d())
                i = 0; 
              int k = this.c.b;
              if (i) {
                i = Math.max(this.c.b, -this.c.ak);
              } else {
                i = 0;
              } 
              i = k - i;
              if (this.c.n || this.c.ae) {
                if (this.c.n) {
                  SmartRefreshLayout smartRefreshLayout2 = this.c;
                  smartRefreshLayout2.i = smartRefreshLayout2.k;
                  smartRefreshLayout2 = this.c;
                  smartRefreshLayout2.n = false;
                  smartRefreshLayout2.d = smartRefreshLayout2.b - i;
                } 
                l = System.currentTimeMillis();
                SmartRefreshLayout smartRefreshLayout1 = this.c;
                float f1 = smartRefreshLayout1.j;
                float f2 = this.c.k;
                float f3 = i;
                SmartRefreshLayout.c(smartRefreshLayout1, MotionEvent.obtain(l, l, 0, f1, f2 + f3 + (this.c.a * 2), 0));
                smartRefreshLayout1 = this.c;
                SmartRefreshLayout.d(smartRefreshLayout1, MotionEvent.obtain(l, l, 2, smartRefreshLayout1.j, this.c.k + f3, 0));
                if (this.c.ae)
                  this.c.ad = 0; 
              } 
              SmartRefreshLayout smartRefreshLayout = this.c;
              Runnable runnable = new Runnable(this, i) {
                  public void run() {
                    ValueAnimator.AnimatorUpdateListener animatorUpdateListener;
                    ValueAnimator valueAnimator;
                    if (this.b.c.M && this.a < 0) {
                      animatorUpdateListener = this.b.c.au.a(this.b.c.b);
                    } else {
                      animatorUpdateListener = null;
                    } 
                    if (animatorUpdateListener != null)
                      animatorUpdateListener.onAnimationUpdate(ValueAnimator.ofInt(new int[] { 0, 0 })); 
                    AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this) {
                        public void onAnimationCancel(Animator param3Animator) {
                          super.onAnimationEnd(param3Animator);
                        }
                        
                        public void onAnimationEnd(Animator param3Animator) {
                          this.a.b.c.aG = false;
                          if (this.a.b.b)
                            this.a.b.c.f(true); 
                          if (this.a.b.c.az == RefreshState.p)
                            this.a.b.c.a(RefreshState.a); 
                        }
                      };
                    if (this.b.c.b > 0) {
                      valueAnimator = this.b.c.ax.a(0);
                    } else {
                      if (valueAnimator != null || this.b.c.b == 0) {
                        if (this.b.c.aN != null) {
                          this.b.c.aN.cancel();
                          this.b.c.aN = null;
                        } 
                        this.b.c.ax.a(0, false);
                        this.b.c.d();
                      } else if (this.b.b && this.b.c.G) {
                        if (this.b.c.b >= -this.b.c.ak) {
                          this.b.c.a(RefreshState.a);
                        } else {
                          valueAnimator = this.b.c.ax.a(-this.b.c.ak);
                          if (valueAnimator != null) {
                            valueAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter);
                            return;
                          } 
                        } 
                      } else {
                        valueAnimator = this.b.c.ax.a(0);
                        if (valueAnimator != null) {
                          valueAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter);
                          return;
                        } 
                      } 
                      valueAnimator = null;
                    } 
                    if (valueAnimator != null) {
                      valueAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter);
                      return;
                    } 
                  }
                };
              if (this.c.b < 0) {
                l = j;
              } else {
                l = 0L;
              } 
              smartRefreshLayout.postDelayed(runnable, l);
              return;
            } 
          } else if (this.b) {
            this.c.f(true);
          } 
        }
      };
    if (paramInt <= 0) {
      l = 1L;
    } else {
      l = paramInt;
    } 
    postDelayed(runnable, l);
    return this;
  }
  
  public SmartRefreshLayout a(RefreshFooter paramRefreshFooter) {
    return a(paramRefreshFooter, -1, -2);
  }
  
  public SmartRefreshLayout a(RefreshFooter paramRefreshFooter, int paramInt1, int paramInt2) {
    boolean bool;
    RefreshInternal refreshInternal = this.at;
    if (refreshInternal != null)
      removeView(refreshInternal.getView()); 
    this.at = (RefreshInternal)paramRefreshFooter;
    this.aD = 0;
    this.aF = false;
    this.al = this.al.a();
    if (!this.S || this.B) {
      bool = true;
    } else {
      bool = false;
    } 
    this.B = bool;
    if (this.at.getSpinnerStyle() == SpinnerStyle.c) {
      addView(this.at.getView(), 0, (ViewGroup.LayoutParams)new LayoutParams(paramInt1, paramInt2));
      return this;
    } 
    addView(this.at.getView(), paramInt1, paramInt2);
    return this;
  }
  
  public SmartRefreshLayout a(RefreshHeader paramRefreshHeader) {
    return a(paramRefreshHeader, -1, -2);
  }
  
  public SmartRefreshLayout a(RefreshHeader paramRefreshHeader, int paramInt1, int paramInt2) {
    RefreshInternal refreshInternal = this.as;
    if (refreshInternal != null)
      removeView(refreshInternal.getView()); 
    this.as = (RefreshInternal)paramRefreshHeader;
    this.aC = 0;
    this.aE = false;
    this.aj = this.aj.a();
    if (paramRefreshHeader.getSpinnerStyle() == SpinnerStyle.c) {
      addView(this.as.getView(), 0, (ViewGroup.LayoutParams)new LayoutParams(paramInt1, paramInt2));
      return this;
    } 
    addView(this.as.getView(), paramInt1, paramInt2);
    return this;
  }
  
  public SmartRefreshLayout a(OnLoadMoreListener paramOnLoadMoreListener) {
    this.aa = paramOnLoadMoreListener;
    if (this.B || (!this.S && paramOnLoadMoreListener != null)) {
      boolean bool1 = true;
      this.B = bool1;
      return this;
    } 
    boolean bool = false;
    this.B = bool;
    return this;
  }
  
  public SmartRefreshLayout a(OnMultiPurposeListener paramOnMultiPurposeListener) {
    this.ab = paramOnMultiPurposeListener;
    return this;
  }
  
  public SmartRefreshLayout a(OnRefreshListener paramOnRefreshListener) {
    this.W = paramOnRefreshListener;
    return this;
  }
  
  public SmartRefreshLayout a(OnRefreshLoadMoreListener paramOnRefreshLoadMoreListener) {
    this.W = (OnRefreshListener)paramOnRefreshLoadMoreListener;
    this.aa = (OnLoadMoreListener)paramOnRefreshLoadMoreListener;
    if (this.B || (!this.S && paramOnRefreshLoadMoreListener != null)) {
      boolean bool1 = true;
      this.B = bool1;
      return this;
    } 
    boolean bool = false;
    this.B = bool;
    return this;
  }
  
  public SmartRefreshLayout a(int... paramVarArgs) {
    RefreshInternal refreshInternal = this.as;
    if (refreshInternal != null)
      refreshInternal.setPrimaryColors(paramVarArgs); 
    refreshInternal = this.at;
    if (refreshInternal != null)
      refreshInternal.setPrimaryColors(paramVarArgs); 
    this.z = paramVarArgs;
    return this;
  }
  
  protected void a() {
    if (this.az != RefreshState.m) {
      this.aB = System.currentTimeMillis();
      this.aG = true;
      a(RefreshState.m);
      OnLoadMoreListener onLoadMoreListener = this.aa;
      if (onLoadMoreListener != null) {
        onLoadMoreListener.a(this);
      } else if (this.ab == null) {
        c(2000);
      } 
      RefreshInternal refreshInternal = this.at;
      if (refreshInternal != null) {
        int i = this.ak;
        refreshInternal.b(this, i, (int)(this.ap * i));
      } 
      OnMultiPurposeListener onMultiPurposeListener = this.ab;
      if (onMultiPurposeListener != null && this.at instanceof RefreshFooter) {
        onMultiPurposeListener.a(this);
        onMultiPurposeListener = this.ab;
        RefreshFooter refreshFooter = (RefreshFooter)this.at;
        int i = this.ak;
        onMultiPurposeListener.b(refreshFooter, i, (int)(this.ap * i));
      } 
    } 
  }
  
  protected void a(float paramFloat) {
    if (this.aN == null) {
      if (paramFloat > 0.0F && (this.az == RefreshState.l || this.az == RefreshState.n)) {
        this.aM = new BounceRunnable(this, paramFloat, this.ai);
        return;
      } 
      if (paramFloat < 0.0F && (this.az == RefreshState.m || (this.G && this.R && a(this.B)) || (this.K && !this.R && a(this.B) && this.az != RefreshState.l))) {
        this.aM = new BounceRunnable(this, paramFloat, -this.ak);
        return;
      } 
      if (this.b == 0 && this.I)
        this.aM = new BounceRunnable(this, paramFloat, 0); 
    } 
  }
  
  protected void a(RefreshState paramRefreshState) {
    RefreshState refreshState = this.az;
    if (refreshState != paramRefreshState) {
      this.az = paramRefreshState;
      this.aA = paramRefreshState;
      RefreshInternal refreshInternal1 = this.as;
      RefreshInternal refreshInternal2 = this.at;
      OnMultiPurposeListener onMultiPurposeListener = this.ab;
      if (refreshInternal1 != null)
        refreshInternal1.a(this, refreshState, paramRefreshState); 
      if (refreshInternal2 != null)
        refreshInternal2.a(this, refreshState, paramRefreshState); 
      if (onMultiPurposeListener != null)
        onMultiPurposeListener.a(this, refreshState, paramRefreshState); 
    } 
  }
  
  protected boolean a(int paramInt) {
    if (paramInt == 0) {
      if (this.aN != null)
        if (!this.az.w) {
          if (this.az == RefreshState.i)
            return true; 
          if (this.az == RefreshState.d) {
            this.ax.a(RefreshState.b);
          } else if (this.az == RefreshState.e) {
            this.ax.a(RefreshState.c);
          } 
          this.aN.cancel();
          this.aN = null;
        } else {
          return true;
        }  
      this.aM = null;
    } 
    return (this.aN != null);
  }
  
  public boolean a(int paramInt1, int paramInt2, float paramFloat) {
    if (this.az == RefreshState.a && a(this.A)) {
      ValueAnimator valueAnimator = this.aN;
      if (valueAnimator != null)
        valueAnimator.cancel(); 
      Runnable runnable = new Runnable(this, paramFloat, paramInt2) {
          public void run() {
            SmartRefreshLayout smartRefreshLayout = this.c;
            smartRefreshLayout.aN = ValueAnimator.ofInt(new int[] { smartRefreshLayout.b, (int)(this.c.ai * this.a) });
            this.c.aN.setDuration(this.b);
            this.c.aN.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
            this.c.aN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
                  public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                    this.a.c.ax.a(((Integer)param2ValueAnimator.getAnimatedValue()).intValue(), true);
                  }
                });
            this.c.aN.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
                  public void onAnimationEnd(Animator param2Animator) {
                    this.a.c.aN = null;
                    if (this.a.c.az != RefreshState.f)
                      this.a.c.ax.a(RefreshState.f); 
                    this.a.c.e();
                  }
                  
                  public void onAnimationStart(Animator param2Animator) {
                    SmartRefreshLayout smartRefreshLayout = this.a.c;
                    this.a.c.j = (smartRefreshLayout.getMeasuredWidth() / 2);
                    this.a.c.ax.a(RefreshState.b);
                  }
                });
            this.c.aN.start();
          }
        };
      if (paramInt1 > 0) {
        this.aN = new ValueAnimator();
        postDelayed(runnable, paramInt1);
      } else {
        runnable.run();
      } 
      return true;
    } 
    return false;
  }
  
  protected boolean a(Float paramFloat) {
    float f;
    if (paramFloat == null) {
      f = this.v;
    } else {
      f = paramFloat.floatValue();
    } 
    if (Math.abs(f) > this.t) {
      if (this.b * f < 0.0F)
        if (this.az.v) {
          if (this.az != RefreshState.n && this.az != this.aA) {
            this.aM = (new FlingRunnable(this, f)).a();
            return true;
          } 
        } else {
          int i = this.b;
          if (i > this.ai * this.aq || -i > this.ak * this.ar)
            return true; 
        }  
      if ((f < 0.0F && ((this.I && (this.J || a(this.B))) || (this.az == RefreshState.m && this.b >= 0) || (this.K && a(this.B)))) || (f > 0.0F && ((this.I && (this.J || a(this.A))) || (this.az == RefreshState.l && this.b <= 0)))) {
        this.aK = false;
        this.w.fling(0, 0, 0, (int)-f, 0, 0, -2147483647, 2147483647);
        this.w.computeScrollOffset();
        invalidate();
      } 
    } 
    return false;
  }
  
  protected boolean a(boolean paramBoolean) {
    return (paramBoolean && !this.L);
  }
  
  protected boolean a(boolean paramBoolean, RefreshInternal paramRefreshInternal) {
    return (paramBoolean || this.L || paramRefreshInternal == null || paramRefreshInternal.getSpinnerStyle() == SpinnerStyle.c);
  }
  
  public SmartRefreshLayout b(int paramInt) {
    return a(paramInt, true);
  }
  
  public SmartRefreshLayout b(boolean paramBoolean) {
    this.S = true;
    this.B = paramBoolean;
    return this;
  }
  
  public SmartRefreshLayout b(int... paramVarArgs) {
    int[] arrayOfInt = new int[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++)
      arrayOfInt[i] = SmartUtil.a(getContext(), paramVarArgs[i]); 
    a(arrayOfInt);
    return this;
  }
  
  protected void b() {
    AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this) {
        public void onAnimationEnd(Animator param1Animator) {
          this.a.a();
        }
      };
    a(RefreshState.k);
    ValueAnimator valueAnimator = this.ax.a(-this.ak);
    if (valueAnimator != null)
      valueAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter); 
    RefreshInternal refreshInternal = this.at;
    if (refreshInternal != null) {
      int i = this.ak;
      refreshInternal.a(this, i, (int)(this.ap * i));
    } 
    OnMultiPurposeListener onMultiPurposeListener = this.ab;
    if (onMultiPurposeListener != null) {
      RefreshInternal refreshInternal1 = this.at;
      if (refreshInternal1 instanceof RefreshFooter) {
        RefreshFooter refreshFooter = (RefreshFooter)refreshInternal1;
        int i = this.ak;
        onMultiPurposeListener.a(refreshFooter, i, (int)(this.ap * i));
      } 
    } 
    if (valueAnimator == null)
      animatorListenerAdapter.onAnimationEnd(null); 
  }
  
  protected void b(float paramFloat) {
    if (this.az == RefreshState.n && paramFloat > 0.0F) {
      this.ax.a(Math.min((int)paramFloat, getMeasuredHeight()), true);
    } else if (this.az == RefreshState.l && paramFloat >= 0.0F) {
      int i = this.ai;
      if (paramFloat < i) {
        this.ax.a((int)paramFloat, true);
      } else {
        double d3 = ((this.ao - 1.0F) * i);
        i = Math.max(this.g * 4 / 3, getHeight());
        int j = this.ai;
        double d2 = (i - j);
        double d4 = Math.max(0.0F, (paramFloat - j) * this.l);
        double d5 = -d4;
        double d1 = d2;
        if (d2 == 0.0D)
          d1 = 1.0D; 
        d1 = Math.min(d3 * (1.0D - Math.pow(100.0D, d5 / d1)), d4);
        this.ax.a((int)d1 + this.ai, true);
      } 
    } else if (paramFloat < 0.0F && (this.az == RefreshState.m || (this.G && this.R && a(this.B)) || (this.K && !this.R && a(this.B)))) {
      int i = this.ak;
      if (paramFloat > -i) {
        this.ax.a((int)paramFloat, true);
      } else {
        double d3 = ((this.ap - 1.0F) * i);
        i = Math.max(this.g * 4 / 3, getHeight());
        int j = this.ak;
        double d2 = (i - j);
        double d4 = -Math.min(0.0F, (j + paramFloat) * this.l);
        double d5 = -d4;
        double d1 = d2;
        if (d2 == 0.0D)
          d1 = 1.0D; 
        d1 = -Math.min(d3 * (1.0D - Math.pow(100.0D, d5 / d1)), d4);
        this.ax.a((int)d1 - this.ak, true);
      } 
    } else if (paramFloat >= 0.0F) {
      double d3 = (this.ao * this.ai);
      double d2 = Math.max(this.g / 2, getHeight());
      double d4 = Math.max(0.0F, this.l * paramFloat);
      double d5 = -d4;
      double d1 = d2;
      if (d2 == 0.0D)
        d1 = 1.0D; 
      d1 = Math.min(d3 * (1.0D - Math.pow(100.0D, d5 / d1)), d4);
      this.ax.a((int)d1, true);
    } else {
      double d3 = (this.ap * this.ak);
      double d2 = Math.max(this.g / 2, getHeight());
      double d4 = -Math.min(0.0F, this.l * paramFloat);
      double d5 = -d4;
      double d1 = d2;
      if (d2 == 0.0D)
        d1 = 1.0D; 
      d1 = -Math.min(d3 * (1.0D - Math.pow(100.0D, d5 / d1)), d4);
      this.ax.a((int)d1, true);
    } 
    if (this.K && !this.R && a(this.B) && paramFloat < 0.0F && this.az != RefreshState.l && this.az != RefreshState.m && this.az != RefreshState.p) {
      a();
      if (this.Q) {
        this.aM = null;
        this.ax.a(-this.ak);
      } 
    } 
  }
  
  public SmartRefreshLayout c(float paramFloat) {
    if (this.al.a(DimensionStatus.j)) {
      this.ak = DensityUtil.a(paramFloat);
      this.al = DimensionStatus.i;
      RefreshInternal refreshInternal = this.at;
      if (refreshInternal != null)
        refreshInternal.getView().requestLayout(); 
    } 
    return this;
  }
  
  public SmartRefreshLayout c(int paramInt) {
    return a(paramInt, true, false);
  }
  
  public SmartRefreshLayout c(boolean paramBoolean) {
    this.A = paramBoolean;
    return this;
  }
  
  protected void c() {
    AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this) {
        public void onAnimationEnd(Animator param1Animator) {
          this.a.aB = System.currentTimeMillis();
          this.a.a(RefreshState.l);
          if (this.a.W != null) {
            this.a.W.onRefresh(this.a);
          } else if (this.a.ab == null) {
            this.a.b(3000);
          } 
          if (this.a.as != null) {
            RefreshInternal refreshInternal = this.a.as;
            SmartRefreshLayout smartRefreshLayout = this.a;
            refreshInternal.b(smartRefreshLayout, smartRefreshLayout.ai, (int)(this.a.ao * this.a.ai));
          } 
          if (this.a.ab != null && this.a.as instanceof RefreshHeader) {
            this.a.ab.onRefresh(this.a);
            this.a.ab.b((RefreshHeader)this.a.as, this.a.ai, (int)(this.a.ao * this.a.ai));
          } 
        }
      };
    a(RefreshState.j);
    ValueAnimator valueAnimator = this.ax.a(this.ai);
    if (valueAnimator != null)
      valueAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter); 
    RefreshInternal refreshInternal = this.as;
    if (refreshInternal != null) {
      int i = this.ai;
      refreshInternal.a(this, i, (int)(this.ao * i));
    } 
    OnMultiPurposeListener onMultiPurposeListener = this.ab;
    if (onMultiPurposeListener != null) {
      RefreshInternal refreshInternal1 = this.as;
      if (refreshInternal1 instanceof RefreshHeader) {
        RefreshHeader refreshHeader = (RefreshHeader)refreshInternal1;
        int i = this.ai;
        onMultiPurposeListener.a(refreshHeader, i, (int)(this.ao * i));
      } 
    } 
    if (valueAnimator == null)
      animatorListenerAdapter.onAnimationEnd(null); 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void computeScroll() {
    this.w.getCurrY();
    if (this.w.computeScrollOffset()) {
      int i = this.w.getFinalY();
      if ((i < 0 && (this.J || a(this.A)) && this.au.c()) || (i > 0 && (this.J || a(this.B)) && this.au.d())) {
        if (this.aK) {
          float f;
          if (Build.VERSION.SDK_INT >= 14) {
            if (i > 0) {
              f = -this.w.getCurrVelocity();
            } else {
              f = this.w.getCurrVelocity();
            } 
          } else {
            f = (this.w.getCurrY() - i) * 1.0F / Math.max(this.w.getDuration() - this.w.timePassed(), 1);
          } 
          a(f);
        } 
        this.w.forceFinished(true);
        return;
      } 
      this.aK = true;
      invalidate();
    } 
  }
  
  public SmartRefreshLayout d(float paramFloat) {
    this.ao = paramFloat;
    RefreshInternal refreshInternal = this.as;
    if (refreshInternal != null && this.aw != null) {
      RefreshKernel refreshKernel = this.ax;
      int i = this.ai;
      refreshInternal.a(refreshKernel, i, (int)(this.ao * i));
      return this;
    } 
    this.aj = this.aj.a();
    return this;
  }
  
  public SmartRefreshLayout d(boolean paramBoolean) {
    this.K = paramBoolean;
    return this;
  }
  
  protected void d() {
    if (this.az != RefreshState.a && this.b == 0)
      a(RefreshState.a); 
    if (this.b != 0)
      this.ax.a(0); 
  }
  
  public boolean d(int paramInt) {
    int k = this.f;
    float f1 = this.ao / 2.0F;
    int j = this.ai;
    float f2 = j;
    int i = j;
    if (j == 0)
      i = 1; 
    return a(paramInt, k, (f1 + 0.5F) * f2 * 1.0F / i);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getActionMasked : ()I
    //   4: istore #11
    //   6: iconst_1
    //   7: istore #9
    //   9: iload #11
    //   11: bipush #6
    //   13: if_icmpne -> 22
    //   16: iconst_1
    //   17: istore #6
    //   19: goto -> 25
    //   22: iconst_0
    //   23: istore #6
    //   25: iload #6
    //   27: ifeq -> 39
    //   30: aload_1
    //   31: invokevirtual getActionIndex : ()I
    //   34: istore #7
    //   36: goto -> 42
    //   39: iconst_m1
    //   40: istore #7
    //   42: aload_1
    //   43: invokevirtual getPointerCount : ()I
    //   46: istore #10
    //   48: iconst_0
    //   49: istore #8
    //   51: fconst_0
    //   52: fstore_3
    //   53: fconst_0
    //   54: fstore_2
    //   55: iload #8
    //   57: iload #10
    //   59: if_icmpge -> 99
    //   62: iload #7
    //   64: iload #8
    //   66: if_icmpne -> 72
    //   69: goto -> 90
    //   72: fload_3
    //   73: aload_1
    //   74: iload #8
    //   76: invokevirtual getX : (I)F
    //   79: fadd
    //   80: fstore_3
    //   81: fload_2
    //   82: aload_1
    //   83: iload #8
    //   85: invokevirtual getY : (I)F
    //   88: fadd
    //   89: fstore_2
    //   90: iload #8
    //   92: iconst_1
    //   93: iadd
    //   94: istore #8
    //   96: goto -> 55
    //   99: iload #10
    //   101: istore #7
    //   103: iload #6
    //   105: ifeq -> 114
    //   108: iload #10
    //   110: iconst_1
    //   111: isub
    //   112: istore #7
    //   114: iload #7
    //   116: i2f
    //   117: fstore #4
    //   119: fload_3
    //   120: fload #4
    //   122: fdiv
    //   123: fstore_3
    //   124: fload_2
    //   125: fload #4
    //   127: fdiv
    //   128: fstore #4
    //   130: iload #11
    //   132: bipush #6
    //   134: if_icmpeq -> 143
    //   137: iload #11
    //   139: iconst_5
    //   140: if_icmpne -> 166
    //   143: aload_0
    //   144: getfield n : Z
    //   147: ifeq -> 166
    //   150: aload_0
    //   151: aload_0
    //   152: getfield i : F
    //   155: fload #4
    //   157: aload_0
    //   158: getfield k : F
    //   161: fsub
    //   162: fadd
    //   163: putfield i : F
    //   166: aload_0
    //   167: fload_3
    //   168: putfield j : F
    //   171: aload_0
    //   172: fload #4
    //   174: putfield k : F
    //   177: aload_0
    //   178: getfield ae : Z
    //   181: ifeq -> 358
    //   184: aload_0
    //   185: getfield ad : I
    //   188: istore #6
    //   190: aload_0
    //   191: aload_1
    //   192: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   195: istore #12
    //   197: iload #11
    //   199: iconst_2
    //   200: if_icmpne -> 355
    //   203: iload #6
    //   205: aload_0
    //   206: getfield ad : I
    //   209: if_icmpne -> 355
    //   212: aload_0
    //   213: getfield j : F
    //   216: f2i
    //   217: istore #8
    //   219: aload_0
    //   220: invokevirtual getWidth : ()I
    //   223: istore #7
    //   225: aload_0
    //   226: getfield j : F
    //   229: fstore_2
    //   230: iload #7
    //   232: ifne -> 242
    //   235: iload #9
    //   237: istore #6
    //   239: goto -> 246
    //   242: iload #7
    //   244: istore #6
    //   246: fload_2
    //   247: iload #6
    //   249: i2f
    //   250: fdiv
    //   251: fstore_2
    //   252: aload_0
    //   253: aload_0
    //   254: getfield A : Z
    //   257: invokevirtual a : (Z)Z
    //   260: ifeq -> 305
    //   263: aload_0
    //   264: getfield b : I
    //   267: ifle -> 305
    //   270: aload_0
    //   271: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   274: astore_1
    //   275: aload_1
    //   276: ifnull -> 305
    //   279: aload_1
    //   280: invokeinterface a : ()Z
    //   285: ifeq -> 305
    //   288: aload_0
    //   289: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   292: fload_2
    //   293: iload #8
    //   295: iload #7
    //   297: invokeinterface a : (FII)V
    //   302: iload #12
    //   304: ireturn
    //   305: aload_0
    //   306: aload_0
    //   307: getfield B : Z
    //   310: invokevirtual a : (Z)Z
    //   313: ifeq -> 355
    //   316: aload_0
    //   317: getfield b : I
    //   320: ifge -> 355
    //   323: aload_0
    //   324: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   327: astore_1
    //   328: aload_1
    //   329: ifnull -> 355
    //   332: aload_1
    //   333: invokeinterface a : ()Z
    //   338: ifeq -> 355
    //   341: aload_0
    //   342: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   345: fload_2
    //   346: iload #8
    //   348: iload #7
    //   350: invokeinterface a : (FII)V
    //   355: iload #12
    //   357: ireturn
    //   358: aload_0
    //   359: invokevirtual isEnabled : ()Z
    //   362: ifeq -> 1655
    //   365: aload_0
    //   366: aload_0
    //   367: getfield A : Z
    //   370: invokevirtual a : (Z)Z
    //   373: ifne -> 394
    //   376: aload_0
    //   377: aload_0
    //   378: getfield B : Z
    //   381: invokevirtual a : (Z)Z
    //   384: ifne -> 394
    //   387: aload_0
    //   388: getfield J : Z
    //   391: ifeq -> 1655
    //   394: aload_0
    //   395: getfield aE : Z
    //   398: ifeq -> 431
    //   401: aload_0
    //   402: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   405: getfield v : Z
    //   408: ifne -> 421
    //   411: aload_0
    //   412: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   415: getfield w : Z
    //   418: ifeq -> 431
    //   421: aload_0
    //   422: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   425: getfield r : Z
    //   428: ifne -> 1655
    //   431: aload_0
    //   432: getfield aF : Z
    //   435: ifeq -> 471
    //   438: aload_0
    //   439: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   442: getfield v : Z
    //   445: ifne -> 458
    //   448: aload_0
    //   449: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   452: getfield w : Z
    //   455: ifeq -> 471
    //   458: aload_0
    //   459: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   462: getfield s : Z
    //   465: ifeq -> 471
    //   468: goto -> 1655
    //   471: aload_0
    //   472: iload #11
    //   474: invokevirtual a : (I)Z
    //   477: ifne -> 1653
    //   480: aload_0
    //   481: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   484: getfield w : Z
    //   487: ifne -> 1653
    //   490: aload_0
    //   491: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   494: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.m : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   497: if_acmpne -> 507
    //   500: aload_0
    //   501: getfield Q : Z
    //   504: ifne -> 1653
    //   507: aload_0
    //   508: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   511: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.l : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   514: if_acmpne -> 526
    //   517: aload_0
    //   518: getfield P : Z
    //   521: ifeq -> 526
    //   524: iconst_0
    //   525: ireturn
    //   526: iload #11
    //   528: ifeq -> 1534
    //   531: iload #11
    //   533: iconst_1
    //   534: if_icmpeq -> 1399
    //   537: iload #11
    //   539: iconst_2
    //   540: if_icmpeq -> 552
    //   543: iload #11
    //   545: iconst_3
    //   546: if_icmpeq -> 1440
    //   549: goto -> 1528
    //   552: fload_3
    //   553: aload_0
    //   554: getfield h : F
    //   557: fsub
    //   558: fstore #5
    //   560: fload #4
    //   562: aload_0
    //   563: getfield i : F
    //   566: fsub
    //   567: fstore_3
    //   568: aload_0
    //   569: getfield x : Landroid/view/VelocityTracker;
    //   572: aload_1
    //   573: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   576: fload_3
    //   577: fstore_2
    //   578: aload_0
    //   579: getfield n : Z
    //   582: ifne -> 956
    //   585: aload_0
    //   586: getfield m : C
    //   589: istore #6
    //   591: fload_3
    //   592: fstore_2
    //   593: iload #6
    //   595: bipush #104
    //   597: if_icmpeq -> 956
    //   600: fload_3
    //   601: fstore_2
    //   602: aload_0
    //   603: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   606: ifnull -> 956
    //   609: iload #6
    //   611: bipush #118
    //   613: if_icmpeq -> 698
    //   616: fload_3
    //   617: invokestatic abs : (F)F
    //   620: aload_0
    //   621: getfield a : I
    //   624: i2f
    //   625: fcmpl
    //   626: iflt -> 645
    //   629: fload #5
    //   631: invokestatic abs : (F)F
    //   634: fload_3
    //   635: invokestatic abs : (F)F
    //   638: fcmpg
    //   639: ifge -> 645
    //   642: goto -> 698
    //   645: fload_3
    //   646: fstore_2
    //   647: fload #5
    //   649: invokestatic abs : (F)F
    //   652: aload_0
    //   653: getfield a : I
    //   656: i2f
    //   657: fcmpl
    //   658: iflt -> 956
    //   661: fload_3
    //   662: fstore_2
    //   663: fload #5
    //   665: invokestatic abs : (F)F
    //   668: fload_3
    //   669: invokestatic abs : (F)F
    //   672: fcmpl
    //   673: ifle -> 956
    //   676: fload_3
    //   677: fstore_2
    //   678: aload_0
    //   679: getfield m : C
    //   682: bipush #118
    //   684: if_icmpeq -> 956
    //   687: aload_0
    //   688: bipush #104
    //   690: putfield m : C
    //   693: fload_3
    //   694: fstore_2
    //   695: goto -> 956
    //   698: aload_0
    //   699: bipush #118
    //   701: putfield m : C
    //   704: fload_3
    //   705: fconst_0
    //   706: fcmpl
    //   707: ifle -> 767
    //   710: aload_0
    //   711: getfield b : I
    //   714: iflt -> 747
    //   717: aload_0
    //   718: getfield J : Z
    //   721: ifne -> 735
    //   724: aload_0
    //   725: aload_0
    //   726: getfield A : Z
    //   729: invokevirtual a : (Z)Z
    //   732: ifeq -> 767
    //   735: aload_0
    //   736: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   739: invokeinterface c : ()Z
    //   744: ifeq -> 767
    //   747: aload_0
    //   748: iconst_1
    //   749: putfield n : Z
    //   752: aload_0
    //   753: fload #4
    //   755: aload_0
    //   756: getfield a : I
    //   759: i2f
    //   760: fsub
    //   761: putfield i : F
    //   764: goto -> 844
    //   767: fload_3
    //   768: fconst_0
    //   769: fcmpg
    //   770: ifge -> 844
    //   773: aload_0
    //   774: getfield b : I
    //   777: ifgt -> 827
    //   780: aload_0
    //   781: getfield J : Z
    //   784: ifne -> 798
    //   787: aload_0
    //   788: aload_0
    //   789: getfield B : Z
    //   792: invokevirtual a : (Z)Z
    //   795: ifeq -> 844
    //   798: aload_0
    //   799: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   802: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.m : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   805: if_acmpne -> 815
    //   808: aload_0
    //   809: getfield aG : Z
    //   812: ifne -> 827
    //   815: aload_0
    //   816: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   819: invokeinterface d : ()Z
    //   824: ifeq -> 844
    //   827: aload_0
    //   828: iconst_1
    //   829: putfield n : Z
    //   832: aload_0
    //   833: aload_0
    //   834: getfield a : I
    //   837: i2f
    //   838: fload #4
    //   840: fadd
    //   841: putfield i : F
    //   844: fload_3
    //   845: fstore_2
    //   846: aload_0
    //   847: getfield n : Z
    //   850: ifeq -> 956
    //   853: fload #4
    //   855: aload_0
    //   856: getfield i : F
    //   859: fsub
    //   860: fstore_3
    //   861: aload_0
    //   862: getfield o : Z
    //   865: ifeq -> 879
    //   868: aload_1
    //   869: iconst_3
    //   870: invokevirtual setAction : (I)V
    //   873: aload_0
    //   874: aload_1
    //   875: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   878: pop
    //   879: aload_0
    //   880: getfield b : I
    //   883: istore #6
    //   885: iload #6
    //   887: ifgt -> 920
    //   890: iload #6
    //   892: ifne -> 904
    //   895: fload_3
    //   896: fconst_0
    //   897: fcmpl
    //   898: ifle -> 904
    //   901: goto -> 920
    //   904: aload_0
    //   905: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   908: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.c : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   911: invokeinterface a : (Lcom/scwang/smartrefresh/layout/constant/RefreshState;)Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   916: pop
    //   917: goto -> 933
    //   920: aload_0
    //   921: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   924: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.b : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   927: invokeinterface a : (Lcom/scwang/smartrefresh/layout/constant/RefreshState;)Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   932: pop
    //   933: aload_0
    //   934: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   937: astore #15
    //   939: fload_3
    //   940: fstore_2
    //   941: aload #15
    //   943: ifnull -> 956
    //   946: aload #15
    //   948: iconst_1
    //   949: invokeinterface requestDisallowInterceptTouchEvent : (Z)V
    //   954: fload_3
    //   955: fstore_2
    //   956: aload_0
    //   957: getfield n : Z
    //   960: ifeq -> 1367
    //   963: fload_2
    //   964: f2i
    //   965: aload_0
    //   966: getfield d : I
    //   969: iadd
    //   970: istore #7
    //   972: aload_0
    //   973: getfield aA : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   976: getfield r : Z
    //   979: ifeq -> 994
    //   982: iload #7
    //   984: iflt -> 1024
    //   987: aload_0
    //   988: getfield c : I
    //   991: iflt -> 1024
    //   994: iload #7
    //   996: istore #6
    //   998: aload_0
    //   999: getfield aA : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   1002: getfield s : Z
    //   1005: ifeq -> 1358
    //   1008: iload #7
    //   1010: ifgt -> 1024
    //   1013: iload #7
    //   1015: istore #6
    //   1017: aload_0
    //   1018: getfield c : I
    //   1021: ifle -> 1358
    //   1024: aload_0
    //   1025: iload #7
    //   1027: putfield c : I
    //   1030: aload_1
    //   1031: invokevirtual getEventTime : ()J
    //   1034: lstore #13
    //   1036: aload_0
    //   1037: getfield aL : Landroid/view/MotionEvent;
    //   1040: ifnonnull -> 1076
    //   1043: aload_0
    //   1044: lload #13
    //   1046: lload #13
    //   1048: iconst_0
    //   1049: aload_0
    //   1050: getfield h : F
    //   1053: fload #5
    //   1055: fadd
    //   1056: aload_0
    //   1057: getfield i : F
    //   1060: iconst_0
    //   1061: invokestatic obtain : (JJIFFI)Landroid/view/MotionEvent;
    //   1064: putfield aL : Landroid/view/MotionEvent;
    //   1067: aload_0
    //   1068: aload_0
    //   1069: getfield aL : Landroid/view/MotionEvent;
    //   1072: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   1075: pop
    //   1076: lload #13
    //   1078: lload #13
    //   1080: iconst_2
    //   1081: aload_0
    //   1082: getfield h : F
    //   1085: fload #5
    //   1087: fadd
    //   1088: aload_0
    //   1089: getfield i : F
    //   1092: iload #7
    //   1094: i2f
    //   1095: fadd
    //   1096: iconst_0
    //   1097: invokestatic obtain : (JJIFFI)Landroid/view/MotionEvent;
    //   1100: astore_1
    //   1101: aload_0
    //   1102: aload_1
    //   1103: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   1106: pop
    //   1107: aload_0
    //   1108: getfield aG : Z
    //   1111: ifeq -> 1136
    //   1114: fload_2
    //   1115: aload_0
    //   1116: getfield a : I
    //   1119: i2f
    //   1120: fcmpl
    //   1121: ifle -> 1136
    //   1124: aload_0
    //   1125: getfield b : I
    //   1128: ifge -> 1136
    //   1131: aload_0
    //   1132: iconst_0
    //   1133: putfield aG : Z
    //   1136: iload #7
    //   1138: ifle -> 1207
    //   1141: aload_0
    //   1142: getfield J : Z
    //   1145: ifne -> 1159
    //   1148: aload_0
    //   1149: aload_0
    //   1150: getfield A : Z
    //   1153: invokevirtual a : (Z)Z
    //   1156: ifeq -> 1207
    //   1159: aload_0
    //   1160: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   1163: invokeinterface c : ()Z
    //   1168: ifeq -> 1207
    //   1171: aload_0
    //   1172: fload #4
    //   1174: putfield k : F
    //   1177: aload_0
    //   1178: fload #4
    //   1180: putfield i : F
    //   1183: aload_0
    //   1184: iconst_0
    //   1185: putfield d : I
    //   1188: aload_0
    //   1189: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   1192: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.b : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   1195: invokeinterface a : (Lcom/scwang/smartrefresh/layout/constant/RefreshState;)Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   1200: pop
    //   1201: iconst_0
    //   1202: istore #6
    //   1204: goto -> 1287
    //   1207: iload #7
    //   1209: istore #6
    //   1211: iload #7
    //   1213: ifge -> 1287
    //   1216: aload_0
    //   1217: getfield J : Z
    //   1220: ifne -> 1238
    //   1223: iload #7
    //   1225: istore #6
    //   1227: aload_0
    //   1228: aload_0
    //   1229: getfield B : Z
    //   1232: invokevirtual a : (Z)Z
    //   1235: ifeq -> 1287
    //   1238: iload #7
    //   1240: istore #6
    //   1242: aload_0
    //   1243: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   1246: invokeinterface d : ()Z
    //   1251: ifeq -> 1287
    //   1254: aload_0
    //   1255: fload #4
    //   1257: putfield k : F
    //   1260: aload_0
    //   1261: fload #4
    //   1263: putfield i : F
    //   1266: aload_0
    //   1267: iconst_0
    //   1268: putfield d : I
    //   1271: aload_0
    //   1272: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   1275: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.c : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   1278: invokeinterface a : (Lcom/scwang/smartrefresh/layout/constant/RefreshState;)Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   1283: pop
    //   1284: goto -> 1201
    //   1287: aload_0
    //   1288: getfield aA : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   1291: getfield r : Z
    //   1294: ifeq -> 1302
    //   1297: iload #6
    //   1299: iflt -> 1317
    //   1302: aload_0
    //   1303: getfield aA : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   1306: getfield s : Z
    //   1309: ifeq -> 1331
    //   1312: iload #6
    //   1314: ifle -> 1331
    //   1317: aload_0
    //   1318: getfield b : I
    //   1321: ifeq -> 1329
    //   1324: aload_0
    //   1325: fconst_0
    //   1326: invokevirtual b : (F)V
    //   1329: iconst_1
    //   1330: ireturn
    //   1331: aload_0
    //   1332: getfield aL : Landroid/view/MotionEvent;
    //   1335: ifnull -> 1354
    //   1338: aload_0
    //   1339: aconst_null
    //   1340: putfield aL : Landroid/view/MotionEvent;
    //   1343: aload_1
    //   1344: iconst_3
    //   1345: invokevirtual setAction : (I)V
    //   1348: aload_0
    //   1349: aload_1
    //   1350: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   1353: pop
    //   1354: aload_1
    //   1355: invokevirtual recycle : ()V
    //   1358: aload_0
    //   1359: iload #6
    //   1361: i2f
    //   1362: invokevirtual b : (F)V
    //   1365: iconst_1
    //   1366: ireturn
    //   1367: aload_0
    //   1368: getfield aG : Z
    //   1371: ifeq -> 1528
    //   1374: fload_2
    //   1375: aload_0
    //   1376: getfield a : I
    //   1379: i2f
    //   1380: fcmpl
    //   1381: ifle -> 1528
    //   1384: aload_0
    //   1385: getfield b : I
    //   1388: ifge -> 1528
    //   1391: aload_0
    //   1392: iconst_0
    //   1393: putfield aG : Z
    //   1396: goto -> 1528
    //   1399: aload_0
    //   1400: getfield x : Landroid/view/VelocityTracker;
    //   1403: aload_1
    //   1404: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   1407: aload_0
    //   1408: getfield x : Landroid/view/VelocityTracker;
    //   1411: sipush #1000
    //   1414: aload_0
    //   1415: getfield u : I
    //   1418: i2f
    //   1419: invokevirtual computeCurrentVelocity : (IF)V
    //   1422: aload_0
    //   1423: aload_0
    //   1424: getfield x : Landroid/view/VelocityTracker;
    //   1427: invokevirtual getYVelocity : ()F
    //   1430: f2i
    //   1431: putfield v : I
    //   1434: aload_0
    //   1435: aconst_null
    //   1436: invokevirtual a : (Ljava/lang/Float;)Z
    //   1439: pop
    //   1440: aload_0
    //   1441: getfield x : Landroid/view/VelocityTracker;
    //   1444: invokevirtual clear : ()V
    //   1447: aload_0
    //   1448: bipush #110
    //   1450: putfield m : C
    //   1453: aload_0
    //   1454: getfield aL : Landroid/view/MotionEvent;
    //   1457: astore #15
    //   1459: aload #15
    //   1461: ifnull -> 1510
    //   1464: aload #15
    //   1466: invokevirtual recycle : ()V
    //   1469: aload_0
    //   1470: aconst_null
    //   1471: putfield aL : Landroid/view/MotionEvent;
    //   1474: aload_1
    //   1475: invokevirtual getEventTime : ()J
    //   1478: lstore #13
    //   1480: lload #13
    //   1482: lload #13
    //   1484: iload #11
    //   1486: aload_0
    //   1487: getfield h : F
    //   1490: fload #4
    //   1492: iconst_0
    //   1493: invokestatic obtain : (JJIFFI)Landroid/view/MotionEvent;
    //   1496: astore #15
    //   1498: aload_0
    //   1499: aload #15
    //   1501: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   1504: pop
    //   1505: aload #15
    //   1507: invokevirtual recycle : ()V
    //   1510: aload_0
    //   1511: invokevirtual e : ()V
    //   1514: aload_0
    //   1515: getfield n : Z
    //   1518: ifeq -> 1528
    //   1521: aload_0
    //   1522: iconst_0
    //   1523: putfield n : Z
    //   1526: iconst_1
    //   1527: ireturn
    //   1528: aload_0
    //   1529: aload_1
    //   1530: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   1533: ireturn
    //   1534: aload_0
    //   1535: iconst_0
    //   1536: putfield v : I
    //   1539: aload_0
    //   1540: getfield x : Landroid/view/VelocityTracker;
    //   1543: aload_1
    //   1544: invokevirtual addMovement : (Landroid/view/MotionEvent;)V
    //   1547: aload_0
    //   1548: getfield w : Landroid/widget/Scroller;
    //   1551: iconst_1
    //   1552: invokevirtual forceFinished : (Z)V
    //   1555: aload_0
    //   1556: fload_3
    //   1557: putfield h : F
    //   1560: aload_0
    //   1561: fload #4
    //   1563: putfield i : F
    //   1566: aload_0
    //   1567: iconst_0
    //   1568: putfield c : I
    //   1571: aload_0
    //   1572: aload_0
    //   1573: getfield b : I
    //   1576: putfield d : I
    //   1579: aload_0
    //   1580: iconst_0
    //   1581: putfield n : Z
    //   1584: aload_0
    //   1585: aload_0
    //   1586: aload_1
    //   1587: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   1590: putfield o : Z
    //   1593: aload_0
    //   1594: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   1597: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.n : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   1600: if_acmpne -> 1632
    //   1603: aload_0
    //   1604: getfield i : F
    //   1607: aload_0
    //   1608: invokevirtual getMeasuredHeight : ()I
    //   1611: iconst_5
    //   1612: imul
    //   1613: bipush #6
    //   1615: idiv
    //   1616: i2f
    //   1617: fcmpg
    //   1618: ifge -> 1632
    //   1621: aload_0
    //   1622: bipush #104
    //   1624: putfield m : C
    //   1627: aload_0
    //   1628: getfield o : Z
    //   1631: ireturn
    //   1632: aload_0
    //   1633: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   1636: astore #15
    //   1638: aload #15
    //   1640: ifnull -> 1651
    //   1643: aload #15
    //   1645: aload_1
    //   1646: invokeinterface a : (Landroid/view/MotionEvent;)V
    //   1651: iconst_1
    //   1652: ireturn
    //   1653: iconst_0
    //   1654: ireturn
    //   1655: aload_0
    //   1656: aload_1
    //   1657: invokespecial dispatchTouchEvent : (Landroid/view/MotionEvent;)Z
    //   1660: ireturn
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    RefreshContent refreshContent = this.au;
    if (refreshContent != null) {
      View view = refreshContent.a();
    } else {
      refreshContent = null;
    } 
    RefreshInternal refreshInternal = this.as;
    if (refreshInternal != null && refreshInternal.getView() == paramView)
      if (a(this.A)) {
        if (!this.H && isInEditMode())
          return true; 
        if (refreshContent != null) {
          int i = Math.max(refreshContent.getTop() + refreshContent.getPaddingTop() + this.b, paramView.getTop());
          int k = this.aC;
          int j = i;
          if (k != 0) {
            Paint paint = this.av;
            j = i;
            if (paint != null) {
              paint.setColor(k);
              if (this.as.getSpinnerStyle() == SpinnerStyle.b) {
                i = paramView.getBottom();
              } else if (this.as.getSpinnerStyle() == SpinnerStyle.a) {
                i = paramView.getBottom() + this.b;
              } 
              paramCanvas.drawRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), i, this.av);
              j = i;
            } 
          } 
          if (this.C && this.as.getSpinnerStyle() == SpinnerStyle.c) {
            paramCanvas.save();
            paramCanvas.clipRect(paramView.getLeft(), paramView.getTop(), paramView.getRight(), j);
            boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restore();
            return bool;
          } 
        } 
      } else {
        return true;
      }  
    refreshInternal = this.at;
    if (refreshInternal != null && refreshInternal.getView() == paramView)
      if (a(this.B)) {
        if (!this.H && isInEditMode())
          return true; 
        if (refreshContent != null) {
          int i = Math.min(refreshContent.getBottom() - refreshContent.getPaddingBottom() + this.b, paramView.getBottom());
          int k = this.aD;
          int j = i;
          if (k != 0) {
            Paint paint = this.av;
            j = i;
            if (paint != null) {
              paint.setColor(k);
              if (this.at.getSpinnerStyle() == SpinnerStyle.b) {
                i = paramView.getTop();
              } else if (this.at.getSpinnerStyle() == SpinnerStyle.a) {
                i = paramView.getTop() + this.b;
              } 
              paramCanvas.drawRect(paramView.getLeft(), i, paramView.getRight(), paramView.getBottom(), this.av);
              j = i;
            } 
          } 
          if (this.D && this.at.getSpinnerStyle() == SpinnerStyle.c) {
            paramCanvas.save();
            paramCanvas.clipRect(paramView.getLeft(), j, paramView.getRight(), paramView.getBottom());
            boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restore();
            return bool;
          } 
        } 
      } else {
        return true;
      }  
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public RefreshLayout e(boolean paramBoolean) {
    setNestedScrollingEnabled(paramBoolean);
    return this;
  }
  
  protected void e() {
    if (this.az == RefreshState.n) {
      if (this.v > -1000 && this.b > getMeasuredHeight() / 2) {
        ValueAnimator valueAnimator = this.ax.a(getMeasuredHeight());
        if (valueAnimator != null) {
          valueAnimator.setDuration(this.e);
          return;
        } 
      } else if (this.n) {
        this.ax.b();
        return;
      } 
    } else {
      if (this.az == RefreshState.m || (this.G && this.R && this.b < 0 && a(this.B))) {
        int i = this.b;
        int j = this.ak;
        if (i < -j) {
          this.ax.a(-j);
          return;
        } 
        if (i > 0)
          this.ax.a(0); 
        return;
      } 
      if (this.az == RefreshState.l) {
        int i = this.b;
        int j = this.ai;
        if (i > j) {
          this.ax.a(j);
          return;
        } 
        if (i < 0) {
          this.ax.a(0);
          return;
        } 
      } else {
        if (this.az == RefreshState.b) {
          this.ax.a(RefreshState.d);
          return;
        } 
        if (this.az == RefreshState.c) {
          this.ax.a(RefreshState.e);
          return;
        } 
        if (this.az == RefreshState.f) {
          this.ax.a(RefreshState.l);
          return;
        } 
        if (this.az == RefreshState.g) {
          this.ax.a(RefreshState.m);
          return;
        } 
        if (this.az == RefreshState.h) {
          this.ax.a(RefreshState.i);
          return;
        } 
        if (this.az == RefreshState.j) {
          if (this.aN == null) {
            this.ax.a(this.ai);
            return;
          } 
        } else if (this.az == RefreshState.k) {
          if (this.aN == null) {
            this.ax.a(-this.ak);
            return;
          } 
        } else if (this.b != 0) {
          this.ax.a(0);
          return;
        } 
      } 
    } 
  }
  
  protected LayoutParams f() {
    return new LayoutParams(-1, -1);
  }
  
  public SmartRefreshLayout f(boolean paramBoolean) {
    this.R = paramBoolean;
    RefreshInternal refreshInternal = this.at;
    if (refreshInternal instanceof RefreshFooter && !((RefreshFooter)refreshInternal).a(paramBoolean)) {
      PrintStream printStream = System.out;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Footer:");
      stringBuilder.append(this.at);
      stringBuilder.append(" NoMoreData is not supported.(不支持NoMoreData)");
      printStream.println(stringBuilder.toString());
    } 
    return this;
  }
  
  public SmartRefreshLayout g() {
    return b(Math.min(Math.max(0, 300 - (int)(System.currentTimeMillis() - this.aB)), 300));
  }
  
  public SmartRefreshLayout g(boolean paramBoolean) {
    boolean bool;
    long l1 = System.currentTimeMillis();
    long l2 = this.aB;
    if (paramBoolean) {
      bool = Math.min(Math.max(0, 300 - (int)(l1 - l2)), 300);
    } else {
      bool = false;
    } 
    return a(bool, paramBoolean, false);
  }
  
  public SmartRefreshLayout getLayout() {
    return this;
  }
  
  public int getNestedScrollAxes() {
    return this.ah.getNestedScrollAxes();
  }
  
  public RefreshFooter getRefreshFooter() {
    RefreshInternal refreshInternal = this.at;
    return (refreshInternal instanceof RefreshFooter) ? (RefreshFooter)refreshInternal : null;
  }
  
  public RefreshHeader getRefreshHeader() {
    RefreshInternal refreshInternal = this.as;
    return (refreshInternal instanceof RefreshHeader) ? (RefreshHeader)refreshInternal : null;
  }
  
  public RefreshState getState() {
    return this.az;
  }
  
  public SmartRefreshLayout h() {
    return c(Math.min(Math.max(0, 300 - (int)(System.currentTimeMillis() - this.aB)), 300));
  }
  
  public boolean i() {
    boolean bool;
    if (this.aw == null) {
      bool = true;
    } else {
      bool = false;
    } 
    return d(bool);
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.ag.isNestedScrollingEnabled();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      if (this.aw == null)
        this.aw = new Handler(); 
      List<DelayedRunnable> list = this.ay;
      View view = null;
      if (list != null) {
        for (DelayedRunnable delayedRunnable : list)
          this.aw.postDelayed((Runnable)delayedRunnable, delayedRunnable.a); 
        this.ay.clear();
        this.ay = null;
      } 
      if (this.as == null) {
        DefaultRefreshHeaderCreator defaultRefreshHeaderCreator = aI;
        if (defaultRefreshHeaderCreator != null) {
          a(defaultRefreshHeaderCreator.a(getContext(), this));
        } else {
          a((RefreshHeader)new BezierRadarHeader(getContext()));
        } 
      } 
      if (this.at == null) {
        DefaultRefreshFooterCreator defaultRefreshFooterCreator = aH;
        if (defaultRefreshFooterCreator != null) {
          a(defaultRefreshFooterCreator.a(getContext(), this));
        } else {
          boolean bool = this.B;
          a((RefreshFooter)new BallPulseFooter(getContext()));
          this.B = bool;
        } 
      } else {
        boolean bool;
        if (this.B || !this.S) {
          bool = true;
        } else {
          bool = false;
        } 
        this.B = bool;
      } 
      if (this.au == null) {
        int k = getChildCount();
        for (int j = 0; j < k; j++) {
          View view1 = getChildAt(j);
          RefreshInternal refreshInternal1 = this.as;
          if (refreshInternal1 == null || view1 != refreshInternal1.getView()) {
            refreshInternal1 = this.at;
            if (refreshInternal1 == null || view1 != refreshInternal1.getView())
              this.au = (RefreshContent)new RefreshContentWrapper(view1); 
          } 
        } 
      } 
      if (this.au == null) {
        int j = DensityUtil.a(20.0F);
        TextView textView = new TextView(getContext());
        textView.setTextColor(-39424);
        textView.setGravity(17);
        textView.setTextSize(20.0F);
        textView.setText(R.string.srl_content_empty);
        addView((View)textView, -1, -1);
        this.au = (RefreshContent)new RefreshContentWrapper((View)textView);
        this.au.a().setPadding(j, j, j, j);
      } 
      int i = this.p;
      if (i > 0) {
        View view1 = findViewById(i);
      } else {
        list = null;
      } 
      i = this.q;
      if (i > 0)
        view = findViewById(i); 
      this.au.a(this.ac);
      this.au.a(this.O);
      this.au.a(this.ax, (View)list, view);
      if (this.b != 0) {
        a(RefreshState.a);
        RefreshContent refreshContent1 = this.au;
        this.b = 0;
        refreshContent1.a(0, this.r, this.s);
      } 
      if (!this.T && !isNestedScrollingEnabled())
        post(new Runnable(this) {
              public void run() {
                ViewParent viewParent = this.a.getParent();
                while (viewParent != null) {
                  if (viewParent instanceof NestedScrollingParent) {
                    SmartRefreshLayout smartRefreshLayout = this.a;
                    if (((NestedScrollingParent)viewParent).onStartNestedScroll((View)smartRefreshLayout, (View)smartRefreshLayout, 2)) {
                      this.a.setNestedScrollingEnabled(true);
                      this.a.T = false;
                      return;
                    } 
                  } 
                  if (viewParent instanceof View)
                    viewParent = ((View)viewParent).getParent(); 
                } 
              }
            }); 
    } 
    int[] arrayOfInt = this.z;
    if (arrayOfInt != null) {
      RefreshInternal refreshInternal2 = this.as;
      if (refreshInternal2 != null)
        refreshInternal2.setPrimaryColors(arrayOfInt); 
      RefreshInternal refreshInternal1 = this.at;
      if (refreshInternal1 != null)
        refreshInternal1.setPrimaryColors(this.z); 
    } 
    RefreshContent refreshContent = this.au;
    if (refreshContent != null)
      bringChildToFront(refreshContent.a()); 
    RefreshInternal refreshInternal = this.as;
    if (refreshInternal != null && refreshInternal.getSpinnerStyle() != SpinnerStyle.c)
      bringChildToFront(this.as.getView()); 
    refreshInternal = this.at;
    if (refreshInternal != null && refreshInternal.getSpinnerStyle() != SpinnerStyle.c)
      bringChildToFront(this.at.getView()); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.ax.a(0, true);
    a(RefreshState.a);
    Handler handler = this.aw;
    if (handler != null) {
      handler.removeCallbacksAndMessages(null);
      this.aw = null;
    } 
    List<DelayedRunnable> list = this.ay;
    if (list != null) {
      list.clear();
      this.ay = null;
    } 
    this.S = true;
    this.T = true;
    this.aM = null;
    ValueAnimator valueAnimator = this.aN;
    if (valueAnimator != null) {
      valueAnimator.removeAllListeners();
      this.aN.removeAllUpdateListeners();
      this.aN.cancel();
      this.aN = null;
    } 
  }
  
  protected void onFinishInflate() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial onFinishInflate : ()V
    //   4: aload_0
    //   5: invokespecial getChildCount : ()I
    //   8: istore #7
    //   10: iload #7
    //   12: iconst_3
    //   13: if_icmpgt -> 367
    //   16: iconst_0
    //   17: istore_1
    //   18: iconst_m1
    //   19: istore #5
    //   21: iconst_0
    //   22: istore #4
    //   24: iconst_2
    //   25: istore_2
    //   26: iconst_1
    //   27: istore #6
    //   29: iload_1
    //   30: iload #7
    //   32: if_icmpge -> 127
    //   35: aload_0
    //   36: iload_1
    //   37: invokespecial getChildAt : (I)Landroid/view/View;
    //   40: astore #9
    //   42: aload #9
    //   44: invokestatic c : (Landroid/view/View;)Z
    //   47: ifeq -> 68
    //   50: iload #4
    //   52: iconst_2
    //   53: if_icmplt -> 61
    //   56: iload_1
    //   57: iconst_1
    //   58: if_icmpne -> 68
    //   61: iload_1
    //   62: istore_2
    //   63: iconst_2
    //   64: istore_3
    //   65: goto -> 114
    //   68: iload #5
    //   70: istore_2
    //   71: iload #4
    //   73: istore_3
    //   74: aload #9
    //   76: instanceof com/scwang/smartrefresh/layout/api/RefreshInternal
    //   79: ifne -> 114
    //   82: iload #5
    //   84: istore_2
    //   85: iload #4
    //   87: istore_3
    //   88: iload #4
    //   90: iconst_1
    //   91: if_icmpge -> 114
    //   94: iload_1
    //   95: ifle -> 104
    //   98: iload #6
    //   100: istore_2
    //   101: goto -> 106
    //   104: iconst_0
    //   105: istore_2
    //   106: iload_1
    //   107: istore #4
    //   109: iload_2
    //   110: istore_3
    //   111: iload #4
    //   113: istore_2
    //   114: iload_1
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: iload_2
    //   119: istore #5
    //   121: iload_3
    //   122: istore #4
    //   124: goto -> 24
    //   127: iload #5
    //   129: iflt -> 184
    //   132: aload_0
    //   133: new com/scwang/smartrefresh/layout/impl/RefreshContentWrapper
    //   136: dup
    //   137: aload_0
    //   138: iload #5
    //   140: invokespecial getChildAt : (I)Landroid/view/View;
    //   143: invokespecial <init> : (Landroid/view/View;)V
    //   146: putfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   149: iload #5
    //   151: iconst_1
    //   152: if_icmpne -> 171
    //   155: iload #7
    //   157: iconst_3
    //   158: if_icmpne -> 166
    //   161: iconst_0
    //   162: istore_1
    //   163: goto -> 188
    //   166: iconst_0
    //   167: istore_1
    //   168: goto -> 186
    //   171: iload #7
    //   173: iconst_2
    //   174: if_icmpne -> 184
    //   177: iconst_m1
    //   178: istore_1
    //   179: iconst_1
    //   180: istore_2
    //   181: goto -> 188
    //   184: iconst_m1
    //   185: istore_1
    //   186: iconst_m1
    //   187: istore_2
    //   188: iconst_0
    //   189: istore_3
    //   190: iload_3
    //   191: iload #7
    //   193: if_icmpge -> 366
    //   196: aload_0
    //   197: iload_3
    //   198: invokespecial getChildAt : (I)Landroid/view/View;
    //   201: astore #9
    //   203: iload_3
    //   204: iload_1
    //   205: if_icmpeq -> 324
    //   208: iload_3
    //   209: iload_2
    //   210: if_icmpeq -> 236
    //   213: iload_1
    //   214: iconst_m1
    //   215: if_icmpne -> 236
    //   218: aload_0
    //   219: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   222: ifnonnull -> 236
    //   225: aload #9
    //   227: instanceof com/scwang/smartrefresh/layout/api/RefreshHeader
    //   230: ifeq -> 236
    //   233: goto -> 324
    //   236: iload_3
    //   237: iload_2
    //   238: if_icmpeq -> 254
    //   241: iload_2
    //   242: iconst_m1
    //   243: if_icmpne -> 359
    //   246: aload #9
    //   248: instanceof com/scwang/smartrefresh/layout/api/RefreshFooter
    //   251: ifeq -> 359
    //   254: aload_0
    //   255: getfield B : Z
    //   258: ifne -> 277
    //   261: aload_0
    //   262: getfield S : Z
    //   265: ifne -> 271
    //   268: goto -> 277
    //   271: iconst_0
    //   272: istore #8
    //   274: goto -> 280
    //   277: iconst_1
    //   278: istore #8
    //   280: aload_0
    //   281: iload #8
    //   283: putfield B : Z
    //   286: aload #9
    //   288: instanceof com/scwang/smartrefresh/layout/api/RefreshFooter
    //   291: ifeq -> 304
    //   294: aload #9
    //   296: checkcast com/scwang/smartrefresh/layout/api/RefreshFooter
    //   299: astore #9
    //   301: goto -> 315
    //   304: new com/scwang/smartrefresh/layout/impl/RefreshFooterWrapper
    //   307: dup
    //   308: aload #9
    //   310: invokespecial <init> : (Landroid/view/View;)V
    //   313: astore #9
    //   315: aload_0
    //   316: aload #9
    //   318: putfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   321: goto -> 359
    //   324: aload #9
    //   326: instanceof com/scwang/smartrefresh/layout/api/RefreshHeader
    //   329: ifeq -> 342
    //   332: aload #9
    //   334: checkcast com/scwang/smartrefresh/layout/api/RefreshHeader
    //   337: astore #9
    //   339: goto -> 353
    //   342: new com/scwang/smartrefresh/layout/impl/RefreshHeaderWrapper
    //   345: dup
    //   346: aload #9
    //   348: invokespecial <init> : (Landroid/view/View;)V
    //   351: astore #9
    //   353: aload_0
    //   354: aload #9
    //   356: putfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   359: iload_3
    //   360: iconst_1
    //   361: iadd
    //   362: istore_3
    //   363: goto -> 190
    //   366: return
    //   367: new java/lang/RuntimeException
    //   370: dup
    //   371: ldc_w '最多只支持3个子View，Most only support three sub view'
    //   374: invokespecial <init> : (Ljava/lang/String;)V
    //   377: athrow
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPaddingLeft : ()I
    //   4: istore #9
    //   6: aload_0
    //   7: invokevirtual getPaddingTop : ()I
    //   10: istore #10
    //   12: aload_0
    //   13: invokevirtual getPaddingBottom : ()I
    //   16: pop
    //   17: aload_0
    //   18: invokespecial getChildCount : ()I
    //   21: istore #11
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_3
    //   26: iload #11
    //   28: if_icmpge -> 656
    //   31: aload_0
    //   32: iload_3
    //   33: invokespecial getChildAt : (I)Landroid/view/View;
    //   36: astore #14
    //   38: aload_0
    //   39: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   42: astore #15
    //   44: iconst_1
    //   45: istore #6
    //   47: aload #15
    //   49: ifnull -> 228
    //   52: aload #15
    //   54: invokeinterface a : ()Landroid/view/View;
    //   59: aload #14
    //   61: if_acmpne -> 228
    //   64: aload_0
    //   65: invokevirtual isInEditMode : ()Z
    //   68: ifeq -> 102
    //   71: aload_0
    //   72: getfield H : Z
    //   75: ifeq -> 102
    //   78: aload_0
    //   79: aload_0
    //   80: getfield A : Z
    //   83: invokevirtual a : (Z)Z
    //   86: ifeq -> 102
    //   89: aload_0
    //   90: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   93: ifnull -> 102
    //   96: iconst_1
    //   97: istore #4
    //   99: goto -> 105
    //   102: iconst_0
    //   103: istore #4
    //   105: aload_0
    //   106: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   109: invokeinterface a : ()Landroid/view/View;
    //   114: astore #15
    //   116: aload #15
    //   118: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   121: checkcast com/scwang/smartrefresh/layout/SmartRefreshLayout$LayoutParams
    //   124: astore #16
    //   126: aload #16
    //   128: getfield leftMargin : I
    //   131: iload #9
    //   133: iadd
    //   134: istore #12
    //   136: aload #16
    //   138: getfield topMargin : I
    //   141: iload #10
    //   143: iadd
    //   144: istore #8
    //   146: aload #15
    //   148: invokevirtual getMeasuredWidth : ()I
    //   151: istore #13
    //   153: aload #15
    //   155: invokevirtual getMeasuredHeight : ()I
    //   158: iload #8
    //   160: iadd
    //   161: istore #7
    //   163: iload #8
    //   165: istore #5
    //   167: iload #7
    //   169: istore_2
    //   170: iload #4
    //   172: ifeq -> 213
    //   175: iload #8
    //   177: istore #5
    //   179: iload #7
    //   181: istore_2
    //   182: aload_0
    //   183: aload_0
    //   184: getfield E : Z
    //   187: aload_0
    //   188: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   191: invokevirtual a : (ZLcom/scwang/smartrefresh/layout/api/RefreshInternal;)Z
    //   194: ifeq -> 213
    //   197: aload_0
    //   198: getfield ai : I
    //   201: istore_2
    //   202: iload #8
    //   204: iload_2
    //   205: iadd
    //   206: istore #5
    //   208: iload #7
    //   210: iload_2
    //   211: iadd
    //   212: istore_2
    //   213: aload #15
    //   215: iload #12
    //   217: iload #5
    //   219: iload #13
    //   221: iload #12
    //   223: iadd
    //   224: iload_2
    //   225: invokevirtual layout : (IIII)V
    //   228: aload_0
    //   229: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   232: astore #15
    //   234: aload #15
    //   236: ifnull -> 407
    //   239: aload #15
    //   241: invokeinterface getView : ()Landroid/view/View;
    //   246: aload #14
    //   248: if_acmpne -> 407
    //   251: aload_0
    //   252: invokevirtual isInEditMode : ()Z
    //   255: ifeq -> 282
    //   258: aload_0
    //   259: getfield H : Z
    //   262: ifeq -> 282
    //   265: aload_0
    //   266: aload_0
    //   267: getfield A : Z
    //   270: invokevirtual a : (Z)Z
    //   273: ifeq -> 282
    //   276: iconst_1
    //   277: istore #4
    //   279: goto -> 285
    //   282: iconst_0
    //   283: istore #4
    //   285: aload_0
    //   286: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   289: invokeinterface getView : ()Landroid/view/View;
    //   294: astore #15
    //   296: aload #15
    //   298: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   301: checkcast com/scwang/smartrefresh/layout/SmartRefreshLayout$LayoutParams
    //   304: astore #16
    //   306: aload #16
    //   308: getfield leftMargin : I
    //   311: istore #12
    //   313: aload #16
    //   315: getfield topMargin : I
    //   318: aload_0
    //   319: getfield am : I
    //   322: iadd
    //   323: istore #8
    //   325: aload #15
    //   327: invokevirtual getMeasuredWidth : ()I
    //   330: istore #13
    //   332: aload #15
    //   334: invokevirtual getMeasuredHeight : ()I
    //   337: iload #8
    //   339: iadd
    //   340: istore #7
    //   342: iload #8
    //   344: istore #5
    //   346: iload #7
    //   348: istore_2
    //   349: iload #4
    //   351: ifne -> 392
    //   354: iload #8
    //   356: istore #5
    //   358: iload #7
    //   360: istore_2
    //   361: aload_0
    //   362: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   365: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   370: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.a : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   373: if_acmpne -> 392
    //   376: aload_0
    //   377: getfield ai : I
    //   380: istore_2
    //   381: iload #8
    //   383: iload_2
    //   384: isub
    //   385: istore #5
    //   387: iload #7
    //   389: iload_2
    //   390: isub
    //   391: istore_2
    //   392: aload #15
    //   394: iload #12
    //   396: iload #5
    //   398: iload #13
    //   400: iload #12
    //   402: iadd
    //   403: iload_2
    //   404: invokevirtual layout : (IIII)V
    //   407: aload_0
    //   408: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   411: astore #15
    //   413: aload #15
    //   415: ifnull -> 649
    //   418: aload #15
    //   420: invokeinterface getView : ()Landroid/view/View;
    //   425: aload #14
    //   427: if_acmpne -> 649
    //   430: aload_0
    //   431: invokevirtual isInEditMode : ()Z
    //   434: ifeq -> 461
    //   437: aload_0
    //   438: getfield H : Z
    //   441: ifeq -> 461
    //   444: aload_0
    //   445: aload_0
    //   446: getfield B : Z
    //   449: invokevirtual a : (Z)Z
    //   452: ifeq -> 461
    //   455: iload #6
    //   457: istore_2
    //   458: goto -> 463
    //   461: iconst_0
    //   462: istore_2
    //   463: aload_0
    //   464: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   467: invokeinterface getView : ()Landroid/view/View;
    //   472: astore #14
    //   474: aload #14
    //   476: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   479: checkcast com/scwang/smartrefresh/layout/SmartRefreshLayout$LayoutParams
    //   482: astore #15
    //   484: aload_0
    //   485: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   488: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   493: astore #16
    //   495: aload #15
    //   497: getfield leftMargin : I
    //   500: istore #5
    //   502: aload #15
    //   504: getfield topMargin : I
    //   507: aload_0
    //   508: invokevirtual getMeasuredHeight : ()I
    //   511: iadd
    //   512: aload_0
    //   513: getfield an : I
    //   516: isub
    //   517: istore #4
    //   519: aload #16
    //   521: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.e : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   524: if_acmpne -> 541
    //   527: aload #15
    //   529: getfield topMargin : I
    //   532: aload_0
    //   533: getfield an : I
    //   536: isub
    //   537: istore_2
    //   538: goto -> 626
    //   541: iload_2
    //   542: ifne -> 616
    //   545: aload #16
    //   547: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.d : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   550: if_acmpeq -> 616
    //   553: aload #16
    //   555: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.c : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   558: if_acmpne -> 564
    //   561: goto -> 616
    //   564: iload #4
    //   566: istore_2
    //   567: aload #16
    //   569: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.b : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   572: if_acmpne -> 626
    //   575: iload #4
    //   577: istore_2
    //   578: aload_0
    //   579: getfield b : I
    //   582: ifge -> 626
    //   585: aload_0
    //   586: aload_0
    //   587: getfield B : Z
    //   590: invokevirtual a : (Z)Z
    //   593: ifeq -> 605
    //   596: aload_0
    //   597: getfield b : I
    //   600: ineg
    //   601: istore_2
    //   602: goto -> 607
    //   605: iconst_0
    //   606: istore_2
    //   607: iload_2
    //   608: iconst_0
    //   609: invokestatic max : (II)I
    //   612: istore_2
    //   613: goto -> 621
    //   616: aload_0
    //   617: getfield ak : I
    //   620: istore_2
    //   621: iload #4
    //   623: iload_2
    //   624: isub
    //   625: istore_2
    //   626: aload #14
    //   628: iload #5
    //   630: iload_2
    //   631: aload #14
    //   633: invokevirtual getMeasuredWidth : ()I
    //   636: iload #5
    //   638: iadd
    //   639: aload #14
    //   641: invokevirtual getMeasuredHeight : ()I
    //   644: iload_2
    //   645: iadd
    //   646: invokevirtual layout : (IIII)V
    //   649: iload_3
    //   650: iconst_1
    //   651: iadd
    //   652: istore_3
    //   653: goto -> 25
    //   656: return
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual isInEditMode : ()Z
    //   4: ifeq -> 20
    //   7: aload_0
    //   8: getfield H : Z
    //   11: ifeq -> 20
    //   14: iconst_1
    //   15: istore #6
    //   17: goto -> 23
    //   20: iconst_0
    //   21: istore #6
    //   23: aload_0
    //   24: invokespecial getChildCount : ()I
    //   27: istore #8
    //   29: iconst_0
    //   30: istore #7
    //   32: iconst_0
    //   33: istore #4
    //   35: iload #7
    //   37: iload #8
    //   39: if_icmpge -> 1365
    //   42: aload_0
    //   43: iload #7
    //   45: invokespecial getChildAt : (I)Landroid/view/View;
    //   48: astore #14
    //   50: aload_0
    //   51: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   54: astore #15
    //   56: iload #4
    //   58: istore #5
    //   60: aload #15
    //   62: ifnull -> 561
    //   65: iload #4
    //   67: istore #5
    //   69: aload #15
    //   71: invokeinterface getView : ()Landroid/view/View;
    //   76: aload #14
    //   78: if_acmpne -> 561
    //   81: aload_0
    //   82: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   85: invokeinterface getView : ()Landroid/view/View;
    //   90: astore #15
    //   92: aload #15
    //   94: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   97: checkcast com/scwang/smartrefresh/layout/SmartRefreshLayout$LayoutParams
    //   100: astore #16
    //   102: iload_1
    //   103: aload #16
    //   105: getfield leftMargin : I
    //   108: aload #16
    //   110: getfield rightMargin : I
    //   113: iadd
    //   114: aload #16
    //   116: getfield width : I
    //   119: invokestatic getChildMeasureSpec : (III)I
    //   122: istore #9
    //   124: aload_0
    //   125: getfield ai : I
    //   128: istore_3
    //   129: aload_0
    //   130: getfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   133: invokevirtual ordinal : ()I
    //   136: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.g : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   139: invokevirtual ordinal : ()I
    //   142: if_icmpge -> 356
    //   145: aload #16
    //   147: getfield height : I
    //   150: ifle -> 222
    //   153: aload #16
    //   155: getfield height : I
    //   158: aload #16
    //   160: getfield bottomMargin : I
    //   163: iadd
    //   164: aload #16
    //   166: getfield topMargin : I
    //   169: iadd
    //   170: istore #5
    //   172: iload #5
    //   174: istore_3
    //   175: aload_0
    //   176: getfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   179: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.e : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   182: invokevirtual a : (Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;)Z
    //   185: ifeq -> 356
    //   188: aload_0
    //   189: aload #16
    //   191: getfield height : I
    //   194: aload #16
    //   196: getfield bottomMargin : I
    //   199: iadd
    //   200: aload #16
    //   202: getfield topMargin : I
    //   205: iadd
    //   206: putfield ai : I
    //   209: aload_0
    //   210: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.e : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   213: putfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   216: iload #5
    //   218: istore_3
    //   219: goto -> 356
    //   222: aload #16
    //   224: getfield height : I
    //   227: bipush #-2
    //   229: if_icmpne -> 356
    //   232: aload_0
    //   233: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   236: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   241: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.e : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   244: if_acmpne -> 257
    //   247: aload_0
    //   248: getfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   251: getfield m : Z
    //   254: ifne -> 356
    //   257: iload_2
    //   258: invokestatic getSize : (I)I
    //   261: aload #16
    //   263: getfield bottomMargin : I
    //   266: isub
    //   267: aload #16
    //   269: getfield topMargin : I
    //   272: isub
    //   273: iconst_0
    //   274: invokestatic max : (II)I
    //   277: istore #5
    //   279: aload #15
    //   281: iload #9
    //   283: iload #5
    //   285: ldc_w -2147483648
    //   288: invokestatic makeMeasureSpec : (II)I
    //   291: invokevirtual measure : (II)V
    //   294: aload #15
    //   296: invokevirtual getMeasuredHeight : ()I
    //   299: istore #10
    //   301: iload #10
    //   303: ifle -> 356
    //   306: iload #10
    //   308: iload #5
    //   310: if_icmpeq -> 351
    //   313: aload_0
    //   314: getfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   317: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.c : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   320: invokevirtual a : (Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;)Z
    //   323: ifeq -> 351
    //   326: aload_0
    //   327: iload #10
    //   329: aload #16
    //   331: getfield bottomMargin : I
    //   334: iadd
    //   335: aload #16
    //   337: getfield topMargin : I
    //   340: iadd
    //   341: putfield ai : I
    //   344: aload_0
    //   345: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.c : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   348: putfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   351: iconst_m1
    //   352: istore_3
    //   353: goto -> 356
    //   356: aload_0
    //   357: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   360: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   365: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.e : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   368: if_acmpne -> 380
    //   371: iload_2
    //   372: invokestatic getSize : (I)I
    //   375: istore #5
    //   377: goto -> 434
    //   380: iload_3
    //   381: istore #5
    //   383: aload_0
    //   384: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   387: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   392: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.b : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   395: if_acmpne -> 434
    //   398: iload_3
    //   399: istore #5
    //   401: iload #6
    //   403: ifne -> 434
    //   406: aload_0
    //   407: aload_0
    //   408: getfield A : Z
    //   411: invokevirtual a : (Z)Z
    //   414: ifeq -> 425
    //   417: aload_0
    //   418: getfield b : I
    //   421: istore_3
    //   422: goto -> 427
    //   425: iconst_0
    //   426: istore_3
    //   427: iconst_0
    //   428: iload_3
    //   429: invokestatic max : (II)I
    //   432: istore #5
    //   434: iload #5
    //   436: iconst_m1
    //   437: if_icmpeq -> 471
    //   440: aload #15
    //   442: iload #9
    //   444: iload #5
    //   446: aload #16
    //   448: getfield bottomMargin : I
    //   451: isub
    //   452: aload #16
    //   454: getfield topMargin : I
    //   457: isub
    //   458: iconst_0
    //   459: invokestatic max : (II)I
    //   462: ldc_w 1073741824
    //   465: invokestatic makeMeasureSpec : (II)I
    //   468: invokevirtual measure : (II)V
    //   471: aload_0
    //   472: getfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   475: getfield m : Z
    //   478: ifne -> 527
    //   481: aload_0
    //   482: aload_0
    //   483: getfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   486: invokevirtual b : ()Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   489: putfield aj : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   492: aload_0
    //   493: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   496: astore #16
    //   498: aload_0
    //   499: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   502: astore #17
    //   504: aload_0
    //   505: getfield ai : I
    //   508: istore_3
    //   509: aload #16
    //   511: aload #17
    //   513: iload_3
    //   514: aload_0
    //   515: getfield ao : F
    //   518: iload_3
    //   519: i2f
    //   520: fmul
    //   521: f2i
    //   522: invokeinterface a : (Lcom/scwang/smartrefresh/layout/api/RefreshKernel;II)V
    //   527: iload #4
    //   529: istore #5
    //   531: iload #6
    //   533: ifeq -> 561
    //   536: iload #4
    //   538: istore #5
    //   540: aload_0
    //   541: aload_0
    //   542: getfield A : Z
    //   545: invokevirtual a : (Z)Z
    //   548: ifeq -> 561
    //   551: iload #4
    //   553: aload #15
    //   555: invokevirtual getMeasuredHeight : ()I
    //   558: iadd
    //   559: istore #5
    //   561: aload_0
    //   562: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   565: astore #15
    //   567: iload #5
    //   569: istore_3
    //   570: aload #15
    //   572: ifnull -> 1078
    //   575: iload #5
    //   577: istore_3
    //   578: aload #15
    //   580: invokeinterface getView : ()Landroid/view/View;
    //   585: aload #14
    //   587: if_acmpne -> 1078
    //   590: aload_0
    //   591: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   594: invokeinterface getView : ()Landroid/view/View;
    //   599: astore #15
    //   601: aload #15
    //   603: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   606: checkcast com/scwang/smartrefresh/layout/SmartRefreshLayout$LayoutParams
    //   609: astore #16
    //   611: iload_1
    //   612: aload #16
    //   614: getfield leftMargin : I
    //   617: aload #16
    //   619: getfield rightMargin : I
    //   622: iadd
    //   623: aload #16
    //   625: getfield width : I
    //   628: invokestatic getChildMeasureSpec : (III)I
    //   631: istore #9
    //   633: aload_0
    //   634: getfield ak : I
    //   637: istore #4
    //   639: iload #4
    //   641: istore_3
    //   642: aload_0
    //   643: getfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   646: invokevirtual ordinal : ()I
    //   649: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.g : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   652: invokevirtual ordinal : ()I
    //   655: if_icmpge -> 875
    //   658: aload #16
    //   660: getfield height : I
    //   663: ifle -> 735
    //   666: aload #16
    //   668: getfield height : I
    //   671: aload #16
    //   673: getfield topMargin : I
    //   676: iadd
    //   677: aload #16
    //   679: getfield bottomMargin : I
    //   682: iadd
    //   683: istore #4
    //   685: iload #4
    //   687: istore_3
    //   688: aload_0
    //   689: getfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   692: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.e : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   695: invokevirtual a : (Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;)Z
    //   698: ifeq -> 875
    //   701: aload_0
    //   702: aload #16
    //   704: getfield height : I
    //   707: aload #16
    //   709: getfield topMargin : I
    //   712: iadd
    //   713: aload #16
    //   715: getfield bottomMargin : I
    //   718: iadd
    //   719: putfield ak : I
    //   722: aload_0
    //   723: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.e : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   726: putfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   729: iload #4
    //   731: istore_3
    //   732: goto -> 875
    //   735: iload #4
    //   737: istore_3
    //   738: aload #16
    //   740: getfield height : I
    //   743: bipush #-2
    //   745: if_icmpne -> 875
    //   748: aload_0
    //   749: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   752: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   757: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.e : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   760: if_acmpne -> 776
    //   763: iload #4
    //   765: istore_3
    //   766: aload_0
    //   767: getfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   770: getfield m : Z
    //   773: ifne -> 875
    //   776: iload_2
    //   777: invokestatic getSize : (I)I
    //   780: aload #16
    //   782: getfield bottomMargin : I
    //   785: isub
    //   786: aload #16
    //   788: getfield topMargin : I
    //   791: isub
    //   792: iconst_0
    //   793: invokestatic max : (II)I
    //   796: istore #10
    //   798: aload #15
    //   800: iload #9
    //   802: iload #10
    //   804: ldc_w -2147483648
    //   807: invokestatic makeMeasureSpec : (II)I
    //   810: invokevirtual measure : (II)V
    //   813: aload #15
    //   815: invokevirtual getMeasuredHeight : ()I
    //   818: istore #11
    //   820: iload #4
    //   822: istore_3
    //   823: iload #11
    //   825: ifle -> 875
    //   828: iload #11
    //   830: iload #10
    //   832: if_icmpeq -> 873
    //   835: aload_0
    //   836: getfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   839: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.c : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   842: invokevirtual a : (Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;)Z
    //   845: ifeq -> 873
    //   848: aload_0
    //   849: iload #11
    //   851: aload #16
    //   853: getfield topMargin : I
    //   856: iadd
    //   857: aload #16
    //   859: getfield bottomMargin : I
    //   862: iadd
    //   863: putfield ak : I
    //   866: aload_0
    //   867: getstatic com/scwang/smartrefresh/layout/constant/DimensionStatus.c : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   870: putfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   873: iconst_m1
    //   874: istore_3
    //   875: aload_0
    //   876: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   879: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   884: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.e : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   887: if_acmpne -> 899
    //   890: iload_2
    //   891: invokestatic getSize : (I)I
    //   894: istore #4
    //   896: goto -> 954
    //   899: iload_3
    //   900: istore #4
    //   902: aload_0
    //   903: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   906: invokeinterface getSpinnerStyle : ()Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   911: getstatic com/scwang/smartrefresh/layout/constant/SpinnerStyle.b : Lcom/scwang/smartrefresh/layout/constant/SpinnerStyle;
    //   914: if_acmpne -> 954
    //   917: iload_3
    //   918: istore #4
    //   920: iload #6
    //   922: ifne -> 954
    //   925: aload_0
    //   926: aload_0
    //   927: getfield B : Z
    //   930: invokevirtual a : (Z)Z
    //   933: ifeq -> 945
    //   936: aload_0
    //   937: getfield b : I
    //   940: ineg
    //   941: istore_3
    //   942: goto -> 947
    //   945: iconst_0
    //   946: istore_3
    //   947: iconst_0
    //   948: iload_3
    //   949: invokestatic max : (II)I
    //   952: istore #4
    //   954: iload #4
    //   956: iconst_m1
    //   957: if_icmpeq -> 991
    //   960: aload #15
    //   962: iload #9
    //   964: iload #4
    //   966: aload #16
    //   968: getfield bottomMargin : I
    //   971: isub
    //   972: aload #16
    //   974: getfield topMargin : I
    //   977: isub
    //   978: iconst_0
    //   979: invokestatic max : (II)I
    //   982: ldc_w 1073741824
    //   985: invokestatic makeMeasureSpec : (II)I
    //   988: invokevirtual measure : (II)V
    //   991: aload_0
    //   992: getfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   995: getfield m : Z
    //   998: ifne -> 1047
    //   1001: aload_0
    //   1002: aload_0
    //   1003: getfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   1006: invokevirtual b : ()Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   1009: putfield al : Lcom/scwang/smartrefresh/layout/constant/DimensionStatus;
    //   1012: aload_0
    //   1013: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   1016: astore #16
    //   1018: aload_0
    //   1019: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   1022: astore #17
    //   1024: aload_0
    //   1025: getfield ak : I
    //   1028: istore_3
    //   1029: aload #16
    //   1031: aload #17
    //   1033: iload_3
    //   1034: aload_0
    //   1035: getfield ap : F
    //   1038: iload_3
    //   1039: i2f
    //   1040: fmul
    //   1041: f2i
    //   1042: invokeinterface a : (Lcom/scwang/smartrefresh/layout/api/RefreshKernel;II)V
    //   1047: iload #5
    //   1049: istore_3
    //   1050: iload #6
    //   1052: ifeq -> 1078
    //   1055: iload #5
    //   1057: istore_3
    //   1058: aload_0
    //   1059: aload_0
    //   1060: getfield B : Z
    //   1063: invokevirtual a : (Z)Z
    //   1066: ifeq -> 1078
    //   1069: iload #5
    //   1071: aload #15
    //   1073: invokevirtual getMeasuredHeight : ()I
    //   1076: iadd
    //   1077: istore_3
    //   1078: aload_0
    //   1079: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   1082: astore #15
    //   1084: iload_3
    //   1085: istore #4
    //   1087: aload #15
    //   1089: ifnull -> 1356
    //   1092: iload_3
    //   1093: istore #4
    //   1095: aload #15
    //   1097: invokeinterface a : ()Landroid/view/View;
    //   1102: aload #14
    //   1104: if_acmpne -> 1356
    //   1107: aload_0
    //   1108: getfield au : Lcom/scwang/smartrefresh/layout/api/RefreshContent;
    //   1111: invokeinterface a : ()Landroid/view/View;
    //   1116: astore #14
    //   1118: aload #14
    //   1120: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
    //   1123: checkcast com/scwang/smartrefresh/layout/SmartRefreshLayout$LayoutParams
    //   1126: astore #15
    //   1128: aload_0
    //   1129: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   1132: ifnull -> 1167
    //   1135: aload_0
    //   1136: aload_0
    //   1137: getfield A : Z
    //   1140: invokevirtual a : (Z)Z
    //   1143: ifeq -> 1167
    //   1146: aload_0
    //   1147: aload_0
    //   1148: getfield E : Z
    //   1151: aload_0
    //   1152: getfield as : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   1155: invokevirtual a : (ZLcom/scwang/smartrefresh/layout/api/RefreshInternal;)Z
    //   1158: ifeq -> 1167
    //   1161: iconst_1
    //   1162: istore #5
    //   1164: goto -> 1170
    //   1167: iconst_0
    //   1168: istore #5
    //   1170: aload_0
    //   1171: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   1174: ifnull -> 1209
    //   1177: aload_0
    //   1178: aload_0
    //   1179: getfield B : Z
    //   1182: invokevirtual a : (Z)Z
    //   1185: ifeq -> 1209
    //   1188: aload_0
    //   1189: aload_0
    //   1190: getfield F : Z
    //   1193: aload_0
    //   1194: getfield at : Lcom/scwang/smartrefresh/layout/api/RefreshInternal;
    //   1197: invokevirtual a : (ZLcom/scwang/smartrefresh/layout/api/RefreshInternal;)Z
    //   1200: ifeq -> 1209
    //   1203: iconst_1
    //   1204: istore #4
    //   1206: goto -> 1212
    //   1209: iconst_0
    //   1210: istore #4
    //   1212: iload_1
    //   1213: aload_0
    //   1214: invokevirtual getPaddingLeft : ()I
    //   1217: aload_0
    //   1218: invokevirtual getPaddingRight : ()I
    //   1221: iadd
    //   1222: aload #15
    //   1224: getfield leftMargin : I
    //   1227: iadd
    //   1228: aload #15
    //   1230: getfield rightMargin : I
    //   1233: iadd
    //   1234: aload #15
    //   1236: getfield width : I
    //   1239: invokestatic getChildMeasureSpec : (III)I
    //   1242: istore #9
    //   1244: aload_0
    //   1245: invokevirtual getPaddingTop : ()I
    //   1248: istore #10
    //   1250: aload_0
    //   1251: invokevirtual getPaddingBottom : ()I
    //   1254: istore #11
    //   1256: aload #15
    //   1258: getfield topMargin : I
    //   1261: istore #12
    //   1263: aload #15
    //   1265: getfield bottomMargin : I
    //   1268: istore #13
    //   1270: iload #6
    //   1272: ifeq -> 1289
    //   1275: iload #5
    //   1277: ifeq -> 1289
    //   1280: aload_0
    //   1281: getfield ai : I
    //   1284: istore #5
    //   1286: goto -> 1292
    //   1289: iconst_0
    //   1290: istore #5
    //   1292: iload #6
    //   1294: ifeq -> 1311
    //   1297: iload #4
    //   1299: ifeq -> 1311
    //   1302: aload_0
    //   1303: getfield ak : I
    //   1306: istore #4
    //   1308: goto -> 1314
    //   1311: iconst_0
    //   1312: istore #4
    //   1314: aload #14
    //   1316: iload #9
    //   1318: iload_2
    //   1319: iload #10
    //   1321: iload #11
    //   1323: iadd
    //   1324: iload #12
    //   1326: iadd
    //   1327: iload #13
    //   1329: iadd
    //   1330: iload #5
    //   1332: iadd
    //   1333: iload #4
    //   1335: iadd
    //   1336: aload #15
    //   1338: getfield height : I
    //   1341: invokestatic getChildMeasureSpec : (III)I
    //   1344: invokevirtual measure : (II)V
    //   1347: iload_3
    //   1348: aload #14
    //   1350: invokevirtual getMeasuredHeight : ()I
    //   1353: iadd
    //   1354: istore #4
    //   1356: iload #7
    //   1358: iconst_1
    //   1359: iadd
    //   1360: istore #7
    //   1362: goto -> 35
    //   1365: aload_0
    //   1366: aload_0
    //   1367: invokespecial getSuggestedMinimumWidth : ()I
    //   1370: iload_1
    //   1371: invokestatic resolveSize : (II)I
    //   1374: iload #4
    //   1376: iload_2
    //   1377: invokestatic resolveSize : (II)I
    //   1380: invokespecial setMeasuredDimension : (II)V
    //   1383: aload_0
    //   1384: aload_0
    //   1385: invokevirtual getMeasuredWidth : ()I
    //   1388: iconst_2
    //   1389: idiv
    //   1390: i2f
    //   1391: putfield j : F
    //   1394: return
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return this.ag.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return ((this.aG && paramFloat2 > 0.0F) || a(Float.valueOf(-paramFloat2)) || this.ag.dispatchNestedPreFling(paramFloat1, paramFloat2));
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_0
    //   1: getfield ad : I
    //   4: istore #5
    //   6: iload_3
    //   7: iload #5
    //   9: imul
    //   10: ifle -> 134
    //   13: iload_3
    //   14: invokestatic abs : (I)I
    //   17: aload_0
    //   18: getfield ad : I
    //   21: invokestatic abs : (I)I
    //   24: if_icmple -> 41
    //   27: aload_0
    //   28: getfield ad : I
    //   31: istore #5
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield ad : I
    //   38: goto -> 54
    //   41: aload_0
    //   42: aload_0
    //   43: getfield ad : I
    //   46: iload_3
    //   47: isub
    //   48: putfield ad : I
    //   51: iload_3
    //   52: istore #5
    //   54: aload_0
    //   55: aload_0
    //   56: getfield ad : I
    //   59: i2f
    //   60: invokevirtual b : (F)V
    //   63: aload_0
    //   64: getfield aA : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   67: getfield v : Z
    //   70: ifne -> 87
    //   73: iload #5
    //   75: istore #6
    //   77: aload_0
    //   78: getfield aA : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   81: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.a : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   84: if_acmpne -> 171
    //   87: aload_0
    //   88: getfield b : I
    //   91: ifle -> 114
    //   94: aload_0
    //   95: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   98: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.b : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   101: invokeinterface a : (Lcom/scwang/smartrefresh/layout/constant/RefreshState;)Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   106: pop
    //   107: iload #5
    //   109: istore #6
    //   111: goto -> 171
    //   114: aload_0
    //   115: getfield ax : Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   118: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.c : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
    //   121: invokeinterface a : (Lcom/scwang/smartrefresh/layout/constant/RefreshState;)Lcom/scwang/smartrefresh/layout/api/RefreshKernel;
    //   126: pop
    //   127: iload #5
    //   129: istore #6
    //   131: goto -> 171
    //   134: iload_3
    //   135: ifle -> 168
    //   138: aload_0
    //   139: getfield aG : Z
    //   142: ifeq -> 168
    //   145: aload_0
    //   146: iload #5
    //   148: iload_3
    //   149: isub
    //   150: putfield ad : I
    //   153: aload_0
    //   154: aload_0
    //   155: getfield ad : I
    //   158: i2f
    //   159: invokevirtual b : (F)V
    //   162: iload_3
    //   163: istore #6
    //   165: goto -> 171
    //   168: iconst_0
    //   169: istore #6
    //   171: aload_0
    //   172: getfield ag : Landroidx/core/view/NestedScrollingChildHelper;
    //   175: iload_2
    //   176: iload_3
    //   177: iload #6
    //   179: isub
    //   180: aload #4
    //   182: aconst_null
    //   183: invokevirtual dispatchNestedPreScroll : (II[I[I)Z
    //   186: pop
    //   187: aload #4
    //   189: iconst_1
    //   190: aload #4
    //   192: iconst_1
    //   193: iaload
    //   194: iload #6
    //   196: iadd
    //   197: iastore
    //   198: return
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.ag.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.af);
    paramInt1 = paramInt4 + this.af[1];
    if (paramInt1 != 0 && (this.J || (paramInt1 < 0 && a(this.A)) || (paramInt1 > 0 && a(this.B)))) {
      if (this.aA == RefreshState.a) {
        RefreshState refreshState;
        RefreshKernel refreshKernel = this.ax;
        if (paramInt1 > 0) {
          refreshState = RefreshState.c;
        } else {
          refreshState = RefreshState.b;
        } 
        refreshKernel.a(refreshState);
      } 
      paramInt1 = this.ad - paramInt1;
      this.ad = paramInt1;
      b(paramInt1);
    } 
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.ah.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.ag.startNestedScroll(paramInt & 0x2);
    this.ad = this.b;
    this.ae = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    null = isEnabled();
    boolean bool = true;
    if (null && isNestedScrollingEnabled() && (paramInt & 0x2) != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    if (paramInt != 0) {
      null = bool;
      if (!this.J) {
        null = bool;
        if (!a(this.A)) {
          if (a(this.B))
            return true; 
        } else {
          return null;
        } 
      } else {
        return null;
      } 
    } 
    return false;
  }
  
  public void onStopNestedScroll(View paramView) {
    this.ah.onStopNestedScroll(paramView);
    this.ae = false;
    this.ad = 0;
    e();
    this.ag.stopNestedScroll();
  }
  
  public boolean post(Runnable paramRunnable) {
    List<DelayedRunnable> list;
    Handler handler = this.aw;
    if (handler == null) {
      List<DelayedRunnable> list1 = this.ay;
      list = list1;
      if (list1 == null)
        list = new ArrayList<DelayedRunnable>(); 
      this.ay = list;
      this.ay.add(new DelayedRunnable(paramRunnable, 0L));
      return false;
    } 
    return list.post((Runnable)new DelayedRunnable(paramRunnable, 0L));
  }
  
  public boolean postDelayed(Runnable paramRunnable, long paramLong) {
    List<DelayedRunnable> list;
    if (paramLong == 0L) {
      (new DelayedRunnable(paramRunnable, 0L)).run();
      return true;
    } 
    Handler handler = this.aw;
    if (handler == null) {
      List<DelayedRunnable> list1 = this.ay;
      list = list1;
      if (list1 == null)
        list = new ArrayList<DelayedRunnable>(); 
      this.ay = list;
      this.ay.add(new DelayedRunnable(paramRunnable, paramLong));
      return false;
    } 
    return list.postDelayed((Runnable)new DelayedRunnable(paramRunnable, 0L), paramLong);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    this.T = true;
    this.ag.setNestedScrollingEnabled(paramBoolean);
  }
  
  protected void setViceState(RefreshState paramRefreshState) {
    if (this.az.u && this.az.r != paramRefreshState.r)
      a(RefreshState.a); 
    if (this.aA != paramRefreshState)
      this.aA = paramRefreshState; 
  }
  
  public class BounceRunnable implements Runnable {
    int a = 0;
    
    int b = 10;
    
    int c;
    
    long d;
    
    float e = 0.0F;
    
    float f;
    
    BounceRunnable(SmartRefreshLayout this$0, float param1Float, int param1Int) {
      this.f = param1Float;
      this.c = param1Int;
      this.d = AnimationUtils.currentAnimationTimeMillis();
      this$0.postDelayed(this, this.b);
    }
    
    public void run() {
      if (this.g.aM == this && !this.g.az.w) {
        if (Math.abs(this.g.b) >= Math.abs(this.c)) {
          if (this.c != 0) {
            double d = this.f;
            int i = this.a + 1;
            this.a = i;
            this.f = (float)(d * Math.pow(0.44999998807907104D, (i * 2)));
          } else {
            double d = this.f;
            int i = this.a + 1;
            this.a = i;
            this.f = (float)(d * Math.pow(0.8500000238418579D, (i * 2)));
          } 
        } else {
          double d = this.f;
          int i = this.a + 1;
          this.a = i;
          this.f = (float)(d * Math.pow(0.949999988079071D, (i * 2)));
        } 
        long l = AnimationUtils.currentAnimationTimeMillis();
        float f = (float)(l - this.d) * 1.0F / 1000.0F;
        f = this.f * f;
        if (Math.abs(f) >= 1.0F) {
          this.d = l;
          this.e += f;
          this.g.b(this.e);
          this.g.postDelayed(this, this.b);
          return;
        } 
        SmartRefreshLayout smartRefreshLayout = this.g;
        smartRefreshLayout.aM = null;
        if (Math.abs(smartRefreshLayout.b) >= Math.abs(this.c)) {
          int i = Math.min(Math.max((int)DensityUtil.a(Math.abs(this.g.b - this.c)), 30), 100);
          smartRefreshLayout = this.g;
          smartRefreshLayout.a(this.c, 0, smartRefreshLayout.y, i * 10);
        } 
      } 
    }
  }
  
  public class FlingRunnable implements Runnable {
    int a;
    
    int b = 0;
    
    int c = 10;
    
    float d;
    
    float e = 0.98F;
    
    long f = 0L;
    
    long g = AnimationUtils.currentAnimationTimeMillis();
    
    FlingRunnable(SmartRefreshLayout this$0, float param1Float) {
      this.d = param1Float;
      this.a = this$0.b;
    }
    
    public Runnable a() {
      // Byte code:
      //   0: aload_0
      //   1: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   4: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   7: getfield w : Z
      //   10: ifeq -> 15
      //   13: aconst_null
      //   14: areturn
      //   15: aload_0
      //   16: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   19: getfield b : I
      //   22: ifeq -> 351
      //   25: aload_0
      //   26: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   29: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   32: getfield v : Z
      //   35: ifne -> 77
      //   38: aload_0
      //   39: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   42: getfield R : Z
      //   45: ifeq -> 177
      //   48: aload_0
      //   49: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   52: getfield G : Z
      //   55: ifeq -> 177
      //   58: aload_0
      //   59: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   62: astore #10
      //   64: aload #10
      //   66: aload #10
      //   68: getfield B : Z
      //   71: invokevirtual a : (Z)Z
      //   74: ifeq -> 177
      //   77: aload_0
      //   78: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   81: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   84: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.m : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   87: if_acmpeq -> 129
      //   90: aload_0
      //   91: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   94: getfield R : Z
      //   97: ifeq -> 147
      //   100: aload_0
      //   101: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   104: getfield G : Z
      //   107: ifeq -> 147
      //   110: aload_0
      //   111: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   114: astore #10
      //   116: aload #10
      //   118: aload #10
      //   120: getfield B : Z
      //   123: invokevirtual a : (Z)Z
      //   126: ifeq -> 147
      //   129: aload_0
      //   130: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   133: getfield b : I
      //   136: aload_0
      //   137: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   140: getfield ak : I
      //   143: ineg
      //   144: if_icmplt -> 177
      //   147: aload_0
      //   148: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   151: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   154: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.l : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   157: if_acmpne -> 351
      //   160: aload_0
      //   161: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   164: getfield b : I
      //   167: aload_0
      //   168: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   171: getfield ai : I
      //   174: if_icmple -> 351
      //   177: iconst_0
      //   178: istore #8
      //   180: aload_0
      //   181: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   184: getfield b : I
      //   187: istore #7
      //   189: aload_0
      //   190: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   193: getfield b : I
      //   196: istore #9
      //   198: aload_0
      //   199: getfield d : F
      //   202: fstore #5
      //   204: iload #9
      //   206: iload #7
      //   208: imul
      //   209: ifle -> 351
      //   212: fload #5
      //   214: f2d
      //   215: dstore_1
      //   216: aload_0
      //   217: getfield e : F
      //   220: f2d
      //   221: dstore_3
      //   222: iload #8
      //   224: iconst_1
      //   225: iadd
      //   226: istore #8
      //   228: dload_1
      //   229: dload_3
      //   230: aload_0
      //   231: getfield c : I
      //   234: iload #8
      //   236: imul
      //   237: bipush #10
      //   239: idiv
      //   240: i2d
      //   241: invokestatic pow : (DD)D
      //   244: dmul
      //   245: d2f
      //   246: fstore #5
      //   248: aload_0
      //   249: getfield c : I
      //   252: i2f
      //   253: fconst_1
      //   254: fmul
      //   255: ldc 1000.0
      //   257: fdiv
      //   258: fload #5
      //   260: fmul
      //   261: fstore #6
      //   263: fload #6
      //   265: invokestatic abs : (F)F
      //   268: fconst_1
      //   269: fcmpg
      //   270: ifge -> 339
      //   273: aload_0
      //   274: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   277: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   280: getfield v : Z
      //   283: ifeq -> 337
      //   286: aload_0
      //   287: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   290: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   293: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.l : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   296: if_acmpne -> 311
      //   299: iload #7
      //   301: aload_0
      //   302: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   305: getfield ai : I
      //   308: if_icmpgt -> 337
      //   311: aload_0
      //   312: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   315: getfield az : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   318: getstatic com/scwang/smartrefresh/layout/constant/RefreshState.l : Lcom/scwang/smartrefresh/layout/constant/RefreshState;
      //   321: if_acmpeq -> 351
      //   324: iload #7
      //   326: aload_0
      //   327: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   330: getfield ak : I
      //   333: ineg
      //   334: if_icmpge -> 351
      //   337: aconst_null
      //   338: areturn
      //   339: iload #7
      //   341: i2f
      //   342: fload #6
      //   344: fadd
      //   345: f2i
      //   346: istore #7
      //   348: goto -> 204
      //   351: aload_0
      //   352: invokestatic currentAnimationTimeMillis : ()J
      //   355: putfield f : J
      //   358: aload_0
      //   359: getfield h : Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;
      //   362: aload_0
      //   363: aload_0
      //   364: getfield c : I
      //   367: i2l
      //   368: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
      //   371: pop
      //   372: aload_0
      //   373: areturn
    }
    
    public void run() {
      if (this.h.aM == this && !this.h.az.w) {
        long l1 = AnimationUtils.currentAnimationTimeMillis();
        long l2 = this.g;
        this.d = (float)(this.d * Math.pow(this.e, ((l1 - this.f) / (1000 / this.c))));
        float f = this.d * (float)(l1 - l2) * 1.0F / 1000.0F;
        if (Math.abs(f) > 1.0F) {
          this.g = l1;
          this.a = (int)(this.a + f);
          if (this.h.b * this.a > 0) {
            this.h.ax.a(this.a, true);
            this.h.postDelayed(this, this.c);
            return;
          } 
          SmartRefreshLayout smartRefreshLayout = this.h;
          smartRefreshLayout.aM = null;
          smartRefreshLayout.ax.a(0, true);
          SmartUtil.a(this.h.au.b(), (int)-this.d);
          if (this.h.aG && f > 0.0F) {
            this.h.aG = false;
            return;
          } 
        } else {
          this.h.aM = null;
        } 
      } 
    }
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
    public int a = 0;
    
    public SpinnerStyle b = null;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.SmartRefreshLayout_Layout);
      this.a = typedArray.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.a);
      if (typedArray.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle))
        this.b = SpinnerStyle.values()[typedArray.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, SpinnerStyle.a.ordinal())]; 
      typedArray.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
  }
  
  public class RefreshKernelImpl implements RefreshKernel {
    public RefreshKernelImpl(SmartRefreshLayout this$0) {}
    
    public ValueAnimator a(int param1Int) {
      SmartRefreshLayout smartRefreshLayout = this.a;
      return smartRefreshLayout.a(param1Int, 0, smartRefreshLayout.y, this.a.f);
    }
    
    public RefreshKernel a(int param1Int, boolean param1Boolean) {
      if (this.a.b == param1Int && (this.a.as == null || !this.a.as.a()) && (this.a.at == null || !this.a.at.a()))
        return this; 
      SmartRefreshLayout smartRefreshLayout2 = this.a;
      int i = smartRefreshLayout2.b;
      SmartRefreshLayout smartRefreshLayout1 = this.a;
      smartRefreshLayout1.b = param1Int;
      if (param1Boolean && smartRefreshLayout1.aA.u)
        if (this.a.b > this.a.ai * this.a.aq) {
          if (this.a.az != RefreshState.h)
            this.a.ax.a(RefreshState.f); 
        } else if (-this.a.b > this.a.ak * this.a.ar && !this.a.R) {
          this.a.ax.a(RefreshState.g);
        } else if (this.a.b < 0 && !this.a.R) {
          this.a.ax.a(RefreshState.c);
        } else if (this.a.b > 0) {
          this.a.ax.a(RefreshState.b);
        }  
      RefreshContent refreshContent = this.a.au;
      boolean bool = true;
      if (refreshContent != null) {
        Integer integer1;
        RefreshContent refreshContent1 = null;
        refreshContent = refreshContent1;
        if (param1Int >= 0) {
          refreshContent = refreshContent1;
          if (this.a.as != null) {
            SmartRefreshLayout smartRefreshLayout = this.a;
            if (smartRefreshLayout.a(smartRefreshLayout.E, this.a.as)) {
              integer1 = Integer.valueOf(param1Int);
            } else {
              RefreshContent refreshContent2 = refreshContent1;
              if (i < 0)
                integer1 = Integer.valueOf(0); 
            } 
          } 
        } 
        Integer integer2 = integer1;
        if (param1Int <= 0) {
          integer2 = integer1;
          if (this.a.at != null) {
            SmartRefreshLayout smartRefreshLayout = this.a;
            if (smartRefreshLayout.a(smartRefreshLayout.F, this.a.at)) {
              Integer integer = Integer.valueOf(param1Int);
            } else {
              integer2 = integer1;
              if (i > 0)
                integer2 = Integer.valueOf(0); 
            } 
          } 
        } 
        if (integer2 != null) {
          boolean bool1;
          boolean bool2;
          this.a.au.a(integer2.intValue(), this.a.r, this.a.s);
          if (this.a.C && this.a.as != null && this.a.as.getSpinnerStyle() == SpinnerStyle.c) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (bool1 || this.a.aC != 0) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (this.a.D && this.a.at != null && this.a.at.getSpinnerStyle() == SpinnerStyle.c) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          if (bool2 || this.a.aD != 0) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          if ((bool1 && (integer2.intValue() >= 0 || i > 0)) || (bool2 && (integer2.intValue() <= 0 || i < 0)))
            smartRefreshLayout2.invalidate(); 
        } 
      } 
      if ((param1Int >= 0 || i > 0) && this.a.as != null) {
        int j;
        int k = Math.max(param1Int, 0);
        int m = this.a.ai;
        int n = (int)(this.a.ai * this.a.ao);
        float f = k;
        if (this.a.ai == 0) {
          j = 1;
        } else {
          j = this.a.ai;
        } 
        f = f * 1.0F / j;
        SmartRefreshLayout smartRefreshLayout = this.a;
        if (smartRefreshLayout.a(smartRefreshLayout.A) || (this.a.az == RefreshState.o && !param1Boolean)) {
          if (i != this.a.b) {
            if (this.a.as.getSpinnerStyle() == SpinnerStyle.a) {
              this.a.as.getView().setTranslationY(this.a.b);
              if (this.a.aC != 0 && this.a.av != null) {
                smartRefreshLayout = this.a;
                if (!smartRefreshLayout.a(smartRefreshLayout.E, this.a.as))
                  smartRefreshLayout2.invalidate(); 
              } 
            } else if (this.a.as.getSpinnerStyle() == SpinnerStyle.b) {
              this.a.as.getView().requestLayout();
            } 
            this.a.as.a(param1Boolean, f, k, m, n);
          } 
          if (param1Boolean && this.a.as.a()) {
            int i2 = (int)this.a.j;
            int i1 = smartRefreshLayout2.getWidth();
            float f1 = this.a.j;
            if (i1 == 0) {
              j = 1;
            } else {
              j = i1;
            } 
            f1 /= j;
            this.a.as.a(f1, i2, i1);
          } 
        } 
        if (i != this.a.b && this.a.ab != null && this.a.as instanceof RefreshHeader)
          this.a.ab.a((RefreshHeader)this.a.as, param1Boolean, f, k, m, n); 
      } 
      if ((param1Int <= 0 || i < 0) && this.a.at != null) {
        int j = -Math.min(param1Int, 0);
        int k = this.a.ak;
        int m = (int)(this.a.ak * this.a.ap);
        float f = j;
        if (this.a.ak == 0) {
          param1Int = 1;
        } else {
          param1Int = this.a.ak;
        } 
        f = f * 1.0F / param1Int;
        SmartRefreshLayout smartRefreshLayout = this.a;
        if (smartRefreshLayout.a(smartRefreshLayout.B) || (this.a.az == RefreshState.p && !param1Boolean)) {
          if (i != this.a.b) {
            if (this.a.at.getSpinnerStyle() == SpinnerStyle.a) {
              this.a.at.getView().setTranslationY(this.a.b);
              if (this.a.aD != 0 && this.a.av != null) {
                smartRefreshLayout = this.a;
                if (!smartRefreshLayout.a(smartRefreshLayout.F, this.a.at))
                  smartRefreshLayout2.invalidate(); 
              } 
            } else if (this.a.at.getSpinnerStyle() == SpinnerStyle.b) {
              this.a.at.getView().requestLayout();
            } 
            this.a.at.a(param1Boolean, f, j, k, m);
          } 
          if (param1Boolean && this.a.at.a()) {
            int i1 = (int)this.a.j;
            int n = smartRefreshLayout2.getWidth();
            float f1 = this.a.j;
            if (n == 0) {
              param1Int = bool;
            } else {
              param1Int = n;
            } 
            f1 /= param1Int;
            this.a.at.a(f1, i1, n);
          } 
        } 
        if (i != this.a.b && this.a.ab != null && this.a.at instanceof RefreshFooter)
          this.a.ab.a((RefreshFooter)this.a.at, param1Boolean, f, j, k, m); 
      } 
      return this;
    }
    
    public RefreshKernel a(RefreshInternal param1RefreshInternal, int param1Int) {
      if (this.a.av == null && param1Int != 0)
        this.a.av = new Paint(); 
      if (param1RefreshInternal.equals(this.a.as)) {
        this.a.aC = param1Int;
        return this;
      } 
      if (param1RefreshInternal.equals(this.a.at))
        this.a.aD = param1Int; 
      return this;
    }
    
    public RefreshKernel a(RefreshInternal param1RefreshInternal, boolean param1Boolean) {
      if (param1RefreshInternal.equals(this.a.as)) {
        this.a.aE = param1Boolean;
        return this;
      } 
      if (param1RefreshInternal.equals(this.a.at))
        this.a.aF = param1Boolean; 
      return this;
    }
    
    public RefreshKernel a(RefreshState param1RefreshState) {
      SmartRefreshLayout smartRefreshLayout;
      switch (SmartRefreshLayout.null.a[param1RefreshState.ordinal()]) {
        default:
          return null;
        case 17:
          this.a.a(RefreshState.n);
        case 16:
          this.a.a(RefreshState.q);
        case 15:
          this.a.a(RefreshState.i);
        case 14:
          if (this.a.az == RefreshState.m)
            this.a.a(RefreshState.p); 
        case 13:
          if (this.a.az == RefreshState.l)
            this.a.a(RefreshState.o); 
        case 12:
          this.a.b();
        case 11:
          this.a.c();
        case 10:
          if (!this.a.az.v) {
            SmartRefreshLayout smartRefreshLayout1 = this.a;
            if (smartRefreshLayout1.a(smartRefreshLayout1.B))
              this.a.a(RefreshState.k); 
          } 
          this.a.setViceState(RefreshState.k);
        case 9:
          if (!this.a.az.v) {
            SmartRefreshLayout smartRefreshLayout1 = this.a;
            if (smartRefreshLayout1.a(smartRefreshLayout1.A))
              this.a.a(RefreshState.j); 
          } 
          this.a.setViceState(RefreshState.j);
        case 8:
          if (!this.a.az.v) {
            SmartRefreshLayout smartRefreshLayout1 = this.a;
            if (smartRefreshLayout1.a(smartRefreshLayout1.A))
              this.a.a(RefreshState.h); 
          } 
          this.a.setViceState(RefreshState.h);
        case 7:
          smartRefreshLayout = this.a;
          if (smartRefreshLayout.a(smartRefreshLayout.B) && !this.a.az.v && !this.a.az.w && (!this.a.R || !this.a.G)) {
            this.a.a(RefreshState.g);
          } else {
            this.a.setViceState(RefreshState.g);
          } 
        case 6:
          if (!this.a.az.v) {
            smartRefreshLayout = this.a;
            if (smartRefreshLayout.a(smartRefreshLayout.A))
              this.a.a(RefreshState.f); 
          } 
          this.a.setViceState(RefreshState.f);
        case 5:
          smartRefreshLayout = this.a;
          if (smartRefreshLayout.a(smartRefreshLayout.B) && !this.a.az.v && (!this.a.R || !this.a.G)) {
            this.a.a(RefreshState.e);
            this.a.d();
          } else {
            this.a.setViceState(RefreshState.e);
          } 
        case 4:
          if (!this.a.az.v) {
            smartRefreshLayout = this.a;
            if (smartRefreshLayout.a(smartRefreshLayout.A)) {
              this.a.a(RefreshState.d);
              this.a.d();
            } 
          } 
          this.a.setViceState(RefreshState.d);
        case 3:
          smartRefreshLayout = this.a;
          if (smartRefreshLayout.a(smartRefreshLayout.B) && !this.a.az.v && !this.a.az.w && (!this.a.R || !this.a.G)) {
            this.a.a(RefreshState.c);
          } else {
            this.a.setViceState(RefreshState.c);
          } 
        case 2:
          if (!this.a.az.v) {
            smartRefreshLayout = this.a;
            if (smartRefreshLayout.a(smartRefreshLayout.A))
              this.a.a(RefreshState.b); 
          } 
          this.a.setViceState(RefreshState.b);
        case 1:
          break;
      } 
      this.a.d();
    }
    
    public RefreshKernel a(boolean param1Boolean) {
      if (param1Boolean) {
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this) {
            public void onAnimationEnd(Animator param2Animator) {
              this.a.a.ax.a(RefreshState.n);
            }
          };
        ValueAnimator valueAnimator = a(this.a.getMeasuredHeight());
        if (valueAnimator != null && valueAnimator == this.a.aN) {
          valueAnimator.setDuration(this.a.e);
          valueAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter);
          return this;
        } 
        animatorListenerAdapter.onAnimationEnd(null);
        return this;
      } 
      if (a(0) == null)
        this.a.a(RefreshState.a); 
      return this;
    }
    
    public RefreshLayout a() {
      return this.a;
    }
    
    public RefreshKernel b() {
      if (this.a.az == RefreshState.n) {
        this.a.ax.a(RefreshState.q);
        if (this.a.b == 0) {
          a(0, false);
          this.a.a(RefreshState.a);
          return this;
        } 
        a(0).setDuration(this.a.e);
      } 
      return this;
    }
    
    public RefreshKernel b(int param1Int) {
      this.a.e = param1Int;
      return this;
    }
  }
  
  class null extends AnimatorListenerAdapter {
    null(SmartRefreshLayout this$0) {}
    
    public void onAnimationEnd(Animator param1Animator) {
      this.a.a.ax.a(RefreshState.n);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\SmartRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */