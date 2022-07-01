package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
  @LazyInit
  @NullableDecl
  private transient ImmutableList<E> a;
  
  public static <E> ImmutableSet<E> a(Iterable<? extends E> paramIterable) {
    return (paramIterable instanceof Collection) ? a((Collection<? extends E>)paramIterable) : a(paramIterable.iterator());
  }
  
  public static <E> ImmutableSet<E> a(E paramE1, E paramE2, E paramE3) {
    return b(3, new Object[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E> ImmutableSet<E> a(Collection<? extends E> paramCollection) {
    if (paramCollection instanceof ImmutableSet && !(paramCollection instanceof java.util.SortedSet)) {
      ImmutableSet<E> immutableSet = (ImmutableSet)paramCollection;
      if (!immutableSet.a())
        return immutableSet; 
    } 
    Object[] arrayOfObject = paramCollection.toArray();
    return b(arrayOfObject.length, arrayOfObject);
  }
  
  public static <E> ImmutableSet<E> a(Iterator<? extends E> paramIterator) {
    if (!paramIterator.hasNext())
      return j(); 
    E e = paramIterator.next();
    return !paramIterator.hasNext() ? d(e) : (new Builder<E>()).c(e).b(paramIterator).a();
  }
  
  private static <E> ImmutableSet<E> b(int paramInt, Object... paramVarArgs) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        int m = c(paramInt);
        Object[] arrayOfObject2 = new Object[m];
        int n = m - 1;
        int i = 0;
        int k = 0;
        int j = 0;
        label28: while (i < paramInt) {
          Object object = ObjectArrays.a(paramVarArgs[i], i);
          int i2 = object.hashCode();
          int i1 = Hashing.a(i2);
          while (true) {
            int i3 = i1 & n;
            Object object1 = arrayOfObject2[i3];
            if (object1 == null) {
              paramVarArgs[j] = object;
              arrayOfObject2[i3] = object;
              k += i2;
              j++;
            } else if (!object1.equals(object)) {
              i1++;
              continue;
            } 
            i++;
            continue label28;
          } 
        } 
        Arrays.fill(paramVarArgs, j, paramInt, (Object)null);
        if (j == 1)
          return new SingletonImmutableSet<E>((E)paramVarArgs[0], k); 
        if (c(j) < m / 2)
          return b(j, paramVarArgs); 
        Object[] arrayOfObject1 = paramVarArgs;
        if (b(j, paramVarArgs.length))
          arrayOfObject1 = Arrays.copyOf(paramVarArgs, j); 
        return new RegularImmutableSet<E>(arrayOfObject1, k, arrayOfObject2, n, j);
      } 
      return d((E)paramVarArgs[0]);
    } 
    return j();
  }
  
  private static boolean b(int paramInt1, int paramInt2) {
    return (paramInt1 < (paramInt2 >> 1) + (paramInt2 >> 2));
  }
  
  static int c(int paramInt) {
    int i = Math.max(paramInt, 2);
    boolean bool = true;
    if (i < 751619276) {
      for (paramInt = Integer.highestOneBit(i - 1) << 1; paramInt * 0.7D < i; paramInt <<= 1);
      return paramInt;
    } 
    if (i >= 1073741824)
      bool = false; 
    Preconditions.a(bool, "collection too large");
    return 1073741824;
  }
  
  public static <E> ImmutableSet<E> d(E paramE) {
    return new SingletonImmutableSet<E>(paramE);
  }
  
  public static <E> ImmutableSet<E> j() {
    return RegularImmutableSet.a;
  }
  
  public static <E> Builder<E> k() {
    return new Builder<E>();
  }
  
  public abstract UnmodifiableIterator<E> av_();
  
  ImmutableList<E> d() {
    return ImmutableList.b(toArray());
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return (paramObject == this) ? true : ((paramObject instanceof ImmutableSet && i() && ((ImmutableSet)paramObject).i() && hashCode() != paramObject.hashCode()) ? false : Sets.a(this, paramObject));
  }
  
  public ImmutableList<E> h() {
    ImmutableList<E> immutableList2 = this.a;
    ImmutableList<E> immutableList1 = immutableList2;
    if (immutableList2 == null) {
      immutableList1 = d();
      this.a = immutableList1;
    } 
    return immutableList1;
  }
  
  public int hashCode() {
    return Sets.a(this);
  }
  
  boolean i() {
    return false;
  }
  
  public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
    @NullableDecl
    Object[] d;
    
    private int e;
    
    public Builder() {
      super(4);
    }
    
    private void d(E param1E) {
      int j = this.d.length;
      int k = param1E.hashCode();
      for (int i = Hashing.a(k);; i++) {
        i &= j - 1;
        Object[] arrayOfObject = this.d;
        Object object = arrayOfObject[i];
        if (object == null) {
          arrayOfObject[i] = param1E;
          this.e += k;
          super.a(param1E);
          return;
        } 
        if (object.equals(param1E))
          return; 
      } 
    }
    
    public ImmutableSet<E> a() {
      int i = this.b;
      if (i != 0) {
        if (i != 1) {
          ImmutableSet<E> immutableSet;
          if (this.d != null && ImmutableSet.c(this.b) == this.d.length) {
            Object[] arrayOfObject1;
            if (ImmutableSet.a(this.b, this.a.length)) {
              arrayOfObject1 = Arrays.copyOf(this.a, this.b);
            } else {
              arrayOfObject1 = this.a;
            } 
            i = this.e;
            Object[] arrayOfObject2 = this.d;
            immutableSet = new RegularImmutableSet(arrayOfObject1, i, arrayOfObject2, arrayOfObject2.length - 1, this.b);
          } else {
            immutableSet = ImmutableSet.a(this.b, this.a);
            this.b = immutableSet.size();
          } 
          this.c = true;
          this.d = null;
          return immutableSet;
        } 
        return ImmutableSet.d((E)this.a[0]);
      } 
      return ImmutableSet.j();
    }
    
    public Builder<E> b(Iterable<? extends E> param1Iterable) {
      Iterator<? extends E> iterator;
      Preconditions.a(param1Iterable);
      if (this.d != null) {
        iterator = param1Iterable.iterator();
        while (iterator.hasNext())
          c(iterator.next()); 
      } else {
        super.a((Iterable<? extends E>)iterator);
      } 
      return this;
    }
    
    public Builder<E> b(Iterator<? extends E> param1Iterator) {
      Preconditions.a(param1Iterator);
      while (param1Iterator.hasNext())
        c(param1Iterator.next()); 
      return this;
    }
    
    public Builder<E> c(E param1E) {
      Preconditions.a(param1E);
      if (this.d != null && ImmutableSet.c(this.b) <= this.d.length) {
        d(param1E);
        return this;
      } 
      this.d = null;
      super.a(param1E);
      return this;
    }
  }
  
  static class SerializedForm implements Serializable {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */