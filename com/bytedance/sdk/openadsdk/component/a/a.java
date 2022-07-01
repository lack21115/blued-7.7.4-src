package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.h.f.b;
import com.bytedance.sdk.openadsdk.utils.ah;
import java.util.ArrayList;
import java.util.List;

public class a {
  private static volatile a a;
  
  private final p b = o.f();
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/component/a/a.a : Lcom/bytedance/sdk/openadsdk/component/a/a;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/component/a/a
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/component/a/a.a : Lcom/bytedance/sdk/openadsdk/component/a/a;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/component/a/a
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/component/a/a.a : Lcom/bytedance/sdk/openadsdk/component/a/a;
    //   25: ldc com/bytedance/sdk/openadsdk/component/a/a
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/component/a/a
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/component/a/a.a : Lcom/bytedance/sdk/openadsdk/component/a/a;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(Context paramContext, AdSlot paramAdSlot, TTAdNative.DrawFeedAdListener paramDrawFeedAdListener) {
    this.b.a(paramAdSlot, null, 9, new p.b(this, paramDrawFeedAdListener, paramContext) {
          public void a(int param1Int, String param1String) {
            this.a.onError(param1Int, param1String);
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              List list = param1a.c();
              ArrayList<b> arrayList = new ArrayList(list.size());
              for (k k : list) {
                if (k.aa())
                  arrayList.add(new b(this.b, k, 9)); 
                if ((k.Q() == 5 || k.Q() == 15) && k.z() != null && k.z().g() != null) {
                  int i = ah.d(k.P());
                  if (o.h().a(String.valueOf(i)) && o.h().q(String.valueOf(i))) {
                    b b1 = (new b()).a(k.z().g()).a(512000).b(k.z().j());
                    com.bytedance.sdk.openadsdk.h.f.a.a().a(b1);
                  } 
                } 
              } 
              if (!arrayList.isEmpty()) {
                this.a.onDrawFeedAdLoad(arrayList);
                return;
              } 
              this.a.onError(-4, g.a(-4));
              return;
            } 
            this.a.onError(-3, g.a(-3));
          }
        });
  }
  
  public void a(Context paramContext, AdSlot paramAdSlot, TTAdNative.FeedAdListener paramFeedAdListener) {
    this.b.a(paramAdSlot, null, 5, new p.b(this, paramFeedAdListener, paramContext, paramAdSlot) {
          public void a(int param1Int, String param1String) {
            this.a.onError(param1Int, param1String);
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              List list = param1a.c();
              ArrayList<c> arrayList = new ArrayList(list.size());
              for (k k : list) {
                if (k.aa())
                  arrayList.add(new c(this.b, k, 5, this.c)); 
                if (k.Q() == 5 && k.z() != null && k.z().g() != null) {
                  int i = ah.d(k.P());
                  if (o.h().a(String.valueOf(i)) && o.h().q(String.valueOf(i))) {
                    b b1 = (new b()).a(k.z().g()).a(204800).b(k.z().j());
                    com.bytedance.sdk.openadsdk.h.f.a.a().a(b1);
                  } 
                } 
              } 
              if (!arrayList.isEmpty()) {
                this.a.onFeedAdLoad(arrayList);
                return;
              } 
              this.a.onError(-4, g.a(-4));
              return;
            } 
            this.a.onError(-3, g.a(-3));
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */