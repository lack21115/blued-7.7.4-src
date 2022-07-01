package com.loc;

public final class cz extends cw {
  public int j = 0;
  
  public int k = 0;
  
  public int l = Integer.MAX_VALUE;
  
  public int m = Integer.MAX_VALUE;
  
  public int n = Integer.MAX_VALUE;
  
  public cz(boolean paramBoolean) {
    super(paramBoolean, true);
  }
  
  public final cw a() {
    cz cz1 = new cz(this.h);
    cz1.a(this);
    cz1.j = this.j;
    cz1.k = this.k;
    cz1.l = this.l;
    cz1.m = this.m;
    cz1.n = this.n;
    return cz1;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("AmapCellLte{lac=");
    stringBuilder.append(this.j);
    stringBuilder.append(", cid=");
    stringBuilder.append(this.k);
    stringBuilder.append(", pci=");
    stringBuilder.append(this.l);
    stringBuilder.append(", earfcn=");
    stringBuilder.append(this.m);
    stringBuilder.append(", timingAdvance=");
    stringBuilder.append(this.n);
    stringBuilder.append('}');
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */