package com.ss.android.downloadlib.a;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.a.a.a.n;
import com.ss.android.a.a.b.b;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.b.d;
import com.ss.android.a.a.b.e;
import com.ss.android.a.a.c.e;
import com.ss.android.downloadad.a.a.c;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.b.e;
import com.ss.android.downloadlib.a.c.d;
import com.ss.android.downloadlib.e.b;
import com.ss.android.downloadlib.e.d;
import com.ss.android.downloadlib.e.g;
import com.ss.android.downloadlib.e.h;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.d.w;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.notification.b;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class f implements g, h.a {
  private static final String a = f.class.getSimpleName();
  
  private final h b = new h(Looper.getMainLooper(), this);
  
  private h c = new h();
  
  private WeakReference<Context> d;
  
  private final Map<Integer, Object> e = new ConcurrentHashMap<Integer, Object>();
  
  private e f;
  
  private c g;
  
  private a h;
  
  private final w i = (w)new h.a(this.b);
  
  private boolean j;
  
  private long k;
  
  private long l = -1L;
  
  private c m = null;
  
  private b n = null;
  
  private com.ss.android.a.a.b.a o = null;
  
  private boolean p;
  
  private void a(c paramc) {
    Message message = Message.obtain();
    message.what = 3;
    message.obj = paramc;
    this.b.sendMessage(message);
  }
  
  private void b(boolean paramBoolean) {
    if (this.c.a(this.p) != 1) {
      d(paramBoolean);
      return;
    } 
    if (paramBoolean)
      com.ss.android.downloadlib.d.a.a().a(this.l, 1); 
    j.c().a(k(), this.m, m(), l());
  }
  
  private boolean b(int paramInt) {
    if (!i())
      return false; 
    byte b1 = -1;
    String str = this.m.y().a();
    if (paramInt != 1) {
      if (paramInt == 2)
        b1 = 4; 
    } else {
      b1 = 5;
    } 
    com.ss.android.downloadlib.d.a.a().a(this.l, paramInt);
    boolean bool = d.c(j.a(), str);
    if (bool) {
      Message message = Message.obtain();
      message.what = b1;
      message.obj = Long.valueOf(this.m.d());
      this.b.sendMessageDelayed(message, d.a().b());
      d.a().a(b1, this.m, this.n);
      return bool;
    } 
    com.ss.android.downloadlib.d.a.a().a(this.l, false, 0);
    return bool;
  }
  
  private void c(boolean paramBoolean) {
    if (paramBoolean)
      com.ss.android.downloadlib.d.a.a().a(this.l, 1); 
    e(paramBoolean);
  }
  
  private void d(boolean paramBoolean) {
    f(paramBoolean);
    this.c.b();
  }
  
  private void e(boolean paramBoolean) {
    com.ss.android.downloadlib.e.f.a(a, "performItemClickWithNewDownloader", null);
    if (this.c.c(this.g)) {
      com.ss.android.downloadlib.e.f.a(a, "performItemClickWithNewDownloader ButtonClick", null);
      f(paramBoolean);
      return;
    } 
    com.ss.android.downloadlib.e.f.a(a, "performItemClickWithNewDownloader onItemClick", null);
    j.c().a(k(), this.m, m(), l());
  }
  
  private void f(boolean paramBoolean) {
    com.ss.android.downloadlib.e.f.a(a, "performButtonClickWithNewDownloader", null);
    c c2 = this.g;
    if (c2 == null || (c2.q() != -3 && !com.ss.android.socialbase.downloader.downloader.f.a(j.a()).d(this.g.g()))) {
      if (paramBoolean)
        com.ss.android.downloadlib.d.a.a().a(this.l, 2); 
      com.ss.android.downloadlib.e.f.a(a, "performButtonClickWithNewDownloader not start", null);
      this.c.a(new n(this) {
            public void a() {
              com.ss.android.downloadlib.e.f.a(f.h(), "performButtonClickWithNewDownloader start download", null);
              f.c(this.a);
            }
            
            public void a(String param1String) {
              com.ss.android.downloadlib.e.f.a(f.h(), "performButtonClickWithNewDownloader onDenied", null);
            }
          });
      return;
    } 
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("performButtonClickWithNewDownloader continue download, status:");
    stringBuilder.append(this.g.q());
    com.ss.android.downloadlib.e.f.a(str, stringBuilder.toString(), null);
    this.c.d(this.g);
    c c1 = this.g;
    if (c1 != null) {
      c c3 = this.m;
      if (c3 != null)
        c1.c(c3.k()); 
    } 
    d.h().a(j.a(), this.g.g(), this.g.q());
  }
  
  private boolean i() {
    return (j.i().optInt("quick_app_enable_switch", 0) != 0) ? false : ((d.a(this.m) && d.a(this.g)));
  }
  
  private void j() {
    n();
  }
  
  private Context k() {
    WeakReference<Context> weakReference = this.d;
    return (weakReference != null && weakReference.get() != null) ? this.d.get() : j.a();
  }
  
  private b l() {
    e e1;
    b b2 = this.n;
    b b1 = b2;
    if (b2 == null)
      e1 = (new e.a()).a(); 
    return (b)e1;
  }
  
  private com.ss.android.a.a.b.a m() {
    com.ss.android.downloadad.a.a.a a1;
    com.ss.android.a.a.b.a a3 = this.o;
    com.ss.android.a.a.b.a a2 = a3;
    if (a3 == null)
      a1 = (new com.ss.android.downloadad.a.a.a.a()).a(); 
    return (com.ss.android.a.a.b.a)a1;
  }
  
  private void n() {
    Iterator<d> iterator = h.a(this.e).iterator();
    while (iterator.hasNext())
      ((d)iterator.next()).a(this.m, m()); 
    int i = this.c.a(j.a(), this.i);
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("beginDownloadWithNewDownloader id:");
    stringBuilder.append(i);
    com.ss.android.downloadlib.e.f.a(str, stringBuilder.toString(), null);
    if (i != 0) {
      c c1 = this.g;
      if (c1 == null) {
        this.c.c();
      } else {
        this.c.d(c1);
      } 
      c.a().a(new com.ss.android.downloadad.a.b.a(this.m, l(), m(), i));
    } else {
      c c1 = (new c.a(this.m.a())).a();
      c1.b(-1);
      a(c1);
      com.ss.android.downloadlib.d.a.a().a(this.l, new com.ss.android.socialbase.downloader.e.a(2, "start download failed, id=0"));
      g.b();
    } 
    d.a().b().remove(i);
    if (this.c.b(c())) {
      j.c().a(k(), this.m, m(), l());
      str = a;
      stringBuilder = new StringBuilder();
      stringBuilder.append("beginDownloadWithNewDownloader onItemClick id:");
      stringBuilder.append(i);
      com.ss.android.downloadlib.e.f.a(str, stringBuilder.toString(), null);
    } 
  }
  
  private void o() {
    a a1 = this.h;
    if (a1 != null && a1.getStatus() != AsyncTask.Status.FINISHED)
      this.h.cancel(true); 
    this.h = new a();
    b.a(this.h, (Object[])new String[] { this.m.a(), this.m.t() });
  }
  
  private e p() {
    if (this.f == null)
      this.f = new e(); 
    return this.f;
  }
  
  public f a(int paramInt, d paramd) {
    if (paramd != null) {
      if (j.i().optInt("back_use_softref_listener") == 1) {
        this.e.put(Integer.valueOf(paramInt), paramd);
        return this;
      } 
      this.e.put(Integer.valueOf(paramInt), new SoftReference<d>(paramd));
    } 
    return this;
  }
  
  public f a(Context paramContext) {
    if (paramContext != null)
      this.d = new WeakReference<Context>(paramContext); 
    j.b(paramContext);
    return this;
  }
  
  public f a(com.ss.android.a.a.b.a parama) {
    this.o = parama;
    c.a().a(this.l, m());
    return this;
  }
  
  public f a(b paramb) {
    boolean bool;
    this.n = paramb;
    if (l().k() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.p = bool;
    c.a().a(this.l, l());
    return this;
  }
  
  public f a(c paramc) {
    if (paramc != null) {
      c.a().a(paramc);
      this.l = paramc.d();
      this.m = paramc;
      if (i.a(paramc)) {
        ((c)paramc).a(3L);
        com.ss.android.downloadad.a.b.a a1 = c.a().d(this.l);
        if (a1 != null && a1.b() != 3L) {
          a1.b(3L);
          e.a().a(a1);
        } 
      } 
    } 
    return this;
  }
  
  public void a() {
    this.j = true;
    c.a().a(this.l, l());
    c.a().a(this.l, m());
    this.c.a(this.l);
    o();
  }
  
  public void a(long paramLong, int paramInt) {
    if (paramInt == 2 || paramInt == 1) {
      if (paramLong > 0L) {
        c c1 = c.a().a(paramLong);
        if (c1 != null) {
          this.m = c1;
          this.l = paramLong;
          this.c.a(this.l);
        } 
      } else {
        g.b();
      } 
      if (!this.c.a(k(), paramInt, this.p)) {
        boolean bool = b(paramInt);
        if (paramInt != 1) {
          if (paramInt != 2)
            return; 
          if (!bool) {
            String str = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handleDownload id:");
            stringBuilder.append(paramLong);
            stringBuilder.append(",tryPerformButtonClick:");
            com.ss.android.downloadlib.e.f.a(str, stringBuilder.toString(), null);
            b(true);
            return;
          } 
        } else if (!bool) {
          String str = a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("handleDownload id:");
          stringBuilder.append(paramLong);
          stringBuilder.append(",tryPerformItemClick:");
          com.ss.android.downloadlib.e.f.a(str, stringBuilder.toString(), null);
          c(true);
        } 
      } 
      return;
    } 
    throw new IllegalArgumentException("error actionType");
  }
  
  public void a(Message paramMessage) {
    if (paramMessage != null) {
      if (!this.j)
        return; 
      int i = paramMessage.what;
      if (i != 3) {
        if (i != 4) {
          if (i != 5)
            return; 
          if (j.k() != null && j.k().a())
            return; 
          com.ss.android.downloadlib.d.a.a().a(this.l, false, 1);
          c(false);
          return;
        } 
        if (j.k() != null && j.k().a())
          return; 
        com.ss.android.downloadlib.d.a.a().a(this.l, false, 2);
        b(false);
        return;
      } 
      this.g = (c)paramMessage.obj;
      this.c.a(paramMessage, p(), h.a(this.e));
    } 
  }
  
  public void a(boolean paramBoolean) {
    if (this.g != null) {
      if (paramBoolean) {
        d d = d.h().b();
        if (d != null)
          d.a(this.g); 
        com.ss.android.socialbase.downloader.downloader.f.a(b.B()).a(this.g.g(), true);
        return;
      } 
      Intent intent = new Intent(j.a(), DownloadHandlerService.class);
      intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
      intent.putExtra("extra_click_download_ids", this.g.g());
      j.a().startService(intent);
    } 
  }
  
  public boolean a(int paramInt) {
    if (paramInt == 0) {
      this.e.clear();
    } else {
      this.e.remove(Integer.valueOf(paramInt));
    } 
    boolean bool1 = this.e.isEmpty();
    boolean bool = false;
    if (bool1) {
      String str1;
      this.j = false;
      this.k = System.currentTimeMillis();
      if (this.g != null)
        com.ss.android.socialbase.downloader.downloader.f.a(j.a()).k(this.g.g()); 
      a a1 = this.h;
      bool = true;
      if (a1 != null && a1.getStatus() != AsyncTask.Status.FINISHED)
        this.h.cancel(true); 
      this.c.a(this.g);
      String str2 = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
      c c1 = this.g;
      if (c1 == null) {
        str1 = "";
      } else {
        str1 = str1.j();
      } 
      stringBuilder.append(str1);
      com.ss.android.downloadlib.e.f.a(str2, stringBuilder.toString(), null);
      this.b.removeCallbacksAndMessages(null);
      this.f = null;
      this.g = null;
    } 
    return bool;
  }
  
  public boolean b() {
    return this.j;
  }
  
  public boolean c() {
    return (this.g != null);
  }
  
  public long d() {
    return this.k;
  }
  
  public void e() {
    this.b.post(new Runnable(this) {
          public void run() {
            Iterator<d> iterator = h.a(f.a(this.a)).iterator();
            while (iterator.hasNext())
              ((d)iterator.next()).b(f.b(this.a)); 
          }
        });
  }
  
  public void f() {
    if (this.e.size() == 0)
      return; 
    Iterator<d> iterator = h.a(this.e).iterator();
    while (iterator.hasNext())
      ((d)iterator.next()).a(); 
    c c1 = this.g;
    if (c1 != null)
      c1.b(-4); 
  }
  
  public void g() {
    c.a().f(this.l);
  }
  
  class a extends AsyncTask<String, Void, c> {
    private a(f this$0) {}
    
    protected c a(String... param1VarArgs) {
      c c = null;
      String[] arrayOfString = null;
      if (param1VarArgs != null) {
        c c1;
        if (param1VarArgs.length >= 1 && TextUtils.isEmpty(param1VarArgs[0]))
          return null; 
        String str = param1VarArgs[0];
        param1VarArgs = arrayOfString;
        if (f.d(this.a) != null) {
          param1VarArgs = arrayOfString;
          if (!TextUtils.isEmpty(f.d(this.a).l()))
            c1 = com.ss.android.socialbase.downloader.downloader.f.a(j.a()).a(str, f.d(this.a).l()); 
        } 
        c = c1;
        if (c1 == null)
          c = d.h().a(j.a(), str); 
      } 
      return c;
    }
    
    protected void a(c param1c) {
      super.onPostExecute(param1c);
      if (!isCancelled()) {
        if (f.d(this.a) == null)
          return; 
        try {
          boolean bool = g.a(f.d(this.a).t(), f.d(this.a).p(), f.d(this.a).q()).a();
          if (param1c != null && param1c.g() != 0 && (bool || !com.ss.android.socialbase.downloader.downloader.f.a(j.a()).a(param1c))) {
            com.ss.android.socialbase.downloader.downloader.f.a(j.a()).k(param1c.g());
            bool = com.ss.android.socialbase.downloader.k.a.a(param1c.g()).b("bugfix_remove_listener", true);
            if (f.e(this.a) != null && (f.e(this.a).q() == -4 || ((bool ^ true) == 0 && f.e(this.a).q() == -1))) {
              f.a(this.a, (c)null);
            } else {
              f.a(this.a, param1c);
              com.ss.android.socialbase.downloader.downloader.f.a(j.a()).a(f.e(this.a).g(), f.f(this.a));
            } 
            f.g(this.a).a(f.e(this.a), f.b(this.a), h.a(f.a(this.a)));
          } else {
            if (param1c != null && com.ss.android.socialbase.downloader.downloader.f.a(j.a()).a(param1c)) {
              b.a().f(param1c.g());
              f.a(this.a, (c)null);
            } 
            if (f.e(this.a) != null) {
              com.ss.android.socialbase.downloader.downloader.f.a(j.a()).k(f.e(this.a).g());
              com.ss.android.socialbase.downloader.downloader.f.a(f.h(this.a)).a(f.e(this.a).g(), f.f(this.a));
            } 
            if (bool) {
              f.a(this.a, (new c.a(f.d(this.a).a())).a());
              f.e(this.a).b(-3);
              f.g(this.a).a(f.e(this.a), f.b(this.a), h.a(f.a(this.a)));
            } else {
              Iterator<d> iterator = h.a(f.a(this.a)).iterator();
              while (iterator.hasNext())
                ((d)iterator.next()).a(); 
              f.a(this.a, (c)null);
            } 
          } 
          f.g(this.a).b(f.e(this.a));
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */