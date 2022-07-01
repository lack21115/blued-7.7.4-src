package com.bytedance.embedapplog.b;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

class q extends c {
  q() {
    super(true, false);
  }
  
  private boolean a() {
    boolean bool = false;
    try {
      int i = Class.forName("miui.os.Build").getName().length();
      if (i > 0)
        bool = true; 
      return bool;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private boolean a(String paramString) {
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = d(); 
    return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) ? true : c();
  }
  
  private boolean b() {
    return ((!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER));
  }
  
  private boolean c() {
    return ((!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei")));
  }
  
  private String d() {
    BufferedReader bufferedReader;
    String str1 = null;
    String str2 = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.build.version.emui").getInputStream()), 1024);
      str1 = str2;
    } finally {
      str2 = null;
    } 
    try {
      h.a((Throwable)str2);
      return (String)null;
    } finally {
      if (iOException != null)
        try {
          iOException.close();
        } catch (IOException iOException1) {} 
    } 
  }
  
  protected boolean a(JSONObject paramJSONObject) {
    StringBuilder stringBuilder = new StringBuilder(16);
    if (a()) {
      stringBuilder.append("MIUI-");
    } else if (b()) {
      stringBuilder.append("FLYME-");
    } else {
      String str = d();
      if (a(str))
        stringBuilder.append("EMUI-"); 
      if (!TextUtils.isEmpty(str)) {
        stringBuilder.append(str);
        stringBuilder.append("-");
      } 
    } 
    stringBuilder.append(Build.VERSION.INCREMENTAL);
    paramJSONObject.put("rom", stringBuilder.toString());
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */