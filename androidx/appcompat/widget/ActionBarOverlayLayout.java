package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;

public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
  static final int[] e = new int[] { R.attr.actionBarSize, 16842841 };
  
  private final Runnable A = new Runnable(this) {
      public void run() {
        this.a.c();
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = actionBarOverlayLayout.a.animate().translationY(-this.a.a.getHeight()).setListener((Animator.AnimatorListener)this.a.d);
      }
    };
  
  private final NestedScrollingParentHelper B;
  
  ActionBarContainer a;
  
  boolean b;
  
  ViewPropertyAnimator c;
  
  final AnimatorListenerAdapter d = new AnimatorListenerAdapter(this) {
      public void onAnimationCancel(Animator param1Animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = null;
        actionBarOverlayLayout.b = false;
      }
      
      public void onAnimationEnd(Animator param1Animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = null;
        actionBarOverlayLayout.b = false;
      }
    };
  
  private int f;
  
  private int g = 0;
  
  private ContentFrameLayout h;
  
  private DecorToolbar i;
  
  private Drawable j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private int o;
  
  private int p;
  
  private final Rect q = new Rect();
  
  private final Rect r = new Rect();
  
  private final Rect s = new Rect();
  
  private final Rect t = new Rect();
  
  private final Rect u = new Rect();
  
  private final Rect v = new Rect();
  
  private final Rect w = new Rect();
  
  private ActionBarVisibilityCallback x;
  
  private OverScroller y;
  
  private final Runnable z = new Runnable(this) {
      public void run() {
        this.a.c();
        ActionBarOverlayLayout actionBarOverlayLayout = this.a;
        actionBarOverlayLayout.c = actionBarOverlayLayout.a.animate().translationY(0.0F).setListener((Animator.AnimatorListener)this.a.d);
      }
    };
  
  public ActionBarOverlayLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.B = new NestedScrollingParentHelper(this);
  }
  
  private DecorToolbar a(View paramView) {
    if (paramView instanceof DecorToolbar)
      return (DecorToolbar)paramView; 
    if (paramView instanceof Toolbar)
      return ((Toolbar)paramView).getWrapper(); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't make a decor toolbar out of ");
    stringBuilder.append(paramView.getClass().getSimpleName());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  private void a(Context paramContext) {
    TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(e);
    boolean bool2 = false;
    this.f = typedArray.getDimensionPixelSize(0, 0);
    this.j = typedArray.getDrawable(1);
    if (this.j == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    setWillNotDraw(bool1);
    typedArray.recycle();
    boolean bool1 = bool2;
    if ((paramContext.getApplicationInfo()).targetSdkVersion < 19)
      bool1 = true; 
    this.k = bool1;
    this.y = new OverScroller(paramContext);
  }
  
  private boolean a(float paramFloat1, float paramFloat2) {
    this.y.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    return (this.y.getFinalY() > this.a.getHeight());
  }
  
  private boolean a(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    boolean bool;
    LayoutParams layoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramBoolean1 && layoutParams.leftMargin != paramRect.left) {
      layoutParams.leftMargin = paramRect.left;
      bool = true;
    } else {
      bool = false;
    } 
    paramBoolean1 = bool;
    if (paramBoolean2) {
      paramBoolean1 = bool;
      if (layoutParams.topMargin != paramRect.top) {
        layoutParams.topMargin = paramRect.top;
        paramBoolean1 = true;
      } 
    } 
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4) {
      paramBoolean2 = paramBoolean1;
      if (layoutParams.rightMargin != paramRect.right) {
        layoutParams.rightMargin = paramRect.right;
        paramBoolean2 = true;
      } 
    } 
    paramBoolean1 = paramBoolean2;
    if (paramBoolean3) {
      paramBoolean1 = paramBoolean2;
      if (layoutParams.bottomMargin != paramRect.bottom) {
        layoutParams.bottomMargin = paramRect.bottom;
        paramBoolean1 = true;
      } 
    } 
    return paramBoolean1;
  }
  
  private void d() {
    c();
    postDelayed(this.z, 600L);
  }
  
  private void e() {
    c();
    postDelayed(this.A, 600L);
  }
  
  private void f() {
    c();
    this.z.run();
  }
  
  private void g() {
    c();
    this.A.run();
  }
  
  protected LayoutParams a() {
    return new LayoutParams(-1, -1);
  }
  
  void b() {
    if (this.h == null) {
      this.h = (ContentFrameLayout)findViewById(R.id.action_bar_activity_content);
      this.a = (ActionBarContainer)findViewById(R.id.action_bar_container);
      this.i = a(findViewById(R.id.action_bar));
    } 
  }
  
  void c() {
    removeCallbacks(this.z);
    removeCallbacks(this.A);
    ViewPropertyAnimator viewPropertyAnimator = this.c;
    if (viewPropertyAnimator != null)
      viewPropertyAnimator.cancel(); 
  }
  
  public boolean canShowOverflowMenu() {
    b();
    return this.i.canShowOverflowMenu();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void dismissPopups() {
    b();
    this.i.dismissPopupMenus();
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    if (this.j != null && !this.k) {
      byte b;
      if (this.a.getVisibility() == 0) {
        b = (int)(this.a.getBottom() + this.a.getTranslationY() + 0.5F);
      } else {
        b = 0;
      } 
      this.j.setBounds(0, b, getWidth(), this.j.getIntrinsicHeight() + b);
      this.j.draw(paramCanvas);
    } 
  }
  
  protected boolean fitSystemWindows(Rect paramRect) {
    b();
    ViewCompat.getWindowSystemUiVisibility((View)this);
    boolean bool = a((View)this.a, paramRect, true, true, false, true);
    this.t.set(paramRect);
    ViewUtils.computeFitSystemWindows((View)this, this.t, this.q);
    if (!this.u.equals(this.t)) {
      this.u.set(this.t);
      bool = true;
    } 
    if (!this.r.equals(this.q)) {
      this.r.set(this.q);
      bool = true;
    } 
    if (bool)
      requestLayout(); 
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new LayoutParams(paramLayoutParams);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet) {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getActionBarHideOffset() {
    ActionBarContainer actionBarContainer = this.a;
    return (actionBarContainer != null) ? -((int)actionBarContainer.getTranslationY()) : 0;
  }
  
  public int getNestedScrollAxes() {
    return this.B.getNestedScrollAxes();
  }
  
  public CharSequence getTitle() {
    b();
    return this.i.getTitle();
  }
  
  public boolean hasIcon() {
    b();
    return this.i.hasIcon();
  }
  
  public boolean hasLogo() {
    b();
    return this.i.hasLogo();
  }
  
  public boolean hideOverflowMenu() {
    b();
    return this.i.hideOverflowMenu();
  }
  
  public void initFeature(int paramInt) {
    b();
    if (paramInt != 2) {
      if (paramInt != 5) {
        if (paramInt != 109)
          return; 
        setOverlayMode(true);
        return;
      } 
      this.i.initIndeterminateProgress();
      return;
    } 
    this.i.initProgress();
  }
  
  public boolean isHideOnContentScrollEnabled() {
    return this.n;
  }
  
  public boolean isInOverlayMode() {
    return this.l;
  }
  
  public boolean isOverflowMenuShowPending() {
    b();
    return this.i.isOverflowMenuShowPending();
  }
  
  public boolean isOverflowMenuShowing() {
    b();
    return this.i.isOverflowMenuShowing();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    a(getContext());
    ViewCompat.requestApplyInsets((View)this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    c();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      View view = getChildAt(paramInt1);
      if (view.getVisibility() != 8) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int i = view.getMeasuredWidth();
        int j = view.getMeasuredHeight();
        int k = layoutParams.leftMargin + paramInt3;
        int m = layoutParams.topMargin + paramInt4;
        view.layout(k, m, i + k, j + m);
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    b();
    measureChildWithMargins((View)this.a, paramInt1, 0, paramInt2, 0);
    LayoutParams layoutParams = (LayoutParams)this.a.getLayoutParams();
    int i1 = Math.max(0, this.a.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    int n = Math.max(0, this.a.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
    int m = View.combineMeasuredStates(0, this.a.getMeasuredState());
    if ((ViewCompat.getWindowSystemUiVisibility((View)this) & 0x100) != 0) {
      j = 1;
    } else {
      j = 0;
    } 
    if (j) {
      int i2 = this.f;
      i = i2;
      if (this.m) {
        i = i2;
        if (this.a.getTabContainer() != null)
          i = i2 + this.f; 
      } 
    } else if (this.a.getVisibility() != 8) {
      i = this.a.getMeasuredHeight();
    } else {
      i = 0;
    } 
    this.s.set(this.q);
    this.v.set(this.t);
    if (!this.l && !j) {
      Rect rect = this.s;
      rect.top += i;
      rect = this.s;
      rect.bottom += 0;
    } else {
      Rect rect = this.v;
      rect.top += i;
      rect = this.v;
      rect.bottom += 0;
    } 
    a((View)this.h, this.s, true, true, true, true);
    if (!this.w.equals(this.v)) {
      this.w.set(this.v);
      this.h.dispatchFitSystemWindows(this.v);
    } 
    measureChildWithMargins((View)this.h, paramInt1, 0, paramInt2, 0);
    layoutParams = (LayoutParams)this.h.getLayoutParams();
    int i = Math.max(i1, this.h.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    int j = Math.max(n, this.h.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
    int k = View.combineMeasuredStates(m, this.h.getMeasuredState());
    m = getPaddingLeft();
    n = getPaddingRight();
    j = Math.max(j + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i + m + n, getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (!this.n || !paramBoolean)
      return false; 
    if (a(paramFloat1, paramFloat2)) {
      g();
    } else {
      f();
    } 
    this.b = true;
    return true;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {}
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3) {
    if (paramInt3 == 0)
      onNestedPreScroll(paramView, paramInt1, paramInt2, paramArrayOfint); 
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.o += paramInt2;
    setActionBarHideOffset(this.o);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt5 == 0)
      onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint) {
    onNestedScroll(paramView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.B.onNestedScrollAccepted(paramView1, paramView2, paramInt);
    this.o = getActionBarHideOffset();
    c();
    ActionBarVisibilityCallback actionBarVisibilityCallback = this.x;
    if (actionBarVisibilityCallback != null)
      actionBarVisibilityCallback.onContentScrollStarted(); 
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    if (paramInt2 == 0)
      onNestedScrollAccepted(paramView1, paramView2, paramInt1); 
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return ((paramInt & 0x2) == 0 || this.a.getVisibility() != 0) ? false : this.n;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    return (paramInt2 == 0 && onStartNestedScroll(paramView1, paramView2, paramInt1));
  }
  
  public void onStopNestedScroll(View paramView) {
    if (this.n && !this.b)
      if (this.o <= this.a.getHeight()) {
        d();
      } else {
        e();
      }  
    ActionBarVisibilityCallback actionBarVisibilityCallback = this.x;
    if (actionBarVisibilityCallback != null)
      actionBarVisibilityCallback.onContentScrollStopped(); 
  }
  
  public void onStopNestedScroll(View paramView, int paramInt) {
    if (paramInt == 0)
      onStopNestedScroll(paramView); 
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt) {
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 16)
      super.onWindowSystemUiVisibilityChanged(paramInt); 
    b();
    int i = this.p;
    this.p = paramInt;
    boolean bool2 = false;
    if ((paramInt & 0x4) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if ((paramInt & 0x100) != 0)
      bool2 = true; 
    ActionBarVisibilityCallback actionBarVisibilityCallback = this.x;
    if (actionBarVisibilityCallback != null) {
      actionBarVisibilityCallback.enableContentAnimations(bool2 ^ true);
      if (bool1 || !bool2) {
        this.x.showForSystem();
      } else {
        this.x.hideForSystem();
      } 
    } 
    if (((i ^ paramInt) & 0x100) != 0 && this.x != null)
      ViewCompat.requestApplyInsets((View)this); 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
    this.g = paramInt;
    ActionBarVisibilityCallback actionBarVisibilityCallback = this.x;
    if (actionBarVisibilityCallback != null)
      actionBarVisibilityCallback.onWindowVisibilityChanged(paramInt); 
  }
  
  public void restoreToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray) {
    b();
    this.i.restoreHierarchyState(paramSparseArray);
  }
  
  public void saveToolbarHierarchyState(SparseArray<Parcelable> paramSparseArray) {
    b();
    this.i.saveHierarchyState(paramSparseArray);
  }
  
  public void setActionBarHideOffset(int paramInt) {
    c();
    paramInt = Math.max(0, Math.min(paramInt, this.a.getHeight()));
    this.a.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(ActionBarVisibilityCallback paramActionBarVisibilityCallback) {
    this.x = paramActionBarVisibilityCallback;
    if (getWindowToken() != null) {
      this.x.onWindowVisibilityChanged(this.g);
      int i = this.p;
      if (i != 0) {
        onWindowSystemUiVisibilityChanged(i);
        ViewCompat.requestApplyInsets((View)this);
      } 
    } 
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean) {
    if (paramBoolean != this.n) {
      this.n = paramBoolean;
      if (!paramBoolean) {
        c();
        setActionBarHideOffset(0);
      } 
    } 
  }
  
  public void setIcon(int paramInt) {
    b();
    this.i.setIcon(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable) {
    b();
    this.i.setIcon(paramDrawable);
  }
  
  public void setLogo(int paramInt) {
    b();
    this.i.setLogo(paramInt);
  }
  
  public void setMenu(Menu paramMenu, MenuPresenter.Callback paramCallback) {
    b();
    this.i.setMenu(paramMenu, paramCallback);
  }
  
  public void setMenuPrepared() {
    b();
    this.i.setMenuPrepared();
  }
  
  public void setOverlayMode(boolean paramBoolean) {
    this.l = paramBoolean;
    if (paramBoolean && (getContext().getApplicationInfo()).targetSdkVersion < 19) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    this.k = paramBoolean;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback) {
    b();
    this.i.setWindowCallback(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence) {
    b();
    this.i.setWindowTitle(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
  
  public boolean showOverflowMenu() {
    b();
    return this.i.showOverflowMenu();
  }
  
  public static interface ActionBarVisibilityCallback {
    void enableContentAnimations(boolean param1Boolean);
    
    void hideForSystem();
    
    void onContentScrollStarted();
    
    void onContentScrollStopped();
    
    void onWindowVisibilityChanged(int param1Int);
    
    void showForSystem();
  }
  
  public static class LayoutParams extends ViewGroup.MarginLayoutParams {
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
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */