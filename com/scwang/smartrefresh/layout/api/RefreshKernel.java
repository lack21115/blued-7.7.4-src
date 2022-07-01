package com.scwang.smartrefresh.layout.api;

import android.animation.ValueAnimator;
import com.scwang.smartrefresh.layout.constant.RefreshState;

public interface RefreshKernel {
  ValueAnimator a(int paramInt);
  
  RefreshKernel a(int paramInt, boolean paramBoolean);
  
  RefreshKernel a(RefreshInternal paramRefreshInternal, int paramInt);
  
  RefreshKernel a(RefreshInternal paramRefreshInternal, boolean paramBoolean);
  
  RefreshKernel a(RefreshState paramRefreshState);
  
  RefreshKernel a(boolean paramBoolean);
  
  RefreshLayout a();
  
  RefreshKernel b();
  
  RefreshKernel b(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\api\RefreshKernel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */