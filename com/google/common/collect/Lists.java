package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Lists {
  static int a(int paramInt) {
    CollectPreconditions.a(paramInt, "arraySize");
    return Ints.b(paramInt + 5L + (paramInt / 10));
  }
  
  public static ImmutableList<Character> a(String paramString) {
    return new StringAsImmutableList((String)Preconditions.a(paramString));
  }
  
  public static <E> ArrayList<E> a() {
    return new ArrayList<E>();
  }
  
  public static <E> ArrayList<E> a(Iterable<? extends E> paramIterable) {
    Preconditions.a(paramIterable);
    return (paramIterable instanceof Collection) ? new ArrayList<E>(Collections2.a(paramIterable)) : a(paramIterable.iterator());
  }
  
  public static <E> ArrayList<E> a(Iterator<? extends E> paramIterator) {
    ArrayList<?> arrayList = a();
    Iterators.a(arrayList, paramIterator);
    return (ArrayList)arrayList;
  }
  
  public static <T> List<T> a(List<T> paramList) {
    return (paramList instanceof ImmutableList) ? ((ImmutableList<T>)paramList).f() : ((paramList instanceof ReverseList) ? ((ReverseList<T>)paramList).a() : ((paramList instanceof RandomAccess) ? new RandomAccessReverseList<T>(paramList) : new ReverseList<T>(paramList)));
  }
  
  public static <F, T> List<T> a(List<F> paramList, Function<? super F, ? extends T> paramFunction) {
    return (List<T>)((paramList instanceof RandomAccess) ? new TransformingRandomAccessList<F, T>(paramList, paramFunction) : new TransformingSequentialList<F, T>(paramList, paramFunction));
  }
  
  static boolean a(List<?> paramList, @NullableDecl Object paramObject) {
    if (paramObject == Preconditions.a(paramList))
      return true; 
    if (!(paramObject instanceof List))
      return false; 
    paramObject = paramObject;
    int i = paramList.size();
    if (i != paramObject.size())
      return false; 
    if (paramList instanceof RandomAccess && paramObject instanceof RandomAccess) {
      for (int j = 0; j < i; j++) {
        if (!Objects.a(paramList.get(j), paramObject.get(j)))
          return false; 
      } 
      return true;
    } 
    return Iterators.a(paramList.iterator(), paramObject.iterator());
  }
  
  static int b(List<?> paramList, @NullableDecl Object paramObject) {
    if (paramList instanceof RandomAccess)
      return d(paramList, paramObject); 
    ListIterator<?> listIterator = paramList.listIterator();
    while (listIterator.hasNext()) {
      if (Objects.a(paramObject, listIterator.next()))
        return listIterator.previousIndex(); 
    } 
    return -1;
  }
  
  public static <E> ArrayList<E> b(int paramInt) {
    CollectPreconditions.a(paramInt, "initialArraySize");
    return new ArrayList<E>(paramInt);
  }
  
  public static <E> LinkedList<E> b() {
    return new LinkedList<E>();
  }
  
  static int c(List<?> paramList, @NullableDecl Object paramObject) {
    if (paramList instanceof RandomAccess)
      return e(paramList, paramObject); 
    ListIterator<?> listIterator = paramList.listIterator(paramList.size());
    while (listIterator.hasPrevious()) {
      if (Objects.a(paramObject, listIterator.previous()))
        return listIterator.nextIndex(); 
    } 
    return -1;
  }
  
  public static <E> ArrayList<E> c(int paramInt) {
    return new ArrayList<E>(a(paramInt));
  }
  
  private static int d(List<?> paramList, @NullableDecl Object paramObject) {
    int j = paramList.size();
    int i = 0;
    byte b = 0;
    if (paramObject == null) {
      for (i = b; i < j; i++) {
        if (paramList.get(i) == null)
          return i; 
      } 
    } else {
      while (i < j) {
        if (paramObject.equals(paramList.get(i)))
          return i; 
        i++;
      } 
    } 
    return -1;
  }
  
  private static int e(List<?> paramList, @NullableDecl Object paramObject) {
    if (paramObject == null) {
      for (int i = paramList.size() - 1; i >= 0; i--) {
        if (paramList.get(i) == null)
          return i; 
      } 
    } else {
      for (int i = paramList.size() - 1; i >= 0; i--) {
        if (paramObject.equals(paramList.get(i)))
          return i; 
      } 
    } 
    return -1;
  }
  
  static class AbstractListWrapper<E> extends AbstractList<E> {
    final List<E> a;
    
    public void add(int param1Int, E param1E) {
      this.a.add(param1Int, param1E);
    }
    
    public boolean addAll(int param1Int, Collection<? extends E> param1Collection) {
      return this.a.addAll(param1Int, param1Collection);
    }
    
    public boolean contains(Object param1Object) {
      return this.a.contains(param1Object);
    }
    
    public E get(int param1Int) {
      return this.a.get(param1Int);
    }
    
    public E remove(int param1Int) {
      return this.a.remove(param1Int);
    }
    
    public E set(int param1Int, E param1E) {
      return this.a.set(param1Int, param1E);
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  static final class CharSequenceAsList extends AbstractList<Character> {
    private final CharSequence a;
    
    public Character a(int param1Int) {
      Preconditions.a(param1Int, size());
      return Character.valueOf(this.a.charAt(param1Int));
    }
    
    public int size() {
      return this.a.length();
    }
  }
  
  static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    @NullableDecl
    final E a;
    
    final E[] b;
    
    public E get(int param1Int) {
      Preconditions.a(param1Int, size());
      return (param1Int == 0) ? this.a : this.b[param1Int - 1];
    }
    
    public int size() {
      return IntMath.e(this.b.length, 1);
    }
  }
  
  static class Partition<T> extends AbstractList<List<T>> {
    final List<T> a;
    
    final int b;
    
    public List<T> a(int param1Int) {
      Preconditions.a(param1Int, size());
      int i = this.b;
      param1Int *= i;
      i = Math.min(i + param1Int, this.a.size());
      return this.a.subList(param1Int, i);
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public int size() {
      return IntMath.a(this.a.size(), this.b, RoundingMode.CEILING);
    }
  }
  
  static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {}
  
  static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {}
  
  static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
    RandomAccessReverseList(List<T> param1List) {
      super(param1List);
    }
  }
  
  static class ReverseList<T> extends AbstractList<T> {
    private final List<T> a;
    
    ReverseList(List<T> param1List) {
      this.a = (List<T>)Preconditions.a(param1List);
    }
    
    private int a(int param1Int) {
      int i = size();
      Preconditions.a(param1Int, i);
      return i - 1 - param1Int;
    }
    
    private int b(int param1Int) {
      int i = size();
      Preconditions.b(param1Int, i);
      return i - param1Int;
    }
    
    List<T> a() {
      return this.a;
    }
    
    public void add(int param1Int, @NullableDecl T param1T) {
      this.a.add(b(param1Int), param1T);
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public T get(int param1Int) {
      return this.a.get(a(param1Int));
    }
    
    public Iterator<T> iterator() {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int param1Int) {
      param1Int = b(param1Int);
      return new ListIterator<T>(this, this.a.listIterator(param1Int)) {
          boolean a;
          
          public void add(T param2T) {
            this.b.add(param2T);
            this.b.previous();
            this.a = false;
          }
          
          public boolean hasNext() {
            return this.b.hasPrevious();
          }
          
          public boolean hasPrevious() {
            return this.b.hasNext();
          }
          
          public T next() {
            if (hasNext()) {
              this.a = true;
              return this.b.previous();
            } 
            throw new NoSuchElementException();
          }
          
          public int nextIndex() {
            return Lists.ReverseList.a(this.c, this.b.nextIndex());
          }
          
          public T previous() {
            if (hasPrevious()) {
              this.a = true;
              return this.b.next();
            } 
            throw new NoSuchElementException();
          }
          
          public int previousIndex() {
            return nextIndex() - 1;
          }
          
          public void remove() {
            CollectPreconditions.a(this.a);
            this.b.remove();
            this.a = false;
          }
          
          public void set(T param2T) {
            Preconditions.b(this.a);
            this.b.set(param2T);
          }
        };
    }
    
    public T remove(int param1Int) {
      return this.a.remove(a(param1Int));
    }
    
    protected void removeRange(int param1Int1, int param1Int2) {
      subList(param1Int1, param1Int2).clear();
    }
    
    public T set(int param1Int, @NullableDecl T param1T) {
      return this.a.set(a(param1Int), param1T);
    }
    
    public int size() {
      return this.a.size();
    }
    
    public List<T> subList(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      return Lists.a(this.a.subList(b(param1Int2), b(param1Int1)));
    }
  }
  
  class null implements ListIterator<T> {
    boolean a;
    
    null(Lists this$0, ListIterator param1ListIterator) {}
    
    public void add(T param1T) {
      this.b.add(param1T);
      this.b.previous();
      this.a = false;
    }
    
    public boolean hasNext() {
      return this.b.hasPrevious();
    }
    
    public boolean hasPrevious() {
      return this.b.hasNext();
    }
    
    public T next() {
      if (hasNext()) {
        this.a = true;
        return this.b.previous();
      } 
      throw new NoSuchElementException();
    }
    
    public int nextIndex() {
      return Lists.ReverseList.a(this.c, this.b.nextIndex());
    }
    
    public T previous() {
      if (hasPrevious()) {
        this.a = true;
        return this.b.next();
      } 
      throw new NoSuchElementException();
    }
    
    public int previousIndex() {
      return nextIndex() - 1;
    }
    
    public void remove() {
      CollectPreconditions.a(this.a);
      this.b.remove();
      this.a = false;
    }
    
    public void set(T param1T) {
      Preconditions.b(this.a);
      this.b.set(param1T);
    }
  }
  
  static final class StringAsImmutableList extends ImmutableList<Character> {
    private final String a;
    
    StringAsImmutableList(String param1String) {
      this.a = param1String;
    }
    
    public ImmutableList<Character> a(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      return Lists.a(this.a.substring(param1Int1, param1Int2));
    }
    
    boolean a() {
      return false;
    }
    
    public Character b(int param1Int) {
      Preconditions.a(param1Int, size());
      return Character.valueOf(this.a.charAt(param1Int));
    }
    
    public int indexOf(@NullableDecl Object param1Object) {
      return (param1Object instanceof Character) ? this.a.indexOf(((Character)param1Object).charValue()) : -1;
    }
    
    public int lastIndexOf(@NullableDecl Object param1Object) {
      return (param1Object instanceof Character) ? this.a.lastIndexOf(((Character)param1Object).charValue()) : -1;
    }
    
    public int size() {
      return this.a.length();
    }
  }
  
  static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
    final List<F> a;
    
    final Function<? super F, ? extends T> b;
    
    TransformingRandomAccessList(List<F> param1List, Function<? super F, ? extends T> param1Function) {
      this.a = (List<F>)Preconditions.a(param1List);
      this.b = (Function<? super F, ? extends T>)Preconditions.a(param1Function);
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public T get(int param1Int) {
      return (T)this.b.f(this.a.get(param1Int));
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public Iterator<T> iterator() {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int param1Int) {
      return new TransformedListIterator<F, T>(this, this.a.listIterator(param1Int)) {
          T a(F param2F) {
            return (T)this.a.b.f(param2F);
          }
        };
    }
    
    public T remove(int param1Int) {
      return (T)this.b.f(this.a.remove(param1Int));
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  class null extends TransformedListIterator<F, T> {
    null(Lists this$0, ListIterator<? extends F> param1ListIterator) {
      super(param1ListIterator);
    }
    
    T a(F param1F) {
      return (T)this.a.b.f(param1F);
    }
  }
  
  static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
    final List<F> a;
    
    final Function<? super F, ? extends T> b;
    
    TransformingSequentialList(List<F> param1List, Function<? super F, ? extends T> param1Function) {
      this.a = (List<F>)Preconditions.a(param1List);
      this.b = (Function<? super F, ? extends T>)Preconditions.a(param1Function);
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public ListIterator<T> listIterator(int param1Int) {
      return new TransformedListIterator<F, T>(this, this.a.listIterator(param1Int)) {
          T a(F param2F) {
            return (T)this.a.b.f(param2F);
          }
        };
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  class null extends TransformedListIterator<F, T> {
    null(Lists this$0, ListIterator<? extends F> param1ListIterator) {
      super(param1ListIterator);
    }
    
    T a(F param1F) {
      return (T)this.a.b.f(param1F);
    }
  }
  
  static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    @NullableDecl
    final E a;
    
    @NullableDecl
    final E b;
    
    final E[] c;
    
    public E get(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          Preconditions.a(param1Int, size());
          return this.c[param1Int - 2];
        } 
        return this.b;
      } 
      return this.a;
    }
    
    public int size() {
      return IntMath.e(this.c.length, 2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Lists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */