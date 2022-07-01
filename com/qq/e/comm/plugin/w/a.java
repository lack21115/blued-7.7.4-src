package com.qq.e.comm.plugin.w;

import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.StringUtil;
import yaq.gdtadv;

public class a {
  private static void a(int paramInt, String paramString) {
    gdtadv.getVresult(120, 1, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public static void a(String paramString) {
    a(245, paramString);
  }
  
  public static void a(String paramString1, String paramString2) {
    char c;
    if (StringUtil.isEmpty(paramString1))
      return; 
    if (com.qq.e.comm.plugin.a.e.a.a(GDTADManager.getInstance().getAppContext(), paramString1)) {
      c = '÷';
    } else {
      c = 'ø';
    } 
    a(c, paramString2);
  }
  
  public static void a(boolean paramBoolean, String paramString) {
    char c;
    if (paramBoolean) {
      c = '÷';
    } else {
      c = 'ø';
    } 
    a(c, paramString);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {
    char c;
    if (paramBoolean1) {
      if (paramBoolean2) {
        c = 'Ċ';
      } else {
        c = 'ċ';
      } 
    } else if (paramBoolean2) {
      c = 'Ě';
    } else {
      c = 'ě';
    } 
    a(c, paramString);
  }
  
  private static String b(int paramInt, String paramString) {
    return (String)gdtadv.getobjresult(121, 1, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public static void b(String paramString) {
    a(246, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\w\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */