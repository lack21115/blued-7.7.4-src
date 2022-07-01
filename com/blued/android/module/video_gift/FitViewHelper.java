package com.blued.android.module.video_gift;

import android.graphics.Point;

public class FitViewHelper {
  private float a = 0.5625F;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private ScaleType f = ScaleType.d;
  
  private Point b(int paramInt1, int paramInt2) {
    int k = this.b;
    int j = paramInt1;
    int i = paramInt2;
    if (k != 0) {
      int m = this.c;
      j = paramInt1;
      i = paramInt2;
      if (m != 0) {
        j = k;
        i = m;
      } 
    } 
    float f1 = j;
    float f2 = i;
    float f3 = this.a;
    if (f1 > f2 * f3) {
      j = (int)((f2 * f3) + 0.5D);
    } else {
      i = (int)((f1 / f3) + 0.5D);
    } 
    return new Point(j, i);
  }
  
  private Point c(int paramInt1, int paramInt2) {
    int i = this.b;
    boolean bool = false;
    if (i != 0 && this.c != 0) {
      paramInt2 = (int)((i / this.a) + 0.5D);
      paramInt1 = i;
    } else if (paramInt1 != 0 && paramInt2 != 0) {
      paramInt2 = (int)((paramInt1 / this.a) + 0.5D);
    } else {
      paramInt1 = 0;
      paramInt2 = bool;
    } 
    return new Point(paramInt1, paramInt2);
  }
  
  private Point d(int paramInt1, int paramInt2) {
    int i = this.b;
    boolean bool = false;
    if (i != 0) {
      i = this.c;
      if (i != 0) {
        paramInt1 = (int)((i * this.a) + 0.5D);
        paramInt2 = i;
        return new Point(paramInt1, paramInt2);
      } 
    } 
    if (paramInt1 != 0 && paramInt2 != 0) {
      paramInt1 = (int)((paramInt2 * this.a) + 0.5D);
    } else {
      paramInt2 = 0;
      paramInt1 = bool;
    } 
    return new Point(paramInt1, paramInt2);
  }
  
  private Point e(int paramInt1, int paramInt2) {
    int i = this.b;
    if (i != 0) {
      int j = this.c;
      if (j != 0) {
        float f = this.a;
        if (f > i * 1.0F / j) {
          paramInt1 = (int)((j * f) + 0.5D);
          paramInt2 = j;
        } else {
          paramInt2 = (int)((i / f) + 0.5D);
          paramInt1 = i;
        } 
        return new Point(paramInt1, paramInt2);
      } 
    } 
    if (paramInt1 != 0 && paramInt2 != 0) {
      float f1 = this.a;
      float f2 = paramInt1;
      float f3 = paramInt2;
      if (f1 > 1.0F * f2 / f3) {
        paramInt1 = (int)((f3 * f1) + 0.5D);
      } else {
        paramInt2 = (int)((f2 / f1) + 0.5D);
      } 
    } else {
      paramInt1 = 0;
      paramInt2 = 0;
    } 
    return new Point(paramInt1, paramInt2);
  }
  
  public int a() {
    return this.d;
  }
  
  public void a(ScaleType paramScaleType) {
    this.f = paramScaleType;
  }
  
  public boolean a(float paramFloat, int paramInt1, int paramInt2) {
    if (paramFloat > 0.0D && paramInt1 >= 0 && paramInt2 >= 0) {
      if (this.a != paramFloat || this.b != paramInt1 || this.c != paramInt2) {
        this.a = paramFloat;
        this.b = paramInt1;
        this.c = paramInt2;
        return a(0, 0);
      } 
      return false;
    } 
    throw new IllegalArgumentException();
  }
  
  protected boolean a(int paramInt1, int paramInt2) {
    Point point;
    ScaleType scaleType1 = this.f;
    ScaleType scaleType2 = ScaleType.e;
    boolean bool = false;
    if (scaleType1 == scaleType2) {
      this.d = paramInt1;
      this.e = paramInt2;
      return false;
    } 
    if (this.f == ScaleType.a) {
      point = b(paramInt1, paramInt2);
    } else if (this.f == ScaleType.b) {
      point = c(paramInt1, paramInt2);
    } else if (this.f == ScaleType.c) {
      point = d(paramInt1, paramInt2);
    } else {
      point = e(paramInt1, paramInt2);
    } 
    if (point.x != this.d || point.y != this.e)
      bool = true; 
    this.d = point.x;
    this.e = point.y;
    return bool;
  }
  
  public int b() {
    return this.e;
  }
  
  public enum ScaleType {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\video_gift\FitViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */