package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class RewardVideoAD {
  public static final int REWARD_TYPE_PAGE = 1;
  
  public static final int REWARD_TYPE_VIDEO = 0;
  
  private RewardVideoADListener a;
  
  private volatile boolean b;
  
  private RVADI c;
  
  private volatile boolean d;
  
  private volatile boolean e;
  
  private volatile boolean f;
  
  private String g;
  
  private boolean h;
  
  private Map<String, String> i = new HashMap<String, String>();
  
  private LoadAdParams j = null;
  
  public RewardVideoAD(Context paramContext, String paramString, RewardVideoADListener paramRewardVideoADListener) {
    this(paramContext, paramString, paramRewardVideoADListener, true);
  }
  
  public RewardVideoAD(Context paramContext, String paramString, RewardVideoADListener paramRewardVideoADListener, boolean paramBoolean) {
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramContext, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString, paramRewardVideoADListener, paramBoolean);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    paramRewardVideoADListener.onError(a.a(2003));
  }
  
  @Deprecated
  public RewardVideoAD(Context paramContext, String paramString1, String paramString2, RewardVideoADListener paramRewardVideoADListener) {
    this(paramContext, paramString1, paramString2, paramRewardVideoADListener, true);
  }
  
  @Deprecated
  public RewardVideoAD(Context paramContext, String paramString1, String paramString2, RewardVideoADListener paramRewardVideoADListener, boolean paramBoolean) {
    GDTLogger.w("此构造方法即将废弃，请在 Application 中初始化 SDK 后，使用不带 appId 的构造方法，详细请参考Demo");
    a(paramContext, paramString1, paramString2, paramRewardVideoADListener, paramBoolean);
  }
  
  private void a(int paramInt) {
    (new Handler(Looper.getMainLooper())).post(new Runnable(this, paramInt) {
          public void run() {
            if (RewardVideoAD.d(this.b) != null)
              RewardVideoAD.d(this.b).onError(a.a(this.a)); 
          }
        });
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, RewardVideoADListener paramRewardVideoADListener, boolean paramBoolean) {
    if (paramContext == null || TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2) || paramRewardVideoADListener == null) {
      GDTLogger.e(String.format("RewardVideoAD Constructor params error, context=%s, appID=%s, posID=%s, rewardVideoADListener=%s", new Object[] { paramContext, paramString1, paramString2, paramRewardVideoADListener }));
      return;
    } 
    this.a = paramRewardVideoADListener;
    this.d = true;
    if (!a.a(paramContext)) {
      GDTLogger.e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
      a(4002);
      return;
    } 
    this.e = true;
    this.g = paramString2;
    GDTADManager.INIT_EXECUTOR.execute(new Runnable(this, paramContext, paramString1, paramRewardVideoADListener, paramString2, paramBoolean) {
          public void run() {
            if (GDTADManager.getInstance().initWith(this.a, this.b))
              try {
                POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                return;
              } finally {
                Exception exception = null;
              }  
            RewardVideoAD.a(this.f, 2001);
          }
        });
  }
  
  public VideoAdValidity checkValidity() {
    return hasShown() ? VideoAdValidity.SHOWED : ((SystemClock.elapsedRealtime() > getExpireTimestamp() - 1000L) ? VideoAdValidity.OVERDUE : (!this.h ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID));
  }
  
  public String getAdNetWorkName() {
    RVADI rVADI = this.c;
    if (rVADI != null)
      return rVADI.getAdNetWorkName(); 
    GDTLogger.e("please invoke getAdNetWorkName method after callback \"onADLoad\" or the ad does not support \"getAdNetWorkName\" ");
    return null;
  }
  
  public int getECPM() {
    RVADI rVADI = this.c;
    if (rVADI != null)
      return rVADI.getECPM(); 
    GDTLogger.e("please invoke getECPM method after callback \"onADLoad\" ");
    return -1;
  }
  
  public String getECPMLevel() {
    RVADI rVADI = this.c;
    if (rVADI != null)
      return rVADI.getECPMLevel(); 
    GDTLogger.e("please invoke getECPMLevel method after callback \"onADLoad\" ");
    return null;
  }
  
  public long getExpireTimestamp() {
    RVADI rVADI = this.c;
    if (rVADI != null)
      return rVADI.getExpireTimestamp(); 
    GDTLogger.e("please invoke getExpireTimestamp method after callback \"onADLoad\" ");
    return 0L;
  }
  
  public Map<String, String> getExts() {
    return this.i;
  }
  
  public int getRewardAdType() {
    RVADI rVADI = this.c;
    if (rVADI != null)
      return rVADI.getRewardAdType(); 
    GDTLogger.e("please invoke getRewardAdType method after callback \"onADLoad\" or the ad does not support \"getRewardAdType\" ");
    return 0;
  }
  
  public int getVideoDuration() {
    RVADI rVADI = this.c;
    if (rVADI != null)
      return rVADI.getVideoDuration(); 
    GDTLogger.e("please invoke getVideoDuration method after callback \"onADLoad\" or the ad does not support \"getVideoDuration\" ");
    return 0;
  }
  
  public boolean hasShown() {
    RVADI rVADI = this.c;
    if (rVADI != null)
      return rVADI.hasShown(); 
    GDTLogger.e("please invoke hasShown method after callback \"onADLoad\" ");
    return false;
  }
  
  public void loadAD() {
    String str;
    if (!this.d || !this.e) {
      str = "AD init Params OR Context error, details in logs produced while init RewardVideoAD";
    } else {
      if (!this.b) {
        this.f = true;
        return;
      } 
      RVADI rVADI = this.c;
      if (rVADI != null) {
        rVADI.loadAD();
        return;
      } 
      str = "RewardVideo AD Init error, see more logs";
    } 
    GDTLogger.e(str);
  }
  
  public void setExt(String paramString) {
    this.i.put("clickUrl", paramString);
  }
  
  public void setLoadAdParams(LoadAdParams paramLoadAdParams) {
    this.j = paramLoadAdParams;
    RVADI rVADI = this.c;
    if (rVADI != null)
      rVADI.setLoadAdParams(this.j); 
  }
  
  public void setTag(Map paramMap) {
    if (paramMap != null && paramMap.size() > 0)
      try {
        JSONObject jSONObject = new JSONObject(paramMap);
        GDTADManager.getInstance().getSM().setDEVCodeSetting("ad_tags", jSONObject, this.g);
        return;
      } catch (Exception exception) {
        GDTLogger.e("NativeUnifiedAD#setTag Exception");
        exception.printStackTrace();
      }  
  }
  
  public void showAD() {
    RVADI rVADI = this.c;
    if (rVADI != null) {
      rVADI.showAD();
      return;
    } 
    GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
  }
  
  public void showAD(Activity paramActivity) {
    RVADI rVADI = this.c;
    if (rVADI != null) {
      rVADI.showAD(paramActivity);
      return;
    } 
    GDTLogger.e("please invoke showAD method after callback \"onADLoad\" ");
  }
  
  public static class ADListenerAdapter implements ADListener {
    public static final int EVENT_TYPE_ON_AD_CLICK = 6;
    
    public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
    
    public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
    
    public static final int EVENT_TYPE_ON_AD_LOADED = 1;
    
    public static final int EVENT_TYPE_ON_AD_SHOW = 3;
    
    public static final int EVENT_TYPE_ON_ERROR = 9;
    
    public static final int EVENT_TYPE_ON_REWARD = 5;
    
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
    
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;
    
    private CacheCallback a;
    
    public RewardVideoADListener adListener;
    
    private WeakReference<RewardVideoAD> b;
    
    public ADListenerAdapter(RewardVideoADListener param1RewardVideoADListener) {
      this.adListener = param1RewardVideoADListener;
    }
    
    public ADListenerAdapter(RewardVideoADListener param1RewardVideoADListener, CacheCallback param1CacheCallback) {
      this.adListener = param1RewardVideoADListener;
      this.a = param1CacheCallback;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      switch (param1ADEvent.getType()) {
        default:
          return;
        case 9:
          if ((param1ADEvent.getParas()).length > 0 && param1ADEvent.getParas()[0] instanceof Integer) {
            this.adListener.onError(a.a(((Integer)param1ADEvent.getParas()[0]).intValue()));
            return;
          } 
          return;
        case 8:
          this.adListener.onADClose();
          return;
        case 7:
          this.adListener.onVideoComplete();
          return;
        case 6:
          if (this.b != null && (param1ADEvent.getParas()).length == 1) {
            Object object = param1ADEvent.getParas()[0];
            if (object instanceof String && this.b.get() != null)
              ((RewardVideoAD)this.b.get()).setExt((String)object); 
          } 
          this.adListener.onADClick();
          return;
        case 5:
          this.adListener.onReward();
          return;
        case 4:
          this.adListener.onADExpose();
          return;
        case 3:
          this.adListener.onADShow();
          return;
        case 2:
          this.adListener.onVideoCached();
          cacheCallback = this.a;
          if (cacheCallback != null) {
            cacheCallback.onCached();
            return;
          } 
          return;
        case 1:
          break;
      } 
      this.adListener.onADLoad();
      CacheCallback cacheCallback = this.a;
      if (cacheCallback != null)
        cacheCallback.onLoaded(); 
    }
    
    public void setBase(RewardVideoAD param1RewardVideoAD) {
      this.b = new WeakReference<RewardVideoAD>(param1RewardVideoAD);
    }
    
    static interface CacheCallback {
      void onCached();
      
      void onLoaded();
    }
  }
  
  static interface CacheCallback {
    void onCached();
    
    void onLoaded();
  }
  
  static interface CacheCallback {
    void onCached();
    
    void onLoaded();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\rewardvideo\RewardVideoAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */