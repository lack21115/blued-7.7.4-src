package com.tencent.tbs.patch.common.patch;

public final class PatchResultExplainer {
  private final boolean a;
  
  private final String b;
  
  private final String c;
  
  public PatchResultExplainer(String paramString1, String paramString2) {
    this(paramString1, paramString2, false);
  }
  
  public PatchResultExplainer(String paramString1, String paramString2, boolean paramBoolean) {
    this.c = paramString1;
    this.b = paramString2;
    this.a = paramBoolean;
  }
  
  public String getPatchFilePath() {
    return this.b;
  }
  
  public String getPatchName() {
    return this.c;
  }
  
  public boolean isIncompatible() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\patch\PatchResultExplainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */