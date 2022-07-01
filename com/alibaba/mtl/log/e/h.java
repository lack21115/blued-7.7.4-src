package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;

public class h {
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap, String paramString6, String paramString7) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramMap != null)
      hashMap.putAll(paramMap); 
    if (!TextUtils.isEmpty(paramString1))
      hashMap.put(LogField.PAGE.toString(), paramString1); 
    hashMap.put(LogField.EVENTID.toString(), paramString2);
    if (!TextUtils.isEmpty(paramString3))
      hashMap.put(LogField.ARG1.toString(), paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      hashMap.put(LogField.ARG2.toString(), paramString4); 
    if (!TextUtils.isEmpty(paramString5))
      hashMap.put(LogField.ARG3.toString(), paramString5); 
    if (!TextUtils.isEmpty(paramString7))
      hashMap.put(LogField.RECORD_TIMESTAMP.toString(), paramString7); 
    if (!TextUtils.isEmpty(paramString6))
      hashMap.put(LogField.RESERVE3.toString(), paramString6); 
    return b((Map)hashMap);
  }
  
  public static String a(Map<String, String> paramMap) {
    StringBuilder stringBuilder = new StringBuilder();
    LogField[] arrayOfLogField = LogField.values();
    int j = arrayOfLogField.length;
    int i = 0;
    while (true) {
      StringBuilder stringBuilder1 = null;
      if (i < j) {
        String str;
        LogField logField = arrayOfLogField[i];
        if (logField == LogField.ARGS)
          break; 
        if (paramMap.containsKey(logField.toString())) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramMap.get(logField.toString()));
          stringBuilder1.append("");
          str = stringBuilder1.toString();
          paramMap.remove(logField.toString());
        } 
        stringBuilder.append(d(str));
        stringBuilder.append("||");
        i++;
        continue;
      } 
      break;
    } 
    if (paramMap.containsKey(LogField.ARGS.toString())) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramMap.get(LogField.ARGS.toString()));
      stringBuilder1.append("");
      stringBuilder.append(d(stringBuilder1.toString()));
      paramMap.remove(LogField.ARGS.toString());
      i = 0;
    } else {
      i = 1;
    } 
    for (String str4 : paramMap.keySet()) {
      String str3;
      if (paramMap.containsKey(str4)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramMap.get(str4));
        stringBuilder1.append("");
        str3 = stringBuilder1.toString();
      } else {
        str3 = null;
      } 
      if (i != 0) {
        if ("StackTrace".equals(str4)) {
          stringBuilder.append("StackTrace=====>");
          stringBuilder.append(str3);
        } else {
          stringBuilder.append(d(str4));
          stringBuilder.append("=");
          stringBuilder.append(str3);
        } 
        i = 0;
        continue;
      } 
      if ("StackTrace".equals(str4)) {
        stringBuilder.append(",");
        stringBuilder.append("StackTrace=====>");
        stringBuilder.append(str3);
        continue;
      } 
      stringBuilder.append(",");
      stringBuilder.append(d(str4));
      stringBuilder.append("=");
      stringBuilder.append(str3);
    } 
    String str2 = stringBuilder.toString();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = str2;
      if (str2.endsWith("||")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append("-");
        str1 = stringBuilder1.toString();
      } 
    } 
    return str1;
  }
  
  public static Map<String, String> a(Map<String, String> paramMap) {
    Map<String, String> map = paramMap;
    if (paramMap == null)
      map = new HashMap<String, String>(); 
    try {
      String str2 = b.m();
      if (!TextUtils.isEmpty(str2) && !map.containsKey(LogField.USERNICK.toString()))
        map.put(LogField.USERNICK.toString(), str2); 
      str2 = b.j();
      if (!TextUtils.isEmpty(str2) && !map.containsKey(LogField.LL_USERNICK.toString()))
        map.put(LogField.LL_USERNICK.toString(), str2); 
      str2 = b.n();
      if (!TextUtils.isEmpty(str2) && !map.containsKey(LogField.USERID.toString()))
        map.put(LogField.USERID.toString(), str2); 
      str2 = b.k();
      if (!TextUtils.isEmpty(str2) && !map.containsKey(LogField.LL_USERID.toString()))
        map.put(LogField.LL_USERID.toString(), str2); 
      long l = System.currentTimeMillis();
      if (!map.containsKey(LogField.RECORD_TIMESTAMP.toString()))
        map.put(LogField.RECORD_TIMESTAMP.toString(), String.valueOf(l)); 
      if (!map.containsKey(LogField.START_SESSION_TIMESTAMP.toString()))
        map.put(LogField.START_SESSION_TIMESTAMP.toString(), String.valueOf(a.B)); 
      Map<String, String> map1 = d.a(a.getContext());
      if (map1 != null)
        for (String str3 : map1.keySet()) {
          String str4 = map1.get(str3);
          if (!TextUtils.isEmpty(str4) && !map.containsKey(str3))
            map.put(str3, str4); 
        }  
      String str1 = t();
      return map;
    } finally {
      paramMap = null;
    } 
  }
  
  public static String b(Map<String, String> paramMap) {
    if (paramMap != null && paramMap.size() > 0) {
      a(paramMap);
      return a(paramMap);
    } 
    return null;
  }
  
  private static String d(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "-"; 
    return str;
  }
  
  private static String t() {
    String str2 = l.getWifiAddress(a.getContext());
    String str1 = "_ap=1";
    if (str2 != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("_ap=1");
      stringBuilder.append(String.format("%s=%s", new Object[] { "_mac", str2 }));
      str1 = stringBuilder.toString();
    } 
    str2 = str1;
    if (d.k()) {
      String str = d.q();
      str2 = str1;
      if (!TextUtils.isEmpty(str)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1);
        stringBuilder.append(",_did=");
        stringBuilder.append(str);
        str2 = stringBuilder.toString();
      } 
    } 
    return str2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */