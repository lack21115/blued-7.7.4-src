package com.qq.e.comm.pi;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.ViewGroup;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.ads.hybrid.HybridADListener;
import com.qq.e.ads.hybrid.HybridADSetting;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADListener;
import java.util.HashMap;
import org.json.JSONObject;

public interface POFactory {
  void config(int paramInt, String paramString);
  
  SVSD getAPKDownloadServiceDelegate(Service paramService);
  
  ACTD getActivityDelegate(String paramString, Activity paramActivity);
  
  RVADI2 getExpressRewardVideoADDelegate(Context paramContext, String paramString1, String paramString2, ADListener paramADListener);
  
  DFA getGDTApkDelegate(IGDTApkListener paramIGDTApkListener);
  
  HADI getHybridAD(HybridADSetting paramHybridADSetting, HybridADListener paramHybridADListener);
  
  NUADI getNativeAdManagerDelegate(Context paramContext, String paramString1, String paramString2, ADListener paramADListener);
  
  NEADI getNativeExpressADDelegate(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, ADListener paramADListener);
  
  NEIADI getNativeExpressADDelegate2(Context paramContext, String paramString1, String paramString2, ADListener paramADListener);
  
  NEADVI getNativeExpressADView(NEADI paramNEADI, Context paramContext, ViewGroup paramViewGroup, ADSize paramADSize, String paramString1, String paramString2, JSONObject paramJSONObject, HashMap<String, JSONObject> paramHashMap);
  
  NSPVI getNativeSplashAdView(Context paramContext, String paramString1, String paramString2);
  
  RVADI getRewardVideoADDelegate(Context paramContext, String paramString1, String paramString2, ADListener paramADListener);
  
  UBVI getUnifiedBannerViewDelegate(UnifiedBannerView paramUnifiedBannerView, Activity paramActivity, String paramString1, String paramString2, UnifiedBannerADListener paramUnifiedBannerADListener);
  
  UIADI getUnifiedInterstitialADDelegate(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener);
  
  WRI getWebReporterDelegate(String paramString, long paramLong);
  
  void trackEvent(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\pi\POFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */