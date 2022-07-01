package com.google.android.material.shape;

public class RoundedCornerTreatment extends CornerTreatment {
  float a = -1.0F;
  
  public void a(ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3) {
    paramShapePath.a(0.0F, paramFloat3 * paramFloat2, 180.0F, 180.0F - paramFloat1);
    paramFloat2 = paramFloat3 * 2.0F * paramFloat2;
    paramShapePath.a(0.0F, 0.0F, paramFloat2, paramFloat2, 180.0F, paramFloat1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\RoundedCornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */