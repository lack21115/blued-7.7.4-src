package com.loc;

public final class da extends cw {
  public int j = 0;
  
  public int k = 0;
  
  public int l = Integer.MAX_VALUE;
  
  public int m = Integer.MAX_VALUE;
  
  public da(boolean paramBoolean1, boolean paramBoolean2) {
    super(paramBoolean1, paramBoolean2);
  }
  
  public final cw a() {
    da da1 = new da(this.h, this.i);
    da1.a(this);
    da1.j = this.j;
    da1.k = this.k;
    da1.l = this.l;
    da1.m = this.m;
    return da1;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("AmapCellWcdma{lac=");
    stringBuilder.append(this.j);
    stringBuilder.append(", cid=");
    stringBuilder.append(this.k);
    stringBuilder.append(", psc=");
    stringBuilder.append(this.l);
    stringBuilder.append(", uarfcn=");
    stringBuilder.append(this.m);
    stringBuilder.append('}');
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */