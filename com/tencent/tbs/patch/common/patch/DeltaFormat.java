package com.tencent.tbs.patch.common.patch;

import com.tencent.tbs.patch.common.util.FileFormat;

public enum DeltaFormat {
  BIN,
  DEX,
  ELF32(101),
  PACKAGE(103);
  
  public int code;
  
  static {
    DEX = new DeltaFormat("DEX", 2, 105);
    BIN = new DeltaFormat("BIN", 3, 106);
    a = new DeltaFormat[] { ELF32, PACKAGE, DEX, BIN };
    throw new VerifyError("bad dex opcode");
  }
  
  DeltaFormat(int paramInt1) {
    this.code = paramInt1;
  }
  
  public static DeltaFormat codeOf(int paramInt) {
    for (DeltaFormat deltaFormat : values()) {
      if (deltaFormat.code == paramInt)
        return deltaFormat; 
    } 
    return BIN;
  }
  
  public static boolean isPackageType(String paramString) {
    return (paramString.endsWith(".jar") || paramString.endsWith(".apk") || paramString.endsWith(".zip"));
  }
  
  public static DeltaFormat typeOf(String paramString) {
    return paramString.endsWith(".so") ? (FileFormat.isElf32(paramString) ? ELF32 : BIN) : (paramString.endsWith(".dex") ? DEX : (isPackageType(paramString) ? PACKAGE : BIN));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\patch\DeltaFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */