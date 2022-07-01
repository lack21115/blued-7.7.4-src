package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
  private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList((E[])new Object[0], 0);
  
  private E[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  ProtobufArrayList() {
    this((E[])new Object[10], 0);
  }
  
  private ProtobufArrayList(E[] paramArrayOfE, int paramInt) {
    this.array = paramArrayOfE;
    this.size = paramInt;
  }
  
  private static <E> E[] createArray(int paramInt) {
    return (E[])new Object[paramInt];
  }
  
  public static <E> ProtobufArrayList<E> emptyList() {
    return (ProtobufArrayList)EMPTY_LIST;
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
  
  public void add(int paramInt, E paramE) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        E[] arrayOfE = this.array;
        if (i < arrayOfE.length) {
          System.arraycopy(arrayOfE, paramInt, arrayOfE, paramInt + 1, i - paramInt);
        } else {
          arrayOfE = createArray(i * 3 / 2 + 1);
          System.arraycopy(this.array, 0, arrayOfE, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfE, paramInt + 1, this.size - paramInt);
          this.array = arrayOfE;
        } 
        this.array[paramInt] = paramE;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public boolean add(E paramE) {
    ensureIsMutable();
    int i = this.size;
    E[] arrayOfE = this.array;
    if (i == arrayOfE.length)
      this.array = Arrays.copyOf(arrayOfE, i * 3 / 2 + 1); 
    arrayOfE = this.array;
    i = this.size;
    this.size = i + 1;
    arrayOfE[i] = paramE;
    this.modCount++;
    return true;
  }
  
  public E get(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public ProtobufArrayList<E> mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new ProtobufArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public E remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    E[] arrayOfE = this.array;
    E e = arrayOfE[paramInt];
    int i = this.size;
    if (paramInt < i - 1)
      System.arraycopy(arrayOfE, paramInt + 1, arrayOfE, paramInt, i - paramInt - 1); 
    this.size--;
    this.modCount++;
    return e;
  }
  
  public E set(int paramInt, E paramE) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    E[] arrayOfE = this.array;
    E e = arrayOfE[paramInt];
    arrayOfE[paramInt] = paramE;
    this.modCount++;
    return e;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ProtobufArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */