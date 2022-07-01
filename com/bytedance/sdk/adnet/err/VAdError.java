package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.j;

public class VAdError extends Exception {
  public final j a = null;
  
  private long b;
  
  public VAdError() {}
  
  public VAdError(j paramj) {}
  
  public VAdError(String paramString) {
    super(paramString);
  }
  
  public VAdError(Throwable paramThrowable) {
    super(paramThrowable);
  }
  
  public void a(long paramLong) {
    this.b = paramLong;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\err\VAdError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */