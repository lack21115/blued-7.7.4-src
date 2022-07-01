package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
  private final transient ImmutableList<List<E>> a;
  
  private final transient int[] b;
  
  private int a(int paramInt1, int paramInt2) {
    return paramInt1 / this.b[paramInt2 + 1] % ((List)this.a.get(paramInt2)).size();
  }
  
  public ImmutableList<E> a(int paramInt) {
    Preconditions.a(paramInt, size());
    return new ImmutableList<E>(this, paramInt) {
        boolean a() {
          return true;
        }
        
        public E get(int param1Int) {
          Preconditions.a(param1Int, size());
          int i = CartesianList.a(this.b, this.a, param1Int);
          return ((List<E>)CartesianList.a(this.b).get(param1Int)).get(i);
        }
        
        public int size() {
          return CartesianList.a(this.b).size();
        }
      };
  }
  
  public boolean contains(@NullableDecl Object paramObject) {
    return (indexOf(paramObject) != -1);
  }
  
  public int indexOf(Object paramObject) {
    if (!(paramObject instanceof List))
      return -1; 
    paramObject = paramObject;
    if (paramObject.size() != this.a.size())
      return -1; 
    paramObject = paramObject.listIterator();
    int i;
    for (i = 0; paramObject.hasNext(); i += k * this.b[j + 1]) {
      int j = paramObject.nextIndex();
      int k = ((List)this.a.get(j)).indexOf(paramObject.next());
      if (k == -1)
        return -1; 
    } 
    return i;
  }
  
  public int size() {
    return this.b[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\collect\CartesianList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */