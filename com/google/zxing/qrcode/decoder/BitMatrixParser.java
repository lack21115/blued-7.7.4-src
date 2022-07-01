package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
  private final BitMatrix a;
  
  private Version b;
  
  private FormatInformation c;
  
  private boolean d;
  
  BitMatrixParser(BitMatrix paramBitMatrix) throws FormatException {
    int i = paramBitMatrix.f();
    if (i >= 21 && (i & 0x3) == 1) {
      this.a = paramBitMatrix;
      return;
    } 
    throw FormatException.a();
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (this.d) {
      bool = this.a.a(paramInt2, paramInt1);
    } else {
      bool = this.a.a(paramInt1, paramInt2);
    } 
    return bool ? (paramInt3 << 1 | 0x1) : (paramInt3 << 1);
  }
  
  FormatInformation a() throws FormatException {
    FormatInformation formatInformation = this.c;
    if (formatInformation != null)
      return formatInformation; 
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < 6) {
      j = a(i, 8, j);
      i++;
    } 
    j = a(8, 7, a(8, 8, a(7, 8, j)));
    for (i = 5; i >= 0; i--)
      j = a(8, i, j); 
    int m = this.a.f();
    int k = m - 1;
    i = bool;
    while (k >= m - 7) {
      i = a(8, k, i);
      k--;
    } 
    for (k = m - 8; k < m; k++)
      i = a(k, 8, i); 
    this.c = FormatInformation.b(j, i);
    formatInformation = this.c;
    if (formatInformation != null)
      return formatInformation; 
    throw FormatException.a();
  }
  
  void a(boolean paramBoolean) {
    this.b = null;
    this.c = null;
    this.d = paramBoolean;
  }
  
  Version b() throws FormatException {
    Version version = this.b;
    if (version != null)
      return version; 
    int k = this.a.f();
    int i = (k - 17) / 4;
    if (i <= 6)
      return Version.b(i); 
    int m = k - 11;
    byte b = 5;
    boolean bool = false;
    i = 5;
    int j = 0;
    while (i >= 0) {
      for (int n = k - 9; n >= m; n--)
        j = a(n, i, j); 
      i--;
    } 
    version = Version.c(j);
    i = b;
    j = bool;
    if (version != null) {
      i = b;
      j = bool;
      if (version.d() == k) {
        this.b = version;
        return version;
      } 
    } 
    while (i >= 0) {
      for (int n = k - 9; n >= m; n--)
        j = a(i, n, j); 
      i--;
    } 
    version = Version.c(j);
    if (version != null && version.d() == k) {
      this.b = version;
      return version;
    } 
    throw FormatException.a();
  }
  
  byte[] c() throws FormatException {
    FormatInformation formatInformation = a();
    Version version = b();
    DataMask dataMask = DataMask.values()[formatInformation.b()];
    int i2 = this.a.f();
    dataMask.a(this.a, i2);
    BitMatrix bitMatrix = version.e();
    byte[] arrayOfByte = new byte[version.c()];
    int i1 = i2 - 1;
    int m = i1;
    int i = 0;
    int n = 1;
    int j = 0;
    int k = 0;
    while (m > 0) {
      int i3 = m;
      if (m == 6)
        i3 = m - 1; 
      m = 0;
      while (m < i2) {
        int i5;
        if (n) {
          i5 = i1 - m;
        } else {
          i5 = m;
        } 
        int i4 = j;
        int i6 = 0;
        j = k;
        k = i4;
        while (i6 < 2) {
          int i9 = i3 - i6;
          int i8 = i;
          i4 = k;
          int i7 = j;
          if (!bitMatrix.a(i9, i5)) {
            i4 = k + 1;
            j <<= 1;
            if (this.a.a(i9, i5))
              j |= 0x1; 
            if (i4 == 8) {
              arrayOfByte[i] = (byte)j;
              i8 = i + 1;
              i4 = 0;
              i7 = 0;
            } else {
              i7 = j;
              i8 = i;
            } 
          } 
          i6++;
          i = i8;
          k = i4;
          j = i7;
        } 
        m++;
        i4 = j;
        j = k;
        k = i4;
      } 
      n ^= 0x1;
      m = i3 - 2;
    } 
    if (i == version.c())
      return arrayOfByte; 
    throw FormatException.a();
  }
  
  void d() {
    if (this.c == null)
      return; 
    DataMask dataMask = DataMask.values()[this.c.b()];
    int i = this.a.f();
    dataMask.a(this.a, i);
  }
  
  void e() {
    for (int i = 0; i < this.a.e(); i = j) {
      int j = i + 1;
      for (int k = j; k < this.a.f(); k++) {
        if (this.a.a(i, k) != this.a.a(k, i)) {
          this.a.c(k, i);
          this.a.c(i, k);
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\qrcode\decoder\BitMatrixParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */