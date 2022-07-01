package com.scwang.smartrefresh.layout.api;

import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;

public interface RefreshLayout {
  RefreshLayout b(RefreshHeader paramRefreshHeader);
  
  RefreshLayout b(OnMultiPurposeListener paramOnMultiPurposeListener);
  
  RefreshLayout c(int... paramVarArgs);
  
  RefreshLayout e(float paramFloat);
  
  RefreshLayout e(boolean paramBoolean);
  
  RefreshLayout f(float paramFloat);
  
  ViewGroup getLayout();
  
  RefreshState getState();
  
  RefreshLayout h(boolean paramBoolean);
  
  RefreshLayout i(boolean paramBoolean);
  
  boolean i();
  
  RefreshLayout j();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\api\RefreshLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */