package com.google.zxing.common.detector;

public final class MathUtils {
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    paramFloat1 -= paramFloat3;
    paramFloat2 -= paramFloat4;
    return (float)Math.sqrt((paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2));
  }
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    paramInt1 -= paramInt3;
    paramInt2 -= paramInt4;
    return (float)Math.sqrt((paramInt1 * paramInt1 + paramInt2 * paramInt2));
  }
  
  public static int a(float paramFloat) {
    float f;
    if (paramFloat < 0.0F) {
      f = -0.5F;
    } else {
      f = 0.5F;
    } 
    return (int)(paramFloat + f);
  }
  
  public static int a(int[] paramArrayOfint) {
    int k = paramArrayOfint.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      j += paramArrayOfint[i];
      i++;
    } 
    return j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\detector\MathUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */