package com.huawei.hms.push.ups.entity;

public class CodeResult {
  public int a;
  
  public String b;
  
  public CodeResult() {}
  
  public CodeResult(int paramInt) {
    this.a = paramInt;
  }
  
  public CodeResult(int paramInt, String paramString) {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public String getReason() {
    return this.b;
  }
  
  public int getReturnCode() {
    return this.a;
  }
  
  public void setReason(String paramString) {
    this.b = paramString;
  }
  
  public void setReturnCode(int paramInt) {
    this.a = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\pus\\ups\entity\CodeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */