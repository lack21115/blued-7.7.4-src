package com.bytedance.sdk.openadsdk.dislike;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.y;

public class b implements TTAdDislike {
  private final Context a;
  
  private k b;
  
  private c c;
  
  private TTAdDislike.DislikeInteractionCallback d;
  
  public b(Context paramContext, k paramk) {
    y.a(paramContext, "Dislike 初始化必须使用activity,请在TTAdManager.createAdNative(activity)中传入");
    this.a = paramContext;
    this.b = paramk;
    a();
  }
  
  private void a() {
    this.c = new c(this.a, this.b);
    this.c.a(new c.a(this) {
          public void a() {
            t.b("TTAdDislikeImpl", "onDislikeShow: ");
          }
          
          public void a(int param1Int, FilterWord param1FilterWord) {
            try {
              if (!param1FilterWord.hasSecondOptions() && b.a(this.a) != null)
                b.a(this.a).onSelected(param1Int, param1FilterWord.getName()); 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onDislikeSelected: ");
              stringBuilder.append(param1Int);
              stringBuilder.append(", ");
              return;
            } finally {
              param1FilterWord = null;
              t.c("TTAdDislikeImpl", "dislike callback selected error: ", (Throwable)param1FilterWord);
            } 
          }
          
          public void b() {
            t.e("TTAdDislikeImpl", "onDislikeDismiss: ");
          }
          
          public void c() {
            t.e("TTAdDislikeImpl", "onDislikeOptionBack: ");
          }
        });
  }
  
  public void a(k paramk) {
    this.c.a(paramk);
  }
  
  public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback paramDislikeInteractionCallback) {
    this.d = paramDislikeInteractionCallback;
  }
  
  public void showDislikeDialog() {
    boolean bool;
    Context context = this.a;
    if (context instanceof Activity && !((Activity)context).isFinishing()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool)
      this.c.show(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\dislike\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */