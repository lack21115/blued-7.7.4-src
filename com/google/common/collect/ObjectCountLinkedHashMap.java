package com.google.common.collect;

import java.util.Arrays;

class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
  transient long[] f;
  
  private transient int g;
  
  private transient int h;
  
  ObjectCountLinkedHashMap() {
    this(3);
  }
  
  ObjectCountLinkedHashMap(int paramInt) {
    this(paramInt, 1.0F);
  }
  
  ObjectCountLinkedHashMap(int paramInt, float paramFloat) {
    super(paramInt, paramFloat);
  }
  
  private void c(int paramInt1, int paramInt2) {
    long[] arrayOfLong = this.f;
    arrayOfLong[paramInt1] = arrayOfLong[paramInt1] & 0xFFFFFFFF00000000L | paramInt2 & 0xFFFFFFFFL;
  }
  
  private void d(int paramInt1, int paramInt2) {
    long[] arrayOfLong = this.f;
    arrayOfLong[paramInt1] = arrayOfLong[paramInt1] & 0xFFFFFFFFL | paramInt2 << 32L;
  }
  
  private void e(int paramInt1, int paramInt2) {
    if (paramInt1 == -2) {
      this.g = paramInt2;
    } else {
      c(paramInt1, paramInt2);
    } 
    if (paramInt2 == -2) {
      this.h = paramInt1;
      return;
    } 
    d(paramInt2, paramInt1);
  }
  
  private int j(int paramInt) {
    return (int)(this.f[paramInt] >>> 32L);
  }
  
  private int k(int paramInt) {
    return (int)this.f[paramInt];
  }
  
  int a(int paramInt1, int paramInt2) {
    int i = paramInt1;
    if (paramInt1 == c())
      i = paramInt2; 
    return i;
  }
  
  void a(int paramInt, float paramFloat) {
    super.a(paramInt, paramFloat);
    this.g = -2;
    this.h = -2;
    this.f = new long[paramInt];
    Arrays.fill(this.f, -1L);
  }
  
  void a(int paramInt1, K paramK, int paramInt2, int paramInt3) {
    super.a(paramInt1, paramK, paramInt2, paramInt3);
    e(this.h, paramInt1);
    e(paramInt1, -2);
  }
  
  int b() {
    int j = this.g;
    int i = j;
    if (j == -2)
      i = -1; 
    return i;
  }
  
  int b(int paramInt) {
    int i = k(paramInt);
    paramInt = i;
    if (i == -2)
      paramInt = -1; 
    return paramInt;
  }
  
  public void d() {
    super.d();
    this.g = -2;
    this.h = -2;
  }
  
  void g(int paramInt) {
    super.g(paramInt);
    long[] arrayOfLong = this.f;
    int i = arrayOfLong.length;
    this.f = Arrays.copyOf(arrayOfLong, paramInt);
    Arrays.fill(this.f, i, paramInt, -1L);
  }
  
  void i(int paramInt) {
    int i = c() - 1;
    e(j(paramInt), k(paramInt));
    if (paramInt < i) {
      e(j(i), paramInt);
      e(paramInt, k(i));
    } 
    super.i(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ObjectCountLinkedHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */