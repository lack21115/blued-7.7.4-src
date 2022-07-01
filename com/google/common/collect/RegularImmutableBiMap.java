package com.google.common.collect;

import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
  static final RegularImmutableBiMap<Object, Object> a = new RegularImmutableBiMap();
  
  final transient Object[] c;
  
  private final transient Object d;
  
  private final transient int e;
  
  private final transient int f;
  
  private final transient RegularImmutableBiMap<V, K> g;
  
  private RegularImmutableBiMap() {
    this.d = null;
    this.c = new Object[0];
    this.e = 0;
    this.f = 0;
    this.g = this;
  }
  
  private RegularImmutableBiMap(Object paramObject, Object[] paramArrayOfObject, int paramInt, RegularImmutableBiMap<V, K> paramRegularImmutableBiMap) {
    this.d = paramObject;
    this.c = paramArrayOfObject;
    this.e = 1;
    this.f = paramInt;
    this.g = paramRegularImmutableBiMap;
  }
  
  RegularImmutableBiMap(Object[] paramArrayOfObject, int paramInt) {
    boolean bool;
    this.c = paramArrayOfObject;
    this.f = paramInt;
    this.e = 0;
    if (paramInt >= 2) {
      bool = ImmutableSet.c(paramInt);
    } else {
      bool = false;
    } 
    this.d = RegularImmutableMap.a(paramArrayOfObject, paramInt, bool, 0);
    this.g = new RegularImmutableBiMap(RegularImmutableMap.a(paramArrayOfObject, paramInt, bool, 1), paramArrayOfObject, paramInt, this);
  }
  
  boolean b() {
    return false;
  }
  
  ImmutableSet<K> c() {
    return new RegularImmutableMap.KeySet<K>(this, new RegularImmutableMap.KeysOrValuesAsList(this.c, this.e, this.f));
  }
  
  public ImmutableBiMap<V, K> e() {
    return this.g;
  }
  
  public V get(@NullableDecl Object paramObject) {
    return (V)RegularImmutableMap.a(this.d, this.c, this.f, this.e, paramObject);
  }
  
  ImmutableSet<Map.Entry<K, V>> m() {
    return new RegularImmutableMap.EntrySet<K, V>(this, this.c, this.e, this.f);
  }
  
  public int size() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\RegularImmutableBiMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */