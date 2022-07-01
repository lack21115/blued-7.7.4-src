package com.blued.android.module.external_sense_library.utils;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;

public class SPUtils {
  private SharedPreferences a;
  
  private SharedPreferences.Editor b;
  
  public SPUtils(String paramString) {
    this.a = AppInfo.d().getSharedPreferences(paramString, 0);
    this.b = this.a.edit();
    this.b.apply();
  }
  
  public void a(String paramString1, String paramString2) {
    this.b.putString(paramString1, paramString2).apply();
  }
  
  public String b(String paramString1, String paramString2) {
    return this.a.getString(paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_librar\\utils\SPUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */