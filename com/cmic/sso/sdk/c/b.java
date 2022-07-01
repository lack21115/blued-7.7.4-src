package com.cmic.sso.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.cmic.sso.sdk.b.a.d;
import com.cmic.sso.sdk.b.a.f;
import com.cmic.sso.sdk.b.c.a;
import com.cmic.sso.sdk.utils.d;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.j;
import com.cmic.sso.sdk.utils.l;
import com.cmic.sso.sdk.utils.o;
import com.cmic.sso.sdk.utils.p;
import com.cmic.sso.sdk.utils.t;
import com.cmic.sso.sdk.utils.u;
import com.cmic.sso.sdk.utils.v;
import com.cmic.sso.sdk.utils.x;
import com.cmic.sso.sdk.utils.z;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
  private Bundle a;
  
  private Context b;
  
  private <T extends f> void a(String paramString, T paramT, com.cmic.sso.sdk.b.b.b paramb) {
    if (x.m() == 0 || x.l() == 0 || System.currentTimeMillis() > p.b("logCloseTime", 0L) + x.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("request https url : ");
      stringBuilder.append(x.g());
      stringBuilder.append(">>>>>>> PARAMS : ");
      stringBuilder.append(paramT.a().toString());
      f.a("SendLog", stringBuilder.toString());
      (new d()).a(paramString, (f)paramT, false, new d.a(this, paramString, paramb) {
            public void a(String param1String1, String param1String2) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("request success , url : ");
              stringBuilder.append(this.a);
              stringBuilder.append(">>>>result : ");
              stringBuilder.append(param1String1);
              f.a("SendLog", stringBuilder.toString());
              try {
                JSONObject jSONObject = new JSONObject(param1String1);
                this.b.a(jSONObject.optString("resultCode"), jSONObject.optString("desc"), jSONObject);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                a("200021", "数据解析异常", param1String2);
                return;
              } 
            }
            
            public void a(String param1String1, String param1String2, String param1String3) {
              if (x.m() != 0 && x.l() != 0) {
                int i = p.a("logFailTimes", 0) + 1;
                SharedPreferences.Editor editor = p.a();
                if (i >= x.l()) {
                  editor.putInt("logFailTimes", 0);
                  editor.putLong("logCloseTime", System.currentTimeMillis());
                } else {
                  editor.putInt("logFailTimes", i);
                } 
                editor.commit();
              } 
              JSONObject jSONObject = new JSONObject();
              try {
                jSONObject.put("resultCode", param1String1);
                jSONObject.put("desc", param1String2);
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("request failed , url : ");
              stringBuilder.append(this.a);
              stringBuilder.append(">>>>>errorMsg : ");
              stringBuilder.append(jSONObject.toString());
              f.a("SendLog", stringBuilder.toString());
              com.cmic.sso.sdk.b.b.b b1 = this.b;
              if (b1 != null)
                b1.a(param1String1, param1String2, jSONObject); 
            }
          }"POST", "", this.a);
    } 
  }
  
  private void a(JSONArray paramJSONArray, com.cmic.sso.sdk.b.b.b paramb) {
    d d = new d();
    d.a a = new d.a();
    d.b b1 = new d.b();
    b1.d(z.a());
    b1.e(v.a());
    b1.b(this.a.getString("appid", ""));
    b1.a("2.0");
    b1.c(b1.f());
    JSONArray jSONArray = paramJSONArray;
    if (paramJSONArray == null)
      jSONArray = new JSONArray(); 
    a.a(jSONArray);
    d.a(a);
    d.a(b1);
    String str = x.g();
    a.a(x.a(x.g()));
    a(str, d, paramb);
  }
  
  private void a(JSONObject paramJSONObject) {
    JSONArray jSONArray = new JSONArray();
    jSONArray.put(paramJSONObject);
    a(jSONArray, new com.cmic.sso.sdk.b.b.b(this) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {}
        });
  }
  
  public void a(Context paramContext, String paramString, Bundle paramBundle, Throwable paramThrowable) {
    this.b = paramContext;
    try {
      String str2;
      String str1;
      JSONArray jSONArray1;
      a a = new a();
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("resultCode", paramString);
      StringBuilder stringBuilder4 = null;
      jSONObject.put("PGWResultCode", paramBundle.getString("PGWResultCode", null));
      jSONObject = new JSONObject();
      StringBuilder stringBuilder5 = new StringBuilder();
      stringBuilder5.append(t.a(this.b));
      stringBuilder5.append("");
      a.C(stringBuilder5.toString());
      jSONObject.put("timeOut", paramBundle.getString("timeOut"));
      jSONObject.put("imsiState", paramBundle.getString("imsiState"));
      if (paramBundle.getBoolean("isCacheScrip", false)) {
        a.u("scrip");
      } else {
        a.u("pgw");
      } 
      if ("loginAuth".equals(paramBundle.getString("loginMethod"))) {
        a.z("loginAuth");
      } else if ("mobileAuth".equals(paramBundle.getString("loginMethod"))) {
        a.z("mobileAuth");
      } else {
        a.z("preGetMobile");
      } 
      a.v(paramBundle.getString("traceId"));
      a.A(paramBundle.getString("appid"));
      a.o(j.c(this.b));
      a.p(j.d(this.b));
      a.B("quick_login_android_5.7.2");
      a.l("android");
      a.m(paramBundle.getString("timeOut"));
      a.w(paramBundle.getString("starttime"));
      boolean bool = paramBundle.getBoolean("hsaReadPhoneStatePermission", false);
      String str3 = "1";
      if (bool) {
        str2 = "1";
      } else {
        str2 = "0";
      } 
      a.a(str2);
      long l = System.currentTimeMillis();
      a.y(v.a(l));
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append(l - paramBundle.getLong("starttimemills"));
      stringBuilder3.append("");
      a.k(stringBuilder3.toString());
      a.j(paramBundle.getString("interfacetype", ""));
      paramBundle.putString("interfacetype", "");
      a.f(paramBundle.getString("interfacecode", ""));
      paramBundle.putString("interfacecode", "");
      a.g(paramBundle.getString("interfaceelasped", ""));
      paramBundle.putString("interfaceelasped", "");
      stringBuilder3 = new StringBuilder();
      stringBuilder3.append(paramBundle.getLong("loginTime", 0L));
      stringBuilder3.append("");
      a.h(stringBuilder3.toString());
      a.r(paramBundle.getString("operatorType", ""));
      if (paramBundle.getInt("startnetworkType", 0) == 0) {
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(t.a(this.b));
        stringBuilder3.append("");
        a.C(stringBuilder3.toString());
      } else {
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(paramBundle.getInt("startnetworkType", 0));
        stringBuilder3.append("");
        a.C(stringBuilder3.toString());
      } 
      a.x(paramBundle.getString("networkClass"));
      a.i(t.a());
      a.s(t.b());
      a.t(t.c());
      a.q(paramBundle.getString("simCardNum"));
      a.e(paramString);
      if (l.a()) {
        str1 = str3;
      } else {
        str1 = "0";
      } 
      a.d(str1);
      a.c(paramBundle.getString("imsiState", "0"));
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(System.currentTimeMillis() - paramBundle.getLong("methodTimes", 0L));
      stringBuilder2.append("");
      a.k(stringBuilder2.toString());
      stringBuilder2 = stringBuilder4;
      if (paramThrowable != null) {
        jSONArray1 = new JSONArray();
        JSONObject jSONObject1 = new JSONObject();
        StringBuffer stringBuffer = new StringBuffer();
        for (StackTraceElement stackTraceElement : paramThrowable.getStackTrace()) {
          stringBuffer.append("\n");
          stringBuffer.append(stackTraceElement.toString());
        } 
        jSONObject1.put("message", paramThrowable.toString());
        jSONObject1.put("stack", stringBuffer.toString());
        jSONArray1.put(jSONObject1);
      } 
      JSONArray jSONArray2 = jSONArray1;
      if (a.a.size() > 0) {
        jSONArray2 = jSONArray1;
        if (jSONArray1 == null)
          jSONArray2 = new JSONArray(); 
        for (Throwable paramThrowable : a.a) {
          StringBuffer stringBuffer = new StringBuffer();
          JSONObject jSONObject1 = new JSONObject();
          for (StackTraceElement stackTraceElement : paramThrowable.getStackTrace()) {
            stringBuffer.append("\n");
            stringBuffer.append(stackTraceElement.toString());
          } 
          jSONObject1.put("message", paramThrowable.toString());
          jSONObject1.put("stack", stringBuffer.toString());
          jSONArray2.put(jSONObject1);
        } 
        a.a.clear();
      } 
      if (jSONArray2 != null && jSONArray2.length() > 0)
        a.a(jSONArray2); 
      a.b(p.b("AID", ""));
      a.D(o.a(this.b).f());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("登录日志");
      stringBuilder1.append(a.a());
      f.a("SendLog", stringBuilder1.toString());
      a(this.b, a.a(), paramBundle);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void a(Context paramContext, JSONObject paramJSONObject, Bundle paramBundle) {
    this.a = paramBundle;
    this.b = paramContext;
    u.a(new u.a(this, paramJSONObject) {
          public void a() {
            b.a(this.b, this.a);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */