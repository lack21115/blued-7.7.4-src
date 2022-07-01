package com.google.android.material.shape;

import android.graphics.RectF;

public class CornerTreatment {
  @Deprecated
  public void a(float paramFloat1, float paramFloat2, ShapePath paramShapePath) {}
  
  public void a(ShapePath paramShapePath, float paramFloat1, float paramFloat2, float paramFloat3) {
    a(paramFloat1, paramFloat2, paramShapePath);
  }
  
  public void a(ShapePath paramShapePath, float paramFloat1, float paramFloat2, RectF paramRectF, CornerSize paramCornerSize) {
    a(paramShapePath, paramFloat1, paramFloat2, paramCornerSize.a(paramRectF));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\CornerTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */