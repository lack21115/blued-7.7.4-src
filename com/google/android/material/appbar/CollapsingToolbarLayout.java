package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class CollapsingToolbarLayout extends FrameLayout {
  private static final int e = R.style.Widget_Design_CollapsingToolbar;
  
  final CollapsingTextHelper a;
  
  Drawable b;
  
  int c;
  
  WindowInsetsCompat d;
  
  private boolean f = true;
  
  private int g;
  
  private Toolbar h;
  
  private View i;
  
  private View j;
  
  private int k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private final Rect o = new Rect();
  
  private boolean p;
  
  private boolean q;
  
  private Drawable r;
  
  private int s;
  
  private boolean t;
  
  private ValueAnimator u;
  
  private long v;
  
  private int w = -1;
  
  private AppBarLayout.OnOffsetChangedListener x;
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, e), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.a = new CollapsingTextHelper((View)this);
    this.a.a(AnimationUtils.e);
    TypedArray typedArray = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.CollapsingToolbarLayout, paramInt, e, new int[0]);
    this.a.a(typedArray.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
    this.a.b(typedArray.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
    paramInt = typedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
    this.n = paramInt;
    this.m = paramInt;
    this.l = paramInt;
    this.k = paramInt;
    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart))
      this.k = typedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0); 
    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd))
      this.m = typedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0); 
    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop))
      this.l = typedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0); 
    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom))
      this.n = typedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0); 
    this.p = typedArray.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
    setTitle(typedArray.getText(R.styleable.CollapsingToolbarLayout_title));
    this.a.d(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
    this.a.c(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance))
      this.a.d(typedArray.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0)); 
    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance))
      this.a.c(typedArray.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0)); 
    this.w = typedArray.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
    if (typedArray.hasValue(R.styleable.CollapsingToolbarLayout_maxLines))
      this.a.e(typedArray.getInt(R.styleable.CollapsingToolbarLayout_maxLines, 1)); 
    this.v = typedArray.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
    setContentScrim(typedArray.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
    setStatusBarScrim(typedArray.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
    this.g = typedArray.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
    typedArray.recycle();
    setWillNotDraw(false);
    ViewCompat.setOnApplyWindowInsetsListener((View)this, new OnApplyWindowInsetsListener(this) {
          public WindowInsetsCompat onApplyWindowInsets(View param1View, WindowInsetsCompat param1WindowInsetsCompat) {
            return this.a.a(param1WindowInsetsCompat);
          }
        });
  }
  
  static ViewOffsetHelper a(View paramView) {
    ViewOffsetHelper viewOffsetHelper2 = (ViewOffsetHelper)paramView.getTag(R.id.view_offset_helper);
    ViewOffsetHelper viewOffsetHelper1 = viewOffsetHelper2;
    if (viewOffsetHelper2 == null) {
      viewOffsetHelper1 = new ViewOffsetHelper(paramView);
      paramView.setTag(R.id.view_offset_helper, viewOffsetHelper1);
    } 
    return viewOffsetHelper1;
  }
  
  private void a(int paramInt) {
    TimeInterpolator timeInterpolator;
    c();
    ValueAnimator valueAnimator = this.u;
    if (valueAnimator == null) {
      this.u = new ValueAnimator();
      this.u.setDuration(this.v);
      ValueAnimator valueAnimator1 = this.u;
      if (paramInt > this.s) {
        timeInterpolator = AnimationUtils.c;
      } else {
        timeInterpolator = AnimationUtils.d;
      } 
      valueAnimator1.setInterpolator(timeInterpolator);
      this.u.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              this.a.setScrimAlpha(((Integer)param1ValueAnimator.getAnimatedValue()).intValue());
            }
          });
    } else if (timeInterpolator.isRunning()) {
      this.u.cancel();
    } 
    this.u.setIntValues(new int[] { this.s, paramInt });
    this.u.start();
  }
  
  private void c() {
    if (!this.f)
      return; 
    View view = null;
    this.h = null;
    this.i = null;
    int i = this.g;
    if (i != -1) {
      this.h = (Toolbar)findViewById(i);
      Toolbar toolbar = this.h;
      if (toolbar != null)
        this.i = d((View)toolbar); 
    } 
    if (this.h == null) {
      Toolbar toolbar;
      int j = getChildCount();
      i = 0;
      while (true) {
        View view1 = view;
        if (i < j) {
          view1 = getChildAt(i);
          if (view1 instanceof Toolbar) {
            toolbar = (Toolbar)view1;
            break;
          } 
          i++;
          continue;
        } 
        break;
      } 
      this.h = toolbar;
    } 
    d();
    this.f = false;
  }
  
  private boolean c(View paramView) {
    View view = this.i;
    return (view == null || view == this) ? ((paramView == this.h)) : ((paramView == view));
  }
  
  private View d(View paramView) {
    ViewParent viewParent2 = paramView.getParent();
    View view = paramView;
    for (ViewParent viewParent1 = viewParent2; viewParent1 != this && viewParent1 != null; viewParent1 = viewParent1.getParent()) {
      if (viewParent1 instanceof View)
        view = (View)viewParent1; 
    } 
    return view;
  }
  
  private void d() {
    if (!this.p) {
      View view = this.j;
      if (view != null) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof ViewGroup)
          ((ViewGroup)viewParent).removeView(this.j); 
      } 
    } 
    if (this.p && this.h != null) {
      if (this.j == null)
        this.j = new View(getContext()); 
      if (this.j.getParent() == null)
        this.h.addView(this.j, -1, -1); 
    } 
  }
  
  private static int e(View paramView) {
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
      ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
      return paramView.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    } 
    return paramView.getHeight();
  }
  
  private void e() {
    setContentDescription(getTitle());
  }
  
  protected FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams) {
    return new LayoutParams(paramLayoutParams);
  }
  
  WindowInsetsCompat a(WindowInsetsCompat paramWindowInsetsCompat) {
    WindowInsetsCompat windowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows((View)this)) {
      windowInsetsCompat = paramWindowInsetsCompat;
    } else {
      windowInsetsCompat = null;
    } 
    if (!ObjectsCompat.equals(this.d, windowInsetsCompat)) {
      this.d = windowInsetsCompat;
      requestLayout();
    } 
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }
  
  protected LayoutParams a() {
    return new LayoutParams(-1, -1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    if (this.t != paramBoolean1) {
      char c = 'ÿ';
      if (paramBoolean2) {
        if (!paramBoolean1)
          c = Character.MIN_VALUE; 
        a(c);
      } else {
        if (!paramBoolean1)
          c = Character.MIN_VALUE; 
        setScrimAlpha(c);
      } 
      this.t = paramBoolean1;
    } 
  }
  
  final int b(View paramView) {
    ViewOffsetHelper viewOffsetHelper = a(paramView);
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    return getHeight() - viewOffsetHelper.d() - paramView.getHeight() - layoutParams.bottomMargin;
  }
  
  final void b() {
    if (this.r != null || this.b != null) {
      boolean bool;
      if (getHeight() + this.c < getScrimVisibleHeightTrigger()) {
        bool = true;
      } else {
        bool = false;
      } 
      setScrimsShown(bool);
    } 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    c();
    if (this.h == null) {
      Drawable drawable = this.r;
      if (drawable != null && this.s > 0) {
        drawable.mutate().setAlpha(this.s);
        this.r.draw(paramCanvas);
      } 
    } 
    if (this.p && this.q)
      this.a.a(paramCanvas); 
    if (this.b != null && this.s > 0) {
      byte b;
      WindowInsetsCompat windowInsetsCompat = this.d;
      if (windowInsetsCompat != null) {
        b = windowInsetsCompat.getSystemWindowInsetTop();
      } else {
        b = 0;
      } 
      if (b) {
        this.b.setBounds(0, -this.c, getWidth(), b - this.c);
        this.b.mutate().setAlpha(this.s);
        this.b.draw(paramCanvas);
      } 
    } 
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong) {
    boolean bool1;
    Drawable drawable = this.r;
    boolean bool2 = true;
    if (drawable != null && this.s > 0 && c(paramView)) {
      this.r.mutate().setAlpha(this.s);
      this.r.draw(paramCanvas);
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (!super.drawChild(paramCanvas, paramView, paramLong)) {
      if (bool1)
        return true; 
      bool2 = false;
    } 
    return bool2;
  }
  
  protected void drawableStateChanged() {
    boolean bool2;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable drawable = this.b;
    int j = 0;
    int i = j;
    if (drawable != null) {
      i = j;
      if (drawable.isStateful())
        i = false | drawable.setState(arrayOfInt); 
    } 
    drawable = this.r;
    j = i;
    if (drawable != null) {
      j = i;
      if (drawable.isStateful())
        bool2 = i | drawable.setState(arrayOfInt); 
    } 
    CollapsingTextHelper collapsingTextHelper = this.a;
    boolean bool1 = bool2;
    if (collapsingTextHelper != null)
      bool1 = bool2 | collapsingTextHelper.a(arrayOfInt); 
    if (bool1)
      invalidate(); 
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getCollapsedTitleGravity() {
    return this.a.f();
  }
  
  public Typeface getCollapsedTitleTypeface() {
    return this.a.g();
  }
  
  public Drawable getContentScrim() {
    return this.r;
  }
  
  public int getExpandedTitleGravity() {
    return this.a.e();
  }
  
  public int getExpandedTitleMarginBottom() {
    return this.n;
  }
  
  public int getExpandedTitleMarginEnd() {
    return this.m;
  }
  
  public int getExpandedTitleMarginStart() {
    return this.k;
  }
  
  public int getExpandedTitleMarginTop() {
    return this.l;
  }
  
  public Typeface getExpandedTitleTypeface() {
    return this.a.h();
  }
  
  public int getMaxLines() {
    return this.a.n();
  }
  
  int getScrimAlpha() {
    return this.s;
  }
  
  public long getScrimAnimationDuration() {
    return this.v;
  }
  
  public int getScrimVisibleHeightTrigger() {
    int i = this.w;
    if (i >= 0)
      return i; 
    WindowInsetsCompat windowInsetsCompat = this.d;
    if (windowInsetsCompat != null) {
      i = windowInsetsCompat.getSystemWindowInsetTop();
    } else {
      i = 0;
    } 
    int j = ViewCompat.getMinimumHeight((View)this);
    return (j > 0) ? Math.min(j * 2 + i, getHeight()) : (getHeight() / 3);
  }
  
  public Drawable getStatusBarScrim() {
    return this.b;
  }
  
  public CharSequence getTitle() {
    return this.p ? this.a.m() : null;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ViewParent viewParent = getParent();
    if (viewParent instanceof AppBarLayout) {
      ViewCompat.setFitsSystemWindows((View)this, ViewCompat.getFitsSystemWindows((View)viewParent));
      if (this.x == null)
        this.x = new OffsetUpdateListener(this); 
      ((AppBarLayout)viewParent).a(this.x);
      ViewCompat.requestApplyInsets((View)this);
    } 
  }
  
  protected void onDetachedFromWindow() {
    ViewParent viewParent = getParent();
    AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.x;
    if (onOffsetChangedListener != null && viewParent instanceof AppBarLayout)
      ((AppBarLayout)viewParent).b(onOffsetChangedListener); 
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    WindowInsetsCompat windowInsetsCompat = this.d;
    boolean bool = false;
    if (windowInsetsCompat != null) {
      int m = windowInsetsCompat.getSystemWindowInsetTop();
      int n = getChildCount();
      int k;
      for (k = 0; k < n; k++) {
        View view = getChildAt(k);
        if (!ViewCompat.getFitsSystemWindows(view) && view.getTop() < m)
          ViewCompat.offsetTopAndBottom(view, m); 
      } 
    } 
    int j = getChildCount();
    int i;
    for (i = 0; i < j; i++)
      a(getChildAt(i)).a(); 
    if (this.p) {
      View view = this.j;
      if (view != null) {
        paramBoolean = ViewCompat.isAttachedToWindow(view);
        i = 1;
        if (paramBoolean && this.j.getVisibility() == 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        } 
        this.q = paramBoolean;
        if (this.q) {
          Toolbar toolbar;
          if (ViewCompat.getLayoutDirection((View)this) != 1)
            i = 0; 
          view = this.i;
          if (view == null)
            toolbar = this.h; 
          int m = b((View)toolbar);
          DescendantOffsetUtils.b((ViewGroup)this, this.j, this.o);
          CollapsingTextHelper collapsingTextHelper = this.a;
          int n = this.o.left;
          if (i != 0) {
            j = this.h.getTitleMarginEnd();
          } else {
            j = this.h.getTitleMarginStart();
          } 
          int i1 = this.o.top;
          int i2 = this.h.getTitleMarginTop();
          int i3 = this.o.right;
          if (i != 0) {
            k = this.h.getTitleMarginStart();
          } else {
            k = this.h.getTitleMarginEnd();
          } 
          collapsingTextHelper.b(n + j, i1 + m + i2, i3 - k, this.o.bottom + m - this.h.getTitleMarginBottom());
          collapsingTextHelper = this.a;
          if (i != 0) {
            j = this.m;
          } else {
            j = this.k;
          } 
          int k = this.o.top;
          m = this.l;
          if (i != 0) {
            i = this.k;
          } else {
            i = this.m;
          } 
          collapsingTextHelper.a(j, k + m, paramInt3 - paramInt1 - i, paramInt4 - paramInt2 - this.n);
          this.a.l();
        } 
      } 
    } 
    if (this.h != null) {
      if (this.p && TextUtils.isEmpty(this.a.m()))
        setTitle(this.h.getTitle()); 
      View view = this.i;
      if (view == null || view == this) {
        setMinimumHeight(e((View)this.h));
      } else {
        setMinimumHeight(e(view));
      } 
    } 
    b();
    paramInt2 = getChildCount();
    for (paramInt1 = bool; paramInt1 < paramInt2; paramInt1++)
      a(getChildAt(paramInt1)).b(); 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    c();
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    WindowInsetsCompat windowInsetsCompat = this.d;
    if (windowInsetsCompat != null) {
      paramInt2 = windowInsetsCompat.getSystemWindowInsetTop();
    } else {
      paramInt2 = 0;
    } 
    if (i == 0 && paramInt2 > 0)
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + paramInt2, 1073741824)); 
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable drawable = this.r;
    if (drawable != null)
      drawable.setBounds(0, 0, paramInt1, paramInt2); 
  }
  
  public void setCollapsedTitleGravity(int paramInt) {
    this.a.b(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(int paramInt) {
    this.a.c(paramInt);
  }
  
  public void setCollapsedTitleTextColor(int paramInt) {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(ColorStateList paramColorStateList) {
    this.a.a(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(Typeface paramTypeface) {
    this.a.a(paramTypeface);
  }
  
  public void setContentScrim(Drawable paramDrawable) {
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
        paramDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.r.setCallback((Drawable.Callback)this);
        this.r.setAlpha(this.s);
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  public void setContentScrimColor(int paramInt) {
    setContentScrim((Drawable)new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(int paramInt) {
    setContentScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(int paramInt) {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt) {
    this.a.a(paramInt);
  }
  
  public void setExpandedTitleMarginBottom(int paramInt) {
    this.n = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt) {
    this.m = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt) {
    this.k = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt) {
    this.l = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(int paramInt) {
    this.a.d(paramInt);
  }
  
  public void setExpandedTitleTextColor(ColorStateList paramColorStateList) {
    this.a.b(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(Typeface paramTypeface) {
    this.a.b(paramTypeface);
  }
  
  public void setMaxLines(int paramInt) {
    this.a.e(paramInt);
  }
  
  void setScrimAlpha(int paramInt) {
    if (paramInt != this.s) {
      if (this.r != null) {
        Toolbar toolbar = this.h;
        if (toolbar != null)
          ViewCompat.postInvalidateOnAnimation((View)toolbar); 
      } 
      this.s = paramInt;
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  public void setScrimAnimationDuration(long paramLong) {
    this.v = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(int paramInt) {
    if (this.w != paramInt) {
      this.w = paramInt;
      b();
    } 
  }
  
  public void setScrimsShown(boolean paramBoolean) {
    boolean bool;
    if (ViewCompat.isLaidOut((View)this) && !isInEditMode()) {
      bool = true;
    } else {
      bool = false;
    } 
    a(paramBoolean, bool);
  }
  
  public void setStatusBarScrim(Drawable paramDrawable) {
    Drawable drawable = this.b;
    if (drawable != paramDrawable) {
      Drawable drawable1 = null;
      if (drawable != null)
        drawable.setCallback(null); 
      if (paramDrawable != null)
        drawable1 = paramDrawable.mutate(); 
      this.b = drawable1;
      paramDrawable = this.b;
      if (paramDrawable != null) {
        boolean bool;
        if (paramDrawable.isStateful())
          this.b.setState(getDrawableState()); 
        DrawableCompat.setLayoutDirection(this.b, ViewCompat.getLayoutDirection((View)this));
        paramDrawable = this.b;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        paramDrawable.setVisible(bool, false);
        this.b.setCallback((Drawable.Callback)this);
        this.b.setAlpha(this.s);
      } 
      ViewCompat.postInvalidateOnAnimation((View)this);
    } 
  }
  
  public void setStatusBarScrimColor(int paramInt) {
    setStatusBarScrim((Drawable)new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(int paramInt) {
    setStatusBarScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.a.a(paramCharSequence);
    e();
  }
  
  public void setTitleEnabled(boolean paramBoolean) {
    if (paramBoolean != this.p) {
      this.p = paramBoolean;
      e();
      d();
      requestLayout();
    } 
  }
  
  public void setVisibility(int paramInt) {
    boolean bool;
    super.setVisibility(paramInt);
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Drawable drawable = this.b;
    if (drawable != null && drawable.isVisible() != bool)
      this.b.setVisible(bool, false); 
    drawable = this.r;
    if (drawable != null && drawable.isVisible() != bool)
      this.r.setVisible(bool, false); 
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable) {
    return (super.verifyDrawable(paramDrawable) || paramDrawable == this.r || paramDrawable == this.b);
  }
  
  public static class LayoutParams extends FrameLayout.LayoutParams {
    int a = 0;
    
    float b = 0.5F;
    
    public LayoutParams(int param1Int1, int param1Int2) {
      super(param1Int1, param1Int2);
    }
    
    public LayoutParams(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.CollapsingToolbarLayout_Layout);
      this.a = typedArray.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
      a(typedArray.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5F));
      typedArray.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
    
    public void a(float param1Float) {
      this.b = param1Float;
    }
  }
  
  class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
    OffsetUpdateListener(CollapsingToolbarLayout this$0) {}
    
    public void onOffsetChanged(AppBarLayout param1AppBarLayout, int param1Int) {
      byte b;
      CollapsingToolbarLayout collapsingToolbarLayout = this.a;
      collapsingToolbarLayout.c = param1Int;
      if (collapsingToolbarLayout.d != null) {
        b = this.a.d.getSystemWindowInsetTop();
      } else {
        b = 0;
      } 
      int j = this.a.getChildCount();
      int i;
      for (i = 0; i < j; i++) {
        View view = this.a.getChildAt(i);
        CollapsingToolbarLayout.LayoutParams layoutParams = (CollapsingToolbarLayout.LayoutParams)view.getLayoutParams();
        ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.a(view);
        int k = layoutParams.a;
        if (k != 1) {
          if (k == 2)
            viewOffsetHelper.a(Math.round(-param1Int * layoutParams.b)); 
        } else {
          viewOffsetHelper.a(MathUtils.clamp(-param1Int, 0, this.a.b(view)));
        } 
      } 
      this.a.b();
      if (this.a.b != null && b)
        ViewCompat.postInvalidateOnAnimation((View)this.a); 
      i = this.a.getHeight();
      j = ViewCompat.getMinimumHeight((View)this.a);
      this.a.a.b(Math.abs(param1Int) / (i - j - b));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\appbar\CollapsingToolbarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */