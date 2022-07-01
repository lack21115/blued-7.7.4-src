package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
  private final Map<TypeToken<? extends B>, B> a = Maps.c();
  
  @Deprecated
  public B a(TypeToken<? extends B> paramTypeToken, B paramB) {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  public Map<TypeToken<? extends B>, B> a() {
    return this.a;
  }
  
  public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
    return UnmodifiableEntry.a(super.entrySet());
  }
  
  @Deprecated
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> paramMap) {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  static final class UnmodifiableEntry<K, V> extends ForwardingMapEntry<K, V> {
    private final Map.Entry<K, V> a;
    
    private UnmodifiableEntry(Map.Entry<K, V> param1Entry) {
      this.a = (Map.Entry<K, V>)Preconditions.a(param1Entry);
    }
    
    static <K, V> Set<Map.Entry<K, V>> a(Set<Map.Entry<K, V>> param1Set) {
      return (Set<Map.Entry<K, V>>)new ForwardingSet<Map.Entry<K, V>>(param1Set) {
          public Set<Map.Entry<K, V>> a() {
            return this.a;
          }
          
          public Iterator<Map.Entry<K, V>> iterator() {
            return MutableTypeToInstanceMap.UnmodifiableEntry.a(super.iterator());
          }
          
          public Object[] toArray() {
            return o();
          }
          
          public <T> T[] toArray(T[] param2ArrayOfT) {
            return (T[])a((Object[])param2ArrayOfT);
          }
        };
    }
    
    private static <K, V> Iterator<Map.Entry<K, V>> b(Iterator<Map.Entry<K, V>> param1Iterator) {
      return Iterators.a(param1Iterator, new Function<Map.Entry<K, V>, Map.Entry<K, V>>() {
            public Map.Entry<K, V> a(Map.Entry<K, V> param2Entry) {
              return (Map.Entry)new MutableTypeToInstanceMap.UnmodifiableEntry<Object, Object>(param2Entry);
            }
          });
    }
    
    public Map.Entry<K, V> a() {
      return this.a;
    }
    
    public V setValue(V param1V) {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class null extends ForwardingSet<Map.Entry<K, V>> {
    null(Set param1Set) {}
    
    public Set<Map.Entry<K, V>> a() {
      return this.a;
    }
    
    public Iterator<Map.Entry<K, V>> iterator() {
      return MutableTypeToInstanceMap.UnmodifiableEntry.a(super.iterator());
    }
    
    public Object[] toArray() {
      return o();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])a((Object[])param1ArrayOfT);
    }
  }
  
  static final class null implements Function<Map.Entry<K, V>, Map.Entry<K, V>> {
    public Map.Entry<K, V> a(Map.Entry<K, V> param1Entry) {
      return (Map.Entry)new MutableTypeToInstanceMap.UnmodifiableEntry<Object, Object>(param1Entry);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\reflect\MutableTypeToInstanceMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */