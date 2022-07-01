package com.soft.blued.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.soft.blued.app.BluedApplicationLike;

public class ServiceUtils {
  public static void a(Context paramContext, Class<?> paramClass, Bundle paramBundle) {
    if (!a())
      return; 
    Intent intent = new Intent(paramContext, paramClass);
    if (paramBundle != null)
      intent.putExtras(paramBundle); 
    try {
      paramContext.startService(intent);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static boolean a() {
    return AppInfo.c() ? (!(Build.VERSION.SDK_INT >= 26 && !BluedApplicationLike.isAppOnForeground())) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\ServiceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */