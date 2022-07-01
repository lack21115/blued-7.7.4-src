package com.google.android.material.snackbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
  static final Handler a;
  
  private static final boolean d;
  
  private static final int[] e = new int[] { R.attr.snackbarStyle };
  
  private static final String f = BaseTransientBottomBar.class.getSimpleName();
  
  protected final SnackbarBaseLayout b;
  
  SnackbarManager.Callback c;
  
  private final ViewGroup g;
  
  private final Context h;
  
  private final ContentViewCallback i;
  
  private boolean j;
  
  private View k;
  
  private final Runnable l;
  
  private Rect m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private int r;
  
  private List<BaseCallback<B>> s;
  
  private Behavior t;
  
  private final AccessibilityManager u;
  
  static {
    a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
          public boolean handleMessage(Message param1Message) {
            int i = param1Message.what;
            if (i != 0) {
              if (i != 1)
                return false; 
              ((BaseTransientBottomBar)param1Message.obj).b(param1Message.arg1);
              return true;
            } 
            ((BaseTransientBottomBar)param1Message.obj).d();
            return true;
          }
        });
  }
  
  private ValueAnimator a(float... paramVarArgs) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(paramVarArgs);
    valueAnimator.setInterpolator(AnimationUtils.a);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            this.a.b.setAlpha(((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
          }
        });
    return valueAnimator;
  }
  
  private void a(CoordinatorLayout.LayoutParams paramLayoutParams) {
    Behavior behavior = this.t;
    SwipeDismissBehavior<? extends View> swipeDismissBehavior = behavior;
    if (behavior == null)
      swipeDismissBehavior = c(); 
    if (swipeDismissBehavior instanceof Behavior)
      Behavior.a((Behavior)swipeDismissBehavior, this); 
    swipeDismissBehavior.a(new SwipeDismissBehavior.OnDismissListener(this) {
          public void a(int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1 && param1Int != 2)
                return; 
              SnackbarManager.a().c(this.a.c);
              return;
            } 
            SnackbarManager.a().d(this.a.c);
          }
          
          public void a(View param1View) {
            param1View.setVisibility(8);
            this.a.a(0);
          }
        });
    paramLayoutParams.setBehavior((CoordinatorLayout.Behavior)swipeDismissBehavior);
    if (this.k == null)
      paramLayoutParams.insetEdge = 80; 
  }
  
  private ValueAnimator b(float... paramVarArgs) {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(paramVarArgs);
    valueAnimator.setInterpolator(AnimationUtils.d);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            this.a.b.setScaleX(f);
            this.a.b.setScaleY(f);
          }
        });
    return valueAnimator;
  }
  
  private void d(int paramInt) {
    if (this.b.getAnimationMode() == 1) {
      e(paramInt);
      return;
    } 
    f(paramInt);
  }
  
  private void e(int paramInt) {
    ValueAnimator valueAnimator = a(new float[] { 1.0F, 0.0F });
    valueAnimator.setDuration(75L);
    valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramInt) {
          public void onAnimationEnd(Animator param1Animator) {
            this.b.c(this.a);
          }
        });
    valueAnimator.start();
  }
  
  private void f(int paramInt) {
    ValueAnimator valueAnimator = new ValueAnimator();
    valueAnimator.setIntValues(new int[] { 0, s() });
    valueAnimator.setInterpolator(AnimationUtils.b);
    valueAnimator.setDuration(250L);
    valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramInt) {
          public void onAnimationEnd(Animator param1Animator) {
            this.b.c(this.a);
          }
          
          public void onAnimationStart(Animator param1Animator) {
            BaseTransientBottomBar.i(this.b).b(0, 180);
          }
        });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
          private int b = 0;
          
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.i()) {
              ViewCompat.offsetTopAndBottom((View)this.a.b, i - this.b);
            } else {
              this.a.b.setTranslationY(i);
            } 
            this.b = i;
          }
        });
    valueAnimator.start();
  }
  
  private void j() {
    int i;
    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.m == null) {
      Log.w(f, "Unable to update margins because layout params are not MarginLayoutParams");
      return;
    } 
    if (this.k != null) {
      i = this.r;
    } else {
      i = this.n;
    } 
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
    marginLayoutParams.bottomMargin = this.m.bottom + i;
    marginLayoutParams.leftMargin = this.m.left + this.o;
    marginLayoutParams.rightMargin = this.m.right + this.p;
    this.b.requestLayout();
    if (Build.VERSION.SDK_INT >= 29 && k()) {
      this.b.removeCallbacks(this.l);
      this.b.post(this.l);
    } 
  }
  
  private boolean k() {
    return (this.q > 0 && !this.j && l());
  }
  
  private boolean l() {
    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
    return (layoutParams instanceof CoordinatorLayout.LayoutParams && ((CoordinatorLayout.LayoutParams)layoutParams).getBehavior() instanceof SwipeDismissBehavior);
  }
  
  private void m() {
    if (g()) {
      e();
      return;
    } 
    this.b.setVisibility(0);
    f();
  }
  
  private int n() {
    int[] arrayOfInt = new int[2];
    this.b.getLocationOnScreen(arrayOfInt);
    return arrayOfInt[1] + this.b.getHeight();
  }
  
  private int o() {
    WindowManager windowManager = (WindowManager)this.h.getSystemService("window");
    DisplayMetrics displayMetrics = new DisplayMetrics();
    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
    return displayMetrics.heightPixels;
  }
  
  private int p() {
    View view = this.k;
    if (view == null)
      return 0; 
    int[] arrayOfInt2 = new int[2];
    view.getLocationOnScreen(arrayOfInt2);
    int i = arrayOfInt2[1];
    int[] arrayOfInt1 = new int[2];
    this.g.getLocationOnScreen(arrayOfInt1);
    return arrayOfInt1[1] + this.g.getHeight() - i;
  }
  
  private void q() {
    ValueAnimator valueAnimator1 = a(new float[] { 0.0F, 1.0F });
    ValueAnimator valueAnimator2 = b(new float[] { 0.8F, 1.0F });
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(new Animator[] { (Animator)valueAnimator1, (Animator)valueAnimator2 });
    animatorSet.setDuration(150L);
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.f();
          }
        });
    animatorSet.start();
  }
  
  private void r() {
    int i = s();
    if (d) {
      ViewCompat.offsetTopAndBottom((View)this.b, i);
    } else {
      this.b.setTranslationY(i);
    } 
    ValueAnimator valueAnimator = new ValueAnimator();
    valueAnimator.setIntValues(new int[] { i, 0 });
    valueAnimator.setInterpolator(AnimationUtils.b);
    valueAnimator.setDuration(250L);
    valueAnimator.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            this.a.f();
          }
          
          public void onAnimationStart(Animator param1Animator) {
            BaseTransientBottomBar.i(this.a).a(70, 180);
          }
        });
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, i) {
          private int c = this.a;
          
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            int i = ((Integer)param1ValueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.i()) {
              ViewCompat.offsetTopAndBottom((View)this.b.b, i - this.c);
            } else {
              this.b.b.setTranslationY(i);
            } 
            this.c = i;
          }
        });
    valueAnimator.start();
  }
  
  private int s() {
    int j = this.b.getHeight();
    ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
    int i = j;
    if (layoutParams instanceof ViewGroup.MarginLayoutParams)
      i = j + ((ViewGroup.MarginLayoutParams)layoutParams).bottomMargin; 
    return i;
  }
  
  public void a() {
    a(3);
  }
  
  protected void a(int paramInt) {
    SnackbarManager.a().a(this.c, paramInt);
  }
  
  final void b(int paramInt) {
    if (g() && this.b.getVisibility() == 0) {
      d(paramInt);
      return;
    } 
    c(paramInt);
  }
  
  public boolean b() {
    return SnackbarManager.a().e(this.c);
  }
  
  protected SwipeDismissBehavior<? extends View> c() {
    return new Behavior();
  }
  
  void c(int paramInt) {
    SnackbarManager.a().a(this.c);
    List<BaseCallback<B>> list = this.s;
    if (list != null)
      for (int i = list.size() - 1; i >= 0; i--)
        ((BaseCallback<BaseTransientBottomBar>)this.s.get(i)).a(this, paramInt);  
    ViewParent viewParent = this.b.getParent();
    if (viewParent instanceof ViewGroup)
      ((ViewGroup)viewParent).removeView((View)this.b); 
  }
  
  final void d() {
    this.b.setOnAttachStateChangeListener(new OnAttachStateChangeListener(this) {
          public void a(View param1View) {
            if (Build.VERSION.SDK_INT >= 29) {
              WindowInsets windowInsets = this.a.b.getRootWindowInsets();
              if (windowInsets != null) {
                BaseTransientBottomBar.d(this.a, (windowInsets.getMandatorySystemGestureInsets()).bottom);
                BaseTransientBottomBar.e(this.a);
              } 
            } 
          }
          
          public void b(View param1View) {
            if (this.a.b())
              BaseTransientBottomBar.a.post(new Runnable(this) {
                    public void run() {
                      this.a.a.c(3);
                    }
                  }); 
          }
        });
    if (this.b.getParent() == null) {
      ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
      if (layoutParams instanceof CoordinatorLayout.LayoutParams)
        a((CoordinatorLayout.LayoutParams)layoutParams); 
      this.r = p();
      j();
      this.b.setVisibility(4);
      this.g.addView((View)this.b);
    } 
    if (ViewCompat.isLaidOut((View)this.b)) {
      m();
      return;
    } 
    this.b.setOnLayoutChangeListener(new OnLayoutChangeListener(this) {
          public void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
            this.a.b.setOnLayoutChangeListener((BaseTransientBottomBar.OnLayoutChangeListener)null);
            BaseTransientBottomBar.f(this.a);
          }
        });
  }
  
  void e() {
    this.b.post(new Runnable(this) {
          public void run() {
            if (this.a.b == null)
              return; 
            this.a.b.setVisibility(0);
            if (this.a.b.getAnimationMode() == 1) {
              BaseTransientBottomBar.g(this.a);
              return;
            } 
            BaseTransientBottomBar.h(this.a);
          }
        });
  }
  
  void f() {
    SnackbarManager.a().b(this.c);
    List<BaseCallback<B>> list = this.s;
    if (list != null)
      for (int i = list.size() - 1; i >= 0; i--)
        ((BaseCallback<BaseTransientBottomBar>)this.s.get(i)).a(this);  
  }
  
  boolean g() {
    List list = this.u.getEnabledAccessibilityServiceList(1);
    return (list != null && list.isEmpty());
  }
  
  static {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19) {
      bool = true;
    } else {
      bool = false;
    } 
    d = bool;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AnimationMode {}
  
  public static abstract class BaseCallback<B> {
    public void a(B param1B) {}
    
    public void a(B param1B, int param1Int) {}
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface DismissEvent {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface DismissEvent {}
  
  public static class Behavior extends SwipeDismissBehavior<View> {
    private final BaseTransientBottomBar.BehaviorDelegate g = new BaseTransientBottomBar.BehaviorDelegate(this);
    
    private void a(BaseTransientBottomBar<?> param1BaseTransientBottomBar) {
      this.g.a(param1BaseTransientBottomBar);
    }
    
    public boolean a(View param1View) {
      return this.g.a(param1View);
    }
    
    public boolean onInterceptTouchEvent(CoordinatorLayout param1CoordinatorLayout, View param1View, MotionEvent param1MotionEvent) {
      this.g.a(param1CoordinatorLayout, param1View, param1MotionEvent);
      return super.onInterceptTouchEvent(param1CoordinatorLayout, param1View, param1MotionEvent);
    }
  }
  
  public static class BehaviorDelegate {
    private SnackbarManager.Callback a;
    
    public BehaviorDelegate(SwipeDismissBehavior<?> param1SwipeDismissBehavior) {
      param1SwipeDismissBehavior.a(0.1F);
      param1SwipeDismissBehavior.b(0.6F);
      param1SwipeDismissBehavior.a(0);
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, View param1View, MotionEvent param1MotionEvent) {
      int i = param1MotionEvent.getActionMasked();
      if (i != 0) {
        if (i != 1 && i != 3)
          return; 
        SnackbarManager.a().d(this.a);
        return;
      } 
      if (param1CoordinatorLayout.isPointInChildBounds(param1View, (int)param1MotionEvent.getX(), (int)param1MotionEvent.getY()))
        SnackbarManager.a().c(this.a); 
    }
    
    public void a(BaseTransientBottomBar<?> param1BaseTransientBottomBar) {
      this.a = param1BaseTransientBottomBar.c;
    }
    
    public boolean a(View param1View) {
      return param1View instanceof BaseTransientBottomBar.SnackbarBaseLayout;
    }
  }
  
  @Deprecated
  public static interface ContentViewCallback extends ContentViewCallback {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Duration {}
  
  public static interface OnAttachStateChangeListener {
    void a(View param1View);
    
    void b(View param1View);
  }
  
  public static interface OnLayoutChangeListener {
    void a(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4);
  }
  
  public static class SnackbarBaseLayout extends FrameLayout {
    private static final View.OnTouchListener a = new View.OnTouchListener() {
        public boolean onTouch(View param2View, MotionEvent param2MotionEvent) {
          return true;
        }
      };
    
    private BaseTransientBottomBar.OnLayoutChangeListener b;
    
    private BaseTransientBottomBar.OnAttachStateChangeListener c;
    
    private int d;
    
    private final float e;
    
    private final float f;
    
    private ColorStateList g;
    
    private PorterDuff.Mode h;
    
    protected SnackbarBaseLayout(Context param1Context) {
      this(param1Context, (AttributeSet)null);
    }
    
    protected SnackbarBaseLayout(Context param1Context, AttributeSet param1AttributeSet) {
      super(MaterialThemeOverlay.a(param1Context, param1AttributeSet, 0, 0), param1AttributeSet);
      param1Context = getContext();
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.SnackbarLayout);
      if (typedArray.hasValue(R.styleable.SnackbarLayout_elevation))
        ViewCompat.setElevation((View)this, typedArray.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0)); 
      this.d = typedArray.getInt(R.styleable.SnackbarLayout_animationMode, 0);
      this.e = typedArray.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0F);
      setBackgroundTintList(MaterialResources.a(param1Context, typedArray, R.styleable.SnackbarLayout_backgroundTint));
      setBackgroundTintMode(ViewUtils.a(typedArray.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
      this.f = typedArray.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0F);
      typedArray.recycle();
      setOnTouchListener(a);
      setFocusable(true);
      if (getBackground() == null)
        ViewCompat.setBackground((View)this, a()); 
    }
    
    private Drawable a() {
      Drawable drawable;
      float f = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
      GradientDrawable gradientDrawable = new GradientDrawable();
      gradientDrawable.setShape(0);
      gradientDrawable.setCornerRadius(f);
      gradientDrawable.setColor(MaterialColors.a((View)this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
      if (this.g != null) {
        drawable = DrawableCompat.wrap((Drawable)gradientDrawable);
        DrawableCompat.setTintList(drawable, this.g);
        return drawable;
      } 
      return DrawableCompat.wrap(drawable);
    }
    
    float getActionTextColorAlpha() {
      return this.f;
    }
    
    int getAnimationMode() {
      return this.d;
    }
    
    float getBackgroundOverlayColorAlpha() {
      return this.e;
    }
    
    protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
      if (onAttachStateChangeListener != null)
        onAttachStateChangeListener.a((View)this); 
      ViewCompat.requestApplyInsets((View)this);
    }
    
    protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      BaseTransientBottomBar.OnAttachStateChangeListener onAttachStateChangeListener = this.c;
      if (onAttachStateChangeListener != null)
        onAttachStateChangeListener.b((View)this); 
    }
    
    protected void onLayout(boolean param1Boolean, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      super.onLayout(param1Boolean, param1Int1, param1Int2, param1Int3, param1Int4);
      BaseTransientBottomBar.OnLayoutChangeListener onLayoutChangeListener = this.b;
      if (onLayoutChangeListener != null)
        onLayoutChangeListener.a((View)this, param1Int1, param1Int2, param1Int3, param1Int4); 
    }
    
    void setAnimationMode(int param1Int) {
      this.d = param1Int;
    }
    
    public void setBackground(Drawable param1Drawable) {
      setBackgroundDrawable(param1Drawable);
    }
    
    public void setBackgroundDrawable(Drawable param1Drawable) {
      Drawable drawable = param1Drawable;
      if (param1Drawable != null) {
        drawable = param1Drawable;
        if (this.g != null) {
          drawable = DrawableCompat.wrap(param1Drawable.mutate());
          DrawableCompat.setTintList(drawable, this.g);
          DrawableCompat.setTintMode(drawable, this.h);
        } 
      } 
      super.setBackgroundDrawable(drawable);
    }
    
    public void setBackgroundTintList(ColorStateList param1ColorStateList) {
      this.g = param1ColorStateList;
      if (getBackground() != null) {
        Drawable drawable = DrawableCompat.wrap(getBackground().mutate());
        DrawableCompat.setTintList(drawable, param1ColorStateList);
        DrawableCompat.setTintMode(drawable, this.h);
        if (drawable != getBackground())
          super.setBackgroundDrawable(drawable); 
      } 
    }
    
    public void setBackgroundTintMode(PorterDuff.Mode param1Mode) {
      this.h = param1Mode;
      if (getBackground() != null) {
        Drawable drawable = DrawableCompat.wrap(getBackground().mutate());
        DrawableCompat.setTintMode(drawable, param1Mode);
        if (drawable != getBackground())
          super.setBackgroundDrawable(drawable); 
      } 
    }
    
    void setOnAttachStateChangeListener(BaseTransientBottomBar.OnAttachStateChangeListener param1OnAttachStateChangeListener) {
      this.c = param1OnAttachStateChangeListener;
    }
    
    public void setOnClickListener(View.OnClickListener param1OnClickListener) {
      View.OnTouchListener onTouchListener;
      if (param1OnClickListener != null) {
        onTouchListener = null;
      } else {
        onTouchListener = a;
      } 
      setOnTouchListener(onTouchListener);
      super.setOnClickListener(param1OnClickListener);
    }
    
    void setOnLayoutChangeListener(BaseTransientBottomBar.OnLayoutChangeListener param1OnLayoutChangeListener) {
      this.b = param1OnLayoutChangeListener;
    }
  }
  
  static final class null implements View.OnTouchListener {
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      return true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\snackbar\BaseTransientBottomBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */