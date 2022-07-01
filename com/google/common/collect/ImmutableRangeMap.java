package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
  private static final ImmutableRangeMap<Comparable<?>, Object> a = new ImmutableRangeMap(ImmutableList.d(), ImmutableList.d());
  
  private final transient ImmutableList<Range<K>> b;
  
  private final transient ImmutableList<V> c;
  
  ImmutableRangeMap(ImmutableList<Range<K>> paramImmutableList, ImmutableList<V> paramImmutableList1) {
    this.b = paramImmutableList;
    this.c = paramImmutableList1;
  }
  
  public ImmutableMap<Range<K>, V> a() {
    return this.b.isEmpty() ? ImmutableMap.j() : new ImmutableSortedMap<Range<K>, V>(new RegularImmutableSortedSet<Range<K>>(this.b, (Comparator)Range.c()), this.c);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject instanceof RangeMap) {
      paramObject = paramObject;
      return a().equals(paramObject.b());
    } 
    return false;
  }
  
  public int hashCode() {
    return a().hashCode();
  }
  
  public String toString() {
    return a().toString();
  }
  
  @DoNotMock
  public static final class Builder<K extends Comparable<?>, V> {
    private final List<Map.Entry<Range<K>, V>> a = Lists.a();
  }
  
  static class SerializedForm<K extends Comparable<?>, V> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableRangeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */