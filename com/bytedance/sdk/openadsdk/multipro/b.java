package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.multipro.d.a;

public class b {
  public static boolean a;
  
  public static boolean b;
  
  public static void a() {
    a.a("sp_multi_info", "is_support_multi_process", Boolean.valueOf(true));
    a = true;
    b = true;
  }
  
  public static boolean b() {
    if (!b) {
      a = a.a("sp_multi_info", "is_support_multi_process", false);
      b = true;
    } 
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */