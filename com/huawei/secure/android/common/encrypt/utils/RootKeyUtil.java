package com.huawei.secure.android.common.encrypt.utils;

import android.os.Build;

public class RootKeyUtil {
  private static final String a = RootKeyUtil.class.getSimpleName();
  
  private byte[] b = null;
  
  public static RootKeyUtil a(String paramString1, String paramString2, String paramString3, String paramString4) {
    RootKeyUtil rootKeyUtil = new RootKeyUtil();
    rootKeyUtil.b(paramString1, paramString2, paramString3, paramString4);
    return rootKeyUtil;
  }
  
  public static RootKeyUtil a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte) {
    RootKeyUtil rootKeyUtil = new RootKeyUtil();
    rootKeyUtil.b(paramString1, paramString2, paramString3, paramArrayOfbyte);
    return rootKeyUtil;
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4) {
    b(paramString1, paramString2, paramString3, HexUtil.a(paramString4));
  }
  
  private void b(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfbyte) {
    if (Build.VERSION.SDK_INT < 26) {
      b.b(a, "initRootKey: sha1");
      this.b = BaseKeyUtil.a(paramString1, paramString2, paramString3, paramArrayOfbyte, false);
      return;
    } 
    b.b(a, "initRootKey: sha256");
    this.b = BaseKeyUtil.a(paramString1, paramString2, paramString3, paramArrayOfbyte, true);
  }
  
  public byte[] a() {
    return (byte[])this.b.clone();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encryp\\utils\RootKeyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */