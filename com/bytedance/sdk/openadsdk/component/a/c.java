package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.e.a;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.w;

class c extends a implements TTFeedAd, c.b, c.c, a.a {
  a a;
  
  boolean b = false;
  
  boolean c = true;
  
  int d;
  
  AdSlot e;
  
  int f;
  
  private TTFeedAd.VideoAdListener m;
  
  c(Context paramContext, k paramk, int paramInt) {
    super(paramContext, paramk, paramInt);
    this.f = paramInt;
    this.a = new a();
    this.d = ah.d(this.h.P());
    a(this.d);
  }
  
  c(Context paramContext, k paramk, int paramInt, AdSlot paramAdSlot) {
    super(paramContext, paramk, paramInt);
    this.f = paramInt;
    this.e = paramAdSlot;
    this.a = new a();
    this.d = ah.d(this.h.P());
    a(this.d);
  }
  
  private void a(int paramInt) {
    paramInt = o.h().c(paramInt);
    if (3 == paramInt) {
      this.b = false;
      this.c = false;
      return;
    } 
    if (1 == paramInt && w.d(this.i)) {
      this.b = false;
      this.c = true;
      return;
    } 
    if (2 == paramInt) {
      if (w.e(this.i) || w.d(this.i)) {
        this.b = false;
        this.c = true;
        return;
      } 
    } else if (4 == paramInt) {
      this.b = true;
    } 
  }
  
  public a a() {
    return this.a;
  }
  
  public void a(int paramInt1, int paramInt2) {
    TTFeedAd.VideoAdListener videoAdListener = this.m;
    if (videoAdListener != null)
      videoAdListener.onVideoError(paramInt1, paramInt2); 
  }
  
  public void a(long paramLong1, long paramLong2) {
    TTFeedAd.VideoAdListener videoAdListener = this.m;
    if (videoAdListener != null)
      videoAdListener.onProgressUpdate(paramLong1, paramLong2); 
  }
  
  public void c() {
    TTFeedAd.VideoAdListener videoAdListener = this.m;
    if (videoAdListener != null)
      videoAdListener.onVideoAdContinuePlay(this); 
  }
  
  public void d() {
    TTFeedAd.VideoAdListener videoAdListener = this.m;
    if (videoAdListener != null)
      videoAdListener.onVideoAdPaused(this); 
  }
  
  public void d_() {
    TTFeedAd.VideoAdListener videoAdListener = this.m;
    if (videoAdListener != null)
      videoAdListener.onVideoAdComplete(this); 
  }
  
  public void e() {
    TTFeedAd.VideoAdListener videoAdListener = this.m;
    if (videoAdListener != null)
      videoAdListener.onVideoAdStartPlay(this); 
  }
  
  public void f() {
    TTFeedAd.VideoAdListener videoAdListener = this.m;
    if (videoAdListener != null)
      videoAdListener.onVideoLoad(this); 
  }
  
  boolean g() {
    return (getImageMode() == 5 || getImageMode() == 15);
  }
  
  public View getAdView() {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   4: ifnull -> 152
    //   7: aload_0
    //   8: getfield i : Landroid/content/Context;
    //   11: ifnonnull -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual g : ()Z
    //   20: ifeq -> 125
    //   23: new com/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView
    //   26: dup
    //   27: aload_0
    //   28: getfield i : Landroid/content/Context;
    //   31: aload_0
    //   32: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   35: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/sdk/openadsdk/core/d/k;)V
    //   38: astore_2
    //   39: aload_2
    //   40: new com/bytedance/sdk/openadsdk/component/a/c$1
    //   43: dup
    //   44: aload_0
    //   45: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/a/c;)V
    //   48: invokevirtual setControllerStatusCallBack : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView$a;)V
    //   51: aload_2
    //   52: aload_0
    //   53: invokevirtual setVideoAdLoadListener : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c$c;)V
    //   56: aload_2
    //   57: aload_0
    //   58: invokevirtual setVideoAdInteractionListener : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c$b;)V
    //   61: iconst_5
    //   62: aload_0
    //   63: getfield f : I
    //   66: if_icmpne -> 100
    //   69: aload_0
    //   70: getfield b : Z
    //   73: ifeq -> 87
    //   76: aload_0
    //   77: getfield e : Lcom/bytedance/sdk/openadsdk/AdSlot;
    //   80: invokevirtual isAutoPlay : ()Z
    //   83: istore_1
    //   84: goto -> 92
    //   87: aload_0
    //   88: getfield c : Z
    //   91: istore_1
    //   92: aload_2
    //   93: iload_1
    //   94: invokevirtual setIsAutoPlay : (Z)V
    //   97: goto -> 108
    //   100: aload_2
    //   101: aload_0
    //   102: getfield c : Z
    //   105: invokevirtual setIsAutoPlay : (Z)V
    //   108: aload_2
    //   109: invokestatic h : ()Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   112: aload_0
    //   113: getfield d : I
    //   116: invokevirtual a : (I)Z
    //   119: invokevirtual setIsQuiet : (Z)V
    //   122: goto -> 127
    //   125: aconst_null
    //   126: astore_2
    //   127: aload_0
    //   128: invokevirtual g : ()Z
    //   131: ifeq -> 152
    //   134: aload_2
    //   135: ifnull -> 152
    //   138: aload_2
    //   139: lconst_0
    //   140: iconst_1
    //   141: iconst_0
    //   142: invokevirtual a : (JZZ)Z
    //   145: ifne -> 150
    //   148: aconst_null
    //   149: areturn
    //   150: aload_2
    //   151: areturn
    //   152: aconst_null
    //   153: areturn
    //   154: astore_2
    //   155: goto -> 125
    // Exception table:
    //   from	to	target	type
    //   23	84	154	java/lang/Exception
    //   87	92	154	java/lang/Exception
    //   92	97	154	java/lang/Exception
    //   100	108	154	java/lang/Exception
    //   108	122	154	java/lang/Exception
  }
  
  public double getVideoDuration() {
    return (this.h != null && this.h.z() != null) ? this.h.z().d() : 0.0D;
  }
  
  public void setVideoAdListener(TTFeedAd.VideoAdListener paramVideoAdListener) {
    this.m = paramVideoAdListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */