package com.google.zxing.common;

public final class PerspectiveTransform {
  private final float a;
  
  private final float b;
  
  private final float c;
  
  private final float d;
  
  private final float e;
  
  private final float f;
  
  private final float g;
  
  private final float h;
  
  private final float i;
  
  private PerspectiveTransform(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9) {
    this.a = paramFloat1;
    this.b = paramFloat4;
    this.c = paramFloat7;
    this.d = paramFloat2;
    this.e = paramFloat5;
    this.f = paramFloat8;
    this.g = paramFloat3;
    this.h = paramFloat6;
    this.i = paramFloat9;
  }
  
  public static PerspectiveTransform a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
    float f1 = paramFloat1 - paramFloat3 + paramFloat5 - paramFloat7;
    float f2 = paramFloat2 - paramFloat4 + paramFloat6 - paramFloat8;
    if (f1 == 0.0F && f2 == 0.0F)
      return new PerspectiveTransform(paramFloat3 - paramFloat1, paramFloat5 - paramFloat3, paramFloat1, paramFloat4 - paramFloat2, paramFloat6 - paramFloat4, paramFloat2, 0.0F, 0.0F, 1.0F); 
    float f3 = paramFloat3 - paramFloat5;
    float f4 = paramFloat7 - paramFloat5;
    paramFloat5 = paramFloat4 - paramFloat6;
    float f5 = paramFloat8 - paramFloat6;
    paramFloat6 = f3 * f5 - f4 * paramFloat5;
    f4 = (f5 * f1 - f4 * f2) / paramFloat6;
    paramFloat5 = (f3 * f2 - f1 * paramFloat5) / paramFloat6;
    return new PerspectiveTransform(f4 * paramFloat3 + paramFloat3 - paramFloat1, paramFloat5 * paramFloat7 + paramFloat7 - paramFloat1, paramFloat1, paramFloat4 - paramFloat2 + f4 * paramFloat4, paramFloat8 - paramFloat2 + paramFloat5 * paramFloat8, paramFloat2, f4, paramFloat5, 1.0F);
  }
  
  public static PerspectiveTransform a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16) {
    PerspectiveTransform perspectiveTransform = b(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8);
    return a(paramFloat9, paramFloat10, paramFloat11, paramFloat12, paramFloat13, paramFloat14, paramFloat15, paramFloat16).a(perspectiveTransform);
  }
  
  public static PerspectiveTransform b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
    return a(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramFloat8).a();
  }
  
  PerspectiveTransform a() {
    float f1 = this.e;
    float f2 = this.i;
    float f3 = this.f;
    float f4 = this.h;
    float f5 = this.g;
    float f6 = this.d;
    float f7 = this.c;
    float f8 = this.b;
    float f9 = this.a;
    return new PerspectiveTransform(f1 * f2 - f3 * f4, f3 * f5 - f6 * f2, f6 * f4 - f1 * f5, f7 * f4 - f8 * f2, f2 * f9 - f7 * f5, f5 * f8 - f4 * f9, f8 * f3 - f7 * f1, f7 * f6 - f3 * f9, f9 * f1 - f8 * f6);
  }
  
  PerspectiveTransform a(PerspectiveTransform paramPerspectiveTransform) {
    float f1 = this.a;
    float f2 = paramPerspectiveTransform.a;
    float f3 = this.d;
    float f4 = paramPerspectiveTransform.b;
    float f5 = this.g;
    float f6 = paramPerspectiveTransform.c;
    float f7 = paramPerspectiveTransform.d;
    float f8 = paramPerspectiveTransform.e;
    float f9 = paramPerspectiveTransform.f;
    float f10 = paramPerspectiveTransform.g;
    float f11 = paramPerspectiveTransform.h;
    float f12 = paramPerspectiveTransform.i;
    float f13 = this.b;
    float f14 = this.e;
    float f15 = this.h;
    float f16 = this.c;
    float f17 = this.f;
    float f18 = this.i;
    return new PerspectiveTransform(f1 * f2 + f3 * f4 + f5 * f6, f1 * f7 + f3 * f8 + f5 * f9, f1 * f10 + f3 * f11 + f5 * f12, f13 * f2 + f14 * f4 + f15 * f6, f13 * f7 + f14 * f8 + f15 * f9, f15 * f12 + f13 * f10 + f14 * f11, f6 * f18 + f2 * f16 + f4 * f17, f7 * f16 + f8 * f17 + f9 * f18, f16 * f10 + f17 * f11 + f18 * f12);
  }
  
  public void a(float[] paramArrayOffloat) {
    int j = paramArrayOffloat.length;
    float f1 = this.a;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    float f5 = this.e;
    float f6 = this.f;
    float f7 = this.g;
    float f8 = this.h;
    float f9 = this.i;
    int i;
    for (i = 0; i < j; i += 2) {
      float f10 = paramArrayOffloat[i];
      int k = i + 1;
      float f11 = paramArrayOffloat[k];
      float f12 = f3 * f10 + f6 * f11 + f9;
      paramArrayOffloat[i] = (f1 * f10 + f4 * f11 + f7) / f12;
      paramArrayOffloat[k] = (f10 * f2 + f11 * f5 + f8) / f12;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\PerspectiveTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */