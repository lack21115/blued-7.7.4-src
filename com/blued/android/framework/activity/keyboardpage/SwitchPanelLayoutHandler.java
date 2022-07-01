package com.blued.android.framework.activity.keyboardpage;

import android.view.View;

public class SwitchPanelLayoutHandler {
  private boolean a = false;
  
  private final View b;
  
  private boolean c = false;
  
  public SwitchPanelLayoutHandler(View paramView) {
    this.b = paramView;
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public boolean a() {
    return this.c;
  }
  
  public boolean a(int paramInt) {
    if (paramInt == 0)
      this.a = false; 
    return (paramInt == this.b.getVisibility()) ? true : ((a() && paramInt == 0));
  }
  
  public int[] a(int paramInt1, int paramInt2) {
    if (this.a) {
      this.b.setVisibility(8);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    } 
    return new int[] { paramInt1, paramInt2 };
  }
  
  public void b() {
    this.a = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\activity\keyboardpage\SwitchPanelLayoutHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */