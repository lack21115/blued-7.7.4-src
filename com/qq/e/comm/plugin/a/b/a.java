package com.qq.e.comm.plugin.a.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.qq.e.comm.plugin.a.c;
import com.qq.e.comm.plugin.d.d;
import com.qq.e.comm.plugin.util.aw;
import com.qq.e.comm.plugin.util.y;
import java.util.concurrent.Future;

public class a {
  private final c a;
  
  private final c b;
  
  private final NotificationManager c;
  
  private Future<Bitmap> d;
  
  private d e;
  
  private int f = -1;
  
  private long g = System.currentTimeMillis();
  
  private String h;
  
  private int i;
  
  private boolean j = false;
  
  public a(Context paramContext, c paramc) {
    this.a = paramc;
    this.b = c.a(paramContext);
    this.c = d.a(paramContext);
    this.h = paramc.a("notifyTag");
    this.i = paramc.b("notifyId");
  }
  
  private void d() {
    c c1 = this.b;
    if (c1 != null) {
      c1 = c1.a(false);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("正在下载：");
      stringBuilder.append(this.a.f());
      c1.a(stringBuilder.toString());
      f();
    } 
  }
  
  private void e() {}
  
  private void f() {
    if (this.b != null) {
      if (this.j)
        return; 
      Future<Bitmap> future = this.d;
      if (future != null && future.isDone()) {
        this.j = true;
        try {
          Bitmap bitmap = this.d.get();
          return;
        } finally {
          future = null;
        } 
      } 
    } 
  }
  
  public void a() {
    y.a(new Runnable(this) {
          public void run() {
            if (a.a(this.a) != null) {
              a.b(this.a);
              a.a(this.a).b("玩儿命下载中").a(100, 100, true);
              if (a.c(this.a) != null)
                a.a(this.a).a(a.c(this.a).a()); 
              Notification notification = a.a(this.a).a();
              a.d(this.a);
              a.g(this.a).notify(a.e(this.a), a.f(this.a), notification);
            } 
          }
        });
  }
  
  public void a(long paramLong1, long paramLong2) {
    y.a(new Runnable(this, paramLong2, paramLong1) {
          public void run() {
            if (a.a(this.c) != null) {
              byte b;
              long l = this.a;
              if (l > 0L) {
                b = (int)(this.b * 100L / l);
              } else {
                b = 0;
              } 
              l = System.currentTimeMillis();
              if (b - a.h(this.c) > 1 && l - a.i(this.c) > 1000L) {
                a.a(this.c, b);
                a.a(this.c, l);
                a.b(this.c);
                a.a(this.c).a(100, a.h(this.c), false);
                c c = a.a(this.c);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("已完成：");
                stringBuilder.append(aw.c(this.b));
                stringBuilder.append(",总大小：");
                stringBuilder.append(aw.c(this.a));
                c.b(stringBuilder.toString());
                if (a.c(this.c) != null)
                  a.a(this.c).a(a.c(this.c).a()); 
                Notification notification = a.a(this.c).a();
                if (b % 10 == 0)
                  a.d(this.c); 
                a.g(this.c).notify(a.e(this.c), a.f(this.c), notification);
              } 
            } 
          }
        });
  }
  
  public void a(d paramd) {
    this.e = paramd;
  }
  
  public void a(String paramString) {
    y.a(new Runnable(this, paramString) {
          public void run() {
            if (a.a(this.b) != null) {
              c c = a.a(this.b).a(false);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("暂停下载：");
              stringBuilder.append(a.j(this.b).f());
              c.a(stringBuilder.toString());
              a.k(this.b);
              a.a(this.b).a(100, a.h(this.b), false);
              a.a(this.b).b(this.a);
              if (a.c(this.b) != null)
                a.a(this.b).a(a.c(this.b).e()); 
              Notification notification = a.a(this.b).a();
              a.d(this.b);
              a.g(this.b).notify(a.e(this.b), a.f(this.b), notification);
            } 
          }
        });
  }
  
  public void a(Future<Bitmap> paramFuture) {
    this.d = paramFuture;
  }
  
  public void b() {
    y.a(new Runnable(this) {
          public void run() {
            if (a.a(this.a) != null) {
              a.b(this.a);
              a.a(this.a).a(100, 100, false);
              a.a(this.a).b("下载完成点击安装");
              if (a.c(this.a) != null)
                a.a(this.a).a(a.c(this.a).c()); 
              Notification notification = a.a(this.a).a();
              a.d(this.a);
              a.g(this.a).notify(a.e(this.a), a.f(this.a), notification);
            } 
          }
        });
  }
  
  public void b(String paramString) {
    y.a(new Runnable(this, paramString) {
          public void run() {
            if (a.a(this.b) != null) {
              a.b(this.b);
              a.a(this.b).a(100, 100, true);
              a.a(this.b).b(this.a);
              if (a.c(this.b) != null)
                a.a(this.b).a(a.c(this.b).b()); 
              Notification notification = a.a(this.b).a();
              a.d(this.b);
              a.g(this.b).notify(a.e(this.b), a.f(this.b), notification);
            } 
          }
        });
  }
  
  public void c() {
    y.a(new Runnable(this) {
          public void run() {
            if (a.a(this.a) != null) {
              if (a.c(this.a) != null)
                a.a(this.a).a(a.c(this.a).d()); 
              if (a.j(this.a).p() != null)
                a.a(this.a).a(a.j(this.a).p()); 
              a.a(this.a).b("点击启动").a(a.j(this.a).f()).a(false);
              Notification notification = a.a(this.a).a();
              a.d(this.a);
              a.g(this.a).notify(a.e(this.a), a.f(this.a), notification);
            } 
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */