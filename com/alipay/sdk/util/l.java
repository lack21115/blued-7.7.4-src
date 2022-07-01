package com.alipay.sdk.util;

import com.alipay.sdk.app.k;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.a;
import java.util.HashMap;
import java.util.Map;

public class l {
  public static final String a = "resultStatus";
  
  public static final String b = "memo";
  
  public static final String c = "result";
  
  private static String a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append("={");
    paramString2 = stringBuilder.toString();
    return paramString1.substring(paramString1.indexOf(paramString2) + paramString2.length(), paramString1.lastIndexOf("}"));
  }
  
  private static Map<String, String> a() {
    k k = k.b(k.c.a());
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("resultStatus", Integer.toString(k.a()));
    hashMap.put("memo", k.b());
    hashMap.put("result", "");
    return (Map)hashMap;
  }
  
  public static Map<String, String> a(a parama, String paramString) {
    Map<String, String> map = a();
    try {
      return a(paramString);
    } finally {
      paramString = null;
      a.a(parama, "biz", "FormatResultEx", (Throwable)paramString);
    } 
  }
  
  public static Map<String, String> a(String paramString) {
    String[] arrayOfString = paramString.split(";");
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str1 = arrayOfString[i];
      String str2 = str1.substring(0, str1.indexOf("={"));
      hashMap.put(str2, a(str1, str2));
    } 
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sd\\util\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */