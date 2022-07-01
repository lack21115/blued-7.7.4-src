package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, PrimitiveNonBoxingCollection, RandomAccess {
  private static final LongArrayList EMPTY_LIST = new LongArrayList(new long[0], 0);
  
  private long[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  LongArrayList() {
    this(new long[10], 0);
  }
  
  private LongArrayList(long[] paramArrayOflong, int paramInt) {
    this.array = paramArrayOflong;
    this.size = paramInt;
  }
  
  private void addLong(int paramInt, long paramLong) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        long[] arrayOfLong = this.array;
        if (i < arrayOfLong.length) {
          System.arraycopy(arrayOfLong, paramInt, arrayOfLong, paramInt + 1, i - paramInt);
        } else {
          long[] arrayOfLong1 = new long[i * 3 / 2 + 1];
          System.arraycopy(arrayOfLong, 0, arrayOfLong1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfLong1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfLong1;
        } 
        this.array[paramInt] = paramLong;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static LongArrayList emptyList() {
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
  
  public void add(int paramInt, Long paramLong) {
    addLong(paramInt, paramLong.longValue());
  }
  
  public boolean add(Long paramLong) {
    addLong(paramLong.longValue());
    return true;
  }
  
  public boolean addAll(Collection<? extends Long> paramCollection) {
    ensureIsMutable();
    Internal.checkNotNull(paramCollection);
    if (!(paramCollection instanceof LongArrayList))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((LongArrayList)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      long[] arrayOfLong = this.array;
      if (i > arrayOfLong.length)
        this.array = Arrays.copyOf(arrayOfLong, i); 
      System.arraycopy(((LongArrayList)paramCollection).array, 0, this.array, this.size, ((LongArrayList)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public void addLong(long paramLong) {
    ensureIsMutable();
    int i = this.size;
    long[] arrayOfLong = this.array;
    if (i == arrayOfLong.length) {
      long[] arrayOfLong1 = new long[i * 3 / 2 + 1];
      System.arraycopy(arrayOfLong, 0, arrayOfLong1, 0, i);
      this.array = arrayOfLong1;
    } 
    arrayOfLong = this.array;
    i = this.size;
    this.size = i + 1;
    arrayOfLong[i] = paramLong;
  }
  
  public boolean contains(Object paramObject) {
    return (indexOf(paramObject) != -1);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof LongArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((LongArrayList)paramObject).size)
      return false; 
    paramObject = ((LongArrayList)paramObject).array;
    for (int i = 0; i < this.size; i++) {
      if (this.array[i] != paramObject[i])
        return false; 
    } 
    return true;
  }
  
  public Long get(int paramInt) {
    return Long.valueOf(getLong(paramInt));
  }
  
  public long getLong(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int j = 1;
    for (int i = 0; i < this.size; i++)
      j = j * 31 + Internal.hashLong(this.array[i]); 
    return j;
  }
  
  public int indexOf(Object paramObject) {
    if (!(paramObject instanceof Long))
      return -1; 
    long l = ((Long)paramObject).longValue();
    int j = size();
    for (int i = 0; i < j; i++) {
      if (this.array[i] == l)
        return i; 
    } 
    return -1;
  }
  
  public Internal.LongList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new LongArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Long remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long[] arrayOfLong = this.array;
    long l = arrayOfLong[paramInt];
    int i = this.size;
    if (paramInt < i - 1)
      System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, i - paramInt - 1); 
    this.size--;
    this.modCount++;
    return Long.valueOf(l);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Long.valueOf(this.array[i]))) {
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
      long[] arrayOfLong = this.array;
      System.arraycopy(arrayOfLong, paramInt2, arrayOfLong, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public Long set(int paramInt, Long paramLong) {
    return Long.valueOf(setLong(paramInt, paramLong.longValue()));
  }
  
  public long setLong(int paramInt, long paramLong) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    long[] arrayOfLong = this.array;
    long l = arrayOfLong[paramInt];
    arrayOfLong[paramInt] = paramLong;
    return l;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\LongArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */