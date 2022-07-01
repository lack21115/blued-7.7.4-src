package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

class DetectionResultColumn {
  private final BoundingBox a;
  
  private final Codeword[] b;
  
  DetectionResultColumn(BoundingBox paramBoundingBox) {
    this.a = new BoundingBox(paramBoundingBox);
    this.b = new Codeword[paramBoundingBox.d() - paramBoundingBox.c() + 1];
  }
  
  final BoundingBox a() {
    return this.a;
  }
  
  final Codeword a(int paramInt) {
    Codeword codeword = c(paramInt);
    if (codeword != null)
      return codeword; 
    for (int i = 1; i < 5; i++) {
      int j = b(paramInt) - i;
      if (j >= 0) {
        codeword = this.b[j];
        if (codeword != null)
          return codeword; 
      } 
      j = b(paramInt) + i;
      Codeword[] arrayOfCodeword = this.b;
      if (j < arrayOfCodeword.length) {
        Codeword codeword1 = arrayOfCodeword[j];
        if (codeword1 != null)
          return codeword1; 
      } 
    } 
    return null;
  }
  
  final void a(int paramInt, Codeword paramCodeword) {
    this.b[b(paramInt)] = paramCodeword;
  }
  
  final int b(int paramInt) {
    return paramInt - this.a.c();
  }
  
  final Codeword[] b() {
    return this.b;
  }
  
  final Codeword c(int paramInt) {
    return this.b[b(paramInt)];
  }
  
  public String toString() {
    Formatter formatter = new Formatter();
    try {
      Codeword[] arrayOfCodeword = this.b;
      int k = arrayOfCodeword.length;
      int j = 0;
      int i = 0;
      while (true) {
        if (j < k) {
          Codeword codeword = arrayOfCodeword[j];
          if (codeword == null) {
            formatter.format("%3d:    |   %n", new Object[] { Integer.valueOf(i) });
            i++;
          } else {
            formatter.format("%3d: %3d|%3d%n", new Object[] { Integer.valueOf(i), Integer.valueOf(codeword.h()), Integer.valueOf(codeword.g()) });
            i++;
          } 
        } else {
          return formatter.toString();
        } 
        j++;
      } 
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\pdf417\decoder\DetectionResultColumn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */