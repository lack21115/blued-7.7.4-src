package com.loc;

import java.util.Locale;

public final class dv {
  public int a = 0;
  
  public int b = 0;
  
  public int c = 0;
  
  public int d = 0;
  
  public int e = 0;
  
  public int f = 0;
  
  public int g = 0;
  
  public int h = 0;
  
  public int i = 0;
  
  public int j = -113;
  
  public int k = 0;
  
  public short l = 0;
  
  public long m = 0L;
  
  public boolean n = false;
  
  public int o = 32767;
  
  public boolean p = true;
  
  public dv(int paramInt, boolean paramBoolean) {
    this.k = paramInt;
    this.n = paramBoolean;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (paramObject instanceof dv) {
      paramObject = paramObject;
      int i = ((dv)paramObject).k;
      if (i != 1)
        return (i != 2) ? ((i != 3) ? ((i != 4) ? false : ((this.k != 4) ? false : ((((dv)paramObject).c == this.c && ((dv)paramObject).d == this.d && ((dv)paramObject).b == this.b)))) : ((this.k != 3) ? false : ((((dv)paramObject).c == this.c && ((dv)paramObject).d == this.d && ((dv)paramObject).b == this.b)))) : ((this.k != 2) ? false : ((((dv)paramObject).i == this.i && ((dv)paramObject).h == this.h && ((dv)paramObject).g == this.g))); 
      if (this.k != 1)
        return false; 
      if (((dv)paramObject).c == this.c && ((dv)paramObject).d == this.d && ((dv)paramObject).b == this.b)
        return true; 
    } 
    return false;
  }
  
  public final int hashCode() {
    int i;
    int j;
    int k = String.valueOf(this.k).hashCode();
    if (this.k == 2) {
      i = String.valueOf(this.i).hashCode() + String.valueOf(this.h).hashCode();
      j = this.g;
    } else {
      i = String.valueOf(this.c).hashCode() + String.valueOf(this.d).hashCode();
      j = this.b;
    } 
    return k + i + String.valueOf(j).hashCode();
  }
  
  public final String toString() {
    int i = this.k;
    return (i != 1) ? ((i != 2) ? ((i != 3) ? ((i != 4) ? "unknown" : String.format(Locale.CHINA, "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n), Integer.valueOf(this.o) })) : String.format(Locale.CHINA, "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b, pci=%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n), Integer.valueOf(this.o) })) : String.format(Locale.CHINA, "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.h), Integer.valueOf(this.g), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n) })) : String.format(Locale.CHINA, "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.p), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */