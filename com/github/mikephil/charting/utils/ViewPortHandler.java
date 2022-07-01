package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class ViewPortHandler {
  protected final Matrix a = new Matrix();
  
  protected RectF b = new RectF();
  
  protected float c = 0.0F;
  
  protected float d = 0.0F;
  
  protected float[] e = new float[9];
  
  protected Matrix f = new Matrix();
  
  protected final float[] g = new float[9];
  
  private float h = 1.0F;
  
  private float i = Float.MAX_VALUE;
  
  private float j = 1.0F;
  
  private float k = Float.MAX_VALUE;
  
  private float l = 1.0F;
  
  private float m = 1.0F;
  
  private float n = 0.0F;
  
  private float o = 0.0F;
  
  private float p = 0.0F;
  
  private float q = 0.0F;
  
  public float a() {
    return this.b.left;
  }
  
  public Matrix a(Matrix paramMatrix, View paramView, boolean paramBoolean) {
    this.a.set(paramMatrix);
    a(this.a, this.b);
    if (paramBoolean)
      paramView.invalidate(); 
    paramMatrix.set(this.a);
    return paramMatrix;
  }
  
  public void a(float paramFloat) {
    float f = paramFloat;
    if (paramFloat < 1.0F)
      f = 1.0F; 
    this.j = f;
    a(this.a, this.b);
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    float f1 = a();
    float f2 = c();
    float f3 = b();
    float f4 = d();
    this.d = paramFloat2;
    this.c = paramFloat1;
    a(f1, f2, f3, f4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    this.b.set(paramFloat1, paramFloat2, this.c - paramFloat3, this.d - paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Matrix paramMatrix) {
    paramMatrix.reset();
    paramMatrix.set(this.a);
    paramMatrix.postScale(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void a(float paramFloat1, float paramFloat2, Matrix paramMatrix) {
    paramMatrix.reset();
    paramMatrix.set(this.a);
    paramMatrix.postScale(paramFloat1, paramFloat2);
  }
  
  public void a(Matrix paramMatrix, RectF paramRectF) {
    paramMatrix.getValues(this.g);
    float[] arrayOfFloat2 = this.g;
    float f3 = arrayOfFloat2[2];
    float f1 = arrayOfFloat2[0];
    float f4 = arrayOfFloat2[5];
    float f2 = arrayOfFloat2[4];
    this.l = Math.min(Math.max(this.j, f1), this.k);
    this.m = Math.min(Math.max(this.h, f2), this.i);
    f1 = 0.0F;
    if (paramRectF != null) {
      f1 = paramRectF.width();
      f2 = paramRectF.height();
    } else {
      f2 = 0.0F;
    } 
    this.n = Math.min(Math.max(f3, -f1 * (this.l - 1.0F) - this.p), this.p);
    this.o = Math.max(Math.min(f4, f2 * (this.m - 1.0F) + this.q), -this.q);
    float[] arrayOfFloat1 = this.g;
    arrayOfFloat1[2] = this.n;
    arrayOfFloat1[0] = this.l;
    arrayOfFloat1[5] = this.o;
    arrayOfFloat1[4] = this.m;
    paramMatrix.setValues(arrayOfFloat1);
  }
  
  public void a(float[] paramArrayOffloat, Matrix paramMatrix) {
    paramMatrix.reset();
    paramMatrix.set(this.a);
    float f1 = paramArrayOffloat[0];
    float f2 = a();
    float f3 = paramArrayOffloat[1];
    float f4 = c();
    paramMatrix.postTranslate(-(f1 - f2), -(f3 - f4));
  }
  
  public void a(float[] paramArrayOffloat, View paramView) {
    Matrix matrix = this.f;
    matrix.reset();
    matrix.set(this.a);
    float f1 = paramArrayOffloat[0];
    float f2 = a();
    float f3 = paramArrayOffloat[1];
    float f4 = c();
    matrix.postTranslate(-(f1 - f2), -(f3 - f4));
    a(matrix, paramView, true);
  }
  
  public float b() {
    return this.c - this.b.right;
  }
  
  public void b(float paramFloat) {
    float f = paramFloat;
    if (paramFloat == 0.0F)
      f = Float.MAX_VALUE; 
    this.k = f;
    a(this.a, this.b);
  }
  
  public void b(float paramFloat1, float paramFloat2, Matrix paramMatrix) {
    paramMatrix.reset();
    paramMatrix.set(this.a);
    paramMatrix.setScale(paramFloat1, paramFloat2);
  }
  
  public boolean b(float paramFloat1, float paramFloat2) {
    return (e(paramFloat1) && f(paramFloat2));
  }
  
  public float c() {
    return this.b.top;
  }
  
  public void c(float paramFloat) {
    float f = paramFloat;
    if (paramFloat < 1.0F)
      f = 1.0F; 
    this.h = f;
    a(this.a, this.b);
  }
  
  public float d() {
    return this.d - this.b.bottom;
  }
  
  public void d(float paramFloat) {
    float f = paramFloat;
    if (paramFloat == 0.0F)
      f = Float.MAX_VALUE; 
    this.i = f;
    a(this.a, this.b);
  }
  
  public float e() {
    return this.b.top;
  }
  
  public boolean e(float paramFloat) {
    return (g(paramFloat) && h(paramFloat));
  }
  
  public float f() {
    return this.b.left;
  }
  
  public boolean f(float paramFloat) {
    return (i(paramFloat) && j(paramFloat));
  }
  
  public float g() {
    return this.b.right;
  }
  
  public boolean g(float paramFloat) {
    return (this.b.left <= paramFloat + 1.0F);
  }
  
  public float h() {
    return this.b.bottom;
  }
  
  public boolean h(float paramFloat) {
    paramFloat = (int)(paramFloat * 100.0F) / 100.0F;
    return (this.b.right >= paramFloat - 1.0F);
  }
  
  public float i() {
    return this.b.width();
  }
  
  public boolean i(float paramFloat) {
    return (this.b.top <= paramFloat);
  }
  
  public float j() {
    return this.b.height();
  }
  
  public boolean j(float paramFloat) {
    paramFloat = (int)(paramFloat * 100.0F) / 100.0F;
    return (this.b.bottom >= paramFloat);
  }
  
  public RectF k() {
    return this.b;
  }
  
  public void k(float paramFloat) {
    this.p = Utils.a(paramFloat);
  }
  
  public MPPointF l() {
    return MPPointF.a(this.b.centerX(), this.b.centerY());
  }
  
  public void l(float paramFloat) {
    this.q = Utils.a(paramFloat);
  }
  
  public float m() {
    return this.d;
  }
  
  public float n() {
    return this.c;
  }
  
  public float o() {
    return Math.min(this.b.width(), this.b.height());
  }
  
  public Matrix p() {
    return this.a;
  }
  
  public float q() {
    return this.l;
  }
  
  public float r() {
    return this.m;
  }
  
  public boolean s() {
    return (u() && t());
  }
  
  public boolean t() {
    float f1 = this.m;
    float f2 = this.h;
    return (f1 <= f2 && f2 <= 1.0F);
  }
  
  public boolean u() {
    float f1 = this.l;
    float f2 = this.j;
    return (f1 <= f2 && f2 <= 1.0F);
  }
  
  public boolean v() {
    return (this.p <= 0.0F && this.q <= 0.0F);
  }
  
  public boolean w() {
    return (this.l > this.j);
  }
  
  public boolean x() {
    return (this.l < this.k);
  }
  
  public boolean y() {
    return (this.m > this.h);
  }
  
  public boolean z() {
    return (this.m < this.i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\ViewPortHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */