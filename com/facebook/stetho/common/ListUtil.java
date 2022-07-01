package com.facebook.stetho.common;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class ListUtil {
  public static <T> List<T> copyToImmutableList(List<T> paramList) {
    if (paramList instanceof ImmutableList)
      return paramList; 
    int i = paramList.size();
    return (List<T>)((i != 0) ? ((i != 1) ? ((i != 2) ? ((i != 3) ? ((i != 4) ? ((i != 5) ? new ImmutableArrayList<T>(paramList.toArray()) : new FiveItemImmutableList<T>(paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3), paramList.get(4))) : new FourItemImmutableList<T>(paramList.get(0), paramList.get(1), paramList.get(2), paramList.get(3))) : new ThreeItemImmutableList<T>(paramList.get(0), paramList.get(1), paramList.get(2))) : new TwoItemImmutableList<T>(paramList.get(0), paramList.get(1))) : new OneItemImmutableList<T>(paramList.get(0))) : Collections.emptyList());
  }
  
  public static <T> boolean identityEquals(List<? extends T> paramList1, List<? extends T> paramList2) {
    if (paramList1 == paramList2)
      return true; 
    int j = paramList1.size();
    if (j != paramList2.size())
      return false; 
    for (int i = 0; i < j; i++) {
      if (paramList1.get(i) != paramList2.get(i))
        return false; 
    } 
    return true;
  }
  
  public static <T> List<T> newImmutableList(T paramT) {
    return new OneItemImmutableList<T>(paramT);
  }
  
  public static <T> List<T> newImmutableList(T paramT1, T paramT2) {
    return new TwoItemImmutableList<T>(paramT1, paramT2);
  }
  
  static final class FiveItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
    private final E mItem0;
    
    private final E mItem1;
    
    private final E mItem2;
    
    private final E mItem3;
    
    private final E mItem4;
    
    public FiveItemImmutableList(E param1E1, E param1E2, E param1E3, E param1E4, E param1E5) {
      this.mItem0 = param1E1;
      this.mItem1 = param1E2;
      this.mItem2 = param1E3;
      this.mItem3 = param1E4;
      this.mItem4 = param1E5;
    }
    
    public E get(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int != 3) {
              if (param1Int == 4)
                return this.mItem4; 
              throw new IndexOutOfBoundsException();
            } 
            return this.mItem3;
          } 
          return this.mItem2;
        } 
        return this.mItem1;
      } 
      return this.mItem0;
    }
    
    public int size() {
      return 5;
    }
  }
  
  static final class FourItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
    private final E mItem0;
    
    private final E mItem1;
    
    private final E mItem2;
    
    private final E mItem3;
    
    public FourItemImmutableList(E param1E1, E param1E2, E param1E3, E param1E4) {
      this.mItem0 = param1E1;
      this.mItem1 = param1E2;
      this.mItem2 = param1E3;
      this.mItem3 = param1E4;
    }
    
    public E get(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int == 3)
              return this.mItem3; 
            throw new IndexOutOfBoundsException();
          } 
          return this.mItem2;
        } 
        return this.mItem1;
      } 
      return this.mItem0;
    }
    
    public int size() {
      return 4;
    }
  }
  
  static final class ImmutableArrayList<E> extends AbstractList<E> implements ImmutableList<E> {
    private final Object[] mArray;
    
    public ImmutableArrayList(Object[] param1ArrayOfObject) {
      this.mArray = param1ArrayOfObject;
    }
    
    public E get(int param1Int) {
      return (E)this.mArray[param1Int];
    }
    
    public int size() {
      return this.mArray.length;
    }
  }
  
  static interface ImmutableList<E> extends List<E>, RandomAccess {}
  
  static final class OneItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
    private final E mItem;
    
    public OneItemImmutableList(E param1E) {
      this.mItem = param1E;
    }
    
    public E get(int param1Int) {
      if (param1Int == 0)
        return this.mItem; 
      throw new IndexOutOfBoundsException();
    }
    
    public int size() {
      return 1;
    }
  }
  
  static final class ThreeItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
    private final E mItem0;
    
    private final E mItem1;
    
    private final E mItem2;
    
    public ThreeItemImmutableList(E param1E1, E param1E2, E param1E3) {
      this.mItem0 = param1E1;
      this.mItem1 = param1E2;
      this.mItem2 = param1E3;
    }
    
    public E get(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int == 2)
            return this.mItem2; 
          throw new IndexOutOfBoundsException();
        } 
        return this.mItem1;
      } 
      return this.mItem0;
    }
    
    public int size() {
      return 3;
    }
  }
  
  static final class TwoItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
    private final E mItem0;
    
    private final E mItem1;
    
    public TwoItemImmutableList(E param1E1, E param1E2) {
      this.mItem0 = param1E1;
      this.mItem1 = param1E2;
    }
    
    public E get(int param1Int) {
      if (param1Int != 0) {
        if (param1Int == 1)
          return this.mItem1; 
        throw new IndexOutOfBoundsException();
      } 
      return this.mItem0;
    }
    
    public int size() {
      return 2;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\ListUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */