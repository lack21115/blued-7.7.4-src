package com.amap.api.mapcore2d;

import android.graphics.PointF;

class bs implements Cloneable {
  public int a = 0;
  
  public final int b;
  
  public final int c;
  
  public final int d;
  
  public final int e;
  
  public final boolean f;
  
  public PointF g;
  
  public int h = -1;
  
  public boolean i = false;
  
  private String j;
  
  public bs(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = cl.a(this.b, this.c, this.d) ^ true;
    b();
  }
  
  public bs(bs parambs) {
    this.b = parambs.b;
    this.c = parambs.c;
    this.d = parambs.d;
    this.e = parambs.e;
    this.g = parambs.g;
    this.a = parambs.a;
    this.f = cl.a(this.b, this.c, this.d) ^ true;
    b();
  }
  
  public bs a() {
    return new bs(this);
  }
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("-");
    stringBuilder.append(this.c);
    stringBuilder.append("-");
    stringBuilder.append(this.d);
    if (this.f && q.i == 1) {
      stringBuilder.append("-");
      stringBuilder.append(1);
    } 
    this.j = stringBuilder.toString();
  }
  
  public String c() {
    return this.j;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof bs))
      return false; 
    paramObject = paramObject;
    return (this.b == ((bs)paramObject).b && this.c == ((bs)paramObject).c && this.d == ((bs)paramObject).d && this.e == ((bs)paramObject).e);
  }
  
  public int hashCode() {
    return this.b * 7 + this.c * 11 + this.d * 13 + this.e;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("-");
    stringBuilder.append(this.c);
    stringBuilder.append("-");
    stringBuilder.append(this.d);
    stringBuilder.append("-");
    stringBuilder.append(this.e);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */