package com.huawei.hms.api;

import java.util.List;

public class ProtocolNegotiate {
  private static ProtocolNegotiate a = new ProtocolNegotiate();
  
  private int b = 1;
  
  public static ProtocolNegotiate getInstance() {
    return a;
  }
  
  public int getVersion() {
    return this.b;
  }
  
  public int negotiate(List<Integer> paramList) {
    if (paramList == null || paramList.isEmpty()) {
      this.b = 1;
      return this.b;
    } 
    if (!paramList.contains(Integer.valueOf(2))) {
      this.b = ((Integer)paramList.get(paramList.size() - 1)).intValue();
    } else {
      this.b = 2;
    } 
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\ProtocolNegotiate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */