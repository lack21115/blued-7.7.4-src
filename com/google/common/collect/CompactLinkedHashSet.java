package com.google.common.collect;

import java.util.Arrays;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class CompactLinkedHashSet<E> extends CompactHashSet<E> {
  @NullableDecl
  private transient int[] b;
  
  @NullableDecl
  private transient int[] c;
  
  private transient int d;
  
  private transient int e;
  
  CompactLinkedHashSet() {}
  
  CompactLinkedHashSet(int paramInt) {
    super(paramInt);
  }
  
  private void c(int paramInt1, int paramInt2) {
    this.c[paramInt1] = paramInt2 + 1;
  }
  
  private void d(int paramInt1, int paramInt2) {
    this.b[paramInt1] = paramInt2 + 1;
  }
  
  public static <E> CompactLinkedHashSet<E> e(int paramInt) {
    return new CompactLinkedHashSet<E>(paramInt);
  }
  
  private void e(int paramInt1, int paramInt2) {
    if (paramInt1 == -2) {
      this.d = paramInt2;
    } else {
      c(paramInt1, paramInt2);
    } 
    if (paramInt2 == -2) {
      this.e = paramInt1;
      return;
    } 
    d(paramInt2, paramInt1);
  }
  
  private int f(int paramInt) {
    return this.b[paramInt] - 1;
  }
  
  void a(int paramInt1, int paramInt2) {
    int i = size() - 1;
    super.a(paramInt1, paramInt2);
    e(f(paramInt1), d(paramInt1));
    if (paramInt1 < i) {
      e(f(i), paramInt1);
      e(paramInt1, d(i));
    } 
    this.b[i] = 0;
    this.c[i] = 0;
  }
  
  void a(int paramInt1, @NullableDecl E paramE, int paramInt2, int paramInt3) {
    super.a(paramInt1, paramE, paramInt2, paramInt3);
    e(this.e, paramInt1);
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
    this.d = -2;
    this.e = -2;
  }
  
  int c() {
    int i = super.c();
    this.b = new int[i];
    this.c = new int[i];
    return i;
  }
  
  void c(int paramInt) {
    super.c(paramInt);
    this.b = Arrays.copyOf(this.b, paramInt);
    this.c = Arrays.copyOf(this.c, paramInt);
  }
  
  public void clear() {
    if (b())
      return; 
    this.d = -2;
    this.e = -2;
    int[] arrayOfInt = this.b;
    if (arrayOfInt != null) {
      Arrays.fill(arrayOfInt, 0, size(), 0);
      Arrays.fill(this.c, 0, size(), 0);
    } 
    super.clear();
  }
  
  int d(int paramInt) {
    return this.c[paramInt] - 1;
  }
  
  Set<E> e() {
    Set<E> set = super.e();
    this.b = null;
    this.c = null;
    return set;
  }
  
  int g() {
    return this.d;
  }
  
  public Object[] toArray() {
    return ObjectArrays.a(this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return ObjectArrays.a(this, paramArrayOfT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CompactLinkedHashSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */