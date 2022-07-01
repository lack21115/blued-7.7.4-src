package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionBarPolicy;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

abstract class AbsActionBarView extends ViewGroup {
  protected ActionMenuPresenter mActionMenuPresenter;
  
  protected int mContentHeight;
  
  private boolean mEatingHover;
  
  private boolean mEatingTouch;
  
  protected ActionMenuView mMenuView;
  
  private ViewPropertyAnimatorCompat mVisibilityAnim;
  
  AbsActionBarView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  AbsActionBarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    new AbsActionBarView$VisibilityAnimListener();
    TypedValue typedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0)
      new ContextThemeWrapper(paramContext, typedValue.resourceId); 
  }
  
  protected static int measureChildView(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - paramInt3);
  }
  
  protected static int next(int paramInt1, int paramInt2, boolean paramBoolean) {
    return paramBoolean ? (paramInt1 - paramInt2) : (paramInt1 + paramInt2);
  }
  
  protected static int positionChild(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 += (paramInt3 - j) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    } else {
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    } 
    return paramBoolean ? -i : i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    TypedArray typedArray = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    setContentHeight(typedArray.getLayoutDimension(R.styleable.ActionBar_height, 0));
    typedArray.recycle();
    if (this.mActionMenuPresenter != null) {
      ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
      if (!actionMenuPresenter.mMaxItemsSet)
        actionMenuPresenter.mMaxItems = ActionBarPolicy.get(actionMenuPresenter.mContext).getMaxActionButtons(); 
      if (actionMenuPresenter.mMenu != null)
        actionMenuPresenter.mMenu.onItemsChanged(true); 
    } 
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
  
  public void setContentHeight(int paramInt) {
    this.mContentHeight = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt) {
    if (paramInt != getVisibility()) {
      if (this.mVisibilityAnim != null)
        this.mVisibilityAnim.cancel(); 
      super.setVisibility(paramInt);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\AbsActionBarView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */