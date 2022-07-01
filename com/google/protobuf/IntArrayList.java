package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, PrimitiveNonBoxingCollection, RandomAccess {
  private static final IntArrayList EMPTY_LIST = new IntArrayList(new int[0], 0);
  
  private int[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  IntArrayList() {
    this(new int[10], 0);
  }
  
  private IntArrayList(int[] paramArrayOfint, int paramInt) {
    this.array = paramArrayOfint;
    this.size = paramInt;
  }
  
  private void addInt(int paramInt1, int paramInt2) {
    ensureIsMutable();
    if (paramInt1 >= 0) {
      int i = this.size;
      if (paramInt1 <= i) {
        int[] arrayOfInt = this.array;
        if (i < arrayOfInt.length) {
          System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, i - paramInt1);
        } else {
          int[] arrayOfInt1 = new int[i * 3 / 2 + 1];
          System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, paramInt1);
          System.arraycopy(this.array, paramInt1, arrayOfInt1, paramInt1 + 1, this.size - paramInt1);
          this.array = arrayOfInt1;
        } 
        this.array[paramInt1] = paramInt2;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt1));
  }
  
  public static IntArrayList emptyList() {
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
  
  public void add(int paramInt, Integer paramInteger) {
    addInt(paramInt, paramInteger.intValue());
  }
  
  public boolean add(Integer paramInteger) {
    addInt(paramInteger.intValue());
    return true;
  }
  
  public boolean addAll(Collection<? extends Integer> paramCollection) {
    ensureIsMutable();
    Internal.checkNotNull(paramCollection);
    if (!(paramCollection instanceof IntArrayList))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((IntArrayList)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      int[] arrayOfInt = this.array;
      if (i > arrayOfInt.length)
        this.array = Arrays.copyOf(arrayOfInt, i); 
      System.arraycopy(((IntArrayList)paramCollection).array, 0, this.array, this.size, ((IntArrayList)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public void addInt(int paramInt) {
    ensureIsMutable();
    int i = this.size;
    int[] arrayOfInt = this.array;
    if (i == arrayOfInt.length) {
      int[] arrayOfInt1 = new int[i * 3 / 2 + 1];
      System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, i);
      this.array = arrayOfInt1;
    } 
    arrayOfInt = this.array;
    i = this.size;
    this.size = i + 1;
    arrayOfInt[i] = paramInt;
  }
  
  public boolean contains(Object paramObject) {
    return (indexOf(paramObject) != -1);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof IntArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((IntArrayList)paramObject).size)
      return false; 
    paramObject = ((IntArrayList)paramObject).array;
    for (int i = 0; i < this.size; i++) {
      if (this.array[i] != paramObject[i])
        return false; 
    } 
    return true;
  }
  
  public Integer get(int paramInt) {
    return Integer.valueOf(getInt(paramInt));
  }
  
  public int getInt(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int j = 1;
    for (int i = 0; i < this.size; i++)
      j = j * 31 + this.array[i]; 
    return j;
  }
  
  public int indexOf(Object paramObject) {
    if (!(paramObject instanceof Integer))
      return -1; 
    int j = ((Integer)paramObject).intValue();
    int k = size();
    for (int i = 0; i < k; i++) {
      if (this.array[i] == j)
        return i; 
    } 
    return -1;
  }
  
  public Internal.IntList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new IntArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Integer remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    int[] arrayOfInt = this.array;
    int i = arrayOfInt[paramInt];
    int j = this.size;
    if (paramInt < j - 1)
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, j - paramInt - 1); 
    this.size--;
    this.modCount++;
    return Integer.valueOf(i);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Integer.valueOf(this.array[i]))) {
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
      int[] arrayOfInt = this.array;
      System.arraycopy(arrayOfInt, paramInt2, arrayOfInt, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public Integer set(int paramInt, Integer paramInteger) {
    return Integer.valueOf(setInt(paramInt, paramInteger.intValue()));
  }
  
  public int setInt(int paramInt1, int paramInt2) {
    ensureIsMutable();
    ensureIndexInRange(paramInt1);
    int[] arrayOfInt = this.array;
    int i = arrayOfInt[paramInt1];
    arrayOfInt[paramInt1] = paramInt2;
    return i;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\IntArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */