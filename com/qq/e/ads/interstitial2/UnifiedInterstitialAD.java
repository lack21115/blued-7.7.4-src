package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.a;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class UnifiedInterstitialAD {
  private UIADI a;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private boolean d = false;
  
  private AtomicInteger e = new AtomicInteger(0);
  
  private AtomicInteger f = new AtomicInteger(0);
  
  private volatile UnifiedInterstitialMediaListener g;
  
  private volatile VideoOption h;
  
  private volatile int i;
  
  private volatile int j;
  
  private volatile int k;
  
  public UnifiedInterstitialAD(Activity paramActivity, String paramString, UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    this(paramActivity, paramString, paramUnifiedInterstitialADListener, (Map)null);
  }
  
  public UnifiedInterstitialAD(Activity paramActivity, String paramString, UnifiedInterstitialADListener paramUnifiedInterstitialADListener, Map paramMap) {
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramActivity, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString, paramUnifiedInterstitialADListener, paramMap);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    paramUnifiedInterstitialADListener.onNoAD(a.a(2003));
  }
  
  @Deprecated
  public UnifiedInterstitialAD(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener) {
    this(paramActivity, paramString1, paramString2, paramUnifiedInterstitialADListener, null);
  }
  
  @Deprecated
  public UnifiedInterstitialAD(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener, Map paramMap) {
    GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
    a(paramActivity, paramString1, paramString2, paramUnifiedInterstitialADListener, paramMap);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, UnifiedInterstitialADListener paramUnifiedInterstitialADListener, Map paramMap) {
    String str;
    if (StringUtil.isEmpty(paramString1) || StringUtil.isEmpty(paramString2) || paramActivity == null || paramUnifiedInterstitialADListener == null) {
      str = String.format("UnifiedInterstitialAD Constructor paras error, appid=%s,posId=%s,context=%s,listener=%s", new Object[] { paramString1, paramString2, paramActivity, paramUnifiedInterstitialADListener });
    } else {
      this.b = true;
      if (!a.a((Context)str)) {
        str = "Required Activity/Service/Permission Not Declared in AndroidManifest.xml";
      } else {
        this.c = true;
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, (Activity)str, paramString1, paramString2, paramUnifiedInterstitialADListener, paramMap) {
              public void run() {
                if (GDTADManager.getInstance().initWith((Context)this.a, this.b))
                  try {
                    return;
                  } finally {
                    Exception exception = null;
                    GDTLogger.e("Exception while init UnifiedInterstitialAD plugin", exception);
                  }  
                GDTLogger.e("Fail to init ADManager");
              }
            });
        return;
      } 
    } 
    GDTLogger.e(str);
  }
  
  public void close() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.close(); 
  }
  
  public void destroy() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.destory(); 
  }
  
  public String getAdNetWorkName() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      return uIADI.getAdNetWorkName(); 
    GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdNetWorkName");
    return null;
  }
  
  public int getAdPatternType() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      return uIADI.getAdPatternType(); 
    GDTLogger.e("InterstitialAD init failed or not inited, can't call getAdPatternType");
    return 0;
  }
  
  public int getECPM() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      return uIADI.getECPM(); 
    GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPM");
    return -1;
  }
  
  public String getECPMLevel() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      return uIADI.getECPMLevel(); 
    GDTLogger.e("InterstitialAD init failed or not inited, can't call getECPMLevel");
    return null;
  }
  
  public Map getExt() {
    try {
      if (this.a != null)
        return UIADI.ext; 
    } catch (Exception exception) {
      GDTLogger.e("interstitial2 can not get ext");
    } 
    return null;
  }
  
  public boolean isValid() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      return uIADI.isValid(); 
    GDTLogger.e("InterstitialAD init failed or not inited, can't call isValid");
    return false;
  }
  
  public void loadAD() {
    String str;
    if (!this.b || !this.c) {
      str = "InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD";
    } else {
      if (!this.d) {
        this.e.incrementAndGet();
        return;
      } 
      UIADI uIADI = this.a;
      if (uIADI != null) {
        uIADI.loadAd();
        return;
      } 
      str = "InterstitialAD Init error,See More Logs";
    } 
    GDTLogger.e(str);
  }
  
  public void loadFullScreenAD() {
    String str;
    if (!this.b || !this.c) {
      str = "InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD";
    } else {
      if (!this.d) {
        this.f.incrementAndGet();
        return;
      } 
      UIADI uIADI = this.a;
      if (uIADI != null) {
        uIADI.loadFullScreenAD();
        return;
      } 
      str = "InterstitialAD Init error,See More Logs";
    } 
    GDTLogger.e(str);
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.k = paramInt;
    if (this.k > 0 && this.j > this.k)
      GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration"); 
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.setMaxVideoDuration(paramInt); 
  }
  
  public void setMediaListener(UnifiedInterstitialMediaListener paramUnifiedInterstitialMediaListener) {
    this.g = paramUnifiedInterstitialMediaListener;
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.setMediaListener(paramUnifiedInterstitialMediaListener); 
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.j = paramInt;
    if (this.k > 0 && this.j > this.k)
      GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration"); 
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.setMinVideoDuration(paramInt); 
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.h = paramVideoOption;
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.setVideoOption(paramVideoOption); 
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.i = paramInt;
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.setVideoPlayPolicy(paramInt); 
  }
  
  public void show() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.show(); 
  }
  
  public void show(Activity paramActivity) {
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.show(paramActivity); 
  }
  
  public void showAsPopupWindow() {
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.showAsPopupWindow(); 
  }
  
  public void showAsPopupWindow(Activity paramActivity) {
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.showAsPopupWindow(paramActivity); 
  }
  
  public void showFullScreenAD(Activity paramActivity) {
    UIADI uIADI = this.a;
    if (uIADI != null)
      uIADI.showFullScreenAD(paramActivity); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\interstitial2\UnifiedInterstitialAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */