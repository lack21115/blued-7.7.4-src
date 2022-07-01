package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
  @LazyInit
  private transient ImmutableList<E> a;
  
  @LazyInit
  private transient ImmutableSet<Multiset.Entry<E>> b;
  
  public static <E> ImmutableMultiset<E> a(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof ImmutableMultiset) {
      ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset)paramIterable;
      if (!immutableMultiset.a())
        return immutableMultiset; 
    } 
    Builder<E> builder = new Builder(Multisets.a(paramIterable));
    builder.b(paramIterable);
    return builder.a();
  }
  
  private ImmutableSet<Multiset.Entry<E>> c() {
    return isEmpty() ? ImmutableSet.j() : new EntrySet();
  }
  
  public static <E> ImmutableMultiset<E> g() {
    return RegularImmutableMultiset.a;
  }
  
  @Deprecated
  public final int a(E paramE, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    UnmodifiableIterator<Multiset.Entry<E>> unmodifiableIterator = i().av_();
    while (unmodifiableIterator.hasNext()) {
      Multiset.Entry entry = unmodifiableIterator.next();
      Arrays.fill(paramArrayOfObject, paramInt, entry.b() + paramInt, entry.c());
      paramInt += entry.b();
    } 
    return paramInt;
  }
  
  abstract Multiset.Entry<E> a(int paramInt);
  
  @Deprecated
  public final boolean a(E paramE, int paramInt1, int paramInt2) {
    throw new UnsupportedOperationException();
  }
  
  public UnmodifiableIterator<E> av_() {
    return new UnmodifiableIterator<E>(this, i().av_()) {
        int a;
        
        @NullableDecl
        E b;
        
        public boolean hasNext() {
          return (this.a > 0 || this.c.hasNext());
        }
        
        public E next() {
          if (this.a <= 0) {
            Multiset.Entry<E> entry = this.c.next();
            this.b = entry.c();
            this.a = entry.b();
          } 
          this.a--;
          return this.b;
        }
      };
  }
  
  @Deprecated
  public final int b(Object paramObject, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final int c(E paramE, int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return (a(paramObject) > 0);
  }
  
  public abstract ImmutableSet<E> e();
  
  public boolean equals(@NullableDecl Object paramObject) {
    return Multisets.a(this, paramObject);
  }
  
  public ImmutableList<E> h() {
    ImmutableList<E> immutableList2 = this.a;
    ImmutableList<E> immutableList1 = immutableList2;
    if (immutableList2 == null) {
      immutableList1 = super.h();
      this.a = immutableList1;
    } 
    return immutableList1;
  }
  
  public int hashCode() {
    return Sets.a(i());
  }
  
  public ImmutableSet<Multiset.Entry<E>> i() {
    ImmutableSet<Multiset.Entry<E>> immutableSet2 = this.b;
    ImmutableSet<Multiset.Entry<E>> immutableSet1 = immutableSet2;
    if (immutableSet2 == null) {
      immutableSet1 = c();
      this.b = immutableSet1;
    } 
    return immutableSet1;
  }
  
  public String toString() {
    return i().toString();
  }
  
  public static class Builder<E> extends ImmutableCollection.Builder<E> {
    ObjectCountHashMap<E> a;
    
    boolean b = false;
    
    boolean c = false;
    
    public Builder() {
      this(4);
    }
    
    Builder(int param1Int) {
      this.a = ObjectCountHashMap.a(param1Int);
    }
    
    @NullableDecl
    static <T> ObjectCountHashMap<T> c(Iterable<T> param1Iterable) {
      return (param1Iterable instanceof RegularImmutableMultiset) ? ((RegularImmutableMultiset)param1Iterable).b : ((param1Iterable instanceof AbstractMapBasedMultiset) ? ((AbstractMapBasedMultiset)param1Iterable).a : null);
    }
    
    public Builder<E> a(E param1E) {
      return a(param1E, 1);
    }
    
    public Builder<E> a(E param1E, int param1Int) {
      if (param1Int == 0)
        return this; 
      if (this.b) {
        this.a = new ObjectCountHashMap<E>(this.a);
        this.c = false;
      } 
      this.b = false;
      Preconditions.a(param1E);
      ObjectCountHashMap<E> objectCountHashMap = this.a;
      objectCountHashMap.a(param1E, param1Int + objectCountHashMap.b(param1E));
      return this;
    }
    
    public ImmutableMultiset<E> a() {
      if (this.a.c() == 0)
        return ImmutableMultiset.g(); 
      if (this.c) {
        this.a = new ObjectCountHashMap<E>(this.a);
        this.c = false;
      } 
      this.b = true;
      return new RegularImmutableMultiset<E>(this.a);
    }
    
    public Builder<E> b(Iterable<? extends E> param1Iterable) {
      if (param1Iterable instanceof Multiset) {
        ObjectCountHashMap<E> objectCountHashMap;
        param1Iterable = Multisets.b(param1Iterable);
        ObjectCountHashMap<? extends E> objectCountHashMap1 = c(param1Iterable);
        if (objectCountHashMap1 != null) {
          objectCountHashMap = this.a;
          objectCountHashMap.f(Math.max(objectCountHashMap.c(), objectCountHashMap1.c()));
          for (int i = objectCountHashMap1.b(); i >= 0; i = objectCountHashMap1.b(i))
            a(objectCountHashMap1.c(i), objectCountHashMap1.d(i)); 
        } else {
          Set<Multiset.Entry<E>> set = objectCountHashMap.f();
          ObjectCountHashMap<E> objectCountHashMap2 = this.a;
          objectCountHashMap2.f(Math.max(objectCountHashMap2.c(), set.size()));
          for (Multiset.Entry<E> entry : objectCountHashMap.f())
            a(entry.c(), entry.b()); 
        } 
      } else {
        super.a(param1Iterable);
      } 
      return this;
    }
    
    public Builder<E> b(Iterator<? extends E> param1Iterator) {
      super.a(param1Iterator);
      return this;
    }
  }
  
  final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
    private EntrySet(ImmutableMultiset this$0) {}
    
    boolean a() {
      return this.a.a();
    }
    
    Multiset.Entry<E> b(int param1Int) {
      return this.a.a(param1Int);
    }
    
    public boolean contains(Object param1Object) {
      boolean bool = param1Object instanceof Multiset.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        if (param1Object.b() <= 0)
          return false; 
        bool1 = bool2;
        if (this.a.a(param1Object.c()) == param1Object.b())
          bool1 = true; 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public int size() {
      return this.a.e().size();
    }
  }
  
  static class EntrySetSerializedForm<E> implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */