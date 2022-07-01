package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.primitives.Ints;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Iterators {
  static <T> UnmodifiableIterator<T> a() {
    return b();
  }
  
  public static <T> UnmodifiableIterator<T> a(Iterable<? extends Iterator<? extends T>> paramIterable, Comparator<? super T> paramComparator) {
    Preconditions.a(paramIterable, "iterators");
    Preconditions.a(paramComparator, "comparator");
    return new MergingIterator<T>(paramIterable, paramComparator);
  }
  
  public static <T> UnmodifiableIterator<T> a(@NullableDecl T paramT) {
    return new UnmodifiableIterator<T>(paramT) {
        boolean a;
        
        public boolean hasNext() {
          return this.a ^ true;
        }
        
        public T next() {
          if (!this.a) {
            this.a = true;
            return (T)this.b;
          } 
          throw new NoSuchElementException();
        }
      };
  }
  
  public static <T> UnmodifiableIterator<T> a(Iterator<? extends T> paramIterator) {
    Preconditions.a(paramIterator);
    return (paramIterator instanceof UnmodifiableIterator) ? (UnmodifiableIterator)paramIterator : new UnmodifiableIterator<T>(paramIterator) {
        public boolean hasNext() {
          return this.a.hasNext();
        }
        
        public T next() {
          return this.a.next();
        }
      };
  }
  
  public static <T> UnmodifiableIterator<List<T>> a(Iterator<T> paramIterator, int paramInt) {
    return a(paramIterator, paramInt, false);
  }
  
  private static <T> UnmodifiableIterator<List<T>> a(Iterator<T> paramIterator, int paramInt, boolean paramBoolean) {
    boolean bool;
    Preconditions.a(paramIterator);
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    return new UnmodifiableIterator<List<T>>(paramIterator, paramInt, paramBoolean) {
        public List<T> a() {
          if (hasNext()) {
            Object[] arrayOfObject = new Object[this.b];
            int i;
            for (i = 0; i < this.b && this.a.hasNext(); i++)
              arrayOfObject[i] = this.a.next(); 
            for (int j = i; j < this.b; j++)
              arrayOfObject[j] = null; 
            List<?> list2 = Collections.unmodifiableList(Arrays.asList(arrayOfObject));
            List<?> list1 = list2;
            if (!this.c) {
              if (i == this.b)
                return (List)list2; 
              list1 = list2.subList(0, i);
            } 
            return (List)list1;
          } 
          throw new NoSuchElementException();
        }
        
        public boolean hasNext() {
          return this.a.hasNext();
        }
      };
  }
  
  @SafeVarargs
  public static <T> UnmodifiableIterator<T> a(T... paramVarArgs) {
    return a(paramVarArgs, 0, paramVarArgs.length, 0);
  }
  
  static <T> UnmodifiableListIterator<T> a(T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfT.length);
    Preconditions.b(paramInt3, paramInt2);
    return (paramInt2 == 0) ? b() : new ArrayItr<T>(paramArrayOfT, paramInt1, paramInt2, paramInt3);
  }
  
  @NullableDecl
  public static <T> T a(Iterator<? extends T> paramIterator, Predicate<? super T> paramPredicate, @NullableDecl T paramT) {
    Preconditions.a(paramIterator);
    Preconditions.a(paramPredicate);
    while (paramIterator.hasNext()) {
      T t = paramIterator.next();
      if (paramPredicate.a(t))
        return t; 
    } 
    return paramT;
  }
  
  public static <T> Iterator<T> a(Iterable<T> paramIterable) {
    Preconditions.a(paramIterable);
    return new Iterator<T>(paramIterable) {
        Iterator<T> a = Iterators.c();
        
        public boolean hasNext() {
          return (this.a.hasNext() || this.b.iterator().hasNext());
        }
        
        public T next() {
          if (!this.a.hasNext()) {
            this.a = this.b.iterator();
            if (!this.a.hasNext())
              throw new NoSuchElementException(); 
          } 
          return this.a.next();
        }
        
        public void remove() {
          this.a.remove();
        }
      };
  }
  
  public static <F, T> Iterator<T> a(Iterator<F> paramIterator, Function<? super F, ? extends T> paramFunction) {
    Preconditions.a(paramFunction);
    return new TransformedIterator<F, T>(paramIterator, paramFunction) {
        T a(F param1F) {
          return (T)this.a.f(param1F);
        }
      };
  }
  
  public static <T> boolean a(Collection<T> paramCollection, Iterator<? extends T> paramIterator) {
    Preconditions.a(paramCollection);
    Preconditions.a(paramIterator);
    boolean bool;
    for (bool = false; paramIterator.hasNext(); bool |= paramCollection.add(paramIterator.next()));
    return bool;
  }
  
  public static <T> boolean a(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Preconditions.a(paramPredicate);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (paramPredicate.a(paramIterator.next())) {
        paramIterator.remove();
        bool = true;
      } 
    } 
    return bool;
  }
  
  public static boolean a(Iterator<?> paramIterator, @NullableDecl Object paramObject) {
    if (paramObject == null) {
      while (paramIterator.hasNext()) {
        if (paramIterator.next() == null)
          return true; 
      } 
    } else {
      while (paramIterator.hasNext()) {
        if (paramObject.equals(paramIterator.next()))
          return true; 
      } 
    } 
    return false;
  }
  
  public static boolean a(Iterator<?> paramIterator, Collection<?> paramCollection) {
    Preconditions.a(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (paramCollection.contains(paramIterator.next())) {
        paramIterator.remove();
        bool = true;
      } 
    } 
    return bool;
  }
  
  public static boolean a(Iterator<?> paramIterator1, Iterator<?> paramIterator2) {
    while (paramIterator1.hasNext()) {
      if (!paramIterator2.hasNext())
        return false; 
      if (!Objects.a(paramIterator1.next(), paramIterator2.next()))
        return false; 
    } 
    return paramIterator2.hasNext() ^ true;
  }
  
  public static int b(Iterator<?> paramIterator) {
    long l;
    for (l = 0L; paramIterator.hasNext(); l++)
      paramIterator.next(); 
    return Ints.b(l);
  }
  
  public static <T> UnmodifiableIterator<List<T>> b(Iterator<T> paramIterator, int paramInt) {
    return a(paramIterator, paramInt, true);
  }
  
  public static <T> UnmodifiableIterator<T> b(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Preconditions.a(paramIterator);
    Preconditions.a(paramPredicate);
    return new AbstractIterator<T>(paramIterator, paramPredicate) {
        protected T a() {
          while (this.a.hasNext()) {
            T t = (T)this.a.next();
            if (this.b.a(t))
              return t; 
          } 
          return b();
        }
      };
  }
  
  static <T> UnmodifiableListIterator<T> b() {
    return (UnmodifiableListIterator)ArrayItr.a;
  }
  
  @NullableDecl
  public static <T> T b(Iterator<? extends T> paramIterator, @NullableDecl T paramT) {
    if (paramIterator.hasNext())
      paramT = paramIterator.next(); 
    return paramT;
  }
  
  public static <T> Iterator<T> b(Iterator<? extends T> paramIterator1, Iterator<? extends T> paramIterator2) {
    Preconditions.a(paramIterator1);
    Preconditions.a(paramIterator2);
    return d(b((Iterator<? extends T>[])new Iterator[] { paramIterator1, paramIterator2 }));
  }
  
  private static <T> Iterator<T> b(T... paramVarArgs) {
    return new UnmodifiableIterator<T>((Object[])paramVarArgs) {
        int a = 0;
        
        public boolean hasNext() {
          return (this.a < this.b.length);
        }
        
        public T next() {
          if (hasNext()) {
            Object[] arrayOfObject = this.b;
            int i = this.a;
            Object object = arrayOfObject[i];
            arrayOfObject[i] = null;
            this.a = i + 1;
            return (T)object;
          } 
          throw new NoSuchElementException();
        }
      };
  }
  
  public static boolean b(Iterator<?> paramIterator, Collection<?> paramCollection) {
    Preconditions.a(paramCollection);
    boolean bool = false;
    while (paramIterator.hasNext()) {
      if (!paramCollection.contains(paramIterator.next())) {
        paramIterator.remove();
        bool = true;
      } 
    } 
    return bool;
  }
  
  public static int c(Iterator<?> paramIterator, int paramInt) {
    boolean bool;
    Preconditions.a(paramIterator);
    int i = 0;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "numberToAdvance must be nonnegative");
    while (i < paramInt && paramIterator.hasNext()) {
      paramIterator.next();
      i++;
    } 
    return i;
  }
  
  public static String c(Iterator<?> paramIterator) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('[');
    boolean bool = true;
    while (paramIterator.hasNext()) {
      if (!bool)
        stringBuilder.append(", "); 
      bool = false;
      stringBuilder.append(paramIterator.next());
    } 
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  static <T> Iterator<T> c() {
    return EmptyModifiableIterator.a;
  }
  
  public static <T> boolean c(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    return (e(paramIterator, paramPredicate) != -1);
  }
  
  public static <T> T d(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Preconditions.a(paramIterator);
    Preconditions.a(paramPredicate);
    while (paramIterator.hasNext()) {
      T t = paramIterator.next();
      if (paramPredicate.a(t))
        return t; 
    } 
    throw new NoSuchElementException();
  }
  
  public static <T> Iterator<T> d(Iterator<? extends Iterator<? extends T>> paramIterator) {
    return new ConcatenatedIterator<T>(paramIterator);
  }
  
  public static <T> Iterator<T> d(Iterator<T> paramIterator, int paramInt) {
    boolean bool;
    Preconditions.a(paramIterator);
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "limit is negative");
    return new Iterator<T>(paramInt, paramIterator) {
        private int c;
        
        public boolean hasNext() {
          return (this.c < this.a && this.b.hasNext());
        }
        
        public T next() {
          if (hasNext()) {
            this.c++;
            return this.b.next();
          } 
          throw new NoSuchElementException();
        }
        
        public void remove() {
          this.b.remove();
        }
      };
  }
  
  public static <T> int e(Iterator<T> paramIterator, Predicate<? super T> paramPredicate) {
    Preconditions.a(paramPredicate, "predicate");
    for (int i = 0; paramIterator.hasNext(); i++) {
      if (paramPredicate.a(paramIterator.next()))
        return i; 
    } 
    return -1;
  }
  
  public static <T> T e(Iterator<T> paramIterator) {
    while (true) {
      T t = paramIterator.next();
      if (!paramIterator.hasNext())
        return t; 
    } 
  }
  
  public static <T> Iterator<T> f(Iterator<T> paramIterator) {
    Preconditions.a(paramIterator);
    return new UnmodifiableIterator<T>(paramIterator) {
        public boolean hasNext() {
          return this.a.hasNext();
        }
        
        public T next() {
          T t = (T)this.a.next();
          this.a.remove();
          return t;
        }
        
        public String toString() {
          return "Iterators.consumingIterator(...)";
        }
      };
  }
  
  @NullableDecl
  static <T> T g(Iterator<T> paramIterator) {
    if (paramIterator.hasNext()) {
      T t = paramIterator.next();
      paramIterator.remove();
      return t;
    } 
    return null;
  }
  
  static void h(Iterator<?> paramIterator) {
    Preconditions.a(paramIterator);
    while (paramIterator.hasNext()) {
      paramIterator.next();
      paramIterator.remove();
    } 
  }
  
  public static <T> PeekingIterator<T> i(Iterator<? extends T> paramIterator) {
    return (paramIterator instanceof PeekingImpl) ? (PeekingImpl)paramIterator : new PeekingImpl<T>(paramIterator);
  }
  
  static <T> ListIterator<T> j(Iterator<T> paramIterator) {
    return (ListIterator<T>)paramIterator;
  }
  
  static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
    static final UnmodifiableListIterator<Object> a = new ArrayItr((T[])new Object[0], 0, 0, 0);
    
    private final T[] b;
    
    private final int c;
    
    ArrayItr(T[] param1ArrayOfT, int param1Int1, int param1Int2, int param1Int3) {
      super(param1Int2, param1Int3);
      this.b = param1ArrayOfT;
      this.c = param1Int1;
    }
    
    protected T a(int param1Int) {
      return this.b[this.c + param1Int];
    }
  }
  
  static class ConcatenatedIterator<T> implements Iterator<T> {
    @NullableDecl
    private Iterator<? extends T> a;
    
    private Iterator<? extends T> b = Iterators.a();
    
    private Iterator<? extends Iterator<? extends T>> c;
    
    @NullableDecl
    private Deque<Iterator<? extends Iterator<? extends T>>> d;
    
    ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> param1Iterator) {
      this.c = (Iterator<? extends Iterator<? extends T>>)Preconditions.a(param1Iterator);
    }
    
    @NullableDecl
    private Iterator<? extends Iterator<? extends T>> a() {
      while (true) {
        Iterator<? extends Iterator<? extends T>> iterator = this.c;
        if (iterator == null || !iterator.hasNext()) {
          Deque<Iterator<? extends Iterator<? extends T>>> deque = this.d;
          if (deque != null && !deque.isEmpty()) {
            this.c = this.d.removeFirst();
            continue;
          } 
          break;
        } 
        return this.c;
      } 
      return null;
    }
    
    public boolean hasNext() {
      while (!((Iterator)Preconditions.a(this.b)).hasNext()) {
        this.c = a();
        Iterator<? extends Iterator<? extends T>> iterator1 = this.c;
        if (iterator1 == null)
          return false; 
        this.b = iterator1.next();
        Iterator<? extends T> iterator = this.b;
        if (iterator instanceof ConcatenatedIterator) {
          iterator = iterator;
          this.b = ((ConcatenatedIterator)iterator).b;
          if (this.d == null)
            this.d = new ArrayDeque<Iterator<? extends Iterator<? extends T>>>(); 
          this.d.addFirst(this.c);
          if (((ConcatenatedIterator)iterator).d != null)
            while (!((ConcatenatedIterator)iterator).d.isEmpty())
              this.d.addFirst(((ConcatenatedIterator)iterator).d.removeLast());  
          this.c = ((ConcatenatedIterator)iterator).c;
        } 
      } 
      return true;
    }
    
    public T next() {
      if (hasNext()) {
        Iterator<? extends T> iterator = this.b;
        this.a = iterator;
        return iterator.next();
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      boolean bool;
      if (this.a != null) {
        bool = true;
      } else {
        bool = false;
      } 
      CollectPreconditions.a(bool);
      this.a.remove();
      this.a = null;
    }
  }
  
  enum EmptyModifiableIterator implements Iterator<Object> {
    a;
    
    public boolean hasNext() {
      return false;
    }
    
    public Object next() {
      throw new NoSuchElementException();
    }
    
    public void remove() {
      CollectPreconditions.a(false);
    }
  }
  
  static class MergingIterator<T> extends UnmodifiableIterator<T> {
    final Queue<PeekingIterator<T>> a;
    
    public MergingIterator(Iterable<? extends Iterator<? extends T>> param1Iterable, Comparator<? super T> param1Comparator) {
      this.a = new PriorityQueue<PeekingIterator<T>>(2, (Comparator)new Comparator<PeekingIterator<PeekingIterator<T>>>(this, param1Comparator) {
            public int a(PeekingIterator<T> param2PeekingIterator1, PeekingIterator<T> param2PeekingIterator2) {
              return this.a.compare(param2PeekingIterator1.a(), param2PeekingIterator2.a());
            }
          });
      for (Iterator<? extends T> iterator : param1Iterable) {
        if (iterator.hasNext())
          this.a.add(Iterators.i(iterator)); 
      } 
    }
    
    public boolean hasNext() {
      return this.a.isEmpty() ^ true;
    }
    
    public T next() {
      PeekingIterator<Object> peekingIterator = (PeekingIterator)this.a.remove();
      T t = (T)peekingIterator.next();
      if (peekingIterator.hasNext())
        this.a.add(peekingIterator); 
      return t;
    }
  }
  
  class null implements Comparator<PeekingIterator<T>> {
    null(Iterators this$0, Comparator param1Comparator) {}
    
    public int a(PeekingIterator<T> param1PeekingIterator1, PeekingIterator<T> param1PeekingIterator2) {
      return this.a.compare(param1PeekingIterator1.a(), param1PeekingIterator2.a());
    }
  }
  
  static class PeekingImpl<E> implements PeekingIterator<E> {
    private final Iterator<? extends E> a;
    
    private boolean b;
    
    @NullableDecl
    private E c;
    
    public PeekingImpl(Iterator<? extends E> param1Iterator) {
      this.a = (Iterator<? extends E>)Preconditions.a(param1Iterator);
    }
    
    public E a() {
      if (!this.b) {
        this.c = this.a.next();
        this.b = true;
      } 
      return this.c;
    }
    
    public boolean hasNext() {
      return (this.b || this.a.hasNext());
    }
    
    public E next() {
      if (!this.b)
        return this.a.next(); 
      E e = this.c;
      this.b = false;
      this.c = null;
      return e;
    }
    
    public void remove() {
      Preconditions.b(this.b ^ true, "Can't remove after you've peeked at next");
      this.a.remove();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Iterators.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */