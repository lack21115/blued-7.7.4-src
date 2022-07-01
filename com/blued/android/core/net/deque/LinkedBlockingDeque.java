package com.blued.android.core.net.deque;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
  transient Node<E> a;
  
  transient Node<E> b;
  
  final ReentrantLock c = new ReentrantLock();
  
  private transient int d;
  
  private final int e;
  
  private final Condition f = this.c.newCondition();
  
  private final Condition g = this.c.newCondition();
  
  public LinkedBlockingDeque() {
    this(2147483647);
  }
  
  public LinkedBlockingDeque(int paramInt) {
    if (paramInt > 0) {
      this.e = paramInt;
      return;
    } 
    throw new IllegalArgumentException();
  }
  
  private boolean b(Node<E> paramNode) {
    if (this.d >= this.e)
      return false; 
    Node<E> node = this.a;
    paramNode.c = node;
    this.a = paramNode;
    if (this.b == null) {
      this.b = paramNode;
    } else {
      node.b = paramNode;
    } 
    this.d++;
    this.f.signal();
    return true;
  }
  
  private boolean c(Node<E> paramNode) {
    if (this.d >= this.e)
      return false; 
    Node<E> node = this.b;
    paramNode.b = node;
    this.b = paramNode;
    if (this.a == null) {
      this.a = paramNode;
    } else {
      node.c = paramNode;
    } 
    this.d++;
    this.f.signal();
    return true;
  }
  
  private E f() {
    Node<E> node1 = this.a;
    if (node1 == null)
      return null; 
    Node<E> node2 = node1.c;
    E e = node1.a;
    node1.a = null;
    node1.c = node1;
    this.a = node2;
    if (node2 == null) {
      this.b = null;
    } else {
      node2.b = null;
    } 
    this.d--;
    this.g.signal();
    return e;
  }
  
  private E g() {
    Node<E> node1 = this.b;
    if (node1 == null)
      return null; 
    Node<E> node2 = node1.b;
    E e = node1.a;
    node1.a = null;
    node1.b = node1;
    this.b = node2;
    if (node2 == null) {
      this.a = null;
    } else {
      node2.c = null;
    } 
    this.d--;
    this.g.signal();
    return e;
  }
  
  public E a() {
    E e = b();
    if (e != null)
      return e; 
    throw new NoSuchElementException();
  }
  
  public E a(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    paramLong = paramTimeUnit.toNanos(paramLong);
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lockInterruptibly();
    try {
      while (true) {
        E e = f();
        if (e == null) {
          if (paramLong <= 0L)
            return null; 
          paramLong = this.f.awaitNanos(paramLong);
          continue;
        } 
        return e;
      } 
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  void a(Node<E> paramNode) {
    Node<E> node1 = paramNode.b;
    Node<E> node2 = paramNode.c;
    if (node1 == null) {
      f();
      return;
    } 
    if (node2 == null) {
      g();
      return;
    } 
    node1.c = node2;
    node2.b = node1;
    paramNode.a = null;
    this.d--;
    this.g.signal();
  }
  
  public void a(E paramE) {
    if (c(paramE))
      return; 
    throw new IllegalStateException("Deque full");
  }
  
  public boolean a(E paramE, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    if (paramE != null) {
      null = new Node<E>(paramE);
      paramLong = paramTimeUnit.toNanos(paramLong);
      ReentrantLock reentrantLock = this.c;
      reentrantLock.lockInterruptibly();
      try {
        while (true) {
          boolean bool = c(null);
          if (!bool) {
            if (paramLong <= 0L) {
              bool = false;
              return bool;
            } 
            paramLong = this.g.awaitNanos(paramLong);
            continue;
          } 
          bool = true;
          return bool;
        } 
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new NullPointerException();
  }
  
  public boolean add(E paramE) {
    a(paramE);
    return true;
  }
  
  public E b() {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      return f();
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public boolean b(E paramE) {
    if (paramE != null) {
      null = new Node<E>(paramE);
      ReentrantLock reentrantLock = this.c;
      reentrantLock.lock();
      try {
        return b(null);
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new NullPointerException();
  }
  
  public E c() throws InterruptedException {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      while (true) {
        E e = f();
        if (e == null) {
          this.f.await();
          continue;
        } 
        return e;
      } 
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public boolean c(E paramE) {
    if (paramE != null) {
      null = new Node<E>(paramE);
      ReentrantLock reentrantLock = this.c;
      reentrantLock.lock();
      try {
        return c(null);
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new NullPointerException();
  }
  
  public void clear() {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      for (Node<E> node = this.a; node != null; node = node1) {
        node.a = null;
        Node<E> node1 = node.c;
        node.b = null;
        node.c = null;
      } 
      this.b = null;
      this.a = null;
      this.d = 0;
      this.g.signalAll();
      return;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public boolean contains(Object paramObject) {
    if (paramObject == null)
      return false; 
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      for (Node<E> node = this.a; node != null; node = node.c) {
        boolean bool = paramObject.equals(node.a);
        if (bool)
          return true; 
      } 
      return false;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public E d() {
    E e = e();
    if (e != null)
      return e; 
    throw new NoSuchElementException();
  }
  
  public void d(E paramE) throws InterruptedException {
    if (paramE != null) {
      null = new Node<E>(paramE);
      ReentrantLock reentrantLock = this.c;
      reentrantLock.lock();
      try {
        while (!c(null))
          this.g.await(); 
        return;
      } finally {
        reentrantLock.unlock();
      } 
    } 
    throw new NullPointerException();
  }
  
  public int drainTo(Collection<? super E> paramCollection) {
    return drainTo(paramCollection, 2147483647);
  }
  
  public int drainTo(Collection<? super E> paramCollection, int paramInt) {
    if (paramCollection != null) {
      if (paramCollection != this) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
          int i = Math.min(paramInt, this.d);
          for (paramInt = 0; paramInt < i; paramInt++) {
            paramCollection.add(this.a.a);
            f();
          } 
          return i;
        } finally {
          reentrantLock.unlock();
        } 
      } 
      throw new IllegalArgumentException();
    } 
    throw new NullPointerException();
  }
  
  public E e() {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      E e;
      if (this.a == null) {
        Object object = null;
      } else {
        e = this.a.a;
      } 
      return e;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public boolean e(Object paramObject) {
    if (paramObject == null)
      return false; 
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      for (Node<E> node = this.a; node != null; node = node.c) {
        if (paramObject.equals(node.a)) {
          a(node);
          return true;
        } 
      } 
      return false;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public E element() {
    return d();
  }
  
  public Iterator<E> iterator() {
    return new Itr();
  }
  
  public boolean offer(E paramE) {
    return c(paramE);
  }
  
  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return a(paramE, paramLong, paramTimeUnit);
  }
  
  public E peek() {
    return e();
  }
  
  public E poll() {
    return b();
  }
  
  public E poll(long paramLong, TimeUnit paramTimeUnit) throws InterruptedException {
    return a(paramLong, paramTimeUnit);
  }
  
  public void put(E paramE) throws InterruptedException {
    d(paramE);
  }
  
  public int remainingCapacity() {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      int i = this.e;
      int j = this.d;
      return i - j;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public E remove() {
    return a();
  }
  
  public boolean remove(Object paramObject) {
    return e(paramObject);
  }
  
  public int size() {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      return this.d;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public E take() throws InterruptedException {
    return c();
  }
  
  public Object[] toArray() {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      Object[] arrayOfObject = new Object[this.d];
      int i = 0;
      Node<E> node = this.a;
      while (node != null) {
        arrayOfObject[i] = node.a;
        node = node.c;
        i++;
      } 
      return arrayOfObject;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    T[] arrayOfT = paramArrayOfT;
    try {
      if (paramArrayOfT.length < this.d)
        arrayOfT = (T[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.d); 
      int i = 0;
      Node<E> node = this.a;
      while (node != null) {
        arrayOfT[i] = (T)node.a;
        node = node.c;
        i++;
      } 
      if (arrayOfT.length > i)
        arrayOfT[i] = null; 
      return arrayOfT;
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  public String toString() {
    ReentrantLock reentrantLock = this.c;
    reentrantLock.lock();
    try {
      Node<E> node = this.a;
      if (node == null)
        return "[]"; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append('[');
      while (true) {
        String str;
        E e2 = node.a;
        E e1 = e2;
        if (e2 == this)
          str = "(this Collection)"; 
        stringBuilder.append(str);
        node = node.c;
        if (node == null) {
          stringBuilder.append(']');
          return stringBuilder.toString();
        } 
        stringBuilder.append(',');
        stringBuilder.append(' ');
      } 
    } finally {
      reentrantLock.unlock();
    } 
  }
  
  abstract class AbstractItr implements Iterator<E> {
    LinkedBlockingDeque.Node<E> a;
    
    E b;
    
    private LinkedBlockingDeque.Node<E> d;
    
    AbstractItr(LinkedBlockingDeque this$0) {
      ReentrantLock reentrantLock = this$0.c;
      reentrantLock.lock();
      try {
        E e;
        this.a = a();
        if (this.a == null) {
          this$0 = null;
        } else {
          e = this.a.a;
        } 
        this.b = e;
        return;
      } finally {
        reentrantLock.unlock();
      } 
    }
    
    private LinkedBlockingDeque.Node<E> b(LinkedBlockingDeque.Node<E> param1Node) {
      while (true) {
        LinkedBlockingDeque.Node<E> node = a(param1Node);
        if (node == null)
          return null; 
        if (node.a != null)
          return node; 
        if (node == param1Node)
          return a(); 
        param1Node = node;
      } 
    }
    
    abstract LinkedBlockingDeque.Node<E> a();
    
    abstract LinkedBlockingDeque.Node<E> a(LinkedBlockingDeque.Node<E> param1Node);
    
    void b() {
      ReentrantLock reentrantLock = this.c.c;
      reentrantLock.lock();
      try {
        E e;
        this.a = b(this.a);
        if (this.a == null) {
          Object object = null;
        } else {
          e = this.a.a;
        } 
        this.b = e;
        return;
      } finally {
        reentrantLock.unlock();
      } 
    }
    
    public boolean hasNext() {
      return (this.a != null);
    }
    
    public E next() {
      LinkedBlockingDeque.Node<E> node = this.a;
      if (node != null) {
        this.d = node;
        E e = this.b;
        b();
        return e;
      } 
      throw new NoSuchElementException();
    }
    
    public void remove() {
      LinkedBlockingDeque.Node<E> node = this.d;
      if (node != null) {
        this.d = null;
        ReentrantLock reentrantLock = this.c.c;
        reentrantLock.lock();
        try {
          if (node.a != null)
            this.c.a(node); 
          return;
        } finally {
          reentrantLock.unlock();
        } 
      } 
      throw new IllegalStateException();
    }
  }
  
  class DescendingItr extends AbstractItr {
    LinkedBlockingDeque.Node<E> a() {
      return this.d.b;
    }
    
    LinkedBlockingDeque.Node<E> a(LinkedBlockingDeque.Node<E> param1Node) {
      return param1Node.b;
    }
  }
  
  class Itr extends AbstractItr {
    private Itr(LinkedBlockingDeque this$0) {}
    
    LinkedBlockingDeque.Node<E> a() {
      return this.d.a;
    }
    
    LinkedBlockingDeque.Node<E> a(LinkedBlockingDeque.Node<E> param1Node) {
      return param1Node.c;
    }
  }
  
  static final class Node<E> {
    E a;
    
    Node<E> b;
    
    Node<E> c;
    
    Node(E param1E) {
      this.a = param1E;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\deque\LinkedBlockingDeque.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */