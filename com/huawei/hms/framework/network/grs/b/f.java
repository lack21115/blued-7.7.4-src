package com.huawei.hms.framework.network.grs.b;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Collections;
import java.util.Set;

public class f {
  private static final String a = "f";
  
  public static final Set<String> b = Collections.unmodifiableSet(new e(16));
  
  public static String a(String paramString, GrsBaseInfo paramGrsBaseInfo) {
    if (TextUtils.isEmpty(paramString)) {
      Logger.w(a, "routeBy must be not empty string or null.");
      return null;
    } 
    if ("no_route".equals(paramString) || "unconditional".equals(paramString)) {
      Logger.v(a, "routeBy equals NO_ROUTE_POLICY");
      return "no_route_country";
    } 
    return b(paramString, paramGrsBaseInfo);
  }
  
  private static String b(String paramString, GrsBaseInfo paramGrsBaseInfo) {
    String str2 = paramGrsBaseInfo.getSerCountry();
    String str3 = paramGrsBaseInfo.getRegCountry();
    String str1 = paramGrsBaseInfo.getIssueCountry();
    for (String str : paramString.split(">")) {
      if (b.contains(str.trim())) {
        if ("ser_country".equals(str.trim()) && !TextUtils.isEmpty(str2))
          return str2; 
        if ("reg_country".equals(str.trim()) && !TextUtils.isEmpty(str3))
          return str3; 
        if ("issue_country".equals(str.trim()) && !TextUtils.isEmpty(str1))
          return str1; 
      } 
    } 
    return "";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */