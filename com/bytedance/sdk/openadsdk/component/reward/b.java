package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.utils.ah;
import java.util.Map;

public class b extends a {
  public b(Context paramContext, ViewGroup paramViewGroup, k paramk) {
    super(paramContext, paramViewGroup, paramk);
  }
  
  public int a() {
    return 2;
  }
  
  public void a(int paramInt1, int paramInt2) {
    String str;
    if (this.b == null)
      return; 
    boolean bool = z();
    if (bool) {
      str = "play_error";
    } else {
      str = "play_start_error";
    } 
    Map<String, Integer> map = ah.a(this.b, paramInt1, paramInt2, t());
    map.put("play_type", Integer.valueOf(ah.a((c)this, this.g)));
    if (bool) {
      map.put("duration", Long.valueOf(o()));
      map.put("percent", Integer.valueOf(q()));
      map.put("buffers_time", Long.valueOf(n()));
    } 
    d.k(this.a.get(), this.b, "fullscreen_interstitial_ad", str, map);
  }
  
  public void b() {
    Map<String, Integer> map = B();
    map.put("play_type", Integer.valueOf(ah.a((c)this, this.g)));
    d.a(this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_over", this.c, 100, map);
  }
  
  public void c() {
    Map<String, Integer> map = B();
    map.put("play_type", Integer.valueOf(ah.a((c)this, this.g)));
    d.a(this.a.get(), this.b, "fullscreen_interstitial_ad", "play_pause", o(), q(), map);
  }
  
  public void d() {
    Map<String, Integer> map = B();
    map.put("play_type", Integer.valueOf(ah.a((c)this, this.g)));
    d.a(this.a.get(), this.b, "fullscreen_interstitial_ad", "continue_play", this.h, q(), map);
  }
  
  public void e() {
    Map<String, Integer> map = A();
    map.put("play_type", Integer.valueOf(ah.a((c)this, this.g)));
    d.j(this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", map);
  }
  
  public void f() {
    Map<String, Integer> map = A();
    map.put("play_type", Integer.valueOf(ah.a((c)this, this.g)));
    d.j(this.a.get(), this.b, "fullscreen_interstitial_ad", "feed_play", map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\reward\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */