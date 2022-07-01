package androidx.transition;

import android.animation.TypeEvaluator;

class FloatArrayEvaluator implements TypeEvaluator<float[]> {
  private float[] a;
  
  FloatArrayEvaluator(float[] paramArrayOffloat) {
    this.a = paramArrayOffloat;
  }
  
  public float[] evaluate(float paramFloat, float[] paramArrayOffloat1, float[] paramArrayOffloat2) {
    float[] arrayOfFloat2 = this.a;
    float[] arrayOfFloat1 = arrayOfFloat2;
    if (arrayOfFloat2 == null)
      arrayOfFloat1 = new float[paramArrayOffloat1.length]; 
    int i;
    for (i = 0; i < arrayOfFloat1.length; i++) {
      float f = paramArrayOffloat1[i];
      arrayOfFloat1[i] = f + (paramArrayOffloat2[i] - f) * paramFloat;
    } 
    return arrayOfFloat1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\FloatArrayEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */