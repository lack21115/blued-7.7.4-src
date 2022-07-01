package com.tencent.tbs.patch.common.patch;

public enum PatchStatus {
  ADDED,
  DELETED,
  INCOMPATIBLE,
  MODIFIED,
  REPLACED,
  UNCHANGED(0);
  
  public int code;
  
  static {
    ADDED = new PatchStatus("ADDED", 1, 1);
    DELETED = new PatchStatus("DELETED", 2, 2);
    MODIFIED = new PatchStatus("MODIFIED", 3, 3);
    REPLACED = new PatchStatus("REPLACED", 4, 4);
    INCOMPATIBLE = new PatchStatus("INCOMPATIBLE", 5, 5);
    a = new PatchStatus[] { UNCHANGED, ADDED, DELETED, MODIFIED, REPLACED, INCOMPATIBLE };
    throw new VerifyError("bad dex opcode");
  }
  
  PatchStatus(int paramInt1) {
    this.code = paramInt1;
  }
  
  public static PatchStatus of(int paramInt) {
    for (PatchStatus patchStatus : values()) {
      if (patchStatus.code == paramInt)
        return patchStatus; 
    } 
    return UNCHANGED;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\patch\PatchStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */