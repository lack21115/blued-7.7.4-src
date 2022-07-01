package androidx.collection;

public class SparseArrayCompat<E> implements Cloneable {
  private static final Object a = new Object();
  
  private boolean b = false;
  
  private int[] c;
  
  private Object[] d;
  
  private int e;
  
  public SparseArrayCompat() {
    this(10);
  }
  
  public SparseArrayCompat(int paramInt) {
    if (paramInt == 0) {
      this.c = ContainerHelpers.a;
      this.d = ContainerHelpers.c;
      return;
    } 
    paramInt = ContainerHelpers.idealIntArraySize(paramInt);
    this.c = new int[paramInt];
    this.d = new Object[paramInt];
  }
  
  private void a() {
    int k = this.e;
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.d;
    int i = 0;
    int j;
    for (j = 0; i < k; j = m) {
      Object object = arrayOfObject[i];
      int m = j;
      if (object != a) {
        if (i != j) {
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public void append(int paramInt, E paramE) {
    int i = this.e;
    if (i != 0 && paramInt <= this.c[i - 1]) {
      put(paramInt, paramE);
      return;
    } 
    if (this.b && this.e >= this.c.length)
      a(); 
    i = this.e;
    if (i >= this.c.length) {
      int j = ContainerHelpers.idealIntArraySize(i + 1);
      int[] arrayOfInt1 = new int[j];
      Object[] arrayOfObject1 = new Object[j];
      int[] arrayOfInt2 = this.c;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfInt1;
      this.d = arrayOfObject1;
    } 
    this.c[i] = paramInt;
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
  
  public SparseArrayCompat<E> clone() {
    try {
      SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat)super.clone();
      sparseArrayCompat.c = (int[])this.c.clone();
      sparseArrayCompat.d = (Object[])this.d.clone();
      return sparseArrayCompat;
    } catch (CloneNotSupportedException cloneNotSupportedException) {
      throw new AssertionError(cloneNotSupportedException);
    } 
  }
  
  public boolean containsKey(int paramInt) {
    return (indexOfKey(paramInt) >= 0);
  }
  
  public boolean containsValue(E paramE) {
    return (indexOfValue(paramE) >= 0);
  }
  
  @Deprecated
  public void delete(int paramInt) {
    remove(paramInt);
  }
  
  public E get(int paramInt) {
    return get(paramInt, null);
  }
  
  public E get(int paramInt, E paramE) {
    paramInt = ContainerHelpers.a(this.c, this.e, paramInt);
    if (paramInt >= 0) {
      Object[] arrayOfObject = this.d;
      return (E)((arrayOfObject[paramInt] == a) ? (Object)paramE : arrayOfObject[paramInt]);
    } 
    return paramE;
  }
  
  public int indexOfKey(int paramInt) {
    if (this.b)
      a(); 
    return ContainerHelpers.a(this.c, this.e, paramInt);
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
  
  public int keyAt(int paramInt) {
    if (this.b)
      a(); 
    return this.c[paramInt];
  }
  
  public void put(int paramInt, E paramE) {
    int i = ContainerHelpers.a(this.c, this.e, paramInt);
    if (i >= 0) {
      this.d[i] = paramE;
      return;
    } 
    int j = i;
    if (j < this.e) {
      Object[] arrayOfObject = this.d;
      if (arrayOfObject[j] == a) {
        this.c[j] = paramInt;
        arrayOfObject[j] = paramE;
        return;
      } 
    } 
    i = j;
    if (this.b) {
      i = j;
      if (this.e >= this.c.length) {
        a();
        i = ContainerHelpers.a(this.c, this.e, paramInt);
      } 
    } 
    j = this.e;
    if (j >= this.c.length) {
      j = ContainerHelpers.idealIntArraySize(j + 1);
      int[] arrayOfInt1 = new int[j];
      Object[] arrayOfObject1 = new Object[j];
      int[] arrayOfInt2 = this.c;
      System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, arrayOfInt2.length);
      Object[] arrayOfObject2 = this.d;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, arrayOfObject2.length);
      this.c = arrayOfInt1;
      this.d = arrayOfObject1;
    } 
    j = this.e;
    if (j - i != 0) {
      int[] arrayOfInt = this.c;
      int k = i + 1;
      System.arraycopy(arrayOfInt, i, arrayOfInt, k, j - i);
      Object[] arrayOfObject = this.d;
      System.arraycopy(arrayOfObject, i, arrayOfObject, k, this.e - i);
    } 
    this.c[i] = paramInt;
    this.d[i] = paramE;
    this.e++;
  }
  
  public void putAll(SparseArrayCompat<? extends E> paramSparseArrayCompat) {
    int j = paramSparseArrayCompat.size();
    for (int i = 0; i < j; i++)
      put(paramSparseArrayCompat.keyAt(i), paramSparseArrayCompat.valueAt(i)); 
  }
  
  public E putIfAbsent(int paramInt, E paramE) {
    E e = get(paramInt);
    if (e == null)
      put(paramInt, paramE); 
    return e;
  }
  
  public void remove(int paramInt) {
    paramInt = ContainerHelpers.a(this.c, this.e, paramInt);
    if (paramInt >= 0) {
      Object[] arrayOfObject = this.d;
      Object object1 = arrayOfObject[paramInt];
      Object object2 = a;
      if (object1 != object2) {
        arrayOfObject[paramInt] = object2;
        this.b = true;
      } 
    } 
  }
  
  public boolean remove(int paramInt, Object paramObject) {
    paramInt = indexOfKey(paramInt);
    if (paramInt >= 0) {
      E e = valueAt(paramInt);
      if (paramObject == e || (paramObject != null && paramObject.equals(e))) {
        removeAt(paramInt);
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
  
  public void removeAtRange(int paramInt1, int paramInt2) {
    paramInt2 = Math.min(this.e, paramInt2 + paramInt1);
    while (paramInt1 < paramInt2) {
      removeAt(paramInt1);
      paramInt1++;
    } 
  }
  
  public E replace(int paramInt, E paramE) {
    paramInt = indexOfKey(paramInt);
    if (paramInt >= 0) {
      Object[] arrayOfObject = this.d;
      Object object = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
      return (E)object;
    } 
    return null;
  }
  
  public boolean replace(int paramInt, E paramE1, E paramE2) {
    paramInt = indexOfKey(paramInt);
    if (paramInt >= 0) {
      Object object = this.d[paramInt];
      if (object == paramE1 || (paramE1 != null && paramE1.equals(object))) {
        this.d[paramInt] = paramE2;
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\collection\SparseArrayCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */