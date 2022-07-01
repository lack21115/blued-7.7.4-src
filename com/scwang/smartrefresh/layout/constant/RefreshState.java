package com.scwang.smartrefresh.layout.constant;

public enum RefreshState {
  a(0, false, false, false, false),
  b(1, true, false, false, false),
  c(2, true, false, false, false),
  d(1, false, false, false, false),
  e(2, false, false, false, false),
  f(1, true, false, false, false),
  g(2, true, false, false, false),
  h(1, true, false, false, true),
  i(1, false, false, false, true),
  j(1, false, false, false, false),
  k(2, false, false, false, false),
  l(1, false, true, false, false),
  m(2, false, true, false, false),
  n(1, false, true, false, true),
  o(1, false, false, true, false),
  p(2, false, false, true, false),
  q(1, false, false, true, true);
  
  public final boolean r;
  
  public final boolean s;
  
  public final boolean t;
  
  public final boolean u;
  
  public final boolean v;
  
  public final boolean w;
  
  RefreshState(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {
    boolean bool2 = false;
    if (paramInt1 == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.r = bool1;
    boolean bool1 = bool2;
    if (paramInt1 == 2)
      bool1 = true; 
    this.s = bool1;
    this.u = paramBoolean1;
    this.v = paramBoolean2;
    this.w = paramBoolean3;
    this.t = paramBoolean4;
  }
  
  public RefreshState a() {
    return (this.r && !this.t) ? values()[ordinal() + 1] : this;
  }
  
  public RefreshState b() {
    return (this.s && !this.t) ? values()[ordinal() - 1] : null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\constant\RefreshState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */