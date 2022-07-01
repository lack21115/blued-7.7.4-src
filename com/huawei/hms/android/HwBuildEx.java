package com.huawei.hms.android;

import android.util.Log;

public class HwBuildEx {
  public static int getSystemPropertiesInt(String paramString, int paramInt) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return ((Integer)clazz.getDeclaredMethod("getInt", new Class[] { String.class, int.class }).invoke(clazz, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
    } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|java.lang.reflect.InvocationTargetException|ClassCastException classNotFoundException) {
      Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
      return paramInt;
    } 
  }
  
  public static class VERSION {
    public static final int EMUI_SDK_INT = HwBuildEx.getSystemPropertiesInt("ro.build.hw_emui_api_level", 0);
  }
  
  public static class VersionCodes {
    public static final int CUR_DEVELOPMENT = 10000;
    
    public static final int EMUI_10_0 = 21;
    
    public static final int EMUI_1_0 = 1;
    
    public static final int EMUI_1_5 = 2;
    
    public static final int EMUI_1_6 = 3;
    
    public static final int EMUI_2_0_JB = 4;
    
    public static final int EMUI_2_0_KK = 5;
    
    public static final int EMUI_2_3 = 6;
    
    public static final int EMUI_3_0 = 7;
    
    public static final int EMUI_3_0_5 = 8;
    
    public static final int EMUI_3_1 = 8;
    
    public static final int EMUI_4_0 = 9;
    
    public static final int EMUI_4_1 = 10;
    
    public static final int EMUI_5_0 = 11;
    
    public static final int EMUI_5_1 = 12;
    
    public static final int EMUI_5_1_b10x = 13;
    
    public static final int EMUI_5_1_b200 = 13;
    
    public static final int EMUI_6_0 = 14;
    
    public static final int EMUI_9_0 = 17;
    
    public static final int UNKNOWN_EMUI = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\android\HwBuildEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */