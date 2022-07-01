package com.bun.miitmdid.b;

import android.text.TextUtils;
import com.bun.lib.sysParamters;

public class a {
  private static String a;
  
  public static String a() {
    if (!TextUtils.isEmpty(a))
      return a; 
    a = "miitmdid(sdkv_" + sysParamters.f().d() + ")";
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */