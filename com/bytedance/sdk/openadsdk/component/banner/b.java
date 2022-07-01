package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;

public class b {
  private static volatile b a;
  
  private WeakReference<Context> b;
  
  private final p c;
  
  private b(Context paramContext) {
    this.b = new WeakReference<Context>(paramContext);
    this.c = o.f();
  }
  
  private Context a() {
    WeakReference<Context> weakReference = this.b;
    return (weakReference == null || weakReference.get() == null) ? o.a() : this.b.get();
  }
  
  public static b a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/component/banner/b.a : Lcom/bytedance/sdk/openadsdk/component/banner/b;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/component/banner/b
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/component/banner/b.a : Lcom/bytedance/sdk/openadsdk/component/banner/b;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/component/banner/b
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/component/banner/b.a : Lcom/bytedance/sdk/openadsdk/component/banner/b;
    //   26: ldc com/bytedance/sdk/openadsdk/component/banner/b
    //   28: monitorexit
    //   29: goto -> 45
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/component/banner/b
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/component/banner/b.a : Lcom/bytedance/sdk/openadsdk/component/banner/b;
    //   41: aload_0
    //   42: invokespecial b : (Landroid/content/Context;)V
    //   45: getstatic com/bytedance/sdk/openadsdk/component/banner/b.a : Lcom/bytedance/sdk/openadsdk/component/banner/b;
    //   48: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(k paramk, a parama) {
    String str = ((j)paramk.F().get(0)).a();
    e.a(a()).g().a(str, new d.d(this, parama, paramk) {
          public void a() {}
          
          public void a(d.c param1c, boolean param1Boolean) {
            if (param1c != null && param1c.a() != null) {
              b.a a2 = this.a;
              if (a2 != null)
                a2.a(new a(param1c.a(), this.b)); 
              return;
            } 
            b.a a1 = this.a;
            if (a1 != null)
              a1.a(); 
          }
          
          public void a(n<Bitmap> param1n) {}
          
          public void b() {}
          
          public void b(n<Bitmap> param1n) {
            b.a a1 = this.a;
            if (a1 != null)
              a1.a(); 
          }
        });
  }
  
  private void b(Context paramContext) {
    this.b = new WeakReference<Context>(paramContext);
  }
  
  public void a(AdSlot paramAdSlot, TTAdNative.BannerAdListener paramBannerAdListener) {
    this.c.a(paramAdSlot, null, 1, new p.b(this, paramBannerAdListener, paramAdSlot) {
          public void a(int param1Int, String param1String) {
            this.a.onError(param1Int, param1String);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1String);
            stringBuilder.append(" ");
            stringBuilder.append(param1Int);
            t.b("BannerAdManager", stringBuilder.toString());
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              k k = param1a.c().get(0);
              if (k.aa()) {
                b.a a1 = new b.a(this) {
                    public void a() {
                      this.a.a.onError(-5, g.a(-5));
                    }
                    
                    public void a(a param2a) {
                      if (b.a(this.a.c).get() != null) {
                        e e = new e(b.a(this.a.c).get(), param2a, this.a.b);
                        this.a.a.onBannerAdLoad(e);
                      } 
                    }
                  };
                b.a(this.c, k, a1);
                return;
              } 
              t.b("BannerAdManager", "Banner广告解析失败");
              this.a.onError(-4, g.a(-4));
              return;
            } 
            t.b("BannerAdManager", "Banner广告解析失败/广告为空");
            this.a.onError(-4, g.a(-4));
          }
        });
  }
  
  void a(AdSlot paramAdSlot, a parama) {
    this.c.a(paramAdSlot, null, 1, new p.b(this, parama) {
          public void a(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1String);
            stringBuilder.append("  ");
            stringBuilder.append(param1Int);
            t.b("BannerAdManager", stringBuilder.toString());
            b.a a1 = this.a;
            if (a1 != null)
              a1.a(); 
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              k k = param1a.c().get(0);
              if (k.aa()) {
                b.a(this.b, k, this.a);
                return;
              } 
              t.b("BannerAdManager", "Banner广告解析失败/广告为空");
              b.a a1 = this.a;
              if (a1 != null)
                a1.a(); 
            } 
          }
        });
  }
  
  public static interface a {
    void a();
    
    void a(a param1a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\banner\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */