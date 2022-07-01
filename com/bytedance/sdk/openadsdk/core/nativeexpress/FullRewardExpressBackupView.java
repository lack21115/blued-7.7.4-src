package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;
import com.bytedance.sdk.openadsdk.utils.t;

public class FullRewardExpressBackupView extends BackupView {
  private View h;
  
  private NativeExpressView i;
  
  private FrameLayout j;
  
  private a k;
  
  public FullRewardExpressBackupView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
  }
  
  private void b() {
    this.f = ai.c(this.a, this.i.getExpectExpressWidth());
    this.g = ai.c(this.a, this.i.getExpectExpressWidth());
    ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
    ViewGroup.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new ViewGroup.LayoutParams(this.f, this.g); 
    layoutParams1.width = this.f;
    layoutParams1.height = this.g;
    if (layoutParams1 instanceof FrameLayout.LayoutParams)
      ((FrameLayout.LayoutParams)layoutParams1).gravity = 17; 
    setLayoutParams(layoutParams1);
    this.b.h();
    c();
  }
  
  private void c() {
    this.h = LayoutInflater.from(this.a).inflate(ab.f(this.a, "tt_backup_full_reward"), (ViewGroup)this, true);
    this.j = (FrameLayout)this.h.findViewById(ab.e(this.a, "tt_bu_video_container"));
    this.j.removeAllViews();
  }
  
  protected void a(int paramInt, i parami) {
    NativeExpressView nativeExpressView = this.i;
    if (nativeExpressView != null)
      nativeExpressView.a(paramInt, parami); 
  }
  
  public void a(k paramk, NativeExpressView paramNativeExpressView, a parama) {
    t.b("FullRewardExpressBackupView", "show backup view");
    setBackgroundColor(-1);
    this.b = paramk;
    this.i = paramNativeExpressView;
    this.k = parama;
    if (ah.c(this.b.P()) == 7) {
      this.e = "rewarded_video";
    } else {
      this.e = "fullscreen_interstitial_ad";
    } 
    b();
    this.i.addView((View)this, new ViewGroup.LayoutParams(-2, -2));
  }
  
  public FrameLayout getVideoContainer() {
    return this.j;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\FullRewardExpressBackupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */