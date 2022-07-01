package com.bytedance.sdk.a.b.a.e;

public enum b {
  a(0),
  b(1),
  c(2),
  d(3),
  e(7),
  f(8);
  
  public final int g;
  
  b(int paramInt1) {
    this.g = paramInt1;
  }
  
  public static b a(int paramInt) {
    for (b b1 : values()) {
      if (b1.g == paramInt)
        return b1; 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */