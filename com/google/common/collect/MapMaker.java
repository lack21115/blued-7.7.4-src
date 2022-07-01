package com.google.common.collect;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class MapMaker {
  boolean a;
  
  int b = -1;
  
  int c = -1;
  
  @NullableDecl
  MapMakerInternalMap.Strength d;
  
  @NullableDecl
  MapMakerInternalMap.Strength e;
  
  @NullableDecl
  Equivalence<Object> f;
  
  Equivalence<Object> a() {
    return (Equivalence<Object>)MoreObjects.a(this.f, e().a());
  }
  
  MapMaker a(MapMakerInternalMap.Strength paramStrength) {
    boolean bool;
    if (this.d == null) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool, "Key strength was already set to %s", this.d);
    this.d = (MapMakerInternalMap.Strength)Preconditions.a(paramStrength);
    if (paramStrength != MapMakerInternalMap.Strength.a)
      this.a = true; 
    return this;
  }
  
  int b() {
    int j = this.b;
    int i = j;
    if (j == -1)
      i = 16; 
    return i;
  }
  
  int c() {
    int j = this.c;
    int i = j;
    if (j == -1)
      i = 4; 
    return i;
  }
  
  public MapMaker d() {
    return a(MapMakerInternalMap.Strength.b);
  }
  
  MapMakerInternalMap.Strength e() {
    return (MapMakerInternalMap.Strength)MoreObjects.a(this.d, MapMakerInternalMap.Strength.a);
  }
  
  MapMakerInternalMap.Strength f() {
    return (MapMakerInternalMap.Strength)MoreObjects.a(this.e, MapMakerInternalMap.Strength.a);
  }
  
  public <K, V> ConcurrentMap<K, V> g() {
    return (ConcurrentMap<K, V>)(!this.a ? new ConcurrentHashMap<K, V>(b(), 0.75F, c()) : MapMakerInternalMap.a(this));
  }
  
  public String toString() {
    MoreObjects.ToStringHelper toStringHelper = MoreObjects.a(this);
    int i = this.b;
    if (i != -1)
      toStringHelper.a("initialCapacity", i); 
    i = this.c;
    if (i != -1)
      toStringHelper.a("concurrencyLevel", i); 
    MapMakerInternalMap.Strength strength = this.d;
    if (strength != null)
      toStringHelper.a("keyStrength", Ascii.a(strength.toString())); 
    strength = this.e;
    if (strength != null)
      toStringHelper.a("valueStrength", Ascii.a(strength.toString())); 
    if (this.f != null)
      toStringHelper.a("keyEquivalence"); 
    return toStringHelper.toString();
  }
  
  enum Dummy {
    a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\MapMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */