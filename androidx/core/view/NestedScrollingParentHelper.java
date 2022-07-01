package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {
  private int a;
  
  private int b;
  
  public NestedScrollingParentHelper(ViewGroup paramViewGroup) {}
  
  public int getNestedScrollAxes() {
    return this.a | this.b;
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt) {
    onNestedScrollAccepted(paramView1, paramView2, paramInt, 0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt1, int paramInt2) {
    if (paramInt2 == 1) {
      this.b = paramInt1;
      return;
    } 
    this.a = paramInt1;
  }
  
  public void onStopNestedScroll(View paramView) {
    onStopNestedScroll(paramView, 0);
  }
  
  public void onStopNestedScroll(View paramView, int paramInt) {
    if (paramInt == 1) {
      this.b = 0;
      return;
    } 
    this.a = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\NestedScrollingParentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */