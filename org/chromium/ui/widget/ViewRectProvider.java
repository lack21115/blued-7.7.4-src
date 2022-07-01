package org.chromium.ui.widget;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewTreeObserver;
import org.chromium.base.ApiCompatibilityUtils;

public final class ViewRectProvider extends RectProvider implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnPreDrawListener {
  private final int[] mCachedWindowCoordinates = new int[2];
  
  public boolean mIncludePadding;
  
  public final Rect mInsetRect = new Rect();
  
  private final View mView;
  
  private ViewTreeObserver mViewTreeObserver;
  
  public ViewRectProvider(View paramView) {
    this.mView = paramView;
    this.mCachedWindowCoordinates[0] = -1;
    this.mCachedWindowCoordinates[1] = -1;
  }
  
  public final void onGlobalLayout() {
    if (!this.mView.isShown())
      notifyRectHidden(); 
  }
  
  public final boolean onPreDraw() {
    if (!this.mView.isShown()) {
      notifyRectHidden();
    } else {
      refreshRectBounds();
    } 
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView) {
    notifyRectHidden();
  }
  
  public final void refreshRectBounds() {
    int i = this.mCachedWindowCoordinates[0];
    int j = this.mCachedWindowCoordinates[1];
    this.mView.getLocationInWindow(this.mCachedWindowCoordinates);
    this.mCachedWindowCoordinates[0] = Math.max(this.mCachedWindowCoordinates[0], 0);
    this.mCachedWindowCoordinates[1] = Math.max(this.mCachedWindowCoordinates[1], 0);
    if (this.mCachedWindowCoordinates[0] == i && this.mCachedWindowCoordinates[1] == j)
      return; 
    this.mRect.left = this.mCachedWindowCoordinates[0];
    this.mRect.top = this.mCachedWindowCoordinates[1];
    this.mRect.right = this.mRect.left + this.mView.getWidth();
    this.mRect.bottom = this.mRect.top + this.mView.getHeight();
    Rect rect = this.mRect;
    rect.left += this.mInsetRect.left;
    rect = this.mRect;
    rect.top += this.mInsetRect.top;
    rect = this.mRect;
    rect.right -= this.mInsetRect.right;
    rect = this.mRect;
    rect.bottom -= this.mInsetRect.bottom;
    if (!this.mIncludePadding) {
      boolean bool = ApiCompatibilityUtils.isLayoutRtl(this.mView);
      rect = this.mRect;
      j = rect.left;
      if (bool) {
        i = ViewCompat.getPaddingEnd(this.mView);
      } else {
        i = ViewCompat.getPaddingStart(this.mView);
      } 
      rect.left = j + i;
      rect = this.mRect;
      j = rect.right;
      if (bool) {
        i = ViewCompat.getPaddingStart(this.mView);
      } else {
        i = ViewCompat.getPaddingEnd(this.mView);
      } 
      rect.right = j - i;
      rect = this.mRect;
      rect.top += this.mView.getPaddingTop();
      rect = this.mRect;
      rect.bottom -= this.mView.getPaddingBottom();
    } 
    this.mRect.right = Math.max(this.mRect.left, this.mRect.right);
    this.mRect.bottom = Math.max(this.mRect.top, this.mRect.bottom);
    this.mRect.right = Math.min(this.mRect.right, this.mView.getRootView().getWidth());
    this.mRect.bottom = Math.min(this.mRect.bottom, this.mView.getRootView().getHeight());
    if (this.mObserver != null)
      this.mObserver.onRectChanged(); 
  }
  
  public final void startObserving(RectProvider$Observer paramRectProvider$Observer) {
    this.mView.addOnAttachStateChangeListener(this);
    this.mViewTreeObserver = this.mView.getViewTreeObserver();
    this.mViewTreeObserver.addOnGlobalLayoutListener(this);
    this.mViewTreeObserver.addOnPreDrawListener(this);
    refreshRectBounds();
    super.startObserving(paramRectProvider$Observer);
  }
  
  public final void stopObserving() {
    this.mView.removeOnAttachStateChangeListener(this);
    if (this.mViewTreeObserver != null && this.mViewTreeObserver.isAlive()) {
      this.mViewTreeObserver.removeOnGlobalLayoutListener(this);
      this.mViewTreeObserver.removeOnPreDrawListener(this);
    } 
    this.mViewTreeObserver = null;
    super.stopObserving();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\widget\ViewRectProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */