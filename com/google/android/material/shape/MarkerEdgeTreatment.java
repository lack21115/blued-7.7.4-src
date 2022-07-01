package com.google.android.material.shape;

public final class MarkerEdgeTreatment extends EdgeTreatment {
  private final float a;
  
  public MarkerEdgeTreatment(float paramFloat) {
    this.a = paramFloat - 0.001F;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, ShapePath paramShapePath) {
    paramFloat1 = (float)(this.a * Math.sqrt(2.0D) / 2.0D);
    paramFloat3 = (float)Math.sqrt(Math.pow(this.a, 2.0D) - Math.pow(paramFloat1, 2.0D));
    paramShapePath.a(paramFloat2 - paramFloat1, (float)-(this.a * Math.sqrt(2.0D) - this.a) + paramFloat3);
    paramShapePath.b(paramFloat2, (float)-(this.a * Math.sqrt(2.0D) - this.a));
    paramShapePath.b(paramFloat2 + paramFloat1, (float)-(this.a * Math.sqrt(2.0D) - this.a) + paramFloat3);
  }
  
  boolean f() {
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\shape\MarkerEdgeTreatment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */