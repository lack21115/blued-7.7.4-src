package com.bytedance.sdk.a.b.a;

public abstract class b implements Runnable {
  protected final String a;
  
  public b(String paramString, Object... paramVarArgs) {
    this.a = c.a(paramString, paramVarArgs);
  }
  
  protected abstract void a();
  
  public final void run() {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.a);
    try {
      a();
      return;
    } finally {
      Thread.currentThread().setName(str);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */