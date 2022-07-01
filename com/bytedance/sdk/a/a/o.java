package com.bytedance.sdk.a.a;

final class o {
  final byte[] a = new byte[8192];
  
  int b;
  
  int c;
  
  boolean d;
  
  boolean e;
  
  o f;
  
  o g;
  
  o() {
    this.e = true;
    this.d = false;
  }
  
  o(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  final o a() {
    this.d = true;
    return new o(this.a, this.b, this.c, true, false);
  }
  
  public final o a(int paramInt) {
    if (paramInt > 0 && paramInt <= this.c - this.b) {
      o o1;
      if (paramInt >= 1024) {
        o1 = a();
      } else {
        o1 = p.a();
        System.arraycopy(this.a, this.b, o1.a, 0, paramInt);
      } 
      o1.c = o1.b + paramInt;
      this.b += paramInt;
      this.g.a(o1);
      return o1;
    } 
    throw new IllegalArgumentException();
  }
  
  public final o a(o paramo) {
    paramo.g = this;
    paramo.f = this.f;
    this.f.g = paramo;
    this.f = paramo;
    return paramo;
  }
  
  public final void a(o paramo, int paramInt) {
    if (paramo.e) {
      int i = paramo.c;
      if (i + paramInt > 8192)
        if (!paramo.d) {
          int j = paramo.b;
          if (i + paramInt - j <= 8192) {
            byte[] arrayOfByte = paramo.a;
            System.arraycopy(arrayOfByte, j, arrayOfByte, 0, i - j);
            paramo.c -= paramo.b;
            paramo.b = 0;
          } else {
            throw new IllegalArgumentException();
          } 
        } else {
          throw new IllegalArgumentException();
        }  
      System.arraycopy(this.a, this.b, paramo.a, paramo.c, paramInt);
      paramo.c += paramInt;
      this.b += paramInt;
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  public final o b() {
    o o1 = this.f;
    if (o1 == this)
      o1 = null; 
    o o2 = this.g;
    o2.f = this.f;
    this.f.g = o2;
    this.f = null;
    this.g = null;
    return o1;
  }
  
  public final void c() {
    o o1 = this.g;
    if (o1 != this) {
      int i;
      if (!o1.e)
        return; 
      int j = this.c - this.b;
      int k = o1.c;
      if (o1.d) {
        i = 0;
      } else {
        i = o1.b;
      } 
      if (j > 8192 - k + i)
        return; 
      a(this.g, j);
      b();
      p.a(this);
      return;
    } 
    throw new IllegalStateException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\a\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */