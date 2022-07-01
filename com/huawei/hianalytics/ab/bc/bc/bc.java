package com.huawei.hianalytics.ab.bc.bc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.ab;
import com.huawei.hianalytics.ab.ab.cd;
import com.huawei.hianalytics.ab.bc.cd.ab.ab;
import com.huawei.hianalytics.ab.bc.cd.ab.de;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.kl.cd;

public abstract class bc {
  public static String ab(Context paramContext, String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(ab.ab(paramString1, paramString2)))
      return ab.ab(paramString1, paramString2); 
    ab.cd("hmsSdk", "getAndroidId(): to getConfigByType()");
    return cd(paramContext, paramString1, paramString2);
  }
  
  public static String bc(Context paramContext, String paramString1, String paramString2) {
    if (paramString2.equals("oper"))
      return de(paramContext, paramString1, paramString2); 
    if (paramString2.equals("maint"))
      return de(paramContext, paramString1, paramString2); 
    if (paramString2.equals("diffprivacy"))
      return de(paramContext, paramString1, paramString2); 
    if (paramString2.equals("preins"))
      return de(paramContext, paramString1, paramString2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getChannel(): Invalid type: ");
    stringBuilder.append(paramString2);
    ab.fg("hmsSdk", stringBuilder.toString());
    return "";
  }
  
  private static String cd(Context paramContext, String paramString1, String paramString2) {
    if (ab.bc(paramString1, paramString2)) {
      if (TextUtils.isEmpty(com.huawei.hianalytics.ab.ab.bc.bc())) {
        String str = ab.ab(paramContext);
        ab.cd().bc().ab(str);
      } 
      return com.huawei.hianalytics.ab.ab.bc.bc();
    } 
    return "";
  }
  
  private static String de(Context paramContext, String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(cd.bc(paramString1, paramString2)))
      return cd.bc(paramString1, paramString2); 
    de de = ab.cd().bc();
    if (TextUtils.isEmpty(de.de())) {
      paramString1 = ab.bc(paramContext);
      String str = paramString1;
      if (!cd.ab("channel", paramString1, 256))
        str = ""; 
      de.cd(str);
    } 
    return de.de();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\bc\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */