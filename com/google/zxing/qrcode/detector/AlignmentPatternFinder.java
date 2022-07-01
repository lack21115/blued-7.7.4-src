package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.List;

final class AlignmentPatternFinder {
  private final BitMatrix a;
  
  private final List<AlignmentPattern> b;
  
  private final int c;
  
  private final int d;
  
  private final int e;
  
  private final int f;
  
  private final float g;
  
  private final int[] h;
  
  private final ResultPointCallback i;
  
  AlignmentPatternFinder(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, ResultPointCallback paramResultPointCallback) {
    this.a = paramBitMatrix;
    this.b = new ArrayList<AlignmentPattern>(5);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramFloat;
    this.h = new int[3];
    this.i = paramResultPointCallback;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    BitMatrix bitMatrix = this.a;
    int j = bitMatrix.f();
    int[] arrayOfInt = this.h;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    int i;
    for (i = paramInt1; i >= 0 && bitMatrix.a(paramInt2, i) && arrayOfInt[1] <= paramInt3; i--)
      arrayOfInt[1] = arrayOfInt[1] + 1; 
    if (i >= 0) {
      if (arrayOfInt[1] > paramInt3)
        return Float.NaN; 
      while (i >= 0 && !bitMatrix.a(paramInt2, i) && arrayOfInt[0] <= paramInt3) {
        arrayOfInt[0] = arrayOfInt[0] + 1;
        i--;
      } 
      if (arrayOfInt[0] > paramInt3)
        return Float.NaN; 
      while (++paramInt1 < j && bitMatrix.a(paramInt2, paramInt1) && arrayOfInt[1] <= paramInt3) {
        arrayOfInt[1] = arrayOfInt[1] + 1;
        paramInt1++;
      } 
      if (paramInt1 != j) {
        if (arrayOfInt[1] > paramInt3)
          return Float.NaN; 
        while (paramInt1 < j && !bitMatrix.a(paramInt2, paramInt1) && arrayOfInt[2] <= paramInt3) {
          arrayOfInt[2] = arrayOfInt[2] + 1;
          paramInt1++;
        } 
        if (arrayOfInt[2] > paramInt3)
          return Float.NaN; 
        if (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] - paramInt4) * 5 >= paramInt4 * 2)
          return Float.NaN; 
        if (a(arrayOfInt))
          return a(arrayOfInt, paramInt1); 
      } 
    } 
    return Float.NaN;
  }
  
  private static float a(int[] paramArrayOfint, int paramInt) {
    return (paramInt - paramArrayOfint[2]) - paramArrayOfint[1] / 2.0F;
  }
  
  private AlignmentPattern a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    int i = paramArrayOfint[0];
    int j = paramArrayOfint[1];
    int k = paramArrayOfint[2];
    float f1 = a(paramArrayOfint, paramInt2);
    float f2 = a(paramInt1, (int)f1, paramArrayOfint[1] * 2, i + j + k);
    if (!Float.isNaN(f2)) {
      float f = (paramArrayOfint[0] + paramArrayOfint[1] + paramArrayOfint[2]) / 3.0F;
      for (AlignmentPattern alignmentPattern1 : this.b) {
        if (alignmentPattern1.a(f, f2, f1))
          return alignmentPattern1.b(f2, f1, f); 
      } 
      AlignmentPattern alignmentPattern = new AlignmentPattern(f1, f2, f);
      this.b.add(alignmentPattern);
      ResultPointCallback resultPointCallback = this.i;
      if (resultPointCallback != null)
        resultPointCallback.a(alignmentPattern); 
    } 
    return null;
  }
  
  private boolean a(int[] paramArrayOfint) {
    float f1 = this.g;
    float f2 = f1 / 2.0F;
    int i;
    for (i = 0; i < 3; i++) {
      if (Math.abs(f1 - paramArrayOfint[i]) >= f2)
        return false; 
    } 
    return true;
  }
  
  AlignmentPattern a() throws NotFoundException {
    int j = this.c;
    int k = this.f;
    int m = this.e + j;
    int n = this.d;
    int i1 = k / 2;
    int[] arrayOfInt = new int[3];
    for (int i = 0; i < k; i++) {
      if ((i & 0x1) == 0) {
        i2 = (i + 1) / 2;
      } else {
        i2 = -((i + 1) / 2);
      } 
      int i5 = i2 + n + i1;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      arrayOfInt[2] = 0;
      int i3;
      for (i3 = j; i3 < m && !this.a.a(i3, i5); i3++);
      int i2 = 0;
      int i4;
      for (i4 = i3; i4 < m; i4++) {
        if (this.a.a(i4, i5)) {
          if (i2 == 1) {
            arrayOfInt[1] = arrayOfInt[1] + 1;
          } else if (i2 == 2) {
            if (a(arrayOfInt)) {
              AlignmentPattern alignmentPattern = a(arrayOfInt, i5, i4);
              if (alignmentPattern != null)
                return alignmentPattern; 
            } 
            arrayOfInt[0] = arrayOfInt[2];
            arrayOfInt[1] = 1;
            arrayOfInt[2] = 0;
            i2 = 1;
          } else {
            arrayOfInt[++i2] = arrayOfInt[i2] + 1;
          } 
        } else {
          i3 = i2;
          if (i2 == 1)
            i3 = i2 + 1; 
          arrayOfInt[i3] = arrayOfInt[i3] + 1;
          i2 = i3;
        } 
      } 
      if (a(arrayOfInt)) {
        AlignmentPattern alignmentPattern = a(arrayOfInt, i5, m);
        if (alignmentPattern != null)
          return alignmentPattern; 
      } 
    } 
    if (!this.b.isEmpty())
      return this.b.get(0); 
    throw NotFoundException.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\detector\AlignmentPatternFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */