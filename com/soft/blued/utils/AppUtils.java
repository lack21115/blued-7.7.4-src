package com.soft.blued.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.user.UserInfo;
import java.util.List;

public class AppUtils {
  private static String a;
  
  private static String b;
  
  public static String a() {
    if (TextUtils.isEmpty(a))
      try {
        a = AppInfo.d().getExternalCacheDir().getParentFile().getAbsolutePath();
      } catch (NullPointerException nullPointerException) {
        nullPointerException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    if (a == null)
      a = ""; 
    return a;
  }
  
  public static void a(Context paramContext) {
    CommonConstants.c = true;
    CommonConstants.d = false;
    FirstActivity.a(paramContext);
  }
  
  public static boolean a(Intent paramIntent) {
    List list = AppInfo.d().getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (list != null && list.size() > 0);
  }
  
  public static boolean a(String paramString) {
    Logger.c("ljxtaobao", new Object[] { "start" });
    if (paramString != null) {
      if ("".equals(paramString))
        return false; 
      try {
        AppInfo.d().getPackageManager().getApplicationInfo(paramString, 8192);
        Logger.c("ljxtaobao", new Object[] { "end" });
        return true;
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Logger.c("ljxtaobao", new Object[] { "end" });
      } 
    } 
    return false;
  }
  
  public static String b() {
    if (TextUtils.isEmpty(b))
      try {
        b = AppInfo.d().getCacheDir().getParentFile().getAbsolutePath();
      } catch (NullPointerException nullPointerException) {
        nullPointerException.printStackTrace();
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    if (b == null)
      b = ""; 
    return b;
  }
  
  public static boolean b(String paramString) {
    return (paramString == null) ? false : ((!TextUtils.isEmpty(b()) && paramString.startsWith(b())) ? true : ((!TextUtils.isEmpty(a()) && paramString.startsWith(a()))));
  }
  
  public static boolean c(String paramString) {
    return !TextUtils.isEmpty(paramString) ? paramString.equals((UserInfo.a().i()).uid) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\AppUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */