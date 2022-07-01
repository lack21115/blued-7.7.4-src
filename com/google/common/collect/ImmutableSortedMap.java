package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
  private static final Comparator<Comparable> a = Ordering.d();
  
  private static final ImmutableSortedMap<Comparable, Object> c = new ImmutableSortedMap(ImmutableSortedSet.a(Ordering.d()), ImmutableList.d());
  
  private final transient RegularImmutableSortedSet<K> d;
  
  private final transient ImmutableList<V> e;
  
  private transient ImmutableSortedMap<K, V> f;
  
  ImmutableSortedMap(RegularImmutableSortedSet<K> paramRegularImmutableSortedSet, ImmutableList<V> paramImmutableList) {
    this(paramRegularImmutableSortedSet, paramImmutableList, null);
  }
  
  ImmutableSortedMap(RegularImmutableSortedSet<K> paramRegularImmutableSortedSet, ImmutableList<V> paramImmutableList, ImmutableSortedMap<K, V> paramImmutableSortedMap) {
    this.d = paramRegularImmutableSortedSet;
    this.e = paramImmutableList;
    this.f = paramImmutableSortedMap;
  }
  
  private ImmutableSortedMap<K, V> a(int paramInt1, int paramInt2) {
    return (paramInt1 == 0 && paramInt2 == size()) ? this : ((paramInt1 == paramInt2) ? a(comparator()) : new ImmutableSortedMap(this.d.b(paramInt1, paramInt2), this.e.a(paramInt1, paramInt2)));
  }
  
  static <K, V> ImmutableSortedMap<K, V> a(Comparator<? super K> paramComparator) {
    return Ordering.<Comparable>d().equals(paramComparator) ? d() : new ImmutableSortedMap<K, V>(ImmutableSortedSet.a(paramComparator), ImmutableList.d());
  }
  
  private static <K, V> ImmutableSortedMap<K, V> b(Comparator<? super K> paramComparator, K paramK, V paramV) {
    return new ImmutableSortedMap<K, V>(new RegularImmutableSortedSet<K>(ImmutableList.a(paramK), (Comparator<? super K>)Preconditions.a(paramComparator)), ImmutableList.a(paramV));
  }
  
  public static <K, V> ImmutableSortedMap<K, V> d() {
    return (ImmutableSortedMap)c;
  }
  
  public ImmutableSortedMap<K, V> a(K paramK) {
    return a(paramK, false);
  }
  
  public ImmutableSortedMap<K, V> a(K paramK, boolean paramBoolean) {
    return a(0, this.d.e((K)Preconditions.a(paramK), paramBoolean));
  }
  
  public ImmutableSortedMap<K, V> a(K paramK1, boolean paramBoolean1, K paramK2, boolean paramBoolean2) {
    boolean bool;
    Preconditions.a(paramK1);
    Preconditions.a(paramK2);
    if (comparator().compare(paramK1, paramK2) <= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "expected fromKey <= toKey but %s > %s", paramK1, paramK2);
    return a(paramK2, paramBoolean2).b(paramK1, paramBoolean1);
  }
  
  public ImmutableSortedMap<K, V> b(K paramK) {
    return b(paramK, true);
  }
  
  public ImmutableSortedMap<K, V> b(K paramK1, K paramK2) {
    return a(paramK1, true, paramK2, false);
  }
  
  public ImmutableSortedMap<K, V> b(K paramK, boolean paramBoolean) {
    return a(this.d.f((K)Preconditions.a(paramK), paramBoolean), size());
  }
  
  boolean b() {
    return (this.d.a() || this.e.a());
  }
  
  ImmutableSet<K> c() {
    throw new AssertionError("should never be called");
  }
  
  public Map.Entry<K, V> ceilingEntry(K paramK) {
    return b(paramK, true).firstEntry();
  }
  
  public K ceilingKey(K paramK) {
    return Maps.b(ceilingEntry(paramK));
  }
  
  public Comparator<? super K> comparator() {
    return e().comparator();
  }
  
  public ImmutableSortedSet<K> e() {
    return this.d;
  }
  
  public ImmutableSortedMap<K, V> f() {
    ImmutableSortedMap<K, V> immutableSortedMap2 = this.f;
    ImmutableSortedMap<K, V> immutableSortedMap1 = immutableSortedMap2;
    if (immutableSortedMap2 == null) {
      if (isEmpty())
        return a(Ordering.<K>a(comparator()).a()); 
      immutableSortedMap1 = new ImmutableSortedMap((RegularImmutableSortedSet<K>)this.d.as_(), this.e.f(), this);
    } 
    return immutableSortedMap1;
  }
  
  public Map.Entry<K, V> firstEntry() {
    return isEmpty() ? null : l().h().get(0);
  }
  
  public K firstKey() {
    return e().first();
  }
  
  public Map.Entry<K, V> floorEntry(K paramK) {
    return a(paramK, true).lastEntry();
  }
  
  public K floorKey(K paramK) {
    return Maps.b(floorEntry(paramK));
  }
  
  public ImmutableSortedSet<K> g() {
    return this.d;
  }
  
  public V get(@NullableDecl Object paramObject) {
    int i = this.d.c(paramObject);
    return (i == -1) ? null : this.e.get(i);
  }
  
  ImmutableCollection<V> h() {
    throw new AssertionError("should never be called");
  }
  
  public Map.Entry<K, V> higherEntry(K paramK) {
    return b(paramK, false).firstEntry();
  }
  
  public K higherKey(K paramK) {
    return Maps.b(higherEntry(paramK));
  }
  
  public ImmutableCollection<V> i() {
    return this.e;
  }
  
  public ImmutableSet<Map.Entry<K, V>> l() {
    return super.l();
  }
  
  public Map.Entry<K, V> lastEntry() {
    return isEmpty() ? null : l().h().get(size() - 1);
  }
  
  public K lastKey() {
    return e().last();
  }
  
  public Map.Entry<K, V> lowerEntry(K paramK) {
    return a(paramK, false).lastEntry();
  }
  
  public K lowerKey(K paramK) {
    return Maps.b(lowerEntry(paramK));
  }
  
  ImmutableSet<Map.Entry<K, V>> m() {
    class EntrySet extends ImmutableMapEntrySet<K, V> {
      EntrySet(ImmutableSortedMap this$0) {}
      
      public UnmodifiableIterator<Map.Entry<K, V>> av_() {
        return h().av_();
      }
      
      ImmutableMap<K, V> c() {
        return this.a;
      }
      
      ImmutableList<Map.Entry<K, V>> d() {
        return new ImmutableList<Map.Entry<K, V>>(this) {
            boolean a() {
              return true;
            }
            
            public Map.Entry<K, V> b(int param2Int) {
              return new AbstractMap.SimpleImmutableEntry<K, V>(ImmutableSortedMap.a(this.a.a).h().get(param2Int), ImmutableSortedMap.b(this.a.a).get(param2Int));
            }
            
            public int size() {
              return this.a.a.size();
            }
          };
      }
    };
    return isEmpty() ? ImmutableSet.j() : new EntrySet(this);
  }
  
  public ImmutableSortedSet<K> p() {
    return this.d.as_();
  }
  
  @Deprecated
  public final Map.Entry<K, V> pollFirstEntry() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final Map.Entry<K, V> pollLastEntry() {
    throw new UnsupportedOperationException();
  }
  
  public int size() {
    return this.e.size();
  }
  
  public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
    private transient Object[] e;
    
    private transient Object[] f;
    
    private final Comparator<? super K> g;
    
    private void a(int param1Int) {
      Object[] arrayOfObject = this.e;
      if (param1Int > arrayOfObject.length) {
        param1Int = ImmutableCollection.Builder.a(arrayOfObject.length, param1Int);
        this.e = Arrays.copyOf(this.e, param1Int);
        this.f = Arrays.copyOf(this.f, param1Int);
      } 
    }
    
    public Builder<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> param1Iterable) {
      super.b(param1Iterable);
      return this;
    }
    
    public Builder<K, V> a(K param1K, V param1V) {
      a(this.c + 1);
      CollectPreconditions.a(param1K, param1V);
      this.e[this.c] = param1K;
      this.f[this.c] = param1V;
      this.c++;
      return this;
    }
    
    public Builder<K, V> a(Map.Entry<? extends K, ? extends V> param1Entry) {
      super.b(param1Entry);
      return this;
    }
    
    public Builder<K, V> a(Map<? extends K, ? extends V> param1Map) {
      super.b(param1Map);
      return this;
    }
    
    public ImmutableSortedMap<K, V> a() {
      int i = this.c;
      if (i != 0) {
        int j = 0;
        if (i != 1) {
          Object[] arrayOfObject1 = Arrays.copyOf(this.e, this.c);
          Object[] arrayOfObject2 = arrayOfObject1;
          Arrays.sort(arrayOfObject2, (Comparator)this.g);
          Object[] arrayOfObject3 = new Object[this.c];
          while (j < this.c) {
            StringBuilder stringBuilder;
            if (j > 0) {
              Comparator<? super K> comparator = this.g;
              i = j - 1;
              if (comparator.compare((K)arrayOfObject1[i], (K)arrayOfObject1[j]) == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("keys required to be distinct but compared as equal: ");
                stringBuilder.append(arrayOfObject1[i]);
                stringBuilder.append(" and ");
                stringBuilder.append(arrayOfObject1[j]);
                throw new IllegalArgumentException(stringBuilder.toString());
              } 
            } 
            arrayOfObject3[Arrays.binarySearch((T[])stringBuilder, (T)this.e[j], this.g)] = this.f[j];
            j++;
          } 
          return new ImmutableSortedMap<K, V>(new RegularImmutableSortedSet<K>(ImmutableList.b(arrayOfObject1), this.g), ImmutableList.b(arrayOfObject3));
        } 
        return ImmutableSortedMap.a(this.g, this.e[0], this.f[0]);
      } 
      return ImmutableSortedMap.a(this.g);
    }
  }
  
  static class SerializedForm extends ImmutableMap.SerializedForm {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableSortedMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */