package com.loc;

public final class cy extends cw {
  public int j = 0;
  
  public int k = 0;
  
  public int l = Integer.MAX_VALUE;
  
  public int m = Integer.MAX_VALUE;
  
  public int n = Integer.MAX_VALUE;
  
  public int o = Integer.MAX_VALUE;
  
  public cy(boolean paramBoolean1, boolean paramBoolean2) {
    super(paramBoolean1, paramBoolean2);
  }
  
  public final cw a() {
    cy cy1 = new cy(this.h, this.i);
    cy1.a(this);
    cy1.j = this.j;
    cy1.k = this.k;
    cy1.l = this.l;
    cy1.m = this.m;
    cy1.n = this.n;
    cy1.o = this.o;
    return cy1;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("AmapCellGsm{lac=");
    stringBuilder.append(this.j);
    stringBuilder.append(", cid=");
    stringBuilder.append(this.k);
    stringBuilder.append(", psc=");
    stringBuilder.append(this.l);
    stringBuilder.append(", arfcn=");
    stringBuilder.append(this.m);
    stringBuilder.append(", bsic=");
    stringBuilder.append(this.n);
    stringBuilder.append(", timingAdvance=");
    stringBuilder.append(this.o);
    stringBuilder.append('}');
    stringBuilder.append(super.toString());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */