package com.scwang.smartrefresh.layout.api;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

public interface RefreshContent {
  ValueAnimator.AnimatorUpdateListener a(int paramInt);
  
  View a();
  
  void a(int paramInt1, int paramInt2, int paramInt3);
  
  void a(MotionEvent paramMotionEvent);
  
  void a(RefreshKernel paramRefreshKernel, View paramView1, View paramView2);
  
  void a(ScrollBoundaryDecider paramScrollBoundaryDecider);
  
  void a(boolean paramBoolean);
  
  View b();
  
  boolean c();
  
  boolean d();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\api\RefreshContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */