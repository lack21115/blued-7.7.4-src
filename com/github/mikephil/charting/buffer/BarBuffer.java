package com.github.mikephil.charting.buffer;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class BarBuffer extends AbstractBuffer<IBarDataSet> {
  protected int g = 0;
  
  protected int h = 1;
  
  protected boolean i = false;
  
  protected boolean j = false;
  
  protected float k = 1.0F;
  
  public BarBuffer(int paramInt1, int paramInt2, boolean paramBoolean) {
    super(paramInt1);
    this.h = paramInt2;
    this.i = paramBoolean;
  }
  
  public void a(float paramFloat) {
    this.k = paramFloat;
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    float[] arrayOfFloat = this.b;
    int i = this.a;
    this.a = i + 1;
    arrayOfFloat[i] = paramFloat1;
    arrayOfFloat = this.b;
    i = this.a;
    this.a = i + 1;
    arrayOfFloat[i] = paramFloat2;
    arrayOfFloat = this.b;
    i = this.a;
    this.a = i + 1;
    arrayOfFloat[i] = paramFloat3;
    arrayOfFloat = this.b;
    i = this.a;
    this.a = i + 1;
    arrayOfFloat[i] = paramFloat4;
  }
  
  public void a(int paramInt) {
    this.g = paramInt;
  }
  
  public void a(IBarDataSet paramIBarDataSet) {
    float f1 = paramIBarDataSet.H();
    float f2 = this.c;
    float f3 = this.k / 2.0F;
    int i;
    for (i = 0; i < f1 * f2; i++) {
      BarEntry barEntry = (BarEntry)paramIBarDataSet.e(i);
      if (barEntry != null) {
        float f5 = barEntry.i();
        float f4 = barEntry.b();
        float[] arrayOfFloat = barEntry.a();
        if (!this.i || arrayOfFloat == null) {
          float f;
          if (this.j) {
            if (f4 >= 0.0F) {
              f = f4;
            } else {
              f = 0.0F;
            } 
            if (f4 > 0.0F)
              f4 = 0.0F; 
            float f6 = f;
            f = f4;
            f4 = f6;
          } else {
            if (f4 >= 0.0F) {
              f = f4;
            } else {
              f = 0.0F;
            } 
            if (f4 > 0.0F)
              f4 = 0.0F; 
          } 
          if (f > 0.0F) {
            f *= this.d;
          } else {
            f4 *= this.d;
          } 
          a(f5 - f3, f, f5 + f3, f4);
        } else {
          float f = -barEntry.f();
          int j = 0;
          f4 = 0.0F;
          while (j < arrayOfFloat.length) {
            float f6;
            float f7 = arrayOfFloat[j];
            int k = f7 cmp 0.0F;
            if (k == 0 && (f4 == 0.0F || f == 0.0F)) {
              float f8 = f;
              f6 = f4;
              f4 = f7;
              f = f7;
              f7 = f8;
            } else if (k >= 0) {
              f7 += f4;
              float f8 = f;
              f6 = f7;
              f = f7;
              f7 = f8;
            } else {
              float f8 = Math.abs(f7);
              f7 = Math.abs(f7);
              f6 = f4;
              f4 = f;
              f7 += f;
              f = f8 + f;
            } 
            if (this.j) {
              float f8;
              if (f4 >= f) {
                f8 = f4;
              } else {
                f8 = f;
              } 
              if (f4 > f)
                f4 = f; 
              f = f4;
              f4 = f8;
            } else {
              float f8;
              if (f4 >= f) {
                f8 = f4;
              } else {
                f8 = f;
              } 
              if (f4 <= f) {
                f = f8;
              } else {
                f4 = f;
                f = f8;
              } 
            } 
            a(f5 - f3, f * this.d, f5 + f3, f4 * this.d);
            j++;
            f4 = f6;
            f = f7;
          } 
        } 
      } 
    } 
    a();
  }
  
  public void a(boolean paramBoolean) {
    this.j = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\charting\buffer\BarBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */