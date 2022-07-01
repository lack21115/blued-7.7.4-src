package com.scwang.smartrefresh.layout.listener;

import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;

public interface OnMultiPurposeListener extends OnRefreshLoadMoreListener, OnStateChangedListener {
  void a(RefreshFooter paramRefreshFooter, int paramInt1, int paramInt2);
  
  void a(RefreshFooter paramRefreshFooter, boolean paramBoolean);
  
  void a(RefreshFooter paramRefreshFooter, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3);
  
  void a(RefreshHeader paramRefreshHeader, int paramInt1, int paramInt2);
  
  void a(RefreshHeader paramRefreshHeader, boolean paramBoolean);
  
  void a(RefreshHeader paramRefreshHeader, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3);
  
  void b(RefreshFooter paramRefreshFooter, int paramInt1, int paramInt2);
  
  void b(RefreshHeader paramRefreshHeader, int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\listener\OnMultiPurposeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */