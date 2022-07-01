package com.bytedance.sdk.a.a;

import java.io.IOException;

public abstract class g implements r {
  private final r a;
  
  public g(r paramr) {
    if (paramr != null) {
      this.a = paramr;
      return;
    } 
    throw new IllegalArgumentException("delegate == null");
  }
  
  public t a() {
    return this.a.a();
  }
  
  public void a_(c paramc, long paramLong) throws IOException {
    this.a.a_(paramc, paramLong);
  }
  
  public void close() throws IOException {
    this.a.close();
  }
  
  public void flush() throws IOException {
    this.a.flush();
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */