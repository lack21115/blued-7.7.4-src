package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class MatrixEvaluator implements TypeEvaluator<Matrix> {
  private final float[] a = new float[9];
  
  private final float[] b = new float[9];
  
  private final Matrix c = new Matrix();
  
  public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2) {
    paramMatrix1.getValues(this.a);
    paramMatrix2.getValues(this.b);
    int i;
    for (i = 0; i < 9; i++) {
      float[] arrayOfFloat1 = this.b;
      float f1 = arrayOfFloat1[i];
      float[] arrayOfFloat2 = this.a;
      float f2 = arrayOfFloat2[i];
      arrayOfFloat1[i] = arrayOfFloat2[i] + (f1 - f2) * paramFloat;
    } 
    this.c.setValues(this.b);
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\animation\MatrixEvaluator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */