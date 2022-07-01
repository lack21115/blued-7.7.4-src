package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.w;

public class a extends b {
  private TTDrawFeedAd.DrawVideoListener C;
  
  private int D;
  
  private boolean a = true;
  
  private boolean b = false;
  
  public a(Context paramContext, k paramk, String paramString, int paramInt) {
    super(paramContext, paramk, paramString, paramInt);
  }
  
  private String a(String paramString) {
    byte b1;
    switch (paramString.hashCode()) {
      default:
        b1 = -1;
        break;
      case 2091589896:
        if (paramString.equals("slide_banner_ad")) {
          b1 = 3;
          break;
        } 
      case 1912999166:
        if (paramString.equals("draw_ad")) {
          b1 = 1;
          break;
        } 
      case 1844104722:
        if (paramString.equals("interaction")) {
          b1 = 4;
          break;
        } 
      case 174971131:
        if (paramString.equals("splash_ad")) {
          b1 = 5;
          break;
        } 
      case -712491894:
        if (paramString.equals("embeded_ad")) {
          b1 = 0;
          break;
        } 
      case -1695837674:
        if (paramString.equals("banner_ad")) {
          b1 = 2;
          break;
        } 
    } 
    return (b1 != 0 && b1 != 1) ? ((b1 != 2 && b1 != 3) ? ((b1 != 4) ? ((b1 != 5) ? "" : "splash_ad") : "interaction_call") : "banner_call") : "feed_call";
  }
  
  private boolean c(View paramView) {
    if (paramView == null)
      return false; 
    if (paramView instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView) {
      t.c("ClickCreativeListener", "NativeVideoTsView....");
      return true;
    } 
    if (paramView.getId() == ab.e(this.c, "tt_video_ad_cover_center_layout") || paramView.getId() == ab.e(this.c, "tt_video_ad_logo_image") || paramView.getId() == ab.e(this.c, "tt_video_btn_ad_image_tv") || paramView.getId() == ab.e(this.c, "tt_video_ad_name") || paramView.getId() == ab.e(this.c, "tt_video_ad_button")) {
      t.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
      return true;
    } 
    if (paramView.getId() == ab.e(this.c, "tt_root_view") || paramView.getId() == ab.e(this.c, "tt_video_play")) {
      t.c("ClickCreativeListener", "tt_root_view....");
      return true;
    } 
    if (paramView instanceof ViewGroup) {
      int i = 0;
      while (true) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        if (i < viewGroup.getChildCount()) {
          if (c(viewGroup.getChildAt(i)))
            return true; 
          i++;
          continue;
        } 
        break;
      } 
    } 
    return false;
  }
  
  private boolean d() {
    k k = this.d;
    null = true;
    if (k != null && this.d.e() == 1)
      if (this.d.Q() != 5) {
        if (this.d.Q() == 15)
          return true; 
      } else {
        return null;
      }  
    return false;
  }
  
  private boolean e() {
    return (this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.d);
  }
  
  private boolean f() {
    if (this.d == null)
      return false; 
    if (e())
      return false; 
    if (this.d.Q() != 5 && this.d.Q() != 15)
      return false; 
    if (this.D == 0)
      this.D = ah.c(this.d.P()); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("!isViewVisibility()=");
    stringBuilder.append(b() ^ true);
    stringBuilder.append(",isAutoPlay()=");
    stringBuilder.append(a());
    stringBuilder.append(",!isCoverPageVisibility()=");
    stringBuilder.append(c() ^ true);
    t.b("ClickCreativeListener", stringBuilder.toString());
    if (this.D == 5 && d() && a() && !b() && !c())
      return false; 
    int i = this.D;
    return !(i != 1 && i != 2 && i != 5);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    View view1;
    View view2;
    if (a(2))
      return; 
    if (f() && c(paramView)) {
      t.b("ClickCreativeListener", "拦截原生视频view走普通点击事件.....");
      super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    } 
    t.b("ClickCreativeListener", "走创意区域点击事件.....");
    if (this.c == null)
      this.c = o.a(); 
    if (this.c == null)
      return; 
    long l1 = this.v;
    long l2 = this.w;
    if (this.g == null) {
      view1 = null;
    } else {
      view1 = this.g.get();
    } 
    if (this.h == null) {
      view2 = null;
    } else {
      view2 = this.h.get();
    } 
    this.i = a(paramInt1, paramInt2, paramInt3, paramInt4, l1, l2, view1, view2);
    paramInt2 = this.d.B();
    if (paramInt2 != 2 && paramInt2 != 3) {
      if (paramInt2 != 4) {
        if (paramInt2 != 5) {
          paramInt1 = -1;
        } else {
          String str = a(this.e);
          if (!TextUtils.isEmpty(str))
            d.a(this.c, "click_call", this.d, this.i, str, true, this.o); 
          boolean bool = ah.e(paramView.getContext(), this.d.G());
          d.a(this.c, "click", this.d, this.i, this.e, bool, this.o);
          paramInt1 = paramInt2;
        } 
      } else if (this.d.q() && (this.k != null || this.p != null)) {
        boolean bool = z.a(this.c, this.d, this.f, this.k, this.p, this.e, this.n, true);
        paramInt1 = paramInt2;
        if (this.a) {
          d.a(this.c, "click", this.d, this.i, this.e, bool, this.o);
          paramInt1 = paramInt2;
        } 
      } else {
        paramInt1 = paramInt2;
        if (this.n != null) {
          this.n.h();
          paramInt1 = paramInt2;
          if (this.a) {
            paramInt1 = paramInt2;
            if (this.n.e()) {
              d.a(this.c, "click", this.d, this.i, this.e, true, this.o);
              paramInt1 = paramInt2;
            } 
          } 
        } 
      } 
    } else {
      if (this.k != null || this.b)
        d.a(this.c, "click_button", this.d, this.i, this.e, true, this.o); 
      z.a(true);
      boolean bool = z.a(this.c, this.d, this.f, this.k, this.p, ah.a(this.f), this.n, true);
      paramInt1 = paramInt2;
      if (this.a) {
        d.a(this.c, "click", this.d, this.i, this.e, bool, this.o);
        paramInt1 = paramInt2;
      } 
    } 
    if (this.j != null)
      this.j.a(paramView, paramInt1); 
    if (ah.a(this.d)) {
      TTDrawFeedAd.DrawVideoListener drawVideoListener = this.C;
      if (drawVideoListener != null)
        drawVideoListener.onClick(); 
    } 
  }
  
  public void a(TTDrawFeedAd.DrawVideoListener paramDrawVideoListener) {
    this.C = paramDrawVideoListener;
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  protected boolean a() {
    k k = this.d;
    boolean bool = true;
    if (k == null)
      return true; 
    int i = ah.d(this.d.P());
    i = o.h().c(i);
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4);
          return true;
        } 
        return false;
      } 
      if (!w.e(this.c)) {
        if (w.d(this.c))
          return true; 
        bool = false;
      } 
      return bool;
    } 
    return w.d(this.c);
  }
  
  public void b(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public boolean b() {
    return false;
  }
  
  public boolean c() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */