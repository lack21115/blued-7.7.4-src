package com.huawei.hms.push.ups.entity;

public class TokenResult extends CodeResult {
  public String c;
  
  public TokenResult() {}
  
  public TokenResult(int paramInt) {
    super(paramInt);
  }
  
  public TokenResult(int paramInt, String paramString) {
    super(paramInt, paramString);
  }
  
  public TokenResult(String paramString) {
    this.c = paramString;
  }
  
  public String getToken() {
    return this.c;
  }
  
  public void setToken(String paramString) {
    this.c = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\pus\\ups\entity\TokenResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */