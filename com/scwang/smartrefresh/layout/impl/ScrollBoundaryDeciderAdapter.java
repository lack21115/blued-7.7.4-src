package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;

public class ScrollBoundaryDeciderAdapter implements ScrollBoundaryDecider {
  public PointF a;
  
  public ScrollBoundaryDecider b;
  
  public boolean c = true;
  
  public boolean a(View paramView) {
    ScrollBoundaryDecider scrollBoundaryDecider = this.b;
    return (scrollBoundaryDecider != null) ? scrollBoundaryDecider.a(paramView) : ScrollBoundaryUtil.a(paramView, this.a);
  }
  
  public boolean b(View paramView) {
    ScrollBoundaryDecider scrollBoundaryDecider = this.b;
    return (scrollBoundaryDecider != null) ? scrollBoundaryDecider.b(paramView) : ScrollBoundaryUtil.a(paramView, this.a, this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\impl\ScrollBoundaryDeciderAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */