package com.qq.e.comm.plugin.r.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.plugin.r.b.c;
import com.qq.e.comm.plugin.y.c;
import com.qq.e.comm.plugin.y.d;
import com.qq.e.comm.plugin.y.u;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class a<T> {
  protected Context a;
  
  protected Context b;
  
  protected Handler c = new Handler(Looper.getMainLooper());
  
  private e d;
  
  private com.qq.e.comm.plugin.r.b.a e;
  
  private List<c> f = new ArrayList<c>();
  
  private c g;
  
  private AtomicInteger h = new AtomicInteger(0);
  
  private AtomicInteger i = new AtomicInteger(0);
  
  private Map<c, T> j = new HashMap<c, T>();
  
  private Map<T, c> k = new HashMap<T, c>();
  
  private T l = null;
  
  private boolean m = true;
  
  private Object n = new Object();
  
  private b o = b.a;
  
  private boolean p;
  
  private int q;
  
  private final d r;
  
  public a(Context paramContext, String paramString) {
    this.r = d.a(paramContext);
    this.e = this.r.a(paramString);
    this.a = paramContext.getApplicationContext();
    this.b = paramContext;
    if (this.e == null) {
      u.a(70002, 0, (new c()).a(paramString));
      GDTLogger.e("Mediator do not get layer config");
    } 
    this.d = new e(this.r.a(), this.r.b(), this.e.e());
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("init mediator: posId = ");
    stringBuilder.append(paramString);
    stringBuilder.append(" isSerial = ");
    stringBuilder.append(i());
    GDTLogger.d(stringBuilder.toString());
    this.q = this.e.b();
  }
  
  private void a(int paramInt, Map<String, Object> paramMap) {
    d d1;
    int i;
    String str;
    if (paramMap == null) {
      d1 = new d();
    } else {
      d1 = new d(new JSONObject((Map)d1));
    } 
    d1.a("isSerial", Boolean.valueOf(i()));
    com.qq.e.comm.plugin.r.b.a a2 = this.e;
    if (a2 == null) {
      i = 0;
    } else {
      i = a2.b();
    } 
    d1.a("layer_timeout", Integer.valueOf(i));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("埋点=");
    stringBuilder.append(d1.toString());
    GDTLogger.d(stringBuilder.toString());
    c c1 = new c();
    com.qq.e.comm.plugin.r.b.a a1 = this.e;
    if (a1 == null) {
      str = "";
    } else {
      str = str.a();
    } 
    u.a(paramInt, 0, c1.a(str), d1);
  }
  
  private void e(T paramT) {
    this.c.postAtTime(new Runnable(this, paramT) {
          public void run() {
            int i = this.b.b(this.a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("加载广告=");
            stringBuilder.append(this.a.getClass().getSimpleName());
            GDTLogger.d(stringBuilder.toString());
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            hashMap.put("adapter", this.a.getClass().getSimpleName());
            a.a(this.b, i, hashMap);
          }
        }this.n, SystemClock.uptimeMillis());
  }
  
  private void l() {
    for (Map.Entry<c, T> entry : this.j.entrySet()) {
      e((T)entry.getValue());
      ((c)entry.getKey()).c(true);
    } 
  }
  
  private void m() {
    this.o = b.a;
    this.c.removeCallbacksAndMessages(this.n);
  }
  
  private void n() {
    if (this.o == b.b) {
      g();
      m();
      c c1 = this.g;
      if (c1 != null) {
        c1 = (c)this.j.get(c1);
      } else {
        c1 = null;
      } 
      a((T)c1);
    } 
  }
  
  protected abstract void a();
  
  public void a(int paramInt) {
    if (paramInt > 0)
      this.q = paramInt; 
  }
  
  protected void a(int paramInt, c paramc) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramc != null) {
      hashMap.put("config_name", paramc.a());
      hashMap.put("config_class_name", paramc.e());
      hashMap.put("identity", paramc.b());
    } 
    a(paramInt, (Map)hashMap);
  }
  
  protected abstract void a(T paramT);
  
  public void a(T paramT, int paramInt) {
    e e1 = this.d;
    if (e1 != null)
      e1.a(this.k.get(paramT)); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("adapter", paramT.getClass().getSimpleName());
    a(paramInt, (Map)hashMap);
  }
  
  public void a(T paramT, int paramInt1, boolean paramBoolean, int paramInt2) {
    c c1 = this.k.get(paramT);
    if (c1 != null) {
      c1.a(paramInt1);
      c1.a(paramBoolean);
      c1.b(paramInt2);
    } 
  }
  
  public void a(T paramT, long paramLong, boolean paramBoolean, int paramInt) {
    c c1 = this.k.get(paramT);
    if (c1 != null) {
      boolean bool;
      String str;
      c1.d(paramBoolean);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("广告拉取完毕，");
      stringBuilder.append(paramT.getClass().getSimpleName());
      stringBuilder.append("加载");
      if (paramBoolean) {
        str = "成功";
      } else {
        str = "失败";
      } 
      stringBuilder.append(str);
      stringBuilder.append("，耗时=");
      stringBuilder.append(paramLong);
      GDTLogger.d(stringBuilder.toString());
      if (!j() && paramBoolean) {
        bool = true;
      } else {
        bool = false;
      } 
      c1.b(bool);
      int j = (int)paramLong;
      try {
        c1.c(j);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
    } 
    int i = this.i.incrementAndGet();
    if (i() && paramBoolean && c(paramT))
      m(); 
    if (!i() && i == this.j.size())
      n(); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("adapter", paramT.getClass().getSimpleName());
    if (c1 != null) {
      hashMap.put("adapter_timeout", Integer.valueOf(c1.h()));
      hashMap.put("adapter_duration", Integer.valueOf(c1.p()));
    } 
    a(paramInt, (Map)hashMap);
  }
  
  protected abstract int b(T paramT);
  
  protected abstract T b(c paramc);
  
  public void b(T paramT, int paramInt) {
    e e1 = this.d;
    if (e1 != null)
      e1.b(this.k.get(paramT)); 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("adapter", paramT.getClass().getSimpleName());
    a(paramInt, (Map)hashMap);
  }
  
  public boolean b() {
    int i = this.h.get();
    int j = this.f.size();
    boolean bool = true;
    if (i < j && this.o == b.b) {
      c c1 = this.f.get(this.h.get());
      T t = this.j.get(c1);
      this.l = t;
      e(t);
      if (this.m && c1.h() > 0)
        this.c.postAtTime(new Runnable(this, t) {
              public void run() {
                if (this.b.c(this.a) && !this.b.b())
                  this.b.a(); 
              }
            }this.n, SystemClock.uptimeMillis() + c1.h()); 
      c1.c(true);
      this.g = c1;
    } else {
      this.g = null;
      bool = false;
    } 
    this.h.getAndIncrement();
    if (!bool) {
      if (this.o == b.b)
        h(); 
      m();
    } 
    return bool;
  }
  
  protected void c() {
    if (this.e != null && b.a == this.o) {
      int i;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.e.a());
      stringBuilder.append(" preLoadAd");
      GDTLogger.d(stringBuilder.toString());
      if (i()) {
        i = 70082;
      } else {
        i = 70092;
      } 
      a(i, (Map<String, Object>)null);
      e();
      f();
      Iterator<c> iterator = this.f.iterator();
      while (iterator.hasNext()) {
        c c1 = iterator.next();
        if (!this.j.containsKey(c1) || this.j.get(c1) == null) {
          T t = b(c1);
          if (t == null) {
            iterator.remove();
            continue;
          } 
          this.j.put(c1, t);
          this.k.put(t, c1);
        } 
      } 
      this.r.a(false, true);
      d();
      return;
    } 
    GDTLogger.w("Mediator last loading not finish");
  }
  
  public boolean c(T paramT) {
    if (paramT != null) {
      T t = this.l;
      if (t != null && paramT == t && this.o == b.b)
        return true; 
    } 
    return false;
  }
  
  protected void d() {
    this.o = b.b;
    if (i()) {
      if (!b())
        a(); 
    } else {
      l();
    } 
    Handler handler = this.c;
    Runnable runnable = new Runnable(this) {
        public void run() {
          if (!this.a.i()) {
            a.a(this.a);
          } else {
            a.a(this.a, true);
            if (a.b(this.a) == a.b.b) {
              this.a.a();
              a.a(this.a, (c)null);
              this.a.h();
            } 
          } 
          a.c(this.a);
        }
      };
    Object object = this.n;
    long l = SystemClock.uptimeMillis();
    int i = this.q;
    if (i <= 0)
      i = 5000; 
    handler.postAtTime(runnable, object, l + i);
  }
  
  public boolean d(T paramT) {
    if (paramT != null) {
      c c1 = this.g;
      if (c1 != null && c1 == this.k.get(paramT))
        return true; 
    } 
    return false;
  }
  
  protected void e() {
    this.p = false;
    this.g = null;
    this.h.set(0);
    this.i.set(0);
    this.f.clear();
    this.c.removeCallbacksAndMessages(this.n);
  }
  
  protected void f() {
    List<c> list;
    if (i()) {
      list = b.a(this.e.f());
    } else {
      list = this.e.f();
    } 
    this.f = list;
  }
  
  protected void g() {
    this.f = b.b(this.f);
    if (this.f.size() > 0)
      this.g = this.f.get(0); 
    h();
  }
  
  public void h() {
    if (this.d != null) {
      int i;
      String str;
      c c1 = this.g;
      Collection<c> collection = this.k.values();
      if (c1 != null) {
        str = c1.f();
        if (i()) {
          i = 70062;
        } else {
          i = 70042;
        } 
      } else {
        str = this.e.d();
        if (i()) {
          i = 70072;
        } else {
          i = 70052;
        } 
      } 
      a(i, (Map<String, Object>)null);
      this.d.a(new ArrayList<c>(collection), str);
    } 
  }
  
  public boolean i() {
    com.qq.e.comm.plugin.r.b.a a1 = this.e;
    boolean bool = true;
    if (a1 == null)
      return true; 
    if (a1.c() != 1)
      bool = false; 
    return bool;
  }
  
  public boolean j() {
    return this.p;
  }
  
  protected String k() {
    c c1 = this.g;
    return (c1 != null) ? c1.a() : null;
  }
  
  public static interface a {
    void a();
    
    boolean a(ADEvent param1ADEvent);
    
    void b();
    
    void b(ADEvent param1ADEvent);
    
    void c();
  }
  
  enum b {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\r\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */