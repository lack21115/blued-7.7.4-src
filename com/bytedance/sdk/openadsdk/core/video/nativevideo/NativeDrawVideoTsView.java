package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.g.e;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;

public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
  private boolean n = false;
  
  public NativeDrawVideoTsView(Context paramContext, k paramk) {
    super(paramContext, paramk);
    setOnClickListener(this);
  }
  
  private void d() {
    ai.a((View)this.e, 0);
    ai.a((View)this.f, 0);
    ai.a((View)this.h, 8);
  }
  
  private void i() {
    f();
    if (this.e != null) {
      if (this.e.getVisibility() == 0)
        return; 
      e.a(getContext()).a(this.a.z().f(), this.f);
    } 
    d();
  }
  
  public void a(Bitmap paramBitmap, int paramInt) {
    h.c().a(paramBitmap);
    this.j = paramInt;
  }
  
  protected void b() {
    this.d = false;
    this.i = "draw_ad";
    int i = ah.d(this.a.P());
    o.h().s(String.valueOf(i));
    super.b();
  }
  
  protected void c() {
    if (this.n)
      super.c(); 
  }
  
  public void onClick(View paramView) {
    if (this.g != null && this.g.getVisibility() == 0)
      ai.d((View)this.e); 
    c();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    if (this.g != null && this.g.getVisibility() == 0) {
      i();
      return;
    } 
    super.onWindowFocusChanged(paramBoolean);
  }
  
  protected void onWindowVisibilityChanged(int paramInt) {
    if (this.g != null && this.g.getVisibility() == 0) {
      i();
      return;
    } 
    super.onWindowVisibilityChanged(paramInt);
  }
  
  public void setCanInterruptVideoPlay(boolean paramBoolean) {
    this.n = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\nativevideo\NativeDrawVideoTsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */