package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
  boolean a() {
    return c().b();
  }
  
  abstract ImmutableMap<K, V> c();
  
  public boolean contains(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof Map.Entry;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      V v = c().get(paramObject.getKey());
      bool1 = bool2;
      if (v != null) {
        bool1 = bool2;
        if (v.equals(paramObject.getValue()))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return c().hashCode();
  }
  
  boolean i() {
    return c().o();
  }
  
  public int size() {
    return c().size();
  }
  
  static class EntrySetSerializedForm<K, V> implements Serializable {}
  
  static final class RegularEntrySet<K, V> extends ImmutableMapEntrySet<K, V> {
    private final transient ImmutableMap<K, V> a;
    
    private final transient ImmutableList<Map.Entry<K, V>> b;
    
    int a(Object[] param1ArrayOfObject, int param1Int) {
      return this.b.a(param1ArrayOfObject, param1Int);
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> av_() {
      return this.b.av_();
    }
    
    ImmutableMap<K, V> c() {
      return this.a;
    }
    
    ImmutableList<Map.Entry<K, V>> d() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableMapEntrySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */