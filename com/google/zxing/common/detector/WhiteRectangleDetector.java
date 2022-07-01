package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
  private final BitMatrix a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private final int f;
  
  private final int g;
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix) throws NotFoundException {
    this(paramBitMatrix, 10, paramBitMatrix.e() / 2, paramBitMatrix.f() / 2);
  }
  
  public WhiteRectangleDetector(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3) throws NotFoundException {
    this.a = paramBitMatrix;
    this.b = paramBitMatrix.f();
    this.c = paramBitMatrix.e();
    paramInt1 /= 2;
    this.d = paramInt2 - paramInt1;
    this.e = paramInt2 + paramInt1;
    this.g = paramInt3 - paramInt1;
    this.f = paramInt3 + paramInt1;
    if (this.g >= 0 && this.d >= 0 && this.f < this.b && this.e < this.c)
      return; 
    throw NotFoundException.a();
  }
  
  private ResultPoint a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    int j = MathUtils.a(MathUtils.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    float f = j;
    paramFloat3 = (paramFloat3 - paramFloat1) / f;
    paramFloat4 = (paramFloat4 - paramFloat2) / f;
    int i;
    for (i = 0; i < j; i++) {
      f = i;
      int k = MathUtils.a(f * paramFloat3 + paramFloat1);
      int m = MathUtils.a(f * paramFloat4 + paramFloat2);
      if (this.a.a(k, m))
        return new ResultPoint(k, m); 
    } 
    return null;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    int i = paramInt1;
    if (paramBoolean) {
      while (paramInt1 <= paramInt2) {
        if (this.a.a(paramInt1, paramInt3))
          return true; 
        paramInt1++;
      } 
    } else {
      while (i <= paramInt2) {
        if (this.a.a(paramInt3, i))
          return true; 
        i++;
      } 
    } 
    return false;
  }
  
  private ResultPoint[] a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4) {
    float f1 = paramResultPoint1.a();
    float f2 = paramResultPoint1.b();
    float f3 = paramResultPoint2.a();
    float f4 = paramResultPoint2.b();
    float f5 = paramResultPoint3.a();
    float f6 = paramResultPoint3.b();
    float f7 = paramResultPoint4.a();
    float f8 = paramResultPoint4.b();
    return (f1 < this.c / 2.0F) ? new ResultPoint[] { new ResultPoint(f7 - 1.0F, f8 + 1.0F), new ResultPoint(f3 + 1.0F, f4 + 1.0F), new ResultPoint(f5 - 1.0F, f6 - 1.0F), new ResultPoint(f1 + 1.0F, f2 - 1.0F) } : new ResultPoint[] { new ResultPoint(f7 + 1.0F, f8 + 1.0F), new ResultPoint(f3 + 1.0F, f4 - 1.0F), new ResultPoint(f5 - 1.0F, f6 + 1.0F), new ResultPoint(f1 - 1.0F, f2 - 1.0F) };
  }
  
  public ResultPoint[] a() throws NotFoundException {
    int n;
    int i1;
    int i2;
    int i5;
    boolean bool5;
    int j = this.d;
    int k = this.e;
    int i = this.g;
    int m = this.f;
    boolean bool7 = false;
    boolean bool6 = true;
    int i4 = 1;
    int i3 = 0;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    while (true) {
      n = k;
      i2 = i;
      i1 = m;
      bool5 = bool7;
      i5 = j;
      if (i4) {
        boolean bool = true;
        n = 0;
        i1 = i3;
        while ((bool || i1 == 0) && k < this.c) {
          boolean bool8 = a(i, m, k, false);
          if (bool8) {
            k++;
            i1 = 1;
            n = 1;
            bool = bool8;
            continue;
          } 
          bool = bool8;
          if (i1 == 0) {
            k++;
            bool = bool8;
          } 
        } 
        if (k < this.c) {
          bool = true;
          while ((bool || !bool4) && m < this.b) {
            boolean bool8 = a(j, k, m, true);
            if (bool8) {
              m++;
              bool4 = true;
              n = 1;
              bool = bool8;
              continue;
            } 
            bool = bool8;
            if (!bool4) {
              m++;
              bool = bool8;
            } 
          } 
          if (m < this.b) {
            bool = true;
            while ((bool || !bool3) && j >= 0) {
              boolean bool8 = a(i, m, j, false);
              if (bool8) {
                j--;
                bool3 = true;
                n = 1;
                bool = bool8;
                continue;
              } 
              bool = bool8;
              if (!bool3) {
                j--;
                bool = bool8;
              } 
            } 
            if (j >= 0) {
              bool = true;
              while ((bool || !bool2) && i >= 0) {
                boolean bool8 = a(j, k, i, true);
                if (bool8) {
                  i--;
                  bool2 = true;
                  n = 1;
                  bool = bool8;
                  continue;
                } 
                bool = bool8;
                if (!bool2) {
                  i--;
                  bool = bool8;
                } 
              } 
              if (i >= 0) {
                if (n != 0)
                  bool1 = true; 
                i4 = n;
                i3 = i1;
                continue;
              } 
            } 
          } 
        } 
        bool5 = true;
        n = k;
        i2 = i;
        i1 = m;
        i5 = j;
      } 
      break;
    } 
    if (!bool5 && bool1) {
      j = n - i5;
      ResultPoint resultPoint2 = null;
      ResultPoint resultPoint1 = null;
      for (i = 1; resultPoint1 == null && i < j; i++)
        resultPoint1 = a(i5, (i1 - i), (i5 + i), i1); 
      if (resultPoint1 != null) {
        ResultPoint resultPoint = null;
        for (i = 1; resultPoint == null && i < j; i++)
          resultPoint = a(i5, (i2 + i), (i5 + i), i2); 
        if (resultPoint != null) {
          ResultPoint resultPoint3 = null;
          for (i = 1; resultPoint3 == null && i < j; i++)
            resultPoint3 = a(n, (i2 + i), (n - i), i2); 
          if (resultPoint3 != null) {
            for (i = bool6; resultPoint2 == null && i < j; i++)
              resultPoint2 = a(n, (i1 - i), (n - i), i1); 
            if (resultPoint2 != null)
              return a(resultPoint2, resultPoint1, resultPoint3, resultPoint); 
            throw NotFoundException.a();
          } 
          throw NotFoundException.a();
        } 
        throw NotFoundException.a();
      } 
      throw NotFoundException.a();
    } 
    throw NotFoundException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\common\detector\WhiteRectangleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */