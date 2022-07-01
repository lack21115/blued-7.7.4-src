package com.amap.api.mapcore2d;

import java.util.Locale;

public final class gm {
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
  
  public gm(int paramInt, boolean paramBoolean) {
    this.k = paramInt;
    this.n = paramBoolean;
  }
  
  public final int a() {
    return this.c;
  }
  
  public final int b() {
    return this.d;
  }
  
  public final int c() {
    return this.h;
  }
  
  public final int d() {
    return this.i;
  }
  
  public final int e() {
    return this.j;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (paramObject instanceof gm) {
      paramObject = paramObject;
      int i = ((gm)paramObject).k;
      if (i != 1)
        return (i != 2) ? ((i != 3) ? ((i != 4) ? false : ((this.k != 4) ? false : ((((gm)paramObject).c == this.c && ((gm)paramObject).d == this.d && ((gm)paramObject).b == this.b)))) : ((this.k != 3) ? false : ((((gm)paramObject).c == this.c && ((gm)paramObject).d == this.d && ((gm)paramObject).b == this.b)))) : ((this.k != 2) ? false : ((((gm)paramObject).i == this.i && ((gm)paramObject).h == this.h && ((gm)paramObject).g == this.g))); 
      if (this.k != 1)
        return false; 
      if (((gm)paramObject).c == this.c && ((gm)paramObject).d == this.d && ((gm)paramObject).b == this.b)
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */