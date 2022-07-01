package com.cmic.sso.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cmic.sso.sdk.b.b.b;
import com.cmic.sso.sdk.utils.aa;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.l;
import com.cmic.sso.sdk.utils.p;
import com.cmic.sso.sdk.utils.q;
import com.cmic.sso.sdk.utils.t;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static a c;
  
  private com.cmic.sso.sdk.b.b.a a;
  
  private Context b;
  
  private a(Context paramContext) {
    this.b = paramContext.getApplicationContext();
    this.a = com.cmic.sso.sdk.b.b.a.a(this.b);
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   3: ifnonnull -> 38
    //   6: ldc com/cmic/sso/sdk/auth/a
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   12: ifnonnull -> 26
    //   15: new com/cmic/sso/sdk/auth/a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   26: ldc com/cmic/sso/sdk/auth/a
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/cmic/sso/sdk/auth/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(JSONObject paramJSONObject, String paramString, Bundle paramBundle) {
    String str;
    if (paramBundle.getBoolean("keyIsSimKeyICCID", false)) {
      str = paramBundle.getString("iccid", "");
    } else {
      str = str.getString("imsi", "");
    } 
    l.a(this.b, paramString, paramJSONObject.optLong("phonescripED"), str);
  }
  
  private void b(Bundle paramBundle, b paramb) {
    long l = SystemClock.elapsedRealtime();
    this.a.a(this.b, paramBundle, new b(this, paramBundle, l, paramb) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            aa.a(a.a(this.d)).a();
            String str = this.a.getString("interfacecode", "");
            Bundle bundle = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(param1String1);
            stringBuilder.append(";");
            bundle.putString("interfacecode", stringBuilder.toString());
            long l = SystemClock.elapsedRealtime() - this.b;
            str = this.a.getString("interfaceelasped", "");
            bundle = this.a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(l);
            stringBuilder.append(";");
            bundle.putString("interfaceelasped", stringBuilder.toString());
            if ("103000".equals(param1String1)) {
              param1String1 = param1JSONObject.optString("resultdata");
              if (TextUtils.isEmpty(param1String1) || param1String1.equals("")) {
                param1String1 = param1JSONObject.toString();
              } else {
                param1String1 = com.cmic.sso.sdk.utils.a.b(this.a.getString(com.cmic.sso.sdk.a.a.a), param1String1);
              } 
              try {
                JSONObject jSONObject = new JSONObject(param1String1);
                param1String1 = jSONObject.optString("phonescrip");
                try {
                  f.b("phonescrip", param1String1);
                  a.a(this.d, jSONObject, param1String1, this.a);
                  String str2 = jSONObject.optString("securityphone");
                  try {
                    p.a("securityphone", str2);
                    str = jSONObject.optString("openId");
                    try {
                      String str4 = jSONObject.optString("sourceid");
                      String str3 = str;
                      try {
                        p.a("sourceid", str4);
                        param1String2 = str;
                        str3 = str;
                        if (str.isEmpty()) {
                          str3 = str;
                          param1String2 = jSONObject.optString("pcid");
                        } 
                        str3 = param1String2;
                        p.a("allcapaids", jSONObject.optString("capaids", "acd"));
                        str3 = param1String2;
                        p.a("validated", true);
                        str = param1String2;
                      } catch (JSONException jSONException) {
                        param1String2 = str4;
                        str4 = param1String1;
                        param1String1 = str3;
                      } 
                    } catch (JSONException jSONException) {
                      param1String2 = null;
                      String str3 = param1String1;
                      param1String1 = str;
                    } 
                  } catch (JSONException jSONException) {
                    String str3 = param1String1;
                  } 
                } catch (JSONException jSONException) {}
              } catch (JSONException jSONException) {
                param1String1 = null;
              } 
              param1JSONObject = null;
              String str1 = param1String1;
            } 
            this.c.a(param1String1, param1String2, this.a, param1JSONObject);
          }
        });
  }
  
  public void a(Bundle paramBundle, b paramb) {
    p.a("tokentimes", System.currentTimeMillis());
    long l = SystemClock.elapsedRealtime();
    f.c("AuthBusiness", "获取平台token》》》》");
    l.a(true);
    if (paramBundle.getInt("logintype") == 1)
      paramBundle.putString("userCapaid", "200"); 
    this.a.a(paramBundle, new b(this, paramBundle, l, paramb) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("获取平台token 》》》》");
            stringBuilder1.append(param1JSONObject.toString());
            f.c("AuthBusiness", stringBuilder1.toString());
            String str = this.a.getString("interfacecode", "");
            Bundle bundle = this.a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(param1String1);
            stringBuilder2.append(";");
            bundle.putString("interfacecode", stringBuilder2.toString());
            if (param1String1.equals("103000")) {
              str = param1JSONObject.optString("phonescrip");
              this.a.putString("phonescrip", str);
              a.a(this.d, param1JSONObject, str, this.a);
              str = param1JSONObject.optString("openId");
              this.a.putString("openId", str);
            } 
            long l1 = SystemClock.elapsedRealtime();
            long l2 = this.b;
            str = this.a.getString("interfaceelasped", "");
            bundle = this.a;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(l1 - l2);
            stringBuilder2.append(";");
            bundle.putString("interfaceelasped", stringBuilder2.toString());
            this.c.a(param1String1, param1String2, this.a, param1JSONObject);
          }
        });
  }
  
  public void a(Bundle paramBundle, String paramString, b paramb) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("进行取号查询》》》》authtype=");
    stringBuilder.append(paramString);
    f.c("AuthBusiness", stringBuilder.toString());
    paramString = this.b.getPackageName();
    String str = h.a(q.a(this.b));
    paramBundle.putString("apppackage", paramString);
    paramBundle.putString("appsign", str);
    paramString = UUID.randomUUID().toString().substring(0, 16);
    paramBundle.putString(com.cmic.sso.sdk.a.a.a, paramString);
    paramBundle.putInt("networkType", t.a(this.b));
    paramBundle.putString("authtype", "3");
    b(paramBundle, paramb);
  }
  
  void a(String paramString, Bundle paramBundle, b paramb) {
    JSONObject jSONObject;
    int i = paramBundle.getInt("logintype", 0);
    if (paramBundle.getBoolean("isCacheScrip", false)) {
      if (i == 3) {
        jSONObject = new JSONObject();
        try {
          jSONObject.put("resultCode", "103000");
          jSONObject.put("desc", "true");
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        paramb.a("103000", "true", paramBundle, jSONObject);
        return;
      } 
      String str = l.a(this.b);
      if (TextUtils.isEmpty(str)) {
        paramBundle.putBoolean("isCacheScrip", false);
        if (paramBundle.getInt("networkType") == 2) {
          paramb.a("200027", "无数据网络", paramBundle, null);
          return;
        } 
        a(paramBundle, (String)jSONObject, paramb);
        return;
      } 
      paramBundle.putString("sourceid", p.b("sourceid", ""));
      paramBundle.putString("phonescrip", str);
      if (1 == i) {
        paramBundle.putString("securityphone", p.b("securityphone", ""));
        paramb.a("103000", "显示登录取号成功", paramBundle, null);
        return;
      } 
      a(paramBundle, paramb);
      return;
    } 
    a(paramBundle, (String)jSONObject, paramb);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\auth\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */