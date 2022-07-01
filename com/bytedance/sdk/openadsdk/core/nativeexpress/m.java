package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.k;

public class m extends n {
  public m(Context paramContext, k paramk, AdSlot paramAdSlot) {
    super(paramContext, paramk, paramAdSlot);
  }
  
  public void a(Context paramContext, k paramk, AdSlot paramAdSlot) {
    this.d = "draw_ad";
    this.a = new NativeExpressVideoView(paramContext, paramk, paramAdSlot, "draw_ad");
    a(this.a, this.c);
  }
  
  public void setCanInterruptVideoPlay(boolean paramBoolean) {
    if (this.a != null)
      ((NativeExpressVideoView)this.a).setCanInterruptVideoPlay(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */