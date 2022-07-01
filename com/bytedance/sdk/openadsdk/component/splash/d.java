package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import java.util.Map;

public class d extends a {
  private boolean i = false;
  
  d(Context paramContext, ViewGroup paramViewGroup, k paramk) {
    super(paramContext, paramViewGroup, paramk);
  }
  
  public int a() {
    return 3;
  }
  
  public void a(int paramInt1, int paramInt2) {
    String str;
    if (this.b == null)
      return; 
    if (paramInt1 == 308)
      return; 
    boolean bool = z();
    if (bool) {
      str = "play_error";
    } else {
      str = "play_start_error";
    } 
    Map<String, Long> map = ah.a(this.b, paramInt1, paramInt2, t());
    if (bool) {
      map.put("duration", Long.valueOf(o()));
      map.put("percent", Integer.valueOf(q()));
      map.put("buffers_time", Long.valueOf(n()));
    } 
    com.bytedance.sdk.openadsdk.c.d.k(this.a.get(), this.b, "splash_ad", str, map);
  }
  
  public void b() {
    if (!this.i) {
      this.i = true;
      com.bytedance.sdk.openadsdk.c.d.a(this.a.get(), this.b, "splash_ad", "feed_over", this.c, 100, B());
    } 
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {
    com.bytedance.sdk.openadsdk.c.d.j(this.a.get(), this.b, "splash_ad", "feed_play", A());
  }
  
  public void f() {
    com.bytedance.sdk.openadsdk.c.d.j(this.a.get(), this.b, "splash_ad", "feed_play", A());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\splash\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */