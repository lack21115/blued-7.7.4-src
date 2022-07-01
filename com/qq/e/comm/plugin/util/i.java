package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

public class i {
  public static long a(Context paramContext) {
    if (paramContext != null)
      try {
        return (new File((paramContext.getApplicationContext().getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0)).sourceDir)).length();
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Get apk size encounter exception: ");
        stringBuilder.append(exception.getMessage());
        GDTLogger.d(stringBuilder.toString());
      }  
    return 0L;
  }
  
  public static boolean b(Context paramContext) {
    boolean bool2 = false;
    if (paramContext == null)
      return false; 
    String str = (paramContext.getApplicationInfo()).packageName;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      Intent intent = new Intent("android.intent.action.MAIN");
      intent.addCategory("android.intent.category.HOME");
      ResolveInfo resolveInfo = paramContext.getPackageManager().resolveActivity(intent, 0);
      bool1 = bool2;
      if (resolveInfo != null) {
        bool1 = bool2;
        if (resolveInfo.activityInfo != null)
          bool1 = str.equals(resolveInfo.activityInfo.packageName); 
      } 
    } 
    return bool1;
  }
  
  public static boolean c(Context paramContext) {
    return (paramContext != null && ((paramContext.getApplicationInfo()).flags & 0x1) != 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */