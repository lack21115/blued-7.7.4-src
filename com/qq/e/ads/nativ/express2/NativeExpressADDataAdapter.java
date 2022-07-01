package com.qq.e.ads.nativ.express2;

import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;

public class NativeExpressADDataAdapter implements NativeExpressADData2 {
  private NativeExpressADData2 a;
  
  private MediaEventListener b;
  
  private AdEventListener c;
  
  public NativeExpressADDataAdapter(NativeExpressADData2 paramNativeExpressADData2) {
    this.a = paramNativeExpressADData2;
    paramNativeExpressADData2 = this.a;
    if (paramNativeExpressADData2 instanceof ADEventListener)
      ((ADEventListener)paramNativeExpressADData2).setAdListener(new ADListener(this) {
            public void onADEvent(ADEvent param1ADEvent) {
              if (param1ADEvent.getType() < 201) {
                NativeExpressADDataAdapter.a(this.a, param1ADEvent);
                return;
              } 
              NativeExpressADDataAdapter.b(this.a, param1ADEvent);
            }
          }); 
  }
  
  public void destroy() {
    this.a.destroy();
  }
  
  public View getAdView() {
    return this.a.getAdView();
  }
  
  public String getECPMLevel() {
    return this.a.getECPMLevel();
  }
  
  public int getVideoDuration() {
    return this.a.getVideoDuration();
  }
  
  public boolean isVideoAd() {
    return this.a.isVideoAd();
  }
  
  public void render() {
    this.a.render();
  }
  
  public void setAdEventListener(AdEventListener paramAdEventListener) {
    this.c = paramAdEventListener;
  }
  
  public void setMediaListener(MediaEventListener paramMediaEventListener) {
    this.b = paramMediaEventListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\express2\NativeExpressADDataAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */