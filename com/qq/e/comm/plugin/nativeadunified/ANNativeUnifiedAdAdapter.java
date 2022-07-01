package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.List;

class ANNativeUnifiedAdAdapter extends BaseNativeUnifiedAd {
  private List<NativeUnifiedADData> data;
  
  private i delegate;
  
  private ADListener listener;
  
  public ANNativeUnifiedAdAdapter(Context paramContext, String paramString1, String paramString2) {
    super(paramContext, paramString1, paramString2);
    this.delegate = new i(paramContext, GDTADManager.getInstance().getAppStatus().getAPPID(), paramString1, l.b, new ADListener(this) {
          public void onADEvent(ADEvent param1ADEvent) {
            this.a.listener.onADEvent(param1ADEvent);
            if (param1ADEvent != null && param1ADEvent.getType() == 1 && param1ADEvent.getParas() != null && (param1ADEvent.getParas()).length > 0)
              ANNativeUnifiedAdAdapter.access$102(this.a, (List)param1ADEvent.getParas()[0]); 
          }
        });
  }
  
  public int getAdapterPriority() {
    return this.delegate.e();
  }
  
  public int getECPM() {
    List<NativeUnifiedADData> list = this.data;
    return (list == null || list.isEmpty()) ? -1 : ((NativeUnifiedADData)this.data.get(0)).getECPM();
  }
  
  public void loadData(int paramInt) {
    this.data = null;
    this.delegate.loadData(paramInt);
  }
  
  public void setAdListener(ADListener paramADListener) {
    this.listener = paramADListener;
  }
  
  public void setBrowserType(int paramInt) {
    this.delegate.setBrowserType(paramInt);
  }
  
  public void setCategories(List<String> paramList) {
    this.delegate.setCategories(paramList);
  }
  
  public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy paramDownAPPConfirmPolicy) {
    this.delegate.setDownAPPConfirmPolicy(paramDownAPPConfirmPolicy);
  }
  
  public void setMaxVideoDuration(int paramInt) {
    this.delegate.setMaxVideoDuration(paramInt);
  }
  
  public void setMinVideoDuration(int paramInt) {
    this.delegate.setMinVideoDuration(paramInt);
  }
  
  public void setVideoADContainerRender(int paramInt) {
    this.delegate.setVideoADContainerRender(paramInt);
  }
  
  public void setVideoPlayPolicy(int paramInt) {
    this.delegate.setVideoPlayPolicy(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\ANNativeUnifiedAdAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */