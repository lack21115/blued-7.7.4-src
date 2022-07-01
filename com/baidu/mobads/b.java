package com.baidu.mobads;

import android.view.View;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import org.json.JSONObject;

class b implements Runnable {
  b(a parama, IOAdEvent paramIOAdEvent) {}
  
  public void run() {
    if ("AdLoaded".equals(this.a.getType())) {
      AdView.a(this.b.a).onAdReady(this.b.a);
      return;
    } 
    if ("AdStarted".equals(this.a.getType())) {
      AdView.a(this.b.a).onAdSwitch();
      AdView.a(this.b.a).onAdShow(new JSONObject());
      return;
    } 
    if ("AdError".equals(this.a.getType())) {
      AdView.a(this.b.a).onAdFailed(XAdSDKFoundationFacade.getInstance().getErrorCode().getMessage(this.a.getData()));
      return;
    } 
    if ("AdUserClick".equals(this.a.getType())) {
      AdView.a(this.b.a).onAdClick(new JSONObject());
      return;
    } 
    if ("AdUserClose".equals(this.a.getType())) {
      XAdSDKFoundationFacade.getInstance().getCommonUtils().a((View)this.b.a);
      AdView.a(this.b.a).onAdClose(new JSONObject());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */