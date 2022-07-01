package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, PrimitiveNonBoxingCollection, RandomAccess {
  private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList(new boolean[0], 0);
  
  private boolean[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  BooleanArrayList() {
    this(new boolean[10], 0);
  }
  
  private BooleanArrayList(boolean[] paramArrayOfboolean, int paramInt) {
    this.array = paramArrayOfboolean;
    this.size = paramInt;
  }
  
  private void addBoolean(int paramInt, boolean paramBoolean) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        boolean[] arrayOfBoolean = this.array;
        if (i < arrayOfBoolean.length) {
          System.arraycopy(arrayOfBoolean, paramInt, arrayOfBoolean, paramInt + 1, i - paramInt);
        } else {
          boolean[] arrayOfBoolean1 = new boolean[i * 3 / 2 + 1];
          System.arraycopy(arrayOfBoolean, 0, arrayOfBoolean1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfBoolean1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfBoolean1;
        } 
        this.array[paramInt] = paramBoolean;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static BooleanArrayList emptyList() {
    return EMPTY_LIST;
  }
  
  private void ensureIndexInRange(int paramInt) {
    if (paramInt >= 0 && paramInt < this.size)
      return; 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  private String makeOutOfBoundsExceptionMessage(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Index:");
    stringBuilder.append(paramInt);
    stringBuilder.append(", Size:");
    stringBuilder.append(this.size);
    return stringBuilder.toString();
  }
  
  public void add(int paramInt, Boolean paramBoolean) {
    addBoolean(paramInt, paramBoolean.booleanValue());
  }
  
  public boolean add(Boolean paramBoolean) {
    addBoolean(paramBoolean.booleanValue());
    return true;
  }
  
  public boolean addAll(Collection<? extends Boolean> paramCollection) {
    ensureIsMutable();
    Internal.checkNotNull(paramCollection);
    if (!(paramCollection instanceof BooleanArrayList))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((BooleanArrayList)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      boolean[] arrayOfBoolean = this.array;
      if (i > arrayOfBoolean.length)
        this.array = Arrays.copyOf(arrayOfBoolean, i); 
      System.arraycopy(((BooleanArrayList)paramCollection).array, 0, this.array, this.size, ((BooleanArrayList)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public void addBoolean(boolean paramBoolean) {
    ensureIsMutable();
    int i = this.size;
    boolean[] arrayOfBoolean = this.array;
    if (i == arrayOfBoolean.length) {
      boolean[] arrayOfBoolean1 = new boolean[i * 3 / 2 + 1];
      System.arraycopy(arrayOfBoolean, 0, arrayOfBoolean1, 0, i);
      this.array = arrayOfBoolean1;
    } 
    arrayOfBoolean = this.array;
    i = this.size;
    this.size = i + 1;
    arrayOfBoolean[i] = paramBoolean;
  }
  
  public boolean contains(Object paramObject) {
    return (indexOf(paramObject) != -1);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof BooleanArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((BooleanArrayList)paramObject).size)
      return false; 
    paramObject = ((BooleanArrayList)paramObject).array;
    for (int i = 0; i < this.size; i++) {
      if (this.array[i] != paramObject[i])
        return false; 
    } 
    return true;
  }
  
  public Boolean get(int paramInt) {
    return Boolean.valueOf(getBoolean(paramInt));
  }
  
  public boolean getBoolean(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int j = 1;
    for (int i = 0; i < this.size; i++)
      j = j * 31 + Internal.hashBoolean(this.array[i]); 
    return j;
  }
  
  public int indexOf(Object paramObject) {
    if (!(paramObject instanceof Boolean))
      return -1; 
    boolean bool = ((Boolean)paramObject).booleanValue();
    int j = size();
    for (int i = 0; i < j; i++) {
      if (this.array[i] == bool)
        return i; 
    } 
    return -1;
  }
  
  public Internal.BooleanList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new BooleanArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Boolean remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    boolean[] arrayOfBoolean = this.array;
    boolean bool = arrayOfBoolean[paramInt];
    int i = this.size;
    if (paramInt < i - 1)
      System.arraycopy(arrayOfBoolean, paramInt + 1, arrayOfBoolean, paramInt, i - paramInt - 1); 
    this.size--;
    this.modCount++;
    return Boolean.valueOf(bool);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Boolean.valueOf(this.array[i]))) {
        paramObject = this.array;
        System.arraycopy(paramObject, i + 1, paramObject, i, this.size - i - 1);
        this.size--;
        this.modCount++;
        return true;
      } 
    } 
    return false;
  }
  
  protected void removeRange(int paramInt1, int paramInt2) {
    ensureIsMutable();
    if (paramInt2 >= paramInt1) {
      boolean[] arrayOfBoolean = this.array;
      System.arraycopy(arrayOfBoolean, paramInt2, arrayOfBoolean, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public Boolean set(int paramInt, Boolean paramBoolean) {
    return Boolean.valueOf(setBoolean(paramInt, paramBoolean.booleanValue()));
  }
  
  public boolean setBoolean(int paramInt, boolean paramBoolean) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    boolean[] arrayOfBoolean = this.array;
    boolean bool = arrayOfBoolean[paramInt];
    arrayOfBoolean[paramInt] = paramBoolean;
    return bool;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\BooleanArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */