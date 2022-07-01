package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
  @NullableDecl
  transient Object[] a;
  
  @NullableDecl
  private transient Object b;
  
  @NullableDecl
  private transient int[] c;
  
  private transient int d;
  
  private transient int e;
  
  CompactHashSet() {
    b(3);
  }
  
  CompactHashSet(int paramInt) {
    b(paramInt);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    Object object1 = CompactHashing.b(paramInt2);
    int i = paramInt2 - 1;
    if (paramInt4 != 0)
      CompactHashing.a(object1, paramInt3 & i, paramInt4 + 1); 
    Object object2 = this.b;
    int[] arrayOfInt = this.c;
    for (paramInt2 = 0; paramInt2 <= paramInt1; paramInt2++) {
      for (paramInt3 = CompactHashing.a(object2, paramInt2); paramInt3 != 0; paramInt3 = CompactHashing.b(j, paramInt1)) {
        paramInt4 = paramInt3 - 1;
        int j = arrayOfInt[paramInt4];
        int k = CompactHashing.a(j, paramInt1) | paramInt2;
        int m = k & i;
        int n = CompactHashing.a(object1, m);
        CompactHashing.a(object1, m, paramInt3);
        arrayOfInt[paramInt4] = CompactHashing.a(k, n, i);
      } 
    } 
    this.b = object1;
    f(i);
    return i;
  }
  
  public static <E> CompactHashSet<E> a() {
    return new CompactHashSet<E>();
  }
  
  public static <E> CompactHashSet<E> a(int paramInt) {
    return new CompactHashSet<E>(paramInt);
  }
  
  private Set<E> e(int paramInt) {
    return new LinkedHashSet<E>(paramInt, 1.0F);
  }
  
  private void f(int paramInt) {
    paramInt = Integer.numberOfLeadingZeros(paramInt);
    this.d = CompactHashing.a(this.d, 32 - paramInt, 31);
  }
  
  private void g(int paramInt) {
    int i = this.c.length;
    if (paramInt > i) {
      paramInt = Math.min(1073741823, Math.max(1, i >>> 1) + i | 0x1);
      if (paramInt != i)
        c(paramInt); 
    } 
  }
  
  private int h() {
    return (1 << (this.d & 0x1F)) - 1;
  }
  
  void a(int paramInt1, int paramInt2) {
    int i = size() - 1;
    if (paramInt1 < i) {
      Object[] arrayOfObject = this.a;
      Object object = arrayOfObject[i];
      arrayOfObject[paramInt1] = object;
      arrayOfObject[i] = null;
      int[] arrayOfInt = this.c;
      arrayOfInt[paramInt1] = arrayOfInt[i];
      arrayOfInt[i] = 0;
      int m = Hashing.a(object) & paramInt2;
      int j = CompactHashing.a(this.b, m);
      int k = i + 1;
      i = j;
      if (j == k) {
        CompactHashing.a(this.b, m, paramInt1 + 1);
        return;
      } 
      while (true) {
        j = i - 1;
        m = this.c[j];
        i = CompactHashing.b(m, paramInt2);
        if (i == k) {
          this.c[j] = CompactHashing.a(m, paramInt1 + 1, paramInt2);
          return;
        } 
      } 
    } 
    this.a[paramInt1] = null;
    this.c[paramInt1] = 0;
  }
  
  void a(int paramInt1, @NullableDecl E paramE, int paramInt2, int paramInt3) {
    this.c[paramInt1] = CompactHashing.a(paramInt2, 0, paramInt3);
    this.a[paramInt1] = paramE;
  }
  
  public boolean add(@NullableDecl E paramE) {
    if (b())
      c(); 
    Set<E> set = d();
    if (set != null)
      return set.add(paramE); 
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.a;
    int m = this.e;
    int n = m + 1;
    int i1 = Hashing.a(paramE);
    int k = h();
    int i = i1 & k;
    int j = CompactHashing.a(this.b, i);
    if (j == 0) {
      if (n > k) {
        i = a(k, CompactHashing.c(k), i1, m);
      } else {
        CompactHashing.a(this.b, i, n);
        i = k;
      } 
    } else {
      int i2 = CompactHashing.a(i1, k);
      i = 0;
      while (true) {
        int i3 = j - 1;
        int i4 = arrayOfInt[i3];
        if (CompactHashing.a(i4, k) == i2 && Objects.a(paramE, arrayOfObject[i3]))
          return false; 
        j = CompactHashing.b(i4, k);
        i++;
        if (j == 0) {
          if (i >= 9)
            return e().add(paramE); 
          if (n > k) {
            i = a(k, CompactHashing.c(k), i1, m);
          } else {
            arrayOfInt[i3] = CompactHashing.a(i4, n, k);
            i = k;
          } 
          g(n);
          a(m, paramE, i1, i);
          this.e = n;
          f();
          return true;
        } 
      } 
    } 
    g(n);
    a(m, paramE, i1, i);
    this.e = n;
    f();
    return true;
  }
  
  int b(int paramInt1, int paramInt2) {
    return paramInt1 - 1;
  }
  
  void b(int paramInt) {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool, "Expected size must be >= 0");
    this.d = Ints.a(paramInt, 1, 1073741823);
  }
  
  boolean b() {
    return (this.b == null);
  }
  
  int c() {
    Preconditions.b(b(), "Arrays already allocated");
    int i = this.d;
    int j = CompactHashing.a(i);
    this.b = CompactHashing.b(j);
    f(j - 1);
    this.c = new int[i];
    this.a = new Object[i];
    return i;
  }
  
  void c(int paramInt) {
    this.c = Arrays.copyOf(this.c, paramInt);
    this.a = Arrays.copyOf(this.a, paramInt);
  }
  
  public void clear() {
    if (b())
      return; 
    f();
    Set<E> set = d();
    if (set != null) {
      this.d = Ints.a(size(), 3, 1073741823);
      set.clear();
      this.b = null;
      this.e = 0;
      return;
    } 
    Arrays.fill(this.a, 0, this.e, (Object)null);
    CompactHashing.a(this.b);
    Arrays.fill(this.c, 0, this.e, 0);
    this.e = 0;
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    if (b())
      return false; 
    Set<E> set = d();
    if (set != null)
      return set.contains(paramObject); 
    int j = Hashing.a(paramObject);
    int k = h();
    int i = CompactHashing.a(this.b, j & k);
    if (i == 0)
      return false; 
    int m = CompactHashing.a(j, k);
    while (true) {
      j = this.c[--i];
      if (CompactHashing.a(j, k) == m && Objects.a(paramObject, this.a[i]))
        return true; 
      j = CompactHashing.b(j, k);
      i = j;
      if (j == 0)
        return false; 
    } 
  }
  
  int d(int paramInt) {
    return (++paramInt < this.e) ? paramInt : -1;
  }
  
  @NullableDecl
  Set<E> d() {
    Object object = this.b;
    return (object instanceof Set) ? (Set<E>)object : null;
  }
  
  Set<E> e() {
    Set<E> set = e(h() + 1);
    for (int i = g(); i >= 0; i = d(i))
      set.add((E)this.a[i]); 
    this.b = set;
    this.c = null;
    this.a = null;
    f();
    return set;
  }
  
  void f() {
    this.d += 32;
  }
  
  int g() {
    return isEmpty() ? -1 : 0;
  }
  
  public boolean isEmpty() {
    return (size() == 0);
  }
  
  public Iterator<E> iterator() {
    Set<E> set = d();
    return (set != null) ? set.iterator() : new Iterator<E>(this) {
        int a = CompactHashSet.a(this.d);
        
        int b = this.d.g();
        
        int c = -1;
        
        private void b() {
          if (CompactHashSet.a(this.d) == this.a)
            return; 
          throw new ConcurrentModificationException();
        }
        
        void a() {
          this.a += 32;
        }
        
        public boolean hasNext() {
          return (this.b >= 0);
        }
        
        public E next() {
          b();
          if (hasNext()) {
            this.c = this.b;
            Object[] arrayOfObject = this.d.a;
            int i = this.b;
            Object object = arrayOfObject[i];
            this.b = this.d.d(i);
            return (E)object;
          } 
          throw new NoSuchElementException();
        }
        
        public void remove() {
          boolean bool;
          b();
          if (this.c >= 0) {
            bool = true;
          } else {
            bool = false;
          } 
          CollectPreconditions.a(bool);
          a();
          CompactHashSet compactHashSet = this.d;
          compactHashSet.remove(compactHashSet.a[this.c]);
          this.b = this.d.b(this.b, this.c);
          this.c = -1;
        }
      };
  }
  
  public boolean remove(@NullableDecl Object paramObject) {
    if (b())
      return false; 
    Set<E> set = d();
    if (set != null)
      return set.remove(paramObject); 
    int i = h();
    int j = CompactHashing.a(paramObject, null, i, this.b, this.c, this.a, null);
    if (j == -1)
      return false; 
    a(j, i);
    this.e--;
    f();
    return true;
  }
  
  public int size() {
    Set<E> set = d();
    return (set != null) ? set.size() : this.e;
  }
  
  public Object[] toArray() {
    if (b())
      return new Object[0]; 
    Set<E> set = d();
    return (set != null) ? set.toArray() : Arrays.copyOf(this.a, this.e);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT) {
    if (b()) {
      if (paramArrayOfT.length > 0)
        paramArrayOfT[0] = null; 
      return paramArrayOfT;
    } 
    Set<E> set = d();
    return (set != null) ? set.toArray(paramArrayOfT) : ObjectArrays.a(this.a, 0, this.e, paramArrayOfT);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CompactHashSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */