package com.airbnb.lottie.value;

public class LottieFrameInfo<T> {
  private float a;
  
  private float b;
  
  private T c;
  
  private T d;
  
  private float e;
  
  private float f;
  
  private float g;
  
  public LottieFrameInfo<T> a(float paramFloat1, float paramFloat2, T paramT1, T paramT2, float paramFloat3, float paramFloat4, float paramFloat5) {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramT1;
    this.d = paramT2;
    this.e = paramFloat3;
    this.f = paramFloat4;
    this.g = paramFloat5;
    return this;
  }
  
  public T a() {
    return this.c;
  }
  
  public T b() {
    return this.d;
  }
  
  public float c() {
    return this.f;
  }
  
  public float d() {
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\LottieFrameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */