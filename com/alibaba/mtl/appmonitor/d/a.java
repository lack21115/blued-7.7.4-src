package com.alibaba.mtl.appmonitor.d;

import org.json.JSONObject;

public abstract class a<T extends JSONObject> {
  protected int n;
  
  public a(int paramInt) {
    this.n = paramInt;
  }
  
  protected void a(T paramT) {
    try {
      Integer integer = Integer.valueOf(paramT.getInt("sampling"));
      if (integer != null)
        this.n = integer.intValue(); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  protected boolean a(int paramInt) {
    return (paramInt < this.n);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */