package com.baidu.mobad.nativevideo;

import android.view.View;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;

public class XAdVideoResponse implements e {
  NativeResponse a;
  
  private IXAdContainer b;
  
  private IXAdInstanceInfo c;
  
  public XAdVideoResponse(NativeResponse paramNativeResponse, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdContainer paramIXAdContainer) {
    this.a = paramNativeResponse;
    this.b = paramIXAdContainer;
    this.c = paramIXAdInstanceInfo;
  }
  
  public String getAdLogoUrl() {
    NativeResponse nativeResponse = this.a;
    return (nativeResponse != null) ? nativeResponse.getAdLogoUrl() : null;
  }
  
  public String getBaiduLogoUrl() {
    NativeResponse nativeResponse = this.a;
    return (nativeResponse != null) ? nativeResponse.getBaiduLogoUrl() : null;
  }
  
  public String getDesc() {
    NativeResponse nativeResponse = this.a;
    return (nativeResponse != null) ? nativeResponse.getDesc() : null;
  }
  
  public String getIconUrl() {
    NativeResponse nativeResponse = this.a;
    return (nativeResponse != null) ? nativeResponse.getIconUrl() : null;
  }
  
  public String getImageUrl() {
    NativeResponse nativeResponse = this.a;
    return (nativeResponse != null) ? nativeResponse.getImageUrl() : null;
  }
  
  public String getMaterialType() {
    if (this.a != null) {
      int i = f.a[this.a.getMaterialType().ordinal()];
      if (i != 1) {
        if (i == 2 && this.a.getImageUrl().endsWith(".gif"))
          return "gif"; 
      } else {
        return "video";
      } 
    } 
    return "normal";
  }
  
  public String getTitle() {
    NativeResponse nativeResponse = this.a;
    return (nativeResponse != null) ? nativeResponse.getTitle() : null;
  }
  
  public String getVideoUrl() {
    NativeResponse nativeResponse = this.a;
    return (nativeResponse != null) ? nativeResponse.getVideoUrl() : null;
  }
  
  public void handleClick(View paramView) {
    NativeResponse nativeResponse = this.a;
    if (nativeResponse != null)
      nativeResponse.handleClick(paramView); 
  }
  
  public void handleClick(View paramView, int paramInt) {
    NativeResponse nativeResponse = this.a;
    if (nativeResponse != null)
      nativeResponse.handleClick(paramView, paramInt); 
  }
  
  public void recordImpression(View paramView) {
    NativeResponse nativeResponse = this.a;
    if (nativeResponse != null)
      nativeResponse.recordImpression(paramView); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\nativevideo\XAdVideoResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */