package com.geetest.onelogin.i;

import android.content.Context;
import android.content.Intent;
import com.geetest.onelogin.activity.OneLoginActivity;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.g.a;
import com.geetest.onelogin.g.b;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.j;
import com.geetest.onelogin.j.n;
import com.geetest.onelogin.j.p;
import com.geetest.onelogin.listener.a;
import com.geetest.onelogin.listener.a.a;
import com.geetest.onelogin.listener.c;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class d {
  private Context a;
  
  private com.geetest.onelogin.a.d b;
  
  private a c;
  
  public d(Context paramContext, com.geetest.onelogin.a.d paramd) {
    this.a = paramContext;
    this.b = paramd;
  }
  
  private void a(Class paramClass) {
    Context context = this.a;
    if (context == null) {
      h.c("context is null");
      return;
    } 
    Intent intent = new Intent(context, paramClass);
    intent.addFlags(268435456);
    this.a.startActivity(intent);
  }
  
  private void b(boolean paramBoolean) {
    if (paramBoolean) {
      if (b.w().k() && c(true))
        return; 
      a(OneLoginActivity.class);
      return;
    } 
    if (this.c != null) {
      if (c(false))
        return; 
      d();
    } 
  }
  
  private boolean c(boolean paramBoolean) {
    if (j.a(this.b, this.a)) {
      h.c("Sim is changed while requesting token");
      this.b.setPreTokenValidate(false);
      if (paramBoolean) {
        c.a(this.b, a.b(a.d, this.b, a.a("Sim is changed while requesting token")), false);
      } else {
        c.a(this.b, a.d(a.d, this.b, a.a("Sim is changed while requesting token")), false);
      } 
      return true;
    } 
    c.a("Sim is not change");
    return false;
  }
  
  private void d() {
    int i = this.b.getRequestTimeout();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("openAuthOrRequest:Timeout=");
    stringBuilder.append(i);
    c.a(stringBuilder.toString());
    this.b.setState(false);
    this.b.setTimeout(false);
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, n.a());
    scheduledThreadPoolExecutor.schedule(new Runnable(this) {
          public void run() {
            if (d.a(this.a).isState())
              return; 
            d.a(this.a).setTimeout(true);
            p.a().b("requestTokenTimeoutChecker");
            h.c("openAuthOrRequest Timeout");
            c.a(d.a(this.a), a.d(a.c, d.a(this.a), a.a("Time out")), false);
          }
        }i, TimeUnit.MILLISECONDS);
    p.a().a("requestTokenTimeoutChecker");
    b.w().a(scheduledThreadPoolExecutor);
    this.c.c();
  }
  
  public void a() {
    b.w().Q();
    a a1 = this.c;
    if (a1 != null)
      a1.f(); 
  }
  
  public void a(JSONObject paramJSONObject, String paramString) {
    com.geetest.onelogin.a.d d1 = this.b;
    c.a(d1, a.d(paramString, d1, paramJSONObject), false);
  }
  
  public void a(boolean paramBoolean) {
    if (!this.b.isPreTokenSuccess()) {
      c.a(this.b, a.b(a.b, this.b, a.a(b.w().c("openAuthOrRequest"))), false);
      return;
    } 
    if (b.w().k()) {
      if (!this.b.isPreTokenValidate()) {
        c.a(this.b, a.b(a.b, this.b, a.a(b.w().d("pre token is invalid"))), false);
        return;
      } 
      if (this.b.isAccessCodeExpired()) {
        c.a(this.b, a.b(a.b, this.b, a.a(b.w().d("pre token is expired"))), false);
        return;
      } 
    } 
    this.c = b.a(this.b);
    if (this.c == null) {
      com.geetest.onelogin.a.d d1 = this.b;
      String str = a.h;
      com.geetest.onelogin.a.d d2 = this.b;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Currently getting operators error: ");
      stringBuilder.append(this.b.getOperator());
      c.a(d1, a.b(str, d2, a.a(stringBuilder.toString())), false);
      return;
    } 
    b(paramBoolean ^ true);
  }
  
  public void b() {
    b(false);
    a.a().d();
  }
  
  public void c() {
    a.a().c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */