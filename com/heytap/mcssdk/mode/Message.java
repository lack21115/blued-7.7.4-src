package com.heytap.mcssdk.mode;

public abstract class Message {
  private int a;
  
  private String b;
  
  private String c = "";
  
  public abstract int b();
  
  public void d(int paramInt) {
    this.a = paramInt;
  }
  
  public String e() {
    return this.c;
  }
  
  public void e(String paramString) {
    this.c = paramString;
  }
  
  public String f() {
    return this.b;
  }
  
  public void f(String paramString) {
    this.b = paramString;
  }
  
  public int g() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\heytap\mcssdk\mode\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */