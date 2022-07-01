package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
  static final RegularImmutableMultiset<Object> a = new RegularImmutableMultiset(ObjectCountHashMap.a());
  
  final transient ObjectCountHashMap<E> b;
  
  private final transient int c;
  
  @LazyInit
  private transient ImmutableSet<E> d;
  
  RegularImmutableMultiset(ObjectCountHashMap<E> paramObjectCountHashMap) {
    this.b = paramObjectCountHashMap;
    long l = 0L;
    for (int i = 0; i < paramObjectCountHashMap.c(); i++)
      l += paramObjectCountHashMap.d(i); 
    this.c = Ints.b(l);
  }
  
  public int a(@NullableDecl Object paramObject) {
    return this.b.b(paramObject);
  }
  
  Multiset.Entry<E> a(int paramInt) {
    return this.b.e(paramInt);
  }
  
  boolean a() {
    return false;
  }
  
  public ImmutableSet<E> e() {
    ImmutableSet<E> immutableSet2 = this.d;
    ImmutableSet<E> immutableSet1 = immutableSet2;
    if (immutableSet2 == null) {
      immutableSet1 = new ElementSet();
      this.d = immutableSet1;
    } 
    return immutableSet1;
  }
  
  public int size() {
    return this.c;
  }
  
  final class ElementSet extends IndexedImmutableSet<E> {
    private ElementSet(RegularImmutableMultiset this$0) {}
    
    E a(int param1Int) {
      return this.a.b.c(param1Int);
    }
    
    boolean a() {
      return true;
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.a.contains(param1Object);
    }
    
    public int size() {
      return this.a.b.c();
    }
  }
  
  static class SerializedForm implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */