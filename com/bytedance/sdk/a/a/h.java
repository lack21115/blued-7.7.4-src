package com.bytedance.sdk.a.a;

import java.io.IOException;

public abstract class h implements s {
  private final s a;
  
  public h(s params) {
    if (params != null) {
      this.a = params;
      return;
    } 
    throw new IllegalArgumentException("delegate == null");
  }
  
  public long a(c paramc, long paramLong) throws IOException {
    return this.a.a(paramc, paramLong);
  }
  
  public t a() {
    return this.a.a();
  }
  
  public final s b() {
    return this.a;
  }
  
  public void close() throws IOException {
    this.a.close();
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append("(");
    stringBuilder.append(this.a.toString());
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */