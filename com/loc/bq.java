package com.loc;

public abstract class bq {
  bq c;
  
  public bq() {}
  
  public bq(bq parambq) {
    this.c = parambq;
  }
  
  public void a(int paramInt) {
    bq bq1 = this.c;
    if (bq1 != null)
      bq1.a(paramInt); 
  }
  
  public void a(boolean paramBoolean) {
    bq bq1 = this.c;
    if (bq1 != null)
      bq1.a(paramBoolean); 
  }
  
  protected abstract boolean a();
  
  public int b() {
    int i;
    bq bq1 = this.c;
    if (bq1 != null) {
      i = bq1.b();
    } else {
      i = Integer.MAX_VALUE;
    } 
    return Math.min(2147483647, i);
  }
  
  public final boolean c() {
    boolean bool;
    bq bq1 = this.c;
    if (bq1 != null) {
      bool = bq1.c();
    } else {
      bool = true;
    } 
    return !bool ? false : a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */