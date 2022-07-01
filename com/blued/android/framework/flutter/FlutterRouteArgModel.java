package com.blued.android.framework.flutter;

import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import com.soft.blued.http.Host;
import com.soft.blued.user.UserInfo;
import java.util.HashMap;
import java.util.Map;

public class FlutterRouteArgModel {
  public int darkMode;
  
  public Map extra;
  
  public String h5_host;
  
  public String language;
  
  public String routeName;
  
  public String user_avatar;
  
  public String user_id;
  
  public String user_name;
  
  private static int getDarkMode() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static FlutterRouteArgModel getDefault() {
    FlutterRouteArgModel flutterRouteArgModel = new FlutterRouteArgModel();
    flutterRouteArgModel.routeName = "/";
    flutterRouteArgModel.darkMode = getDarkMode();
    flutterRouteArgModel.language = getLanguage();
    flutterRouteArgModel.user_id = UserInfo.a().i().getUid();
    flutterRouteArgModel.user_name = UserInfo.a().i().getName();
    flutterRouteArgModel.user_avatar = UserInfo.a().i().getAvatar();
    flutterRouteArgModel.extra = new HashMap<Object, Object>();
    flutterRouteArgModel.h5_host = Host.a("H5");
    return flutterRouteArgModel;
  }
  
  private static String getLanguage() {
    String str2 = LocaleUtils.c().getLanguage();
    String str3 = LocaleUtils.c().getCountry();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getLanguage: language=");
    stringBuilder.append(str2);
    stringBuilder.append(", country=");
    stringBuilder.append(str3);
    LogUtils.c(stringBuilder.toString());
    String str1 = "zh";
    if ("zh".equalsIgnoreCase(str2)) {
      if ("tw".equalsIgnoreCase(str3) || "hk".equalsIgnoreCase(str3))
        return "zh_TW"; 
    } else if ("en".equalsIgnoreCase(str2)) {
      str1 = "en";
    } 
    return str1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\flutter\FlutterRouteArgModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */