package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

final class DetectionResult {
  private final BarcodeMetadata a;
  
  private final DetectionResultColumn[] b;
  
  private BoundingBox c;
  
  private final int d;
  
  DetectionResult(BarcodeMetadata paramBarcodeMetadata, BoundingBox paramBoundingBox) {
    this.a = paramBarcodeMetadata;
    this.d = paramBarcodeMetadata.a();
    this.c = paramBoundingBox;
    this.b = new DetectionResultColumn[this.d + 2];
  }
  
  private static int a(int paramInt1, int paramInt2, Codeword paramCodeword) {
    if (paramCodeword == null)
      return paramInt2; 
    int i = paramInt2;
    if (!paramCodeword.a()) {
      if (paramCodeword.a(paramInt1)) {
        paramCodeword.b(paramInt1);
        return 0;
      } 
      i = paramInt2 + 1;
    } 
    return i;
  }
  
  private void a(int paramInt1, int paramInt2, Codeword[] paramArrayOfCodeword) {
    Codeword[] arrayOfCodeword1;
    Codeword codeword = paramArrayOfCodeword[paramInt2];
    Codeword[] arrayOfCodeword2 = this.b[paramInt1 - 1].b();
    DetectionResultColumn[] arrayOfDetectionResultColumn = this.b;
    if (arrayOfDetectionResultColumn[++paramInt1] != null) {
      arrayOfCodeword1 = arrayOfDetectionResultColumn[paramInt1].b();
    } else {
      arrayOfCodeword1 = arrayOfCodeword2;
    } 
    Codeword[] arrayOfCodeword3 = new Codeword[14];
    arrayOfCodeword3[2] = arrayOfCodeword2[paramInt2];
    arrayOfCodeword3[3] = arrayOfCodeword1[paramInt2];
    boolean bool = false;
    if (paramInt2 > 0) {
      paramInt1 = paramInt2 - 1;
      arrayOfCodeword3[0] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[4] = arrayOfCodeword2[paramInt1];
      arrayOfCodeword3[5] = arrayOfCodeword1[paramInt1];
    } 
    if (paramInt2 > 1) {
      paramInt1 = paramInt2 - 2;
      arrayOfCodeword3[8] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[10] = arrayOfCodeword2[paramInt1];
      arrayOfCodeword3[11] = arrayOfCodeword1[paramInt1];
    } 
    if (paramInt2 < paramArrayOfCodeword.length - 1) {
      paramInt1 = paramInt2 + 1;
      arrayOfCodeword3[1] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[6] = arrayOfCodeword2[paramInt1];
      arrayOfCodeword3[7] = arrayOfCodeword1[paramInt1];
    } 
    paramInt1 = bool;
    if (paramInt2 < paramArrayOfCodeword.length - 2) {
      paramInt1 = paramInt2 + 2;
      arrayOfCodeword3[9] = paramArrayOfCodeword[paramInt1];
      arrayOfCodeword3[12] = arrayOfCodeword2[paramInt1];
      arrayOfCodeword3[13] = arrayOfCodeword1[paramInt1];
      paramInt1 = bool;
    } 
    while (paramInt1 < 14) {
      if (a(codeword, arrayOfCodeword3[paramInt1]))
        return; 
      paramInt1++;
    } 
  }
  
  private void a(DetectionResultColumn paramDetectionResultColumn) {
    if (paramDetectionResultColumn != null)
      ((DetectionResultRowIndicatorColumn)paramDetectionResultColumn).a(this.a); 
  }
  
  private static boolean a(Codeword paramCodeword1, Codeword paramCodeword2) {
    if (paramCodeword2 == null)
      return false; 
    if (paramCodeword2.a() && paramCodeword2.f() == paramCodeword1.f()) {
      paramCodeword1.b(paramCodeword2.h());
      return true;
    } 
    return false;
  }
  
  private int f() {
    int j = g();
    if (j == 0)
      return 0; 
    for (int i = 1; i < this.d + 1; i++) {
      Codeword[] arrayOfCodeword = this.b[i].b();
      for (int k = 0; k < arrayOfCodeword.length; k++) {
        if (arrayOfCodeword[k] != null && !arrayOfCodeword[k].a())
          a(i, k, arrayOfCodeword); 
      } 
    } 
    return j;
  }
  
  private int g() {
    h();
    return j() + i();
  }
  
  private void h() {
    DetectionResultColumn[] arrayOfDetectionResultColumn = this.b;
    int i = 0;
    if (arrayOfDetectionResultColumn[0] != null) {
      if (arrayOfDetectionResultColumn[this.d + 1] == null)
        return; 
      Codeword[] arrayOfCodeword1 = arrayOfDetectionResultColumn[0].b();
      Codeword[] arrayOfCodeword2 = this.b[this.d + 1].b();
      while (i < arrayOfCodeword1.length) {
        if (arrayOfCodeword1[i] != null && arrayOfCodeword2[i] != null && arrayOfCodeword1[i].h() == arrayOfCodeword2[i].h())
          for (int j = 1; j <= this.d; j++) {
            Codeword codeword = this.b[j].b()[i];
            if (codeword != null) {
              codeword.b(arrayOfCodeword1[i].h());
              if (!codeword.a())
                this.b[j].b()[i] = null; 
            } 
          }  
        i++;
      } 
    } 
  }
  
  private int i() {
    DetectionResultColumn[] arrayOfDetectionResultColumn = this.b;
    int i = this.d;
    if (arrayOfDetectionResultColumn[i + 1] == null)
      return 0; 
    Codeword[] arrayOfCodeword = arrayOfDetectionResultColumn[i + 1].b();
    int j = 0;
    for (i = 0; j < arrayOfCodeword.length; i = k) {
      int k = i;
      if (arrayOfCodeword[j] != null) {
        int n = arrayOfCodeword[j].h();
        k = this.d + 1;
        int m = 0;
        while (k > 0 && m < 2) {
          Codeword codeword = this.b[k].b()[j];
          int i1 = m;
          int i2 = i;
          if (codeword != null) {
            m = a(n, m, codeword);
            i1 = m;
            i2 = i;
            if (!codeword.a()) {
              i2 = i + 1;
              i1 = m;
            } 
          } 
          k--;
          m = i1;
          i = i2;
        } 
        k = i;
      } 
      j++;
    } 
    return i;
  }
  
  private int j() {
    DetectionResultColumn[] arrayOfDetectionResultColumn = this.b;
    if (arrayOfDetectionResultColumn[0] == null)
      return 0; 
    Codeword[] arrayOfCodeword = arrayOfDetectionResultColumn[0].b();
    int j = 0;
    int i;
    for (i = 0; j < arrayOfCodeword.length; i = k) {
      int k = i;
      if (arrayOfCodeword[j] != null) {
        int n = arrayOfCodeword[j].h();
        k = 1;
        int m = 0;
        while (k < this.d + 1 && m < 2) {
          Codeword codeword = this.b[k].b()[j];
          int i1 = m;
          int i2 = i;
          if (codeword != null) {
            m = a(n, m, codeword);
            i1 = m;
            i2 = i;
            if (!codeword.a()) {
              i2 = i + 1;
              i1 = m;
            } 
          } 
          k++;
          m = i1;
          i = i2;
        } 
        k = i;
      } 
      j++;
    } 
    return i;
  }
  
  DetectionResultColumn a(int paramInt) {
    return this.b[paramInt];
  }
  
  void a(int paramInt, DetectionResultColumn paramDetectionResultColumn) {
    this.b[paramInt] = paramDetectionResultColumn;
  }
  
  void a(BoundingBox paramBoundingBox) {
    this.c = paramBoundingBox;
  }
  
  DetectionResultColumn[] a() {
    a(this.b[0]);
    a(this.b[this.d + 1]);
    for (int i = 928;; i = j) {
      int j = f();
      if (j <= 0 || j >= i)
        break; 
    } 
    return this.b;
  }
  
  int b() {
    return this.d;
  }
  
  int c() {
    return this.a.c();
  }
  
  int d() {
    return this.a.b();
  }
  
  BoundingBox e() {
    return this.c;
  }
  
  public String toString() {
    DetectionResultColumn[] arrayOfDetectionResultColumn = this.b;
    DetectionResultColumn detectionResultColumn2 = arrayOfDetectionResultColumn[0];
    DetectionResultColumn detectionResultColumn1 = detectionResultColumn2;
    if (detectionResultColumn2 == null)
      detectionResultColumn1 = arrayOfDetectionResultColumn[this.d + 1]; 
    Formatter formatter = new Formatter();
    int i = 0;
    label35: while (true) {
      try {
        if (i < (detectionResultColumn1.b()).length) {
          formatter.format("CW %3d:", new Object[] { Integer.valueOf(i) });
          for (int j = 0;; j++) {
            if (j < this.d + 2) {
              DetectionResultColumn detectionResultColumn = this.b[j];
              if (detectionResultColumn == null) {
                formatter.format("    |   ", new Object[0]);
              } else {
                Codeword codeword = this.b[j].b()[i];
                if (codeword == null) {
                  formatter.format("    |   ", new Object[0]);
                } else {
                  formatter.format(" %3d|%3d", new Object[] { Integer.valueOf(codeword.h()), Integer.valueOf(codeword.g()) });
                } 
              } 
            } else {
              formatter.format("%n", new Object[0]);
              i++;
              continue label35;
            } 
          } 
          break;
        } 
        return formatter.toString();
      } finally {
        detectionResultColumn1 = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */