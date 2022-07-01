package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.a;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class UnifiedBannerView extends FrameLayout {
  private UBVI a;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private boolean d = false;
  
  private DownAPPConfirmPolicy e;
  
  private AtomicInteger f = new AtomicInteger(0);
  
  private int g = 30;
  
  private LoadAdParams h = null;
  
  public UnifiedBannerView(Activity paramActivity, String paramString, UnifiedBannerADListener paramUnifiedBannerADListener) {
    this(paramActivity, paramString, paramUnifiedBannerADListener, (Map)null);
  }
  
  public UnifiedBannerView(Activity paramActivity, String paramString, UnifiedBannerADListener paramUnifiedBannerADListener, Map paramMap) {
    super((Context)paramActivity);
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramActivity, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString, paramUnifiedBannerADListener, paramMap);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    paramUnifiedBannerADListener.onNoAD(a.a(2003));
  }
  
  @Deprecated
  public UnifiedBannerView(Activity paramActivity, String paramString1, String paramString2, UnifiedBannerADListener paramUnifiedBannerADListener) {
    this(paramActivity, paramString1, paramString2, paramUnifiedBannerADListener, null);
  }
  
  @Deprecated
  public UnifiedBannerView(Activity paramActivity, String paramString1, String paramString2, UnifiedBannerADListener paramUnifiedBannerADListener, Map paramMap) {
    super((Context)paramActivity);
    GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
    a(paramActivity, paramString1, paramString2, paramUnifiedBannerADListener, paramMap);
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2, UnifiedBannerADListener paramUnifiedBannerADListener, Map paramMap) {
    String str;
    if (StringUtil.isEmpty(paramString1) || StringUtil.isEmpty(paramString2) || paramActivity == null || paramUnifiedBannerADListener == null) {
      str = String.format("UnifiedBannerView Constructor params error, appid=%s,posId=%s,context=%s,listener=%s", new Object[] { paramString1, paramString2, paramActivity, paramUnifiedBannerADListener });
    } else {
      this.b = true;
      if (!a.a((Context)str)) {
        str = "Required Activity/Service/Permission Not Declared in AndroidManifest.xml";
      } else {
        this.c = true;
        setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
        GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, (Activity)str, paramString1, paramString2, paramUnifiedBannerADListener, paramMap) {
              public void run() {
                if (GDTADManager.getInstance().initWith((Context)this.a, this.b))
                  try {
                    return;
                  } finally {
                    Exception exception = null;
                    GDTLogger.e("Exception while init UnifiedBannerView plugin", exception);
                  }  
                GDTLogger.e("Fail to init ADManager");
              }
            });
        return;
      } 
    } 
    GDTLogger.e(str);
  }
  
  public void destroy() {
    UBVI uBVI = this.a;
    if (uBVI != null)
      uBVI.destroy(); 
  }
  
  public Map getExt() {
    try {
      if (this.a != null)
        return UBVI.ext; 
    } catch (Exception exception) {
      GDTLogger.e("banner2 can not get ext");
    } 
    return null;
  }
  
  public void loadAD() {
    String str;
    if (!this.b || !this.c) {
      str = "UnifiedBannerView init Paras OR Context error,See More logs while new BannerView";
    } else {
      if (!this.d) {
        this.f.incrementAndGet();
        return;
      } 
      UBVI uBVI = this.a;
      if (uBVI != null) {
        uBVI.fetchAd();
        return;
      } 
      str = "UnifiedBannerView Init error,See More Logs";
    } 
    GDTLogger.e(str);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    UBVI uBVI = this.a;
    if (uBVI != null)
      uBVI.onWindowFocusChanged(paramBoolean); 
  }
  
  public void setDownConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    this.e = paramDownAPPConfirmPolicy;
    if (paramDownAPPConfirmPolicy != null) {
      UBVI uBVI = this.a;
      if (uBVI != null)
        uBVI.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy); 
    } 
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.h = paramLoadAdParams;
    UBVI uBVI = this.a;
    if (uBVI != null)
      uBVI.setLoadAdParams(this.h); 
  }
  
  public void setRefresh(int paramInt) {
    this.g = paramInt;
    UBVI uBVI = this.a;
    if (uBVI != null)
      uBVI.setRefresh(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\banner2\UnifiedBannerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */