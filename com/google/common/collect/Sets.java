package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Sets {
  static int a(Set<?> paramSet) {
    Iterator<?> iterator = paramSet.iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += b) {
      byte b;
      Object object = iterator.next();
      if (object != null) {
        b = object.hashCode();
      } else {
        b = 0;
      } 
    } 
    return i;
  }
  
  public static <E> SetView<E> a(Set<? extends E> paramSet1, Set<? extends E> paramSet2) {
    Preconditions.a(paramSet1, "set1");
    Preconditions.a(paramSet2, "set2");
    return new SetView<E>(paramSet1, paramSet2) {
        public UnmodifiableIterator<E> a() {
          return new AbstractIterator(this) {
              final Iterator<? extends E> a = this.c.a.iterator();
              
              final Iterator<? extends E> b = this.c.b.iterator();
              
              protected E a() {
                if (this.a.hasNext())
                  return this.a.next(); 
                while (this.b.hasNext()) {
                  E e = this.b.next();
                  if (!this.c.a.contains(e))
                    return e; 
                } 
                return b();
              }
            };
        }
        
        public boolean contains(Object param1Object) {
          return (this.a.contains(param1Object) || this.b.contains(param1Object));
        }
        
        public boolean isEmpty() {
          return (this.a.isEmpty() && this.b.isEmpty());
        }
        
        public int size() {
          int i = this.a.size();
          for (Object object : this.b) {
            if (!this.a.contains(object))
              i++; 
          } 
          return i;
        }
      };
  }
  
  public static <E> HashSet<E> a() {
    return new HashSet<E>();
  }
  
  public static <E> HashSet<E> a(int paramInt) {
    return new HashSet<E>(Maps.a(paramInt));
  }
  
  public static <E> LinkedHashSet<E> a(Iterable<? extends E> paramIterable) {
    if (paramIterable instanceof Collection)
      return new LinkedHashSet<E>(Collections2.a(paramIterable)); 
    LinkedHashSet<?> linkedHashSet = c();
    Iterables.a(linkedHashSet, paramIterable);
    return (LinkedHashSet)linkedHashSet;
  }
  
  public static <E> NavigableSet<E> a(NavigableSet<E> paramNavigableSet) {
    return !(paramNavigableSet instanceof ImmutableCollection) ? ((paramNavigableSet instanceof UnmodifiableNavigableSet) ? paramNavigableSet : new UnmodifiableNavigableSet<E>(paramNavigableSet)) : paramNavigableSet;
  }
  
  public static <E> NavigableSet<E> a(NavigableSet<E> paramNavigableSet, Predicate<? super E> paramPredicate) {
    FilteredSet filteredSet;
    if (paramNavigableSet instanceof FilteredSet) {
      filteredSet = (FilteredSet)paramNavigableSet;
      paramPredicate = Predicates.a(filteredSet.b, paramPredicate);
      return new FilteredNavigableSet<E>((NavigableSet<E>)filteredSet.a, paramPredicate);
    } 
    return new FilteredNavigableSet<E>((NavigableSet<E>)Preconditions.a(filteredSet), (Predicate<? super E>)Preconditions.a(paramPredicate));
  }
  
  public static <E> Set<E> a(Set<E> paramSet, Predicate<? super E> paramPredicate) {
    if (paramSet instanceof SortedSet)
      return a((SortedSet<E>)paramSet, paramPredicate); 
    if (paramSet instanceof FilteredSet) {
      paramSet = paramSet;
      paramPredicate = Predicates.a(((FilteredSet)paramSet).b, paramPredicate);
      return new FilteredSet<E>((Set<E>)((FilteredSet)paramSet).a, paramPredicate);
    } 
    return new FilteredSet<E>((Set<E>)Preconditions.a(paramSet), (Predicate<? super E>)Preconditions.a(paramPredicate));
  }
  
  public static <E> SortedSet<E> a(SortedSet<E> paramSortedSet, Predicate<? super E> paramPredicate) {
    FilteredSet filteredSet;
    if (paramSortedSet instanceof FilteredSet) {
      filteredSet = (FilteredSet)paramSortedSet;
      paramPredicate = Predicates.a(filteredSet.b, paramPredicate);
      return new FilteredSortedSet<E>((SortedSet<E>)filteredSet.a, paramPredicate);
    } 
    return new FilteredSortedSet<E>((SortedSet<E>)Preconditions.a(filteredSet), (Predicate<? super E>)Preconditions.a(paramPredicate));
  }
  
  static boolean a(Set<?> paramSet, @NullableDecl Object paramObject) {
    if (paramSet == paramObject)
      return true; 
    if (paramObject instanceof Set) {
      paramObject = paramObject;
      try {
        if (paramSet.size() == paramObject.size()) {
          boolean bool = paramSet.containsAll((Collection<?>)paramObject);
          if (bool)
            return true; 
        } 
        return false;
      } catch (NullPointerException|ClassCastException nullPointerException) {
        return false;
      } 
    } 
    return false;
  }
  
  static boolean a(Set<?> paramSet, Collection<?> paramCollection) {
    Preconditions.a(paramCollection);
    Collection<?> collection = paramCollection;
    if (paramCollection instanceof Multiset)
      collection = ((Multiset)paramCollection).d(); 
    return (collection instanceof Set && collection.size() > paramSet.size()) ? Iterators.a(paramSet.iterator(), collection) : a(paramSet, collection.iterator());
  }
  
  static boolean a(Set<?> paramSet, Iterator<?> paramIterator) {
    boolean bool;
    for (bool = false; paramIterator.hasNext(); bool |= paramSet.remove(paramIterator.next()));
    return bool;
  }
  
  public static <E> SetView<E> b(Set<E> paramSet, Set<?> paramSet1) {
    Preconditions.a(paramSet, "set1");
    Preconditions.a(paramSet1, "set2");
    return new SetView<E>(paramSet, paramSet1) {
        public UnmodifiableIterator<E> a() {
          return new AbstractIterator(this) {
              final Iterator<E> a = this.b.a.iterator();
              
              protected E a() {
                while (this.a.hasNext()) {
                  E e = this.a.next();
                  if (this.b.b.contains(e))
                    return e; 
                } 
                return b();
              }
            };
        }
        
        public boolean contains(Object param1Object) {
          return (this.a.contains(param1Object) && this.b.contains(param1Object));
        }
        
        public boolean containsAll(Collection<?> param1Collection) {
          return (this.a.containsAll(param1Collection) && this.b.containsAll(param1Collection));
        }
        
        public boolean isEmpty() {
          return Collections.disjoint(this.b, this.a);
        }
        
        public int size() {
          Iterator<Object> iterator = this.a.iterator();
          int i = 0;
          while (iterator.hasNext()) {
            Object object = iterator.next();
            if (this.b.contains(object))
              i++; 
          } 
          return i;
        }
      };
  }
  
  public static <E> Set<E> b() {
    return Collections.newSetFromMap(new ConcurrentHashMap<E, Boolean>());
  }
  
  public static <E> SetView<E> c(Set<E> paramSet, Set<?> paramSet1) {
    Preconditions.a(paramSet, "set1");
    Preconditions.a(paramSet1, "set2");
    return new SetView<E>(paramSet, paramSet1) {
        public UnmodifiableIterator<E> a() {
          return new AbstractIterator(this) {
              final Iterator<E> a = this.b.a.iterator();
              
              protected E a() {
                while (this.a.hasNext()) {
                  E e = this.a.next();
                  if (!this.b.b.contains(e))
                    return e; 
                } 
                return b();
              }
            };
        }
        
        public boolean contains(Object param1Object) {
          return (this.a.contains(param1Object) && !this.b.contains(param1Object));
        }
        
        public boolean isEmpty() {
          return this.b.containsAll(this.a);
        }
        
        public int size() {
          Iterator<Object> iterator = this.a.iterator();
          int i = 0;
          while (iterator.hasNext()) {
            Object object = iterator.next();
            if (!this.b.contains(object))
              i++; 
          } 
          return i;
        }
      };
  }
  
  public static <E> LinkedHashSet<E> c() {
    return new LinkedHashSet<E>();
  }
  
  public static <E> Set<E> d() {
    return Collections.newSetFromMap(Maps.g());
  }
  
  static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
    private final transient ImmutableList<ImmutableSet<E>> a;
    
    private final transient CartesianList<E> b;
    
    protected Collection<List<E>> c() {
      return this.b;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof CartesianSet) {
        param1Object = param1Object;
        return this.a.equals(((CartesianSet)param1Object).a);
      } 
      return super.equals(param1Object);
    }
    
    public int hashCode() {
      int i = size();
      boolean bool = true;
      i--;
      int j;
      for (j = 0; j < this.a.size(); j++)
        i *= 31; 
      UnmodifiableIterator<ImmutableSet<E>> unmodifiableIterator = this.a.av_();
      for (j = bool; unmodifiableIterator.hasNext(); j = j * 31 + size() / set.size() * set.hashCode())
        Set set = unmodifiableIterator.next(); 
      return j + i;
    }
  }
  
  static final class null extends ImmutableList<List<E>> {
    boolean a() {
      return true;
    }
    
    public List<E> b(int param1Int) {
      return ((ImmutableSet<E>)this.a.get(param1Int)).h();
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  static class DescendingSet<E> extends ForwardingNavigableSet<E> {
    private final NavigableSet<E> a;
    
    private static <T> Ordering<T> a(Comparator<T> param1Comparator) {
      return Ordering.<T>a(param1Comparator).a();
    }
    
    public E ceiling(E param1E) {
      return this.a.floor(param1E);
    }
    
    public Comparator<? super E> comparator() {
      Comparator<? super E> comparator = this.a.comparator();
      return (comparator == null) ? Ordering.<Comparable>d().a() : a(comparator);
    }
    
    protected NavigableSet<E> d() {
      return this.a;
    }
    
    public Iterator<E> descendingIterator() {
      return this.a.iterator();
    }
    
    public NavigableSet<E> descendingSet() {
      return this.a;
    }
    
    public E first() {
      return this.a.last();
    }
    
    public E floor(E param1E) {
      return this.a.ceiling(param1E);
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return this.a.tailSet(param1E, param1Boolean).descendingSet();
    }
    
    public SortedSet<E> headSet(E param1E) {
      return a(param1E);
    }
    
    public E higher(E param1E) {
      return this.a.lower(param1E);
    }
    
    public Iterator<E> iterator() {
      return this.a.descendingIterator();
    }
    
    public E last() {
      return this.a.first();
    }
    
    public E lower(E param1E) {
      return this.a.higher(param1E);
    }
    
    public E pollFirst() {
      return this.a.pollLast();
    }
    
    public E pollLast() {
      return this.a.pollFirst();
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return this.a.subSet(param1E2, param1Boolean2, param1E1, param1Boolean1).descendingSet();
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return a(param1E1, param1E2);
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return this.a.headSet(param1E, param1Boolean).descendingSet();
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return b(param1E);
    }
    
    public Object[] toArray() {
      return o();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])a((Object[])param1ArrayOfT);
    }
    
    public String toString() {
      return n();
    }
  }
  
  static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
    FilteredNavigableSet(NavigableSet<E> param1NavigableSet, Predicate<? super E> param1Predicate) {
      super(param1NavigableSet, param1Predicate);
    }
    
    NavigableSet<E> a() {
      return (NavigableSet<E>)this.a;
    }
    
    public E ceiling(E param1E) {
      return Iterables.a(a().tailSet(param1E, true), this.b, null);
    }
    
    public Iterator<E> descendingIterator() {
      return Iterators.b(a().descendingIterator(), this.b);
    }
    
    public NavigableSet<E> descendingSet() {
      return Sets.a(a().descendingSet(), this.b);
    }
    
    @NullableDecl
    public E floor(E param1E) {
      return Iterators.a(a().headSet(param1E, true).descendingIterator(), this.b, (E)null);
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return Sets.a(a().headSet(param1E, param1Boolean), this.b);
    }
    
    public E higher(E param1E) {
      return Iterables.a(a().tailSet(param1E, false), this.b, null);
    }
    
    public E last() {
      return Iterators.d(a().descendingIterator(), this.b);
    }
    
    @NullableDecl
    public E lower(E param1E) {
      return Iterators.a(a().headSet(param1E, false).descendingIterator(), this.b, (E)null);
    }
    
    public E pollFirst() {
      return Iterables.b(a(), this.b);
    }
    
    public E pollLast() {
      return Iterables.b(a().descendingSet(), this.b);
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return Sets.a(a().subSet(param1E1, param1Boolean1, param1E2, param1Boolean2), this.b);
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return Sets.a(a().tailSet(param1E, param1Boolean), this.b);
    }
  }
  
  static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
    FilteredSet(Set<E> param1Set, Predicate<? super E> param1Predicate) {
      super(param1Set, param1Predicate);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      return Sets.a(this, param1Object);
    }
    
    public int hashCode() {
      return Sets.a(this);
    }
  }
  
  static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
    FilteredSortedSet(SortedSet<E> param1SortedSet, Predicate<? super E> param1Predicate) {
      super(param1SortedSet, param1Predicate);
    }
    
    public Comparator<? super E> comparator() {
      return ((SortedSet<E>)this.a).comparator();
    }
    
    public E first() {
      return Iterators.d(this.a.iterator(), this.b);
    }
    
    public SortedSet<E> headSet(E param1E) {
      return new FilteredSortedSet(((SortedSet<E>)this.a).headSet(param1E), this.b);
    }
    
    public E last() {
      for (SortedSet<Object> sortedSet = (SortedSet)this.a;; sortedSet = sortedSet.headSet((Object)e)) {
        E e = (E)sortedSet.last();
        if (this.b.a(e))
          return e; 
      } 
    }
    
    public SortedSet<E> subSet(E param1E1, E param1E2) {
      return new FilteredSortedSet(((SortedSet<E>)this.a).subSet(param1E1, param1E2), this.b);
    }
    
    public SortedSet<E> tailSet(E param1E) {
      return new FilteredSortedSet(((SortedSet<E>)this.a).tailSet(param1E), this.b);
    }
  }
  
  static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
    public boolean removeAll(Collection<?> param1Collection) {
      return Sets.a(this, param1Collection);
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      return super.retainAll((Collection)Preconditions.a(param1Collection));
    }
  }
  
  static final class PowerSet<E> extends AbstractSet<Set<E>> {
    final ImmutableMap<E, Integer> a;
    
    public boolean contains(@NullableDecl Object param1Object) {
      if (param1Object instanceof Set) {
        param1Object = param1Object;
        return this.a.n().containsAll((Collection<?>)param1Object);
      } 
      return false;
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof PowerSet) {
        param1Object = param1Object;
        return this.a.equals(((PowerSet)param1Object).a);
      } 
      return super.equals(param1Object);
    }
    
    public int hashCode() {
      return this.a.n().hashCode() << this.a.size() - 1;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public Iterator<Set<E>> iterator() {
      return (Iterator)new AbstractIndexedListIterator<Set<Set<E>>>(this, size()) {
          protected Set<E> b(int param2Int) {
            return new Sets.SubSet<E>(this.a.a, param2Int);
          }
        };
    }
    
    public int size() {
      return 1 << this.a.size();
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("powerSet(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  class null extends AbstractIndexedListIterator<Set<E>> {
    null(Sets this$0, int param1Int) {
      super(param1Int);
    }
    
    protected Set<E> b(int param1Int) {
      return new Sets.SubSet<E>(this.a.a, param1Int);
    }
  }
  
  public static abstract class SetView<E> extends AbstractSet<E> {
    private SetView() {}
    
    public abstract UnmodifiableIterator<E> a();
    
    @Deprecated
    public final boolean add(E param1E) {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    public final boolean addAll(Collection<? extends E> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    public final void clear() {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    public final boolean remove(Object param1Object) {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    public final boolean removeAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
    
    @Deprecated
    public final boolean retainAll(Collection<?> param1Collection) {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class SubSet<E> extends AbstractSet<E> {
    private final ImmutableMap<E, Integer> a;
    
    private final int b;
    
    SubSet(ImmutableMap<E, Integer> param1ImmutableMap, int param1Int) {
      this.a = param1ImmutableMap;
      this.b = param1Int;
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      param1Object = this.a.get(param1Object);
      if (param1Object != null) {
        int i = this.b;
        if ((1 << param1Object.intValue() & i) != 0)
          return true; 
      } 
      return false;
    }
    
    public Iterator<E> iterator() {
      return new UnmodifiableIterator<E>(this) {
          final ImmutableList<E> a = Sets.SubSet.a(this.c).n().h();
          
          int b = Sets.SubSet.b(this.c);
          
          public boolean hasNext() {
            return (this.b != 0);
          }
          
          public E next() {
            int i = Integer.numberOfTrailingZeros(this.b);
            if (i != 32) {
              this.b &= 1 << i;
              return this.a.get(i);
            } 
            throw new NoSuchElementException();
          }
        };
    }
    
    public int size() {
      return Integer.bitCount(this.b);
    }
  }
  
  class null extends UnmodifiableIterator<E> {
    final ImmutableList<E> a = Sets.SubSet.a(this.c).n().h();
    
    int b = Sets.SubSet.b(this.c);
    
    null(Sets this$0) {}
    
    public boolean hasNext() {
      return (this.b != 0);
    }
    
    public E next() {
      int i = Integer.numberOfTrailingZeros(this.b);
      if (i != 32) {
        this.b &= 1 << i;
        return this.a.get(i);
      } 
      throw new NoSuchElementException();
    }
  }
  
  static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements Serializable, NavigableSet<E> {
    private final NavigableSet<E> a;
    
    private final SortedSet<E> b;
    
    @NullableDecl
    private transient UnmodifiableNavigableSet<E> c;
    
    UnmodifiableNavigableSet(NavigableSet<E> param1NavigableSet) {
      this.a = (NavigableSet<E>)Preconditions.a(param1NavigableSet);
      this.b = Collections.unmodifiableSortedSet(param1NavigableSet);
    }
    
    public E ceiling(E param1E) {
      return this.a.ceiling(param1E);
    }
    
    public Iterator<E> descendingIterator() {
      return Iterators.a(this.a.descendingIterator());
    }
    
    public NavigableSet<E> descendingSet() {
      UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = this.c;
      UnmodifiableNavigableSet<E> unmodifiableNavigableSet1 = unmodifiableNavigableSet2;
      if (unmodifiableNavigableSet2 == null) {
        unmodifiableNavigableSet1 = new UnmodifiableNavigableSet(this.a.descendingSet());
        this.c = unmodifiableNavigableSet1;
        unmodifiableNavigableSet1.c = this;
      } 
      return unmodifiableNavigableSet1;
    }
    
    protected SortedSet<E> e() {
      return this.b;
    }
    
    public E floor(E param1E) {
      return this.a.floor(param1E);
    }
    
    public NavigableSet<E> headSet(E param1E, boolean param1Boolean) {
      return Sets.a(this.a.headSet(param1E, param1Boolean));
    }
    
    public E higher(E param1E) {
      return this.a.higher(param1E);
    }
    
    public E lower(E param1E) {
      return this.a.lower(param1E);
    }
    
    public E pollFirst() {
      throw new UnsupportedOperationException();
    }
    
    public E pollLast() {
      throw new UnsupportedOperationException();
    }
    
    public NavigableSet<E> subSet(E param1E1, boolean param1Boolean1, E param1E2, boolean param1Boolean2) {
      return Sets.a(this.a.subSet(param1E1, param1Boolean1, param1E2, param1Boolean2));
    }
    
    public NavigableSet<E> tailSet(E param1E, boolean param1Boolean) {
      return Sets.a(this.a.tailSet(param1E, param1Boolean));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Sets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */