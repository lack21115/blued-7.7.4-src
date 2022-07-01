package com.soft.blued.utils;

import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.soft.blued.tinker.util.TinkerTools;
import com.soft.blued.user.UserInfo;
import com.tencent.bugly.crashreport.CrashReport;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class BuglyCrashRecorder extends CrashReport.CrashHandleCallback {
  public static String a = "";
  
  public Map<String, String> onCrashHandleStart(int paramInt, String paramString1, String paramString2, String paramString3) {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    linkedHashMap.put("TopFragment", BaseFragmentActivity.a);
    linkedHashMap.put("TopActivity", a);
    linkedHashMap.put("RoutePath", BaseActivity.a);
    linkedHashMap.put("Tinker patch", TinkerTools.a());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(DeviceUtils.b());
    linkedHashMap.put("versionCode", stringBuilder.toString());
    return (Map)linkedHashMap;
  }
  
  public byte[] onCrashHandleStart2GetExtraDatas(int paramInt, String paramString1, String paramString2, String paramString3) {
    try {
      if (AppInfo.c()) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        long l = System.currentTimeMillis();
        String str = (new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss")).format(Long.valueOf(l));
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("\ncrashTime=");
        stringBuilder2.append(str);
        printWriter.append(stringBuilder2.toString());
        printWriter.append("\n7.7.4, 707046");
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("\nuid: ");
        stringBuilder1.append((UserInfo.a().i()).uid);
        printWriter.append(stringBuilder1.toString());
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("\ncrashType:");
        stringBuilder1.append(paramInt);
        printWriter.append(stringBuilder1.toString());
        printWriter.append("\n");
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("errorType:");
        stringBuilder1.append(paramString1);
        printWriter.append(stringBuilder1.toString());
        printWriter.append("\n");
        printWriter.append(paramString2);
        printWriter.append(paramString3);
        paramString1 = stringWriter.toString();
        printWriter.close();
        AppMethods.a(paramString1, AppMethods.a("crash"), "blued_crash.txt");
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\BuglyCrashRecorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */