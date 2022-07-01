package com.soft.blued.utils.third;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.DensityUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.soft.blued.utils.Logger;
import java.util.List;

public class TTADUtils {
  public static void a(Context paramContext) {
    Logger.a("ttinit", "start");
    TTAdSdk.init(paramContext, (new TTAdConfig.Builder()).appId("5042793").useTextureView(false).appName("Blued_android").titleBarTheme(1).allowShowNotify(true).allowShowPageWhenScreenLock(false).directDownloadNetworkType(new int[] { 4, 3 }).supportMultiProcess(false).build());
    Logger.a("ttinit", "end");
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, TTGetAdListener paramTTGetAdListener) {
    Logger.a("TTBANNER", "1");
    if (Build.VERSION.SDK_INT < 21) {
      paramTTGetAdListener.a();
      return;
    } 
    AdSlot adSlot = (new AdSlot.Builder()).setCodeId(paramString).setSupportDeepLink(true).setImageAcceptedSize(228, 150).setNativeAdType(5).setAdCount(1).build();
    TTAdManagerHolder.a(paramContext).createAdNative(paramContext).loadNativeAd(adSlot, new TTAdNative.NativeAdListener(paramTTGetAdListener) {
          public void onError(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error:");
            stringBuilder.append(param1Int);
            stringBuilder.append("=");
            stringBuilder.append(param1String);
            Logger.a("TTBANNER", stringBuilder.toString());
            TTADUtils.TTGetAdListener tTGetAdListener = this.a;
            if (tTGetAdListener != null)
              tTGetAdListener.a(); 
          }
          
          public void onNativeAdLoad(List<TTNativeAd> param1List) {
            Logger.a("TTBANNER", "success");
            if (this.a != null) {
              if (param1List != null && param1List.get(0) != null) {
                this.a.a(param1List.get(0));
                return;
              } 
              this.a.b();
            } 
          }
        });
  }
  
  public static void a(Context paramContext, String paramString, TTGetOriginAdListener paramTTGetOriginAdListener) {
    Logger.a("TTBANNER", "1");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("width:");
    stringBuilder.append(60);
    stringBuilder.append(",height:");
    stringBuilder.append(60);
    Logger.a("TTBANNER", stringBuilder.toString());
    AdSlot.Builder builder = (new AdSlot.Builder()).setCodeId(paramString).setSupportDeepLink(true).setAdCount(1).setNativeAdType(5);
    float f = 60;
    AdSlot adSlot = builder.setExpressViewAcceptedSize(f, f).build();
    TTAdManagerHolder.a(paramContext).createAdNative(paramContext).loadNativeAd(adSlot, new TTAdNative.NativeAdListener(paramTTGetOriginAdListener) {
          public void onError(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error:");
            stringBuilder.append(param1Int);
            stringBuilder.append("=");
            stringBuilder.append(param1String);
            Logger.a("TTBANNER", stringBuilder.toString());
            TTADUtils.TTGetOriginAdListener tTGetOriginAdListener = this.a;
            if (tTGetOriginAdListener != null)
              tTGetOriginAdListener.a(); 
          }
          
          public void onNativeAdLoad(List<TTNativeAd> param1List) {
            Logger.a("TTBANNER", "success");
            if (this.a != null) {
              if (param1List != null && param1List.get(0) != null && ((TTNativeAd)param1List.get(0)).getImageList() != null && !((TTNativeAd)param1List.get(0)).getImageList().isEmpty()) {
                this.a.a(param1List.get(0));
                return;
              } 
              this.a.b();
            } 
          }
        });
  }
  
  public static void a(Context paramContext, String paramString, TTGetSplashAdListener paramTTGetSplashAdListener) {
    int i = AppInfo.l;
    int j = AppInfo.m;
    int k = DensityUtils.a(paramContext, 75.0F);
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
      str = "887288373"; 
    AdSlot adSlot = (new AdSlot.Builder()).setCodeId(str).setSupportDeepLink(true).setImageAcceptedSize(i, j - k).build();
    TTAdManagerHolder.a(paramContext).createAdNative(paramContext).loadSplashAd(adSlot, new TTAdNative.SplashAdListener(paramTTGetSplashAdListener) {
          public void onError(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("error:");
            stringBuilder.append(param1Int);
            stringBuilder.append("=");
            stringBuilder.append(param1String);
            Logger.a("TTSPLASH", stringBuilder.toString());
            TTADUtils.TTGetSplashAdListener tTGetSplashAdListener = this.a;
            if (tTGetSplashAdListener != null)
              tTGetSplashAdListener.a(); 
          }
          
          public void onSplashAdLoad(TTSplashAd param1TTSplashAd) {
            TTADUtils.TTGetSplashAdListener tTGetSplashAdListener = this.a;
            if (tTGetSplashAdListener != null)
              tTGetSplashAdListener.a(param1TTSplashAd); 
          }
          
          public void onTimeout() {
            Logger.a("TTSPLASH", "NO AD");
            TTADUtils.TTGetSplashAdListener tTGetSplashAdListener = this.a;
            if (tTGetSplashAdListener != null)
              tTGetSplashAdListener.b(); 
          }
        }300);
  }
  
  public static interface TTGetAdListener {
    void a();
    
    void a(TTNativeAd param1TTNativeAd);
    
    void b();
  }
  
  public static interface TTGetOriginAdListener {
    void a();
    
    void a(TTNativeAd param1TTNativeAd);
    
    void b();
  }
  
  public static interface TTGetSplashAdListener {
    void a();
    
    void a(TTSplashAd param1TTSplashAd);
    
    void b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\third\TTADUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */