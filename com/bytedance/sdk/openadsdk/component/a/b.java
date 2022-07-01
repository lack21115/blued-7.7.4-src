package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.w;

public class b extends c implements TTDrawFeedAd {
  private boolean m;
  
  private Bitmap n;
  
  private int o;
  
  private TTDrawFeedAd.DrawVideoListener p;
  
  public b(Context paramContext, k paramk, int paramInt) {
    super(paramContext, paramk, paramInt);
  }
  
  private boolean a(int paramInt) {
    paramInt = o.h().c(paramInt);
    return (3 == paramInt) ? false : (((1 == paramInt && w.d(this.i)) || (2 == paramInt && (w.e(this.i) || w.d(this.i)))));
  }
  
  private void h() {
    int i = this.o;
    if (i >= 200) {
      this.o = 200;
      return;
    } 
    if (i <= 20)
      this.o = 20; 
  }
  
  public View getAdView() {
    // Byte code:
    //   0: aload_0
    //   1: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   4: ifnull -> 163
    //   7: aload_0
    //   8: getfield i : Landroid/content/Context;
    //   11: ifnonnull -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual g : ()Z
    //   20: ifeq -> 136
    //   23: new com/bytedance/sdk/openadsdk/core/video/nativevideo/NativeDrawVideoTsView
    //   26: dup
    //   27: aload_0
    //   28: getfield i : Landroid/content/Context;
    //   31: aload_0
    //   32: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   35: invokespecial <init> : (Landroid/content/Context;Lcom/bytedance/sdk/openadsdk/core/d/k;)V
    //   38: astore_2
    //   39: aload_2
    //   40: new com/bytedance/sdk/openadsdk/component/a/b$1
    //   43: dup
    //   44: aload_0
    //   45: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/component/a/b;)V
    //   48: invokevirtual setControllerStatusCallBack : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/NativeVideoTsView$a;)V
    //   51: aload_2
    //   52: aload_0
    //   53: invokevirtual setVideoAdLoadListener : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c$c;)V
    //   56: aload_2
    //   57: aload_0
    //   58: invokevirtual setVideoAdInteractionListener : (Lcom/bytedance/sdk/openadsdk/core/video/nativevideo/c$b;)V
    //   61: aload_0
    //   62: getfield h : Lcom/bytedance/sdk/openadsdk/core/d/k;
    //   65: invokevirtual P : ()Ljava/lang/String;
    //   68: invokestatic d : (Ljava/lang/String;)I
    //   71: istore_1
    //   72: aload_2
    //   73: aload_0
    //   74: iload_1
    //   75: invokespecial a : (I)Z
    //   78: invokevirtual setIsAutoPlay : (Z)V
    //   81: aload_2
    //   82: invokestatic h : ()Lcom/bytedance/sdk/openadsdk/core/h/l;
    //   85: iload_1
    //   86: invokevirtual a : (I)Z
    //   89: invokevirtual setIsQuiet : (Z)V
    //   92: aload_2
    //   93: checkcast com/bytedance/sdk/openadsdk/core/video/nativevideo/NativeDrawVideoTsView
    //   96: aload_0
    //   97: getfield m : Z
    //   100: invokevirtual setCanInterruptVideoPlay : (Z)V
    //   103: aload_0
    //   104: getfield n : Landroid/graphics/Bitmap;
    //   107: ifnull -> 125
    //   110: aload_2
    //   111: checkcast com/bytedance/sdk/openadsdk/core/video/nativevideo/NativeDrawVideoTsView
    //   114: aload_0
    //   115: getfield n : Landroid/graphics/Bitmap;
    //   118: aload_0
    //   119: getfield o : I
    //   122: invokevirtual a : (Landroid/graphics/Bitmap;I)V
    //   125: aload_2
    //   126: aload_0
    //   127: getfield p : Lcom/bytedance/sdk/openadsdk/TTDrawFeedAd$DrawVideoListener;
    //   130: invokevirtual setDrawVideoListener : (Lcom/bytedance/sdk/openadsdk/TTDrawFeedAd$DrawVideoListener;)V
    //   133: goto -> 138
    //   136: aconst_null
    //   137: astore_2
    //   138: aload_0
    //   139: invokevirtual g : ()Z
    //   142: ifeq -> 163
    //   145: aload_2
    //   146: ifnull -> 163
    //   149: aload_2
    //   150: lconst_0
    //   151: iconst_1
    //   152: iconst_0
    //   153: invokevirtual a : (JZZ)Z
    //   156: ifne -> 161
    //   159: aconst_null
    //   160: areturn
    //   161: aload_2
    //   162: areturn
    //   163: aconst_null
    //   164: areturn
    //   165: astore_2
    //   166: goto -> 136
    // Exception table:
    //   from	to	target	type
    //   23	125	165	java/lang/Exception
    //   125	133	165	java/lang/Exception
  }
  
  public void setCanInterruptVideoPlay(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener paramDrawVideoListener) {
    this.p = paramDrawVideoListener;
  }
  
  public void setPauseIcon(Bitmap paramBitmap, int paramInt) {
    this.n = paramBitmap;
    this.o = paramInt;
    h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\component\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */