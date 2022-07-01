package com.bytedance.sdk.a.a;

import java.util.Arrays;

final class q extends f {
  final transient byte[][] f;
  
  final transient int[] g;
  
  q(c paramc, int paramInt) {
    super(null);
    u.a(paramc.b, 0L, paramInt);
    o o2 = paramc.a;
    int k = 0;
    int j = 0;
    int i = 0;
    while (j < paramInt) {
      if (o2.c != o2.b) {
        j += o2.c - o2.b;
        i++;
        o2 = o2.f;
        continue;
      } 
      throw new AssertionError("s.limit == s.pos");
    } 
    this.f = new byte[i][];
    this.g = new int[i * 2];
    o o1 = paramc.a;
    j = 0;
    i = k;
    while (i < paramInt) {
      this.f[j] = o1.a;
      k = i + o1.c - o1.b;
      i = k;
      if (k > paramInt)
        i = paramInt; 
      int[] arrayOfInt = this.g;
      arrayOfInt[j] = i;
      arrayOfInt[this.f.length + j] = o1.b;
      o1.d = true;
      j++;
      o1 = o1.f;
    } 
  }
  
  private int b(int paramInt) {
    paramInt = Arrays.binarySearch(this.g, 0, this.f.length, paramInt + 1);
    return (paramInt >= 0) ? paramInt : paramInt;
  }
  
  private f i() {
    return new f(h());
  }
  
  public byte a(int paramInt) {
    int i;
    u.a(this.g[this.f.length - 1], paramInt, 1L);
    int j = b(paramInt);
    if (j == 0) {
      i = 0;
    } else {
      i = this.g[j - 1];
    } 
    int[] arrayOfInt = this.g;
    byte[][] arrayOfByte = this.f;
    int k = arrayOfInt[arrayOfByte.length + j];
    return arrayOfByte[j][paramInt - i + k];
  }
  
  public f a(int paramInt1, int paramInt2) {
    return i().a(paramInt1, paramInt2);
  }
  
  public String a() {
    return i().a();
  }
  
  void a(c paramc) {
    int k = this.f.length;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      int[] arrayOfInt = this.g;
      int n = arrayOfInt[k + i];
      int m = arrayOfInt[i];
      o o = new o(this.f[i], n, n + m - j, true, false);
      if (paramc.a == null) {
        o.g = o;
        o.f = o;
        paramc.a = o;
      } else {
        paramc.a.g.a(o);
      } 
      i++;
    } 
    paramc.b += j;
  }
  
  public boolean a(int paramInt1, f paramf, int paramInt2, int paramInt3) {
    if (paramInt1 >= 0) {
      if (paramInt1 > g() - paramInt3)
        return false; 
      int j = b(paramInt1);
      int i = paramInt1;
      for (paramInt1 = j; paramInt3 > 0; paramInt1++) {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.g[paramInt1 - 1];
        } 
        int k = Math.min(paramInt3, this.g[paramInt1] - j + j - i);
        int[] arrayOfInt = this.g;
        byte[][] arrayOfByte = this.f;
        int m = arrayOfInt[arrayOfByte.length + paramInt1];
        if (!paramf.a(paramInt2, arrayOfByte[paramInt1], i - j + m, k))
          return false; 
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
      } 
      return true;
    } 
    return false;
  }
  
  public boolean a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
    if (paramInt1 >= 0 && paramInt1 <= g() - paramInt3 && paramInt2 >= 0) {
      if (paramInt2 > paramArrayOfbyte.length - paramInt3)
        return false; 
      int j = b(paramInt1);
      int i = paramInt1;
      for (paramInt1 = j; paramInt3 > 0; paramInt1++) {
        if (paramInt1 == 0) {
          j = 0;
        } else {
          j = this.g[paramInt1 - 1];
        } 
        int k = Math.min(paramInt3, this.g[paramInt1] - j + j - i);
        int[] arrayOfInt = this.g;
        byte[][] arrayOfByte = this.f;
        int m = arrayOfInt[arrayOfByte.length + paramInt1];
        if (!u.a(arrayOfByte[paramInt1], i - j + m, paramArrayOfbyte, paramInt2, k))
          return false; 
        i += k;
        paramInt2 += k;
        paramInt3 -= k;
      } 
      return true;
    } 
    return false;
  }
  
  public String b() {
    return i().b();
  }
  
  public f c() {
    return i().c();
  }
  
  public f d() {
    return i().d();
  }
  
  public String e() {
    return i().e();
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject instanceof f) {
      paramObject = paramObject;
      if (paramObject.g() == g() && a(0, (f)paramObject, 0, g()))
        return true; 
    } 
    return false;
  }
  
  public f f() {
    return i().f();
  }
  
  public int g() {
    return this.g[this.f.length - 1];
  }
  
  public byte[] h() {
    int[] arrayOfInt = this.g;
    byte[][] arrayOfByte = this.f;
    byte[] arrayOfByte1 = new byte[arrayOfInt[arrayOfByte.length - 1]];
    int k = arrayOfByte.length;
    int i = 0;
    for (int j = 0; i < k; j = m) {
      int[] arrayOfInt1 = this.g;
      int n = arrayOfInt1[k + i];
      int m = arrayOfInt1[i];
      System.arraycopy(this.f[i], n, arrayOfByte1, j, m - j);
      i++;
    } 
    return arrayOfByte1;
  }
  
  public int hashCode() {
    int i = this.d;
    if (i != 0)
      return i; 
    int n = this.f.length;
    int k = 0;
    int m = 1;
    for (int j = 0; k < n; j = i1) {
      byte[] arrayOfByte = this.f[k];
      int[] arrayOfInt = this.g;
      int i2 = arrayOfInt[n + k];
      int i1 = arrayOfInt[k];
      for (i = i2; i < i1 - j + i2; i++)
        m = m * 31 + arrayOfByte[i]; 
      k++;
    } 
    this.d = m;
    return m;
  }
  
  public String toString() {
    return i().toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */