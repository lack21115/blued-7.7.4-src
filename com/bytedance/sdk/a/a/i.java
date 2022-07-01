package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class i extends t {
  private t a;
  
  public i(t paramt) {
    if (paramt != null) {
      this.a = paramt;
      return;
    } 
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final i a(t paramt) {
    if (paramt != null) {
      this.a = paramt;
      return this;
    } 
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final t a() {
    return this.a;
  }
  
  public t a(long paramLong) {
    return this.a.a(paramLong);
  }
  
  public t a(long paramLong, TimeUnit paramTimeUnit) {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public long aj_() {
    return this.a.aj_();
  }
  
  public boolean ak_() {
    return this.a.ak_();
  }
  
  public long d() {
    return this.a.d();
  }
  
  public t e() {
    return this.a.e();
  }
  
  public t f() {
    return this.a.f();
  }
  
  public void g() throws IOException {
    this.a.g();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */