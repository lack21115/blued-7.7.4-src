package com.bytedance.sdk.openadsdk.i;

import java.util.UUID;

public abstract class c implements Comparable<c>, Runnable {
  private int a = -1;
  
  private String b;
  
  public c() {
    this.a = 5;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UUID.randomUUID().toString());
    stringBuilder.append("-");
    stringBuilder.append(String.valueOf(System.nanoTime()));
    this.b = stringBuilder.toString();
  }
  
  public c(int paramInt) {
    if (paramInt == -1)
      paramInt = 5; 
    this.a = paramInt;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(UUID.randomUUID().toString());
    stringBuilder.append("-");
    stringBuilder.append(String.valueOf(System.nanoTime()));
    this.b = stringBuilder.toString();
  }
  
  public int a() {
    return this.a;
  }
  
  public int a(c paramc) {
    return (a() < paramc.a()) ? 1 : ((a() > paramc.a()) ? -1 : 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */