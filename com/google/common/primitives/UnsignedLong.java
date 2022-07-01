package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class UnsignedLong extends Number implements Serializable, Comparable<UnsignedLong> {
  public static final UnsignedLong a = new UnsignedLong(0L);
  
  public static final UnsignedLong b = new UnsignedLong(1L);
  
  public static final UnsignedLong c = new UnsignedLong(-1L);
  
  private final long d;
  
  private UnsignedLong(long paramLong) {
    this.d = paramLong;
  }
  
  public int a(UnsignedLong paramUnsignedLong) {
    Preconditions.a(paramUnsignedLong);
    return UnsignedLongs.a(this.d, paramUnsignedLong.d);
  }
  
  public double doubleValue() {
    long l = this.d;
    double d2 = (Long.MAX_VALUE & l);
    double d1 = d2;
    if (l < 0L)
      d1 = d2 + 9.223372036854776E18D; 
    return d1;
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool = paramObject instanceof UnsignedLong;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.d == ((UnsignedLong)paramObject).d)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public float floatValue() {
    long l = this.d;
    float f2 = (float)(Long.MAX_VALUE & l);
    float f1 = f2;
    if (l < 0L)
      f1 = f2 + 9.223372E18F; 
    return f1;
  }
  
  public int hashCode() {
    return Longs.a(this.d);
  }
  
  public int intValue() {
    return (int)this.d;
  }
  
  public long longValue() {
    return this.d;
  }
  
  public String toString() {
    return UnsignedLongs.a(this.d);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\UnsignedLong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */