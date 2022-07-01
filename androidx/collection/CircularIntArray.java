package androidx.collection;

public final class CircularIntArray {
  private int[] a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  public CircularIntArray() {
    this(8);
  }
  
  public CircularIntArray(int paramInt) {
    if (paramInt >= 1) {
      if (paramInt <= 1073741824) {
        int i = paramInt;
        if (Integer.bitCount(paramInt) != 1)
          i = Integer.highestOneBit(paramInt - 1) << 1; 
        this.d = i - 1;
        this.a = new int[i];
        return;
      } 
      throw new IllegalArgumentException("capacity must be <= 2^30");
    } 
    throw new IllegalArgumentException("capacity must be >= 1");
  }
  
  private void a() {
    int[] arrayOfInt = this.a;
    int i = arrayOfInt.length;
    int j = this.b;
    int k = i - j;
    int m = i << 1;
    if (m >= 0) {
      int[] arrayOfInt1 = new int[m];
      System.arraycopy(arrayOfInt, j, arrayOfInt1, 0, k);
      System.arraycopy(this.a, 0, arrayOfInt1, k, this.b);
      this.a = arrayOfInt1;
      this.b = 0;
      this.c = i;
      this.d = m - 1;
      return;
    } 
    throw new RuntimeException("Max array capacity exceeded");
  }
  
  public void addFirst(int paramInt) {
    this.b = this.b - 1 & this.d;
    int[] arrayOfInt = this.a;
    int i = this.b;
    arrayOfInt[i] = paramInt;
    if (i == this.c)
      a(); 
  }
  
  public void addLast(int paramInt) {
    int[] arrayOfInt = this.a;
    int i = this.c;
    arrayOfInt[i] = paramInt;
    this.c = this.d & i + 1;
    if (this.c == this.b)
      a(); 
  }
  
  public void clear() {
    this.c = this.b;
  }
  
  public int get(int paramInt) {
    if (paramInt >= 0 && paramInt < size()) {
      int[] arrayOfInt = this.a;
      int i = this.b;
      return arrayOfInt[this.d & i + paramInt];
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int getFirst() {
    int i = this.b;
    if (i != this.c)
      return this.a[i]; 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int getLast() {
    int i = this.b;
    int j = this.c;
    if (i != j)
      return this.a[j - 1 & this.d]; 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public boolean isEmpty() {
    return (this.b == this.c);
  }
  
  public int popFirst() {
    int i = this.b;
    if (i != this.c) {
      int j = this.a[i];
      this.b = i + 1 & this.d;
      return j;
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int popLast() {
    int i = this.b;
    int j = this.c;
    if (i != j) {
      i = this.d & j - 1;
      j = this.a[i];
      this.c = i;
      return j;
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void removeFromEnd(int paramInt) {
    if (paramInt <= 0)
      return; 
    if (paramInt <= size()) {
      int i = this.c;
      this.c = this.d & i - paramInt;
      return;
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public void removeFromStart(int paramInt) {
    if (paramInt <= 0)
      return; 
    if (paramInt <= size()) {
      int i = this.b;
      this.b = this.d & i + paramInt;
      return;
    } 
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public int size() {
    return this.c - this.b & this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\collection\CircularIntArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */