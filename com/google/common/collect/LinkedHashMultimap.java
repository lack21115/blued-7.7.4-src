package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
  transient int a;
  
  private transient ValueEntry<K, V> b;
  
  private static <K, V> void b(ValueEntry<K, V> paramValueEntry) {
    b(paramValueEntry.c(), paramValueEntry.d());
  }
  
  private static <K, V> void b(ValueEntry<K, V> paramValueEntry1, ValueEntry<K, V> paramValueEntry2) {
    paramValueEntry1.a(paramValueEntry2);
    paramValueEntry2.b(paramValueEntry1);
  }
  
  private static <K, V> void b(ValueSetLink<K, V> paramValueSetLink) {
    b(paramValueSetLink.a(), paramValueSetLink.b());
  }
  
  private static <K, V> void b(ValueSetLink<K, V> paramValueSetLink1, ValueSetLink<K, V> paramValueSetLink2) {
    paramValueSetLink1.b(paramValueSetLink2);
    paramValueSetLink2.a(paramValueSetLink1);
  }
  
  Set<V> a() {
    return Platform.d(this.a);
  }
  
  Collection<V> e(K paramK) {
    return new ValueSet(this, paramK, this.a);
  }
  
  public void g() {
    super.g();
    ValueEntry<K, V> valueEntry = this.b;
    b(valueEntry, valueEntry);
  }
  
  public Collection<V> j() {
    return super.j();
  }
  
  Iterator<V> l() {
    return Maps.b(o());
  }
  
  Iterator<Map.Entry<K, V>> o() {
    return new Iterator<Map.Entry<K, V>>(this) {
        LinkedHashMultimap.ValueEntry<K, V> a = (LinkedHashMultimap.a(this.c)).h;
        
        @NullableDecl
        LinkedHashMultimap.ValueEntry<K, V> b;
        
        public Map.Entry<K, V> a() {
          if (hasNext()) {
            LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.a;
            this.b = valueEntry;
            this.a = valueEntry.h;
            return valueEntry;
          } 
          throw new NoSuchElementException();
        }
        
        public boolean hasNext() {
          return (this.a != LinkedHashMultimap.a(this.c));
        }
        
        public void remove() {
          boolean bool;
          if (this.b != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.a(bool);
          this.c.c(this.b.getKey(), this.b.getValue());
          this.b = null;
        }
      };
  }
  
  public Set<K> s() {
    return super.s();
  }
  
  public Set<Map.Entry<K, V>> t() {
    return super.t();
  }
  
  static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {
    final int c;
    
    @NullableDecl
    ValueEntry<K, V> d;
    
    @NullableDecl
    LinkedHashMultimap.ValueSetLink<K, V> e;
    
    @NullableDecl
    LinkedHashMultimap.ValueSetLink<K, V> f;
    
    @NullableDecl
    ValueEntry<K, V> g;
    
    @NullableDecl
    ValueEntry<K, V> h;
    
    ValueEntry(@NullableDecl K param1K, @NullableDecl V param1V, int param1Int, @NullableDecl ValueEntry<K, V> param1ValueEntry) {
      super(param1K, param1V);
      this.c = param1Int;
      this.d = param1ValueEntry;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> a() {
      return this.e;
    }
    
    public void a(ValueEntry<K, V> param1ValueEntry) {
      this.h = param1ValueEntry;
    }
    
    public void a(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.e = param1ValueSetLink;
    }
    
    boolean a(@NullableDecl Object param1Object, int param1Int) {
      return (this.c == param1Int && Objects.a(getValue(), param1Object));
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> b() {
      return this.f;
    }
    
    public void b(ValueEntry<K, V> param1ValueEntry) {
      this.g = param1ValueEntry;
    }
    
    public void b(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.f = param1ValueSetLink;
    }
    
    public ValueEntry<K, V> c() {
      return this.g;
    }
    
    public ValueEntry<K, V> d() {
      return this.h;
    }
  }
  
  final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
    LinkedHashMultimap.ValueEntry<K, V>[] a;
    
    private final K c;
    
    private int d = 0;
    
    private int e = 0;
    
    private LinkedHashMultimap.ValueSetLink<K, V> f;
    
    private LinkedHashMultimap.ValueSetLink<K, V> g;
    
    ValueSet(LinkedHashMultimap this$0, K param1K, int param1Int) {
      this.c = param1K;
      this.f = this;
      this.g = this;
      this.a = (LinkedHashMultimap.ValueEntry<K, V>[])new LinkedHashMultimap.ValueEntry[Hashing.a(param1Int, 1.0D)];
    }
    
    private int c() {
      return this.a.length - 1;
    }
    
    private void d() {
      if (Hashing.a(this.d, this.a.length, 1.0D)) {
        LinkedHashMultimap.ValueEntry[] arrayOfValueEntry = new LinkedHashMultimap.ValueEntry[this.a.length * 2];
        this.a = (LinkedHashMultimap.ValueEntry<K, V>[])arrayOfValueEntry;
        int i = arrayOfValueEntry.length;
        for (LinkedHashMultimap.ValueSetLink<K, V> valueSetLink = this.f; valueSetLink != this; valueSetLink = valueSetLink.b()) {
          LinkedHashMultimap.ValueEntry valueEntry = (LinkedHashMultimap.ValueEntry)valueSetLink;
          int j = valueEntry.c & i - 1;
          valueEntry.d = arrayOfValueEntry[j];
          arrayOfValueEntry[j] = valueEntry;
        } 
      } 
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> a() {
      return this.g;
    }
    
    public void a(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.g = param1ValueSetLink;
    }
    
    public boolean add(@NullableDecl V param1V) {
      int i = Hashing.a(param1V);
      int j = c() & i;
      LinkedHashMultimap.ValueEntry<K, V> valueEntry3 = this.a[j];
      for (LinkedHashMultimap.ValueEntry<K, V> valueEntry2 = valueEntry3; valueEntry2 != null; valueEntry2 = valueEntry2.d) {
        if (valueEntry2.a(param1V, i))
          return false; 
      } 
      LinkedHashMultimap.ValueEntry<K, V> valueEntry1 = new LinkedHashMultimap.ValueEntry<K, V>(this.c, param1V, i, valueEntry3);
      LinkedHashMultimap.a(this.g, valueEntry1);
      LinkedHashMultimap.a(valueEntry1, this);
      LinkedHashMultimap.a(LinkedHashMultimap.a(this.b).c(), valueEntry1);
      LinkedHashMultimap.a(valueEntry1, LinkedHashMultimap.a(this.b));
      this.a[j] = valueEntry1;
      this.d++;
      this.e++;
      d();
      return true;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> b() {
      return this.f;
    }
    
    public void b(LinkedHashMultimap.ValueSetLink<K, V> param1ValueSetLink) {
      this.f = param1ValueSetLink;
    }
    
    public void clear() {
      Arrays.fill((Object[])this.a, (Object)null);
      this.d = 0;
      for (LinkedHashMultimap.ValueSetLink<K, V> valueSetLink = this.f; valueSetLink != this; valueSetLink = valueSetLink.b())
        LinkedHashMultimap.a((LinkedHashMultimap.ValueEntry)valueSetLink); 
      LinkedHashMultimap.a(this, this);
      this.e++;
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      int i = Hashing.a(param1Object);
      for (LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.a[c() & i]; valueEntry != null; valueEntry = valueEntry.d) {
        if (valueEntry.a(param1Object, i))
          return true; 
      } 
      return false;
    }
    
    public Iterator<V> iterator() {
      return new Iterator<V>(this) {
          LinkedHashMultimap.ValueSetLink<K, V> a = LinkedHashMultimap.ValueSet.a(this.d);
          
          @NullableDecl
          LinkedHashMultimap.ValueEntry<K, V> b;
          
          int c = LinkedHashMultimap.ValueSet.b(this.d);
          
          private void a() {
            if (LinkedHashMultimap.ValueSet.b(this.d) == this.c)
              return; 
            throw new ConcurrentModificationException();
          }
          
          public boolean hasNext() {
            a();
            return (this.a != this.d);
          }
          
          public V next() {
            if (hasNext()) {
              LinkedHashMultimap.ValueEntry<K, V> valueEntry = (LinkedHashMultimap.ValueEntry)this.a;
              Object object = valueEntry.getValue();
              this.b = valueEntry;
              this.a = valueEntry.b();
              return (V)object;
            } 
            throw new NoSuchElementException();
          }
          
          public void remove() {
            boolean bool;
            a();
            if (this.b != null) {
              bool = true;
            } else {
              bool = false;
            } 
            CollectPreconditions.a(bool);
            this.d.remove(this.b.getValue());
            this.c = LinkedHashMultimap.ValueSet.b(this.d);
            this.b = null;
          }
        };
    }
    
    public boolean remove(@NullableDecl Object param1Object) {
      int i = Hashing.a(param1Object);
      int j = c() & i;
      LinkedHashMultimap.ValueEntry<K, V> valueEntry1 = this.a[j];
      LinkedHashMultimap.ValueEntry<K, V> valueEntry2 = null;
      while (true) {
        LinkedHashMultimap.ValueEntry<K, V> valueEntry = valueEntry2;
        valueEntry2 = valueEntry1;
        if (valueEntry2 != null) {
          if (valueEntry2.a(param1Object, i)) {
            if (valueEntry == null) {
              this.a[j] = valueEntry2.d;
            } else {
              valueEntry.d = valueEntry2.d;
            } 
            LinkedHashMultimap.a(valueEntry2);
            LinkedHashMultimap.a(valueEntry2);
            this.d--;
            this.e++;
            return true;
          } 
          valueEntry1 = valueEntry2.d;
          continue;
        } 
        return false;
      } 
    }
    
    public int size() {
      return this.d;
    }
  }
  
  class null implements Iterator<V> {
    LinkedHashMultimap.ValueSetLink<K, V> a = LinkedHashMultimap.ValueSet.a(this.d);
    
    @NullableDecl
    LinkedHashMultimap.ValueEntry<K, V> b;
    
    int c = LinkedHashMultimap.ValueSet.b(this.d);
    
    null(LinkedHashMultimap this$0) {}
    
    private void a() {
      if (LinkedHashMultimap.ValueSet.b(this.d) == this.c)
        return; 
      throw new ConcurrentModificationException();
    }
    
    public boolean hasNext() {
      a();
      return (this.a != this.d);
    }
    
    public V next() {
      if (hasNext()) {
        LinkedHashMultimap.ValueEntry<K, V> valueEntry = (LinkedHashMultimap.ValueEntry)this.a;
        Object object = valueEntry.getValue();
        this.b = valueEntry;
        this.a = valueEntry.b();
        return (V)object;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      a();
      if (this.b != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      this.d.remove(this.b.getValue());
      this.c = LinkedHashMultimap.ValueSet.b(this.d);
      this.b = null;
    }
  }
  
  static interface ValueSetLink<K, V> {
    ValueSetLink<K, V> a();
    
    void a(ValueSetLink<K, V> param1ValueSetLink);
    
    ValueSetLink<K, V> b();
    
    void b(ValueSetLink<K, V> param1ValueSetLink);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\LinkedHashMultimap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */