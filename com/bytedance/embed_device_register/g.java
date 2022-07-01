package com.bytedance.embed_device_register;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.embedapplog.IOaidObserver;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class g {
  private static final String a;
  
  private static Map<String, String> b = null;
  
  private static IOaidObserver c;
  
  private static final f d = new f() {
      public void a(Map<String, String> param1Map) {
        g.a(param1Map);
        g.a(new IOaidObserver.Oaid(param1Map.get("id")));
      }
    };
  
  static void a(Context paramContext, SharedPreferences paramSharedPreferences) {
    e.a(paramContext, paramSharedPreferences);
    i.a(paramContext, paramSharedPreferences);
  }
  
  static void a(IOaidObserver paramIOaidObserver) {
    c = paramIOaidObserver;
    Map<String, String> map = b;
    if (map != null)
      b(new IOaidObserver.Oaid(map.get("id"))); 
  }
  
  static Map<String, String> b(Context paramContext, SharedPreferences paramSharedPreferences) {
    Map<String, String> map;
    e.a a;
    i.b b = d(paramContext, paramSharedPreferences);
    if (b != null) {
      map = b.b();
    } else {
      a = c((Context)map, paramSharedPreferences);
      if (a != null) {
        Map<String, String> map1 = a.a();
      } else {
        a = null;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Oaid#getOaid result=");
    stringBuilder.append(a);
    c.a("TrackerDr", stringBuilder.toString());
    b = (Map<String, String>)a;
    return (Map<String, String>)a;
  }
  
  private static void b(IOaidObserver.Oaid paramOaid) {
    if (paramOaid != null) {
      IOaidObserver iOaidObserver = c;
      if (iOaidObserver != null)
        iOaidObserver.onOaidLoaded(paramOaid); 
    } 
  }
  
  private static e.a c(Context paramContext, SharedPreferences paramSharedPreferences) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("getHuaweiOaid: ");
    c.a("TrackerDr", stringBuilder.toString());
    stringBuilder = null;
    if (paramContext != null && paramSharedPreferences != null) {
      String str;
      if (!e.a(paramContext))
        return null; 
      e e = e.b(paramContext, paramSharedPreferences);
      e.a a = e.a();
      if (a != null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a);
        stringBuilder1.append("getHuaweiOaid: return cache=");
        stringBuilder1.append(a.b());
        c.a("TrackerDr", stringBuilder1.toString());
        return a;
      } 
      CountDownLatch countDownLatch = new CountDownLatch(1);
      h<e.a> h = new h();
      stringBuilder1.a(new a(h, countDownLatch, d));
      try {
        countDownLatch.await(100L, TimeUnit.MILLISECONDS);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(a);
      stringBuilder2.append("getHuaweiOaid: return waited=");
      StringBuilder stringBuilder1 = stringBuilder;
      if (h.a != null)
        str = ((e.a)h.a).b(); 
      stringBuilder2.append(str);
      c.a("TrackerDr", stringBuilder2.toString());
      return (e.a)h.a;
    } 
    return null;
  }
  
  private static i.b d(Context paramContext, SharedPreferences paramSharedPreferences) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("getXmOaid: ");
    c.a("TrackerDr", stringBuilder.toString());
    stringBuilder = null;
    if (paramContext != null && paramSharedPreferences != null) {
      String str;
      if (!i.a.a())
        return null; 
      i i = i.b(paramContext, paramSharedPreferences);
      i.b b = i.a();
      if (b != null) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append(a);
        stringBuilder1.append("getXmOaid: return cache=");
        stringBuilder1.append(b.a());
        c.a("TrackerDr", stringBuilder1.toString());
        return b;
      } 
      CountDownLatch countDownLatch = new CountDownLatch(1);
      h<i.b> h = new h();
      stringBuilder1.a(new c(h, countDownLatch, d));
      try {
        countDownLatch.await(100L, TimeUnit.MILLISECONDS);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(a);
      stringBuilder2.append("getHuaweiOaid: return waited=");
      StringBuilder stringBuilder1 = stringBuilder;
      if (h.a != null)
        str = ((i.b)h.a).a(); 
      stringBuilder2.append(str);
      c.a("TrackerDr", stringBuilder2.toString());
      return (i.b)h.a;
    } 
    return null;
  }
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(g.class.getSimpleName());
    stringBuilder.append("#");
    a = stringBuilder.toString();
  }
  
  static class a implements b<e.a> {
    private final h<e.a> a;
    
    private final CountDownLatch b;
    
    private final f c;
    
    a(h<e.a> param1h, CountDownLatch param1CountDownLatch, f param1f) {
      this.a = param1h;
      this.b = param1CountDownLatch;
      this.c = param1f;
    }
    
    public void a(e.a param1a) {
      this.a.a = (T)param1a;
      if (param1a != null) {
        Map<String, String> map = param1a.a();
        if (map != null)
          this.c.a(map); 
      } 
      this.b.countDown();
    }
  }
  
  static interface b<T> {
    void a(T param1T);
  }
  
  static class c implements b<i.b> {
    private final h<i.b> a;
    
    private final CountDownLatch b;
    
    private final f c;
    
    c(h<i.b> param1h, CountDownLatch param1CountDownLatch, f param1f) {
      this.a = param1h;
      this.b = param1CountDownLatch;
      this.c = param1f;
    }
    
    public void a(i.b param1b) {
      this.a.a = (T)param1b;
      if (param1b != null) {
        Map<String, String> map = param1b.b();
        if (map != null)
          this.c.a(map); 
      } 
      this.b.countDown();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\embed_device_register\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */