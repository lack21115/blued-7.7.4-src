package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class b {
  aq a = null;
  
  public b(Context paramContext) {
    try {
      p.a().a(paramContext);
    } finally {}
    this.a = aq.a();
  }
  
  private static String a(Context paramContext, String paramString, Map<String, String> paramMap) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(16);
      ed ed = new ed();
      hashMap.clear();
      hashMap.put("Content-Type", "application/x-www-form-urlencoded");
      hashMap.put("Connection", "Keep-Alive");
      hashMap.put("User-Agent", "AMAP_Location_SDK_Android 5.2.0");
      String str1 = m.a();
      String str2 = m.a(paramContext, str1, u.b(paramMap));
      paramMap.put("ts", str1);
      paramMap.put("scode", str2);
      ed.b(paramMap);
      ed.a((Map)hashMap);
      ed.a(paramString);
      ed.a(s.a(paramContext));
      ed.a(ej.g);
      ed.b(ej.g);
      try {
        return new String(arrayOfByte, "utf-8");
      } finally {
        paramContext = null;
      } 
    } finally {}
    return null;
  }
  
  private static Map<String, String> b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(16);
    hashMap.put("key", k.f(paramContext));
    if (!TextUtils.isEmpty(paramString1))
      hashMap.put("keywords", paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      hashMap.put("types", paramString2); 
    if (!TextUtils.isEmpty(paramString5) && !TextUtils.isEmpty(paramString6)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString6);
      stringBuilder.append(",");
      stringBuilder.append(paramString5);
      hashMap.put("location", stringBuilder.toString());
    } 
    if (!TextUtils.isEmpty(paramString3))
      hashMap.put("city", paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      hashMap.put("offset", paramString4); 
    if (!TextUtils.isEmpty(paramString7))
      hashMap.put("radius", paramString7); 
    return (Map)hashMap;
  }
  
  public final String a(Context paramContext, String paramString1, String paramString2) {
    Map<String, String> map = b(paramContext, paramString2, null, null, null, null, null, null);
    map.put("extensions", "all");
    map.put("subdistrict", "0");
    return a(paramContext, paramString1, map);
  }
  
  public final String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    Map<String, String> map = b(paramContext, paramString2, paramString3, paramString4, paramString5, null, null, null);
    map.put("children", "1");
    map.put("page", "1");
    map.put("extensions", "base");
    return a(paramContext, paramString1, map);
  }
  
  public final String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
    Map<String, String> map = b(paramContext, paramString2, paramString3, null, paramString4, paramString5, paramString6, paramString7);
    map.put("children", "1");
    map.put("page", "1");
    map.put("extensions", "base");
    return a(paramContext, paramString1, map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */