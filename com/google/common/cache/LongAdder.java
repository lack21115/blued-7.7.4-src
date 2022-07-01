package com.google.common.cache;

import java.io.Serializable;

final class LongAdder extends Striped64 implements LongAddable, Serializable {
  final long a(long paramLong1, long paramLong2) {
    return paramLong1 + paramLong2;
  }
  
  public void a() {
    a(1L);
  }
  
  public void a(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: getfield d : [Lcom/google/common/cache/Striped64$Cell;
    //   4: astore #9
    //   6: aload #9
    //   8: ifnonnull -> 30
    //   11: aload_0
    //   12: getfield e : J
    //   15: lstore #4
    //   17: aload_0
    //   18: lload #4
    //   20: lload #4
    //   22: lload_1
    //   23: ladd
    //   24: invokevirtual b : (JJ)Z
    //   27: ifne -> 131
    //   30: getstatic com/google/common/cache/LongAdder.a : Ljava/lang/ThreadLocal;
    //   33: invokevirtual get : ()Ljava/lang/Object;
    //   36: checkcast [I
    //   39: astore #8
    //   41: iconst_1
    //   42: istore #7
    //   44: iload #7
    //   46: istore #6
    //   48: aload #8
    //   50: ifnull -> 122
    //   53: iload #7
    //   55: istore #6
    //   57: aload #9
    //   59: ifnull -> 122
    //   62: aload #9
    //   64: arraylength
    //   65: istore_3
    //   66: iload #7
    //   68: istore #6
    //   70: iload_3
    //   71: iconst_1
    //   72: if_icmplt -> 122
    //   75: aload #9
    //   77: iload_3
    //   78: iconst_1
    //   79: isub
    //   80: aload #8
    //   82: iconst_0
    //   83: iaload
    //   84: iand
    //   85: aaload
    //   86: astore #9
    //   88: iload #7
    //   90: istore #6
    //   92: aload #9
    //   94: ifnull -> 122
    //   97: aload #9
    //   99: getfield a : J
    //   102: lstore #4
    //   104: aload #9
    //   106: lload #4
    //   108: lload #4
    //   110: lload_1
    //   111: ladd
    //   112: invokevirtual a : (JJ)Z
    //   115: istore #6
    //   117: iload #6
    //   119: ifne -> 131
    //   122: aload_0
    //   123: lload_1
    //   124: aload #8
    //   126: iload #6
    //   128: invokevirtual a : (J[IZ)V
    //   131: return
  }
  
  public long b() {
    long l1 = this.e;
    Striped64.Cell[] arrayOfCell = this.d;
    long l2 = l1;
    if (arrayOfCell != null) {
      int j = arrayOfCell.length;
      int i = 0;
      while (true) {
        l2 = l1;
        if (i < j) {
          Striped64.Cell cell = arrayOfCell[i];
          l2 = l1;
          if (cell != null)
            l2 = l1 + cell.a; 
          i++;
          l1 = l2;
          continue;
        } 
        break;
      } 
    } 
    return l2;
  }
  
  public double doubleValue() {
    return b();
  }
  
  public float floatValue() {
    return (float)b();
  }
  
  public int intValue() {
    return (int)b();
  }
  
  public long longValue() {
    return b();
  }
  
  public String toString() {
    return Long.toString(b());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\cache\LongAdder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */