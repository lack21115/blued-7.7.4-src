package android.support.v7.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.OverScroller;

public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent {
  private static int[] ATTRS = new int[] { R.attr.actionBarSize, 16842841 };
  
  private int mActionBarHeight;
  
  ActionBarContainer mActionBarTop;
  
  private ActionBarOverlayLayout$ActionBarVisibilityCallback mActionBarVisibilityCallback;
  
  private final Runnable mAddActionBarHideOffset = new ActionBarOverlayLayout$3(this);
  
  boolean mAnimatingForFling;
  
  private final Rect mBaseContentInsets = new Rect();
  
  private final Rect mBaseInnerInsets = new Rect();
  
  private ContentFrameLayout mContent;
  
  private final Rect mContentInsets = new Rect();
  
  ViewPropertyAnimator mCurrentActionBarTopAnimator;
  
  private OverScroller mFlingEstimator;
  
  private boolean mHasNonEmbeddedTabs;
  
  private boolean mHideOnContentScroll;
  
  private int mHideOnContentScrollReference;
  
  private boolean mIgnoreWindowContentOverlay;
  
  private final Rect mInnerInsets = new Rect();
  
  private final Rect mLastBaseContentInsets = new Rect();
  
  private final Rect mLastBaseInnerInsets = new Rect();
  
  private final Rect mLastInnerInsets = new Rect();
  
  private int mLastSystemUiVisibility;
  
  private boolean mOverlayMode;
  
  private final NestedScrollingParentHelper mParentHelper;
  
  private final Runnable mRemoveActionBarHideOffset = new ActionBarOverlayLayout$2(this);
  
  final AnimatorListenerAdapter mTopAnimatorListener = new ActionBarOverlayLayout$1(this);
  
  private Drawable mWindowContentOverlay;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ActionBarOverlayLayout(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    init(paramContext);
    this.mParentHelper = new NestedScrollingParentHelper();
  }
  
  private static boolean applyInsets(View paramView, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    boolean bool;
    ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)paramView.getLayoutParams();
    if (paramBoolean1 && actionBarOverlayLayout$LayoutParams.leftMargin != paramRect.left) {
      actionBarOverlayLayout$LayoutParams.leftMargin = paramRect.left;
      bool = true;
    } else {
      bool = false;
    } 
    paramBoolean1 = bool;
    if (paramBoolean2) {
      paramBoolean1 = bool;
      if (actionBarOverlayLayout$LayoutParams.topMargin != paramRect.top) {
        actionBarOverlayLayout$LayoutParams.topMargin = paramRect.top;
        paramBoolean1 = true;
      } 
    } 
    paramBoolean2 = paramBoolean1;
    if (paramBoolean4) {
      paramBoolean2 = paramBoolean1;
      if (actionBarOverlayLayout$LayoutParams.rightMargin != paramRect.right) {
        actionBarOverlayLayout$LayoutParams.rightMargin = paramRect.right;
        paramBoolean2 = true;
      } 
    } 
    paramBoolean1 = paramBoolean2;
    if (paramBoolean3) {
      paramBoolean1 = paramBoolean2;
      if (actionBarOverlayLayout$LayoutParams.bottomMargin != paramRect.bottom) {
        actionBarOverlayLayout$LayoutParams.bottomMargin = paramRect.bottom;
        paramBoolean1 = true;
      } 
    } 
    return paramBoolean1;
  }
  
  private void init(Context paramContext) {
    TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(ATTRS);
    boolean bool2 = false;
    this.mActionBarHeight = typedArray.getDimensionPixelSize(0, 0);
    this.mWindowContentOverlay = typedArray.getDrawable(1);
    if (this.mWindowContentOverlay == null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    setWillNotDraw(bool1);
    typedArray.recycle();
    boolean bool1 = bool2;
    if ((paramContext.getApplicationInfo()).targetSdkVersion < 19)
      bool1 = true; 
    this.mIgnoreWindowContentOverlay = bool1;
    this.mFlingEstimator = new OverScroller(paramContext);
  }
  
  private void pullChildren() {
    if (this.mContent == null) {
      this.mContent = (ContentFrameLayout)findViewById(R.id.action_bar_activity_content);
      this.mActionBarTop = (ActionBarContainer)findViewById(R.id.action_bar_container);
      View view = findViewById(R.id.action_bar);
      if (!(view instanceof DecorToolbar)) {
        Toolbar toolbar;
        if (view instanceof Toolbar) {
          toolbar = (Toolbar)view;
          if (toolbar.mWrapper == null)
            toolbar.mWrapper = new ToolbarWidgetWrapper(toolbar, true); 
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
        stringBuilder.append(toolbar.getClass().getSimpleName());
        throw new IllegalStateException(stringBuilder.toString());
      } 
    } 
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return paramLayoutParams instanceof ActionBarOverlayLayout$LayoutParams;
  }
  
  public void draw(Canvas paramCanvas) {
    super.draw(paramCanvas);
    if (this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
      byte b;
      if (this.mActionBarTop.getVisibility() == 0) {
        b = (int)(this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY() + 0.5F);
      } else {
        b = 0;
      } 
      this.mWindowContentOverlay.setBounds(0, b, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + b);
      this.mWindowContentOverlay.draw(paramCanvas);
    } 
  }
  
  protected boolean fitSystemWindows(Rect paramRect) {
    pullChildren();
    ViewCompat.getWindowSystemUiVisibility((View)this);
    boolean bool = applyInsets((View)this.mActionBarTop, paramRect, true, true, false, true);
    this.mBaseInnerInsets.set(paramRect);
    ViewUtils.computeFitSystemWindows((View)this, this.mBaseInnerInsets, this.mBaseContentInsets);
    if (!this.mLastBaseInnerInsets.equals(this.mBaseInnerInsets)) {
      this.mLastBaseInnerInsets.set(this.mBaseInnerInsets);
      bool = true;
    } 
    if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
      this.mLastBaseContentInsets.set(this.mBaseContentInsets);
      bool = true;
    } 
    if (bool)
      requestLayout(); 
    return true;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (ViewGroup.LayoutParams)new ActionBarOverlayLayout$LayoutParams(paramLayoutParams);
  }
  
  public int getNestedScrollAxes() {
    return this.mParentHelper.mNestedScrollAxes;
  }
  
  final void haltActionBarHideOffsetAnimations() {
    removeCallbacks(this.mRemoveActionBarHideOffset);
    removeCallbacks(this.mAddActionBarHideOffset);
    if (this.mCurrentActionBarTopAnimator != null)
      this.mCurrentActionBarTopAnimator.cancel(); 
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    init(getContext());
    ViewCompat.requestApplyInsets((View)this);
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    haltActionBarHideOffsetAnimations();
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
        ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)view.getLayoutParams();
        int i = view.getMeasuredWidth();
        int j = view.getMeasuredHeight();
        int k = actionBarOverlayLayout$LayoutParams.leftMargin + paramInt3;
        int m = actionBarOverlayLayout$LayoutParams.topMargin + paramInt4;
        view.layout(k, m, i + k, j + m);
      } 
    } 
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    pullChildren();
    measureChildWithMargins((View)this.mActionBarTop, paramInt1, 0, paramInt2, 0);
    ActionBarOverlayLayout$LayoutParams actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)this.mActionBarTop.getLayoutParams();
    int j = this.mActionBarTop.getMeasuredWidth();
    int k = actionBarOverlayLayout$LayoutParams.leftMargin;
    int m = actionBarOverlayLayout$LayoutParams.rightMargin;
    int i = 0;
    int i1 = Math.max(0, j + k + m);
    int n = Math.max(0, this.mActionBarTop.getMeasuredHeight() + actionBarOverlayLayout$LayoutParams.topMargin + actionBarOverlayLayout$LayoutParams.bottomMargin);
    m = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
    if ((ViewCompat.getWindowSystemUiVisibility((View)this) & 0x100) != 0) {
      j = 1;
    } else {
      j = 0;
    } 
    if (j != 0) {
      k = this.mActionBarHeight;
      i = k;
      if (this.mHasNonEmbeddedTabs) {
        i = k;
        if (this.mActionBarTop.mTabContainer != null)
          i = k + this.mActionBarHeight; 
      } 
    } else if (this.mActionBarTop.getVisibility() != 8) {
      i = this.mActionBarTop.getMeasuredHeight();
    } 
    this.mContentInsets.set(this.mBaseContentInsets);
    this.mInnerInsets.set(this.mBaseInnerInsets);
    if (!this.mOverlayMode && j == 0) {
      Rect rect = this.mContentInsets;
      rect.top += i;
      rect = this.mContentInsets;
      rect.bottom = rect.bottom;
    } else {
      Rect rect = this.mInnerInsets;
      rect.top += i;
      rect = this.mInnerInsets;
      rect.bottom = rect.bottom;
    } 
    applyInsets((View)this.mContent, this.mContentInsets, true, true, true, true);
    if (!this.mLastInnerInsets.equals(this.mInnerInsets)) {
      this.mLastInnerInsets.set(this.mInnerInsets);
      this.mContent.dispatchFitSystemWindows(this.mInnerInsets);
    } 
    measureChildWithMargins((View)this.mContent, paramInt1, 0, paramInt2, 0);
    actionBarOverlayLayout$LayoutParams = (ActionBarOverlayLayout$LayoutParams)this.mContent.getLayoutParams();
    i = Math.max(i1, this.mContent.getMeasuredWidth() + actionBarOverlayLayout$LayoutParams.leftMargin + actionBarOverlayLayout$LayoutParams.rightMargin);
    j = Math.max(n, this.mContent.getMeasuredHeight() + actionBarOverlayLayout$LayoutParams.topMargin + actionBarOverlayLayout$LayoutParams.bottomMargin);
    k = View.combineMeasuredStates(m, this.mContent.getMeasuredState());
    m = getPaddingLeft();
    n = getPaddingRight();
    j = Math.max(j + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i + m + n, getSuggestedMinimumWidth()), paramInt1, k), View.resolveSizeAndState(j, paramInt2, k << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {
    boolean bool1 = this.mHideOnContentScroll;
    boolean bool = false;
    if (bool1) {
      if (!paramBoolean)
        return false; 
      this.mFlingEstimator.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
      if (this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight())
        bool = true; 
      if (bool) {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
      } else {
        haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
      } 
      this.mAnimatingForFling = true;
      return true;
    } 
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2) {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.mHideOnContentScrollReference += paramInt2;
    paramInt1 = this.mHideOnContentScrollReference;
    haltActionBarHideOffsetAnimations();
    paramInt1 = Math.max(0, Math.min(paramInt1, this.mActionBarTop.getHeight()));
    this.mActionBarTop.setTranslationY(-paramInt1);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    this.mParentHelper.mNestedScrollAxes = paramInt;
    if (this.mActionBarTop != null) {
      paramInt = -((int)this.mActionBarTop.getTranslationY());
    } else {
      paramInt = 0;
    } 
    this.mHideOnContentScrollReference = paramInt;
    haltActionBarHideOffsetAnimations();
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt) {
    return ((paramInt & 0x2) == 0 || this.mActionBarTop.getVisibility() != 0) ? false : this.mHideOnContentScroll;
  }
  
  public void onStopNestedScroll(View paramView) {
    if (this.mHideOnContentScroll && !this.mAnimatingForFling) {
      if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mRemoveActionBarHideOffset, 600L);
        return;
      } 
      haltActionBarHideOffsetAnimations();
      postDelayed(this.mAddActionBarHideOffset, 600L);
    } 
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt) {
    if (Build.VERSION.SDK_INT >= 16)
      super.onWindowSystemUiVisibilityChanged(paramInt); 
    pullChildren();
    int i = this.mLastSystemUiVisibility;
    this.mLastSystemUiVisibility = paramInt;
    if (((i ^ paramInt) & 0x100) != 0 && this.mActionBarVisibilityCallback != null)
      ViewCompat.requestApplyInsets((View)this); 
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    super.onWindowVisibilityChanged(paramInt);
  }
  
  public boolean shouldDelayChildPressedState() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\ActionBarOverlayLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */