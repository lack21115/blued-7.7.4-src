package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
  private final transient ConcurrentMap<E, AtomicInteger> a;
  
  private List<E> h() {
    ArrayList<?> arrayList = Lists.c(size());
    for (Multiset.Entry<Object> entry : (Iterable<Multiset.Entry<Object>>)f()) {
      Object object = entry.c();
      for (int i = entry.b(); i > 0; i--)
        arrayList.add(object); 
    } 
    return (List)arrayList;
  }
  
  public int a(@NullableDecl Object paramObject) {
    paramObject = Maps.<AtomicInteger>a(this.a, paramObject);
    return (paramObject == null) ? 0 : paramObject.get();
  }
  
  public int a(E paramE, int paramInt) {
    Preconditions.a(paramE);
    if (paramInt == 0)
      return a(paramE); 
    CollectPreconditions.b(paramInt, "occurences");
    label25: while (true) {
      AtomicInteger atomicInteger2 = Maps.<AtomicInteger>a(this.a, paramE);
      AtomicInteger atomicInteger1 = atomicInteger2;
      if (atomicInteger2 == null) {
        atomicInteger2 = this.a.putIfAbsent(paramE, new AtomicInteger(paramInt));
        atomicInteger1 = atomicInteger2;
        if (atomicInteger2 == null)
          return 0; 
      } 
      while (true) {
        StringBuilder stringBuilder;
        int i = atomicInteger1.get();
        if (i != 0) {
          try {
            boolean bool = atomicInteger1.compareAndSet(i, IntMath.b(i, paramInt));
            if (bool)
              return i; 
          } catch (ArithmeticException arithmeticException) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Overflow adding ");
            stringBuilder.append(paramInt);
            stringBuilder.append(" occurrences to a count of ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
          } 
          continue;
        } 
        atomicInteger2 = new AtomicInteger(paramInt);
        if (this.a.putIfAbsent((E)stringBuilder, atomicInteger2) == null || this.a.replace((E)stringBuilder, atomicInteger1, atomicInteger2))
          return 0; 
        continue label25;
      } 
      break;
    } 
  }
  
  Iterator<E> a() {
    throw new AssertionError("should never be called");
  }
  
  public boolean a(E paramE, int paramInt1, int paramInt2) {
    Preconditions.a(paramE);
    CollectPreconditions.a(paramInt1, "oldCount");
    CollectPreconditions.a(paramInt2, "newCount");
    AtomicInteger atomicInteger = Maps.<AtomicInteger>a(this.a, paramE);
    boolean bool = false;
    null = false;
    if (atomicInteger == null) {
      if (paramInt1 != 0)
        return false; 
      if (paramInt2 == 0)
        return true; 
      if (this.a.putIfAbsent(paramE, new AtomicInteger(paramInt2)) == null)
        null = true; 
      return null;
    } 
    int i = atomicInteger.get();
    if (i == paramInt1) {
      if (i == 0) {
        if (paramInt2 == 0) {
          this.a.remove(paramE, atomicInteger);
          return true;
        } 
        AtomicInteger atomicInteger1 = new AtomicInteger(paramInt2);
        if (this.a.putIfAbsent(paramE, atomicInteger1) != null) {
          null = bool;
          return this.a.replace(paramE, atomicInteger, atomicInteger1) ? true : null;
        } 
      } else {
        if (atomicInteger.compareAndSet(i, paramInt2)) {
          if (paramInt2 == 0)
            this.a.remove(paramE, atomicInteger); 
          return true;
        } 
        return false;
      } 
    } else {
      return false;
    } 
    return true;
  }
  
  public int b(@NullableDecl Object paramObject, int paramInt) {
    if (paramInt == 0)
      return a(paramObject); 
    CollectPreconditions.b(paramInt, "occurences");
    AtomicInteger atomicInteger = Maps.<AtomicInteger>a(this.a, paramObject);
    if (atomicInteger == null)
      return 0; 
    while (true) {
      int i = atomicInteger.get();
      if (i != 0) {
        int j = Math.max(0, i - paramInt);
        if (atomicInteger.compareAndSet(i, j)) {
          if (j == 0)
            this.a.remove(paramObject, atomicInteger); 
          return i;
        } 
        continue;
      } 
      return 0;
    } 
  }
  
  Iterator<Multiset.Entry<E>> b() {
    return new ForwardingIterator<Multiset.Entry<E>>(this, new AbstractIterator<Multiset.Entry<E>>(this) {
          private final Iterator<Map.Entry<E, AtomicInteger>> b = ConcurrentHashMultiset.a(this.a).entrySet().iterator();
          
          protected Multiset.Entry<E> c() {
            while (true) {
              if (!this.b.hasNext())
                return b(); 
              Map.Entry entry = this.b.next();
              int i = ((AtomicInteger)entry.getValue()).get();
              if (i != 0)
                return Multisets.a((E)entry.getKey(), i); 
            } 
          }
        }) {
        @NullableDecl
        private Multiset.Entry<E> c;
        
        protected Iterator<Multiset.Entry<E>> a() {
          return this.a;
        }
        
        public Multiset.Entry<E> c() {
          this.c = super.next();
          return this.c;
        }
        
        public void remove() {
          boolean bool;
          if (this.c != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.a(bool);
          this.b.c(this.c.c(), 0);
          this.c = null;
        }
      };
  }
  
  int c() {
    return this.a.size();
  }
  
  public int c(E paramE, int paramInt) {
    Preconditions.a(paramE);
    CollectPreconditions.a(paramInt, "count");
    label23: while (true) {
      AtomicInteger atomicInteger2 = Maps.<AtomicInteger>a(this.a, paramE);
      AtomicInteger atomicInteger1 = atomicInteger2;
      if (atomicInteger2 == null) {
        if (paramInt == 0)
          return 0; 
        atomicInteger2 = this.a.putIfAbsent(paramE, new AtomicInteger(paramInt));
        atomicInteger1 = atomicInteger2;
        if (atomicInteger2 == null)
          return 0; 
      } 
      while (true) {
        int i = atomicInteger1.get();
        if (i == 0) {
          if (paramInt == 0)
            return 0; 
          atomicInteger2 = new AtomicInteger(paramInt);
          if (this.a.putIfAbsent(paramE, atomicInteger2) == null || this.a.replace(paramE, atomicInteger1, atomicInteger2))
            return 0; 
          continue label23;
        } 
        if (atomicInteger1.compareAndSet(i, paramInt)) {
          if (paramInt == 0)
            this.a.remove(paramE, atomicInteger1); 
          return i;
        } 
      } 
      break;
    } 
  }
  
  public void clear() {
    this.a.clear();
  }
  
  Set<E> e() {
    return new ForwardingSet<E>(this, this.a.keySet()) {
        protected Set<E> a() {
          return this.a;
        }
        
        public boolean contains(@NullableDecl Object param1Object) {
          return (param1Object != null && Collections2.a(this.a, param1Object));
        }
        
        public boolean containsAll(Collection<?> param1Collection) {
          return a(param1Collection);
        }
        
        public boolean remove(Object param1Object) {
          return (param1Object != null && Collections2.b(this.a, param1Object));
        }
        
        public boolean removeAll(Collection<?> param1Collection) {
          return c(param1Collection);
        }
      };
  }
  
  @Deprecated
  public Set<Multiset.Entry<E>> g() {
    return new EntrySet();
  }
  
  public boolean isEmpty() {
    return this.a.isEmpty();
  }
  
  public Iterator<E> iterator() {
    return Multisets.a(this);
  }
  
  public int size() {
    Iterator<AtomicInteger> iterator = this.a.values().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += ((AtomicInteger)iterator.next()).get());
    return Ints.b(l);
  }
  
  public Object[] toArray() {
    return h().toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    return h().toArray(paramArrayOfT);
  }
  
  class EntrySet extends AbstractMultiset<E>.EntrySet {
    private EntrySet(ConcurrentHashMultiset this$0) {}
    
    private List<Multiset.Entry<E>> c() {
      ArrayList<?> arrayList = Lists.c(size());
      Iterators.a(arrayList, iterator());
      return (List)arrayList;
    }
    
    ConcurrentHashMultiset<E> b() {
      return this.b;
    }
    
    public Object[] toArray() {
      return c().toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return c().toArray(param1ArrayOfT);
    }
  }
  
  static class FieldSettersHolder {
    static final Serialization.FieldSetter<ConcurrentHashMultiset> a = Serialization.a(ConcurrentHashMultiset.class, "countMap");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ConcurrentHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */