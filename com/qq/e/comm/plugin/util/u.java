package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;

public class u {
  public static String a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      int i = GDTADManager.getInstance().getSM().getInteger("urlLimit", 2000);
      if (paramString1.length() + paramString2.length() <= i)
        return bb.c(paramString1, "mu_p", paramString2); 
      ak.b("gdt_tag_p", "点击url超长 ， url = %s ,p = %s", new Object[] { paramString1, paramString2 });
      com.qq.e.comm.plugin.y.u.a(100022, 0, null);
    } 
    return paramString1;
  }
  
  public static boolean a(String paramString) {
    return bb.d(paramString, "ase", "1");
  }
  
  public static String b(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1) && !TextUtils.isEmpty(paramString2)) {
      int i = GDTADManager.getInstance().getSM().getInteger("urlLimit", 2000);
      if (paramString1.length() + paramString2.length() <= i)
        return bb.c(paramString1, "mu_p", paramString2); 
      ak.b("gdt_tag_p", "点击url超长 ， url = %s ,p = %s", new Object[] { paramString1, paramString2 });
      com.qq.e.comm.plugin.y.u.a(100162, 0, null);
    } 
    return paramString1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\uti\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */