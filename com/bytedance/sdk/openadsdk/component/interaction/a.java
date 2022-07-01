package com.bytedance.sdk.openadsdk.component.interaction;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;

public class a {
  private final p a = o.f();
  
  public static a a() {
    return new a();
  }
  
  public void a(Context paramContext, AdSlot paramAdSlot, TTAdNative.InteractionAdListener paramInteractionAdListener) {
    this.a.a(paramAdSlot, null, 2, new p.b(this, paramInteractionAdListener, paramContext) {
          public void a(int param1Int, String param1String) {
            this.a.onError(param1Int, param1String);
          }
          
          public void a(com.bytedance.sdk.openadsdk.core.d.a param1a) {
            if (param1a.c() != null && !param1a.c().isEmpty()) {
              k k = param1a.c().get(0);
              if (k.aa()) {
                b b1 = new b(this.b, k);
                b1.a(new k(this, b1) {
                      public void a() {
                        this.b.a.onInteractionAdLoad(this.a);
                      }
                      
                      public void b() {
                        this.b.a.onError(-6, g.a(-6));
                      }
                    });
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\interaction\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */