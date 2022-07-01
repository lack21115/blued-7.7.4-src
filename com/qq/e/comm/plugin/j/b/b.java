package com.qq.e.comm.plugin.j.b;

class b implements l {
  public l.a[] a(long paramLong, int paramInt) {
    long l1 = paramLong / paramInt;
    l.a[] arrayOfA = new l.a[paramInt];
    int i = 0;
    while (true) {
      int j = paramInt - 1;
      if (i < j) {
        arrayOfA[i] = new l.a(i * l1, l1);
        i++;
        continue;
      } 
      l1 = j * l1;
      arrayOfA[j] = new l.a(l1, paramLong - l1);
      return arrayOfA;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\j\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */