package com.scwang.smartrefresh.layout.impl;

import android.view.View;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

public class RefreshFooterWrapper extends InternalAbstract implements RefreshFooter {
  public RefreshFooterWrapper(View paramView) {
    super(paramView);
  }
  
  public boolean a(boolean paramBoolean) {
    return (this.x instanceof RefreshFooter && ((RefreshFooter)this.x).a(paramBoolean));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\impl\RefreshFooterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */