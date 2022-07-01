package com.qq.e.comm.plugin.j;

public class c extends Exception {
  private final String a;
  
  private final int b;
  
  public c(int paramInt, String paramString) {
    super(paramString);
    this.b = paramInt;
    this.a = paramString;
  }
  
  public c(int paramInt, String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
    this.b = paramInt;
    this.a = paramString;
  }
  
  public int a() {
    return this.b;
  }
  
  public String b() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */