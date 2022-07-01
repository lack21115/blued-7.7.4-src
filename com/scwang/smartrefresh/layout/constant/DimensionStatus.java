package com.scwang.smartrefresh.layout.constant;

public enum DimensionStatus {
  a(false),
  b(true),
  c(false),
  d(true),
  e(false),
  f(true),
  g(false),
  h(true),
  i(false),
  j(true),
  k(false),
  l(true);
  
  public final boolean m;
  
  DimensionStatus(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public DimensionStatus a() {
    if (this.m) {
      DimensionStatus dimensionStatus = values()[ordinal() - 1];
      return !dimensionStatus.m ? dimensionStatus : a;
    } 
    return this;
  }
  
  public boolean a(DimensionStatus paramDimensionStatus) {
    return (ordinal() < paramDimensionStatus.ordinal() || ((!this.m || j == this) && ordinal() == paramDimensionStatus.ordinal()));
  }
  
  public DimensionStatus b() {
    return !this.m ? values()[ordinal() + 1] : this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\constant\DimensionStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */