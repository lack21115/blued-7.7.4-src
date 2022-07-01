package com.chad.library.adapter.base.loadmore;

import com.chad.library.adapter.base.BaseViewHolder;

public abstract class LoadMoreView {
  private int a = 1;
  
  private boolean b = false;
  
  private void a(BaseViewHolder paramBaseViewHolder, boolean paramBoolean) {
    paramBaseViewHolder.c(b(), paramBoolean);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, boolean paramBoolean) {
    paramBaseViewHolder.c(c(), paramBoolean);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, boolean paramBoolean) {
    int i = d();
    if (i != 0)
      paramBaseViewHolder.c(i, paramBoolean); 
  }
  
  public abstract int a();
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public void a(BaseViewHolder paramBaseViewHolder) {
    int i = this.a;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          a(paramBaseViewHolder, false);
          b(paramBaseViewHolder, false);
          c(paramBaseViewHolder, true);
          return;
        } 
        a(paramBaseViewHolder, false);
        b(paramBaseViewHolder, true);
        c(paramBaseViewHolder, false);
        return;
      } 
      a(paramBaseViewHolder, true);
      b(paramBaseViewHolder, false);
      c(paramBaseViewHolder, false);
      return;
    } 
    a(paramBaseViewHolder, false);
    b(paramBaseViewHolder, false);
    c(paramBaseViewHolder, false);
  }
  
  public final void a(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  protected abstract int b();
  
  protected abstract int c();
  
  protected abstract int d();
  
  public int e() {
    return this.a;
  }
  
  public final boolean f() {
    return (d() == 0) ? true : this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\chad\library\adapter\base\loadmore\LoadMoreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */