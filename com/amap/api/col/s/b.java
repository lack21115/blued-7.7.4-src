package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class b<T, V> extends a<T, V> {
  public b(Context paramContext, T paramT) {
    super(paramContext, paramT);
  }
  
  protected static String b(String paramString) {
    if (paramString == null)
      return paramString; 
    try {
      return URLEncoder.encode(paramString, "utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      i.a(unsupportedEncodingException, "ProtocalHandler", "strEncoderUnsupportedEncodingException");
    } catch (Exception exception) {
      i.a(exception, "ProtocalHandler", "strEncoderException");
    } 
    return "";
  }
  
  private static String c(String paramString) {
    String[] arrayOfString = paramString.split("&");
    Arrays.sort((Object[])arrayOfString);
    StringBuffer stringBuffer = new StringBuffer();
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      stringBuffer.append(d(arrayOfString[i]));
      stringBuffer.append("&");
    } 
    String str = stringBuffer.toString();
    if (str.length() > 1)
      paramString = (String)str.subSequence(0, str.length() - 1); 
    return paramString;
  }
  
  private static String d(String paramString) {
    if (paramString == null)
      return paramString; 
    try {
      return URLDecoder.decode(paramString, "utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      i.a(unsupportedEncodingException, "ProtocalHandler", "strReEncoder");
    } catch (Exception exception) {
      i.a(exception, "ProtocalHandler", "strReEncoderException");
    } 
    return "";
  }
  
  protected abstract V a(String paramString) throws AMapException;
  
  protected abstract String a();
  
  public Map<String, String> e() {
    return null;
  }
  
  public Map<String, String> f() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("Content-Type", "application/x-www-form-urlencoded");
    hashMap.put("Accept-Encoding", "gzip");
    hashMap.put("User-Agent", "AMAP SDK Android Search 7.7.0");
    hashMap.put("X-INFO", bl.a(this.e));
    hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { "7.7.0", "sea" }));
    hashMap.put("logversion", "2.1");
    return (Map)hashMap;
  }
  
  public byte[] i() {
    try {
      String str1 = a();
      StringBuffer stringBuffer = new StringBuffer();
      if (str1 != null) {
        stringBuffer.append(str1);
        stringBuffer.append("&");
      } 
      stringBuffer.append("language=");
      stringBuffer.append(ServiceSettings.getInstance().getLanguage());
      String str2 = stringBuffer.toString();
      str1 = c(str2);
      stringBuffer = new StringBuffer();
      stringBuffer.append(str2);
      str2 = bl.a();
      stringBuffer.append("&ts=".concat(String.valueOf(str2)));
      StringBuilder stringBuilder = new StringBuilder("&scode=");
      return stringBuffer.toString().getBytes("utf-8");
    } finally {
      Exception exception = null;
      i.a(exception, "ProtocalHandler", "getEntity");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */