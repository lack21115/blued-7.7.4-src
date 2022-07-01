package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@DoNotMock("Use ImmutableList.of or another implementation")
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
  private static final Object[] a = new Object[0];
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    UnmodifiableIterator<E> unmodifiableIterator = av_();
    while (unmodifiableIterator.hasNext()) {
      paramArrayOfObject[paramInt] = unmodifiableIterator.next();
      paramInt++;
    } 
    return paramInt;
  }
  
  abstract boolean a();
  
  @Deprecated
  public final boolean add(E paramE) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(Collection<? extends E> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public abstract UnmodifiableIterator<E> av_();
  
  @Deprecated
  public final void clear() {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean contains(@NullableDecl Object paramObject);
  
  public ImmutableList<E> h() {
    return isEmpty() ? ImmutableList.d() : ImmutableList.b(toArray());
  }
  
  @NullableDecl
  Object[] n() {
    return null;
  }
  
  int o() {
    throw new UnsupportedOperationException();
  }
  
  int q() {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean remove(Object paramObject) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean removeAll(Collection<?> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean retainAll(Collection<?> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public final Object[] toArray() {
    return toArray(a);
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT) {
    T[] arrayOfT;
    Preconditions.a(paramArrayOfT);
    int i = size();
    if (paramArrayOfT.length < i) {
      Object[] arrayOfObject = n();
      if (arrayOfObject != null)
        return Platform.a(arrayOfObject, o(), q(), paramArrayOfT); 
      arrayOfObject = ObjectArrays.a((Object[])paramArrayOfT, i);
    } else {
      arrayOfT = paramArrayOfT;
      if (paramArrayOfT.length > i) {
        paramArrayOfT[i] = null;
        arrayOfT = paramArrayOfT;
      } 
    } 
    a((Object[])arrayOfT, 0);
    return arrayOfT;
  }
  
  static abstract class ArrayBasedBuilder<E> extends Builder<E> {
    Object[] a;
    
    int b;
    
    boolean c;
    
    ArrayBasedBuilder(int param1Int) {
      CollectPreconditions.a(param1Int, "initialCapacity");
      this.a = new Object[param1Int];
      this.b = 0;
    }
    
    private void a(int param1Int) {
      Object[] arrayOfObject = this.a;
      if (arrayOfObject.length < param1Int) {
        this.a = Arrays.copyOf(arrayOfObject, a(arrayOfObject.length, param1Int));
        this.c = false;
        return;
      } 
      if (this.c) {
        this.a = (Object[])arrayOfObject.clone();
        this.c = false;
      } 
    }
    
    public ArrayBasedBuilder<E> a(E param1E) {
      Preconditions.a(param1E);
      a(this.b + 1);
      Object[] arrayOfObject = this.a;
      int i = this.b;
      this.b = i + 1;
      arrayOfObject[i] = param1E;
      return this;
    }
    
    public ImmutableCollection.Builder<E> a(Iterable<? extends E> param1Iterable) {
      if (param1Iterable instanceof Collection) {
        Collection collection = (Collection)param1Iterable;
        a(this.b + collection.size());
        if (collection instanceof ImmutableCollection) {
          this.b = ((ImmutableCollection)collection).a(this.a, this.b);
          return this;
        } 
      } 
      super.a(param1Iterable);
      return this;
    }
  }
  
  @DoNotMock
  public static abstract class Builder<E> {
    static int a(int param1Int1, int param1Int2) {
      if (param1Int2 >= 0) {
        int i = param1Int1 + (param1Int1 >> 1) + 1;
        param1Int1 = i;
        if (i < param1Int2)
          param1Int1 = Integer.highestOneBit(param1Int2 - 1) << 1; 
        param1Int2 = param1Int1;
        if (param1Int1 < 0)
          param1Int2 = Integer.MAX_VALUE; 
        return param1Int2;
      } 
      throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
    
    public Builder<E> a(Iterable<? extends E> param1Iterable) {
      Iterator<? extends E> iterator = param1Iterable.iterator();
      while (iterator.hasNext())
        b(iterator.next()); 
      return this;
    }
    
    public Builder<E> a(Iterator<? extends E> param1Iterator) {
      while (param1Iterator.hasNext())
        b(param1Iterator.next()); 
      return this;
    }
    
    public abstract Builder<E> b(E param1E);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableCollection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */