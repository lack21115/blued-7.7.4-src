package com.scwang.smartrefresh.layout.listener;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;

public class SimpleMultiPurposeListener implements OnMultiPurposeListener {
  public void a(RefreshFooter paramRefreshFooter, int paramInt1, int paramInt2) {}
  
  public void a(RefreshFooter paramRefreshFooter, boolean paramBoolean) {}
  
  public void a(RefreshFooter paramRefreshFooter, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(RefreshHeader paramRefreshHeader, int paramInt1, int paramInt2) {}
  
  public void a(RefreshHeader paramRefreshHeader, boolean paramBoolean) {}
  
  public void a(RefreshHeader paramRefreshHeader, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(RefreshLayout paramRefreshLayout) {}
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {}
  
  public void b(RefreshFooter paramRefreshFooter, int paramInt1, int paramInt2) {}
  
  public void b(RefreshHeader paramRefreshHeader, int paramInt1, int paramInt2) {}
  
  public void onRefresh(RefreshLayout paramRefreshLayout) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\listener\SimpleMultiPurposeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */