package com.airbnb.lottie.value;

public class ScaleXY {
  private float a;
  
  private float b;
  
  public ScaleXY() {
    this(1.0F, 1.0F);
  }
  
  public ScaleXY(float paramFloat1, float paramFloat2) {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public float a() {
    return this.a;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public float b() {
    return this.b;
  }
  
  public boolean b(float paramFloat1, float paramFloat2) {
    return (this.a == paramFloat1 && this.b == paramFloat2);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a());
    stringBuilder.append("x");
    stringBuilder.append(b());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\value\ScaleXY.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */