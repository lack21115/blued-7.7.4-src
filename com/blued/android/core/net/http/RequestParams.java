package com.blued.android.core.net.http;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.utils.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestParams {
  private static String h = "UTF-8";
  
  protected ConcurrentHashMap<String, String> a;
  
  protected String b;
  
  protected String c;
  
  protected String d;
  
  protected String e;
  
  protected Map<String, String> f;
  
  protected byte[] g;
  
  public RequestParams() {
    c();
  }
  
  public static String a(String paramString, RequestParams paramRequestParams) {
    String str = paramString;
    if (paramRequestParams != null) {
      String str1 = paramRequestParams.b();
      if (paramString.indexOf("?") == -1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("?");
        stringBuilder.append(str1);
        paramString = stringBuilder.toString();
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("&");
        stringBuilder.append(str1);
        paramString = stringBuilder.toString();
      } 
      str = paramString;
      if (HttpManager.c()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("real url:");
        stringBuilder.append(paramString);
        Log.a("HttpManager", stringBuilder.toString());
        str = paramString;
      } 
    } 
    return str;
  }
  
  private void c() {
    this.a = new ConcurrentHashMap<String, String>();
  }
  
  public String a() {
    return this.d;
  }
  
  public void a(String paramString) {
    if (paramString == null) {
      this.e = "";
      return;
    } 
    this.e = paramString;
  }
  
  public void a(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null)
      this.a.put(paramString1, paramString2); 
  }
  
  public String b() {
    StringBuffer stringBuffer = new StringBuffer();
    int i = 0;
    try {
      for (Map.Entry<String, String> entry : this.a.entrySet()) {
        String str = (String)entry.getKey();
        if (!TextUtils.isEmpty(str)) {
          if (i)
            stringBuffer.append("&"); 
          stringBuffer.append(URLEncoder.encode(str, h));
          String str1 = (String)entry.getValue();
          if (!TextUtils.isEmpty(str1)) {
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(str1, h));
          } 
          i++;
        } 
      } 
    } catch (UnsupportedEncodingException unsupportedEncodingException) {}
    return stringBuffer.toString();
  }
  
  public void b(String paramString1, String paramString2) {
    this.c = paramString1;
    this.b = paramString2;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : this.a.entrySet()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append((String)entry.getKey());
      stringBuilder.append("=");
      stringBuilder.append((String)entry.getValue());
    } 
    if (!TextUtils.isEmpty(this.c)) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("uploadFile=");
      stringBuilder1.append(this.c);
      stringBuilder.append(stringBuilder1.toString());
    } 
    if (!TextUtils.isEmpty(this.d)) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("downloadFile=");
      stringBuilder1.append(this.d);
      stringBuilder.append(stringBuilder1.toString());
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\RequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */