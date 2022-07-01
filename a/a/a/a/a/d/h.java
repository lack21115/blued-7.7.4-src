package a.a.a.a.a.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public class h {
  public static String a() {
    String str3 = Build.MODEL.trim();
    String str2 = a(Build.MANUFACTURER.trim(), str3);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = a(Build.BRAND.trim(), str3); 
    StringBuilder stringBuilder = new StringBuilder();
    str2 = str1;
    if (str1 == null)
      str2 = ""; 
    stringBuilder.append(str2);
    stringBuilder.append(str3);
    return a(stringBuilder.toString()).replace(" ", "_");
  }
  
  public static String a(Context paramContext) {
    ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    int i = applicationInfo.labelRes;
    return (i == 0) ? applicationInfo.nonLocalizedLabel.toString() : paramContext.getString(i);
  }
  
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c > '\037' && c < '')
        stringBuilder.append(c); 
    } 
    return stringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2) {
    String str = paramString1.toLowerCase(Locale.getDefault());
    return (str.startsWith("unknown") || str.startsWith("alps") || str.startsWith("android") || str.startsWith("sprd") || str.startsWith("spreadtrum") || str.startsWith("rockchip") || str.startsWith("wondermedia") || str.startsWith("mtk") || str.startsWith("mt65") || str.startsWith("nvidia") || str.startsWith("brcm") || str.startsWith("marvell") || paramString2.toLowerCase(Locale.getDefault()).contains(str)) ? null : paramString1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */