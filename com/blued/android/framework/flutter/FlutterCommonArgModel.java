package com.blued.android.framework.flutter;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.LocaleUtils;
import com.blued.android.framework.utils.LogUtils;
import java.io.File;

public class FlutterCommonArgModel {
  public String cache_dir_path;
  
  public int dark_mode;
  
  public int debug_mode;
  
  public String language;
  
  public String locale;
  
  public int screen_destiny = 0;
  
  private static int getDarkMode() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static FlutterCommonArgModel getDefault() {
    FlutterCommonArgModel flutterCommonArgModel = new FlutterCommonArgModel();
    flutterCommonArgModel.locale = getLocale();
    flutterCommonArgModel.language = getLanguage();
    flutterCommonArgModel.dark_mode = getDarkMode();
    flutterCommonArgModel.debug_mode = 0;
    flutterCommonArgModel.cache_dir_path = getFileCacheDirPath();
    flutterCommonArgModel.screen_destiny = 0;
    return flutterCommonArgModel;
  }
  
  private static String getFileCacheDirPath() {
    File file = AppInfo.d().getExternalFilesDir((String)null);
    if (file != null)
      return file.getAbsolutePath(); 
    file = AppInfo.d().getFilesDir();
    return (file != null) ? file.getAbsolutePath() : "";
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
  
  private static String getLocale() {
    String str2 = LocaleUtils.c().getCountry();
    String str1 = str2;
    if (str2 == null)
      str1 = "cn"; 
    return str1.toLowerCase().trim();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\flutter\FlutterCommonArgModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */