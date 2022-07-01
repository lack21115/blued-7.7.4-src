package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use ImmutableMap.of or another implementation")
public abstract class ImmutableMap<K, V> implements Serializable, Map<K, V> {
  static final Map.Entry<?, ?>[] b = (Map.Entry<?, ?>[])new Map.Entry[0];
  
  @LazyInit
  private transient ImmutableSet<Map.Entry<K, V>> a;
  
  @LazyInit
  private transient ImmutableSet<K> c;
  
  @LazyInit
  private transient ImmutableCollection<V> d;
  
  public static <K, V> ImmutableMap<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> paramIterable) {
    byte b;
    if (paramIterable instanceof Collection) {
      b = ((Collection)paramIterable).size();
    } else {
      b = 4;
    } 
    Builder<Object, Object> builder = new Builder<Object, Object>(b);
    builder.b(paramIterable);
    return (ImmutableMap)builder.b();
  }
  
  public static <K, V> ImmutableMap<K, V> a(K paramK, V paramV) {
    CollectPreconditions.a(paramK, paramV);
    return RegularImmutableMap.a(1, new Object[] { paramK, paramV });
  }
  
  public static <K, V> ImmutableMap<K, V> a(Map<? extends K, ? extends V> paramMap) {
    if (paramMap instanceof ImmutableMap && !(paramMap instanceof java.util.SortedMap)) {
      ImmutableMap<K, V> immutableMap = (ImmutableMap)paramMap;
      if (!immutableMap.b())
        return immutableMap; 
    } 
    return a(paramMap.entrySet());
  }
  
  public static <K, V> ImmutableMap<K, V> j() {
    return (ImmutableMap)RegularImmutableMap.a;
  }
  
  public static <K, V> Builder<K, V> k() {
    return new Builder<K, V>();
  }
  
  UnmodifiableIterator<K> a() {
    return new UnmodifiableIterator<K>(this, l().av_()) {
        public boolean hasNext() {
          return this.a.hasNext();
        }
        
        public K next() {
          return (K)((Map.Entry)this.a.next()).getKey();
        }
      };
  }
  
  abstract boolean b();
  
  abstract ImmutableSet<K> c();
  
  @Deprecated
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  public boolean containsKey(@NullableDecl Object paramObject) {
    return (get(paramObject) != null);
  }
  
  public boolean containsValue(@NullableDecl Object paramObject) {
    return i().contains(paramObject);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return Maps.d(this, paramObject);
  }
  
  public abstract V get(@NullableDecl Object paramObject);
  
  public final V getOrDefault(@NullableDecl Object paramObject, @NullableDecl V paramV) {
    paramObject = get(paramObject);
    return (V)((paramObject != null) ? paramObject : (Object)paramV);
  }
  
  abstract ImmutableCollection<V> h();
  
  public int hashCode() {
    return Sets.a(l());
  }
  
  public ImmutableCollection<V> i() {
    ImmutableCollection<V> immutableCollection2 = this.d;
    ImmutableCollection<V> immutableCollection1 = immutableCollection2;
    if (immutableCollection2 == null) {
      immutableCollection1 = h();
      this.d = immutableCollection1;
    } 
    return immutableCollection1;
  }
  
  public boolean isEmpty() {
    return (size() == 0);
  }
  
  public ImmutableSet<Map.Entry<K, V>> l() {
    ImmutableSet<Map.Entry<K, V>> immutableSet2 = this.a;
    ImmutableSet<Map.Entry<K, V>> immutableSet1 = immutableSet2;
    if (immutableSet2 == null) {
      immutableSet1 = m();
      this.a = immutableSet1;
    } 
    return immutableSet1;
  }
  
  abstract ImmutableSet<Map.Entry<K, V>> m();
  
  public ImmutableSet<K> n() {
    ImmutableSet<K> immutableSet2 = this.c;
    ImmutableSet<K> immutableSet1 = immutableSet2;
    if (immutableSet2 == null) {
      immutableSet1 = c();
      this.c = immutableSet1;
    } 
    return immutableSet1;
  }
  
  boolean o() {
    return false;
  }
  
  @Deprecated
  public final V put(K paramK, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final void putAll(Map<? extends K, ? extends V> paramMap) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final V remove(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  public String toString() {
    return Maps.a(this);
  }
  
  @DoNotMock
  public static class Builder<K, V> {
    @NullableDecl
    Comparator<? super V> a;
    
    Object[] b;
    
    int c;
    
    boolean d;
    
    public Builder() {
      this(4);
    }
    
    Builder(int param1Int) {
      this.b = new Object[param1Int * 2];
      this.c = 0;
      this.d = false;
    }
    
    private void a(int param1Int) {
      param1Int *= 2;
      Object[] arrayOfObject = this.b;
      if (param1Int > arrayOfObject.length) {
        this.b = Arrays.copyOf(arrayOfObject, ImmutableCollection.Builder.a(arrayOfObject.length, param1Int));
        this.d = false;
      } 
    }
    
    public Builder<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
      if (param1Iterable instanceof Collection)
        a(this.c + ((Collection)param1Iterable).size()); 
      Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        b(iterator.next()); 
      return this;
    }
    
    public Builder<K, V> b(K param1K, V param1V) {
      a(this.c + 1);
      CollectPreconditions.a(param1K, param1V);
      Object[] arrayOfObject = this.b;
      int i = this.c;
      arrayOfObject[i * 2] = param1K;
      arrayOfObject[i * 2 + 1] = param1V;
      this.c = i + 1;
      return this;
    }
    
    public Builder<K, V> b(Map.Entry<? extends K, ? extends V> param1Entry) {
      return b(param1Entry.getKey(), param1Entry.getValue());
    }
    
    public Builder<K, V> b(Map<? extends K, ? extends V> param1Map) {
      return b(param1Map.entrySet());
    }
    
    public ImmutableMap<K, V> b() {
      c();
      this.d = true;
      return RegularImmutableMap.a(this.c, this.b);
    }
    
    void c() {
      if (this.a != null) {
        if (this.d)
          this.b = Arrays.copyOf(this.b, this.c * 2); 
        Map.Entry[] arrayOfEntry = new Map.Entry[this.c];
        int j = 0;
        int i = 0;
        while (true) {
          int k = this.c;
          if (i < k) {
            Object[] arrayOfObject = this.b;
            k = i * 2;
            arrayOfEntry[i] = new AbstractMap.SimpleImmutableEntry<Object, Object>(arrayOfObject[k], arrayOfObject[k + 1]);
            i++;
            continue;
          } 
          Arrays.sort(arrayOfEntry, 0, k, Ordering.<V>a(this.a).a(Maps.b()));
          for (i = j; i < this.c; i++) {
            Object[] arrayOfObject = this.b;
            j = i * 2;
            arrayOfObject[j] = arrayOfEntry[i].getKey();
            this.b[j + 1] = arrayOfEntry[i].getValue();
          } 
          break;
        } 
      } 
    }
  }
  
  static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
    ImmutableSet<K> c() {
      return new ImmutableMapKeySet<K, Object>(this);
    }
    
    abstract UnmodifiableIterator<Map.Entry<K, V>> d();
    
    ImmutableCollection<V> h() {
      return new ImmutableMapValues<Object, V>(this);
    }
    
    ImmutableSet<Map.Entry<K, V>> m() {
      class EntrySetImpl extends ImmutableMapEntrySet<K, V> {
        EntrySetImpl(ImmutableMap.IteratorBasedImmutableMap this$0) {}
        
        public UnmodifiableIterator<Map.Entry<K, V>> av_() {
          return this.a.d();
        }
        
        ImmutableMap<K, V> c() {
          return this.a;
        }
      };
      return new EntrySetImpl(this);
    }
  }
  
  class EntrySetImpl extends ImmutableMapEntrySet<K, V> {
    EntrySetImpl(ImmutableMap this$0) {}
    
    public UnmodifiableIterator<Map.Entry<K, V>> av_() {
      return this.a.d();
    }
    
    ImmutableMap<K, V> c() {
      return this.a;
    }
  }
  
  final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
    public ImmutableSet<V> a(@NullableDecl Object param1Object) {
      param1Object = this.a.get(param1Object);
      return (param1Object == null) ? null : ImmutableSet.d((V)param1Object);
    }
    
    boolean b() {
      return this.a.b();
    }
    
    ImmutableSet<K> c() {
      return this.a.n();
    }
    
    public boolean containsKey(@NullableDecl Object param1Object) {
      return this.a.containsKey(param1Object);
    }
    
    UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> d() {
      return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>(this, this.a.l().av_()) {
          public Map.Entry<K, ImmutableSet<V>> a() {
            return (Map.Entry)new AbstractMapEntry<K, ImmutableSet<ImmutableSet<V>>>(this, this.a.next()) {
                public ImmutableSet<V> a() {
                  return ImmutableSet.d((V)this.a.getValue());
                }
                
                public K getKey() {
                  return (K)this.a.getKey();
                }
              };
          }
          
          public boolean hasNext() {
            return this.a.hasNext();
          }
        };
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    boolean o() {
      return this.a.o();
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  class null extends UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> {
    null(ImmutableMap this$0, Iterator param1Iterator) {}
    
    public Map.Entry<K, ImmutableSet<V>> a() {
      return (Map.Entry)new AbstractMapEntry<K, ImmutableSet<ImmutableSet<V>>>(this, this.a.next()) {
          public ImmutableSet<V> a() {
            return ImmutableSet.d((V)this.a.getValue());
          }
          
          public K getKey() {
            return (K)this.a.getKey();
          }
        };
    }
    
    public boolean hasNext() {
      return this.a.hasNext();
    }
  }
  
  class null extends AbstractMapEntry<K, ImmutableSet<V>> {
    public ImmutableSet<V> a() {
      return ImmutableSet.d((V)this.a.getValue());
    }
    
    public K getKey() {
      return (K)this.a.getKey();
    }
  }
  
  static class SerializedForm implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */