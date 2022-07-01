package com.google.common.util.concurrent;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicDoubleArray implements Serializable {
  private transient AtomicLongArray a;
  
  public final int a() {
    return this.a.length();
  }
  
  public String toString() {
    int j = a() - 1;
    if (j == -1)
      return "[]"; 
    StringBuilder stringBuilder = new StringBuilder((j + 1) * 19);
    stringBuilder.append('[');
    for (int i = 0;; i++) {
      stringBuilder.append(Double.longBitsToDouble(this.a.get(i)));
      if (i == j) {
        stringBuilder.append(']');
        return stringBuilder.toString();
      } 
      stringBuilder.append(',');
      stringBuilder.append(' ');
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AtomicDoubleArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */