package com.tencent.tbs.patch.applier;

import com.tencent.tbs.patch.common.PatchException;

public final class BinaryApplier extends a<BasicApplierConfig> {
  public BinaryApplier(BasicApplierConfig paramBasicApplierConfig) {
    super(paramBasicApplierConfig);
  }
  
  private native int applyBinaryPatch(String paramString1, String paramString2, String paramString3);
  
  public void doApply() {
    int i = applyBinaryPatch(this.a.getSourceInput(), this.a.getPatchInput(), this.a.getRestoreOutput());
    if (i == 0)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Input old: ");
    stringBuilder.append(this.a.getSourceInput());
    stringBuilder.append("\n");
    stringBuilder.append("Input patch: ");
    stringBuilder.append(this.a.getPatchInput());
    stringBuilder.append("\n");
    stringBuilder.append("Generate bs patch failed, return code: ");
    stringBuilder.append(i);
    throw new PatchException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\BinaryApplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */