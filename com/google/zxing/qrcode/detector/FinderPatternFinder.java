package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
  private final BitMatrix a;
  
  private final List<FinderPattern> b;
  
  private boolean c;
  
  private final int[] d;
  
  private final ResultPointCallback e;
  
  public FinderPatternFinder(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback) {
    this.a = paramBitMatrix;
    this.b = new ArrayList<FinderPattern>();
    this.d = new int[5];
    this.e = paramResultPointCallback;
  }
  
  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    BitMatrix bitMatrix = this.a;
    int k = bitMatrix.f();
    int[] arrayOfInt = a();
    int i;
    for (i = paramInt1; i >= 0 && bitMatrix.a(paramInt2, i); i--)
      arrayOfInt[2] = arrayOfInt[2] + 1; 
    int j = i;
    if (i < 0)
      return Float.NaN; 
    while (j >= 0 && !bitMatrix.a(paramInt2, j) && arrayOfInt[1] <= paramInt3) {
      arrayOfInt[1] = arrayOfInt[1] + 1;
      j--;
    } 
    if (j >= 0) {
      if (arrayOfInt[1] > paramInt3)
        return Float.NaN; 
      while (j >= 0 && bitMatrix.a(paramInt2, j) && arrayOfInt[0] <= paramInt3) {
        arrayOfInt[0] = arrayOfInt[0] + 1;
        j--;
      } 
      if (arrayOfInt[0] > paramInt3)
        return Float.NaN; 
      while (++paramInt1 < k && bitMatrix.a(paramInt2, paramInt1)) {
        arrayOfInt[2] = arrayOfInt[2] + 1;
        paramInt1++;
      } 
      i = paramInt1;
      if (paramInt1 == k)
        return Float.NaN; 
      while (i < k && !bitMatrix.a(paramInt2, i) && arrayOfInt[3] < paramInt3) {
        arrayOfInt[3] = arrayOfInt[3] + 1;
        i++;
      } 
      if (i != k) {
        if (arrayOfInt[3] >= paramInt3)
          return Float.NaN; 
        while (i < k && bitMatrix.a(paramInt2, i) && arrayOfInt[4] < paramInt3) {
          arrayOfInt[4] = arrayOfInt[4] + 1;
          i++;
        } 
        if (arrayOfInt[4] >= paramInt3)
          return Float.NaN; 
        if (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 5 >= paramInt4 * 2)
          return Float.NaN; 
        if (a(arrayOfInt))
          return a(arrayOfInt, i); 
      } 
    } 
    return Float.NaN;
  }
  
  private static float a(int[] paramArrayOfint, int paramInt) {
    return (paramInt - paramArrayOfint[4] - paramArrayOfint[3]) - paramArrayOfint[2] / 2.0F;
  }
  
  private boolean a(int paramInt1, int paramInt2) {
    int[] arrayOfInt = a();
    int i;
    for (i = 0; paramInt1 >= i && paramInt2 >= i && this.a.a(paramInt2 - i, paramInt1 - i); i++)
      arrayOfInt[2] = arrayOfInt[2] + 1; 
    if (arrayOfInt[2] == 0)
      return false; 
    while (paramInt1 >= i && paramInt2 >= i && !this.a.a(paramInt2 - i, paramInt1 - i)) {
      arrayOfInt[1] = arrayOfInt[1] + 1;
      i++;
    } 
    if (arrayOfInt[1] == 0)
      return false; 
    while (paramInt1 >= i && paramInt2 >= i && this.a.a(paramInt2 - i, paramInt1 - i)) {
      arrayOfInt[0] = arrayOfInt[0] + 1;
      i++;
    } 
    if (arrayOfInt[0] == 0)
      return false; 
    int k = this.a.f();
    int m = this.a.e();
    int j = 1;
    while (true) {
      int n = paramInt1 + j;
      i = j;
      if (n < k) {
        int i1 = paramInt2 + j;
        i = j;
        if (i1 < m) {
          i = j;
          if (this.a.a(i1, n)) {
            arrayOfInt[2] = arrayOfInt[2] + 1;
            j++;
            continue;
          } 
        } 
      } 
      break;
    } 
    while (true) {
      j = paramInt1 + i;
      if (j < k) {
        int n = paramInt2 + i;
        if (n < m && !this.a.a(n, j)) {
          arrayOfInt[3] = arrayOfInt[3] + 1;
          i++;
          continue;
        } 
      } 
      break;
    } 
    if (arrayOfInt[3] == 0)
      return false; 
    while (true) {
      j = paramInt1 + i;
      if (j < k) {
        int n = paramInt2 + i;
        if (n < m && this.a.a(n, j)) {
          arrayOfInt[4] = arrayOfInt[4] + 1;
          i++;
          continue;
        } 
      } 
      break;
    } 
    return (arrayOfInt[4] == 0) ? false : b(arrayOfInt);
  }
  
  protected static boolean a(int[] paramArrayOfint) {
    int i = 0;
    int j = 0;
    while (i < 5) {
      int k = paramArrayOfint[i];
      if (k == 0)
        return false; 
      j += k;
      i++;
    } 
    if (j < 7)
      return false; 
    float f1 = j / 7.0F;
    float f2 = f1 / 2.0F;
    return (Math.abs(f1 - paramArrayOfint[0]) < f2 && Math.abs(f1 - paramArrayOfint[1]) < f2 && Math.abs(f1 * 3.0F - paramArrayOfint[2]) < 3.0F * f2 && Math.abs(f1 - paramArrayOfint[3]) < f2 && Math.abs(f1 - paramArrayOfint[4]) < f2);
  }
  
  private int[] a() {
    c(this.d);
    return this.d;
  }
  
  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    BitMatrix bitMatrix = this.a;
    int k = bitMatrix.e();
    int[] arrayOfInt = a();
    int i;
    for (i = paramInt1; i >= 0 && bitMatrix.a(i, paramInt2); i--)
      arrayOfInt[2] = arrayOfInt[2] + 1; 
    int j = i;
    if (i < 0)
      return Float.NaN; 
    while (j >= 0 && !bitMatrix.a(j, paramInt2) && arrayOfInt[1] <= paramInt3) {
      arrayOfInt[1] = arrayOfInt[1] + 1;
      j--;
    } 
    if (j >= 0) {
      if (arrayOfInt[1] > paramInt3)
        return Float.NaN; 
      while (j >= 0 && bitMatrix.a(j, paramInt2) && arrayOfInt[0] <= paramInt3) {
        arrayOfInt[0] = arrayOfInt[0] + 1;
        j--;
      } 
      if (arrayOfInt[0] > paramInt3)
        return Float.NaN; 
      while (++paramInt1 < k && bitMatrix.a(paramInt1, paramInt2)) {
        arrayOfInt[2] = arrayOfInt[2] + 1;
        paramInt1++;
      } 
      i = paramInt1;
      if (paramInt1 == k)
        return Float.NaN; 
      while (i < k && !bitMatrix.a(i, paramInt2) && arrayOfInt[3] < paramInt3) {
        arrayOfInt[3] = arrayOfInt[3] + 1;
        i++;
      } 
      if (i != k) {
        if (arrayOfInt[3] >= paramInt3)
          return Float.NaN; 
        while (i < k && bitMatrix.a(i, paramInt2) && arrayOfInt[4] < paramInt3) {
          arrayOfInt[4] = arrayOfInt[4] + 1;
          i++;
        } 
        if (arrayOfInt[4] >= paramInt3)
          return Float.NaN; 
        if (Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) * 5 >= paramInt4)
          return Float.NaN; 
        if (a(arrayOfInt))
          return a(arrayOfInt, i); 
      } 
    } 
    return Float.NaN;
  }
  
  private int b() {
    if (this.b.size() <= 1)
      return 0; 
    FinderPattern finderPattern = null;
    for (FinderPattern finderPattern1 : this.b) {
      if (finderPattern1.d() >= 2) {
        if (finderPattern == null) {
          finderPattern = finderPattern1;
          continue;
        } 
        this.c = true;
        return (int)(Math.abs(finderPattern.a() - finderPattern1.a()) - Math.abs(finderPattern.b() - finderPattern1.b())) / 2;
      } 
    } 
    return 0;
  }
  
  protected static boolean b(int[] paramArrayOfint) {
    int i = 0;
    int j = 0;
    while (i < 5) {
      int k = paramArrayOfint[i];
      if (k == 0)
        return false; 
      j += k;
      i++;
    } 
    if (j < 7)
      return false; 
    float f1 = j / 7.0F;
    float f2 = f1 / 1.333F;
    return (Math.abs(f1 - paramArrayOfint[0]) < f2 && Math.abs(f1 - paramArrayOfint[1]) < f2 && Math.abs(f1 * 3.0F - paramArrayOfint[2]) < 3.0F * f2 && Math.abs(f1 - paramArrayOfint[3]) < f2 && Math.abs(f1 - paramArrayOfint[4]) < f2);
  }
  
  private boolean c() {
    int j = this.b.size();
    Iterator<FinderPattern> iterator = this.b.iterator();
    float f2 = 0.0F;
    int i = 0;
    float f1 = 0.0F;
    while (iterator.hasNext()) {
      FinderPattern finderPattern = iterator.next();
      if (finderPattern.d() >= 2) {
        i++;
        f1 += finderPattern.c();
      } 
    } 
    if (i < 3)
      return false; 
    float f3 = f1 / j;
    iterator = this.b.iterator();
    while (iterator.hasNext())
      f2 += Math.abs(((FinderPattern)iterator.next()).c() - f3); 
    return (f2 <= f1 * 0.05F);
  }
  
  private FinderPattern[] d() throws NotFoundException {
    int i = this.b.size();
    if (i >= 3) {
      float f = 0.0F;
      if (i > 3) {
        Iterator<FinderPattern> iterator = this.b.iterator();
        float f2 = 0.0F;
        float f1;
        for (f1 = 0.0F; iterator.hasNext(); f1 += f4 * f4) {
          float f4 = ((FinderPattern)iterator.next()).c();
          f2 += f4;
        } 
        float f3 = i;
        f2 /= f3;
        f1 = (float)Math.sqrt((f1 / f3 - f2 * f2));
        Collections.sort(this.b, new FurthestFromAverageComparator(f2));
        f1 = Math.max(0.2F * f2, f1);
        for (i = 0; i < this.b.size() && this.b.size() > 3; i = j + 1) {
          int j = i;
          if (Math.abs(((FinderPattern)this.b.get(i)).c() - f2) > f1) {
            this.b.remove(i);
            j = i - 1;
          } 
        } 
      } 
      if (this.b.size() > 3) {
        Iterator<FinderPattern> iterator = this.b.iterator();
        float f1;
        for (f1 = f; iterator.hasNext(); f1 += ((FinderPattern)iterator.next()).c());
        f1 /= this.b.size();
        Collections.sort(this.b, new CenterComparator(f1));
        List<FinderPattern> list = this.b;
        list.subList(3, list.size()).clear();
      } 
      return new FinderPattern[] { this.b.get(0), this.b.get(1), this.b.get(2) };
    } 
    throw NotFoundException.a();
  }
  
  final FinderPatternInfo a(Map<DecodeHintType, ?> paramMap) throws NotFoundException {
    int j;
    if (paramMap != null && paramMap.containsKey(DecodeHintType.d)) {
      j = 1;
    } else {
      j = 0;
    } 
    int m = this.a.f();
    int n = this.a.e();
    int i = m * 3 / 388;
    if (i < 3 || j)
      i = 3; 
    int[] arrayOfInt = new int[5];
    int k = i - 1;
    boolean bool = false;
    while (k < m && !bool) {
      c(arrayOfInt);
      j = 0;
      int i2 = 0;
      int i1 = i;
      i = i2;
      while (j < n) {
        if (this.a.a(j, k)) {
          i2 = i;
          if ((i & 0x1) == 1)
            i2 = i + 1; 
          arrayOfInt[i2] = arrayOfInt[i2] + 1;
          i = i2;
        } else if ((i & 0x1) == 0) {
          if (i == 4) {
            if (a(arrayOfInt)) {
              if (a(arrayOfInt, k, j)) {
                boolean bool1;
                if (this.c) {
                  bool1 = c();
                  i = k;
                } else {
                  i1 = b();
                  i = k;
                  bool1 = bool;
                  if (i1 > arrayOfInt[2]) {
                    i = k + i1 - arrayOfInt[2] - 2;
                    j = n - 1;
                    bool1 = bool;
                  } 
                } 
                c(arrayOfInt);
                i2 = 0;
                i1 = 2;
                k = i;
                i = i2;
                bool = bool1;
              } else {
                d(arrayOfInt);
                i = 3;
              } 
            } else {
              d(arrayOfInt);
              i = 3;
            } 
          } else {
            arrayOfInt[++i] = arrayOfInt[i] + 1;
          } 
        } else {
          arrayOfInt[i] = arrayOfInt[i] + 1;
        } 
        j++;
      } 
      if (a(arrayOfInt) && a(arrayOfInt, k, n)) {
        i = arrayOfInt[0];
        if (this.c)
          bool = c(); 
      } else {
        i = i1;
      } 
      k += i;
    } 
    FinderPattern[] arrayOfFinderPattern = d();
    ResultPoint.a((ResultPoint[])arrayOfFinderPattern);
    return new FinderPatternInfo(arrayOfFinderPattern);
  }
  
  protected final boolean a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    boolean bool = false;
    int i = paramArrayOfint[0] + paramArrayOfint[1] + paramArrayOfint[2] + paramArrayOfint[3] + paramArrayOfint[4];
    paramInt2 = (int)a(paramArrayOfint, paramInt2);
    float f = a(paramInt1, paramInt2, paramArrayOfint[2], i);
    if (!Float.isNaN(f)) {
      paramInt1 = (int)f;
      float f1 = b(paramInt2, paramInt1, paramArrayOfint[2], i);
      if (!Float.isNaN(f1) && a(paramInt1, (int)f1)) {
        float f2 = i / 7.0F;
        paramInt1 = 0;
        while (true) {
          paramInt2 = bool;
          if (paramInt1 < this.b.size()) {
            FinderPattern finderPattern = this.b.get(paramInt1);
            if (finderPattern.a(f2, f, f1)) {
              this.b.set(paramInt1, finderPattern.b(f, f1, f2));
              paramInt2 = 1;
              break;
            } 
            paramInt1++;
            continue;
          } 
          break;
        } 
        if (paramInt2 == 0) {
          FinderPattern finderPattern = new FinderPattern(f1, f, f2);
          this.b.add(finderPattern);
          ResultPointCallback resultPointCallback = this.e;
          if (resultPointCallback != null)
            resultPointCallback.a(finderPattern); 
        } 
        return true;
      } 
    } 
    return false;
  }
  
  protected final void c(int[] paramArrayOfint) {
    for (int i = 0; i < paramArrayOfint.length; i++)
      paramArrayOfint[i] = 0; 
  }
  
  protected final void d(int[] paramArrayOfint) {
    paramArrayOfint[0] = paramArrayOfint[2];
    paramArrayOfint[1] = paramArrayOfint[3];
    paramArrayOfint[2] = paramArrayOfint[4];
    paramArrayOfint[3] = 1;
    paramArrayOfint[4] = 0;
  }
  
  static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
    private final float a;
    
    private CenterComparator(float param1Float) {
      this.a = param1Float;
    }
    
    public int a(FinderPattern param1FinderPattern1, FinderPattern param1FinderPattern2) {
      int i = Integer.compare(param1FinderPattern2.d(), param1FinderPattern1.d());
      return (i == 0) ? Float.compare(Math.abs(param1FinderPattern1.c() - this.a), Math.abs(param1FinderPattern2.c() - this.a)) : i;
    }
  }
  
  static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
    private final float a;
    
    private FurthestFromAverageComparator(float param1Float) {
      this.a = param1Float;
    }
    
    public int a(FinderPattern param1FinderPattern1, FinderPattern param1FinderPattern2) {
      return Float.compare(Math.abs(param1FinderPattern2.c() - this.a), Math.abs(param1FinderPattern1.c() - this.a));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\detector\FinderPatternFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */