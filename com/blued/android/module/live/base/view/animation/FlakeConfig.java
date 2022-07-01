package com.blued.android.module.live.base.view.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;

public class FlakeConfig {
  static SparseArray<Bitmap> i = new SparseArray();
  
  int a;
  
  int b;
  
  float c;
  
  float d;
  
  float e;
  
  float f;
  
  float g;
  
  Bitmap h;
  
  private float j = 1300.0F;
  
  private float k = 1800.0F;
  
  private float l = -90.0F;
  
  private float m = 90.0F;
  
  private float n = -45.0F;
  
  private float o = 90.0F;
  
  private float p;
  
  private float q;
  
  FlakeConfig(Context paramContext, float paramFloat1, float paramFloat2, Bitmap paramBitmap) {
    this.p = paramFloat1;
    this.q = paramFloat2;
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    this.a = i - (int)(Math.random() * i / 2.0D);
    this.b = j * this.a / i;
    b();
    this.h = (Bitmap)i.get(this.a);
    if (this.h == null) {
      this.h = Bitmap.createScaledBitmap(paramBitmap, this.a, this.b, true);
      i.put(this.a, this.h);
    } 
  }
  
  private void b() {
    this.c = (float)Math.random() * (this.p - this.a);
    this.d = 0.0F - this.b + (float)Math.random() * this.q;
    this.f = this.j + (float)Math.random() * (this.k - this.j);
    float f1 = (float)Math.random();
    float f2 = this.m;
    float f3 = this.l;
    this.e = f1 * (f2 - f3) + f3;
    f1 = (float)Math.random();
    f2 = this.o;
    f3 = this.n;
    this.g = f1 * (f2 - f3) + f3;
  }
  
  void a() {
    b();
  }
  
  void a(float paramFloat1, float paramFloat2) {
    if (paramFloat2 >= paramFloat1) {
      this.k = paramFloat2;
      this.j = paramFloat1;
      return;
    } 
    throw new IllegalArgumentException("speedMax must be >= speedMini");
  }
  
  void b(float paramFloat1, float paramFloat2) {
    if (paramFloat2 >= paramFloat1) {
      this.m = paramFloat2;
      this.l = paramFloat1;
      return;
    } 
    throw new IllegalArgumentException("degreeMax must be >= degreeMini");
  }
  
  void c(float paramFloat1, float paramFloat2) {
    if (paramFloat2 >= paramFloat1) {
      this.o = paramFloat2;
      this.n = paramFloat1;
      return;
    } 
    throw new IllegalArgumentException("rotationSpeedMax must be >= rotationSpeedMini");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\view\animation\FlakeConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */