package com.airbnb.lottie.utils;

public class MeanCalculator {
  private float a;
  
  private int b;
  
  public void a(float paramFloat) {
    this.a += paramFloat;
    int i = ++this.b;
    if (i == Integer.MAX_VALUE) {
      this.a /= 2.0F;
      this.b = i / 2;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lotti\\utils\MeanCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */