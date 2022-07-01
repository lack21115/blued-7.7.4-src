package com.google.common.collect;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableSet<E> extends ImmutableSet<E> {
  static final RegularImmutableSet<Object> a = new RegularImmutableSet(new Object[0], 0, null, 0, 0);
  
  final transient Object[] b;
  
  final transient Object[] c;
  
  private final transient int d;
  
  private final transient int e;
  
  private final transient int f;
  
  RegularImmutableSet(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2, int paramInt3) {
    this.b = paramArrayOfObject1;
    this.c = paramArrayOfObject2;
    this.d = paramInt2;
    this.e = paramInt1;
    this.f = paramInt3;
  }
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    System.arraycopy(this.b, 0, paramArrayOfObject, paramInt, this.f);
    return paramInt + this.f;
  }
  
  boolean a() {
    return false;
  }
  
  public UnmodifiableIterator<E> av_() {
    return h().av_();
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    Object[] arrayOfObject = this.c;
    if (paramObject != null) {
      if (arrayOfObject == null)
        return false; 
      for (int i = Hashing.a(paramObject);; i++) {
        i &= this.d;
        Object object = arrayOfObject[i];
        if (object == null)
          return false; 
        if (object.equals(paramObject))
          return true; 
      } 
    } 
    return false;
  }
  
  ImmutableList<E> d() {
    return ImmutableList.b(this.b, this.f);
  }
  
  public int hashCode() {
    return this.e;
  }
  
  boolean i() {
    return true;
  }
  
  Object[] n() {
    return this.b;
  }
  
  int o() {
    return 0;
  }
  
  int q() {
    return this.f;
  }
  
  public int size() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */