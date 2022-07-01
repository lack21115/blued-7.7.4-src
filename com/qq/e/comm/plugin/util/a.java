package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
import java.util.Random;

public class a {
  private static final Random a = new Random(System.currentTimeMillis());
  
  private static int a(String paramString, int paramInt) {
    return GDTADManager.getInstance().getSM().getInteger(paramString, paramInt);
  }
  
  public static String a(String paramString1, String paramString2, String paramString3) {
    paramString3 = String.format("%s@%s#%d#%s", new Object[] { paramString2, paramString1, Long.valueOf(System.currentTimeMillis()), paramString3 });
    int i = (int)(a.nextDouble() * 100.0D);
    StringBuilder stringBuilder = new StringBuilder();
    int j = a("getad_report_sampling_rate", 1);
    paramString2 = "1";
    if (i < j) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    } 
    stringBuilder.append(paramString1);
    if (i < a("expad_report_sampling_rate", 1)) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    } 
    stringBuilder.append(paramString1);
    if (i < a("clkad_report_sampling_rate", 100)) {
      paramString1 = paramString2;
    } else {
      paramString1 = "0";
    } 
    stringBuilder.append(paramString1);
    stringBuilder.append(paramString3);
    return stringBuilder.toString();
  }
  
  public static boolean a(String paramString) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      bool1 = bool2;
      if (paramString.length() > 3) {
        bool1 = bool2;
        if (paramString.charAt(0) == '1')
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public static boolean b(String paramString) {
    return (paramString != null && paramString.length() > 3 && paramString.charAt(1) == '1');
  }
  
  public static boolean c(String paramString) {
    return (paramString != null && paramString.length() > 3 && paramString.charAt(2) == '1');
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */