package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class t {
  public static final t c = new t() {
      public t a(long param1Long) {
        return this;
      }
      
      public t a(long param1Long, TimeUnit param1TimeUnit) {
        return this;
      }
      
      public void g() throws IOException {}
    };
  
  private boolean a;
  
  private long b;
  
  private long d;
  
  public t a(long paramLong) {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public t a(long paramLong, TimeUnit paramTimeUnit) {
    if (paramLong >= 0L) {
      if (paramTimeUnit != null) {
        this.d = paramTimeUnit.toNanos(paramLong);
        return this;
      } 
      throw new IllegalArgumentException("unit == null");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("timeout < 0: ");
    stringBuilder.append(paramLong);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public long aj_() {
    return this.d;
  }
  
  public boolean ak_() {
    return this.a;
  }
  
  public long d() {
    if (this.a)
      return this.b; 
    throw new IllegalStateException("No deadline");
  }
  
  public t e() {
    this.d = 0L;
    return this;
  }
  
  public t f() {
    this.a = false;
    return this;
  }
  
  public void g() throws IOException {
    if (!Thread.interrupted()) {
      if (this.a) {
        if (this.b - System.nanoTime() > 0L)
          return; 
        throw new InterruptedIOException("deadline reached");
      } 
      return;
    } 
    Thread.currentThread().interrupt();
    throw new InterruptedIOException("interrupted");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */