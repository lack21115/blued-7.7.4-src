package com.tencent.tbs.patch.applier;

public class BasicApplierConfig {
  protected String a;
  
  protected String b;
  
  protected String c;
  
  protected BasicApplierConfig() {}
  
  public BasicApplierConfig(String paramString1, String paramString2, String paramString3) {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String getPatchInput() {
    return this.b;
  }
  
  public String getRestoreOutput() {
    return this.c;
  }
  
  public String getSourceInput() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\BasicApplierConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */