package com.amap.api.mapcore2d;

public abstract class fu {
  fu a;
  
  public fu() {}
  
  public fu(fu paramfu) {
    this.a = paramfu;
  }
  
  private boolean d() {
    fu fu1 = this.a;
    return (fu1 != null) ? fu1.c() : true;
  }
  
  public void a(int paramInt) {
    fu fu1 = this.a;
    if (fu1 != null)
      fu1.a(paramInt); 
  }
  
  public void a(boolean paramBoolean) {
    fu fu1 = this.a;
    if (fu1 != null)
      fu1.a(paramBoolean); 
  }
  
  protected abstract boolean a();
  
  public int b() {
    int i;
    fu fu1 = this.a;
    if (fu1 != null) {
      i = fu1.b();
    } else {
      i = Integer.MAX_VALUE;
    } 
    return Math.min(2147483647, i);
  }
  
  public boolean c() {
    return !d() ? false : a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */