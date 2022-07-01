package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class ImmutableDoubleArray implements Serializable {
  private static final ImmutableDoubleArray a = new ImmutableDoubleArray(new double[0]);
  
  private final double[] b;
  
  private final transient int c;
  
  private final int d;
  
  private ImmutableDoubleArray(double[] paramArrayOfdouble) {
    this(paramArrayOfdouble, 0, paramArrayOfdouble.length);
  }
  
  private ImmutableDoubleArray(double[] paramArrayOfdouble, int paramInt1, int paramInt2) {
    this.b = paramArrayOfdouble;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  private static boolean b(double paramDouble1, double paramDouble2) {
    return (Double.doubleToLongBits(paramDouble1) == Double.doubleToLongBits(paramDouble2));
  }
  
  public double a(int paramInt) {
    Preconditions.a(paramInt, a());
    return this.b[this.c + paramInt];
  }
  
  public int a() {
    return this.d - this.c;
  }
  
  public int a(double paramDouble) {
    for (int i = this.c; i < this.d; i++) {
      if (b(this.b[i], paramDouble))
        return i - this.c; 
    } 
    return -1;
  }
  
  public ImmutableDoubleArray a(int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt2, a());
    if (paramInt1 == paramInt2)
      return a; 
    double[] arrayOfDouble = this.b;
    int i = this.c;
    return new ImmutableDoubleArray(arrayOfDouble, paramInt1 + i, i + paramInt2);
  }
  
  public int b(double paramDouble) {
    for (int i = this.d - 1; i >= this.c; i--) {
      if (b(this.b[i], paramDouble))
        return i - this.c; 
    } 
    return -1;
  }
  
  public boolean b() {
    return (this.d == this.c);
  }
  
  public List<Double> c() {
    return new AsList(this);
  }
  
  public boolean equals(@NullableDecl Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof ImmutableDoubleArray))
      return false; 
    paramObject = paramObject;
    if (a() != paramObject.a())
      return false; 
    for (int i = 0; i < a(); i++) {
      if (!b(a(i), paramObject.a(i)))
        return false; 
    } 
    return true;
  }
  
  public int hashCode() {
    int i = this.c;
    int j = 1;
    while (i < this.d) {
      j = j * 31 + Doubles.a(this.b[i]);
      i++;
    } 
    return j;
  }
  
  public String toString() {
    if (b())
      return "[]"; 
    StringBuilder stringBuilder = new StringBuilder(a() * 5);
    stringBuilder.append('[');
    stringBuilder.append(this.b[this.c]);
    int i = this.c;
    while (true) {
      if (++i < this.d) {
        stringBuilder.append(", ");
        stringBuilder.append(this.b[i]);
        continue;
      } 
      stringBuilder.append(']');
      return stringBuilder.toString();
    } 
  }
  
  static class AsList extends AbstractList<Double> implements Serializable, RandomAccess {
    private final ImmutableDoubleArray a;
    
    private AsList(ImmutableDoubleArray param1ImmutableDoubleArray) {
      this.a = param1ImmutableDoubleArray;
    }
    
    public Double a(int param1Int) {
      return Double.valueOf(this.a.a(param1Int));
    }
    
    public boolean contains(Object param1Object) {
      return (indexOf(param1Object) >= 0);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof AsList) {
        param1Object = param1Object;
        return this.a.equals(((AsList)param1Object).a);
      } 
      if (!(param1Object instanceof List))
        return false; 
      param1Object = param1Object;
      if (size() != param1Object.size())
        return false; 
      int i = ImmutableDoubleArray.b(this.a);
      param1Object = param1Object.iterator();
      while (param1Object.hasNext()) {
        Double double_ = (Double)param1Object.next();
        if (double_ instanceof Double) {
          if (!ImmutableDoubleArray.a(ImmutableDoubleArray.a(this.a)[i], ((Double)double_).doubleValue()))
            return false; 
          i++;
          continue;
        } 
        return false;
      } 
      return true;
    }
    
    public int hashCode() {
      return this.a.hashCode();
    }
    
    public int indexOf(Object param1Object) {
      return (param1Object instanceof Double) ? this.a.a(((Double)param1Object).doubleValue()) : -1;
    }
    
    public int lastIndexOf(Object param1Object) {
      return (param1Object instanceof Double) ? this.a.b(((Double)param1Object).doubleValue()) : -1;
    }
    
    public int size() {
      return this.a.a();
    }
    
    public List<Double> subList(int param1Int1, int param1Int2) {
      return this.a.a(param1Int1, param1Int2).c();
    }
    
    public String toString() {
      return this.a.toString();
    }
  }
  
  public static final class Builder {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\primitives\ImmutableDoubleArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */