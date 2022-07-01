package com.google.common.hash;

import java.io.Serializable;

final class LongAdder extends Striped64 implements LongAddable, Serializable {
  public long a() {
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
    return a();
  }
  
  public float floatValue() {
    return (float)a();
  }
  
  public int intValue() {
    return (int)a();
  }
  
  public long longValue() {
    return a();
  }
  
  public String toString() {
    return Long.toString(a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\hash\LongAdder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */