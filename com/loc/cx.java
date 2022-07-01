package com.loc;

public final class cx extends cw {
  public int j = 0;
  
  public int k = 0;
  
  public int l = 0;
  
  public int m;
  
  public int n;
  
  public cx(boolean paramBoolean1, boolean paramBoolean2) {
    super(paramBoolean1, paramBoolean2);
  }
  
  public final cw a() {
    cx cx1 = new cx(this.h, this.i);
    cx1.a(this);
    this.j = cx1.j;
    this.k = cx1.k;
    this.l = cx1.l;
    this.m = cx1.m;
    this.n = cx1.n;
    return cx1;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("AmapCellCdma{sid=");
    stringBuilder.append(this.j);
    stringBuilder.append(", nid=");
    stringBuilder.append(this.k);
    stringBuilder.append(", bid=");
    stringBuilder.append(this.l);
    stringBuilder.append(", latitude=");
    stringBuilder.append(this.m);
    stringBuilder.append(", longitude=");
    stringBuilder.append(this.n);
    stringBuilder.append('}');
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */