package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
  private final transient Reference<AvlNode<E>> b;
  
  private final transient GeneralRange<E> c;
  
  private final transient AvlNode<E> d;
  
  TreeMultiset(Reference<AvlNode<E>> paramReference, GeneralRange<E> paramGeneralRange, AvlNode<E> paramAvlNode) {
    super(paramGeneralRange.a());
    this.b = paramReference;
    this.c = paramGeneralRange;
    this.d = paramAvlNode;
  }
  
  static int a(@NullableDecl AvlNode<?> paramAvlNode) {
    return (paramAvlNode == null) ? 0 : AvlNode.c(paramAvlNode);
  }
  
  private long a(Aggregate paramAggregate) {
    AvlNode<?> avlNode = this.b.a();
    long l2 = paramAggregate.b(avlNode);
    long l1 = l2;
    if (this.c.b())
      l1 = l2 - a(paramAggregate, (AvlNode)avlNode); 
    l2 = l1;
    if (this.c.c())
      l2 = l1 - b(paramAggregate, (AvlNode)avlNode); 
    return l2;
  }
  
  private long a(Aggregate paramAggregate, @NullableDecl AvlNode<E> paramAvlNode) {
    if (paramAvlNode == null)
      return 0L; 
    int i = comparator().compare(this.c.d(), AvlNode.d(paramAvlNode));
    if (i < 0)
      return a(paramAggregate, AvlNode.e(paramAvlNode)); 
    if (i == 0) {
      i = null.a[this.c.e().ordinal()];
      if (i != 1) {
        if (i == 2)
          return paramAggregate.b(AvlNode.e(paramAvlNode)); 
        throw new AssertionError();
      } 
      long l3 = paramAggregate.a(paramAvlNode);
      long l4 = paramAggregate.b(AvlNode.e(paramAvlNode));
      return l3 + l4;
    } 
    long l1 = paramAggregate.b(AvlNode.e(paramAvlNode)) + paramAggregate.a(paramAvlNode);
    long l2 = a(paramAggregate, AvlNode.f(paramAvlNode));
    return l1 + l2;
  }
  
  private long b(Aggregate paramAggregate, @NullableDecl AvlNode<E> paramAvlNode) {
    if (paramAvlNode == null)
      return 0L; 
    int i = comparator().compare(this.c.f(), AvlNode.d(paramAvlNode));
    if (i > 0)
      return b(paramAggregate, AvlNode.f(paramAvlNode)); 
    if (i == 0) {
      i = null.a[this.c.g().ordinal()];
      if (i != 1) {
        if (i == 2)
          return paramAggregate.b(AvlNode.f(paramAvlNode)); 
        throw new AssertionError();
      } 
      long l3 = paramAggregate.a(paramAvlNode);
      long l4 = paramAggregate.b(AvlNode.f(paramAvlNode));
      return l3 + l4;
    } 
    long l1 = paramAggregate.b(AvlNode.f(paramAvlNode)) + paramAggregate.a(paramAvlNode);
    long l2 = b(paramAggregate, AvlNode.e(paramAvlNode));
    return l1 + l2;
  }
  
  private Multiset.Entry<E> b(AvlNode<E> paramAvlNode) {
    return new Multisets.AbstractEntry<E>(this, paramAvlNode) {
        public int b() {
          int j = this.a.b();
          int i = j;
          if (j == 0)
            i = this.b.a(c()); 
          return i;
        }
        
        public E c() {
          return this.a.a();
        }
      };
  }
  
  private static <T> void b(AvlNode<T> paramAvlNode1, AvlNode<T> paramAvlNode2) {
    AvlNode.d(paramAvlNode1, paramAvlNode2);
    AvlNode.c(paramAvlNode2, paramAvlNode1);
  }
  
  private static <T> void b(AvlNode<T> paramAvlNode1, AvlNode<T> paramAvlNode2, AvlNode<T> paramAvlNode3) {
    b(paramAvlNode1, paramAvlNode2);
    b(paramAvlNode2, paramAvlNode3);
  }
  
  @NullableDecl
  private AvlNode<E> r() {
    AvlNode<E> avlNode;
    if ((AvlNode)this.b.a() == null)
      return null; 
    if (this.c.b()) {
      E e = this.c.d();
      AvlNode<E> avlNode1 = AvlNode.a(this.b.a(), comparator(), e);
      if (avlNode1 == null)
        return null; 
      avlNode = avlNode1;
      if (this.c.e() == BoundType.a) {
        avlNode = avlNode1;
        if (comparator().compare(e, avlNode1.a()) == 0)
          avlNode = AvlNode.g(avlNode1); 
      } 
    } else {
      avlNode = AvlNode.g(this.d);
    } 
    if (avlNode != this.d) {
      AvlNode<E> avlNode1 = avlNode;
      return !this.c.c(avlNode.a()) ? null : avlNode1;
    } 
    return null;
  }
  
  @NullableDecl
  private AvlNode<E> s() {
    AvlNode<E> avlNode;
    if ((AvlNode)this.b.a() == null)
      return null; 
    if (this.c.c()) {
      E e = this.c.f();
      AvlNode<E> avlNode1 = AvlNode.b(this.b.a(), comparator(), e);
      if (avlNode1 == null)
        return null; 
      avlNode = avlNode1;
      if (this.c.g() == BoundType.a) {
        avlNode = avlNode1;
        if (comparator().compare(e, avlNode1.a()) == 0)
          avlNode = AvlNode.h(avlNode1); 
      } 
    } else {
      avlNode = AvlNode.h(this.d);
    } 
    if (avlNode != this.d) {
      AvlNode<E> avlNode1 = avlNode;
      return !this.c.c(avlNode.a()) ? null : avlNode1;
    } 
    return null;
  }
  
  public int a(@NullableDecl Object paramObject) {
    try {
      AvlNode<Object> avlNode = (AvlNode)this.b.a();
      return this.c.c((E)paramObject) ? ((avlNode == null) ? 0 : avlNode.a(comparator(), paramObject)) : 0;
    } catch (ClassCastException|NullPointerException classCastException) {
      return 0;
    } 
  }
  
  public int a(@NullableDecl E paramE, int paramInt) {
    CollectPreconditions.a(paramInt, "occurrences");
    if (paramInt == 0)
      return a(paramE); 
    Preconditions.a(this.c.c(paramE));
    AvlNode<E> avlNode2 = this.b.a();
    if (avlNode2 == null) {
      comparator().compare(paramE, paramE);
      avlNode1 = new AvlNode<E>(paramE, paramInt);
      AvlNode<E> avlNode = this.d;
      b(avlNode, avlNode1, avlNode);
      this.b.a(avlNode2, avlNode1);
      return 0;
    } 
    int[] arrayOfInt = new int[1];
    AvlNode<E> avlNode1 = avlNode2.a(comparator(), (E)avlNode1, paramInt, arrayOfInt);
    this.b.a(avlNode2, avlNode1);
    return arrayOfInt[0];
  }
  
  Iterator<E> a() {
    return Multisets.a(b());
  }
  
  public boolean a(@NullableDecl E paramE, int paramInt1, int paramInt2) {
    CollectPreconditions.a(paramInt2, "newCount");
    CollectPreconditions.a(paramInt1, "oldCount");
    Preconditions.a(this.c.c(paramE));
    AvlNode<E> avlNode2 = this.b.a();
    boolean bool = false;
    if (avlNode2 == null) {
      if (paramInt1 == 0) {
        if (paramInt2 > 0)
          a(paramE, paramInt2); 
        return true;
      } 
      return false;
    } 
    int[] arrayOfInt = new int[1];
    AvlNode<E> avlNode1 = avlNode2.a(comparator(), paramE, paramInt1, paramInt2, arrayOfInt);
    this.b.a(avlNode2, avlNode1);
    if (arrayOfInt[0] == paramInt1)
      bool = true; 
    return bool;
  }
  
  public int b(@NullableDecl Object paramObject, int paramInt) {
    CollectPreconditions.a(paramInt, "occurrences");
    if (paramInt == 0)
      return a(paramObject); 
    AvlNode<Object> avlNode = (AvlNode)this.b.a();
    int[] arrayOfInt = new int[1];
    try {
      if (this.c.c((E)paramObject)) {
        if (avlNode == null)
          return 0; 
        paramObject = avlNode.b(comparator(), paramObject, paramInt, arrayOfInt);
        this.b.a(avlNode, paramObject);
        return arrayOfInt[0];
      } 
      return 0;
    } catch (ClassCastException|NullPointerException classCastException) {
      return 0;
    } 
  }
  
  Iterator<Multiset.Entry<E>> b() {
    return (Iterator)new Iterator<Multiset.Entry<Multiset.Entry<E>>>(this) {
        TreeMultiset.AvlNode<E> a = TreeMultiset.a(this.c);
        
        @NullableDecl
        Multiset.Entry<E> b;
        
        public Multiset.Entry<E> a() {
          if (hasNext()) {
            Multiset.Entry<E> entry = TreeMultiset.a(this.c, this.a);
            this.b = entry;
            if (TreeMultiset.AvlNode.g(this.a) == TreeMultiset.c(this.c)) {
              this.a = null;
              return entry;
            } 
            this.a = TreeMultiset.AvlNode.g(this.a);
            return entry;
          } 
          throw new NoSuchElementException();
        }
        
        public boolean hasNext() {
          if (this.a == null)
            return false; 
          if (TreeMultiset.b(this.c).b(this.a.a())) {
            this.a = null;
            return false;
          } 
          return true;
        }
        
        public void remove() {
          boolean bool;
          if (this.b != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.a(bool);
          this.c.c(this.b.c(), 0);
          this.b = null;
        }
      };
  }
  
  int c() {
    return Ints.b(a(Aggregate.b));
  }
  
  public int c(@NullableDecl E paramE, int paramInt) {
    CollectPreconditions.a(paramInt, "count");
    boolean bool1 = this.c.c(paramE);
    boolean bool = true;
    if (!bool1) {
      if (paramInt != 0)
        bool = false; 
      Preconditions.a(bool);
      return 0;
    } 
    AvlNode<E> avlNode2 = this.b.a();
    if (avlNode2 == null) {
      if (paramInt > 0)
        a(paramE, paramInt); 
      return 0;
    } 
    int[] arrayOfInt = new int[1];
    AvlNode<E> avlNode1 = avlNode2.c(comparator(), paramE, paramInt, arrayOfInt);
    this.b.a(avlNode2, avlNode1);
    return arrayOfInt[0];
  }
  
  public SortedMultiset<E> c(@NullableDecl E paramE, BoundType paramBoundType) {
    return new TreeMultiset(this.b, this.c.a(GeneralRange.a(comparator(), paramE, paramBoundType)), this.d);
  }
  
  public void clear() {
    if (!this.c.b() && !this.c.c()) {
      AvlNode<E> avlNode = AvlNode.g(this.d);
      while (true) {
        AvlNode<E> avlNode1 = this.d;
        if (avlNode != avlNode1) {
          avlNode1 = AvlNode.g(avlNode);
          AvlNode.a(avlNode, 0);
          AvlNode.a(avlNode, (AvlNode)null);
          AvlNode.b(avlNode, (AvlNode)null);
          AvlNode.c(avlNode, (AvlNode)null);
          AvlNode.d(avlNode, null);
          avlNode = avlNode1;
          continue;
        } 
        b(avlNode1, avlNode1);
        this.b.b();
        return;
      } 
    } 
    Iterators.h(b());
  }
  
  public SortedMultiset<E> d(@NullableDecl E paramE, BoundType paramBoundType) {
    return new TreeMultiset(this.b, this.c.a(GeneralRange.b(comparator(), paramE, paramBoundType)), this.d);
  }
  
  public Iterator<E> iterator() {
    return Multisets.a(this);
  }
  
  Iterator<Multiset.Entry<E>> n() {
    return (Iterator)new Iterator<Multiset.Entry<Multiset.Entry<E>>>(this) {
        TreeMultiset.AvlNode<E> a = TreeMultiset.d(this.c);
        
        Multiset.Entry<E> b = null;
        
        public Multiset.Entry<E> a() {
          if (hasNext()) {
            Multiset.Entry<E> entry = TreeMultiset.a(this.c, this.a);
            this.b = entry;
            if (TreeMultiset.AvlNode.h(this.a) == TreeMultiset.c(this.c)) {
              this.a = null;
              return entry;
            } 
            this.a = TreeMultiset.AvlNode.h(this.a);
            return entry;
          } 
          throw new NoSuchElementException();
        }
        
        public boolean hasNext() {
          if (this.a == null)
            return false; 
          if (TreeMultiset.b(this.c).a(this.a.a())) {
            this.a = null;
            return false;
          } 
          return true;
        }
        
        public void remove() {
          boolean bool;
          if (this.b != null) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.a(bool);
          this.c.c(this.b.c(), 0);
          this.b = null;
        }
      };
  }
  
  public int size() {
    return Ints.b(a(Aggregate.a));
  }
  
  enum Aggregate {
    a {
      int a(TreeMultiset.AvlNode<?> param2AvlNode) {
        return TreeMultiset.AvlNode.a(param2AvlNode);
      }
      
      long b(@NullableDecl TreeMultiset.AvlNode<?> param2AvlNode) {
        return (param2AvlNode == null) ? 0L : TreeMultiset.AvlNode.b(param2AvlNode);
      }
    },
    b {
      int a(TreeMultiset.AvlNode<?> param2AvlNode) {
        return 1;
      }
      
      long b(@NullableDecl TreeMultiset.AvlNode<?> param2AvlNode) {
        return (param2AvlNode == null) ? 0L : TreeMultiset.AvlNode.c(param2AvlNode);
      }
    };
    
    abstract int a(TreeMultiset.AvlNode<?> param1AvlNode);
    
    abstract long b(@NullableDecl TreeMultiset.AvlNode<?> param1AvlNode);
  }
  
  enum null {
    int a(TreeMultiset.AvlNode<?> param1AvlNode) {
      return TreeMultiset.AvlNode.a(param1AvlNode);
    }
    
    long b(@NullableDecl TreeMultiset.AvlNode<?> param1AvlNode) {
      return (param1AvlNode == null) ? 0L : TreeMultiset.AvlNode.b(param1AvlNode);
    }
  }
  
  enum null {
    int a(TreeMultiset.AvlNode<?> param1AvlNode) {
      return 1;
    }
    
    long b(@NullableDecl TreeMultiset.AvlNode<?> param1AvlNode) {
      return (param1AvlNode == null) ? 0L : TreeMultiset.AvlNode.c(param1AvlNode);
    }
  }
  
  static final class AvlNode<E> {
    @NullableDecl
    private final E a;
    
    private int b;
    
    private int c;
    
    private long d;
    
    private int e;
    
    @NullableDecl
    private AvlNode<E> f;
    
    @NullableDecl
    private AvlNode<E> g;
    
    @NullableDecl
    private AvlNode<E> h;
    
    @NullableDecl
    private AvlNode<E> i;
    
    AvlNode(@NullableDecl E param1E, int param1Int) {
      boolean bool;
      if (param1Int > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      this.a = param1E;
      this.b = param1Int;
      this.d = param1Int;
      this.c = 1;
      this.e = 1;
      this.f = null;
      this.g = null;
    }
    
    private AvlNode<E> a(E param1E, int param1Int) {
      this.g = new AvlNode(param1E, param1Int);
      TreeMultiset.a(this, this.g, this.i);
      this.e = Math.max(2, this.e);
      this.c++;
      this.d += param1Int;
      return this;
    }
    
    private AvlNode<E> b(E param1E, int param1Int) {
      this.f = new AvlNode(param1E, param1Int);
      TreeMultiset.a(this.h, this.f, this);
      this.e = Math.max(2, this.e);
      this.c++;
      this.d += param1Int;
      return this;
    }
    
    @NullableDecl
    private AvlNode<E> b(Comparator<? super E> param1Comparator, E param1E) {
      int i = param1Comparator.compare(param1E, this.a);
      if (i < 0) {
        AvlNode<E> avlNode1 = this.f;
        return (avlNode1 == null) ? this : (AvlNode<E>)MoreObjects.a(avlNode1.b(param1Comparator, param1E), this);
      } 
      if (i == 0)
        return this; 
      AvlNode<E> avlNode = this.g;
      return (avlNode == null) ? null : avlNode.b(param1Comparator, param1E);
    }
    
    private AvlNode<E> c() {
      int i = this.b;
      this.b = 0;
      TreeMultiset.a(this.h, this.i);
      AvlNode<E> avlNode1 = this.f;
      if (avlNode1 == null)
        return this.g; 
      AvlNode<E> avlNode2 = this.g;
      if (avlNode2 == null)
        return avlNode1; 
      if (avlNode1.e >= avlNode2.e) {
        avlNode2 = this.h;
        avlNode2.f = avlNode1.j(avlNode2);
        avlNode2.g = this.g;
        avlNode2.c = this.c - 1;
        avlNode2.d = this.d - i;
        return avlNode2.g();
      } 
      avlNode1 = this.i;
      avlNode1.g = avlNode2.i(avlNode1);
      avlNode1.f = this.f;
      avlNode1.c = this.c - 1;
      avlNode1.d = this.d - i;
      return avlNode1.g();
    }
    
    @NullableDecl
    private AvlNode<E> c(Comparator<? super E> param1Comparator, E param1E) {
      int i = param1Comparator.compare(param1E, this.a);
      if (i > 0) {
        AvlNode<E> avlNode1 = this.g;
        return (avlNode1 == null) ? this : (AvlNode<E>)MoreObjects.a(avlNode1.c(param1Comparator, param1E), this);
      } 
      if (i == 0)
        return this; 
      AvlNode<E> avlNode = this.f;
      return (avlNode == null) ? null : avlNode.c(param1Comparator, param1E);
    }
    
    private void d() {
      this.c = TreeMultiset.a(this.f) + 1 + TreeMultiset.a(this.g);
      this.d = this.b + k(this.f) + k(this.g);
    }
    
    private void e() {
      this.e = Math.max(l(this.f), l(this.g)) + 1;
    }
    
    private void f() {
      d();
      e();
    }
    
    private AvlNode<E> g() {
      int i = h();
      if (i != -2) {
        if (i != 2) {
          e();
          return this;
        } 
        if (this.f.h() < 0)
          this.f = this.f.i(); 
        return j();
      } 
      if (this.g.h() > 0)
        this.g = this.g.j(); 
      return i();
    }
    
    private int h() {
      return l(this.f) - l(this.g);
    }
    
    private AvlNode<E> i() {
      boolean bool;
      if (this.g != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool);
      AvlNode<E> avlNode = this.g;
      this.g = avlNode.f;
      avlNode.f = this;
      avlNode.d = this.d;
      avlNode.c = this.c;
      f();
      avlNode.e();
      return avlNode;
    }
    
    private AvlNode<E> i(AvlNode<E> param1AvlNode) {
      AvlNode<E> avlNode = this.f;
      if (avlNode == null)
        return this.g; 
      this.f = avlNode.i(param1AvlNode);
      this.c--;
      this.d -= param1AvlNode.b;
      return g();
    }
    
    private AvlNode<E> j() {
      boolean bool;
      if (this.f != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.b(bool);
      AvlNode<E> avlNode = this.f;
      this.f = avlNode.g;
      avlNode.g = this;
      avlNode.d = this.d;
      avlNode.c = this.c;
      f();
      avlNode.e();
      return avlNode;
    }
    
    private AvlNode<E> j(AvlNode<E> param1AvlNode) {
      AvlNode<E> avlNode = this.g;
      if (avlNode == null)
        return this.f; 
      this.g = avlNode.j(param1AvlNode);
      this.c--;
      this.d -= param1AvlNode.b;
      return g();
    }
    
    private static long k(@NullableDecl AvlNode<?> param1AvlNode) {
      return (param1AvlNode == null) ? 0L : param1AvlNode.d;
    }
    
    private static int l(@NullableDecl AvlNode<?> param1AvlNode) {
      return (param1AvlNode == null) ? 0 : param1AvlNode.e;
    }
    
    public int a(Comparator<? super E> param1Comparator, E param1E) {
      int i = param1Comparator.compare(param1E, this.a);
      if (i < 0) {
        AvlNode<E> avlNode = this.f;
        return (avlNode == null) ? 0 : avlNode.a(param1Comparator, param1E);
      } 
      if (i > 0) {
        AvlNode<E> avlNode = this.g;
        return (avlNode == null) ? 0 : avlNode.a(param1Comparator, param1E);
      } 
      return this.b;
    }
    
    AvlNode<E> a(Comparator<? super E> param1Comparator, @NullableDecl E param1E, int param1Int1, int param1Int2, int[] param1ArrayOfint) {
      int i = param1Comparator.compare(param1E, this.a);
      if (i < 0) {
        AvlNode<E> avlNode = this.f;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return (param1Int1 == 0 && param1Int2 > 0) ? b(param1E, param1Int2) : this;
        } 
        this.f = avlNode.a(param1Comparator, param1E, param1Int1, param1Int2, param1ArrayOfint);
        if (param1ArrayOfint[0] == param1Int1) {
          if (param1Int2 == 0 && param1ArrayOfint[0] != 0) {
            this.c--;
          } else if (param1Int2 > 0 && param1ArrayOfint[0] == 0) {
            this.c++;
          } 
          this.d += (param1Int2 - param1ArrayOfint[0]);
        } 
        return g();
      } 
      if (i > 0) {
        AvlNode<E> avlNode = this.g;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return (param1Int1 == 0 && param1Int2 > 0) ? a(param1E, param1Int2) : this;
        } 
        this.g = avlNode.a(param1Comparator, param1E, param1Int1, param1Int2, param1ArrayOfint);
        if (param1ArrayOfint[0] == param1Int1) {
          if (param1Int2 == 0 && param1ArrayOfint[0] != 0) {
            this.c--;
          } else if (param1Int2 > 0 && param1ArrayOfint[0] == 0) {
            this.c++;
          } 
          this.d += (param1Int2 - param1ArrayOfint[0]);
        } 
        return g();
      } 
      i = this.b;
      param1ArrayOfint[0] = i;
      if (param1Int1 == i) {
        if (param1Int2 == 0)
          return c(); 
        this.d += (param1Int2 - i);
        this.b = param1Int2;
      } 
      return this;
    }
    
    AvlNode<E> a(Comparator<? super E> param1Comparator, @NullableDecl E param1E, int param1Int, int[] param1ArrayOfint) {
      int i = param1Comparator.compare(param1E, this.a);
      boolean bool = true;
      if (i < 0) {
        AvlNode<E> avlNode = this.f;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return b(param1E, param1Int);
        } 
        i = avlNode.e;
        this.f = avlNode.a(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] == 0)
          this.c++; 
        this.d += param1Int;
        return (this.f.e == i) ? this : g();
      } 
      if (i > 0) {
        AvlNode<E> avlNode = this.g;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return a(param1E, param1Int);
        } 
        i = avlNode.e;
        this.g = avlNode.a(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] == 0)
          this.c++; 
        this.d += param1Int;
        return (this.g.e == i) ? this : g();
      } 
      i = this.b;
      param1ArrayOfint[0] = i;
      long l1 = i;
      long l2 = param1Int;
      if (l1 + l2 > 2147483647L)
        bool = false; 
      Preconditions.a(bool);
      this.b += param1Int;
      this.d += l2;
      return this;
    }
    
    E a() {
      return this.a;
    }
    
    int b() {
      return this.b;
    }
    
    AvlNode<E> b(Comparator<? super E> param1Comparator, @NullableDecl E param1E, int param1Int, int[] param1ArrayOfint) {
      int i = param1Comparator.compare(param1E, this.a);
      if (i < 0) {
        AvlNode<E> avlNode = this.f;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return this;
        } 
        this.f = avlNode.b(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] > 0)
          if (param1Int >= param1ArrayOfint[0]) {
            this.c--;
            this.d -= param1ArrayOfint[0];
          } else {
            this.d -= param1Int;
          }  
        return (param1ArrayOfint[0] == 0) ? this : g();
      } 
      if (i > 0) {
        AvlNode<E> avlNode = this.g;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return this;
        } 
        this.g = avlNode.b(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1ArrayOfint[0] > 0)
          if (param1Int >= param1ArrayOfint[0]) {
            this.c--;
            this.d -= param1ArrayOfint[0];
          } else {
            this.d -= param1Int;
          }  
        return g();
      } 
      i = this.b;
      param1ArrayOfint[0] = i;
      if (param1Int >= i)
        return c(); 
      this.b = i - param1Int;
      this.d -= param1Int;
      return this;
    }
    
    AvlNode<E> c(Comparator<? super E> param1Comparator, @NullableDecl E param1E, int param1Int, int[] param1ArrayOfint) {
      int i = param1Comparator.compare(param1E, this.a);
      if (i < 0) {
        AvlNode<E> avlNode = this.f;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return (param1Int > 0) ? b(param1E, param1Int) : this;
        } 
        this.f = avlNode.c(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1Int == 0 && param1ArrayOfint[0] != 0) {
          this.c--;
        } else if (param1Int > 0 && param1ArrayOfint[0] == 0) {
          this.c++;
        } 
        this.d += (param1Int - param1ArrayOfint[0]);
        return g();
      } 
      if (i > 0) {
        AvlNode<E> avlNode = this.g;
        if (avlNode == null) {
          param1ArrayOfint[0] = 0;
          return (param1Int > 0) ? a(param1E, param1Int) : this;
        } 
        this.g = avlNode.c(param1Comparator, param1E, param1Int, param1ArrayOfint);
        if (param1Int == 0 && param1ArrayOfint[0] != 0) {
          this.c--;
        } else if (param1Int > 0 && param1ArrayOfint[0] == 0) {
          this.c++;
        } 
        this.d += (param1Int - param1ArrayOfint[0]);
        return g();
      } 
      i = this.b;
      param1ArrayOfint[0] = i;
      if (param1Int == 0)
        return c(); 
      this.d += (param1Int - i);
      this.b = param1Int;
      return this;
    }
    
    public String toString() {
      return Multisets.<E>a(a(), b()).toString();
    }
  }
  
  static final class Reference<T> {
    @NullableDecl
    private T a;
    
    @NullableDecl
    public T a() {
      return this.a;
    }
    
    public void a(@NullableDecl T param1T1, T param1T2) {
      if (this.a == param1T1) {
        this.a = param1T2;
        return;
      } 
      throw new ConcurrentModificationException();
    }
    
    void b() {
      this.a = null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\TreeMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */