package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
  static <R, C, V> Table.Cell<R, C, V> b(R paramR, C paramC, V paramV) {
    return Tables.a((R)Preconditions.a(paramR, "rowKey"), (C)Preconditions.a(paramC, "columnKey"), (V)Preconditions.a(paramV, "value"));
  }
  
  @Deprecated
  public final V a(R paramR, C paramC, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  public boolean a(@NullableDecl Object paramObject1, @NullableDecl Object paramObject2) {
    return (b(paramObject1, paramObject2) != null);
  }
  
  @Deprecated
  public final V c(Object paramObject1, Object paramObject2) {
    throw new UnsupportedOperationException();
  }
  
  public boolean c(@NullableDecl Object paramObject) {
    return s().contains(paramObject);
  }
  
  @Deprecated
  public final void d() {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<R, V> f(C paramC) {
    Preconditions.a(paramC, "columnKey");
    return (ImmutableMap<R, V>)MoreObjects.a(l().get(paramC), ImmutableMap.j());
  }
  
  public ImmutableMap<C, V> g(R paramR) {
    Preconditions.a(paramR, "rowKey");
    return (ImmutableMap<C, V>)MoreObjects.a(n().get(paramR), ImmutableMap.j());
  }
  
  final Iterator<V> j() {
    throw new AssertionError("should never be called");
  }
  
  public abstract ImmutableMap<C, Map<R, V>> l();
  
  public abstract ImmutableMap<R, Map<C, V>> n();
  
  public ImmutableSet<Table.Cell<R, C, V>> p() {
    return (ImmutableSet<Table.Cell<R, C, V>>)super.e();
  }
  
  abstract ImmutableSet<Table.Cell<R, C, V>> q();
  
  final UnmodifiableIterator<Table.Cell<R, C, V>> r() {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableCollection<V> s() {
    return (ImmutableCollection<V>)super.h();
  }
  
  abstract ImmutableCollection<V> t();
  
  public ImmutableSet<C> u() {
    return l().n();
  }
  
  public ImmutableSet<R> v() {
    return n().n();
  }
  
  @DoNotMock
  public static final class Builder<R, C, V> {
    private final List<Table.Cell<R, C, V>> a = Lists.a();
  }
  
  static final class SerializedForm implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */