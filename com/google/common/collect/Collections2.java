package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Collections2 {
  static String a(Collection<?> paramCollection) {
    StringBuilder stringBuilder = a(paramCollection.size());
    stringBuilder.append('[');
    Iterator<?> iterator = paramCollection.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      Object object = iterator.next();
      if (!bool)
        stringBuilder.append(", "); 
      bool = false;
      if (object == paramCollection) {
        stringBuilder.append("(this Collection)");
        continue;
      } 
      stringBuilder.append(object);
    } 
    stringBuilder.append(']');
    return stringBuilder.toString();
  }
  
  static StringBuilder a(int paramInt) {
    CollectPreconditions.a(paramInt, "size");
    return new StringBuilder((int)Math.min(paramInt * 8L, 1073741824L));
  }
  
  static <T> Collection<T> a(Iterable<T> paramIterable) {
    return (Collection<T>)paramIterable;
  }
  
  public static <F, T> Collection<T> a(Collection<F> paramCollection, Function<? super F, T> paramFunction) {
    return new TransformedCollection<F, T>(paramCollection, paramFunction);
  }
  
  public static <E> Collection<E> a(Collection<E> paramCollection, Predicate<? super E> paramPredicate) {
    return (paramCollection instanceof FilteredCollection) ? ((FilteredCollection<E>)paramCollection).a(paramPredicate) : new FilteredCollection<E>((Collection<E>)Preconditions.a(paramCollection), (Predicate<? super E>)Preconditions.a(paramPredicate));
  }
  
  static boolean a(Collection<?> paramCollection, @NullableDecl Object paramObject) {
    Preconditions.a(paramCollection);
    try {
      return paramCollection.contains(paramObject);
    } catch (ClassCastException|NullPointerException classCastException) {
      return false;
    } 
  }
  
  static boolean a(Collection<?> paramCollection1, Collection<?> paramCollection2) {
    Iterator<?> iterator = paramCollection2.iterator();
    while (iterator.hasNext()) {
      if (!paramCollection1.contains(iterator.next()))
        return false; 
    } 
    return true;
  }
  
  private static <E> ObjectCountHashMap<E> b(Collection<E> paramCollection) {
    // Byte code:
    //   0: new com/google/common/collect/ObjectCountHashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokeinterface iterator : ()Ljava/util/Iterator;
    //   14: astore_0
    //   15: aload_0
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 47
    //   24: aload_0
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: astore_2
    //   31: aload_1
    //   32: aload_2
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual b : (Ljava/lang/Object;)I
    //   38: iconst_1
    //   39: iadd
    //   40: invokevirtual a : (Ljava/lang/Object;I)I
    //   43: pop
    //   44: goto -> 15
    //   47: aload_1
    //   48: areturn
  }
  
  static boolean b(Collection<?> paramCollection, @NullableDecl Object paramObject) {
    Preconditions.a(paramCollection);
    try {
      return paramCollection.remove(paramObject);
    } catch (ClassCastException|NullPointerException classCastException) {
      return false;
    } 
  }
  
  private static boolean b(List<?> paramList1, List<?> paramList2) {
    if (paramList1.size() != paramList2.size())
      return false; 
    ObjectCountHashMap<?> objectCountHashMap1 = b(paramList1);
    ObjectCountHashMap<?> objectCountHashMap2 = b(paramList2);
    if (paramList1.size() != paramList2.size())
      return false; 
    for (int i = 0; i < paramList1.size(); i++) {
      if (objectCountHashMap1.d(i) != objectCountHashMap2.b(objectCountHashMap1.c(i)))
        return false; 
    } 
    return true;
  }
  
  static class FilteredCollection<E> extends AbstractCollection<E> {
    final Collection<E> a;
    
    final Predicate<? super E> b;
    
    FilteredCollection(Collection<E> param1Collection, Predicate<? super E> param1Predicate) {
      this.a = param1Collection;
      this.b = param1Predicate;
    }
    
    FilteredCollection<E> a(Predicate<? super E> param1Predicate) {
      return new FilteredCollection(this.a, Predicates.a(this.b, param1Predicate));
    }
    
    public boolean add(E param1E) {
      Preconditions.a(this.b.a(param1E));
      return this.a.add(param1E);
    }
    
    public boolean addAll(Collection<? extends E> param1Collection) {
      // Byte code:
      //   0: aload_1
      //   1: invokeinterface iterator : ()Ljava/util/Iterator;
      //   6: astore_2
      //   7: aload_2
      //   8: invokeinterface hasNext : ()Z
      //   13: ifeq -> 39
      //   16: aload_2
      //   17: invokeinterface next : ()Ljava/lang/Object;
      //   22: astore_3
      //   23: aload_0
      //   24: getfield b : Lcom/google/common/base/Predicate;
      //   27: aload_3
      //   28: invokeinterface a : (Ljava/lang/Object;)Z
      //   33: invokestatic a : (Z)V
      //   36: goto -> 7
      //   39: aload_0
      //   40: getfield a : Ljava/util/Collection;
      //   43: aload_1
      //   44: invokeinterface addAll : (Ljava/util/Collection;)Z
      //   49: ireturn
    }
    
    public void clear() {
      Iterables.a(this.a, this.b);
    }
    
    public boolean contains(@NullableDecl Object param1Object) {
      return Collections2.a(this.a, param1Object) ? this.b.a(param1Object) : false;
    }
    
    public boolean containsAll(Collection<?> param1Collection) {
      return Collections2.a(this, param1Collection);
    }
    
    public boolean isEmpty() {
      return Iterables.<E>d(this.a, this.b) ^ true;
    }
    
    public Iterator<E> iterator() {
      return Iterators.b(this.a.iterator(), this.b);
    }
    
    public boolean remove(Object param1Object) {
      return (contains(param1Object) && this.a.remove(param1Object));
    }
    
    public boolean removeAll(Collection<?> param1Collection) {
      Iterator<E> iterator = this.a.iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        E e = iterator.next();
        if (this.b.a(e) && param1Collection.contains(e)) {
          iterator.remove();
          bool = true;
        } 
      } 
      return bool;
    }
    
    public boolean retainAll(Collection<?> param1Collection) {
      Iterator<E> iterator = this.a.iterator();
      boolean bool = false;
      while (iterator.hasNext()) {
        E e = iterator.next();
        if (this.b.a(e) && !param1Collection.contains(e)) {
          iterator.remove();
          bool = true;
        } 
      } 
      return bool;
    }
    
    public int size() {
      Iterator<E> iterator = this.a.iterator();
      int i = 0;
      while (iterator.hasNext()) {
        E e = iterator.next();
        if (this.b.a(e))
          i++; 
      } 
      return i;
    }
    
    public Object[] toArray() {
      return Lists.<E>a(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] param1ArrayOfT) {
      return (T[])Lists.<E>a(iterator()).toArray((Object[])param1ArrayOfT);
    }
  }
  
  static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
    final ImmutableList<E> a;
    
    final Comparator<? super E> b;
    
    final int c;
    
    public boolean contains(@NullableDecl Object param1Object) {
      if (param1Object instanceof List) {
        param1Object = param1Object;
        return Collections2.a(this.a, (List)param1Object);
      } 
      return false;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public Iterator<List<E>> iterator() {
      return new Collections2.OrderedPermutationIterator<E>(this.a, this.b);
    }
    
    public int size() {
      return this.c;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("orderedPermutationCollection(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
    @NullableDecl
    List<E> a;
    
    final Comparator<? super E> b;
    
    OrderedPermutationIterator(List<E> param1List, Comparator<? super E> param1Comparator) {
      this.a = Lists.a(param1List);
      this.b = param1Comparator;
    }
    
    int a(int param1Int) {
      E e = this.a.get(param1Int);
      for (int i = this.a.size() - 1; i > param1Int; i--) {
        if (this.b.compare(e, this.a.get(i)) < 0)
          return i; 
      } 
      throw new AssertionError("this statement should be unreachable");
    }
    
    protected List<E> c() {
      List<E> list = this.a;
      if (list == null)
        return b(); 
      list = ImmutableList.a(list);
      d();
      return list;
    }
    
    void d() {
      int i = e();
      if (i == -1) {
        this.a = null;
        return;
      } 
      int j = a(i);
      Collections.swap(this.a, i, j);
      j = this.a.size();
      Collections.reverse(this.a.subList(i + 1, j));
    }
    
    int e() {
      for (int i = this.a.size() - 2; i >= 0; i--) {
        if (this.b.compare(this.a.get(i), this.a.get(i + 1)) < 0)
          return i; 
      } 
      return -1;
    }
  }
  
  static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
    final ImmutableList<E> a;
    
    public boolean contains(@NullableDecl Object param1Object) {
      if (param1Object instanceof List) {
        param1Object = param1Object;
        return Collections2.a(this.a, (List)param1Object);
      } 
      return false;
    }
    
    public boolean isEmpty() {
      return false;
    }
    
    public Iterator<List<E>> iterator() {
      return new Collections2.PermutationIterator<E>(this.a);
    }
    
    public int size() {
      return IntMath.b(this.a.size());
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("permutations(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class PermutationIterator<E> extends AbstractIterator<List<E>> {
    final List<E> a;
    
    final int[] b;
    
    final int[] c;
    
    int d;
    
    PermutationIterator(List<E> param1List) {
      this.a = new ArrayList<E>(param1List);
      int i = param1List.size();
      this.b = new int[i];
      this.c = new int[i];
      Arrays.fill(this.b, 0);
      Arrays.fill(this.c, 1);
      this.d = Integer.MAX_VALUE;
    }
    
    protected List<E> c() {
      if (this.d <= 0)
        return b(); 
      ImmutableList<E> immutableList = ImmutableList.a(this.a);
      d();
      return immutableList;
    }
    
    void d() {
      this.d = this.a.size() - 1;
      if (this.d == -1)
        return; 
      int i = 0;
      while (true) {
        int[] arrayOfInt = this.b;
        int j = this.d;
        int k = arrayOfInt[j] + this.c[j];
        if (k < 0) {
          e();
          continue;
        } 
        if (k == j + 1) {
          if (j == 0)
            return; 
          i++;
          e();
          continue;
        } 
        Collections.swap(this.a, j - arrayOfInt[j] + i, j - k + i);
        this.b[this.d] = k;
        return;
      } 
    }
    
    void e() {
      int[] arrayOfInt = this.c;
      int i = this.d;
      arrayOfInt[i] = -arrayOfInt[i];
      this.d = i - 1;
    }
  }
  
  static class TransformedCollection<F, T> extends AbstractCollection<T> {
    final Collection<F> a;
    
    final Function<? super F, ? extends T> b;
    
    TransformedCollection(Collection<F> param1Collection, Function<? super F, ? extends T> param1Function) {
      this.a = (Collection<F>)Preconditions.a(param1Collection);
      this.b = (Function<? super F, ? extends T>)Preconditions.a(param1Function);
    }
    
    public void clear() {
      this.a.clear();
    }
    
    public boolean isEmpty() {
      return this.a.isEmpty();
    }
    
    public Iterator<T> iterator() {
      return Iterators.a(this.a.iterator(), this.b);
    }
    
    public int size() {
      return this.a.size();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\Collections2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */