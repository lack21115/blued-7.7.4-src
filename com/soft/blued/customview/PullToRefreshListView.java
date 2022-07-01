package com.soft.blued.customview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.PauseOnScrollListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PullToRefreshListView extends ListView implements AbsListView.OnScrollListener {
  private int A;
  
  private Context B;
  
  private View C;
  
  private View D;
  
  private TextView E;
  
  private View F;
  
  private int G;
  
  private int H = 0;
  
  private int I = 0;
  
  private boolean J = false;
  
  private float K;
  
  private View L;
  
  private ArrayList<View> M;
  
  private int N = 0;
  
  private boolean O = true;
  
  private boolean P = true;
  
  private int Q;
  
  private int R;
  
  private long S;
  
  private List<View> T;
  
  private boolean U = false;
  
  private View V;
  
  private FrameLayout W;
  
  int a = -1;
  
  private CustomOnScrollListner aa;
  
  public Map<String, AnimationSet> b;
  
  public final String c = "Positive Animation";
  
  public final String d = "Negative Animation";
  
  private float e;
  
  private float f;
  
  private float g;
  
  private float h;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private int l;
  
  private long m;
  
  private boolean n = false;
  
  private int o = 0;
  
  private Interpolator p;
  
  private SmoothScrollRunnable q;
  
  private OnRefreshListener r;
  
  private OnLoadMoreListener s;
  
  private RotateLayout t;
  
  private boolean u = false;
  
  private boolean v = false;
  
  private IOnTouchChangedListener w;
  
  private PauseOnScrollListener x = new PauseOnScrollListener(false, true);
  
  private boolean y = false;
  
  private int z = 0;
  
  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent) {
    return MotionEvent.obtain(paramMotionEvent.getDownTime(), SystemClock.uptimeMillis(), 3, paramMotionEvent.getX(), paramMotionEvent.getY(), 0);
  }
  
  private void a(float paramFloat) {
    View view = this.V;
    int i = (int)paramFloat;
    int k = this.o;
    int j = 0;
    view.setPadding(0, i - k, 0, 0);
    if (this.W != null)
      setHeaderBackgoundPulling(i - this.o); 
    List<View> list = this.T;
    if (list != null && list.size() > 0) {
      if (this.V.getPaddingTop() == 0) {
        i = 0;
      } else {
        i = 4;
      } 
      while (j < this.T.size()) {
        if (this.T.get(j) != null)
          ((View)this.T.get(j)).setVisibility(i); 
        j++;
      } 
    } 
  }
  
  private void a(View paramView) {
    if (((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin != 0) {
      ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { this.N, 0 });
      valueAnimator.setDuration(200L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
              layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
              this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
          });
      valueAnimator.start();
    } 
  }
  
  private void b(View paramView) {
    if (((LinearLayout.LayoutParams)paramView.getLayoutParams()).topMargin == 0) {
      ValueAnimator valueAnimator = ObjectAnimator.ofInt(new int[] { 0, this.N });
      valueAnimator.setDuration(200L);
      valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramView) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
              LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.a.getLayoutParams();
              layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
              this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
          });
      valueAnimator.start();
    } 
  }
  
  private void c() {
    ArrayList<View> arrayList = this.M;
    if (arrayList != null && arrayList.size() > 0)
      for (int i = 0; i < this.M.size(); i++)
        a(this.M.get(i));  
    this.O = true;
  }
  
  private void d() {
    ArrayList<View> arrayList = this.M;
    if (arrayList != null && arrayList.size() > 0)
      for (int i = 0; i < this.M.size(); i++)
        b(this.M.get(i));  
    this.O = false;
  }
  
  private void e() {
    this.u = true;
    this.t.b();
    int i = this.V.getPaddingTop();
    int j = this.o;
    this.q = new SmoothScrollRunnable(this, i + j, j, 300L, new OnSmoothScrollFinishedListener(this) {
          public void a() {
            if (PullToRefreshListView.a(this.a) != null)
              PullToRefreshListView.a(this.a).a(this.a); 
          }
        });
    postDelayed(this.q, 20L);
  }
  
  private boolean f() {
    if (getFirstVisiblePosition() <= 1) {
      View view = getChildAt(0);
      if (view != null)
        return (view.getTop() >= getTop()); 
    } 
    return false;
  }
  
  private void setHeaderBackgoundPulling(int paramInt) {
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.z + paramInt, this.A + paramInt);
    layoutParams.setMargins(-paramInt / 2, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
    FrameLayout frameLayout = this.W;
    if (frameLayout != null)
      frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams); 
  }
  
  private void setHeaderBgMarginTop(int paramInt) {
    FrameLayout frameLayout = this.W;
    if (frameLayout != null) {
      FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)frameLayout.getLayoutParams();
      layoutParams.setMargins(layoutParams.leftMargin, paramInt, layoutParams.rightMargin, layoutParams.bottomMargin);
      this.W.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  void a() {
    getInstance().setOnScrollListener(this);
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2) {
    int i = this.H;
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt1 != i) {
      if (paramInt1 <= i)
        bool1 = false; 
      this.H = paramInt1;
      this.I = paramInt2;
      return bool1;
    } 
    if (this.I <= paramInt2) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    this.I = paramInt2;
    return bool1;
  }
  
  public void b() {
    if (this.u)
      this.u = false; 
    this.t.e();
    if (this.v)
      this.v = false; 
    this.q = new SmoothScrollRunnable(this, this.V.getPaddingTop() + this.o, 0, 300L, new OnSmoothScrollFinishedListener(this) {
          public void a() {}
        });
    if (this.y)
      postDelayed(this.q, 20L); 
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public PullToRefreshListView getInstance() {
    return this;
  }
  
  public View getPullHeaderView() {
    return this.V;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    if (this.U)
      return false; 
    try {
      if (paramMotionEvent.getAction() == 0) {
        float f = paramMotionEvent.getY();
        this.h = f;
        this.f = f;
        f = paramMotionEvent.getX();
        this.g = f;
        this.e = f;
      } 
    } catch (Exception exception) {}
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {
    this.x.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 + paramInt2 == paramInt3 && paramInt3 > 0 && !this.u)
      boolean bool = this.v; 
    if (paramAbsListView.getChildAt(0) != null) {
      int i = paramAbsListView.getChildAt(0).getTop();
      long l = System.currentTimeMillis() - this.m;
      if (paramInt1 == 0 && i == 0) {
        if (!this.O)
          c(); 
      } else {
        int j = this.l;
        if (j < paramInt1) {
          if (this.O)
            d(); 
        } else if (j == paramInt1) {
          float f1 = this.k;
          float f2 = i;
          j = (int)Math.abs(f1 - f2);
          if (this.k < f2 && l != 0L && (j * 1000) / l > 2000L) {
            if (!this.O)
              c(); 
          } else if (this.k > f2 && j > 10 && this.O) {
            d();
          } 
        } 
      } 
      float f = Math.abs(i);
      this.J = a(paramAbsListView, paramInt1, (int)f);
      if (paramInt1 == 0) {
        if (this.W != null)
          setHeaderBgMarginTop(i); 
        if (this.C != null) {
          float f2 = DensityUtils.a(this.B, 100.0F);
          float f1 = f2;
          if (f >= f2)
            f1 = f; 
          setOverHeaderAlpha(f / f1);
        } 
      } else if (this.W != null) {
        setHeaderBgMarginTop(-this.A);
      } 
      if (this.b != null) {
        View view = this.F;
        if (view != null) {
          if (this.G == 0 && f >= this.K && this.J) {
            this.G = 1;
            view.setVisibility(0);
            this.F.clearAnimation();
            this.F.startAnimation((Animation)this.b.get("Positive Animation"));
          } 
          if (this.G == 1 && f <= this.K && !this.J && paramInt1 == 0) {
            this.G = 0;
            this.F.clearAnimation();
            this.F.startAnimation((Animation)this.b.get("Negative Animation"));
          } 
        } 
      } 
      this.l = paramInt1;
      this.k = i;
      this.m = System.currentTimeMillis();
    } 
    if (this.P && !this.u && !this.v && this.s != null) {
      ListAdapter listAdapter = (ListAdapter)paramAbsListView.getAdapter();
      if (listAdapter != null) {
        long l1 = System.currentTimeMillis();
        long l2 = this.S;
        if (l2 == 0L) {
          this.S = l1;
        } else if (paramInt1 > this.Q) {
          double d = (l1 - l2);
          this.R = paramAbsListView.getLastVisiblePosition();
          this.Q = paramInt1;
          this.S = l1;
          if (d <= 30.0D) {
            int j = this.R;
            int i = listAdapter.getCount();
            int k = listAdapter.getCount();
            if (i < 15) {
              i = (k - paramInt1) / 2;
            } else {
              i = k - 14;
            } 
            if (j >= i) {
              this.v = true;
              this.s.a(getInstance());
            } 
          } else if (d <= 220.0D) {
            int j = this.R;
            int i = listAdapter.getCount();
            int k = listAdapter.getCount();
            if (i < 15) {
              i = (k - paramInt1) / 2;
            } else {
              i = k - 12;
            } 
            if (j >= i) {
              this.v = true;
              this.s.a(getInstance());
            } 
          } else {
            int j = this.R;
            int i = listAdapter.getCount();
            int k = listAdapter.getCount();
            if (i < 15) {
              i = (k - paramInt1) * 2 / 3;
            } else {
              i = k - 10;
            } 
            if (j >= i) {
              this.v = true;
              this.s.a(getInstance());
            } 
          } 
        } 
      } 
    } 
    CustomOnScrollListner customOnScrollListner = this.aa;
    if (customOnScrollListner != null)
      customOnScrollListner.a(paramAbsListView, paramInt1, paramInt2, paramInt3); 
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {
    this.x.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0 && paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1 && !this.u && !this.v) {
      OnLoadMoreListener onLoadMoreListener = this.s;
      if (onLoadMoreListener != null) {
        this.v = true;
        onLoadMoreListener.a(getInstance());
      } 
    } 
    CustomOnScrollListner customOnScrollListner = this.aa;
    if (customOnScrollListner != null)
      customOnScrollListner.a(paramAbsListView, paramInt); 
    if (paramInt == 1)
      this.S = 0L; 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    try {
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
          if (i != 2) {
            if (i != 3)
              return super.onTouchEvent(paramMotionEvent); 
          } else {
            this.h = paramMotionEvent.getY();
            if (this.u || this.v)
              return super.onTouchEvent(paramMotionEvent); 
            if (this.w != null)
              if (this.h - this.f >= 0.0F) {
                if (this.V.getPaddingTop() > 0)
                  this.w.a(true); 
              } else {
                this.w.a(false);
              }  
            if (f()) {
              this.i = paramMotionEvent.getY();
              if (this.i != this.j) {
                float f1 = this.j;
                float f2 = this.i;
                this.j = this.i;
                if (this.h - this.f > 0.0F) {
                  this.n = true;
                  if (this.V.getPaddingTop() < 200) {
                    this.t.d();
                    this.t.a((f1 - f2) / 3.0F);
                  } else {
                    this.t.d();
                  } 
                  a((this.h - this.f) / 2.0F);
                  return super.onTouchEvent(a(paramMotionEvent));
                } 
              } 
            } else {
              float f = paramMotionEvent.getY();
              this.h = f;
              this.f = f;
              f = paramMotionEvent.getX();
              this.g = f;
              this.e = f;
            } 
            return super.onTouchEvent(paramMotionEvent);
          }  
        this.y = false;
        if (this.n) {
          this.n = false;
          this.h = paramMotionEvent.getY();
          if (this.h - this.f > AppMethods.a(150)) {
            this.y = false;
            e();
          } else {
            this.y = true;
            b();
            this.w.a(false);
          } 
        } 
      } else {
        if (this.u || this.v)
          return super.onTouchEvent(paramMotionEvent); 
        if (f()) {
          float f = paramMotionEvent.getY();
          this.f = f;
          this.h = f;
        } 
      } 
      return super.onTouchEvent(paramMotionEvent);
    } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
      arrayIndexOutOfBoundsException.printStackTrace();
      return false;
    } 
  }
  
  public void setCoverTransparent(View paramView) {
    this.L = paramView;
  }
  
  public void setCustomerOnScrollListner(CustomOnScrollListner paramCustomOnScrollListner) {
    this.aa = paramCustomOnScrollListner;
  }
  
  public void setIfDisallowIntercept(Boolean paramBoolean) {
    this.U = paramBoolean.booleanValue();
  }
  
  public final void setOnLoadMoreListener(OnLoadMoreListener paramOnLoadMoreListener) {
    this.s = paramOnLoadMoreListener;
  }
  
  public final void setOnRefreshListener(OnRefreshListener paramOnRefreshListener) {
    this.r = paramOnRefreshListener;
  }
  
  public void setOnTouchChangedListener(IOnTouchChangedListener paramIOnTouchChangedListener) {
    this.w = paramIOnTouchChangedListener;
  }
  
  public void setOverHeaderAlpha(float paramFloat) {
    if (this.C != null) {
      if (Build.VERSION.SDK_INT < 11) {
        this.C.getBackground().setAlpha((int)(paramFloat * 255.0F));
      } else {
        this.C.setAlpha(paramFloat);
      } 
      if (paramFloat <= 0.1D) {
        this.C.setVisibility(8);
      } else {
        this.C.setVisibility(0);
      } 
    } 
    String str3 = Integer.toHexString((int)(paramFloat * 255.0F));
    String str1 = str3;
    if (str3.length() == 1) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("0");
      stringBuilder.append(str3);
      str1 = stringBuilder.toString();
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("#");
    stringBuilder1.append(str1);
    stringBuilder1.append("000000");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("#");
    stringBuilder2.append(str1);
    stringBuilder2.append("e1e1e1");
    str1 = stringBuilder2.toString();
    TextView textView = this.E;
    if (textView != null)
      textView.setTextColor(Color.parseColor(str2)); 
    View view = this.D;
    if (view != null)
      view.setBackgroundColor(Color.parseColor(str1)); 
  }
  
  public void setPullHeaderView(View paramView) {
    this.V = paramView;
    addHeaderView(paramView);
    if (this.o == 0)
      this.o = paramView.getHeight(); 
    a(0.0F);
    if (this.p == null)
      this.p = (Interpolator)new DecelerateInterpolator(); 
  }
  
  public void setPullHeaderViewHeight(int paramInt) {
    this.o = paramInt;
    if (this.V != null)
      a(0.0F); 
  }
  
  public void setRotateLayout(RotateLayout paramRotateLayout) {
    this.t = paramRotateLayout;
  }
  
  public void setViewNeedToHideWhilePull(List<View> paramList) {
    this.T = new ArrayList<View>();
    this.T.addAll(paramList);
  }
  
  public static interface CustomOnScrollListner {
    void a(AbsListView param1AbsListView, int param1Int);
    
    void a(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3);
  }
  
  public static interface IOnTouchChangedListener {
    void a(boolean param1Boolean);
  }
  
  public static interface OnLoadMoreListener<V extends View> {
    void a(PullToRefreshListView param1PullToRefreshListView);
  }
  
  public static interface OnRefreshListener<V extends View> {
    void a(PullToRefreshListView param1PullToRefreshListView);
  }
  
  static interface OnSmoothScrollFinishedListener {
    void a();
  }
  
  final class SmoothScrollRunnable implements Runnable {
    private final Interpolator b;
    
    private final int c;
    
    private final int d;
    
    private final long e;
    
    private PullToRefreshListView.OnSmoothScrollFinishedListener f;
    
    private boolean g = true;
    
    private long h = -1L;
    
    private int i = -1;
    
    public SmoothScrollRunnable(PullToRefreshListView this$0, int param1Int1, int param1Int2, long param1Long, PullToRefreshListView.OnSmoothScrollFinishedListener param1OnSmoothScrollFinishedListener) {
      this.d = param1Int1;
      this.c = param1Int2;
      this.b = PullToRefreshListView.b(this$0);
      this.e = param1Long;
      this.f = param1OnSmoothScrollFinishedListener;
    }
    
    public void run() {
      if (this.h == -1L) {
        this.h = System.currentTimeMillis();
      } else {
        long l = Math.max(Math.min((System.currentTimeMillis() - this.h) * 1000L / this.e, 1000L), 0L);
        int i = Math.round((this.d - this.c) * this.b.getInterpolation((float)l / 1000.0F));
        this.i = this.d - i;
        PullToRefreshListView.a(this.a, this.i);
      } 
      if (this.g && this.c != this.i) {
        ViewCompat.postOnAnimation((View)this.a, this);
        return;
      } 
      PullToRefreshListView.OnSmoothScrollFinishedListener onSmoothScrollFinishedListener = this.f;
      if (onSmoothScrollFinishedListener != null)
        onSmoothScrollFinishedListener.a(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PullToRefreshListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */