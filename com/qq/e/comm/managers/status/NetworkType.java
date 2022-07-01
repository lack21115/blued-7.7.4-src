package com.qq.e.comm.managers.status;

public enum NetworkType {
  NET_2G,
  NET_3G,
  NET_4G,
  UNKNOWN(0, 1, "unknown"),
  WIFI(1, 2, "wifi");
  
  private int a;
  
  private int b;
  
  private String c;
  
  static {
    NET_2G = new NetworkType("NET_2G", 2, 2, 4, "2g");
    NET_3G = new NetworkType("NET_3G", 3, 3, 8, "3g");
    NET_4G = new NetworkType("NET_4G", 4, 4, 16, "4g");
    d = new NetworkType[] { UNKNOWN, WIFI, NET_2G, NET_3G, NET_4G };
  }
  
  NetworkType(int paramInt1, int paramInt2, String paramString1) {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramString1;
  }
  
  public final int getConnValue() {
    return this.a;
  }
  
  public final String getNameValue() {
    return this.c;
  }
  
  public final int getPermValue() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\status\NetworkType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */