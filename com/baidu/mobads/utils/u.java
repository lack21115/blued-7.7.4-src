package com.baidu.mobads.utils;

import android.content.Context;
import android.provider.Settings;
import com.baidu.mobads.openad.e.e;

class u extends e.b<String> {
  u(t paramt, Context paramContext) {}
  
  public void a(String paramString) {}
  
  public String b() {
    try {
      t.a(this.b, "1");
      String str = Settings.System.getString(this.a.getContentResolver(), "bd_setting_i");
      boolean bool = t.b(this.b, str);
      if (bool) {
        t.a(this.b, "2");
        str = "";
      } 
      try {
        String[] arrayOfString = (this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 4096)).requestedPermissions;
        for (int i = 0; i < arrayOfString.length; i++) {
          if (arrayOfString[i].contains("android.permission.READ_PHONE_STATE")) {
            t.c(this.b, "2");
            break;
          } 
          t.c(this.b, "0");
        } 
      } finally {
        Exception exception;
      } 
    } finally {
      Exception exception = null;
    } 
    return t.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\util\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */