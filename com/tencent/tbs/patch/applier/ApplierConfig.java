package com.tencent.tbs.patch.applier;

import java.io.File;

public final class ApplierConfig extends BasicApplierConfig {
  private boolean d = false;
  
  private boolean e = false;
  
  private String f;
  
  private ApplierConfig() {}
  
  public String getTempDir() {
    String str2 = (new File(System.getProperty("java.io.tmpdir"), ".x5patch")).getAbsolutePath();
    String str3 = this.f;
    String str1 = str2;
    if (str3 != null) {
      if ("".equals(str3))
        return str2; 
      File file = new File(this.f);
      if (file.exists())
        return this.f; 
      str1 = str2;
      if (file.mkdirs())
        str1 = this.f; 
    } 
    return str1;
  }
  
  public boolean isRestoreOutputDir() {
    return this.e;
  }
  
  public boolean isSourceInputDir() {
    return this.d;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{, sourceInput='");
    stringBuilder.append(this.a);
    stringBuilder.append('\'');
    stringBuilder.append(", patchInput='");
    stringBuilder.append(this.b);
    stringBuilder.append('\'');
    stringBuilder.append(", restoreOutput='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append(", isRestoreOutputDir=");
    stringBuilder.append(this.d);
    stringBuilder.append(", isNewOutputDir=");
    stringBuilder.append(this.e);
    stringBuilder.append(", mTempDir='");
    stringBuilder.append(this.f);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public static final class Builder {
    ApplierConfig a = new ApplierConfig();
    
    public ApplierConfig create() {
      return this.a;
    }
    
    public Builder patchInput(String param1String) {
      this.a.b = param1String;
      return this;
    }
    
    public Builder restoreOutput(String param1String) {
      return restoreOutput(param1String, false);
    }
    
    public Builder restoreOutput(String param1String, boolean param1Boolean) {
      ApplierConfig applierConfig = this.a;
      applierConfig.c = param1String;
      ApplierConfig.b(applierConfig, param1Boolean);
      return this;
    }
    
    public Builder sourceInput(String param1String) {
      return sourceInput(param1String, false);
    }
    
    public Builder sourceInput(String param1String, boolean param1Boolean) {
      ApplierConfig applierConfig = this.a;
      applierConfig.a = param1String;
      ApplierConfig.a(applierConfig, param1Boolean);
      return this;
    }
    
    public Builder tempDir(String param1String) {
      ApplierConfig.a(this.a, param1String);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\ApplierConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */