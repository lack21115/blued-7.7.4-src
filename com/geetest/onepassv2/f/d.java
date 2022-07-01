package com.geetest.onepassv2.f;

import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.o;
import com.geetest.onepassv2.a.a;
import com.geetest.onepassv2.g.a;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
  private static String a = "code";
  
  private static String b = "custom_id";
  
  private static String c = "process_id";
  
  private static String d = "metadata";
  
  private static String e = "real_op";
  
  private static String f = "op";
  
  public static void a(String paramString, JSONObject paramJSONObject, a parama) {
    h.b("开始发送 Report 请求");
    o.a().a(new Runnable(parama, paramString, paramJSONObject) {
          public void run() {
            JSONObject jSONObject1 = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
              jSONObject1.put(d.a(), this.a.B());
              jSONObject1.put(d.b(), this.b);
              jSONObject1.put(d.c(), this.a.A());
              jSONObject1.put(d.d(), this.c);
              jSONObject1.put(d.e(), this.a.u());
              jSONObject1.put(d.f(), this.a.C());
              jSONObject1.put("clienttype", "1");
              jSONObject1.put("sdk", "2.1.4.1");
              jSONObject1.put("accesscode_time", this.a.s());
              jSONObject2.put("clientId", this.a.f());
              jSONObject2.put("clientType", this.a.g());
              jSONObject2.put("format", this.a.h());
              jSONObject2.put("version", this.a.n());
              jSONObject2.put("sign", this.a.i());
              jSONObject2.put("paramStr", this.a.j());
              jSONObject2.put("paramKey", this.a.k());
              jSONObject2.put("client_id", this.a.l());
              jSONObject2.put("client_type", this.a.m());
              jSONObject2.put("Authorization", this.a.o());
              jSONObject2.put("packname", this.a.p());
              jSONObject2.put("packsign", this.a.q());
              jSONObject1.put("request_url", this.a.e());
              jSONObject1.put("request_param", jSONObject2);
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("clientreport 接口构造参数: ");
            stringBuilder.append(jSONObject1.toString());
            h.b(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.d());
            stringBuilder.append("/v2.0/clientreport");
            String str = a.a(stringBuilder.toString(), jSONObject1, null, this.a.b());
            stringBuilder = new StringBuilder();
            stringBuilder.append("clientreport 接口返回: ");
            stringBuilder.append(str);
            h.b(stringBuilder.toString());
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */