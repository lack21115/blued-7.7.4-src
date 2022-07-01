package com.soft.blued.customview;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;

public class CoordinatorListView extends ListView implements NestedScrollingChild {
  private final NestedScrollingChildHelper a = new NestedScrollingChildHelper((View)this);
  
  public CoordinatorListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT >= 21)
      setNestedScrollingEnabled(true); 
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean) {
    return this.a.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2) {
    return this.a.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2) {
    return this.a.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfint1, paramArrayOfint2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
    return this.a.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
  }
  
  public boolean hasNestedScrollingParent() {
    return this.a.hasNestedScrollingParent();
  }
  
  public boolean isNestedScrollingEnabled() {
    return this.a.isNestedScrollingEnabled();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean) {
    this.a.setNestedScrollingEnabled(paramBoolean);
  }
  
  public boolean startNestedScroll(int paramInt) {
    return this.a.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll() {
    this.a.stopNestedScroll();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CoordinatorListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */