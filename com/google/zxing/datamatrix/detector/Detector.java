package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Detector {
  private final BitMatrix a;
  
  private final WhiteRectangleDetector b;
  
  public Detector(BitMatrix paramBitMatrix) throws NotFoundException {
    this.a = paramBitMatrix;
    this.b = new WhiteRectangleDetector(paramBitMatrix);
  }
  
  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return MathUtils.a(ResultPoint.a(paramResultPoint1, paramResultPoint2));
  }
  
  private ResultPoint a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt) {
    float f2 = a(paramResultPoint1, paramResultPoint2);
    float f1 = paramInt;
    f2 /= f1;
    paramInt = a(paramResultPoint3, paramResultPoint4);
    float f4 = paramResultPoint4.a();
    float f5 = paramResultPoint3.a();
    float f3 = paramInt;
    f4 = (f4 - f5) / f3;
    f3 = (paramResultPoint4.b() - paramResultPoint3.b()) / f3;
    ResultPoint resultPoint = new ResultPoint(paramResultPoint4.a() + f4 * f2, paramResultPoint4.b() + f2 * f3);
    f1 = a(paramResultPoint1, paramResultPoint3) / f1;
    paramInt = a(paramResultPoint2, paramResultPoint4);
    f3 = paramResultPoint4.a();
    f4 = paramResultPoint2.a();
    f2 = paramInt;
    f3 = (f3 - f4) / f2;
    f2 = (paramResultPoint4.b() - paramResultPoint2.b()) / f2;
    paramResultPoint1 = new ResultPoint(paramResultPoint4.a() + f3 * f1, paramResultPoint4.b() + f1 * f2);
    return !a(resultPoint) ? (a(paramResultPoint1) ? paramResultPoint1 : null) : (!a(paramResultPoint1) ? resultPoint : ((Math.abs(b(paramResultPoint3, resultPoint).c() - b(paramResultPoint2, resultPoint).c()) <= Math.abs(b(paramResultPoint3, paramResultPoint1).c() - b(paramResultPoint2, paramResultPoint1).c())) ? resultPoint : paramResultPoint1));
  }
  
  private ResultPoint a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2) {
    float f1 = a(paramResultPoint1, paramResultPoint2) / paramInt1;
    int i = a(paramResultPoint3, paramResultPoint4);
    float f3 = paramResultPoint4.a();
    float f4 = paramResultPoint3.a();
    float f2 = i;
    f3 = (f3 - f4) / f2;
    f2 = (paramResultPoint4.b() - paramResultPoint3.b()) / f2;
    ResultPoint resultPoint = new ResultPoint(paramResultPoint4.a() + f3 * f1, paramResultPoint4.b() + f1 * f2);
    f1 = a(paramResultPoint1, paramResultPoint3) / paramInt2;
    i = a(paramResultPoint2, paramResultPoint4);
    f3 = paramResultPoint4.a();
    f4 = paramResultPoint2.a();
    f2 = i;
    f3 = (f3 - f4) / f2;
    f2 = (paramResultPoint4.b() - paramResultPoint2.b()) / f2;
    paramResultPoint1 = new ResultPoint(paramResultPoint4.a() + f3 * f1, paramResultPoint4.b() + f1 * f2);
    return !a(resultPoint) ? (a(paramResultPoint1) ? paramResultPoint1 : null) : (!a(paramResultPoint1) ? resultPoint : ((Math.abs(paramInt1 - b(paramResultPoint3, resultPoint).c()) + Math.abs(paramInt2 - b(paramResultPoint2, resultPoint).c()) <= Math.abs(paramInt1 - b(paramResultPoint3, paramResultPoint1).c()) + Math.abs(paramInt2 - b(paramResultPoint2, paramResultPoint1).c())) ? resultPoint : paramResultPoint1));
  }
  
  private static BitMatrix a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2) throws NotFoundException {
    GridSampler gridSampler = GridSampler.a();
    float f1 = paramInt1 - 0.5F;
    float f2 = paramInt2 - 0.5F;
    return gridSampler.a(paramBitMatrix, paramInt1, paramInt2, 0.5F, 0.5F, f1, 0.5F, f1, f2, 0.5F, f2, paramResultPoint1.a(), paramResultPoint1.b(), paramResultPoint4.a(), paramResultPoint4.b(), paramResultPoint3.a(), paramResultPoint3.b(), paramResultPoint2.a(), paramResultPoint2.b());
  }
  
  private static void a(Map<ResultPoint, Integer> paramMap, ResultPoint paramResultPoint) {
    Integer integer = paramMap.get(paramResultPoint);
    int i = 1;
    if (integer != null)
      i = 1 + integer.intValue(); 
    paramMap.put(paramResultPoint, Integer.valueOf(i));
  }
  
  private boolean a(ResultPoint paramResultPoint) {
    return (paramResultPoint.a() >= 0.0F && paramResultPoint.a() < this.a.e() && paramResultPoint.b() > 0.0F && paramResultPoint.b() < this.a.f());
  }
  
  private ResultPointsAndTransitions b(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    boolean bool;
    int i3 = (int)paramResultPoint1.a();
    int n = (int)paramResultPoint1.b();
    int m = (int)paramResultPoint2.a();
    int k = (int)paramResultPoint2.b();
    int i = Math.abs(k - n);
    int j = Math.abs(m - i3);
    int i4 = 0;
    byte b = 1;
    if (i > j) {
      bool = true;
    } else {
      bool = false;
    } 
    i = i3;
    j = n;
    int i2 = m;
    int i1 = k;
    if (bool) {
      j = i3;
      i = n;
      i1 = m;
      i2 = k;
    } 
    int i5 = Math.abs(i2 - i);
    int i6 = Math.abs(i1 - j);
    n = -i5 / 2;
    if (j < i1) {
      i3 = 1;
    } else {
      i3 = -1;
    } 
    if (i >= i2)
      b = -1; 
    BitMatrix bitMatrix = this.a;
    if (bool) {
      k = j;
    } else {
      k = i;
    } 
    if (bool) {
      m = i;
    } else {
      m = j;
    } 
    boolean bool1 = bitMatrix.a(k, m);
    k = i4;
    while (true) {
      i4 = k;
      if (i != i2) {
        bitMatrix = this.a;
        if (bool) {
          m = j;
        } else {
          m = i;
        } 
        if (bool) {
          i4 = i;
        } else {
          i4 = j;
        } 
        boolean bool3 = bitMatrix.a(m, i4);
        m = k;
        boolean bool2 = bool1;
        if (bool3 != bool1) {
          m = k + 1;
          bool2 = bool3;
        } 
        int i7 = n + i6;
        k = j;
        n = i7;
        if (i7 > 0) {
          i4 = m;
          if (j != i1) {
            k = j + i3;
            n = i7 - i5;
          } else {
            break;
          } 
        } 
        i += b;
        j = k;
        k = m;
        bool1 = bool2;
        continue;
      } 
      break;
    } 
    return new ResultPointsAndTransitions(paramResultPoint1, paramResultPoint2, i4);
  }
  
  public DetectorResult a() throws NotFoundException {
    ResultPoint resultPoint1;
    ResultPoint resultPoint3;
    ResultPoint[] arrayOfResultPoint = this.b.a();
    ResultPoint resultPoint4 = arrayOfResultPoint[0];
    ResultPoint resultPoint5 = arrayOfResultPoint[1];
    ResultPoint resultPoint6 = arrayOfResultPoint[2];
    ResultPoint resultPoint7 = arrayOfResultPoint[3];
    ArrayList<ResultPointsAndTransitions> arrayList = new ArrayList(4);
    arrayList.add(b(resultPoint4, resultPoint5));
    arrayList.add(b(resultPoint4, resultPoint6));
    arrayList.add(b(resultPoint5, resultPoint7));
    arrayList.add(b(resultPoint6, resultPoint7));
    ResultPoint resultPoint2 = null;
    Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
    ResultPointsAndTransitions resultPointsAndTransitions1 = arrayList.get(0);
    ResultPointsAndTransitions resultPointsAndTransitions2 = arrayList.get(1);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    a((Map)hashMap, resultPointsAndTransitions1.a());
    a((Map)hashMap, resultPointsAndTransitions1.b());
    a((Map)hashMap, resultPointsAndTransitions2.a());
    a((Map)hashMap, resultPointsAndTransitions2.b());
    Iterator<Map.Entry> iterator = hashMap.entrySet().iterator();
    ResultPointsAndTransitions resultPointsAndTransitions3 = null;
    resultPointsAndTransitions2 = resultPointsAndTransitions3;
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      ResultPoint resultPoint = (ResultPoint)entry.getKey();
      if (((Integer)entry.getValue()).intValue() == 2) {
        resultPoint3 = resultPoint;
        continue;
      } 
      if (resultPoint2 == null) {
        resultPoint2 = resultPoint;
        continue;
      } 
      resultPoint1 = resultPoint;
    } 
    if (resultPoint2 != null && resultPoint3 != null && resultPoint1 != null) {
      ResultPoint resultPoint8;
      BitMatrix bitMatrix2;
      ResultPoint[] arrayOfResultPoint1 = new ResultPoint[3];
      arrayOfResultPoint1[0] = resultPoint2;
      arrayOfResultPoint1[1] = resultPoint3;
      arrayOfResultPoint1[2] = resultPoint1;
      ResultPoint.a(arrayOfResultPoint1);
      ResultPoint resultPoint9 = arrayOfResultPoint1[0];
      ResultPoint resultPoint10 = arrayOfResultPoint1[1];
      resultPoint2 = arrayOfResultPoint1[2];
      if (!hashMap.containsKey(resultPoint4)) {
        resultPoint8 = resultPoint4;
      } else if (!hashMap.containsKey(resultPoint5)) {
        resultPoint8 = resultPoint5;
      } else if (!hashMap.containsKey(resultPoint6)) {
        resultPoint8 = resultPoint6;
      } else {
        resultPoint8 = resultPoint7;
      } 
      int k = b(resultPoint2, resultPoint8).c();
      int j = b(resultPoint9, resultPoint8).c();
      int i = k;
      if ((k & 0x1) == 1)
        i = k + 1; 
      k = i + 2;
      i = j;
      if ((j & 0x1) == 1)
        i = j + 1; 
      i += 2;
      if (k * 4 >= i * 7 || i * 4 >= k * 7) {
        resultPoint3 = resultPoint2;
        resultPoint4 = a(resultPoint10, resultPoint9, resultPoint2, resultPoint8, k, i);
        resultPoint1 = resultPoint4;
        if (resultPoint4 == null)
          resultPoint1 = resultPoint8; 
        j = b(resultPoint3, resultPoint1).c();
        k = b(resultPoint9, resultPoint1).c();
        i = j;
        if ((j & 0x1) == 1)
          i = j + 1; 
        j = k;
        if ((k & 0x1) == 1)
          j = k + 1; 
        bitMatrix1 = a(this.a, resultPoint3, resultPoint10, resultPoint9, resultPoint1, i, j);
        return new DetectorResult(bitMatrix1, new ResultPoint[] { resultPoint2, resultPoint10, resultPoint9, resultPoint1 });
      } 
      resultPoint3 = a(resultPoint10, resultPoint9, resultPoint2, (ResultPoint)bitMatrix1, Math.min(i, k));
      resultPoint1 = resultPoint3;
      if (resultPoint3 == null)
        bitMatrix2 = bitMatrix1; 
      j = Math.max(b(resultPoint2, (ResultPoint)bitMatrix2).c(), b(resultPoint9, (ResultPoint)bitMatrix2).c()) + 1;
      i = j;
      if ((j & 0x1) == 1)
        i = j + 1; 
      BitMatrix bitMatrix1 = a(this.a, resultPoint2, resultPoint10, resultPoint9, (ResultPoint)bitMatrix2, i, i);
      return new DetectorResult(bitMatrix1, new ResultPoint[] { resultPoint2, resultPoint10, resultPoint9, (ResultPoint)bitMatrix2 });
    } 
    throw NotFoundException.a();
  }
  
  static final class ResultPointsAndTransitions {
    private final ResultPoint a;
    
    private final ResultPoint b;
    
    private final int c;
    
    private ResultPointsAndTransitions(ResultPoint param1ResultPoint1, ResultPoint param1ResultPoint2, int param1Int) {
      this.a = param1ResultPoint1;
      this.b = param1ResultPoint2;
      this.c = param1Int;
    }
    
    ResultPoint a() {
      return this.a;
    }
    
    ResultPoint b() {
      return this.b;
    }
    
    int c() {
      return this.c;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append("/");
      stringBuilder.append(this.b);
      stringBuilder.append('/');
      stringBuilder.append(this.c);
      return stringBuilder.toString();
    }
  }
  
  static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
    private ResultPointsAndTransitionsComparator() {}
    
    public int a(Detector.ResultPointsAndTransitions param1ResultPointsAndTransitions1, Detector.ResultPointsAndTransitions param1ResultPointsAndTransitions2) {
      return param1ResultPointsAndTransitions1.c() - param1ResultPointsAndTransitions2.c();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\datamatrix\detector\Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */