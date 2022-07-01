package android.support.v4.util;

public final class LongSparseArray implements Cloneable {
  public static final Object DELETED = new Object();
  
  public boolean mGarbage = false;
  
  public long[] mKeys;
  
  public int mSize;
  
  public Object[] mValues;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public LongSparseArray() {
    this(10);
  }
  
  private LongSparseArray(int paramInt) {
    if (paramInt == 0) {
      this.mKeys = ContainerHelpers.EMPTY_LONGS;
      this.mValues = ContainerHelpers.EMPTY_OBJECTS;
    } else {
      paramInt = ContainerHelpers.idealLongArraySize(paramInt);
      this.mKeys = new long[paramInt];
      this.mValues = new Object[paramInt];
    } 
    this.mSize = 0;
  }
  
  private LongSparseArray clone() {
    try {
      LongSparseArray longSparseArray = (LongSparseArray)super.clone();
      try {
        longSparseArray.mKeys = (long[])this.mKeys.clone();
        longSparseArray.mValues = (Object[])this.mValues.clone();
        return longSparseArray;
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        return longSparseArray;
      } 
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  private void gc() {
    int k = this.mSize;
    long[] arrayOfLong = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      Object object = arrayOfObject[i];
      int m = j;
      if (object != DELETED) {
        if (i != j) {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = object;
          arrayOfObject[i] = null;
        } 
        m = j + 1;
      } 
      i++;
    } 
    this.mGarbage = false;
    this.mSize = j;
  }
  
  private long keyAt(int paramInt) {
    if (this.mGarbage)
      gc(); 
    return this.mKeys[paramInt];
  }
  
  private Object valueAt(int paramInt) {
    if (this.mGarbage)
      gc(); 
    return this.mValues[paramInt];
  }
  
  public final void put(long paramLong, Object paramObject) {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0) {
      this.mValues[i] = paramObject;
      return;
    } 
    int j = i ^ 0xFFFFFFFF;
    if (j < this.mSize && this.mValues[j] == DELETED) {
      this.mKeys[j] = paramLong;
      this.mValues[j] = paramObject;
      return;
    } 
    i = j;
    if (this.mGarbage) {
      i = j;
      if (this.mSize >= this.mKeys.length) {
        gc();
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong) ^ 0xFFFFFFFF;
      } 
    } 
    if (this.mSize >= this.mKeys.length) {
      j = ContainerHelpers.idealLongArraySize(this.mSize + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
      System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
      this.mKeys = arrayOfLong;
      this.mValues = arrayOfObject;
    } 
    if (this.mSize - i != 0) {
      long[] arrayOfLong1 = this.mKeys;
      long[] arrayOfLong2 = this.mKeys;
      j = i + 1;
      System.arraycopy(arrayOfLong1, i, arrayOfLong2, j, this.mSize - i);
      System.arraycopy(this.mValues, i, this.mValues, j, this.mSize - i);
    } 
    this.mKeys[i] = paramLong;
    this.mValues[i] = paramObject;
    this.mSize++;
  }
  
  public final String toString() {
    if (this.mGarbage)
      gc(); 
    if (this.mSize <= 0)
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
    stringBuilder.append('{');
    for (int i = 0; i < this.mSize; i++) {
      if (i > 0)
        stringBuilder.append(", "); 
      stringBuilder.append(keyAt(i));
      stringBuilder.append('=');
      Object object = valueAt(i);
      if (object != this) {
        stringBuilder.append(object);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\LongSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */