package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
  private static final UnmodifiableListIterator<Object> a = new Itr(RegularImmutableList.a, 0);
  
  public static <E> ImmutableList<E> a(Iterable<? extends E> paramIterable) {
    Preconditions.a(paramIterable);
    return (paramIterable instanceof Collection) ? a((Collection<? extends E>)paramIterable) : a(paramIterable.iterator());
  }
  
  public static <E> ImmutableList<E> a(E paramE) {
    return c(new Object[] { paramE });
  }
  
  public static <E> ImmutableList<E> a(Collection<? extends E> paramCollection) {
    if (paramCollection instanceof ImmutableCollection) {
      ImmutableList<? extends E> immutableList = ((ImmutableCollection)paramCollection).h();
      paramCollection = immutableList;
      if (immutableList.a())
        paramCollection = b(immutableList.toArray()); 
      return (ImmutableList)paramCollection;
    } 
    return c(paramCollection.toArray());
  }
  
  public static <E> ImmutableList<E> a(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable) {
    Preconditions.a(paramComparator);
    Object[] arrayOfObject = Iterables.b(paramIterable);
    ObjectArrays.a(arrayOfObject);
    Arrays.sort(arrayOfObject, (Comparator)paramComparator);
    return b(arrayOfObject);
  }
  
  public static <E> ImmutableList<E> a(Iterator<? extends E> paramIterator) {
    if (!paramIterator.hasNext())
      return d(); 
    E e = paramIterator.next();
    return !paramIterator.hasNext() ? a(e) : (new Builder<E>()).c(e).b(paramIterator).a();
  }
  
  public static <E> ImmutableList<E> a(E[] paramArrayOfE) {
    return (paramArrayOfE.length == 0) ? d() : c((Object[])paramArrayOfE.clone());
  }
  
  static <E> ImmutableList<E> b(Object[] paramArrayOfObject) {
    return b(paramArrayOfObject, paramArrayOfObject.length);
  }
  
  static <E> ImmutableList<E> b(Object[] paramArrayOfObject, int paramInt) {
    return (paramInt == 0) ? d() : new RegularImmutableList<E>(paramArrayOfObject, paramInt);
  }
  
  private static <E> ImmutableList<E> c(Object... paramVarArgs) {
    return b(ObjectArrays.a(paramVarArgs));
  }
  
  public static <E> ImmutableList<E> d() {
    return (ImmutableList)RegularImmutableList.a;
  }
  
  public static <E> Builder<E> g() {
    return new Builder<E>();
  }
  
  int a(Object[] paramArrayOfObject, int paramInt) {
    int j = size();
    for (int i = 0; i < j; i++)
      paramArrayOfObject[paramInt + i] = get(i); 
    return paramInt + j;
  }
  
  public ImmutableList<E> a(int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt2, size());
    int i = paramInt2 - paramInt1;
    return (i == size()) ? this : ((i == 0) ? d() : b(paramInt1, paramInt2));
  }
  
  public UnmodifiableListIterator<E> a(int paramInt) {
    Preconditions.b(paramInt, size());
    return (UnmodifiableListIterator<E>)(isEmpty() ? a : new Itr<E>(this, paramInt));
  }
  
  @Deprecated
  public final void add(int paramInt, E paramE) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final boolean addAll(int paramInt, Collection<? extends E> paramCollection) {
    throw new UnsupportedOperationException();
  }
  
  public UnmodifiableIterator<E> av_() {
    return e();
  }
  
  ImmutableList<E> b(int paramInt1, int paramInt2) {
    return new SubList(this, paramInt1, paramInt2 - paramInt1);
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return (indexOf(paramObject) >= 0);
  }
  
  public UnmodifiableListIterator<E> e() {
    return a(0);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    return Lists.a(this, paramObject);
  }
  
  public ImmutableList<E> f() {
    return (size() <= 1) ? this : new ReverseImmutableList<E>(this);
  }
  
  public final ImmutableList<E> h() {
    return this;
  }
  
  public int hashCode() {
    int k = size();
    int j = 1;
    for (int i = 0; i < k; i++)
      j = j * 31 + get(i).hashCode(); 
    return j;
  }
  
  public int indexOf(@NullableDecl Object paramObject) {
    return (paramObject == null) ? -1 : Lists.b(this, paramObject);
  }
  
  public int lastIndexOf(@NullableDecl Object paramObject) {
    return (paramObject == null) ? -1 : Lists.c(this, paramObject);
  }
  
  @Deprecated
  public final E remove(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public final E set(int paramInt, E paramE) {
    throw new UnsupportedOperationException();
  }
  
  public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
    public Builder() {
      this(4);
    }
    
    Builder(int param1Int) {
      super(param1Int);
    }
    
    public ImmutableList<E> a() {
      this.c = true;
      return ImmutableList.b(this.a, this.b);
    }
    
    public Builder<E> b(Iterable<? extends E> param1Iterable) {
      super.a(param1Iterable);
      return this;
    }
    
    public Builder<E> b(Iterator<? extends E> param1Iterator) {
      super.a(param1Iterator);
      return this;
    }
    
    public Builder<E> c(E param1E) {
      super.a(param1E);
      return this;
    }
  }
  
  static class Itr<E> extends AbstractIndexedListIterator<E> {
    private final ImmutableList<E> a;
    
    Itr(ImmutableList<E> param1ImmutableList, int param1Int) {
      super(param1ImmutableList.size(), param1Int);
      this.a = param1ImmutableList;
    }
    
    protected E a(int param1Int) {
      return this.a.get(param1Int);
    }
  }
  
  static class ReverseImmutableList<E> extends ImmutableList<E> {
    private final transient ImmutableList<E> a;
    
    ReverseImmutableList(ImmutableList<E> param1ImmutableList) {
      this.a = param1ImmutableList;
    }
    
    private int b(int param1Int) {
      return size() - 1 - param1Int;
    }
    
    private int c(int param1Int) {
      return size() - param1Int;
    }
    
    public ImmutableList<E> a(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, size());
      return this.a.a(c(param1Int2), c(param1Int1)).f();
    }
    
    boolean a() {
      return this.a.a();
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return this.a.contains(param1Object);
    }
    
    public ImmutableList<E> f() {
      return this.a;
    }
    
    public E get(int param1Int) {
      Preconditions.a(param1Int, size());
      return this.a.get(b(param1Int));
    }
    
    public int indexOf(@NullableDecl Object param1Object) {
      int i = this.a.lastIndexOf(param1Object);
      return (i >= 0) ? b(i) : -1;
    }
    
    public int lastIndexOf(@NullableDecl Object param1Object) {
      int i = this.a.indexOf(param1Object);
      return (i >= 0) ? b(i) : -1;
    }
    
    public int size() {
      return this.a.size();
    }
  }
  
  static class SerializedForm implements Serializable {}
  
  class SubList extends ImmutableList<E> {
    final transient int a;
    
    final transient int b;
    
    SubList(ImmutableList this$0, int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    public ImmutableList<E> a(int param1Int1, int param1Int2) {
      Preconditions.a(param1Int1, param1Int2, this.b);
      ImmutableList<E> immutableList = this.c;
      int i = this.a;
      return immutableList.a(param1Int1 + i, param1Int2 + i);
    }
    
    boolean a() {
      return true;
    }
    
    public E get(int param1Int) {
      Preconditions.a(param1Int, this.b);
      return this.c.get(param1Int + this.a);
    }
    
    Object[] n() {
      return this.c.n();
    }
    
    int o() {
      return this.c.o() + this.a;
    }
    
    int q() {
      return this.c.o() + this.a + this.b;
    }
    
    public int size() {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\ImmutableList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */