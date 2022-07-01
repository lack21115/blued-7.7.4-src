package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Iterator;

public abstract class FluentIterable<E> implements Iterable<E> {
  private final Optional<Iterable<E>> a;
  
  protected FluentIterable() {
    this.a = Optional.e();
  }
  
  FluentIterable(Iterable<E> paramIterable) {
    Preconditions.a(paramIterable);
    if (this == paramIterable)
      paramIterable = null; 
    this.a = Optional.c(paramIterable);
  }
  
  public static <E> FluentIterable<E> a(Iterable<E> paramIterable) {
    return (paramIterable instanceof FluentIterable) ? (FluentIterable<E>)paramIterable : new FluentIterable<E>(paramIterable, paramIterable) {
        public Iterator<E> iterator() {
          return this.a.iterator();
        }
      };
  }
  
  public static <T> FluentIterable<T> a(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2) {
    return a((Iterable<? extends T>[])new Iterable[] { paramIterable1, paramIterable2 });
  }
  
  private static <T> FluentIterable<T> a(Iterable<? extends T>... paramVarArgs) {
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
      Preconditions.a(paramVarArgs[i]); 
    return new FluentIterable<T>((Iterable[])paramVarArgs) {
        public Iterator<T> iterator() {
          return Iterators.d(new AbstractIndexedListIterator(this, this.a.length) {
                public Iterator<? extends T> b(int param2Int) {
                  return this.a.a[param2Int].iterator();
                }
              });
        }
      };
  }
  
  private Iterable<E> c() {
    return (Iterable<E>)this.a.a(this);
  }
  
  public final Optional<E> a() {
    Iterator<E> iterator = c().iterator();
    return iterator.hasNext() ? Optional.b(iterator.next()) : Optional.e();
  }
  
  public final FluentIterable<E> a(Predicate<? super E> paramPredicate) {
    return a(Iterables.c(c(), paramPredicate));
  }
  
  public final <T> FluentIterable<T> a(Class<T> paramClass) {
    return a(Iterables.b(c(), paramClass));
  }
  
  public final ImmutableSet<E> b() {
    return ImmutableSet.a(c());
  }
  
  public final E[] b(Class<E> paramClass) {
    return Iterables.a(c(), paramClass);
  }
  
  public String toString() {
    return Iterables.a(c());
  }
  
  static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
    public FluentIterable<E> a(Iterable<E> param1Iterable) {
      return FluentIterable.a(param1Iterable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\FluentIterable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */