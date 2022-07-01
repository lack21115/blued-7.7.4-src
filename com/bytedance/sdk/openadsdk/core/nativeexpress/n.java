package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.multipro.b.a;

public class n extends k {
  public n(Context paramContext, k paramk, AdSlot paramAdSlot) {
    super(paramContext, paramk, paramAdSlot);
  }
  
  public void a(Context paramContext, k paramk, AdSlot paramAdSlot) {
    this.a = new NativeExpressVideoView(paramContext, paramk, paramAdSlot, "embeded_ad");
    a(this.a, this.c);
  }
  
  public a getVideoModel() {
    return (this.a != null) ? ((NativeExpressVideoView)this.a).getVideoModel() : null;
  }
  
  public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener paramExpressVideoAdListener) {
    if (this.a != null)
      this.a.setVideoAdListener(paramExpressVideoAdListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */