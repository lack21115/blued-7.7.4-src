package com.qq.e.comm.plugin.ab.c;

public class f<T> {
  private T a;
  
  private String b;
  
  private int c;
  
  public f(int paramInt, String paramString) {
    this.b = paramString;
    this.c = paramInt;
    this.a = null;
  }
  
  public f(T paramT) {
    this.a = paramT;
    this.c = 0;
    this.b = "";
  }
  
  public T a() {
    return this.a;
  }
  
  public String b() {
    return this.b;
  }
  
  public int c() {
    return this.c;
  }
  
  public boolean d() {
    return (this.c == 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */