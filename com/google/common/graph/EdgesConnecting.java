package com.google.common.graph;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class EdgesConnecting<E> extends AbstractSet<E> {
  private final Map<?, E> a;
  
  private final Object b;
  
  @NullableDecl
  private E b() {
    return this.a.get(this.b);
  }
  
  public UnmodifiableIterator<E> a() {
    E e = b();
    return (e == null) ? ImmutableSet.j().av_() : Iterators.a(e);
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    E e = b();
    return (e != null && e.equals(paramObject));
  }
  
  public int size() {
    return (b() == null) ? 0 : 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\graph\EdgesConnecting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */