package com.bytedance.sdk.openadsdk.component.reward;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.b;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {
  private static volatile g a;
  
  private Context b;
  
  private final p c = o.f();
  
  private AtomicBoolean d = new AtomicBoolean(false);
  
  private List<a> e = Collections.synchronizedList(new ArrayList<a>());
  
  private final BroadcastReceiver f = new BroadcastReceiver(this) {
      public void onReceive(Context param1Context, Intent param1Intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(param1Intent.getAction()) && w.c(g.a(this.a)) != 0) {
          Iterator<Runnable> iterator = g.b(this.a).iterator();
          while (iterator.hasNext()) {
            com.bytedance.sdk.openadsdk.i.a.a().c(iterator.next(), 1);
            iterator.remove();
          } 
        } 
      }
    };
  
  private g(Context paramContext) {
    if (paramContext == null) {
      paramContext = o.a();
    } else {
      paramContext = paramContext.getApplicationContext();
    } 
    this.b = paramContext;
    c();
  }
  
  public static g a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/component/reward/g.a : Lcom/bytedance/sdk/openadsdk/component/reward/g;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/component/reward/g
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/component/reward/g.a : Lcom/bytedance/sdk/openadsdk/component/reward/g;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/component/reward/g
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/component/reward/g.a : Lcom/bytedance/sdk/openadsdk/component/reward/g;
    //   26: ldc com/bytedance/sdk/openadsdk/component/reward/g
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/component/reward/g
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/component/reward/g.a : Lcom/bytedance/sdk/openadsdk/component/reward/g;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(AdSlot paramAdSlot, boolean paramBoolean, TTAdNative.RewardVideoAdListener paramRewardVideoAdListener) {
    j j;
    if (paramBoolean) {
      b(paramAdSlot, true, paramRewardVideoAdListener);
      return;
    } 
    k k = e.a(this.b).c(paramAdSlot.getCodeId());
    if (k != null) {
      j = new j(this.b, k, paramAdSlot);
      if (!k.r())
        j.a(e.a(this.b).a(k)); 
      d.a(k);
      if (paramRewardVideoAdListener != null) {
        paramRewardVideoAdListener.onRewardVideoAdLoad(j);
        if (!k.r())
          paramRewardVideoAdListener.onRewardVideoCached(); 
      } 
      com.bytedance.sdk.openadsdk.core.g.a.a().a(k, new com.bytedance.sdk.openadsdk.core.g.a.a(this, paramRewardVideoAdListener, k) {
            public void a(boolean param1Boolean) {
              if (this.a != null && this.b.r())
                this.a.onRewardVideoCached(); 
            }
          });
      t.b("RewardVideoLoadManager", "get cache data success");
      return;
    } 
    b((AdSlot)j, false, paramRewardVideoAdListener);
  }
  
  private void a(a parama) {
    if (parama == null)
      return; 
    if (this.e.size() >= 1)
      this.e.remove(0); 
    this.e.add(parama);
  }
  
  private void b(AdSlot paramAdSlot, boolean paramBoolean, TTAdNative.RewardVideoAdListener paramRewardVideoAdListener) {
    boolean bool;
    l l = new l();
    if (paramBoolean) {
      bool = true;
    } else {
      bool = true;
    } 
    l.b = bool;
    if (o.h().i(paramAdSlot.getCodeId()) || paramAdSlot.getExpressViewAcceptedWidth() > 0.0F)
      l.e = 2; 
    this.c.a(paramAdSlot, l, 7, new p.b(this, paramBoolean, paramRewardVideoAdListener, paramAdSlot) {
          public void a(int param1Int, String param1String) {
            if (!this.a) {
              TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.b;
              if (rewardVideoAdListener != null)
                rewardVideoAdListener.onError(param1Int, param1String); 
            } 
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("get material data success: ");
              stringBuilder.append(this.a);
              t.b("RewardVideoLoadManager", stringBuilder.toString());
              k k = param1a.c().get(0);
              try {
                if (k.C() != null && !TextUtils.isEmpty(k.C().a())) {
                  String str = k.C().a();
                  b b1 = new b(true);
                  b1.a(this.c.getCodeId());
                  b1.a(7);
                  b1.c(k.M());
                  b1.d(k.P());
                  b1.b(ah.h(k.P()));
                  e.a(g.a(this.d)).g().a(str, (d.d)b1);
                } 
              } finally {}
              j j = new j(g.a(this.d), k, this.c);
              if (!this.a) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.b;
                if (rewardVideoAdListener != null)
                  rewardVideoAdListener.onRewardVideoAdLoad(j); 
              } 
              com.bytedance.sdk.openadsdk.core.g.a.a().a(k, new com.bytedance.sdk.openadsdk.core.g.a.a(this, k) {
                    public void a(boolean param2Boolean) {
                      if (!this.b.a && this.b.b != null) {
                        k k1 = this.a;
                        if (k1 != null && k1.r())
                          this.b.b.onRewardVideoCached(); 
                      } 
                    }
                  });
              if (k.aa()) {
                g g1;
                if (this.a && !k.r() && (o.h().r(this.c.getCodeId())).d == 1) {
                  if (!w.d(g.a(this.d))) {
                    g1 = this.d;
                    g.a(g1, new g.a(g1, k, this.c));
                  } 
                  return;
                } 
                if (!k.r()) {
                  e.a(g.a(this.d)).a(k, new e.a(this, k, (j)g1) {
                        public void a(boolean param2Boolean, Object param2Object) {
                          param2Object = new StringBuilder();
                          param2Object.append("download video file: ");
                          param2Object.append(param2Boolean);
                          param2Object.append(", preload: ");
                          param2Object.append(this.c.a);
                          t.b("RewardVideoLoadManager", param2Object.toString());
                          if (param2Boolean) {
                            param2Object = e.a(g.a(this.c.d)).a(this.a);
                            this.b.a((String)param2Object);
                          } 
                          if (!this.c.a) {
                            d.a(this.a);
                            if (param2Boolean && this.c.b != null) {
                              this.c.b.onRewardVideoCached();
                              return;
                            } 
                          } else if (param2Boolean) {
                            e.a(g.a(this.c.d)).a(this.c.c, this.a);
                          } 
                        }
                      });
                  return;
                } 
              } else if (!this.a) {
                TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.b;
                if (rewardVideoAdListener != null) {
                  rewardVideoAdListener.onError(-4, com.bytedance.sdk.openadsdk.core.g.a(-4));
                  return;
                } 
              } 
            } else if (!this.a) {
              TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.b;
              if (rewardVideoAdListener != null)
                rewardVideoAdListener.onError(-3, com.bytedance.sdk.openadsdk.core.g.a(-3)); 
            } 
          }
        });
  }
  
  private void c() {
    if (this.d.get())
      return; 
    this.d.set(true);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    try {
      this.b.registerReceiver(this.f, intentFilter);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void d() {
    if (!this.d.get())
      return; 
    this.d.set(false);
    try {
      this.b.unregisterReceiver(this.f);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public void a() {
    AdSlot adSlot = e.a(this.b).b();
    if (adSlot != null) {
      if (TextUtils.isEmpty(adSlot.getCodeId()))
        return; 
      if (e.a(this.b).c(adSlot.getCodeId()) == null)
        b(adSlot); 
    } 
  }
  
  public void a(AdSlot paramAdSlot) {
    e.a(this.b).b(paramAdSlot);
  }
  
  public void a(AdSlot paramAdSlot, TTAdNative.RewardVideoAdListener paramRewardVideoAdListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("load reward vide: ");
    stringBuilder.append(String.valueOf(paramAdSlot));
    t.b("RewardVideoLoadManager", stringBuilder.toString());
    e.a(this.b).a(paramAdSlot);
    a(paramAdSlot, false, paramRewardVideoAdListener);
  }
  
  public void a(String paramString) {
    e.a(this.b).a(paramString);
  }
  
  public AdSlot b(String paramString) {
    return e.a(this.b).b(paramString);
  }
  
  public void b() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public void b(AdSlot paramAdSlot) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("preload reward video: ");
    stringBuilder.append(String.valueOf(paramAdSlot));
    t.b("RewardVideoLoadManager", stringBuilder.toString());
    a(paramAdSlot, true, null);
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
    d();
  }
  
  class a implements Runnable {
    k a;
    
    AdSlot b;
    
    a(g this$0, k param1k, AdSlot param1AdSlot) {
      this.a = param1k;
      this.b = param1AdSlot;
    }
    
    public void run() {
      e.a(g.a(this.c)).a(this.a, new e.a(this) {
            public void a(boolean param2Boolean, Object param2Object) {
              if (param2Boolean)
                e.a(g.a(this.a.c)).a(this.a.b, this.a.a); 
            }
          });
    }
  }
  
  class null implements e.a<Object> {
    null(g this$0) {}
    
    public void a(boolean param1Boolean, Object param1Object) {
      if (param1Boolean)
        e.a(g.a(this.a.c)).a(this.a.b, this.a.a); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */