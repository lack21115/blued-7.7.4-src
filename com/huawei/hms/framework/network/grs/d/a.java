package com.huawei.hms.framework.network.grs.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

public class a {
  public static String a() {
    return "4.0.18.300";
  }
  
  public static String a(Context paramContext) {
    if (paramContext == null)
      return ""; 
    PackageManager packageManager = paramContext.getPackageManager();
    try {
      return (packageManager.getPackageInfo(paramContext.getPackageName(), 16384)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Logger.w("AgentUtil", "", (Throwable)nameNotFoundException);
      return "";
    } 
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    Locale locale1;
    String str1;
    StringBuilder stringBuilder2;
    if (paramContext == null) {
      locale1 = Locale.ROOT;
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString1);
      stringBuilder2.append("/%s");
      return String.format(locale1, stringBuilder2.toString(), new Object[] { a() });
    } 
    String str2 = locale1.getPackageName();
    String str3 = a((Context)locale1);
    String str4 = Build.VERSION.RELEASE;
    String str5 = Build.MODEL;
    Locale locale2 = Locale.ROOT;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("%s/%s (Linux; Android %s; %s) ");
    stringBuilder1.append(paramString1);
    stringBuilder1.append("/%s %s");
    paramString1 = stringBuilder1.toString();
    String str6 = a();
    stringBuilder1 = stringBuilder2;
    if (TextUtils.isEmpty(stringBuilder2))
      str1 = "no_service_name"; 
    return String.format(locale2, paramString1, new Object[] { str2, str3, str4, str5, str6, str1 });
  }
  
  public static String b(Context paramContext, String paramString1, String paramString2) {
    return a(paramContext, paramString1, paramString2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */