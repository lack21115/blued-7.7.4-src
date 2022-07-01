package com.google.zxing.pdf417.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.pdf417.PDF417Common;
import com.google.zxing.pdf417.decoder.ec.ErrorCorrection;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class PDF417ScanningDecoder {
  private static final ErrorCorrection a = new ErrorCorrection();
  
  private static int a(int paramInt) {
    return 2 << paramInt;
  }
  
  private static int a(DetectionResult paramDetectionResult, int paramInt1, int paramInt2, boolean paramBoolean) {
    byte b;
    if (paramBoolean) {
      b = 1;
    } else {
      b = -1;
    } 
    Codeword codeword = null;
    int i = paramInt1 - b;
    if (a(paramDetectionResult, i))
      codeword = paramDetectionResult.a(i).c(paramInt2); 
    if (codeword != null)
      return paramBoolean ? codeword.e() : codeword.d(); 
    codeword = paramDetectionResult.a(paramInt1).a(paramInt2);
    if (codeword != null)
      return paramBoolean ? codeword.d() : codeword.e(); 
    if (a(paramDetectionResult, i))
      codeword = paramDetectionResult.a(i).a(paramInt2); 
    if (codeword != null)
      return paramBoolean ? codeword.e() : codeword.d(); 
    i = 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (true) {
      i = paramInt2 - b;
      if (a(paramDetectionResult, i)) {
        Codeword[] arrayOfCodeword = paramDetectionResult.a(i).b();
        int j = arrayOfCodeword.length;
        for (paramInt2 = 0; paramInt2 < j; paramInt2++) {
          Codeword codeword1 = arrayOfCodeword[paramInt2];
          if (codeword1 != null) {
            if (paramBoolean) {
              paramInt2 = codeword1.e();
            } else {
              paramInt2 = codeword1.d();
            } 
            return paramInt2 + b * paramInt1 * (codeword1.e() - codeword1.d());
          } 
        } 
        paramInt1++;
        paramInt2 = i;
        continue;
      } 
      BoundingBox boundingBox = paramDetectionResult.e();
      return paramBoolean ? boundingBox.a() : boundingBox.b();
    } 
  }
  
  private static int a(int[] paramArrayOfint) {
    int k = paramArrayOfint.length;
    int j = -1;
    for (int i = 0; i < k; i++)
      j = Math.max(j, paramArrayOfint[i]); 
    return j;
  }
  
  private static int a(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt) throws ChecksumException {
    if ((paramArrayOfint2 == null || paramArrayOfint2.length <= paramInt / 2 + 3) && paramInt >= 0 && paramInt <= 512)
      return a.a(paramArrayOfint1, paramInt, paramArrayOfint2); 
    throw ChecksumException.a();
  }
  
  private static DecoderResult a(int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[][] paramArrayOfint) throws FormatException, ChecksumException {
    int[] arrayOfInt = new int[paramArrayOfint3.length];
    int i = 100;
    while (true) {
      if (i > 0) {
        int j;
        for (j = 0; j < arrayOfInt.length; j++)
          paramArrayOfint1[paramArrayOfint3[j]] = paramArrayOfint[j][arrayOfInt[j]]; 
        try {
          return a(paramArrayOfint1, paramInt, paramArrayOfint2);
        } catch (ChecksumException checksumException) {
          if (arrayOfInt.length != 0) {
            j = 0;
            while (j < arrayOfInt.length) {
              if (arrayOfInt[j] < (paramArrayOfint[j]).length - 1) {
                arrayOfInt[j] = arrayOfInt[j] + 1;
                break;
              } 
              arrayOfInt[j] = 0;
              if (j != arrayOfInt.length - 1) {
                j++;
                continue;
              } 
              throw ChecksumException.a();
            } 
            i--;
            continue;
          } 
          throw ChecksumException.a();
        } 
      } 
      throw ChecksumException.a();
    } 
  }
  
  public static DecoderResult a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2) throws NotFoundException, FormatException, ChecksumException {
    DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn1;
    DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn2;
    boolean bool;
    DetectionResult detectionResult;
    BoundingBox boundingBox = new BoundingBox(paramBitMatrix, paramResultPoint1, paramResultPoint2, paramResultPoint3, paramResultPoint4);
    paramResultPoint2 = null;
    ResultPoint resultPoint = paramResultPoint2;
    paramResultPoint4 = resultPoint;
    int i = 0;
    while (i < 2) {
      if (paramResultPoint1 != null)
        detectionResultRowIndicatorColumn1 = a(paramBitMatrix, boundingBox, paramResultPoint1, true, paramInt1, paramInt2); 
      if (paramResultPoint3 != null)
        detectionResultRowIndicatorColumn2 = a(paramBitMatrix, boundingBox, paramResultPoint3, false, paramInt1, paramInt2); 
      detectionResult = a(detectionResultRowIndicatorColumn1, detectionResultRowIndicatorColumn2);
      if (detectionResult != null) {
        if (i == 0 && detectionResult.e() != null && (detectionResult.e().c() < boundingBox.c() || detectionResult.e().d() > boundingBox.d())) {
          boundingBox = detectionResult.e();
          i++;
          continue;
        } 
        detectionResult.a(boundingBox);
        break;
      } 
      throw NotFoundException.a();
    } 
    int j = detectionResult.b() + 1;
    detectionResult.a(0, detectionResultRowIndicatorColumn1);
    detectionResult.a(j, detectionResultRowIndicatorColumn2);
    if (detectionResultRowIndicatorColumn1 != null) {
      bool = true;
    } else {
      bool = false;
    } 
    i = 1;
    while (i <= j) {
      int n;
      if (bool) {
        n = i;
      } else {
        n = j - i;
      } 
      int m = paramInt1;
      int k = paramInt2;
      if (detectionResult.a(n) == null) {
        DetectionResultColumn detectionResultColumn;
        if (n == 0 || n == j) {
          boolean bool1;
          if (n == 0) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          detectionResultColumn = new DetectionResultRowIndicatorColumn(boundingBox, bool1);
        } else {
          detectionResultColumn = new DetectionResultColumn(boundingBox);
        } 
        detectionResult.a(n, detectionResultColumn);
        int i1 = boundingBox.c();
        m = -1;
        k = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = m;
        while (i1 <= boundingBox.d()) {
          m = a(detectionResult, n, i1, bool);
          if (m < 0 || m > boundingBox.b())
            if (paramInt2 != -1) {
              m = paramInt2;
            } else {
              continue;
            }  
          Codeword codeword = a(paramBitMatrix, boundingBox.a(), boundingBox.b(), bool, m, i1, k, paramInt1);
          if (codeword != null) {
            detectionResultColumn.a(i1, codeword);
            k = Math.min(k, codeword.c());
            paramInt1 = Math.max(paramInt1, codeword.c());
            paramInt2 = m;
          } 
          continue;
          i1++;
        } 
        m = k;
        k = paramInt1;
      } 
      i++;
      paramInt1 = m;
      paramInt2 = k;
    } 
    return a(detectionResult);
  }
  
  private static DecoderResult a(DetectionResult paramDetectionResult) throws FormatException, ChecksumException, NotFoundException {
    BarcodeValue[][] arrayOfBarcodeValue = b(paramDetectionResult);
    a(paramDetectionResult, arrayOfBarcodeValue);
    ArrayList<Integer> arrayList1 = new ArrayList();
    int[] arrayOfInt = new int[paramDetectionResult.c() * paramDetectionResult.b()];
    ArrayList<int[]> arrayList = new ArrayList();
    ArrayList<Integer> arrayList2 = new ArrayList();
    boolean bool = false;
    int i;
    for (i = 0; i < paramDetectionResult.c(); i++) {
      for (int j = 0; j < paramDetectionResult.b(); j = k) {
        BarcodeValue[] arrayOfBarcodeValue1 = arrayOfBarcodeValue[i];
        int k = j + 1;
        int[] arrayOfInt2 = arrayOfBarcodeValue1[k].a();
        j = paramDetectionResult.b() * i + j;
        if (arrayOfInt2.length == 0) {
          arrayList1.add(Integer.valueOf(j));
        } else if (arrayOfInt2.length == 1) {
          arrayOfInt[j] = arrayOfInt2[0];
        } else {
          arrayList2.add(Integer.valueOf(j));
          arrayList.add(arrayOfInt2);
        } 
      } 
    } 
    int[][] arrayOfInt1 = new int[arrayList.size()][];
    for (i = bool; i < arrayOfInt1.length; i++)
      arrayOfInt1[i] = arrayList.get(i); 
    return a(paramDetectionResult.d(), arrayOfInt, PDF417Common.a(arrayList1), PDF417Common.a(arrayList2), arrayOfInt1);
  }
  
  private static DecoderResult a(int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2) throws FormatException, ChecksumException {
    if (paramArrayOfint1.length != 0) {
      int i = 1 << paramInt + 1;
      int j = a(paramArrayOfint1, paramArrayOfint2, i);
      a(paramArrayOfint1, i);
      DecoderResult decoderResult = DecodedBitStreamParser.a(paramArrayOfint1, String.valueOf(paramInt));
      decoderResult.a(Integer.valueOf(j));
      decoderResult.b(Integer.valueOf(paramArrayOfint2.length));
      return decoderResult;
    } 
    throw FormatException.a();
  }
  
  private static BoundingBox a(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn) throws NotFoundException {
    if (paramDetectionResultRowIndicatorColumn == null)
      return null; 
    int[] arrayOfInt = paramDetectionResultRowIndicatorColumn.c();
    if (arrayOfInt == null)
      return null; 
    int n = a(arrayOfInt);
    int m = arrayOfInt.length;
    boolean bool = false;
    int k = 0;
    int j = 0;
    while (true) {
      i = j;
      if (k < m) {
        int i1 = arrayOfInt[k];
        j += n - i1;
        i = j;
        if (i1 <= 0) {
          k++;
          continue;
        } 
      } 
      break;
    } 
    Codeword[] arrayOfCodeword = paramDetectionResultRowIndicatorColumn.b();
    j = 0;
    k = i;
    int i;
    for (i = j; k > 0 && arrayOfCodeword[i] == null; i++)
      k--; 
    m = arrayOfInt.length - 1;
    j = bool;
    while (true) {
      i = j;
      if (m >= 0) {
        j += n - arrayOfInt[m];
        i = j;
        if (arrayOfInt[m] <= 0) {
          m--;
          continue;
        } 
      } 
      break;
    } 
    m = arrayOfCodeword.length - 1;
    j = i;
    for (i = m; j > 0 && arrayOfCodeword[i] == null; i--)
      j--; 
    return paramDetectionResultRowIndicatorColumn.a().a(k, j, paramDetectionResultRowIndicatorColumn.e());
  }
  
  private static Codeword a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    paramInt3 = b(paramBitMatrix, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    int[] arrayOfInt = a(paramBitMatrix, paramInt1, paramInt2, paramBoolean, paramInt3, paramInt4);
    if (arrayOfInt == null)
      return null; 
    paramInt4 = MathUtils.a(arrayOfInt);
    if (paramBoolean) {
      paramInt2 = paramInt3 + paramInt4;
      paramInt1 = paramInt3;
      paramInt3 = paramInt2;
    } else {
      for (paramInt1 = 0; paramInt1 < arrayOfInt.length / 2; paramInt1++) {
        paramInt2 = arrayOfInt[paramInt1];
        arrayOfInt[paramInt1] = arrayOfInt[arrayOfInt.length - 1 - paramInt1];
        arrayOfInt[arrayOfInt.length - 1 - paramInt1] = paramInt2;
      } 
      paramInt1 = paramInt3 - paramInt4;
    } 
    if (!a(paramInt4, paramInt5, paramInt6))
      return null; 
    paramInt2 = PDF417CodewordDecoder.a(arrayOfInt);
    paramInt4 = PDF417Common.a(paramInt2);
    return (paramInt4 == -1) ? null : new Codeword(paramInt1, paramInt3, c(paramInt2), paramInt4);
  }
  
  private static DetectionResult a(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2) throws NotFoundException {
    if (paramDetectionResultRowIndicatorColumn1 == null && paramDetectionResultRowIndicatorColumn2 == null)
      return null; 
    BarcodeMetadata barcodeMetadata = b(paramDetectionResultRowIndicatorColumn1, paramDetectionResultRowIndicatorColumn2);
    return (barcodeMetadata == null) ? null : new DetectionResult(barcodeMetadata, BoundingBox.a(a(paramDetectionResultRowIndicatorColumn1), a(paramDetectionResultRowIndicatorColumn2)));
  }
  
  private static DetectionResultRowIndicatorColumn a(BitMatrix paramBitMatrix, BoundingBox paramBoundingBox, ResultPoint paramResultPoint, boolean paramBoolean, int paramInt1, int paramInt2) {
    DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(paramBoundingBox, paramBoolean);
    int i;
    for (i = 0; i < 2; i++) {
      byte b;
      if (i == 0) {
        b = 1;
      } else {
        b = -1;
      } 
      int j = (int)paramResultPoint.a();
      int k;
      for (k = (int)paramResultPoint.b(); k <= paramBoundingBox.d() && k >= paramBoundingBox.c(); k += b) {
        Codeword codeword = a(paramBitMatrix, 0, paramBitMatrix.e(), paramBoolean, j, k, paramInt1, paramInt2);
        if (codeword != null) {
          detectionResultRowIndicatorColumn.a(k, codeword);
          if (paramBoolean) {
            j = codeword.d();
          } else {
            j = codeword.e();
          } 
        } 
      } 
    } 
    return detectionResultRowIndicatorColumn;
  }
  
  private static void a(DetectionResult paramDetectionResult, BarcodeValue[][] paramArrayOfBarcodeValue) throws NotFoundException {
    BarcodeValue barcodeValue = paramArrayOfBarcodeValue[0][1];
    int[] arrayOfInt = barcodeValue.a();
    int i = paramDetectionResult.b() * paramDetectionResult.c() - a(paramDetectionResult.d());
    if (arrayOfInt.length == 0) {
      if (i > 0 && i <= 928) {
        barcodeValue.a(i);
        return;
      } 
      throw NotFoundException.a();
    } 
    if (arrayOfInt[0] != i)
      barcodeValue.a(i); 
  }
  
  private static void a(int[] paramArrayOfint, int paramInt) throws FormatException {
    if (paramArrayOfint.length >= 4) {
      int i = paramArrayOfint[0];
      if (i <= paramArrayOfint.length) {
        if (i == 0) {
          if (paramInt < paramArrayOfint.length) {
            paramArrayOfint[0] = paramArrayOfint.length - paramInt;
            return;
          } 
          throw FormatException.a();
        } 
        return;
      } 
      throw FormatException.a();
    } 
    throw FormatException.a();
  }
  
  private static boolean a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt2 - 2 <= paramInt1 && paramInt1 <= paramInt3 + 2);
  }
  
  private static boolean a(DetectionResult paramDetectionResult, int paramInt) {
    return (paramInt >= 0 && paramInt <= paramDetectionResult.b() + 1);
  }
  
  private static int[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {
    byte b;
    int[] arrayOfInt = new int[8];
    if (paramBoolean) {
      b = 1;
    } else {
      b = -1;
    } 
    int i = 0;
    boolean bool = paramBoolean;
    while ((paramBoolean ? (paramInt3 < paramInt2) : (paramInt3 >= paramInt1)) && i < 8) {
      if (paramBitMatrix.a(paramInt3, paramInt4) == bool) {
        arrayOfInt[i] = arrayOfInt[i] + 1;
        paramInt3 += b;
        continue;
      } 
      i++;
      int j = bool ^ true;
    } 
    if (i != 8) {
      if (paramBoolean)
        paramInt1 = paramInt2; 
      return (paramInt3 == paramInt1 && i == 7) ? arrayOfInt : null;
    } 
    return arrayOfInt;
  }
  
  private static int b(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4) {
    byte b;
    if (paramBoolean) {
      b = -1;
    } else {
      b = 1;
    } 
    int i = 0;
    int j = paramInt3;
    while (i < 2) {
      while ((paramBoolean ? (j >= paramInt1) : (j < paramInt2)) && paramBoolean == paramBitMatrix.a(j, paramInt4)) {
        if (Math.abs(paramInt3 - j) > 2)
          return paramInt3; 
        j += b;
      } 
      b = -b;
      int k = paramBoolean ^ true;
      i++;
    } 
    return j;
  }
  
  private static int b(int[] paramArrayOfint) {
    return (paramArrayOfint[0] - paramArrayOfint[2] + paramArrayOfint[4] - paramArrayOfint[6] + 9) % 9;
  }
  
  private static BarcodeMetadata b(DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn1, DetectionResultRowIndicatorColumn paramDetectionResultRowIndicatorColumn2) {
    BarcodeMetadata barcodeMetadata;
    if (paramDetectionResultRowIndicatorColumn1 != null) {
      BarcodeMetadata barcodeMetadata1 = paramDetectionResultRowIndicatorColumn1.d();
      if (barcodeMetadata1 != null) {
        if (paramDetectionResultRowIndicatorColumn2 != null) {
          barcodeMetadata = paramDetectionResultRowIndicatorColumn2.d();
          if (barcodeMetadata == null)
            return barcodeMetadata1; 
          if (barcodeMetadata1.a() != barcodeMetadata.a() && barcodeMetadata1.b() != barcodeMetadata.b() && barcodeMetadata1.c() != barcodeMetadata.c())
            return null; 
        } 
        return barcodeMetadata1;
      } 
    } 
    return (barcodeMetadata == null) ? null : barcodeMetadata.d();
  }
  
  private static int[] b(int paramInt) {
    int[] arrayOfInt = new int[8];
    int j = 0;
    for (int i = 7;; i = m) {
      int n = paramInt & 0x1;
      int k = j;
      int m = i;
      if (n != j) {
        m = i - 1;
        if (m >= 0) {
          k = n;
        } else {
          return arrayOfInt;
        } 
      } 
      arrayOfInt[m] = arrayOfInt[m] + 1;
      paramInt >>= 1;
      j = k;
    } 
  }
  
  private static BarcodeValue[][] b(DetectionResult paramDetectionResult) {
    BarcodeValue[][] arrayOfBarcodeValue = (BarcodeValue[][])Array.newInstance(BarcodeValue.class, new int[] { paramDetectionResult.c(), paramDetectionResult.b() + 2 });
    int i;
    for (i = 0; i < arrayOfBarcodeValue.length; i++) {
      for (int m = 0; m < (arrayOfBarcodeValue[i]).length; m++)
        arrayOfBarcodeValue[i][m] = new BarcodeValue(); 
    } 
    DetectionResultColumn[] arrayOfDetectionResultColumn = paramDetectionResult.a();
    int k = arrayOfDetectionResultColumn.length;
    i = 0;
    int j = 0;
    while (i < k) {
      DetectionResultColumn detectionResultColumn = arrayOfDetectionResultColumn[i];
      if (detectionResultColumn != null)
        for (Codeword codeword : detectionResultColumn.b()) {
          if (codeword != null) {
            int m = codeword.h();
            if (m >= 0 && m < arrayOfBarcodeValue.length)
              arrayOfBarcodeValue[m][j].a(codeword.g()); 
          } 
        }  
      j++;
      i++;
    } 
    return arrayOfBarcodeValue;
  }
  
  private static int c(int paramInt) {
    return b(b(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\PDF417ScanningDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */