package com.qq.e.comm.plugin;

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
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.DFA;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.pi.NEIADI;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.pi.WRI;
import com.qq.e.comm.plugin.h.b;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.plugin.util.ax;
import com.qq.e.comm.plugin.util.b;
import com.qq.e.comm.plugin.util.l;
import com.qq.e.comm.plugin.util.o;
import com.qq.e.comm.plugin.x.a;
import java.util.HashMap;
import org.json.JSONObject;
import yaq.gdtadv;

public class POFactoryImpl implements POFactory {
  public static final String DETAIL_PAGE = "detailPage";
  
  public static final String DownloadManage = "downloadManage";
  
  public static final String HYBRID_AD_PAGE = "hybridADPage";
  
  public static final String InnerBrowser = "innerBrowser";
  
  public static final String InterstitialFullScreen = "interstitialFullScreen";
  
  public static final String RewardPage = "rewardPage";
  
  public static final String RewardVideo = "rewardVideo";
  
  public static final String RewardVideo2 = "rewardVideo2";
  
  private static final POFactory a = new POFactoryImpl();
  
  private POFactoryImpl() {
    a.a().b();
    Context context = GDTADManager.getInstance().getAppContext();
    if (context != null)
      b.d.a(context); 
    ax.a(context);
    l.a(o.b()).a();
    ab.a().b();
    b.b(context);
  }
  
  public static POFactory getInstance() {
    return (POFactory)gdtadv.getobjresult(38, 1, new Object[0]);
  }
  
  public void config(int paramInt, String paramString) {
    gdtadv.getVresult(39, 0, new Object[] { this, Integer.valueOf(paramInt), paramString });
  }
  
  public SVSD getAPKDownloadServiceDelegate(Service paramService) {
    return (SVSD)gdtadv.getobjresult(40, 0, new Object[] { this, paramService });
  }
  
  public ACTD getActivityDelegate(String paramString, Activity paramActivity) {
    return (ACTD)gdtadv.getobjresult(41, 0, new Object[] { this, paramString, paramActivity });
  }
  
  public RVADI2 getExpressRewardVideoADDelegate(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    return (RVADI2)gdtadv.getobjresult(42, 0, new Object[] { this, paramContext, paramString1, paramString2, paramADListener });
  }
  
  public DFA getGDTApkDelegate(IGDTApkListener paramIGDTApkListener) {
    return (DFA)gdtadv.getobjresult(43, 0, new Object[] { this, paramIGDTApkListener });
  }
  
  public HADI getHybridAD(HybridADSetting paramHybridADSetting, HybridADListener paramHybridADListener) {
    return (HADI)gdtadv.getobjresult(44, 0, new Object[] { this, paramHybridADSetting, paramHybridADListener });
  }
  
  public NUADI getNativeAdManagerDelegate(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    return (NUADI)gdtadv.getobjresult(45, 0, new Object[] { this, paramContext, paramString1, paramString2, paramADListener });
  }
  
  public NEADI getNativeExpressADDelegate(Context paramContext, ADSize paramADSize, String paramString1, String paramString2, ADListener paramADListener) {
    return (NEADI)gdtadv.getobjresult(46, 0, new Object[] { this, paramContext, paramADSize, paramString1, paramString2, paramADListener });
  }
  
  public NEIADI getNativeExpressADDelegate2(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    return (NEIADI)gdtadv.getobjresult(47, 0, new Object[] { this, paramContext, paramString1, paramString2, paramADListener });
  }
  
  public NEADVI getNativeExpressADView(NEADI paramNEADI, Context paramContext, ViewGroup paramViewGroup, ADSize paramADSize, String paramString1, String paramString2, JSONObject paramJSONObject, HashMap<String, JSONObject> paramHashMap) {
    return (NEADVI)gdtadv.getobjresult(48, 0, new Object[] { this, paramNEADI, paramContext, paramViewGroup, paramADSize, paramString1, paramString2, paramJSONObject, paramHashMap });
  }
  
  public NSPVI getNativeSplashAdView(Context paramContext, String paramString1, String paramString2) {
    return (NSPVI)gdtadv.getobjresult(49, 0, new Object[] { this, paramContext, paramString1, paramString2 });
  }
  
  public RVADI getRewardVideoADDelegate(Context paramContext, String paramString1, String paramString2, ADListener paramADListener) {
    return (RVADI)gdtadv.getobjresult(50, 0, new Object[] { this, paramContext, paramString1, paramString2, paramADListener });
  }
  
  public UBVI getUnifiedBannerViewDelegate(UnifiedBannerView paramUnifiedBannerView, Activity paramActivity, String paramString1, String paramString2, UnifiedBannerADListener paramUnifiedBannerADListener) {
    return (UBVI)gdtadv.getobjresult(51, 0, new Object[] { this, paramUnifiedBannerView, paramActivity, paramString1, paramString2, paramUnifiedBannerADListener });
  }
  
  public UIADI getUnifiedInterstitialADDelegate(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    return (UIADI)gdtadv.getobjresult(52, 0, new Object[] { this, paramActivity, paramString1, paramString2, paramUnifiedInterstitialADListener });
  }
  
  public WRI getWebReporterDelegate(String paramString, long paramLong) {
    return (WRI)gdtadv.getobjresult(53, 0, new Object[] { this, paramString, Long.valueOf(paramLong) });
  }
  
  public void trackEvent(int paramInt) {
    gdtadv.getVresult(54, 0, new Object[] { this, Integer.valueOf(paramInt) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\POFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */