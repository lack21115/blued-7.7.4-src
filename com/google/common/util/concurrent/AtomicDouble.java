package com.google.common.util.concurrent;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicDouble extends Number implements Serializable {
  private transient AtomicLong a;
  
  public AtomicDouble() {
    this(0.0D);
  }
  
  public AtomicDouble(double paramDouble) {
    this.a = new AtomicLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  public final double a() {
    return Double.longBitsToDouble(this.a.get());
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
    return (long)a();
  }
  
  public String toString() {
    return Double.toString(a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\AtomicDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */