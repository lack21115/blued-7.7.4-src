package com.tencent.tbs.patch.applier;

import com.tencent.tbs.patch.common.PatchException;
import com.tencent.tbs.patch.common.util.FileFormat;

public final class ELF32Applier extends a<BasicApplierConfig> {
  public ELF32Applier(BasicApplierConfig paramBasicApplierConfig) {
    super(paramBasicApplierConfig);
  }
  
  private native int applyELF32Patch(String paramString1, String paramString2, String paramString3);
  
  public void doApply() {
    boolean bool;
    if (FileFormat.isElf32(this.a.getSourceInput())) {
      bool = applyELF32Patch(this.a.getSourceInput(), this.a.getPatchInput(), this.a.getRestoreOutput());
    } else {
      bool = false;
    } 
    if (!bool)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Input old: ");
    stringBuilder.append(this.a.getSourceInput());
    stringBuilder.append("\n");
    stringBuilder.append("Input patch: ");
    stringBuilder.append(this.a.getPatchInput());
    stringBuilder.append("\n");
    stringBuilder.append("Apply Elf 32 patch failed, return code: ");
    stringBuilder.append(bool);
    throw new PatchException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\applier\ELF32Applier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */