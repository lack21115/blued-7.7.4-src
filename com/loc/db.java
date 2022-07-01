package com.loc;

public class db {
  public String a;
  
  public long b = 0L;
  
  public long c = 0L;
  
  public double d = 0.0D;
  
  public double e = 0.0D;
  
  public double f = 0.0D;
  
  public float g = 0.0F;
  
  public float h = 0.0F;
  
  public float i = 0.0F;
  
  public boolean j = false;
  
  public db(String paramString) {
    this.a = paramString;
  }
  
  public final double a(db paramdb) {
    if (paramdb != null) {
      double d4 = this.e;
      double d1 = this.d;
      double d5 = paramdb.e;
      double d2 = paramdb.d;
      double d3 = (90.0D - d1) * 21412.0D / 90.0D + 6356725.0D;
      d4 = (d5 * 0.01745329238474369D - d4 * 0.01745329238474369D) * Math.cos(3.1415927410125732D * d1 / 180.0D) * d3;
      d1 = (d2 * 0.01745329238474369D - d1 * 0.01745329238474369D) * d3;
      return Math.pow(d4 * d4 + d1 * d1, 0.5D);
    } 
    return 0.0D;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */