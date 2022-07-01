package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class MultimapBuilder<K0, V0> {
  private MultimapBuilder() {}
  
  public static MultimapBuilderWithKeys<Object> a() {
    return a(8);
  }
  
  public static MultimapBuilderWithKeys<Object> a(int paramInt) {
    CollectPreconditions.a(paramInt, "expectedKeys");
    return new MultimapBuilderWithKeys(paramInt) {
        <K, V> Map<K, Collection<V>> a() {
          return Platform.a(this.a);
        }
      };
  }
  
  static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
    private final int a;
    
    public List<V> a() {
      return new ArrayList<V>(this.a);
    }
  }
  
  static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
    private final Class<V> a;
    
    EnumSetSupplier(Class<V> param1Class) {
      this.a = (Class<V>)Preconditions.a(param1Class);
    }
    
    public Set<V> a() {
      return EnumSet.noneOf(this.a);
    }
  }
  
  static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
    private final int a;
    
    HashSetSupplier(int param1Int) {
      this.a = CollectPreconditions.a(param1Int, "expectedValuesPerKey");
    }
    
    public Set<V> a() {
      return Platform.c(this.a);
    }
  }
  
  static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
    private final int a;
    
    LinkedHashSetSupplier(int param1Int) {
      this.a = CollectPreconditions.a(param1Int, "expectedValuesPerKey");
    }
    
    public Set<V> a() {
      return Platform.d(this.a);
    }
  }
  
  enum LinkedListSupplier implements Supplier<List<Object>> {
    a;
    
    public List<Object> a() {
      return new LinkedList();
    }
  }
  
  public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {}
  
  public static abstract class MultimapBuilderWithKeys<K0> {
    public MultimapBuilder.SetMultimapBuilder<K0, Object> a(int param1Int) {
      CollectPreconditions.a(param1Int, "expectedValuesPerKey");
      return new MultimapBuilder.SetMultimapBuilder<K0, Object>(this, param1Int) {
          public <K extends K0, V> SetMultimap<K, V> b() {
            return Multimaps.a(this.b.a(), new MultimapBuilder.LinkedHashSetSupplier(this.a));
          }
        };
    }
    
    abstract <K extends K0, V> Map<K, Collection<V>> a();
    
    public MultimapBuilder.SetMultimapBuilder<K0, Object> b() {
      return a(2);
    }
  }
  
  class null extends ListMultimapBuilder<K0, Object> {}
  
  class null extends ListMultimapBuilder<K0, Object> {}
  
  class null extends SetMultimapBuilder<K0, Object> {
    public <K extends K0, V> SetMultimap<K, V> b() {
      return Multimaps.a(this.b.a(), new MultimapBuilder.HashSetSupplier(this.a));
    }
  }
  
  class null extends SetMultimapBuilder<K0, Object> {
    null(MultimapBuilder this$0, int param1Int) {}
    
    public <K extends K0, V> SetMultimap<K, V> b() {
      return Multimaps.a(this.b.a(), new MultimapBuilder.LinkedHashSetSupplier(this.a));
    }
  }
  
  class null extends SortedSetMultimapBuilder<K0, V0> {
    public <K extends K0, V extends V0> SortedSetMultimap<K, V> c() {
      return Multimaps.b(this.b.a(), new MultimapBuilder.TreeSetSupplier(this.a));
    }
  }
  
  class null extends SetMultimapBuilder<K0, V0> {
    public <K extends K0, V extends V0> SetMultimap<K, V> b() {
      MultimapBuilder.EnumSetSupplier<Enum> enumSetSupplier = new MultimapBuilder.EnumSetSupplier<Enum>(this.a);
      return Multimaps.a(this.b.a(), (Supplier)enumSetSupplier);
    }
  }
  
  public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
    public abstract <K extends K0, V extends V0> SetMultimap<K, V> b();
  }
  
  public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
    public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> c();
  }
  
  static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
    private final Comparator<? super V> a;
    
    TreeSetSupplier(Comparator<? super V> param1Comparator) {
      this.a = (Comparator<? super V>)Preconditions.a(param1Comparator);
    }
    
    public SortedSet<V> a() {
      return new TreeSet<V>(this.a);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\MultimapBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */