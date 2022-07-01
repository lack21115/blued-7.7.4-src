package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
  private final ImmutableMap<K, V> a;
  
  ImmutableMapKeySet(ImmutableMap<K, V> paramImmutableMap) {
    this.a = paramImmutableMap;
  }
  
  K a(int paramInt) {
    return (K)((Map.Entry)this.a.l().h().get(paramInt)).getKey();
  }
  
  boolean a() {
    return true;
  }
  
  public UnmodifiableIterator<K> av_() {
    return this.a.a();
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return this.a.containsKey(paramObject);
  }
  
  public int size() {
    return this.a.size();
  }
  
  static class KeySetSerializedForm<K> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableMapKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */