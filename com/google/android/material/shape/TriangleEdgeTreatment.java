package com.google.android.material.shape;

public class TriangleEdgeTreatment extends EdgeTreatment {
  private final float a;
  
  private final boolean b;
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, ShapePath paramShapePath) {
    float f;
    paramShapePath.b(paramFloat2 - this.a * paramFloat3, 0.0F);
    if (this.b) {
      f = this.a;
    } else {
      f = -this.a;
    } 
    paramShapePath.b(paramFloat2, f * paramFloat3);
    paramShapePath.b(paramFloat2 + this.a * paramFloat3, 0.0F);
    paramShapePath.b(paramFloat1, 0.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\TriangleEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */