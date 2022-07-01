package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.SM;
import java.util.Random;

public class au {
  private static final Random a = new Random(System.currentTimeMillis());
  
  private static volatile Boolean b = null;
  
  public static void a() {
    b = null;
  }
  
  public static boolean a(int paramInt1, int paramInt2) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 > 0) {
      if (paramInt2 <= 0)
        return false; 
      if (paramInt1 < paramInt2) {
        String str = o.b();
        bool1 = bool2;
        if (!TextUtils.isEmpty(str)) {
          if ((str.hashCode() & Integer.MAX_VALUE) % paramInt2 > paramInt1)
            return false; 
        } else {
          return bool1;
        } 
      } 
      bool1 = true;
    } 
    return bool1;
  }
  
  public static boolean b() {
    SM sM = GDTADManager.getInstance().getSM();
    boolean bool = false;
    if (sM != null)
      bool = a(sM.getInteger("qimeiSamplingRate", 0), 10000); 
    return bool;
  }
  
  public static boolean b(int paramInt1, int paramInt2) {
    boolean bool = false;
    if (paramInt1 > 0) {
      if (paramInt2 <= 0)
        return false; 
      if (paramInt1 < paramInt2 && a.nextInt(paramInt2) >= paramInt1)
        return false; 
      bool = true;
    } 
    return bool;
  }
  
  public static boolean c() {
    if (b == null) {
      SM sM = GDTADManager.getInstance().getSM();
      if (sM != null) {
        b = Boolean.valueOf(b(sM.getInteger("collectAntiSpamInfo", 0), 10000));
        return b.booleanValue();
      } 
      return false;
    } 
    return b.booleanValue();
  }
  
  public static boolean d() {
    SM sM = GDTADManager.getInstance().getSM();
    return (sM != null) ? b(sM.getInteger("securityVulnerabilityReport", 10), 10000) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */