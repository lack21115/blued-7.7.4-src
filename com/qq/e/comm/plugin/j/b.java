package com.qq.e.comm.plugin.j;

import java.util.concurrent.ExecutorService;

public final class b {
  private int a = 30000;
  
  private int b = 30000;
  
  private boolean c = true;
  
  private ExecutorService d;
  
  private b() {}
  
  public int a() {
    return this.a;
  }
  
  public int b() {
    return this.b;
  }
  
  public boolean c() {
    return this.c;
  }
  
  public ExecutorService d() {
    return this.d;
  }
  
  public static class a {
    private final b a = new b();
    
    public a a(int param1Int) {
      b.a(this.a, param1Int);
      return this;
    }
    
    public a a(ExecutorService param1ExecutorService) {
      b.a(this.a, param1ExecutorService);
      return this;
    }
    
    public a a(boolean param1Boolean) {
      b.a(this.a, param1Boolean);
      return this;
    }
    
    public b a() {
      return this.a;
    }
    
    public a b(int param1Int) {
      b.b(this.a, param1Int);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */