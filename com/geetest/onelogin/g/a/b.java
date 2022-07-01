package com.geetest.onelogin.g.a;

import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.cmic.sso.sdk.utils.p;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.f.a;
import com.geetest.onelogin.g.a;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.p;
import org.json.JSONObject;

public class b extends a {
  public b(d paramd) {
    super(paramd);
  }
  
  public void d() {
    AuthnHelper.setDebugMode(com.geetest.onelogin.f.b.w().a());
    long l = System.currentTimeMillis();
    int i = this.a.getSdkTimeout();
    AuthnHelper authnHelper = AuthnHelper.getInstance(a.a());
    authnHelper.setOverTime(i);
    a.a(a.a(), authnHelper, this.a.getTokenId(), this.a.getTokenKey(), new TokenListener(this, l) {
          public void onGetTokenComplete(int param1Int, JSONObject param1JSONObject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("preToken isTimeout=");
            stringBuilder.append(this.b.a.isTimeout());
            c.a(stringBuilder.toString());
            p.a().b("PRE_GET_TOKEN:O");
            if (this.b.a.isTimeout())
              return; 
            this.b.a.setPreGetTokenTime(System.currentTimeMillis() - this.a);
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.a(this.b));
            stringBuilder.append("运营商预取号返回结果为: ");
            stringBuilder.append(param1JSONObject.toString());
            h.b(stringBuilder.toString());
            try {
              String str = param1JSONObject.getString("resultCode");
              param1JSONObject.put("operator_error_code", str);
              this.b.a.setMessage(str);
              this.b.a.setNumber(p.b("securityphone", ""));
              if ("true".equals(param1JSONObject.getString("desc"))) {
                b.a(this.b, true);
                return;
              } 
              b.a(this.b, a.k, param1JSONObject, true);
              return;
            } catch (Exception exception) {
              b.b(this.b, a.k, param1JSONObject, true);
              return;
            } 
          }
        });
  }
  
  public void e() {
    long l = System.currentTimeMillis();
    a.b(a.a(), AuthnHelper.getInstance(a.a()), this.a.getTokenId(), this.a.getTokenKey(), new TokenListener(this, l) {
          public void onGetTokenComplete(int param1Int, JSONObject param1JSONObject) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("preToken isTimeout=");
            stringBuilder.append(this.b.a.isTimeout());
            c.a(stringBuilder.toString());
            p.a().b("requestToken");
            if (this.b.a.isTimeout())
              return; 
            if (this.b.a())
              return; 
            this.b.a.setRequestTokenTime(System.currentTimeMillis() - this.a);
            stringBuilder = new StringBuilder();
            stringBuilder.append(b.b(this.b));
            stringBuilder.append("运营商取号返回结果为: ");
            stringBuilder.append(param1JSONObject.toString());
            h.b(stringBuilder.toString());
            try {
              String str = param1JSONObject.getString("resultCode");
              param1JSONObject.put("operator_error_code", str);
              this.b.a.setMessage(str);
              str = param1JSONObject.getString("token");
              this.b.a.setToken(b.a(this.b, str));
              this.b.a.setGwAuth("0000");
              b.b(this.b, false);
            } catch (Exception exception) {
              b.c(this.b, a.l, param1JSONObject, false);
            } 
            p.a().b("requestToken");
          }
        });
  }
  
  public void f() {
    super.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */