package com.bytedance.embedapplog.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
  private static String a;
  
  private static String b = ":push";
  
  private static String a() {
    Exception exception;
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("/proc/");
      stringBuilder.append(Process.myPid());
      stringBuilder.append("/cmdline");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(stringBuilder.toString()), "iso-8859-1"));
      return null;
    } finally {
      exception = null;
    } 
    if (exception != null)
      try {
        exception.close();
        return null;
      } catch (Exception exception1) {
        return null;
      }  
  }
  
  public static String a(Context paramContext) {
    String str = a;
    if (!TextUtils.isEmpty(str))
      return str; 
    try {
      int j = Process.myPid();
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses()) {
        if (runningAppProcessInfo.pid == j) {
          a = runningAppProcessInfo.processName;
          break;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    a = a();
    if (h.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getProcessName, ");
      stringBuilder.append(a);
      h.a(stringBuilder.toString(), null);
    } 
    return a;
  }
  
  private static String a(String paramString1, String paramString2) {
    if (paramString2 == null)
      paramString2 = "ISO-8859-1"; 
    try {
      return URLEncoder.encode(paramString1, paramString2);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      return "";
    } 
  }
  
  public static String a(String paramString1, HashMap<String, String> paramHashMap, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder(paramString1);
    for (String paramString1 : paramHashMap.keySet()) {
      String str = a(paramString1, paramString2);
      paramString1 = paramHashMap.get(paramString1);
      if (paramString1 != null) {
        paramString1 = a(paramString1, paramString2);
      } else {
        paramString1 = "";
      } 
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append(str);
      stringBuilder.append("=");
      stringBuilder.append(paramString1);
    } 
    return stringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean) {
    return paramBoolean ? "yes" : "no";
  }
  
  public static boolean a(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static boolean a(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    return (paramJSONObject1 != null && paramJSONObject2 != null) ? paramJSONObject1.toString().equals(paramJSONObject2.toString()) : a(paramJSONObject1, paramJSONObject2);
  }
  
  public static JSONObject b(JSONObject paramJSONObject1, JSONObject paramJSONObject2) {
    try {
      Iterator<String> iterator = paramJSONObject2.keys();
      while (iterator.hasNext()) {
        String str = iterator.next();
        paramJSONObject1.put(str, paramJSONObject2.opt(str));
      } 
    } catch (JSONException jSONException) {
      h.a((Throwable)jSONException);
    } 
    return paramJSONObject1;
  }
  
  public static boolean b(Context paramContext) {
    String str = a(paramContext);
    return (str != null && str.endsWith(b));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplo\\util\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */