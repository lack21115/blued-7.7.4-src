package com.ss.android.socialbase.appdownloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c;
import com.ss.android.socialbase.appdownloader.c.g;
import com.ss.android.socialbase.appdownloader.c.i;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.e;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.m;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.k.a;
import com.ss.android.socialbase.downloader.m.f;
import com.ss.android.socialbase.downloader.m.i;
import com.ss.android.socialbase.downloader.m.k;
import com.ss.android.socialbase.downloader.notification.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class b implements m {
  private List<Integer> a;
  
  private BroadcastReceiver b;
  
  private JSONObject a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        return new JSONObject(paramString);
      } finally {} 
    return null;
  }
  
  private void a(Context paramContext, c paramc, boolean paramBoolean) {
    if (paramc != null) {
      g g;
      if (!paramc.ag())
        return; 
      int i = paramc.w();
      if (i == -5 && !paramc.aI()) {
        boolean bool;
        a a = a.a(paramc.g());
        i = a.a("failed_resume_max_count", 0);
        double d1 = a.a("failed_resume_max_hours", 72.0D);
        double d2 = a.a("failed_resume_min_hours", 12.0D);
        long l = System.currentTimeMillis();
        if (paramc.aZ() < i && (l - paramc.bd()) < d1 * 3600000.0D && (l - paramc.ba()) > d2 * 3600000.0D) {
          bool = true;
        } else {
          bool = false;
        } 
        if (bool) {
          boolean bool1;
          if (a.a("failed_resume_need_wifi", 1) == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (a.a("failed_resume_need_wait_wifi", 0) == 1) {
            i = 1;
          } else {
            i = 0;
          } 
          if (paramBoolean || !bool1 || i == 0) {
            a(paramc, bool, bool1);
            paramc.e(l);
            paramc.h(paramc.aZ() + 1);
            paramc.aX();
            paramBoolean = true;
          } else {
            if (this.a == null)
              this.a = new ArrayList<Integer>(); 
            i = paramc.g();
            if (!this.a.contains(Integer.valueOf(i)))
              this.a.add(Integer.valueOf(i)); 
            paramc.c(true);
            r.a().a(paramc);
            paramBoolean = false;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("launchResume, name = ");
          stringBuilder.append(paramc.i());
          stringBuilder.append(", canShowNotification = ");
          stringBuilder.append(bool);
          stringBuilder.append(", downloadResumed = ");
          stringBuilder.append(paramBoolean);
          a.c("LaunchResume", stringBuilder.toString());
          g = d.h().j();
          if (g != null) {
            g.a(paramc, paramBoolean);
            return;
          } 
          return;
        } 
      } else {
        if (i == -3 && a(paramc)) {
          i i1 = d.h().k();
          a a = a.a(paramc.g());
          if (a.a("back_fix_sigbus", 0) == 0 && i1 != null && i1.a() && (a.a("bugfix_sigbus_all_brand", 0) == 1 || i.b())) {
            i = Build.VERSION.SDK_INT;
            if (i >= 21 && i <= 25 && k.a() && !paramc.k().startsWith(Environment.getDataDirectory().getAbsolutePath()))
              return; 
          } 
          String str1 = paramc.k();
          String str2 = paramc.h();
          StringBuilder stringBuilder2 = new StringBuilder();
          stringBuilder2.append("url: ");
          stringBuilder2.append(paramc.j());
          stringBuilder2.append(", backupUrl: ");
          stringBuilder2.append(paramc.K());
          if (c.a((Context)g, str1, str2, stringBuilder2.toString()))
            return; 
          i = a.a("uninstall_resume_max_count", 0);
          double d1 = a.a("uninstall_resume_max_hours", 72.0D);
          double d2 = a.a("uninstall_resume_min_hours", 12.0D);
          long l = System.currentTimeMillis();
          if (paramc.bb() < i && (l - paramc.bd()) < d1 * 3600000.0D && (l - paramc.bc()) > d2 * 3600000.0D) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("uninstallResume, name = ");
          stringBuilder1.append(paramc.i());
          stringBuilder1.append(", canShowNotification = ");
          stringBuilder1.append(paramBoolean);
          a.c("LaunchResume", stringBuilder1.toString());
          if (paramBoolean) {
            a a1;
            a a2 = com.ss.android.socialbase.downloader.notification.b.a().e(paramc.g());
            if (a2 == null) {
              e e = new e((Context)g, paramc.g(), paramc.i(), paramc.k(), paramc.h(), paramc.y());
              com.ss.android.socialbase.downloader.notification.b.a().a((a)e);
            } else {
              a2.a(paramc);
              a1 = a2;
            } 
            a1.b(paramc.ab());
            a1.a(paramc.ab());
            a1.a(paramc.q(), null, false, false);
            paramc.f(l);
            paramc.i(paramc.bb() + 1);
            paramc.aX();
          } 
        } 
        return;
      } 
    } else {
      return;
    } 
    paramBoolean = false;
  }
  
  private void a(c paramc, boolean paramBoolean1, boolean paramBoolean2) {
    g g2 = (new g(com.ss.android.socialbase.downloader.downloader.b.B(), paramc.j())).a(paramc.i()).b(paramc.h()).c(paramc.k()).a(paramc.ag());
    if (paramc.x() || paramBoolean2) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    } 
    g g1 = g2.c(paramBoolean2).d(paramc.y()).e(paramc.ah()).a(paramc.B()).e(true).a(paramc.D()).b(paramc.E()).b(paramc.aC()).c(paramc.aG()).d(paramc.aF()).f(paramBoolean1).d(paramc.ai()).f(paramc.z()).g(paramc.A()).i(paramc.o()).j(paramc.S()).l(paramc.T()).a(paramc.r()).n(paramc.Y()).m(paramc.U()).g(paramc.aj()).h(paramc.ak()).a(a(paramc.M()));
    d.h().a(g1);
  }
  
  private boolean a(c paramc) {
    return a.a(paramc.g()).b("uninstall_can_not_resume_for_force_task", false) ? f.a(paramc, false, paramc.A()) : paramc.aI();
  }
  
  private void b(List<c> paramList) {
    if (paramList != null) {
      if (paramList.isEmpty())
        return; 
      g g = d.h().j();
      if (g != null)
        g.a(paramList); 
      Context context = com.ss.android.socialbase.downloader.downloader.b.B();
      if (context == null)
        return; 
      boolean bool = f.a(context);
      Iterator<c> iterator = paramList.iterator();
      while (iterator.hasNext())
        a(context, iterator.next(), bool); 
      List<Integer> list = this.a;
      if (list != null && !list.isEmpty() && this.b == null) {
        this.b = new BroadcastReceiver(this) {
            public void onReceive(Context param1Context, Intent param1Intent) {
              param1Context = param1Context.getApplicationContext();
              if (!f.a(param1Context))
                return; 
              a.b("LaunchResume", "onReceive : wifi connected !!!");
              com.ss.android.socialbase.downloader.downloader.b.k().execute(new Runnable(this, param1Context) {
                    public void run() {
                      try {
                        if (b.a(this.b.a) != null) {
                          if (b.a(this.b.a).isEmpty())
                            return; 
                          Integer[] arrayOfInteger = new Integer[b.a(this.b.a).size()];
                          b.a(this.b.a).toArray((Object[])arrayOfInteger);
                          b.a(this.b.a).clear();
                          int j = arrayOfInteger.length;
                          for (int i = 0; i < j; i++) {
                            Integer integer = arrayOfInteger[i];
                            c c = f.a(this.a).h(integer.intValue());
                            if (c != null && c.w() == -5)
                              b.a(this.b.a, this.a, c, true); 
                          } 
                        } else {
                          return;
                        } 
                      } catch (Exception exception) {
                        exception.printStackTrace();
                      } 
                    }
                  });
              try {
                param1Context.unregisterReceiver(b.b(this.a));
              } finally {
                param1Context = null;
              } 
            }
          };
        try {
          IntentFilter intentFilter = new IntentFilter();
          return;
        } finally {
          list = null;
          list.printStackTrace();
        } 
      } 
    } 
  }
  
  public List<String> a() {
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("application/vnd.android.package-archive");
    return arrayList;
  }
  
  public void a(List<c> paramList) {
    if (f.d()) {
      com.ss.android.socialbase.downloader.downloader.b.k().execute(new Runnable(this, paramList) {
            public void run() {
              try {
                b.a(this.b, this.a);
                return;
              } catch (Exception exception) {
                exception.printStackTrace();
                return;
              } 
            }
          });
      return;
    } 
    b(paramList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */