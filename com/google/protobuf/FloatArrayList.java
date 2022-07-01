package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, PrimitiveNonBoxingCollection, RandomAccess {
  private static final FloatArrayList EMPTY_LIST = new FloatArrayList(new float[0], 0);
  
  private float[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  FloatArrayList() {
    this(new float[10], 0);
  }
  
  private FloatArrayList(float[] paramArrayOffloat, int paramInt) {
    this.array = paramArrayOffloat;
    this.size = paramInt;
  }
  
  private void addFloat(int paramInt, float paramFloat) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        float[] arrayOfFloat = this.array;
        if (i < arrayOfFloat.length) {
          System.arraycopy(arrayOfFloat, paramInt, arrayOfFloat, paramInt + 1, i - paramInt);
        } else {
          float[] arrayOfFloat1 = new float[i * 3 / 2 + 1];
          System.arraycopy(arrayOfFloat, 0, arrayOfFloat1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfFloat1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfFloat1;
        } 
        this.array[paramInt] = paramFloat;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static FloatArrayList emptyList() {
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
  
  public void add(int paramInt, Float paramFloat) {
    addFloat(paramInt, paramFloat.floatValue());
  }
  
  public boolean add(Float paramFloat) {
    addFloat(paramFloat.floatValue());
    return true;
  }
  
  public boolean addAll(Collection<? extends Float> paramCollection) {
    ensureIsMutable();
    Internal.checkNotNull(paramCollection);
    if (!(paramCollection instanceof FloatArrayList))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((FloatArrayList)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      float[] arrayOfFloat = this.array;
      if (i > arrayOfFloat.length)
        this.array = Arrays.copyOf(arrayOfFloat, i); 
      System.arraycopy(((FloatArrayList)paramCollection).array, 0, this.array, this.size, ((FloatArrayList)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public void addFloat(float paramFloat) {
    ensureIsMutable();
    int i = this.size;
    float[] arrayOfFloat = this.array;
    if (i == arrayOfFloat.length) {
      float[] arrayOfFloat1 = new float[i * 3 / 2 + 1];
      System.arraycopy(arrayOfFloat, 0, arrayOfFloat1, 0, i);
      this.array = arrayOfFloat1;
    } 
    arrayOfFloat = this.array;
    i = this.size;
    this.size = i + 1;
    arrayOfFloat[i] = paramFloat;
  }
  
  public boolean contains(Object paramObject) {
    return (indexOf(paramObject) != -1);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof FloatArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((FloatArrayList)paramObject).size)
      return false; 
    paramObject = ((FloatArrayList)paramObject).array;
    for (int i = 0; i < this.size; i++) {
      if (Float.floatToIntBits(this.array[i]) != Float.floatToIntBits(paramObject[i]))
        return false; 
    } 
    return true;
  }
  
  public Float get(int paramInt) {
    return Float.valueOf(getFloat(paramInt));
  }
  
  public float getFloat(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int j = 1;
    for (int i = 0; i < this.size; i++)
      j = j * 31 + Float.floatToIntBits(this.array[i]); 
    return j;
  }
  
  public int indexOf(Object paramObject) {
    if (!(paramObject instanceof Float))
      return -1; 
    float f = ((Float)paramObject).floatValue();
    int j = size();
    for (int i = 0; i < j; i++) {
      if (this.array[i] == f)
        return i; 
    } 
    return -1;
  }
  
  public Internal.FloatList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new FloatArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Float remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float[] arrayOfFloat = this.array;
    float f = arrayOfFloat[paramInt];
    int i = this.size;
    if (paramInt < i - 1)
      System.arraycopy(arrayOfFloat, paramInt + 1, arrayOfFloat, paramInt, i - paramInt - 1); 
    this.size--;
    this.modCount++;
    return Float.valueOf(f);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Float.valueOf(this.array[i]))) {
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
      float[] arrayOfFloat = this.array;
      System.arraycopy(arrayOfFloat, paramInt2, arrayOfFloat, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public Float set(int paramInt, Float paramFloat) {
    return Float.valueOf(setFloat(paramInt, paramFloat.floatValue()));
  }
  
  public float setFloat(int paramInt, float paramFloat) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    float[] arrayOfFloat = this.array;
    float f = arrayOfFloat[paramInt];
    arrayOfFloat[paramInt] = paramFloat;
    return f;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\FloatArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */