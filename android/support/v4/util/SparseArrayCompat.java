package android.support.v4.util;

public final class SparseArrayCompat implements Cloneable {
  private static final Object DELETED = new Object();
  
  public boolean mGarbage = false;
  
  public int[] mKeys;
  
  public int mSize;
  
  private Object[] mValues;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public SparseArrayCompat() {
    this(10);
  }
  
  public SparseArrayCompat(int paramInt) {
    if (paramInt == 0) {
      this.mKeys = ContainerHelpers.EMPTY_INTS;
      this.mValues = ContainerHelpers.EMPTY_OBJECTS;
    } else {
      paramInt = ContainerHelpers.idealIntArraySize(paramInt);
      this.mKeys = new int[paramInt];
      this.mValues = new Object[paramInt];
    } 
    this.mSize = 0;
  }
  
  private SparseArrayCompat clone() {
    try {
      SparseArrayCompat sparseArrayCompat = (SparseArrayCompat)super.clone();
      try {
        sparseArrayCompat.mKeys = (int[])this.mKeys.clone();
        sparseArrayCompat.mValues = (Object[])this.mValues.clone();
        return sparseArrayCompat;
      } catch (CloneNotSupportedException cloneNotSupportedException) {
        return sparseArrayCompat;
      } 
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      return null;
    } 
  }
  
  public final void append(int paramInt, Object paramObject) {
    if (this.mSize != 0 && paramInt <= this.mKeys[this.mSize - 1]) {
      put(paramInt, paramObject);
      return;
    } 
    if (this.mGarbage && this.mSize >= this.mKeys.length)
      gc(); 
    int i = this.mSize;
    if (i >= this.mKeys.length) {
      int j = ContainerHelpers.idealIntArraySize(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.mKeys, 0, arrayOfInt, 0, this.mKeys.length);
      System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
      this.mKeys = arrayOfInt;
      this.mValues = arrayOfObject;
    } 
    this.mKeys[i] = paramInt;
    this.mValues[i] = paramObject;
    this.mSize = i + 1;
  }
  
  public final void clear() {
    int j = this.mSize;
    Object[] arrayOfObject = this.mValues;
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = null; 
    this.mSize = 0;
    this.mGarbage = false;
  }
  
  public final void gc() {
    int k = this.mSize;
    int[] arrayOfInt = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      Object object = arrayOfObject[i];
      int m = j;
      if (object != DELETED) {
        if (i != j) {
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final Object get(int paramInt) {
    paramInt = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
    return (paramInt < 0 || this.mValues[paramInt] == DELETED) ? null : this.mValues[paramInt];
  }
  
  public final int keyAt(int paramInt) {
    if (this.mGarbage)
      gc(); 
    return this.mKeys[paramInt];
  }
  
  public final void put(int paramInt, Object paramObject) {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
    if (i >= 0) {
      this.mValues[i] = paramObject;
      return;
    } 
    int j = i ^ 0xFFFFFFFF;
    if (j < this.mSize && this.mValues[j] == DELETED) {
      this.mKeys[j] = paramInt;
      this.mValues[j] = paramObject;
      return;
    } 
    i = j;
    if (this.mGarbage) {
      i = j;
      if (this.mSize >= this.mKeys.length) {
        gc();
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt) ^ 0xFFFFFFFF;
      } 
    } 
    if (this.mSize >= this.mKeys.length) {
      j = ContainerHelpers.idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.mKeys, 0, arrayOfInt, 0, this.mKeys.length);
      System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
      this.mKeys = arrayOfInt;
      this.mValues = arrayOfObject;
    } 
    if (this.mSize - i != 0) {
      int[] arrayOfInt1 = this.mKeys;
      int[] arrayOfInt2 = this.mKeys;
      j = i + 1;
      System.arraycopy(arrayOfInt1, i, arrayOfInt2, j, this.mSize - i);
      System.arraycopy(this.mValues, i, this.mValues, j, this.mSize - i);
    } 
    this.mKeys[i] = paramInt;
    this.mValues[i] = paramObject;
    this.mSize++;
  }
  
  public final void remove(int paramInt) {
    paramInt = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramInt);
    if (paramInt >= 0 && this.mValues[paramInt] != DELETED) {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    } 
  }
  
  public final int size() {
    if (this.mGarbage)
      gc(); 
    return this.mSize;
  }
  
  public final String toString() {
    if (size() <= 0)
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
  
  public final Object valueAt(int paramInt) {
    if (this.mGarbage)
      gc(); 
    return this.mValues[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\SparseArrayCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */