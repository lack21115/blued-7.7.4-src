package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Ordering<T> implements Comparator<T> {
  public static <T> Ordering<T> a(Comparator<T> paramComparator) {
    return (paramComparator instanceof Ordering) ? (Ordering<T>)paramComparator : new ComparatorOrdering<T>(paramComparator);
  }
  
  public static <C extends Comparable> Ordering<C> d() {
    return NaturalOrdering.a;
  }
  
  public <E extends T> ImmutableList<E> a(Iterable<E> paramIterable) {
    return ImmutableList.a(this, paramIterable);
  }
  
  public <S extends T> Ordering<S> a() {
    return new ReverseOrdering<S>(this);
  }
  
  public <F> Ordering<F> a(Function<F, ? extends T> paramFunction) {
    return new ByFunctionOrdering<F, T>(paramFunction, this);
  }
  
  public <E extends T> E a(@NullableDecl E paramE1, @NullableDecl E paramE2) {
    return (compare((T)paramE1, (T)paramE2) <= 0) ? paramE1 : paramE2;
  }
  
  public <S extends T> Ordering<S> b() {
    return new NullsFirstOrdering<S>(this);
  }
  
  public <E extends T> E b(@NullableDecl E paramE1, @NullableDecl E paramE2) {
    return (compare((T)paramE1, (T)paramE2) >= 0) ? paramE1 : paramE2;
  }
  
  public <S extends T> Ordering<S> c() {
    return new NullsLastOrdering<S>(this);
  }
  
  public abstract int compare(@NullableDecl T paramT1, @NullableDecl T paramT2);
  
  <T2 extends T> Ordering<Map.Entry<T2, ?>> e() {
    return a(Maps.a());
  }
  
  static class ArbitraryOrdering extends Ordering<Object> {
    private final AtomicInteger a = new AtomicInteger(0);
    
    private final ConcurrentMap<Object, Integer> b = Platform.a(new MapMaker()).g();
    
    private Integer b(Object param1Object) {
      Integer integer = this.b.get(param1Object);
      Object object = integer;
      if (integer == null) {
        object = Integer.valueOf(this.a.getAndIncrement());
        param1Object = this.b.putIfAbsent(param1Object, (Integer)object);
        if (param1Object != null)
          object = param1Object; 
      } 
      return (Integer)object;
    }
    
    int a(Object param1Object) {
      return System.identityHashCode(param1Object);
    }
    
    public int compare(Object param1Object1, Object param1Object2) {
      if (param1Object1 == param1Object2)
        return 0; 
      if (param1Object1 == null)
        return -1; 
      if (param1Object2 == null)
        return 1; 
      int i = a(param1Object1);
      int j = a(param1Object2);
      if (i != j)
        return (i < j) ? -1 : 1; 
      i = b(param1Object1).compareTo(b(param1Object2));
      if (i != 0)
        return i; 
      throw new AssertionError();
    }
    
    public String toString() {
      return "Ordering.arbitrary()";
    }
  }
  
  static class ArbitraryOrderingHolder {
    static final Ordering<Object> a = new Ordering.ArbitraryOrdering();
  }
  
  static class IncomparableValueException extends ClassCastException {
    final Object a;
    
    IncomparableValueException(Object param1Object) {
      super(stringBuilder.toString());
      this.a = param1Object;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Ordering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */