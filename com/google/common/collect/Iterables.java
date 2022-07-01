package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Iterables {
  static <T> Function<Iterable<? extends T>, Iterator<? extends T>> a() {
    return new Function<Iterable<? extends T>, Iterator<? extends T>>() {
        public Iterator<? extends T> a(Iterable<? extends T> param1Iterable) {
          return param1Iterable.iterator();
        }
      };
  }
  
  public static <T> Iterable<T> a(Iterable<T> paramIterable, int paramInt) {
    boolean bool;
    Preconditions.a(paramIterable);
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "number to skip cannot be negative");
    return new FluentIterable<T>(paramIterable, paramInt) {
        public Iterator<T> iterator() {
          Iterable<T> iterable = this.a;
          if (iterable instanceof List) {
            iterable = iterable;
            return iterable.subList(Math.min(iterable.size(), this.b), iterable.size()).iterator();
          } 
          Iterator<T> iterator = iterable.iterator();
          Iterators.c(iterator, this.b);
          return new Iterator(this, iterator) {
              boolean a = true;
              
              public boolean hasNext() {
                return this.b.hasNext();
              }
              
              public T next() {
                T t = (T)this.b.next();
                this.a = false;
                return t;
              }
              
              public void remove() {
                CollectPreconditions.a(this.a ^ true);
                this.b.remove();
              }
            };
        }
      };
  }
  
  public static <F, T> Iterable<T> a(Iterable<F> paramIterable, Function<? super F, ? extends T> paramFunction) {
    Preconditions.a(paramIterable);
    Preconditions.a(paramFunction);
    return new FluentIterable<T>(paramIterable, paramFunction) {
        public Iterator<T> iterator() {
          return Iterators.a(this.a.iterator(), this.b);
        }
      };
  }
  
  public static <T> Iterable<T> a(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2) {
    return FluentIterable.a(paramIterable1, paramIterable2);
  }
  
  @NullableDecl
  public static <T> T a(Iterable<? extends T> paramIterable, Predicate<? super T> paramPredicate, @NullableDecl T paramT) {
    return Iterators.a(paramIterable.iterator(), paramPredicate, paramT);
  }
  
  @NullableDecl
  public static <T> T a(Iterable<? extends T> paramIterable, @NullableDecl T paramT) {
    return Iterators.b(paramIterable.iterator(), paramT);
  }
  
  private static <T> T a(List<T> paramList) {
    return paramList.get(paramList.size() - 1);
  }
  
  public static String a(Iterable<?> paramIterable) {
    return Iterators.c(paramIterable.iterator());
  }
  
  private static <T> void a(List<T> paramList, Predicate<? super T> paramPredicate, int paramInt1, int paramInt2) {
    int i;
    for (i = paramList.size() - 1; i > paramInt2; i--) {
      if (paramPredicate.a(paramList.get(i)))
        paramList.remove(i); 
    } 
    while (--paramInt2 >= paramInt1) {
      paramList.remove(paramInt2);
      paramInt2--;
    } 
  }
  
  public static <T> boolean a(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return (paramIterable instanceof java.util.RandomAccess && paramIterable instanceof List) ? a((List)paramIterable, (Predicate)Preconditions.a(paramPredicate)) : Iterators.a(paramIterable.iterator(), paramPredicate);
  }
  
  public static <T> boolean a(Collection<T> paramCollection, Iterable<? extends T> paramIterable) {
    return (paramIterable instanceof Collection) ? paramCollection.addAll(Collections2.a(paramIterable)) : Iterators.a(paramCollection, ((Iterable<? extends T>)Preconditions.a(paramIterable)).iterator());
  }
  
  private static <T> boolean a(List<T> paramList, Predicate<? super T> paramPredicate) {
    Object object;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    while (true) {
      if (i < paramList.size()) {
        T t = paramList.get(i);
        Object object1 = object;
        if (!paramPredicate.a(t)) {
          if (i > object)
            try {
              paramList.set(object, t);
              int k = object + 1;
              continue;
            } catch (UnsupportedOperationException unsupportedOperationException) {
              a(paramList, paramPredicate, object, i);
              return true;
            } catch (IllegalArgumentException illegalArgumentException) {
              a(paramList, paramPredicate, object, i);
              return true;
            }  
        } else {
          continue;
        } 
      } else {
        paramList.subList(object, paramList.size()).clear();
        if (i != object)
          bool2 = true; 
        return bool2;
      } 
      int j = object + 1;
      continue;
      i++;
      object = SYNTHETIC_LOCAL_VARIABLE_4;
    } 
  }
  
  public static <T> T[] a(Iterable<? extends T> paramIterable, Class<T> paramClass) {
    return a(paramIterable, ObjectArrays.a(paramClass, 0));
  }
  
  static <T> T[] a(Iterable<? extends T> paramIterable, T[] paramArrayOfT) {
    return (T[])d(paramIterable).toArray((Object[])paramArrayOfT);
  }
  
  public static <T> Iterable<T> b(Iterable<?> paramIterable, Class<T> paramClass) {
    Preconditions.a(paramIterable);
    Preconditions.a(paramClass);
    return c((Iterable)paramIterable, Predicates.a(paramClass));
  }
  
  @NullableDecl
  static <T> T b(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    Preconditions.a(paramPredicate);
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext()) {
      T t = iterator.next();
      if (paramPredicate.a(t)) {
        iterator.remove();
        return t;
      } 
    } 
    return null;
  }
  
  static Object[] b(Iterable<?> paramIterable) {
    return d(paramIterable).toArray();
  }
  
  public static <T> Iterable<T> c(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    Preconditions.a(paramIterable);
    Preconditions.a(paramPredicate);
    return new FluentIterable<T>(paramIterable, paramPredicate) {
        public Iterator<T> iterator() {
          return Iterators.b(this.a.iterator(), this.b);
        }
      };
  }
  
  public static <T> T c(Iterable<T> paramIterable) {
    if (paramIterable instanceof List) {
      paramIterable = paramIterable;
      if (!paramIterable.isEmpty())
        return a((List<T>)paramIterable); 
      throw new NoSuchElementException();
    } 
    return Iterators.e(paramIterable.iterator());
  }
  
  private static <E> Collection<E> d(Iterable<E> paramIterable) {
    return (paramIterable instanceof Collection) ? (Collection<E>)paramIterable : Lists.a(paramIterable.iterator());
  }
  
  public static <T> boolean d(Iterable<T> paramIterable, Predicate<? super T> paramPredicate) {
    return Iterators.c(paramIterable.iterator(), paramPredicate);
  }
  
  static final class UnmodifiableIterable<T> extends FluentIterable<T> {
    private final Iterable<? extends T> a;
    
    public Iterator<T> iterator() {
      return Iterators.a(this.a.iterator());
    }
    
    public String toString() {
      return this.a.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Iterables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */