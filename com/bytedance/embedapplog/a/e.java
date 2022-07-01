package com.bytedance.embedapplog.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.embedapplog.AppLog;
import com.bytedance.embedapplog.b.b;
import com.bytedance.embedapplog.b.h;
import com.bytedance.embedapplog.b.i;
import com.bytedance.embedapplog.collector.Collector;
import com.bytedance.embedapplog.collector.a;
import com.bytedance.embedapplog.d.a;
import com.bytedance.embedapplog.d.b;
import com.bytedance.embedapplog.d.i;
import com.bytedance.embedapplog.util.g;
import com.bytedance.embedapplog.util.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class e implements Handler.Callback, Comparator<a> {
  private static e b;
  
  public Application a;
  
  private a c;
  
  private boolean d;
  
  private h e;
  
  private final ArrayList<a> f = new ArrayList<a>(32);
  
  private b g;
  
  private i h;
  
  private Handler i;
  
  private k j;
  
  private Handler k;
  
  public static void a() {
    e e1 = b;
    if (e1 != null)
      e1.b(null); 
  }
  
  public static void a(a parama) {
    e e1 = b;
    if (e1 == null) {
      h.b("Init comes First!", null);
      b.a(parama);
      return;
    } 
    if (parama.a == 0L)
      h.a(null); 
    if (parama instanceof i)
      ((i)parama).i = e1.e.l(); 
    synchronized (e1.f) {
      int j = e1.f.size();
      e1.f.add(parama);
      if (j % 10 == 0) {
        Handler handler = e1.k;
        if (handler != null) {
          long l;
          handler.removeMessages(4);
          handler = e1.k;
          if (j == 0) {
            l = 500L;
          } else {
            l = 250L;
          } 
          handler.sendEmptyMessageDelayed(4, l);
        } 
      } 
      return;
    } 
  }
  
  public static void a(String[] paramArrayOfString) {
    e e1 = b;
    if (e1 == null) {
      h.a(new RuntimeException("Init comes First!"));
      return;
    } 
    e1.k.removeMessages(4);
    e1.k.obtainMessage(5, paramArrayOfString).sendToTarget();
  }
  
  public static e b() {
    // Byte code:
    //   0: getstatic com/bytedance/embedapplog/a/e.b : Lcom/bytedance/embedapplog/a/e;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/embedapplog/a/e
    //   8: monitorenter
    //   9: getstatic com/bytedance/embedapplog/a/e.b : Lcom/bytedance/embedapplog/a/e;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/embedapplog/a/e
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/embedapplog/a/e.b : Lcom/bytedance/embedapplog/a/e;
    //   25: ldc com/bytedance/embedapplog/a/e
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/embedapplog/a/e
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/embedapplog/a/e.b : Lcom/bytedance/embedapplog/a/e;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void b(String[] paramArrayOfString) {
    ArrayList<a> arrayList;
    String[] arrayOfString;
    synchronized (this.f) {
      ArrayList<a> arrayList1 = (ArrayList)this.f.clone();
      this.f.clear();
      byte b1 = 0;
      int j = 0;
      if (paramArrayOfString != null) {
        arrayList1.ensureCapacity(arrayList1.size() + paramArrayOfString.length);
        int n = paramArrayOfString.length;
        for (int m = 0; m < n; m++)
          arrayList1.add(a.a(paramArrayOfString[m])); 
      } 
      boolean bool = this.e.a(arrayList1);
      if (arrayList1.size() > 0) {
        if (this.e.u()) {
          if (bool || arrayList1.size() > 100) {
            Collections.sort(arrayList1, this);
            ArrayList<a> arrayList2 = new ArrayList(arrayList1.size());
            null = arrayList1.iterator();
            bool = false;
            int i1 = j;
            while (null.hasNext()) {
              a a1 = null.next();
              if (this.j.a(a1, arrayList2))
                g(); 
              if (a1 instanceof com.bytedance.embedapplog.d.h) {
                bool = k.a(a1);
                i1 = 1;
              } 
            } 
            if (i1)
              if (bool) {
                this.k.removeMessages(7);
              } else {
                this.k.sendEmptyMessageDelayed(7, this.e.A());
              }  
            this.g.a(arrayList2);
            if (!this.d && this.j.b() && this.i != null && AppLog.getAutoActiveState()) {
              e();
              return;
            } 
            return;
          } 
          synchronized (this.f) {
            this.f.addAll((Collection<? extends a>)null);
            return;
          } 
        } 
        Intent intent = new Intent((Context)this.a, Collector.class);
        int n = arrayList1.size();
        arrayOfString = new String[n];
        j = 0;
        for (int m = b1; m < n; m++) {
          arrayOfString[m] = ((a)arrayList1.get(m)).e().toString();
          j += arrayOfString[m].length();
        } 
        if (j >= 307200)
          h.a(null); 
        intent.putExtra("EMBED_K_DATA", arrayOfString);
        try {
          this.a.sendBroadcast(intent);
          return;
        } catch (Exception exception) {
          h.a(exception);
        } 
      } 
      return;
    } 
  }
  
  public static String c() {
    return (d()).a;
  }
  
  public static k d() {
    e e1 = b;
    if (e1 != null)
      return e1.j; 
    h.a(null);
    return null;
  }
  
  private void f() {
    if (this.e.y()) {
      if (this.c == null) {
        this.c = new a(this.a, this.h, this.e);
        this.i.obtainMessage(6, this.c).sendToTarget();
        return;
      } 
    } else {
      a a1 = this.c;
      if (a1 != null) {
        a1.f();
        this.c = null;
      } 
    } 
  }
  
  private void g() {
    if (h.b) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("packAndSend once, ");
      stringBuilder.append(this.j.a);
      stringBuilder.append(", hadUI:");
      stringBuilder.append(this.j.b());
      h.a(stringBuilder.toString(), null);
    } 
    Handler handler = this.i;
    if (handler != null) {
      handler.sendMessage(this.k.obtainMessage(6, new f((Context)this.a, this.h, this.g)));
      this.i.sendMessage(this.k.obtainMessage(6, new g((Context)this.a, this.g, this.e, this.h)));
    } 
  }
  
  public int a(a parama1, a parama2) {
    int j = parama1.a - parama2.a cmp 0L;
    return (j < 0) ? -1 : ((j > 0) ? 1 : 0);
  }
  
  public void a(Application paramApplication, h paramh, i parami, a parama) {
    this.a = paramApplication;
    this.g = new b(paramApplication, parami, paramh);
    this.e = paramh;
    this.h = parami;
    this.j = new k(this.h, this.e);
    this.a.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)parama);
    HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
    handlerThread.start();
    this.k = new Handler(handlerThread.getLooper(), this);
    Handler handler = this.k;
    boolean bool = true;
    handler.sendEmptyMessage(1);
    if (paramh.l() == 0)
      bool = false; 
    g.a(bool);
  }
  
  public boolean e() {
    this.d = true;
    b b1 = new b((Context)this.a, this.h);
    Handler handler = this.i;
    if (handler != null) {
      handler.obtainMessage(6, b1).sendToTarget();
      return true;
    } 
    return false;
  }
  
  public boolean handleMessage(Message paramMessage) {
    int j = paramMessage.what;
    if (j != 1) {
      if (j != 2) {
        if (j != 4) {
          c c;
          if (j != 5) {
            if (j != 6) {
              if (j != 7) {
                h.a(null);
                return true;
              } 
              synchronized (this.f) {
                this.f.add(k.d());
                b(null);
                return true;
              } 
            } 
            c = (c)paramMessage.obj;
            if (!c.g()) {
              long l = c.h();
              if (l < 864000000L)
                this.i.sendMessageDelayed(this.k.obtainMessage(6, c), l); 
              f();
              return true;
            } 
          } else {
            b((String[])((Message)c).obj);
            return true;
          } 
        } else {
          b(null);
          return true;
        } 
      } else {
        ArrayList<i> arrayList = new ArrayList(4);
        arrayList.add(new i((Context)this.a, this.h, this.j));
        arrayList.add(new d((Context)this.a, this.h, this.e));
        arrayList.add(new h((Context)this.a, this.h, this.g));
        arrayList.add(new j((Context)this.a, this.g, this.e, this.h));
        for (c c : arrayList) {
          long l = c.h();
          if (l < 864000000L)
            this.i.sendMessageDelayed(this.k.obtainMessage(6, c), l); 
        } 
        f();
        return true;
      } 
    } else {
      h.a = this.e.z();
      if (this.h.e()) {
        if (this.e.u()) {
          HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
          handlerThread.start();
          this.i = new Handler(handlerThread.getLooper(), this);
          this.i.sendEmptyMessage(2);
          if (this.f.size() > 0) {
            this.k.removeMessages(4);
            this.k.sendEmptyMessageDelayed(4, 1000L);
          } 
          h.d("net|worker start", null);
        } 
      } else {
        this.k.removeMessages(1);
        this.k.sendEmptyMessageDelayed(1, 1000L);
      } 
      b.a();
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embedapplog\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */