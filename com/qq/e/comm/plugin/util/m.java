package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;

public class m {
  public static boolean a(double paramDouble) {
    return (paramDouble == 0.0D);
  }
  
  public static boolean a(int paramInt) {
    int i = GDTADManager.getInstance().getSM().getInteger("video_duration_setting_min", 5);
    int j = GDTADManager.getInstance().getSM().getInteger("video_duration_setting_max", 60);
    if (paramInt < i || paramInt > j) {
      GDTLogger.e("setMaxVideoDuration Illegal param ");
      return false;
    } 
    return true;
  }
  
  public static boolean a(Object paramObject) {
    return (paramObject == null);
  }
  
  public static boolean a(String paramString) {
    return (a(paramString) || paramString.trim().length() == 0);
  }
  
  public static boolean a(String paramString1, String paramString2) {
    boolean bool2 = a(paramString1);
    boolean bool1 = false;
    if (!bool2) {
      if (a(paramString2))
        return false; 
      paramString1 = paramString1.substring(0, paramString1.lastIndexOf("."));
      bool1 = paramString2.substring(0, paramString2.lastIndexOf(".")).equals(paramString1);
    } 
    return bool1;
  }
  
  public static boolean b(String paramString) {
    return TextUtils.isEmpty(paramString) ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */