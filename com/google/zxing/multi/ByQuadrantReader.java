package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.Map;

public final class ByQuadrantReader implements Reader {
  private final Reader a;
  
  private static void a(ResultPoint[] paramArrayOfResultPoint, int paramInt1, int paramInt2) {
    if (paramArrayOfResultPoint != null)
      for (int i = 0; i < paramArrayOfResultPoint.length; i++) {
        ResultPoint resultPoint = paramArrayOfResultPoint[i];
        paramArrayOfResultPoint[i] = new ResultPoint(resultPoint.a() + paramInt1, resultPoint.b() + paramInt2);
      }  
  }
  
  public Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap) throws NotFoundException, ChecksumException, FormatException {
    int i = paramBinaryBitmap.a();
    int j = paramBinaryBitmap.b();
    i /= 2;
    j /= 2;
    try {
      return this.a.a(paramBinaryBitmap.a(0, 0, i, j), paramMap);
    } catch (NotFoundException notFoundException) {
      try {
        Result result = this.a.a(paramBinaryBitmap.a(i, 0, i, j), paramMap);
        a(result.c(), i, 0);
        return result;
      } catch (NotFoundException notFoundException1) {
        try {
          Result result = this.a.a(paramBinaryBitmap.a(0, j, i, j), paramMap);
          a(result.c(), 0, j);
          return result;
        } catch (NotFoundException notFoundException2) {
          try {
            Result result = this.a.a(paramBinaryBitmap.a(i, j, i, j), paramMap);
            a(result.c(), i, j);
            return result;
          } catch (NotFoundException notFoundException3) {
            int k = i / 2;
            int m = j / 2;
            paramBinaryBitmap = paramBinaryBitmap.a(k, m, i, j);
            Result result = this.a.a(paramBinaryBitmap, paramMap);
            a(result.c(), k, m);
            return result;
          } 
        } 
      } 
    } 
  }
  
  public void a() {
    this.a.a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\multi\ByQuadrantReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */