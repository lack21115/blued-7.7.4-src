package com.geetest.onelogin.i;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.a.e;
import com.geetest.onelogin.a.f;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.d.c;
import com.geetest.onelogin.d.e;
import com.geetest.onelogin.e.a;
import com.geetest.onelogin.e.a.e;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.g;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.l;
import com.geetest.onelogin.j.p;
import com.geetest.onelogin.listener.a.a;
import com.geetest.onelogin.listener.c;
import com.geetest.onelogin.listener.d;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends AsyncTask<String, Void, String> {
  private Context a;
  
  private d b;
  
  private boolean c;
  
  private d d;
  
  private volatile boolean e = false;
  
  public b(Context paramContext, d paramd, d paramd1) {
    this.a = paramContext;
    this.b = paramd;
    this.d = paramd1;
  }
  
  private e a(String paramString, JSONObject paramJSONObject) {
    e e = new e();
    try {
      e.a(paramString);
      e.b(paramJSONObject.getString("get_token_id"));
      e.c(paramJSONObject.getString("get_token_key"));
      e.a(paramJSONObject.getInt("expire_time"));
      return e;
    } catch (Exception exception) {
      return e;
    } 
  }
  
  private JSONObject d(String paramString) {
    JSONObject jSONObject;
    try {
      JSONObject jSONObject1 = new JSONObject(paramString);
      int i = jSONObject1.getInt("status");
      String str3 = jSONObject1.getString("error_msg");
      String str1 = this.b.getAppId();
      String str2 = this.a.getPackageName();
      String str4 = e.a(this.a);
      if (i == 11100) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append("(APP_ID 用错了), 当前产品ID APP_ID:");
        stringBuilder.append(str1);
        stringBuilder.append(", 包名 pkgName:");
        stringBuilder.append(str2);
        stringBuilder.append(", 包签名 Sign:");
        stringBuilder.append(str4);
        h.c(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("The pkgName ");
        stringBuilder.append(str2);
        stringBuilder.append(" and APP_ID ");
        stringBuilder.append(str1);
        stringBuilder.append(" is not matched, the APP_ID is wrong");
        jSONObject1.put("msg", stringBuilder.toString());
        return jSONObject1;
      } 
      jSONObject = jSONObject1;
      if (i == 11102) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append("(应用包名与管理后台配置的包名不一致), 当前产品ID APP_ID:");
        stringBuilder.append(str1);
        stringBuilder.append(", 包名 pkgName:");
        stringBuilder.append(str2);
        stringBuilder.append(", 包签名 Sign:");
        stringBuilder.append(str4);
        h.c(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("The pkgName ");
        stringBuilder.append(str2);
        stringBuilder.append(" and APP_ID ");
        stringBuilder.append(str1);
        stringBuilder.append(" is not matched, the pkgName is wrong");
        jSONObject1.put("msg", stringBuilder.toString());
        return jSONObject1;
      } 
    } catch (Exception exception) {
      jSONObject = new JSONObject();
    } 
    return jSONObject;
  }
  
  public String a() {
    JSONObject jSONObject = new JSONObject();
    try {
      boolean bool;
      jSONObject.put("app_id", this.b.getAppId());
      jSONObject.put("risk_info", c.b(this.a));
      if (com.geetest.onelogin.f.b.w().k()) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put("pre_token_type", bool);
      jSONObject.put("sdk", "2.1.4.1");
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("pre_get_token JSON 构造错误: ");
      stringBuilder1.append(jSONException.toString());
      h.c(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pre_get_token opsalt=");
    stringBuilder.append(jSONObject);
    c.a(stringBuilder.toString());
    return jSONObject.toString();
  }
  
  protected String a(String... paramVarArgs) {
    if (isCancelled())
      return null; 
    this.e = false;
    this.c = com.geetest.onelogin.f.b.w().m().b() ^ true;
    p.a().a("PRE_GET_TOKEN:G");
    return this.c ? b() : null;
  }
  
  protected void a(String paramString) {
    p.a().b("PRE_GET_TOKEN:G");
    if (isCancelled()) {
      h.b("请求被关闭");
      this.e = true;
      return;
    } 
    if (this.c)
      b(paramString); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PreGetTokenTask onPostExecute isHasIdKey=");
    stringBuilder.append(com.geetest.onelogin.f.b.w().m().b());
    c.a(stringBuilder.toString());
    p.a().a("PRE_GET_TOKEN:O");
    if (com.geetest.onelogin.f.b.w().m().b()) {
      d d1 = this.d;
      if (d1 != null)
        d1.a(this.b); 
    } 
    this.e = true;
  }
  
  public String b() {
    String str1 = c(a());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(System.currentTimeMillis() / 1000L);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    String str3 = this.b.getProcessId();
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.b.getAppId());
    stringBuilder1.append("1");
    stringBuilder1.append(str3);
    stringBuilder1.append(str2);
    stringBuilder1.append("2.1.4.1");
    stringBuilder1.append(str1);
    String str4 = e.a(stringBuilder1.toString(), l.b(str3));
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("opsalt", str1);
      jSONObject.put("clienttype", "1");
      jSONObject.put("sdk", "2.1.4.1");
      jSONObject.put("timestamp", str2);
      jSONObject.put("process_id", str3);
      jSONObject.put("sign", str4);
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pre_get_token opsalt JSON构造错误: ");
      stringBuilder.append(jSONException.toString());
      h.c(stringBuilder.toString());
    } 
    p.a().b("PRE_GET_TOKEN:P");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("requestPost jsonObject=");
    stringBuilder2.append(jSONObject);
    c.a(stringBuilder2.toString());
    return g.a(g.a(this.b.getApiServer(), "/pre_get_token"), jSONObject, 10000);
  }
  
  public void b(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      c.b(this.b, a.a(a.q, this.b, a.a("Currently pre_get_token request error")), true);
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("pre_get_token result=");
    stringBuilder2.append(paramString);
    c.a(stringBuilder2.toString());
    String str = a.c(paramString, this.b.getRandom());
    if (TextUtils.isEmpty(str)) {
      JSONObject jSONObject = d(paramString);
      c.b(this.b, a.a(a.r, this.b, a.a(jSONObject.toString())), true);
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("pre_get_token value=");
    stringBuilder1.append(str);
    c.a(stringBuilder1.toString());
    h.b("pre_get_token 请求完成");
    try {
      JSONObject jSONObject = new JSONObject(str);
      if (jSONObject.getInt("status") == 200) {
        String str1;
        stringBuilder1 = null;
        if (jSONObject.has("cu_channel"))
          str1 = jSONObject.getString("cu_channel"); 
        boolean bool = TextUtils.isEmpty(str1);
        if (!bool) {
          str1 = str1.toLowerCase();
        } else {
          str1 = "cu";
        } 
        f f = com.geetest.onelogin.f.b.w().m();
        f.a("cm", a("CM", jSONObject.getJSONObject("cm")));
        f.a("cu", a("CU", jSONObject.getJSONObject("cu")));
        f.a("ct", a("CT", jSONObject.getJSONObject("ct")));
        if ("cucc".equals(str1)) {
          f.a("cucc", a("CUCC", jSONObject.getJSONObject("cucc")));
          f.d(str1);
        } else {
          f.d("cu");
        } 
        f.a(true);
        h.b("pre_get_token 获取配置完成");
        return;
      } 
      c.b(this.b, a.a(a.q, this.b, jSONObject), true);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pre_get_token 接口返回值异常,错误信息为: ");
      stringBuilder.append(exception.toString());
      h.c(stringBuilder.toString());
      try {
        c.b(this.b, a.a(a.q, this.b, new JSONObject(str)), true);
        return;
      } catch (JSONException jSONException) {
        c.b(this.b, a.a(a.q, this.b, a.a(str)), true);
        return;
      } 
    } 
  }
  
  public String c(String paramString) {
    return a.b(paramString, this.b.getRandom());
  }
  
  public boolean c() {
    return this.e;
  }
  
  protected void onCancelled() {
    super.onCancelled();
    this.e = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */