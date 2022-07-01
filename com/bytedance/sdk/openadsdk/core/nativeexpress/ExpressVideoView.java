package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.h;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;

public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
  private boolean n = false;
  
  public ExpressVideoView(Context paramContext, k paramk, String paramString) {
    super(paramContext, paramk, false, paramString);
    if ("draw_ad".equals(paramString))
      this.n = true; 
    setOnClickListener(this);
  }
  
  private void i() {
    ai.a((View)this.e, 0);
    ai.a((View)this.f, 0);
    ai.a((View)this.h, 8);
  }
  
  private void j() {
    f();
    if (this.e != null) {
      if (this.e.getVisibility() == 0)
        return; 
      e.a(getContext()).a(this.a.z().f(), this.f);
    } 
    i();
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {
    this.d = false;
    int i = ah.d(this.a.P());
    o.h().s(String.valueOf(i));
    super.b();
  }
  
  public void c() {
    if (this.n)
      super.c(); 
  }
  
  public void d() {
    if (this.h != null)
      ai.a((View)this.h, 8); 
  }
  
  public void onClick(View paramView) {
    if (this.g != null && this.g.getVisibility() == 0)
      ai.d((View)this.e); 
    c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    if (this.g != null && this.g.getVisibility() == 0) {
      j();
      return;
    } 
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void onWindowVisibilityChanged(int paramInt) {
    if (this.g != null && this.g.getVisibility() == 0) {
      j();
      return;
    } 
    super.onWindowVisibilityChanged(paramInt);
  }
  
  public void setCanInterruptVideoPlay(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public void setShouldCheckNetChange(boolean paramBoolean) {
    if (this.b != null)
      this.b.f(paramBoolean); 
  }
  
  public void setShowAdInteractionView(boolean paramBoolean) {
    if (this.b != null) {
      h h = this.b.u();
      if (h != null)
        h.d(paramBoolean); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\ExpressVideoView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */