package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.Map;

public class c {
  private static final String a = "c";
  
  private PLSharedPreferences b = null;
  
  public c(Context paramContext) {
    String str = paramContext.getPackageName();
    Logger.d(a, "get pkgname from context is{%s}", new Object[] { str });
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("share_pre_grs_conf_");
    stringBuilder.append(str);
    this.b = new PLSharedPreferences(paramContext, stringBuilder.toString());
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    try {
      String str1 = Long.toString((paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384)).versionCode);
      String str2 = a("version", "");
      if (!str1.equals(str2)) {
        Logger.i(a, "app version changed! old version{%s} and new version{%s}", new Object[] { str2, str1 });
        c();
        b("version", str1);
      } 
      return;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      Logger.w(a, "get app version failed and catch NameNotFoundException");
      return;
    } 
  }
  
  public String a(String paramString1, String paramString2) {
    return this.b.getString(paramString1, paramString2);
  }
  
  public Map<String, ?> a() {
    return this.b.getAll();
  }
  
  public void a(String paramString) {
    this.b.remove(paramString);
  }
  
  public String b() {
    return a("cp", "");
  }
  
  public void b(String paramString1, String paramString2) {
    this.b.putString(paramString1, paramString2);
  }
  
  public void c() {
    this.b.clear();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */