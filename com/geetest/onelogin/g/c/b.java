package com.geetest.onelogin.g.c;

import com.geetest.onelogin.a.d;
import com.geetest.onelogin.f.a;
import com.unicom.xiaowo.account.shield.ResultListener;
import com.unicom.xiaowo.account.shield.UniAccountHelper;

public class b extends a {
  private b(d paramd) {
    super(paramd);
    UniAccountHelper.getInstance().init(a.a(), paramd.getTokenId(), paramd.getTokenKey());
  }
  
  public static b a(d paramd) {
    return new b(paramd);
  }
  
  public void d() {
    super.d();
    UniAccountHelper.getInstance().login(this.a.getSdkTimeout(), new ResultListener(this) {
          public void onResult(String param1String) {
            this.a.b(param1String);
          }
        });
  }
  
  public void e() {
    super.e();
    d(this.a.getCuPreResult(), "accessCode");
  }
  
  public void f() {
    super.f();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\g\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */