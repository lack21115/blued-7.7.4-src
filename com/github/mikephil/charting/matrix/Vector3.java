package com.github.mikephil.charting.matrix;

public final class Vector3 {
  public static final Vector3 d = new Vector3(0.0F, 0.0F, 0.0F);
  
  public static final Vector3 e = new Vector3(1.0F, 0.0F, 0.0F);
  
  public static final Vector3 f = new Vector3(0.0F, 1.0F, 0.0F);
  
  public static final Vector3 g = new Vector3(0.0F, 0.0F, 1.0F);
  
  public float a;
  
  public float b;
  
  public float c;
  
  public Vector3() {}
  
  public Vector3(float paramFloat1, float paramFloat2, float paramFloat3) {
    a(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3) {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\matrix\Vector3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */