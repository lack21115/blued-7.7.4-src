package com.huawei.updatesdk.b.e.a;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;

public final class a {
  private static final String a = "a";
  
  private static String b;
  
  public static String a() {
    String str = b;
    if (str != null)
      return str; 
    try {
      String str1 = com.huawei.updatesdk.a.b.a.a.c().a().getPackageName();
      PackageInfo packageInfo = com.huawei.updatesdk.a.b.a.a.c().a().getPackageManager().getPackageInfo(com.huawei.updatesdk.a.b.a.a.c().a().getPackageName(), 0);
      str = str1;
      if (packageInfo != null) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(packageInfo.versionName);
        null = stringBuilder1.toString();
      } 
      str1 = Build.BRAND;
      boolean bool = TextUtils.isEmpty(str1);
      if (bool)
        str1 = "other"; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(null);
      stringBuilder.append("_");
      stringBuilder.append(str1);
      a(stringBuilder.toString());
      return b;
    } catch (Exception exception) {
      String str1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getUserAgent() ");
      stringBuilder.append(exception.toString());
      com.huawei.updatesdk.a.a.b.a.a.a.b(str1, stringBuilder.toString());
      return null;
    } 
  }
  
  private static void a(String paramString) {
    b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\b\e\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */