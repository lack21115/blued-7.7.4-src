package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.a.e;
import com.cmic.sso.sdk.c.b;
import java.util.HashMap;
import org.json.JSONObject;

public class c {
  private static a<String, String> a = new a<String, String>();
  
  public static void a() {
    String str = String.valueOf(0);
    a.put("authPageIn", str);
    a.put("authPageOut", str);
    a.put("authClickFailed", str);
    a.put("authClickSuccess", str);
    a.put("timeOnAuthPage", str);
    a.put("authPrivacyState", str);
  }
  
  public static void a(Context paramContext, Bundle paramBundle) {
    try {
      if (x.k())
        return; 
      e e = new e();
      String str3 = String.valueOf(0);
      boolean bool = ((String)a.a("authPageIn", str3)).equals(str3);
      String str2 = null;
      if (!bool) {
        str1 = a.get("authPageIn");
      } else {
        str1 = null;
      } 
      e.e(str1);
      if (!((String)a.a("authPageOut", str3)).equals(str3)) {
        str1 = a.get("authPageOut");
      } else {
        str1 = null;
      } 
      e.f(str1);
      if (!((String)a.a("authClickSuccess", str3)).equals(str3)) {
        str1 = a.get("authClickSuccess");
      } else {
        str1 = null;
      } 
      e.c(str1);
      if (!((String)a.a("authClickFailed", str3)).equals(str3)) {
        str1 = a.get("authClickFailed");
      } else {
        str1 = null;
      } 
      e.b(str1);
      String str1 = str2;
      if (!((String)a.a("timeOnAuthPage", str3)).equals(str3))
        str1 = a.get("timeOnAuthPage"); 
      e.d(str1);
      e.a(a.a("authPrivacyState", str3));
      JSONObject jSONObject = e.a();
      com.cmic.sso.sdk.c.a a1 = new com.cmic.sso.sdk.c.a();
      if (paramBundle != null)
        a1.A(paramBundle.getString("appid", "")); 
      a1.v(paramBundle.getString("traceId"));
      a1.A(paramBundle.getString("appid"));
      a1.o(j.c(paramContext));
      a1.p(j.d(paramContext));
      a1.B("quick_login_android_5.7.2");
      a1.l("android");
      a1.m(paramBundle.getString("timeOut"));
      str2 = a.a("authPageInTime", "");
      str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = a.a("SMSInTime", ""); 
      a1.w(str1);
      str2 = a.a("authPageOutTime", "");
      str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = a.a("SMSOutTime", ""); 
      a1.y(str1);
      a1.z("eventTracking5");
      a1.r(paramBundle.getString("operatorType", ""));
      if (paramBundle.getInt("startnetworkType", 0) == 0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(t.a(paramContext));
        stringBuilder1.append("");
        a1.C(stringBuilder1.toString());
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramBundle.getInt("startnetworkType", 0));
        stringBuilder1.append("");
        a1.C(stringBuilder1.toString());
      } 
      a1.x(paramBundle.getString("networkClass"));
      a1.i(t.a());
      a1.s(t.b());
      a1.t(t.c());
      a1.q(paramBundle.getString("simCardNum"));
      bool = paramBundle.getBoolean("hsaReadPhoneStatePermission", false);
      str2 = "1";
      if (bool) {
        str1 = "1";
      } else {
        str1 = "0";
      } 
      a1.a(str1);
      a1.a(jSONObject);
      if (l.a()) {
        str1 = str2;
      } else {
        str1 = "0";
      } 
      a1.d(str1);
      a1.c(paramBundle.getString("imsiState", "0"));
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(System.currentTimeMillis() - paramBundle.getLong("methodTimes", 0L));
      stringBuilder.append("");
      a1.k(stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append("埋点日志上报");
      stringBuilder.append(a1.a());
      f.a("EventUtils", stringBuilder.toString());
      (new b()).a(paramContext, a1.a(), paramBundle);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(String paramString) {
    try {
      String str = a.get(paramString);
      int i = 0;
      if (!TextUtils.isEmpty(str))
        i = Integer.valueOf(str).intValue(); 
      a.put(paramString, String.valueOf(i + 1));
      a<String, String> a1 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString);
      stringBuilder.append("Time");
      a1.put(stringBuilder.toString(), v.a());
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    a.put(paramString1, paramString2);
  }
  
  static class a<K, V> extends HashMap<K, V> {
    private a() {}
    
    public V a(Object param1Object, V param1V) {
      return (containsKey(param1Object) && get(param1Object) != null) ? get(param1Object) : param1V;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sd\\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */