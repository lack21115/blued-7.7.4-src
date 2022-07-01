package com.scwang.smartrefresh.layout.api;

import android.view.View;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.listener.OnStateChangedListener;

public interface RefreshInternal extends OnStateChangedListener {
  int a(RefreshLayout paramRefreshLayout, boolean paramBoolean);
  
  void a(float paramFloat, int paramInt1, int paramInt2);
  
  void a(RefreshKernel paramRefreshKernel, int paramInt1, int paramInt2);
  
  void a(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2);
  
  void a(boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3);
  
  boolean a();
  
  void b(RefreshLayout paramRefreshLayout, int paramInt1, int paramInt2);
  
  SpinnerStyle getSpinnerStyle();
  
  View getView();
  
  void setPrimaryColors(int... paramVarArgs);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\api\RefreshInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */