package com.google.common.math;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class PairedStats implements Serializable {
  private final Stats a;
  
  private final Stats b;
  
  private final double c;
  
  public long a() {
    return this.a.a();
  }
  
  public double b() {
    boolean bool;
    if (a() != 0L) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.b(bool);
    return this.c / a();
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    boolean bool2 = false;
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    boolean bool1 = bool2;
    if (this.a.equals(((PairedStats)paramObject).a)) {
      bool1 = bool2;
      if (this.b.equals(((PairedStats)paramObject).b)) {
        bool1 = bool2;
        if (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(((PairedStats)paramObject).c))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return Objects.a(new Object[] { this.a, this.b, Double.valueOf(this.c) });
  }
  
  public String toString() {
    return (a() > 0L) ? MoreObjects.a(this).a("xStats", this.a).a("yStats", this.b).a("populationCovariance", b()).toString() : MoreObjects.a(this).a("xStats", this.a).a("yStats", this.b).toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\math\PairedStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */