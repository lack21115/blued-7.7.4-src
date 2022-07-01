package com.google.android.material.shape;

public final class OffsetEdgeTreatment extends EdgeTreatment {
  private final EdgeTreatment a;
  
  private final float b;
  
  public OffsetEdgeTreatment(EdgeTreatment paramEdgeTreatment, float paramFloat) {
    this.a = paramEdgeTreatment;
    this.b = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, ShapePath paramShapePath) {
    this.a.a(paramFloat1, paramFloat2 - this.b, paramFloat3, paramShapePath);
  }
  
  boolean f() {
    return this.a.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\OffsetEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */