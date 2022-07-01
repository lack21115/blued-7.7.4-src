package com.google.common.primitives;

import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
  public static final UnsignedInteger a = a(0);
  
  public static final UnsignedInteger b = a(1);
  
  public static final UnsignedInteger c = a(-1);
  
  private final int d;
  
  private UnsignedInteger(int paramInt) {
    this.d = paramInt & 0xFFFFFFFF;
  }
  
  public static UnsignedInteger a(int paramInt) {
    return new UnsignedInteger(paramInt);
  }
  
  public int a(UnsignedInteger paramUnsignedInteger) {
    Preconditions.a(paramUnsignedInteger);
    return UnsignedInts.a(this.d, paramUnsignedInteger.d);
  }
  
  public String b(int paramInt) {
    return UnsignedInts.b(this.d, paramInt);
  }
  
  public double doubleValue() {
    return longValue();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof UnsignedInteger;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.d == ((UnsignedInteger)paramObject).d)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public float floatValue() {
    return (float)longValue();
  }
  
  public int hashCode() {
    return this.d;
  }
  
  public int intValue() {
    return this.d;
  }
  
  public long longValue() {
    return UnsignedInts.b(this.d);
  }
  
  public String toString() {
    return b(10);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\UnsignedInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */