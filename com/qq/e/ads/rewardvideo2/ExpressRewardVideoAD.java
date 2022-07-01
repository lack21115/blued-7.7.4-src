package com.qq.e.ads.rewardvideo2;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.a;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI2;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.VideoAdValidity;

public class ExpressRewardVideoAD extends LiteAbstractAD<RVADI2> {
  public static final int EVENT_AD_LOAD = 100;
  
  public static final int EVENT_CLICK = 105;
  
  public static final int EVENT_CLOSE = 106;
  
  public static final int EVENT_COMPLETE = 108;
  
  public static final int EVENT_ERROR = 107;
  
  public static final int EVENT_EXPOSE = 103;
  
  public static final int EVENT_REWARD = 104;
  
  public static final int EVENT_SHOW = 102;
  
  public static final int EVENT_VIDEO_CACHED = 101;
  
  private RVADI2 a;
  
  private boolean b;
  
  private boolean c = true;
  
  private ExpressRewardVideoAdListener d;
  
  public ExpressRewardVideoAD(Context paramContext, String paramString, ExpressRewardVideoAdListener paramExpressRewardVideoAdListener) {
    this.d = paramExpressRewardVideoAdListener;
    if (GDTADManager.getInstance().isInitialized()) {
      a(paramContext, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString);
      return;
    } 
    GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTADManager.getInstance().initWith() 初始化");
    a(2003);
  }
  
  public ExpressRewardVideoAD(Context paramContext, String paramString1, String paramString2, ExpressRewardVideoAdListener paramExpressRewardVideoAdListener) {
    this.d = paramExpressRewardVideoAdListener;
    a(paramContext, paramString1, paramString2);
  }
  
  public final void a(int paramInt) {
    ExpressRewardVideoAdListener expressRewardVideoAdListener = this.d;
    if (expressRewardVideoAdListener != null)
      expressRewardVideoAdListener.onError(a.a(paramInt)); 
  }
  
  public VideoAdValidity checkValidity() {
    boolean bool;
    if (hasShown())
      return VideoAdValidity.SHOWED; 
    if (SystemClock.elapsedRealtime() > getExpireTimestamp())
      return VideoAdValidity.OVERDUE; 
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null) {
      bool = rVADI2.isVideoCached();
    } else {
      GDTLogger.w("don't call isVideoCached before loading AD success");
      bool = false;
    } 
    return !bool ? VideoAdValidity.NONE_CACHE : VideoAdValidity.VALID;
  }
  
  public void destroy() {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null)
      rVADI2.destroy(); 
  }
  
  public String getECPMLevel() {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null)
      return rVADI2.getECPMLevel(); 
    GDTLogger.w("don't call getECPMLevel before loading AD success");
    return null;
  }
  
  public long getExpireTimestamp() {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null)
      return rVADI2.getExpireTimestamp(); 
    GDTLogger.w("don't call getExpireTimestamp before loading AD success");
    return 0L;
  }
  
  public int getVideoDuration() {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null)
      return rVADI2.getVideoDuration(); 
    GDTLogger.w("don't call getVideoDuration before loading AD success");
    return 0;
  }
  
  public boolean hasShown() {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null)
      return rVADI2.hasShown(); 
    GDTLogger.w("don't call hasShown before loading AD success");
    return false;
  }
  
  public void loadAD() {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null) {
      rVADI2.loadAD();
      return;
    } 
    this.b = true;
  }
  
  public void setVolumeOn(boolean paramBoolean) {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null) {
      rVADI2.setVolumeOn(paramBoolean);
      return;
    } 
    this.c = paramBoolean;
  }
  
  public void showAD(Activity paramActivity) {
    RVADI2 rVADI2 = this.a;
    if (rVADI2 != null) {
      rVADI2.showAD(paramActivity);
      return;
    } 
    GDTLogger.w("don't call showAD before loading AD success");
  }
  
  static class AdListenerAdapter implements ADListener {
    private ExpressRewardVideoAdListener a;
    
    AdListenerAdapter(ExpressRewardVideoAdListener param1ExpressRewardVideoAdListener) {
      this.a = param1ExpressRewardVideoAdListener;
    }
    
    public void onADEvent(ADEvent param1ADEvent) {
      if (this.a != null && param1ADEvent != null) {
        switch (param1ADEvent.getType()) {
          default:
            return;
          case 108:
            this.a.onVideoComplete();
            return;
          case 107:
            if ((param1ADEvent.getParas()).length > 0 && param1ADEvent.getParas()[0] instanceof Integer) {
              this.a.onError(a.a(((Integer)param1ADEvent.getParas()[0]).intValue()));
              return;
            } 
            return;
          case 106:
            this.a.onClose();
            return;
          case 105:
            this.a.onClick();
            return;
          case 104:
            this.a.onReward();
            return;
          case 103:
            this.a.onExpose();
            return;
          case 102:
            this.a.onShow();
            return;
          case 101:
            this.a.onVideoCached();
            return;
          case 100:
            break;
        } 
        this.a.onAdLoaded();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\rewardvideo2\ExpressRewardVideoAD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */