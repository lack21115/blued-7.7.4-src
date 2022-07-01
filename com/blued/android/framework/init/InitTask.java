package com.blued.android.framework.init;

public abstract class InitTask {
  private String a;
  
  public InitTask(String paramString) {
    this.a = paramString;
  }
  
  public String a() {
    return this.a;
  }
  
  public abstract void b();
  
  public boolean c() {
    return false;
  }
  
  public boolean d() {
    return false;
  }
  
  public boolean e() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\init\InitTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */