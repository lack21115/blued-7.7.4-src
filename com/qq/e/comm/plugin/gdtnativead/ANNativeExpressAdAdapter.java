package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.n;
import com.qq.e.comm.plugin.r.a;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.List;

class ANNativeExpressAdAdapter extends BaseNativeExpressAd implements a {
  private f mDelegate;
  
  private NativeExpressADView mExpressADView;
  
  private ADListener mListener;
  
  public ANNativeExpressAdAdapter(Context paramContext, ADSize paramADSize, String paramString1, String paramString2) {
    super(paramContext, paramADSize, paramString1, paramString2);
    this.mDelegate = new f(paramContext, paramADSize, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString1, l.b, new ADListener(this) {
          public void onADEvent(ADEvent param1ADEvent) {
            if (param1ADEvent != null && param1ADEvent.getType() == 2 && param1ADEvent.getParas() != null && (param1ADEvent.getParas()).length > 0)
              try {
                List<NativeExpressADView> list = (List)param1ADEvent.getParas()[0];
                if (list != null && list.size() > 0)
                  ANNativeExpressAdAdapter.access$002(this.a, list.get(0)); 
              } catch (Exception exception) {
                GDTLogger.w("ANNativeExpressAdAdapter cast exception");
                exception.printStackTrace();
              }  
            if (this.a.mListener != null)
              this.a.mListener.onADEvent(param1ADEvent); 
          }
        });
  }
  
  public int getECPM() {
    NativeExpressADView nativeExpressADView = this.mExpressADView;
    return (nativeExpressADView != null && nativeExpressADView.getBoundData() != null) ? this.mExpressADView.getBoundData().getECPM() : -1;
  }
  
  public int getMediationPrice() {
    NativeExpressADView nativeExpressADView = this.mExpressADView;
    return (nativeExpressADView != null && nativeExpressADView.getBoundData() instanceof n) ? ((n)this.mExpressADView.getBoundData()).getMediationPrice() : -1;
  }
  
  public boolean isContractAd() {
    NativeExpressADView nativeExpressADView = this.mExpressADView;
    return (nativeExpressADView != null && nativeExpressADView.getBoundData() instanceof n) ? ((n)this.mExpressADView.getBoundData()).isContractAd() : false;
  }
  
  public void loadAD(int paramInt) {
    this.mDelegate.loadAd(paramInt);
  }
  
  public void loadAD(int paramInt, LoadAdParams paramLoadAdParams) {
    this.mDelegate.loadAd(paramInt, paramLoadAdParams);
  }
  
  public void setAdListener(ADListener paramADListener) {
    this.mListener = paramADListener;
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.mDelegate.setMaxVideoDuration(paramInt);
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.mDelegate.setMinVideoDuration(paramInt);
  }
  
  public void setVideoOption(VideoOption paramVideoOption) {
    this.mDelegate.setVideoOption(paramVideoOption);
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.mDelegate.setVideoPlayPolicy(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\gdtnativead\ANNativeExpressAdAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */