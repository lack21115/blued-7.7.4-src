package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

public class NestedScrollingChildHelper {
  private ViewParent a;
  
  private ViewParent b;
  
  private final View c;
  
  private boolean d;
  
  private int[] e;
  
  public NestedScrollingChildHelper(View paramView) {
    this.c = paramView;
  }
  
  private ViewParent a(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? null : this.b) : this.a;
  }
  
  private void a(int paramInt, ViewParent paramViewParent) {
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      this.b = paramViewParent;
      return;
    } 
    this.a = paramViewParent;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int paramInt5, int[] paramArrayOfint2) {
    if (isNestedScrollingEnabled()) {
      ViewParent viewParent = a(paramInt5);
      if (viewParent == null)
        return false; 
      if (paramInt1 != 0 || paramInt2 != 0 || paramInt3 != 0 || paramInt4 != 0) {
        byte b1;
        byte b2;
        if (paramArrayOfint1 != null) {
          this.c.getLocationInWindow(paramArrayOfint1);
          b1 = paramArrayOfint1[0];
          b2 = paramArrayOfint1[1];
        } else {
          b1 = 0;
          b2 = 0;
        } 
        if (paramArrayOfint2 == null) {
          paramArrayOfint2 = a();
          paramArrayOfint2[0] = 0;
          paramArrayOfint2[1] = 0;
        } 
        ViewParentCompat.onNestedScroll(viewParent, this.c, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfint2);
        if (paramArrayOfint1 != null) {
          this.c.getLocationInWindow(paramArrayOfint1);
          paramArrayOfint1[0] = paramArrayOfint1[0] - b1;
          paramArrayOfint1[1] = paramArrayOfint1[1] - b2;
        } 
        return true;
      } 
      if (paramArrayOfint1 != null) {
        paramArrayOfint1[0] = 0;
        paramArrayOfint1[1] = 0;
        return false;
      } 
    } 
    return false;
  }
  
  private int[] a() {
    if (this.e == null)
      this.e = new int[2]; 
    return this.e;
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    if (isNestedScrollingEnabled()) {
      ViewParent viewParent = a(0);
      if (viewParent != null)
        return ViewParentCompat.onNestedFling(viewParent, this.c, paramFloat1, paramFloat2, paramBoolean); 
    } 
    return false;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    if (isNestedScrollingEnabled()) {
      ViewParent viewParent = a(0);
      if (viewParent != null)
        return ViewParentCompat.onNestedPreFling(viewParent, this.c, paramFloat1, paramFloat2); 
    } 
    return false;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2, 0);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt3) {
    if (isNestedScrollingEnabled()) {
      ViewParent viewParent = a(paramInt3);
      if (viewParent == null)
        return false; 
      boolean bool = true;
      if (paramInt1 != 0 || paramInt2 != 0) {
        byte b1;
        byte b2;
        if (paramArrayOfint2 != null) {
          this.c.getLocationInWindow(paramArrayOfint2);
          b1 = paramArrayOfint2[0];
          b2 = paramArrayOfint2[1];
        } else {
          b1 = 0;
          b2 = 0;
        } 
        int[] arrayOfInt = paramArrayOfint1;
        if (paramArrayOfint1 == null)
          arrayOfInt = a(); 
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        ViewParentCompat.onNestedPreScroll(viewParent, this.c, paramInt1, paramInt2, arrayOfInt, paramInt3);
        if (paramArrayOfint2 != null) {
          this.c.getLocationInWindow(paramArrayOfint2);
          paramArrayOfint2[0] = paramArrayOfint2[0] - b1;
          paramArrayOfint2[1] = paramArrayOfint2[1] - b2;
        } 
        if (arrayOfInt[0] == 0) {
          if (arrayOfInt[1] != 0)
            return true; 
          bool = false;
        } 
        return bool;
      } 
      if (paramArrayOfint2 != null) {
        paramArrayOfint2[0] = 0;
        paramArrayOfint2[1] = 0;
        return false;
      } 
    } 
    return false;
  }
  
  public void dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int paramInt5, int[] paramArrayOfint2) {
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint1, paramInt5, paramArrayOfint2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, 0, null);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, int paramInt5) {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint, paramInt5, null);
  }
  
  public boolean hasNestedScrollingParent() {
    return hasNestedScrollingParent(0);
  }
  
  public boolean hasNestedScrollingParent(int paramInt) {
    return (a(paramInt) != null);
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.d;
  }
  
  public void onDetachedFromWindow() {
    ViewCompat.stopNestedScroll(this.c);
  }
  
  public void onStopNestedScroll(View paramView) {
    ViewCompat.stopNestedScroll(this.c);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    if (this.d)
      ViewCompat.stopNestedScroll(this.c); 
    this.d = paramBoolean;
  }
  
  public boolean startNestedScroll(int paramInt) {
    return startNestedScroll(paramInt, 0);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2) {
    if (hasNestedScrollingParent(paramInt2))
      return true; 
    if (isNestedScrollingEnabled()) {
      ViewParent viewParent = this.c.getParent();
      View view = this.c;
      while (viewParent != null) {
        if (ViewParentCompat.onStartNestedScroll(viewParent, view, this.c, paramInt1, paramInt2)) {
          a(paramInt2, viewParent);
          ViewParentCompat.onNestedScrollAccepted(viewParent, view, this.c, paramInt1, paramInt2);
          return true;
        } 
        if (viewParent instanceof View)
          view = (View)viewParent; 
        viewParent = viewParent.getParent();
      } 
    } 
    return false;
  }
  
  public void stopNestedScroll() {
    stopNestedScroll(0);
  }
  
  public void stopNestedScroll(int paramInt) {
    ViewParent viewParent = a(paramInt);
    if (viewParent != null) {
      ViewParentCompat.onStopNestedScroll(viewParent, this.c, paramInt);
      a(paramInt, null);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\NestedScrollingChildHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */