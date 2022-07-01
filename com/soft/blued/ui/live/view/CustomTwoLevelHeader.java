package com.soft.blued.ui.live.view;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.TwoLevelHeader;

public class CustomTwoLevelHeader extends TwoLevelHeader {
  RefreshState m;
  
  RefreshLayout n;
  
  private boolean o = false;
  
  public CustomTwoLevelHeader(Context paramContext) {
    super(paramContext);
  }
  
  public CustomTwoLevelHeader(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(RefreshLayout paramRefreshLayout, RefreshState paramRefreshState1, RefreshState paramRefreshState2) {
    this.m = paramRefreshState1;
    this.n = paramRefreshLayout;
    if (paramRefreshState2 != RefreshState.i || this.o)
      super.a(paramRefreshLayout, paramRefreshState1, paramRefreshState2); 
    this.o = false;
  }
  
  public void b() {
    this.o = true;
    a(this.n, this.m, RefreshState.i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\CustomTwoLevelHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */