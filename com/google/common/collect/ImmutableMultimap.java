package com.google.common.collect;

import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
  final transient ImmutableMap<K, ? extends ImmutableCollection<V>> b;
  
  final transient int c;
  
  ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> paramImmutableMap, int paramInt) {
    this.b = paramImmutableMap;
    this.c = paramInt;
  }
  
  @Deprecated
  public boolean a(K paramK, V paramV) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public boolean c(Object paramObject1, Object paramObject2) {
    throw new UnsupportedOperationException();
  }
  
  boolean d() {
    return this.b.b();
  }
  
  public ImmutableSet<K> e() {
    return this.b.n();
  }
  
  public int f() {
    return this.c;
  }
  
  public boolean f(@NullableDecl Object paramObject) {
    return this.b.containsKey(paramObject);
  }
  
  @Deprecated
  public void g() {
    throw new UnsupportedOperationException();
  }
  
  public boolean g(@NullableDecl Object paramObject) {
    return (paramObject != null && super.g(paramObject));
  }
  
  Set<K> h() {
    throw new AssertionError("unreachable");
  }
  
  public abstract ImmutableCollection<V> i(K paramK);
  
  public ImmutableMap<K, Collection<V>> i() {
    return (ImmutableMap)this.b;
  }
  
  @Deprecated
  public ImmutableCollection<V> j(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  Map<K, Collection<V>> p() {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableCollection<Map.Entry<K, V>> q() {
    return (ImmutableCollection<Map.Entry<K, V>>)super.m();
  }
  
  ImmutableCollection<Map.Entry<K, V>> u() {
    return new EntryCollection<K, V>(this);
  }
  
  UnmodifiableIterator<Map.Entry<K, V>> v() {
    return new UnmodifiableIterator<Map.Entry<K, V>>(this) {
        final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> a = this.d.b.l().av_();
        
        K b = null;
        
        Iterator<V> c = Iterators.a();
        
        public Map.Entry<K, V> a() {
          if (!this.c.hasNext()) {
            Map.Entry entry = this.a.next();
            this.b = (K)entry.getKey();
            this.c = ((ImmutableCollection<V>)entry.getValue()).av_();
          } 
          return Maps.a(this.b, this.c.next());
        }
        
        public boolean hasNext() {
          return (this.c.hasNext() || this.a.hasNext());
        }
      };
  }
  
  public ImmutableCollection<V> w() {
    return (ImmutableCollection<V>)super.j();
  }
  
  ImmutableCollection<V> x() {
    return new Values<Object, V>(this);
  }
  
  UnmodifiableIterator<V> y() {
    return new UnmodifiableIterator<V>(this) {
        Iterator<? extends ImmutableCollection<V>> a = this.c.b.i().av_();
        
        Iterator<V> b = Iterators.a();
        
        public boolean hasNext() {
          return (this.b.hasNext() || this.a.hasNext());
        }
        
        public V next() {
          if (!this.b.hasNext())
            this.b = ((ImmutableCollection<V>)this.a.next()).av_(); 
          return this.b.next();
        }
      };
  }
  
  @DoNotMock
  public static class Builder<K, V> {
    Map<K, Collection<V>> a = Platform.a();
    
    @NullableDecl
    Comparator<? super K> b;
    
    @NullableDecl
    Comparator<? super V> c;
    
    public Builder<K, V> b(K param1K, V param1V) {
      CollectPreconditions.a(param1K, param1V);
      Collection<V> collection2 = this.a.get(param1K);
      Collection<V> collection1 = collection2;
      if (collection2 == null) {
        Map<K, Collection<V>> map = this.a;
        collection1 = c();
        map.put(param1K, collection1);
      } 
      collection1.add(param1V);
      return this;
    }
    
    public ImmutableMultimap<K, V> b() {
      ImmutableList<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> immutableList;
      Set<Map.Entry<K, Collection<V>>> set2 = this.a.entrySet();
      Comparator<? super K> comparator = this.b;
      Set<Map.Entry<K, Collection<V>>> set1 = set2;
      if (comparator != null)
        immutableList = Ordering.<K>a(comparator).e().a(set2); 
      return ImmutableListMultimap.a(immutableList, this.c);
    }
    
    Collection<V> c() {
      return new ArrayList<V>();
    }
  }
  
  static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
    final ImmutableMultimap<K, V> a;
    
    EntryCollection(ImmutableMultimap<K, V> param1ImmutableMultimap) {
      this.a = param1ImmutableMultimap;
    }
    
    boolean a() {
      return this.a.d();
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> av_() {
      return this.a.v();
    }
    
    public boolean contains(Object param1Object) {
      if (param1Object instanceof Map.Entry) {
        param1Object = param1Object;
        return this.a.b(param1Object.getKey(), param1Object.getValue());
      } 
      return false;
    }
    
    public int size() {
      return this.a.f();
    }
  }
  
  static class FieldSettersHolder {
    static final Serialization.FieldSetter<ImmutableMultimap> a = Serialization.a(ImmutableMultimap.class, "map");
    
    static final Serialization.FieldSetter<ImmutableMultimap> b = Serialization.a(ImmutableMultimap.class, "size");
  }
  
  class Keys extends ImmutableMultiset<K> {
    public int a(@NullableDecl Object param1Object) {
      param1Object = this.a.b.get(param1Object);
      return (param1Object == null) ? 0 : param1Object.size();
    }
    
    Multiset.Entry<K> a(int param1Int) {
      Map.Entry entry = this.a.b.l().h().get(param1Int);
      return Multisets.a((K)entry.getKey(), ((Collection)entry.getValue()).size());
    }
    
    boolean a() {
      return true;
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.a.f(param1Object);
    }
    
    public ImmutableSet<K> e() {
      return this.a.e();
    }
    
    public int size() {
      return this.a.f();
    }
  }
  
  static final class KeysSerializedForm implements Serializable {}
  
  static final class Values<K, V> extends ImmutableCollection<V> {
    private final transient ImmutableMultimap<K, V> a;
    
    Values(ImmutableMultimap<K, V> param1ImmutableMultimap) {
      this.a = param1ImmutableMultimap;
    }
    
    int a(Object[] param1ArrayOfObject, int param1Int) {
      UnmodifiableIterator<ImmutableCollection> unmodifiableIterator = this.a.b.i().av_();
      while (unmodifiableIterator.hasNext())
        param1Int = ((ImmutableCollection)unmodifiableIterator.next()).a(param1ArrayOfObject, param1Int); 
      return param1Int;
    }
    
    boolean a() {
      return true;
    }
    
    public UnmodifiableIterator<V> av_() {
      return this.a.y();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.a.g(param1Object);
    }
    
    public int size() {
      return this.a.f();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */