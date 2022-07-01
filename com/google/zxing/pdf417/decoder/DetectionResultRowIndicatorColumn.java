package com.google.zxing.pdf417.decoder;

import com.google.zxing.ResultPoint;

final class DetectionResultRowIndicatorColumn extends DetectionResultColumn {
  private final boolean a;
  
  DetectionResultRowIndicatorColumn(BoundingBox paramBoundingBox, boolean paramBoolean) {
    super(paramBoundingBox);
    this.a = paramBoolean;
  }
  
  private void a(Codeword[] paramArrayOfCodeword, BarcodeMetadata paramBarcodeMetadata) {
    for (int i = 0; i < paramArrayOfCodeword.length; i++) {
      Codeword codeword = paramArrayOfCodeword[i];
      if (paramArrayOfCodeword[i] != null) {
        int k = codeword.g() % 30;
        int j = codeword.h();
        if (j > paramBarcodeMetadata.c()) {
          paramArrayOfCodeword[i] = null;
        } else {
          int m = j;
          if (!this.a)
            m = j + 2; 
          m %= 3;
          if (m != 0) {
            if (m != 1) {
              if (m == 2 && k + 1 != paramBarcodeMetadata.a())
                paramArrayOfCodeword[i] = null; 
            } else if (k / 3 != paramBarcodeMetadata.b() || k % 3 != paramBarcodeMetadata.e()) {
              paramArrayOfCodeword[i] = null;
            } 
          } else if (k * 3 + 1 != paramBarcodeMetadata.d()) {
            paramArrayOfCodeword[i] = null;
          } 
        } 
      } 
    } 
  }
  
  private void b(BarcodeMetadata paramBarcodeMetadata) {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    BoundingBox boundingBox = a();
    if (this.a) {
      resultPoint1 = boundingBox.e();
    } else {
      resultPoint1 = boundingBox.f();
    } 
    if (this.a) {
      resultPoint2 = boundingBox.g();
    } else {
      resultPoint2 = resultPoint2.h();
    } 
    int j = b((int)resultPoint1.b());
    int n = b((int)resultPoint2.b());
    Codeword[] arrayOfCodeword = b();
    int k = -1;
    int m = 0;
    for (int i = 1;; i = i3) {
      int i1;
      int i2;
      int i3;
      if (j < n) {
        i2 = k;
        i1 = m;
        i3 = i;
        if (arrayOfCodeword[j] != null) {
          Codeword codeword = arrayOfCodeword[j];
          codeword.b();
          i1 = codeword.h() - k;
          if (i1 == 0) {
            i1 = m + 1;
            i2 = k;
            i3 = i;
          } else {
            if (i1 == 1) {
              i = Math.max(i, m);
              i1 = codeword.h();
            } else {
              if (codeword.h() >= paramBarcodeMetadata.c()) {
                arrayOfCodeword[j] = null;
                i2 = k;
                i1 = m;
                i3 = i;
              } else {
                i1 = codeword.h();
                k = 1;
                i2 = i1;
                i1 = k;
                i3 = i;
              } 
              j++;
              k = i2;
              m = i1;
              i = i3;
            } 
            k = 1;
            i2 = i1;
            i1 = k;
            i3 = i;
          } 
        } 
      } else {
        break;
      } 
      j++;
      k = i2;
      m = i1;
    } 
  }
  
  private void f() {
    for (Codeword codeword : b()) {
      if (codeword != null)
        codeword.b(); 
    } 
  }
  
  void a(BarcodeMetadata paramBarcodeMetadata) {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    Codeword[] arrayOfCodeword = b();
    f();
    a(arrayOfCodeword, paramBarcodeMetadata);
    BoundingBox boundingBox = a();
    if (this.a) {
      resultPoint1 = boundingBox.e();
    } else {
      resultPoint1 = boundingBox.f();
    } 
    if (this.a) {
      resultPoint2 = boundingBox.g();
    } else {
      resultPoint2 = resultPoint2.h();
    } 
    int j = b((int)resultPoint1.b());
    int n = b((int)resultPoint2.b());
    int k = -1;
    int m = 0;
    for (int i = 1;; i = i3) {
      int i1;
      int i2;
      int i3;
      if (j < n) {
        i2 = k;
        i1 = m;
        i3 = i;
        if (arrayOfCodeword[j] != null) {
          Codeword codeword = arrayOfCodeword[j];
          i1 = codeword.h() - k;
          if (i1 == 0) {
            i1 = m + 1;
            i2 = k;
            i3 = i;
          } else {
            if (i1 == 1) {
              i = Math.max(i, m);
              i1 = codeword.h();
            } else {
              if (i1 < 0 || codeword.h() >= paramBarcodeMetadata.c() || i1 > j) {
                arrayOfCodeword[j] = null;
                i3 = i;
                i1 = m;
                i2 = k;
              } else {
                i2 = i1;
                if (i > 2)
                  i2 = i1 * (i - 2); 
                if (i2 >= j) {
                  i1 = 1;
                } else {
                  i1 = 0;
                } 
                for (i3 = 1; i3 <= i2 && i1 == 0; i3++) {
                  if (arrayOfCodeword[j - i3] != null) {
                    i1 = 1;
                  } else {
                    i1 = 0;
                  } 
                } 
                if (i1 != 0) {
                  arrayOfCodeword[j] = null;
                  i2 = k;
                  i1 = m;
                  i3 = i;
                } else {
                  i1 = codeword.h();
                  k = 1;
                  i2 = i1;
                  i1 = k;
                  i3 = i;
                } 
              } 
              j++;
              k = i2;
              m = i1;
              i = i3;
            } 
            k = 1;
            i2 = i1;
            i1 = k;
            i3 = i;
          } 
        } 
      } else {
        break;
      } 
      j++;
      k = i2;
      m = i1;
    } 
  }
  
  int[] c() {
    BarcodeMetadata barcodeMetadata = d();
    if (barcodeMetadata == null)
      return null; 
    b(barcodeMetadata);
    int[] arrayOfInt = new int[barcodeMetadata.c()];
    for (Codeword codeword : b()) {
      if (codeword != null) {
        int i = codeword.h();
        if (i < arrayOfInt.length)
          arrayOfInt[i] = arrayOfInt[i] + 1; 
      } 
    } 
    return arrayOfInt;
  }
  
  BarcodeMetadata d() {
    Codeword[] arrayOfCodeword = b();
    BarcodeValue barcodeValue1 = new BarcodeValue();
    BarcodeValue barcodeValue2 = new BarcodeValue();
    BarcodeValue barcodeValue3 = new BarcodeValue();
    BarcodeValue barcodeValue4 = new BarcodeValue();
    int j = arrayOfCodeword.length;
    for (int i = 0; i < j; i++) {
      Codeword codeword = arrayOfCodeword[i];
      if (codeword != null) {
        codeword.b();
        int n = codeword.g() % 30;
        int m = codeword.h();
        int k = m;
        if (!this.a)
          k = m + 2; 
        k %= 3;
        if (k != 0) {
          if (k != 1) {
            if (k == 2)
              barcodeValue1.a(n + 1); 
          } else {
            barcodeValue4.a(n / 3);
            barcodeValue3.a(n % 3);
          } 
        } else {
          barcodeValue2.a(n * 3 + 1);
        } 
      } 
    } 
    if ((barcodeValue1.a()).length == 0 || (barcodeValue2.a()).length == 0 || (barcodeValue3.a()).length == 0 || (barcodeValue4.a()).length == 0 || barcodeValue1.a()[0] <= 0 || barcodeValue2.a()[0] + barcodeValue3.a()[0] < 3 || barcodeValue2.a()[0] + barcodeValue3.a()[0] > 90)
      return null; 
    BarcodeMetadata barcodeMetadata = new BarcodeMetadata(barcodeValue1.a()[0], barcodeValue2.a()[0], barcodeValue3.a()[0], barcodeValue4.a()[0]);
    a(arrayOfCodeword, barcodeMetadata);
    return barcodeMetadata;
  }
  
  boolean e() {
    return this.a;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("IsLeft: ");
    stringBuilder.append(this.a);
    stringBuilder.append('\n');
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResultRowIndicatorColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */