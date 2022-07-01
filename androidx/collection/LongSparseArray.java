package androidx.collection;

public class LongSparseArray<E> implements Cloneable {
  private static final Object a = new Object();
  
  private boolean b = false;
  
  private long[] c;
  
  private Object[] d;
  
  private int e;
  
  public LongSparseArray() {
    this(10);
  }
  
  public LongSparseArray(int paramInt) {
    if (paramInt == 0) {
      this.c = ContainerHelpers.b;
      this.d = ContainerHelpers.c;
      return;
    } 
    paramInt = ContainerHelpers.idealLongArraySize(paramInt);
    this.c = new long[paramInt];
    this.d = new Object[paramInt];
  }
  
  private void a() {
    int k = this.e;
    long[] arrayOfLong = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      Object object = arrayOfObject[i];
      int m = j;
      if (object != a) {
        if (i != j) {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = object;
          arrayOfObject[i] = null;
        } 
        m = j + 1;
      } 
      i++;
    } 
    this.b = false;
    this.e = j;
  }
  
  public void append(long paramLong, E paramE) {
    int i = this.e;
    if (i != 0 && paramLong <= this.c[i - 1]) {
      put(paramLong, paramE);
      return;
    } 
    if (this.b && this.e >= this.c.length)
      a(); 
    i = this.e;
    if (i >= this.c.length) {
      int j = ContainerHelpers.idealLongArraySize(i + 1);
      long[] arrayOfLong1 = new long[j];
      Object[] arrayOfObject1 = new Object[j];
      long[] arrayOfLong2 = this.c;
      System.arraycopy(arrayOfLong2, 0, arrayOfLong1, 0, arrayOfLong2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfLong1;
      this.d = arrayOfObject1;
    } 
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e = i + 1;
  }
  
  public void clear() {
    int j = this.e;
    Object[] arrayOfObject = this.d;
    for (int i = 0; i < j; i++)
      arrayOfObject[i] = null; 
    this.e = 0;
    this.b = false;
  }
  
  public LongSparseArray<E> clone() {
    try {
      LongSparseArray<E> longSparseArray = (LongSparseArray)super.clone();
      longSparseArray.c = (long[])this.c.clone();
      longSparseArray.d = (Object[])this.d.clone();
      return longSparseArray;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public boolean containsKey(long paramLong) {
    return (indexOfKey(paramLong) >= 0);
  }
  
  public boolean containsValue(E paramE) {
    return (indexOfValue(paramE) >= 0);
  }
  
  @Deprecated
  public void delete(long paramLong) {
    remove(paramLong);
  }
  
  public E get(long paramLong) {
    return get(paramLong, null);
  }
  
  public E get(long paramLong, E paramE) {
    int i = ContainerHelpers.a(this.c, this.e, paramLong);
    if (i >= 0) {
      Object[] arrayOfObject = this.d;
      return (E)((arrayOfObject[i] == a) ? (Object)paramE : arrayOfObject[i]);
    } 
    return paramE;
  }
  
  public int indexOfKey(long paramLong) {
    if (this.b)
      a(); 
    return ContainerHelpers.a(this.c, this.e, paramLong);
  }
  
  public int indexOfValue(E paramE) {
    if (this.b)
      a(); 
    for (int i = 0; i < this.e; i++) {
      if (this.d[i] == paramE)
        return i; 
    } 
    return -1;
  }
  
  public boolean isEmpty() {
    return (size() == 0);
  }
  
  public long keyAt(int paramInt) {
    if (this.b)
      a(); 
    return this.c[paramInt];
  }
  
  public void put(long paramLong, E paramE) {
    int i = ContainerHelpers.a(this.c, this.e, paramLong);
    if (i >= 0) {
      this.d[i] = paramE;
      return;
    } 
    int j = i;
    if (j < this.e) {
      Object[] arrayOfObject = this.d;
      if (arrayOfObject[j] == a) {
        this.c[j] = paramLong;
        arrayOfObject[j] = paramE;
        return;
      } 
    } 
    i = j;
    if (this.b) {
      i = j;
      if (this.e >= this.c.length) {
        a();
        i = ContainerHelpers.a(this.c, this.e, paramLong);
      } 
    } 
    j = this.e;
    if (j >= this.c.length) {
      j = ContainerHelpers.idealLongArraySize(j + 1);
      long[] arrayOfLong1 = new long[j];
      Object[] arrayOfObject1 = new Object[j];
      long[] arrayOfLong2 = this.c;
      System.arraycopy(arrayOfLong2, 0, arrayOfLong1, 0, arrayOfLong2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfLong1;
      this.d = arrayOfObject1;
    } 
    j = this.e;
    if (j - i != 0) {
      long[] arrayOfLong = this.c;
      int k = i + 1;
      System.arraycopy(arrayOfLong, i, arrayOfLong, k, j - i);
      Object[] arrayOfObject = this.d;
      System.arraycopy(arrayOfObject, i, arrayOfObject, k, this.e - i);
    } 
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e++;
  }
  
  public void putAll(LongSparseArray<? extends E> paramLongSparseArray) {
    int j = paramLongSparseArray.size();
    for (int i = 0; i < j; i++)
      put(paramLongSparseArray.keyAt(i), paramLongSparseArray.valueAt(i)); 
  }
  
  public E putIfAbsent(long paramLong, E paramE) {
    E e = get(paramLong);
    if (e == null)
      put(paramLong, paramE); 
    return e;
  }
  
  public void remove(long paramLong) {
    int i = ContainerHelpers.a(this.c, this.e, paramLong);
    if (i >= 0) {
      Object[] arrayOfObject = this.d;
      Object object1 = arrayOfObject[i];
      Object object2 = a;
      if (object1 != object2) {
        arrayOfObject[i] = object2;
        this.b = true;
      } 
    } 
  }
  
  public boolean remove(long paramLong, Object paramObject) {
    int i = indexOfKey(paramLong);
    if (i >= 0) {
      E e = valueAt(i);
      if (paramObject == e || (paramObject != null && paramObject.equals(e))) {
        removeAt(i);
        return true;
      } 
    } 
    return false;
  }
  
  public void removeAt(int paramInt) {
    Object[] arrayOfObject = this.d;
    Object object1 = arrayOfObject[paramInt];
    Object object2 = a;
    if (object1 != object2) {
      arrayOfObject[paramInt] = object2;
      this.b = true;
    } 
  }
  
  public E replace(long paramLong, E paramE) {
    int i = indexOfKey(paramLong);
    if (i >= 0) {
      Object[] arrayOfObject = this.d;
      Object object = arrayOfObject[i];
      arrayOfObject[i] = paramE;
      return (E)object;
    } 
    return null;
  }
  
  public boolean replace(long paramLong, E paramE1, E paramE2) {
    int i = indexOfKey(paramLong);
    if (i >= 0) {
      Object object = this.d[i];
      if (object == paramE1 || (paramE1 != null && paramE1.equals(object))) {
        this.d[i] = paramE2;
        return true;
      } 
    } 
    return false;
  }
  
  public void setValueAt(int paramInt, E paramE) {
    if (this.b)
      a(); 
    this.d[paramInt] = paramE;
  }
  
  public int size() {
    if (this.b)
      a(); 
    return this.e;
  }
  
  public String toString() {
    if (size() <= 0)
      return "{}"; 
    StringBuilder stringBuilder = new StringBuilder(this.e * 28);
    stringBuilder.append('{');
    for (int i = 0; i < this.e; i++) {
      if (i > 0)
        stringBuilder.append(", "); 
      stringBuilder.append(keyAt(i));
      stringBuilder.append('=');
      E e = valueAt(i);
      if (e != this) {
        stringBuilder.append(e);
      } else {
        stringBuilder.append("(this Map)");
      } 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public E valueAt(int paramInt) {
    if (this.b)
      a(); 
    return (E)this.d[paramInt];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\collection\LongSparseArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */