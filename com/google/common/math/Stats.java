package com.google.common.math;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Stats implements Serializable {
  private final long a;
  
  private final double b;
  
  private final double c;
  
  private final double d;
  
  private final double e;
  
  public long a() {
    return this.a;
  }
  
  public double b() {
    boolean bool;
    if (this.a > 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool);
    return Double.isNaN(this.c) ? Double.NaN : ((this.a == 1L) ? 0.0D : (DoubleUtils.a(this.c) / a()));
  }
  
  public double c() {
    return Math.sqrt(b());
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool2 = false;
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    boolean bool1 = bool2;
    if (this.a == ((Stats)paramObject).a) {
      bool1 = bool2;
      if (Double.doubleToLongBits(this.b) == Double.doubleToLongBits(((Stats)paramObject).b)) {
        bool1 = bool2;
        if (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(((Stats)paramObject).c)) {
          bool1 = bool2;
          if (Double.doubleToLongBits(this.d) == Double.doubleToLongBits(((Stats)paramObject).d)) {
            bool1 = bool2;
            if (Double.doubleToLongBits(this.e) == Double.doubleToLongBits(((Stats)paramObject).e))
              bool1 = true; 
          } 
        } 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { Long.valueOf(this.a), Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.d), Double.valueOf(this.e) });
  }
  
  public String toString() {
    return (a() > 0L) ? MoreObjects.a(this).a("count", this.a).a("mean", this.b).a("populationStandardDeviation", c()).a("min", this.d).a("max", this.e).toString() : MoreObjects.a(this).a("count", this.a).toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\Stats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */