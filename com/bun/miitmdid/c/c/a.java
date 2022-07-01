package com.bun.miitmdid.c.c;

import android.text.TextUtils;
import com.bun.lib.sysParamters;

public class a {
  public static com.bun.miitmdid.c.a a() {
    return b() ? com.bun.miitmdid.c.a.p : (c() ? com.bun.miitmdid.c.a.q : com.bun.miitmdid.c.a.b);
  }
  
  private static boolean b() {
    String str = sysParamters.a("ro.build.freeme.label", "");
    return TextUtils.isEmpty(str) ? false : str.equalsIgnoreCase("FreemeOS");
  }
  
  private static boolean c() {
    return !TextUtils.isEmpty(sysParamters.a("ro.ssui.product", ""));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued71500-dex2jar.jar!\com\bun\miitmdid\c\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */