package com.soft.blued.customview.capricorn;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RotateAndTranslateAnimation extends Animation {
  private int a = 0;
  
  private int b = 0;
  
  private int c = 0;
  
  private int d = 0;
  
  private float e = 0.0F;
  
  private float f = 0.0F;
  
  private float g = 0.0F;
  
  private float h = 0.0F;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private float l;
  
  private float m;
  
  private float n;
  
  private int o = 0;
  
  private int p = 0;
  
  private float q = 0.0F;
  
  private float r = 0.0F;
  
  private float s;
  
  private float t;
  
  public RotateAndTranslateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
    this.e = paramFloat1;
    this.f = paramFloat2;
    this.g = paramFloat3;
    this.h = paramFloat4;
    this.a = 0;
    this.b = 0;
    this.c = 0;
    this.d = 0;
    this.m = paramFloat5;
    this.n = paramFloat6;
    this.q = 0.5F;
    this.o = 1;
    this.r = 0.5F;
    this.p = 1;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation) {
    float f1 = this.m;
    f1 += (this.n - f1) * paramFloat;
    if (this.s == 0.0F && this.t == 0.0F) {
      paramTransformation.getMatrix().setRotate(f1);
    } else {
      paramTransformation.getMatrix().setRotate(f1, this.s, this.t);
    } 
    float f3 = this.i;
    float f2 = this.k;
    float f4 = this.j;
    f1 = f3;
    if (f3 != f4)
      f1 = f3 + (f4 - f3) * paramFloat; 
    f3 = this.k;
    f4 = this.l;
    if (f3 != f4)
      f2 = f3 + (f4 - f3) * paramFloat; 
    paramTransformation.getMatrix().postTranslate(f1, f2);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = resolveSize(this.a, this.e, paramInt1, paramInt3);
    this.j = resolveSize(this.b, this.f, paramInt1, paramInt3);
    this.k = resolveSize(this.c, this.g, paramInt2, paramInt4);
    this.l = resolveSize(this.d, this.h, paramInt2, paramInt4);
    this.s = resolveSize(this.o, this.q, paramInt1, paramInt3);
    this.t = resolveSize(this.p, this.r, paramInt2, paramInt4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\capricorn\RotateAndTranslateAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */