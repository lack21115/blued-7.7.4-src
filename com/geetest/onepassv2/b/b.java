package com.geetest.onepassv2.b;

import com.geetest.onelogin.e.a.a;
import com.geetest.onelogin.e.a.d;
import com.geetest.onelogin.e.a.h;
import com.geetest.onepassv2.a.a;
import java.net.URLEncoder;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

public class b {
  public static String a(String paramString1, String paramString2, a parama) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(16);
    hashMap.put("clientId", paramString1);
    hashMap.put("clientType", "3");
    hashMap.put("format", "json");
    hashMap.put("version", "v1.5");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("timestamp=");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("&bussinessType=jy");
    String str = a.a(stringBuilder.toString(), "e1c3d0de067d4666");
    try {
      String str1 = h.a("e1c3d0de067d4666", (RSAPublicKey)h.a("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB"));
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    hashMap.put("paramStr", str);
    hashMap.put("paramKey", exception);
    paramString2 = a(paramString1, (String)exception, str, paramString2);
    hashMap.put("sign", paramString2);
    parama.e(paramString1);
    parama.f("3");
    parama.g("json");
    parama.m("v1.5");
    parama.h(paramString2);
    parama.i(str);
    parama.j((String)exception);
    return a((Map)hashMap, "utf-8");
  }
  
  private static String a(String paramString1, String paramString2, String paramString3, String paramString4) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("3");
    stringBuilder.append("json");
    stringBuilder.append(paramString2);
    stringBuilder.append(paramString3);
    stringBuilder.append("v1.5");
    return d.a(d.a(stringBuilder.toString(), paramString4));
  }
  
  private static String a(Map<String, String> paramMap, String paramString) {
    StringBuffer stringBuffer = new StringBuffer();
    try {
      for (Map.Entry<String, String> entry : paramMap.entrySet()) {
        stringBuffer.append((String)entry.getKey());
        stringBuffer.append("=");
        stringBuffer.append(URLEncoder.encode((String)entry.getValue(), paramString));
        stringBuffer.append("&");
      } 
      stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return stringBuffer.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */