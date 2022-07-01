package com.qq.e.comm.managers.status;

public enum Carrier {
  CMCC,
  TELECOM,
  UNICOM,
  UNKNOWN(0);
  
  private int a;
  
  static {
    CMCC = new Carrier("CMCC", 1, 1);
    UNICOM = new Carrier("UNICOM", 2, 2);
    TELECOM = new Carrier("TELECOM", 3, 3);
    b = new Carrier[] { UNKNOWN, CMCC, UNICOM, TELECOM };
  }
  
  Carrier(int paramInt1) {
    this.a = paramInt1;
  }
  
  public final int getValue() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\status\Carrier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */