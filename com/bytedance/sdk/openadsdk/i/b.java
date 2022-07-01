package com.bytedance.sdk.openadsdk.i;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class b<V> extends FutureTask<V> implements Comparable<b<V>> {
  private int a;
  
  private int b;
  
  public b(Runnable paramRunnable, V paramV, int paramInt1, int paramInt2) {
    super(paramRunnable, paramV);
    if (paramInt1 == -1)
      paramInt1 = 5; 
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public b(Callable<V> paramCallable, int paramInt1, int paramInt2) {
    super(paramCallable);
    if (paramInt1 == -1)
      paramInt1 = 5; 
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a() {
    return this.a;
  }
  
  public int a(b paramb) {
    return (a() < paramb.a()) ? 1 : ((a() > paramb.a()) ? -1 : 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */