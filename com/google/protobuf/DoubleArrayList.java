package com.google.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, PrimitiveNonBoxingCollection, RandomAccess {
  private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList(new double[0], 0);
  
  private double[] array;
  
  private int size;
  
  static {
    EMPTY_LIST.makeImmutable();
  }
  
  DoubleArrayList() {
    this(new double[10], 0);
  }
  
  private DoubleArrayList(double[] paramArrayOfdouble, int paramInt) {
    this.array = paramArrayOfdouble;
    this.size = paramInt;
  }
  
  private void addDouble(int paramInt, double paramDouble) {
    ensureIsMutable();
    if (paramInt >= 0) {
      int i = this.size;
      if (paramInt <= i) {
        double[] arrayOfDouble = this.array;
        if (i < arrayOfDouble.length) {
          System.arraycopy(arrayOfDouble, paramInt, arrayOfDouble, paramInt + 1, i - paramInt);
        } else {
          double[] arrayOfDouble1 = new double[i * 3 / 2 + 1];
          System.arraycopy(arrayOfDouble, 0, arrayOfDouble1, 0, paramInt);
          System.arraycopy(this.array, paramInt, arrayOfDouble1, paramInt + 1, this.size - paramInt);
          this.array = arrayOfDouble1;
        } 
        this.array[paramInt] = paramDouble;
        this.size++;
        this.modCount++;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(paramInt));
  }
  
  public static DoubleArrayList emptyList() {
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
  
  public void add(int paramInt, Double paramDouble) {
    addDouble(paramInt, paramDouble.doubleValue());
  }
  
  public boolean add(Double paramDouble) {
    addDouble(paramDouble.doubleValue());
    return true;
  }
  
  public boolean addAll(Collection<? extends Double> paramCollection) {
    ensureIsMutable();
    Internal.checkNotNull(paramCollection);
    if (!(paramCollection instanceof DoubleArrayList))
      return super.addAll(paramCollection); 
    paramCollection = paramCollection;
    int i = ((DoubleArrayList)paramCollection).size;
    if (i == 0)
      return false; 
    int j = this.size;
    if (Integer.MAX_VALUE - j >= i) {
      i = j + i;
      double[] arrayOfDouble = this.array;
      if (i > arrayOfDouble.length)
        this.array = Arrays.copyOf(arrayOfDouble, i); 
      System.arraycopy(((DoubleArrayList)paramCollection).array, 0, this.array, this.size, ((DoubleArrayList)paramCollection).size);
      this.size = i;
      this.modCount++;
      return true;
    } 
    throw new OutOfMemoryError();
  }
  
  public void addDouble(double paramDouble) {
    ensureIsMutable();
    int i = this.size;
    double[] arrayOfDouble = this.array;
    if (i == arrayOfDouble.length) {
      double[] arrayOfDouble1 = new double[i * 3 / 2 + 1];
      System.arraycopy(arrayOfDouble, 0, arrayOfDouble1, 0, i);
      this.array = arrayOfDouble1;
    } 
    arrayOfDouble = this.array;
    i = this.size;
    this.size = i + 1;
    arrayOfDouble[i] = paramDouble;
  }
  
  public boolean contains(Object paramObject) {
    return (indexOf(paramObject) != -1);
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof DoubleArrayList))
      return super.equals(paramObject); 
    paramObject = paramObject;
    if (this.size != ((DoubleArrayList)paramObject).size)
      return false; 
    paramObject = ((DoubleArrayList)paramObject).array;
    for (int i = 0; i < this.size; i++) {
      if (Double.doubleToLongBits(this.array[i]) != Double.doubleToLongBits(paramObject[i]))
        return false; 
    } 
    return true;
  }
  
  public Double get(int paramInt) {
    return Double.valueOf(getDouble(paramInt));
  }
  
  public double getDouble(int paramInt) {
    ensureIndexInRange(paramInt);
    return this.array[paramInt];
  }
  
  public int hashCode() {
    int j = 1;
    for (int i = 0; i < this.size; i++)
      j = j * 31 + Internal.hashLong(Double.doubleToLongBits(this.array[i])); 
    return j;
  }
  
  public int indexOf(Object paramObject) {
    if (!(paramObject instanceof Double))
      return -1; 
    double d = ((Double)paramObject).doubleValue();
    int j = size();
    int i;
    for (i = 0; i < j; i++) {
      if (this.array[i] == d)
        return i; 
    } 
    return -1;
  }
  
  public Internal.DoubleList mutableCopyWithCapacity(int paramInt) {
    if (paramInt >= this.size)
      return new DoubleArrayList(Arrays.copyOf(this.array, paramInt), this.size); 
    throw new IllegalArgumentException();
  }
  
  public Double remove(int paramInt) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double[] arrayOfDouble = this.array;
    double d = arrayOfDouble[paramInt];
    int i = this.size;
    if (paramInt < i - 1)
      System.arraycopy(arrayOfDouble, paramInt + 1, arrayOfDouble, paramInt, i - paramInt - 1); 
    this.size--;
    this.modCount++;
    return Double.valueOf(d);
  }
  
  public boolean remove(Object paramObject) {
    ensureIsMutable();
    for (int i = 0; i < this.size; i++) {
      if (paramObject.equals(Double.valueOf(this.array[i]))) {
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
      double[] arrayOfDouble = this.array;
      System.arraycopy(arrayOfDouble, paramInt2, arrayOfDouble, paramInt1, this.size - paramInt2);
      this.size -= paramInt2 - paramInt1;
      this.modCount++;
      return;
    } 
    throw new IndexOutOfBoundsException("toIndex < fromIndex");
  }
  
  public Double set(int paramInt, Double paramDouble) {
    return Double.valueOf(setDouble(paramInt, paramDouble.doubleValue()));
  }
  
  public double setDouble(int paramInt, double paramDouble) {
    ensureIsMutable();
    ensureIndexInRange(paramInt);
    double[] arrayOfDouble = this.array;
    double d = arrayOfDouble[paramInt];
    arrayOfDouble[paramInt] = paramDouble;
    return d;
  }
  
  public int size() {
    return this.size;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\DoubleArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */