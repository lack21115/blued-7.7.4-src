package com.geetest.onelogin.g.c;

import android.text.TextUtils;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.f.a;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.p;
import com.unicom.online.account.yjyz.LoginCallback;
import com.unicom.online.account.yjyz.LoginResult;
import com.unicom.online.account.yjyz.YJYZ;
import org.json.JSONObject;

public class d extends a {
  private d(com.geetest.onelogin.a.d paramd) {
    super(paramd);
    YJYZ.init(a.a(), paramd.getTokenId(), paramd.getTokenKey());
    int i = (int)(paramd.getSdkTimeout() / 1000.0D + 0.5D);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CuYJYZ timeout=");
    stringBuilder.append(paramd.getSdkTimeout());
    stringBuilder.append(" set timeout=");
    stringBuilder.append(i);
    c.a(stringBuilder.toString());
    YJYZ.setTimeOut(i);
    YJYZ.setDebugMode(b.w().a());
  }
  
  public static d a(com.geetest.onelogin.a.d paramd) {
    return new d(paramd);
  }
  
  private JSONObject a(LoginResult paramLoginResult) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("result", paramLoginResult.getResult());
      jSONObject.put("token", paramLoginResult.getToken());
      jSONObject.put("mobile", paramLoginResult.getFakeMobile());
      jSONObject.put("operator", paramLoginResult.getOperator());
      jSONObject.put("seq", paramLoginResult.getSeq());
      jSONObject.put("optoken", paramLoginResult.getOpToken());
      return jSONObject;
    } catch (Exception exception) {
      return jSONObject;
    } 
  }
  
  public void d() {
    this.c = System.currentTimeMillis();
    YJYZ.clearCache(a.a());
    YJYZ.login(new LoginCallback(this) {
          public void onComplete(Object param1Object) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("preToken isTimeout=");
            stringBuilder.append(this.a.a.isTimeout());
            c.a(stringBuilder.toString());
            p.a().b("PRE_GET_TOKEN:O");
            if (this.a.a.isTimeout())
              return; 
            stringBuilder = new StringBuilder();
            stringBuilder.append("onComplete oneLoginBean=");
            stringBuilder.append(this.a.a);
            c.a(stringBuilder.toString());
            this.a.a.setCuccResult(null);
            stringBuilder = new StringBuilder();
            stringBuilder.append("onComplete oneLoginBean=");
            stringBuilder.append(this.a.a);
            c.a(stringBuilder.toString());
            if (param1Object instanceof LoginResult) {
              com.geetest.onelogin.a.d d1;
              param1Object = param1Object;
              JSONObject jSONObject = d.a(this.a, (LoginResult)param1Object);
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(d.a(this.a));
              stringBuilder1.append("运营商预取号返回结果为: ");
              stringBuilder1.append(jSONObject);
              h.b(stringBuilder1.toString());
              if (param1Object.getResult().intValue() == 0 && !TextUtils.isEmpty(param1Object.getFakeMobile())) {
                d1 = this.a.a;
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append(param1Object.getResult());
                stringBuilder1.append("");
                d1.setMessage(stringBuilder1.toString());
                this.a.a.setAccessCode(param1Object.getOpToken());
                this.a.a.setNumber(param1Object.getFakeMobile());
                this.a.a.setCuccResult(param1Object);
                d.a(this.a, true);
                return;
              } 
              d.a(this.a, a.m, (JSONObject)d1, true);
              return;
            } 
            if (param1Object instanceof com.unicom.online.account.yjyz.JiYanEntity) {
              param1Object = param1Object;
              stringBuilder = new StringBuilder();
              stringBuilder.append(d.b(this.a));
              stringBuilder.append("运营商预取号返回结果为: {result=");
              stringBuilder.append(param1Object.getResult());
              stringBuilder.append(", body=");
              stringBuilder.append(param1Object.getBody());
              stringBuilder.append(", header=");
              stringBuilder.append(param1Object.getHeader());
              stringBuilder.append(", msg=");
              stringBuilder.append(param1Object.getMsg());
              stringBuilder.append("}");
              h.b(stringBuilder.toString());
              JSONObject jSONObject = new JSONObject();
              try {
                jSONObject.put("result", param1Object.getResult());
                jSONObject.put("body", param1Object.getBody());
                jSONObject.put("header", param1Object.getHeader());
                jSONObject.put("msg", param1Object.getMsg());
              } catch (Exception exception) {}
              d.b(this.a, a.m, jSONObject, true);
              return;
            } 
            stringBuilder = new StringBuilder();
            stringBuilder.append(d.c(this.a));
            stringBuilder.append("运营商预取号返回结果为: ");
            stringBuilder.append(exception);
            h.b(stringBuilder.toString());
            d.a(this.a, a.m, "unknown error");
          }
        });
  }
  
  public void e() {
    super.e();
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("request oneLoginBean=");
    stringBuilder1.append(this.a);
    c.a(stringBuilder1.toString());
    LoginResult loginResult = (LoginResult)this.a.getCuccResult();
    JSONObject jSONObject = a(loginResult);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("request isTimeout=");
    stringBuilder2.append(this.a.isTimeout());
    c.a(stringBuilder2.toString());
    p.a().b("requestToken");
    if (this.a.isTimeout())
      return; 
    if (a())
      return; 
    this.a.setRequestTokenTime(System.currentTimeMillis() - this.c);
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.b);
    stringBuilder2.append("运营商取号返回结果为: ");
    stringBuilder2.append(jSONObject);
    h.b(stringBuilder2.toString());
    try {
      this.a.setOpToken(loginResult.getOpToken());
      this.a.setToken(c(this.a.getOpBean().a(), loginResult.getToken()));
      this.a.setGwAuth("0000");
      a(false);
      return;
    } catch (Exception exception) {
      a(a.n, jSONObject, false);
      return;
    } 
  }
  
  public void f() {
    super.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */