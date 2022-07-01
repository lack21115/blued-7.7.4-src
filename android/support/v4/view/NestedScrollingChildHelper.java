package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

public final class NestedScrollingChildHelper {
  public boolean mIsNestedScrollingEnabled;
  
  private ViewParent mNestedScrollingParentNonTouch;
  
  private ViewParent mNestedScrollingParentTouch;
  
  private int[] mTempNestedScrollConsumed;
  
  public final View mView;
  
  public NestedScrollingChildHelper(View paramView) {
    this.mView = paramView;
  }
  
  private void setNestedScrollingParentForType(int paramInt, ViewParent paramViewParent) {
    switch (paramInt) {
      default:
        return;
      case 1:
        this.mNestedScrollingParentNonTouch = paramViewParent;
        return;
      case 0:
        break;
    } 
    this.mNestedScrollingParentTouch = paramViewParent;
  }
  
  public final boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt3) {
    if (this.mIsNestedScrollingEnabled) {
      ViewParent viewParent = getNestedScrollingParentForType(paramInt3);
      if (viewParent == null)
        return false; 
      if (paramInt1 != 0 || paramInt2 != 0) {
        byte b1;
        byte b2;
        if (paramArrayOfint2 != null) {
          this.mView.getLocationInWindow(paramArrayOfint2);
          b1 = paramArrayOfint2[0];
          b2 = paramArrayOfint2[1];
        } else {
          b1 = 0;
          b2 = 0;
        } 
        int[] arrayOfInt = paramArrayOfint1;
        if (paramArrayOfint1 == null) {
          if (this.mTempNestedScrollConsumed == null)
            this.mTempNestedScrollConsumed = new int[2]; 
          arrayOfInt = this.mTempNestedScrollConsumed;
        } 
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        ViewParentCompat.onNestedPreScroll(viewParent, this.mView, paramInt1, paramInt2, arrayOfInt, paramInt3);
        if (paramArrayOfint2 != null) {
          this.mView.getLocationInWindow(paramArrayOfint2);
          paramArrayOfint2[0] = paramArrayOfint2[0] - b1;
          paramArrayOfint2[1] = paramArrayOfint2[1] - b2;
        } 
        return (arrayOfInt[0] == 0) ? ((arrayOfInt[1] != 0)) : true;
      } 
      if (paramArrayOfint2 != null) {
        paramArrayOfint2[0] = 0;
        paramArrayOfint2[1] = 0;
        return false;
      } 
    } 
    return false;
  }
  
  public final boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, int paramInt5) {
    if (this.mIsNestedScrollingEnabled) {
      ViewParent viewParent = getNestedScrollingParentForType(paramInt5);
      if (viewParent == null)
        return false; 
      if (paramInt1 != 0 || paramInt2 != 0 || paramInt3 != 0 || paramInt4 != 0) {
        byte b1;
        byte b2;
        if (paramArrayOfint != null) {
          this.mView.getLocationInWindow(paramArrayOfint);
          b1 = paramArrayOfint[0];
          b2 = paramArrayOfint[1];
        } else {
          b1 = 0;
          b2 = 0;
        } 
        ViewParentCompat.onNestedScroll(viewParent, this.mView, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
        if (paramArrayOfint != null) {
          this.mView.getLocationInWindow(paramArrayOfint);
          paramArrayOfint[0] = paramArrayOfint[0] - b1;
          paramArrayOfint[1] = paramArrayOfint[1] - b2;
        } 
        return true;
      } 
      if (paramArrayOfint != null) {
        paramArrayOfint[0] = 0;
        paramArrayOfint[1] = 0;
        return false;
      } 
    } 
    return false;
  }
  
  public final ViewParent getNestedScrollingParentForType(int paramInt) {
    switch (paramInt) {
      default:
        return null;
      case 1:
        return this.mNestedScrollingParentNonTouch;
      case 0:
        break;
    } 
    return this.mNestedScrollingParentTouch;
  }
  
  public final boolean hasNestedScrollingParent(int paramInt) {
    return (getNestedScrollingParentForType(paramInt) != null);
  }
  
  public final boolean startNestedScroll(int paramInt1, int paramInt2) {
    if (hasNestedScrollingParent(paramInt2))
      return true; 
    if (this.mIsNestedScrollingEnabled) {
      ViewParent viewParent = this.mView.getParent();
      View view = this.mView;
      while (viewParent != null) {
        if (ViewParentCompat.onStartNestedScroll(viewParent, view, this.mView, paramInt1, paramInt2)) {
          setNestedScrollingParentForType(paramInt2, viewParent);
          ViewParentCompat.onNestedScrollAccepted(viewParent, view, this.mView, paramInt1, paramInt2);
          return true;
        } 
        if (viewParent instanceof View)
          view = (View)viewParent; 
        viewParent = viewParent.getParent();
      } 
    } 
    return false;
  }
  
  public final void stopNestedScroll(int paramInt) {
    ViewParent viewParent = getNestedScrollingParentForType(paramInt);
    if (viewParent != null) {
      ViewParentCompat.onStopNestedScroll(viewParent, this.mView, paramInt);
      setNestedScrollingParentForType(paramInt, null);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\NestedScrollingChildHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */