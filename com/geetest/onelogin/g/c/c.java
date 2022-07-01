package com.geetest.onelogin.g.c;

import android.text.TextUtils;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.f.a;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.o;
import com.unicom.xiaowo.login.ResultListener;
import com.unicom.xiaowo.login.TraceLogger;
import com.unicom.xiaowo.login.UniAuthHelper;

public class c extends a {
  private c(d paramd) {
    super(paramd);
    UniAuthHelper.getInstance(a.a()).init(paramd.getSdkTimeout(), paramd.getSdkTimeout(), paramd.getSdkTimeout(), new TraceLogger(this) {
          public void debug(String param1String1, String param1String2) {
            if (!TextUtils.isEmpty(param1String1) && !TextUtils.isEmpty(param1String2))
              h.a(param1String1, param1String2); 
          }
          
          public void error(String param1String1, String param1String2, Throwable param1Throwable) {
            if (!TextUtils.isEmpty(param1String1) && !TextUtils.isEmpty(param1String2))
              h.a(param1String1, param1String2); 
          }
          
          public void info(String param1String1, String param1String2) {
            if (!TextUtils.isEmpty(param1String1) && !TextUtils.isEmpty(param1String2))
              h.a(param1String1, param1String2); 
          }
          
          public void verbose(String param1String1, String param1String2) {
            if (!TextUtils.isEmpty(param1String1) && !TextUtils.isEmpty(param1String2))
              h.a(param1String1, param1String2); 
          }
          
          public void warn(String param1String1, String param1String2, Throwable param1Throwable) {
            if (!TextUtils.isEmpty(param1String1) && !TextUtils.isEmpty(param1String2))
              h.a(param1String1, param1String2); 
          }
        });
  }
  
  public static c a(d paramd) {
    return new c(paramd);
  }
  
  public void d() {
    this.c = System.currentTimeMillis();
    UniAuthHelper.getInstance(a.a()).getLoginPhone(this.a.getTokenId(), this.a.getTokenKey(), new ResultListener(this) {
          public void onResult(String param1String) {
            this.a.b(param1String);
          }
        });
  }
  
  public void e() {
    super.e();
    o.a().a(new Runnable(this) {
          public void run() {
            UniAuthHelper.getInstance(a.a()).getLoginToken(this.a.a.getTokenId(), this.a.a.getTokenKey(), this.a.a.getAccessCode(), new ResultListener(this) {
                  public void onResult(String param2String) {
                    this.a.a.d(param2String, "access_token");
                  }
                });
          }
        });
  }
  
  public void f() {
    super.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */