package com.blued.android.core.utils.skin;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.blued.android.core.AppInfo;

public class BluedSkinPreferences {
  private static SharedPreferences a;
  
  public static void a(boolean paramBoolean) {
    c().edit().putBoolean("skin_auto_system", paramBoolean).commit();
  }
  
  public static boolean a() {
    return c().getBoolean("skin_auto_system", true);
  }
  
  public static void b(boolean paramBoolean) {
    c().edit().putBoolean("skin_dark_mode_status", paramBoolean).commit();
  }
  
  public static boolean b() {
    return c().getBoolean("skin_dark_mode_status", false);
  }
  
  private static SharedPreferences c() {
    if (a == null)
      a = PreferenceManager.getDefaultSharedPreferences(AppInfo.d()); 
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\skin\BluedSkinPreferences.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */