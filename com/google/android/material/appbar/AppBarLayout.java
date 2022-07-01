package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
  private static final int a = R.style.Widget_Design_AppBarLayout;
  
  private int b;
  
  private int c = -1;
  
  private int d = -1;
  
  private int e = -1;
  
  private boolean f;
  
  private int g = 0;
  
  private WindowInsetsCompat h;
  
  private List<BaseOnOffsetChangedListener> i;
  
  private boolean j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private int n;
  
  private WeakReference<View> o;
  
  private ValueAnimator p;
  
  private int[] q;
  
  private Drawable r;
  
  public AppBarLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.appBarLayoutStyle);
  }
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21) {
      ViewUtilsLollipop.a((View)this);
      ViewUtilsLollipop.a((View)this, paramAttributeSet, paramInt, a);
    } 
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.AppBarLayout, paramInt, a, new int[0]);
    ViewCompat.setBackground((View)this, typedArray.getDrawable(R.styleable.AppBarLayout_android_background));
    if (getBackground() instanceof ColorDrawable) {
      ColorDrawable colorDrawable = (ColorDrawable)getBackground();
      MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
      materialShapeDrawable.g(ColorStateList.valueOf(colorDrawable.getColor()));
      materialShapeDrawable.a(paramContext);
      ViewCompat.setBackground((View)this, (Drawable)materialShapeDrawable);
    } 
    if (typedArray.hasValue(R.styleable.AppBarLayout_expanded))
      a(typedArray.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false); 
    if (Build.VERSION.SDK_INT >= 21 && typedArray.hasValue(R.styleable.AppBarLayout_elevation))
      ViewUtilsLollipop.a((View)this, typedArray.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0)); 
    if (Build.VERSION.SDK_INT >= 26) {
      if (typedArray.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster))
        setKeyboardNavigationCluster(typedArray.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false)); 
      if (typedArray.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus))
        setTouchscreenBlocksFocus(typedArray.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false)); 
    } 
    this.m = typedArray.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
    this.n = typedArray.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
    setStatusBarForeground(typedArray.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
    typedArray.recycle();
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener(this) {
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            return this.a.a(param1WindowInsetsCompat);
          }
        });
  }
  
  private void a(MaterialShapeDrawable paramMaterialShapeDrawable, boolean paramBoolean) {
    float f2;
    float f1 = getResources().getDimension(R.dimen.design_appbar_elevation);
    if (paramBoolean) {
      f2 = 0.0F;
    } else {
      f2 = f1;
    } 
    if (!paramBoolean)
      f1 = 0.0F; 
    ValueAnimator valueAnimator = this.p;
    if (valueAnimator != null)
      valueAnimator.cancel(); 
    this.p = ValueAnimator.ofFloat(new float[] { f2, f1 });
    this.p.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
    this.p.setInterpolator(AnimationUtils.a);
    this.p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, paramMaterialShapeDrawable) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            this.a.r(((Float)param1ValueAnimator.getAnimatedValue()).floatValue());
          }
        });
    this.p.start();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    byte b1;
    byte b2;
    if (paramBoolean1) {
      b1 = 1;
    } else {
      b1 = 2;
    } 
    byte b3 = 0;
    if (paramBoolean2) {
      b2 = 4;
    } else {
      b2 = 0;
    } 
    if (paramBoolean3)
      b3 = 8; 
    this.g = b1 | b2 | b3;
    requestLayout();
  }
  
  private View b(View paramView) {
    WeakReference<View> weakReference = this.o;
    View view = null;
    if (weakReference == null) {
      int i = this.n;
      if (i != -1) {
        if (paramView != null) {
          paramView = paramView.findViewById(i);
        } else {
          paramView = null;
        } 
        View view1 = paramView;
        if (paramView == null) {
          view1 = paramView;
          if (getParent() instanceof ViewGroup)
            view1 = ((ViewGroup)getParent()).findViewById(this.n); 
        } 
        if (view1 != null)
          this.o = new WeakReference<View>(view1); 
      } 
    } 
    weakReference = this.o;
    paramView = view;
    if (weakReference != null)
      paramView = weakReference.get(); 
    return paramView;
  }
  
  private boolean b(boolean paramBoolean) {
    if (this.k != paramBoolean) {
      this.k = paramBoolean;
      refreshDrawableState();
      return true;
    } 
    return false;
  }
  
  private void f() {
    setWillNotDraw(g() ^ true);
  }
  
  private boolean g() {
    return (this.r != null && getTopInset() > 0);
  }
  
  private boolean h() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      if (((LayoutParams)getChildAt(i).getLayoutParams()).c())
        return true; 
    } 
    return false;
  }
  
  private void i() {
    this.c = -1;
    this.d = -1;
    this.e = -1;
  }
  
  private void j() {
    WeakReference<View> weakReference = this.o;
    if (weakReference != null)
      weakReference.clear(); 
    this.o = null;
  }
  
  private boolean k() {
    int i = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0) {
      View view = getChildAt(0);
      bool1 = bool2;
      if (view.getVisibility() != 8) {
        bool1 = bool2;
        if (!ViewCompat.getFitsSystemWindows(view))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  WindowInsetsCompat a(WindowInsetsCompat paramWindowInsetsCompat) {
    WindowInsetsCompat windowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows((View)this)) {
      windowInsetsCompat = paramWindowInsetsCompat;
    } else {
      windowInsetsCompat = null;
    } 
    if (!ObjectsCompat.equals(this.h, windowInsetsCompat)) {
      this.h = windowInsetsCompat;
      f();
      requestLayout();
    } 
    return paramWindowInsetsCompat;
  }
  
  protected LayoutParams a() {
    return new LayoutParams(-1, -2);
  }
  
  public LayoutParams a(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    return (Build.VERSION.SDK_INT >= 19 && paramLayoutParams instanceof LinearLayout.LayoutParams) ? new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new LayoutParams(paramLayoutParams));
  }
  
  void a(int paramInt) {
    this.b = paramInt;
    if (!willNotDraw())
      ViewCompat.postInvalidateOnAnimation((View)this); 
    List<BaseOnOffsetChangedListener> list = this.i;
    if (list != null) {
      int i = 0;
      int j = list.size();
      while (i < j) {
        BaseOnOffsetChangedListener<AppBarLayout> baseOnOffsetChangedListener = this.i.get(i);
        if (baseOnOffsetChangedListener != null)
          baseOnOffsetChangedListener.onOffsetChanged(this, paramInt); 
        i++;
      } 
    } 
  }
  
  public void a(BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener) {
    if (this.i == null)
      this.i = new ArrayList<BaseOnOffsetChangedListener>(); 
    if (paramBaseOnOffsetChangedListener != null && !this.i.contains(paramBaseOnOffsetChangedListener))
      this.i.add(paramBaseOnOffsetChangedListener); 
  }
  
  public void a(OnOffsetChangedListener paramOnOffsetChangedListener) {
    a(paramOnOffsetChangedListener);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  boolean a(View paramView) {
    View view = b(paramView);
    if (view != null)
      paramView = view; 
    return (paramView != null && (paramView.canScrollVertically(-1) || paramView.getScrollY() > 0));
  }
  
  boolean a(boolean paramBoolean) {
    if (this.l != paramBoolean) {
      this.l = paramBoolean;
      refreshDrawableState();
      if (this.m && getBackground() instanceof MaterialShapeDrawable)
        a((MaterialShapeDrawable)getBackground(), paramBoolean); 
      return true;
    } 
    return false;
  }
  
  public void b(BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener) {
    List<BaseOnOffsetChangedListener> list = this.i;
    if (list != null && paramBaseOnOffsetChangedListener != null)
      list.remove(paramBaseOnOffsetChangedListener); 
  }
  
  public void b(OnOffsetChangedListener paramOnOffsetChangedListener) {
    b(paramOnOffsetChangedListener);
  }
  
  boolean b() {
    return this.f;
  }
  
  boolean c() {
    return (getTotalScrollRange() != 0);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public boolean d() {
    return this.m;
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    if (g()) {
      int i = paramCanvas.save();
      paramCanvas.translate(0.0F, -this.b);
      this.r.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    } 
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable drawable = this.r;
    if (drawable != null && drawable.isStateful() && drawable.setState(arrayOfInt))
      invalidateDrawable(drawable); 
  }
  
  void e() {
    this.g = 0;
  }
  
  public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
    return new Behavior();
  }
  
  int getDownNestedPreScrollRange() {
    int i = this.d;
    if (i != -1)
      return i; 
    int j = getChildCount() - 1;
    int k = 0;
    while (true) {
      if (j >= 0) {
        View view = getChildAt(j);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n = view.getMeasuredHeight();
        i = layoutParams.a;
        if ((i & 0x5) == 5) {
          int i1 = layoutParams.topMargin + layoutParams.bottomMargin;
          if ((i & 0x8) != 0) {
            i = ViewCompat.getMinimumHeight(view);
          } else if ((i & 0x2) != 0) {
            i = n - ViewCompat.getMinimumHeight(view);
          } else {
            i = i1 + n;
            i1 = i;
          } 
          i = i1 + i;
        } else {
          i = k;
          if (k)
            break; 
          j--;
          k = i;
        } 
      } else {
        break;
      } 
      int m = i;
    } 
    i = Math.max(0, k);
    this.d = i;
    return i;
  }
  
  int getDownNestedScrollRange() {
    int k;
    int i = this.e;
    if (i != -1)
      return i; 
    int m = getChildCount();
    int j = 0;
    i = 0;
    while (true) {
      k = i;
      if (j < m) {
        View view = getChildAt(j);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int i1 = view.getMeasuredHeight();
        int i2 = layoutParams.topMargin;
        int i3 = layoutParams.bottomMargin;
        int n = layoutParams.a;
        k = i;
        if ((n & 0x1) != 0) {
          i += i1 + i2 + i3;
          if ((n & 0x2) != 0) {
            k = i - ViewCompat.getMinimumHeight(view);
            break;
          } 
          j++;
          continue;
        } 
      } 
      break;
    } 
    i = Math.max(0, k);
    this.e = i;
    return i;
  }
  
  public int getLiftOnScrollTargetViewId() {
    return this.n;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent() {
    int j = getTopInset();
    int i = ViewCompat.getMinimumHeight((View)this);
    if (i == 0) {
      i = getChildCount();
      if (i >= 1) {
        i = ViewCompat.getMinimumHeight(getChildAt(i - 1));
      } else {
        i = 0;
      } 
      if (i == 0)
        return getHeight() / 3; 
    } 
    return i * 2 + j;
  }
  
  int getPendingAction() {
    return this.g;
  }
  
  public Drawable getStatusBarForeground() {
    return this.r;
  }
  
  @Deprecated
  public float getTargetElevation() {
    return 0.0F;
  }
  
  final int getTopInset() {
    WindowInsetsCompat windowInsetsCompat = this.h;
    return (windowInsetsCompat != null) ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
  }
  
  public final int getTotalScrollRange() {
    int k;
    int i = this.c;
    if (i != -1)
      return i; 
    int m = getChildCount();
    int j = 0;
    i = 0;
    while (true) {
      k = i;
      if (j < m) {
        View view = getChildAt(j);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int i1 = view.getMeasuredHeight();
        int n = layoutParams.a;
        k = i;
        if ((n & 0x1) != 0) {
          k = i + i1 + layoutParams.topMargin + layoutParams.bottomMargin;
          i = k;
          if (j == 0) {
            i = k;
            if (ViewCompat.getFitsSystemWindows(view))
              i = k - getTopInset(); 
          } 
          if ((n & 0x2) != 0) {
            k = i - ViewCompat.getMinimumHeight(view);
            break;
          } 
          j++;
          continue;
        } 
      } 
      break;
    } 
    i = Math.max(0, k);
    this.c = i;
    return i;
  }
  
  int getUpNestedPreScrollRange() {
    return getTotalScrollRange();
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    MaterialShapeUtils.a((View)this);
  }
  
  protected int[] onCreateDrawableState(int paramInt) {
    if (this.q == null)
      this.q = new int[4]; 
    int[] arrayOfInt1 = this.q;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    if (this.k) {
      paramInt = R.attr.state_liftable;
    } else {
      paramInt = -R.attr.state_liftable;
    } 
    arrayOfInt1[0] = paramInt;
    if (this.k && this.l) {
      paramInt = R.attr.state_lifted;
    } else {
      paramInt = -R.attr.state_lifted;
    } 
    arrayOfInt1[1] = paramInt;
    if (this.k) {
      paramInt = R.attr.state_collapsible;
    } else {
      paramInt = -R.attr.state_collapsible;
    } 
    arrayOfInt1[2] = paramInt;
    if (this.k && this.l) {
      paramInt = R.attr.state_collapsed;
    } else {
      paramInt = -R.attr.state_collapsed;
    } 
    arrayOfInt1[3] = paramInt;
    return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    j();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (ViewCompat.getFitsSystemWindows((View)this) && k()) {
      paramInt2 = getTopInset();
      for (paramInt1 = getChildCount() - 1; paramInt1 >= 0; paramInt1--)
        ViewCompat.offsetTopAndBottom(getChildAt(paramInt1), paramInt2); 
    } 
    i();
    paramBoolean = false;
    this.f = false;
    paramInt2 = getChildCount();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).b() != null) {
        this.f = true;
        break;
      } 
    } 
    Drawable drawable = this.r;
    if (drawable != null)
      drawable.setBounds(0, 0, getWidth(), getTopInset()); 
    if (!this.j) {
      if (this.m || h())
        paramBoolean = true; 
      b(paramBoolean);
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if (i != 1073741824 && ViewCompat.getFitsSystemWindows((View)this) && k()) {
      paramInt1 = getMeasuredHeight();
      if (i != Integer.MIN_VALUE) {
        if (i == 0)
          paramInt1 += getTopInset(); 
      } else {
        paramInt1 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(paramInt2));
      } 
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    } 
    i();
  }
  
  public void setElevation(float paramFloat) {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a((View)this, paramFloat);
  }
  
  public void setExpanded(boolean paramBoolean) {
    a(paramBoolean, ViewCompat.isLaidOut((View)this));
  }
  
  public void setLiftOnScroll(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setLiftOnScrollTargetViewId(int paramInt) {
    this.n = paramInt;
    j();
  }
  
  public void setOrientation(int paramInt) {
    if (paramInt == 1) {
      super.setOrientation(paramInt);
      return;
    } 
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  public void setStatusBarForeground(Drawable paramDrawable) {
    Drawable drawable = this.r;
    if (drawable != paramDrawable) {
      Drawable drawable1 = null;
      if (drawable != null)
        drawable.setCallback(null); 
      if (paramDrawable != null)
        drawable1 = paramDrawable.mutate(); 
      this.r = drawable1;
      paramDrawable = this.r;
      if (paramDrawable != null) {
        boolean bool;
        if (paramDrawable.isStateful())
          this.r.setState(getDrawableState()); 
        DrawableCompat.setLayoutDirection(this.r, ViewCompat.getLayoutDirection((View)this));
        paramDrawable = this.r;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        paramDrawable.setVisible(bool, false);
        this.r.setCallback((Drawable.Callback)this);
      } 
      f();
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  public void setStatusBarForegroundColor(int paramInt) {
    setStatusBarForeground((Drawable)new ColorDrawable(paramInt));
  }
  
  public void setStatusBarForegroundResource(int paramInt) {
    setStatusBarForeground(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat) {
    if (Build.VERSION.SDK_INT >= 21)
      ViewUtilsLollipop.a((View)this, paramFloat); 
  }
  
  public void setVisibility(int paramInt) {
    boolean bool;
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Drawable drawable = this.r;
    if (drawable != null)
      drawable.setVisible(bool, false); 
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.r);
  }
  
  public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
    private int b;
    
    private int c;
    
    private ValueAnimator d;
    
    private int e = -1;
    
    private boolean f;
    
    private float g;
    
    private WeakReference<View> h;
    
    private BaseDragCallback i;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    private int a(T param1T, int param1Int) {
      int j = param1T.getChildCount();
      for (int i = 0; i < j; i++) {
        View view = param1T.getChildAt(i);
        int i1 = view.getTop();
        int n = view.getBottom();
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)view.getLayoutParams();
        int m = i1;
        int k = n;
        if (a(layoutParams.a(), 32)) {
          m = i1 - layoutParams.topMargin;
          k = n + layoutParams.bottomMargin;
        } 
        n = -param1Int;
        if (m <= n && k >= n)
          return i; 
      } 
      return -1;
    }
    
    private View a(CoordinatorLayout param1CoordinatorLayout) {
      int j = param1CoordinatorLayout.getChildCount();
      int i = 0;
      while (i < j) {
        View view = param1CoordinatorLayout.getChildAt(i);
        if (!(view instanceof androidx.core.view.NestedScrollingChild) && !(view instanceof android.widget.ListView)) {
          if (view instanceof android.widget.ScrollView)
            return view; 
          i++;
          continue;
        } 
        return view;
      } 
      return null;
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int, float param1Float) {
      int i = Math.abs(a() - param1Int);
      param1Float = Math.abs(param1Float);
      if (param1Float > 0.0F) {
        i = Math.round(i / param1Float * 1000.0F) * 3;
      } else {
        i = (int)((i / param1T.getHeight() + 1.0F) * 150.0F);
      } 
      a(param1CoordinatorLayout, param1T, param1Int, i);
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2) {
      ValueAnimator valueAnimator1;
      int i = a();
      if (i == param1Int1) {
        valueAnimator1 = this.d;
        if (valueAnimator1 != null && valueAnimator1.isRunning())
          this.d.cancel(); 
        return;
      } 
      ValueAnimator valueAnimator2 = this.d;
      if (valueAnimator2 == null) {
        this.d = new ValueAnimator();
        this.d.setInterpolator(AnimationUtils.e);
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, (CoordinatorLayout)valueAnimator1, (AppBarLayout)param1T) {
              public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
                this.c.a_(this.a, this.b, ((Integer)param2ValueAnimator.getAnimatedValue()).intValue());
              }
            });
      } else {
        valueAnimator2.cancel();
      } 
      this.d.setDuration(Math.min(param1Int2, 600));
      this.d.setIntValues(new int[] { i, param1Int1 });
      this.d.start();
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_2
      //   1: iload_3
      //   2: invokestatic c : (Lcom/google/android/material/appbar/AppBarLayout;I)Landroid/view/View;
      //   5: astore #10
      //   7: aload #10
      //   9: ifnull -> 172
      //   12: aload #10
      //   14: invokevirtual getLayoutParams : ()Landroid/view/ViewGroup$LayoutParams;
      //   17: checkcast com/google/android/material/appbar/AppBarLayout$LayoutParams
      //   20: invokevirtual a : ()I
      //   23: istore #6
      //   25: iconst_0
      //   26: istore #9
      //   28: iload #9
      //   30: istore #8
      //   32: iload #6
      //   34: iconst_1
      //   35: iand
      //   36: ifeq -> 123
      //   39: aload #10
      //   41: invokestatic getMinimumHeight : (Landroid/view/View;)I
      //   44: istore #7
      //   46: iload #4
      //   48: ifle -> 87
      //   51: iload #6
      //   53: bipush #12
      //   55: iand
      //   56: ifeq -> 87
      //   59: iload #9
      //   61: istore #8
      //   63: iload_3
      //   64: ineg
      //   65: aload #10
      //   67: invokevirtual getBottom : ()I
      //   70: iload #7
      //   72: isub
      //   73: aload_2
      //   74: invokevirtual getTopInset : ()I
      //   77: isub
      //   78: if_icmplt -> 123
      //   81: iconst_1
      //   82: istore #8
      //   84: goto -> 123
      //   87: iload #9
      //   89: istore #8
      //   91: iload #6
      //   93: iconst_2
      //   94: iand
      //   95: ifeq -> 123
      //   98: iload #9
      //   100: istore #8
      //   102: iload_3
      //   103: ineg
      //   104: aload #10
      //   106: invokevirtual getBottom : ()I
      //   109: iload #7
      //   111: isub
      //   112: aload_2
      //   113: invokevirtual getTopInset : ()I
      //   116: isub
      //   117: if_icmplt -> 123
      //   120: goto -> 81
      //   123: aload_2
      //   124: invokevirtual d : ()Z
      //   127: ifeq -> 141
      //   130: aload_2
      //   131: aload_0
      //   132: aload_1
      //   133: invokespecial a : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;)Landroid/view/View;
      //   136: invokevirtual a : (Landroid/view/View;)Z
      //   139: istore #8
      //   141: aload_2
      //   142: iload #8
      //   144: invokevirtual a : (Z)Z
      //   147: istore #8
      //   149: iload #5
      //   151: ifne -> 168
      //   154: iload #8
      //   156: ifeq -> 172
      //   159: aload_0
      //   160: aload_1
      //   161: aload_2
      //   162: invokespecial e : (Landroidx/coordinatorlayout/widget/CoordinatorLayout;Lcom/google/android/material/appbar/AppBarLayout;)Z
      //   165: ifeq -> 172
      //   168: aload_2
      //   169: invokevirtual jumpDrawablesToCurrentState : ()V
      //   172: return
    }
    
    private void a(CoordinatorLayout param1CoordinatorLayout, T param1T, AccessibilityNodeInfoCompat.AccessibilityActionCompat param1AccessibilityActionCompat, boolean param1Boolean) {
      ViewCompat.replaceAccessibilityAction((View)param1CoordinatorLayout, param1AccessibilityActionCompat, null, new AccessibilityViewCommand(this, (AppBarLayout)param1T, param1Boolean) {
            public boolean perform(View param2View, AccessibilityViewCommand.CommandArguments param2CommandArguments) {
              this.a.setExpanded(this.b);
              return true;
            }
          });
    }
    
    private static boolean a(int param1Int1, int param1Int2) {
      return ((param1Int1 & param1Int2) == param1Int2);
    }
    
    private boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View) {
      return (param1T.c() && param1CoordinatorLayout.getHeight() - param1View.getHeight() <= param1T.getHeight());
    }
    
    private int b(T param1T, int param1Int) {
      int k = Math.abs(param1Int);
      int m = param1T.getChildCount();
      int j = 0;
      int i;
      for (i = 0; i < m; i++) {
        View view = param1T.getChildAt(i);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)view.getLayoutParams();
        Interpolator interpolator = layoutParams.b();
        if (k >= view.getTop() && k <= view.getBottom()) {
          if (interpolator != null) {
            m = layoutParams.a();
            i = j;
            if ((m & 0x1) != 0) {
              j = 0 + view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
              i = j;
              if ((m & 0x2) != 0)
                i = j - ViewCompat.getMinimumHeight(view); 
            } 
            j = i;
            if (ViewCompat.getFitsSystemWindows(view))
              j = i - param1T.getTopInset(); 
            if (j > 0) {
              i = view.getTop();
              float f = j;
              i = Math.round(f * interpolator.getInterpolation((k - i) / f));
              return Integer.signum(param1Int) * (view.getTop() + i);
            } 
          } 
          break;
        } 
      } 
      return param1Int;
    }
    
    private void b(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View) {
      if (a() != -param1T.getTotalScrollRange() && param1View.canScrollVertically(1))
        a(param1CoordinatorLayout, param1T, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false); 
      if (a() != 0)
        if (param1View.canScrollVertically(-1)) {
          int i = -param1T.getDownNestedPreScrollRange();
          if (i != 0) {
            ViewCompat.replaceAccessibilityAction((View)param1CoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AccessibilityViewCommand(this, param1CoordinatorLayout, (AppBarLayout)param1T, param1View, i) {
                  public boolean perform(View param2View, AccessibilityViewCommand.CommandArguments param2CommandArguments) {
                    this.e.a(this.a, this.b, this.c, 0, this.d, new int[] { 0, 0 }, 1);
                    return true;
                  }
                });
            return;
          } 
        } else {
          a(param1CoordinatorLayout, param1T, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
        }  
    }
    
    private static View c(AppBarLayout param1AppBarLayout, int param1Int) {
      int i = Math.abs(param1Int);
      int j = param1AppBarLayout.getChildCount();
      for (param1Int = 0; param1Int < j; param1Int++) {
        View view = param1AppBarLayout.getChildAt(param1Int);
        if (i >= view.getTop() && i <= view.getBottom())
          return view; 
      } 
      return null;
    }
    
    private void c(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      int j = a();
      int i = a(param1T, j);
      if (i >= 0) {
        View view = param1T.getChildAt(i);
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams)view.getLayoutParams();
        int k = layoutParams.a();
        if ((k & 0x11) == 17) {
          int i1 = -view.getTop();
          int m = -view.getBottom();
          int n = m;
          if (i == param1T.getChildCount() - 1)
            n = m + param1T.getTopInset(); 
          if (a(k, 2)) {
            m = n + ViewCompat.getMinimumHeight(view);
            i = i1;
          } else {
            i = i1;
            m = n;
            if (a(k, 5)) {
              m = ViewCompat.getMinimumHeight(view) + n;
              if (j < m) {
                i = m;
                m = n;
              } else {
                i = i1;
              } 
            } 
          } 
          i1 = i;
          n = m;
          if (a(k, 32)) {
            i1 = i + layoutParams.topMargin;
            n = m - layoutParams.bottomMargin;
          } 
          m = i1;
          if (j < (n + i1) / 2)
            m = n; 
          a(param1CoordinatorLayout, param1T, MathUtils.clamp(m, -param1T.getTotalScrollRange(), 0), 0.0F);
        } 
      } 
    }
    
    private void d(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      ViewCompat.removeAccessibilityAction((View)param1CoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
      ViewCompat.removeAccessibilityAction((View)param1CoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
      View view = a(param1CoordinatorLayout);
      if (view != null) {
        if (param1T.getTotalScrollRange() == 0)
          return; 
        if (!(((CoordinatorLayout.LayoutParams)view.getLayoutParams()).getBehavior() instanceof AppBarLayout.ScrollingViewBehavior))
          return; 
        b(param1CoordinatorLayout, param1T, view);
      } 
    }
    
    private boolean e(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      List<View> list = param1CoordinatorLayout.getDependents((View)param1T);
      int j = list.size();
      boolean bool = false;
      for (int i = 0; i < j; i++) {
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)((View)list.get(i)).getLayoutParams()).getBehavior();
        if (behavior instanceof AppBarLayout.ScrollingViewBehavior) {
          if (((AppBarLayout.ScrollingViewBehavior)behavior).d() != 0)
            bool = true; 
          return bool;
        } 
      } 
      return false;
    }
    
    int a() {
      return b() + this.b;
    }
    
    int a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2, int param1Int3) {
      int i = a();
      boolean bool = false;
      if (param1Int2 != 0 && i >= param1Int2 && i <= param1Int3) {
        param1Int2 = MathUtils.clamp(param1Int1, param1Int2, param1Int3);
        param1Int1 = bool;
        if (i != param1Int2) {
          if (param1T.b()) {
            param1Int1 = b(param1T, param1Int2);
          } else {
            param1Int1 = param1Int2;
          } 
          boolean bool1 = a(param1Int1);
          param1Int3 = i - param1Int2;
          this.b = param1Int2 - param1Int1;
          if (!bool1 && param1T.b())
            param1CoordinatorLayout.dispatchDependentViewsChanged((View)param1T); 
          param1T.a(b());
          if (param1Int2 < i) {
            param1Int1 = -1;
          } else {
            param1Int1 = 1;
          } 
          a(param1CoordinatorLayout, param1T, param1Int2, param1Int1, false);
          param1Int1 = param1Int3;
        } 
      } else {
        this.b = 0;
        param1Int1 = bool;
      } 
      d(param1CoordinatorLayout, param1T);
      return param1Int1;
    }
    
    void a(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      c(param1CoordinatorLayout, param1T);
      if (param1T.d())
        param1T.a(param1T.a(a(param1CoordinatorLayout))); 
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, Parcelable param1Parcelable) {
      SavedState savedState;
      if (param1Parcelable instanceof SavedState) {
        savedState = (SavedState)param1Parcelable;
        super.onRestoreInstanceState(param1CoordinatorLayout, (View)param1T, savedState.getSuperState());
        this.e = savedState.a;
        this.g = savedState.b;
        this.f = savedState.c;
        return;
      } 
      super.onRestoreInstanceState(param1CoordinatorLayout, (View)param1T, (Parcelable)savedState);
      this.e = -1;
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View, int param1Int) {
      if (this.c == 0 || param1Int == 1) {
        c(param1CoordinatorLayout, param1T);
        if (param1T.d())
          param1T.a(param1T.a(param1View)); 
      } 
      this.h = new WeakReference<View>(param1View);
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5, int[] param1ArrayOfint) {
      if (param1Int4 < 0)
        param1ArrayOfint[1] = b(param1CoordinatorLayout, param1T, param1Int4, -param1T.getDownNestedScrollRange(), 0); 
      if (param1Int4 == 0)
        d(param1CoordinatorLayout, param1T); 
    }
    
    public void a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View, int param1Int1, int param1Int2, int[] param1ArrayOfint, int param1Int3) {
      if (param1Int2 != 0) {
        if (param1Int2 < 0) {
          param1Int3 = -param1T.getTotalScrollRange();
          int i = param1T.getDownNestedPreScrollRange();
          param1Int1 = param1Int3;
          param1Int3 = i + param1Int3;
        } else {
          param1Int1 = -param1T.getUpNestedPreScrollRange();
          param1Int3 = 0;
        } 
        if (param1Int1 != param1Int3)
          param1ArrayOfint[1] = b(param1CoordinatorLayout, param1T, param1Int2, param1Int1, param1Int3); 
      } 
      if (param1T.d())
        param1T.a(param1T.a(param1View)); 
    }
    
    public void a(BaseDragCallback param1BaseDragCallback) {
      this.i = param1BaseDragCallback;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int) {
      boolean bool = super.onLayoutChild(param1CoordinatorLayout, param1T, param1Int);
      int i = param1T.getPendingAction();
      param1Int = this.e;
      if (param1Int >= 0 && (i & 0x8) == 0) {
        View view = param1T.getChildAt(param1Int);
        i = -view.getBottom();
        if (this.f) {
          param1Int = ViewCompat.getMinimumHeight(view) + param1T.getTopInset();
        } else {
          param1Int = Math.round(view.getHeight() * this.g);
        } 
        a_(param1CoordinatorLayout, param1T, i + param1Int);
      } else if (i != 0) {
        if ((i & 0x4) != 0) {
          param1Int = 1;
        } else {
          param1Int = 0;
        } 
        if ((i & 0x2) != 0) {
          i = -param1T.getUpNestedPreScrollRange();
          if (param1Int != 0) {
            a(param1CoordinatorLayout, param1T, i, 0.0F);
          } else {
            a_(param1CoordinatorLayout, param1T, i);
          } 
        } else if ((i & 0x1) != 0) {
          if (param1Int != 0) {
            a(param1CoordinatorLayout, param1T, 0, 0.0F);
          } else {
            a_(param1CoordinatorLayout, param1T, 0);
          } 
        } 
      } 
      param1T.e();
      this.e = -1;
      a(MathUtils.clamp(b(), -param1T.getTotalScrollRange(), 0));
      a(param1CoordinatorLayout, param1T, b(), 0, true);
      param1T.a(b());
      d(param1CoordinatorLayout, param1T);
      return bool;
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      if (((CoordinatorLayout.LayoutParams)param1T.getLayoutParams()).height == -2) {
        param1CoordinatorLayout.onMeasureChild((View)param1T, param1Int1, param1Int2, View.MeasureSpec.makeMeasureSpec(0, 0), param1Int4);
        return true;
      } 
      return super.onMeasureChild(param1CoordinatorLayout, (View)param1T, param1Int1, param1Int2, param1Int3, param1Int4);
    }
    
    public boolean a(CoordinatorLayout param1CoordinatorLayout, T param1T, View param1View1, View param1View2, int param1Int1, int param1Int2) {
      boolean bool;
      if ((param1Int1 & 0x2) != 0 && (param1T.d() || a(param1CoordinatorLayout, param1T, param1View1))) {
        bool = true;
      } else {
        bool = false;
      } 
      if (bool) {
        ValueAnimator valueAnimator = this.d;
        if (valueAnimator != null)
          valueAnimator.cancel(); 
      } 
      this.h = null;
      this.c = param1Int2;
      return bool;
    }
    
    boolean a(T param1T) {
      BaseDragCallback<T> baseDragCallback = this.i;
      if (baseDragCallback != null)
        return baseDragCallback.a(param1T); 
      WeakReference<View> weakReference = this.h;
      boolean bool = true;
      if (weakReference != null) {
        View view = weakReference.get();
        if (view != null && view.isShown() && !view.canScrollVertically(-1))
          return true; 
        bool = false;
      } 
      return bool;
    }
    
    int b(T param1T) {
      return -param1T.getDownNestedScrollRange();
    }
    
    public Parcelable b(CoordinatorLayout param1CoordinatorLayout, T param1T) {
      SavedState savedState;
      Parcelable parcelable = super.onSaveInstanceState(param1CoordinatorLayout, (View)param1T);
      int j = b();
      int k = param1T.getChildCount();
      boolean bool = false;
      for (int i = 0; i < k; i++) {
        View view = param1T.getChildAt(i);
        int m = view.getBottom() + j;
        if (view.getTop() + j <= 0 && m >= 0) {
          savedState = new SavedState(parcelable);
          savedState.a = i;
          if (m == ViewCompat.getMinimumHeight(view) + param1T.getTopInset())
            bool = true; 
          savedState.c = bool;
          savedState.b = m / view.getHeight();
          return (Parcelable)savedState;
        } 
      } 
      return (Parcelable)savedState;
    }
    
    int c(T param1T) {
      return param1T.getTotalScrollRange();
    }
    
    public static abstract class BaseDragCallback<T extends AppBarLayout> {
      public abstract boolean a(T param2T);
    }
    
    public static class SavedState extends AbsSavedState {
      public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
          public AppBarLayout.BaseBehavior.SavedState a(Parcel param3Parcel) {
            return new AppBarLayout.BaseBehavior.SavedState(param3Parcel, null);
          }
          
          public AppBarLayout.BaseBehavior.SavedState a(Parcel param3Parcel, ClassLoader param3ClassLoader) {
            return new AppBarLayout.BaseBehavior.SavedState(param3Parcel, param3ClassLoader);
          }
          
          public AppBarLayout.BaseBehavior.SavedState[] a(int param3Int) {
            return new AppBarLayout.BaseBehavior.SavedState[param3Int];
          }
        };
      
      int a;
      
      float b;
      
      boolean c;
      
      public SavedState(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        super(param2Parcel, param2ClassLoader);
        boolean bool;
        this.a = param2Parcel.readInt();
        this.b = param2Parcel.readFloat();
        if (param2Parcel.readByte() != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        this.c = bool;
      }
      
      public SavedState(Parcelable param2Parcelable) {
        super(param2Parcelable);
      }
      
      public void writeToParcel(Parcel param2Parcel, int param2Int) {
        super.writeToParcel(param2Parcel, param2Int);
        param2Parcel.writeInt(this.a);
        param2Parcel.writeFloat(this.b);
        param2Parcel.writeByte((byte)this.c);
      }
    }
    
    static final class null implements Parcelable.ClassLoaderCreator<SavedState> {
      public AppBarLayout.BaseBehavior.SavedState a(Parcel param2Parcel) {
        return new AppBarLayout.BaseBehavior.SavedState(param2Parcel, null);
      }
      
      public AppBarLayout.BaseBehavior.SavedState a(Parcel param2Parcel, ClassLoader param2ClassLoader) {
        return new AppBarLayout.BaseBehavior.SavedState(param2Parcel, param2ClassLoader);
      }
      
      public AppBarLayout.BaseBehavior.SavedState[] a(int param2Int) {
        return new AppBarLayout.BaseBehavior.SavedState[param2Int];
      }
    }
  }
  
  class null implements ValueAnimator.AnimatorUpdateListener {
    null(AppBarLayout this$0, CoordinatorLayout param1CoordinatorLayout, AppBarLayout param1AppBarLayout) {}
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      this.c.a_(this.a, this.b, ((Integer)param1ValueAnimator.getAnimatedValue()).intValue());
    }
  }
  
  class null implements AccessibilityViewCommand {
    null(AppBarLayout this$0, CoordinatorLayout param1CoordinatorLayout, AppBarLayout param1AppBarLayout, View param1View, int param1Int) {}
    
    public boolean perform(View param1View, AccessibilityViewCommand.CommandArguments param1CommandArguments) {
      this.e.a(this.a, this.b, this.c, 0, this.d, new int[] { 0, 0 }, 1);
      return true;
    }
  }
  
  class null implements AccessibilityViewCommand {
    null(AppBarLayout this$0, AppBarLayout param1AppBarLayout, boolean param1Boolean) {}
    
    public boolean perform(View param1View, AccessibilityViewCommand.CommandArguments param1CommandArguments) {
      this.a.setExpanded(this.b);
      return true;
    }
  }
  
  public static abstract class BaseDragCallback<T extends AppBarLayout> {
    public abstract boolean a(T param1T);
  }
  
  public static class SavedState extends AbsSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = (Parcelable.Creator<SavedState>)new Parcelable.ClassLoaderCreator<SavedState>() {
        public AppBarLayout.BaseBehavior.SavedState a(Parcel param3Parcel) {
          return new AppBarLayout.BaseBehavior.SavedState(param3Parcel, null);
        }
        
        public AppBarLayout.BaseBehavior.SavedState a(Parcel param3Parcel, ClassLoader param3ClassLoader) {
          return new AppBarLayout.BaseBehavior.SavedState(param3Parcel, param3ClassLoader);
        }
        
        public AppBarLayout.BaseBehavior.SavedState[] a(int param3Int) {
          return new AppBarLayout.BaseBehavior.SavedState[param3Int];
        }
      };
    
    int a;
    
    float b;
    
    boolean c;
    
    public SavedState(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      super(param1Parcel, param1ClassLoader);
      boolean bool;
      this.a = param1Parcel.readInt();
      this.b = param1Parcel.readFloat();
      if (param1Parcel.readByte() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      this.c = bool;
    }
    
    public SavedState(Parcelable param1Parcelable) {
      super(param1Parcelable);
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeInt(this.a);
      param1Parcel.writeFloat(this.b);
      param1Parcel.writeByte((byte)this.c);
    }
  }
  
  static final class null implements Parcelable.ClassLoaderCreator<BaseBehavior.SavedState> {
    public AppBarLayout.BaseBehavior.SavedState a(Parcel param1Parcel) {
      return new AppBarLayout.BaseBehavior.SavedState(param1Parcel, null);
    }
    
    public AppBarLayout.BaseBehavior.SavedState a(Parcel param1Parcel, ClassLoader param1ClassLoader) {
      return new AppBarLayout.BaseBehavior.SavedState(param1Parcel, param1ClassLoader);
    }
    
    public AppBarLayout.BaseBehavior.SavedState[] a(int param1Int) {
      return new AppBarLayout.BaseBehavior.SavedState[param1Int];
    }
  }
  
  public static interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
    void onOffsetChanged(T param1T, int param1Int);
  }
  
  public static class Behavior extends BaseBehavior<AppBarLayout> {
    public Behavior() {}
    
    public Behavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
    }
    
    public static abstract class DragCallback extends AppBarLayout.BaseBehavior.BaseDragCallback<AppBarLayout> {}
  }
  
  public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {}
  
  public static class LayoutParams extends LinearLayout.LayoutParams {
    int a = 1;
    
    Interpolator b;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.AppBarLayout_Layout);
      this.a = typedArray.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (typedArray.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator))
        this.b = AnimationUtils.loadInterpolator(param1Context, typedArray.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0)); 
      typedArray.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams param1MarginLayoutParams) {
      super(param1MarginLayoutParams);
    }
    
    public LayoutParams(LinearLayout.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public int a() {
      return this.a;
    }
    
    public void a(int param1Int) {
      this.a = param1Int;
    }
    
    public Interpolator b() {
      return this.b;
    }
    
    boolean c() {
      int i = this.a;
      return ((i & 0x1) == 1 && (i & 0xA) != 0);
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface ScrollFlags {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface ScrollFlags {}
  
  public static interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {}
  
  public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.ScrollingViewBehavior_Layout);
      b(typedArray.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
      typedArray.recycle();
    }
    
    private static int a(AppBarLayout param1AppBarLayout) {
      CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)param1AppBarLayout.getLayoutParams()).getBehavior();
      return (behavior instanceof AppBarLayout.BaseBehavior) ? ((AppBarLayout.BaseBehavior)behavior).a() : 0;
    }
    
    private void a(View param1View1, View param1View2) {
      CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams)param1View2.getLayoutParams()).getBehavior();
      if (behavior instanceof AppBarLayout.BaseBehavior) {
        behavior = behavior;
        ViewCompat.offsetTopAndBottom(param1View1, param1View2.getBottom() - param1View1.getTop() + AppBarLayout.BaseBehavior.a((AppBarLayout.BaseBehavior)behavior) + c() - c(param1View2));
      } 
    }
    
    private void b(View param1View1, View param1View2) {
      if (param1View2 instanceof AppBarLayout) {
        AppBarLayout appBarLayout = (AppBarLayout)param1View2;
        if (appBarLayout.d())
          appBarLayout.a(appBarLayout.a(param1View1)); 
      } 
    }
    
    float a(View param1View) {
      if (param1View instanceof AppBarLayout) {
        AppBarLayout appBarLayout = (AppBarLayout)param1View;
        int j = appBarLayout.getTotalScrollRange();
        int k = appBarLayout.getDownNestedPreScrollRange();
        int i = a(appBarLayout);
        if (k != 0 && j + i <= k)
          return 0.0F; 
        j -= k;
        if (j != 0)
          return i / j + 1.0F; 
      } 
      return 0.0F;
    }
    
    AppBarLayout a(List<View> param1List) {
      int j = param1List.size();
      for (int i = 0; i < j; i++) {
        View view = param1List.get(i);
        if (view instanceof AppBarLayout)
          return (AppBarLayout)view; 
      } 
      return null;
    }
    
    int b(View param1View) {
      return (param1View instanceof AppBarLayout) ? ((AppBarLayout)param1View).getTotalScrollRange() : super.b(param1View);
    }
    
    public boolean layoutDependsOn(CoordinatorLayout param1CoordinatorLayout, View param1View1, View param1View2) {
      return param1View2 instanceof AppBarLayout;
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout param1CoordinatorLayout, View param1View1, View param1View2) {
      a(param1View1, param1View2);
      b(param1View1, param1View2);
      return false;
    }
    
    public void onDependentViewRemoved(CoordinatorLayout param1CoordinatorLayout, View param1View1, View param1View2) {
      if (param1View2 instanceof AppBarLayout) {
        ViewCompat.removeAccessibilityAction((View)param1CoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction((View)param1CoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
      } 
    }
    
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout param1CoordinatorLayout, View param1View, Rect param1Rect, boolean param1Boolean) {
      AppBarLayout appBarLayout = a(param1CoordinatorLayout.getDependencies(param1View));
      if (appBarLayout != null) {
        param1Rect.offset(param1View.getLeft(), param1View.getTop());
        Rect rect = this.a;
        rect.set(0, 0, param1CoordinatorLayout.getWidth(), param1CoordinatorLayout.getHeight());
        if (!rect.contains(param1Rect)) {
          appBarLayout.a(false, param1Boolean ^ true);
          return true;
        } 
      } 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\appbar\AppBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */