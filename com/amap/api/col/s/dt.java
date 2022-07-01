package com.amap.api.col.s;

public abstract class dt {
  dt c;
  
  public dt() {}
  
  public dt(dt paramdt) {
    this.c = paramdt;
  }
  
  public void a(int paramInt) {
    dt dt1 = this.c;
    if (dt1 != null)
      dt1.a(paramInt); 
  }
  
  public void a(boolean paramBoolean) {
    dt dt1 = this.c;
    if (dt1 != null)
      dt1.a(paramBoolean); 
  }
  
  protected abstract boolean a();
  
  public int b() {
    int i;
    dt dt1 = this.c;
    if (dt1 != null) {
      i = dt1.b();
    } else {
      i = Integer.MAX_VALUE;
    } 
    return Math.min(2147483647, i);
  }
  
  public final boolean c() {
    boolean bool;
    dt dt1 = this.c;
    if (dt1 != null) {
      bool = dt1.c();
    } else {
      bool = true;
    } 
    return !bool ? false : a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */