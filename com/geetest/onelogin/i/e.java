package com.geetest.onelogin.i;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.geetest.onelogin.a.b;
import com.geetest.onelogin.a.d;
import com.geetest.onelogin.a.f;
import com.geetest.onelogin.b.a;
import com.geetest.onelogin.f.b;
import com.geetest.onelogin.g.a;
import com.geetest.onelogin.g.b;
import com.geetest.onelogin.j.b;
import com.geetest.onelogin.j.c;
import com.geetest.onelogin.j.h;
import com.geetest.onelogin.j.i;
import com.geetest.onelogin.j.j;
import com.geetest.onelogin.j.n;
import com.geetest.onelogin.j.p;
import com.geetest.onelogin.listener.a.a;
import com.geetest.onelogin.listener.c;
import com.geetest.onelogin.listener.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class e {
  private Context a;
  
  private b b;
  
  private a c;
  
  private a d;
  
  private ExecutorService e;
  
  public e(Context paramContext) {
    this.a = paramContext;
    this.e = Executors.newCachedThreadPool();
  }
  
  private void a(AsyncTask paramAsyncTask) {
    if (paramAsyncTask != null && !paramAsyncTask.isCancelled() && paramAsyncTask.getStatus() == AsyncTask.Status.RUNNING)
      paramAsyncTask.cancel(true); 
  }
  
  private void c(d paramd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("flowerOperator oneLoginBean=");
    stringBuilder.append(paramd);
    c.a(stringBuilder.toString());
    this.d = b.a(paramd);
    if (this.d == null) {
      String str = a.h;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Currently getting operators error: ");
      stringBuilder1.append(paramd.getOperator());
      c.b(paramd, a.a(str, paramd, a.a(stringBuilder1.toString())), true);
      return;
    } 
    a(this.b);
    a(this.c);
    this.d.b();
  }
  
  public void a() {
    b.w().Q();
    a(this.b);
    a(this.c);
  }
  
  public void a(d paramd) {
    if (!i.a(this.a)) {
      h.c("Current network is unavailable");
      return;
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startPreGetToken oneLoginBean=");
    stringBuilder1.append(paramd);
    stringBuilder1.append(" op=");
    stringBuilder1.append(b.w().m().a());
    c.a(stringBuilder1.toString());
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, n.a());
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("startPreGetToken timeoutService=");
    stringBuilder2.append(scheduledThreadPoolExecutor);
    c.a(stringBuilder2.toString());
    scheduledThreadPoolExecutor.schedule(new Runnable(this, paramd) {
          public void run() {
            p.a().b("preGetTokenTimeoutChecker");
            if (this.a.isState() || b.w().m().b()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("preGetTokenTask timeout, oneLoginBean.isState()=");
              stringBuilder.append(this.a.isState());
              c.a(stringBuilder.toString());
              return;
            } 
            c.b("preGetTokenTask Timeout");
            this.a.setTimeout(true);
            e e1 = this.b;
            e.a(e1, e.a(e1));
          }
        }10000L, TimeUnit.MILLISECONDS);
    p.a().a("preGetTokenTimeoutChecker");
    b.w().a(scheduledThreadPoolExecutor);
    this.b = new b(this.a, paramd, null);
    this.b.executeOnExecutor(this.e, (Object[])new String[0]);
  }
  
  public void b(d paramd) {
    int i;
    String str2;
    if (!b.a(this.a)) {
      c.a(paramd, a.a(a.f, paramd, a.a("Current phone does not have a calling card")), true);
      return;
    } 
    b b2 = j.d(this.a);
    String str1 = b2.a();
    paramd.setOperator(str1);
    if (!i.a(this.a)) {
      c.a(paramd, a.a(a.e, paramd, a.a("Current network is unavailable")), true);
      return;
    } 
    if (!b.b(this.a)) {
      c.a(paramd, a.a(a.g, paramd, a.a("The current mobile phone has a calling card but no data network")), true);
      return;
    } 
    f f = b.w().m();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append("startPreToken oneLoginBean=");
    stringBuilder4.append(paramd);
    stringBuilder4.append(" op=");
    stringBuilder4.append(f.a());
    c.a(stringBuilder4.toString());
    if (TextUtils.isEmpty(f.a())) {
      StringBuilder stringBuilder;
      stringBuilder4 = new StringBuilder();
      stringBuilder4.append("当前判断的运营商为：");
      stringBuilder4.append(str1);
      h.b(stringBuilder4.toString());
      if (TextUtils.isEmpty(str1)) {
        str2 = a.h;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Currently getting operators error:");
        stringBuilder.append(str1);
        c.a(paramd, a.a(str2, paramd, a.a(stringBuilder.toString())), true);
        return;
      } 
      if (!b.a(str1)) {
        str2 = a.h;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Currently getting operators error:");
        stringBuilder.append(str1);
        c.a(paramd, a.a(str2, paramd, a.a(stringBuilder.toString())), true);
        return;
      } 
      str2.b(str1);
      paramd.setOperator(str1);
      paramd.setDataSimBean((b)stringBuilder);
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("当前设置的运营商为：");
      stringBuilder.append(str2.a());
      h.b(stringBuilder.toString());
      paramd.setOperator(str2.a());
    } 
    if (b.w().s()) {
      i = paramd.getSdkTimeout();
    } else {
      i = paramd.getRequestTimeout();
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("startPreToken timeout=");
    stringBuilder2.append(i);
    c.a(stringBuilder2.toString());
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, n.a());
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("startPreToken timeoutService=");
    stringBuilder3.append(scheduledThreadPoolExecutor);
    c.a(stringBuilder3.toString());
    Runnable runnable = new Runnable(this, paramd) {
        public void run() {
          p.a().b("preTokenTimeoutChecker");
          if (this.a.isState()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("preTokenTask timeout, oneLoginBean.isState()=");
            stringBuilder.append(this.a.isState());
            c.a(stringBuilder.toString());
            return;
          } 
          h.c("preTokenTask Timeout");
          this.a.setTimeout(true);
          c.a(this.a, a.a(a.c, this.a, a.a("Time out")), true);
          e e1 = this.b;
          e.a(e1, e.a(e1));
          e1 = this.b;
          e.a(e1, e.b(e1));
        }
      };
    long l = i;
    scheduledThreadPoolExecutor.schedule(runnable, l, TimeUnit.MILLISECONDS);
    p.a().a("preTokenTimeoutChecker");
    b.w().a(scheduledThreadPoolExecutor);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("startPreToken preGetTokenTask=");
    stringBuilder1.append(this.b);
    stringBuilder1.append(", isHasIdKey=");
    stringBuilder1.append(b.w().m().b());
    c.a(stringBuilder1.toString());
    if (this.b != null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("startPreToken isFinished=");
      stringBuilder1.append(this.b.c());
      c.a(stringBuilder1.toString());
    } 
    if (b.w().m().b()) {
      c.a("startPreToken 1");
      c(paramd);
      return;
    } 
    b b1 = this.b;
    if (b1 == null || b1.c()) {
      c.a("startPreToken 2");
      this.b = new b(this.a, paramd, new d(this) {
            public void a(d param1d) {
              e.a(this.a, param1d);
            }
          });
      this.b.executeOnExecutor(this.e, (Object[])new String[0]);
      return;
    } 
    c.a("startPreToken 3");
    this.c = new a(paramd, l, new d(this) {
          public void a(d param1d) {
            e.a(this.a, param1d);
          }
        });
    this.c.executeOnExecutor(this.e, (Object[])new String[0]);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\onelogin\i\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */