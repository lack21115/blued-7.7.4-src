package androidx.collection;

public final class CircularArray<E> {
  private E[] a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  public CircularArray() {
    this(8);
  }
  
  public CircularArray(int paramInt) {
    if (paramInt >= 1) {
      if (paramInt <= 1073741824) {
        int i = paramInt;
        if (Integer.bitCount(paramInt) != 1)
          i = Integer.highestOneBit(paramInt - 1) << 1; 
        this.d = i - 1;
        this.a = (E[])new Object[i];
        return;
      } 
      throw new IllegalArgumentException("capacity must be <= 2^30");
    } 
    throw new IllegalArgumentException("capacity must be >= 1");
  }
  
  private void a() {
    E[] arrayOfE = this.a;
    int i = arrayOfE.length;
    int j = this.b;
    int k = i - j;
    int m = i << 1;
    if (m >= 0) {
      Object[] arrayOfObject = new Object[m];
      System.arraycopy(arrayOfE, j, arrayOfObject, 0, k);
      System.arraycopy(this.a, 0, arrayOfObject, k, this.b);
      this.a = (E[])arrayOfObject;
      this.b = 0;
      this.c = i;
      this.d = m - 1;
      return;
    } 
    throw new RuntimeException("Max array capacity exceeded");
  }
  
  public void addFirst(E paramE) {
    this.b = this.b - 1 & this.d;
    E[] arrayOfE = this.a;
    int i = this.b;
    arrayOfE[i] = paramE;
    if (i == this.c)
      a(); 
  }
  
  public void addLast(E paramE) {
    E[] arrayOfE = this.a;
    int i = this.c;
    arrayOfE[i] = paramE;
    this.c = this.d & i + 1;
    if (this.c == this.b)
      a(); 
  }
  
  public void clear() {
    removeFromStart(size());
  }
  
  public E get(int paramInt) {
    if (paramInt >= 0 && paramInt < size()) {
      E[] arrayOfE = this.a;
      int i = this.b;
      return arrayOfE[this.d & i + paramInt];
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E getFirst() {
    int i = this.b;
    if (i != this.c)
      return this.a[i]; 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E getLast() {
    int i = this.b;
    int j = this.c;
    if (i != j)
      return this.a[j - 1 & this.d]; 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public boolean isEmpty() {
    return (this.b == this.c);
  }
  
  public E popFirst() {
    int i = this.b;
    if (i != this.c) {
      E[] arrayOfE = this.a;
      E e = arrayOfE[i];
      arrayOfE[i] = null;
      this.b = i + 1 & this.d;
      return e;
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public E popLast() {
    int i = this.b;
    int j = this.c;
    if (i != j) {
      i = this.d & j - 1;
      E[] arrayOfE = this.a;
      E e = arrayOfE[i];
      arrayOfE[i] = null;
      this.c = i;
      return e;
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void removeFromEnd(int paramInt) {
    if (paramInt <= 0)
      return; 
    if (paramInt <= size()) {
      int i = 0;
      int j = this.c;
      if (paramInt < j)
        i = j - paramInt; 
      j = i;
      while (true) {
        int k = this.c;
        if (j < k) {
          this.a[j] = null;
          j++;
          continue;
        } 
        i = k - i;
        paramInt -= i;
        this.c = k - i;
        if (paramInt > 0) {
          this.c = this.a.length;
          i = this.c - paramInt;
          for (paramInt = i; paramInt < this.c; paramInt++)
            this.a[paramInt] = null; 
          this.c = i;
        } 
        return;
      } 
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void removeFromStart(int paramInt) {
    if (paramInt <= 0)
      return; 
    if (paramInt <= size()) {
      int j = this.a.length;
      int k = this.b;
      int i = j;
      if (paramInt < j - k)
        i = k + paramInt; 
      for (j = this.b; j < i; j++)
        this.a[j] = null; 
      j = this.b;
      k = i - j;
      i = paramInt - k;
      this.b = this.d & j + k;
      if (i > 0) {
        for (paramInt = 0; paramInt < i; paramInt++)
          this.a[paramInt] = null; 
        this.b = i;
      } 
      return;
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int size() {
    return this.c - this.b & this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\collection\CircularArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */