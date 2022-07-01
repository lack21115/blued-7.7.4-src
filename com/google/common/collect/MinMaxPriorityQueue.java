package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
  final int a;
  
  private final Heap b;
  
  private final Heap c;
  
  private Object[] d;
  
  private int e;
  
  private int f;
  
  private static int a(int paramInt1, int paramInt2) {
    return Math.min(paramInt1 - 1, paramInt2) + 1;
  }
  
  private MoveDesc<E> a(int paramInt, E paramE) {
    Heap heap = e(paramInt);
    int i = heap.c(paramInt);
    int j = heap.b(i, paramE);
    return (j == i) ? heap.a(paramInt, i, paramE) : ((j < paramInt) ? new MoveDesc<E>(paramE, a(paramInt)) : null);
  }
  
  private int b() {
    int i = this.e;
    byte b = 1;
    if (i != 1) {
      if (i != 2) {
        if (this.c.a(1, 2) <= 0)
          return 1; 
        b = 2;
      } 
      return b;
    } 
    return 0;
  }
  
  private void c() {
    if (this.e > this.d.length) {
      Object[] arrayOfObject1 = new Object[d()];
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.d = arrayOfObject1;
    } 
  }
  
  static boolean c(int paramInt) {
    boolean bool;
    if (++paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool, "negative index");
    return ((0x55555555 & paramInt) > (paramInt & 0xAAAAAAAA));
  }
  
  private int d() {
    int i = this.d.length;
    if (i < 64) {
      i = (i + 1) * 2;
    } else {
      i = IntMath.d(i / 2, 3);
    } 
    return a(i, this.a);
  }
  
  private E d(int paramInt) {
    E e = a(paramInt);
    b(paramInt);
    return e;
  }
  
  private Heap e(int paramInt) {
    return c(paramInt) ? this.b : this.c;
  }
  
  public E a() {
    return isEmpty() ? null : d(b());
  }
  
  E a(int paramInt) {
    return (E)this.d[paramInt];
  }
  
  public boolean add(E paramE) {
    offer(paramE);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection) {
    Iterator<? extends E> iterator = paramCollection.iterator();
    boolean bool;
    for (bool = false; iterator.hasNext(); bool = true)
      offer(iterator.next()); 
    return bool;
  }
  
  MoveDesc<E> b(int paramInt) {
    Preconditions.b(paramInt, this.e);
    this.f++;
    int i = --this.e;
    if (i == paramInt) {
      this.d[i] = null;
      return null;
    } 
    E e1 = a(i);
    i = e(this.e).a(e1);
    if (i == paramInt) {
      this.d[this.e] = null;
      return null;
    } 
    E e2 = a(this.e);
    this.d[this.e] = null;
    MoveDesc<E> moveDesc = a(paramInt, e2);
    return (i < paramInt) ? ((moveDesc == null) ? new MoveDesc<E>(e1, e2) : new MoveDesc<E>(e1, moveDesc.b)) : moveDesc;
  }
  
  public void clear() {
    for (int i = 0; i < this.e; i++)
      this.d[i] = null; 
    this.e = 0;
  }
  
  public Iterator<E> iterator() {
    return new QueueIterator();
  }
  
  public boolean offer(E paramE) {
    Preconditions.a(paramE);
    int i = this.f;
    boolean bool = true;
    this.f = i + 1;
    i = this.e;
    this.e = i + 1;
    c();
    e(i).a(i, paramE);
    if (this.e > this.a) {
      if (a() != paramE)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public E peek() {
    return isEmpty() ? null : a(0);
  }
  
  public E poll() {
    return isEmpty() ? null : d(0);
  }
  
  public int size() {
    return this.e;
  }
  
  public Object[] toArray() {
    int i = this.e;
    Object[] arrayOfObject = new Object[i];
    System.arraycopy(this.d, 0, arrayOfObject, 0, i);
    return arrayOfObject;
  }
  
  public static final class Builder<B> {}
  
  class Heap {
    final Ordering<E> a;
    
    @NullableDecl
    Heap b;
    
    private int d(int param1Int) {
      return param1Int * 2 + 1;
    }
    
    private int e(int param1Int) {
      return param1Int * 2 + 2;
    }
    
    private int f(int param1Int) {
      return (param1Int - 1) / 2;
    }
    
    private int g(int param1Int) {
      return f(f(param1Int));
    }
    
    int a(int param1Int) {
      return b(d(param1Int), 2);
    }
    
    int a(int param1Int1, int param1Int2) {
      return this.a.compare(this.c.a(param1Int1), this.c.a(param1Int2));
    }
    
    int a(E param1E) {
      int i = f(MinMaxPriorityQueue.b(this.c));
      if (i != 0) {
        int j = e(f(i));
        if (j != i && d(j) >= MinMaxPriorityQueue.b(this.c)) {
          E e = (E)this.c.a(j);
          if (this.a.compare(e, param1E) < 0) {
            MinMaxPriorityQueue.a(this.c)[j] = param1E;
            MinMaxPriorityQueue.a(this.c)[MinMaxPriorityQueue.b(this.c)] = e;
            return j;
          } 
        } 
      } 
      return MinMaxPriorityQueue.b(this.c);
    }
    
    MinMaxPriorityQueue.MoveDesc<E> a(int param1Int1, int param1Int2, E param1E) {
      E e;
      int i = d(param1Int2, param1E);
      if (i == param1Int2)
        return null; 
      if (i < param1Int1) {
        e = (E)this.c.a(param1Int1);
      } else {
        e = (E)this.c.a(f(param1Int1));
      } 
      return (this.b.b(i, param1E) < param1Int1) ? new MinMaxPriorityQueue.MoveDesc<E>(param1E, e) : null;
    }
    
    void a(int param1Int, E param1E) {
      Heap heap;
      int i = c(param1Int, param1E);
      if (i == param1Int) {
        heap = this;
      } else {
        heap = this.b;
        param1Int = i;
      } 
      heap.b(param1Int, param1E);
    }
    
    int b(int param1Int) {
      param1Int = d(param1Int);
      return (param1Int < 0) ? -1 : b(d(param1Int), 4);
    }
    
    int b(int param1Int1, int param1Int2) {
      boolean bool;
      if (param1Int1 >= MinMaxPriorityQueue.b(this.c))
        return -1; 
      if (param1Int1 > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool);
      int j = Math.min(param1Int1, MinMaxPriorityQueue.b(this.c) - param1Int2);
      int i = param1Int1 + 1;
      while (i < j + param1Int2) {
        int k = param1Int1;
        if (a(i, param1Int1) < 0)
          k = i; 
        i++;
        param1Int1 = k;
      } 
      return param1Int1;
    }
    
    int b(int param1Int, E param1E) {
      while (param1Int > 2) {
        int i = g(param1Int);
        E e = (E)this.c.a(i);
        if (this.a.compare(e, param1E) <= 0)
          break; 
        MinMaxPriorityQueue.a(this.c)[param1Int] = e;
        param1Int = i;
      } 
      MinMaxPriorityQueue.a(this.c)[param1Int] = param1E;
      return param1Int;
    }
    
    int c(int param1Int) {
      while (true) {
        int i = b(param1Int);
        if (i > 0) {
          MinMaxPriorityQueue.a(this.c)[param1Int] = this.c.a(i);
          param1Int = i;
          continue;
        } 
        return param1Int;
      } 
    }
    
    int c(int param1Int, E param1E) {
      E e1;
      if (param1Int == 0) {
        MinMaxPriorityQueue.a(this.c)[0] = param1E;
        return 0;
      } 
      int j = f(param1Int);
      E e3 = (E)this.c.a(j);
      int i = j;
      E e2 = e3;
      if (j != 0) {
        int k = e(f(j));
        i = j;
        e2 = e3;
        if (k != j) {
          i = j;
          e2 = e3;
          if (d(k) >= MinMaxPriorityQueue.b(this.c)) {
            E e = (E)this.c.a(k);
            i = j;
            e2 = e3;
            if (this.a.compare(e, e3) < 0) {
              i = k;
              e1 = e;
            } 
          } 
        } 
      } 
      if (this.a.compare(e1, param1E) < 0) {
        MinMaxPriorityQueue.a(this.c)[param1Int] = e1;
        MinMaxPriorityQueue.a(this.c)[i] = param1E;
        return i;
      } 
      MinMaxPriorityQueue.a(this.c)[param1Int] = param1E;
      return param1Int;
    }
    
    int d(int param1Int, E param1E) {
      int i = a(param1Int);
      if (i > 0 && this.a.compare(this.c.a(i), param1E) < 0) {
        MinMaxPriorityQueue.a(this.c)[param1Int] = this.c.a(i);
        MinMaxPriorityQueue.a(this.c)[i] = param1E;
        return i;
      } 
      return c(param1Int, param1E);
    }
  }
  
  static class MoveDesc<E> {
    final E a;
    
    final E b;
    
    MoveDesc(E param1E1, E param1E2) {
      this.a = param1E1;
      this.b = param1E2;
    }
  }
  
  class QueueIterator implements Iterator<E> {
    private int b = -1;
    
    private int c = -1;
    
    private int d = MinMaxPriorityQueue.c(this.a);
    
    @NullableDecl
    private Queue<E> e;
    
    @NullableDecl
    private List<E> f;
    
    @NullableDecl
    private E g;
    
    private boolean h;
    
    private QueueIterator(MinMaxPriorityQueue this$0) {}
    
    private void a() {
      if (MinMaxPriorityQueue.c(this.a) == this.d)
        return; 
      throw new ConcurrentModificationException();
    }
    
    private void a(int param1Int) {
      if (this.c < param1Int) {
        int i = param1Int;
        if (this.f != null)
          while (true) {
            i = param1Int;
            if (param1Int < this.a.size()) {
              i = param1Int;
              if (a(this.f, this.a.a(param1Int))) {
                param1Int++;
                continue;
              } 
            } 
            break;
          }  
        this.c = i;
      } 
    }
    
    private boolean a(Iterable<E> param1Iterable, E param1E) {
      Iterator<E> iterator = param1Iterable.iterator();
      while (iterator.hasNext()) {
        if (iterator.next() == param1E) {
          iterator.remove();
          return true;
        } 
      } 
      return false;
    }
    
    private boolean a(Object param1Object) {
      for (int i = 0; i < MinMaxPriorityQueue.b(this.a); i++) {
        if (MinMaxPriorityQueue.a(this.a)[i] == param1Object) {
          this.a.b(i);
          return true;
        } 
      } 
      return false;
    }
    
    public boolean hasNext() {
      a();
      int i = this.b;
      boolean bool = true;
      a(i + 1);
      if (this.c >= this.a.size()) {
        Queue<E> queue = this.e;
        if (queue != null && !queue.isEmpty())
          return true; 
        bool = false;
      } 
      return bool;
    }
    
    public E next() {
      a();
      a(this.b + 1);
      if (this.c < this.a.size()) {
        this.b = this.c;
        this.h = true;
        return this.a.a(this.b);
      } 
      if (this.e != null) {
        this.b = this.a.size();
        this.g = this.e.poll();
        E e = this.g;
        if (e != null) {
          this.h = true;
          return e;
        } 
      } 
      throw new NoSuchElementException("iterator moved past last element in queue.");
    }
    
    public void remove() {
      CollectPreconditions.a(this.h);
      a();
      this.h = false;
      this.d++;
      if (this.b < this.a.size()) {
        MinMaxPriorityQueue.MoveDesc moveDesc = this.a.b(this.b);
        if (moveDesc != null) {
          if (this.e == null) {
            this.e = new ArrayDeque<E>();
            this.f = new ArrayList<E>(3);
          } 
          if (!a(this.f, moveDesc.a))
            this.e.add(moveDesc.a); 
          if (!a(this.e, moveDesc.b))
            this.f.add(moveDesc.b); 
        } 
        this.b--;
        this.c--;
        return;
      } 
      Preconditions.b(a(this.g));
      this.g = null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\MinMaxPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */