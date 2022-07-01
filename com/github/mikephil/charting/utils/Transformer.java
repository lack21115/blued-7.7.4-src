package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;

public class Transformer {
  protected Matrix a = new Matrix();
  
  protected Matrix b = new Matrix();
  
  protected ViewPortHandler c;
  
  protected float[] d = new float[1];
  
  protected float[] e = new float[1];
  
  protected float[] f = new float[1];
  
  protected float[] g = new float[1];
  
  protected Matrix h = new Matrix();
  
  float[] i = new float[2];
  
  private Matrix j = new Matrix();
  
  private Matrix k = new Matrix();
  
  public Transformer(ViewPortHandler paramViewPortHandler) {
    this.c = paramViewPortHandler;
  }
  
  public Matrix a() {
    this.j.set(this.a);
    this.j.postConcat(this.c.a);
    this.j.postConcat(this.b);
    return this.j;
  }
  
  public MPPointD a(float paramFloat1, float paramFloat2) {
    MPPointD mPPointD = MPPointD.a(0.0D, 0.0D);
    a(paramFloat1, paramFloat2, mPPointD);
    return mPPointD;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float f2 = this.c.i() / paramFloat2;
    float f1 = this.c.j() / paramFloat3;
    paramFloat2 = f2;
    if (Float.isInfinite(f2))
      paramFloat2 = 0.0F; 
    paramFloat3 = f1;
    if (Float.isInfinite(f1))
      paramFloat3 = 0.0F; 
    this.a.reset();
    this.a.postTranslate(-paramFloat1, -paramFloat4);
    this.a.postScale(paramFloat2, -paramFloat3);
  }
  
  public void a(float paramFloat1, float paramFloat2, MPPointD paramMPPointD) {
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    b(arrayOfFloat);
    arrayOfFloat = this.i;
    paramMPPointD.a = arrayOfFloat[0];
    paramMPPointD.b = arrayOfFloat[1];
  }
  
  public void a(Path paramPath) {
    paramPath.transform(this.a);
    paramPath.transform(this.c.p());
    paramPath.transform(this.b);
  }
  
  public void a(RectF paramRectF) {
    this.a.mapRect(paramRectF);
    this.c.p().mapRect(paramRectF);
    this.b.mapRect(paramRectF);
  }
  
  public void a(RectF paramRectF, float paramFloat) {
    paramRectF.top *= paramFloat;
    paramRectF.bottom *= paramFloat;
    this.a.mapRect(paramRectF);
    this.c.p().mapRect(paramRectF);
    this.b.mapRect(paramRectF);
  }
  
  public void a(boolean paramBoolean) {
    this.b.reset();
    if (!paramBoolean) {
      this.b.postTranslate(this.c.a(), this.c.m() - this.c.d());
      return;
    } 
    this.b.setTranslate(this.c.a(), -this.c.c());
    this.b.postScale(1.0F, -1.0F);
  }
  
  public void a(float[] paramArrayOffloat) {
    this.a.mapPoints(paramArrayOffloat);
    this.c.p().mapPoints(paramArrayOffloat);
    this.b.mapPoints(paramArrayOffloat);
  }
  
  public float[] a(IBubbleDataSet paramIBubbleDataSet, float paramFloat, int paramInt1, int paramInt2) {
    int i = (paramInt2 - paramInt1 + 1) * 2;
    if (this.e.length != i)
      this.e = new float[i]; 
    float[] arrayOfFloat = this.e;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2) {
      Entry entry = paramIBubbleDataSet.e(paramInt2 / 2 + paramInt1);
      if (entry != null) {
        arrayOfFloat[paramInt2] = entry.i();
        arrayOfFloat[paramInt2 + 1] = entry.b() * paramFloat;
      } else {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[paramInt2 + 1] = 0.0F;
      } 
    } 
    a().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] a(ICandleDataSet paramICandleDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
    int i = (int)((paramInt2 - paramInt1) * paramFloat1 + 1.0F) * 2;
    if (this.g.length != i)
      this.g = new float[i]; 
    float[] arrayOfFloat = this.g;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2) {
      CandleEntry candleEntry = (CandleEntry)paramICandleDataSet.e(paramInt2 / 2 + paramInt1);
      if (candleEntry != null) {
        arrayOfFloat[paramInt2] = candleEntry.i();
        arrayOfFloat[paramInt2 + 1] = candleEntry.a() * paramFloat2;
      } else {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[paramInt2 + 1] = 0.0F;
      } 
    } 
    a().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] a(ILineDataSet paramILineDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
    int i = ((int)((paramInt2 - paramInt1) * paramFloat1) + 1) * 2;
    if (this.f.length != i)
      this.f = new float[i]; 
    float[] arrayOfFloat = this.f;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2) {
      Entry entry = paramILineDataSet.e(paramInt2 / 2 + paramInt1);
      if (entry != null) {
        arrayOfFloat[paramInt2] = entry.i();
        arrayOfFloat[paramInt2 + 1] = entry.b() * paramFloat2;
      } else {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[paramInt2 + 1] = 0.0F;
      } 
    } 
    a().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public float[] a(IScatterDataSet paramIScatterDataSet, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2) {
    int i = (int)((paramInt2 - paramInt1) * paramFloat1 + 1.0F) * 2;
    if (this.d.length != i)
      this.d = new float[i]; 
    float[] arrayOfFloat = this.d;
    for (paramInt2 = 0; paramInt2 < i; paramInt2 += 2) {
      Entry entry = paramIScatterDataSet.e(paramInt2 / 2 + paramInt1);
      if (entry != null) {
        arrayOfFloat[paramInt2] = entry.i();
        arrayOfFloat[paramInt2 + 1] = entry.b() * paramFloat2;
      } else {
        arrayOfFloat[paramInt2] = 0.0F;
        arrayOfFloat[paramInt2 + 1] = 0.0F;
      } 
    } 
    a().mapPoints(arrayOfFloat);
    return arrayOfFloat;
  }
  
  public MPPointD b(float paramFloat1, float paramFloat2) {
    float[] arrayOfFloat = this.i;
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    a(arrayOfFloat);
    arrayOfFloat = this.i;
    return MPPointD.a(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public void b(RectF paramRectF, float paramFloat) {
    paramRectF.left *= paramFloat;
    paramRectF.right *= paramFloat;
    this.a.mapRect(paramRectF);
    this.c.p().mapRect(paramRectF);
    this.b.mapRect(paramRectF);
  }
  
  public void b(float[] paramArrayOffloat) {
    Matrix matrix = this.h;
    matrix.reset();
    this.b.invert(matrix);
    matrix.mapPoints(paramArrayOffloat);
    this.c.p().invert(matrix);
    matrix.mapPoints(paramArrayOffloat);
    this.a.invert(matrix);
    matrix.mapPoints(paramArrayOffloat);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\Transformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */