package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

public class InterpolateOnScrollPositionChangeHelper {
  private View a;
  
  private MaterialShapeDrawable b;
  
  private ScrollView c;
  
  private final int[] d;
  
  private final int[] e;
  
  public void a() {
    ScrollView scrollView = this.c;
    if (scrollView == null)
      return; 
    if (scrollView.getChildCount() != 0) {
      this.c.getLocationInWindow(this.d);
      this.c.getChildAt(0).getLocationInWindow(this.e);
      int k = this.a.getTop() - this.d[1] + this.e[1];
      int i = this.a.getHeight();
      int j = this.c.getHeight();
      if (k < 0) {
        this.b.p(Math.max(0.0F, Math.min(1.0F, k / i + 1.0F)));
        this.a.invalidate();
        return;
      } 
      k += i;
      if (k > j) {
        this.b.p(Math.max(0.0F, Math.min(1.0F, 1.0F - (k - j) / i)));
        this.a.invalidate();
        return;
      } 
      if (this.b.Q() != 1.0F) {
        this.b.p(1.0F);
        this.a.invalidate();
      } 
      return;
    } 
    throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\InterpolateOnScrollPositionChangeHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */