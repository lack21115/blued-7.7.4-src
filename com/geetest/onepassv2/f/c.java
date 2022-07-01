package com.geetest.onepassv2.f;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.c.a;
import com.geetest.onelogin.e.a.a;
import com.geetest.onelogin.j.b;
import com.geetest.onelogin.j.h;
import com.geetest.onepassv2.a.a;
import com.geetest.onepassv2.b.d;
import com.geetest.onepassv2.e.b;
import com.geetest.onepassv2.g.a;
import com.geetest.onepassv2.listener.OnePassListener;
import com.geetest.onepassv2.listener.a;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends AsyncTask<String, Void, String> {
  private a a;
  
  private OnePassListener b;
  
  private Context c;
  
  private b d;
  
  public c(a parama, Context paramContext, OnePassListener paramOnePassListener) {
    this.a = parama;
    this.c = paramContext;
    this.b = paramOnePassListener;
  }
  
  private String b() {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("custom", this.a.A());
      jSONObject.put("sdk_operator", this.a.C());
      boolean bool = TextUtils.isEmpty(this.a.D());
      if (bool) {
        jSONObject.put("phone", "");
        jSONObject.put("phone_header", "");
        jSONObject.put("algorithm", false);
      } else {
        jSONObject.put("phone", this.a.z());
        jSONObject.put("phone_header", this.a.D().substring(0, 5));
        if (this.b.onAlgorithmSelf()) {
          h.b("设置了用户自定义手机号加密");
          jSONObject.put("algorithm", true);
        } else {
          jSONObject.put("algorithm", this.b.onAlgorithm());
        } 
      } 
      if (a.b())
        jSONObject.put("deepknow_session_id", a.a()); 
      jSONObject.put("clienttype", "1");
      String str = b.a(System.currentTimeMillis());
      this.a.a(str);
      jSONObject.put("clienttime", str);
      jSONObject.put("sdk", "2.1.4.1");
      jSONObject.put("risk_info", com.geetest.onelogin.d.c.a(this.c));
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("PreGateWay JSON 构造错误: ");
      stringBuilder1.append(exception.toString());
      h.c(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PreGateWay JSON 请求参数: ");
    stringBuilder.append(jSONObject);
    com.geetest.onelogin.j.c.a(stringBuilder.toString());
    return d.a(jSONObject.toString(), this.a.y());
  }
  
  protected String a(String... paramVarArgs) {
    if (isCancelled())
      return null; 
    String str = b();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("opsalt", str);
    } catch (JSONException jSONException) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("PreGateWay opsalt JSON构造错误: ");
      stringBuilder1.append(jSONException.toString());
      h.c(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.d());
    stringBuilder.append("/v2.0/pre_gateway");
    return a.a(stringBuilder.toString(), jSONObject, null, this.a.b());
  }
  
  public void a() {
    b b1 = this.d;
    if (b1 != null)
      b1.a(); 
    if (this.b != null)
      this.b = null; 
  }
  
  protected void a(String paramString) {
    OnePassListener onePassListener;
    h.b("PreGateWay 请求结束");
    if (isCancelled())
      return; 
    if (TextUtils.isEmpty(paramString)) {
      h.c("PreGateWay 请求错误");
      a.a(this.b, a.v, "PreGateWay request error", this.a);
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PreGateWay 请求成功: ");
    stringBuilder.append(paramString);
    h.b(stringBuilder.toString());
    String str = a.c(paramString, this.a.y());
    if (TextUtils.isEmpty(str)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("PreGateWay 接口返回值解密错误: ");
      stringBuilder1.append(paramString);
      h.c(stringBuilder1.toString());
      onePassListener = this.b;
      String str1 = a.w;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("PreGateWay interface return value decryption error: ");
      stringBuilder2.append(paramString);
      a.a(onePassListener, str1, stringBuilder2.toString(), this.a);
      return;
    } 
    try {
      StringBuilder stringBuilder1;
      JSONObject jSONObject = new JSONObject((String)onePassListener);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("PreGateWay 请求结果: ");
      stringBuilder2.append(jSONObject);
      com.geetest.onelogin.j.c.a(stringBuilder2.toString());
      if (jSONObject.getInt("status") == 200) {
        this.a.A(jSONObject.getString("process_id"));
        String str1 = jSONObject.getString("real_operator");
        this.a.t(str1);
        this.a.u(jSONObject.getString("operator_url"));
        this.a.v(jSONObject.getString("id"));
        this.a.w(jSONObject.getString("key"));
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("PreGateWay 请求成功, 开始向运营商发送请求.运营商为: ");
        stringBuilder1.append(str1);
        h.b(stringBuilder1.toString());
        this.d = new b(this.a, this.b, this.c);
        this.d.b();
        return;
      } 
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("PreGateWay 接口返回错误: ");
      stringBuilder2.append((String)onePassListener);
      h.c(stringBuilder2.toString());
      a.a(this.b, a.x, (JSONObject)stringBuilder1, this.a);
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("PreGateWay 接口返回值异常, 错误信息为: ");
      stringBuilder1.append(exception.toString());
      h.c(stringBuilder1.toString());
      try {
        a.a(this.b, a.x, new JSONObject((String)onePassListener), this.a);
        return;
      } catch (JSONException jSONException) {
        a.a(this.b, a.x, (String)onePassListener, this.a);
        return;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onepassv2\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */