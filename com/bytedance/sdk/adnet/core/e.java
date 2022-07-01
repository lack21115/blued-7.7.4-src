package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.d;

public class e implements d {
  private int a;
  
  private int b;
  
  private int c;
  
  private final float d;
  
  public e() {
    this(2500, 1, 1.0F);
  }
  
  public e(int paramInt1, int paramInt2, float paramFloat) {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramFloat;
  }
  
  public int a() {
    return this.a;
  }
  
  public e a(int paramInt) {
    this.a = paramInt;
    return this;
  }
  
  public void a(VAdError paramVAdError) throws VAdError {
    this.b++;
    int i = this.a;
    this.a = i + (int)(i * this.d);
    if (c())
      return; 
    throw paramVAdError;
  }
  
  public int b() {
    return this.b;
  }
  
  public e b(int paramInt) {
    this.c = paramInt;
    return this;
  }
  
  protected boolean c() {
    return (this.b <= this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\core\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */