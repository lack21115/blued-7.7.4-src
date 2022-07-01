package com.geetest.onelogin.g.c;

import android.text.TextUtils;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.g.a;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.p;
import org.json.JSONObject;

public abstract class a extends a {
  protected long c;
  
  a(d paramd) {
    super(paramd);
  }
  
  protected void b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("preToken isTimeout=");
    stringBuilder.append(this.a.isTimeout());
    c.a(stringBuilder.toString());
    p.a().b("PRE_GET_TOKEN:O");
    if (this.a.isTimeout())
      return; 
    this.a.setCuPreResult(null);
    this.a.setPreGetTokenTime(System.currentTimeMillis() - this.c);
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("运营商预取号返回结果为: ");
    stringBuilder.append(paramString);
    h.b(stringBuilder.toString());
    try {
      JSONObject jSONObject1 = new JSONObject(paramString);
      int i = jSONObject1.getInt("resultCode");
      jSONObject1.put("operator_error_code", i);
      d d = this.a;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(i);
      stringBuilder1.append("");
      d.setMessage(stringBuilder1.toString());
      JSONObject jSONObject2 = jSONObject1.getJSONObject("resultData");
      String str2 = jSONObject2.getString("accessCode");
      this.a.setAccessCode(str2);
      String str1 = jSONObject2.getString("mobile").replaceAll(" ", "");
      if (!TextUtils.isEmpty(str1)) {
        this.a.setNumber(str1);
        this.a.setCuPreResult(paramString);
        a(true);
        return;
      } 
      a(com.geetest.onelogin.b.a.m, jSONObject1, true);
      return;
    } catch (Exception exception) {
      a(com.geetest.onelogin.b.a.m, paramString);
      return;
    } 
  }
  
  public void d() {
    this.c = System.currentTimeMillis();
  }
  
  protected void d(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("request isTimeout=");
    stringBuilder.append(this.a.isTimeout());
    c.a(stringBuilder.toString());
    p.a().b("requestToken");
    if (this.a.isTimeout())
      return; 
    if (a())
      return; 
    this.a.setRequestTokenTime(System.currentTimeMillis() - this.c);
    stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("运营商取号返回结果为: ");
    stringBuilder.append(paramString1);
    h.b(stringBuilder.toString());
    try {
      JSONObject jSONObject = new JSONObject(paramString1);
      String str1 = jSONObject.optString("resultCode");
      String str2 = jSONObject.optString("resultData");
      d d = this.a;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("");
      d.setMessage(stringBuilder1.toString());
      jSONObject.put("operator_error_code", str1);
      if (!TextUtils.isEmpty(str2)) {
        paramString2 = (new JSONObject(str2)).optString(paramString2);
        this.a.setToken(a(paramString2));
      } 
      this.a.setGwAuth("0000");
      if ("0".equals(str1)) {
        a(false);
        return;
      } 
      a(com.geetest.onelogin.b.a.n, jSONObject, false);
      return;
    } catch (Exception exception) {
      b(com.geetest.onelogin.b.a.n, paramString1);
      return;
    } 
  }
  
  public void e() {
    this.c = System.currentTimeMillis();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */