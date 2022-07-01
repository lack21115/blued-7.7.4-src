package com.cmic.sso.sdk.b.b;

import android.content.Context;
import android.os.Bundle;
import com.cmic.sso.sdk.b.a.b;
import com.cmic.sso.sdk.b.a.c;
import com.cmic.sso.sdk.b.a.f;
import com.cmic.sso.sdk.utils.aa;
import com.cmic.sso.sdk.utils.d;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.i;
import com.cmic.sso.sdk.utils.l;
import com.cmic.sso.sdk.utils.m;
import com.cmic.sso.sdk.utils.o;
import com.cmic.sso.sdk.utils.p;
import com.cmic.sso.sdk.utils.t;
import com.cmic.sso.sdk.utils.v;
import com.cmic.sso.sdk.utils.x;
import com.cmic.sso.sdk.utils.y;
import com.cmic.sso.sdk.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  private static a b;
  
  private Context a;
  
  protected a() {}
  
  protected a(Context paramContext) {
    this.a = paramContext;
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   3: ifnonnull -> 38
    //   6: ldc com/cmic/sso/sdk/b/b/a
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   12: ifnonnull -> 26
    //   15: new com/cmic/sso/sdk/b/b/a
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   26: ldc com/cmic/sso/sdk/b/b/a
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/cmic/sso/sdk/b/b/a
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/cmic/sso/sdk/b/b/a.b : Lcom/cmic/sso/sdk/b/b/a;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  public void a(Context paramContext, Bundle paramBundle, b paramb) {
    int i = paramBundle.getInt("networkType");
    String str1 = paramBundle.getString("authtype", "");
    c c = new c();
    c.a a1 = new c.a();
    a1.e("1.0");
    a1.f("quick_login_android_5.7.2");
    a1.g(paramBundle.getString("appid"));
    a1.h(str1);
    a1.i(paramBundle.getString("smskey", ""));
    a1.j(paramBundle.getString("imsi", ""));
    a1.k(o.a(paramContext).c());
    a1.d(o.a(paramContext).d());
    a1.c(o.a(this.a).b());
    a1.l(paramBundle.getString("operatorType"));
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(i);
    stringBuilder3.append("");
    a1.m(stringBuilder3.toString());
    a1.n(t.a());
    a1.o(t.b());
    a1.p(t.c());
    a1.q("0");
    a1.r(z.a());
    a1.s(v.a());
    a1.t(paramBundle.getString("apppackage"));
    a1.u(paramBundle.getString("appsign"));
    a1.t(paramBundle.getString("apppackage"));
    a1.u(paramBundle.getString("appsign"));
    a1.v(a1.w(paramBundle.getString("appkey")));
    c.a(paramBundle.getString(com.cmic.sso.sdk.a.a.a));
    c.b(m.a().a(paramBundle.getString(com.cmic.sso.sdk.a.a.a)));
    c.a(a1);
    String str3 = paramBundle.getString("interfacetype", "");
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str3);
    stringBuilder3.append("getPrePhonescrip;");
    paramBundle.putString("interfacetype", stringBuilder3.toString());
    paramBundle.putString("interfaceVersion", "7.0");
    paramBundle.putBoolean("isCloseIpv4", x.b());
    paramBundle.putBoolean("isCloseIpv6", x.c());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(x.e());
    stringBuilder2.append("rs/getPrePhonescrip");
    String str2 = stringBuilder2.toString();
    if (i == 3 && str1.equals("3")) {
      aa.a(paramContext);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("使用wifi下取号");
      stringBuilder.append(i);
      f.b("BaseRequest", stringBuilder.toString());
      a(str2, c, true, paramBundle, paramb);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("不使用wifi下取号");
    stringBuilder1.append(i);
    f.b("BaseRequest", stringBuilder1.toString());
    a(str2, c, false, paramBundle, paramb);
  }
  
  public void a(Bundle paramBundle, b paramb) {
    String str2;
    com.cmic.sso.sdk.b.a.a a1 = new com.cmic.sso.sdk.b.a.a();
    com.cmic.sso.sdk.b.a.a.a a2 = new com.cmic.sso.sdk.b.a.a.a();
    a1.f("0.1");
    a1.i(paramBundle.getString("phonescrip"));
    a1.h(paramBundle.getString("appid"));
    a1.g(z.a());
    a1.c(v.a());
    if ("2".equals(paramBundle.getString("authtype"))) {
      a1.d("2.0");
    } else {
      a1.d("6.0");
    } 
    a1.e(paramBundle.getString("userCapaid", "50"));
    a1.a("0");
    a1.b(paramBundle.getString("sourceid"));
    a1.k(paramBundle.getString("authenticated_appid"));
    a1.l(paramBundle.getString("genTokenByAppid"));
    a1.j(a1.m(paramBundle.getString("appkey")));
    a2.a(p.b("AID", ""));
    a2.b(t.c());
    a2.c(t.b());
    a2.d(t.a());
    a2.e(paramBundle.getString("operatorType", ""));
    a2.f("0");
    int i = t.a(this.a);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(i);
    stringBuilder2.append("");
    a2.g(stringBuilder2.toString());
    a2.h(y.a(true));
    a2.i(y.a(false, false));
    if (x.h()) {
      str2 = "0";
    } else {
      str2 = "1";
    } 
    a2.j(str2);
    if (l.a()) {
      a2.k("1");
    } else {
      a2.k("0");
    } 
    a1.a(a2.a());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(x.f());
    stringBuilder1.append("api/getAuthToken");
    String str1 = stringBuilder1.toString();
    com.cmic.sso.sdk.b.c.a.a(x.a(x.f()));
    String str3 = paramBundle.getString("interfacetype", "");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str3);
    stringBuilder3.append("getAuthToken;");
    paramBundle.putString("interfacetype", stringBuilder3.toString());
    paramBundle.putString("interfaceVersion", "6.0");
    a(str1, a1, false, paramBundle, paramb);
  }
  
  public <T extends f> void a(String paramString, T paramT, boolean paramBoolean, Bundle paramBundle, b paramb) {
    JSONObject jSONObject;
    StringBuilder stringBuilder1;
    String str = paramBundle.getString("traceId");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("request https url : ");
    stringBuilder2.append(paramString);
    stringBuilder2.append(">>>>>>> PARAMS : ");
    stringBuilder2.append(paramT.a().toString());
    f.a("BaseRequest", stringBuilder2.toString());
    if (t.a(this.a) == 0) {
      jSONObject = new JSONObject();
      try {
        jSONObject.put("resultCode", "200022");
        jSONObject.put("desc", "网络未连接");
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("request failed , url : ");
      stringBuilder1.append(paramString);
      stringBuilder1.append(">>>>>errorMsg : ");
      stringBuilder1.append(jSONObject.toString());
      f.a("BaseRequest", stringBuilder1.toString());
      if (paramb != null)
        paramb.a("200022", "网络未连接", jSONObject); 
      return;
    } 
    try {
      JSONObject jSONObject1 = new JSONObject();
      jSONObject1.put("timeOut", stringBuilder1.getString("timeOut"));
      jSONObject1.put("imsiState", stringBuilder1.getString("imsiState"));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    (new d()).a(paramString, (f)jSONObject, paramBoolean, new d.a(this, paramString, (Bundle)stringBuilder1, paramb) {
          private boolean e = false;
          
          public void a(String param1String1, String param1String2) {
            if (!this.e) {
              this.e = true;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("request success , url : ");
              stringBuilder.append(this.a);
              stringBuilder.append(">>>>result : ");
              stringBuilder.append(param1String1);
              f.a("BaseRequest", stringBuilder.toString());
              try {
                JSONObject jSONObject = new JSONObject(param1String1);
                if (jSONObject.has("resultCode")) {
                  param1String1 = jSONObject.getString("resultCode");
                } else {
                  param1String1 = jSONObject.getString("resultcode");
                } 
                if (i.a(this.b.getString("traceId")) && !this.a.contains("Config"))
                  return; 
                this.c.a(param1String1, jSONObject.optString("desc"), jSONObject);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                a("200021", "数据解析异常", param1String2);
              } 
            } 
          }
          
          public void a(String param1String1, String param1String2, String param1String3) {
            if (!this.e) {
              this.e = true;
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
              f.a("BaseRequest", stringBuilder.toString());
              if (this.c != null) {
                if (i.a(this.b.getString("traceId")) && !this.a.contains("Config"))
                  return; 
                this.c.a(param1String1, param1String2, jSONObject);
              } 
            } 
          }
        }"POST", str, (Bundle)stringBuilder1);
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle, b paramb) {
    String str;
    b b1 = new b();
    b1.a("1.0");
    b1.b("Android");
    b1.c(p.b("AID", ""));
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    } 
    b1.d(str);
    b1.e("quick_login_android_5.7.2");
    b1.f(paramBundle.getString("appid"));
    b1.g(b1.b());
    a("https://config.cmpassport.com/client/uniConfig", b1, false, paramBundle, paramb);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\b\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */