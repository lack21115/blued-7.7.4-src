package a.a.a.a.a.b.i;

import android.opengl.Matrix;

public class e {
  public static final float[] a() {
    return new float[] { 
        1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 
        1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
  }
  
  public static float[] a(float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
    float[] arrayOfFloat = new float[16];
    Matrix.multiplyMM(arrayOfFloat, 0, paramArrayOffloat1, 0, paramArrayOffloat2, 0);
    return arrayOfFloat;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */