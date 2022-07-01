package com.alipay.sdk.sys;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.c;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.n;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  public static final String a = "\"&";
  
  public static final String b = "&";
  
  public static final String c = "bizcontext=\"";
  
  public static final String d = "bizcontext=";
  
  public static final String e = "\"";
  
  public static final String f = "appkey";
  
  public static final String g = "ty";
  
  public static final String h = "sv";
  
  public static final String i = "an";
  
  public static final String j = "setting";
  
  public static final String k = "av";
  
  public static final String l = "sdk_start_time";
  
  public static final String m = "extInfo";
  
  public static final String n = "ap_link_token";
  
  public static final String o = "UTF-8";
  
  public final String p;
  
  public final long q;
  
  public final String r;
  
  public final c s;
  
  private String t = "";
  
  private String u = "";
  
  private Context v = null;
  
  public a(Context paramContext, String paramString1, String paramString2) {
    boolean bool = TextUtils.isEmpty(paramString2);
    this.s = new c(paramContext, bool);
    this.p = c(paramString1, this.u);
    this.q = SystemClock.elapsedRealtime();
    this.r = paramString2;
    if (!bool) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramString2);
      stringBuilder.append("|");
      stringBuilder.append(this.p);
      com.alipay.sdk.app.statistic.a.b(this, "biz", "eptyp", stringBuilder.toString());
    } 
    try {
      this.v = paramContext.getApplicationContext();
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.t = packageInfo.versionName;
      this.u = packageInfo.packageName;
    } catch (Exception exception) {
      c.a(exception);
    } 
    if (!bool) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("");
      stringBuilder.append(SystemClock.elapsedRealtime());
      com.alipay.sdk.app.statistic.a.b(this, "biz", "PgApiInvoke", stringBuilder.toString());
      com.alipay.sdk.app.statistic.a.a(paramContext, this, paramString1, this.p);
    } 
  }
  
  public static a a() {
    return null;
  }
  
  private String a(String paramString1, String paramString2, String paramString3) {
    if (TextUtils.isEmpty(paramString1))
      return null; 
    String[] arrayOfString = paramString1.split(paramString2);
    int i;
    for (i = 0; i < arrayOfString.length; i++) {
      if (!TextUtils.isEmpty(arrayOfString[i]) && arrayOfString[i].startsWith(paramString3))
        return arrayOfString[i]; 
    } 
    return null;
  }
  
  private String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws JSONException, UnsupportedEncodingException {
    JSONObject jSONObject;
    paramString1 = paramString1.substring(paramString2.length());
    int i = paramString1.length();
    int j = paramString3.length();
    boolean bool = false;
    paramString1 = paramString1.substring(0, i - j);
    if (paramString1.length() >= 2 && paramString1.startsWith("\"") && paramString1.endsWith("\"")) {
      jSONObject = new JSONObject(paramString1.substring(1, paramString1.length() - 1));
      bool = true;
    } else {
      jSONObject = new JSONObject((String)jSONObject);
    } 
    if (!jSONObject.has("appkey"))
      jSONObject.put("appkey", "2014052600006128"); 
    if (!jSONObject.has("ty"))
      jSONObject.put("ty", "and_lite"); 
    if (!jSONObject.has("sv"))
      jSONObject.put("sv", "h.a.3.7.4"); 
    if (!jSONObject.has("an") && (!this.u.contains("setting") || !n.b(this.v)))
      jSONObject.put("an", this.u); 
    if (!jSONObject.has("av"))
      jSONObject.put("av", this.t); 
    if (!jSONObject.has("sdk_start_time"))
      jSONObject.put("sdk_start_time", System.currentTimeMillis()); 
    if (!jSONObject.has("extInfo"))
      jSONObject.put("extInfo", c()); 
    String str2 = jSONObject.toString();
    String str1 = str2;
    if (bool) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("\"");
      stringBuilder1.append(str2);
      stringBuilder1.append("\"");
      str1 = stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString2);
    stringBuilder.append(str1);
    stringBuilder.append(paramString3);
    return stringBuilder.toString();
  }
  
  public static HashMap<String, String> a(a parama) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (parama != null) {
      hashMap.put("sdk_ver", "15.7.4");
      hashMap.put("app_name", parama.u);
      hashMap.put("token", parama.p);
      hashMap.put("call_type", parama.r);
      hashMap.put("ts_api_invoke", String.valueOf(parama.q));
    } 
    return (HashMap)hashMap;
  }
  
  private String b(String paramString1, String paramString2) throws JSONException, UnsupportedEncodingException {
    String str = a("", "");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append(str);
    stringBuilder.append(paramString2);
    return stringBuilder.toString();
  }
  
  private boolean b(String paramString) {
    return paramString.contains("\"&") ^ true;
  }
  
  private String c(String paramString) {
    try {
      StringBuilder stringBuilder1;
      String str1 = a(paramString, "&", "bizcontext=");
      boolean bool = TextUtils.isEmpty(str1);
      if (bool) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append("&");
        return stringBuilder1.toString();
      } 
      int i = paramString.indexOf((String)stringBuilder1);
      String str2 = paramString.substring(0, i);
      String str3 = paramString.substring(i + stringBuilder1.length());
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str2);
      stringBuilder2.append(a((String)stringBuilder1, "bizcontext=", "", true));
      return stringBuilder2.toString();
    } finally {
      Exception exception = null;
    } 
  }
  
  private static String c(String paramString1, String paramString2) {
    try {
      Locale locale = Locale.getDefault();
      String str = paramString1;
      if (paramString1 == null)
        str = ""; 
      paramString1 = paramString2;
      return String.format("EP%s%s_%s", new Object[] { "1", n.f(String.format(locale, "%s%s%d%s", new Object[] { str, paramString1, Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString() })), Long.valueOf(System.currentTimeMillis()) });
    } finally {
      paramString1 = null;
    } 
  }
  
  private JSONObject c() {
    JSONObject jSONObject = new JSONObject();
    try {
      return jSONObject;
    } finally {
      Exception exception = null;
    } 
  }
  
  private String d(String paramString) {
    try {
      String str1 = a(paramString, "\"&", "bizcontext=\"");
      boolean bool = TextUtils.isEmpty(str1);
      if (bool) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramString);
        stringBuilder1.append("&");
        return stringBuilder1.toString();
      } 
      null = str1;
      if (!str1.endsWith("\"")) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append("\"");
        null = stringBuilder1.toString();
      } 
      int i = paramString.indexOf(null);
      str1 = paramString.substring(0, i);
      String str2 = paramString.substring(i + null.length());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str1);
      stringBuilder.append(a(null, "bizcontext=\"", "\"", false));
      return stringBuilder.toString();
    } finally {
      Exception exception = null;
    } 
  }
  
  public String a(String paramString) {
    return TextUtils.isEmpty(paramString) ? paramString : (paramString.startsWith("new_external_info==") ? paramString : (b(paramString) ? c(paramString) : d(paramString)));
  }
  
  public String a(String paramString1, String paramString2) {
    try {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("appkey", "2014052600006128");
      jSONObject.put("ty", "and_lite");
      jSONObject.put("sv", "h.a.3.7.4");
      if (!this.u.contains("setting") || !n.b(this.v))
        jSONObject.put("an", this.u); 
      jSONObject.put("av", this.t);
      jSONObject.put("sdk_start_time", System.currentTimeMillis());
      return jSONObject.toString();
    } finally {
      paramString1 = null;
      c.a((Throwable)paramString1);
    } 
  }
  
  public Context b() {
    return this.v;
  }
  
  public static final class a {
    private static final HashMap<UUID, a> a = new HashMap<UUID, a>();
    
    private static final HashMap<String, a> b = new HashMap<String, a>();
    
    private static final String c = "i_uuid_b_c";
    
    public static a a(Intent param1Intent) {
      if (param1Intent == null)
        return null; 
      Serializable serializable = param1Intent.getSerializableExtra("i_uuid_b_c");
      return (serializable instanceof UUID) ? a.remove(serializable) : null;
    }
    
    public static a a(String param1String) {
      return TextUtils.isEmpty(param1String) ? null : b.remove(param1String);
    }
    
    public static void a(a param1a, Intent param1Intent) {
      if (param1a != null) {
        if (param1Intent == null)
          return; 
        UUID uUID = UUID.randomUUID();
        a.put(uUID, param1a);
        param1Intent.putExtra("i_uuid_b_c", uUID);
      } 
    }
    
    public static void a(a param1a, String param1String) {
      if (param1a != null) {
        if (TextUtils.isEmpty(param1String))
          return; 
        b.put(param1String, param1a);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\sdk\sys\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */