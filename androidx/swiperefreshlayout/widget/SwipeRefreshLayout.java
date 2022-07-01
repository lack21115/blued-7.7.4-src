package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
  public static final int DEFAULT = 1;
  
  public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
  
  private static final int[] E;
  
  public static final int LARGE = 0;
  
  private static final String n = SwipeRefreshLayout.class.getSimpleName();
  
  private boolean A;
  
  private int B = -1;
  
  private boolean C;
  
  private final DecelerateInterpolator D;
  
  private int F = -1;
  
  private Animation G;
  
  private Animation H;
  
  private Animation I;
  
  private Animation J;
  
  private Animation K;
  
  private int L;
  
  private OnChildScrollUpCallback M;
  
  private Animation.AnimationListener N = new Animation.AnimationListener(this) {
      public void onAnimationEnd(Animation param1Animation) {
        if (this.a.b) {
          this.a.k.setAlpha(255);
          this.a.k.start();
          if (this.a.l && this.a.a != null)
            this.a.a.onRefresh(); 
          SwipeRefreshLayout swipeRefreshLayout = this.a;
          swipeRefreshLayout.c = swipeRefreshLayout.e.getTop();
          return;
        } 
        this.a.a();
      }
      
      public void onAnimationRepeat(Animation param1Animation) {}
      
      public void onAnimationStart(Animation param1Animation) {}
    };
  
  private final Animation O = new Animation(this) {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        if (!this.a.m) {
          i = this.a.i - Math.abs(this.a.h);
        } else {
          i = this.a.i;
        } 
        int j = this.a.f;
        int i = (int)((i - this.a.f) * param1Float);
        int k = this.a.e.getTop();
        this.a.setTargetOffsetTopAndBottom(j + i - k);
        this.a.k.setArrowScale(1.0F - param1Float);
      }
    };
  
  private final Animation P = new Animation(this) {
      public void applyTransformation(float param1Float, Transformation param1Transformation) {
        this.a.a(param1Float);
      }
    };
  
  OnRefreshListener a;
  
  boolean b = false;
  
  int c;
  
  boolean d;
  
  CircleImageView e;
  
  protected int f;
  
  float g;
  
  protected int h;
  
  int i;
  
  int j;
  
  CircularProgressDrawable k;
  
  boolean l;
  
  boolean m;
  
  private View o;
  
  private int p;
  
  private float q = -1.0F;
  
  private float r;
  
  private final NestedScrollingParentHelper s;
  
  private final NestedScrollingChildHelper t;
  
  private final int[] u = new int[2];
  
  private final int[] v = new int[2];
  
  private boolean w;
  
  private int x;
  
  private float y;
  
  private float z;
  
  static {
    E = new int[] { 16842766 };
  }
  
  public SwipeRefreshLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.p = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.x = getResources().getInteger(17694721);
    setWillNotDraw(false);
    this.D = new DecelerateInterpolator(2.0F);
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    this.L = (int)(displayMetrics.density * 40.0F);
    b();
    setChildrenDrawingOrderEnabled(true);
    this.i = (int)(displayMetrics.density * 64.0F);
    this.q = this.i;
    this.s = new NestedScrollingParentHelper(this);
    this.t = new NestedScrollingChildHelper((View)this);
    setNestedScrollingEnabled(true);
    int i = -this.L;
    this.c = i;
    this.h = i;
    a(1.0F);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, E);
    setEnabled(typedArray.getBoolean(0, true));
    typedArray.recycle();
  }
  
  private Animation a(int paramInt1, int paramInt2) {
    Animation animation = new Animation(this, paramInt1, paramInt2) {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          CircularProgressDrawable circularProgressDrawable = this.c.k;
          int i = this.a;
          circularProgressDrawable.setAlpha((int)(i + (this.b - i) * param1Float));
        }
      };
    animation.setDuration(300L);
    this.e.setAnimationListener((Animation.AnimationListener)null);
    this.e.clearAnimation();
    this.e.startAnimation(animation);
    return animation;
  }
  
  private void a(int paramInt, Animation.AnimationListener paramAnimationListener) {
    this.f = paramInt;
    this.O.reset();
    this.O.setDuration(200L);
    this.O.setInterpolator((Interpolator)this.D);
    if (paramAnimationListener != null)
      this.e.setAnimationListener(paramAnimationListener); 
    this.e.clearAnimation();
    this.e.startAnimation(this.O);
  }
  
  private void a(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.B) {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      } 
      this.B = paramMotionEvent.getPointerId(i);
    } 
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.b != paramBoolean1) {
      this.l = paramBoolean2;
      e();
      this.b = paramBoolean1;
      if (this.b) {
        a(this.c, this.N);
        return;
      } 
      a(this.N);
    } 
  }
  
  private boolean a(Animation paramAnimation) {
    return (paramAnimation != null && paramAnimation.hasStarted() && !paramAnimation.hasEnded());
  }
  
  private void b() {
    this.e = new CircleImageView(getContext(), -328966);
    this.k = new CircularProgressDrawable(getContext());
    this.k.setStyle(1);
    this.e.setImageDrawable(this.k);
    this.e.setVisibility(8);
    addView((View)this.e);
  }
  
  private void b(float paramFloat) {
    this.k.setArrowEnabled(true);
    float f1 = Math.min(1.0F, Math.abs(paramFloat / this.q));
    float f2 = (float)Math.max(f1 - 0.4D, 0.0D) * 5.0F / 3.0F;
    float f4 = Math.abs(paramFloat);
    float f5 = this.q;
    int i = this.j;
    if (i <= 0)
      if (this.m) {
        i = this.i - this.h;
      } else {
        i = this.i;
      }  
    float f3 = i;
    double d = (Math.max(0.0F, Math.min(f4 - f5, f3 * 2.0F) / f3) / 4.0F);
    f4 = (float)(d - Math.pow(d, 2.0D)) * 2.0F;
    i = this.h;
    int j = (int)(f3 * f1 + f3 * f4 * 2.0F);
    if (this.e.getVisibility() != 0)
      this.e.setVisibility(0); 
    if (!this.d) {
      this.e.setScaleX(1.0F);
      this.e.setScaleY(1.0F);
    } 
    if (this.d)
      setAnimationProgress(Math.min(1.0F, paramFloat / this.q)); 
    if (paramFloat < this.q) {
      if (this.k.getAlpha() > 76 && !a(this.I))
        c(); 
    } else if (this.k.getAlpha() < 255 && !a(this.J)) {
      d();
    } 
    this.k.setStartEndTrim(0.0F, Math.min(0.8F, f2 * 0.8F));
    this.k.setArrowScale(Math.min(1.0F, f2));
    this.k.setProgressRotation((f2 * 0.4F - 0.25F + f4 * 2.0F) * 0.5F);
    setTargetOffsetTopAndBottom(i + j - this.c);
  }
  
  private void b(int paramInt, Animation.AnimationListener paramAnimationListener) {
    if (this.d) {
      c(paramInt, paramAnimationListener);
      return;
    } 
    this.f = paramInt;
    this.P.reset();
    this.P.setDuration(200L);
    this.P.setInterpolator((Interpolator)this.D);
    if (paramAnimationListener != null)
      this.e.setAnimationListener(paramAnimationListener); 
    this.e.clearAnimation();
    this.e.startAnimation(this.P);
  }
  
  private void b(Animation.AnimationListener paramAnimationListener) {
    this.e.setVisibility(0);
    this.k.setAlpha(255);
    this.G = new Animation(this) {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          this.a.setAnimationProgress(param1Float);
        }
      };
    this.G.setDuration(this.x);
    if (paramAnimationListener != null)
      this.e.setAnimationListener(paramAnimationListener); 
    this.e.clearAnimation();
    this.e.startAnimation(this.G);
  }
  
  private void c() {
    this.I = a(this.k.getAlpha(), 76);
  }
  
  private void c(float paramFloat) {
    if (paramFloat > this.q) {
      a(true, true);
      return;
    } 
    this.b = false;
    this.k.setStartEndTrim(0.0F, 0.0F);
    Animation.AnimationListener animationListener = null;
    if (!this.d)
      animationListener = new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            if (!this.a.d)
              this.a.a((Animation.AnimationListener)null); 
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        }; 
    b(this.c, animationListener);
    this.k.setArrowEnabled(false);
  }
  
  private void c(int paramInt, Animation.AnimationListener paramAnimationListener) {
    this.f = paramInt;
    this.g = this.e.getScaleX();
    this.K = new Animation(this) {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          float f1 = this.a.g;
          float f2 = -this.a.g;
          this.a.setAnimationProgress(f1 + f2 * param1Float);
          this.a.a(param1Float);
        }
      };
    this.K.setDuration(150L);
    if (paramAnimationListener != null)
      this.e.setAnimationListener(paramAnimationListener); 
    this.e.clearAnimation();
    this.e.startAnimation(this.K);
  }
  
  private void d() {
    this.J = a(this.k.getAlpha(), 255);
  }
  
  private void d(float paramFloat) {
    float f = this.z;
    int i = this.p;
    if (paramFloat - f > i && !this.A) {
      this.y = f + i;
      this.A = true;
      this.k.setAlpha(76);
    } 
  }
  
  private void e() {
    if (this.o == null)
      for (int i = 0; i < getChildCount(); i++) {
        View view = getChildAt(i);
        if (!view.equals(this.e)) {
          this.o = view;
          return;
        } 
      }  
  }
  
  private void setColorViewAlpha(int paramInt) {
    this.e.getBackground().setAlpha(paramInt);
    this.k.setAlpha(paramInt);
  }
  
  void a() {
    this.e.clearAnimation();
    this.k.stop();
    this.e.setVisibility(8);
    setColorViewAlpha(255);
    if (this.d) {
      setAnimationProgress(0.0F);
    } else {
      setTargetOffsetTopAndBottom(this.h - this.c);
    } 
    this.c = this.e.getTop();
  }
  
  void a(float paramFloat) {
    int i = this.f;
    setTargetOffsetTopAndBottom(i + (int)((this.h - i) * paramFloat) - this.e.getTop());
  }
  
  void a(Animation.AnimationListener paramAnimationListener) {
    this.H = new Animation(this) {
        public void applyTransformation(float param1Float, Transformation param1Transformation) {
          this.a.setAnimationProgress(1.0F - param1Float);
        }
      };
    this.H.setDuration(150L);
    this.e.setAnimationListener(paramAnimationListener);
    this.e.clearAnimation();
    this.e.startAnimation(this.H);
  }
  
  public boolean canChildScrollUp() {
    OnChildScrollUpCallback onChildScrollUpCallback = this.M;
    if (onChildScrollUpCallback != null)
      return onChildScrollUpCallback.canChildScrollUp(this, this.o); 
    View view = this.o;
    return (view instanceof ListView) ? ListViewCompat.canScrollList((ListView)view, -1) : view.canScrollVertically(-1);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return this.t.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    return this.t.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return this.t.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return this.t.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2) {
    int i = this.F;
    if (i < 0)
      return paramInt2; 
    if (paramInt2 == paramInt1 - 1)
      return i; 
    paramInt1 = paramInt2;
    if (paramInt2 >= i)
      paramInt1 = paramInt2 + 1; 
    return paramInt1;
  }
  
  public int getNestedScrollAxes() {
    return this.s.getNestedScrollAxes();
  }
  
  public int getProgressCircleDiameter() {
    return this.L;
  }
  
  public int getProgressViewEndOffset() {
    return this.i;
  }
  
  public int getProgressViewStartOffset() {
    return this.h;
  }
  
  public boolean hasNestedScrollingParent() {
    return this.t.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.t.isNestedScrollingEnabled();
  }
  
  public boolean isRefreshing() {
    return this.b;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    a();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    e();
    int i = paramMotionEvent.getActionMasked();
    if (this.C && i == 0)
      this.C = false; 
    if (isEnabled() && !this.C && !canChildScrollUp() && !this.b) {
      if (this.w)
        return false; 
      if (i != 0) {
        if (i != 1)
          if (i != 2) {
            if (i != 3) {
              if (i == 6)
                a(paramMotionEvent); 
              return this.A;
            } 
          } else {
            i = this.B;
            if (i == -1) {
              Log.e(n, "Got ACTION_MOVE event but don't have an active pointer id.");
              return false;
            } 
            i = paramMotionEvent.findPointerIndex(i);
            if (i < 0)
              return false; 
            d(paramMotionEvent.getY(i));
            return this.A;
          }  
        this.A = false;
        this.B = -1;
      } else {
        setTargetOffsetTopAndBottom(this.h - this.e.getTop());
        this.B = paramMotionEvent.getPointerId(0);
        this.A = false;
        i = paramMotionEvent.findPointerIndex(this.B);
        if (i < 0)
          return false; 
        this.z = paramMotionEvent.getY(i);
      } 
      return this.A;
    } 
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    if (getChildCount() == 0)
      return; 
    if (this.o == null)
      e(); 
    View view = this.o;
    if (view == null)
      return; 
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    view.layout(paramInt3, paramInt4, paramInt1 - getPaddingLeft() - getPaddingRight() + paramInt3, paramInt2 - getPaddingTop() - getPaddingBottom() + paramInt4);
    paramInt3 = this.e.getMeasuredWidth();
    paramInt2 = this.e.getMeasuredHeight();
    CircleImageView circleImageView = this.e;
    paramInt1 /= 2;
    paramInt3 /= 2;
    paramInt4 = this.c;
    circleImageView.layout(paramInt1 - paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    if (this.o == null)
      e(); 
    View view = this.o;
    if (view == null)
      return; 
    view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), 1073741824));
    this.e.measure(View.MeasureSpec.makeMeasureSpec(this.L, 1073741824), View.MeasureSpec.makeMeasureSpec(this.L, 1073741824));
    this.F = -1;
    for (paramInt1 = 0; paramInt1 < getChildCount(); paramInt1++) {
      if (getChildAt(paramInt1) == this.e) {
        this.F = paramInt1;
        return;
      } 
    } 
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    if (paramInt2 > 0) {
      float f = this.r;
      if (f > 0.0F) {
        float f1 = paramInt2;
        if (f1 > f) {
          paramArrayOfint[1] = paramInt2 - (int)f;
          this.r = 0.0F;
        } else {
          this.r = f - f1;
          paramArrayOfint[1] = paramInt2;
        } 
        b(this.r);
      } 
    } 
    if (this.m && paramInt2 > 0 && this.r == 0.0F && Math.abs(paramInt2 - paramArrayOfint[1]) > 0)
      this.e.setVisibility(8); 
    int[] arrayOfInt = this.u;
    if (dispatchNestedPreScroll(paramInt1 - paramArrayOfint[0], paramInt2 - paramArrayOfint[1], arrayOfInt, (int[])null)) {
      paramArrayOfint[0] = paramArrayOfint[0] + arrayOfInt[0];
      paramArrayOfint[1] = paramArrayOfint[1] + arrayOfInt[1];
    } 
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.v);
    paramInt1 = paramInt4 + this.v[1];
    if (paramInt1 < 0 && !canChildScrollUp()) {
      this.r += Math.abs(paramInt1);
      b(this.r);
    } 
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.s.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    startNestedScroll(paramInt & 0x2);
    this.r = 0.0F;
    this.w = true;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return (isEnabled() && !this.C && !this.b && (paramInt & 0x2) != 0);
  }
  
  public void onStopNestedScroll(View paramView) {
    this.s.onStopNestedScroll(paramView);
    this.w = false;
    float f = this.r;
    if (f > 0.0F) {
      c(f);
      this.r = 0.0F;
    } 
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (this.C && i == 0)
      this.C = false; 
    if (isEnabled() && !this.C && !canChildScrollUp() && !this.b) {
      if (this.w)
        return false; 
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i != 5) {
                if (i != 6)
                  return true; 
                a(paramMotionEvent);
                return true;
              } 
              i = paramMotionEvent.getActionIndex();
              if (i < 0) {
                Log.e(n, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
              } 
              this.B = paramMotionEvent.getPointerId(i);
              return true;
            } 
            return false;
          } 
          i = paramMotionEvent.findPointerIndex(this.B);
          if (i < 0) {
            Log.e(n, "Got ACTION_MOVE event but have an invalid active pointer id.");
            return false;
          } 
          float f = paramMotionEvent.getY(i);
          d(f);
          if (this.A) {
            f = (f - this.y) * 0.5F;
            if (f > 0.0F) {
              b(f);
              return true;
            } 
            return false;
          } 
        } else {
          i = paramMotionEvent.findPointerIndex(this.B);
          if (i < 0) {
            Log.e(n, "Got ACTION_UP event but don't have an active pointer id.");
            return false;
          } 
          if (this.A) {
            float f1 = paramMotionEvent.getY(i);
            float f2 = this.y;
            this.A = false;
            c((f1 - f2) * 0.5F);
          } 
          this.B = -1;
          return false;
        } 
      } else {
        this.B = paramMotionEvent.getPointerId(0);
        this.A = false;
      } 
      return true;
    } 
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 21 || !(this.o instanceof android.widget.AbsListView)) {
      View view = this.o;
      if (view != null && !ViewCompat.isNestedScrollingEnabled(view))
        return; 
      super.requestDisallowInterceptTouchEvent(paramBoolean);
    } 
  }
  
  void setAnimationProgress(float paramFloat) {
    this.e.setScaleX(paramFloat);
    this.e.setScaleY(paramFloat);
  }
  
  @Deprecated
  public void setColorScheme(int... paramVarArgs) {
    setColorSchemeResources(paramVarArgs);
  }
  
  public void setColorSchemeColors(int... paramVarArgs) {
    e();
    this.k.setColorSchemeColors(paramVarArgs);
  }
  
  public void setColorSchemeResources(int... paramVarArgs) {
    Context context = getContext();
    int[] arrayOfInt = new int[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++)
      arrayOfInt[i] = ContextCompat.getColor(context, paramVarArgs[i]); 
    setColorSchemeColors(arrayOfInt);
  }
  
  public void setDistanceToTriggerSync(int paramInt) {
    this.q = paramInt;
  }
  
  public void setEnabled(boolean paramBoolean) {
    super.setEnabled(paramBoolean);
    if (!paramBoolean)
      a(); 
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    this.t.setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnChildScrollUpCallback(OnChildScrollUpCallback paramOnChildScrollUpCallback) {
    this.M = paramOnChildScrollUpCallback;
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener) {
    this.a = paramOnRefreshListener;
  }
  
  @Deprecated
  public void setProgressBackgroundColor(int paramInt) {
    setProgressBackgroundColorSchemeResource(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeColor(int paramInt) {
    this.e.setBackgroundColor(paramInt);
  }
  
  public void setProgressBackgroundColorSchemeResource(int paramInt) {
    setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), paramInt));
  }
  
  public void setProgressViewEndTarget(boolean paramBoolean, int paramInt) {
    this.i = paramInt;
    this.d = paramBoolean;
    this.e.invalidate();
  }
  
  public void setProgressViewOffset(boolean paramBoolean, int paramInt1, int paramInt2) {
    this.d = paramBoolean;
    this.h = paramInt1;
    this.i = paramInt2;
    this.m = true;
    a();
    this.b = false;
  }
  
  public void setRefreshing(boolean paramBoolean) {
    if (paramBoolean && this.b != paramBoolean) {
      int i;
      this.b = paramBoolean;
      if (!this.m) {
        i = this.i + this.h;
      } else {
        i = this.i;
      } 
      setTargetOffsetTopAndBottom(i - this.c);
      this.l = false;
      b(this.N);
      return;
    } 
    a(paramBoolean, false);
  }
  
  public void setSize(int paramInt) {
    if (paramInt != 0 && paramInt != 1)
      return; 
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    if (paramInt == 0) {
      this.L = (int)(displayMetrics.density * 56.0F);
    } else {
      this.L = (int)(displayMetrics.density * 40.0F);
    } 
    this.e.setImageDrawable(null);
    this.k.setStyle(paramInt);
    this.e.setImageDrawable(this.k);
  }
  
  public void setSlingshotDistance(int paramInt) {
    this.j = paramInt;
  }
  
  void setTargetOffsetTopAndBottom(int paramInt) {
    this.e.bringToFront();
    ViewCompat.offsetTopAndBottom((View)this.e, paramInt);
    this.c = this.e.getTop();
  }
  
  public boolean startNestedScroll(int paramInt) {
    return this.t.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll() {
    this.t.stopNestedScroll();
  }
  
  public static interface OnChildScrollUpCallback {
    boolean canChildScrollUp(SwipeRefreshLayout param1SwipeRefreshLayout, View param1View);
  }
  
  public static interface OnRefreshListener {
    void onRefresh();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\swiperefreshlayout\widget\SwipeRefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */