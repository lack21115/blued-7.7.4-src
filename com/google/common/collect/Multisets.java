package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Multisets {
  static <E> int a(Multiset<E> paramMultiset, E paramE, int paramInt) {
    CollectPreconditions.a(paramInt, "count");
    int i = paramMultiset.a(paramE);
    paramInt -= i;
    if (paramInt > 0) {
      paramMultiset.a(paramE, paramInt);
      return i;
    } 
    if (paramInt < 0)
      paramMultiset.b(paramE, -paramInt); 
    return i;
  }
  
  static int a(Iterable<?> paramIterable) {
    return (paramIterable instanceof Multiset) ? ((Multiset)paramIterable).d().size() : 11;
  }
  
  public static <E> Multiset.Entry<E> a(@NullableDecl E paramE, int paramInt) {
    return new ImmutableEntry<E>(paramE, paramInt);
  }
  
  public static <E> SortedMultiset<E> a(SortedMultiset<E> paramSortedMultiset) {
    return new UnmodifiableSortedMultiset<E>((SortedMultiset<E>)Preconditions.a(paramSortedMultiset));
  }
  
  static <E> Iterator<E> a(Multiset<E> paramMultiset) {
    return new MultisetIteratorImpl<E>(paramMultiset, paramMultiset.f().iterator());
  }
  
  static <E> Iterator<E> a(Iterator<Multiset.Entry<E>> paramIterator) {
    return new TransformedIterator<Multiset.Entry<E>, E>(paramIterator) {
        E a(Multiset.Entry<E> param1Entry) {
          return param1Entry.c();
        }
      };
  }
  
  private static <E> boolean a(Multiset<E> paramMultiset, AbstractMapBasedMultiset<? extends E> paramAbstractMapBasedMultiset) {
    if (paramAbstractMapBasedMultiset.isEmpty())
      return false; 
    paramAbstractMapBasedMultiset.a(paramMultiset);
    return true;
  }
  
  private static <E> boolean a(Multiset<E> paramMultiset, Multiset<? extends E> paramMultiset1) {
    if (paramMultiset1 instanceof AbstractMapBasedMultiset)
      return a(paramMultiset, (AbstractMapBasedMultiset<? extends E>)paramMultiset1); 
    if (paramMultiset1.isEmpty())
      return false; 
    for (Multiset.Entry<E> entry : paramMultiset1.f())
      paramMultiset.a(entry.c(), entry.b()); 
    return true;
  }
  
  static boolean a(Multiset<?> paramMultiset, @NullableDecl Object paramObject) {
    if (paramObject == paramMultiset)
      return true; 
    if (paramObject instanceof Multiset) {
      paramObject = paramObject;
      if (paramMultiset.size() == paramObject.size()) {
        if (paramMultiset.f().size() != paramObject.f().size())
          return false; 
        paramObject = paramObject.f().iterator();
        while (paramObject.hasNext()) {
          Multiset.Entry entry = paramObject.next();
          if (paramMultiset.a(entry.c()) != entry.b())
            return false; 
        } 
        return true;
      } 
    } 
    return false;
  }
  
  static <E> boolean a(Multiset<E> paramMultiset, E paramE, int paramInt1, int paramInt2) {
    CollectPreconditions.a(paramInt1, "oldCount");
    CollectPreconditions.a(paramInt2, "newCount");
    if (paramMultiset.a(paramE) == paramInt1) {
      paramMultiset.c(paramE, paramInt2);
      return true;
    } 
    return false;
  }
  
  static <E> boolean a(Multiset<E> paramMultiset, Collection<? extends E> paramCollection) {
    Preconditions.a(paramMultiset);
    Preconditions.a(paramCollection);
    return (paramCollection instanceof Multiset) ? a(paramMultiset, b(paramCollection)) : (paramCollection.isEmpty() ? false : Iterators.a(paramMultiset, paramCollection.iterator()));
  }
  
  static int b(Multiset<?> paramMultiset) {
    Iterator<Multiset.Entry> iterator = paramMultiset.f().iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += ((Multiset.Entry)iterator.next()).b());
    return Ints.b(l);
  }
  
  static <T> Multiset<T> b(Iterable<T> paramIterable) {
    return (Multiset<T>)paramIterable;
  }
  
  static boolean b(Multiset<?> paramMultiset, Collection<?> paramCollection) {
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).d(); 
    return paramMultiset.d().removeAll(collection);
  }
  
  static boolean c(Multiset<?> paramMultiset, Collection<?> paramCollection) {
    Preconditions.a(paramCollection);
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).d(); 
    return paramMultiset.d().retainAll(collection);
  }
  
  static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof Multiset.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (b() == param1Object.b()) {
          bool1 = bool2;
          if (Objects.a(c(), param1Object.c()))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      int i;
      E e = c();
      if (e == null) {
        i = 0;
      } else {
        i = e.hashCode();
      } 
      return i ^ b();
    }
    
    public String toString() {
      String str = String.valueOf(c());
      int i = b();
      if (i == 1)
        return str; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(" x ");
      stringBuilder.append(i);
      return stringBuilder.toString();
    }
  }
  
  static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {
    static final DecreasingCount a = new DecreasingCount();
    
    public int a(Multiset.Entry<?> param1Entry1, Multiset.Entry<?> param1Entry2) {
      return param1Entry2.b() - param1Entry1.b();
    }
  }
  
  static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
    abstract Multiset<E> a();
    
    public void clear() {
      a().clear();
    }
    
    public boolean contains(Object param1Object) {
      return a().contains(param1Object);
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return a().containsAll(param1Collection);
    }
    
    public boolean isEmpty() {
      return a().isEmpty();
    }
    
    public boolean remove(Object param1Object) {
      return (a().b(param1Object, 2147483647) > 0);
    }
    
    public int size() {
      return a().f().size();
    }
  }
  
  static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
    abstract Multiset<E> a();
    
    public void clear() {
      a().clear();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof Multiset.Entry;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        if (param1Object.b() <= 0)
          return false; 
        bool1 = bool2;
        if (a().a(param1Object.c()) == param1Object.b())
          bool1 = true; 
      } 
      return bool1;
    }
    
    public boolean remove(Object param1Object) {
      if (param1Object instanceof Multiset.Entry) {
        param1Object = param1Object;
        E e = (E)param1Object.c();
        int i = param1Object.b();
        if (i != 0)
          return a().a(e, i, 0); 
      } 
      return false;
    }
  }
  
  static final class FilteredMultiset<E> extends ViewMultiset<E> {
    final Multiset<E> a;
    
    final Predicate<? super E> b;
    
    public int a(@NullableDecl Object param1Object) {
      int i = this.a.a(param1Object);
      return (i > 0) ? (this.b.a(param1Object) ? i : 0) : 0;
    }
    
    public int a(@NullableDecl E param1E, int param1Int) {
      Preconditions.a(this.b.a(param1E), "Element %s does not match predicate %s", param1E, this.b);
      return this.a.a(param1E, param1Int);
    }
    
    Iterator<E> a() {
      throw new AssertionError("should never be called");
    }
    
    public int b(@NullableDecl Object param1Object, int param1Int) {
      CollectPreconditions.a(param1Int, "occurrences");
      return (param1Int == 0) ? a(param1Object) : (contains(param1Object) ? this.a.b(param1Object, param1Int) : 0);
    }
    
    Iterator<Multiset.Entry<E>> b() {
      throw new AssertionError("should never be called");
    }
    
    Set<E> e() {
      return Sets.a(this.a.d(), this.b);
    }
    
    Set<Multiset.Entry<E>> g() {
      return Sets.a(this.a.f(), new Predicate<Multiset.Entry<E>>(this) {
            public boolean a(Multiset.Entry<E> param2Entry) {
              return this.a.b.a(param2Entry.c());
            }
          });
    }
    
    public UnmodifiableIterator<E> h() {
      return Iterators.b(this.a.iterator(), this.b);
    }
  }
  
  class null implements Predicate<Multiset.Entry<E>> {
    null(Multisets this$0) {}
    
    public boolean a(Multiset.Entry<E> param1Entry) {
      return this.a.b.a(param1Entry.c());
    }
  }
  
  static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
    @NullableDecl
    private final E a;
    
    private final int b;
    
    ImmutableEntry(@NullableDecl E param1E, int param1Int) {
      this.a = param1E;
      this.b = param1Int;
      CollectPreconditions.a(param1Int, "count");
    }
    
    public final int b() {
      return this.b;
    }
    
    @NullableDecl
    public final E c() {
      return this.a;
    }
  }
  
  static final class MultisetIteratorImpl<E> implements Iterator<E> {
    private final Multiset<E> a;
    
    private final Iterator<Multiset.Entry<E>> b;
    
    @NullableDecl
    private Multiset.Entry<E> c;
    
    private int d;
    
    private int e;
    
    private boolean f;
    
    MultisetIteratorImpl(Multiset<E> param1Multiset, Iterator<Multiset.Entry<E>> param1Iterator) {
      this.a = param1Multiset;
      this.b = param1Iterator;
    }
    
    public boolean hasNext() {
      return (this.d > 0 || this.b.hasNext());
    }
    
    public E next() {
      if (hasNext()) {
        if (this.d == 0) {
          this.c = this.b.next();
          int i = this.c.b();
          this.d = i;
          this.e = i;
        } 
        this.d--;
        this.f = true;
        return this.c.c();
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      CollectPreconditions.a(this.f);
      if (this.e == 1) {
        this.b.remove();
      } else {
        this.a.remove(this.c.c());
      } 
      this.e--;
      this.f = false;
    }
  }
  
  static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
    final Multiset<? extends E> a;
    
    @NullableDecl
    transient Set<E> b;
    
    @NullableDecl
    transient Set<Multiset.Entry<E>> c;
    
    UnmodifiableMultiset(Multiset<? extends E> param1Multiset) {
      this.a = param1Multiset;
    }
    
    public int a(E param1E, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    Set<E> a() {
      return Collections.unmodifiableSet(this.a.d());
    }
    
    public boolean a(E param1E, int param1Int1, int param1Int2) {
      throw new UnsupportedOperationException();
    }
    
    public boolean add(E param1E) {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public int b(Object param1Object, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public int c(E param1E, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public void clear() {
      throw new UnsupportedOperationException();
    }
    
    public Set<E> d() {
      Set<E> set2 = this.b;
      Set<E> set1 = set2;
      if (set2 == null) {
        set1 = a();
        this.b = set1;
      } 
      return set1;
    }
    
    public Set<Multiset.Entry<E>> f() {
      Set<Multiset.Entry<E>> set2 = this.c;
      Set<Multiset.Entry<E>> set1 = set2;
      if (set2 == null) {
        set1 = Collections.unmodifiableSet((Set)this.a.f());
        this.c = set1;
      } 
      return set1;
    }
    
    protected Multiset<E> g() {
      return (Multiset)this.a;
    }
    
    public Iterator<E> iterator() {
      return Iterators.a(this.a.iterator());
    }
    
    public boolean remove(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
  }
  
  static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
    int c() {
      return d().size();
    }
    
    public void clear() {
      d().clear();
    }
    
    public Iterator<E> iterator() {
      return Multisets.a(this);
    }
    
    public int size() {
      return Multisets.b(this);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Multisets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */