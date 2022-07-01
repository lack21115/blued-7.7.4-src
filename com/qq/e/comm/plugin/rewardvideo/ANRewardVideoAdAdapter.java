package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.mediation.interfaces.BaseRewardAd;

class ANRewardVideoAdAdapter extends BaseRewardAd implements a {
  private j mDelegate;
  
  private ADListener mListener;
  
  public ANRewardVideoAdAdapter(Context paramContext, String paramString1, String paramString2) {
    super(paramContext, paramString1, paramString2);
    this.mDelegate = new j(paramContext, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString1, l.b, new ADListener(this) {
          public void onADEvent(ADEvent param1ADEvent) {
            if (this.a.mListener != null)
              this.a.mListener.onADEvent(param1ADEvent); 
          }
        });
  }
  
  public int getAdapterPriority() {
    return this.mDelegate.b();
  }
  
  public int getECPM() {
    return this.mDelegate.getECPM();
  }
  
  public String getECPMLevel() {
    return this.mDelegate.getECPMLevel();
  }
  
  public long getExpireTimestamp() {
    return this.mDelegate.getExpireTimestamp();
  }
  
  public int getMediationPrice() {
    return this.mDelegate.getMediationPrice();
  }
  
  public int getVideoDuration() {
    return this.mDelegate.getVideoDuration();
  }
  
  public boolean hasShown() {
    return this.mDelegate.hasShown();
  }
  
  public boolean isContractAd() {
    return this.mDelegate.isContractAd();
  }
  
  public void loadAD() {
    this.mDelegate.loadAD();
  }
  
  public void setAdListener(ADListener paramADListener) {
    this.mListener = paramADListener;
  }
  
  public void setVolumOn(boolean paramBoolean) {
    this.mDelegate.setVolumeOn(paramBoolean);
  }
  
  public void showAD() {
    this.mDelegate.showAD();
  }
  
  public void showAD(Activity paramActivity) {
    this.mDelegate.showAD(paramActivity);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\ANRewardVideoAdAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */