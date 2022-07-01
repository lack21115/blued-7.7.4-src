package com.qq.e.comm.plugin.a.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.util.aj;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.io.File;

public class a {
  public static File a(File paramFile, c paramc) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a(paramc.h()));
    stringBuilder.append(".apk");
    return new File(paramFile, stringBuilder.toString());
  }
  
  public static String a(String paramString) {
    return paramString;
  }
  
  public static boolean a(Context paramContext, String paramString) {
    if (!StringUtil.isEmpty(paramString)) {
      PackageManager packageManager = paramContext.getPackageManager();
      try {
        PackageInfo packageInfo = packageManager.getPackageInfo(paramString, 256);
        if (packageInfo != null)
          return true; 
      } finally {}
    } 
    return false;
  }
  
  public static boolean a(c paramc) {
    File file = aj.h();
    return (file == null) ? false : a(file, paramc).exists();
  }
  
  public static boolean a(File paramFile, String paramString, Context paramContext) {
    if (paramFile != null && paramFile.exists()) {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
      if (packageInfo == null) {
        GDTLogger.e("apk file does not fit current system");
      } else {
        return packageInfo.packageName.equals(paramString);
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */