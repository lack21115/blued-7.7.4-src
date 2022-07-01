package com.google.android.material.shape;

public class CutCornerTreatment extends CornerTreatment {
  float a = -1.0F;
  
  public void a(ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3) {
    paramShapePath.a(0.0F, paramFloat3 * paramFloat2, 180.0F, 180.0F - paramFloat1);
    double d1 = Math.sin(Math.toRadians(paramFloat1));
    double d2 = paramFloat3;
    double d3 = paramFloat2;
    paramShapePath.b((float)(d1 * d2 * d3), (float)(Math.sin(Math.toRadians((90.0F - paramFloat1))) * d2 * d3));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\CutCornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */