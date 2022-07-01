package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader {
  private final int[] a = new int[4];
  
  private final int[] b = new int[8];
  
  private final float[] c = new float[4];
  
  private final float[] d = new float[4];
  
  private final int[] e;
  
  private final int[] f;
  
  public AbstractRSSReader() {
    int[] arrayOfInt = this.b;
    this.e = new int[arrayOfInt.length / 2];
    this.f = new int[arrayOfInt.length / 2];
  }
  
  protected static int a(int[] paramArrayOfint, int[][] paramArrayOfint1) throws NotFoundException {
    for (int i = 0; i < paramArrayOfint1.length; i++) {
      if (a(paramArrayOfint, paramArrayOfint1[i], 0.45F) < 0.2F)
        return i; 
    } 
    throw NotFoundException.a();
  }
  
  protected static void a(int[] paramArrayOfint, float[] paramArrayOffloat) {
    float f = paramArrayOffloat[0];
    int i = 1;
    int j = 0;
    while (i < paramArrayOfint.length) {
      float f1 = f;
      if (paramArrayOffloat[i] > f) {
        f1 = paramArrayOffloat[i];
        j = i;
      } 
      i++;
      f = f1;
    } 
    paramArrayOfint[j] = paramArrayOfint[j] + 1;
  }
  
  protected static boolean a(int[] paramArrayOfint) {
    int i = paramArrayOfint[0] + paramArrayOfint[1];
    int j = paramArrayOfint[2];
    int k = paramArrayOfint[3];
    float f = i / (j + i + k);
    if (f >= 0.7916667F && f <= 0.89285713F) {
      int m = Integer.MIN_VALUE;
      int n = paramArrayOfint.length;
      j = 0;
      for (i = Integer.MAX_VALUE; j < n; i = i2) {
        int i1 = paramArrayOfint[j];
        k = m;
        if (i1 > m)
          k = i1; 
        int i2 = i;
        if (i1 < i)
          i2 = i1; 
        j++;
        m = k;
      } 
      if (m < i * 10)
        return true; 
    } 
    return false;
  }
  
  protected static void b(int[] paramArrayOfint, float[] paramArrayOffloat) {
    float f = paramArrayOffloat[0];
    int i = 1;
    int j = 0;
    while (i < paramArrayOfint.length) {
      float f1 = f;
      if (paramArrayOffloat[i] < f) {
        f1 = paramArrayOffloat[i];
        j = i;
      } 
      i++;
      f = f1;
    } 
    paramArrayOfint[j] = paramArrayOfint[j] - 1;
  }
  
  protected final int[] b() {
    return this.a;
  }
  
  protected final int[] c() {
    return this.b;
  }
  
  protected final float[] d() {
    return this.c;
  }
  
  protected final float[] e() {
    return this.d;
  }
  
  protected final int[] f() {
    return this.e;
  }
  
  protected final int[] g() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\AbstractRSSReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */