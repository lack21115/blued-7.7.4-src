package com.geetest.onelogin.i;

import android.text.TextUtils;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.c.a;
import com.geetest.onelogin.e.a;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.j.g;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.l;
import com.geetest.onelogin.j.o;
import org.json.JSONObject;

public class c {
  private static JSONObject a;
  
  public static void a(d paramd) {
    o.a().a(new Runnable(paramd) {
          public void run() {
            JSONObject jSONObject = c.c(this.a);
            h.b("token_record 接口开始请求");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("token_record 接口请求参数: ");
            stringBuilder.append(jSONObject);
            com.geetest.onelogin.j.c.a(stringBuilder.toString());
            String str = g.a(g.a(this.a.getApiServer(), "/token_record"), jSONObject, 15000);
            stringBuilder = new StringBuilder();
            stringBuilder.append("token_record 接口返回: ");
            stringBuilder.append(str);
            h.b(stringBuilder.toString());
          }
        });
  }
  
  public static void a(d paramd, String paramString, JSONObject paramJSONObject) {
    o.a().a(new Runnable(paramd, paramString, paramJSONObject) {
          public void run() {
            c.a(c.c(this.a, this.b, this.c));
          }
        });
  }
  
  public static void b(d paramd) {
    if (a == null)
      return; 
    o.a().a(new Runnable(paramd) {
          public void run() {
            JSONObject jSONObject = c.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("client_report 接口开始请求，请求参数为: ");
            stringBuilder.append(jSONObject.toString());
            h.b(stringBuilder.toString());
            String str = g.a(g.a(this.a.getApiServer(), "/clientreport_onelogin"), jSONObject, 15000);
            stringBuilder = new StringBuilder();
            stringBuilder.append("client_report 接口返回: ");
            stringBuilder.append(str);
            h.b(stringBuilder.toString());
            c.a((JSONObject)null);
          }
        });
  }
  
  public static void b(d paramd, String paramString, JSONObject paramJSONObject) {
    o.a().a(new Runnable(paramd, paramString, paramJSONObject) {
          public void run() {
            JSONObject jSONObject = c.c(this.a, this.b, this.c);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("client_report 接口开始请求，请求参数为: ");
            stringBuilder.append(jSONObject.toString());
            h.b(stringBuilder.toString());
            String str = g.a(g.a(this.a.getApiServer(), "/clientreport_onelogin"), jSONObject, 15000);
            stringBuilder = new StringBuilder();
            stringBuilder.append("client_report 接口返回: ");
            stringBuilder.append(str);
            h.b(stringBuilder.toString());
          }
        });
  }
  
  private static JSONObject d(d paramd) {
    JSONObject jSONObject = new JSONObject();
    try {
      boolean bool;
      String str;
      jSONObject.put("process_id", paramd.getProcessId());
      jSONObject.put("app_id", paramd.getAppId());
      jSONObject.put("clienttype", "1");
      jSONObject.put("sdk", "2.1.4.1");
      if (paramd.getOpBean() != null) {
        str = paramd.getOpBean().a();
      } else {
        str = paramd.getOperator();
      } 
      jSONObject.put("operator", str);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramd.getPreGetTokenTime());
      stringBuilder.append("");
      jSONObject.put("pre_token_time", stringBuilder.toString());
      if (b.w().k()) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put("pre_token_type", bool);
      if (a.b())
        jSONObject.put("deepknow_session_id", a.a()); 
      if (!b.w().d()) {
        JSONObject jSONObject1 = new JSONObject();
        String str2 = paramd.getRandom();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = l.a(b.w().e()); 
        jSONObject1.put("risk_info", com.geetest.onelogin.d.c.a(b.w().b()));
        jSONObject.put("opsalt", a.a(jSONObject1.toString(), str1));
      } 
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  private static JSONObject d(d paramd, String paramString, JSONObject paramJSONObject) {
    JSONObject jSONObject = new JSONObject();
    try {
      boolean bool;
      jSONObject.put("process_id", paramd.getProcessId());
      jSONObject.put("code", paramString);
      jSONObject.put("metadata", paramJSONObject);
      jSONObject.put("app_id", paramd.getAppId());
      jSONObject.put("clienttype", "1");
      jSONObject.put("sdk", "2.1.4.1");
      if (paramd.getOpBean() != null) {
        paramString = paramd.getOpBean().a();
      } else {
        paramString = paramd.getOperator();
      } 
      jSONObject.put("operator", paramString);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramd.getPreGetTokenTime());
      stringBuilder.append("");
      jSONObject.put("pre_token_time", stringBuilder.toString());
      if (b.w().k()) {
        bool = true;
      } else {
        bool = false;
      } 
      jSONObject.put("pre_token_type", bool);
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramd.getRequestTokenTime());
      stringBuilder.append("");
      jSONObject.put("request_token_time", stringBuilder.toString());
      if (paramJSONObject != null)
        if (paramJSONObject.has("operator_error_code")) {
          jSONObject.put("operator_error_code", paramJSONObject.get("operator_error_code"));
        } else if (paramJSONObject.has("resultCode")) {
          jSONObject.put("operator_error_code", paramJSONObject.get("resultCode"));
        } else if (paramJSONObject.has("result")) {
          jSONObject.put("operator_error_code", paramJSONObject.get("result"));
        }  
      if (!b.w().d()) {
        paramJSONObject = new JSONObject();
        String str2 = paramd.getRandom();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
          str1 = l.a(b.w().e()); 
        paramJSONObject.put("risk_info", com.geetest.onelogin.d.c.a(b.w().b()));
        jSONObject.put("opsalt", a.a(paramJSONObject.toString(), str1));
      } 
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */