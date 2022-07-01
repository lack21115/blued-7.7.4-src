package com.google.common.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
  @NullableDecl
  transient long[] d;
  
  private transient int e;
  
  private transient int f;
  
  private final boolean g;
  
  CompactLinkedHashMap() {
    this(3);
  }
  
  CompactLinkedHashMap(int paramInt) {
    this(paramInt, false);
  }
  
  CompactLinkedHashMap(int paramInt, boolean paramBoolean) {
    super(paramInt);
    this.g = paramBoolean;
  }
  
  private void c(int paramInt1, int paramInt2) {
    long[] arrayOfLong = this.d;
    arrayOfLong[paramInt1] = arrayOfLong[paramInt1] & 0xFFFFFFFF00000000L | (paramInt2 + 1) & 0xFFFFFFFFL;
  }
  
  private void d(int paramInt1, int paramInt2) {
    long[] arrayOfLong = this.d;
    arrayOfLong[paramInt1] = arrayOfLong[paramInt1] & 0xFFFFFFFFL | (paramInt2 + 1) << 32L;
  }
  
  private void e(int paramInt1, int paramInt2) {
    if (paramInt1 == -2) {
      this.e = paramInt2;
    } else {
      c(paramInt1, paramInt2);
    } 
    if (paramInt2 == -2) {
      this.f = paramInt1;
      return;
    } 
    d(paramInt2, paramInt1);
  }
  
  public static <K, V> CompactLinkedHashMap<K, V> g(int paramInt) {
    return new CompactLinkedHashMap<K, V>(paramInt);
  }
  
  private int h(int paramInt) {
    return (int)(this.d[paramInt] >>> 32L) - 1;
  }
  
  void a(int paramInt1, int paramInt2) {
    int i = size() - 1;
    super.a(paramInt1, paramInt2);
    e(h(paramInt1), f(paramInt1));
    if (paramInt1 < i) {
      e(h(i), paramInt1);
      e(paramInt1, f(i));
    } 
    this.d[i] = 0L;
  }
  
  void a(int paramInt1, @NullableDecl K paramK, @NullableDecl V paramV, int paramInt2, int paramInt3) {
    super.a(paramInt1, paramK, paramV, paramInt2, paramInt3);
    e(this.f, paramInt1);
    e(paramInt1, -2);
  }
  
  int b(int paramInt1, int paramInt2) {
    int i = paramInt1;
    if (paramInt1 >= size())
      i = paramInt2; 
    return i;
  }
  
  void b(int paramInt) {
    super.b(paramInt);
    this.e = -2;
    this.f = -2;
  }
  
  int c() {
    int i = super.c();
    this.d = new long[i];
    return i;
  }
  
  Map<K, V> c(int paramInt) {
    return new LinkedHashMap<K, V>(paramInt, 1.0F, this.g);
  }
  
  public void clear() {
    if (b())
      return; 
    this.e = -2;
    this.f = -2;
    long[] arrayOfLong = this.d;
    if (arrayOfLong != null)
      Arrays.fill(arrayOfLong, 0, size(), 0L); 
    super.clear();
  }
  
  void d(int paramInt) {
    if (this.g) {
      e(h(paramInt), f(paramInt));
      e(this.f, paramInt);
      e(paramInt, -2);
      f();
    } 
  }
  
  Map<K, V> e() {
    Map<K, V> map = super.e();
    this.d = null;
    return map;
  }
  
  void e(int paramInt) {
    super.e(paramInt);
    this.d = Arrays.copyOf(this.d, paramInt);
  }
  
  int f(int paramInt) {
    return (int)this.d[paramInt] - 1;
  }
  
  int g() {
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CompactLinkedHashMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */