package com.blued.android.module.live_china.view;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class CustomDurationScroller extends Scroller {
  private double a = 1.0D;
  
  public CustomDurationScroller(Context paramContext, Interpolator paramInterpolator) {
    super(paramContext, paramInterpolator);
  }
  
  public void a(double paramDouble) {
    this.a = paramDouble;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, (int)(paramInt5 * this.a));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\CustomDurationScroller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */