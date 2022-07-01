package com.amap.api.mapcore2d;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

class k {
  private static float I = (float)(Math.log(0.78D) / Math.log(0.9D));
  
  private static final float[] J = new float[101];
  
  private static final float[] K = new float[101];
  
  private static float O = 8.0F;
  
  private static float P = 1.0F;
  
  private float A;
  
  private float B;
  
  private boolean C = true;
  
  private Interpolator D;
  
  private boolean E;
  
  private float F;
  
  private int G;
  
  private float H = ViewConfiguration.getScrollFriction();
  
  private float L;
  
  private final float M;
  
  private float N;
  
  private int a;
  
  private int b;
  
  private int c;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private int g;
  
  private int h;
  
  private float i;
  
  private float j;
  
  private float k;
  
  private int l;
  
  private int m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private int q;
  
  private float r;
  
  private float s;
  
  private float t;
  
  private long u;
  
  private long v;
  
  private float w;
  
  private float x;
  
  private float y;
  
  private float z;
  
  static {
    P = 1.0F / a(1.0F);
  }
  
  public k(Context paramContext) {
    this(paramContext, null);
  }
  
  private k(Context paramContext, Interpolator paramInterpolator) {
    this(paramContext, paramInterpolator, bool);
  }
  
  private k(Context paramContext, Interpolator paramInterpolator, boolean paramBoolean) {
    this.D = paramInterpolator;
    this.M = (paramContext.getResources().getDisplayMetrics()).density * 160.0F;
    this.L = b(ViewConfiguration.getScrollFriction());
    this.E = paramBoolean;
    this.N = b(0.84F);
  }
  
  static float a(float paramFloat) {
    paramFloat *= O;
    if (paramFloat < 1.0F) {
      paramFloat -= 1.0F - (float)Math.exp(-paramFloat);
    } else {
      paramFloat = (1.0F - (float)Math.exp((1.0F - paramFloat))) * 0.63212055F + 0.36787945F;
    } 
    return paramFloat * P;
  }
  
  private float b(float paramFloat) {
    return this.M * 386.0878F * paramFloat;
  }
  
  public final void a(boolean paramBoolean) {
    this.C = paramBoolean;
  }
  
  public final boolean a() {
    return this.C;
  }
  
  public final int b() {
    return this.p;
  }
  
  public final int c() {
    return this.q;
  }
  
  public final float d() {
    return this.r;
  }
  
  public final float e() {
    return this.s;
  }
  
  public final float f() {
    return this.t;
  }
  
  public boolean g() {
    if (this.C)
      return false; 
    int i = (int)(AnimationUtils.currentAnimationTimeMillis() - this.u);
    long l1 = i;
    long l2 = this.v;
    if (l1 < l2) {
      int j = this.a;
      if (j != 1) {
        if (j != 2)
          return true; 
        float f = i * this.w;
        Interpolator interpolator = this.D;
        if (interpolator == null) {
          f = a(f);
        } else {
          f = interpolator.getInterpolation(f);
        } 
        this.p = this.b + Math.round(this.x * f);
        this.q = this.c + Math.round(this.y * f);
        this.r = this.d + this.z * f;
        this.s = this.e + this.A * f;
        this.t = this.f + f * this.B;
        return true;
      } 
      float f3 = i / (float)l2;
      i = (int)(f3 * 100.0F);
      float f1 = 1.0F;
      float f2 = 0.0F;
      if (i < 100) {
        f1 = i / 100.0F;
        j = i + 1;
        f2 = j / 100.0F;
        float[] arrayOfFloat = J;
        float f = arrayOfFloat[i];
        f2 = (arrayOfFloat[j] - f) / (f2 - f1);
        f1 = f + (f3 - f1) * f2;
      } 
      this.F = f2 * this.G / (float)this.v * 1000.0F;
      i = this.b;
      this.p = i + Math.round((this.g - i) * f1);
      this.p = Math.min(this.p, this.m);
      this.p = Math.max(this.p, this.l);
      i = this.c;
      this.q = i + Math.round(f1 * (this.h - i));
      this.q = Math.min(this.q, this.o);
      this.q = Math.max(this.q, this.n);
      if (this.p == this.g && this.q == this.h) {
        this.C = true;
        return true;
      } 
    } else {
      this.p = this.g;
      this.q = this.h;
      this.r = this.i;
      this.s = this.j;
      this.t = this.k;
      this.C = true;
    } 
    return true;
  }
  
  public final int h() {
    return this.a;
  }
  
  static {
    float f1 = 0.0F;
    int i = 0;
    float f2 = 0.0F;
    label26: while (i < 100) {
      float f4 = i / 100.0F;
      float f3 = 1.0F;
      while (true) {
        float f5 = (f3 - f1) / 2.0F + f1;
        float f6 = 1.0F - f5;
        float f7 = f5 * 3.0F * f6;
        float f8 = f5 * f5 * f5;
        float f9 = (f6 * 0.175F + f5 * 0.35000002F) * f7 + f8;
        if (Math.abs(f9 - f4) < 1.0E-5D) {
          J[i] = f7 * (f6 * 0.5F + f5) + f8;
          f3 = 1.0F;
          while (true) {
            f5 = (f3 - f2) / 2.0F + f2;
            f6 = 1.0F - f5;
            f7 = f5 * 3.0F * f6;
            f8 = f5 * f5 * f5;
            f9 = (f6 * 0.5F + f5) * f7 + f8;
            if (Math.abs(f9 - f4) < 1.0E-5D) {
              K[i] = f7 * (f6 * 0.175F + f5 * 0.35000002F) + f8;
              i++;
              continue label26;
            } 
            if (f9 > f4) {
              f3 = f5;
              continue;
            } 
            f2 = f5;
          } 
          break;
        } 
        if (f9 > f4) {
          f3 = f5;
          continue;
        } 
        f1 = f5;
      } 
    } 
    float[] arrayOfFloat = J;
    K[100] = 1.0F;
    arrayOfFloat[100] = 1.0F;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */