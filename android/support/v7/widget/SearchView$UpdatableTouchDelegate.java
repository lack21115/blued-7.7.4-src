package android.support.v7.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

final class SearchView$UpdatableTouchDelegate extends TouchDelegate {
  private final Rect mActualBounds;
  
  private boolean mDelegateTargeted;
  
  private final View mDelegateView;
  
  private final int mSlop;
  
  private final Rect mSlopBounds;
  
  private final Rect mTargetBounds;
  
  public SearchView$UpdatableTouchDelegate(Rect paramRect1, Rect paramRect2, View paramView) {
    super(paramRect1, paramView);
    this.mSlop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.mTargetBounds = new Rect();
    this.mSlopBounds = new Rect();
    this.mActualBounds = new Rect();
    setBounds(paramRect1, paramRect2);
    this.mDelegateView = paramView;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent) {
    boolean bool1;
    boolean bool3;
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    boolean bool = true;
    boolean bool2 = false;
    switch (i) {
      default:
        bool1 = false;
        i = bool;
        break;
      case 3:
        bool1 = this.mDelegateTargeted;
        this.mDelegateTargeted = false;
        i = bool;
        break;
      case 1:
      case 2:
        bool3 = this.mDelegateTargeted;
        bool1 = bool3;
        i = bool;
        if (bool3) {
          bool1 = bool3;
          i = bool;
          if (!this.mSlopBounds.contains(j, k)) {
            i = 0;
            bool1 = bool3;
          } 
        } 
        break;
      case 0:
        if (this.mTargetBounds.contains(j, k)) {
          this.mDelegateTargeted = true;
          bool1 = true;
          i = bool;
          break;
        } 
    } 
    if (bool1) {
      if (i != 0 && !this.mActualBounds.contains(j, k)) {
        paramMotionEvent.setLocation((this.mDelegateView.getWidth() / 2), (this.mDelegateView.getHeight() / 2));
      } else {
        paramMotionEvent.setLocation((j - this.mActualBounds.left), (k - this.mActualBounds.top));
      } 
      bool2 = this.mDelegateView.dispatchTouchEvent(paramMotionEvent);
    } 
    return bool2;
  }
  
  public final void setBounds(Rect paramRect1, Rect paramRect2) {
    this.mTargetBounds.set(paramRect1);
    this.mSlopBounds.set(paramRect1);
    this.mSlopBounds.inset(-this.mSlop, -this.mSlop);
    this.mActualBounds.set(paramRect2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\SearchView$UpdatableTouchDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */