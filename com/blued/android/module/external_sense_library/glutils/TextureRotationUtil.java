package com.blued.android.module.external_sense_library.glutils;

public class TextureRotationUtil {
  public static final float[] a = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  
  public static final float[] b = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  
  public static final float[] c = new float[] { 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F };
  
  public static final float[] d = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  
  public static final float[] e = new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  
  public static final float[] f = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  
  public static final float[] g = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  
  public static final float[] h = new float[] { 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  
  private static float a(float paramFloat) {
    return (paramFloat == 0.0F) ? 1.0F : 0.0F;
  }
  
  public static float[] a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramInt != 0) {
      if (paramInt != 90) {
        if (paramInt != 180) {
          if (paramInt != 270) {
            arrayOfFloat1 = d;
          } else {
            arrayOfFloat1 = e;
          } 
        } else {
          arrayOfFloat1 = d;
        } 
      } else {
        arrayOfFloat1 = c;
      } 
    } else {
      arrayOfFloat1 = c;
    } 
    float[] arrayOfFloat2 = arrayOfFloat1;
    if (paramBoolean1)
      arrayOfFloat2 = new float[] { a(arrayOfFloat1[0]), arrayOfFloat1[1], a(arrayOfFloat1[2]), arrayOfFloat1[3], a(arrayOfFloat1[4]), arrayOfFloat1[5], a(arrayOfFloat1[6]), arrayOfFloat1[7] }; 
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (paramBoolean2)
      arrayOfFloat1 = new float[] { arrayOfFloat2[0], a(arrayOfFloat2[1]), arrayOfFloat2[2], a(arrayOfFloat2[3]), arrayOfFloat2[4], a(arrayOfFloat2[5]), arrayOfFloat2[6], a(arrayOfFloat2[7]) }; 
    return arrayOfFloat1;
  }
  
  public static float[] b(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramInt != 90) {
      if (paramInt != 180) {
        if (paramInt != 270) {
          arrayOfFloat1 = a;
        } else {
          arrayOfFloat1 = e;
        } 
      } else {
        arrayOfFloat1 = d;
      } 
    } else {
      arrayOfFloat1 = c;
    } 
    float[] arrayOfFloat2 = arrayOfFloat1;
    if (paramBoolean1)
      arrayOfFloat2 = new float[] { a(arrayOfFloat1[0]), arrayOfFloat1[1], a(arrayOfFloat1[2]), arrayOfFloat1[3], a(arrayOfFloat1[4]), arrayOfFloat1[5], a(arrayOfFloat1[6]), arrayOfFloat1[7] }; 
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (paramBoolean2)
      arrayOfFloat1 = new float[] { arrayOfFloat2[0], a(arrayOfFloat2[1]), arrayOfFloat2[2], a(arrayOfFloat2[3]), arrayOfFloat2[4], a(arrayOfFloat2[5]), arrayOfFloat2[6], a(arrayOfFloat2[7]) }; 
    return arrayOfFloat1;
  }
  
  public static float[] c(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramInt != 90) {
      if (paramInt != 180) {
        if (paramInt != 270) {
          arrayOfFloat1 = b;
        } else {
          arrayOfFloat1 = e;
        } 
      } else {
        arrayOfFloat1 = d;
      } 
    } else {
      arrayOfFloat1 = c;
    } 
    float[] arrayOfFloat2 = arrayOfFloat1;
    if (paramBoolean1)
      arrayOfFloat2 = new float[] { a(arrayOfFloat1[0]), arrayOfFloat1[1], a(arrayOfFloat1[2]), arrayOfFloat1[3], a(arrayOfFloat1[4]), arrayOfFloat1[5], a(arrayOfFloat1[6]), arrayOfFloat1[7] }; 
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (paramBoolean2)
      arrayOfFloat1 = new float[] { arrayOfFloat2[0], a(arrayOfFloat2[1]), arrayOfFloat2[2], a(arrayOfFloat2[3]), arrayOfFloat2[4], a(arrayOfFloat2[5]), arrayOfFloat2[6], a(arrayOfFloat2[7]) }; 
    return arrayOfFloat1;
  }
  
  public static float[] d(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramInt != 90) {
      if (paramInt != 180) {
        if (paramInt != 270) {
          arrayOfFloat1 = b;
        } else {
          arrayOfFloat1 = e;
        } 
      } else {
        arrayOfFloat1 = d;
      } 
    } else {
      arrayOfFloat1 = c;
    } 
    float[] arrayOfFloat2 = arrayOfFloat1;
    if (paramBoolean1)
      arrayOfFloat2 = new float[] { a(arrayOfFloat1[0]), arrayOfFloat1[1], a(arrayOfFloat1[2]), arrayOfFloat1[3], a(arrayOfFloat1[4]), arrayOfFloat1[5], a(arrayOfFloat1[6]), arrayOfFloat1[7] }; 
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (paramBoolean2)
      arrayOfFloat1 = new float[] { arrayOfFloat2[0], a(arrayOfFloat2[1]), arrayOfFloat2[2], a(arrayOfFloat2[3]), arrayOfFloat2[4], a(arrayOfFloat2[5]), arrayOfFloat2[6], a(arrayOfFloat2[7]) }; 
    return arrayOfFloat1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\glutils\TextureRotationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */