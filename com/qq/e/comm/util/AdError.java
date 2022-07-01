package com.qq.e.comm.util;

public class AdError {
  private int a;
  
  private String b;
  
  public AdError() {}
  
  public AdError(int paramInt, String paramString) {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public int getErrorCode() {
    return this.a;
  }
  
  public String getErrorMsg() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\com\\util\AdError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */