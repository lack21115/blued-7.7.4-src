package com.amap.api.mapcore2d;

public class w {
  private long a = Long.MIN_VALUE;
  
  private long b = Long.MIN_VALUE;
  
  private double c = Double.MIN_VALUE;
  
  private double d = Double.MIN_VALUE;
  
  public w() {
    this.a = 0L;
    this.b = 0L;
  }
  
  private w(double paramDouble1, double paramDouble2, long paramLong1, long paramLong2) {
    this.c = paramDouble1;
    this.d = paramDouble2;
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  w(double paramDouble1, double paramDouble2, boolean paramBoolean) {
    if (paramBoolean == true) {
      this.a = (long)(paramDouble1 * 1000000.0D);
      this.b = (long)(paramDouble2 * 1000000.0D);
      return;
    } 
    this.c = paramDouble1;
    this.d = paramDouble2;
  }
  
  public w(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a() {
    return (int)this.b;
  }
  
  public void a(double paramDouble) {
    this.d = paramDouble;
  }
  
  public int b() {
    return (int)this.a;
  }
  
  public void b(double paramDouble) {
    this.c = paramDouble;
  }
  
  public long c() {
    return this.b;
  }
  
  public long d() {
    return this.a;
  }
  
  public double e() {
    if (Double.doubleToLongBits(this.d) == Double.doubleToLongBits(Double.MIN_VALUE))
      this.d = r.a(this.b) * 2.003750834E7D / 180.0D; 
    return this.d;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return (this.a != ((w)paramObject).a) ? false : ((this.b != ((w)paramObject).b) ? false : ((Double.doubleToLongBits(this.c) != Double.doubleToLongBits(((w)paramObject).c)) ? false : (!(Double.doubleToLongBits(this.d) != Double.doubleToLongBits(((w)paramObject).d)))));
  }
  
  public double f() {
    if (Double.doubleToLongBits(this.c) == Double.doubleToLongBits(Double.MIN_VALUE))
      this.c = Math.log(Math.tan((r.a(this.a) + 90.0D) * Math.PI / 360.0D)) / 0.017453292519943295D * 2.003750834E7D / 180.0D; 
    return this.c;
  }
  
  public w g() {
    return new w(this.c, this.d, this.a, this.b);
  }
  
  public int hashCode() {
    long l = this.a;
    int i = (int)(l ^ l >>> 32L);
    l = this.b;
    int j = (int)(l ^ l >>> 32L);
    l = Double.doubleToLongBits(this.c);
    int k = (int)(l ^ l >>> 32L);
    l = Double.doubleToLongBits(this.d);
    return (((i + 31) * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */