package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

public class b {
  private static Set<b> j = Collections.synchronizedSet(new HashSet<b>());
  
  private AdSlot a;
  
  private final p b = o.f();
  
  private Context c;
  
  private TTAdNative.NativeExpressAdListener d;
  
  private final AtomicBoolean e = new AtomicBoolean(false);
  
  private List<k> f;
  
  private List<k> g;
  
  private a h;
  
  private int i = 5;
  
  private ScheduledFuture<?> k = null;
  
  private ScheduledFuture<?> l = null;
  
  private ScheduledFuture<?> m = null;
  
  private b(Context paramContext) {
    if (paramContext != null) {
      this.c = paramContext.getApplicationContext();
    } else {
      this.c = o.a();
    } 
    j.add(this);
  }
  
  private TTNativeExpressAd a(k paramk) {
    int i = this.i;
    return (TTNativeExpressAd)((i != 1) ? ((i != 2) ? ((i != 5) ? ((i != 9) ? null : new m(this.c, paramk, this.a)) : ((paramk.z() != null) ? new n(this.c, paramk, this.a) : new k(this.c, paramk, this.a))) : new com.bytedance.sdk.openadsdk.core.c.b(this.c, paramk, this.a)) : new com.bytedance.sdk.openadsdk.core.bannerexpress.b(this.c, paramk, this.a));
  }
  
  public static b a(Context paramContext) {
    return new b(paramContext);
  }
  
  private void a() {
    List<k> list = this.f;
    if (list == null)
      return; 
    for (k k : list) {
      if (k.aa() && k.F() != null && !k.F().isEmpty())
        for (j j : k.F()) {
          if (!TextUtils.isEmpty(j.a()))
            e.a(this.c).f().a(j.a(), (com.bytedance.sdk.openadsdk.g.a.b.b)com.bytedance.sdk.openadsdk.g.a.b.a(), j.b(), j.c()); 
        }  
      if ((k.Q() == 5 || k.Q() == 15) && k.z() != null && k.z().g() != null) {
        int i = ah.d(k.P());
        if (o.h().a(String.valueOf(i)) && o.h().q(String.valueOf(i))) {
          com.bytedance.sdk.openadsdk.h.f.b b1 = (new com.bytedance.sdk.openadsdk.h.f.b()).a(k.z().g()).a(204800).b(k.z().j());
          com.bytedance.sdk.openadsdk.h.f.a.a().a(b1);
        } 
      } 
    } 
  }
  
  private void a(int paramInt) {
    String str;
    List<k> list = this.f;
    if (list != null && list.size() > 0) {
      str = ah.h(((k)this.f.get(0)).P());
    } else {
      str = "";
    } 
    d d = d.b().a(this.i).c(this.a.getCodeId()).f(str);
    d.b(paramInt).g(g.a(paramInt));
    com.bytedance.sdk.openadsdk.f.a.a().h(d);
  }
  
  private void a(int paramInt, String paramString) {
    if (this.e.getAndSet(false)) {
      TTAdNative.NativeExpressAdListener nativeExpressAdListener = this.d;
      if (nativeExpressAdListener != null)
        nativeExpressAdListener.onError(paramInt, paramString); 
      a a1 = this.h;
      if (a1 != null)
        a1.a(); 
      c();
    } 
  }
  
  private void a(AdSlot paramAdSlot, TTAdNative.NativeExpressAdListener paramNativeExpressAdListener) {
    if (paramAdSlot == null)
      return; 
    l l = new l();
    l.e = 2;
    this.b.a(paramAdSlot, l, this.i, new p.b(this) {
          public void a(int param1Int, String param1String) {
            b.a(this.a, param1Int, param1String);
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              b.a(this.a, param1a.c());
              b.b(this.a, param1a.c());
              b.a(this.a);
              b.b(this.a);
              return;
            } 
            b.a(this.a, -3, g.a(-3));
          }
        });
  }
  
  private void a(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void b() {
    if (this.e.getAndSet(false))
      (new Handler(Looper.getMainLooper())).post(new Runnable(this) {
            public void run() {
              if (b.c(this.a) != null && b.c(this.a).size() > 0) {
                if (b.d(this.a) != null) {
                  ArrayList<TTNativeExpressAd> arrayList = new ArrayList(b.c(this.a).size());
                  for (k k : b.c(this.a))
                    arrayList.add(b.a(this.a, k)); 
                  if (!arrayList.isEmpty()) {
                    b.d(this.a).onNativeExpressAdLoad(arrayList);
                  } else {
                    b.d(this.a).onError(103, g.a(103));
                    b.a(this.a, 103);
                  } 
                } 
                if (b.e(this.a) != null)
                  b.e(this.a).a(b.c(this.a)); 
              } else {
                if (b.d(this.a) != null) {
                  b.d(this.a).onError(108, g.a(108));
                  b.a(this.a, 108);
                } 
                if (b.e(this.a) != null)
                  b.e(this.a).a(); 
              } 
              b.f(this.a);
            }
          }); 
  }
  
  private void b(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void c() {
    List<k> list = this.f;
    if (list != null)
      list.clear(); 
    list = this.g;
    if (list != null)
      list.clear(); 
    a(true);
    b(true);
    c(true);
    d();
  }
  
  private void c(boolean paramBoolean) {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private void d() {
    j.remove(this);
  }
  
  public void a(AdSlot paramAdSlot, int paramInt1, TTAdNative.NativeExpressAdListener paramNativeExpressAdListener, int paramInt2) {
    a(paramAdSlot, paramInt1, paramNativeExpressAdListener, null, paramInt2);
  }
  
  public void a(AdSlot paramAdSlot, int paramInt1, TTAdNative.NativeExpressAdListener paramNativeExpressAdListener, a parama, int paramInt2) {
    if (this.e.get()) {
      t.e("ExpressAdLoadManager", "express ad is loading...");
      return;
    } 
    this.i = paramInt1;
    this.e.set(true);
    this.a = paramAdSlot;
    this.d = paramNativeExpressAdListener;
    this.h = parama;
    a(this.a, this.d);
  }
  
  public static interface a {
    void a();
    
    void a(List<k> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */