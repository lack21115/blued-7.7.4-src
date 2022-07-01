package com.geetest.onelogin.g.b;

import android.text.TextUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.g.a;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.p;
import org.json.JSONObject;

public class a extends a {
  public a(d paramd) {
    super(paramd);
  }
  
  public void d() {
    CtAuth.getInstance().init(com.geetest.onelogin.f.a.a(), this.a.getTokenId(), this.a.getTokenKey(), new b());
    long l = System.currentTimeMillis();
    CtAuth.getInstance().requestPreLogin(new CtSetting(this.a.getSdkTimeout(), this.a.getSdkTimeout(), this.a.getSdkTimeout()), new ResultListener(this, l) {
          public void onResult(String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("preToken isTimeout=");
            stringBuilder.append(this.b.a.isTimeout());
            c.a(stringBuilder.toString());
            p.a().b("PRE_GET_TOKEN:O");
            if (this.b.a.isTimeout())
              return; 
            this.b.a.setPreGetTokenTime(System.currentTimeMillis() - this.a);
            stringBuilder = new StringBuilder();
            stringBuilder.append(a.a(this.b));
            stringBuilder.append("运营商预取号返回结果为: ");
            stringBuilder.append(param1String);
            h.b(stringBuilder.toString());
            try {
              JSONObject jSONObject1 = new JSONObject(param1String);
              int i = jSONObject1.getInt("result");
              jSONObject1.put("operator_error_code", i);
              d d = this.b.a;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(i);
              stringBuilder1.append("");
              d.setMessage(stringBuilder1.toString());
              JSONObject jSONObject2 = jSONObject1.getJSONObject("data");
              String str2 = jSONObject2.getString("accessCode");
              this.b.a.setAccessCode(str2);
              str2 = jSONObject2.getString("number");
              this.b.a.setGwAuth(jSONObject2.getString("gwAuth"));
              String str1 = str2.replaceAll(" ", "");
              if (!TextUtils.isEmpty(str1)) {
                this.b.a.setNumber(str1);
                this.b.a.setCtPreResult(param1String);
                a.a(this.b, true);
                return;
              } 
              a.a(this.b, com.geetest.onelogin.b.a.o, jSONObject1, true);
              return;
            } catch (Exception exception) {
              a.a(this.b, com.geetest.onelogin.b.a.o, param1String);
              return;
            } 
          }
        });
  }
  
  public void e() {
    this.a.setRequestTokenTime(0L);
    String str = this.a.getCtPreResult();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append("运营商取号返回结果为: ");
    stringBuilder.append(str);
    h.b(stringBuilder.toString());
    try {
      int i = (new JSONObject(str)).getInt("result");
      d d = this.a;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(i);
      stringBuilder1.append("");
      d.setMessage(stringBuilder1.toString());
      this.a.setToken(a(this.a.getAccessCode()));
      a(false);
    } catch (Exception exception) {
      b(com.geetest.onelogin.b.a.p, str);
    } 
    p.a().b("requestToken");
  }
  
  public void f() {
    super.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */