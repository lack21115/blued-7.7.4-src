package com.huawei.secure.android.common.encrypt.utils;

import com.huawei.secure.android.common.encrypt.aes.AesCbc;

public class WorkKeyCryptUtil {
  public static String a(String paramString, RootKeyUtil paramRootKeyUtil) {
    return AesCbc.a(paramString, paramRootKeyUtil.a());
  }
  
  public static String b(String paramString, RootKeyUtil paramRootKeyUtil) {
    return AesCbc.b(paramString, paramRootKeyUtil.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\secure\android\common\encryp\\utils\WorkKeyCryptUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */