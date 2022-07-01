package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
  int mButtonGravity;
  
  ImageButton mCollapseButtonView;
  
  private CharSequence mCollapseDescription;
  
  private Drawable mCollapseIcon;
  
  private boolean mCollapsible;
  
  private int mContentInsetEndWithActions;
  
  private int mContentInsetStartWithNavigation;
  
  RtlSpacingHelper mContentInsets;
  
  private boolean mEatingHover;
  
  private boolean mEatingTouch;
  
  View mExpandedActionView;
  
  Toolbar$ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  
  private int mGravity = 8388627;
  
  final ArrayList mHiddenViews = new ArrayList();
  
  private ImageView mLogoView;
  
  private int mMaxButtonHeight;
  
  ActionMenuView mMenuView;
  
  private ImageButton mNavButtonView;
  
  private int mPopupTheme;
  
  private final Runnable mShowOverflowMenuRunnable;
  
  CharSequence mSubtitleText;
  
  int mSubtitleTextAppearance;
  
  private int mSubtitleTextColor;
  
  TextView mSubtitleTextView;
  
  private final int[] mTempMargins = new int[2];
  
  private final ArrayList mTempViews = new ArrayList();
  
  private int mTitleMarginBottom;
  
  private int mTitleMarginEnd;
  
  private int mTitleMarginStart;
  
  private int mTitleMarginTop;
  
  CharSequence mTitleText;
  
  int mTitleTextAppearance;
  
  private int mTitleTextColor;
  
  TextView mTitleTextView;
  
  ToolbarWidgetWrapper mWrapper;
  
  public Toolbar(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    new Toolbar$1();
    this.mShowOverflowMenuRunnable = new Toolbar$2(this);
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.mTitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.mSubtitleTextAppearance = tintTypedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.mGravity = tintTypedArray.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
    this.mButtonGravity = tintTypedArray.getInteger(R.styleable.Toolbar_buttonGravity, 48);
    int i = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
    paramInt = i;
    if (tintTypedArray.hasValue(R.styleable.Toolbar_titleMargins))
      paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, i); 
    this.mTitleMarginBottom = paramInt;
    this.mTitleMarginTop = paramInt;
    this.mTitleMarginEnd = paramInt;
    this.mTitleMarginStart = paramInt;
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0)
      this.mTitleMarginStart = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0)
      this.mTitleMarginEnd = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0)
      this.mTitleMarginTop = paramInt; 
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0)
      this.mTitleMarginBottom = paramInt; 
    this.mMaxButtonHeight = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    paramInt = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, -2147483648);
    i = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    int j = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int k = tintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    ensureContentInsets();
    RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
    rtlSpacingHelper.mIsRelative = false;
    if (j != Integer.MIN_VALUE) {
      rtlSpacingHelper.mExplicitLeft = j;
      rtlSpacingHelper.mLeft = j;
    } 
    if (k != Integer.MIN_VALUE) {
      rtlSpacingHelper.mExplicitRight = k;
      rtlSpacingHelper.mRight = k;
    } 
    if (paramInt != Integer.MIN_VALUE || i != Integer.MIN_VALUE)
      this.mContentInsets.setRelative(paramInt, i); 
    this.mContentInsetStartWithNavigation = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.mContentInsetEndWithActions = tintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, -2147483648);
    this.mCollapseIcon = tintTypedArray.getDrawable(R.styleable.Toolbar_collapseIcon);
    this.mCollapseDescription = tintTypedArray.getText(R.styleable.Toolbar_collapseContentDescription);
    CharSequence charSequence3 = tintTypedArray.getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(charSequence3))
      setTitle(charSequence3); 
    charSequence3 = tintTypedArray.getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(charSequence3))
      setSubtitle(charSequence3); 
    getContext();
    setPopupTheme(tintTypedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
    Drawable drawable2 = tintTypedArray.getDrawable(R.styleable.Toolbar_navigationIcon);
    if (drawable2 != null)
      setNavigationIcon(drawable2); 
    CharSequence charSequence2 = tintTypedArray.getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(charSequence2))
      setNavigationContentDescription(charSequence2); 
    Drawable drawable1 = tintTypedArray.getDrawable(R.styleable.Toolbar_logo);
    if (drawable1 != null)
      setLogo(drawable1); 
    CharSequence charSequence1 = tintTypedArray.getText(R.styleable.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(charSequence1)) {
      if (!TextUtils.isEmpty(charSequence1))
        ensureLogoView(); 
      if (this.mLogoView != null)
        this.mLogoView.setContentDescription(charSequence1); 
    } 
    if (tintTypedArray.hasValue(R.styleable.Toolbar_titleTextColor)) {
      paramInt = tintTypedArray.getColor(R.styleable.Toolbar_titleTextColor, -1);
      this.mTitleTextColor = paramInt;
      if (this.mTitleTextView != null)
        this.mTitleTextView.setTextColor(paramInt); 
    } 
    if (tintTypedArray.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
      paramInt = tintTypedArray.getColor(R.styleable.Toolbar_subtitleTextColor, -1);
      this.mSubtitleTextColor = paramInt;
      if (this.mSubtitleTextView != null)
        this.mSubtitleTextView.setTextColor(paramInt); 
    } 
    tintTypedArray.mWrapped.recycle();
  }
  
  private void addCustomViewsWithGravity(List<View> paramList, int paramInt) {
    int i = ViewCompat.getLayoutDirection((View)this);
    boolean bool = false;
    if (i == 1) {
      i = 1;
    } else {
      i = 0;
    } 
    int k = getChildCount();
    int j = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection((View)this));
    paramList.clear();
    paramInt = bool;
    if (i != 0) {
      for (paramInt = k - 1; paramInt >= 0; paramInt--) {
        View view = getChildAt(paramInt);
        Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
        if (toolbar$LayoutParams.mViewType == 0 && shouldLayout(view) && getChildHorizontalGravity(toolbar$LayoutParams.gravity) == j)
          paramList.add(view); 
      } 
      return;
    } 
    while (paramInt < k) {
      View view = getChildAt(paramInt);
      Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
      if (toolbar$LayoutParams.mViewType == 0 && shouldLayout(view) && getChildHorizontalGravity(toolbar$LayoutParams.gravity) == j)
        paramList.add(view); 
      paramInt++;
    } 
  }
  
  private void addSystemView(View paramView, boolean paramBoolean) {
    Toolbar$LayoutParams toolbar$LayoutParams;
    ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
    if (layoutParams == null) {
      toolbar$LayoutParams = generateDefaultLayoutParams();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)toolbar$LayoutParams)) {
      toolbar$LayoutParams = generateLayoutParams((ViewGroup.LayoutParams)toolbar$LayoutParams);
    } else {
      toolbar$LayoutParams = toolbar$LayoutParams;
    } 
    toolbar$LayoutParams.mViewType = 1;
    if (paramBoolean && this.mExpandedActionView != null) {
      paramView.setLayoutParams((ViewGroup.LayoutParams)toolbar$LayoutParams);
      this.mHiddenViews.add(paramView);
      return;
    } 
    addView(paramView, (ViewGroup.LayoutParams)toolbar$LayoutParams);
  }
  
  private void ensureLogoView() {
    if (this.mLogoView == null)
      this.mLogoView = new AppCompatImageView(getContext()); 
  }
  
  private void ensureNavButtonView() {
    if (this.mNavButtonView == null) {
      this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      Toolbar$LayoutParams toolbar$LayoutParams = generateDefaultLayoutParams();
      toolbar$LayoutParams.gravity = 0x800003 | this.mButtonGravity & 0x70;
      this.mNavButtonView.setLayoutParams((ViewGroup.LayoutParams)toolbar$LayoutParams);
    } 
  }
  
  protected static Toolbar$LayoutParams generateDefaultLayoutParams() {
    return new Toolbar$LayoutParams(-2, -2);
  }
  
  private static Toolbar$LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (paramLayoutParams instanceof Toolbar$LayoutParams) ? new Toolbar$LayoutParams((Toolbar$LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ActionBar.LayoutParams) ? new Toolbar$LayoutParams((ActionBar.LayoutParams)paramLayoutParams) : ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams) ? new Toolbar$LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams) : new Toolbar$LayoutParams(paramLayoutParams)));
  }
  
  private int getChildHorizontalGravity(int paramInt) {
    int i = ViewCompat.getLayoutDirection((View)this);
    paramInt = GravityCompat.getAbsoluteGravity(paramInt, i) & 0x7;
    return (paramInt != 1 && paramInt != 3 && paramInt != 5) ? ((i == 1) ? 5 : 3) : paramInt;
  }
  
  private int getChildTop(View paramView, int paramInt) {
    Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)paramView.getLayoutParams();
    int j = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (j - paramInt) / 2;
    } else {
      paramInt = 0;
    } 
    int i = toolbar$LayoutParams.gravity & 0x70;
    if (i != 16 && i != 48 && i != 80)
      i = this.mGravity & 0x70; 
    if (i != 48) {
      if (i != 80) {
        int k = getPaddingTop();
        paramInt = getPaddingBottom();
        int m = getHeight();
        i = (m - k - paramInt - j) / 2;
        if (i < toolbar$LayoutParams.topMargin) {
          paramInt = toolbar$LayoutParams.topMargin;
        } else {
          j = m - paramInt - j - i - k;
          paramInt = i;
          if (j < toolbar$LayoutParams.bottomMargin)
            paramInt = Math.max(0, i - toolbar$LayoutParams.bottomMargin - j); 
        } 
        return k + paramInt;
      } 
      return getHeight() - getPaddingBottom() - j - toolbar$LayoutParams.bottomMargin - paramInt;
    } 
    return getPaddingTop() - paramInt;
  }
  
  private int getContentInsetEnd() {
    if (this.mContentInsets != null) {
      RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
      return rtlSpacingHelper.mIsRtl ? rtlSpacingHelper.mLeft : rtlSpacingHelper.mRight;
    } 
    return 0;
  }
  
  private int getContentInsetStart() {
    if (this.mContentInsets != null) {
      RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
      return rtlSpacingHelper.mIsRtl ? rtlSpacingHelper.mRight : rtlSpacingHelper.mLeft;
    } 
    return 0;
  }
  
  private int getCurrentContentInsetEnd() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mMenuView : Landroid/support/v7/widget/ActionMenuView;
    //   4: ifnull -> 31
    //   7: aload_0
    //   8: getfield mMenuView : Landroid/support/v7/widget/ActionMenuView;
    //   11: getfield mMenu : Landroid/support/v7/view/menu/MenuBuilder;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull -> 31
    //   19: aload_2
    //   20: invokevirtual hasVisibleItems : ()Z
    //   23: ifeq -> 31
    //   26: iconst_1
    //   27: istore_1
    //   28: goto -> 33
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq -> 53
    //   37: aload_0
    //   38: invokespecial getContentInsetEnd : ()I
    //   41: aload_0
    //   42: getfield mContentInsetEndWithActions : I
    //   45: iconst_0
    //   46: invokestatic max : (II)I
    //   49: invokestatic max : (II)I
    //   52: ireturn
    //   53: aload_0
    //   54: invokespecial getContentInsetEnd : ()I
    //   57: ireturn
  }
  
  private int getCurrentContentInsetStart() {
    return (getNavigationIcon() != null) ? Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0)) : getContentInsetStart();
  }
  
  private static int getHorizontalMargins(View paramView) {
    int i;
    int j;
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (Build.VERSION.SDK_INT >= 17) {
      i = marginLayoutParams.getMarginStart();
    } else {
      i = marginLayoutParams.leftMargin;
    } 
    if (Build.VERSION.SDK_INT >= 17) {
      j = marginLayoutParams.getMarginEnd();
    } else {
      j = marginLayoutParams.rightMargin;
    } 
    return i + j;
  }
  
  private static int getVerticalMargins(View paramView) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
  }
  
  private boolean isChildOrHidden(View paramView) {
    return (paramView.getParent() == this || this.mHiddenViews.contains(paramView));
  }
  
  private int layoutChildLeft(View paramView, int paramInt1, int[] paramArrayOfint, int paramInt2) {
    Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)paramView.getLayoutParams();
    int i = toolbar$LayoutParams.leftMargin - paramArrayOfint[0];
    paramInt1 += Math.max(0, i);
    paramArrayOfint[0] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + i + toolbar$LayoutParams.rightMargin;
  }
  
  private int layoutChildRight(View paramView, int paramInt1, int[] paramArrayOfint, int paramInt2) {
    Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)paramView.getLayoutParams();
    int i = toolbar$LayoutParams.rightMargin - paramArrayOfint[1];
    paramInt1 -= Math.max(0, i);
    paramArrayOfint[1] = Math.max(0, -i);
    paramInt2 = getChildTop(paramView, paramInt2);
    i = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - i + toolbar$LayoutParams.leftMargin;
  }
  
  private int measureChildCollapseMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = marginLayoutParams.leftMargin - paramArrayOfint[0];
    int j = marginLayoutParams.rightMargin - paramArrayOfint[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfint[0] = Math.max(0, -i);
    paramArrayOfint[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + k + paramInt2, marginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + paramInt4, marginLayoutParams.height));
    return paramView.getMeasuredWidth() + k;
  }
  
  private void measureChildConstrained(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + paramInt2, marginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + paramInt4, marginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824) {
      paramInt1 = paramInt2;
      if (paramInt5 >= 0) {
        paramInt1 = paramInt5;
        if (paramInt3 != 0)
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt5); 
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      } 
    } 
    paramView.measure(i, paramInt1);
  }
  
  private boolean shouldLayout(View paramView) {
    return (paramView != null && paramView.getParent() == this && paramView.getVisibility() != 8);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams) {
    return (super.checkLayoutParams(paramLayoutParams) && paramLayoutParams instanceof Toolbar$LayoutParams);
  }
  
  final void ensureCollapseButtonView() {
    if (this.mCollapseButtonView == null) {
      this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
      this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
      Toolbar$LayoutParams toolbar$LayoutParams = generateDefaultLayoutParams();
      toolbar$LayoutParams.gravity = 0x800003 | this.mButtonGravity & 0x70;
      toolbar$LayoutParams.mViewType = 2;
      this.mCollapseButtonView.setLayoutParams((ViewGroup.LayoutParams)toolbar$LayoutParams);
      this.mCollapseButtonView.setOnClickListener(new Toolbar$3(this));
    } 
  }
  
  final void ensureContentInsets() {
    if (this.mContentInsets == null)
      this.mContentInsets = new RtlSpacingHelper(); 
  }
  
  public final CharSequence getNavigationContentDescription() {
    return (this.mNavButtonView != null) ? this.mNavButtonView.getContentDescription() : null;
  }
  
  public final Drawable getNavigationIcon() {
    return (this.mNavButtonView != null) ? this.mNavButtonView.getDrawable() : null;
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    removeCallbacks(this.mShowOverflowMenuRunnable);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9)
      this.mEatingHover = false; 
    if (!this.mEatingHover) {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if (i == 9 && !bool)
        this.mEatingHover = true; 
    } 
    if (i == 10 || i == 3)
      this.mEatingHover = false; 
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (ViewCompat.getLayoutDirection((View)this) == 1) {
      k = 1;
    } else {
      k = 0;
    } 
    int i1 = getWidth();
    int i4 = getHeight();
    paramInt3 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = getPaddingTop();
    int i5 = getPaddingBottom();
    int m = i1 - i2;
    int[] arrayOfInt = this.mTempMargins;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = ViewCompat.getMinimumHeight((View)this);
    if (paramInt1 >= 0) {
      paramInt4 = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      paramInt4 = 0;
    } 
    if (shouldLayout((View)this.mNavButtonView)) {
      if (k) {
        i = layoutChildRight((View)this.mNavButtonView, m, arrayOfInt, paramInt4);
        j = paramInt3;
      } else {
        j = layoutChildLeft((View)this.mNavButtonView, paramInt3, arrayOfInt, paramInt4);
        i = m;
      } 
    } else {
      j = paramInt3;
      i = m;
    } 
    paramInt1 = i;
    paramInt2 = j;
    if (shouldLayout((View)this.mCollapseButtonView))
      if (k) {
        paramInt1 = layoutChildRight((View)this.mCollapseButtonView, i, arrayOfInt, paramInt4);
        paramInt2 = j;
      } else {
        paramInt2 = layoutChildLeft((View)this.mCollapseButtonView, j, arrayOfInt, paramInt4);
        paramInt1 = i;
      }  
    int i = paramInt1;
    int j = paramInt2;
    if (shouldLayout((View)this.mMenuView))
      if (k) {
        j = layoutChildLeft((View)this.mMenuView, paramInt2, arrayOfInt, paramInt4);
        i = paramInt1;
      } else {
        i = layoutChildRight((View)this.mMenuView, paramInt1, arrayOfInt, paramInt4);
        j = paramInt2;
      }  
    if (ViewCompat.getLayoutDirection((View)this) == 1) {
      paramInt1 = getCurrentContentInsetEnd();
    } else {
      paramInt1 = getCurrentContentInsetStart();
    } 
    if (ViewCompat.getLayoutDirection((View)this) == 1) {
      paramInt2 = getCurrentContentInsetStart();
    } else {
      paramInt2 = getCurrentContentInsetEnd();
    } 
    arrayOfInt[0] = Math.max(0, paramInt1 - j);
    arrayOfInt[1] = Math.max(0, paramInt2 - m - i);
    int n = Math.max(j, paramInt1);
    paramInt2 = Math.min(i, m - paramInt2);
    paramInt1 = n;
    j = paramInt2;
    if (shouldLayout(this.mExpandedActionView))
      if (k) {
        j = layoutChildRight(this.mExpandedActionView, paramInt2, arrayOfInt, paramInt4);
        paramInt1 = n;
      } else {
        paramInt1 = layoutChildLeft(this.mExpandedActionView, n, arrayOfInt, paramInt4);
        j = paramInt2;
      }  
    paramInt2 = paramInt1;
    i = j;
    if (shouldLayout((View)this.mLogoView))
      if (k) {
        i = layoutChildRight((View)this.mLogoView, j, arrayOfInt, paramInt4);
        paramInt2 = paramInt1;
      } else {
        paramInt2 = layoutChildLeft((View)this.mLogoView, paramInt1, arrayOfInt, paramInt4);
        i = j;
      }  
    paramBoolean = shouldLayout((View)this.mTitleTextView);
    boolean bool = shouldLayout((View)this.mSubtitleTextView);
    if (paramBoolean) {
      Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
      paramInt1 = toolbar$LayoutParams.topMargin + this.mTitleTextView.getMeasuredHeight() + toolbar$LayoutParams.bottomMargin + 0;
    } else {
      paramInt1 = 0;
    } 
    if (bool) {
      Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
      paramInt1 += toolbar$LayoutParams.topMargin + this.mSubtitleTextView.getMeasuredHeight() + toolbar$LayoutParams.bottomMargin;
    } 
    if (paramBoolean || bool) {
      TextView textView1;
      TextView textView2;
      if (paramBoolean) {
        textView1 = this.mTitleTextView;
      } else {
        textView1 = this.mSubtitleTextView;
      } 
      if (bool) {
        textView2 = this.mSubtitleTextView;
      } else {
        textView2 = this.mTitleTextView;
      } 
      Toolbar$LayoutParams toolbar$LayoutParams1 = (Toolbar$LayoutParams)textView1.getLayoutParams();
      Toolbar$LayoutParams toolbar$LayoutParams2 = (Toolbar$LayoutParams)textView2.getLayoutParams();
      if ((paramBoolean && this.mTitleTextView.getMeasuredWidth() > 0) || (bool && this.mSubtitleTextView.getMeasuredWidth() > 0)) {
        j = 1;
      } else {
        j = 0;
      } 
      m = this.mGravity & 0x70;
      if (m != 48) {
        if (m != 80) {
          m = (i4 - i3 - i5 - paramInt1) / 2;
          if (m < toolbar$LayoutParams1.topMargin + this.mTitleMarginTop) {
            paramInt1 = toolbar$LayoutParams1.topMargin + this.mTitleMarginTop;
          } else {
            n = i4 - i5 - paramInt1 - m - i3;
            paramInt1 = m;
            if (n < toolbar$LayoutParams1.bottomMargin + this.mTitleMarginBottom)
              paramInt1 = Math.max(0, m - toolbar$LayoutParams2.bottomMargin + this.mTitleMarginBottom - n); 
          } 
          paramInt1 = i3 + paramInt1;
        } else {
          paramInt1 = i4 - i5 - toolbar$LayoutParams2.bottomMargin - this.mTitleMarginBottom - paramInt1;
        } 
      } else {
        paramInt1 = getPaddingTop() + toolbar$LayoutParams1.topMargin + this.mTitleMarginTop;
      } 
      m = paramInt2;
      if (k) {
        if (j != 0) {
          paramInt2 = this.mTitleMarginStart;
        } else {
          paramInt2 = 0;
        } 
        k = paramInt2 - arrayOfInt[1];
        paramInt2 = i - Math.max(0, k);
        arrayOfInt[1] = Math.max(0, -k);
        if (paramBoolean) {
          toolbar$LayoutParams1 = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
          k = paramInt2 - this.mTitleTextView.getMeasuredWidth();
          i = this.mTitleTextView.getMeasuredHeight() + paramInt1;
          this.mTitleTextView.layout(k, paramInt1, paramInt2, i);
          paramInt1 = k - this.mTitleMarginEnd;
          k = i + toolbar$LayoutParams1.bottomMargin;
        } else {
          i = paramInt2;
          k = paramInt1;
          paramInt1 = i;
        } 
        if (bool) {
          toolbar$LayoutParams1 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
          i = k + toolbar$LayoutParams1.topMargin;
          k = this.mSubtitleTextView.getMeasuredWidth();
          n = this.mSubtitleTextView.getMeasuredHeight();
          this.mSubtitleTextView.layout(paramInt2 - k, i, paramInt2, n + i);
          i = paramInt2 - this.mTitleMarginEnd;
          k = toolbar$LayoutParams1.bottomMargin;
        } else {
          i = paramInt2;
        } 
        if (j != 0)
          paramInt2 = Math.min(paramInt1, i); 
        paramInt1 = m;
        i = paramInt2;
      } else {
        if (j != 0) {
          paramInt2 = this.mTitleMarginStart;
        } else {
          paramInt2 = 0;
        } 
        k = paramInt2 - arrayOfInt[0];
        paramInt2 = m + Math.max(0, k);
        arrayOfInt[0] = Math.max(0, -k);
        if (paramBoolean) {
          toolbar$LayoutParams1 = (Toolbar$LayoutParams)this.mTitleTextView.getLayoutParams();
          m = this.mTitleTextView.getMeasuredWidth() + paramInt2;
          k = this.mTitleTextView.getMeasuredHeight() + paramInt1;
          this.mTitleTextView.layout(paramInt2, paramInt1, m, k);
          paramInt1 = m + this.mTitleMarginEnd;
          m = k + toolbar$LayoutParams1.bottomMargin;
        } else {
          k = paramInt2;
          m = paramInt1;
          paramInt1 = k;
        } 
        if (bool) {
          toolbar$LayoutParams1 = (Toolbar$LayoutParams)this.mSubtitleTextView.getLayoutParams();
          k = m + toolbar$LayoutParams1.topMargin;
          m = this.mSubtitleTextView.getMeasuredWidth() + paramInt2;
          n = this.mSubtitleTextView.getMeasuredHeight();
          this.mSubtitleTextView.layout(paramInt2, k, m, n + k);
          k = m + this.mTitleMarginEnd;
          m = toolbar$LayoutParams1.bottomMargin;
        } else {
          k = paramInt2;
        } 
        if (j != 0) {
          paramInt1 = Math.max(paramInt1, k);
        } else {
          paramInt1 = paramInt2;
        } 
      } 
    } else {
      paramInt1 = paramInt2;
    } 
    int k = paramInt4;
    m = paramInt3;
    addCustomViewsWithGravity(this.mTempViews, 3);
    paramInt3 = this.mTempViews.size();
    for (paramInt2 = 0; paramInt2 < paramInt3; paramInt2++)
      paramInt1 = layoutChildLeft(this.mTempViews.get(paramInt2), paramInt1, arrayOfInt, k); 
    addCustomViewsWithGravity(this.mTempViews, 5);
    paramInt3 = this.mTempViews.size();
    for (paramInt2 = 0; paramInt2 < paramInt3; paramInt2++)
      i = layoutChildRight(this.mTempViews.get(paramInt2), i, arrayOfInt, k); 
    addCustomViewsWithGravity(this.mTempViews, 1);
    ArrayList<View> arrayList = this.mTempViews;
    j = arrayOfInt[0];
    paramInt4 = arrayOfInt[1];
    n = arrayList.size();
    paramInt3 = 0;
    paramInt2 = 0;
    while (paramInt3 < n) {
      View view = arrayList.get(paramInt3);
      Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
      j = toolbar$LayoutParams.leftMargin - j;
      paramInt4 = toolbar$LayoutParams.rightMargin - paramInt4;
      i3 = Math.max(0, j);
      i4 = Math.max(0, paramInt4);
      j = Math.max(0, -j);
      paramInt4 = Math.max(0, -paramInt4);
      paramInt2 += i3 + view.getMeasuredWidth() + i4;
      paramInt3++;
    } 
    paramInt3 = 0;
    paramInt4 = m + (i1 - m - i2) / 2 - paramInt2 / 2;
    paramInt2 += paramInt4;
    if (paramInt4 >= paramInt1)
      if (paramInt2 > i) {
        paramInt1 = paramInt4 - paramInt2 - i;
      } else {
        paramInt1 = paramInt4;
      }  
    paramInt4 = this.mTempViews.size();
    for (paramInt2 = paramInt3; paramInt2 < paramInt4; paramInt2++)
      paramInt1 = layoutChildLeft(this.mTempViews.get(paramInt2), paramInt1, arrayOfInt, k); 
    this.mTempViews.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int[] arrayOfInt = this.mTempMargins;
    boolean bool1 = ViewUtils.isLayoutRtl((View)this);
    boolean bool = true;
    if (bool1) {
      i1 = 1;
      n = 0;
    } else {
      i1 = 0;
      n = 1;
    } 
    if (shouldLayout((View)this.mNavButtonView)) {
      measureChildConstrained((View)this.mNavButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      i = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins((View)this.mNavButtonView);
      m = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins((View)this.mNavButtonView));
      k = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    } else {
      i = 0;
      m = 0;
      k = 0;
    } 
    int i2 = i;
    int j = m;
    int i = k;
    if (shouldLayout((View)this.mCollapseButtonView)) {
      measureChildConstrained((View)this.mCollapseButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
      i2 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins((View)this.mCollapseButtonView);
      j = Math.max(m, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins((View)this.mCollapseButtonView));
      i = View.combineMeasuredStates(k, this.mCollapseButtonView.getMeasuredState());
    } 
    int k = getCurrentContentInsetStart();
    int m = Math.max(k, i2) + 0;
    arrayOfInt[i1] = Math.max(0, k - i2);
    if (shouldLayout((View)this.mMenuView)) {
      measureChildConstrained((View)this.mMenuView, paramInt1, m, paramInt2, 0, this.mMaxButtonHeight);
      k = this.mMenuView.getMeasuredWidth() + getHorizontalMargins((View)this.mMenuView);
      j = Math.max(j, this.mMenuView.getMeasuredHeight() + getVerticalMargins((View)this.mMenuView));
      i = View.combineMeasuredStates(i, this.mMenuView.getMeasuredState());
    } else {
      k = 0;
    } 
    i2 = getCurrentContentInsetEnd();
    int i1 = m + Math.max(i2, k);
    arrayOfInt[n] = Math.max(0, i2 - k);
    int n = i1;
    m = j;
    k = i;
    if (shouldLayout(this.mExpandedActionView)) {
      n = i1 + measureChildCollapseMargins(this.mExpandedActionView, paramInt1, i1, paramInt2, 0, arrayOfInt);
      m = Math.max(j, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
      k = View.combineMeasuredStates(i, this.mExpandedActionView.getMeasuredState());
    } 
    j = n;
    i1 = m;
    i = k;
    if (shouldLayout((View)this.mLogoView)) {
      j = n + measureChildCollapseMargins((View)this.mLogoView, paramInt1, n, paramInt2, 0, arrayOfInt);
      i1 = Math.max(m, this.mLogoView.getMeasuredHeight() + getVerticalMargins((View)this.mLogoView));
      i = View.combineMeasuredStates(k, this.mLogoView.getMeasuredState());
    } 
    int i3 = getChildCount();
    n = i1;
    k = 0;
    m = j;
    j = k;
    while (j < i3) {
      View view = getChildAt(j);
      i2 = m;
      i1 = i;
      k = n;
      if (((Toolbar$LayoutParams)view.getLayoutParams()).mViewType == 0) {
        i2 = m;
        i1 = i;
        k = n;
        if (shouldLayout(view)) {
          i2 = m + measureChildCollapseMargins(view, paramInt1, m, paramInt2, 0, arrayOfInt);
          k = Math.max(n, view.getMeasuredHeight() + getVerticalMargins(view));
          i1 = View.combineMeasuredStates(i, view.getMeasuredState());
        } 
      } 
      j++;
      m = i2;
      i = i1;
      n = k;
    } 
    i1 = this.mTitleMarginTop + this.mTitleMarginBottom;
    i2 = this.mTitleMarginStart + this.mTitleMarginEnd;
    if (shouldLayout((View)this.mTitleTextView)) {
      measureChildCollapseMargins((View)this.mTitleTextView, paramInt1, m + i2, paramInt2, i1, arrayOfInt);
      j = this.mTitleTextView.getMeasuredWidth();
      i3 = getHorizontalMargins((View)this.mTitleTextView);
      k = this.mTitleTextView.getMeasuredHeight();
      int i4 = getVerticalMargins((View)this.mTitleTextView);
      i = View.combineMeasuredStates(i, this.mTitleTextView.getMeasuredState());
      k += i4;
      j += i3;
    } else {
      j = 0;
      k = 0;
    } 
    if (shouldLayout((View)this.mSubtitleTextView)) {
      j = Math.max(j, measureChildCollapseMargins((View)this.mSubtitleTextView, paramInt1, m + i2, paramInt2, k + i1, arrayOfInt));
      k += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins((View)this.mSubtitleTextView);
      i = View.combineMeasuredStates(i, this.mSubtitleTextView.getMeasuredState());
    } 
    k = Math.max(n, k);
    i2 = getPaddingLeft();
    i3 = getPaddingRight();
    n = getPaddingTop();
    i1 = getPaddingBottom();
    j = View.resolveSizeAndState(Math.max(m + j + i2 + i3, getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i);
    paramInt2 = View.resolveSizeAndState(Math.max(k + n + i1, getSuggestedMinimumHeight()), paramInt2, i << 16);
    if (this.mCollapsible) {
      i = getChildCount();
      paramInt1 = 0;
      while (true) {
        if (paramInt1 < i) {
          View view = getChildAt(paramInt1);
          if (!shouldLayout(view) || view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            paramInt1++;
            continue;
          } 
        } else {
          paramInt1 = bool;
          break;
        } 
        paramInt1 = 0;
        break;
      } 
      if (paramInt1 != 0)
        paramInt2 = 0; 
      setMeasuredDimension(j, paramInt2);
      return;
    } 
    paramInt1 = 0;
    break;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    if (!(paramParcelable instanceof Toolbar$SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
      return;
    } 
    Toolbar$SavedState toolbar$SavedState = (Toolbar$SavedState)paramParcelable;
    super.onRestoreInstanceState(toolbar$SavedState.mSuperState);
    if (this.mMenuView != null) {
      MenuBuilder menuBuilder = this.mMenuView.mMenu;
    } else {
      paramParcelable = null;
    } 
    if (toolbar$SavedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && paramParcelable != null) {
      MenuItem menuItem = paramParcelable.findItem(toolbar$SavedState.expandedMenuItemId);
      if (menuItem != null)
        menuItem.expandActionView(); 
    } 
    if (toolbar$SavedState.isOverflowOpen) {
      removeCallbacks(this.mShowOverflowMenuRunnable);
      post(this.mShowOverflowMenuRunnable);
    } 
  }
  
  public void onRtlPropertiesChanged(int paramInt) {
    if (Build.VERSION.SDK_INT >= 17)
      super.onRtlPropertiesChanged(paramInt); 
    ensureContentInsets();
    RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
    boolean bool = true;
    if (paramInt != 1)
      bool = false; 
    if (bool != rtlSpacingHelper.mIsRtl) {
      rtlSpacingHelper.mIsRtl = bool;
      if (rtlSpacingHelper.mIsRelative) {
        if (bool) {
          if (rtlSpacingHelper.mEnd != Integer.MIN_VALUE) {
            paramInt = rtlSpacingHelper.mEnd;
          } else {
            paramInt = rtlSpacingHelper.mExplicitLeft;
          } 
          rtlSpacingHelper.mLeft = paramInt;
          if (rtlSpacingHelper.mStart != Integer.MIN_VALUE) {
            paramInt = rtlSpacingHelper.mStart;
          } else {
            paramInt = rtlSpacingHelper.mExplicitRight;
          } 
          rtlSpacingHelper.mRight = paramInt;
          return;
        } 
        if (rtlSpacingHelper.mStart != Integer.MIN_VALUE) {
          paramInt = rtlSpacingHelper.mStart;
        } else {
          paramInt = rtlSpacingHelper.mExplicitLeft;
        } 
        rtlSpacingHelper.mLeft = paramInt;
        if (rtlSpacingHelper.mEnd != Integer.MIN_VALUE) {
          paramInt = rtlSpacingHelper.mEnd;
        } else {
          paramInt = rtlSpacingHelper.mExplicitRight;
        } 
        rtlSpacingHelper.mRight = paramInt;
        return;
      } 
      rtlSpacingHelper.mLeft = rtlSpacingHelper.mExplicitLeft;
      rtlSpacingHelper.mRight = rtlSpacingHelper.mExplicitRight;
    } 
  }
  
  protected Parcelable onSaveInstanceState() {
    Toolbar$SavedState toolbar$SavedState = new Toolbar$SavedState(super.onSaveInstanceState());
    if (this.mExpandedMenuPresenter != null && this.mExpandedMenuPresenter.mCurrentExpandedItem != null)
      toolbar$SavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId(); 
    ActionMenuView actionMenuView = this.mMenuView;
    boolean bool = true;
    if (actionMenuView != null) {
      boolean bool1;
      actionMenuView = this.mMenuView;
      if (actionMenuView.mPresenter != null && actionMenuView.mPresenter.isOverflowMenuShowing()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if (bool1) {
        toolbar$SavedState.isOverflowOpen = bool;
        return (Parcelable)toolbar$SavedState;
      } 
    } 
    bool = false;
    toolbar$SavedState.isOverflowOpen = bool;
    return (Parcelable)toolbar$SavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
      this.mEatingTouch = false; 
    if (!this.mEatingTouch) {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if (i == 0 && !bool)
        this.mEatingTouch = true; 
    } 
    if (i == 1 || i == 3)
      this.mEatingTouch = false; 
    return true;
  }
  
  public final void setLogo(Drawable paramDrawable) {
    if (paramDrawable != null) {
      ensureLogoView();
      if (!isChildOrHidden((View)this.mLogoView))
        addSystemView((View)this.mLogoView, true); 
    } else if (this.mLogoView != null && isChildOrHidden((View)this.mLogoView)) {
      removeView((View)this.mLogoView);
      this.mHiddenViews.remove(this.mLogoView);
    } 
    if (this.mLogoView != null)
      this.mLogoView.setImageDrawable(paramDrawable); 
  }
  
  public final void setNavigationContentDescription(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence))
      ensureNavButtonView(); 
    if (this.mNavButtonView != null)
      this.mNavButtonView.setContentDescription(paramCharSequence); 
  }
  
  public final void setNavigationIcon(Drawable paramDrawable) {
    if (paramDrawable != null) {
      ensureNavButtonView();
      if (!isChildOrHidden((View)this.mNavButtonView))
        addSystemView((View)this.mNavButtonView, true); 
    } else if (this.mNavButtonView != null && isChildOrHidden((View)this.mNavButtonView)) {
      removeView((View)this.mNavButtonView);
      this.mHiddenViews.remove(this.mNavButtonView);
    } 
    if (this.mNavButtonView != null)
      this.mNavButtonView.setImageDrawable(paramDrawable); 
  }
  
  public final void setNavigationOnClickListener(View.OnClickListener paramOnClickListener) {
    ensureNavButtonView();
    this.mNavButtonView.setOnClickListener(paramOnClickListener);
  }
  
  public final void setPopupTheme(int paramInt) {
    if (this.mPopupTheme != paramInt) {
      this.mPopupTheme = paramInt;
      if (paramInt == 0) {
        getContext();
        return;
      } 
      new ContextThemeWrapper(getContext(), paramInt);
    } 
  }
  
  public final void setSubtitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.mSubtitleTextView == null) {
        Context context = getContext();
        this.mSubtitleTextView = new AppCompatTextView(context);
        this.mSubtitleTextView.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mSubtitleTextAppearance != 0)
          this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance); 
        if (this.mSubtitleTextColor != 0)
          this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor); 
      } 
      if (!isChildOrHidden((View)this.mSubtitleTextView))
        addSystemView((View)this.mSubtitleTextView, true); 
    } else if (this.mSubtitleTextView != null && isChildOrHidden((View)this.mSubtitleTextView)) {
      removeView((View)this.mSubtitleTextView);
      this.mHiddenViews.remove(this.mSubtitleTextView);
    } 
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setText(paramCharSequence); 
    this.mSubtitleText = paramCharSequence;
  }
  
  public final void setTitle(CharSequence paramCharSequence) {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      if (this.mTitleTextView == null) {
        Context context = getContext();
        this.mTitleTextView = new AppCompatTextView(context);
        this.mTitleTextView.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mTitleTextAppearance != 0)
          this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance); 
        if (this.mTitleTextColor != 0)
          this.mTitleTextView.setTextColor(this.mTitleTextColor); 
      } 
      if (!isChildOrHidden((View)this.mTitleTextView))
        addSystemView((View)this.mTitleTextView, true); 
    } else if (this.mTitleTextView != null && isChildOrHidden((View)this.mTitleTextView)) {
      removeView((View)this.mTitleTextView);
      this.mHiddenViews.remove(this.mTitleTextView);
    } 
    if (this.mTitleTextView != null)
      this.mTitleTextView.setText(paramCharSequence); 
    this.mTitleText = paramCharSequence;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\Toolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */