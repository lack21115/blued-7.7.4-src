package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class H5JavaScriptInterface {
  private static HashSet<Integer> a = new HashSet<Integer>();
  
  private String b = null;
  
  private Thread c = null;
  
  private String d = null;
  
  private Map<String, String> e = null;
  
  private static a a(String paramString) {
    if (paramString != null) {
      if (paramString.length() <= 0)
        return null; 
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        a a = new a();
        a.a = jSONObject.getString("projectRoot");
        if (a.a == null)
          return null; 
        a.b = jSONObject.getString("context");
        if (a.b == null)
          return null; 
        a.c = jSONObject.getString("url");
        if (a.c == null)
          return null; 
        a.d = jSONObject.getString("userAgent");
        if (a.d == null)
          return null; 
        a.e = jSONObject.getString("language");
        if (a.e == null)
          return null; 
        a.f = jSONObject.getString("name");
        return null;
      } finally {
        paramString = null;
      } 
    } 
    return null;
  }
  
  public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface paramWebViewInterface) {
    StringBuilder stringBuilder = null;
    if (paramWebViewInterface != null) {
      String str;
      if (a.contains(Integer.valueOf(paramWebViewInterface.hashCode())))
        return null; 
      H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
      a.add(Integer.valueOf(paramWebViewInterface.hashCode()));
      h5JavaScriptInterface.c = Thread.currentThread();
      Thread thread = h5JavaScriptInterface.c;
      if (thread != null) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        for (int i = 2; i < (thread.getStackTrace()).length; i++) {
          StackTraceElement stackTraceElement = thread.getStackTrace()[i];
          if (!stackTraceElement.toString().contains("crashreport")) {
            stringBuilder.append(stackTraceElement.toString());
            stringBuilder.append("\n");
          } 
        } 
        str = stringBuilder.toString();
      } 
      h5JavaScriptInterface.d = str;
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramWebViewInterface.getContentDescription());
      hashMap.put("[WebView] ContentDescription", stringBuilder1.toString());
      h5JavaScriptInterface.e = (Map)hashMap;
      return h5JavaScriptInterface;
    } 
    return null;
  }
  
  @JavascriptInterface
  public void printLog(String paramString) {
    x.d("Log from js: %s", new Object[] { paramString });
  }
  
  @JavascriptInterface
  public void reportJSException(String paramString) {
    if (paramString == null) {
      x.d("Payload from JS is null.", new Object[0]);
      return;
    } 
    String str1 = z.b(paramString.getBytes());
    String str2 = this.b;
    if (str2 != null && str2.equals(str1)) {
      x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
      return;
    } 
    this.b = str1;
    x.d("Handling JS exception ...", new Object[0]);
    a a = a(paramString);
    if (a == null) {
      x.d("Failed to parse payload.", new Object[0]);
      return;
    } 
    LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<Object, Object>();
    LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<Object, Object>();
    if (a.a != null)
      linkedHashMap2.put("[JS] projectRoot", a.a); 
    if (a.b != null)
      linkedHashMap2.put("[JS] context", a.b); 
    if (a.c != null)
      linkedHashMap2.put("[JS] url", a.c); 
    if (a.d != null)
      linkedHashMap2.put("[JS] userAgent", a.d); 
    if (a.i != null)
      linkedHashMap2.put("[JS] file", a.i); 
    if (a.j != 0L)
      linkedHashMap2.put("[JS] lineNumber", Long.toString(a.j)); 
    linkedHashMap1.putAll(linkedHashMap2);
    linkedHashMap1.putAll(this.e);
    linkedHashMap1.put("Java Stack", this.d);
    Thread thread = this.c;
    if (a != null)
      InnerApi.postH5CrashAsync(thread, a.f, a.g, a.h, linkedHashMap1); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\h5\H5JavaScriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */